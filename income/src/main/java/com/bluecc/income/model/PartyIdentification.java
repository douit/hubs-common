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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.PartyIdentificationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class PartyIdentification implements IEventModel<PartyIdentificationData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String partyId;
    @RIndex String partyIdentificationTypeId;
    String idValue;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyIdentificationData.Builder toDataBuilder() {
        PartyIdentificationData.Builder builder = PartyIdentificationData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (partyIdentificationTypeId != null) {
            builder.setPartyIdentificationTypeId(partyIdentificationTypeId);
        }
        if (idValue != null) {
            builder.setIdValue(idValue);
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

    public static PartyIdentification fromData(PartyIdentificationData data) {
        return PartyIdentification.builder()
                .partyId(data.getPartyId())
                .partyIdentificationTypeId(data.getPartyIdentificationTypeId())
                .idValue(data.getIdValue())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}