package com.bluecc.income.dao;

import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class InvoiceItemDelegatorTest extends AbstractStoreProcTest {
    @Inject InvoiceItemDelegator invoiceItems;

    @Before
    public void setUp() throws Exception {
        setupEntities("InvoiceItem");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            InvoiceItemFlatData flatData= InvoiceItemFlatData.newBuilder()
                    .setId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, invoiceItems.create(ctx, flatData));
            assertEquals(1, invoiceItems.update(ctx, flatData));
            assertEquals(1, invoiceItems.find(ctx, flatData).size());
            assertEquals(1, invoiceItems.findById(ctx, flatData).size());
            assertEquals(1, invoiceItems.delete(ctx, flatData));
            assertEquals(0, invoiceItems.find(ctx, flatData).size());
        });
    }
}
