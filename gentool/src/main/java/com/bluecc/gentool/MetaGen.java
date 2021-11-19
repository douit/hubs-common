package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.EntityMeta;
import com.bluecc.gentool.dummy.DummyTemplateProcs;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.io.Writer;
import java.util.List;


/**
 * $ just gen MetaGen Person
 */
public class MetaGen extends MetaGenBase{
    @Parameter
    public List<String> entities = Lists.newArrayList("Person");
    @Parameter(names = {"--template", "-t"})
    String template="meta_source";

    public static void main(String[] args) throws IOException {
        MetaGen main = new MetaGen();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

        main.multiGen(main.entities, main.template, null);
    }

}

