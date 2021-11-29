package com.bluecc.gentool;

import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.HeadEntityResources;
import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.Util;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

import static com.bluecc.gentool.GenModule.startup;

/**
 * $ just gen GenHeadEntities
 */
public class GenHeadEntities {
    public static void main(String[] args) {
        GenHeadEntities genHeadEntities=startup(GenHeadEntities.class);
        genHeadEntities.startGen();
    }

    @Inject
    GenConfig conf;
    void startGen(){
        HeadEntityResources.allHeads().forEach(e -> {
            try {
                String cnt= TemplateUtil.sourceGen(e, "bean", true);
                Util.writeFile(cnt, conf.prependModelFile(e+".java"));

                cnt= TemplateUtil.sourceGen(e, "dao_decl", true);
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
}
