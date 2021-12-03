package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.WorkEffortData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkEffort implements IEventModel<WorkEffortData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String workEffortId;
    String workEffortTypeId;
    String currentStatusId;
    java.time.LocalDateTime lastStatusUpdate;
    String workEffortPurposeTypeId;
    String workEffortParentId;
    String scopeEnumId;
    Long priority;
    Long percentComplete;
    String workEffortName;
    String showAsEnumId;
    Character sendNotificationEmail;
    String description;
    String locationDesc;
    java.time.LocalDateTime estimatedStartDate;
    java.time.LocalDateTime estimatedCompletionDate;
    java.time.LocalDateTime actualStartDate;
    java.time.LocalDateTime actualCompletionDate;
    Double estimatedMilliSeconds;
    Double estimatedSetupMillis;
    String estimateCalcMethod;
    Double actualMilliSeconds;
    Double actualSetupMillis;
    Double totalMilliSecondsAllowed;
    java.math.BigDecimal totalMoneyAllowed;
    String moneyUomId;
    String specialTerms;
    Long timeTransparency;
    String universalId;
    String sourceReferenceId;
    String fixedAssetId;
    String facilityId;
    String infoUrl;
    String recurrenceInfoId;
    String tempExprId;
    String runtimeDataId;
    String noteId;
    String serviceLoaderName;
    java.math.BigDecimal quantityToProduce;
    java.math.BigDecimal quantityProduced;
    java.math.BigDecimal quantityRejected;
    java.math.BigDecimal reservPersons;
    java.math.BigDecimal reserv2ndPPPerc;
    java.math.BigDecimal reservNthPPPerc;
    String accommodationMapId;
    String accommodationSpotId;
    Long revisionNumber;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    Long sequenceNum;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WorkEffortData.Builder toDataBuilder() {
        WorkEffortData.Builder builder = WorkEffortData.newBuilder();
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (workEffortTypeId != null) {
            builder.setWorkEffortTypeId(workEffortTypeId);
        }
        if (currentStatusId != null) {
            builder.setCurrentStatusId(currentStatusId);
        }
        if (lastStatusUpdate != null) {
            builder.setLastStatusUpdate(getTimestamp(lastStatusUpdate));
        }
        if (workEffortPurposeTypeId != null) {
            builder.setWorkEffortPurposeTypeId(workEffortPurposeTypeId);
        }
        if (workEffortParentId != null) {
            builder.setWorkEffortParentId(workEffortParentId);
        }
        if (scopeEnumId != null) {
            builder.setScopeEnumId(scopeEnumId);
        }
        if (priority != null) {
            builder.setPriority(priority);
        }
        if (percentComplete != null) {
            builder.setPercentComplete(percentComplete);
        }
        if (workEffortName != null) {
            builder.setWorkEffortName(workEffortName);
        }
        if (showAsEnumId != null) {
            builder.setShowAsEnumId(showAsEnumId);
        }
        if (sendNotificationEmail != null) {
            builder.setSendNotificationEmail(getIndicator(sendNotificationEmail));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (locationDesc != null) {
            builder.setLocationDesc(locationDesc);
        }
        if (estimatedStartDate != null) {
            builder.setEstimatedStartDate(getTimestamp(estimatedStartDate));
        }
        if (estimatedCompletionDate != null) {
            builder.setEstimatedCompletionDate(getTimestamp(estimatedCompletionDate));
        }
        if (actualStartDate != null) {
            builder.setActualStartDate(getTimestamp(actualStartDate));
        }
        if (actualCompletionDate != null) {
            builder.setActualCompletionDate(getTimestamp(actualCompletionDate));
        }
        if (estimatedMilliSeconds != null) {
            builder.setEstimatedMilliSeconds(estimatedMilliSeconds);
        }
        if (estimatedSetupMillis != null) {
            builder.setEstimatedSetupMillis(estimatedSetupMillis);
        }
        if (estimateCalcMethod != null) {
            builder.setEstimateCalcMethod(estimateCalcMethod);
        }
        if (actualMilliSeconds != null) {
            builder.setActualMilliSeconds(actualMilliSeconds);
        }
        if (actualSetupMillis != null) {
            builder.setActualSetupMillis(actualSetupMillis);
        }
        if (totalMilliSecondsAllowed != null) {
            builder.setTotalMilliSecondsAllowed(totalMilliSecondsAllowed);
        }
        if (totalMoneyAllowed != null) {
            builder.setTotalMoneyAllowed(getCurrency(totalMoneyAllowed));
        }
        if (moneyUomId != null) {
            builder.setMoneyUomId(moneyUomId);
        }
        if (specialTerms != null) {
            builder.setSpecialTerms(specialTerms);
        }
        if (timeTransparency != null) {
            builder.setTimeTransparency(timeTransparency);
        }
        if (universalId != null) {
            builder.setUniversalId(universalId);
        }
        if (sourceReferenceId != null) {
            builder.setSourceReferenceId(sourceReferenceId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (infoUrl != null) {
            builder.setInfoUrl(infoUrl);
        }
        if (recurrenceInfoId != null) {
            builder.setRecurrenceInfoId(recurrenceInfoId);
        }
        if (tempExprId != null) {
            builder.setTempExprId(tempExprId);
        }
        if (runtimeDataId != null) {
            builder.setRuntimeDataId(runtimeDataId);
        }
        if (noteId != null) {
            builder.setNoteId(noteId);
        }
        if (serviceLoaderName != null) {
            builder.setServiceLoaderName(serviceLoaderName);
        }
        if (quantityToProduce != null) {
            builder.setQuantityToProduce(getFixedPoint(quantityToProduce));
        }
        if (quantityProduced != null) {
            builder.setQuantityProduced(getFixedPoint(quantityProduced));
        }
        if (quantityRejected != null) {
            builder.setQuantityRejected(getFixedPoint(quantityRejected));
        }
        if (reservPersons != null) {
            builder.setReservPersons(getFixedPoint(reservPersons));
        }
        if (reserv2ndPPPerc != null) {
            builder.setReserv2NdPPPerc(getFixedPoint(reserv2ndPPPerc));
        }
        if (reservNthPPPerc != null) {
            builder.setReservNthPPPerc(getFixedPoint(reservNthPPPerc));
        }
        if (accommodationMapId != null) {
            builder.setAccommodationMapId(accommodationMapId);
        }
        if (accommodationSpotId != null) {
            builder.setAccommodationSpotId(accommodationSpotId);
        }
        if (revisionNumber != null) {
            builder.setRevisionNumber(revisionNumber);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
                    
        return builder;
    }

    public static WorkEffort fromData(WorkEffortData data) {
        return WorkEffort.builder()
                .workEffortId(data.getWorkEffortId())
                .workEffortTypeId(data.getWorkEffortTypeId())
                .currentStatusId(data.getCurrentStatusId())
                .lastStatusUpdate(getLocalDateTime(data.getLastStatusUpdate()))
                .workEffortPurposeTypeId(data.getWorkEffortPurposeTypeId())
                .workEffortParentId(data.getWorkEffortParentId())
                .scopeEnumId(data.getScopeEnumId())
                .priority(data.getPriority())
                .percentComplete(data.getPercentComplete())
                .workEffortName(data.getWorkEffortName())
                .showAsEnumId(data.getShowAsEnumId())
                .sendNotificationEmail(getIndicatorChar(data.getSendNotificationEmail()))
                .description(data.getDescription())
                .locationDesc(data.getLocationDesc())
                .estimatedStartDate(getLocalDateTime(data.getEstimatedStartDate()))
                .estimatedCompletionDate(getLocalDateTime(data.getEstimatedCompletionDate()))
                .actualStartDate(getLocalDateTime(data.getActualStartDate()))
                .actualCompletionDate(getLocalDateTime(data.getActualCompletionDate()))
                .estimatedMilliSeconds(data.getEstimatedMilliSeconds())
                .estimatedSetupMillis(data.getEstimatedSetupMillis())
                .estimateCalcMethod(data.getEstimateCalcMethod())
                .actualMilliSeconds(data.getActualMilliSeconds())
                .actualSetupMillis(data.getActualSetupMillis())
                .totalMilliSecondsAllowed(data.getTotalMilliSecondsAllowed())
                .totalMoneyAllowed(getBigDecimal(data.getTotalMoneyAllowed()))
                .moneyUomId(data.getMoneyUomId())
                .specialTerms(data.getSpecialTerms())
                .timeTransparency(data.getTimeTransparency())
                .universalId(data.getUniversalId())
                .sourceReferenceId(data.getSourceReferenceId())
                .fixedAssetId(data.getFixedAssetId())
                .facilityId(data.getFacilityId())
                .infoUrl(data.getInfoUrl())
                .recurrenceInfoId(data.getRecurrenceInfoId())
                .tempExprId(data.getTempExprId())
                .runtimeDataId(data.getRuntimeDataId())
                .noteId(data.getNoteId())
                .serviceLoaderName(data.getServiceLoaderName())
                .quantityToProduce(getBigDecimal(data.getQuantityToProduce()))
                .quantityProduced(getBigDecimal(data.getQuantityProduced()))
                .quantityRejected(getBigDecimal(data.getQuantityRejected()))
                .reservPersons(getBigDecimal(data.getReservPersons()))
                .reserv2ndPPPerc(getBigDecimal(data.getReserv2NdPPPerc()))
                .reservNthPPPerc(getBigDecimal(data.getReservNthPPPerc()))
                .accommodationMapId(data.getAccommodationMapId())
                .accommodationSpotId(data.getAccommodationSpotId())
                .revisionNumber(data.getRevisionNumber())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .sequenceNum(data.getSequenceNum())
                
                .build();
    }

    
}
