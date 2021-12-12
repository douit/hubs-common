package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ProductCategoryMemberFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ProductCategoryMemberDelegatorTest extends AbstractStoreProcTest {
    @Inject ProductCategoryMemberDelegator productCategoryMembers;

    @Before
    public void setUp() throws Exception {
        setupEntities("ProductCategoryMember");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ProductCategoryMemberFlatData flatData= ProductCategoryMemberFlatData.newBuilder()
                    .setId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, productCategoryMembers.create(ctx, flatData));
            assertEquals(1, productCategoryMembers.update(ctx, flatData));
            assertEquals(1, productCategoryMembers.find(ctx, flatData).size());
            assertEquals(1, productCategoryMembers.findById(ctx, flatData).size());
            assertEquals(1, productCategoryMembers.delete(ctx, flatData));
            assertEquals(0, productCategoryMembers.find(ctx, flatData).size());
        });
    }
}
