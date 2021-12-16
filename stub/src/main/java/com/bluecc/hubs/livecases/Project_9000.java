package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.WorkEffortSkillStandardData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class Project_9000 {
    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9000_Company_INTERNAL_ORGANIZATIO_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2009-04-05 20:27:52.818"))
            .setPartyId("Company")
            .setRoleTypeId("INTERNAL_ORGANIZATIO")
            .setWorkEffortId("9000")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9000_admin_PROVIDER_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("admin")
            .setRoleTypeId("PROVIDER_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9000")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9000_DemoCustomer1_CLIENT_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoCustomer1")
            .setRoleTypeId("CLIENT_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9000")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9000_DemoCustomer3_CLIENT_BILLING_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("CLIENT_BILLING")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9000")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9000_DemoEmployee1_PROVIDER_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("PROVIDER_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9000")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9000_DemoEmployee2_PROVIDER_ANALYST_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoEmployee2")
            .setRoleTypeId("PROVIDER_ANALYST")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9000")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9002_admin_PROVIDER_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("admin")
            .setRoleTypeId("PROVIDER_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9002")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9000() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 15:07:52.901"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("9000")
            .setWorkEffortName("Demo Project1 Cust1")
            .setWorkEffortTypeId("PROJECT")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9001() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:14.226"))
            .setRevisionNumber(1)
            .setSequenceNum(1)
            .setWorkEffortId("9001")
            .setWorkEffortName("phase1")
            .setWorkEffortParentId("9000")
            .setWorkEffortTypeId("PHASE")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9002() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-05 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-03 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:21.831"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(1)
            .setWorkEffortId("9002")
            .setWorkEffortName("task1")
            .setWorkEffortParentId("9001")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9003() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-16 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-05 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:29.453"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(2)
            .setWorkEffortId("9003")
            .setWorkEffortName("task2")
            .setWorkEffortParentId("9001")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9004() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:35.939"))
            .setRevisionNumber(1)
            .setSequenceNum(2)
            .setWorkEffortId("9004")
            .setWorkEffortName("phase2")
            .setWorkEffortParentId("9000")
            .setWorkEffortTypeId("PHASE")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9005() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-17 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-16 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:50.84"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(1)
            .setWorkEffortId("9005")
            .setWorkEffortName("task3")
            .setWorkEffortParentId("9004")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9006() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-20 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-18 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:58.857"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(2)
            .setWorkEffortId("9006")
            .setWorkEffortName("task4")
            .setWorkEffortParentId("9004")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9002_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(16.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9002")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9003_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(24.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9003")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9005_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(32.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9005")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9006_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(40.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9006")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_9002_9003_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setSequenceNum(0)
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("9002")
            .setWorkEffortIdTo("9003")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_9003_9005_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setSequenceNum(0)
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("9003")
            .setWorkEffortIdTo("9005")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_9005_9006_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setSequenceNum(0)
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("9005")
            .setWorkEffortIdTo("9006")
            .build();
    }

}
