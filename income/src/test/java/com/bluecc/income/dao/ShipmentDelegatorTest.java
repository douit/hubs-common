package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ShipmentFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ShipmentDelegatorTest extends AbstractStoreProcTest {
    @Inject ShipmentDelegator shipments;

    @Before
    public void setUp() throws Exception {
        setupEntities("Shipment");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ShipmentFlatData flatData= ShipmentFlatData.newBuilder()
                    .setShipmentId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, shipments.create(ctx, flatData));
            assertEquals(1, shipments.update(ctx, flatData));
            assertEquals(1, shipments.find(ctx, flatData).size());
            assertEquals(1, shipments.findById(ctx, flatData).size());
            assertEquals(1, shipments.delete(ctx, flatData));
            assertEquals(0, shipments.find(ctx, flatData).size());
        });
    }
}
