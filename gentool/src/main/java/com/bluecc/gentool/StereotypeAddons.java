package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.bluecc.gentool.StereotypeTool.datafileWriter;
import static com.bluecc.gentool.StereotypeTool.datasetWriter;

/**
 * $ just gen StereotypeAddons -f dataset/accounting/PaymentApplicationTestsData.xml
 * $ just gen StereotypeAddons -t stub/src/main/java/com/bluecc/hubs/livecases dataset/livecases
 */
public class StereotypeAddons {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        // example: "dataset/accounting/PaymentApplicationTestsData.xml"
        @Parameter(names = {"--file", "-f"})
        String file;
        @Parameter(names = {"--target-dir", "-t"})
        String targetDir="/opt/gen/stereotypes";
        @Parameter
        public List<String> sourceDirs = Lists.newArrayList();
    }
    public static void main(String[] args) throws IOException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        if(opts.file!=null) {
            datafileWriter(new File(opts.file),
                    opts.targetDir, "", true, "stereotypes");
        }

        // stub/src/main/java/com/bluecc/hubs/livecases
        for (String sourceDir : opts.sourceDirs) {
            datasetWriter(sourceDir, opts.targetDir, "", true, "livecases");
        }
    }

    public static void startGen() throws IOException {
        String sourceDir="dataset/livecases";
        String targetDir="stub/src/main/java/com/bluecc/hubs/livecases";
        datasetWriter(sourceDir, targetDir, "", true, "livecases");
    }

}
