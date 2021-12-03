package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.bluecc.hubs.fund.model.IModel;
import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.exchange.FlatMessageCollector;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.MessageMapCollector;
import com.bluecc.income.exchange.ResultSubscriber;
import com.bluecc.income.template.TemplateGlobalContext;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import reactor.core.publisher.Flux;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.ProtoTypes.getTableByMessage;
import static com.bluecc.income.exchange.MessageMapCollector.collect;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

@Slf4j
public class AbstractProcs {
    @Inject
    protected HubsStore hubsStore;
    @Inject
    protected Sequence sequence;
    @Inject
    protected ProtoMeta protoMeta;

    protected Flux<IModel> process(IProc proc){
        return hubsStore.getJdbi().withHandle(handle -> {
            ResultSubscriber<IModel> resultSubscriber=new ResultSubscriber<>();
            proc.proc(new IProc.ProcContext(handle, resultSubscriber));
            return Flux.fromIterable(resultSubscriber.getResult());
        });
    }

    protected void truncate(IProc.ProcContext ctx, List<String> tableNames) {
        for (String tableName : tableNames) {
            ctx.getHandle().execute("truncate " + tableName);
        }
    }

    protected void truncate(IProc.ProcContext ctx, String... tableNames) {
        truncate(ctx, Arrays.asList(tableNames));
    }

    public static String getPk(INameSymbol symbol) {
        return symbol.getTableKeys().size() > 1 ? "id" : symbol.getTableKeys().get(0);
    }

    protected static void assertEquals(Object o1, Object o2) {
        Preconditions.checkArgument(o1.equals(o2),
                "Expect %s, but %s", o1, o2);
    }

    protected static void assertNotNull(Object o) {
        Preconditions.checkNotNull(o, "Object is null");
    }

    public Map<String, MessageMapCollector.ResultData> storeCompoundObject(IProc.ProcContext ctx, Message messageData) {
        Map<String, MessageMapCollector.ResultData> resultMap = collect((c, e) -> {
            String idval = null;

            // 将子实体的id作为父实体的关联字段保存
            c.getCollector().getResultContext().forEach((k, v) -> {
                if (!k.startsWith("_")) {
                    e.put(v.getRelatedFields().get(0), v.getChildId());
                }
            });

            boolean persist = true;
            if (c.getParentFld() != null) {
                // 如果不是复合键, 且键有值, 则表示已经存在该实体实例, 不用保存
                if (!c.getSymbol().hasCombineKeys()) {
                    Object pval = e.get(c.getSymbol().getTableKeys().get(0));
                    if (pval != null) {
                        persist = false;
                        idval = pval.toString();
                        System.out.println("\tdon't persist " + c.getSymbol().getTable()
                                + ", with id value " + idval);
                    }
                }

                if (idval == null) {
                    idval = sequence.nextStringId();
                    e.put(getPk(c.getSymbol()), idval);
                }

                // transfer parent entity related field values to current entity
                Map<String, Object> values = transferRelations(c.getParentMsg(),
                        c.getParentFld().getName(), c.getSymbol().getEntityName());
                e.putAll(values);
            } else {
                // is head-entity
                idval = e.get(c.getSymbol().getTableKeys().get(0)).toString();
            }

            e.forEach((k,v) -> {
                if(v!=null && v.equals(ValueConstants.PLACER_HEAD_ID)){
                    e.put(k, c.getCollector().getTravelContext().getHeadId());
                }
            });

            String mark=persist?"Ⓜ️ ":"☑️ ";
            System.out.println(mark + c.getSymbol() + " -> " + e);

            if (persist) {
                List<String> names = new ArrayList<>(e.keySet());
                List<String> placers = names.stream().map(name -> ":" + name)
                        .collect(Collectors.toList());

                int total = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                        .define("table", c.getSymbol().getTable())
                        .defineList("columns", names)
                        .defineList("placers", placers)
                        .bindMap(e)
                        .execute();
                assertEquals(1, total);
            }

            if (c.getParentFld() != null) {
                String entityType = ProtoTypes.getEntityTypeByMessage(c.getParentMsg());
                EntityMeta.RelationQueryMeta queryMeta = protoMeta.findRelationQueryMeta(
                        entityType, c.getParentFld().getName());
                System.out.format("\tresult to: %s -> %s\n",
                        c.getParentFld().getName(),
                        queryMeta.getTableFields());
                if (queryMeta.isRepeated()) {
                    Map<String, Object> keyValues = Maps.newHashMap();
                    c.getSymbol().getTableKeys().forEach(key ->
                            keyValues.put(key, e.get(key)));
                    c.getCollector().putSlave(c.getParentFld().getName(), keyValues);
                } else {
                    c.getCollector().putResult(c.getParentFld().getName(),
                            queryMeta.getTableFields(), idval);
                }
            } else {
                c.getCollector().putResult("_id_",
                        c.getSymbol().getTableKeys(), idval);
            }

        }).fillMap(messageData);
        return resultMap;
    }

