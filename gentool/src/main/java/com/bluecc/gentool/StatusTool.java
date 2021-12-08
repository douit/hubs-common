package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.ModelTransition;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * $ just gen StatusTool -t Order
 * $ just gen StatusTool -t Order -w -f
 */
public class StatusTool {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = {"--status", "-t"})
        String status="Order";
        @Parameter(names = {"--target-dir", "-d"})
        String targetDir="saga/src/main/java/com/bluecc/saga/actors"; // default
        @Parameter(names = {"--write", "-w"})
        boolean write=false;
        @Parameter(names = {"--force", "-f"})
        boolean force=false;
    }

    public static void main(String[] args) throws IOException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        if(!opts.write) {
            genAndPrint(opts);
        }else {
            genAndWrite(opts);
        }
    }

    @Data
    @Builder
    public static class ActorSource{
        String name;
        String eventDecl;
        @Singular
        List<String> conductorDecls;
    }

    private static boolean genAndWrite(Opts opts) throws IOException {
        Map<String, Object> ctx = getBuildContext(opts);
        String eventDecl=TemplateUtil.build("templates/actor_event_source.j2", ctx);
        String conductorDecl=TemplateUtil.build("templates/actor_transitions_source.j2", ctx);

        String source=TemplateUtil.build("templates/actor_source.j2",
                ImmutableMap.of("source", ActorSource.builder()
                                .name(opts.status)
                                .eventDecl(eventDecl)
                                .conductorDecl(conductorDecl)
                        .build()));
        File targetFile= Paths.get(opts.targetDir, opts.getStatus()+"Actor.java").toFile();
        if(targetFile.exists() && !opts.force){
            System.out.format("target file %s exists, ignore it.\n", targetFile);
            return false;
        }else {
            Util.writeFile(source, targetFile);
            return true;
        }
    }

    private static void genAndPrint(Opts opts) throws IOException {
        Map<String, Object> ctx = getBuildContext(opts);

        String cnt=TemplateUtil.build("templates/actor_event_source.j2", ctx);
        System.out.println(cnt);
        System.out.println("// --------------------");
        System.out.println("interface Conductors {");
        cnt=TemplateUtil.build("templates/actor_transitions_source.j2", ctx);
        System.out.println(cnt);
        System.out.println("}");
    }

    private static Map<String, Object> getBuildContext(Opts opts) {
        ModelTransition modelTransition=new ModelTransition();
        ModelTransition.ObjectStatus objectStatus= modelTransition.getTransitions(opts.status);
        Map<String,Object> ctx=ImmutableMap.of("actor", objectStatus.getTransitions(),
                "sink", "ConsolePrinter",
                "top", objectStatus);
        return ctx;
    }
}
