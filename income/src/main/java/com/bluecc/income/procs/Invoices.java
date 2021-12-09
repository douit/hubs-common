package com.bluecc.income.procs;

import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceStatusData;
import com.bluecc.income.dao.InvoiceDelegator;

import java.time.LocalDateTime;

import static com.bluecc.hubs.ProtoTypes.getTimestamp;
import static com.bluecc.hubs.ProtoTypes.nowTimestamp;

public class Invoices extends InvoiceDelegator {
    public InvoiceFlatData createInvoice(LocalDateTime dueDate) {
        return InvoiceFlatData.newBuilder()
                .setCurrencyUomId("USD")
                .setDescription("This is the first invoice number to AcctBuyer")
                .setDueDate(getTimestamp(dueDate))
                .setInvoiceDate(nowTimestamp())
                .setInvoiceId(sequence.nextStringId())
                .setInvoiceTypeId("SALES_INVOICE")
                .setPartyId("AcctBuyer")
                .setPartyIdFrom("Company")
                .setStatusId("INVOICE_IN_PROCESS")
                .build();
    }

    public InvoiceStatusData addInvoiceStatus(InvoiceFlatData invoice, String statusId) {
        return InvoiceStatusData.newBuilder()
                .setInvoiceId(invoice.getInvoiceId())
                .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
                .setStatusId(statusId)
                .build();
    }

    public void setInvoiceStatus(InvoiceFlatData inv, String statusId){
        process(c ->{
            InvoiceStatusData statusData=addInvoiceStatus(inv, statusId);
            create(c, statusData);
            update(c, InvoiceFlatData.newBuilder()
                    .setInvoiceId(inv.getInvoiceId())
                    .setStatusId(statusId)
                    .build());
        });
    }
}
