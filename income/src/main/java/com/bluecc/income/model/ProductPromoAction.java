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

import com.bluecc.hubs.stub.ProductPromoActionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoActionData.class,
        symbol = EntityNames.ProductPromoAction)
public class ProductPromoAction implements IEventModel<ProductPromoActionData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_promo_id")
	@RIndex 
    String productPromoId;
    @SerializedName("product_promo_rule_id")
	@RIndex 
    String productPromoRuleId;
    @SerializedName("product_promo_action_seq_id")
	@RIndex 
    String productPromoActionSeqId;
    @SerializedName("product_promo_action_enum_id") 
    String productPromoActionEnumId;
    @SerializedName("custom_method_id") 
    String customMethodId;
    @SerializedName("order_adjustment_type_id") 
    String orderAdjustmentTypeId;
    @SerializedName("service_name") 
    String serviceName;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("use_cart_quantity") 
    Character useCartQuantity;
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

    public ProductPromoActionData.Builder toDataBuilder() {
        ProductPromoActionData.Builder builder = ProductPromoActionData.newBuilder();
        if (getProductPromoId() != null) {
            builder.setProductPromoId(getProductPromoId());
        }
        if (getProductPromoRuleId() != null) {
            builder.setProductPromoRuleId(getProductPromoRuleId());
        }
        if (getProductPromoActionSeqId() != null) {
            builder.setProductPromoActionSeqId(getProductPromoActionSeqId());
        }
        if (getProductPromoActionEnumId() != null) {
            builder.setProductPromoActionEnumId(getProductPromoActionEnumId());
        }
        if (getCustomMethodId() != null) {
            builder.setCustomMethodId(getCustomMethodId());
        }
        if (getOrderAdjustmentTypeId() != null) {
            builder.setOrderAdjustmentTypeId(getOrderAdjustmentTypeId());
        }
        if (getServiceName() != null) {
            builder.setServiceName(getServiceName());
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getAmount() != null) {
            builder.setAmount(getFixedPoint(getAmount()));
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getUseCartQuantity() != null) {
            builder.setUseCartQuantity(getIndicator(getUseCartQuantity()));
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

    public static ProductPromoAction fromData(ProductPromoActionData data) {
        return fromPrototype(data).build();
    }

    public static ProductPromoAction.ProductPromoActionBuilder fromPrototype(ProductPromoActionData data) {
        return ProductPromoAction.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productPromoActionEnumId(data.getProductPromoActionEnumId())
                .customMethodId(data.getCustomMethodId())
                .orderAdjustmentTypeId(data.getOrderAdjustmentTypeId())
                .serviceName(data.getServiceName())
                .quantity(getBigDecimal(data.getQuantity()))
                .amount(getBigDecimal(data.getAmount()))
                .productId(data.getProductId())
                .partyId(data.getPartyId())
                .useCartQuantity(getIndicatorChar(data.getUseCartQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productPromoId, productPromoRuleId, productPromoActionSeqId

-- fields --
    
    String productPromoId
    String productPromoRuleId
    String productPromoActionSeqId
    String productPromoActionEnumId
    String customMethodId
    String orderAdjustmentTypeId
    String serviceName
    java.math.BigDecimal quantity
    java.math.BigDecimal amount
    String productId
    String partyId
    Character useCartQuantity

-- relations --
    
    - ActionEnumeration (one, autoRelation: false, keymaps: productPromoActionEnumId -> enumId)
    - CustomMethod (one, autoRelation: false, keymaps: customMethodId)
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - ProductPromoRule (one, autoRelation: false, keymaps: productPromoId, productPromoRuleId)
    - OrderAdjustmentType (one, autoRelation: false, keymaps: orderAdjustmentTypeId)
    + ProductPromoCategory (many, autoRelation: false, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
    + ProductPromoProduct (many, autoRelation: false, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
    + OrderAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
*/

