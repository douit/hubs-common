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

import com.bluecc.hubs.stub.WorkEffortFixedAssetAssignData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WorkEffortFixedAssetAssignData.class,
        symbol = EntityNames.WorkEffortFixedAssetAssign)
public class WorkEffortFixedAssetAssign implements IEventModel<WorkEffortFixedAssetAssignData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("work_effort_id")
	@RIndex 
    String workEffortId;
    @SerializedName("fixed_asset_id")
	@RIndex 
    String fixedAssetId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("availability_status_id") 
    String availabilityStatusId;
    @SerializedName("allocated_cost") 
    java.math.BigDecimal allocatedCost;
    @SerializedName("comments") 
    String comments;
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

    public WorkEffortFixedAssetAssignData.Builder toDataBuilder() {
        WorkEffortFixedAssetAssignData.Builder builder = WorkEffortFixedAssetAssignData.newBuilder();
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getFixedAssetId() != null) {
            builder.setFixedAssetId(getFixedAssetId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getAvailabilityStatusId() != null) {
            builder.setAvailabilityStatusId(getAvailabilityStatusId());
        }
        if (getAllocatedCost() != null) {
            builder.setAllocatedCost(getCurrency(getAllocatedCost()));
        }
        if (getComments() != null) {
            builder.setComments(getComments());
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

    public static WorkEffortFixedAssetAssign fromData(WorkEffortFixedAssetAssignData data) {
        return fromPrototype(data).build();
    }

    public static WorkEffortFixedAssetAssign.WorkEffortFixedAssetAssignBuilder fromPrototype(WorkEffortFixedAssetAssignData data) {
        return WorkEffortFixedAssetAssign.builder()
                .workEffortId(data.getWorkEffortId())
                .fixedAssetId(data.getFixedAssetId())
                .statusId(data.getStatusId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .availabilityStatusId(data.getAvailabilityStatusId())
                .allocatedCost(getBigDecimal(data.getAllocatedCost()))
                .comments(data.getComments())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: workEffortId, fixedAssetId, fromDate

-- fields --
    
    String workEffortId
    String fixedAssetId
    String statusId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String availabilityStatusId
    java.math.BigDecimal allocatedCost
    String comments

-- relations --
    
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - AvailabilityStatusItem (one, autoRelation: false, keymaps: availabilityStatusId -> statusId)
*/

