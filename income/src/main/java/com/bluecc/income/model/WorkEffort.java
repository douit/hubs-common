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
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.WorkEffortFlatData;

import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.income.dao.WorkEffortDelegator;
import static com.bluecc.income.dao.WorkEffortDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WorkEffortData.class,
        symbol = EntityNames.WorkEffort)
public class WorkEffort implements IEventModel<WorkEffortFlatData.Builder>, HasId, Serializable, WithSuppliers, WithSchedule, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("work_effort_id")
	@RId 
    String workEffortId;
    @SerializedName("work_effort_type_id") 
    String workEffortTypeId;
    @SerializedName("current_status_id") 
    String currentStatusId;
    @SerializedName("last_status_update") 
    java.time.LocalDateTime lastStatusUpdate;
    @SerializedName("work_effort_purpose_type_id") 
    String workEffortPurposeTypeId;
    @SerializedName("work_effort_parent_id") 
    String workEffortParentId;
    @SerializedName("scope_enum_id") 
    String scopeEnumId;
    @SerializedName("priority") 
    Long priority;
    @SerializedName("percent_complete") 
    Long percentComplete;
    @SerializedName("work_effort_name") 
    String workEffortName;
    @SerializedName("show_as_enum_id") 
    String showAsEnumId;
    @SerializedName("send_notification_email") 
    Character sendNotificationEmail;
    @SerializedName("description") 
    String description;
    @SerializedName("location_desc") 
    String locationDesc;
    @SerializedName("estimated_start_date") 
    java.time.LocalDateTime estimatedStartDate;
    @SerializedName("estimated_completion_date") 
    java.time.LocalDateTime estimatedCompletionDate;
    @SerializedName("actual_start_date") 
    java.time.LocalDateTime actualStartDate;
    @SerializedName("actual_completion_date") 
    java.time.LocalDateTime actualCompletionDate;
    @SerializedName("estimated_milli_seconds") 
    Double estimatedMilliSeconds;
    @SerializedName("estimated_setup_millis") 
    Double estimatedSetupMillis;
    @SerializedName("estimate_calc_method") 
    String estimateCalcMethod;
    @SerializedName("actual_milli_seconds") 
    Double actualMilliSeconds;
    @SerializedName("actual_setup_millis") 
    Double actualSetupMillis;
    @SerializedName("total_milli_seconds_allowed") 
    Double totalMilliSecondsAllowed;
    @SerializedName("total_money_allowed") 
    java.math.BigDecimal totalMoneyAllowed;
    @SerializedName("money_uom_id") 
    String moneyUomId;
    @SerializedName("special_terms") 
    String specialTerms;
    @SerializedName("time_transparency") 
    Long timeTransparency;
    @SerializedName("universal_id") 
    String universalId;
    @SerializedName("source_reference_id") 
    String sourceReferenceId;
    @SerializedName("fixed_asset_id") 
    String fixedAssetId;
    @SerializedName("facility_id") 
    String facilityId;
    @SerializedName("info_url") 
    String infoUrl;
    @SerializedName("recurrence_info_id") 
    String recurrenceInfoId;
    @SerializedName("temp_expr_id") 
    String tempExprId;
    @SerializedName("runtime_data_id") 
    String runtimeDataId;
    @SerializedName("note_id") 
    String noteId;
    @SerializedName("service_loader_name") 
    String serviceLoaderName;
    @SerializedName("quantity_to_produce") 
    java.math.BigDecimal quantityToProduce;
    @SerializedName("quantity_produced") 
    java.math.BigDecimal quantityProduced;
    @SerializedName("quantity_rejected") 
    java.math.BigDecimal quantityRejected;
    @SerializedName("reserv_persons") 
    java.math.BigDecimal reservPersons;
    @SerializedName("reserv_2nd_p_p_perc") 
    java.math.BigDecimal reserv2ndPPPerc;
    @SerializedName("reserv_nth_p_p_perc") 
    java.math.BigDecimal reservNthPPPerc;
    @SerializedName("accommodation_map_id") 
    String accommodationMapId;
    @SerializedName("accommodation_spot_id") 
    String accommodationSpotId;
    @SerializedName("revision_number") 
    Long revisionNumber;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login") 
    String lastModifiedByUserLogin;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return workEffortId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WorkEffortFlatData.Builder toDataBuilder() {
        WorkEffortFlatData.Builder builder = WorkEffortFlatData.newBuilder();
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
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static WorkEffort fromData(WorkEffortFlatData data) {
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
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addParentWorkEffort")
    List<WorkEffort> relParentWorkEffort= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAsset")
    List<FixedAsset> relFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addFacility")
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addRecurrenceInfo")
    List<RecurrenceInfo> relRecurrenceInfo= new ArrayList<>(); 
    @Exclude
    @Singular("addTemporalExpression")
    List<TemporalExpression> relTemporalExpression= new ArrayList<>(); 
    @Exclude
    @Singular("addCustomMethod")
    List<CustomMethod> relCustomMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItemDetail")
    List<InventoryItemDetail> relInventoryItemDetail= new ArrayList<>(); 
    @Exclude
    @Singular("addRoutingProductAssoc")
    List<ProductAssoc> relRoutingProductAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteItem")
    List<QuoteItem> relQuoteItem= new ArrayList<>(); 
    @Exclude
    @Singular("addRateAmount")
    List<RateAmount> relRateAmount= new ArrayList<>(); 
    @Exclude
    @Singular("addEstimatedShipShipment")
    List<Shipment> relEstimatedShipShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addEstimatedArrivalShipment")
    List<Shipment> relEstimatedArrivalShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addChildWorkEffort")
    List<WorkEffort> relChildWorkEffort= new ArrayList<>(); 
    @Exclude
    @Singular("addFromWorkEffortAssoc")
    List<WorkEffortAssoc> relFromWorkEffortAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addToWorkEffortAssoc")
    List<WorkEffortAssoc> relToWorkEffortAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortFixedAssetAssign")
    List<WorkEffortFixedAssetAssign> relWorkEffortFixedAssetAssign= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortGoodStandard")
    List<WorkEffortGoodStandard> relWorkEffortGoodStandard= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortPartyAssignment")
    List<WorkEffortPartyAssignment> relWorkEffortPartyAssignment= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortSkillStandard")
    List<WorkEffortSkillStandard> relWorkEffortSkillStandard= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARENT_WORK_EFFORT, getter(this, WorkEffort::getRelParentWorkEffort)); 
        supplierMap.put(FIXED_ASSET, getter(this, WorkEffort::getRelFixedAsset)); 
        supplierMap.put(FACILITY, getter(this, WorkEffort::getRelFacility)); 
        supplierMap.put(RECURRENCE_INFO, getter(this, WorkEffort::getRelRecurrenceInfo)); 
        supplierMap.put(TEMPORAL_EXPRESSION, getter(this, WorkEffort::getRelTemporalExpression)); 
        supplierMap.put(CUSTOM_METHOD, getter(this, WorkEffort::getRelCustomMethod)); 
        supplierMap.put(ACCTG_TRANS, getter(this, WorkEffort::getRelAcctgTrans)); 
        supplierMap.put(INVENTORY_ITEM_DETAIL, getter(this, WorkEffort::getRelInventoryItemDetail)); 
        supplierMap.put(ROUTING_PRODUCT_ASSOC, getter(this, WorkEffort::getRelRoutingProductAssoc)); 
        supplierMap.put(QUOTE_ITEM, getter(this, WorkEffort::getRelQuoteItem)); 
        supplierMap.put(RATE_AMOUNT, getter(this, WorkEffort::getRelRateAmount)); 
        supplierMap.put(ESTIMATED_SHIP_SHIPMENT, getter(this, WorkEffort::getRelEstimatedShipShipment)); 
        supplierMap.put(ESTIMATED_ARRIVAL_SHIPMENT, getter(this, WorkEffort::getRelEstimatedArrivalShipment)); 
        supplierMap.put(CHILD_WORK_EFFORT, getter(this, WorkEffort::getRelChildWorkEffort)); 
        supplierMap.put(FROM_WORK_EFFORT_ASSOC, getter(this, WorkEffort::getRelFromWorkEffortAssoc)); 
        supplierMap.put(TO_WORK_EFFORT_ASSOC, getter(this, WorkEffort::getRelToWorkEffortAssoc)); 
        supplierMap.put(WORK_EFFORT_FIXED_ASSET_ASSIGN, getter(this, WorkEffort::getRelWorkEffortFixedAssetAssign)); 
        supplierMap.put(WORK_EFFORT_GOOD_STANDARD, getter(this, WorkEffort::getRelWorkEffortGoodStandard)); 
        supplierMap.put(WORK_EFFORT_PARTY_ASSIGNMENT, getter(this, WorkEffort::getRelWorkEffortPartyAssignment)); 
        supplierMap.put(WORK_EFFORT_SKILL_STANDARD, getter(this, WorkEffort::getRelWorkEffortSkillStandard)); 
        supplierMap.put(TENANT, getter(this, WorkEffort::getRelTenant));

        return supplierMap;
    };

    public WorkEffortDelegator.Agent agent(IProc.ProcContext ctx,
                                             WorkEffortDelegator delegator){
        return delegator.getAgent(ctx, this.getWorkEffortId());
    }

    public WorkEffortData.Builder toHeadBuilder() {
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
        if (infoUrl != null) {
            builder.setInfoUrl(infoUrl);
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

}


/*
-- keys: workEffortId

-- fields --
    
    String workEffortId
    String workEffortTypeId
    String currentStatusId
    java.time.LocalDateTime lastStatusUpdate
    String workEffortPurposeTypeId
    String workEffortParentId
    String scopeEnumId
    Long priority
    Long percentComplete
    String workEffortName
    String showAsEnumId
    Character sendNotificationEmail
    String description
    String locationDesc
    java.time.LocalDateTime estimatedStartDate
    java.time.LocalDateTime estimatedCompletionDate
    java.time.LocalDateTime actualStartDate
    java.time.LocalDateTime actualCompletionDate
    Double estimatedMilliSeconds
    Double estimatedSetupMillis
    String estimateCalcMethod
    Double actualMilliSeconds
    Double actualSetupMillis
    Double totalMilliSecondsAllowed
    java.math.BigDecimal totalMoneyAllowed
    String moneyUomId
    String specialTerms
    Long timeTransparency
    String universalId
    String sourceReferenceId
    String fixedAssetId
    String facilityId
    String infoUrl
    String recurrenceInfoId
    String tempExprId
    String runtimeDataId
    String noteId
    String serviceLoaderName
    java.math.BigDecimal quantityToProduce
    java.math.BigDecimal quantityProduced
    java.math.BigDecimal quantityRejected
    java.math.BigDecimal reservPersons
    java.math.BigDecimal reserv2ndPPPerc
    java.math.BigDecimal reservNthPPPerc
    String accommodationMapId
    String accommodationSpotId
    Long revisionNumber
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin
    Long sequenceNum

-- relations --
    
    - WorkEffortType (one, autoRelation: false, keymaps: workEffortTypeId)
    - WorkEffortPurposeType (one, autoRelation: false, keymaps: workEffortPurposeTypeId)
    - ParentWorkEffort (one, autoRelation: false, keymaps: workEffortParentId -> workEffortId)
    + WorkEffortTypeAttr (many, autoRelation: false, keymaps: workEffortTypeId)
    - CurrentStatusItem (one, autoRelation: false, keymaps: currentStatusId -> statusId)
    - ScopeEnumeration (one, autoRelation: false, keymaps: scopeEnumId -> enumId)
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - MoneyUom (one, autoRelation: false, keymaps: moneyUomId -> uomId)
    - RecurrenceInfo (one, autoRelation: false, keymaps: recurrenceInfoId)
    - TemporalExpression (one, autoRelation: false, keymaps: tempExprId)
    - RuntimeData (one, autoRelation: false, keymaps: runtimeDataId)
    - NoteData (one, autoRelation: false, keymaps: noteId)
    - CustomMethod (one, autoRelation: false, keymaps: estimateCalcMethod -> customMethodId)
    - AccommodationMap (one, autoRelation: false, keymaps: accommodationMapId)
    - AccommodationSpot (one, autoRelation: false, keymaps: accommodationSpotId)
    + AcctgTrans (many, autoRelation: true, keymaps: workEffortId)
    + AgreementWorkEffortApplic (many, autoRelation: true, keymaps: workEffortId)
    + CommunicationEventWorkEff (many, autoRelation: true, keymaps: workEffortId)
    + CostComponent (many, autoRelation: true, keymaps: workEffortId)
    + CustRequestItemWorkEffort (many, autoRelation: true, keymaps: workEffortId)
    + CustRequestWorkEffort (many, autoRelation: true, keymaps: workEffortId)
    + ScheduleFixedAssetMaint (many, autoRelation: true, keymaps: workEffortId -> scheduleWorkEffortId)
    + InventoryItemDetail (many, autoRelation: true, keymaps: workEffortId)
    + OrderHeaderWorkEffort (many, autoRelation: true, keymaps: workEffortId)
    + PersonTraining (many, autoRelation: true, keymaps: workEffortId)
    + RoutingProductAssoc (many, autoRelation: true, keymaps: workEffortId -> routingWorkEffortId)
    + MaintTemplateProductMaint (many, autoRelation: true, keymaps: workEffortId -> maintTemplateWorkEffortId)
    + QuoteItem (many, autoRelation: true, keymaps: workEffortId)
    + QuoteWorkEffort (many, autoRelation: true, keymaps: workEffortId)
    + RateAmount (many, autoRelation: true, keymaps: workEffortId)
    + SalesOpportunityWorkEffort (many, autoRelation: true, keymaps: workEffortId)
    + EstimatedShipShipment (many, autoRelation: true, keymaps: workEffortId -> estimatedShipWorkEffId)
    + EstimatedArrivalShipment (many, autoRelation: true, keymaps: workEffortId -> estimatedArrivalWorkEffId)
    + ShoppingListWorkEffort (many, autoRelation: true, keymaps: workEffortId)
    + TimeEntry (many, autoRelation: true, keymaps: workEffortId)
    + ChildWorkEffort (many, autoRelation: true, keymaps: workEffortId -> workEffortParentId)
    + FromWorkEffortAssoc (many, autoRelation: true, keymaps: workEffortId -> workEffortIdFrom)
    + ToWorkEffortAssoc (many, autoRelation: true, keymaps: workEffortId -> workEffortIdTo)
    + WorkEffortAttribute (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortBilling (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortContactMech (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortContent (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortCostCalc (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortDeliverableProd (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortEventReminder (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortFixedAssetAssign (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortFixedAssetStd (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortGoodStandard (many, autoRelation: true, keymaps: workEffortId)
    - WorkEffortIcalData (one-nofk, autoRelation: true, keymaps: workEffortId)
    + WorkEffortInventoryAssign (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortInventoryProduced (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortKeyword (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortNote (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortPartyAssignment (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortReview (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortSkillStandard (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortStatus (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortSurveyAppl (many, autoRelation: true, keymaps: workEffortId)
    + WorkEffortTransBox (many, autoRelation: true, keymaps: workEffortId -> processWorkEffortId)
    + WorkOrderItemFulfillment (many, autoRelation: true, keymaps: workEffortId)
    + WorkRequirementFulfillment (many, autoRelation: true, keymaps: workEffortId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

