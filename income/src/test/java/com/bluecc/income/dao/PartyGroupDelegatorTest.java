package com.bluecc.income.dao;

import com.bluecc.hubs.stub.PartyGroupFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class PartyGroupDelegatorTest extends AbstractStoreProcTest {
    @Inject PartyGroupDelegator partyGroups;

    @Before
    public void setUp() throws Exception {
        setupEntities("PartyGroup");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            PartyGroupFlatData flatData= PartyGroupFlatData.newBuilder()
                    .setPartyId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, partyGroups.create(ctx, flatData));
            assertEquals(1, partyGroups.update(ctx, flatData));
            assertEquals(1, partyGroups.find(ctx, flatData).size());
            assertEquals(1, partyGroups.findById(ctx, flatData).size());
            assertEquals(1, partyGroups.delete(ctx, flatData));
            assertEquals(0, partyGroups.find(ctx, flatData).size());
        });
    }
}
