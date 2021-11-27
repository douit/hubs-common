package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.TemplateUtil;

import java.io.IOException;

/**
 * $ just gen TemplateGen -t dao_sql -e Person
 * $ just gen TemplateGen -t bean -e Person
 */
public class TemplateGen {
    @Parameter(names = {"--template", "-t"})
    String template="dao_sql";
    @Parameter(names = {"--entity", "-e"})
    String entity="OrderItem";
    public static void main(String[] args) throws IOException {
        TemplateGen main = new TemplateGen();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        String cnt= TemplateUtil.sourceGen(main.entity, main.template, true);
        System.out.println(cnt);
    }
}
