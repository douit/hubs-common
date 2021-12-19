package com.bluecc.hubs.fund;

import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import javax.inject.Singleton;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.bluecc.hubs.fund.TypeMappers.digestMapper;
import static java.lang.String.format;

@Singleton
public class ProtoMeta {


    Map<String, EntityMeta> metaMap = Maps.newHashMap();
    Map<String, InspectMeta.EntityInspect> inspectMetas = Maps.newHashMap();
    Map<String, TypeMappers.TypeMapper> typeMapperMap=Maps.newHashMap();

    public Map<String, EntityMeta> getMetaMap() {
        return metaMap;
    }

    public EntityMeta getEntityMeta(String entityName) {
        EntityMeta meta = metaMap.get(entityName);
        if (meta == null) {
            synchronized (ProtoMeta.class) {
                meta = EntityMetaManager.readEntityMeta(entityName);
                metaMap.put(entityName, meta);
            }
        }
        return meta;
    }

    public TypeMappers.TypeMapper getTypeMapper(String typeName){
        return typeMapperMap.computeIfAbsent(typeName, e->{
            return digestMapper(typeName, this);
        });
    }

    public SqlMeta getSqlMeta(String entityName) {
        return getSqlMeta(entityName, false);
    }

    public SqlMeta getSqlMeta(String entityName, boolean succ) {
        return new SqlMeta(this, getEntityMeta(entityName), succ);
    }

    public List<EntityMeta> getHeadEntities(){
        return HeadEntityResources.allHeads().stream().map(e -> getEntityMeta(e))
                .collect(Collectors.toList());
    }

    public EntityMeta.RelationQueryMeta findRelationQueryMeta(String entityName, String relField) {
        List<EntityMeta.RelationQueryMeta> rels = getEntityMeta(entityName).getRelationQueries();
        for (EntityMeta.RelationQueryMeta rel : rels) {
            if (rel.getRelationFieldName().equals(relField)) {
                return rel;
            }
        }
        return null;
    }

    Yaml yaml = new Yaml();

    public InspectMeta.EntityInspect getInspectMeta(String entityName) {
        InspectMeta.EntityInspect inspectMeta = inspectMetas.computeIfAbsent(entityName, key ->
        {
            try {
                return yaml.loadAs(new FileReader(
                                SystemDefs.prependHubsHomeFile(format("asset/inspect/%s.yml", entityName))),
                        InspectMeta.EntityInspect.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return inspectMeta;
    }

    public InspectMeta.EntityInspect buildInspectMeta(String entityName) {
        EntityMeta meta = getEntityMeta(entityName);
        // skip, multi, single, assoc
        List<InspectMeta.RelationMark> marks = meta.getValidRelations()
                .stream().sorted(Comparator.comparing(e -> e.getRelEntityName()))
                // .peek( e -> System.out.println(e.getName()))
                .map(e -> InspectMeta.RelationMark.builder()
                        .name(e.getName())
                        .relationType(e.getType())
                        .entityName(e.getRelEntityName())
                        .bindFields(e.getRelFieldList())
                        .tags(Collections.singletonList("skip"))
                        .build()
                )
                .collect(Collectors.toList());
        InspectMeta.EntityInspect inspect = InspectMeta.EntityInspect.builder()
                .name(meta.getName())
                .relationMarks(marks)
                .build();
        return inspect;
    }

}

