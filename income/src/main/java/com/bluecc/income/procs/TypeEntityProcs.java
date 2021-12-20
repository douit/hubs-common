package com.bluecc.income.procs;

import com.bluecc.hubs.feed.FactBag;
import com.bluecc.hubs.fund.DataSetUtil;
import com.bluecc.hubs.fund.MetaTypes;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.StatusItemData;
import com.google.common.collect.Multimap;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

import static com.bluecc.hubs.feed.ProtoModule.startup;
import static com.bluecc.income.procs.GenericProcs.loadDataSet;

/**
 * $ just i procs.TypeEntityProcs
 */
public class TypeEntityProcs {
    public static void main(String[] args) {
        TypeEntityProcs typeEntityProcs=startup(TypeEntityProcs.class);

        // clear all maps
        typeEntityProcs.clearAllMaps();

        // publish seeds
        long cost=typeEntityProcs.publishSeedFiles(true);
        System.out.format("total %d, cost %d ms\n", typeEntityProcs.total, cost);
        System.exit(0);
    }

    @Inject
    FactBag factBag;
    @Inject
    ProtoMeta protoMeta;

    int total;

    public void clearAllMaps(){
        MetaTypes.types().getEntities().forEach(e -> factBag.clearMap(e));
    }
    public long publishSeedFiles(boolean clear) {
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

    // Queries

    public EnumerationData getEnumeration(String enumId) throws InvalidProtocolBufferException {
        EnumerationData.Builder typeBuilder=EnumerationData.newBuilder();
        factBag.getEntityData(enumId, typeBuilder);
        return typeBuilder.build();
    }

    public List<EnumerationData> getAllEnumerations(String typeId){
        return factBag.allTypes("Enumeration", EnumerationData::parseFrom)
                .stream().filter(e -> e.getEnumTypeId().equals(typeId))
                .collect(Collectors.toList());
    }

    public List<Tuple2<String, String>> getAllEnumerationIds(String typeId){
        return getAllEnumerations(typeId)
                .stream().map(e -> Tuple2.of(e.getEnumId(), e.getDescription()))
                .collect(Collectors.toList());
    }

    public List<Tuple2<String, String>> getAllEnumerationIdsBySample(String enumId) throws InvalidProtocolBufferException {
        EnumerationData e=getEnumeration(enumId);
        return getAllEnumerationIds(e.getEnumTypeId());
    }
}
