package com.bluecc.income.dao;

import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class OrderHeaderDelegatorTest extends AbstractStoreProcTest {
    @Inject OrderHeaderDelegator orderHeaders;

    @Before
    public void setUp() throws Exception {
        setupEntities("OrderHeader");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            OrderHeaderFlatData flatData= OrderHeaderFlatData.newBuilder()
                    .setOrderId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, orderHeaders.create(ctx, flatData));
            assertEquals(1, orderHeaders.update(ctx, flatData));
            assertEquals(1, orderHeaders.find(ctx, flatData).size());
            assertEquals(1, orderHeaders.findById(ctx, flatData).size());
            assertEquals(1, orderHeaders.delete(ctx, flatData));
            assertEquals(0, orderHeaders.find(ctx, flatData).size());
        });
    }
}
