package com.bluecc.gentool;

import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.hubspot.jinjava.Jinjava;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.SeedReader.collectEntityData;

public class StereotypeTool {
    public static void main(String[] args) throws IOException {
        // testWriter();

        String targetDir="stub/src/main/java/com/bluecc/hubs/stereotypes";
        // String sourceDir="dataset/ecommerce";
        datasetWriter("dataset/sample", targetDir);
        datasetWriter("dataset/ecommerce", targetDir);
    }

    private static void datasetWriter(String sourceDir, String targetDir) throws IOException {
        // String sourceDir="dataset/sample";
        for (File sourceFile : Util.listFiles(sourceDir, ".xml")) {
            String className = "Stereo"+getCapName(sourceFile);
            FileWriter writer=new FileWriter(targetDir +"/"+className+".java");
            new StereotypeTool().gen(className, sourceFile, writer);
            writer.close();
        }
    }

    private static void testWriter() throws IOException {
        String dataFile = "dataset/sample/SimpleDatSet.xml";
        // String dataFile="dataset/common/GeoData_CN.xml";

        StringWriter writer = new StringWriter();
        String className = "Stereo"+getCapName(dataFile);
        new StereotypeTool().gen(className, new File(dataFile), writer);
        writer.close();
        System.out.println(writer.toString());
    }

    ProtoMeta protoMeta = new ProtoMeta();
    Jinjava jinjava = TemplateUtil.getJinjava();

    void gen(String className, File dataFile, Writer writer) throws IOException {
        String tplSource = IOUtils.toString(Objects.requireNonNull(
                        StereotypeTool.class.getResourceAsStream(
                                "/templates/stereotype_source.j2")),
                StandardCharsets.UTF_8);
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, dataFile, true);

        // package
        writer.write("package com/bluecc/hubs/stereotypes;\n\n".replace('/','.'));
        // import part
        writer.write("import static com.bluecc.hubs.ProtoTypes.*;\n");
        dataList.keySet().stream().map(k -> String.format(
                "import com.bluecc.hubs.stub.%s;",
                        protoMeta.getEntityMeta(k).getFlatMessageType()))
                .forEach(line -> {
                    try {
                        writer.write(line + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        // class part
        writer.write(String.format("\npublic final class %s {\n", className));
        Set<String> idSet= Sets.newHashSet();
        for (String ent : dataList.keySet()) {
            EntityMeta meta = protoMeta.getEntityMeta(ent);
            for (JsonObject jo : dataList.get(ent)) {
                Stereotype obj=convertToStereotype(jo, meta, idSet);
                if(obj!=null) {
                    String result = jinjava.render(tplSource,
                            ImmutableMap.of("obj", obj,
                                    "className", className));
                    // System.out.println(result);
                    writer.write(result);
                }
            }
        }

        writer.write("}\n");
    }

    @Data
    @Builder
    public static class Stereotype {
        EntityMeta meta;
        @Singular
        Map<String, StField> fields;
        String constName;

        public Collection<StField> getFieldList() {
            return fields.values();
        }
    }

    @Data
    @Builder
    public static class StField {
        EntityMeta.FieldMeta meta;
        Object value;
    }

    public static Stereotype convertToStereotype(JsonObject jo, EntityMeta meta, Set<String> idSet) {

        String keyValues = meta.getPks().stream()
                .map(p -> fixValue(jo.get(p).getAsString(),
                        meta.getField(p).get()))
                .collect(Collectors.joining("_"));
        if(idSet.contains(keyValues)){
            return null;  // skip the data with a same key
        }

        idSet.add(keyValues);
        Stereotype.StereotypeBuilder builder = Stereotype.builder().meta(meta);
        builder.constName(keyValues);

        for (String k : jo.keySet()) {
            EntityMeta.FieldMeta fld = meta.getField(k).get();
            builder.field(k, StField.builder().meta(fld)
                    .value(jo.get(k).getAsString())
                    .build());
        }
        return builder.build();
    }

    private static String fixValue(String valStr, EntityMeta.FieldMeta fieldMeta) {
        if (fieldMeta.isDateTimeField()) {
            return "";
        }
        return valStr.replaceAll("[ \\-:.]", "_");
    }


    private static String getCapName(String dataFile) {
        File file = new File(dataFile);
        return getCapName(file);
    }

    private static String getCapName(File file) {
        String name = file.getName().replace(".xml", "");
        // return name.contains("_") ? Util.snakeToCamel(name)
        //         : name.replaceAll("[\\-]", "");
        //
        return name.replaceAll("[\\-]", "");
    }
}
