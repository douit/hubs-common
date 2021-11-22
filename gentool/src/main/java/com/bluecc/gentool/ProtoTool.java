package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.common.EntityMetaDigester;
import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.SystemDefs;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static com.bluecc.gentool.DataSetUtil.getAvailableEntities;

/**
 * $ just gen ProtoTool -w
 */
public class ProtoTool {
    @Parameter
    public List<String> entities = Lists.newArrayList("OrderHeader", "OrderItem");
    @Parameter(names = {"--write-all", "-w"})
    boolean writeAll=false;
    public static void main(String[] args) throws IOException {
        String tplName="proto";

        ProtoTool main = new ProtoTool();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

        if(!main.writeAll) {
            main.genAll(tplName);
        }else{
            String protoDir= SystemDefs.prependHubsHome( "stub/src/main/proto");
            String targetFile=protoDir+"/hubs.proto";
            System.out.println(".. write to "+targetFile);
            main.writeProtos(targetFile);
        }

    }

    SqlGenTool.MetaList metaList=getAvailableEntities();
    void writeProtos(String protoFile) throws IOException {
        FileWriter writer=new FileWriter(protoFile);
        writer.write(TemplateUtil.build("templates/proto_header.j2",
                ImmutableMap.of("className", "DataProto",
                        "classPrefix", "DTP")));

        for (String headEnt : EntityMeta.HEAD_ENTITIES.keySet()) {
            EntityMeta meta= EntityMetaManager.getEntityMeta(headEnt, false);
            writer.write(TemplateUtil.build("templates/proto_service_source.j2",
                    ImmutableMap.of("ent", meta)));
        }

        for (String entity : metaList.entities) {
            writer.write(sourceGen(entity, "proto"));
        }
        writer.close();
    }

    public void genAll(String tplName) throws IOException {
        for (String entName : entities) {
            gen(entName, tplName);
        }
    }

    void gen(String entName, String tplName) throws IOException {
        String cnt = sourceGen(entName, tplName);
        System.out.println(cnt);
    }

    String sourceGen(String entName, String tplName) throws IOException {
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
        EntityMetaDigester digester=new EntityMetaDigester(meta, EntityMetaManager.typeList);

        // setup the entity-meta-info
        meta.getRelations().removeIf(r -> !metaList.has(r.getRelEntityName()));
        // 清除关联对象对应在的字段id
        for (EntityMeta.RelationMeta relation : meta.getRelations()) {
            if(relation.hasProtoDef(meta.getName()) && !relation.getType().equals("many")){
                meta.getFields().removeIf(f -> !f.isPk() &&
                        f.getName().equals(relation.getMainRelField()));
            }
        }

        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta, "digester", digester));
    }
}

