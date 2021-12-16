package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.WorkEffortAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WorkEffortAssocData.class,
        symbol = EntityNames.WorkEffortAssoc)
public class WorkEffortAssoc implements IEventModel<WorkEffortAssocData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String workEffortIdFrom;
    @RIndex String workEffortIdTo;
    @RIndex String workEffortAssocTypeId;
    Long sequenceNum;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WorkEffortAssocData.Builder toDataBuilder() {
        WorkEffortAssocData.Builder builder = WorkEffortAssocData.newBuilder();
        if (workEffortIdFrom != null) {
            builder.setWorkEffortIdFrom(workEffortIdFrom);
        }
        if (workEffortIdTo != null) {
            builder.setWorkEffortIdTo(workEffortIdTo);
        }
        if (workEffortAssocTypeId != null) {
            builder.setWorkEffortAssocTypeId(workEffortAssocTypeId);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
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

    public static WorkEffortAssoc fromData(WorkEffortAssocData data) {
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
                
                .build();
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

