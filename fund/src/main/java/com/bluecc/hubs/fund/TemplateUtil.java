package com.bluecc.hubs.fund;

import com.bluecc.hubs.fund.template.NamedFilter;
import com.bluecc.hubs.fund.template.SnakeCaseFilter;
import com.bluecc.hubs.fund.template.VarFilter;
import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.FatalTemplateErrorsException;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class TemplateUtil {
    public static String build(String templateLoc, Map<String, Object> ctx) throws IOException {
        try {
            String template = Resources.toString(Resources
                            .getResource(templateLoc),
                    Charsets.UTF_8);
            return getJinjava().render(template, ctx);
        }catch (FatalTemplateErrorsException e){
            System.out.println("⚠️  error template: \n"+e.getTemplate());
            e.getErrors().forEach(t -> System.out.println("🆑 "+t));
            return "";
        }
    }

    static Jinjava jinjava;
    public static Jinjava getJinjava() {
        if(jinjava==null) {
            jinjava = new Jinjava();
            jinjava.getGlobalContext().registerFilter(new VarFilter());
            jinjava.getGlobalContext().registerFilter(new SnakeCaseFilter());
            jinjava.getGlobalContext().registerFilter(new NamedFilter("camelCase",
                    e -> Util.snakeToCamel(e.toString())));
            jinjava.getGlobalContext().registerFilter(new NamedFilter("uppercase",
                    e -> e.toString().toUpperCase(Locale.ROOT)));
            jinjava.getGlobalContext().registerFilter(new NamedFilter("upperSnake",
                    e -> CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, e.toString())));
            jinjava.getGlobalContext().registerFilter(new NamedFilter("colToVar",
                    e -> CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, e.toString())));
        }
        return jinjava;
    }

    public static String sourceGen(String entName, String tplName) throws IOException {
        EntityMeta meta= EntityMetaManager.readEntityMeta(entName);
        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta));
    }

    // public static String sourceGen(String entName, String tplName, boolean remap) throws IOException {
    //     EntityMeta meta= EntityMetaManager.getEntityMeta(entName, remap);
    //     return TemplateUtil.build("templates/"+ tplName +"_source.j2",
    //             ImmutableMap.of("ent", meta));
    // }

}
