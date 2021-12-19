package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static com.bluecc.hubs.fund.DataSetUtil.getAvailableEntities;
import static com.bluecc.hubs.fund.MetaTypes.metaList;
import static com.bluecc.hubs.fund.MetaTypes.typeList;
import static java.util.Arrays.asList;

/**
 * $ just gen ProtoTool -w
 */
@Slf4j
public class ProtoTool {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ProtoGenOpts {
        @Parameter
        public List<String> entities = Lists.newArrayList("OrderHeader", "OrderItem");
        @Parameter(names = {"--write-all", "-w"})
        boolean writeAll = false;
    }
    public static void main(String[] args) throws IOException {

        ProtoGenOpts opts=new ProtoGenOpts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        startGen(opts);

    }

    public static void startGen(ProtoGenOpts opts) throws IOException {
        ProtoTool main = new ProtoTool(opts);
        String tplName="proto";
        if(!opts.writeAll) {
            main.genAll(tplName);
        }else{
            String protoDir= SystemDefs.protoDir();
            String targetFile=protoDir+"/hubs.proto";
            System.out.println(".. write to "+targetFile);
            log.info(".. write to "+targetFile);
            main.writeProtos(targetFile);
        }
    }

    EntityMetaProcessors metaProcessors=new EntityMetaProcessors();
    ProtoGenOpts opts;
    public ProtoTool(ProtoGenOpts opts) {
        this.opts=opts;
    }

    void writeProtos(String protoFile) throws IOException {
        FileWriter writer=new FileWriter(protoFile);
        writeProtoFileHeader("DataProto", writer);

        for (String headEnt : HeadEntityResources.allHeads()) {
            EntityMeta meta= EntityMetaManager.readEntityMeta(headEnt);
            writer.write(TemplateUtil.build("templates/proto_service_source.j2",
                    ImmutableMap.of("ent", meta)));
        }

        for (String headEnt : HeadEntityResources.allHeads()) {
            writer.write(flatSourceGen(headEnt, "FlatData", true));
        }

        for (String entity : metaList.getEntities()) {
            writer.write(sourceGen(entity, "proto", true));
        }
        writer.close();
    }

    private void writeProtoFileHeader(String className, FileWriter writer) throws IOException {
        writer.write(TemplateUtil.build("templates/proto_header.j2",
                ImmutableMap.of("className", className,
                        "classPrefix", "DTP")));
    }

    public void genAll(String tplName) throws IOException {
        for (String entName : opts.entities) {
            gen(entName, tplName);
        }
    }

    void gen(String entName, String tplName) throws IOException {
        String cnt = sourceGen(entName, tplName, true);
        System.out.println(cnt);
    }

    String sourceGen(String entName, String tplName, boolean hasTable) throws IOException {
        EntityMeta meta= EntityMetaManager.readEntityMeta(entName);
        EntityMetaDigester digester=new EntityMetaDigester(meta, typeList);

        // setup the entity-meta-info
        metaProcessors.processRelations(meta);

        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta,
                        "digester", digester, "hasTable", hasTable));
    }

    public static String flatSourceGen(String entName, String suffix, boolean hasTable) throws IOException {
        EntityMeta meta= EntityMetaManager.readEntityMeta(entName);
        EntityMetaDigester digester=new EntityMetaDigester(meta, typeList);
        return TemplateUtil.build("templates/proto_flat_source.j2",
                ImmutableMap.of("ent", meta,
                        "digester", digester,
                        "suffix", suffix,
                        "hasTable", hasTable
                        ));
    }
}

