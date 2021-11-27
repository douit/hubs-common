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
    @Override
    public String render(String sql, StatementContext ctx) {
        Jinjava jinjava = new Jinjava();
        jinjava.getGlobalContext().registerFilter(new VarFilter());
        jinjava.getGlobalContext().registerFilter(new SnakeCaseFilter());
        jinjava.getGlobalContext().registerFilter(new NamedFilter("camelCase",
                e -> Util.snakeToCamel(e.toString())));

        Map<String, Object> vars= Maps.newHashMap();
        vars.putAll(TemplateGlobalContext.getEntities());
        vars.putAll(ctx.getAttributes());

        return jinjava.render(sql, vars);
    }
}
