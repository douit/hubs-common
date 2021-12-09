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

import com.bluecc.hubs.stub.ProductFacilityData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFacilityData.class,
        symbol = EntityNames.ProductFacility)
public class ProductFacility implements IEventModel<ProductFacilityData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productId;
    @RIndex String facilityId;
    java.math.BigDecimal minimumStock;
    java.math.BigDecimal reorderQuantity;
    Long daysToShip;
    String replenishMethodEnumId;
    java.math.BigDecimal lastInventoryCount;
    String requirementMethodEnumId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFacilityData.Builder toDataBuilder() {
        ProductFacilityData.Builder builder = ProductFacilityData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (minimumStock != null) {
            builder.setMinimumStock(getFixedPoint(minimumStock));
        }
        if (reorderQuantity != null) {
            builder.setReorderQuantity(getFixedPoint(reorderQuantity));
        }
        if (daysToShip != null) {
            builder.setDaysToShip(daysToShip);
        }
        if (replenishMethodEnumId != null) {
            builder.setReplenishMethodEnumId(replenishMethodEnumId);
        }
        if (lastInventoryCount != null) {
            builder.setLastInventoryCount(getFixedPoint(lastInventoryCount));
        }
        if (requirementMethodEnumId != null) {
            builder.setRequirementMethodEnumId(requirementMethodEnumId);
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

    public static ProductFacility fromData(ProductFacilityData data) {
        return ProductFacility.builder()
                .productId(data.getProductId())
                .facilityId(data.getFacilityId())
                .minimumStock(getBigDecimal(data.getMinimumStock()))
                .reorderQuantity(getBigDecimal(data.getReorderQuantity()))
                .daysToShip(data.getDaysToShip())
                .replenishMethodEnumId(data.getReplenishMethodEnumId())
                .lastInventoryCount(getBigDecimal(data.getLastInventoryCount()))
                .requirementMethodEnumId(data.getRequirementMethodEnumId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
