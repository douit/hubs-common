package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.model.WithSuppliers;
import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.EntityValue;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;
import com.google.protobuf.Message;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

public final class ModelSerializer {
    public static EntityValue toEntityValue(Object bean){
        return EntityValue.newBuilder()
                .setEntityType(bean.getClass().getSimpleName())
                .putAllValues(ModelSerializer.toStringMap(bean))
                .build();
    }

    public static Map<String, String> toStringMap(Object o){
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Field[] fields = o.getClass().getDeclaredFields();
        Map<String, String> resultMap= Maps.newHashMap();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                MethodHandle handle = lookup.unreflectGetter(field);
                if(!Modifier.isStatic(field.getModifiers())) {
                    if(field.isAnnotationPresent(SerializedName.class)) {
                        Object val = handle.invoke(o);
                        if (val!=null && !(val instanceof List)) {
                            String strVal=val.toString();
                            if(!strVal.isEmpty()) {
                                resultMap.put(field.getAnnotation(SerializedName.class).value(), strVal);
                            }
                        }
                    }
                }
            } catch (Throwable ex) {
                throw new RuntimeException(ex.getMessage(), ex);
            }
        }
        return resultMap;
    }


    public static EntityValue getEntityValue(WithSuppliers e) {
        EntityValue.Builder valBuilder = EntityValue.newBuilder()
                .setEntityType(e.getClass().getSimpleName())
                .putAllValues(ModelSerializer.toStringMap(e));
        // Printers.printChildren(e);
        e.suppliers().forEach((k, v) -> {
            List<?> values = v.get();

            if (!values.isEmpty()) {
                EntityBucket.Builder bucket = EntityBucket.newBuilder();
                values.forEach(row -> {
                    bucket.addValues(ModelSerializer.toEntityValue(row));
                });
                valBuilder.putBuckets(k, bucket.build());
            }

        });
        return valBuilder.build();
    }

}
