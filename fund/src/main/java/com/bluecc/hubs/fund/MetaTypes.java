package com.bluecc.hubs.fund;

import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.bluecc.hubs.fund.DataSetUtil.getAvailableEntities;
import static com.bluecc.hubs.fund.FieldMappings.getFieldTypes;
import static com.bluecc.hubs.fund.SystemDefs.prependHubsHomeFile;
import static com.bluecc.hubs.fund.Util.readJsonFile;

public class MetaTypes {
    @Data
    @Builder
    public static class MetaList{
        Set<String> entities;
        public boolean has(String ent){
            return entities.contains(ent);
        }
    }

    public static Map<String, FieldMappings.FieldTypeDef> types=getFieldTypes();

    // $ just gen EntityTypesTool
    public static MetaList typeList=types();
    // $ just gen SqlGenTool
    public static MetaTypes.MetaList metaList=getAvailableEntities();

    public static void reloadMetaList(){
        metaList=getAvailableEntities();
        typeList=types();
    }

    public static Set<String> getAllEntities(){
        return Collections.unmodifiableSet(metaList.getEntities());
    }
    public static Set<String> getAllEntitiesCopy(){
        return new HashSet<>(metaList.getEntities());
    }
    public static Set<String> getNonHeadEntities(){
        Set<String> ents=MetaTypes.getAllEntitiesCopy();
        ents.removeAll(HeadEntityResources.allHeads());
        return ents;
    }

    public static MetaList types()  {
        try {
            return readJsonFile(MetaList.class,
                    prependHubsHomeFile("asset/mysql/types.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean hasTable(String entityName){
        return metaList.has(entityName);
    }

}
