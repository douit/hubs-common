package com.bluecc.gentool.common;

import com.bluecc.hubs.fund.template.VarFilter;
import com.google.common.collect.ImmutableMap;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.lib.fn.ELFunctionDefinition;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class TemplateUtilTest {
    public static class CustFn{
        public static String addSuffix(String s){
            return s+"$";
        }
    }
    @Test
    public void build() {
        Jinjava jinjava = new Jinjava();
        jinjava.getGlobalContext().registerFilter(new VarFilter());
        jinjava.getGlobalContext().registerFunction(new ELFunctionDefinition(
                "", "currentTimeMillis",
                System.class, "currentTimeMillis"));
        jinjava.getGlobalContext().registerFunction(new ELFunctionDefinition(
                "", "suffix",
                CustFn.class, "addSuffix", String.class));
        Map<String, Object> ctx= ImmutableMap.of("s","5");
        String r=jinjava.render("{{s}} = {{currentTimeMillis()}}", ctx);
        System.out.println(r);
        r=jinjava.render("{{suffix('xyz')}}", ctx);
        System.out.println(r);
    }
}