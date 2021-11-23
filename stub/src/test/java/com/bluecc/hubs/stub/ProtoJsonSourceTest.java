package com.bluecc.hubs.stub;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.protobuf.util.JsonFormat;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.lib.fn.ELFunctionDefinition;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;

public class ProtoJsonSourceTest {
    public static URL getPartyFile() {
        return ProtoJsonSourceTest.class.getResource("/data/party_simple.json");
    }
    public static URL getOrderFile() {
        return ProtoJsonSourceTest.class.getResource("/data/order_head_simple.json");
    }

    @Test
    public void testPartySimple() throws IOException {
        String json=IOUtils.toString(getPartyFile(), StandardCharsets.UTF_8);
        PartyFlatData.Builder builder= PartyFlatData.newBuilder();
        JsonFormat.parser().merge(json, builder);
        PartyFlatData data=builder.build();
        System.out.println(data);
    }

    @Test
    public void testOrderSimple() throws IOException{
        String json=IOUtils.toString(getOrderFile(), StandardCharsets.UTF_8);
        OrderHeaderData.Builder builder= OrderHeaderData.newBuilder();
        JsonFormat.parser().merge(json, builder);
        OrderHeaderData data=builder.build();
        System.out.println(data);
    }

    public static URL getOrderYamlFile() {
        return ProtoJsonSourceTest.class.getResource("/data/order_head_simple.yml");
    }
    public static URL getOrderYamlVarsFile() {
        return ProtoJsonSourceTest.class.getResource("/data/order_head_simple_vars.yml");
    }

    // private static String convertYamlToJson(String yaml) {
    //     try {
    //         ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
    //         Map obj = yamlReader.readValue(yaml, Map.class);
    //         ObjectMapper jsonWriter = new ObjectMapper();
    //         return jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    //     } catch (IOException ex) {
    //         ex.printStackTrace();
    //     }
    //     return null;
    // }

    Yaml yaml = new Yaml();
    Gson gson= new Gson();
    @Test
    public void testOrderSimpleYaml() throws IOException {
        // String json = convertYamlToJson(IOUtils.toString(getOrderYamlFile(), StandardCharsets.UTF_8));
        // String cnt=IOUtils.toString(getOrderYamlVarsFile(), StandardCharsets.UTF_8);
        String cnt=IOUtils.toString(getOrderYamlFile(), StandardCharsets.UTF_8);
        // System.out.println(cnt);
        Map<String, Object> obj = yaml.load(cnt);
        System.out.println(obj);
        String json=gson.toJson(obj);
        System.out.println(json);
        pretty(obj);
    }

    public static class CustFn{
        public static String addSuffix(String s){
            return s+"$";
        }
        public static String makeDecimal(String s){
            return String.format("{value: \"%s\"}", s);
        }
    }
    Jinjava createTemplate(){
        Jinjava jinjava = new Jinjava();
        jinjava.getGlobalContext().registerFunction(new ELFunctionDefinition(
                "", "suffix",
                CustFn.class, "addSuffix", String.class));
        jinjava.getGlobalContext().registerFunction(new ELFunctionDefinition(
                "", "decimal",
                CustFn.class, "makeDecimal", String.class));
        return jinjava;
    }

    @Test
    public void testOrderSimpleVarsYaml() throws IOException {
        String cnt=IOUtils.toString(getOrderYamlVarsFile(), StandardCharsets.UTF_8);
        Jinjava jinjava=createTemplate();
        String r=jinjava.render(cnt, ImmutableMap.of());
        System.out.println(r);

        Map<String, Object> obj = yaml.load(r);
        System.out.println(obj);
        pretty(obj);
    }
}
