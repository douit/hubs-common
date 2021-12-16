package com.bluecc.gentool;

import com.bluecc.hubs.fund.*;
import com.google.common.collect.ImmutableMap;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class RpcGenTool {
    public static void main(String[] args) throws IOException {
        startGen();
    }

    public static void startGen() throws IOException {
        ProtoMeta protoMeta = new ProtoMeta();

        String targetDir = SystemDefs.prependHubsHome(
                "income/src/main/java/com/bluecc/income/service");
        for (String headEnt : HeadEntityResources.allHeads()) {
            Path path = Paths.get(targetDir, headEnt + "Rpc.java");
            FileWriter writer = new FileWriter(path.toFile());
            EntityMeta meta = protoMeta.getEntityMeta(headEnt);
            writer.write(TemplateUtil.build("templates/rpc/rpc_crud.j2",
                    ImmutableMap.of("ent", meta)));
            writer.close();
        }

        writeFacade(protoMeta, targetDir);
    }

    private static void writeFacade(ProtoMeta protoMeta, String targetDir) throws IOException {
        String facadeFile = "ServiceFacade.java";
        Path path = Paths.get(targetDir, facadeFile);
        FileWriter writer = new FileWriter(path.toFile());
        List<EntityMeta> metaList = HeadEntityResources.allHeads().stream()
                .map(e -> protoMeta.getEntityMeta(e))
                .collect(Collectors.toList());
        System.out.println("total head entities: "+metaList.size());
        writer.write(TemplateUtil.build("templates/rpc/facade.j2",
                ImmutableMap.of("ents", metaList)));
        writer.close();
    }
}
