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

import com.bluecc.hubs.stub.ProductPromoCondData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoCondData.class,
        symbol = EntityNames.ProductPromoCond)
public class ProductPromoCond implements IEventModel<ProductPromoCondData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productPromoId;
    @RIndex String productPromoRuleId;
    @RIndex String productPromoCondSeqId;
    String customMethodId;
    String inputParamEnumId;
    String operatorEnumId;
    String condValue;
    String otherValue;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoCondData.Builder toDataBuilder() {
        ProductPromoCondData.Builder builder = ProductPromoCondData.newBuilder();
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (productPromoRuleId != null) {
            builder.setProductPromoRuleId(productPromoRuleId);
        }
        if (productPromoCondSeqId != null) {
            builder.setProductPromoCondSeqId(productPromoCondSeqId);
        }
        if (customMethodId != null) {
            builder.setCustomMethodId(customMethodId);
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
        if (otherValue != null) {
            builder.setOtherValue(otherValue);
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

    public static ProductPromoCond fromData(ProductPromoCondData data) {
        return ProductPromoCond.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoCondSeqId(data.getProductPromoCondSeqId())
                .customMethodId(data.getCustomMethodId())
                .inputParamEnumId(data.getInputParamEnumId())
                .operatorEnumId(data.getOperatorEnumId())
                .condValue(data.getCondValue())
                .otherValue(data.getOtherValue())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
