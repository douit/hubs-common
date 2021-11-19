package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.common.EntityMetaDigester;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * $ just gen MetaTool OrderHeader OrderItem
 * $ just gen MetaTool -o Party
 */
public class MetaTool {
    @Parameter
    public List<String> entities = Lists.newArrayList("OrderHeader");
    @Parameter(names = {"--only-show-type-ref", "-o"})
    boolean onlyShowTypeRef=false;
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
        EntityMetaDigester digester=new EntityMetaDigester(meta, EntityMetaManager.typeList);
        Set<String> relFields=digester.getFieldDigestMap().keySet();

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
                        System.out.print("▒▒ " + entry.getKey() + ": "
                                + fieldDigest.getTypeRef().getEntityType()
                                +"("+ (fieldDigest.getRelType().equals("many") ?"*":"1")+")");
                        if(!fieldDigest.getTitle().isEmpty()) {
                            System.out.format(" [%s]", fieldDigest.getTitle());
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
}
