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

import com.bluecc.hubs.stub.ProductSubscriptionResourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductSubscriptionResourceData.class,
        symbol = EntityNames.ProductSubscriptionResource)
public class ProductSubscriptionResource implements IEventModel<ProductSubscriptionResourceData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productId;
    @RIndex String subscriptionResourceId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime purchaseFromDate;
    java.time.LocalDateTime purchaseThruDate;
    Long maxLifeTime;
    String maxLifeTimeUomId;
    Long availableTime;
    String availableTimeUomId;
    Long useCountLimit;
    Long useTime;
    String useTimeUomId;
    String useRoleTypeId;
    Character automaticExtend;
    Long canclAutmExtTime;
    String canclAutmExtTimeUomId;
    Long gracePeriodOnExpiry;
    String gracePeriodOnExpiryUomId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductSubscriptionResourceData.Builder toDataBuilder() {
        ProductSubscriptionResourceData.Builder builder = ProductSubscriptionResourceData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (subscriptionResourceId != null) {
            builder.setSubscriptionResourceId(subscriptionResourceId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (purchaseFromDate != null) {
            builder.setPurchaseFromDate(getTimestamp(purchaseFromDate));
        }
        if (purchaseThruDate != null) {
            builder.setPurchaseThruDate(getTimestamp(purchaseThruDate));
        }
        if (maxLifeTime != null) {
            builder.setMaxLifeTime(maxLifeTime);
        }
        if (maxLifeTimeUomId != null) {
            builder.setMaxLifeTimeUomId(maxLifeTimeUomId);
        }
        if (availableTime != null) {
            builder.setAvailableTime(availableTime);
        }
        if (availableTimeUomId != null) {
            builder.setAvailableTimeUomId(availableTimeUomId);
        }
        if (useCountLimit != null) {
            builder.setUseCountLimit(useCountLimit);
        }
        if (useTime != null) {
            builder.setUseTime(useTime);
        }
        if (useTimeUomId != null) {
            builder.setUseTimeUomId(useTimeUomId);
        }
        if (useRoleTypeId != null) {
            builder.setUseRoleTypeId(useRoleTypeId);
        }
        if (automaticExtend != null) {
            builder.setAutomaticExtend(getIndicator(automaticExtend));
        }
        if (canclAutmExtTime != null) {
            builder.setCanclAutmExtTime(canclAutmExtTime);
        }
        if (canclAutmExtTimeUomId != null) {
            builder.setCanclAutmExtTimeUomId(canclAutmExtTimeUomId);
        }
        if (gracePeriodOnExpiry != null) {
            builder.setGracePeriodOnExpiry(gracePeriodOnExpiry);
        }
        if (gracePeriodOnExpiryUomId != null) {
            builder.setGracePeriodOnExpiryUomId(gracePeriodOnExpiryUomId);
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

    public static ProductSubscriptionResource fromData(ProductSubscriptionResourceData data) {
        return ProductSubscriptionResource.builder()
                .productId(data.getProductId())
                .subscriptionResourceId(data.getSubscriptionResourceId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .purchaseFromDate(getLocalDateTime(data.getPurchaseFromDate()))
                .purchaseThruDate(getLocalDateTime(data.getPurchaseThruDate()))
                .maxLifeTime(data.getMaxLifeTime())
                .maxLifeTimeUomId(data.getMaxLifeTimeUomId())
                .availableTime(data.getAvailableTime())
                .availableTimeUomId(data.getAvailableTimeUomId())
                .useCountLimit(data.getUseCountLimit())
                .useTime(data.getUseTime())
                .useTimeUomId(data.getUseTimeUomId())
                .useRoleTypeId(data.getUseRoleTypeId())
                .automaticExtend(getIndicatorChar(data.getAutomaticExtend()))
                .canclAutmExtTime(data.getCanclAutmExtTime())
                .canclAutmExtTimeUomId(data.getCanclAutmExtTimeUomId())
                .gracePeriodOnExpiry(data.getGracePeriodOnExpiry())
                .gracePeriodOnExpiryUomId(data.getGracePeriodOnExpiryUomId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
