package com.bluecc.hubs.fund.pubs;

import com.google.protobuf.ProtocolMessageEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Transition {
    String value();
    String event() default "return";
}
