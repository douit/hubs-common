package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Project_9100.*;

import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.WorkEffortSkillStandardData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class Project_9100List {
    public static List<WorkEffortPartyAssignmentData> workEffortPartyAssignmentList() {
        return ImmutableList.of(        
            WorkEffortPartyAssignment_9100_admin_PROVIDER_MANAGER_(),        
            WorkEffortPartyAssignment_9100_Company_INTERNAL_ORGANIZATIO_(),        
            WorkEffortPartyAssignment_9100_DemoCustomer2_CLIENT_MANAGER_(),        
            WorkEffortPartyAssignment_9100_DemoCustomer3_CLIENT_BILLING_(),        
            WorkEffortPartyAssignment_9100_DemoEmployee1_PROVIDER_MANAGER_(),        
            WorkEffortPartyAssignment_9100_DemoEmployee3_PROVIDER_ANALYST_());
    }

    public static List<WorkEffortFlatData> workEffortList() {
        return ImmutableList.of(        
            WorkEffort_9100(),        
            WorkEffort_9101(),        
            WorkEffort_9102(),        
            WorkEffort_9103(),        
            WorkEffort_9104(),        
            WorkEffort_9105(),        
            WorkEffort_9106());
    }

    public static List<WorkEffortSkillStandardData> workEffortSkillStandardList() {
        return ImmutableList.of(        
            WorkEffortSkillStandard_9102_9000(),        
            WorkEffortSkillStandard_9103_9000(),        
            WorkEffortSkillStandard_9105_9000(),        
            WorkEffortSkillStandard_9106_9000());
    }

    public static List<WorkEffortAssocData> workEffortAssocList() {
        return ImmutableList.of(        
            WorkEffortAssoc_9102_9103_WORK_EFF_DEPENDENCY_(),        
            WorkEffortAssoc_9103_9105_WORK_EFF_DEPENDENCY_(),        
            WorkEffortAssoc_9105_9106_WORK_EFF_DEPENDENCY_());
    }

}
