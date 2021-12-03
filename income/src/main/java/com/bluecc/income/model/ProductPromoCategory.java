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
import com.bluecc.hubs.stub.ProductPromoCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPromoCategory implements IEventModel<ProductPromoCategoryData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productPromoId;
    String productPromoRuleId;
    String productPromoActionSeqId;
    String productPromoCondSeqId;
    String productCategoryId;
    String andGroupId;
    String productPromoApplEnumId;
    Character includeSubCategories;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoCategoryData.Builder toDataBuilder() {
        ProductPromoCategoryData.Builder builder = ProductPromoCategoryData.newBuilder();
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
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (andGroupId != null) {
            builder.setAndGroupId(andGroupId);
        }
        if (productPromoApplEnumId != null) {
            builder.setProductPromoApplEnumId(productPromoApplEnumId);
        }
        if (includeSubCategories != null) {
            builder.setIncludeSubCategories(getIndicator(includeSubCategories));
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

    public static ProductPromoCategory fromData(ProductPromoCategoryData data) {
        return ProductPromoCategory.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productPromoCondSeqId(data.getProductPromoCondSeqId())
                .productCategoryId(data.getProductCategoryId())
                .andGroupId(data.getAndGroupId())
                .productPromoApplEnumId(data.getProductPromoApplEnumId())
                .includeSubCategories(getIndicatorChar(data.getIncludeSubCategories()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
