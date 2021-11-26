package com.bluecc.domain.generic.procs;

import com.bluecc.domain.sql.model.Invoice;
import com.bluecc.domain.sql.model.InvoiceItem;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InvoiceProcsTest extends AbstractProcsTest{
    @Inject
    InvoiceProcs invoiceProcs;
    int roundingMode = BigDecimal.ROUND_HALF_UP;
    int decimalScale = 2;

    @Before
    public void setUp() throws Exception {
        // OrderItemPriceInfo
        jdbcHelper.truncate("invoice", "invoice_item");
    }

    @Test
    public void getInvoiceTotal() {
        Invoice invoice=new Invoice();
        invoice.setDescription("a sample invoice");
        String invoiceId=invoiceProcs.save(invoice);
        invoiceProcs.addInvoiceItems(invoiceId,
                invoiceItem(1, 11.3, 5),
                invoiceItem(2, 12.3, 5),
                invoiceItem(3, 13.3, 5));
        BigDecimal total=invoiceProcs.getInvoiceTotal(invoiceId);
        System.out.println(total);
        assertEquals(new BigDecimal("184.50"),
                total.setScale(decimalScale, roundingMode));
    }

    private InvoiceItem invoiceItem(Integer seq, double v, int i) {
        InvoiceItem invoiceItem=new InvoiceItem();
        invoiceItem.setInvoiceItemSeqId(seq.toString());
        invoiceItem.setQuantity(BigDecimal.valueOf(i));
        invoiceItem.setAmount(BigDecimal.valueOf(v));
        return invoiceItem;
    }
}