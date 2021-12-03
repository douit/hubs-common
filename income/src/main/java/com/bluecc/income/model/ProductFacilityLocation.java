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
import com.bluecc.hubs.stub.ProductFacilityLocationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFacilityLocation implements IEventModel<ProductFacilityLocationData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productId;
    String facilityId;
    String locationSeqId;
    java.math.BigDecimal minimumStock;
    java.math.BigDecimal moveQuantity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFacilityLocationData.Builder toDataBuilder() {
        ProductFacilityLocationData.Builder builder = ProductFacilityLocationData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (locationSeqId != null) {
            builder.setLocationSeqId(locationSeqId);
        }
        if (minimumStock != null) {
            builder.setMinimumStock(getFixedPoint(minimumStock));
        }
        if (moveQuantity != null) {
            builder.setMoveQuantity(getFixedPoint(moveQuantity));
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

    public static ProductFacilityLocation fromData(ProductFacilityLocationData data) {
        return ProductFacilityLocation.builder()
                .productId(data.getProductId())
                .facilityId(data.getFacilityId())
                .locationSeqId(data.getLocationSeqId())
                .minimumStock(getBigDecimal(data.getMinimumStock()))
                .moveQuantity(getBigDecimal(data.getMoveQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
