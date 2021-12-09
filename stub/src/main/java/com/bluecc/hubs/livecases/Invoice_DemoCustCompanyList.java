package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Invoice_DemoCustCompany.*;

import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.InvoiceStatusData;

public final class Invoice_DemoCustCompanyList {
    public static List<InvoiceFlatData> invoiceList() {
        return ImmutableList.of(        
            Invoice_demo1200());
    }

    public static List<InvoiceItemFlatData> invoiceItemList() {
        return ImmutableList.of(        
            InvoiceItem_demo1200_00001());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_DemoCustCompany());
    }

    public static List<InvoiceStatusData> invoiceStatusList() {
        return ImmutableList.of(        
            InvoiceStatus_INVOICE_IN_PROCESS_demo1200_(),        
            InvoiceStatus_INVOICE_APPROVED_demo1200_());
    }

}
