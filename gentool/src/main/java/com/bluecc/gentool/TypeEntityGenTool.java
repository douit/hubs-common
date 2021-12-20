package com.bluecc.gentool;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;

public class TypeEntityGenTool {
    public static void main(String[] args) throws IOException {
        ProtoMeta protoMeta=new ProtoMeta();
        String targetFile="income/src/main/java/com/bluecc/income/procs/TypeEntities.java";
        String cnt=TemplateUtil.build("templates/type_ent_rest.j2",
                ImmutableMap.of("ents", protoMeta.getTypeEntities()));
        Util.writeFile(cnt, targetFile);
        System.out.println("write: "+targetFile);
    }
}
