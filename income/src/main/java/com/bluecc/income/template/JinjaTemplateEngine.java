package com.bluecc.income.template;

import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.template.NamedFilter;
import com.bluecc.hubs.fund.template.SnakeCaseFilter;
import com.bluecc.hubs.fund.template.VarFilter;
import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.core.statement.TemplateEngine;

import java.util.Map;

/**
 * Rewrites a template, using the attributes on the {@link StatementContext} as template parameters.
 */
public class JinjaTemplateEngine implements TemplateEngine {
    static Jinjava jinjava;
    static Jinjava getJinjava(){
        if(jinjava==null){
            jinjava = new Jinjava();
            jinjava.getGlobalContext().registerFilter(new VarFilter());
            jinjava.getGlobalContext().registerFilter(new SnakeCaseFilter());
            jinjava.getGlobalContext().registerFilter(new NamedFilter("camelCase",
                    e -> Util.snakeToCamel(e.toString())));
        }
        return jinjava;
    }

    @Override
    public String render(String sql, StatementContext ctx) {
        Jinjava jinjava=getJinjava();

        Map<String, Object> vars= Maps.newHashMap();
        vars.putAll(TemplateGlobalContext.getEntities());
        vars.putAll(ctx.getAttributes());

        // System.out.println(ctx.getBinding().getNames());
        return jinjava.render(sql, vars);
    }
}

