package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Customers_DemoCustAgent.*;

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

public final class Customers_DemoCustAgentList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DemoCustAgent_CUSTOMER(),        
            PartyRole_DemoCustAgent_AGENT(),        
            PartyRole_DemoCustAgent__NA_());
    }

    public static List<TelecomNumberData> telecomNumberList() {
        return ImmutableList.of(        
            TelecomNumber_9022());
    }

    public static List<PartyStatusData> partyStatusList() {
        return ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_DemoCustAgent_());
    }

    public static List<ContactMechData> contactMechList() {
        return ImmutableList.of(        
            ContactMech_9011(),        
            ContactMech_9022(),        
            ContactMech_9023());
    }

    public static List<PostalAddressData> postalAddressList() {
        return ImmutableList.of(        
            PostalAddress_9011());
    }

    public static List<PartyRelationshipData> partyRelationshipList() {
        return ImmutableList.of(        
            PartyRelationship_DemoCustCompany_DemoCustAgent_CUSTOMER_AGENT_(),        
            PartyRelationship_DemoCustCompany_DemoCustAgent__NA___NA__());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_DemoCustAgent());
    }

    public static List<PartyContactMechPurposeData> partyContactMechPurposeList() {
        return ImmutableList.of(        
            PartyContactMechPurpose_DemoCustAgent_9011_SHIPPING_LOCATION_(),        
            PartyContactMechPurpose_DemoCustAgent_9011_GENERAL_LOCATION_(),        
            PartyContactMechPurpose_DemoCustAgent_9022_PHONE_WORK_(),        
            PartyContactMechPurpose_DemoCustAgent_9023_PRIMARY_EMAIL_());
    }

    public static List<PersonFlatData> personList() {
        return ImmutableList.of(        
            Person_DemoCustAgent());
    }

    public static List<UserLoginFlatData> userLoginList() {
        return ImmutableList.of(        
            UserLogin_DemoCustAgent());
    }

    public static List<PartyContactMechData> partyContactMechList() {
        return ImmutableList.of(        
            PartyContactMech_DemoCustAgent_9011_(),        
            PartyContactMech_DemoCustAgent_9022_(),        
            PartyContactMech_DemoCustAgent_9023_());
    }

}
