package com.bluecc.hubs.fund;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

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
    }
}
