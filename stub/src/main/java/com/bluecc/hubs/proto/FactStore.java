package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import com.bluecc.hubs.fund.Tuple2;
import com.bluecc.hubs.stub.Envelope;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;

import java.util.List;
import java.util.stream.Collectors;

public class FactStore {

    public Envelope queryData(String listName, GeneratedMessageV3 msg, EntityMeta.RelationQueryMeta queryMeta){
        Descriptors.Descriptor descriptor=msg.getDescriptorForType();
        List<Tuple2<String, Object>> params=queryMeta.getFieldNames().stream().map(p -> {
            Object qval=msg.getField(descriptor.findFieldByName(p));
            return new Tuple2<String, Object>(p, qval);
        }).collect(Collectors.toList());

        // sharedData.getClient().getList(listName).stream().filter(e -> )
        return null;
    }
}
