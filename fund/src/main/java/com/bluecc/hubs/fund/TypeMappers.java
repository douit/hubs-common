package com.bluecc.hubs.fund;

import lombok.Builder;
import lombok.Data;

import java.util.Locale;

public class TypeMappers {
    @Data
    @Builder
    public static class TypeMapper{
        String parentField;
        String idField;
        String descriptionField;
        String name;
    }

    public static TypeMapper digestMapper(String typeEnt, ProtoMeta protoMeta) {
        EntityMeta meta= protoMeta.getEntityMeta(typeEnt);
        System.out.println(meta.getPublicFieldNames());

        TypeMapper.TypeMapperBuilder typeMapper= TypeMapper.builder();
        meta.getPublicFields().forEach(f ->{
            if(!meta.isCombine() && f.isPk()){
                typeMapper.idField(f.getUnderscore());
            }
            if(f.getName().startsWith("parent")){
                typeMapper.parentField(f.getUnderscore());
            }else if(f.getName().toLowerCase(Locale.ROOT).endsWith("description")){
                typeMapper.descriptionField(f.getUnderscore());
            }

        });
        TypeMapper mapper=typeMapper.name(typeEnt).build();
        return mapper;
    }
}
