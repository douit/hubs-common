package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Customers_DemoCustCompany.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.BillingAccountRoleData;
import com.bluecc.hubs.stub.PartyTaxAuthInfoData;
import com.bluecc.hubs.stub.TelecomNumberData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.PartyGroupFlatData;
import com.bluecc.hubs.stub.ContactMechData;
import com.bluecc.hubs.stub.PostalAddressData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PartyContactMechPurposeData;
import com.bluecc.hubs.stub.BillingAccountFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class Customers_DemoCustCompanyList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DemoCustCompany_ACCOUNT(),        
            PartyRole_DemoCustCompany_CUSTOMER(),        
            PartyRole_DemoCustCompany_BILL_TO_CUSTOMER(),        
            PartyRole_DemoCustCompany__NA_());
    }

    public static List<BillingAccountRoleData> billingAccountRoleList() {
        return ImmutableList.of(        
            BillingAccountRole_9010_DemoCustCompany_BILL_TO_CUSTOMER_());
    }

    public static List<PartyTaxAuthInfoData> partyTaxAuthInfoList() {
        return ImmutableList.of(        
            PartyTaxAuthInfo_DemoCustCompany_UT_UT_TAXMAN_(),        
            PartyTaxAuthInfo_DemoCustCompany_CA_CA_BOE_());
    }

    public static List<TelecomNumberData> telecomNumberList() {
        return ImmutableList.of(        
            TelecomNumber_9020());
    }

    public static List<PartyStatusData> partyStatusList() {
        return ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_DemoCustCompany_());
    }

    public static List<PartyGroupFlatData> partyGroupList() {
        return ImmutableList.of(        
            PartyGroup_DemoCustCompany());
    }

    public static List<ContactMechData> contactMechList() {
        return ImmutableList.of(        
            ContactMech_9010(),        
            ContactMech_9014(),        
            ContactMech_9020(),        
            ContactMech_9021());
    }

    public static List<PostalAddressData> postalAddressList() {
        return ImmutableList.of(        
            PostalAddress_9010(),        
            PostalAddress_9014());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_DemoCustCompany());
    }

    public static List<PartyContactMechPurposeData> partyContactMechPurposeList() {
        return ImmutableList.of(        
            PartyContactMechPurpose_DemoCustCompany_9010_BILLING_LOCATION_(),        
            PartyContactMechPurpose_DemoCustCompany_9010_SHIPPING_LOCATION_(),        
            PartyContactMechPurpose_DemoCustCompany_9010_GENERAL_LOCATION_(),        
            PartyContactMechPurpose_DemoCustCompany_9014_BILLING_LOCATION_(),        
            PartyContactMechPurpose_DemoCustCompany_9014_SHIPPING_LOCATION_(),        
            PartyContactMechPurpose_DemoCustCompany_9014_GENERAL_LOCATION_(),        
            PartyContactMechPurpose_DemoCustCompany_9020_PHONE_WORK_(),        
            PartyContactMechPurpose_DemoCustCompany_9021_PRIMARY_EMAIL_());
    }

    public static List<BillingAccountFlatData> billingAccountList() {
        return ImmutableList.of(        
            BillingAccount_9010());
    }

    public static List<UserLoginFlatData> userLoginList() {
        return ImmutableList.of(        
            UserLogin_DemoCustCompany());
    }

    public static List<PartyContactMechData> partyContactMechList() {
        return ImmutableList.of(        
            PartyContactMech_DemoCustCompany_9010_(),        
            PartyContactMech_DemoCustCompany_9014_(),        
            PartyContactMech_DemoCustCompany_9020_(),        
            PartyContactMech_DemoCustCompany_9021_());
    }

}
