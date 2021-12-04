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
import com.bluecc.hubs.stub.ProductPromoActionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPromoAction implements IEventModel<ProductPromoActionData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productPromoId;
    String productPromoRuleId;
    String productPromoActionSeqId;
    String productPromoActionEnumId;
    String customMethodId;
    String orderAdjustmentTypeId;
    String serviceName;
    java.math.BigDecimal quantity;
    java.math.BigDecimal amount;
    String productId;
    String partyId;
    Character useCartQuantity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoActionData.Builder toDataBuilder() {
        ProductPromoActionData.Builder builder = ProductPromoActionData.newBuilder();
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (productPromoRuleId != null) {
            builder.setProductPromoRuleId(productPromoRuleId);
        }
        if (productPromoActionSeqId != null) {
            builder.setProductPromoActionSeqId(productPromoActionSeqId);
        }
        if (productPromoActionEnumId != null) {
            builder.setProductPromoActionEnumId(productPromoActionEnumId);
        }
        if (customMethodId != null) {
            builder.setCustomMethodId(customMethodId);
        }
        if (orderAdjustmentTypeId != null) {
            builder.setOrderAdjustmentTypeId(orderAdjustmentTypeId);
        }
        if (serviceName != null) {
            builder.setServiceName(serviceName);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (amount != null) {
            builder.setAmount(getFixedPoint(amount));
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (useCartQuantity != null) {
            builder.setUseCartQuantity(getIndicator(useCartQuantity));
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

    public static ProductPromoAction fromData(ProductPromoActionData data) {
        return ProductPromoAction.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productPromoActionEnumId(data.getProductPromoActionEnumId())
                .customMethodId(data.getCustomMethodId())
                .orderAdjustmentTypeId(data.getOrderAdjustmentTypeId())
                .serviceName(data.getServiceName())
                .quantity(getBigDecimal(data.getQuantity()))
                .amount(getBigDecimal(data.getAmount()))
                .productId(data.getProductId())
                .partyId(data.getPartyId())
                .useCartQuantity(getIndicatorChar(data.getUseCartQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}