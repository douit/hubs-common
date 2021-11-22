package com.bluecc.gentool;

import com.bluecc.gentool.dummy.DummyTemplateProcs;
import com.bluecc.hubs.fund.EntityMeta;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static com.bluecc.hubs.fund.EntityMetaManager.readEntityMeta;


public class MetaGenBase {

    public void gen(String entityName, String template, Writer writer) throws IOException {
        EntityMeta meta=readEntityMeta(entityName);
        DummyTemplateProcs procs=new DummyTemplateProcs();
        String cnt=procs.procBean(meta, template+".j2");
        if(writer!=null){
            writer.write(cnt);
            writer.write('\n');
        }
    }

    public void multiGen(List<String> names, String template, Writer writer) throws IOException {
        for (String name : names) {
            gen(name, template, writer);
        }
    }
}
