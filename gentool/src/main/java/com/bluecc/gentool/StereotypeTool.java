package com.bluecc.gentool;

import com.bluecc.gentool.Stereotypes.Stereotype;
import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Util;
import com.google.common.collect.*;
import com.google.gson.JsonObject;
import com.hubspot.jinjava.Jinjava;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bluecc.gentool.Stereotypes.convertToStereotype;
import static com.bluecc.gentool.Stereotypes.getCapName;
import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static java.lang.String.format;

@Slf4j
public class StereotypeTool {
    public static void main(String[] args) throws IOException {
        // testWriter();
        startGen();

    }

    public static void startGen() throws IOException {
        String targetDir = "stub/src/main/java/com/bluecc/hubs/stereotypes";
        // String sourceDir="dataset/ecommerce";
        String prefix = "Stereo";
        datasetWriter("dataset/sample", targetDir, prefix);

        datasetWriter("dataset/ecommerce", targetDir, prefix);
        datasetWriter("dataset/seed", targetDir, "");

        Stream.of("dataset/accounting/PaymentApplicationTestsData.xml",
                "dataset/order/PartyDemoData.xml",
                "dataset/order/PartyGeoPointData.xml").forEach(file -> {
            datafileWriter(new File(file),
                    targetDir, "", true, "stereotypes");
        });
    }

    private static void datasetWriter(String sourceDir, String targetDir,
                                      String prefix) throws IOException {
        datasetWriter(sourceDir, targetDir, prefix, false, "stereotypes");
    }

    public static void datasetWriter(String sourceDir, String targetDir,
                                     String prefix, boolean fnMode, String pkg) throws IOException {
        System.out.println(".. write " + sourceDir);
        // String sourceDir="dataset/sample";
        for (File sourceFile : Util.listFiles(sourceDir, ".xml")) {
            datafileWriter(sourceFile, targetDir, prefix, fnMode, pkg);
        }
    }

    public static void datafileWriter(File sourceFile, String targetDir,
                                      String prefix, boolean fnMode, String pkg) {
        try {
            String className = prefix + getCapName(sourceFile);
            FileWriter writer = new FileWriter(targetDir + "/" + className + ".java");
            FileWriter listWriter = new FileWriter(targetDir + "/" + className + "List.java");
            new StereotypeTool(writer, listWriter, fnMode).gen(className, sourceFile, pkg);
            writer.close();
            listWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void testWriter() throws IOException {
        String dataFile = "dataset/sample/SimpleDatSet.xml";
        // String dataFile="dataset/common/GeoData_CN.xml";

        StringWriter writer = new StringWriter();
        String className = "Stereo" + getCapName(dataFile);
        new StereotypeTool(writer, new StringWriter(), false).gen(className, new File(dataFile), "stereotypes");
        writer.close();
        System.out.println(writer.toString());
    }

    ProtoMeta protoMeta = new ProtoMeta();
    Jinjava jinjava = TemplateUtil.getJinjava();

    Writer writer;
    Writer listWriter;
    boolean fnMode;

    StereotypeTool(Writer writer, Writer listWriter, boolean fnMode) {
        this.writer = writer;
        this.listWriter = listWriter;
        this.fnMode = fnMode;
    }

    void gen(String className, File dataFile, String pkg) throws IOException {
        String tplSource = IOUtils.toString(Objects.requireNonNull(
                        StereotypeTool.class.getResourceAsStream(
                                fnMode ? "/templates/stereotype_fn.j2" :
                                        "/templates/stereotype_source.j2")),
                StandardCharsets.UTF_8);
        String tplListSource = IOUtils.toString(Objects.requireNonNull(
                        StereotypeTool.class.getResourceAsStream(
                                fnMode ? "/templates/stereotype_list_fn.j2" :
                                        "/templates/stereotype_list_source.j2")),
                StandardCharsets.UTF_8);

        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, dataFile, true);

        // package: default pkg is stereotypes
        String pkgDecl=format("package com/bluecc/hubs/%s;\n\n"
                .replace('/', '.'), pkg);
        writer.write(pkgDecl);
        listWriter.write(pkgDecl);

        // import part
        writer.write("import static com.bluecc.hubs.ProtoTypes.*;\n");
        listWriter.write("import com.google.common.collect.ImmutableList;\n");
        listWriter.write("import java.util.List;\n");
        listWriter.write(format("import static com.bluecc.hubs.%s.%s.*;\n\n",
                pkg, className));

        dataList.keySet().stream().map(k -> format(
                        "import com.bluecc.hubs.stub.%s;",
                        protoMeta.getEntityMeta(k).getFlatMessageType()))
                .forEach(line -> {
                    try {
                        writer.write(line + "\n");
                        listWriter.write(line + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        // class part
        writer.write(format("\npublic final class %s {\n", className));
        listWriter.write(format("\npublic final class %sList {\n", className));

        Set<String> idSet = Sets.newHashSet();
        List<String> elementDefs = Lists.newArrayList();
        Multimap<String, Stereotype> typeMaps = ArrayListMultimap.create();
        for (String ent : dataList.keySet()) {
            EntityMeta meta = protoMeta.getEntityMeta(ent);
            for (JsonObject jo : dataList.get(ent)) {
                Stereotype obj = convertToStereotype(jo, meta, idSet);
                if (obj != null) {
                    typeMaps.put(ent, obj);
                    String result = jinjava.render(tplSource,
                            ImmutableMap.of("obj", obj,
                                    "className", className));
                    // System.out.println(result);
                    // writer.write(result);
                    elementDefs.add(result);
                }
            }
        }

        writer.write(String.join("\n", elementDefs));

        typeMaps.asMap().forEach((k, list) -> {
            String result = jinjava.render(tplListSource,
                    ImmutableMap.of("objs", list,
                            "meta", protoMeta.getEntityMeta(k),
                            "className", className));
            try {
                listWriter.write(result);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        writer.write("}\n");
        listWriter.write("}\n");
    }

}
