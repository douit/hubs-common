package com.bluecc.hubs.fund;

import com.bluecc.hubs.fund.EntityMetaDigester.FieldDigest;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.MetaTypes.typeList;
import static java.lang.String.format;

@Data
@Builder
@Slf4j
public class EntityMeta {

    /* move to HeadEntity
    public static final Map<String, HeadEntity> HEAD_ENTITIES = ImmutableMap.of(
            "OrderHeader", HeadEntity.builder().build(),
            "OrderItem", HeadEntity.builder()
                    .flatId("OrderHeader")
                    .build(),
            "Payment", HeadEntity.builder().build(),
            "Invoice", HeadEntity.builder()
                            .flatId("Party")
                    .build(),
            "Product", HeadEntity.builder().build(),
            "Shipment", HeadEntity.builder().build(),
            "ProductStore", HeadEntity.builder()
                            .flatId("Party")
                    .build(),
            "Party", HeadEntity.builder().build(),
            "Person", HeadEntity.builder()
                    .flatId("Party")
                    .build(),
            "PartyGroup", HeadEntity.builder()
                    .flatId("Party")
                    .build()
    );
    */

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

    static final Set<String> MESSAGE_IGNORE_FIELDS =
            Sets.newHashSet("lastUpdatedStamp", "createdStamp");
    public List<FieldMeta> getMessageFields() {
        return fields.stream().filter(f -> !MESSAGE_IGNORE_FIELDS.contains(f.getName()))
                .collect(Collectors.toList());
    }

    public int getMessageFieldNumber() {
        return getMessageFields().size();
    }

    public String getKeyNames() {
        return String.join(", ", pks);
    }
    public String getUnderscoreKeys(){
        return getUniqueCols().toLowerCase(Locale.ROOT);
    }

    public Set<String> getFieldNames(){
        return fields.stream().map(f -> f.name).collect(Collectors.toSet());
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
    public String getPkSetter() {
        return "set" + Util.toClassName(getPk());
    }

    public String getPkCol() {
        if (combine) {
            return "ID";
        } else {
            return pkCols().get(0);
        }
    }

    public String getUnderscorePk(){
        return getPkCol().toLowerCase(Locale.ROOT);
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

    // public String getUnderscore() {
    //     return Util.toSnakecase(this.name);
    // }
    public String getUnderscore() {
        return this.tableName.toLowerCase(Locale.ROOT);
    }

    public boolean isHeadEntity() {
        return HeadEntityResources.contains(this.name);
    }

    public String getUpdateClause(){
        String sid=getPk();
        return fields.stream()
                .filter(f -> !f.getName().equals(sid)
                        && !f.isCreateTs()
                        && !IGNORE_FIELDS.contains(f.name))
                .map(f -> {
                    if(f.isUpdateTs()){
                        return format("%s=:now", f.getUnderscore());
                    }else {
                        return format("%s=:%s", f.getUnderscore(), f.name);
                    }
                })
                .collect(Collectors.joining(", "));
    }

    public String getInsertClause(){
        String cols= fields.stream()
                .filter(f -> !f.isUpdateTs() && !IGNORE_FIELDS.contains(f.name))
                .map(f -> f.getUnderscore())
                .collect(Collectors.joining(", "));
        String vals= fields.stream()
                .filter(f -> !f.isUpdateTs() && !IGNORE_FIELDS.contains(f.name))
                .map(f -> {
                    if(f.isCreateTs()){
                        return ":now";
                    }else {
                        return format(":%s", f.getName());
                    }
                })
                .collect(Collectors.joining(", "));
        return format("(%s) values (%s)", cols, vals);
    }

    static final Set<String> IGNORE_FIELDS = Sets.newHashSet("lastUpdatedTxStamp", "createdTxStamp");

    public void setupFieldMappings(Map<String, FieldMappings.FieldTypeDef> types) {
        // fields = fields.stream().filter(f ->
        //         !IGNORE_FIELDS.contains(f.getName())).collect(Collectors.toList());

        // 修正对应的sql-type, 比如TIMESTAMPTZ类型
        fields.forEach(f -> {
            FieldMappings.FieldTypeDef typDef = types.get(f.type);
            f.setSqlType(typDef.getSqlType());
            f.setJavaType(typDef.getJavaType());
            f.setClickhouseType(typDef.getClickhouseType());
        });

        // process entity types
        Map<String, FieldDigest> fieldWithTypes = Maps.newHashMap();
        EntityMetaDigester digester = new EntityMetaDigester(this, typeList);
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
                    // .javaType("Long")
                    // .sqlType("BIGINT auto_increment")
                    .javaType("String")
                    .sqlType("VARCHAR(20)")
                    .stringLength(20)
                    .col("ID")
                    .pk(true)
                    .notNull(true)
                    .autoCreatedInternal(true)
                    .autoInc(true)
                    .build());
        }
        //
        // fields.stream().filter(f -> f.pk).forEach(f -> {
        //     f.setAutoInc(true);
        //     f.setType("id");  // 修正唯一键的类型
        //     f.setJavaType("Long");
        //     f.setSqlType("BIGINT");
        // });
    }

