package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProductStoreFacilityFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProductStoreFacilityDelegatorTest extends AbstractStoreProcTest {
    @Inject ProductStoreFacilityDelegator productStoreFacilitys;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductStoreFacility");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProductStoreFacilityFlatData flatData= ProductStoreFacilityFlatData.newBuilder()
                    .setId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productStoreFacilitys.create(ctx, flatData));
            assertEquals(1, productStoreFacilitys.update(ctx, flatData));
            assertEquals(1, productStoreFacilitys.find(ctx, flatData).size());
            assertEquals(1, productStoreFacilitys.findById(ctx, flatData).size());
            assertEquals(1, productStoreFacilitys.delete(ctx, flatData));
            assertEquals(0, productStoreFacilitys.find(ctx, flatData).size());
        });
    }
}
