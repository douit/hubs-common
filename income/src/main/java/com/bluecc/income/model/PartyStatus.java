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
import com.bluecc.hubs.stub.PartyStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyStatus implements IEventModel<PartyStatusData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String statusId;
    String partyId;
    java.time.LocalDateTime statusDate;
    String changeByUserLoginId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyStatusData.Builder toDataBuilder() {
        PartyStatusData.Builder builder = PartyStatusData.newBuilder();
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (statusDate != null) {
            builder.setStatusDate(getTimestamp(statusDate));
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

    public static PartyStatus fromData(PartyStatusData data) {
        return PartyStatus.builder()
                .statusId(data.getStatusId())
                .partyId(data.getPartyId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}