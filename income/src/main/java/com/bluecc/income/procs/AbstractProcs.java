package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.bluecc.hubs.stub.ShipmentData;
import com.bluecc.income.dummy.store.HubsStore;
import com.bluecc.income.exchange.IProc;
import com.bluecc.income.exchange.MessageMapCollector;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.income.exchange.MessageMapCollector.collect;

public class AbstractProcs {
    @Inject
    protected HubsStore hubsStore;
    @Inject
    protected Sequence sequence;
    @Inject
    protected ProtoMeta protoMeta;

    protected void process(IProc proc) {
        hubsStore.getJdbi().withHandle(handle -> {
            proc.proc(new IProc.ProcContext(handle));
            return null;
        });
    }

    protected void truncate(IProc.ProcContext ctx, String... tableNames) {
        for (String tableName : tableNames) {
            ctx.getHandle().execute("truncate " + tableName);
        }
    }

    public static String getPk(INameSymbol symbol) {
        return symbol.getTableKeys().size() > 1 ? "id" : symbol.getTableKeys().get(0);
    }

    protected static void assertEquals(Object o1, Object o2) {
        Preconditions.checkArgument(o1.equals(o2),
                "Expect %s, but %s", o1, o2);
    }

    protected static void assertNotNull(Object o){
        Preconditions.checkNotNull(o, "Object is null");
    }

    public Map<String, MessageMapCollector.ResultData> storeCompoundObject(IProc.ProcContext ctx, Message messageData){
        Map<String, MessageMapCollector.ResultData> resultMap = collect((c, e) -> {
            System.out.println("Ⓜ️ " + c.getSymbol() + " -> " + e);

            String idval = null;

            // 将子实体的id作为父实体的关联字段保存
            c.getCollector().getResultContext().forEach((k, v) -> {
                if(!k.startsWith("_")) {
                    e.put(v.getRelatedFields().get(0), v.getChildId());
                }
            });

            if (c.getParentFld() != null) {
                idval = sequence.nextStringId();
                e.put(getPk(c.getSymbol()), idval);

                // transfer parent entity related field values to current entity
                Map<String, Object> values = transferRelations(c.getParentMsg(),
                        c.getParentFld().getName(), c.getSymbol().getEntityName());
                e.putAll(values);
            }else{
                idval=e.get(c.getSymbol().getTableKeys().get(0)).toString();
            }

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

            if (c.getParentFld() != null) {
                String entityType = ProtoTypes.getEntityTypeByMessage(c.getParentMsg());
                EntityMeta.RelationQueryMeta queryMeta = protoMeta.findRelationQueryMeta(
                        entityType, c.getParentFld().getName());
                System.out.format("\tresult to: %s -> %s\n",
                        c.getParentFld().getName(),
                        queryMeta.getTableFields());
                if(queryMeta.isRepeated()){
                    Map<String, Object> keyValues= Maps.newHashMap();
                    c.getSymbol().getTableKeys().forEach(key ->
                            keyValues.put(key, e.get(key)));
                    c.getCollector().putSlave(c.getParentFld().getName(), keyValues);
                }else {
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
                        Descriptors.FieldDescriptor fldDesc=descriptor.findFieldByName(keymap.getProtoField());
                        if(fldDesc!=null) {
                            Object val = from.getField(fldDesc);
                            values.put(keymap.getProtoRelField(), val);
                        }
                    }
                });
        return values;
    }
}

