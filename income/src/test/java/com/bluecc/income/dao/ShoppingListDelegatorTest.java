package com.bluecc.income.dao;

import com.bluecc.hubs.stub.ShoppingListFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ShoppingListDelegatorTest extends AbstractStoreProcTest {
    @Inject ShoppingListDelegator shoppingLists;

    @Before
    public void setUp() throws Exception {
        setupEntities("ShoppingList");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            ShoppingListFlatData flatData= ShoppingListFlatData.newBuilder()
                    .setShoppingListId(newId)
                    .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, shoppingLists.create(ctx, flatData));
            assertEquals(1, shoppingLists.update(ctx, flatData));
            assertEquals(1, shoppingLists.find(ctx, flatData).size());
            assertEquals(1, shoppingLists.findById(ctx, flatData).size());
            assertEquals(1, shoppingLists.delete(ctx, flatData));
            assertEquals(0, shoppingLists.find(ctx, flatData).size());
        });
    }


}
