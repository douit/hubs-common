package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.PartySeedInitialData.*;

import com.bluecc.hubs.stub.TemporalExpressionData;
import com.bluecc.hubs.stub.JobSandboxData;

public final class PartySeedInitialDataList {
    public static List<TemporalExpressionData> temporalExpressionList() {
        return ImmutableList.of(        
            TemporalExpression_SENDEMAIL());
    }

    public static List<JobSandboxData> jobSandboxList() {
        return ImmutableList.of(        
            JobSandbox_SENDEMAIL());
    }

}
