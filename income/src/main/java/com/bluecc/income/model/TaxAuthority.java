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

import com.bluecc.hubs.stub.TaxAuthorityData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class TaxAuthority implements IEventModel<TaxAuthorityData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String taxAuthGeoId;
    @RIndex String taxAuthPartyId;
    Character requireTaxIdForExemption;
    String taxIdFormatPattern;
    Character includeTaxInPrice;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TaxAuthorityData.Builder toDataBuilder() {
        TaxAuthorityData.Builder builder = TaxAuthorityData.newBuilder();
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (requireTaxIdForExemption != null) {
            builder.setRequireTaxIdForExemption(getIndicator(requireTaxIdForExemption));
        }
        if (taxIdFormatPattern != null) {
            builder.setTaxIdFormatPattern(taxIdFormatPattern);
        }
        if (includeTaxInPrice != null) {
            builder.setIncludeTaxInPrice(getIndicator(includeTaxInPrice));
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

    public static TaxAuthority fromData(TaxAuthorityData data) {
        return TaxAuthority.builder()
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .requireTaxIdForExemption(getIndicatorChar(data.getRequireTaxIdForExemption()))
                .taxIdFormatPattern(data.getTaxIdFormatPattern())
                .includeTaxInPrice(getIndicatorChar(data.getIncludeTaxInPrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
