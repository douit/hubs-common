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
import com.bluecc.hubs.stub.ProductFeatureCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeatureCategory implements IEventModel<ProductFeatureCategoryData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productFeatureCategoryId;
    String parentCategoryId;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFeatureCategoryData.Builder toDataBuilder() {
        ProductFeatureCategoryData.Builder builder = ProductFeatureCategoryData.newBuilder();
        if (productFeatureCategoryId != null) {
            builder.setProductFeatureCategoryId(productFeatureCategoryId);
        }
        if (parentCategoryId != null) {
            builder.setParentCategoryId(parentCategoryId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductFeatureCategory fromData(ProductFeatureCategoryData data) {
        return ProductFeatureCategory.builder()
                .productFeatureCategoryId(data.getProductFeatureCategoryId())
                .parentCategoryId(data.getParentCategoryId())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}