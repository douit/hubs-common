package com.bluecc.hubs;
import com.bluecc.hubs.fund.JsonString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import java.io.IOException;

public class ProtoJsonUtils {
    public static String toJson(Message sourceMessage){
        try {
            return JsonFormat.printer().print(sourceMessage);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonString toJsonString(Message sourceMessage){
        return JsonString.string(toJson(sourceMessage));
    }

    public static Message toProtoBean(Message.Builder targetBuilder, String json) throws IOException {
        JsonFormat.parser().merge(json, targetBuilder);
        return targetBuilder.build();
    }
}
