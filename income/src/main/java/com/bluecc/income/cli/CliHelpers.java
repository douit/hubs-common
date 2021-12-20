package com.bluecc.income.cli;

import com.beust.jcommander.JCommander;

public class CliHelpers {
    public static ICmd.Opts runOpts(String[] args){
        ICmd.Opts opts = new ICmd.Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);
        System.out.println("opts: "+opts);
        return opts;
    }
}
