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
import com.bluecc.hubs.stub.PartyTaxAuthInfoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyTaxAuthInfo implements IEventModel<PartyTaxAuthInfoData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String partyId;
    String taxAuthGeoId;
    String taxAuthPartyId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String partyTaxId;
    Character isExempt;
    Character isNexus;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyTaxAuthInfoData.Builder toDataBuilder() {
        PartyTaxAuthInfoData.Builder builder = PartyTaxAuthInfoData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (partyTaxId != null) {
            builder.setPartyTaxId(partyTaxId);
        }
        if (isExempt != null) {
            builder.setIsExempt(getIndicator(isExempt));
        }
        if (isNexus != null) {
            builder.setIsNexus(getIndicator(isNexus));
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

    public static PartyTaxAuthInfo fromData(PartyTaxAuthInfoData data) {
        return PartyTaxAuthInfo.builder()
                .partyId(data.getPartyId())
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .partyTaxId(data.getPartyTaxId())
                .isExempt(getIndicatorChar(data.getIsExempt()))
                .isNexus(getIndicatorChar(data.getIsNexus()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
