package com.bluecc.income.dao;

import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class PartyDelegatorTest extends AbstractStoreProcTest {
    @Inject PartyDelegator partyDelegator;

    @Before
    public void setUp() throws Exception {
        setupEntities("Party");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            PartyFlatData flatData= PartyFlatData.newBuilder()
                    .setPartyId(newId)
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, partyDelegator.create(ctx, flatData));
            assertEquals(1, partyDelegator.update(ctx, flatData));
            assertEquals(1, partyDelegator.find(ctx, flatData).size());
            assertEquals(1, partyDelegator.findById(ctx, flatData).size());
            assertEquals(1, partyDelegator.delete(ctx, flatData));
            assertEquals(0, partyDelegator.find(ctx, flatData).size());
        });
    }
}
