//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.ProductSubscriptionResourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductSubscriptionResourceData.class,
        symbol = EntityNames.ProductSubscriptionResource)
public class ProductSubscriptionResource implements IEventModel<ProductSubscriptionResourceData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("subscription_resource_id")
	@RIndex 
    String subscriptionResourceId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("purchase_from_date") 
    java.time.LocalDateTime purchaseFromDate;
    @SerializedName("purchase_thru_date") 
    java.time.LocalDateTime purchaseThruDate;
    @SerializedName("max_life_time") 
    Long maxLifeTime;
    @SerializedName("max_life_time_uom_id") 
    String maxLifeTimeUomId;
    @SerializedName("available_time") 
    Long availableTime;
    @SerializedName("available_time_uom_id") 
    String availableTimeUomId;
    @SerializedName("use_count_limit") 
    Long useCountLimit;
    @SerializedName("use_time") 
    Long useTime;
    @SerializedName("use_time_uom_id") 
    String useTimeUomId;
    @SerializedName("use_role_type_id") 
    String useRoleTypeId;
    @SerializedName("automatic_extend") 
    Character automaticExtend;
    @SerializedName("cancl_autm_ext_time") 
    Long canclAutmExtTime;
    @SerializedName("cancl_autm_ext_time_uom_id") 
    String canclAutmExtTimeUomId;
    @SerializedName("grace_period_on_expiry") 
    Long gracePeriodOnExpiry;
    @SerializedName("grace_period_on_expiry_uom_id") 
    String gracePeriodOnExpiryUomId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductSubscriptionResourceData.Builder toDataBuilder() {
        ProductSubscriptionResourceData.Builder builder = ProductSubscriptionResourceData.newBuilder();
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getSubscriptionResourceId() != null) {
            builder.setSubscriptionResourceId(getSubscriptionResourceId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getPurchaseFromDate() != null) {
            builder.setPurchaseFromDate(getTimestamp(getPurchaseFromDate()));
        }
        if (getPurchaseThruDate() != null) {
            builder.setPurchaseThruDate(getTimestamp(getPurchaseThruDate()));
        }
        if (getMaxLifeTime() != null) {
            builder.setMaxLifeTime(getMaxLifeTime());
        }
        if (getMaxLifeTimeUomId() != null) {
            builder.setMaxLifeTimeUomId(getMaxLifeTimeUomId());
        }
        if (getAvailableTime() != null) {
            builder.setAvailableTime(getAvailableTime());
        }
        if (getAvailableTimeUomId() != null) {
            builder.setAvailableTimeUomId(getAvailableTimeUomId());
        }
        if (getUseCountLimit() != null) {
            builder.setUseCountLimit(getUseCountLimit());
        }
        if (getUseTime() != null) {
            builder.setUseTime(getUseTime());
        }
        if (getUseTimeUomId() != null) {
            builder.setUseTimeUomId(getUseTimeUomId());
        }
        if (getUseRoleTypeId() != null) {
            builder.setUseRoleTypeId(getUseRoleTypeId());
        }
        if (getAutomaticExtend() != null) {
            builder.setAutomaticExtend(getIndicator(getAutomaticExtend()));
        }
        if (getCanclAutmExtTime() != null) {
            builder.setCanclAutmExtTime(getCanclAutmExtTime());
        }
        if (getCanclAutmExtTimeUomId() != null) {
            builder.setCanclAutmExtTimeUomId(getCanclAutmExtTimeUomId());
        }
        if (getGracePeriodOnExpiry() != null) {
            builder.setGracePeriodOnExpiry(getGracePeriodOnExpiry());
        }
        if (getGracePeriodOnExpiryUomId() != null) {
            builder.setGracePeriodOnExpiryUomId(getGracePeriodOnExpiryUomId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static ProductSubscriptionResource fromData(ProductSubscriptionResourceData data) {
        return fromPrototype(data).build();
    }

    public static ProductSubscriptionResource.ProductSubscriptionResourceBuilder fromPrototype(ProductSubscriptionResourceData data) {
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
                ;
    }

    
}


/*
-- keys: productId, subscriptionResourceId, fromDate

-- fields --
    
    String productId
    String subscriptionResourceId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.time.LocalDateTime purchaseFromDate
    java.time.LocalDateTime purchaseThruDate
    Long maxLifeTime
    String maxLifeTimeUomId
    Long availableTime
    String availableTimeUomId
    Long useCountLimit
    Long useTime
    String useTimeUomId
    String useRoleTypeId
    Character automaticExtend
    Long canclAutmExtTime
    String canclAutmExtTimeUomId
    Long gracePeriodOnExpiry
    String gracePeriodOnExpiryUomId

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - SubscriptionResource (one, autoRelation: false, keymaps: subscriptionResourceId)
    - UseRoleType (one, autoRelation: false, keymaps: useRoleTypeId -> roleTypeId)
    - UseTimeUom (one, autoRelation: false, keymaps: useTimeUomId -> uomId)
    - CancelTimeUom (one, autoRelation: false, keymaps: canclAutmExtTimeUomId -> uomId)
    - AvailableTimeUom (one, autoRelation: false, keymaps: availableTimeUomId -> uomId)
    - MaxLifeTimeUom (one, autoRelation: false, keymaps: maxLifeTimeUomId -> uomId)
    - GracePeriodUom (one, autoRelation: false, keymaps: gracePeriodOnExpiryUomId -> uomId)
*/

