package com.bluecc.hubs.fund.pubs;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Supplier;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MessageObject {
    Class<? extends Message> value();
    EntityNames symbol();
}
