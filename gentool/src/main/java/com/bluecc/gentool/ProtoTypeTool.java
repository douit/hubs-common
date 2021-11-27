package com.bluecc.gentool;

import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.SystemDefs;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class ProtoTypeTool {
    public static void main(String[] args) throws IOException {
        startGen();
    }

    public static void startGen() throws IOException {
        String protoDir= SystemDefs.prependHubsHome( "stub/src/main/proto");
        String targetFile=protoDir+"/entity_types.proto";
        System.out.println(".. write to "+targetFile);
        log.info(".. write to "+targetFile);

        FileWriter writer=new FileWriter(targetFile);
        writeProtoFileHeader(writer);

        MetaTypes.typeList.getEntities().forEach(e -> {
            try {
                writer.write(ProtoTool.flatSourceGen(e, ""));
            } catch (IOException ex) {
                throw new RuntimeException("Cannot gen "+e, ex);
            }
        });

        writer.close();
    }

    private static void writeProtoFileHeader(FileWriter writer) throws IOException {
        writer.write(TemplateUtil.build("templates/proto_header.j2",
                ImmutableMap.of("className", "EntityTypeProto",
                        "classPrefix", "ETP")));
    }
}
