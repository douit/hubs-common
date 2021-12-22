package com.bluecc.hubs.fund;

import com.bluecc.hubs.fund.GsonHelpers.LocalDateTimeAdapter;
import com.bluecc.hubs.fund.pubs.Exclude;
import com.google.common.base.CaseFormat;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bluecc.hubs.fund.GsonHelpers.EXCLUSION_STRATEGY;
import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static java.util.Objects.requireNonNull;
import static org.yaml.snakeyaml.DumperOptions.FlowStyle.AUTO;

public class Util {
    public static boolean isNotEmpty(String arg){
        return arg!=null && !arg.isEmpty();
    }

    public static boolean isEmpty(String arg){
        return arg==null || arg.isEmpty();
    }

    public static String arrayAwareToString(Object o) {
        final String arrayString = Arrays.deepToString(new Object[]{o});
        return arrayString.substring(1, arrayString.length() - 1);
    }

    public static String snakeToCamel(String str) {
        Preconditions.checkNotNull(str, "parameter is null");
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str);
    }

    public static String lowerSnakeToCamel(String str) {
        Preconditions.checkNotNull(str, "parameter is null");
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, str);
    }

    public static String toSnakecase(String str) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    public static String toConstName(String str) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str);
    }

    public static String toVarName(String str) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, str);
    }

    public static String toClassName(String str) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, str);
    }

    public static String wordsToClassName(String words) {
        return CaseFormat.LOWER_UNDERSCORE.to(
                CaseFormat.UPPER_CAMEL,
                toSnakecase(words.replaceAll("[ \\-,.():]", "_")));
    }


    public static final Gson GSON = new GsonBuilder()
            // .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
            .setPrettyPrinting()
            .setExclusionStrategies(EXCLUSION_STRATEGY)
            .create();
    public static final Gson GSON_NO_EXCLUDE = new GsonBuilder()
            // .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
            .registerTypeHierarchyAdapter(List.class, new GsonHelpers.CollectionAdapter())
            .setPrettyPrinting()
            // .setExclusionStrategies(strategy)
            .create();

    public static final Gson GSON_UNDER_SCORE = new GsonBuilder()
            .setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
            .registerTypeHierarchyAdapter(List.class, new GsonHelpers.CollectionAdapter())
            .setPrettyPrinting()
            // .setExclusionStrategies(strategy)
            .create();

    public static void pretty(Object o) {
        System.out.println(GSON.toJson(o));
    }
    public static void prettyFull(Object o) {
        System.out.println(GSON_NO_EXCLUDE.toJson(o));
    }

    public static String prettyJson(Object o) {
        // return GSON.toJson(o);
        // 不用Exclude标注, 使用TypeHierarchyAdapter方式来过滤空列表和对象
        return GSON_NO_EXCLUDE.toJson(o);
    }

    public static String underscoreJson(Object o) {
        return GSON_UNDER_SCORE.toJson(o);
    }

    public static String toString(Object o){
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Field[] fields = o.getClass().getDeclaredFields();
        StringBuilder res = new StringBuilder();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                MethodHandle handle = lookup.unreflectGetter(field);
                if(!Modifier.isStatic(field.getModifiers())) {
                    Object val=handle.invoke(o);
                    if(!(val instanceof List)) {
                        res.append(val != null ? field.getName()
                                + "=" + (val.toString()) + "; " : "");
                    }
                }
            } catch (Throwable ex) {
                throw new RuntimeException(ex.getMessage(), ex);
            }
        }
        return res.toString();
    }

    public static InputStream dataSource(String src) throws IOException {
        return Resources.getResource(src).openStream();
    }

    public static void writeJsonFile(Object o, File file) throws IOException {
        Writer writer = new FileWriter(file);
        writer.write(GSON.toJson(o));
        writer.close();
    }

    public static void writeFile(String string, Path path) throws IOException {
        writeFile(string, path.toFile());
    }

    public static void writeFile(String string, String path) throws IOException {
        writeFile(string, new File(path));
    }

    public static void writeFile(String string, File file) throws IOException {
        Writer writer = new FileWriter(file);
        writer.write(string);
        writer.close();
    }

    public static <T> T readJsonFile(Class<T> clz, File file) throws IOException {
        if (!file.exists()) {
            file = SystemDefs.prependHubsHomeFile(file);
        }
        String cnt = IOUtils.toString(new FileInputStream(file), StandardCharsets.UTF_8);
        return GSON.fromJson(cnt, clz);
    }

    public static <T> T readJsonResource(Class<T> clz, String location) throws IOException {
        String cnt = IOUtils.toString(dataSource(location), StandardCharsets.UTF_8);
        return GSON.fromJson(cnt, clz);
    }

    public static <T> T readJson(Class<T> clz, InputStream stream) throws IOException {
        String cnt = IOUtils.toString(stream, StandardCharsets.UTF_8);
        return GSON.fromJson(cnt, clz);
    }

    public static String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }

    public static String readFile(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public static String readFile(Path file) throws IOException {
        return new String(Files.readAllBytes(file));
    }

    public static List<File> listFiles(String dir, String suffix) {
        return listFiles(new File(dir), suffix);
    }

    public static List<File> listFiles(File dir, String suffix) {
        if (!dir.exists()) {
            dir = SystemDefs.prependHubsHomeFile(dir);
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
        } catch (Exception e) {
            throw new RuntimeException("Cannot read xml file " + dataFile, e);
        }
    }

    public static List<Element> allElements(String dataFile, Predicate<Element> filter) {
        Element root = readXml(dataFile);
        return childElements(root, filter);
    }

    public static List<Element> childElements(Element root){
        return childElements(root, null);
    }

    public static List<Element> childElements(Element root, Predicate<Element> filter) {
        NodeList nodeList = root.getChildNodes();
        List<Element> rs = Lists.newArrayList();
        for (int i = 0; i < nodeList.getLength(); ++i) {
            if (nodeList.item(i) instanceof Element) {
                Element element = (Element) nodeList.item(i);
                if (filter != null) {
                    if (filter.test(element)) {
                        rs.add(element);
                    }
                } else {
                    rs.add(element);
                }
            }
        }
        return rs;
    }

    public static String getWordsFirstLetters(String str) {
        return str.replaceAll("\\B.|\\P{L}", "").toUpperCase();
    }

    /**
     * Computes the HMAC/SHA-256 code for a given key and message.
     *
     * @param key     the key used to generate the code.
     * @param message the message.
     * @return the code as a string.
     */
    public static String computeHmacSha256(String key, String message)
            throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hasher = Mac.getInstance("HmacSHA256");
        hasher.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] hash = hasher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        String result = "";
        for (byte b : hash) {
            result += Integer.toString((b & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }

    /**
     * Returns the current UTC timestamp in seconds.
     *
     * @return the timestamp as a long.
     */
    public static long getTimeNow() {
        long time = System.currentTimeMillis() / 1000L;
        return time;
    }

    //  Flatten a map containing a list of items as values in Java
    public static <T> Stream<T> flatten(Collection<List<T>> values) {
        Stream<T> stream = values.stream()
                .flatMap(x -> x.stream());

        return stream;
    }

    //  Flatten a stream of multiple arrays of the same type in Java
    @SafeVarargs
    public static <T> Stream<T> flatten(T[]... arrays) {
        Stream<T> stream = Stream.of(arrays).flatMap(Arrays::stream);
        return stream;
    }

    // Function that matches input str with
    // given wildcard pattern
    // pattern = "ba*ab"; pattern = "ba*ab****"; pattern = "aa?ab";
    public static boolean matchString(String str, String pattern) {
        int n=str.length();
        int m=pattern.length();

        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);

        // lookup table for storing results of
        // subproblems
        boolean[][] lookup = new boolean[n + 1][m + 1];

        // initialize lookup table to false
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);

        // empty pattern can match with empty string
        lookup[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        // fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty
                //     sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1]
                            || lookup[i - 1][j];

                    // Current characters are considered as
                    // matching in two cases
                    // (a) current character of pattern is '?'
                    // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?'
                        || str.charAt(i - 1)
                        == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                    // If characters don't match
                else
                    lookup[i][j] = false;
            }
        }

        return lookup[n][m];
    }

    public static String createRegexFromGlob(String glob) {
        StringBuilder out = new StringBuilder("^");
        for(int i = 0; i < glob.length(); ++i) {
            final char c = glob.charAt(i);
            switch(c) {
                case '*': out.append(".*"); break;
                case '?': out.append('.'); break;
                case '.': out.append("\\."); break;
                case '\\': out.append("\\\\"); break;
                default: out.append(c);
            }
        }
        out.append('$');
        return out.toString();
    }

    public static String toYaml(Object obj){
        DumperOptions dumperOptions = new DumperOptions();
        // dumperOptions.setPrettyFlow(true);
        dumperOptions.setDefaultFlowStyle(AUTO);
        Yaml yaml = new Yaml(dumperOptions);
        return yaml.dumpAs(obj, Tag.MAP, null);
    }

    public static void prettyYaml(Object obj){
        System.out.println(toYaml(obj));
    }

    public static Map<String, Object> readYaml(String inputFile) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(inputFile);
        Yaml yaml = new Yaml();
        return yaml.load(inputStream);
    }

    @SneakyThrows
    public static List<Path> scanFiles(String dir, String fileSuffix) {
        List<Path> fileList= Lists.newArrayList();
        try (Stream<Path> walkStream = Files.walk(Paths.get(dir))) {
            walkStream.filter(p -> p.toFile().isFile()).forEach(f -> {
                if (f.toString().endsWith(fileSuffix)) {
                    // System.out.println(f + " found!");
                    fileList.add(f);
                }
            });
        }
        return fileList;
    }
}
