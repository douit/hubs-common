package com.bluecc.hubs.fund;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.*;

import java.util.Map;
import java.util.Set;

import static com.bluecc.hubs.fund.MetaTypes.metaList;

public class EntityMetaProcessors {

    public enum FacetType{
        PeriodFacet
    }
    public static class Facet{
        public Set<FacetType> facets= Sets.newHashSet();
    }
    Map<String, Facet> facetMap= Maps.newHashMap();

    public void processRelations(EntityMeta meta) {
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

    public void collapseFields(EntityMeta meta) {
        Set<String> periodFields= Sets.newHashSet("fromDate", "thruDate");
        if(meta.getFieldNames().containsAll(periodFields)){
            // meta.getFields().removeIf(f -> periodFields.contains(f.getName()));
            addFacet(meta.name, FacetType.PeriodFacet);
        }
    }

    void addFacet(String ent, FacetType facetType){
        Facet facet=facetMap.get(ent);
        if(facet==null){
            facet=new Facet();
            facetMap.put(ent, facet);
        }
        facet.facets.add(facetType);
    }
}
