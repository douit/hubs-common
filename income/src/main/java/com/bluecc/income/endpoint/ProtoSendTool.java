package com.bluecc.income.endpoint;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.bluecc.hubs.fund.Sequence;
import com.bluecc.hubs.stereotypes.StereoDemoConfigurator;
import com.bluecc.hubs.stub.ContentData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;

import static java.lang.Thread.sleep;

/**
 * $ just i endpoint.ProtoSendTool -u product
 * $ just i endpoint.ProtoSendTool -u receiver
 */
public class ProtoSendTool {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Opts {
        @Parameter(names = {"--silent", "-s"})
        boolean silent;
        @Parameter(names = {"--topic", "-t"})
        String topic="protoEvents";
        @Parameter(names = {"--subject", "-u"})
        String subject="product";
    }
    public static void main(String[] args) throws InterruptedException {
        Opts opts = new Opts();
        JCommander.newBuilder()
                .addObject(opts)
                .build()
                .parse(args);

        Sequence sequence=new Sequence();
        ProtoSender protoSender=new ProtoSender();
        switch (opts.subject) {
            case "product":
                protoSender.send(opts.topic, "", StereoDemoConfigurator.Product_CPU_586);
                break;
            case "receiver":
                new ProtoReceiver().receive(Collections.singletonList(opts.topic));
                break;
            default:
                protoSender.send(opts.topic, "", ContentData.newBuilder()
                                .setContentId(sequence.nextStringId())
                                .setLocaleString("你好")
                        .build());
        }

        sleep(2000);
        System.exit(0);
    }
}
