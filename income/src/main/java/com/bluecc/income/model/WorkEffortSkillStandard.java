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

import com.bluecc.hubs.stub.WorkEffortSkillStandardData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WorkEffortSkillStandardData.class,
        symbol = EntityNames.WorkEffortSkillStandard)
public class WorkEffortSkillStandard implements IEventModel<WorkEffortSkillStandardData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("work_effort_id")
	@RIndex 
    String workEffortId;
    @SerializedName("skill_type_id")
	@RIndex 
    String skillTypeId;
    @SerializedName("estimated_num_people") 
    Double estimatedNumPeople;
    @SerializedName("estimated_duration") 
    Double estimatedDuration;
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

    public WorkEffortSkillStandardData.Builder toDataBuilder() {
        WorkEffortSkillStandardData.Builder builder = WorkEffortSkillStandardData.newBuilder();
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getSkillTypeId() != null) {
            builder.setSkillTypeId(getSkillTypeId());
        }
        if (getEstimatedNumPeople() != null) {
            builder.setEstimatedNumPeople(getEstimatedNumPeople());
        }
        if (getEstimatedDuration() != null) {
            builder.setEstimatedDuration(getEstimatedDuration());
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

    public static WorkEffortSkillStandard fromData(WorkEffortSkillStandardData data) {
        return fromPrototype(data).build();
    }

    public static WorkEffortSkillStandard.WorkEffortSkillStandardBuilder fromPrototype(WorkEffortSkillStandardData data) {
        return WorkEffortSkillStandard.builder()
                .workEffortId(data.getWorkEffortId())
                .skillTypeId(data.getSkillTypeId())
                .estimatedNumPeople(data.getEstimatedNumPeople())
                .estimatedDuration(data.getEstimatedDuration())
                .estimatedCost(getBigDecimal(data.getEstimatedCost()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: workEffortId, skillTypeId

-- fields --
    
    String workEffortId
    String skillTypeId
    Double estimatedNumPeople
    Double estimatedDuration
    java.math.BigDecimal estimatedCost

-- relations --
    
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    - SkillType (one, autoRelation: false, keymaps: skillTypeId)
*/

