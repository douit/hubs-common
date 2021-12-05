package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;

public final class SecurityExtSeedData {
    public final static PartyRoleData PartyRole_system_PACKER = PartyRoleData.newBuilder()
        .setPartyId("system")
        .setRoleTypeId("PACKER")
        .build();


    public final static PartyStatusData PartyStatus_PARTY_ENABLED_system_ = PartyStatusData.newBuilder()
        .setPartyId("system")
        .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
        .setStatusId("PARTY_ENABLED")
        .build();


    public final static PartyFlatData Party_system = PartyFlatData.newBuilder()
        .setPartyId("system")
        .setPartyTypeId("PERSON")
        .setStatusId("PARTY_ENABLED")
        .build();


    public final static PersonFlatData Person_system = PersonFlatData.newBuilder()
        .setFirstName("System")
        .setLastName("Account")
        .setPartyId("system")
        .build();


    public final static UserLoginFlatData UserLogin_system = UserLoginFlatData.newBuilder()
        .setPartyId("system")
        .setUserLoginId("system")
        .build();

}
