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

import com.bluecc.hubs.stub.ProductPromoProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ProductPromoProduct implements IEventModel<ProductPromoProductData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productPromoId;
    @RIndex String productPromoRuleId;
    @RIndex String productPromoActionSeqId;
    @RIndex String productPromoCondSeqId;
    @RIndex String productId;
    String productPromoApplEnumId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoProductData.Builder toDataBuilder() {
        ProductPromoProductData.Builder builder = ProductPromoProductData.newBuilder();
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (productPromoRuleId != null) {
            builder.setProductPromoRuleId(productPromoRuleId);
        }
        if (productPromoActionSeqId != null) {
            builder.setProductPromoActionSeqId(productPromoActionSeqId);
        }
        if (productPromoCondSeqId != null) {
            builder.setProductPromoCondSeqId(productPromoCondSeqId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productPromoApplEnumId != null) {
            builder.setProductPromoApplEnumId(productPromoApplEnumId);
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

    public static ProductPromoProduct fromData(ProductPromoProductData data) {
        return ProductPromoProduct.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productPromoCondSeqId(data.getProductPromoCondSeqId())
                .productId(data.getProductId())
                .productPromoApplEnumId(data.getProductPromoApplEnumId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
