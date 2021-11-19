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
    public static void main(String[] args) throws IOException {
        DummyTemplateProcs procs = new DummyTemplateProcs();
        procs.procBean(partyMeta, "bean_source.j2");
    }

    Map<Tuple2<String, String>, String> templateRepos = Maps.newHashMap();
    Set<String> ignoreFields = Sets.newHashSet("last_updated_tx_stamp", "created_tx_stamp");

    public String procBean(EntityMeta table, String template) throws IOException {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("ent", table);
        return buildWithTemplate("bean", template,
                jinjava, table, context);
    }

    public String procCrud(EntityMeta table) throws IOException {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("ent", table);
        return buildWithTemplate("crud", "crud_source.j2",
                jinjava, table, context);
    }

    public String procSql(String sqlMode, EntityMeta table) throws IOException {
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("table", table);
        if(sqlMode.equals("mysql")) {
            context.put("engine", "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4");
        }else{
            context.put("engine", "");
        }
        String code = buildWithTemplate("mysql", "mysql_idx_source.j2",
                jinjava, table, context);
        return code;
    }

    String buildWithTemplate(String tplName, String tplSource,
                             Jinjava jinjava, EntityMeta table,
                             Map<String, Object> context) throws IOException {
        String renderedTemplate = null;

        String template = Resources.toString(Resources
                        .getResource("templates/" + tplSource),
                Charsets.UTF_8);
        renderedTemplate = jinjava.render(template, context);
        // System.out.println(renderedTemplate);

        templateRepos.put(Tuple2.of(table.getName(), tplName), renderedTemplate);

        return renderedTemplate;
    }
}
