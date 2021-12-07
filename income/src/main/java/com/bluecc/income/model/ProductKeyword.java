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

import com.bluecc.hubs.stub.ProductKeywordData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ProductKeyword implements IEventModel<ProductKeywordData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productId;
    @RIndex String keyword;
    @RIndex String keywordTypeId;
    Long relevancyWeight;
    String statusId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductKeywordData.Builder toDataBuilder() {
        ProductKeywordData.Builder builder = ProductKeywordData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (keyword != null) {
            builder.setKeyword(keyword);
        }
        if (keywordTypeId != null) {
            builder.setKeywordTypeId(keywordTypeId);
        }
        if (relevancyWeight != null) {
            builder.setRelevancyWeight(relevancyWeight);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
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

    public static ProductKeyword fromData(ProductKeywordData data) {
        return ProductKeyword.builder()
                .productId(data.getProductId())
                .keyword(data.getKeyword())
                .keywordTypeId(data.getKeywordTypeId())
                .relevancyWeight(data.getRelevancyWeight())
                .statusId(data.getStatusId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
