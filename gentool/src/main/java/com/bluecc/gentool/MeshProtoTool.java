package com.bluecc.gentool;

import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeshProtoTool {
    public static void main(String[] args) throws IOException {
        ModelTransition modelTransition=new ModelTransition();
        List<String> allMeshes=Util.listFiles("asset/transitions", ".json")
                .stream().map(f -> FilenameUtils.getBaseName(f.toString()))
                .collect(Collectors.toList());
        Map<String,Object> ctx= ImmutableMap.of(
                "sink", "ConsolePrinter",
                "objs", allMeshes.stream()
                        .map(status -> modelTransition.getTransitions(status))
                        .collect(Collectors.toList()));
        String cnt= TemplateUtil.build("templates/actor_mesh_rpc.j2", ctx);
        // System.out.println(cnt);

        String targetFile="stub/src/main/proto/transitions.proto";
        Util.writeFile(cnt, new File(targetFile));
        System.out.println(".. write ok: "+targetFile);
    }
}
