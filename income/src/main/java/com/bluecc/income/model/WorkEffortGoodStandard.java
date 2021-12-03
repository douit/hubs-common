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
import com.bluecc.hubs.stub.WorkEffortGoodStandardData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkEffortGoodStandard implements IEventModel<WorkEffortGoodStandardData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String workEffortId;
    String productId;
    String workEffortGoodStdTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String statusId;
    Double estimatedQuantity;
    java.math.BigDecimal estimatedCost;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WorkEffortGoodStandardData.Builder toDataBuilder() {
        WorkEffortGoodStandardData.Builder builder = WorkEffortGoodStandardData.newBuilder();
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (workEffortGoodStdTypeId != null) {
            builder.setWorkEffortGoodStdTypeId(workEffortGoodStdTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (estimatedQuantity != null) {
            builder.setEstimatedQuantity(estimatedQuantity);
        }
        if (estimatedCost != null) {
            builder.setEstimatedCost(getCurrency(estimatedCost));
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

    public static WorkEffortGoodStandard fromData(WorkEffortGoodStandardData data) {
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
                
                .build();
    }

    
}
