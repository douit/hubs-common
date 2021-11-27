package com.bluecc.income.template;

import org.jdbi.v3.core.config.ConfigRegistry;
import org.jdbi.v3.core.statement.SqlStatements;
import org.jdbi.v3.sqlobject.config.Configurer;
import org.jdbi.v3.stringtemplate4.StringTemplateEngine;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class UseHubsEngineImpl implements Configurer {
    @Override
    public void configureForType(ConfigRegistry registry, Annotation annotation,
                                 Class<?> sqlObjectType) {
        registry.get(SqlStatements.class).setTemplateEngine(new JinjaTemplateEngine());
    }

    @Override
    public void configureForMethod(ConfigRegistry registry, Annotation annotation,
                                   Class<?> sqlObjectType, Method method) {
        configureForType(registry, annotation, sqlObjectType);
    }
}
