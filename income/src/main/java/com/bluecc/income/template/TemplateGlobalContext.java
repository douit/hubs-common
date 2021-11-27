package com.bluecc.income.template;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TemplateGlobalContext {
    private ProtoMeta protoMeta;
    static TemplateGlobalContext instance;
    public static TemplateGlobalContext getContext() {
        if(instance==null){
            instance=new TemplateGlobalContext();
        }
        return instance;
    }

    public static Map<String, EntityMeta> getEntities(){
        return getContext().protoMeta.getMetaMap();
    }

    TemplateGlobalContext(){
        protoMeta=new ProtoMeta();
    }

    public void preload(String... entityNames){
        for (String entityName : entityNames) {
            this.protoMeta.getEntityMeta(entityName);
        }
    }
}

