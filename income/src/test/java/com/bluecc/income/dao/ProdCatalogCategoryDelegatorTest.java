package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProdCatalogCategoryFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProdCatalogCategoryDelegatorTest extends AbstractStoreProcTest {
    @Inject ProdCatalogCategoryDelegator prodCatalogCategorys;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProdCatalogCategory");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProdCatalogCategoryFlatData flatData= ProdCatalogCategoryFlatData.newBuilder()
                    .setId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, prodCatalogCategorys.create(ctx, flatData));
            assertEquals(1, prodCatalogCategorys.update(ctx, flatData));
            assertEquals(1, prodCatalogCategorys.find(ctx, flatData).size());
            assertEquals(1, prodCatalogCategorys.findById(ctx, flatData).size());
            assertEquals(1, prodCatalogCategorys.delete(ctx, flatData));
            assertEquals(0, prodCatalogCategorys.find(ctx, flatData).size());
        });
    }
}
