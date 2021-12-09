package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
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

public final class Agreement_8000 {
    public static PartyRoleData PartyRole_DemoCustAgent_SALES_REP() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustAgent")
            .setRoleTypeId("SALES_REP")
            .build();
    }


    public static AgreementItemData AgreementItem_8000_0001() {
        return AgreementItemData.newBuilder()
            .setAgreementId("8000")
            .setAgreementItemSeqId("0001")
            .setAgreementItemTypeId("AGREEMENT_COMMISSION")
            .setAgreementText("Commission in USD")
            .setCurrencyUomId("USD")
            .build();
    }


    public static InvoiceFlatData Invoice_8100() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setDueDate(getTimestamp("2009-08-07 11:54:00.765"))
            .setInvoiceDate(getTimestamp("2009-07-08 11:54:00.765"))
            .setInvoiceId("8100")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPaidDate(getTimestamp("2009-07-08 11:54:03.246"))
            .setPartyId("admin")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_PAID")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8100_00002() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("440.000"))
            .setDescription("Giant Widget B3")
            .setInvoiceId("8100")
            .setInvoiceItemSeqId("00002")
            .setInvoiceItemTypeId("INV_FPROD_ITEM")
            .setProductId("WG-9943-B3")
            .setQuantity(getFixedPoint("3.000000"))
            .build();
    }


    public static InvoiceRoleData InvoiceRole_8100_Company_BILL_FROM_VENDOR() {
        return InvoiceRoleData.newBuilder()
            .setDatetimePerformed(getTimestamp("2009-07-08 11:54:00.979"))
            .setInvoiceId("8100")
            .setPartyId("Company")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static InvoiceRoleData InvoiceRole_8100_DemoCustAgent_SALES_REP() {
        return InvoiceRoleData.newBuilder()
            .setDatetimePerformed(getTimestamp("2009-07-08 11:54:00.979"))
            .setInvoiceId("8100")
            .setPartyId("DemoCustAgent")
            .setRoleTypeId("SALES_REP")
            .build();
    }


    public static ProductFlatData Product_WG_9943() {
        return ProductFlatData.newBuilder()
            .setProductId("WG-9943")
            .setProductTypeId("FINISHED_GOOD")
            .build();
    }


    public static ProductFlatData Product_WG_9943_B3() {
        return ProductFlatData.newBuilder()
            .setProductId("WG-9943-B3")
            .setProductTypeId("FINISHED_GOOD")
            .build();
    }


    public static AgreementProductApplData AgreementProductAppl_8000_0001_WG_9943() {
        return AgreementProductApplData.newBuilder()
            .setAgreementId("8000")
            .setAgreementItemSeqId("0001")
            .setProductId("WG-9943")
            .build();
    }


    public static AgreementData Agreement_8000() {
        return AgreementData.newBuilder()
            .setAgreementId("8000")
            .setAgreementTypeId("COMMISSION_AGREEMENT")
            .setDescription("Commission Agreement with DemoCustAgent")
            .setPartyIdFrom("Company")
            .setPartyIdTo("DemoCustAgent")
            .build();
    }


    public static AgreementTermData AgreementTerm_8000() {
        return AgreementTermData.newBuilder()
            .setAgreementId("8000")
            .setAgreementItemSeqId("0001")
            .setAgreementTermId("8000")
            .setInvoiceItemTypeId("INV_FPROD_ITEM")
            .setTermDays(30)
            .setTermTypeId("FIN_COMM_FIXED")
            .setTermValue(getCurrency("1.000"))
            .build();
    }


    public static AgreementTermData AgreementTerm_8001() {
        return AgreementTermData.newBuilder()
            .setAgreementId("8000")
            .setAgreementItemSeqId("0001")
            .setAgreementTermId("8001")
            .setInvoiceItemTypeId("INV_FPROD_ITEM")
            .setTermDays(30)
            .setTermTypeId("FIN_COMM_VARIABLE")
            .setTermValue(getCurrency("3.000"))
            .build();
    }


    public static AgreementTermData AgreementTerm_8002() {
        return AgreementTermData.newBuilder()
            .setAgreementId("8000")
            .setAgreementItemSeqId("0001")
            .setAgreementTermId("8002")
            .setInvoiceItemTypeId("INV_FPROD_ITEM")
            .setTermDays(30)
            .setTermTypeId("FIN_COMM_MIN")
            .setTermValue(getCurrency("0.000"))
            .build();
    }


    public static PartyFlatData Party_DemoCustAgent() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_IN_PROCESS_8100_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("8100")
            .setStatusDate(getTimestamp("2009-07-08 11:54:00.845"))
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_PAID_8100_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("8100")
            .setStatusDate(getTimestamp("2009-07-08 11:54:03.8"))
            .setStatusId("INVOICE_PAID")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_READY_8100_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("8100")
            .setStatusDate(getTimestamp("2009-07-08 11:54:01.863"))
            .setStatusId("INVOICE_READY")
            .build();
    }

}
