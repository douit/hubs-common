package com.bluecc.hubs.fund;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

public class MetaTypeUtil {
    public static final Map<String, String> PROTO_TYPE_MAP = ImmutableMap.of(
            "id", "string",
            "blob", "bytes", "byte-array", "bytes", "object", "bytes",
            "floating-point", "double", "integer", "int32",
            "numeric", "int64",
            "date-time", "google.protobuf.Timestamp",
            "date", "google.type.Date",
            "time", "google.type.TimeOfDay"
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

    // public static final Map<String, String[]> IGNORE_FIELDS=ImmutableMap.of(
    //         "Person", new String[]{"oldMaritalStatus"}
    // );
    public static final Set<String> DATETIME_TYPES=
            Sets.newHashSet("date-time", "date", "time");
    public static final Set<String> BLOB_TYPES=
            Sets.newHashSet("blob", "byte-array", "object");

    public static final Set<String> NUMERIC_TYPES=
            Sets.newHashSet("floating-point", "double", "integer", "int32",
                    "numeric", "int64");
    public static final Set<String> DECIMAL_TYPES=
            Sets.newHashSet("currency-amount", // DECIMAL(18,2)
                    "currency-precise", // DECIMAL(18,3)
                    "fixed-point" // DECIMAL(18,6)
            );
    public static final Set<String> MANUAL_TYPES=
            Sets.newHashSet("comment", "description", "name", "value",
                    "credit-card-number", "credit-card-date", "email", "url", "tel-number"
            );
}