    @Data
    @Builder
    public static class RelationQueryMeta{
        String relationFieldName;  // 使用relation名称定义的proto字段名
        String relationEntity;
        List<String> fieldNames;
        boolean repeated;

        public List<String> getTableFields(){
            return fieldNames.stream().map(f -> Util.toSnakecase(f))
                    .collect(Collectors.toList());
        }
    }

    public List<RelationQueryMeta> getRelationQueries(){
        return relations.stream().filter(r -> r.hasProtoDef(name))
                .map(r -> RelationQueryMeta.builder()
                        .relationFieldName(Util.toSnakecase(r.name))
                        .relationEntity(r.getRelEntityName())
                        .fieldNames(r.getRelFieldList())
                        .repeated(r.isRepeated())
                        .build())
                .collect(Collectors.toList());
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
        private String clickhouseType;

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
            // if (type.startsWith("id")) {
            //     if (autoInc) {
            //         return "BIGINT auto_increment";
            //     } else {
            //         return "BIGINT";
            //     }
            // }
            return sqlType;
        }

        public String getComment() {
            if (fieldDigest != null) {
                return fieldDigest.getTypeRef().getEntityType();
            } else {
                return name;
            }
        }

        // public String getUnderscore() {
        //     return Util.toSnakecase(this.name);
        // }
        public String getUnderscore() {
            return col.toLowerCase(Locale.ROOT);
        }

        public String getProtoType() {
            return MetaTypeUtil.getProtoType(this.type);
        }

        public boolean isCreateTs(){
            return name.equals("createdStamp");
        }
        public boolean isUpdateTs(){
            return name.equals("lastUpdatedStamp");
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
                            return format("%s -> %s", r.fieldName, r.relFieldName);
                        }
                    })
                    .collect(Collectors.joining(", "));
        }

        public String getProtoDef() {
            String prefix = this.type.equals("many") ? "repeated " : "";
            // return String.format("%s %sData %s", prefix, relEntityName,
            //         Util.toSnakecase(title) + "_" + Util.toSnakecase(name));
            return format("%s%sData %s", prefix, relEntityName, getProtoName());
        }

        public String getProtoName(){
            return Util.toSnakecase(name);
        }

        public boolean isRepeated(){
            return this.type.equals("many");
        }

        public boolean hasProtoDef(String entityName){
            HeadEntity headEntity=HeadEntityResources.get(entityName);
            if(headEntity!=null){
                return !headEntity.getFlatIds().contains(this.relEntityName);
            }
            return false; // not head-entity
        }

        public String getMainRelField(){
            return keymaps.get(0).fieldName;
        }

        public String getRelFields(){
            return keymaps.stream().map(k -> k.fieldName)
                    .collect(Collectors.joining(" + "));
        }
        public List<String> getRelFieldList(){
            return keymaps.stream().map(k -> k.fieldName)
                    .collect(Collectors.toList());
        }
        public List<String> getTargetFieldList(){
            return keymaps.stream().map(k -> k.relFieldName)
                    .collect(Collectors.toList());
        }
    }

    @Data
    @Builder
    public static class KeymapMeta {
        String fieldName;
        String relFieldName;

        public String getProtoField(){
            return Util.toSnakecase(fieldName);
        }
        public String getProtoRelField(){
            return Util.toSnakecase(relFieldName);
        }

    }
}
