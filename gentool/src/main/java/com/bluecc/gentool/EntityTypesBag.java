package com.bluecc.gentool;

import com.bluecc.hubs.fund.Util;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.IOUtils;
import org.redisson.misc.BiHashMap;

import javax.inject.Singleton;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Singleton
public class EntityTypesBag {
    public static final String DATASET_SEED_ID_MAPPINGS_JSON = "dataset/seed/id_mappings.json";
    BiHashMap<String, Long> idMap= new BiHashMap<>();
    EntityTypesBag() throws IOException {
        Gson gson = new Gson();
        Type empMapType = new TypeToken<Map<String, Long>>() {}.getType();
        File mappingFile=new File(DATASET_SEED_ID_MAPPINGS_JSON);

        if(mappingFile.exists()) {
            String jsonString = IOUtils.toString(new FileInputStream(mappingFile),
                    StandardCharsets.UTF_8);
            Map<String, Long> readMap = gson.fromJson(jsonString, empMapType);
            idMap.putAll(readMap);
        }
    }

    public void put(String key, Long id){
        idMap.put(key, id);
    }

    public Long get(String key){
        return idMap.get(key);
    }

    public void save() throws IOException {
        Map<String, Long> saveMap = Maps.newHashMap();
        saveMap.putAll(idMap);
        Util.writeJsonFile(saveMap, new File(DATASET_SEED_ID_MAPPINGS_JSON));
    }
}

