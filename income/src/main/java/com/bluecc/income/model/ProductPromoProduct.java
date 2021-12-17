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

import com.bluecc.hubs.stub.ProductPromoProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoProductData.class,
        symbol = EntityNames.ProductPromoProduct)
public class ProductPromoProduct implements IEventModel<ProductPromoProductData.Builder>, HasId, Serializable {
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
    @SerializedName("product_promo_cond_seq_id")
	@RIndex 
    String productPromoCondSeqId;
    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("product_promo_appl_enum_id") 
    String productPromoApplEnumId;
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

    public ProductPromoProductData.Builder toDataBuilder() {
        ProductPromoProductData.Builder builder = ProductPromoProductData.newBuilder();
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (productPromoRuleId != null) {
            builder.setProductPromoRuleId(productPromoRuleId);
        }
        if (productPromoActionSeqId != null) {
            builder.setProductPromoActionSeqId(productPromoActionSeqId);
        }
        if (productPromoCondSeqId != null) {
            builder.setProductPromoCondSeqId(productPromoCondSeqId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productPromoApplEnumId != null) {
            builder.setProductPromoApplEnumId(productPromoApplEnumId);
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

    public static ProductPromoProduct fromData(ProductPromoProductData data) {
        return ProductPromoProduct.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productPromoCondSeqId(data.getProductPromoCondSeqId())
                .productId(data.getProductId())
                .productPromoApplEnumId(data.getProductPromoApplEnumId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productPromoId, productPromoRuleId, productPromoActionSeqId, productPromoCondSeqId, productId

-- fields --
    
    String productPromoId
    String productPromoRuleId
    String productPromoActionSeqId
    String productPromoCondSeqId
    String productId
    String productPromoApplEnumId

-- relations --
    
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - Product (one, autoRelation: false, keymaps: productId)
    - ApplEnumeration (one, autoRelation: false, keymaps: productPromoApplEnumId -> enumId)
*/

