package com.bluecc.hubs.fund;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class Util {
    public static String arrayAwareToString(Object o) {
        final String arrayString = Arrays.deepToString(new Object[] {o});
        return arrayString.substring(1, arrayString.length() - 1);
    }

    public static String snakeToCamel(String str){
        Preconditions.checkNotNull(str, "parameter is null");
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str);
    }

    public static String toSnakecase(String str){
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    public static String toVarName(String str){
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, str);
    }

    public static String toClassName(String str){
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, str);
    }

    public static String wordsToClassName(String words){
        return CaseFormat.LOWER_UNDERSCORE.to(
                CaseFormat.UPPER_CAMEL,
                words.replaceAll("[ \\-]", "_"));
    }


    /**
     * A simpler implementation. Add null support to by registering the nullSafe() wrapped version
     * ref: https://stackoverflow.com/questions/39192945/serialize-java-8-localdate-as-yyyy-mm-dd-with-gson
     */
    private static final class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
        @Override
        public void write(final JsonWriter jsonWriter, final LocalDateTime localDate ) throws IOException {
            jsonWriter.value(localDate.toString());
        }

        @Override
        public LocalDateTime read( final JsonReader jsonReader ) throws IOException {
            return LocalDateTime.parse(jsonReader.nextString());
        }
    }

    public static final Gson GSON = new GsonBuilder()
            // .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
            .setPrettyPrinting()
            .create();

    public static void pretty(Object o){
        System.out.println(GSON.toJson(o));
    }

    public static String prettyJson(Object o){
        return GSON.toJson(o);
    }

    public static InputStream dataSource(String src) throws IOException {
        return Resources.getResource(src).openStream();
    }

    public static void writeJsonFile(Object o, File file) throws IOException {
        Writer writer=new FileWriter(file);
        writer.write(GSON.toJson(o));
        writer.close();
    }

    public static void writeFile(String string, File file) throws IOException {
        Writer writer=new FileWriter(file);
        writer.write(string);
        writer.close();
    }

    public static <T> T readJsonFile(Class<T> clz, File file) throws IOException {
        String cnt=IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8);
        return GSON.fromJson(cnt, clz);
    }

    public static <T> T readJsonResource(Class<T> clz, String location) throws IOException {
        String cnt=IOUtils.toString(dataSource(location), StandardCharsets.UTF_8);
        return GSON.fromJson(cnt, clz);
    }

    public static <T> T readJson(Class<T> clz, InputStream stream) throws IOException {
        String cnt=IOUtils.toString(stream, StandardCharsets.UTF_8);
        return GSON.fromJson(cnt, clz);
    }

    public static String getCurrentDirectory(){
        return System.getProperty("user.dir");
    }

    public static String readFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static String readFile(Path file) throws IOException {
        return new String(Files.readAllBytes(file));
    }

    public static List<File> listFiles(String dir, String suffix){
        return listFiles(new File(dir), suffix);
    }

    public static List<File> listFiles(File dir, String suffix){
        if(!dir.exists()){
            dir=SystemDefs.prependHubsHomeFile(dir);
        }
        return Arrays.stream(requireNonNull(dir.listFiles()))
                .filter(f -> f.getName().toLowerCase(Locale.ROOT)
                        .endsWith(suffix))
                .collect(Collectors.toList());
    }

    public static Element readXml(String dataFile) {
        try {
            // Get Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Build Document
            Document document = builder.parse(dataFile);

            // Normalize the XML Structure; It's just too important !!
            document.getDocumentElement().normalize();

            // Here comes the root node
            Element root = document.getDocumentElement();

            return root;
        }catch (Exception e){
            throw new RuntimeException("Cannot read xml file "+dataFile, e);
        }
    }

    public static List<Element> allElements(String dataFile, Predicate<Element> filter){
        Element root = readXml(dataFile);
        return childElements(root, filter);
    }

    public static List<Element> childElements(Element root, Predicate<Element> filter) {
        NodeList nodeList= root.getChildNodes();
        List<Element> rs= Lists.newArrayList();
        for(int i=0;i<nodeList.getLength();++i) {
            if (nodeList.item(i) instanceof Element) {
                Element element = (Element) nodeList.item(i);
                if(filter !=null){
                    if(filter.test(element)){
                        rs.add(element);
                    }
                }else {
                    rs.add(element);
                }
            }
        }
        return rs;
    }
}
