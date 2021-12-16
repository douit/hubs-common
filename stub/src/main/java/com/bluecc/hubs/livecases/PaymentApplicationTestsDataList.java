package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.PaymentApplicationTestsData.*;

import com.bluecc.hubs.stub.BillingAccountRoleData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.BillingAccountFlatData;

public final class PaymentApplicationTestsDataList {
    public static List<BillingAccountRoleData> billingAccountRoleList() {
        return ImmutableList.of(        
            BillingAccountRole_appltest10000_DemoCustomer_BILL_TO_CUSTOMER_());
    }

    public static List<InvoiceFlatData> invoiceList() {
        return ImmutableList.of(        
            Invoice_appltest10000());
    }

    public static List<InvoiceItemFlatData> invoiceItemList() {
        return ImmutableList.of(        
            InvoiceItem_appltest10000_00001());
    }

    public static List<PaymentFlatData> paymentList() {
        return ImmutableList.of(        
            Payment_appltest10000(),        
            Payment_appltest10001(),        
            Payment_appltest10002());
    }

    public static List<BillingAccountFlatData> billingAccountList() {
        return ImmutableList.of(        
            BillingAccount_appltest10000());
    }

}
