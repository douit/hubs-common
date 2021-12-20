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

import com.bluecc.hubs.stub.WorkEffortGoodStandardData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WorkEffortGoodStandardData.class,
        symbol = EntityNames.WorkEffortGoodStandard)
public class WorkEffortGoodStandard implements IEventModel<WorkEffortGoodStandardData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("work_effort_id")
	@RIndex 
    String workEffortId;
    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("work_effort_good_std_type_id")
	@RIndex 
    String workEffortGoodStdTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("estimated_quantity") 
    Double estimatedQuantity;
    @SerializedName("estimated_cost") 
    java.math.BigDecimal estimatedCost;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WorkEffortGoodStandardData.Builder toDataBuilder() {
        WorkEffortGoodStandardData.Builder builder = WorkEffortGoodStandardData.newBuilder();
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getWorkEffortGoodStdTypeId() != null) {
            builder.setWorkEffortGoodStdTypeId(getWorkEffortGoodStdTypeId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getEstimatedQuantity() != null) {
            builder.setEstimatedQuantity(getEstimatedQuantity());
        }
        if (getEstimatedCost() != null) {
            builder.setEstimatedCost(getCurrency(getEstimatedCost()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static WorkEffortGoodStandard fromData(WorkEffortGoodStandardData data) {
        return fromPrototype(data).build();
    }

    public static WorkEffortGoodStandard.WorkEffortGoodStandardBuilder fromPrototype(WorkEffortGoodStandardData data) {
        return WorkEffortGoodStandard.builder()
                .workEffortId(data.getWorkEffortId())
                .productId(data.getProductId())
                .workEffortGoodStdTypeId(data.getWorkEffortGoodStdTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .statusId(data.getStatusId())
                .estimatedQuantity(data.getEstimatedQuantity())
                .estimatedCost(getBigDecimal(data.getEstimatedCost()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: workEffortId, productId, workEffortGoodStdTypeId, fromDate

-- fields --
    
    String workEffortId
    String productId
    String workEffortGoodStdTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String statusId
    Double estimatedQuantity
    java.math.BigDecimal estimatedCost

-- relations --
    
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    - WorkEffortGoodStandardType (one, autoRelation: false, keymaps: workEffortGoodStdTypeId)
    - Product (one, autoRelation: false, keymaps: productId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
*/

