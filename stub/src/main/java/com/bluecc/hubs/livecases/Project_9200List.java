package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.Project_9200.*;

import com.bluecc.hubs.stub.WorkEffortPartyAssignmentData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.WorkEffortSkillStandardData;

public final class Project_9200List {
    public static List<WorkEffortPartyAssignmentData> workEffortPartyAssignmentList() {
        return ImmutableList.of(        
            WorkEffortPartyAssignment_9200_DemoEmployee3_PROVIDER_ANALYST_(),        
            WorkEffortPartyAssignment_9200_Company_INTERNAL_ORGANIZATIO_(),        
            WorkEffortPartyAssignment_9200_DemoCustCompany_CLIENT_BILLING_(),        
            WorkEffortPartyAssignment_9200_DemoEmployee1_PROVIDER_MANAGER_());
    }

    public static List<WorkEffortFlatData> workEffortList() {
        return ImmutableList.of(        
            WorkEffort_9200(),        
            WorkEffort_9201(),        
            WorkEffort_9202());
    }

    public static List<WorkEffortSkillStandardData> workEffortSkillStandardList() {
        return ImmutableList.of(        
            WorkEffortSkillStandard_9202_9000());
    }

}
