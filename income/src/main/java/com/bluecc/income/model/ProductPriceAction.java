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

import com.bluecc.hubs.stub.ProductPriceActionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ProductPriceAction implements IEventModel<ProductPriceActionData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productPriceRuleId;
    @RIndex String productPriceActionSeqId;
    String productPriceActionTypeId;
    java.math.BigDecimal amount;
    String rateCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPriceActionData.Builder toDataBuilder() {
        ProductPriceActionData.Builder builder = ProductPriceActionData.newBuilder();
        if (productPriceRuleId != null) {
            builder.setProductPriceRuleId(productPriceRuleId);
        }
        if (productPriceActionSeqId != null) {
            builder.setProductPriceActionSeqId(productPriceActionSeqId);
        }
        if (productPriceActionTypeId != null) {
            builder.setProductPriceActionTypeId(productPriceActionTypeId);
        }
        if (amount != null) {
            builder.setAmount(getFixedPoint(amount));
        }
        if (rateCode != null) {
            builder.setRateCode(rateCode);
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

    public static ProductPriceAction fromData(ProductPriceActionData data) {
        return ProductPriceAction.builder()
                .productPriceRuleId(data.getProductPriceRuleId())
                .productPriceActionSeqId(data.getProductPriceActionSeqId())
                .productPriceActionTypeId(data.getProductPriceActionTypeId())
                .amount(getBigDecimal(data.getAmount()))
                .rateCode(data.getRateCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
