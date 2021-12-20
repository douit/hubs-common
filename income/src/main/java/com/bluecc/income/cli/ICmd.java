package com.bluecc.income.cli;

import com.beust.jcommander.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ICmd {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = "--help", help = true)
        private boolean help;
        @Parameter(names = {"--profile", "-p"})
        String profile="default";
    }

    void execute(Opts globalOpts) throws InterruptedException;
}
