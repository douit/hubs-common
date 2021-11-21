package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.common.TemplateUtil;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;

import static com.bluecc.gentool.DataSetUtil.getAvailableEntities;

public class ProtoTool {
    public static void main(String[] args) throws IOException {
        // String entName="Person";
        String entName="Invoice";
        String tplName="proto";

        ProtoTool tool=new ProtoTool();
        tool.gen(entName, tplName);
    }

    void gen(String entName, String tplName) throws IOException {
        String cnt = sourceGen(entName, tplName);
        System.out.println(cnt);
    }

    String sourceGen(String entName, String tplName) throws IOException {
        SqlGenTool.MetaList metaList=getAvailableEntities();
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
        meta.getRelations().removeIf(r -> !metaList.has(r.getRelEntityName()));
        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta));
    }
}

