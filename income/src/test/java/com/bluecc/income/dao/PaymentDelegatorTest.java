package com.bluecc.income.dao;

import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class PaymentDelegatorTest extends AbstractStoreProcTest {
    @Inject PaymentDelegator payments;

    @Before
    public void setUp() throws Exception {
        setupEntities("Payment");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            PaymentFlatData flatData= PaymentFlatData.newBuilder()
                    .setPaymentId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, payments.create(ctx, flatData));
            assertEquals(1, payments.update(ctx, flatData));
            assertEquals(1, payments.find(ctx, flatData).size());
            assertEquals(1, payments.findById(ctx, flatData).size());
            assertEquals(1, payments.delete(ctx, flatData));
            assertEquals(0, payments.find(ctx, flatData).size());
        });
    }
}
