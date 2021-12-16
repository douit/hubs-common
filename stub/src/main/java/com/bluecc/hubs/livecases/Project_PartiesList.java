package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Project_Parties.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class Project_PartiesList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DemoEmployee_EMPLOYEE(),        
            PartyRole_DemoEmployee_PROVIDER_ANALYST(),        
            PartyRole_DemoEmployee_PROJECT_TEAM(),        
            PartyRole_DemoEmployee1_EMPLOYEE(),        
            PartyRole_DemoEmployee1_PROVIDER_MANAGER(),        
            PartyRole_DemoEmployee1_PROJECT_TEAM(),        
            PartyRole_DemoEmployee2_PROVIDER_ANALYST(),        
            PartyRole_DemoEmployee2_EMPLOYEE(),        
            PartyRole_DemoEmployee2_PROJECT_TEAM(),        
            PartyRole_DemoEmployee3_PROVIDER_ANALYST(),        
            PartyRole_DemoEmployee3_EMPLOYEE(),        
            PartyRole_DemoEmployee3_PROJECT_TEAM(),        
            PartyRole_DemoCustomer1_CUSTOMER(),        
            PartyRole_DemoCustomer1_CLIENT_MANAGER(),        
            PartyRole_DemoCustomer1_PROJECT_TEAM(),        
            PartyRole_DemoCustomer2_CUSTOMER(),        
            PartyRole_DemoCustomer2_CLIENT_MANAGER(),        
            PartyRole_DemoCustomer2_PROJECT_TEAM(),        
            PartyRole_DemoCustomer3_CUSTOMER(),        
            PartyRole_DemoCustomer3_CLIENT_BILLING(),        
            PartyRole_DemoCustomer3_PROJECT_TEAM(),        
            PartyRole_admin_PROJECT_TEAM(),        
            PartyRole_admin_PROVIDER_MANAGER(),        
            PartyRole_DemoCustCompany_CLIENT_BILLING());
    }

    public static List<PartyStatusData> partyStatusList() {
        return ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_DemoEmployee_(),        
            PartyStatus_PARTY_ENABLED_DemoEmployee1_(),        
            PartyStatus_PARTY_ENABLED_DemoEmployee2_(),        
            PartyStatus_PARTY_ENABLED_DemoEmployee3_(),        
            PartyStatus_PARTY_ENABLED_DemoCustomer1_(),        
            PartyStatus_PARTY_ENABLED_DemoCustomer2_(),        
            PartyStatus_PARTY_ENABLED_DemoCustomer3_());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_DemoEmployee(),        
            Party_DemoEmployee1(),        
            Party_DemoEmployee2(),        
            Party_DemoEmployee3(),        
            Party_DemoCustomer1(),        
            Party_DemoCustomer2(),        
            Party_DemoCustomer3());
    }

    public static List<SecurityGroupPermissionData> securityGroupPermissionList() {
        return ImmutableList.of(        
            SecurityGroupPermission_FLEXADMIN_PROJECTMGR_VIEW_(),        
            SecurityGroupPermission_FLEXADMIN_PROJECTMGR_ROLE_TIMESHEET_CREATE_(),        
            SecurityGroupPermission_VIEWADMIN_PROJECTMGR_VIEW_(),        
            SecurityGroupPermission_VIEWADMIN_PROJECTMGR_ROLE_TIMESHEET_CREATE_(),        
            SecurityGroupPermission_BIZADMIN_PROJECTMGR_VIEW_(),        
            SecurityGroupPermission_BIZADMIN_PROJECTMGR_ROLE_TIMESHEET_CREATE_());
    }

    public static List<UserLoginSecurityGroupData> userLoginSecurityGroupList() {
        return ImmutableList.of(        
            UserLoginSecurityGroup_DemoEmployee_PROJECTADMIN_(),        
            UserLoginSecurityGroup_DemoEmployee1_PROJECTADMIN_(),        
            UserLoginSecurityGroup_DemoEmployee2_PROJECTUSER_(),        
            UserLoginSecurityGroup_DemoEmployee3_PROJECTUSER_(),        
            UserLoginSecurityGroup_DemoCustomer1_PROJECTUSER_(),        
            UserLoginSecurityGroup_DemoCustomer2_PROJECTUSER_(),        
            UserLoginSecurityGroup_DemoCustomer3_PROJECTUSER_());
    }

    public static List<PersonFlatData> personList() {
        return ImmutableList.of(        
            Person_DemoEmployee(),        
            Person_DemoEmployee1(),        
            Person_DemoEmployee2(),        
            Person_DemoEmployee3(),        
            Person_DemoCustomer1(),        
            Person_DemoCustomer2(),        
            Person_DemoCustomer3());
    }

    public static List<UserLoginFlatData> userLoginList() {
        return ImmutableList.of(        
            UserLogin_DemoEmployee(),        
            UserLogin_DemoEmployee1(),        
            UserLogin_DemoEmployee2(),        
            UserLogin_DemoEmployee3(),        
            UserLogin_DemoCustomer1(),        
            UserLogin_DemoCustomer2(),        
            UserLogin_DemoCustomer3());
    }

    public static List<PartyContactMechData> partyContactMechList() {
        return ImmutableList.of(        
            PartyContactMech_DemoEmployee_9020_(),        
            PartyContactMech_DemoEmployee_9001_(),        
            PartyContactMech_DemoEmployee_9023_(),        
            PartyContactMech_DemoEmployee1_9020_(),        
            PartyContactMech_DemoEmployee1_9001_(),        
            PartyContactMech_DemoEmployee1_9023_(),        
            PartyContactMech_DemoEmployee2_9020_(),        
            PartyContactMech_DemoEmployee2_9001_(),        
            PartyContactMech_DemoEmployee2_9023_(),        
            PartyContactMech_DemoEmployee3_9020_(),        
            PartyContactMech_DemoEmployee3_9001_(),        
            PartyContactMech_DemoEmployee3_9023_(),        
            PartyContactMech_DemoCustomer1_9020_(),        
            PartyContactMech_DemoCustomer1_9001_(),        
            PartyContactMech_DemoCustomer1_9023_(),        
            PartyContactMech_DemoCustomer2_9020_(),        
            PartyContactMech_DemoCustomer2_9001_(),        
            PartyContactMech_DemoCustomer2_9023_(),        
            PartyContactMech_DemoCustomer3_9020_(),        
            PartyContactMech_DemoCustomer3_9001_(),        
            PartyContactMech_DemoCustomer3_9023_());
    }

}
