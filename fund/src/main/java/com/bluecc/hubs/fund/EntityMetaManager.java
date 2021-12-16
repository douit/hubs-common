package com.bluecc.hubs.fund;

import com.google.common.collect.Maps;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.fund.MetaTypes.types;
import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static com.bluecc.hubs.fund.Util.GSON;

public class EntityMetaManager {
    // Map<String, EntityMeta> metaMap = Maps.newHashMap();
    // public EntityMeta getEntityMeta(String entityName) {
    //     EntityMeta meta = metaMap.get(entityName);
    //     if (meta == null) {
    //         synchronized (EntityMetaManager.class) {
    //             try {
    //                 meta = readEntityMeta(entityName);
    //                 metaMap.put(entityName, meta);
    //             } catch (IOException e) {
    //                 throw new RuntimeException(e);
    //             }
    //         }
    //     }
    //     return meta;
    // }

    public static List<String> getKeys(String entityName) throws IOException {
        return readEntityMeta(entityName).getPks();
    }

    public static EntityMeta getEntityMeta(File file) throws IOException {
        EntityMeta meta = GSON.fromJson(new FileReader(file), EntityMeta.class);
        meta.setupFieldMappings(types);
        return meta;
    }

    public static EntityMeta readEntityMeta(String entityName)  {
        try {
            return getEntityMeta(getMetaFile(entityName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getMetaFile(String entityName) {
        return prependHubsHomeFile("asset/meta/" + entityName + ".json");
    }
}
