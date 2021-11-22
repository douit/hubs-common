package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.fund.*;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.bluecc.hubs.fund.MetaTypes.typeList;

/**
 * $ just gen MetaTool OrderHeader OrderItem
 * $ just gen MetaTool -o Party
 */
public class MetaTool {
    @Parameter
    public List<String> entities = Lists.newArrayList("OrderHeader");
    @Parameter(names = {"--only-show-type-ref", "-o"})
    boolean onlyShowTypeRef=false;
    MetaTypes.MetaList metaList= DataSetUtil.getAvailableEntities();
    public static void main(String[] args) {
        MetaTool main = new MetaTool();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

        EntityMetaManager entityMetaManager=new EntityMetaManager();
        main.entities.forEach(e -> {
            EntityMeta meta=entityMetaManager.getEntityMeta(e);
            main.digest(meta);
            System.out.println("=====================");
        });
    }

    public void digest(EntityMeta meta) {
        EntityMetaDigester digester=new EntityMetaDigester(meta, typeList);
        Set<String> relFields=digester.getFieldDigestMap().keySet();

        System.out.format("%s: %s\n", meta.getName(), meta.getTitle());
        System.out.println("primary: "+meta.getPks());
        System.out.println("--------------");
        meta.getFields().stream()
                .filter(f -> !relFields.contains(f.getName()))
                .forEach(f -> System.out.format("%s %s %s\n",
                        f.getName(), f.getSqlType(), f.getJavaType()));
        System.out.println("--------------");


        for (Map.Entry<String, Collection<EntityMetaDigester.FieldDigest>> entry : digester.getFieldDigestMap().asMap().entrySet()) {
            for (EntityMetaDigester.FieldDigest fieldDigest : entry.getValue()) {
                if (fieldDigest.getRefType() == EntityMetaDigester.RefType.TYPE_REF) {
                    System.out.println("■■ " + entry.getKey() + ": " + fieldDigest.getTypeRef().getEntityType());
                } else {
                    if(!onlyShowTypeRef) {
                        String entityName=fieldDigest.getTypeRef().getEntityType();
                        System.out.print("▒▒ " + entry.getKey() + ": "
                                + entityName
                                +"("+ (fieldDigest.getRelType().equals("many") ?"*":"1")+")");
                        if(!fieldDigest.getTitle().isEmpty()) {
                            System.out.format(" [%s]", fieldDigest.getTitle());
                        }
                        if(!metaList.has(entityName)){
                            System.out.print(" 🆓");
                        }else{
                            System.out.print(" ✳️");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
