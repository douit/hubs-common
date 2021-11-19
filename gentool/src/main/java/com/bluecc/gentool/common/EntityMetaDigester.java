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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityMetaDigester {
    EntityMeta meta;
    Multimap<String, FieldDigest> fieldDigestMap = ArrayListMultimap.create();
    SqlGenTool.MetaList typeList;

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
