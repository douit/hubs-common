package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Project_9000.*;

import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.WorkEffortSkillStandardData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class Project_9000List {
    public static List<WorkEffortPartyAssignmentData> workEffortPartyAssignmentList() {
        return ImmutableList.of(        
            WorkEffortPartyAssignment_9000_Company_INTERNAL_ORGANIZATIO_(),        
            WorkEffortPartyAssignment_9000_admin_PROVIDER_MANAGER_(),        
            WorkEffortPartyAssignment_9000_DemoCustomer1_CLIENT_MANAGER_(),        
            WorkEffortPartyAssignment_9000_DemoCustomer3_CLIENT_BILLING_(),        
            WorkEffortPartyAssignment_9000_DemoEmployee1_PROVIDER_MANAGER_(),        
            WorkEffortPartyAssignment_9000_DemoEmployee2_PROVIDER_ANALYST_(),        
            WorkEffortPartyAssignment_9002_admin_PROVIDER_MANAGER_());
    }

    public static List<WorkEffortFlatData> workEffortList() {
        return ImmutableList.of(        
            WorkEffort_9000(),        
            WorkEffort_9001(),        
            WorkEffort_9002(),        
            WorkEffort_9003(),        
            WorkEffort_9004(),        
            WorkEffort_9005(),        
            WorkEffort_9006());
    }

    public static List<WorkEffortSkillStandardData> workEffortSkillStandardList() {
        return ImmutableList.of(        
            WorkEffortSkillStandard_9002_9000(),        
            WorkEffortSkillStandard_9003_9000(),        
            WorkEffortSkillStandard_9005_9000(),        
            WorkEffortSkillStandard_9006_9000());
    }

    public static List<WorkEffortAssocData> workEffortAssocList() {
        return ImmutableList.of(        
            WorkEffortAssoc_9002_9003_WORK_EFF_DEPENDENCY_(),        
            WorkEffortAssoc_9003_9005_WORK_EFF_DEPENDENCY_(),        
            WorkEffortAssoc_9005_9006_WORK_EFF_DEPENDENCY_());
    }

}
