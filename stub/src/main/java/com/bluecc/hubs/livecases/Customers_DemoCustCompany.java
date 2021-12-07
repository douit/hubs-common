package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
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

public final class Customers_DemoCustCompany {
    public static PartyRoleData PartyRole_DemoCustCompany_ACCOUNT() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setRoleTypeId("ACCOUNT")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustCompany_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustCompany_BILL_TO_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustCompany__NA_() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setRoleTypeId("_NA_")
            .build();
    }


    public static BillingAccountRoleData BillingAccountRole_9010_DemoCustCompany_BILL_TO_CUSTOMER_() {
        return BillingAccountRoleData.newBuilder()
            .setBillingAccountId("9010")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static PartyTaxAuthInfoData PartyTaxAuthInfo_DemoCustCompany_UT_UT_TAXMAN_() {
        return PartyTaxAuthInfoData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setIsExempt(castIndicator("Y"))
            .setPartyId("DemoCustCompany")
            .setPartyTaxId("12-3456789")
            .setTaxAuthGeoId("UT")
            .setTaxAuthPartyId("UT_TAXMAN")
            .build();
    }


    public static PartyTaxAuthInfoData PartyTaxAuthInfo_DemoCustCompany_CA_CA_BOE_() {
        return PartyTaxAuthInfoData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setIsExempt(castIndicator("N"))
            .setPartyId("DemoCustCompany")
            .setPartyTaxId("98-7654321")
            .setTaxAuthGeoId("CA")
            .setTaxAuthPartyId("CA_BOE")
            .build();
    }


    public static TelecomNumberData TelecomNumber_9020() {
        return TelecomNumberData.newBuilder()
            .setAreaCode("801")
            .setContactMechId("9020")
            .setContactNumber("555-5555")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoCustCompany_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyGroupFlatData PartyGroup_DemoCustCompany() {
        return PartyGroupFlatData.newBuilder()
            .setGroupName("Demo Customer Company")
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static ContactMechData ContactMech_9010() {
        return ContactMechData.newBuilder()
            .setContactMechId("9010")
            .setContactMechTypeId("POSTAL_ADDRESS")
            .build();
    }


    public static ContactMechData ContactMech_9014() {
        return ContactMechData.newBuilder()
            .setContactMechId("9014")
            .setContactMechTypeId("POSTAL_ADDRESS")
            .build();
    }


    public static ContactMechData ContactMech_9020() {
        return ContactMechData.newBuilder()
            .setContactMechId("9020")
            .setContactMechTypeId("TELECOM_NUMBER")
            .build();
    }


    public static ContactMechData ContactMech_9021() {
        return ContactMechData.newBuilder()
            .setContactMechId("9021")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setInfoString("ofbiztest@example.com")
            .build();
    }


    public static PostalAddressData PostalAddress_9010() {
        return PostalAddressData.newBuilder()
            .setAddress1("2004 Factory Blvd")
            .setCity("Orem")
            .setContactMechId("9010")
            .setCountryGeoId("USA")
            .setGeoPointId("9000")
            .setPostalCode("84057")
            .setStateProvinceGeoId("UT")
            .setToName("Demo Customer Company")
            .build();
    }


    public static PostalAddressData PostalAddress_9014() {
        return PostalAddressData.newBuilder()
            .setAddress1("1234 Commerce Way")
            .setCity("Los Angeles")
            .setContactMechId("9014")
            .setCountryGeoId("USA")
            .setPostalCode("90010")
            .setStateProvinceGeoId("CA")
            .setToName("Demo Customer Company")
            .build();
    }


    public static PartyFlatData Party_DemoCustCompany() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setPartyTypeId("PARTY_GROUP")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9010_BILLING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9010")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9010_SHIPPING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9010")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9010_GENERAL_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9010")
            .setContactMechPurposeTypeId("GENERAL_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9014_BILLING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9014")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9014_SHIPPING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9014")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9014_GENERAL_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9014")
            .setContactMechPurposeTypeId("GENERAL_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9020_PHONE_WORK_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9020")
            .setContactMechPurposeTypeId("PHONE_WORK")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustCompany_9021_PRIMARY_EMAIL_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9021")
            .setContactMechPurposeTypeId("PRIMARY_EMAIL")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static BillingAccountFlatData BillingAccount_9010() {
        return BillingAccountFlatData.newBuilder()
            .setAccountCurrencyUomId("USD")
            .setAccountLimit(getCurrency("10000.0"))
            .setBillingAccountId("9010")
            .setContactMechId("9010")
            .setDescription("Demo Customer Company Billing Account")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoCustCompany() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setUserLoginId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustCompany_9010_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9010")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustCompany_9014_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9014")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustCompany_9020_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustCompany_9021_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9021")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustCompany")
            .build();
    }

}
