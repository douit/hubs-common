package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProdCatalogFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProdCatalogDelegatorTest extends AbstractStoreProcTest {
    @Inject ProdCatalogDelegator prodCatalogs;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProdCatalog");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProdCatalogFlatData flatData= ProdCatalogFlatData.newBuilder()
                    .setProdCatalogId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, prodCatalogs.create(ctx, flatData));
            assertEquals(1, prodCatalogs.update(ctx, flatData));
            assertEquals(1, prodCatalogs.find(ctx, flatData).size());
            assertEquals(1, prodCatalogs.findById(ctx, flatData).size());
            assertEquals(1, prodCatalogs.delete(ctx, flatData));
            assertEquals(0, prodCatalogs.find(ctx, flatData).size());
        });
    }
}
