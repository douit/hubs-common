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
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (availabilityStatusId != null) {
            builder.setAvailabilityStatusId(availabilityStatusId);
        }
        if (allocatedCost != null) {
            builder.setAllocatedCost(getCurrency(allocatedCost));
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static WorkEffortFixedAssetAssign fromData(WorkEffortFixedAssetAssignData data) {
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
                
                .build();
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

