package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.WorkEffortSeedData.*;

import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.ContactMechTypeData;
import com.bluecc.hubs.stub.RoleTypeData;
import com.bluecc.hubs.stub.WorkEffortTypeData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.WorkEffortAssocTypeData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.hubs.stub.ContactMechTypePurposeData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.SecurityGroupPermissionData;
import com.bluecc.hubs.stub.WorkEffortContentTypeData;
import com.bluecc.hubs.stub.WorkEffortGoodStandardTypeData;
import com.bluecc.hubs.stub.SecurityPermissionData;
import com.bluecc.hubs.stub.WorkEffortPurposeTypeData;
import com.bluecc.hubs.stub.ContactMechPurposeTypeData;

public final class WorkEffortSeedDataList {
    public static final List<EnumerationData> enumerationList=ImmutableList.of(        
            Enumeration_WEE_FYI,        
            Enumeration_WEE_REQUIRE,        
            Enumeration_WEE_REQUEST,        
            Enumeration_WEE_IMMEDIATE,        
            Enumeration_WEDR_NEED_HELP,        
            Enumeration_WEDR_PART_FINISHED,        
            Enumeration_WEDR_WHOLE_FINISHED,        
            Enumeration_WES_PUBLIC,        
            Enumeration_WES_PRIVATE,        
            Enumeration_WES_CONFIDENTIAL,        
            Enumeration_CAL_PERSONAL,        
            Enumeration_CAL_MANUFACTURING,        
            Enumeration_CAL_NONE);

    public static final List<ContactMechTypeData> contactMechTypeList=ImmutableList.of(        
            ContactMechType_LDAP_ADDRESS);

    public static final List<RoleTypeData> roleTypeList=ImmutableList.of(        
            RoleType_ICAL_MEMBER);

    public static final List<WorkEffortTypeData> workEffortTypeList=ImmutableList.of(        
            WorkEffortType_ROUTING,        
            WorkEffortType_ROU_TASK,        
            WorkEffortType_PROD_ORDER_HEADER,        
            WorkEffortType_PROD_ORDER_TASK,        
            WorkEffortType_ASSET_USAGE,        
            WorkEffortType_EVENT,        
            WorkEffortType_SHIPMENT_INBOUND,        
            WorkEffortType_SHIPMENT_OUTBOUND,        
            WorkEffortType_BUSINESS_TRAVEL,        
            WorkEffortType_MEETING,        
            WorkEffortType_TRAINING,        
            WorkEffortType_PERSONAL_TIMEOFF,        
            WorkEffortType_PUBLISH_PROPS);

    public static final List<EnumerationTypeData> enumerationTypeList=ImmutableList.of(        
            EnumerationType_WORK_EFFORT,        
            EnumerationType_WORKFLOW,        
            EnumerationType_WORK_EFF_EXPECT,        
            EnumerationType_WORK_EFF_DEL_REAS,        
            EnumerationType_WORK_EFF_SCOPE,        
            EnumerationType_CALENDAR_TYPE);

    public static final List<WorkEffortAssocTypeData> workEffortAssocTypeList=ImmutableList.of(        
            WorkEffortAssocType_WORK_EFF_BREAKDOWN,        
            WorkEffortAssocType_WORK_EFF_DEPENDENCY,        
            WorkEffortAssocType_WORK_EFF_CONCURRENCY,        
            WorkEffortAssocType_WORK_EFF_PRECEDENCY,        
            WorkEffortAssocType_WORK_EFF_TEMPLATE,        
            WorkEffortAssocType_ROUTING_COMPONENT);

