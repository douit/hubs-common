package com.bluecc.income.dao;

import com.bluecc.hubs.stub.BillingAccountFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class BillingAccountDelegatorTest extends AbstractStoreProcTest {
    @Inject BillingAccountDelegator billingAccounts;

    @Before
    public void setUp() throws Exception {
        setupEntities("BillingAccount");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            BillingAccountFlatData flatData= BillingAccountFlatData.newBuilder()
                    .setBillingAccountId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, billingAccounts.create(ctx, flatData));
            assertEquals(1, billingAccounts.update(ctx, flatData));
            assertEquals(1, billingAccounts.find(ctx, flatData).size());
            assertEquals(1, billingAccounts.findById(ctx, flatData).size());
            assertEquals(1, billingAccounts.delete(ctx, flatData));
            assertEquals(0, billingAccounts.find(ctx, flatData).size());
        });
    }
}
