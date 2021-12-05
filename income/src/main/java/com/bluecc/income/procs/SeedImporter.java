package com.bluecc.income.procs;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.bluecc.income.dummy.store.StoreModule.startup;

public class SeedImporter {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = {"--file", "-f"})
        String file="dataset/accounting/PaymentApplicationTestsData.xml";
    }
    public static void main(String[] args) {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);
        GenericProcs genericProcs=startup(GenericProcs.class);
        genericProcs.process(c -> {
            genericProcs.storeDataFile(c, opts.file);
        });
    }
}
