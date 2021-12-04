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
import com.bluecc.hubs.stub.ProductFeatureIactnData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeatureIactn implements IEventModel<ProductFeatureIactnData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productFeatureId;
    String productFeatureIdTo;
    String productFeatureIactnTypeId;
    String productId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFeatureIactnData.Builder toDataBuilder() {
        ProductFeatureIactnData.Builder builder = ProductFeatureIactnData.newBuilder();
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (productFeatureIdTo != null) {
            builder.setProductFeatureIdTo(productFeatureIdTo);
        }
        if (productFeatureIactnTypeId != null) {
            builder.setProductFeatureIactnTypeId(productFeatureIactnTypeId);
        }
        if (productId != null) {
            builder.setProductId(productId);
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

    public static ProductFeatureIactn fromData(ProductFeatureIactnData data) {
        return ProductFeatureIactn.builder()
                .productFeatureId(data.getProductFeatureId())
                .productFeatureIdTo(data.getProductFeatureIdTo())
                .productFeatureIactnTypeId(data.getProductFeatureIactnTypeId())
                .productId(data.getProductId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}