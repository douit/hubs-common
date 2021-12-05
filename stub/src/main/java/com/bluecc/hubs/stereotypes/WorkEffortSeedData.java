package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
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

public final class WorkEffortSeedData {
    public final static EnumerationData Enumeration_WEE_FYI = EnumerationData.newBuilder()
        .setDescription("For Your Information")
        .setEnumCode("FYI")
        .setEnumId("WEE_FYI")
        .setEnumTypeId("WORK_EFF_EXPECT")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_WEE_REQUIRE = EnumerationData.newBuilder()
        .setDescription("Involvement Required")
        .setEnumCode("REQUIRE")
        .setEnumId("WEE_REQUIRE")
        .setEnumTypeId("WORK_EFF_EXPECT")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_WEE_REQUEST = EnumerationData.newBuilder()
        .setDescription("Involvement Requested")
        .setEnumCode("REQUEST")
        .setEnumId("WEE_REQUEST")
        .setEnumTypeId("WORK_EFF_EXPECT")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_WEE_IMMEDIATE = EnumerationData.newBuilder()
        .setDescription("Immediate Response Requested")
        .setEnumCode("IMMEDIATE")
        .setEnumId("WEE_IMMEDIATE")
        .setEnumTypeId("WORK_EFF_EXPECT")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_WEDR_NEED_HELP = EnumerationData.newBuilder()
        .setDescription("Need Support or Help")
        .setEnumCode("NEED_HELP")
        .setEnumId("WEDR_NEED_HELP")
        .setEnumTypeId("WORK_EFF_DEL_REAS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_WEDR_PART_FINISHED = EnumerationData.newBuilder()
        .setDescription("My Part Finished")
        .setEnumCode("PART_FINISHED")
        .setEnumId("WEDR_PART_FINISHED")
        .setEnumTypeId("WORK_EFF_DEL_REAS")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_WEDR_WHOLE_FINISHED = EnumerationData.newBuilder()
        .setDescription("Completely Finished")
        .setEnumCode("WHOLE_FINISHED")
        .setEnumId("WEDR_WHOLE_FINISHED")
        .setEnumTypeId("WORK_EFF_DEL_REAS")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_WES_PUBLIC = EnumerationData.newBuilder()
        .setDescription("General, public access")
        .setEnumCode("PUBLIC")
        .setEnumId("WES_PUBLIC")
        .setEnumTypeId("WORK_EFF_SCOPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_WES_PRIVATE = EnumerationData.newBuilder()
        .setDescription("Restricted, private access")
        .setEnumCode("PRIVATE")
        .setEnumId("WES_PRIVATE")
        .setEnumTypeId("WORK_EFF_SCOPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_WES_CONFIDENTIAL = EnumerationData.newBuilder()
        .setDescription("Very restricted, confidential access")
        .setEnumCode("CONFIDENTIAL")
        .setEnumId("WES_CONFIDENTIAL")
        .setEnumTypeId("WORK_EFF_SCOPE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_CAL_PERSONAL = EnumerationData.newBuilder()
        .setDescription("Personal Calendar")
        .setEnumCode("PERSONAL")
        .setEnumId("CAL_PERSONAL")
        .setEnumTypeId("CALENDAR_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_CAL_MANUFACTURING = EnumerationData.newBuilder()
        .setDescription("Manufacturing Calendar")
        .setEnumCode("MANUFACTURING")
        .setEnumId("CAL_MANUFACTURING")
        .setEnumTypeId("CALENDAR_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_CAL_NONE = EnumerationData.newBuilder()
        .setDescription("None")
        .setEnumId("CAL_NONE")
        .setEnumTypeId("CALENDAR_TYPE")
        .setSequenceId("03")
        .build();


    public final static ContactMechTypeData ContactMechType_LDAP_ADDRESS = ContactMechTypeData.newBuilder()
        .setContactMechTypeId("LDAP_ADDRESS")
        .setDescription("LDAP URL")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ELECTRONIC_ADDRESS")
        .build();


    public final static RoleTypeData RoleType_ICAL_MEMBER = RoleTypeData.newBuilder()
        .setDescription("Calendar Member")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_ROLE")
        .setRoleTypeId("ICAL_MEMBER")
        .build();


    public final static WorkEffortTypeData WorkEffortType_ROUTING = WorkEffortTypeData.newBuilder()
        .setDescription("Routing")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("ROUTING")
        .build();


    public final static WorkEffortTypeData WorkEffortType_ROU_TASK = WorkEffortTypeData.newBuilder()
        .setDescription("Routing Task")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortTypeData WorkEffortType_PROD_ORDER_HEADER = WorkEffortTypeData.newBuilder()
        .setDescription("Production Run Header")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("PROD_ORDER_HEADER")
        .build();


    public final static WorkEffortTypeData WorkEffortType_PROD_ORDER_TASK = WorkEffortTypeData.newBuilder()
        .setDescription("Production Run Task")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("PROD_ORDER_TASK")
        .build();


    public final static WorkEffortTypeData WorkEffortType_ASSET_USAGE = WorkEffortTypeData.newBuilder()
        .setDescription("Fixed Asset Usage (rental)")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("ASSET_USAGE")
        .build();


    public final static WorkEffortTypeData WorkEffortType_EVENT = WorkEffortTypeData.newBuilder()
        .setDescription("Event")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("EVENT")
        .build();


    public final static WorkEffortTypeData WorkEffortType_SHIPMENT_INBOUND = WorkEffortTypeData.newBuilder()
        .setDescription("Inbound Shipment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EVENT")
        .setWorkEffortTypeId("SHIPMENT_INBOUND")
        .build();


    public final static WorkEffortTypeData WorkEffortType_SHIPMENT_OUTBOUND = WorkEffortTypeData.newBuilder()
        .setDescription("Outbound Shipment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EVENT")
        .setWorkEffortTypeId("SHIPMENT_OUTBOUND")
        .build();


    public final static WorkEffortTypeData WorkEffortType_BUSINESS_TRAVEL = WorkEffortTypeData.newBuilder()
        .setDescription("Business Travel")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EVENT")
        .setWorkEffortTypeId("BUSINESS_TRAVEL")
        .build();


    public final static WorkEffortTypeData WorkEffortType_MEETING = WorkEffortTypeData.newBuilder()
        .setDescription("Meeting")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EVENT")
        .setWorkEffortTypeId("MEETING")
        .build();


    public final static WorkEffortTypeData WorkEffortType_TRAINING = WorkEffortTypeData.newBuilder()
        .setDescription("Training")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EVENT")
        .setWorkEffortTypeId("TRAINING")
        .build();


    public final static WorkEffortTypeData WorkEffortType_PERSONAL_TIMEOFF = WorkEffortTypeData.newBuilder()
        .setDescription("Personal Time Off")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EVENT")
        .setWorkEffortTypeId("PERSONAL_TIMEOFF")
        .build();


    public final static WorkEffortTypeData WorkEffortType_PUBLISH_PROPS = WorkEffortTypeData.newBuilder()
        .setDescription("Publish Properties")
        .setHasTable(castIndicator("N"))
        .setWorkEffortTypeId("PUBLISH_PROPS")
        .build();


    public final static EnumerationTypeData EnumerationType_WORK_EFFORT = EnumerationTypeData.newBuilder()
        .setDescription("Parent Type for all Work Effort enum types")
        .setEnumTypeId("WORK_EFFORT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_WORKFLOW = EnumerationTypeData.newBuilder()
        .setDescription("Parent Type for all Workflow enum types")
        .setEnumTypeId("WORKFLOW")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_WORK_EFF_EXPECT = EnumerationTypeData.newBuilder()
        .setDescription("Work Effort Expectation")
        .setEnumTypeId("WORK_EFF_EXPECT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFFORT")
        .build();


    public final static EnumerationTypeData EnumerationType_WORK_EFF_DEL_REAS = EnumerationTypeData.newBuilder()
        .setDescription("Work Effort Delegate Reason")
        .setEnumTypeId("WORK_EFF_DEL_REAS")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFFORT")
        .build();


    public final static EnumerationTypeData EnumerationType_WORK_EFF_SCOPE = EnumerationTypeData.newBuilder()
        .setDescription("Work Effort Scope Classification")
        .setEnumTypeId("WORK_EFF_SCOPE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFFORT")
        .build();


    public final static EnumerationTypeData EnumerationType_CALENDAR_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Calendar Type")
        .setEnumTypeId("CALENDAR_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static WorkEffortAssocTypeData WorkEffortAssocType_WORK_EFF_BREAKDOWN = WorkEffortAssocTypeData.newBuilder()
        .setDescription("Breakdown/Detail")
        .setHasTable(castIndicator("N"))
        .setWorkEffortAssocTypeId("WORK_EFF_BREAKDOWN")
        .build();


    public final static WorkEffortAssocTypeData WorkEffortAssocType_WORK_EFF_DEPENDENCY = WorkEffortAssocTypeData.newBuilder()
        .setDescription("Dependency")
        .setHasTable(castIndicator("N"))
        .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
        .build();


    public final static WorkEffortAssocTypeData WorkEffortAssocType_WORK_EFF_CONCURRENCY = WorkEffortAssocTypeData.newBuilder()
        .setDescription("Concurrency")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFF_DEPENDENCY")
        .setWorkEffortAssocTypeId("WORK_EFF_CONCURRENCY")
        .build();


    public final static WorkEffortAssocTypeData WorkEffortAssocType_WORK_EFF_PRECEDENCY = WorkEffortAssocTypeData.newBuilder()
        .setDescription("Precedency")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFF_DEPENDENCY")
        .setWorkEffortAssocTypeId("WORK_EFF_PRECEDENCY")
        .build();


    public final static WorkEffortAssocTypeData WorkEffortAssocType_WORK_EFF_TEMPLATE = WorkEffortAssocTypeData.newBuilder()
        .setDescription("Template of")
        .setHasTable(castIndicator("N"))
        .setWorkEffortAssocTypeId("WORK_EFF_TEMPLATE")
        .build();


    public final static WorkEffortAssocTypeData WorkEffortAssocType_ROUTING_COMPONENT = WorkEffortAssocTypeData.newBuilder()
        .setDescription("Routing and Routing Task Association")
        .setHasTable(castIndicator("N"))
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .build();


    public final static StatusItemData StatusItem_CAL_IN_PLANNING = StatusItemData.newBuilder()
        .setDescription("In Planning")
        .setSequenceId("01")
        .setStatusCode("IN_PLANNING")
        .setStatusId("CAL_IN_PLANNING")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_PLANNED = StatusItemData.newBuilder()
        .setDescription("Planned")
        .setSequenceId("02")
        .setStatusCode("PLANNED")
        .setStatusId("CAL_PLANNED")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_NEEDS_ACTION = StatusItemData.newBuilder()
        .setDescription("Needs Action (Approved)")
        .setSequenceId("03")
        .setStatusCode("NEEDS_ACTION")
        .setStatusId("CAL_NEEDS_ACTION")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_SENT = StatusItemData.newBuilder()
        .setDescription("Sent")
        .setSequenceId("04")
        .setStatusCode("SENT")
        .setStatusId("CAL_SENT")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_DECLINED = StatusItemData.newBuilder()
        .setDescription("Declined")
        .setSequenceId("10")
        .setStatusCode("DECLINED")
        .setStatusId("CAL_DECLINED")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_DELEGATED = StatusItemData.newBuilder()
        .setDescription("Delegated")
        .setSequenceId("11")
        .setStatusCode("DELEGATED")
        .setStatusId("CAL_DELEGATED")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("CAL_CANCELLED")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Accepted")
        .setSequenceId("01")
        .setStatusCode("ACCEPTED")
        .setStatusId("CAL_ACCEPTED")
        .setStatusTypeId("TASK_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("02")
        .setStatusCode("COMPLETED")
        .setStatusId("CAL_COMPLETED")
        .setStatusTypeId("TASK_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_TENTATIVE = StatusItemData.newBuilder()
        .setDescription("Tentative")
        .setSequenceId("01")
        .setStatusCode("TENTATIVE")
        .setStatusId("CAL_TENTATIVE")
        .setStatusTypeId("EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_CAL_CONFIRMED = StatusItemData.newBuilder()
        .setDescription("Confirmed")
        .setSequenceId("02")
        .setStatusCode("CONFIRMED")
        .setStatusId("CAL_CONFIRMED")
        .setStatusTypeId("EVENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_TIMESHEET_IN_PROCESS = StatusItemData.newBuilder()
        .setDescription("In-Process")
        .setSequenceId("01")
        .setStatusCode("IN_PROCESS")
        .setStatusId("TIMESHEET_IN_PROCESS")
        .setStatusTypeId("TIMESHEET_STATUS")
        .build();


    public final static StatusItemData StatusItem_TIMESHEET_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("02")
        .setStatusCode("COMPLETED")
        .setStatusId("TIMESHEET_COMPLETED")
        .setStatusTypeId("TIMESHEET_STATUS")
        .build();


    public final static StatusItemData StatusItem_TIMESHEET_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("03")
        .setStatusCode("APPROVED")
        .setStatusId("TIMESHEET_APPROVED")
        .setStatusTypeId("TIMESHEET_STATUS")
        .build();


    public final static StatusItemData StatusItem_ROU_ACTIVE = StatusItemData.newBuilder()
        .setDescription("Well defined and usable")
        .setSequenceId("01")
        .setStatusCode("ACTIVE")
        .setStatusId("ROU_ACTIVE")
        .setStatusTypeId("ROUTING_STATUS")
        .build();


    public final static StatusItemData StatusItem_ROU_INACTIVE = StatusItemData.newBuilder()
        .setDescription("Not well defined and unusable")
        .setSequenceId("02")
        .setStatusCode("INACTIVE")
        .setStatusId("ROU_INACTIVE")
        .setStatusTypeId("ROUTING_STATUS")
        .build();


    public final static StatusItemData StatusItem_PRUN_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("PRUN_CREATED")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusItemData StatusItem_PRUN_SCHEDULED = StatusItemData.newBuilder()
        .setDescription("Scheduled")
        .setSequenceId("02")
        .setStatusCode("SCHEDULED")
        .setStatusId("PRUN_SCHEDULED")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusItemData StatusItem_PRUN_DOC_PRINTED = StatusItemData.newBuilder()
        .setDescription("Confirmed")
        .setSequenceId("03")
        .setStatusCode("DOC_PRINTED")
        .setStatusId("PRUN_DOC_PRINTED")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusItemData StatusItem_PRUN_RUNNING = StatusItemData.newBuilder()
        .setDescription("Running")
        .setSequenceId("04")
        .setStatusCode("RUNNING")
        .setStatusId("PRUN_RUNNING")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusItemData StatusItem_PRUN_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("05")
        .setStatusCode("COMPLETED")
        .setStatusId("PRUN_COMPLETED")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusItemData StatusItem_PRUN_CLOSED = StatusItemData.newBuilder()
        .setDescription("Closed")
        .setSequenceId("06")
        .setStatusCode("CLOSED")
        .setStatusId("PRUN_CLOSED")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusItemData StatusItem_PRUN_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("10")
        .setStatusCode("CANCELLED")
        .setStatusId("PRUN_CANCELLED")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusItemData StatusItem_WEGS_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("WEGS_CREATED")
        .setStatusTypeId("WEFG_STATUS")
        .build();


    public final static StatusItemData StatusItem_WEGS_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("02")
        .setStatusCode("COMPLETED")
        .setStatusId("WEGS_COMPLETED")
        .setStatusTypeId("WEFG_STATUS")
        .build();


    public final static StatusItemData StatusItem_WEGS_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("03")
        .setStatusCode("CANCELLED")
        .setStatusId("WEGS_CANCELLED")
        .setStatusTypeId("WEFG_STATUS")
        .build();


    public final static StatusItemData StatusItem_WERV_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending")
        .setSequenceId("01")
        .setStatusCode("PENDING")
        .setStatusId("WERV_PENDING")
        .setStatusTypeId("WEFF_REVIEW_STTS")
        .build();


    public final static StatusItemData StatusItem_WERV_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("WERV_APPROVED")
        .setStatusTypeId("WEFF_REVIEW_STTS")
        .build();


    public final static StatusItemData StatusItem_WERV_DELETED = StatusItemData.newBuilder()
        .setDescription("Deleted")
        .setSequenceId("99")
        .setStatusCode("DELETED")
        .setStatusId("WERV_DELETED")
        .setStatusTypeId("WEFF_REVIEW_STTS")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_IN_PLANNING_CAL_PLANNED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_IN_PLANNING")
        .setStatusIdTo("CAL_PLANNED")
        .setTransitionName("Send")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_IN_PLANNING_CAL_NEEDS_ACTION = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_IN_PLANNING")
        .setStatusIdTo("CAL_NEEDS_ACTION")
        .setTransitionName("Send")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_PLANNED_CAL_NEEDS_ACTION = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_PLANNED")
        .setStatusIdTo("CAL_NEEDS_ACTION")
        .setTransitionName("Send")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_NEEDS_ACTION_CAL_SENT = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_NEEDS_ACTION")
        .setStatusIdTo("CAL_SENT")
        .setTransitionName("Send")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_NEEDS_ACTION_CAL_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_NEEDS_ACTION")
        .setStatusIdTo("CAL_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_SENT_CAL_DECLINED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_SENT")
        .setStatusIdTo("CAL_DECLINED")
        .setTransitionName("Decline")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_SENT_CAL_DELEGATED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_SENT")
        .setStatusIdTo("CAL_DELEGATED")
        .setTransitionName("Delegate")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_SENT_CAL_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_SENT")
        .setStatusIdTo("CAL_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_NEEDS_ACTION_CAL_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_NEEDS_ACTION")
        .setStatusIdTo("CAL_COMPLETED")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_SENT_CAL_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_SENT")
        .setStatusIdTo("CAL_ACCEPTED")
        .setTransitionName("Accept")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_ACCEPTED_CAL_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_ACCEPTED")
        .setStatusIdTo("CAL_COMPLETED")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_ACCEPTED_CAL_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_ACCEPTED")
        .setStatusIdTo("CAL_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_ACCEPTED_CAL_DELEGATED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_ACCEPTED")
        .setStatusIdTo("CAL_DELEGATED")
        .setTransitionName("Delegate")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_NEEDS_ACTION_CAL_TENTATIVE = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_NEEDS_ACTION")
        .setStatusIdTo("CAL_TENTATIVE")
        .setTransitionName("Tentatively Plan")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_NEEDS_ACTION_CAL_CONFIRMED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_NEEDS_ACTION")
        .setStatusIdTo("CAL_CONFIRMED")
        .setTransitionName("Confirm")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_TENTATIVE_CAL_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_TENTATIVE")
        .setStatusIdTo("CAL_ACCEPTED")
        .setTransitionName("Accept")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_TENTATIVE_CAL_DECLINED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_TENTATIVE")
        .setStatusIdTo("CAL_DECLINED")
        .setTransitionName("Decline")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_TENTATIVE_CAL_DELEGATED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_TENTATIVE")
        .setStatusIdTo("CAL_DELEGATED")
        .setTransitionName("Delegate")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_TENTATIVE_CAL_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_TENTATIVE")
        .setStatusIdTo("CAL_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_TENTATIVE_CAL_CONFIRMED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_TENTATIVE")
        .setStatusIdTo("CAL_CONFIRMED")
        .setTransitionName("Confirm")
        .build();


    public final static StatusValidChangeData StatusValidChange_CAL_CONFIRMED_CAL_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("CAL_CONFIRMED")
        .setStatusIdTo("CAL_COMPLETED")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_TIMESHEET_IN_PROCESS_TIMESHEET_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("TIMESHEET_IN_PROCESS")
        .setStatusIdTo("TIMESHEET_COMPLETED")
        .setTransitionName("Confirm complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_TIMESHEET_COMPLETED_TIMESHEET_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("TIMESHEET_COMPLETED")
        .setStatusIdTo("TIMESHEET_APPROVED")
        .setTransitionName("Approve")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_CREATED_PRUN_DOC_PRINTED = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_CREATED")
        .setStatusIdTo("PRUN_DOC_PRINTED")
        .setTransitionName("Confirm")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_CREATED_PRUN_SCHEDULED = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_CREATED")
        .setStatusIdTo("PRUN_SCHEDULED")
        .setTransitionName("Schedule")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_CREATED_PRUN_RUNNING = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_CREATED")
        .setStatusIdTo("PRUN_RUNNING")
        .setTransitionName("Start")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_SCHEDULED_PRUN_DOC_PRINTED = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_SCHEDULED")
        .setStatusIdTo("PRUN_DOC_PRINTED")
        .setTransitionName("Confirm")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_SCHEDULED_PRUN_RUNNING = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_SCHEDULED")
        .setStatusIdTo("PRUN_RUNNING")
        .setTransitionName("Start")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_SCHEDULED_PRUN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_SCHEDULED")
        .setStatusIdTo("PRUN_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_DOC_PRINTED_PRUN_RUNNING = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_DOC_PRINTED")
        .setStatusIdTo("PRUN_RUNNING")
        .setTransitionName("Start")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_RUNNING_PRUN_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_RUNNING")
        .setStatusIdTo("PRUN_COMPLETED")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_COMPLETED_PRUN_CLOSED = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_COMPLETED")
        .setStatusIdTo("PRUN_CLOSED")
        .setTransitionName("Close")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRUN_CREATED_PRUN_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PRUN_CREATED")
        .setStatusIdTo("PRUN_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_ROU_ACTIVE_ROU_INACTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("ROU_ACTIVE")
        .setStatusIdTo("ROU_INACTIVE")
        .setTransitionName("Inactive")
        .build();


    public final static StatusValidChangeData StatusValidChange_ROU_INACTIVE_ROU_ACTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("ROU_INACTIVE")
        .setStatusIdTo("ROU_ACTIVE")
        .setTransitionName("Active")
        .build();


    public final static StatusValidChangeData StatusValidChange_WERV_PENDING_WERV_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("WERV_PENDING")
        .setStatusIdTo("WERV_APPROVED")
        .setTransitionName("Review Approved")
        .build();


    public final static StatusValidChangeData StatusValidChange_WERV_PENDING_WERV_DELETED = StatusValidChangeData.newBuilder()
        .setStatusId("WERV_PENDING")
        .setStatusIdTo("WERV_DELETED")
        .setTransitionName("Review Deleted")
        .build();


    public final static StatusValidChangeData StatusValidChange_WERV_APPROVED_WERV_DELETED = StatusValidChangeData.newBuilder()
        .setStatusId("WERV_APPROVED")
        .setStatusIdTo("WERV_DELETED")
        .setTransitionName("Review Deleted")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_EMAIL_ADDRESS_ICAL_URL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("ICAL_URL")
        .setContactMechTypeId("EMAIL_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_LDAP_ADDRESS_ICAL_URL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("ICAL_URL")
        .setContactMechTypeId("LDAP_ADDRESS")
        .build();


    public final static ContactMechTypePurposeData ContactMechTypePurpose_WEB_ADDRESS_ICAL_URL = ContactMechTypePurposeData.newBuilder()
        .setContactMechPurposeTypeId("ICAL_URL")
        .setContactMechTypeId("WEB_ADDRESS")
        .build();


    public final static StatusTypeData StatusType_WORK_EFF_ASSET_STTS = StatusTypeData.newBuilder()
        .setDescription("WorkEffort Asset")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("WORK_EFF_ASSET_STTS")
        .build();


    public final static StatusTypeData StatusType_WORK_EFFORT_ASSIGN = StatusTypeData.newBuilder()
        .setDescription("WorkEffort Assignment")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("WORK_EFFORT_ASSIGN")
        .build();


    public final static StatusTypeData StatusType_WORK_EFFORT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Workeffort")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("WORK_EFFORT_STATUS")
        .build();


    public final static StatusTypeData StatusType_CALENDAR_STATUS = StatusTypeData.newBuilder()
        .setDescription("Calendar")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFFORT_STATUS")
        .setStatusTypeId("CALENDAR_STATUS")
        .build();


    public final static StatusTypeData StatusType_TASK_STATUS = StatusTypeData.newBuilder()
        .setDescription("Task")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_STATUS")
        .setStatusTypeId("TASK_STATUS")
        .build();


    public final static StatusTypeData StatusType_EVENT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Event")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CALENDAR_STATUS")
        .setStatusTypeId("EVENT_STATUS")
        .build();


    public final static StatusTypeData StatusType_TIMESHEET_STATUS = StatusTypeData.newBuilder()
        .setDescription("Timesheet")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("TIMESHEET_STATUS")
        .build();


    public final static StatusTypeData StatusType_ROUTING_STATUS = StatusTypeData.newBuilder()
        .setDescription("Manufacturing Task and Routing status")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFFORT_STATUS")
        .setStatusTypeId("ROUTING_STATUS")
        .build();


    public final static StatusTypeData StatusType_PRODUCTION_RUN = StatusTypeData.newBuilder()
        .setDescription("Production Run Status")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WORK_EFFORT_STATUS")
        .setStatusTypeId("PRODUCTION_RUN")
        .build();


    public final static StatusTypeData StatusType_WEFG_STATUS = StatusTypeData.newBuilder()
        .setDescription("Work Effort Good Standard Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("WEFG_STATUS")
        .build();


    public final static StatusTypeData StatusType_WEFF_REVIEW_STTS = StatusTypeData.newBuilder()
        .setDescription("WorkEffort Review")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("WEFF_REVIEW_STTS")
        .build();


    public final static SecurityGroupPermissionData SecurityGroupPermission_SUPER_WORKEFFORTMGR_ADMIN_ = SecurityGroupPermissionData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setGroupId("SUPER")
        .setPermissionId("WORKEFFORTMGR_ADMIN")
        .build();


    public final static WorkEffortContentTypeData WorkEffortContentType_PROPOSAL_MEDIA = WorkEffortContentTypeData.newBuilder()
        .setDescription("Proposal Media")
        .setWorkEffortContentTypeId("PROPOSAL_MEDIA")
        .build();


    public final static WorkEffortContentTypeData WorkEffortContentType_SUPPORTING_MEDIA = WorkEffortContentTypeData.newBuilder()
        .setDescription("Supporting Media")
        .setWorkEffortContentTypeId("SUPPORTING_MEDIA")
        .build();


    public final static WorkEffortContentTypeData WorkEffortContentType_CREATED_MEDIA = WorkEffortContentTypeData.newBuilder()
        .setDescription("Created Media")
        .setWorkEffortContentTypeId("CREATED_MEDIA")
        .build();


    public final static WorkEffortGoodStandardTypeData WorkEffortGoodStandardType_ROU_PROD_TEMPLATE = WorkEffortGoodStandardTypeData.newBuilder()
        .setDescription("Product and Routing Association")
        .setHasTable(castIndicator("N"))
        .setWorkEffortGoodStdTypeId("ROU_PROD_TEMPLATE")
        .build();


    public final static WorkEffortGoodStandardTypeData WorkEffortGoodStandardType_PRUN_PROD_DELIV = WorkEffortGoodStandardTypeData.newBuilder()
        .setDescription("Production Run and Product to Deliver Association")
        .setHasTable(castIndicator("N"))
        .setWorkEffortGoodStdTypeId("PRUN_PROD_DELIV")
        .build();


    public final static WorkEffortGoodStandardTypeData WorkEffortGoodStandardType_PRUNT_PROD_NEEDED = WorkEffortGoodStandardTypeData.newBuilder()
        .setDescription("Production Run Task and Needed Product Association")
        .setHasTable(castIndicator("N"))
        .setWorkEffortGoodStdTypeId("PRUNT_PROD_NEEDED")
        .build();


    public final static WorkEffortGoodStandardTypeData WorkEffortGoodStandardType_PRUNT_PROD_DELIV = WorkEffortGoodStandardTypeData.newBuilder()
        .setDescription("Production Run Task and Deliverable Product Association")
        .setHasTable(castIndicator("N"))
        .setWorkEffortGoodStdTypeId("PRUNT_PROD_DELIV")
        .build();


    public final static WorkEffortGoodStandardTypeData WorkEffortGoodStandardType_GENERAL_SALES = WorkEffortGoodStandardTypeData.newBuilder()
        .setDescription("Product to Represent General Sales of the WorkEffort")
        .setHasTable(castIndicator("N"))
        .setWorkEffortGoodStdTypeId("GENERAL_SALES")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_VIEW = SecurityPermissionData.newBuilder()
        .setDescription("View operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_VIEW")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Create operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Update operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Delete operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_ROLE_VIEW = SecurityPermissionData.newBuilder()
        .setDescription("Limited View operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_ROLE_VIEW")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_ROLE_CREATE = SecurityPermissionData.newBuilder()
        .setDescription("Limited Create operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_ROLE_CREATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_ROLE_UPDATE = SecurityPermissionData.newBuilder()
        .setDescription("Limited Update operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_ROLE_UPDATE")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_ROLE_DELETE = SecurityPermissionData.newBuilder()
        .setDescription("Limited Delete operations the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_ROLE_DELETE")
        .build();


    public final static SecurityPermissionData SecurityPermission_WORKEFFORTMGR_ADMIN = SecurityPermissionData.newBuilder()
        .setDescription("ALL operations in the Work Effort Manager.")
        .setPermissionId("WORKEFFORTMGR_ADMIN")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_PRODUCTION_RUN = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Production Run")
        .setWorkEffortPurposeTypeId("WEPT_PRODUCTION_RUN")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_MAINTENANCE = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Maintenance")
        .setWorkEffortPurposeTypeId("WEPT_MAINTENANCE")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_RESEARCH = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Research")
        .setWorkEffortPurposeTypeId("WEPT_RESEARCH")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_MEETING = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Meeting")
        .setWorkEffortPurposeTypeId("WEPT_MEETING")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_DEVELOPMENT = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Development")
        .setWorkEffortPurposeTypeId("WEPT_DEVELOPMENT")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_SUPPORT = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Support")
        .setWorkEffortPurposeTypeId("WEPT_SUPPORT")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_DEPLOYMENT = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Deployment")
        .setWorkEffortPurposeTypeId("WEPT_DEPLOYMENT")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_WAREHOUSING = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Warehousing")
        .setWorkEffortPurposeTypeId("WEPT_WAREHOUSING")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_ROU_MANUFACTURING = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Manufacturing")
        .setWorkEffortPurposeTypeId("ROU_MANUFACTURING")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_ROU_ASSEMBLING = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Assembling")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_ROU_SUBCONTRACTING = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Sub-contracting")
        .setWorkEffortPurposeTypeId("ROU_SUBCONTRACTING")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_TASK_PHONE_CALL = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Phone Call")
        .setWorkEffortPurposeTypeId("WEPT_TASK_PHONE_CALL")
        .build();


    public final static WorkEffortPurposeTypeData WorkEffortPurposeType_WEPT_TASK_EMAIL = WorkEffortPurposeTypeData.newBuilder()
        .setDescription("Email")
        .setWorkEffortPurposeTypeId("WEPT_TASK_EMAIL")
        .build();


    public final static ContactMechPurposeTypeData ContactMechPurposeType_ICAL_URL = ContactMechPurposeTypeData.newBuilder()
        .setContactMechPurposeTypeId("ICAL_URL")
        .setDescription("iCalendar URL")
        .setHasTable(castIndicator("N"))
        .build();

}
