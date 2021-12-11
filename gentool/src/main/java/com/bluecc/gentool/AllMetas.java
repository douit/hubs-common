package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Util;
import com.bluecc.hubs.fund.pubs.Exclude;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllMetas {
    @Data
    @AllArgsConstructor
    public static class EntityInfo {
        String name;
        String pk;
    }

    @Data
    @Builder
    public static class EntityList{
        static final String targetFile="asset/facts/all_metas.json";
        List<EntityInfo> infoList;
        int total;

        @Exclude
        Map<String, EntityInfo> entityByKeyMap;
        public EntityInfo getInfoByKey(String key){
            if(entityByKeyMap==null){
                entityByKeyMap= Maps.newHashMap();
                infoList.forEach(e -> entityByKeyMap.put(e.getPk(), e));
            }
            return entityByKeyMap.get(key);
        }

        public static EntityList load() {
            try {
                return Util.readJsonFile(EntityList.class, new File(targetFile));
            } catch (IOException e) {
                throw new RuntimeException("Cannot load config file: "+targetFile, e);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ProtoMeta protoMeta = new ProtoMeta();
        List<EntityInfo> infoList= Util.listFiles("asset/meta", ".json").stream()
                .map(f -> {
                    EntityMeta meta = protoMeta.getEntityMeta(FilenameUtils.getBaseName(f.toString()));
                    return meta;
                })
                .filter(meta -> !meta.isCombine()).map(meta ->
                        new EntityInfo(meta.getName(), meta.getPk()))
                .collect(Collectors.toList());

        Util.writeJsonFile(EntityList.builder()
                        .infoList(infoList)
                        .total(infoList.size()).build(),
                new File(EntityList.targetFile));
    }
}
