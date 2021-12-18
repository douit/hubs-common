package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DartWrapperTool {
    public static void main(String[] args) throws IOException {
        // String ent = "ProductPrice";
        ProtoMeta protoMeta = new ProtoMeta();

        String cnt = TemplateUtil.build("templates/fe/entity_wrapper.j2",
                ImmutableMap.of("ent", protoMeta.getEntityMeta("ProductPrice")));
        System.out.println(cnt);

        String targetDir = "/opt/app/fe/simple";
        Path targetPath = Paths.get(targetDir, "bin/entity_wrappers.dart");
        Util.writeFile(cnt, targetPath);
    }

    static ImmutableMap<String, Object> getEntityMetas(ProtoMeta protoMeta, String... ents) {
        return ImmutableMap.of("ents", Stream.of(ents)
                .map(e ->
                        protoMeta.getEntityMeta(e))
                .collect(Collectors.toList()));
    }
}
