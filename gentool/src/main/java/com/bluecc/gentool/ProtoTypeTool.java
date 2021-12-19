package com.bluecc.gentool;

import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.SystemDefs;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class ProtoTypeTool {
    public static void main(String[] args) throws IOException {
        startGen();
    }

    public static void startGen() throws IOException {
        String protoDir = SystemDefs.protoDir();
        MetaTypes.typeList.getEntities().forEach(e -> {
            try {
                // String targetFile = protoDir + "/entity_types.proto";
                Path targetPath= Paths.get(protoDir, "types",
                        Util.toSnakecase(e)+".proto");
                // System.out.println(".. write to " + targetPath);
                FileWriter writer = new FileWriter(targetPath.toFile());
                writeProtoFileHeader(e+"Proto", writer);
                writer.write(ProtoTool.flatSourceGen(e, "Data", false));
                writer.close();
            } catch (IOException ex) {
                throw new RuntimeException("Cannot gen " + e, ex);
            }
        });
    }

    public static void startGenSingleFile() throws IOException {
        String protoDir = SystemDefs.protoDir();

        String targetFile = protoDir + "/entity_types.proto";
        System.out.println(".. write to " + targetFile);
        log.info(".. write to " + targetFile);

        FileWriter writer = new FileWriter(targetFile);
        writeProtoFileHeader("EntityTypeProto", writer);

        MetaTypes.typeList.getEntities().forEach(e -> {
            try {
                writer.write(ProtoTool.flatSourceGen(e, "Data", false));
            } catch (IOException ex) {
                throw new RuntimeException("Cannot gen " + e, ex);
            }
        });

        writer.close();
    }

    private static void writeProtoFileHeader(String className, FileWriter writer) throws IOException {
        writer.write(TemplateUtil.build("templates/proto_type_header.j2",
                ImmutableMap.of("className", className,
                        "classPrefix", "ETP")));
    }
}
