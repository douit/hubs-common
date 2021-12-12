package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProductStoreCatalogFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProductStoreCatalogDelegatorTest extends AbstractStoreProcTest {
    @Inject ProductStoreCatalogDelegator productStoreCatalogs;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductStoreCatalog");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProductStoreCatalogFlatData flatData= ProductStoreCatalogFlatData.newBuilder()
                    .setId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productStoreCatalogs.create(ctx, flatData));
            assertEquals(1, productStoreCatalogs.update(ctx, flatData));
            assertEquals(1, productStoreCatalogs.find(ctx, flatData).size());
            assertEquals(1, productStoreCatalogs.findById(ctx, flatData).size());
            assertEquals(1, productStoreCatalogs.delete(ctx, flatData));
            assertEquals(0, productStoreCatalogs.find(ctx, flatData).size());
        });
    }
}
