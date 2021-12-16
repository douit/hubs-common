package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.WorkEffortSkillStandardData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class Project_9100 {
    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9100_admin_PROVIDER_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("admin")
            .setRoleTypeId("PROVIDER_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9100")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9100_Company_INTERNAL_ORGANIZATIO_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2009-04-05 20:27:52.818"))
            .setPartyId("Company")
            .setRoleTypeId("INTERNAL_ORGANIZATIO")
            .setWorkEffortId("9100")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9100_DemoCustomer2_CLIENT_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoCustomer2")
            .setRoleTypeId("CLIENT_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9100")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9100_DemoCustomer3_CLIENT_BILLING_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoCustomer3")
            .setRoleTypeId("CLIENT_BILLING")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9100")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9100_DemoEmployee1_PROVIDER_MANAGER_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoEmployee1")
            .setRoleTypeId("PROVIDER_MANAGER")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9100")
            .build();
    }


    public static WorkEffortPartyAssignmentData WorkEffortPartyAssignment_9100_DemoEmployee3_PROVIDER_ANALYST_() {
        return WorkEffortPartyAssignmentData.newBuilder()
            .setFromDate(getTimestamp("2007-12-14 16:45:21.831"))
            .setPartyId("DemoEmployee3")
            .setRoleTypeId("PROVIDER_ANALYST")
            .setStatusId("PAS_ASSIGNED")
            .setWorkEffortId("9100")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9100() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 15:07:52.911"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("9100")
            .setWorkEffortName("Demo Project2 Cust 2")
            .setWorkEffortTypeId("PROJECT")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9101() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:14.226"))
            .setRevisionNumber(1)
            .setSequenceNum(1)
            .setWorkEffortId("9101")
            .setWorkEffortName("phase1")
            .setWorkEffortParentId("9100")
            .setWorkEffortTypeId("PHASE")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9102() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-05 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-03 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:21.831"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(1)
            .setWorkEffortId("9102")
            .setWorkEffortName("task1")
            .setWorkEffortParentId("9101")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9103() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-16 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-05 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:29.453"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(2)
            .setWorkEffortId("9103")
            .setWorkEffortName("task2")
            .setWorkEffortParentId("9101")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9104() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:35.939"))
            .setRevisionNumber(1)
            .setSequenceNum(2)
            .setWorkEffortId("9104")
            .setWorkEffortName("phase2")
            .setWorkEffortParentId("9100")
            .setWorkEffortTypeId("PHASE")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9105() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-17 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-16 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:50.84"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(1)
            .setWorkEffortId("9105")
            .setWorkEffortName("task3")
            .setWorkEffortParentId("9104")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9106() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("PTS_CREATED")
            .setEstimatedCompletionDate(getTimestamp("2007-12-20 00:00:00.0"))
            .setEstimatedStartDate(getTimestamp("2007-12-18 00:00:00.0"))
            .setLastStatusUpdate(getTimestamp("2007-12-14 16:45:58.857"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setSequenceNum(2)
            .setWorkEffortId("9106")
            .setWorkEffortName("task4")
            .setWorkEffortParentId("9104")
            .setWorkEffortTypeId("TASK")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9102_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(16.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9102")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9103_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(24.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9103")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9105_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(32.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9105")
            .build();
    }


    public static WorkEffortSkillStandardData WorkEffortSkillStandard_9106_9000() {
        return WorkEffortSkillStandardData.newBuilder()
            .setEstimatedDuration(40.0)
            .setSkillTypeId("9000")
            .setWorkEffortId("9106")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_9102_9103_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setSequenceNum(0)
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("9102")
            .setWorkEffortIdTo("9103")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_9103_9105_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setSequenceNum(0)
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("9103")
            .setWorkEffortIdTo("9105")
            .build();
    }


    public static WorkEffortAssocData WorkEffortAssoc_9105_9106_WORK_EFF_DEPENDENCY_() {
        return WorkEffortAssocData.newBuilder()
            .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
            .setSequenceNum(0)
            .setWorkEffortAssocTypeId("WORK_EFF_DEPENDENCY")
            .setWorkEffortIdFrom("9105")
            .setWorkEffortIdTo("9106")
            .build();
    }

}
