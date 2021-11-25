package com.bluecc.income.exchange;

import com.bluecc.hubs.stub.ShipmentData;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static com.bluecc.income.exchange.ResourceHelper.readResource;
import static org.junit.Assert.*;

public class MessageMapCollectorTest {

    @Test
    public void fillMap() throws IOException {
        MessageMapCollector collector=new MessageMapCollector((symbol, e) -> {
            System.out.println(e);
        });
        // Map<String, Object> values= Maps.newHashMap();
        ShipmentData.Builder builder=ShipmentData.newBuilder();
        readResource("shipment_simple", builder);
        collector.fillMap(builder.build());
    }
}
