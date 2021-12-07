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

import com.bluecc.hubs.stub.SupplierProductFeatureData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class SupplierProductFeature implements IEventModel<SupplierProductFeatureData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String partyId;
    @RIndex String productFeatureId;
    String description;
    String uomId;
    String idCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SupplierProductFeatureData.Builder toDataBuilder() {
        SupplierProductFeatureData.Builder builder = SupplierProductFeatureData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (idCode != null) {
            builder.setIdCode(idCode);
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

    public static SupplierProductFeature fromData(SupplierProductFeatureData data) {
        return SupplierProductFeature.builder()
                .partyId(data.getPartyId())
                .productFeatureId(data.getProductFeatureId())
                .description(data.getDescription())
                .uomId(data.getUomId())
                .idCode(data.getIdCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
