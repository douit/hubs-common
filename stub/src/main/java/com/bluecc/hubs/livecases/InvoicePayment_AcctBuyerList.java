package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.InvoicePayment_AcctBuyer.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PaymentApplicationData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.PartyGroupFlatData;
import com.bluecc.hubs.stub.SecurityGroupData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.InvoiceStatusData;
import com.bluecc.hubs.stub.UserLoginFlatData;

public final class InvoicePayment_AcctBuyerList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_AcctBuyer_BUYER(),        
            PartyRole_AcctBigSupplier_SUPPLIER());
    }

    public static List<PaymentApplicationData> paymentApplicationList() {
        return ImmutableList.of(        
            PaymentApplication_demo11000());
    }

    public static List<InvoiceFlatData> invoiceList() {
        return ImmutableList.of(        
            Invoice_demo10000(),        
            Invoice_demo10001(),        
            Invoice_demo10002(),        
            Invoice_demo11000(),        
            Invoice_demo11001());
    }

    public static List<InvoiceItemFlatData> invoiceItemList() {
        return ImmutableList.of(        
            InvoiceItem_demo10000_00001(),        
            InvoiceItem_demo10000_00002(),        
            InvoiceItem_demo10000_00003(),        
            InvoiceItem_demo10001_00001(),        
            InvoiceItem_demo10001_00002(),        
            InvoiceItem_demo10002_00001(),        
            InvoiceItem_demo10002_00002(),        
            InvoiceItem_demo11000_00001(),        
            InvoiceItem_demo11001_00001());
    }

    public static List<PartyGroupFlatData> partyGroupList() {
        return ImmutableList.of(        
            PartyGroup_AcctBigSupplier());
    }

    public static List<SecurityGroupData> securityGroupList() {
        return ImmutableList.of(        
            SecurityGroup_ORDERPURCH());
    }

    public static List<PaymentFlatData> paymentList() {
        return ImmutableList.of(        
            Payment_demo10000(),        
            Payment_demo10010(),        
            Payment_demo10001());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_AcctBuyer(),        
            Party_AcctBigSupplier(),        
            Party_EuroCustomer());
    }

    public static List<UserLoginSecurityGroupData> userLoginSecurityGroupList() {
        return ImmutableList.of(        
            UserLoginSecurityGroup_AcctBuyer_ORDERPURCH_());
    }

    public static List<PersonFlatData> personList() {
        return ImmutableList.of(        
            Person_AcctBuyer());
    }

    public static List<InvoiceStatusData> invoiceStatusList() {
        return ImmutableList.of(        
            InvoiceStatus_INVOICE_IN_PROCESS_demo10000_(),        
            InvoiceStatus_INVOICE_IN_PROCESS_demo10001_(),        
            InvoiceStatus_INVOICE_IN_PROCESS_demo10002_(),        
            InvoiceStatus_INVOICE_SENT_demo10002_(),        
            InvoiceStatus_INVOICE_IN_PROCESS_demo11000_(),        
            InvoiceStatus_INVOICE_APPROVED_demo11000_(),        
            InvoiceStatus_INVOICE_IN_PROCESS_demo11001_(),        
            InvoiceStatus_INVOICE_APPROVED_demo11001_());
    }

    public static List<UserLoginFlatData> userLoginList() {
        return ImmutableList.of(        
            UserLogin_AcctBuyer());
    }

}
