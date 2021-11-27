package com.bluecc.income.exchange;

import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.ShipmentData;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;

public class SeedResources {
    public static void main(String[] args) throws IOException {
        printResource("order_head_simple", OrderHeaderData.newBuilder());
        printResource("order_head_product", OrderHeaderData.newBuilder());
        printResource("shipment_simple", ShipmentData.newBuilder());
    }

    public static void printResource(String jsonName, GeneratedMessageV3.Builder<?> builder) throws IOException {
        String json= IOUtils.toString(requireNonNull(SeedResources.class.getResource(
                "/data/" + jsonName + ".json")), StandardCharsets.UTF_8);
        JsonFormat.parser().merge(json, builder);
        System.out.println(builder.build());
    }
}
