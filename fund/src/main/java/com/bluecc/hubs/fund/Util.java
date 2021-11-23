package com.bluecc.hubs.fund;

import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;

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

    public static String getCurrentDirectory(){
        return System.getProperty("user.dir");
    }

    public static String readFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static String readFile(Path file) throws IOException {
        return new String(Files.readAllBytes(file));
    }
}
