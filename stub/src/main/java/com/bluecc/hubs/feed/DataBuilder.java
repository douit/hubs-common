package com.bluecc.hubs.feed;

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
        return procData(entityName, disableHeadEntity, null);
    }

    public static ProtoBuilder procData(String entityName, boolean disableHeadEntity, Object protoInst) {
        String dataClass = null;
        if (HeadEntityResources.contains(entityName) && disableHeadEntity) {
            dataClass = String.format("com.bluecc.hubs.stub.%sFlatData", entityName);
        } else {
            dataClass = String.format("com.bluecc.hubs.stub.%sData", entityName);
        }
        try {
            Class<?> clz = Class.forName(dataClass);

            GeneratedMessageV3.Builder<?> builder = null;
            if(protoInst==null) {
                Method method = clz.getMethod("newBuilder");
                builder = (GeneratedMessageV3.Builder<?>) method.invoke(null);
            }else{
                Method method = clz.getMethod("newBuilder", protoInst.getClass());
                builder = (GeneratedMessageV3.Builder<?>) method.invoke(null, protoInst);
            }
            Method method = clz.getMethod("getDescriptor");
            Descriptors.Descriptor descriptor = (Descriptors.Descriptor) method.invoke(null);
            return new ProtoBuilder(builder, descriptor);
        } catch (Exception e) {
            throw new RuntimeException("Cannot init entity class " + entityName, e);
        }
    }

    @SuppressWarnings("unchecked")
    public static Class<? extends com.google.protobuf.Message> getEntityClass(String entityName, boolean flat){
        String dataClass;
        if (HeadEntityResources.contains(entityName) && flat) {
            dataClass = String.format("com.bluecc.hubs.stub.%sFlatData", entityName);
        } else {
            dataClass = String.format("com.bluecc.hubs.stub.%sData", entityName);
        }
        try {
            Class<?> clz = Class.forName(dataClass);
            return (Class<? extends com.google.protobuf.Message>)clz;
        } catch (Exception e) {
            throw new RuntimeException("Cannot init entity class " + entityName, e);
        }
    }
}
