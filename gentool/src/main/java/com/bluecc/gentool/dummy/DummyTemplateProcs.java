package com.bluecc.gentool.dummy;

import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.common.Tuple2;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static com.bluecc.gentool.dummy.DummyMeta.partyMeta;

/**
 * $ just gen dummy.DummyTemplateProcs
 */
public class DummyTemplateProcs {
    public static void main(String[] args) {
        DummyTemplateProcs procs=new DummyTemplateProcs();
        procs.proc(partyMeta);
    }

    Map<Tuple2<String, String>, String> templateRepos = Maps.newHashMap();
    Set<String> ignoreFields = Sets.newHashSet("last_updated_tx_stamp", "created_tx_stamp");

    void proc(EntityMeta table){
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("ent", table);
        String codeBean = buildWithTemplate("bean", "bean_source.j2",
                jinjava, table, context);
    }

    String buildWithTemplate(String tplName, String tplSource,
                                     Jinjava jinjava, EntityMeta table,
                                     Map<String, Object> context) {
        String renderedTemplate = null;
        try {
            String template = Resources.toString(Resources
                            .getResource("templates/" + tplSource),
                    Charsets.UTF_8);
            renderedTemplate = jinjava.render(template, context);
            System.out.println(renderedTemplate);

            templateRepos.put(Tuple2.of(table.getName(), tplName), renderedTemplate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        return renderedTemplate;
    }
}
