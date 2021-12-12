package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProductCategoryRollupDelegatorTest extends AbstractStoreProcTest {
    @Inject ProductCategoryRollupDelegator productCategoryRollups;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductCategoryRollup");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProductCategoryRollupFlatData flatData= ProductCategoryRollupFlatData.newBuilder()
                    .setId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productCategoryRollups.create(ctx, flatData));
            assertEquals(1, productCategoryRollups.update(ctx, flatData));
            assertEquals(1, productCategoryRollups.find(ctx, flatData).size());
            assertEquals(1, productCategoryRollups.findById(ctx, flatData).size());
            assertEquals(1, productCategoryRollups.delete(ctx, flatData));
            assertEquals(0, productCategoryRollups.find(ctx, flatData).size());
        });
    }
}
