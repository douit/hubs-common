package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

public interface IMapDataCollector {
    @Data
    @AllArgsConstructor
    public static class CollectorContext{
        MessageMapCollector collector;
        INameSymbol symbol;
        Message parentMsg;
        Descriptors.FieldDescriptor parentFld;
    }
    void collect(CollectorContext ctx, Map<String, Object> dataMap);
}

