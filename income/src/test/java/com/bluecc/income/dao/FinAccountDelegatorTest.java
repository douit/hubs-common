package com.bluecc.income.dao;

import com.bluecc.hubs.stub.FinAccountFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class FinAccountDelegatorTest extends AbstractStoreProcTest {
    @Inject FinAccountDelegator finAccounts;

    @Before
    public void setUp() throws Exception {
        setupEntities("FinAccount");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            FinAccountFlatData flatData= FinAccountFlatData.newBuilder()
                    .setFinAccountId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, finAccounts.create(ctx, flatData));
            assertEquals(1, finAccounts.update(ctx, flatData));
            assertEquals(1, finAccounts.find(ctx, flatData).size());
            assertEquals(1, finAccounts.findById(ctx, flatData).size());
            assertEquals(1, finAccounts.delete(ctx, flatData));
            assertEquals(0, finAccounts.find(ctx, flatData).size());
        });
    }
}
