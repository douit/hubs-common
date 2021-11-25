package com.bluecc.income.proto;

import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.ShipmentData;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class ProtoSourceTest {
    public static URL getOrderFile() {
        return ProtoSourceTest.class.getResource("/data/order_head_simple.json");
    }

    @Test
    public void testOrderSimple() throws IOException {
        String json= IOUtils.toString(getOrderFile(), StandardCharsets.UTF_8);
        OrderHeaderData.Builder builder= OrderHeaderData.newBuilder();
        JsonFormat.parser().merge(json, builder);
        OrderHeaderData data=builder.build();
        System.out.println(data);
        // data.getAllFields().entrySet().stream().filter((f,v)-> f.getKey().get)
        data.getAllFields()
                .forEach((f,v) -> System.out.println(f.getName()));
    }

    @Test
    public void testPrintProto() throws IOException {
        printResource("order_head_simple", OrderHeaderData.newBuilder());
        printResource("order_head_product", OrderHeaderData.newBuilder());
        printResource("shipment_simple", ShipmentData.newBuilder());
    }

    void printResource(String jsonName, GeneratedMessageV3.Builder<?> builder) throws IOException {
        String json= IOUtils.toString(requireNonNull(ProtoSourceTest.class.getResource(
                "/data/" + jsonName + ".json")), StandardCharsets.UTF_8);
        JsonFormat.parser().merge(json, builder);
        System.out.println(builder.build());
    }

    @Test
    public void testProtoToMap(){
        PersonFlatData personFlatData= PersonFlatData.newBuilder()
                .setLastName("s")
                .setFirstName("joe").build();

    }
}
