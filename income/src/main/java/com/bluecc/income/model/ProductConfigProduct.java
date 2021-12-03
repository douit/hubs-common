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
import com.bluecc.hubs.stub.ProductConfigProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfigProduct implements IEventModel<ProductConfigProductData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String configItemId;
    String configOptionId;
    String productId;
    java.math.BigDecimal quantity;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductConfigProductData.Builder toDataBuilder() {
        ProductConfigProductData.Builder builder = ProductConfigProductData.newBuilder();
        if (configItemId != null) {
            builder.setConfigItemId(configItemId);
        }
        if (configOptionId != null) {
            builder.setConfigOptionId(configOptionId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
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

    public static ProductConfigProduct fromData(ProductConfigProductData data) {
        return ProductConfigProduct.builder()
                .configItemId(data.getConfigItemId())
                .configOptionId(data.getConfigOptionId())
                .productId(data.getProductId())
                .quantity(getBigDecimal(data.getQuantity()))
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
