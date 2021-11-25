package com.bluecc.income.exchange;

import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

public interface IMapDataCollector {
    @Data
    @AllArgsConstructor
    public static class CollectorContext{
        INameSymbol symbol;
        GeneratedMessageV3 parentMsg;
        Descriptors.FieldDescriptor parentFld;
    }
    void collect(CollectorContext ctx, Map<String, Object> dataMap);
}

