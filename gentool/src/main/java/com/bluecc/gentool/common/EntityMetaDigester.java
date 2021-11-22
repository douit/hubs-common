package com.bluecc.gentool.common;

import com.bluecc.gentool.SqlGenTool;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityMetaDigester {
    EntityMeta meta;
    Multimap<String, FieldDigest> fieldDigestMap = ArrayListMultimap.create();
    SqlGenTool.MetaList typeList;
    Map<String, String> fieldRefTypes=Maps.newHashMap();

    public EntityMetaDigester(EntityMeta meta, SqlGenTool.MetaList typeList) {
        this.meta = meta;
        this.typeList = typeList;
        build();
    }

    public EntityMeta getMeta() {
        return meta;
    }

    public Multimap<String, FieldDigest> getFieldDigestMap() {
        return fieldDigestMap;
    }
    //
    // public boolean isEntityRefField(String fieldName){
    //     fieldDigestMap.get(fieldName);
    // }

    void build() {
        for (EntityMeta.RelationMeta relation : meta.getRelations()) {
            RefType ref;
            if (typeList.getEntities().contains(relation.getRelEntityName())) {
                ref = RefType.TYPE_REF;
            } else {
                ref = RefType.ENTITY_REF;
            }

            fieldDigestMap.put(relation.getKeymaps().get(0).fieldName,
                    new FieldDigest(
                            new TypeRef(relation.getRelEntityName()),
                            ref,
                            relation.getType(),
                            relation.getTitle(),
                            relation.getKeymaps().stream()
                                    .map(r -> r.fieldName).collect(Collectors.toList())
                    ));
        }

        // field entity type ref
        for (Map.Entry<String, Collection<EntityMetaDigester.FieldDigest>> entry : fieldDigestMap.asMap().entrySet()) {
            for (EntityMetaDigester.FieldDigest fieldDigest : entry.getValue()) {
                if (fieldDigest.getRefType() == EntityMetaDigester.RefType.TYPE_REF) {
                    // System.out.println("■■ " + entry.getKey() + ": " + fieldDigest.getTypeRef().getEntityType());
                    fieldRefTypes.put(entry.getKey(), fieldDigest.getTypeRef().getEntityType());
                }
            }
        }
    }

    public boolean isRefField(String fieldName){
        return fieldRefTypes.containsKey(fieldName);
    }
    public String getEntityRef(String fieldName){
        return fieldRefTypes.get(fieldName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TypeRef {
        String entityType;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldDigest {
        TypeRef typeRef;
        RefType refType;
        String relType;
        String title;
        List<String> unionFields;
    }

    public enum RefType {
        TYPE_REF, ENTITY_REF
    }
}
