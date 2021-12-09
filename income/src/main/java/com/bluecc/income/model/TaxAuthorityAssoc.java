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

import com.bluecc.hubs.stub.TaxAuthorityAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class TaxAuthorityAssoc implements IEventModel<TaxAuthorityAssocData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String taxAuthGeoId;
    @RIndex String taxAuthPartyId;
    @RIndex String toTaxAuthGeoId;
    @RIndex String toTaxAuthPartyId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String taxAuthorityAssocTypeId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TaxAuthorityAssocData.Builder toDataBuilder() {
        TaxAuthorityAssocData.Builder builder = TaxAuthorityAssocData.newBuilder();
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (toTaxAuthGeoId != null) {
            builder.setToTaxAuthGeoId(toTaxAuthGeoId);
        }
        if (toTaxAuthPartyId != null) {
            builder.setToTaxAuthPartyId(toTaxAuthPartyId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (taxAuthorityAssocTypeId != null) {
            builder.setTaxAuthorityAssocTypeId(taxAuthorityAssocTypeId);
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

    public static TaxAuthorityAssoc fromData(TaxAuthorityAssocData data) {
        return TaxAuthorityAssoc.builder()
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .toTaxAuthGeoId(data.getToTaxAuthGeoId())
                .toTaxAuthPartyId(data.getToTaxAuthPartyId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .taxAuthorityAssocTypeId(data.getTaxAuthorityAssocTypeId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
