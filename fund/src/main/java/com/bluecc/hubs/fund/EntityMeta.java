package com.bluecc.hubs.fund;

import com.bluecc.hubs.fund.EntityMetaDigester.FieldDigest;
import com.bluecc.hubs.fund.descriptor.EntitySummaries;
import com.bluecc.hubs.fund.descriptor.EntitySummaries.CommonUse;
import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bluecc.hubs.fund.MetaTypes.typeList;
import static java.lang.String.format;

@Data
@Builder
@Slf4j
public class EntityMeta {
    public static final String REL_MANY = "many";
    public static final String REL_ONE = "one";
    public static final String REL_ONE_NOFK = "one-nofk";

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

    public void setCommonUse(CommonUse commonUse) {
        this.commonUse = commonUse;
    }

    EntitySummaries.CommonUse commonUse;
    public List<String> getCommonUseFieldNames(){
        return commonUse==null?Lists.newArrayList(getPks()):commonUse.getFields();
    }


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

    public String getUnderscoreKeys() {
        return getUniqueCols().toLowerCase(Locale.ROOT);
    }

    public Set<String> getFieldNames() {
        return fields.stream().map(f -> f.name).collect(Collectors.toSet());
    }

    public Set<String> getPublicFieldNames() {
        return getPublicFields().stream().map(f -> f.name).collect(Collectors.toSet());
    }

    public List<String> getColNames(String... exclude) {
        if (exclude.length > 0) {
            return fields.stream()
                    .map(f -> f.getUnderscore())
                    .filter(underscore -> Stream.of(exclude)
                            .noneMatch(ex -> Util.matchString(underscore, ex)))
                    .collect(Collectors.toList());
        }

        return fields.stream()
                .map(f -> f.getUnderscore())
                .collect(Collectors.toList());
    }

    public String getPrefix() {
        String constName = getUnderscore();
        String prefix = prefix(constName);
        return prefix;
    }

    static final Set<String> keywords = Sets.newHashSet("in",
            "with", "of", "and", "or", "not");

    public static String prefix(String constName) {
        String prefix = Arrays.stream(constName.split("_"))
                .map(s -> s.substring(0, 1))
                .collect(Collectors.joining());
        if (prefix.length() == 1) {
            prefix = constName.substring(0, 2);
        }
        if (keywords.contains(prefix)) {
            prefix = prefix + "z";
        }
        return prefix;
    }

