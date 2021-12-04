package com.bluecc.income.procs;

import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.fund.DataSetUtil;
import com.google.common.collect.Multimap;
import com.google.protobuf.Message;

import javax.inject.Inject;

import static com.bluecc.hubs.feed.ProtoModule.startup;
import static com.bluecc.income.procs.GenericProcs.loadDataSet;

public class TypeEntityProcs {
    public static void main(String[] args) {
        TypeEntityProcs typeEntityProcs=startup(TypeEntityProcs.class);
        long cost=typeEntityProcs.publishSeedFiles();
        System.out.format("total %d, cost %d ms\n", typeEntityProcs.total, cost);
        System.exit(0);
    }

    @Inject
    FactBag factBag;
    int total;
    public long publishSeedFiles() {
        long start = System.currentTimeMillis();
        total=0;
        DataSetUtil.seedFiles("dataset/seed").forEach(f -> {
            publish(f.getAbsolutePath());
        });

        return System.currentTimeMillis() - start;
    }

    public void publish(String source) {
        Multimap<String, Message> dataMap = loadDataSet(source);
        dataMap.asMap().forEach((k, v) -> {
            v.forEach(e -> {
                factBag.putEntityData(k, e);
                total++;
            });
        });
    }
}
