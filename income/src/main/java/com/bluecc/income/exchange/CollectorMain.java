package com.bluecc.income.exchange;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.stub.ShipmentData;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;

import static com.bluecc.income.dummy.store.StoreModule.startup;
import static com.bluecc.income.exchange.MessageMapCollector.collect;
import static com.bluecc.income.exchange.ResourceHelper.readResource;

public class CollectorMain {
    public static void main(String[] args) throws IOException {
        CollectorMain main = startup(CollectorMain.class);
        main.execute();
        // new CollectorMain().execute();
    }

    @Inject
    ProtoMeta protoMeta;

    public void execute() throws IOException {
        collect((c, e) -> {
            System.out.println("Ⓜ️ " + c.symbol + " -> " + e);
            if (c.parentFld != null) {
                // 需要字段id与关联对象名的映射, 才能够将子对象的id设置到父对象相应的字段上,
                //      在保存父对象时, 才能同时保存父子对象的关系.
                // 两种方式可以用来保存映射关系: 一是protobuf的options,
                // 二是在symbol中(用其它常量类也可以)建立relation->field反查表

                String entityType = ProtoTypes.getEntityTypeByMessage(c.parentMsg);
                EntityMeta.RelationQueryMeta queryMeta = protoMeta.findRelationQueryMeta(
                        entityType, c.parentFld.getName());

                System.out.format("\tresult to: %s -> %s\n",
                        c.parentFld.getName(),
                        queryMeta.getTableFields());

                // TODO save child
                String idval = "_";

                // c.getCollector()获取的是父对象的实例, 每一级的每个父对象都是新的collector实例
                // 所以每一级父对象可以收集齐子对象的关联字段(一般就是新id值)
                c.getCollector().putResult(c.parentFld.getName(),
                        queryMeta.getTableFields(), idval);
            }else {
                System.out.println("current result context:");
                c.getCollector().getResultContext().forEach((k, v) -> {
                    System.out.println("\t"+k+": "+v);
                });
                // TODO save parent
                String idval = "_";

                c.getCollector().putResult("_id_",
                        c.getSymbol().getTableKeys(), idval);
            }
        }).fillMap(readResource("shipment_simple",
                        ShipmentData.newBuilder())
                        .build())
                .forEach((k, v) -> {
                    System.out.println(k+": "+v);
                });
    }
}

