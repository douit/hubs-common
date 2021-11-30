package com.bluecc.income.dao;

import com.bluecc.hubs.stub.OrderItemFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class OrderItemDelegatorTest extends AbstractStoreProcTest {
    @Inject OrderItemDelegator orderItems;

    @Before
    public void setUp() throws Exception {
        setupEntities("OrderItem");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            OrderItemFlatData flatData= OrderItemFlatData.newBuilder()
                    .setId(newId)
                    .setOrderId("o_123")
                    .setOrderItemSeqId("001")
                    .setComments(faker.hipster().word())
                    .build();
            assertEquals(1, orderItems.create(ctx, flatData));
            assertEquals(1, orderItems.update(ctx, flatData));
            assertEquals(1, orderItems.find(ctx, flatData).size());
            assertEquals(1, orderItems.findById(ctx, flatData).size());
            assertEquals(1, orderItems.delete(ctx, flatData));
            assertEquals(0, orderItems.find(ctx, flatData).size());
        });
    }
}
