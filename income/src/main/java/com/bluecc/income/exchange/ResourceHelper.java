package com.bluecc.income.exchange;

import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;

public class ResourceHelper {
    public static void readResource(String jsonName, GeneratedMessageV3.Builder<?> builder) throws IOException {
        String json= IOUtils.toString(requireNonNull(ResourceHelper.class.getResource(
                "/data/" + jsonName + ".json")), StandardCharsets.UTF_8);
        JsonFormat.parser().merge(json, builder);
    }
}
