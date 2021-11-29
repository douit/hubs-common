package com.bluecc.income.dao;

import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class PersonDelegatorTest extends AbstractStoreProcTest {
    @Inject PersonDelegator persons;

    @Before
    public void setUp() throws Exception {
        setupEntities("Person");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            PersonFlatData flatData= PersonFlatData.newBuilder()
                    .setPartyId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, persons.create(ctx, flatData));
            assertEquals(1, persons.update(ctx, flatData));
            assertEquals(1, persons.find(ctx, flatData).size());
            assertEquals(1, persons.findById(ctx, flatData).size());
            assertEquals(1, persons.delete(ctx, flatData));
            assertEquals(0, persons.find(ctx, flatData).size());
        });
    }
}
