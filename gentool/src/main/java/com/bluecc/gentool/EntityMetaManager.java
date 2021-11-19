package com.bluecc.gentool;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.dummy.FieldMappings;
import com.google.common.collect.Maps;

import javax.inject.Singleton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.bluecc.gentool.common.Util.GSON;
import static com.bluecc.gentool.dummy.FieldMappings.getFieldTypes;
import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;

@Singleton
public class EntityMetaManager {
    Map<String, EntityMeta> metaMap= Maps.newHashMap();

    static SqlGenTool.MetaList typeList=EntityTypesTool.types();
    static Map<String, FieldMappings.FieldTypeDef> types=getFieldTypes();

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

    public static EntityMeta getEntityMeta(File file) throws IOException {
        EntityMeta meta=GSON.fromJson(new FileReader(file),
                EntityMeta.class);
        meta.setupFieldMappings(types, typeList);
        return meta;
    }

    public static EntityMeta readEntityMeta(String entityName) throws IOException {
        return getEntityMeta(getMetaFile(entityName));
    }

    public static File getMetaFile(String entityName) {
        return prependHubsHomeFile("asset/meta/" + entityName + ".json");
    }
}
