package com.bluecc.gentool;

import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.*;
import com.google.common.collect.ImmutableMap;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.bluecc.gentool.GenModule.startup;
import static com.bluecc.hubs.fund.MetaTypes.typeList;

/**
 * $ just gen GenHeadEntities
 */
public class GenHeadEntities {
    public static void main(String[] args) throws IOException {
        GenHeadEntities genHeadEntities=startup(GenHeadEntities.class);
        genHeadEntities.genAll();
    }

    public static void startGen() throws IOException {
        new GenHeadEntities(new GenConfig()).genAll();
    }

    GenConfig conf;
    @Inject
    GenHeadEntities(GenConfig conf){
        this.conf=conf;
    }

    public void genAll() throws IOException {
        genHeads();
        genBean(MetaTypes.getNonHeadEntities());
    }

    void genHeads(){
        HeadEntityResources.allHeads().forEach(e -> {
            try {
                genBean(e);
                String cnt;

                cnt= genDao(e, "dao_decl", true);
                Util.writeFile(cnt, conf.prependDaoFile(e+"Delegator.java"));

                File targetFile=conf.prependDaoTestFile(e+"DelegatorTest.java");
                if(!targetFile.exists()) {
                    cnt = TemplateUtil.sourceGen(e, "dao_test", true);
                    Util.writeFile(cnt, targetFile);
                }else{
                    System.out.println(".. ignore exists test-file -> "+targetFile);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex.getMessage(), ex);
            }
        });
    }

    public static String genDao(String entName, String tplName, boolean remap) throws IOException {
        EntityMeta meta= EntityMetaManager.getEntityMeta(entName, remap);
        String querySource=TemplateUtil.build("templates/dao_query_source.j2",
                ImmutableMap.of("ent", meta));
        return TemplateUtil.build("templates/"+ tplName +"_source.j2",
                ImmutableMap.of("ent", meta, "query_rels", querySource));
    }

    public void genBean(Collection<String> ents) throws IOException {
        for (String e : ents) {
            String conv_part = TemplateUtil.sourceGen(e, "bean_conv", true);
            // String cnt= TemplateUtil.sourceGen(e, "bean", true);
            EntityMeta meta = EntityMetaManager.getEntityMeta(e, true);
            String head_part ="";
            if(meta.isHeadEntity()){
                head_part = genHeadPart(e);
            }
            String cnt = TemplateUtil.build("templates/bean_source.j2",
                    ImmutableMap.of("ent", meta,
                            "conv_part", conv_part,
                            "head_part", head_part));
            Util.writeFile(cnt, conf.prependModelFile(e + ".java"));
        }
    }
    public void genBean(String... ents) throws IOException {
        genBean(Arrays.asList(ents));
    }

    EntityMetaProcessors metaProcessors=new EntityMetaProcessors();
    private String genHeadPart(String e) throws IOException {
        // String head_part = TemplateUtil.sourceGen(e, "bean_conv_head", true);
        // return head_part;
        EntityMeta meta= EntityMetaManager.getEntityMeta(e, true);
        // EntityMetaDigester digester=new EntityMetaDigester(meta, typeList);
        // setup the entity-meta-info
        metaProcessors.processRelations(meta);

        return TemplateUtil.build("templates/bean_conv_head_source.j2",
                ImmutableMap.of("ent", meta ));
    }
}
