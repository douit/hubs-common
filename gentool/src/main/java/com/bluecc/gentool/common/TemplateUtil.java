package com.bluecc.gentool.common;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.EntityMetaManager;
import com.bluecc.hubs.fund.Util;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

public class TemplateUtil {
    public static class NamedFilter implements Filter {
        String filterName;
        Function<Object, String> fn;
        public NamedFilter(String filterName, Function<Object, String> fn){
            this.filterName=filterName;
            this.fn=fn;
        }

        @Override
        public String getName() {
            return filterName;
        }

        @Override
        public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
            return fn.apply(var);
        }
    }

    static class VarFilter implements Filter {
        @Override
        public Object filter(Object o, JinjavaInterpreter jinjavaInterpreter, String... strings) {
            // Preconditions.checkNotNull(o, "filter object is null");
            if (o == null) {
                return "**NONE**";
            }
            return Util.toVarName(o.toString());
        }

        @Override
        public String getName() {
            return "varName";
        }
    }

    public static String build(String templateLoc, Map<String, Object> ctx) throws IOException {
        Jinjava jinjava = new Jinjava();
        jinjava.getGlobalContext().registerFilter(new VarFilter());
        jinjava.getGlobalContext().registerFilter(new SnakeCaseFilter());
        jinjava.getGlobalContext().registerFilter(new NamedFilter("camelCase",
                e -> Util.snakeToCamel(e.toString())));

        String template = Resources.toString(Resources
                        .getResource(templateLoc),
                Charsets.UTF_8);
        return jinjava.render(template, ctx);
    }

    public static String sourceGen(String entName, String tplName) throws IOException {
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, false);
        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta));
    }
}
