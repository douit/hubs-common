package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.TemporalExpressionData;
import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.FixedAssetFlatData;
import com.bluecc.hubs.stub.SecurityGroupFlatData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.WorkEffortFixedAssetAssignData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.TemporalExpressionAssocData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.WorkEffortAssocData;
import com.bluecc.hubs.stub.UserLoginFlatData;

public final class WorkEffortDemoData {
    public static PartyRoleData PartyRole_admin_CAL_OWNER() {
        return PartyRoleData.newBuilder()
            .setPartyId("admin")
            .setRoleTypeId("CAL_OWNER")
            .build();
    }


    public static PartyRoleData PartyRole_admin_CAL_ATTENDEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("admin")
            .setRoleTypeId("CAL_ATTENDEE")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee1_CAL_OWNER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("CAL_OWNER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee2_CAL_ATTENDEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("CAL_ATTENDEE")
            .build();
    }


    public static PartyRoleData PartyRole_DemoEmployee3_CAL_ATTENDEE() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("CAL_ATTENDEE")
            .build();
    }


    public static TemporalExpressionData TemporalExpression_STAFF_MTG() {
        return TemporalExpressionData.newBuilder()
            .setDescription("First Monday of Each Month")
            .setTempExprId("STAFF_MTG")
            .setTempExprTypeId("INTERSECTION")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_CALENDAR_PUB_DEMO_admin_CAL_OWNER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("admin")
            .setRoleTypeId("CAL_OWNER")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("CALENDAR_PUB_DEMO")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_PROJECT_PUB_DEMO_DemoEmployee1_CAL_OWNER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("CAL_OWNER")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("PROJECT_PUB_DEMO")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_STAFF_MTG_DemoEmployee1_CAL_OWNER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("CAL_OWNER")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("STAFF_MTG")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_STAFF_MTG_DemoEmployee2_CAL_ATTENDEE_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("CAL_ATTENDEE")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("STAFF_MTG")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_STAFF_MTG_DemoEmployee3_CAL_ATTENDEE_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("CAL_ATTENDEE")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("STAFF_MTG")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_STAFF_MTG_admin_CAL_ATTENDEE_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("admin")
            .setRoleTypeId("CAL_ATTENDEE")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("STAFF_MTG")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_OneOffMeeting_DemoEmployee1_CAL_OWNER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("CAL_OWNER")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("OneOffMeeting")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_OneOffMeeting_DemoEmployee2_CAL_ATTENDEE_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("CAL_ATTENDEE")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("OneOffMeeting")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_OneOffMeeting_admin_CAL_ATTENDEE_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("admin")
            .setRoleTypeId("CAL_ATTENDEE")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("OneOffMeeting")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_PrivateDemoEmployee1_DemoEmployee1_CAL_OWNER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setAvailabilityStatusId("WEPA_AV_BUSY")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("CAL_OWNER")
            .setStatusId("PRTYASGN_ASSIGNED")
            .setWorkEffortId("PrivateDemoEmployee1")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_WorkEffortUser_() {
        return PartyStatusData.newBuilder()
            .setPartyId("WorkEffortUser")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_DEMO_PROJECTOR() {
        return FixedAssetFlatData.newBuilder()
            .setFixedAssetId("DEMO_PROJECTOR")
            .setFixedAssetName("Overhead Projector")
            .setFixedAssetTypeId("EQUIPMENT")
            .setPurchaseCost(getCurrency("2000"))
            .setPurchaseCostUomId("USD")
            .build();
    }


    public static SecurityGroupFlatData SecurityGroup_WORKEFFORT_USER() {
        return SecurityGroupFlatData.newBuilder()
            .setDescription("WorkEffort user group; all limited workeffort permissions.")
            .setGroupId("WORKEFFORT_USER")
            .setGroupName("WorkEffort User")
            .build();
    }


    public static SecurityGroupFlatData SecurityGroup_WORKEFFORTADMIN() {
        return SecurityGroupFlatData.newBuilder()
            .setDescription("WorkEffort Admin group, has all workeffort permissions.")
            .setGroupId("WORKEFFORTADMIN")
            .setGroupName("WorkEffort Admin")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_STAFF_MTG() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("CAL_TENTATIVE")
            .setDescription("Staff Meeting")
            .setEstimatedMilliSeconds(3600000)
            .setEstimatedStartDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2008-01-01 00:00:00.0"))
            .setScopeEnumId("WES_PUBLIC")
            .setTempExprId("STAFF_MTG")
            .setWorkEffortId("STAFF_MTG")
            .setWorkEffortName("Staff Meeting")
            .setWorkEffortTypeId("MEETING")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_CALENDAR_PUB_DEMO() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("CAL_CANCELLED")
            .setDescription("Demo Project 1 Customer 1")
            .setScopeEnumId("WES_PUBLIC")
            .setWorkEffortId("CALENDAR_PUB_DEMO")
            .setWorkEffortName("iCalendar Publish Demonstration")
            .setWorkEffortTypeId("PUBLISH_PROPS")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_PROJECT_PUB_DEMO() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("CAL_CANCELLED")
            .setDescription("Demo Project 1 Customer 1")
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("PROJECT_PUB_DEMO")
            .setWorkEffortName("Project iCalendar Publish Demonstration")
            .setWorkEffortTypeId("PUBLISH_PROPS")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_OneOffMeeting() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("CAL_TENTATIVE")
            .setDescription("Staff Meeting")
            .setEstimatedCompletionDate(getTimestamp("2009-06-12 10:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2009-06-12 09:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2008-01-01 00:00:00.0"))
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("OneOffMeeting")
            .setWorkEffortName("One off Meeting june 12")
            .setWorkEffortTypeId("MEETING")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_PrivateDemoEmployee1() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("CAL_TENTATIVE")
            .setDescription("The birthday i should never forget")
            .setEstimatedCompletionDate(getTimestamp("2009-06-29 23:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2009-06-29 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2008-01-01 00:00:00.0"))
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("PrivateDemoEmployee1")
            .setWorkEffortName("My Wifes birthday june 29")
            .setWorkEffortTypeId("MEETING")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_PublicEvent() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("CAL_TENTATIVE")
            .setDescription("General Party")
            .setEstimatedCompletionDate(getTimestamp("2009-06-17 23:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2009-06-17 19:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2008-01-01 00:00:00.0"))
            .setLocationDesc("Tom's Banquet Hall")
            .setScopeEnumId("WES_PUBLIC")
            .setWorkEffortId("PublicEvent")
            .setWorkEffortName("The general company party june 17")
            .setWorkEffortTypeId("MEETING")
            .build();
    }


    public static WorkEffortFixedAssetAssignData WorkEffortFixedAssetAssign_STAFF_MTG_DEMO_PROJECTOR_() {
        return WorkEffortFixedAssetAssignData.newBuilder()
            .setAvailabilityStatusId("WEFA_IN_USE")
            .setFixedAssetId("DEMO_PROJECTOR")
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setStatusId("FA_ASGN_REQUESTED")
            .setWorkEffortId("STAFF_MTG")
            .build();
    }


    public static PartyFlatData Party_WorkEffortUser() {
        return PartyFlatData.newBuilder()
            .setPartyId("WorkEffortUser")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee1() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee1")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee2() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee2")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static PartyFlatData Party_DemoEmployee3() {
        return PartyFlatData.newBuilder()
            .setPartyId("DemoEmployee3")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FULLADMIN_WORKEFFORTMGR_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FULLADMIN")
            .setPermissionId("WORKEFFORTMGR_ADMIN")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("WORKEFFORTMGR_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("WORKEFFORTMGR_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("WORKEFFORTMGR_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("WORKEFFORTMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_ROLE_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("WORKEFFORTMGR_ROLE_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_ROLE_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("WORKEFFORTMGR_ROLE_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_ROLE_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("FLEXADMIN")
            .setPermissionId("WORKEFFORTMGR_ROLE_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_VIEWADMIN_WORKEFFORTMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("VIEWADMIN")
            .setPermissionId("WORKEFFORTMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_BIZADMIN_WORKEFFORTMGR_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("BIZADMIN")
            .setPermissionId("WORKEFFORTMGR_ADMIN")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("WORKEFFORT_USER")
            .setPermissionId("WORKEFFORTMGR_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("WORKEFFORT_USER")
            .setPermissionId("WORKEFFORTMGR_ROLE_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_CREATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("WORKEFFORT_USER")
            .setPermissionId("WORKEFFORTMGR_ROLE_CREATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_UPDATE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("WORKEFFORT_USER")
            .setPermissionId("WORKEFFORTMGR_ROLE_UPDATE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_DELETE_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("WORKEFFORT_USER")
            .setPermissionId("WORKEFFORTMGR_ROLE_DELETE")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_WORKEFFORT_USER_OFBTOOLS_VIEW_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("WORKEFFORT_USER")
            .setPermissionId("OFBTOOLS_VIEW")
            .build();
    }


    public static SecurityGroupPermissionData SecurityGroupPermission_WORKEFFORTADMIN_WORKEFFORTMGR_ADMIN_() {
        return SecurityGroupPermissionData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setGroupId("WORKEFFORTADMIN")
            .setPermissionId("WORKEFFORTMGR_ADMIN")
            .build();
    }


    public static TemporalExpressionAssocData TemporalExpressionAssoc_STAFF_MTG_1ST_MONDAY_IN_MONTH() {
        return TemporalExpressionAssocData.newBuilder()
            .setFromTempExprId("STAFF_MTG")
            .setToTempExprId("1ST_MONDAY_IN_MONTH")
            .build();
    }


    public static TemporalExpressionAssocData TemporalExpressionAssoc_STAFF_MTG_MINUTE_00() {
        return TemporalExpressionAssocData.newBuilder()
            .setFromTempExprId("STAFF_MTG")
            .setToTempExprId("MINUTE_00")
            .build();
    }


    public static TemporalExpressionAssocData TemporalExpressionAssoc_STAFF_MTG_HOUR_10() {
        return TemporalExpressionAssocData.newBuilder()
            .setFromTempExprId("STAFF_MTG")
            .setToTempExprId("HOUR_10")
            .build();
    }


    public static UserLoginSecurityGroupData UserLoginSecurityGroup_WorkEffortUser_WORKEFFORT_USER_() {
        return UserLoginSecurityGroupData.newBuilder()
            .setFromDate(getTimestamp("2011-01-01 00:00:00.0"))
            .setGroupId("WORKEFFORT_USER")
            .setUserLoginId("WorkEffortUser")
            .build();
    }


    public static PersonFlatData Person_WorkEffortUser() {
        return PersonFlatData.newBuilder()
            .setFirstName("WorkEffort")
            .setLastName("User")
            .setPartyId("WorkEffortUser")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_CALENDAR_PUB_DEMO_STAFF_MTG_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("CALENDAR_PUB_DEMO")
            .setWorkEffortIdTo("STAFF_MTG")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_PROJECT_PUB_DEMO_OneOffMeeting_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("PROJECT_PUB_DEMO")
            .setWorkEffortIdTo("OneOffMeeting")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_PROJECT_PUB_DEMO_PrivateDemoEmployee1_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("PROJECT_PUB_DEMO")
            .setWorkEffortIdTo("PrivateDemoEmployee1")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_PROJECT_PUB_DEMO_PublicEvent_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2008-01-01 00:00:00.0"))
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("PROJECT_PUB_DEMO")
            .setWorkEffortIdTo("PublicEvent")
            .build();
    }


    public static UserLoginFlatData UserLogin_WorkEffortUser() {
        return UserLoginFlatData.newBuilder()
            .setCurrentPassword("{SHA}47b56994cbc2b6d10aa1be30f70165adb305a41a")
            .setPartyId("WorkEffortUser")
            .setUserLoginId("WorkEffortUser")
            .build();
    }

}
