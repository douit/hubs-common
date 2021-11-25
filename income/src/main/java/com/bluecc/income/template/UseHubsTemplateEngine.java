package com.bluecc.income.template;

import org.jdbi.v3.sqlobject.config.ConfiguringAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ConfiguringAnnotation(UseHubsEngineImpl.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UseHubsTemplateEngine {}
