package com.bluecc.income.procs;

import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProductsTest extends AbstractStoreProcTest {
    @Inject Products products;

    @Before
    public void setUp() throws Exception {
        setupEntities("Product");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProductFlatData flatData= ProductFlatData.newBuilder()
                    .setProductId(newId)
                    .setProductName(faker.commerce().productName())
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, products.create(ctx, flatData));
            assertEquals(1, products.update(ctx, flatData));
            assertEquals(1, products.find(ctx, flatData).size());
            assertEquals(1, products.findById(ctx, flatData).size());
            assertEquals(1, products.delete(ctx, flatData));
            assertEquals(0, products.find(ctx, flatData).size());
        });
    }
}
