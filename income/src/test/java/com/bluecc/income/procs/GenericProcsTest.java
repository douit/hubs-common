package com.bluecc.income.procs;

import com.bluecc.hubs.stub.Identity;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.OrderHeader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;
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


    @Test
    public void testStoreDataFile() {
        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            genericProcs.storeDataFile(c, sourceSalesOrder);
            List<Map<String, Object>> rs= genericProcs.find(c, ProductFlatData.newBuilder()
                    .setProductId("GZ-1001")
                    .build());
            assertFalse(rs.isEmpty());
        });
    }

    @Test
    public void testFind() {
        process(c -> {
            // Dao dao = c.getHandle().attach(// Dao.class);
            OrderHeader rec=genericProcs.findOne(c, Identity.newBuilder()
                    .setType("OrderHeader")
                    .setValue("Demo1001")
                    .build(), OrderHeader.class);
            pretty(rec);
            assertNotNull(rec);
        });
    }
}