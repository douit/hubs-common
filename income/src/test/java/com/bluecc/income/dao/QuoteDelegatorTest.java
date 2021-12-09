package com.bluecc.income.dao;

import com.bluecc.hubs.stub.QuoteFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class QuoteDelegatorTest extends AbstractStoreProcTest {
    @Inject QuoteDelegator quotes;

    @Before
    public void setUp() throws Exception {
        setupEntities("Quote");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            QuoteFlatData flatData= QuoteFlatData.newBuilder()
                    .setQuoteId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, quotes.create(ctx, flatData));
            assertEquals(1, quotes.update(ctx, flatData));
            assertEquals(1, quotes.find(ctx, flatData).size());
            assertEquals(1, quotes.findById(ctx, flatData).size());
            assertEquals(1, quotes.delete(ctx, flatData));
            assertEquals(0, quotes.find(ctx, flatData).size());
        });
    }
}
