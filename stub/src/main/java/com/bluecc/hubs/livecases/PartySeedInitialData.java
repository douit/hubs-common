package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.TemporalExpressionData;
import com.bluecc.hubs.stub.JobSandboxData;

public final class PartySeedInitialData {
    public static TemporalExpressionData TemporalExpression_SENDEMAIL() {
        return TemporalExpressionData.newBuilder()
            .setDescription("Every 15 Minutes")
            .setInteger1(12)
            .setInteger2(15)
            .setTempExprId("SENDEMAIL")
            .setTempExprTypeId("FREQUENCY")
            .build();
    }


    public static JobSandboxData JobSandbox_SENDEMAIL() {
        return JobSandboxData.newBuilder()
            .setJobId("SENDEMAIL")
            .setJobName("Send Email")
            .setMaxRecurrenceCount(-1)
            .setPoolId("pool")
            .setRunAsUser("system")
            .setRunTime(getTimestamp("2000-01-01 00:00:00.000"))
            .setServiceName("sendEmailDated")
            .setTempExprId("SENDEMAIL")
            .build();
    }

}
