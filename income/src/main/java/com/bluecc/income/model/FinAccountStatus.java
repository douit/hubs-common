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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.FinAccountStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FinAccountStatusData.class,
        symbol = EntityNames.FinAccountStatus)
public class FinAccountStatus implements IEventModel<FinAccountStatusData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String finAccountId;
    @RIndex String statusId;
    java.time.LocalDateTime statusDate;
    java.time.LocalDateTime statusEndDate;
    String changeByUserLoginId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FinAccountStatusData.Builder toDataBuilder() {
        FinAccountStatusData.Builder builder = FinAccountStatusData.newBuilder();
        if (finAccountId != null) {
            builder.setFinAccountId(finAccountId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (statusDate != null) {
            builder.setStatusDate(getTimestamp(statusDate));
        }
        if (statusEndDate != null) {
            builder.setStatusEndDate(getTimestamp(statusEndDate));
        }
        if (changeByUserLoginId != null) {
            builder.setChangeByUserLoginId(changeByUserLoginId);
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

    public static FinAccountStatus fromData(FinAccountStatusData data) {
        return FinAccountStatus.builder()
                .finAccountId(data.getFinAccountId())
                .statusId(data.getStatusId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .statusEndDate(getLocalDateTime(data.getStatusEndDate()))
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
