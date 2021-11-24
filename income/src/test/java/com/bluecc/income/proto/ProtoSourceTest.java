package com.bluecc.income.proto;

import com.bluecc.hubs.stub.OrderHeaderData;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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
    }
}
