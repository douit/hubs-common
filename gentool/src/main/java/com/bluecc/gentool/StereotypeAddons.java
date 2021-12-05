package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

import static com.bluecc.gentool.StereotypeTool.datafileWriter;

/**
 * $ just gen StereotypeAddons
 */
public class StereotypeAddons {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = {"--file", "-f"})
        String file="dataset/accounting/PaymentApplicationTestsData.xml";
    }
    public static void main(String[] args) throws IOException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        String targetDir="stub/src/main/java/com/bluecc/hubs/stereotypes";
        datafileWriter(new File(opts.file),
                targetDir, "");
    }
}
