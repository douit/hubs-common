package com.bluecc.income.procs;

import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericProcsTest extends AbstractStoreProcTest {
    @Before
    public void setUp() throws Exception {
        setupEntities("Person");
    }

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            PersonFlatData flatData= PersonFlatData.newBuilder()
                    .setPartyId(newId)
                    .setLastName("samlet")
                    .setFirstName("wu")
                    .build();
            assertEquals(1, genericProcs.create(ctx, flatData));
            assertEquals(1, genericProcs.update(ctx, flatData));
            assertEquals(1, genericProcs.find(ctx, flatData).size());
            assertEquals(1, genericProcs.findById(ctx, flatData).size());
            assertEquals(1, genericProcs.delete(ctx, flatData));
            assertEquals(0, genericProcs.find(ctx, flatData).size());
        });
    }
}