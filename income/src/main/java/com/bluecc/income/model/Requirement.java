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

import com.bluecc.hubs.stub.RequirementData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = RequirementData.class,
        symbol = EntityNames.Requirement)
public class Requirement implements IEventModel<RequirementData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("requirement_id")
	@RId 
    String requirementId;
    @SerializedName("requirement_type_id") 
    String requirementTypeId;
    @SerializedName("facility_id") 
    String facilityId;
    @SerializedName("deliverable_id") 
    String deliverableId;
    @SerializedName("fixed_asset_id") 
    String fixedAssetId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("description") 
    String description;
    @SerializedName("requirement_start_date") 
    java.time.LocalDateTime requirementStartDate;
    @SerializedName("required_by_date") 
    java.time.LocalDateTime requiredByDate;
    @SerializedName("estimated_budget") 
    java.math.BigDecimal estimatedBudget;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("use_case") 
    String useCase;
    @SerializedName("reason") 
    String reason;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
    @SerializedName("facility_id_to") 
    String facilityIdTo;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return requirementId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public RequirementData.Builder toDataBuilder() {
        RequirementData.Builder builder = RequirementData.newBuilder();
        if (requirementId != null) {
            builder.setRequirementId(requirementId);
        }
        if (requirementTypeId != null) {
            builder.setRequirementTypeId(requirementTypeId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (deliverableId != null) {
            builder.setDeliverableId(deliverableId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (requirementStartDate != null) {
            builder.setRequirementStartDate(getTimestamp(requirementStartDate));
        }
        if (requiredByDate != null) {
            builder.setRequiredByDate(getTimestamp(requiredByDate));
        }
        if (estimatedBudget != null) {
            builder.setEstimatedBudget(getCurrency(estimatedBudget));
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (useCase != null) {
            builder.setUseCase(useCase);
        }
        if (reason != null) {
            builder.setReason(reason);
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
        if (facilityIdTo != null) {
            builder.setFacilityIdTo(facilityIdTo);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Requirement fromData(RequirementData data) {
        return Requirement.builder()
                .requirementId(data.getRequirementId())
                .requirementTypeId(data.getRequirementTypeId())
                .facilityId(data.getFacilityId())
                .deliverableId(data.getDeliverableId())
                .fixedAssetId(data.getFixedAssetId())
                .productId(data.getProductId())
                .statusId(data.getStatusId())
                .description(data.getDescription())
                .requirementStartDate(getLocalDateTime(data.getRequirementStartDate()))
                .requiredByDate(getLocalDateTime(data.getRequiredByDate()))
                .estimatedBudget(getBigDecimal(data.getEstimatedBudget()))
                .quantity(getBigDecimal(data.getQuantity()))
                .useCase(data.getUseCase())
                .reason(data.getReason())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .facilityIdTo(data.getFacilityIdTo())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: requirementId

-- fields --
    
    String requirementId
    String requirementTypeId
    String facilityId
    String deliverableId
    String fixedAssetId
    String productId
    String statusId
    String description
    java.time.LocalDateTime requirementStartDate
    java.time.LocalDateTime requiredByDate
    java.math.BigDecimal estimatedBudget
    java.math.BigDecimal quantity
    String useCase
    String reason
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin
    String facilityIdTo

-- relations --
    
    - RequirementType (one, autoRelation: false, keymaps: requirementTypeId)
    + RequirementTypeAttr (many, autoRelation: false, keymaps: requirementTypeId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - Deliverable (one, autoRelation: false, keymaps: deliverableId)
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    - Product (one, autoRelation: false, keymaps: productId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    + DesiredFeature (many, autoRelation: true, keymaps: requirementId)
    + OrderRequirementCommitment (many, autoRelation: true, keymaps: requirementId)
    + RequirementAttribute (many, autoRelation: true, keymaps: requirementId)
    + RequirementBudgetAllocation (many, autoRelation: true, keymaps: requirementId)
    + RequirementCustRequest (many, autoRelation: true, keymaps: requirementId)
    + RequirementRole (many, autoRelation: true, keymaps: requirementId)
    + RequirementStatus (many, autoRelation: true, keymaps: requirementId)
    + WorkRequirementFulfillment (many, autoRelation: true, keymaps: requirementId)
*/

