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
import com.bluecc.hubs.stub.ProductPriceRuleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceRule implements IEventModel<ProductPriceRuleData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productPriceRuleId;
    String ruleName;
    String description;
    Character isSale;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPriceRuleData.Builder toDataBuilder() {
        ProductPriceRuleData.Builder builder = ProductPriceRuleData.newBuilder();
        if (productPriceRuleId != null) {
            builder.setProductPriceRuleId(productPriceRuleId);
        }
        if (ruleName != null) {
            builder.setRuleName(ruleName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (isSale != null) {
            builder.setIsSale(getIndicator(isSale));
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductPriceRule fromData(ProductPriceRuleData data) {
        return ProductPriceRule.builder()
                .productPriceRuleId(data.getProductPriceRuleId())
                .ruleName(data.getRuleName())
                .description(data.getDescription())
                .isSale(getIndicatorChar(data.getIsSale()))
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}