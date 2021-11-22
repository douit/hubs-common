package com.bluecc.gentool.common;

import com.bluecc.gentool.EntityMetaManager;
import com.bluecc.gentool.SqlGenTool;
import com.bluecc.gentool.common.EntityMetaDigester.FieldDigest;
import com.bluecc.gentool.dummy.FieldMappings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@Slf4j
public class EntityMeta {
    @Data
    @Builder
    public static class HeadEntity {
        @Singular
        Set<String> flatIds;
    }

    public static final Map<String, HeadEntity> HEAD_ENTITIES = ImmutableMap.of(
            "OrderHeader", HeadEntity.builder().build(),
            "OrderItem", HeadEntity.builder()
                    .flatId("OrderHeader")
                    .build(),
            "Payment", HeadEntity.builder().build(),
            "Invoice", HeadEntity.builder()
                            .flatId("Party")
                    .build()
    );

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

    public List<FieldMeta> getPublicFields() {
        return fields.stream().filter(f -> !f.isAutoCreatedInternal())
                .collect(Collectors.toList());
    }

    public int getPublicFieldNumber() {
        return getPublicFields().size();
    }

    public String getKeyNames() {
        return String.join(", ", pks);
    }

    public String getPk() {
        if (combine) {
            return "id";
        } else {
            return pks.get(0);
        }
    }

    public String getPkGetter() {
        return "get" + Util.toClassName(getPk());
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

    public String getVarName() {
        return Util.toVarName(this.name);
    }

    public String getUnderscore() {
        return Util.toSnakecase(this.name);
    }

    public boolean isHeadEntity() {
        return HEAD_ENTITIES.containsKey(this.name);
    }

    static final Set<String> IGNORE_FIELDS = Sets.newHashSet("lastUpdatedTxStamp", "createdTxStamp");

    public void setupFieldMappings(Map<String, FieldMappings.FieldTypeDef> types) {
        fields = fields.stream().filter(f -> !IGNORE_FIELDS.contains(f.getName())).collect(Collectors.toList());
        fields.forEach(f -> {
            FieldMappings.FieldTypeDef typDef = types.get(f.type);
            f.setSqlType(typDef.getSqlType());
            f.setJavaType(typDef.getJavaType());
        });

        // process entity types
        Map<String, FieldDigest> fieldWithTypes = Maps.newHashMap();
        EntityMetaDigester digester = new EntityMetaDigester(this, EntityMetaManager.typeList);
        for (Map.Entry<String, Collection<FieldDigest>> entry : digester.getFieldDigestMap().asMap().entrySet()) {
            for (FieldDigest fieldDigest : entry.getValue()) {
                if (fieldDigest.getRefType() == EntityMetaDigester.RefType.TYPE_REF) {
                    // System.out.println("■■ " + entry.getKey() + ": "
                    //         + fieldDigest.getTypeRef().getEntityType());
                    fieldWithTypes.put(entry.getKey(), fieldDigest);
                }
            }
        }

        log.debug("fieldWithTypes: {}", fieldWithTypes.keySet());

        getFields().forEach(f -> {
            if (fieldWithTypes.containsKey(f.getName())) {
                f.setJavaType("String");
                f.setSqlType("VARCHAR(20)");
                f.setType("type-id");
                f.setFieldDigest(fieldWithTypes.get(f.getName()));
            }
        });

        // if the entity build with combine-keys, then add a new primary field.
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
        } else {
            fields.stream().filter(f -> f.pk).forEach(f -> {
                f.setAutoInc(true);
                f.setType("id");  // 修正唯一键的类型
                f.setJavaType("Long");
                f.setSqlType("BIGINT");
            });
        }
    }

    // public List<RelationMeta>

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

        FieldDigest fieldDigest;

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

        public String getComment() {
            if (fieldDigest != null) {
                return fieldDigest.getTypeRef().getEntityType();
            } else {
                return name;
            }
        }

        public String getUnderscore() {
            return Util.toSnakecase(this.name);
        }

        public String getProtoType() {
            return NameUtil.getProtoType(this.type);
        }
    }

    @Data
    @Builder
    public static class RelationMeta {
        String name;
        String type;
        String relEntityName;
        String fkName;
        String title;

        @Singular
        List<KeymapMeta> keymaps = Lists.newArrayList();
        boolean autoRelation;

        public String getDesc() {
            return keymaps.stream().map(r -> {
                        if (r.fieldName.equals(r.relFieldName)) {
                            return r.fieldName;
                        } else {
                            return String.format("%s -> %s", r.fieldName, r.relFieldName);
                        }
                    })
                    .collect(Collectors.joining(", "));
        }

        public String getProtoDef() {
            String prefix = this.type.equals("many") ? "repeated " : "";
            // return String.format("%s %sData %s", prefix, relEntityName,
            //         Util.toSnakecase(title) + "_" + Util.toSnakecase(name));
            return String.format("%s%sData %s", prefix, relEntityName,
                    Util.toSnakecase(name));
        }

        public boolean hasProtoDef(String entityName){
            HeadEntity headEntity=HEAD_ENTITIES.get(entityName);
            if(headEntity!=null){
                return !headEntity.flatIds.contains(this.relEntityName);
            }
            return false; // not head-entity
        }

        public String getMainRelField(){
            return keymaps.get(0).fieldName;
        }

        public String getRelFields(){
            return keymaps.stream().map(k -> k.fieldName).collect(Collectors.joining(" + "));
        }
    }

    @Data
    @Builder
    public static class KeymapMeta {
        String fieldName;
        String relFieldName;
    }
}
