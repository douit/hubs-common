package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.TelecomNumberData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.ContactMechData;
import com.bluecc.hubs.stub.PostalAddressData;
import com.bluecc.hubs.stub.PartyRelationshipData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PartyContactMechPurposeData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class Customers_DemoCustAgent {
    public static PartyRoleData PartyRole_DemoCustAgent_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustAgent")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustAgent_AGENT() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustAgent")
            .setRoleTypeId("AGENT")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustAgent__NA_() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustAgent")
            .setRoleTypeId("_NA_")
            .build();
    }


    public static TelecomNumberData TelecomNumber_9022() {
        return TelecomNumberData.newBuilder()
            .setAreaCode("801")
            .setContactMechId("9022")
            .setContactNumber("555-5555")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoCustAgent_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoCustAgent")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static ContactMechData ContactMech_9011() {
        return ContactMechData.newBuilder()
            .setContactMechId("9011")
            .setContactMechTypeId("POSTAL_ADDRESS")
            .build();
    }


    public static ContactMechData ContactMech_9022() {
        return ContactMechData.newBuilder()
            .setContactMechId("9022")
            .setContactMechTypeId("TELECOM_NUMBER")
            .build();
    }


    public static ContactMechData ContactMech_9023() {
        return ContactMechData.newBuilder()
            .setContactMechId("9023")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setInfoString("ofbiztest@example.com")
            .build();
    }


    public static PostalAddressData PostalAddress_9011() {
        return PostalAddressData.newBuilder()
            .setAddress1("2004 Factory Blvd")
            .setCity("Orem")
            .setContactMechId("9011")
            .setCountryGeoId("USA")
            .setGeoPointId("9000")
            .setPostalCode("84057")
            .setStateProvinceGeoId("UT")
            .setToName("Demo Customer Agent")
            .build();
    }


    public static PartyRelationshipData PartyRelationship_DemoCustCompany_DemoCustAgent_CUSTOMER_AGENT_() {
        return PartyRelationshipData.newBuilder()
            .setComments("Allows the DemoCustAgent to purchase on behalf of DemoCustCompany, ie purchase against BillingAccount")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyIdFrom("DemoCustCompany")
            .setPartyIdTo("DemoCustAgent")
            .setPartyRelationshipTypeId("AGENT")
            .setRoleTypeIdFrom("CUSTOMER")
            .setRoleTypeIdTo("AGENT")
            .build();
    }


    public static PartyRelationshipData PartyRelationship_DemoCustCompany_DemoCustAgent__NA___NA__() {
        return PartyRelationshipData.newBuilder()
            .setComments("Specifies the DemoCustAgent is a member of the DemoCustCompany, for Price Rules, Promos, etc")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyIdFrom("DemoCustCompany")
            .setPartyIdTo("DemoCustAgent")
            .setPartyRelationshipTypeId("GROUP_ROLLUP")
            .setRoleTypeIdFrom("_NA_")
            .setRoleTypeIdTo("_NA_")
            .build();
    }


    public static PartyFlatData Party_DemoCustAgent() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustAgent")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustAgent_9011_SHIPPING_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9011")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustAgent_9011_GENERAL_LOCATION_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9011")
            .setContactMechPurposeTypeId("GENERAL_LOCATION")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustAgent_9022_PHONE_WORK_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9022")
            .setContactMechPurposeTypeId("PHONE_WORK")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_DemoCustAgent_9023_PRIMARY_EMAIL_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("9023")
            .setContactMechPurposeTypeId("PRIMARY_EMAIL")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static PersonFlatData Person_DemoCustAgent() {
        return PersonFlatData.newBuilder()
            .setFirstName("Demo")
            .setLastName("Agent")
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoCustAgent() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoCustAgent")
            .setUserLoginId("DemoCustAgent")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustAgent_9011_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9011")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustAgent_9022_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9022")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustAgent")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustAgent_9023_() {
        return PartyContactMechData.newBuilder()
            .setAllowSolicitation(castIndicator("Y"))
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("DemoCustAgent")
            .build();
    }

}