    public Map<String, Object> transferRelations(Message from, String relationProtoName, String toEntity) {
        Descriptors.Descriptor descriptor = from.getDescriptorForType();
        String fromEnt = ProtoTypes.getEntityTypeByMessage(from);
        EntityMeta meta = protoMeta.getEntityMeta(fromEnt);
        Map<String, Object> values = Maps.newHashMap();
        meta.getRelations().stream().filter(r ->
                        r.getProtoName().equals(relationProtoName)
                                && r.getRelEntityName().equals(toEntity))
                .forEach(r -> {
                    for (EntityMeta.KeymapMeta keymap : r.getKeymaps()) {
                        Descriptors.FieldDescriptor fldDesc = descriptor.findFieldByName(keymap.getProtoField());
                        if (fldDesc != null) {
                            Object val = from.getField(fldDesc);
                            if(val!=null && !val.toString().isEmpty()) {
                                log.debug("\t..transfer {}: {}\n", fldDesc.getName(), val);
                                values.put(keymap.getProtoRelField(), val);
                            }
                        }
                    }
                });
        return values;
    }

    protected void setupEntities(String...entities){
        final Jdbi db = hubsStore.getJdbi();

        db.setSqlLogger(new SqlLogger() {
            @Override
            public void logBeforeExecution(StatementContext ctx) {
                System.out.println("sql -> " + ctx.getRawSql());
                System.out.println("\t" + ctx.getParsedSql().getSql());
                System.out.println("\t"+ctx.getBinding().toString());
            }
        });

        if(entities.length>0) {
            TemplateGlobalContext.getContext().preload(entities);
            process(c -> {
                truncate(c, Arrays.stream(entities).map(e ->
                        Util.toSnakecase(e)).collect(Collectors.toList()));
            });
        }
    }

    @Data
    @Builder
    public static class ExtractedTableInfo{
        String table;
        List<String> names;
        List<String> placers;
        Map<String, Object> e;
        String idCond;
        String fieldsCondition;
    }

    public ExtractedTableInfo extract(Message flatData){
        Map<String, Object> e= FlatMessageCollector.extract(flatData);

        List<String> names = new ArrayList<>(e.keySet());
        List<String> placers = names.stream().map(name -> ":" + name)
                .collect(Collectors.toList());

        String fieldsCond = names.stream().map(name ->
                        format("%s=:%s", name, name))
                .collect(Collectors.joining(" and "));

        String table= getTableByMessage(flatData);

        List<String> idCondList= Lists.newArrayList();
        for (String entityKey : ProtoTypes.getEntityKeys(flatData)) {
            idCondList.add(format("%s=:%s", entityKey, entityKey));
        }
        String idCond=String.join(" and ", idCondList);

        return ExtractedTableInfo.builder()
                .table(table)
                .names(names)
                .placers(placers)
                .e(e)
                .idCond(idCond)
                .fieldsCondition(fieldsCond)
                .build();
    }

    public int create(IProc.ProcContext ctx, Message flatData){
        ExtractedTableInfo tableInfo=extract(flatData);
        if(ProtoTypes.isCombine(flatData)){
            String uid=sequence.nextStringId();
            tableInfo.names.add("id");
            tableInfo.placers.add(":id");
            tableInfo.e.put("id", uid);
        }

        int total = ctx.getHandle().createUpdate("insert into <table> (<columns>) values (<placers>)")
                .define("table", tableInfo.table)
                .defineList("columns", tableInfo.names)
                .defineList("placers", tableInfo.placers)
                .bindMap(tableInfo.e)
                .execute();
        assertEquals(1, total);
        return total;
    }

