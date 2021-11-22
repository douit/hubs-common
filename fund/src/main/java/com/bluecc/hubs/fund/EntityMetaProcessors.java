package com.bluecc.hubs.fund;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.bluecc.hubs.fund.MetaTypes.metaList;

public class EntityMetaProcessors {

    public static void processRelations(EntityMeta meta) {
        meta.getRelations().removeIf(r -> !metaList.has(r.getRelEntityName()));
        // 清除关联对象对应在的字段id
        for (EntityMeta.RelationMeta relation : meta.getRelations()) {
            if(relation.hasProtoDef(meta.getName()) && !relation.getType().equals("many")){
                meta.getFields().removeIf(f -> !f.isPk() &&
                        f.getName().equals(relation.getMainRelField()));
            }
        }

        collapseFields(meta);
    }

    public static void collapseFields(EntityMeta meta) {
        Set<String> periodFields= Sets.newHashSet("fromDate", "thruDate");
        if(meta.getFieldNames().containsAll(periodFields)){
            // meta.getFields().removeIf(f -> periodFields.contains(f.getName()));
            meta.getFacet().getFacets().add(EntityMeta.FacetType.PeriodFacet);
        }
    }
}
