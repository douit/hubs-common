package com.bluecc.gentool.common;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.EntityMetaManager;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.template.NamedFilter;
import com.bluecc.hubs.fund.template.SnakeCaseFilter;
import com.bluecc.hubs.fund.template.VarFilter;
import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class TemplateUtil {
    public static String build(String templateLoc, Map<String, Object> ctx) throws IOException {
        Jinjava jinjava = getJinjava();

        String template = Resources.toString(Resources
                        .getResource(templateLoc),
                Charsets.UTF_8);
        return jinjava.render(template, ctx);
    }

    public static Jinjava getJinjava() {
        Jinjava jinjava = new Jinjava();
        jinjava.getGlobalContext().registerFilter(new VarFilter());
        jinjava.getGlobalContext().registerFilter(new SnakeCaseFilter());
        jinjava.getGlobalContext().registerFilter(new NamedFilter("camelCase",
                e -> Util.snakeToCamel(e.toString())));
        jinjava.getGlobalContext().registerFilter(new NamedFilter("uppercase",
                e -> e.toString().toUpperCase(Locale.ROOT)));
        jinjava.getGlobalContext().registerFilter(new NamedFilter("upperSnake",
                e -> CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, e.toString())));
        return jinjava;
    }

    public static String sourceGen(String entName, String tplName) throws IOException {
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta));
    }

    public static String sourceGen(String entName, String tplName, boolean remap) throws IOException {
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, remap);
        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta));
    }

}
