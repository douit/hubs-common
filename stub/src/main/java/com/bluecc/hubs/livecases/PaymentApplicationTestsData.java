package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.BillingAccountRoleData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.BillingAccountFlatData;

public final class PaymentApplicationTestsData {
    public static BillingAccountRoleData BillingAccountRole_appltest10000_DemoCustomer_BILL_TO_CUSTOMER_() {
        return BillingAccountRoleData.newBuilder()
            .setBillingAccountId("appltest10000")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static InvoiceFlatData Invoice_appltest10000() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setDescription("This is the first invoice number to AcctBuyer")
            .setDueDate(getTimestamp("2006-05-25 12:46:27.122"))
            .setInvoiceDate(getTimestamp("2006-04-25 12:46:27.122"))
            .setInvoiceId("appltest10000")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPartyId("DemoCustomer")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_SENT")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_appltest10000_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("20"))
            .setDescription("this was e service for a product")
            .setInvoiceId("appltest10000")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_SPROD_ITEM")
            .setTaxableFlag(castIndicator("Y"))
            .build();
    }


    public static PaymentFlatData Payment_appltest10000() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("20"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2006-04-25 12:56:54.292"))
            .setPartyIdFrom("DemoCustomer")
            .setPartyIdTo("Company")
            .setPaymentId("appltest10000")
            .setPaymentMethodTypeId("EFT_ACCOUNT")
            .setPaymentTypeId("CUSTOMER_PAYMENT")
            .setStatusId("PMNT_NOT_PAID")
            .build();
    }


    public static PaymentFlatData Payment_appltest10001() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("20"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2006-04-25 12:56:54.292"))
            .setPartyIdFrom("Company")
            .setPartyIdTo("DemoCustomer")
            .setPaymentId("appltest10001")
            .setPaymentMethodTypeId("EFT_ACCOUNT")
            .setPaymentTypeId("CUSTOMER_REFUND")
            .setStatusId("PMNT_NOT_PAID")
            .build();
    }


    public static PaymentFlatData Payment_appltest10002() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("20"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2006-04-25 12:56:54.292"))
            .setPartyIdFrom("Company")
            .setPartyIdTo("USA_IRS")
            .setPaymentId("appltest10002")
            .setPaymentMethodTypeId("EFT_ACCOUNT")
            .setPaymentTypeId("SALES_TAX_PAYMENT")
            .setStatusId("PMNT_NOT_PAID")
            .build();
    }


    public static BillingAccountFlatData BillingAccount_appltest10000() {
        return BillingAccountFlatData.newBuilder()
            .setAccountCurrencyUomId("USD")
            .setAccountLimit(getCurrency("10000.0"))
            .setBillingAccountId("appltest10000")
            .setContactMechId("9010")
            .setDescription("Demo Customer Company Billing Account")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .build();
    }

}
