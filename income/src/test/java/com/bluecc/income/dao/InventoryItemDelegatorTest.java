package com.bluecc.income.dao;

import com.bluecc.hubs.stub.InventoryItemFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class InventoryItemDelegatorTest extends AbstractStoreProcTest {
    @Inject InventoryItemDelegator inventoryItems;

    @Before
    public void setUp() throws Exception {
        setupEntities("InventoryItem");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            InventoryItemFlatData flatData= InventoryItemFlatData.newBuilder()
                    .setInventoryItemId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, inventoryItems.create(ctx, flatData));
            assertEquals(1, inventoryItems.update(ctx, flatData));
            assertEquals(1, inventoryItems.find(ctx, flatData).size());
            assertEquals(1, inventoryItems.findById(ctx, flatData).size());
            assertEquals(1, inventoryItems.delete(ctx, flatData));
            assertEquals(0, inventoryItems.find(ctx, flatData).size());
        });
    }
}