    public Optional<FieldMeta> getField(String fieldName) {
        return fields.stream().filter(f -> f.name.equals(fieldName)).findFirst();
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

    public String getUnderscorePk() {
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

    public String getPlural(){
        return Inflector.getInstance().pluralize(getUnderscore());
    }

    public boolean isHeadEntity() {
        return HeadEntityResources.contains(this.name);
    }

    public String getUpdateClause() {
        String sid = getPk();
        return fields.stream()
                .filter(f -> !f.getName().equals(sid)
                        && !f.isCreateTs()
                        && !IGNORE_FIELDS.contains(f.name))
                .map(f -> {
                    if (f.isUpdateTs()) {
                        return format("%s=:now", f.getUnderscore());
                    } else {
                        return format("%s=:%s", f.getUnderscore(), f.name);
                    }
                })
                .collect(Collectors.joining(", "));
    }

    public String getInsertClause() {
        String cols = fields.stream()
                .filter(f -> !f.isUpdateTs() && !IGNORE_FIELDS.contains(f.name))
                .map(f -> f.getUnderscore())
                .collect(Collectors.joining(", "));
        String vals = fields.stream()
                .filter(f -> !f.isUpdateTs() && !IGNORE_FIELDS.contains(f.name))
                .map(f -> {
                    if (f.isCreateTs()) {
                        return ":now";
                    } else {
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

        // ???????????????sql-type, ??????TIMESTAMPTZ??????
        fields.forEach(f -> {
            FieldMappings.FieldTypeDef typDef = types.get(f.type);
            f.setSqlType(typDef.getSqlType());
            f.setJavaType(typDef.getJavaType());
            f.setClickhouseType(typDef.getClickhouseType());

            f.setFieldTypeDef(typDef);  // all other type-mappings
        });

        // process entity types
        Map<String, FieldDigest> fieldWithTypes = Maps.newHashMap();
        EntityMetaDigester digester = new EntityMetaDigester(this, typeList);
        for (Map.Entry<String, Collection<FieldDigest>> entry : digester.getFieldDigestMap().asMap().entrySet()) {
            for (FieldDigest fieldDigest : entry.getValue()) {
                if (fieldDigest.getRefType() == EntityMetaDigester.RefType.TYPE_REF) {
                    // System.out.println("?????? " + entry.getKey() + ": "
                    //         + fieldDigest.getTypeRef().getEntityType());
                    fieldWithTypes.put(entry.getKey(), fieldDigest);
                }
            }
        }

        log.debug("fieldWithTypes: {}", fieldWithTypes.keySet());

        // getFields().forEach(f -> {
        //     if (fieldWithTypes.containsKey(f.getName())) {
        //         f.setJavaType("String");
        //         f.setSqlType("VARCHAR(20)");
        //         f.setType("type-id");
        //         f.setFieldDigest(fieldWithTypes.get(f.getName()));
        //     }
        // });

        // if the entity build with combine-keys, then add a new primary field.
        if (combine) {
            getFields().add(FieldMeta.builder()
                    .name("id")
                    .type("id")
                    // .javaType("Long")
                    // .sqlType("BIGINT auto_increment")
                    .fieldTypeDef(types.get("id"))
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

        if (isHeadEntity()) {
            getFields().add(FieldMeta.builder()
                    .name("tenantId")
                    .type("id")
                    // .javaType("Long")
                    // .sqlType("BIGINT auto_increment")
                    .javaType("String")
                    .sqlType("VARCHAR(20)")
                    .stringLength(20)
                    .col("TENANT_ID")
                    .pk(false)
                    .notNull(false)
                    .autoCreatedInternal(true)
                    .autoInc(false)
                    .build());

            getRelations().add(RelationMeta.builder()
                    .name("Tenant")
                    .relEntityName("Tenant")
                    .type("one")
                    .title("")
                    .fkName("TENANT_FK")
                    .keymap(KeymapMeta.builder()
                            .fieldName("tenantId")
                            .relFieldName("tenantId")
                            .build())
                    .build());
        }
        //
        // fields.stream().filter(f -> f.pk).forEach(f -> {
        //     f.setAutoInc(true);
        //     f.setType("id");  // ????????????????????????
        //     f.setJavaType("Long");
        //     f.setSqlType("BIGINT");
        // });
    }

    public String getFlatMessageType() {
        if (HeadEntityResources.contains(name)) {
            return name + "FlatData";
        }
        return getMessageType();
    }

    public String getMessageType() {
        return name + "Data";
    }

    @Data
    @Builder
    public static class RelationQueryMeta {
        String relationFieldName;  // ??????relation???????????????proto?????????
        String relationEntity;
        List<String> fieldNames;
        boolean repeated;

        public List<String> getTableFields() {
            return fieldNames.stream().map(f -> Util.toSnakecase(f))
                    .collect(Collectors.toList());
        }
    }

    public List<RelationQueryMeta> getRelationQueries() {
        return relations.stream().filter(r -> r.hasProtoDef(name))
                .map(r -> RelationQueryMeta.builder()
                        .relationFieldName(Util.toSnakecase(r.name))
                        .relationEntity(r.getRelEntityName())
                        .fieldNames(r.getRelFieldList())
                        .repeated(r.isRepeated())
                        .build())
                .collect(Collectors.toList());
    }

    public Optional<RelationMeta> findRelation(String relationName) {
        return relations.stream().filter(r -> r.getName().equals(relationName))
                .findFirst();
    }

    public Optional<RelationMeta> findRelationByProtoName(String relationName) {
        return relations.stream().filter(r -> r.getProtoName().equals(relationName))
                .findFirst();
    }

    public List<RelationMeta> findRelationsByField(String fieldName,
                                                   String... relationType) {
        if (relationType.length == 0) {
            return Lists.newArrayList();
        }
        Set<String> types = Sets.newHashSet(relationType);
        return relations.stream()
                .filter(r -> r.getRelFieldList().contains(fieldName)
                        && types.contains(r.type))
                .collect(Collectors.toList());
    }

    public List<RelationMeta> getValidRelations() {
        Set<String> ents = MetaTypes.getAllEntities();
        return relations.stream()
                .filter(r -> ents.contains(r.getRelEntityName()))
                .collect(Collectors.toList());
    }


    public String getAnnotation(FieldMeta fld) {
        List<String> annotations = getAnnotationList(fld);
        return String.join("\n\t", annotations);
    }

    public List<String> getAnnotationList(FieldMeta fld) {
        List<String> annotations = Lists.newArrayList();

        annotations.add(format("@SerializedName(\"%s\")", fld.getSerializeName()));
        if (getPk().equals(fld.name)) {
            annotations.add("@RId");
        } else if (fld.pk && !fld.isDateTimeField()) {
            annotations.add("@RIndex");
        }
        return annotations;
    }

    public String getFacets() {
        List<String> facets = Lists.newArrayList("Serializable");
        if (isHeadEntity()) {
            facets.add("WithSuppliers");
        }
        if (getField("geoPointId").isPresent()) {
            facets.add("WithLocation");
        }
        // tempExprId
        if (getField("tempExprId").isPresent()) {
            facets.add("WithSchedule");
        }
        // WithDescription
        if (getField("description").isPresent()) {
            facets.add("WithDescription");
        }
        Set<String> periodFields = Sets.newHashSet("fromDate", "thruDate");
        if (getFieldNames().containsAll(periodFields)) {
            facets.add("WithPeriod");
        }
        return String.join(", ", facets);
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
        private FieldMappings.FieldTypeDef fieldTypeDef;

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

        public boolean isDateTimeField() {
            return MetaTypeUtil.DATETIME_TYPES.contains(type);
        }

        public boolean isNumericField() {
            return MetaTypeUtil.NUMERIC_TYPES.contains(type);
        }

        public boolean isDecimalField() {
            return MetaTypeUtil.DECIMAL_TYPES.contains(type);
        }

        public boolean isBlobField() {
            return MetaTypeUtil.BLOB_TYPES.contains(type);
        }

        public boolean isManualField() {
            return MetaTypeUtil.MANUAL_TYPES.contains(type);
        }

        public boolean isRawTextField() {
            return type.endsWith("-varchar") || type.startsWith("very-");
        }

        // public String getUnderscore() {
        //     return Util.toSnakecase(this.name);
        // }
        public String getUnderscore() {
            return col.toLowerCase(Locale.ROOT);
        }

        public String getPlural(){
            return Inflector.getInstance().pluralize(getUnderscore());
        }

        public String getSerializeName(){
            String prop=getUnderscore();
            if(prop.endsWith("user_login")){
                return prop+"_id";
            }
            return prop;
        }

        public String getProtoType() {
            return MetaTypeUtil.getProtoType(this.type);
        }

        public boolean isCreateTs() {
            return name.equals("createdStamp");
        }

        public boolean isUpdateTs() {
            return name.equals("lastUpdatedStamp");
        }

        public boolean isIndicator() {
            return type.equals("indicator");
        }

        public String getSetter() {
            return format("set%s", fixedClassName());
        }

        public String getGetter() {
            return format("get%s", Util.toClassName(name));
        }

        public String valuePart(String rawValue) {
            String value = format("\"%s\"", rawValue.replace('"', '\''));
            String valuePart;
            switch (type) {
                case "date-time":
                    valuePart = format("getTimestamp(%s)", value);
                    break;
                case "date":
                    valuePart = format("getDate(%s)", value);
                    break;
                case "time":
                    valuePart = format("getTimeOfDay(%s)", value);
                    break;
                case "indicator":
                    valuePart = format("castIndicator(%s)", value);
                    break;
                case "currency-amount":
                case "currency-precise":
                    valuePart = format("getCurrency(%s)", value);
                    break;
                case "fixed-point":
                    valuePart = format("getFixedPoint(%s)", value);
                    break;
                case "byte-array":
                case "blob":
                case "object":
                    valuePart = format("ByteString.copyFrom(%s)", value);
                    break;

                default:
                    if (name.endsWith("FormatPattern")) {
                        value = StringUtils.replace(value, "\\", "\\\\");
                    }
                    valuePart = isNumericField() ? filterNum(rawValue) : value;
            }
            return valuePart;
        }

        private String filterNum(String rawValue) {
            if (rawValue.contains(".")) {
                return rawValue;
            } else if (rawValue.startsWith("0")) {
                try {
                    return String.format("%d", Integer.parseInt(rawValue));
                } catch (NumberFormatException e) {
                    log.warn("fail to filter-num with integer: {}", rawValue);
                    throw e;
                }
            }
            return rawValue;
        }

        public String getProtoSetter() {
            String valuePart;
            String name=getGetter()+"()";
            switch (type) {
                case "date-time":
                    valuePart = format("getTimestamp(%s)", name);
                    break;
                case "date":
                    valuePart = format("getDate(%s)", name);
                    break;
                case "time":
                    valuePart = format("getTimeOfDay(%s)", name);
                    break;
                case "indicator":
                    valuePart = format("getIndicator(%s)", name);
                    break;
                case "currency-amount":
                case "currency-precise":
                    valuePart = format("getCurrency(%s)", name);
                    break;
                case "fixed-point":
                    valuePart = format("getFixedPoint(%s)", name);
                    break;
                case "byte-array":
                case "blob":
                case "object":
                    valuePart = format("ByteString.copyFrom(%s)", name);
                    break;
                // case "url":
                //     valuePart= format("%s.toString()", name);
                //     break;
                default:
                    valuePart = name;
            }
            return format("set%s(%s)", fixedClassName(), valuePart);
        }

        public String getProtoGetter() {
            // data.getLastName()
            // getLocalDate(data.getBirthDate())
            String getter = format("data.get%s()", fixedClassName());
            switch (type) {
                case "date-time":
                    return format("getLocalDateTime(%s)", getter);
                case "date":
                    return format("getLocalDate(%s)", getter);
                case "time":
                    return format("getTime(%s)", getter);
                case "indicator":
                    return format("getIndicatorChar(%s)", getter);
                case "currency-amount":
                case "currency-precise":
                case "fixed-point":
                    return format("getBigDecimal(%s)", getter);
                case "byte-array":
                case "blob":
                case "object":
                    return format("%s.toByteArray()", getter);
                // case "url":
                //     return format("new URI(%s)", getter);
                default:
                    return getter;
            }
        }

        static final Map<String, String> FIXTURES = ImmutableMap.of(
                "reserv2ndPPPerc", "Reserv2NdPPPerc");

        String fixedClassName() {
            // reserv2ndPPPerc
            if (FIXTURES.containsKey(this.name)) {
                return FIXTURES.get(name);
            }
            return Util.toClassName(name);
        }

        @SneakyThrows
        public String getDartTemplate() {
            String tpl = "fld_default.j2";
            if (MetaTypeUtil.FLOAT_TYPES.contains(type)) {
                tpl = "fld_double.j2";
            } else if (MetaTypeUtil.INT_TYPES.contains(type)) {
                tpl = "fld_int.j2";
            } else if (type.equals("date-time") || type.equals("date")) {
                tpl = "fld_date_time.j2";
            } else if (type.equals("time")) {
                tpl = "fld_time.j2";
            }
            return TemplateUtil.build("templates/fe/" + tpl,
                    ImmutableMap.of("fld", this));
        }

        public String getDartSetter() {
            if (MetaTypeUtil.FLOAT_TYPES.contains(type)
                    || MetaTypeUtil.INT_TYPES.contains(type)
                    || type.equals("date-time")
                    || type.equals("date")
                    || type.equals("time")) {
                return name + "Str";
            }
            return name;
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
            String prefix = this.type.equals(REL_MANY) ? "repeated " : "";
            // return String.format("%s %sData %s", prefix, relEntityName,
            //         Util.toSnakecase(title) + "_" + Util.toSnakecase(name));
            return format("%s%sData %s", prefix, relEntityName, getProtoName());
        }

        public String getProtoName() {
            return Util.toSnakecase(name);
        }

        public String getPlural(){
            return Inflector.getInstance().pluralize(getProtoName());
        }

        public String getPrefix() {
            return prefix(getProtoName()) + type.charAt(0);
        }

        public String getVarName() {
            return Util.toVarName(name);
        }

        public String getRelVarName() {
            return "rel" + name;
        }

        public String getBeanRelGetter() {
            return "getRel" + name;
        }

        public static String getRelVarNameByRelation(String relUnderscore) {
            return "rel" + Util.lowerSnakeToCamel(relUnderscore);
        }

        public String getTableName() {
            return Util.toSnakecase(relEntityName);
        }

        public boolean isRepeated() {
            return this.type.equals("many");
        }

        public boolean hasProtoDef(String entityName) {
            HeadEntity headEntity = HeadEntityResources.get(entityName);
            if (headEntity != null) {
                return !headEntity.getFlatIds().contains(this.relEntityName);
            }
            return false; // not head-entity
        }

        public String getMainRelField() {
            return keymaps.get(0).fieldName;
        }

        public String getMainTargetField() {
            return keymaps.get(0).relFieldName;
        }

        public String getMainTargetCol() {
            return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
                    keymaps.get(0).relFieldName);
        }

        public String getRelFields() {
            return keymaps.stream().map(k -> k.fieldName)
                    .collect(Collectors.joining(" + "));
        }

        public List<String> getRelFieldList() {
            return keymaps.stream().map(k -> k.fieldName)
                    .collect(Collectors.toList());
        }

        public List<String> getTargetFieldList() {
            return keymaps.stream().map(k -> k.relFieldName)
                    .collect(Collectors.toList());
        }

        public String getConstantDef() {
            return String.format("public static final String %s " +
                            "= \"%s\"; // %s",
                    getUpperSnake(), getProtoName(), type);
        }

        public String getUpperSnake() {
            return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, name);
        }

        public String getRelationOp() {
            String prefix = type.equals("many") ? "add" : "set";
            return prefix + name;
        }

        public String getRelGetter() {
            return "getRel" + name;
        }

        public boolean isHeadEntity() {
            return HeadEntityResources.contains(this.relEntityName);
        }

        public String getBuildClause() {
            // String conv=isHeadEntity()?String.format("(%sData)", relEntityName):"";
            return String.format("%s el.to%sBuilder().build()",
                    "", isHeadEntity() ? "Head" : "Data");
        }

        public String getToBuilder() {
            return String.format("to%sBuilder", isHeadEntity() ? "Head" : "Data");
        }
    }

    @Data
    @Builder
    public static class KeymapMeta {
        String fieldName;
        String relFieldName;

        public String getProtoField() {
            return Util.toSnakecase(fieldName);
        }

        public String getProtoRelField() {
            return Util.toSnakecase(relFieldName);
        }

    }
}
