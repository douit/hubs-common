package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.HeadEntityResources;
import com.bluecc.hubs.stub.OrderItemData;
import com.bluecc.hubs.stub.UserLoginData;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DataBuilder {
    @Data
    @AllArgsConstructor
    public static class ProtoBuilder {
        GeneratedMessageV3.Builder<?> builder;
        Descriptors.Descriptor descriptor;
    }

    public ProtoBuilder procData(String entityName, boolean disableHeadEntity) {
        String dataClass = null;
        if (HeadEntityResources.contains(entityName) && disableHeadEntity) {
            dataClass = String.format("com.bluecc.hubs.stub.%sFlatData", entityName);
        } else {
            dataClass = String.format("com.bluecc.hubs.stub.%sData", entityName);
        }
        try {
            Class<?> clz = Class.forName(dataClass);
            Method method = clz.getMethod("newBuilder");
            GeneratedMessageV3.Builder<?> builder = (GeneratedMessageV3.Builder<?>) method.invoke(null);
            method = clz.getMethod("getDescriptor");
            Descriptors.Descriptor descriptor = (Descriptors.Descriptor) method.invoke(null);
            return new ProtoBuilder(builder, descriptor);
        } catch (Exception e) {
            throw new RuntimeException("Cannot init entity class " + entityName, e);
        }
    }
}
