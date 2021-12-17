package com.bluecc.hubs.fund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

public class InspectMeta {
    public enum RelationTags{
        skip, normal
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    // @Accessors(fluent = true)
    public static class RelationMark{
        String name;
        String entityName;
        String relationType;
        List<String> bindFields;
        List<String> tags;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EntityInspect{
        String name;
        List<RelationMark> relationMarks;

        /**
         * Example code:
         * <pre>
         *     protoMeta.getInspectMeta("Product")
         *                 .getValidRelationNames()
         *                 .forEach(e -> System.out.println(e));
         * </pre>
         * @return relation names in snake-case
         */
        public List<String> getValidRelationNames(){
            return getRelationMarks().stream()
                    .filter(r -> !r.getTags().contains("skip"))
                    .map(e -> Util.toSnakecase(e.name))
                    .collect(Collectors.toList());
        }
    }
}
