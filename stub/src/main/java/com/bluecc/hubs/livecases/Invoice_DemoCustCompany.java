package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.InvoiceStatusData;

public final class Invoice_DemoCustCompany {
    public static InvoiceFlatData Invoice_demo1200() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setDescription("This is an invoice to DemoCustomer")
            .setDueDate(getTimestamp("2010-05-25 12:46:27.122"))
            .setInvoiceDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setInvoiceId("demo1200")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPartyId("DemoCustCompany")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_APPROVED")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo1200_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("511.23"))
            .setDescription("this was e service for a product")
            .setInvoiceId("demo1200")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_SPROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static PartyFlatData Party_DemoCustCompany() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setPartyTypeId("PARTY_GROUP")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_IN_PROCESS_demo1200_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo1200")
            .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_APPROVED_demo1200_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo1200")
            .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setStatusId("INVOICE_APPROVED")
            .build();
    }

}
