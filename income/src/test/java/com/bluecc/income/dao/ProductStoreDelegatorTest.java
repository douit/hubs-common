package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProductStoreDelegatorTest extends AbstractStoreProcTest {
    @Inject ProductStoreDelegator productStores;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductStore");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProductStoreFlatData flatData= ProductStoreFlatData.newBuilder()
                    .setProductStoreId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productStores.create(ctx, flatData));
            assertEquals(1, productStores.update(ctx, flatData));
            assertEquals(1, productStores.find(ctx, flatData).size());
            assertEquals(1, productStores.findById(ctx, flatData).size());
            assertEquals(1, productStores.delete(ctx, flatData));
            assertEquals(0, productStores.find(ctx, flatData).size());
        });
    }
}
