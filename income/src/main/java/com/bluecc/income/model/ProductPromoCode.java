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

import com.bluecc.hubs.stub.ProductPromoCodeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ProductPromoCode implements IEventModel<ProductPromoCodeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productPromoCodeId;
    String productPromoId;
    Character userEntered;
    Character requireEmailOrParty;
    Long useLimitPerCode;
    Long useLimitPerCustomer;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoCodeData.Builder toDataBuilder() {
        ProductPromoCodeData.Builder builder = ProductPromoCodeData.newBuilder();
        if (productPromoCodeId != null) {
            builder.setProductPromoCodeId(productPromoCodeId);
        }
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (userEntered != null) {
            builder.setUserEntered(getIndicator(userEntered));
        }
        if (requireEmailOrParty != null) {
            builder.setRequireEmailOrParty(getIndicator(requireEmailOrParty));
        }
        if (useLimitPerCode != null) {
            builder.setUseLimitPerCode(useLimitPerCode);
        }
        if (useLimitPerCustomer != null) {
            builder.setUseLimitPerCustomer(useLimitPerCustomer);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductPromoCode fromData(ProductPromoCodeData data) {
        return ProductPromoCode.builder()
                .productPromoCodeId(data.getProductPromoCodeId())
                .productPromoId(data.getProductPromoId())
                .userEntered(getIndicatorChar(data.getUserEntered()))
                .requireEmailOrParty(getIndicatorChar(data.getRequireEmailOrParty()))
                .useLimitPerCode(data.getUseLimitPerCode())
                .useLimitPerCustomer(data.getUseLimitPerCustomer())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
