package com.bluecc.income.dao;

import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.github.javafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class InvoiceDelegatorTest extends AbstractStoreProcTest {
    @Inject InvoiceDelegator invoices;

    @Before
    public void setUp() throws Exception {
        setupEntities("Invoice");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            InvoiceFlatData flatData= InvoiceFlatData.newBuilder()
                    .setInvoiceId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, invoices.create(ctx, flatData));
            assertEquals(1, invoices.update(ctx, flatData));
            assertEquals(1, invoices.find(ctx, flatData).size());
            assertEquals(1, invoices.findById(ctx, flatData).size());
            assertEquals(1, invoices.delete(ctx, flatData));
            assertEquals(0, invoices.find(ctx, flatData).size());
        });
    }
}
