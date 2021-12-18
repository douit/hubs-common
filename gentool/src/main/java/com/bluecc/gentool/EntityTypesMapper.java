package com.bluecc.gentool;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.ProtoMeta;
import lombok.Builder;
import lombok.Data;

import java.util.Locale;

import static com.bluecc.hubs.fund.Util.prettyYaml;

public class EntityTypesMapper {
    @Data
    @Builder
    public static class TypeMapper{
        String parentField;
        String idField;
        String descriptionField;
        String name;
    }

    public static void main(String[] args) {
        MetaTypes.types().getEntities().forEach(e -> System.out.println(e));
        System.out.println(MetaTypes.types().getEntities().size());

        String typeEnt="StatusType";
        String typeItemEnt="StatusItem";

        ProtoMeta protoMeta=new ProtoMeta();

        TypeMapper mapper = digestMapper(typeEnt, protoMeta);
        prettyYaml(mapper);
        prettyYaml(digestMapper(typeItemEnt, protoMeta));
    }

    private static TypeMapper digestMapper(String typeEnt, ProtoMeta protoMeta) {
        EntityMeta meta= protoMeta.getEntityMeta(typeEnt);
        System.out.println(meta.getPublicFieldNames());

        TypeMapper.TypeMapperBuilder typeMapper= TypeMapper.builder();
        meta.getPublicFields().forEach(f ->{
            if(!meta.isCombine() && f.isPk()){
                typeMapper.idField(f.getName());
            }
            if(f.getName().startsWith("parent")){
                typeMapper.parentField(f.getName());
            }else if(f.getName().toLowerCase(Locale.ROOT).endsWith("description")){
                typeMapper.descriptionField(f.getName());
            }

        });
        TypeMapper mapper=typeMapper.name(typeEnt).build();
        return mapper;
    }
}
