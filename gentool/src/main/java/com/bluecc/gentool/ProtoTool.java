package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.common.TemplateUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

import static com.bluecc.gentool.DataSetUtil.getAvailableEntities;

public class ProtoTool {
    @Parameter
    public List<String> entities = Lists.newArrayList("OrderHeader", "OrderItem");
    public static void main(String[] args) throws IOException {
        String tplName="proto";

        ProtoTool main = new ProtoTool();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        ProtoTool tool=new ProtoTool();
        tool.genAll(tplName);
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
        SqlGenTool.MetaList metaList=getAvailableEntities();
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
        // setup the entity-meta-info
        meta.getRelations().removeIf(r -> !metaList.has(r.getRelEntityName()));
        // 清除关联对象对应在的字段id
        for (EntityMeta.RelationMeta relation : meta.getRelations()) {
            if(relation.hasProtoDef(meta.getName()) && !relation.getType().equals("many")){
                meta.getFields().removeIf(f -> f.getName().equals(relation.getMainRelField()));
            }
        }

        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta));
    }
}

