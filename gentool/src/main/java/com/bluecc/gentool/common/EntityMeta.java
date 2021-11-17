package com.bluecc.gentool.common;

import com.bluecc.gentool.dummy.FieldMappings;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Builder
public class EntityMeta {
    String name;
    String title;
    String tableName;
    String uniqueKey;
    boolean combine;
    String description;

    @Singular
    List<FieldMeta> fields = Lists.newArrayList();
    @Singular
    List<RelationMeta> relations = Lists.newArrayList();
    int pksSize;
    List<String> pks = Lists.newArrayList();
    boolean isView;

    public String getPk() {
        if (combine) {
            return "id";
        } else {
            return pks.get(0);
        }
    }

    public String getPkCol() {
        if (combine) {
            return "ID";
        } else {
            return pkCols().get(0);
        }
    }

    public List<String> pkCols() {
        return fields.stream()
                .filter(f -> f.pk && !f.getName().equals("id"))
                .map(f -> f.getCol())
                .collect(Collectors.toList());
    }

    public String getUniqueCols() {
        return String.join(", ", pkCols());
    }

    public void setupFieldMappings(Map<String, FieldMappings.FieldTypeDef> types) {
        fields.forEach(f -> f.setSqlType(types.get(f.type).getSqlType()));
        if (combine) {
            getFields().add(FieldMeta.builder()
                    .name("id")
                    .type("id")
                    .javaType("Long")
                    .sqlType("BIGINT auto_increment")
                    .stringLength(20)
                    .col("ID")
                    .pk(true)
                    .notNull(true)
                    .autoCreatedInternal(true)
                    .autoInc(true)
                    .build());
        }else{
            fields.stream().filter(f -> f.pk).forEach(f -> f.setAutoInc(true));
        }
    }

    @Data
    @Builder
    public static class FieldMeta {
        String name;
        String type;

        /**
         * The java-type of the Field
         */
        private String javaType;
        /**
         * The sql-type of the Field
         */
        private String sqlType;
        /**
         * The sql-type-alias of the Field, this is optional
         */
        // private String sqlTypeAlias;
        Integer stringLength;

        String col;
        boolean pk;
        boolean notNull;
        boolean encrypt;
        boolean autoCreatedInternal;
        boolean autoInc;
        List<String> validators = Lists.newArrayList();

        public String getFixSqlType() {
            if (type.startsWith("id")) {
                if (autoInc) {
                    return "BIGINT auto_increment";
                } else {
                    return "BIGINT";
                }
            }
            return sqlType;
        }
    }

    @Data
    @Builder
    public static class RelationMeta {
        String name;
        String type;
        String relEntityName;
        String fkName;
        @Singular
        List<KeymapMeta> keymaps = Lists.newArrayList();
        boolean autoRelation;
    }

    @Data
    @Builder
    public static class KeymapMeta {
        String fieldName;
        String relFieldName;
    }
}
