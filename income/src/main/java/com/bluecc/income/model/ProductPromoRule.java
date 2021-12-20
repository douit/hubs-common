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

import com.bluecc.hubs.stub.ProductPromoRuleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoRuleData.class,
        symbol = EntityNames.ProductPromoRule)
public class ProductPromoRule implements IEventModel<ProductPromoRuleData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_promo_id")
	@RIndex 
    String productPromoId;
    @SerializedName("product_promo_rule_id")
	@RIndex 
    String productPromoRuleId;
    @SerializedName("rule_name") 
    String ruleName;
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

    public ProductPromoRuleData.Builder toDataBuilder() {
        ProductPromoRuleData.Builder builder = ProductPromoRuleData.newBuilder();
        if (getProductPromoId() != null) {
            builder.setProductPromoId(getProductPromoId());
        }
        if (getProductPromoRuleId() != null) {
            builder.setProductPromoRuleId(getProductPromoRuleId());
        }
        if (getRuleName() != null) {
            builder.setRuleName(getRuleName());
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

    public static ProductPromoRule fromData(ProductPromoRuleData data) {
        return fromPrototype(data).build();
    }

    public static ProductPromoRule.ProductPromoRuleBuilder fromPrototype(ProductPromoRuleData data) {
        return ProductPromoRule.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .ruleName(data.getRuleName())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productPromoId, productPromoRuleId

-- fields --
    
    String productPromoId
    String productPromoRuleId
    String ruleName

-- relations --
    
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    + OrderAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + ProductPromoAction (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + ProductPromoCond (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: productPromoId, productPromoRuleId)
*/

