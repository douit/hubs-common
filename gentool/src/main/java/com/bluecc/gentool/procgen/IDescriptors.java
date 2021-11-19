package com.bluecc.gentool.procgen;

import com.bluecc.gentool.descriptor.EntityNames;
import com.google.common.collect.Sets;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface IDescriptors {
    @Data
    @Builder
    public static class DaoDescriptor {
        String name;

        EntityNames master;
        @Singular
        List<EntityNames> sigulars;
        @Singular
        List<EntityNames> details;

        @Singular
        List<String> attrs;
    }

    @Data
    @Builder
    public static class DaoDescriptors {
        String daoName;
        EntityNames base;

        @Singular
        List<DaoDescriptor> items;

        public Set<String> getInfers(){
            Set<String> result= Sets.newHashSet();
            items.forEach(item -> {
                result.add(item.master.entityName);
                result.addAll(item.sigulars.stream()
                        .map(e -> e.entityName)
                        .collect(Collectors.toList()));
                result.addAll(item.details.stream()
                        .map(e -> e.entityName)
                        .collect(Collectors.toList()));
            });
            return result;
        }
    }

    Descriptors.DaoDescriptors paramObjects();
}
