package com.bluecc.gentool.dummy;

import com.bluecc.gentool.common.EntityMeta;

import java.io.FileReader;
import java.io.IOException;

import static com.bluecc.gentool.common.Util.GSON;
import static com.bluecc.gentool.common.Util.pretty;

public class MetaImporter {
    public static void main(String[] args) throws IOException {
        String entName="Person";
        EntityMeta meta=GSON.fromJson(new FileReader("asset/meta/"+entName+".json"),
                EntityMeta.class);
        System.out.println(meta.getName());
        meta.getFields().forEach(f -> pretty(f));

        DummyTemplateProcs procs=new DummyTemplateProcs();
        procs.procBean(meta, "bean_source.j2");
        procs.procSql("mysql", meta);
        procs.procCrud(meta);
    }

}
