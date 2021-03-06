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
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
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
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getWorkEffortTypeId() != null) {
            builder.setWorkEffortTypeId(getWorkEffortTypeId());
        }
        if (getCurrentStatusId() != null) {
            builder.setCurrentStatusId(getCurrentStatusId());
        }
        if (getLastStatusUpdate() != null) {
            builder.setLastStatusUpdate(getTimestamp(getLastStatusUpdate()));
        }
        if (getWorkEffortPurposeTypeId() != null) {
            builder.setWorkEffortPurposeTypeId(getWorkEffortPurposeTypeId());
        }
        if (getWorkEffortParentId() != null) {
            builder.setWorkEffortParentId(getWorkEffortParentId());
        }
        if (getScopeEnumId() != null) {
            builder.setScopeEnumId(getScopeEnumId());
        }
        if (getPriority() != null) {
            builder.setPriority(getPriority());
        }
        if (getPercentComplete() != null) {
            builder.setPercentComplete(getPercentComplete());
        }
        if (getWorkEffortName() != null) {
            builder.setWorkEffortName(getWorkEffortName());
        }
        if (getShowAsEnumId() != null) {
            builder.setShowAsEnumId(getShowAsEnumId());
        }
        if (getSendNotificationEmail() != null) {
            builder.setSendNotificationEmail(getIndicator(getSendNotificationEmail()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLocationDesc() != null) {
            builder.setLocationDesc(getLocationDesc());
        }
        if (getEstimatedStartDate() != null) {
            builder.setEstimatedStartDate(getTimestamp(getEstimatedStartDate()));
        }
        if (getEstimatedCompletionDate() != null) {
            builder.setEstimatedCompletionDate(getTimestamp(getEstimatedCompletionDate()));
        }
        if (getActualStartDate() != null) {
            builder.setActualStartDate(getTimestamp(getActualStartDate()));
        }
        if (getActualCompletionDate() != null) {
            builder.setActualCompletionDate(getTimestamp(getActualCompletionDate()));
        }
        if (getEstimatedMilliSeconds() != null) {
            builder.setEstimatedMilliSeconds(getEstimatedMilliSeconds());
        }
        if (getEstimatedSetupMillis() != null) {
            builder.setEstimatedSetupMillis(getEstimatedSetupMillis());
        }
        if (getEstimateCalcMethod() != null) {
            builder.setEstimateCalcMethod(getEstimateCalcMethod());
        }
        if (getActualMilliSeconds() != null) {
            builder.setActualMilliSeconds(getActualMilliSeconds());
        }
        if (getActualSetupMillis() != null) {
            builder.setActualSetupMillis(getActualSetupMillis());
        }
        if (getTotalMilliSecondsAllowed() != null) {
            builder.setTotalMilliSecondsAllowed(getTotalMilliSecondsAllowed());
        }
        if (getTotalMoneyAllowed() != null) {
            builder.setTotalMoneyAllowed(getCurrency(getTotalMoneyAllowed()));
        }
        if (getMoneyUomId() != null) {
            builder.setMoneyUomId(getMoneyUomId());
        }
        if (getSpecialTerms() != null) {
            builder.setSpecialTerms(getSpecialTerms());
        }
        if (getTimeTransparency() != null) {
            builder.setTimeTransparency(getTimeTransparency());
        }
        if (getUniversalId() != null) {
            builder.setUniversalId(getUniversalId());
        }
        if (getSourceReferenceId() != null) {
            builder.setSourceReferenceId(getSourceReferenceId());
        }
        if (getFixedAssetId() != null) {
            builder.setFixedAssetId(getFixedAssetId());
        }
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getInfoUrl() != null) {
            builder.setInfoUrl(getInfoUrl());
        }
        if (getRecurrenceInfoId() != null) {
            builder.setRecurrenceInfoId(getRecurrenceInfoId());
        }
        if (getTempExprId() != null) {
            builder.setTempExprId(getTempExprId());
        }
        if (getRuntimeDataId() != null) {
            builder.setRuntimeDataId(getRuntimeDataId());
        }
        if (getNoteId() != null) {
            builder.setNoteId(getNoteId());
        }
        if (getServiceLoaderName() != null) {
            builder.setServiceLoaderName(getServiceLoaderName());
        }
        if (getQuantityToProduce() != null) {
            builder.setQuantityToProduce(getFixedPoint(getQuantityToProduce()));
        }
        if (getQuantityProduced() != null) {
            builder.setQuantityProduced(getFixedPoint(getQuantityProduced()));
        }
        if (getQuantityRejected() != null) {
            builder.setQuantityRejected(getFixedPoint(getQuantityRejected()));
        }
        if (getReservPersons() != null) {
            builder.setReservPersons(getFixedPoint(getReservPersons()));
        }
        if (getReserv2ndPPPerc() != null) {
            builder.setReserv2NdPPPerc(getFixedPoint(getReserv2ndPPPerc()));
        }
        if (getReservNthPPPerc() != null) {
            builder.setReservNthPPPerc(getFixedPoint(getReservNthPPPerc()));
        }
        if (getAccommodationMapId() != null) {
            builder.setAccommodationMapId(getAccommodationMapId());
        }
        if (getAccommodationSpotId() != null) {
            builder.setAccommodationSpotId(getAccommodationSpotId());
        }
        if (getRevisionNumber() != null) {
            builder.setRevisionNumber(getRevisionNumber());
        }
        if (getCreatedDate() != null) {
            builder.setCreatedDate(getTimestamp(getCreatedDate()));
        }
        if (getCreatedByUserLogin() != null) {
            builder.setCreatedByUserLogin(getCreatedByUserLogin());
        }
        if (getLastModifiedDate() != null) {
            builder.setLastModifiedDate(getTimestamp(getLastModifiedDate()));
        }
        if (getLastModifiedByUserLogin() != null) {
            builder.setLastModifiedByUserLogin(getLastModifiedByUserLogin());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static WorkEffort fromData(WorkEffortFlatData data) {
        return fromPrototype(data).build();
    }

    public static WorkEffort.WorkEffortBuilder fromPrototype(WorkEffortFlatData data) {
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
                ;
    }

        // relations
     
    @Exclude
    @Singular("addParentWorkEffort")
    @SerializedName("parent_work_effort") 
    List<WorkEffort> relParentWorkEffort= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAsset")
    @SerializedName("fixed_asset") 
    List<FixedAsset> relFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addFacility")
    @SerializedName("facility") 
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addRecurrenceInfo")
    @SerializedName("recurrence_info") 
    List<RecurrenceInfo> relRecurrenceInfo= new ArrayList<>(); 
    @Exclude
    @Singular("addTemporalExpression")
    @SerializedName("temporal_expression") 
    List<TemporalExpression> relTemporalExpression= new ArrayList<>(); 
    @Exclude
    @Singular("addCustomMethod")
    @SerializedName("custom_method") 
    List<CustomMethod> relCustomMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    @SerializedName("acctg_trans") 
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItemDetail")
    @SerializedName("inventory_item_detail") 
    List<InventoryItemDetail> relInventoryItemDetail= new ArrayList<>(); 
    @Exclude
    @Singular("addRoutingProductAssoc")
    @SerializedName("routing_product_assoc") 
    List<ProductAssoc> relRoutingProductAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteItem")
    @SerializedName("quote_item") 
    List<QuoteItem> relQuoteItem= new ArrayList<>(); 
    @Exclude
    @Singular("addRateAmount")
    @SerializedName("rate_amount") 
    List<RateAmount> relRateAmount= new ArrayList<>(); 
    @Exclude
    @Singular("addEstimatedShipShipment")
    @SerializedName("estimated_ship_shipment") 
    List<Shipment> relEstimatedShipShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addEstimatedArrivalShipment")
    @SerializedName("estimated_arrival_shipment") 
    List<Shipment> relEstimatedArrivalShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addChildWorkEffort")
    @SerializedName("child_work_effort") 
    List<WorkEffort> relChildWorkEffort= new ArrayList<>(); 
    @Exclude
    @Singular("addFromWorkEffortAssoc")
    @SerializedName("from_work_effort_assoc") 
    List<WorkEffortAssoc> relFromWorkEffortAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addToWorkEffortAssoc")
    @SerializedName("to_work_effort_assoc") 
    List<WorkEffortAssoc> relToWorkEffortAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortFixedAssetAssign")
    @SerializedName("work_effort_fixed_asset_assign") 
    List<WorkEffortFixedAssetAssign> relWorkEffortFixedAssetAssign= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortGoodStandard")
    @SerializedName("work_effort_good_standard") 
    List<WorkEffortGoodStandard> relWorkEffortGoodStandard= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortPartyAssignment")
    @SerializedName("work_effort_party_assignment") 
    List<WorkEffortPartyAssignment> relWorkEffortPartyAssignment= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortSkillStandard")
    @SerializedName("work_effort_skill_standard") 
    List<WorkEffortSkillStandard> relWorkEffortSkillStandard= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
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
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getWorkEffortTypeId() != null) {
            builder.setWorkEffortTypeId(getWorkEffortTypeId());
        }
        if (getCurrentStatusId() != null) {
            builder.setCurrentStatusId(getCurrentStatusId());
        }
        if (getLastStatusUpdate() != null) {
            builder.setLastStatusUpdate(getTimestamp(getLastStatusUpdate()));
        }
        if (getWorkEffortPurposeTypeId() != null) {
            builder.setWorkEffortPurposeTypeId(getWorkEffortPurposeTypeId());
        }
        if (getScopeEnumId() != null) {
            builder.setScopeEnumId(getScopeEnumId());
        }
        if (getPriority() != null) {
            builder.setPriority(getPriority());
        }
        if (getPercentComplete() != null) {
            builder.setPercentComplete(getPercentComplete());
        }
        if (getWorkEffortName() != null) {
            builder.setWorkEffortName(getWorkEffortName());
        }
        if (getShowAsEnumId() != null) {
            builder.setShowAsEnumId(getShowAsEnumId());
        }
        if (getSendNotificationEmail() != null) {
            builder.setSendNotificationEmail(getIndicator(getSendNotificationEmail()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLocationDesc() != null) {
            builder.setLocationDesc(getLocationDesc());
        }
        if (getEstimatedStartDate() != null) {
            builder.setEstimatedStartDate(getTimestamp(getEstimatedStartDate()));
        }
        if (getEstimatedCompletionDate() != null) {
            builder.setEstimatedCompletionDate(getTimestamp(getEstimatedCompletionDate()));
        }
        if (getActualStartDate() != null) {
            builder.setActualStartDate(getTimestamp(getActualStartDate()));
        }
        if (getActualCompletionDate() != null) {
            builder.setActualCompletionDate(getTimestamp(getActualCompletionDate()));
        }
        if (getEstimatedMilliSeconds() != null) {
            builder.setEstimatedMilliSeconds(getEstimatedMilliSeconds());
        }
        if (getEstimatedSetupMillis() != null) {
            builder.setEstimatedSetupMillis(getEstimatedSetupMillis());
        }
        if (getActualMilliSeconds() != null) {
            builder.setActualMilliSeconds(getActualMilliSeconds());
        }
        if (getActualSetupMillis() != null) {
            builder.setActualSetupMillis(getActualSetupMillis());
        }
        if (getTotalMilliSecondsAllowed() != null) {
            builder.setTotalMilliSecondsAllowed(getTotalMilliSecondsAllowed());
        }
        if (getTotalMoneyAllowed() != null) {
            builder.setTotalMoneyAllowed(getCurrency(getTotalMoneyAllowed()));
        }
        if (getMoneyUomId() != null) {
            builder.setMoneyUomId(getMoneyUomId());
        }
        if (getSpecialTerms() != null) {
            builder.setSpecialTerms(getSpecialTerms());
        }
        if (getTimeTransparency() != null) {
            builder.setTimeTransparency(getTimeTransparency());
        }
        if (getUniversalId() != null) {
            builder.setUniversalId(getUniversalId());
        }
        if (getSourceReferenceId() != null) {
            builder.setSourceReferenceId(getSourceReferenceId());
        }
        if (getInfoUrl() != null) {
            builder.setInfoUrl(getInfoUrl());
        }
        if (getRuntimeDataId() != null) {
            builder.setRuntimeDataId(getRuntimeDataId());
        }
        if (getNoteId() != null) {
            builder.setNoteId(getNoteId());
        }
        if (getServiceLoaderName() != null) {
            builder.setServiceLoaderName(getServiceLoaderName());
        }
        if (getQuantityToProduce() != null) {
            builder.setQuantityToProduce(getFixedPoint(getQuantityToProduce()));
        }
        if (getQuantityProduced() != null) {
            builder.setQuantityProduced(getFixedPoint(getQuantityProduced()));
        }
        if (getQuantityRejected() != null) {
            builder.setQuantityRejected(getFixedPoint(getQuantityRejected()));
        }
        if (getReservPersons() != null) {
            builder.setReservPersons(getFixedPoint(getReservPersons()));
        }
        if (getReserv2ndPPPerc() != null) {
            builder.setReserv2NdPPPerc(getFixedPoint(getReserv2ndPPPerc()));
        }
        if (getReservNthPPPerc() != null) {
            builder.setReservNthPPPerc(getFixedPoint(getReservNthPPPerc()));
        }
        if (getAccommodationMapId() != null) {
            builder.setAccommodationMapId(getAccommodationMapId());
        }
        if (getAccommodationSpotId() != null) {
            builder.setAccommodationSpotId(getAccommodationSpotId());
        }
        if (getRevisionNumber() != null) {
            builder.setRevisionNumber(getRevisionNumber());
        }
        if (getCreatedDate() != null) {
            builder.setCreatedDate(getTimestamp(getCreatedDate()));
        }
        if (getCreatedByUserLogin() != null) {
            builder.setCreatedByUserLogin(getCreatedByUserLogin());
        }
        if (getLastModifiedDate() != null) {
            builder.setLastModifiedDate(getTimestamp(getLastModifiedDate()));
        }
        if (getLastModifiedByUserLogin() != null) {
            builder.setLastModifiedByUserLogin(getLastModifiedByUserLogin());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
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

