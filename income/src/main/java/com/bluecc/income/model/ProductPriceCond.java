package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.ProductPriceCondData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPriceCondData.class,
        symbol = EntityNames.ProductPriceCond)
public class ProductPriceCond implements IEventModel<ProductPriceCondData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productPriceRuleId;
    @RIndex String productPriceCondSeqId;
    String inputParamEnumId;
    String operatorEnumId;
    String condValue;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPriceCondData.Builder toDataBuilder() {
        ProductPriceCondData.Builder builder = ProductPriceCondData.newBuilder();
        if (productPriceRuleId != null) {
            builder.setProductPriceRuleId(productPriceRuleId);
        }
        if (productPriceCondSeqId != null) {
            builder.setProductPriceCondSeqId(productPriceCondSeqId);
        }
        if (inputParamEnumId != null) {
            builder.setInputParamEnumId(inputParamEnumId);
        }
        if (operatorEnumId != null) {
            builder.setOperatorEnumId(operatorEnumId);
        }
        if (condValue != null) {
            builder.setCondValue(condValue);
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

    public static ProductPriceCond fromData(ProductPriceCondData data) {
        return ProductPriceCond.builder()
                .productPriceRuleId(data.getProductPriceRuleId())
                .productPriceCondSeqId(data.getProductPriceCondSeqId())
                .inputParamEnumId(data.getInputParamEnumId())
                .operatorEnumId(data.getOperatorEnumId())
                .condValue(data.getCondValue())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
