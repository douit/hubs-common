package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

public class GenProfile {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter
        public List<String> profiles = Lists.newArrayList("livecases");
    }

    public static void main(String[] args) throws IOException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        for (String profile : opts.profiles) {
            switch (profile){
                case "livecases":
                    StereotypeAddons.startGen();
                    break;
                default:
                    System.out.println("Cannot execute profile "+profile);
            }
        }
    }
}
