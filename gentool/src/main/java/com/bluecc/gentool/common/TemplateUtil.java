package com.bluecc.gentool.common;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;

import java.io.IOException;
import java.util.Map;

public class TemplateUtil {
    static class VarFilter implements Filter {
        @Override
        public Object filter(Object o, JinjavaInterpreter jinjavaInterpreter, String... strings) {
            // Preconditions.checkNotNull(o, "filter object is null");
            if(o==null){
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
        String template = Resources.toString(Resources
                        .getResource(templateLoc),
                Charsets.UTF_8);
        return jinjava.render(template, ctx);
    }
}
