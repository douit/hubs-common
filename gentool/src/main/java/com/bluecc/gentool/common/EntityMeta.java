package com.bluecc.gentool.common;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class EntityMeta {
    String name;
    @Singular
    List<FieldMeta> fields= Lists.newArrayList();
    @Singular
    List<RelationMeta> relations=Lists.newArrayList();
    int pksSize;
    List<String> pks=Lists.newArrayList();
    boolean isView;

    @Data
    @Builder
    public static class FieldMeta{
        String name;
        String type;

        /** The java-type of the Field */
        private String javaType;
        /** The sql-type of the Field */
        private String sqlType;
        /** The sql-type-alias of the Field, this is optional */
        private String sqlTypeAlias;
        Integer stringLength;

        String col;
        boolean pk;
        boolean notNull;
        boolean encrypt;
        boolean autoCreatedInternal;
        List<String> validators= Lists.newArrayList();
    }

    @Data
    @Builder
    public static class RelationMeta{
        String name;
        String type;
        String relEntityName;
        String fkName;
        @Singular
        List<KeymapMeta> keymaps=Lists.newArrayList();
        boolean autoRelation;
    }

    @Data
    @Builder
    public static class KeymapMeta{
        String fieldName;
        String relFieldName;
    }
}
