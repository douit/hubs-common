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
import com.bluecc.hubs.stub.PartyContactMechPurposeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyContactMechPurpose implements IEventModel<PartyContactMechPurposeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String partyId;
    String contactMechId;
    String contactMechPurposeTypeId;
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

    public PartyContactMechPurposeData.Builder toDataBuilder() {
        PartyContactMechPurposeData.Builder builder = PartyContactMechPurposeData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (contactMechPurposeTypeId != null) {
            builder.setContactMechPurposeTypeId(contactMechPurposeTypeId);
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

    public static PartyContactMechPurpose fromData(PartyContactMechPurposeData data) {
        return PartyContactMechPurpose.builder()
                .partyId(data.getPartyId())
                .contactMechId(data.getContactMechId())
                .contactMechPurposeTypeId(data.getContactMechPurposeTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