    public static final List<StatusItemData> statusItemList=ImmutableList.of(        
            StatusItem_CAL_IN_PLANNING,        
            StatusItem_CAL_PLANNED,        
            StatusItem_CAL_NEEDS_ACTION,        
            StatusItem_CAL_SENT,        
            StatusItem_CAL_DECLINED,        
            StatusItem_CAL_DELEGATED,        
            StatusItem_CAL_CANCELLED,        
            StatusItem_CAL_ACCEPTED,        
            StatusItem_CAL_COMPLETED,        
            StatusItem_CAL_TENTATIVE,        
            StatusItem_CAL_CONFIRMED,        
            StatusItem_TIMESHEET_IN_PROCESS,        
            StatusItem_TIMESHEET_COMPLETED,        
            StatusItem_TIMESHEET_APPROVED,        
            StatusItem_ROU_ACTIVE,        
            StatusItem_ROU_INACTIVE,        
            StatusItem_PRUN_CREATED,        
            StatusItem_PRUN_SCHEDULED,        
            StatusItem_PRUN_DOC_PRINTED,        
            StatusItem_PRUN_RUNNING,        
            StatusItem_PRUN_COMPLETED,        
            StatusItem_PRUN_CLOSED,        
            StatusItem_PRUN_CANCELLED,        
            StatusItem_WEGS_CREATED,        
            StatusItem_WEGS_COMPLETED,        
            StatusItem_WEGS_CANCELLED,        
            StatusItem_WERV_PENDING,        
            StatusItem_WERV_APPROVED,        
            StatusItem_WERV_DELETED);

    public static final List<StatusValidChangeData> statusValidChangeList=ImmutableList.of(        
            StatusValidChange_CAL_IN_PLANNING_CAL_PLANNED,        
            StatusValidChange_CAL_IN_PLANNING_CAL_NEEDS_ACTION,        
            StatusValidChange_CAL_PLANNED_CAL_NEEDS_ACTION,        
            StatusValidChange_CAL_NEEDS_ACTION_CAL_SENT,        
            StatusValidChange_CAL_NEEDS_ACTION_CAL_CANCELLED,        
            StatusValidChange_CAL_SENT_CAL_DECLINED,        
            StatusValidChange_CAL_SENT_CAL_DELEGATED,        
            StatusValidChange_CAL_SENT_CAL_CANCELLED,        
            StatusValidChange_CAL_NEEDS_ACTION_CAL_COMPLETED,        
            StatusValidChange_CAL_SENT_CAL_ACCEPTED,        
            StatusValidChange_CAL_ACCEPTED_CAL_COMPLETED,        
            StatusValidChange_CAL_ACCEPTED_CAL_CANCELLED,        
            StatusValidChange_CAL_ACCEPTED_CAL_DELEGATED,        
            StatusValidChange_CAL_NEEDS_ACTION_CAL_TENTATIVE,        
            StatusValidChange_CAL_NEEDS_ACTION_CAL_CONFIRMED,        
            StatusValidChange_CAL_TENTATIVE_CAL_ACCEPTED,        
            StatusValidChange_CAL_TENTATIVE_CAL_DECLINED,        
            StatusValidChange_CAL_TENTATIVE_CAL_DELEGATED,        
            StatusValidChange_CAL_TENTATIVE_CAL_CANCELLED,        
            StatusValidChange_CAL_TENTATIVE_CAL_CONFIRMED,        
            StatusValidChange_CAL_CONFIRMED_CAL_COMPLETED,        
            StatusValidChange_TIMESHEET_IN_PROCESS_TIMESHEET_COMPLETED,        
            StatusValidChange_TIMESHEET_COMPLETED_TIMESHEET_APPROVED,        
            StatusValidChange_PRUN_CREATED_PRUN_DOC_PRINTED,        
            StatusValidChange_PRUN_CREATED_PRUN_SCHEDULED,        
            StatusValidChange_PRUN_CREATED_PRUN_RUNNING,        
            StatusValidChange_PRUN_SCHEDULED_PRUN_DOC_PRINTED,        
            StatusValidChange_PRUN_SCHEDULED_PRUN_RUNNING,        
            StatusValidChange_PRUN_SCHEDULED_PRUN_CANCELLED,        
            StatusValidChange_PRUN_DOC_PRINTED_PRUN_RUNNING,        
            StatusValidChange_PRUN_RUNNING_PRUN_COMPLETED,        
            StatusValidChange_PRUN_COMPLETED_PRUN_CLOSED,        
            StatusValidChange_PRUN_CREATED_PRUN_CANCELLED,        
            StatusValidChange_ROU_ACTIVE_ROU_INACTIVE,        
            StatusValidChange_ROU_INACTIVE_ROU_ACTIVE,        
            StatusValidChange_WERV_PENDING_WERV_APPROVED,        
            StatusValidChange_WERV_PENDING_WERV_DELETED,        
            StatusValidChange_WERV_APPROVED_WERV_DELETED);

