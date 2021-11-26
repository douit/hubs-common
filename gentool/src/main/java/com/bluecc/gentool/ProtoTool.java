package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.Data;
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
    @Parameter
    public List<String> entities = Lists.newArrayList("OrderHeader", "OrderItem");
    @Parameter(names = {"--write-all", "-w"})
    boolean writeAll=false;
    public static void main(String[] args) throws IOException {
        String tplName="proto";

        ProtoTool main = new ProtoTool();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

        if(!main.writeAll) {
            main.genAll(tplName);
        }else{
            String protoDir= SystemDefs.prependHubsHome( "stub/src/main/proto");
            String targetFile=protoDir+"/hubs.proto";
            System.out.println(".. write to "+targetFile);
            log.info(".. write to "+targetFile);
            main.writeProtos(targetFile);
        }

    }

    EntityMetaProcessors metaProcessors=new EntityMetaProcessors();
    void writeProtos(String protoFile) throws IOException {
        FileWriter writer=new FileWriter(protoFile);
        writer.write(TemplateUtil.build("templates/proto_header.j2",
                ImmutableMap.of("className", "DataProto",
                        "classPrefix", "DTP")));

        for (String headEnt : HeadEntityResources.allHeads()) {
            EntityMeta meta= EntityMetaManager.getEntityMeta(headEnt, false);
            writer.write(TemplateUtil.build("templates/proto_service_source.j2",
                    ImmutableMap.of("ent", meta)));
        }

        for (String headEnt : HeadEntityResources.allHeads()) {
            writer.write(flatSourceGen(headEnt));
        }

        for (String entity : metaList.getEntities()) {
            writer.write(sourceGen(entity, "proto"));
        }
        writer.close();
    }

    public void genAll(String tplName) throws IOException {
        for (String entName : entities) {
            gen(entName, tplName);
        }
    }

    void gen(String entName, String tplName) throws IOException {
        String cnt = sourceGen(entName, tplName);
        System.out.println(cnt);
    }

    String sourceGen(String entName, String tplName) throws IOException {
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
        EntityMetaDigester digester=new EntityMetaDigester(meta, typeList);

        // setup the entity-meta-info
        metaProcessors.processRelations(meta);

        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta, "digester", digester));
    }

    String flatSourceGen(String entName) throws IOException {
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
        EntityMetaDigester digester=new EntityMetaDigester(meta, typeList);
        return TemplateUtil.build("templates/proto_flat_source.j2",
                ImmutableMap.of("ent", meta, "digester", digester));
    }
}

