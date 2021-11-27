package com.bluecc.income.types;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.fund.MetaTypes;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * $ just i types.EntityMetaProcs -f types
 */
public class EntityMetaProcs {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = {"--fn", "-f"})
        String fn="info";
        @Parameter
        public List<String> entities = Lists.newArrayList();
    }

    public static void main(String[] args) {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        switch (opts.fn){
            case "types":
                MetaTypes.types().getEntities()
                        .stream().sorted()
                        .forEach(e -> System.out.println(e));
                break;
            default:
                System.out.println("special a fn to execute.");
                break;
        }
    }
}
