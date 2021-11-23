package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.EntityMetaManager;
import com.google.common.collect.Maps;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Singleton
public class ProtoMeta {
    Map<String, EntityMeta> metaMap= Maps.newHashMap();

    public EntityMeta getEntityMeta(String entityName){
        EntityMeta meta=metaMap.get(entityName);
        if(meta==null) {
            synchronized (ProtoMeta.class) {
                try {
                    meta = EntityMetaManager.getEntityMeta(entityName, false);
                    metaMap.put(entityName, meta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return meta;
    }

    public EntityMeta.RelationQueryMeta findRelationQueryMeta(String entityName, String relField){
        List<EntityMeta.RelationQueryMeta>  rels=getEntityMeta(entityName).getRelationQueries();
        for (EntityMeta.RelationQueryMeta rel : rels) {
            if(rel.getRelationFieldName().equals(relField)){
                return rel;
            }
        }
        return null;
    }
}

