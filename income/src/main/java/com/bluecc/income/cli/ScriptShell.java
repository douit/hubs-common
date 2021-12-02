package com.bluecc.income.cli;

import java.io.IOException;

/**
 * $ just i cli.ScriptShell
 */
public class ScriptShell {
    public static void main(String[] args) throws IOException {
        org.mvel2.sh.Main.main(args);
    }
}
