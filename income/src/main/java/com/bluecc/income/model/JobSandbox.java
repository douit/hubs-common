//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.JobSandboxData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = JobSandboxData.class,
        symbol = EntityNames.JobSandbox)
public class JobSandbox implements IEventModel<JobSandboxData.Builder>, Serializable, WithSchedule {
    private static final long serialVersionUID = 1L;

    @RId String jobId;
    String jobName;
    java.time.LocalDateTime runTime;
    Long priority;
    String poolId;
    String statusId;
    String parentJobId;
    String previousJobId;
    String serviceName;
    String loaderName;
    Long maxRetry;
    Long currentRetryCount;
    String authUserLoginId;
    String runAsUser;
    String runtimeDataId;
    String recurrenceInfoId;
    String tempExprId;
    Long currentRecurrenceCount;
    Long maxRecurrenceCount;
    String runByInstanceId;
    java.time.LocalDateTime startDateTime;
    java.time.LocalDateTime finishDateTime;
    java.time.LocalDateTime cancelDateTime;
    String jobResult;
    String recurrenceTimeZone;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public JobSandboxData.Builder toDataBuilder() {
        JobSandboxData.Builder builder = JobSandboxData.newBuilder();
        if (jobId != null) {
            builder.setJobId(jobId);
        }
        if (jobName != null) {
            builder.setJobName(jobName);
        }
        if (runTime != null) {
            builder.setRunTime(getTimestamp(runTime));
        }
        if (priority != null) {
            builder.setPriority(priority);
        }
        if (poolId != null) {
            builder.setPoolId(poolId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (parentJobId != null) {
            builder.setParentJobId(parentJobId);
        }
        if (previousJobId != null) {
            builder.setPreviousJobId(previousJobId);
        }
        if (serviceName != null) {
            builder.setServiceName(serviceName);
        }
        if (loaderName != null) {
            builder.setLoaderName(loaderName);
        }
        if (maxRetry != null) {
            builder.setMaxRetry(maxRetry);
        }
        if (currentRetryCount != null) {
            builder.setCurrentRetryCount(currentRetryCount);
        }
        if (authUserLoginId != null) {
            builder.setAuthUserLoginId(authUserLoginId);
        }
        if (runAsUser != null) {
            builder.setRunAsUser(runAsUser);
        }
        if (runtimeDataId != null) {
            builder.setRuntimeDataId(runtimeDataId);
        }
        if (recurrenceInfoId != null) {
            builder.setRecurrenceInfoId(recurrenceInfoId);
        }
        if (tempExprId != null) {
            builder.setTempExprId(tempExprId);
        }
        if (currentRecurrenceCount != null) {
            builder.setCurrentRecurrenceCount(currentRecurrenceCount);
        }
        if (maxRecurrenceCount != null) {
            builder.setMaxRecurrenceCount(maxRecurrenceCount);
        }
        if (runByInstanceId != null) {
            builder.setRunByInstanceId(runByInstanceId);
        }
        if (startDateTime != null) {
            builder.setStartDateTime(getTimestamp(startDateTime));
        }
        if (finishDateTime != null) {
            builder.setFinishDateTime(getTimestamp(finishDateTime));
        }
        if (cancelDateTime != null) {
            builder.setCancelDateTime(getTimestamp(cancelDateTime));
        }
        if (jobResult != null) {
            builder.setJobResult(jobResult);
        }
        if (recurrenceTimeZone != null) {
            builder.setRecurrenceTimeZone(recurrenceTimeZone);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static JobSandbox fromData(JobSandboxData data) {
        return JobSandbox.builder()
                .jobId(data.getJobId())
                .jobName(data.getJobName())
                .runTime(getLocalDateTime(data.getRunTime()))
                .priority(data.getPriority())
                .poolId(data.getPoolId())
                .statusId(data.getStatusId())
                .parentJobId(data.getParentJobId())
                .previousJobId(data.getPreviousJobId())
                .serviceName(data.getServiceName())
                .loaderName(data.getLoaderName())
                .maxRetry(data.getMaxRetry())
                .currentRetryCount(data.getCurrentRetryCount())
                .authUserLoginId(data.getAuthUserLoginId())
                .runAsUser(data.getRunAsUser())
                .runtimeDataId(data.getRuntimeDataId())
                .recurrenceInfoId(data.getRecurrenceInfoId())
                .tempExprId(data.getTempExprId())
                .currentRecurrenceCount(data.getCurrentRecurrenceCount())
                .maxRecurrenceCount(data.getMaxRecurrenceCount())
                .runByInstanceId(data.getRunByInstanceId())
                .startDateTime(getLocalDateTime(data.getStartDateTime()))
                .finishDateTime(getLocalDateTime(data.getFinishDateTime()))
                .cancelDateTime(getLocalDateTime(data.getCancelDateTime()))
                .jobResult(data.getJobResult())
                .recurrenceTimeZone(data.getRecurrenceTimeZone())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: jobId

-- fields --
    
    String jobId
    String jobName
    java.time.LocalDateTime runTime
    Long priority
    String poolId
    String statusId
    String parentJobId
    String previousJobId
    String serviceName
    String loaderName
    Long maxRetry
    Long currentRetryCount
    String authUserLoginId
    String runAsUser
    String runtimeDataId
    String recurrenceInfoId
    String tempExprId
    Long currentRecurrenceCount
    Long maxRecurrenceCount
    String runByInstanceId
    java.time.LocalDateTime startDateTime
    java.time.LocalDateTime finishDateTime
    java.time.LocalDateTime cancelDateTime
    String jobResult
    String recurrenceTimeZone

-- relations --
    
    - RecurrenceInfo (one, autoRelation: false, keymaps: recurrenceInfoId)
    - TemporalExpression (one, autoRelation: false, keymaps: tempExprId)
    - RuntimeData (one, autoRelation: false, keymaps: runtimeDataId)
    - AuthUserLogin (one, autoRelation: false, keymaps: authUserLoginId -> userLoginId)
    - RunAsUserLogin (one, autoRelation: false, keymaps: runAsUser -> userLoginId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    + ProductGroupOrder (many, autoRelation: true, keymaps: jobId)
*/