    public int update(IProc.ProcContext ctx, Message flatData) {
        ExtractedTableInfo tableInfo = extract(flatData);
        List<String> fieldsCond = tableInfo.names.stream()
                .map(name -> name+" = :" + name)
                .collect(Collectors.toList());

        int total = ctx.getHandle().createUpdate("update <table> set <fields_cond> where <id_cond>")
                .define("table", tableInfo.table)
                .defineList("fields_cond", fieldsCond)
                .define("id_cond", tableInfo.idCond)
                .bindMap(tableInfo.e)
                .execute();
        assertEquals(1, total);
        return total;
    }

    public int delete(IProc.ProcContext ctx, Message flatData) {
        ExtractedTableInfo tableInfo = extract(flatData);
        int total = ctx.getHandle().createUpdate("delete from <table> where <id_cond>")
                .define("table", tableInfo.table)
                .define("id_cond", tableInfo.idCond)
                .bindMap(tableInfo.e)
                .execute();
        assertEquals(1, total);
        return total;
    }

    public List<Map<String, Object>> findById(IProc.ProcContext ctx, Message flatData) {
        ExtractedTableInfo tableInfo = extract(flatData);
        List<Map<String, Object>> rs = ctx.getHandle().createQuery(
                "select * from <table> where <id_cond>")
                .define("table", tableInfo.table)
                .define("id_cond", tableInfo.idCond)
                .bindMap(tableInfo.e)
                .mapToMap()
                .list();
        return rs;
    }

    public List<Map<String, Object>> find(IProc.ProcContext ctx, Message flatData) {
        ExtractedTableInfo tableInfo = extract(flatData);
        List<Map<String, Object>> rs = ctx.getHandle().createQuery("select * from <table> where <fields_cond>")
                .define("table", tableInfo.table)
                .define("fields_cond", tableInfo.fieldsCondition)
                .bindMap(tableInfo.e)
                .mapToMap()
                .list();
        return rs;
    }

    public <T> List<T> find(IProc.ProcContext ctx, Message flatData, Class<T> clz) {
        ExtractedTableInfo tableInfo = extract(flatData);
        List<T> rs = ctx.getHandle().createQuery("select * from <table> where <fields_cond>")
                .define("table", tableInfo.table)
                .define("fields_cond", tableInfo.fieldsCondition)
                .bindMap(tableInfo.e)
                .mapTo(clz)
                .list();
        return rs;
    }

    public List<Map<String, Object>> all(IProc.ProcContext c, Message flatData) {
        return all(c, flatData, 0);
    }

    public List<Map<String, Object>> all(IProc.ProcContext c, INameSymbol symbol, int limit) {
        return all(c, symbol.getTable(), limit);
    }

    public List<Map<String, Object>> all(IProc.ProcContext c, Message flatData, int limit) {
        return all(c, getTableByMessage(flatData), limit);
    }

    public List<Map<String, Object>> all(IProc.ProcContext c, String table, int limit) {
        List<Map<String,Object>> rs= c.getHandle().createQuery(
                        format("select * from %s %s",
                                table,
                                limit==0?":":"limit "+limit))
                .mapToMap().list();
        return rs;
    }

    public <T> List<T> getRelationValues(IProc.ProcContext ctx,
                                         Message message,
                                         String relName,
                                         Class<T> clz) {
        EntityMeta p = protoMeta.getEntityMeta(ProtoTypes.getEntityTypeByMessage(message));
        EntityMeta.RelationMeta relationMeta = p.findRelationByProtoName(relName).get();
        String relEnt = relationMeta.getRelEntityName();
        String table = relationMeta.getTableName();
        Map<String, Object> e = transferRelations(message,
                relName, relEnt);

        return getTypedRelations(ctx, table, e, clz);
    }

    public <T> List<T> getTypedRelations(IProc.ProcContext ctx, String table,
                                         Map<String, Object> e, Class<T> clz) {
        List<String> names = new ArrayList<>(e.keySet());

        String fieldsCond = names.stream().map(name ->
                        format("%s=:%s", name, name))
                .collect(Collectors.joining(" and "));

        List<T> rs = ctx.getHandle().createQuery(
                        "select * from <table> where <fieldsCond>")
                .define("table", table)
                .defineList("fieldsCond", fieldsCond)
                .bindMap(e)
                .mapTo(clz).list();
        return rs;

    }
}

