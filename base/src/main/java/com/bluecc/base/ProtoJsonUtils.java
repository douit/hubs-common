package com.bluecc.base;
import com.google.gson.Gson;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import java.io.IOException;
public class ProtoJsonUtils {
    public static String toJson(Message sourceMessage)
            throws IOException {
        return JsonFormat.printer().print(sourceMessage);
    }

    public static Message toProtoBean(Message.Builder targetBuilder, String json) throws IOException {
        JsonFormat.parser().merge(json, targetBuilder);
        return targetBuilder.build();
    }
}
