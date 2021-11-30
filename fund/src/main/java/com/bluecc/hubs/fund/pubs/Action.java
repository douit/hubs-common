package com.bluecc.hubs.fund.pubs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Action {
    Class<?> value();
    String mode() default "async";
    String runAsUser() default "user";
    int seq() default 0;
}