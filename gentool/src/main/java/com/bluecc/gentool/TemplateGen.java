package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.fund.TemplateUtil;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

/**
 * $ just gen TemplateGen -t dao_sql -e Person
 * $ just gen TemplateGen -t bean -e Person
 * $ just gen TemplateGen -t dao_test -e PartyGroup -c true
 */
public class TemplateGen {
    @Parameter(names = {"--template", "-t"})
    String template="dao_sql";
    @Parameter(names = {"--entity", "-e"})
    String entity="OrderItem";
    @Parameter(
            names = { "--clip", "-c" },
            arity = 1
    )
    boolean clip = false;

    public static void main(String[] args) throws IOException {
        TemplateGen main = new TemplateGen();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        String cnt= TemplateUtil.sourceGen(main.entity, main.template);
        System.out.println(cnt);
        if(main.clip) {
            clip(cnt);
        }
    }

    static void clip(String text){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }
}
