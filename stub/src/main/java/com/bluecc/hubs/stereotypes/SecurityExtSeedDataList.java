package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.SecurityExtSeedData.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;

public final class SecurityExtSeedDataList {
    public static final List<PartyRoleData> partyRoleList=ImmutableList.of(        
            PartyRole_system_PACKER);

    public static final List<PartyStatusData> partyStatusList=ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_system_);

    public static final List<PartyFlatData> partyList=ImmutableList.of(        
            Party_system);

    public static final List<PersonFlatData> personList=ImmutableList.of(        
            Person_system);

    public static final List<UserLoginFlatData> userLoginList=ImmutableList.of(        
            UserLogin_system);

}
