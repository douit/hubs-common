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

import com.bluecc.hubs.stub.WorkEffortAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WorkEffortAssocData.class,
        symbol = EntityNames.WorkEffortAssoc)
public class WorkEffortAssoc implements IEventModel<WorkEffortAssocData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("work_effort_id_from")
	@RIndex 
    String workEffortIdFrom;
    @SerializedName("work_effort_id_to")
	@RIndex 
    String workEffortIdTo;
    @SerializedName("work_effort_assoc_type_id")
	@RIndex 
    String workEffortAssocTypeId;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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

    public WorkEffortAssocData.Builder toDataBuilder() {
        WorkEffortAssocData.Builder builder = WorkEffortAssocData.newBuilder();
        if (getWorkEffortIdFrom() != null) {
            builder.setWorkEffortIdFrom(getWorkEffortIdFrom());
        }
        if (getWorkEffortIdTo() != null) {
            builder.setWorkEffortIdTo(getWorkEffortIdTo());
        }
        if (getWorkEffortAssocTypeId() != null) {
            builder.setWorkEffortAssocTypeId(getWorkEffortAssocTypeId());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
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

    public static WorkEffortAssoc fromData(WorkEffortAssocData data) {
        return fromPrototype(data).build();
    }

    public static WorkEffortAssoc.WorkEffortAssocBuilder fromPrototype(WorkEffortAssocData data) {
        return WorkEffortAssoc.builder()
                .workEffortIdFrom(data.getWorkEffortIdFrom())
                .workEffortIdTo(data.getWorkEffortIdTo())
                .workEffortAssocTypeId(data.getWorkEffortAssocTypeId())
                .sequenceNum(data.getSequenceNum())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: workEffortIdFrom, workEffortIdTo, workEffortAssocTypeId, fromDate

-- fields --
    
    String workEffortIdFrom
    String workEffortIdTo
    String workEffortAssocTypeId
    Long sequenceNum
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - WorkEffortAssocType (one, autoRelation: false, keymaps: workEffortAssocTypeId)
    + WorkEffortAssocTypeAttr (many, autoRelation: false, keymaps: workEffortAssocTypeId)
    - FromWorkEffort (one, autoRelation: false, keymaps: workEffortIdFrom -> workEffortId)
    - ToWorkEffort (one, autoRelation: false, keymaps: workEffortIdTo -> workEffortId)
    + WorkEffortAssocAttribute (many, autoRelation: true, keymaps: workEffortIdFrom, workEffortIdTo, workEffortAssocTypeId, fromDate)
*/

