package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.WorkEffortDemoData.*;

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

public final class WorkEffortDemoDataList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_admin_CAL_OWNER(),        
            PartyRole_admin_CAL_ATTENDEE(),        
            PartyRole_DemoEmployee1_CAL_OWNER(),        
            PartyRole_DemoEmployee2_CAL_ATTENDEE(),        
            PartyRole_DemoEmployee3_CAL_ATTENDEE());
    }

    public static List<TemporalExpressionData> temporalExpressionList() {
        return ImmutableList.of(        
            TemporalExpression_STAFF_MTG());
    }

    public static List<WorkEffortPartyAssignmentData> workEffortPartyAssignmentList() {
        return ImmutableList.of(        
            WorkEffortPartyAssignment_CALENDAR_PUB_DEMO_admin_CAL_OWNER_(),        
            WorkEffortPartyAssignment_PROJECT_PUB_DEMO_DemoEmployee1_CAL_OWNER_(),        
            WorkEffortPartyAssignment_STAFF_MTG_DemoEmployee1_CAL_OWNER_(),        
            WorkEffortPartyAssignment_STAFF_MTG_DemoEmployee2_CAL_ATTENDEE_(),        
            WorkEffortPartyAssignment_STAFF_MTG_DemoEmployee3_CAL_ATTENDEE_(),        
            WorkEffortPartyAssignment_STAFF_MTG_admin_CAL_ATTENDEE_(),        
            WorkEffortPartyAssignment_OneOffMeeting_DemoEmployee1_CAL_OWNER_(),        
            WorkEffortPartyAssignment_OneOffMeeting_DemoEmployee2_CAL_ATTENDEE_(),        
            WorkEffortPartyAssignment_OneOffMeeting_admin_CAL_ATTENDEE_(),        
            WorkEffortPartyAssignment_PrivateDemoEmployee1_DemoEmployee1_CAL_OWNER_());
    }

    public static List<PartyStatusData> partyStatusList() {
        return ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_WorkEffortUser_());
    }

    public static List<FixedAssetFlatData> fixedAssetList() {
        return ImmutableList.of(        
            FixedAsset_DEMO_PROJECTOR());
    }

    public static List<SecurityGroupFlatData> securityGroupList() {
        return ImmutableList.of(        
            SecurityGroup_WORKEFFORT_USER(),        
            SecurityGroup_WORKEFFORTADMIN());
    }

    public static List<WorkEffortFlatData> workEffortList() {
        return ImmutableList.of(        
            WorkEffort_STAFF_MTG(),        
            WorkEffort_CALENDAR_PUB_DEMO(),        
            WorkEffort_PROJECT_PUB_DEMO(),        
            WorkEffort_OneOffMeeting(),        
            WorkEffort_PrivateDemoEmployee1(),        
            WorkEffort_PublicEvent());
    }

    public static List<WorkEffortFixedAssetAssignData> workEffortFixedAssetAssignList() {
        return ImmutableList.of(        
            WorkEffortFixedAssetAssign_STAFF_MTG_DEMO_PROJECTOR_());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_WorkEffortUser(),        
            Party_DemoEmployee1(),        
            Party_DemoEmployee2(),        
            Party_DemoEmployee3());
    }

    public static List<SecurityGroupPermissionData> securityGroupPermissionList() {
        return ImmutableList.of(        
            SecurityGroupPermission_FULLADMIN_WORKEFFORTMGR_ADMIN_(),        
            SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_DELETE_(),        
            SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_VIEW_(),        
            SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_ROLE_CREATE_(),        
            SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_ROLE_UPDATE_(),        
            SecurityGroupPermission_FLEXADMIN_WORKEFFORTMGR_ROLE_VIEW_(),        
            SecurityGroupPermission_VIEWADMIN_WORKEFFORTMGR_VIEW_(),        
            SecurityGroupPermission_BIZADMIN_WORKEFFORTMGR_ADMIN_(),        
            SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_VIEW_(),        
            SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_VIEW_(),        
            SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_CREATE_(),        
            SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_UPDATE_(),        
            SecurityGroupPermission_WORKEFFORT_USER_WORKEFFORTMGR_ROLE_DELETE_(),        
            SecurityGroupPermission_WORKEFFORT_USER_OFBTOOLS_VIEW_(),        
            SecurityGroupPermission_WORKEFFORTADMIN_WORKEFFORTMGR_ADMIN_());
    }

    public static List<TemporalExpressionAssocData> temporalExpressionAssocList() {
        return ImmutableList.of(        
            TemporalExpressionAssoc_STAFF_MTG_1ST_MONDAY_IN_MONTH(),        
            TemporalExpressionAssoc_STAFF_MTG_MINUTE_00(),        
            TemporalExpressionAssoc_STAFF_MTG_HOUR_10());
    }

    public static List<UserLoginSecurityGroupData> userLoginSecurityGroupList() {
        return ImmutableList.of(        
            UserLoginSecurityGroup_WorkEffortUser_WORKEFFORT_USER_());
    }

    public static List<PersonFlatData> personList() {
        return ImmutableList.of(        
            Person_WorkEffortUser());
    }

    public static List<WorkEffortAssocData> workEffortAssocList() {
        return ImmutableList.of(        
            WorkEffortAssoc_CALENDAR_PUB_DEMO_STAFF_MTG_WORK_EFF_DEPENDENCY_(),        
            WorkEffortAssoc_PROJECT_PUB_DEMO_OneOffMeeting_WORK_EFF_DEPENDENCY_(),        
            WorkEffortAssoc_PROJECT_PUB_DEMO_PrivateDemoEmployee1_WORK_EFF_DEPENDENCY_(),        
            WorkEffortAssoc_PROJECT_PUB_DEMO_PublicEvent_WORK_EFF_DEPENDENCY_());
    }

    public static List<UserLoginFlatData> userLoginList() {
        return ImmutableList.of(        
            UserLogin_WorkEffortUser());
    }

}
