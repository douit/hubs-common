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
import com.bluecc.hubs.stub.WorkEffortAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkEffortAssoc implements IEventModel<WorkEffortAssocData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String workEffortIdFrom;
    String workEffortIdTo;
    String workEffortAssocTypeId;
    Long sequenceNum;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
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
