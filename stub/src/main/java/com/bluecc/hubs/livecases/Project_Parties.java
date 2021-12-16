package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class Project_Parties {
    public static PartyRoleData PartyRole_DemoEmployee_EMPLOYEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee_PROVIDER_ANALYST() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee")
            .setRoleTypeId("PROVIDER_ANALYST")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee1_EMPLOYEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee1_PROVIDER_MANAGER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("PROVIDER_MANAGER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee1_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee2_PROVIDER_ANALYST() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("PROVIDER_ANALYST")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee2_EMPLOYEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee2_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee3_PROVIDER_ANALYST() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("PROVIDER_ANALYST")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee3_EMPLOYEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee3_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer1_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer1")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer1_CLIENT_MANAGER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer1")
            .setRoleTypeId("CLIENT_MANAGER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer1_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer1")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer2_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer2")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer2_CLIENT_MANAGER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer2")
            .setRoleTypeId("CLIENT_MANAGER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer2_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer2")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer3_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer3_CLIENT_BILLING() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("CLIENT_BILLING")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer3_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_admin_PROJECT_TEAM() {
        return PartyRoleData.newBuilder()
            .setPartyId("admin")
            .setRoleTypeId("PROJECT_TEAM")
            .build();
    }


    public static PartyRoleData PartyRole_admin_PROVIDER_MANAGER() {
        return PartyRoleData.newBuilder()
            .setPartyId("admin")
            .setRoleTypeId("PROVIDER_MANAGER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustCompany_CLIENT_BILLING() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustCompany")
            .setRoleTypeId("CLIENT_BILLING")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoEmployee_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoEmployee")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoEmployee1_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoEmployee2_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoEmployee3_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoCustomer1_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoCustomer1")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoCustomer2_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoCustomer2")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_DemoCustomer3_() {
        return PartyStatusData.newBuilder()
            .setPartyId("DemoCustomer3")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee1() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee2() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee3() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoCustomer1() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustomer1")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoCustomer2() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustomer2")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoCustomer3() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoCustomer3")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PROJECTMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PROJECTMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_PROJECTMGR_ROLE_TIMESHEET_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("PROJECTMGR_ROLE_TIMESHEET_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_VIEWADMIN_PROJECTMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setPermissionId("PROJECTMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_VIEWADMIN_PROJECTMGR_ROLE_TIMESHEET_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setPermissionId("PROJECTMGR_ROLE_TIMESHEET_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_BIZADMIN_PROJECTMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("BIZADMIN")
            .setPermissionId("PROJECTMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_BIZADMIN_PROJECTMGR_ROLE_TIMESHEET_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("BIZADMIN")
            .setPermissionId("PROJECTMGR_ROLE_TIMESHEET_CREATE")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoEmployee_PROJECTADMIN_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setGroupId("PROJECTADMIN")
            .setUserLoginId("DemoEmployee")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoEmployee1_PROJECTADMIN_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setGroupId("PROJECTADMIN")
            .setUserLoginId("DemoEmployee1")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoEmployee2_PROJECTUSER_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setGroupId("PROJECTUSER")
            .setUserLoginId("DemoEmployee2")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoEmployee3_PROJECTUSER_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setGroupId("PROJECTUSER")
            .setUserLoginId("DemoEmployee3")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoCustomer1_PROJECTUSER_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setGroupId("PROJECTUSER")
            .setUserLoginId("DemoCustomer1")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoCustomer2_PROJECTUSER_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setGroupId("PROJECTUSER")
            .setUserLoginId("DemoCustomer2")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoCustomer3_PROJECTUSER_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setGroupId("PROJECTUSER")
            .setUserLoginId("DemoCustomer3")
            .build();
    }


    public static PersonFlatData Person_DemoEmployee() {
        return PersonFlatData.newBuilder()
            .setFirstName("Demo")
            .setLastName("Employee")
            .setPartyId("DemoEmployee")
            .build();
    }


    public static PersonFlatData Person_DemoEmployee1() {
        return PersonFlatData.newBuilder()
            .setFirstName("Peter")
            .setLastName("Manager")
            .setPartyId("DemoEmployee1")
            .build();
    }


    public static PersonFlatData Person_DemoEmployee2() {
        return PersonFlatData.newBuilder()
            .setFirstName("Jo")
            .setLastName("Analist1")
            .setPartyId("DemoEmployee2")
            .build();
    }


    public static PersonFlatData Person_DemoEmployee3() {
        return PersonFlatData.newBuilder()
            .setFirstName("Tom")
            .setLastName("Analist2")
            .setPartyId("DemoEmployee3")
            .build();
    }


    public static PersonFlatData Person_DemoCustomer1() {
        return PersonFlatData.newBuilder()
            .setFirstName("ManagerP1")
            .setLastName("Customer 1")
            .setPartyId("DemoCustomer1")
            .build();
    }


    public static PersonFlatData Person_DemoCustomer2() {
        return PersonFlatData.newBuilder()
            .setFirstName("ManagerP2")
            .setLastName("Customer 2")
            .setPartyId("DemoCustomer2")
            .build();
    }


    public static PersonFlatData Person_DemoCustomer3() {
        return PersonFlatData.newBuilder()
            .setFirstName("Billing")
            .setLastName("Customer 3")
            .setPartyId("DemoCustomer3")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoEmployee() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoEmployee")
            .setUserLoginId("DemoEmployee")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoEmployee1() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setUserLoginId("DemoEmployee1")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoEmployee2() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setUserLoginId("DemoEmployee2")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoEmployee3() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setUserLoginId("DemoEmployee3")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoCustomer1() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoCustomer1")
            .setUserLoginId("DemoCustomer1")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoCustomer2() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoCustomer2")
            .setUserLoginId("DemoCustomer2")
            .build();
    }


    public static UserLoginFlatData UserLogin_DemoCustomer3() {
        return UserLoginFlatData.newBuilder()
            .setPartyId("DemoCustomer3")
            .setUserLoginId("DemoCustomer3")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee_9020_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee_9001_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee_9023_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee1_9020_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee1_9001_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee1_9023_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee2_9020_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee2_9001_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee2_9023_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee3_9020_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee3_9001_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoEmployee3_9023_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("EMPLOYEE")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer1_9020_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer1")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer1_9001_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer1")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer1_9023_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer1")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer2_9020_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer2")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer2_9001_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer2")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer2_9023_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer2")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer3_9020_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9020")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer3_9001_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9001")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_DemoCustomer3_9023_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("9023")
            .setFromDate(getTimestamp("2000-01-01 10:01:48.933"))
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("CUSTOMER")
            .build();
    }

}
