package com.bluecc.gentool.common;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class NameUtil {
    public static final Map<String, String> PROTO_TYPE_MAP= ImmutableMap.of(
            "id", "string",
            "blob", "bytes", "byte-array", "bytes", "object", "bytes",
            "floating-point", "double", "integer", "int32",
            "numeric", "int64"
    );

    public static String getProtoType(String fieldType){
        return PROTO_TYPE_MAP.getOrDefault(fieldType, "string");
    }
}
