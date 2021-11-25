package com.bluecc.hubs.fund;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MetaTypeUtil {
    public static final Map<String, String> PROTO_TYPE_MAP = ImmutableMap.of(
            "id", "string",
            "blob", "bytes", "byte-array", "bytes", "object", "bytes",
            "floating-point", "double", "integer", "int32",
            "numeric", "int64",
            "date-time", "google.protobuf.Timestamp",
            "date", "google.protobuf.Timestamp",
            "time", "google.protobuf.Timestamp"
    );
    public static final Map<String, String> PROTO_CUSTOM_MAP = ImmutableMap.of(
            "indicator", "routines.Indicator",
            "currency-amount", "routines.Currency", // DECIMAL(18,2)
            "currency-precise", "routines.Currency", // DECIMAL(18,3)
            "fixed-point", "routines.FixedPoint" // DECIMAL(18,6)
    );

    public static String getProtoType(String fieldType) {
        return PROTO_TYPE_MAP.getOrDefault(fieldType,
                PROTO_CUSTOM_MAP.getOrDefault(fieldType,
                        "string"));
    }

}
