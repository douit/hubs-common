package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Agreement_8000.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.AgreementItemData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.InvoiceRoleData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.AgreementProductApplData;
import com.bluecc.hubs.stub.AgreementData;
import com.bluecc.hubs.stub.AgreementTermData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.InvoiceStatusData;

public final class Agreement_8000List {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DemoCustAgent_SALES_REP());
    }

    public static List<AgreementItemData> agreementItemList() {
        return ImmutableList.of(        
            AgreementItem_8000_0001());
    }

    public static List<InvoiceFlatData> invoiceList() {
        return ImmutableList.of(        
            Invoice_8100());
    }

    public static List<InvoiceItemFlatData> invoiceItemList() {
        return ImmutableList.of(        
            InvoiceItem_8100_00002());
    }

    public static List<InvoiceRoleData> invoiceRoleList() {
        return ImmutableList.of(        
            InvoiceRole_8100_Company_BILL_FROM_VENDOR(),        
            InvoiceRole_8100_DemoCustAgent_SALES_REP());
    }

    public static List<ProductFlatData> productList() {
        return ImmutableList.of(        
            Product_WG_9943(),        
            Product_WG_9943_B3());
    }

    public static List<AgreementProductApplData> agreementProductApplList() {
        return ImmutableList.of(        
            AgreementProductAppl_8000_0001_WG_9943());
    }

    public static List<AgreementData> agreementList() {
        return ImmutableList.of(        
            Agreement_8000());
    }

    public static List<AgreementTermData> agreementTermList() {
        return ImmutableList.of(        
            AgreementTerm_8000(),        
            AgreementTerm_8001(),        
            AgreementTerm_8002());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_DemoCustAgent());
    }

    public static List<InvoiceStatusData> invoiceStatusList() {
        return ImmutableList.of(        
            InvoiceStatus_INVOICE_IN_PROCESS_8100_(),        
            InvoiceStatus_INVOICE_PAID_8100_(),        
            InvoiceStatus_INVOICE_READY_8100_());
    }

}
