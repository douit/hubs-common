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
import com.bluecc.hubs.stub.ProductConfigOptionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductConfigOption implements IEventModel<ProductConfigOptionData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String configItemId;
    String configOptionId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String configOptionName;
    String description;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductConfigOptionData.Builder toDataBuilder() {
        ProductConfigOptionData.Builder builder = ProductConfigOptionData.newBuilder();
        if (configItemId != null) {
            builder.setConfigItemId(configItemId);
        }
        if (configOptionId != null) {
            builder.setConfigOptionId(configOptionId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (configOptionName != null) {
            builder.setConfigOptionName(configOptionName);
        }
        if (description != null) {
            builder.setDescription(description);
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

    public static ProductConfigOption fromData(ProductConfigOptionData data) {
        return ProductConfigOption.builder()
                .configItemId(data.getConfigItemId())
                .configOptionId(data.getConfigOptionId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .configOptionName(data.getConfigOptionName())
                .description(data.getDescription())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
