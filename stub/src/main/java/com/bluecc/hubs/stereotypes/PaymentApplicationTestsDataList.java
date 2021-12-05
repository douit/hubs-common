package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.PaymentApplicationTestsData.*;import com.bluecc.hubs.stub.BillingAccountRoleData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.BillingAccountFlatData;

public final class PaymentApplicationTestsDataList {
    public static final List<BillingAccountRoleData> billingAccountRoleList=ImmutableList.of(        
            BillingAccountRole_appltest10000_DemoCustomer_BILL_TO_CUSTOMER_);

    public static final List<InvoiceFlatData> invoiceList=ImmutableList.of(        
            Invoice_appltest10000);

    public static final List<InvoiceItemFlatData> invoiceItemList=ImmutableList.of(        
            InvoiceItem_appltest10000_00001);

    public static final List<PaymentFlatData> paymentList=ImmutableList.of(        
            Payment_appltest10000,        
            Payment_appltest10001,        
            Payment_appltest10002);

    public static final List<BillingAccountFlatData> billingAccountList=ImmutableList.of(        
            BillingAccount_appltest10000);

}
