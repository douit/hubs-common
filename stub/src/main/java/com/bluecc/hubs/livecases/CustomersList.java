package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Customers.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PartyGeoPointData;
import com.bluecc.hubs.stub.PartyTaxAuthInfoData;
import com.bluecc.hubs.stub.TelecomNumberData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.ContactMechData;
import com.bluecc.hubs.stub.CreditCardData;
import com.bluecc.hubs.stub.PostalAddressData;
import com.bluecc.hubs.stub.PartyRelationshipData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PartyContactMechPurposeData;
import com.bluecc.hubs.stub.PaymentMethodData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class CustomersList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DemoCustomer_CUSTOMER(),        
            PartyRole_DemoCustomer_CONTACT(),        
            PartyRole_DemoCustomer_BILL_TO_CUSTOMER(),        
            PartyRole_EuroCustomer_CUSTOMER(),        
            PartyRole_EuroCustomer_BILL_TO_CUSTOMER(),        
            PartyRole_FrenchCustomer_CUSTOMER(),        
            PartyRole_FrenchCustomer_BILL_TO_CUSTOMER());
    }

    public static List<PartyGeoPointData> partyGeoPointList() {
        return ImmutableList.of(        
            PartyGeoPoint_DemoCustomer_9000_(),        
            PartyGeoPoint_EuroCustomer_9001_(),        
            PartyGeoPoint_FrenchCustomer_9002_());
    }

    public static List<PartyTaxAuthInfoData> partyTaxAuthInfoList() {
        return ImmutableList.of(        
            PartyTaxAuthInfo_FrenchCustomer_FRA_FRA_TA_());
    }

    public static List<TelecomNumberData> telecomNumberList() {
        return ImmutableList.of(        
            TelecomNumber_9025(),        
            TelecomNumber_9027());
    }

    public static List<PartyStatusData> partyStatusList() {
        return ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_DemoCustomer_(),        
            PartyStatus_PARTY_ENABLED_EuroCustomer_(),        
            PartyStatus_PARTY_ENABLED_FrenchCustomer_());
    }

    public static List<ContactMechData> contactMechList() {
        return ImmutableList.of(        
            ContactMech_9015(),        
            ContactMech_9025(),        
            ContactMech_9027(),        
            ContactMech_9026(),        
            ContactMech_EUROCUSTOMER(),        
            ContactMech_EURO01(),        
            ContactMech_FRENCHCUSTOMER(),        
            ContactMech_FRA01());
    }

    public static List<CreditCardData> creditCardList() {
        return ImmutableList.of(        
            CreditCard_9015(),        
            CreditCard_EUROCUSTOMER(),        
            CreditCard_FRENCHCUSTOMER());
    }

    public static List<PostalAddressData> postalAddressList() {
        return ImmutableList.of(        
            PostalAddress_9015(),        
            PostalAddress_EUROCUSTOMER(),        
            PostalAddress_FRENCHCUSTOMER());
    }

    public static List<PartyRelationshipData> partyRelationshipList() {
        return ImmutableList.of(        
            PartyRelationship_DemoCustCompany_DemoCustomer_ACCOUNT_CONTACT_());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_DemoCustomer(),        
            Party_EuroCustomer(),        
            Party_FrenchCustomer());
    }

    public static List<PartyContactMechPurposeData> partyContactMechPurposeList() {
        return ImmutableList.of(        
            PartyContactMechPurpose_DemoCustomer_9015_BILLING_LOCATION_(),        
            PartyContactMechPurpose_DemoCustomer_9015_SHIPPING_LOCATION_(),        
            PartyContactMechPurpose_DemoCustomer_9015_GENERAL_LOCATION_(),        
            PartyContactMechPurpose_DemoCustomer_9025_PHONE_HOME_(),        
            PartyContactMechPurpose_DemoCustomer_9025_PHONE_SHIPPING_(),        
            PartyContactMechPurpose_DemoCustomer_9027_PHONE_BILLING_(),        
            PartyContactMechPurpose_DemoCustomer_9026_PRIMARY_EMAIL_(),        
            PartyContactMechPurpose_EuroCustomer_EUROCUSTOMER_BILLING_LOCATION_(),        
            PartyContactMechPurpose_EuroCustomer_EUROCUSTOMER_SHIPPING_LOCATION_(),        
            PartyContactMechPurpose_EuroCustomer_EUROCUSTOMER_GENERAL_LOCATION_(),        
            PartyContactMechPurpose_EuroCustomer_EURO01_PRIMARY_EMAIL_(),        
            PartyContactMechPurpose_FrenchCustomer_FRENCHCUSTOMER_BILLING_LOCATION_(),        
            PartyContactMechPurpose_FrenchCustomer_FRENCHCUSTOMER_SHIPPING_LOCATION_(),        
            PartyContactMechPurpose_FrenchCustomer_FRENCHCUSTOMER_GENERAL_LOCATION_(),        
            PartyContactMechPurpose_FrenchCustomer_FRA01_PRIMARY_EMAIL_());
    }

    public static List<PaymentMethodData> paymentMethodList() {
        return ImmutableList.of(        
            PaymentMethod_9015(),        
            PaymentMethod_EUROCUSTOMER(),        
            PaymentMethod_FRENCHCUSTOMER());
    }

    public static List<PersonFlatData> personList() {
        return ImmutableList.of(        
            Person_DemoCustomer(),        
            Person_EuroCustomer(),        
            Person_FrenchCustomer());
    }

    public static List<UserLoginFlatData> userLoginList() {
        return ImmutableList.of(        
            UserLogin_DemoCustomer(),        
            UserLogin_EuroCustomer(),        
            UserLogin_FrenchCustomer());
    }

    public static List<PartyContactMechData> partyContactMechList() {
        return ImmutableList.of(        
            PartyContactMech_DemoCustomer_9015_(),        
            PartyContactMech_DemoCustomer_9025_(),        
            PartyContactMech_DemoCustomer_9027_(),        
            PartyContactMech_DemoCustomer_9026_(),        
            PartyContactMech_EuroCustomer_EUROCUSTOMER_(),        
            PartyContactMech_EuroCustomer_EURO01_(),        
            PartyContactMech_FrenchCustomer_FRENCHCUSTOMER_(),        
            PartyContactMech_FrenchCustomer_FRA01_());
    }

}
