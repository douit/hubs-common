package com.bluecc.saga;

import com.bluecc.hubs.fund.Util;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;

public class ResourceHelper {
    public static GeneratedMessageV3.Builder<?> readResourceFromFile(
            String file, GeneratedMessageV3.Builder<?> builder) {
        String json = null;
        try {
            json = Util.readFile(file);
            JsonFormat.parser().merge(json, builder);
            return builder;
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new RuntimeException("Read protobuf fail: " + file
                    + ", cause: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read resource " + file, e);
        }

    }

    public static GeneratedMessageV3.Builder<?> readResource(
            String jsonName, GeneratedMessageV3.Builder<?> builder) {
        String json = null;
        try {
            json = IOUtils.toString(requireNonNull(ResourceHelper.class.getResource(
                    "/data/" + jsonName + ".json")), StandardCharsets.UTF_8);
            JsonFormat.parser().merge(json, builder);
            return builder;
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new RuntimeException("Read protobuf fail: " + jsonName
                    + ", cause: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read resource " + jsonName, e);
        }

    }
}
