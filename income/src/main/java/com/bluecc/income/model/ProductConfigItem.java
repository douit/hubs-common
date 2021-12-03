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
import com.bluecc.hubs.stub.ProductConfigItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfigItem implements IEventModel<ProductConfigItemData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String configItemId;
    String configItemTypeId;
    String configItemName;
    String description;
    String longDescription;
    String imageUrl;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductConfigItemData.Builder toDataBuilder() {
        ProductConfigItemData.Builder builder = ProductConfigItemData.newBuilder();
        if (configItemId != null) {
            builder.setConfigItemId(configItemId);
        }
        if (configItemTypeId != null) {
            builder.setConfigItemTypeId(configItemTypeId);
        }
        if (configItemName != null) {
            builder.setConfigItemName(configItemName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (longDescription != null) {
            builder.setLongDescription(longDescription);
        }
        if (imageUrl != null) {
            builder.setImageUrl(imageUrl);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductConfigItem fromData(ProductConfigItemData data) {
        return ProductConfigItem.builder()
                .configItemId(data.getConfigItemId())
                .configItemTypeId(data.getConfigItemTypeId())
                .configItemName(data.getConfigItemName())
                .description(data.getDescription())
                .longDescription(data.getLongDescription())
                .imageUrl(data.getImageUrl())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
