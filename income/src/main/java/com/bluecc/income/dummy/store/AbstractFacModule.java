package com.bluecc.income.dummy.store;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.util.Map;
import java.util.Properties;

public class AbstractFacModule extends AbstractModule {
    protected void bindProps(Properties properties) {
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            bind(String.class).annotatedWith(Names.named((String) entry.getKey()))
                    .toInstance((String) entry.getValue());
        }
    }

    protected void bindProps(Map<String, Object> properties) {
        properties.forEach((k, v) -> {
            if (v instanceof Integer) {
                bind(Integer.class).annotatedWith(Names.named(k))
                        .toInstance((Integer) v);
            } else {
                bind(String.class).annotatedWith(Names.named(k))
                        .toInstance(v.toString());
            }
        });
    }
}
