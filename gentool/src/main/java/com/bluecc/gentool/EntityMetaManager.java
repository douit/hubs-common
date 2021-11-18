package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.google.common.collect.Maps;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.bluecc.gentool.SqlGenTool.readEntityMeta;

@Singleton
public class EntityMetaManager {
    Map<String, EntityMeta> metaMap= Maps.newHashMap();
    public EntityMeta getEntityMeta(String entityName){
        EntityMeta meta=metaMap.get(entityName);
        if(meta==null) {
            synchronized (EntityMetaManager.class) {
                try {
                    meta = readEntityMeta(entityName);
                    metaMap.put(entityName, meta);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return meta;
    }

    public List<String> getKeys(String entityName){
        return getEntityMeta(entityName).getPks();
    }
}
