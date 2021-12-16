package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PaymentApplicationData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.PartyGroupFlatData;
import com.bluecc.hubs.stub.SecurityGroupFlatData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.InvoiceStatusData;
import com.bluecc.hubs.stub.UserLoginFlatData;

public final class InvoicePayment_AcctBuyer {
    public static PartyRoleData PartyRole_AcctBuyer_BUYER() {
        return PartyRoleData.newBuilder()
            .setPartyId("AcctBuyer")
            .setRoleTypeId("BUYER")
            .build();
    }


    public static PartyRoleData PartyRole_AcctBigSupplier_SUPPLIER() {
        return PartyRoleData.newBuilder()
            .setPartyId("AcctBigSupplier")
            .setRoleTypeId("SUPPLIER")
            .build();
    }


    public static PaymentApplicationData PaymentApplication_demo11000() {
        return PaymentApplicationData.newBuilder()
            .setAmountApplied(getCurrency("543.23"))
            .setInvoiceId("demo11001")
            .setPaymentApplicationId("demo11000")
            .setPaymentId("demo10001")
            .build();
    }


    public static InvoiceFlatData Invoice_demo10000() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setDescription("This is the first invoice number to AcctBuyer")
            .setDueDate(getTimestamp("2006-05-25 12:46:27.122"))
            .setInvoiceDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setInvoiceId("demo10000")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPartyId("AcctBuyer")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_demo10001() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setDescription("Another invoice")
            .setDueDate(getTimestamp("2006-05-25 12:50:50.655"))
            .setInvoiceDate(getTimestamp("2006-04-25 12:50:50.655"))
            .setInvoiceId("demo10001")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("Company")
            .setPartyIdFrom("AcctBigSupplier")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_demo10002() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setDescription("Another sales invoice")
            .setDueDate(getTimestamp("2006-05-25 12:54:07.011"))
            .setInvoiceDate(getTimestamp("2006-04-25 12:54:07.011"))
            .setInvoiceId("demo10002")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPartyId("AcctBuyer")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_SENT")
            .build();
    }


    public static InvoiceFlatData Invoice_demo11000() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("EUR")
            .setDescription("This is the first invoice number to Eurocustomer with currency in euro")
            .setDueDate(getTimestamp("2006-05-25 12:46:27.122"))
            .setInvoiceDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setInvoiceId("demo11000")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPartyId("EuroCustomer")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_APPROVED")
            .build();
    }


    public static InvoiceFlatData Invoice_demo11001() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("EUR")
            .setDescription("This is the first invoice number to Eurocustomer with currency in euro")
            .setDueDate(getTimestamp("2006-05-25 12:46:27.122"))
            .setInvoiceDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setInvoiceId("demo11001")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPartyId("EuroCustomer")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_APPROVED")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo10000_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("20.0"))
            .setDescription("this was e service for a product")
            .setInvoiceId("demo10000")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_SPROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo10000_00002() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("269.99"))
            .setDescription("Big Gizmo w/ Legs")
            .setInvoiceId("demo10000")
            .setInvoiceItemSeqId("00002")
            .setInvoiceItemTypeId("INV_PROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo10000_00003() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("33.55"))
            .setDescription("sales tax")
            .setInvoiceId("demo10000")
            .setInvoiceItemSeqId("00003")
            .setInvoiceItemTypeId("INV_SALES_TAX")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo10001_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("33.99"))
            .setDescription("Service received")
            .setInvoiceId("demo10001")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("PINV_WE_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo10001_00002() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("2.44"))
            .setDescription("Service received")
            .setInvoiceId("demo10001")
            .setInvoiceItemSeqId("00002")
            .setInvoiceItemTypeId("PINV_SURCHARGE_ADJ")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo10002_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("1.0"))
            .setDescription("Add more money to your card!")
            .setInvoiceId("demo10002")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_DPROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo10002_00002() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("55.99"))
            .setDescription("A digital gizmo: can be downloaded immediately after purchase.")
            .setInvoiceId("demo10002")
            .setInvoiceItemSeqId("00002")
            .setInvoiceItemTypeId("INV_DPROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo11000_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("20.0"))
            .setDescription("this was e service for a product")
            .setInvoiceId("demo11000")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_SPROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_demo11001_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("543.23"))
            .setDescription("this was e service for a product")
            .setInvoiceId("demo11001")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_SPROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .setUomId("USD")
            .build();
    }


    public static PartyGroupFlatData PartyGroup_AcctBigSupplier() {
        return PartyGroupFlatData.newBuilder()
            .setGroupName("Acct Big Supplier")
            .setPartyId("AcctBigSupplier")
            .build();
    }


    public static SecurityGroupFlatData SecurityGroup_ORDERPURCH() {
        return SecurityGroupFlatData.newBuilder()
            .setGroupId("ORDERPURCH")
            .build();
    }


    public static PaymentFlatData Payment_demo10000() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("190.97"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2006-04-25 12:56:54.292"))
            .setPartyIdFrom("AcctBuyer")
            .setPartyIdTo("Company")
            .setPaymentId("demo10000")
            .setPaymentMethodTypeId("EFT_ACCOUNT")
            .setPaymentTypeId("CUSTOMER_PAYMENT")
            .setStatusId("PMNT_NOT_PAID")
            .build();
    }


    public static PaymentFlatData Payment_demo10010() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("20.0"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2006-04-25 13:11:05.94"))
            .setPartyIdFrom("Company")
            .setPartyIdTo("AcctBuyer")
            .setPaymentId("demo10010")
            .setPaymentMethodTypeId("EXT_BILLACT")
            .setPaymentTypeId("CUSTOMER_REFUND")
            .setStatusId("PMNT_SENT")
            .build();
    }


    public static PaymentFlatData Payment_demo10001() {
        return PaymentFlatData.newBuilder()
            .setActualCurrencyAmount(getCurrency("543.23"))
            .setActualCurrencyUomId("EUR")
            .setAmount(getCurrency("820.97"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2006-04-25 12:56:54.292"))
            .setPartyIdFrom("EuroCustomer")
            .setPartyIdTo("Company")
            .setPaymentId("demo10001")
            .setPaymentMethodTypeId("EFT_ACCOUNT")
            .setPaymentTypeId("CUSTOMER_PAYMENT")
            .setStatusId("PMNT_RECEIVED")
            .build();
    }


    public static PartyFlatData Party_AcctBuyer() {
        return PartyFlatData.newBuilder()
            .setPartyId("AcctBuyer")
            .setPartyTypeId("PERSON")
            .build();
    }


    public static PartyFlatData Party_AcctBigSupplier() {
        return PartyFlatData.newBuilder()
            .setPartyId("AcctBigSupplier")
            .setPartyTypeId("PARTY_GROUP")
            .build();
    }


    public static PartyFlatData Party_EuroCustomer() {
        return PartyFlatData.newBuilder()
            .setPartyId("EuroCustomer")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_AcctBuyer_ORDERPURCH_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 00:00:00"))
            .setGroupId("ORDERPURCH")
            .setUserLoginId("AcctBuyer")
            .build();
    }


    public static PersonFlatData Person_AcctBuyer() {
        return PersonFlatData.newBuilder()
            .setFirstName("Acct")
            .setLastName("Buyer")
            .setPartyId("AcctBuyer")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_IN_PROCESS_demo10000_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo10000")
            .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_IN_PROCESS_demo10001_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo10001")
            .setStatusDate(getTimestamp("2006-04-25 12:50:50.655"))
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_IN_PROCESS_demo10002_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo10002")
            .setStatusDate(getTimestamp("2006-04-25 12:54:07.011"))
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_SENT_demo10002_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo10002")
            .setStatusDate(getTimestamp("2006-04-25 12:55:44.228"))
            .setStatusId("INVOICE_SENT")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_IN_PROCESS_demo11000_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo11000")
            .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_APPROVED_demo11000_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo11000")
            .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setStatusId("INVOICE_APPROVED")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_IN_PROCESS_demo11001_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo11001")
            .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceStatusData InvoiceStatus_INVOICE_APPROVED_demo11001_() {
        return InvoiceStatusData.newBuilder()
            .setInvoiceId("demo11001")
            .setStatusDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setStatusId("INVOICE_APPROVED")
            .build();
    }


    public static UserLoginFlatData UserLogin_AcctBuyer() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("AcctBuyer")
            .setUserLoginId("AcctBuyer")
            .build();
    }

}
