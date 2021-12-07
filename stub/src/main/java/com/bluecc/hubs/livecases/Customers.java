package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
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

public final class Customers {
    public static PartyRoleData PartyRole_DemoCustomer_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer_CONTACT() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer")
            .setRoleTypeId("CONTACT")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer_BILL_TO_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_EuroCustomer_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("EuroCustomer")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_EuroCustomer_BILL_TO_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("EuroCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_FrenchCustomer_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("FrenchCustomer")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_FrenchCustomer_BILL_TO_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("FrenchCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static PartyGeoPointData PartyGeoPoint_DemoCustomer_9000_() {
        return PartyGeoPointData.newBuilder()
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9000")
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyGeoPointData PartyGeoPoint_EuroCustomer_9001_() {
        return PartyGeoPointData.newBuilder()
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9001")
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PartyGeoPointData PartyGeoPoint_FrenchCustomer_9002_() {
        return PartyGeoPointData.newBuilder()
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setGeoPointId("9002")
            .setPartyId("FrenchCustomer")
            .build();
    }


    public static PartyTaxAuthInfoData PartyTaxAuthInfo_FrenchCustomer_FRA_FRA_TA_() {
        return PartyTaxAuthInfoData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setIsExempt(castIndicator("N"))
            .setPartyId("FrenchCustomer")
            .setPartyTaxId("FR-12345678901")
            .setTaxAuthGeoId("FRA")
            .setTaxAuthPartyId("FRA_TA")
            .build();
    }


    public static TelecomNumberData TelecomNumber_9025() {
        return TelecomNumberData.newBuilder()
            .setAreaCode("801")
            .setContactMechId("9025")
            .setContactNumber("555-5555")
            .setCountryCode("1")
            .build();
    }


    public static TelecomNumberData TelecomNumber_9027() {
        return TelecomNumberData.newBuilder()
            .setAreaCode("801")
            .setContactMechId("9027")
            .setContactNumber("444-4444")
            .setCountryCode("1")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoCustomer_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoCustomer")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_EuroCustomer_() {
        return PartyStatusData.newBuilder()
            .setPartyId("EuroCustomer")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_FrenchCustomer_() {
        return PartyStatusData.newBuilder()
            .setPartyId("FrenchCustomer")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static ContactMechData ContactMech_9015() {
        return ContactMechData.newBuilder()
            .setContactMechId("9015")
            .setContactMechTypeId("POSTAL_ADDRESS")
            .build();
    }


    public static ContactMechData ContactMech_9025() {
        return ContactMechData.newBuilder()
            .setContactMechId("9025")
            .setContactMechTypeId("TELECOM_NUMBER")
            .build();
    }


    public static ContactMechData ContactMech_9027() {
        return ContactMechData.newBuilder()
            .setContactMechId("9027")
            .setContactMechTypeId("TELECOM_NUMBER")
            .build();
    }


    public static ContactMechData ContactMech_9026() {
        return ContactMechData.newBuilder()
            .setContactMechId("9026")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setInfoString("ofbiztest@example.com")
            .build();
    }


    public static ContactMechData ContactMech_EUROCUSTOMER() {
        return ContactMechData.newBuilder()
            .setContactMechId("EUROCUSTOMER")
            .setContactMechTypeId("POSTAL_ADDRESS")
            .build();
    }


    public static ContactMechData ContactMech_EURO01() {
        return ContactMechData.newBuilder()
            .setContactMechId("EURO01")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setInfoString("ofbiztest@example.com")
            .build();
    }


    public static ContactMechData ContactMech_FRENCHCUSTOMER() {
        return ContactMechData.newBuilder()
            .setContactMechId("FRENCHCUSTOMER")
            .setContactMechTypeId("POSTAL_ADDRESS")
            .build();
    }


    public static ContactMechData ContactMech_FRA01() {
        return ContactMechData.newBuilder()
            .setContactMechId("FRA01")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setInfoString("ofbiztest@example.com")
            .build();
    }


    public static CreditCardData CreditCard_9015() {
        return CreditCardData.newBuilder()
            .setCardNumber("4111111111111111")
            .setCardType("CCT_VISA")
            .setContactMechId("9015")
            .setExpireDate("02/2100")
            .setFirstNameOnCard("DEMO")
            .setLastNameOnCard("CUSTOMER")
            .setPaymentMethodId("9015")
            .build();
    }


    public static CreditCardData CreditCard_EUROCUSTOMER() {
        return CreditCardData.newBuilder()
            .setCardNumber("4111111111111111")
            .setCardType("CCT_VISA")
            .setContactMechId("EUROCUSTOMER")
            .setExpireDate("02/2100")
            .setFirstNameOnCard("EURO")
            .setLastNameOnCard("CUSTOMER")
            .setPaymentMethodId("EUROCUSTOMER")
            .build();
    }


    public static CreditCardData CreditCard_FRENCHCUSTOMER() {
        return CreditCardData.newBuilder()
            .setCardNumber("4111111111111111")
            .setCardType("CCT_VISA")
            .setContactMechId("FRENCHCUSTOMER")
            .setExpireDate("02/2100")
            .setFirstNameOnCard("FRENCH")
            .setLastNameOnCard("CUSTOMER")
            .setPaymentMethodId("FRENCHCUSTOMER")
            .build();
    }


    public static PostalAddressData PostalAddress_9015() {
        return PostalAddressData.newBuilder()
            .setAddress1("2004 Factory Blvd")
            .setCity("Orem")
            .setContactMechId("9015")
            .setCountryGeoId("USA")
            .setGeoPointId("9000")
            .setPostalCode("84057")
            .setStateProvinceGeoId("UT")
            .setToName("Demo Customer")
            .build();
    }


    public static PostalAddressData PostalAddress_EUROCUSTOMER() {
        return PostalAddressData.newBuilder()
            .setAddress1("Prinsengracht 3")
            .setCity("Amsterdam")
            .setContactMechId("EUROCUSTOMER")
            .setCountryGeoId("NLD")
            .setGeoPointId("9001")
            .setPostalCode("1000BD")
            .setToName("Euro Customer")
            .build();
    }


    public static PostalAddressData PostalAddress_FRENCHCUSTOMER() {
        return PostalAddressData.newBuilder()
            .setAddress1("400 E Chemin de la Mouline")
            .setCity("Poussan")
            .setContactMechId("FRENCHCUSTOMER")
            .setCountryGeoId("FRA")
            .setGeoPointId("9002")
            .setPostalCode("34560")
            .setToName("French Customer")
            .build();
    }


    public static PartyRelationshipData PartyRelationship_DemoCustCompany_DemoCustomer_ACCOUNT_CONTACT_() {
        return PartyRelationshipData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
            .setPartyIdFrom("DemoCustCompany")
            .setPartyIdTo("DemoCustomer")
            .setPartyRelationshipTypeId("EMPLOYMENT")
            .setRoleTypeIdFrom("ACCOUNT")
            .setRoleTypeIdTo("CONTACT")
            .build();
    }


    public static PartyFlatData Party_DemoCustomer() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustomer")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_EuroCustomer() {
        return PartyFlatData.newBuilder()
            .setPartyId("EuroCustomer")
            .setPartyTypeId("PERSON")
            .setPreferredCurrencyUomId("EUR")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_FrenchCustomer() {
        return PartyFlatData.newBuilder()
            .setPartyId("FrenchCustomer")
            .setPartyTypeId("PERSON")
            .setPreferredCurrencyUomId("EUR")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustomer_9015_BILLING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9015")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustomer_9015_SHIPPING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9015")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustomer_9015_GENERAL_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9015")
            .setContactMechPurposeTypeId("GENERAL_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustomer_9025_PHONE_HOME_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9025")
            .setContactMechPurposeTypeId("PHONE_HOME")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustomer_9025_PHONE_SHIPPING_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9025")
            .setContactMechPurposeTypeId("PHONE_SHIPPING")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustomer_9027_PHONE_BILLING_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9027")
            .setContactMechPurposeTypeId("PHONE_BILLING")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustomer_9026_PRIMARY_EMAIL_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9026")
            .setContactMechPurposeTypeId("PRIMARY_EMAIL")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_EuroCustomer_EUROCUSTOMER_BILLING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("EUROCUSTOMER")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_EuroCustomer_EUROCUSTOMER_SHIPPING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("EUROCUSTOMER")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_EuroCustomer_EUROCUSTOMER_GENERAL_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("EUROCUSTOMER")
            .setContactMechPurposeTypeId("GENERAL_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_EuroCustomer_EURO01_PRIMARY_EMAIL_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("EURO01")
            .setContactMechPurposeTypeId("PRIMARY_EMAIL")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_FrenchCustomer_FRENCHCUSTOMER_BILLING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("FRENCHCUSTOMER")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setPartyId("FrenchCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_FrenchCustomer_FRENCHCUSTOMER_SHIPPING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("FRENCHCUSTOMER")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setPartyId("FrenchCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_FrenchCustomer_FRENCHCUSTOMER_GENERAL_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("FRENCHCUSTOMER")
            .setContactMechPurposeTypeId("GENERAL_LOCATION")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setPartyId("FrenchCustomer")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_FrenchCustomer_FRA01_PRIMARY_EMAIL_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("FRA01")
            .setContactMechPurposeTypeId("PRIMARY_EMAIL")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setPartyId("FrenchCustomer")
            .build();
    }


    public static PaymentMethodData PaymentMethod_9015() {
        return PaymentMethodData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .setPaymentMethodId("9015")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .build();
    }


    public static PaymentMethodData PaymentMethod_EUROCUSTOMER() {
        return PaymentMethodData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("EuroCustomer")
            .setPaymentMethodId("EUROCUSTOMER")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .build();
    }


    public static PaymentMethodData PaymentMethod_FRENCHCUSTOMER() {
        return PaymentMethodData.newBuilder()
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setPartyId("FrenchCustomer")
            .setPaymentMethodId("FRENCHCUSTOMER")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .build();
    }


    public static PersonFlatData Person_DemoCustomer() {
        return PersonFlatData.newBuilder()
            .setFirstName("Demo")
            .setLastName("Customer")
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PersonFlatData Person_EuroCustomer() {
        return PersonFlatData.newBuilder()
            .setFirstName("Euro")
            .setLastName("Customer")
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PersonFlatData Person_FrenchCustomer() {
        return PersonFlatData.newBuilder()
            .setFirstName("French")
            .setLastName("Customer")
            .setPartyId("FrenchCustomer")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoCustomer() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoCustomer")
            .setUserLoginId("DemoCustomer")
            .build();
    }


    public static UserLoginFlatData UserLogin_EuroCustomer() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("EuroCustomer")
            .setUserLoginId("EuroCustomer")
            .build();
    }


    public static UserLoginFlatData UserLogin_FrenchCustomer() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("FrenchCustomer")
            .setUserLoginId("FrenchCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer_9015_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9015")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer_9025_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9025")
            .setExtension("222")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer_9027_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9027")
            .setExtension("212")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer_9026_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9026")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_EuroCustomer_EUROCUSTOMER_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("EUROCUSTOMER")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_EuroCustomer_EURO01_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("EURO01")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("EuroCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_FrenchCustomer_FRENCHCUSTOMER_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("FRENCHCUSTOMER")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setPartyId("FrenchCustomer")
            .build();
    }


    public static PartyContactMechData PartyContactMech_FrenchCustomer_FRA01_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("FRA01")
            .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
            .setPartyId("FrenchCustomer")
            .build();
    }

}
