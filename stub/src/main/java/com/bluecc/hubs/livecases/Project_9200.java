package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.WorkEffortSkillStandardData;

public final class Project_9200 {
    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9200_DemoEmployee3_PROVIDER_ANALYST_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("PROVIDER_ANALYST")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9200")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9200_Company_INTERNAL_ORGANIZATIO_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2009-04-05 20:27:52.818"))
            .setPartyId("Company")
            .setRoleTypeId("INTERNAL_ORGANIZATIO")
            .setWorkEffortId("9200")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9200_DemoCustCompany_CLIENT_BILLING_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2009-04-05 20:27:52.893"))
            .setPartyId("DemoCustCompany")
            .setRoleTypeId("CLIENT_BILLING")
            .setWorkEffortId("9200")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9200_DemoEmployee1_PROVIDER_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("PROVIDER_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9200")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9200() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 15:07:52.911"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("9200")
            .setWorkEffortName("Demo Project3 DemoCustomerCompany")
            .setWorkEffortTypeId("PROJECT")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9201() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:14.226"))
            .setRevisionNumber(1)
            .setWorkEffortId("9201")
            .setWorkEffortName("phase1")
            .setWorkEffortParentId("9200")
            .setWorkEffortTypeId("PHASE")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9202() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-05 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-03 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:21.831"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("9202")
            .setWorkEffortName("task1")
            .setWorkEffortParentId("9201")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9202_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(16.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9202")
            .build();
    }

}
