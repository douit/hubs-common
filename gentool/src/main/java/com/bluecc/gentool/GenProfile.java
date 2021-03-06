package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.procgen.ProcGen;
import com.bluecc.hubs.fund.HeadEntityResources;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * $ just gen GenProfile proto
 * $ just gen GenProfile heads
 */
public class GenProfile {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter
        public List<String> profiles = Lists.newArrayList("info");
    }

    public static void main(String[] args) throws IOException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        for (String profile : opts.profiles) {
            switch (profile){
                case "livecases":
                    StereotypeAddons.startGen();
                    break;
                case "proto":
                    ProtoTool.startGen(new ProtoTool.ProtoGenOpts(null, true));
                    System.out.println("* proto types");
                    ProtoTypeTool.startGen();
                    break;
                case "heads":
                    GenHeadEntities.startGen();
                    RpcGenTool.startGen();
                    break;
                case "info":
                    System.out.println("available profiles: livecases, proto, heads");
                    break;
                case "symbols":
                    ProcGen.startGen();
                    break;
                case "inspect":
                    writeInspectMeta();
                    break;
                case "delegator":
                    writeDelegatorPlugin();
                    break;
                default:
                    System.out.println("Cannot execute profile "+profile);
            }
        }
    }

    public static void startGen() throws IOException {
        writeInspectMeta();
        writeDelegatorPlugin();
    }

    public static void writeDelegatorPlugin() throws IOException {
        ProtoMeta protoMeta=new ProtoMeta();
        Util.writeFile(TemplateUtil.build("templates/dao_module.j2",
                ImmutableMap.of("ents", protoMeta.getHeadEntities())),
                new File("income/src/main/java/com/bluecc/" +
                        "income/dummy/store/DelegatorsPluginModule.java"));
    }

    public static void writeInspectMeta() {
        AtomicInteger total= new AtomicInteger();
        ProtoMeta protoMeta=new ProtoMeta();
        String targetDir="asset/inspect";
        HeadEntityResources.allHeads().forEach(head ->{
            Path path= Paths.get(targetDir, head+".yml");
            if(!path.toFile().exists()) {
                total.getAndIncrement();
                try {
                    Util.writeFile(Util.toYaml(protoMeta.buildInspectMeta(head)), path);
                    System.out.println("write to "+path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println(".. write inspect meta: "+total.get());
    }
}