    public static final List<ContactMechTypePurposeData> contactMechTypePurposeList=ImmutableList.of(        
            ContactMechTypePurpose_EMAIL_ADDRESS_ICAL_URL,        
            ContactMechTypePurpose_LDAP_ADDRESS_ICAL_URL,        
            ContactMechTypePurpose_WEB_ADDRESS_ICAL_URL);

    public static final List<StatusTypeData> statusTypeList=ImmutableList.of(        
            StatusType_WORK_EFF_ASSET_STTS,        
            StatusType_WORK_EFFORT_ASSIGN,        
            StatusType_WORK_EFFORT_STATUS,        
            StatusType_CALENDAR_STATUS,        
            StatusType_TASK_STATUS,        
            StatusType_EVENT_STATUS,        
            StatusType_TIMESHEET_STATUS,        
            StatusType_ROUTING_STATUS,        
            StatusType_PRODUCTION_RUN,        
            StatusType_WEFG_STATUS,        
            StatusType_WEFF_REVIEW_STTS);

    public static final List<SecurityGroupPermissionData> securityGroupPermissionList=ImmutableList.of(        
            SecurityGroupPermission_SUPER_WORKEFFORTMGR_ADMIN_);

    public static final List<WorkEffortContentTypeData> workEffortContentTypeList=ImmutableList.of(        
            WorkEffortContentType_PROPOSAL_MEDIA,        
            WorkEffortContentType_SUPPORTING_MEDIA,        
            WorkEffortContentType_CREATED_MEDIA);

    public static final List<WorkEffortGoodStandardTypeData> workEffortGoodStandardTypeList=ImmutableList.of(        
            WorkEffortGoodStandardType_ROU_PROD_TEMPLATE,        
            WorkEffortGoodStandardType_PRUN_PROD_DELIV,        
            WorkEffortGoodStandardType_PRUNT_PROD_NEEDED,        
            WorkEffortGoodStandardType_PRUNT_PROD_DELIV,        
            WorkEffortGoodStandardType_GENERAL_SALES);

    public static final List<SecurityPermissionData> securityPermissionList=ImmutableList.of(        
            SecurityPermission_WORKEFFORTMGR_VIEW,        
            SecurityPermission_WORKEFFORTMGR_CREATE,        
            SecurityPermission_WORKEFFORTMGR_UPDATE,        
            SecurityPermission_WORKEFFORTMGR_DELETE,        
            SecurityPermission_WORKEFFORTMGR_ROLE_VIEW,        
            SecurityPermission_WORKEFFORTMGR_ROLE_CREATE,        
            SecurityPermission_WORKEFFORTMGR_ROLE_UPDATE,        
            SecurityPermission_WORKEFFORTMGR_ROLE_DELETE,        
            SecurityPermission_WORKEFFORTMGR_ADMIN);

    public static final List<WorkEffortPurposeTypeData> workEffortPurposeTypeList=ImmutableList.of(        
            WorkEffortPurposeType_WEPT_PRODUCTION_RUN,        
            WorkEffortPurposeType_WEPT_MAINTENANCE,        
            WorkEffortPurposeType_WEPT_RESEARCH,        
            WorkEffortPurposeType_WEPT_MEETING,        
            WorkEffortPurposeType_WEPT_DEVELOPMENT,        
            WorkEffortPurposeType_WEPT_SUPPORT,        
            WorkEffortPurposeType_WEPT_DEPLOYMENT,        
            WorkEffortPurposeType_WEPT_WAREHOUSING,        
            WorkEffortPurposeType_ROU_MANUFACTURING,        
            WorkEffortPurposeType_ROU_ASSEMBLING,        
            WorkEffortPurposeType_ROU_SUBCONTRACTING,        
            WorkEffortPurposeType_WEPT_TASK_PHONE_CALL,        
            WorkEffortPurposeType_WEPT_TASK_EMAIL);

    public static final List<ContactMechPurposeTypeData> contactMechPurposeTypeList=ImmutableList.of(        
            ContactMechPurposeType_ICAL_URL);

}
