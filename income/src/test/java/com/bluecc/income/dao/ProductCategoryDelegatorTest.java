package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProductCategoryDelegatorTest extends AbstractStoreProcTest {
    @Inject ProductCategoryDelegator productCategorys;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductCategory");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProductCategoryFlatData flatData= ProductCategoryFlatData.newBuilder()
                    .setProductCategoryId(newId)
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productCategorys.create(ctx, flatData));
            assertEquals(1, productCategorys.update(ctx, flatData));
            assertEquals(1, productCategorys.find(ctx, flatData).size());
            assertEquals(1, productCategorys.findById(ctx, flatData).size());
            assertEquals(1, productCategorys.delete(ctx, flatData));
            assertEquals(0, productCategorys.find(ctx, flatData).size());
        });
    }
}
