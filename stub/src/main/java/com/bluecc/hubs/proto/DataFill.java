package com.bluecc.hubs.proto;

import com.bluecc.hubs.fund.EntityMeta;
import com.google.protobuf.Descriptors;

import java.util.Map;

public class DataFill {
    Descriptors.Descriptor type;
    EntityMeta meta;
    public DataFill(Descriptors.Descriptor type, EntityMeta meta) {
        this.type = type;
        this.meta=meta;
    }

    public void fillData(Map<String, String> data) {

    }
}
