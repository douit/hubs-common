package com.bluecc.gentool;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.gentool.common.TemplateUtil;
import com.bluecc.hubs.fund.ModelTransition;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.Map;

/**
 * $ just gen StatusTool -t Order
 */
public class StatusTool {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = {"--status", "-t"})
        String status="Order";
    }

    public static void main(String[] args) throws IOException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        ModelTransition modelTransition=new ModelTransition();
        ModelTransition.ObjectStatus objectStatus= modelTransition.getTransitions(opts.status);
        Map<String,Object> ctx=ImmutableMap.of("actor", objectStatus.getTransitions(),
                "sink", "ConsolePrinter",
                "top", objectStatus);

        String cnt=TemplateUtil.build("templates/actor_event_source.j2", ctx);
        System.out.println(cnt);
        System.out.println("--------------------");
        cnt=TemplateUtil.build("templates/actor_transitions_source.j2", ctx);
        System.out.println(cnt);
    }
}
