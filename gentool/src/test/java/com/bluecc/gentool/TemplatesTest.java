package com.bluecc.gentool;

import com.bluecc.hubs.fund.TemplateUtil;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import com.hubspot.jinjava.Jinjava;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.bluecc.gentool.Stereotypes.convertToStereotype;
import static com.bluecc.hubs.fund.SeedReader.collectEntityData;
import static org.junit.Assert.assertEquals;

public class TemplatesTest {
    @Test
    public void testRender() throws IOException {
        // ProtoMeta protoMeta=new ProtoMeta();
        // protoMeta.getEntityMeta("OrderItem");
        String cnt = TemplateUtil.sourceGen("OrderItem", "dao_sql");
        System.out.println(cnt);
    }

    @Data
    @Builder
    public static class VarObject {
        String foo;
        int age;

        public String eval(String val) {
            return "$" + val;
        }

        public int evalInt(int val) {
            return val * 2;
        }
    }

    Jinjava jinjava = TemplateUtil.getJinjava();

    @Test
    public void testJinjava() {
        String result = jinjava.render("{{obj.foo}}, " +
                        "{{obj.eval('hello')}}",
                ImmutableMap.of("obj", VarObject.builder()
                        .foo("samlet")
                        .build()));
        System.out.println(result);
        assertEquals("samlet, $hello", result);

        result = jinjava.render("{{obj.foo}}, " +
                        "{{obj.eval('hello')}}, {{obj.evalInt(obj.age)}}",
                ImmutableMap.of("obj", VarObject.builder()
                        .foo("samlet")
                        .age(18)
                        .build()));
        System.out.println(result);
        assertEquals("samlet, $hello, 36", result);
    }

    ProtoMeta protoMeta = new ProtoMeta();

    @Test
    public void testSeedDataTemplate() {
        String dataFile = "dataset/sample/sales_order.xml";
        Multimap<String, JsonObject> dataList = ArrayListMultimap.create();
        collectEntityData(dataList, dataFile, true);
        System.out.println(dataList.keySet());
        JsonObject partyJo = dataList.get("Party").stream().findFirst().get();
        System.out.println(partyJo.keySet());

        EntityMeta meta = protoMeta.getEntityMeta("Party");
        List<EntityMeta.FieldMeta> flds = meta.getFields().stream()
                .filter(f -> partyJo.keySet().contains(f.getName()))
                .collect(Collectors.toList());
        assertEquals(flds.size(), partyJo.keySet().size());

        Set<String> idSet= Sets.newHashSet();

        String result = jinjava.render("{{obj.fields.partyId.value}}, " +
                        "{{obj.fields.statusId.value}}",
                ImmutableMap.of("obj", convertToStereotype(partyJo, meta, idSet)));
        System.out.println(result);

        System.out.println("-------------");
        result = jinjava.render(
                "{% for f in obj.fieldList %}" +
                        " {{f.meta.name}} = {{f.value}}, \n" +
                        "{% endfor %}",
                ImmutableMap.of("obj", convertToStereotype(partyJo, meta, idSet)));
        System.out.println(result);
    }

    @Test
    public void testFilterNum(){
        String num="08";
        System.out.println(Integer.parseInt(num));
    }

}
