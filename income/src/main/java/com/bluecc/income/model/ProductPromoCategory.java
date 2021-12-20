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

import com.bluecc.hubs.stub.ProductPromoCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoCategoryData.class,
        symbol = EntityNames.ProductPromoCategory)
public class ProductPromoCategory implements IEventModel<ProductPromoCategoryData.Builder>, HasId, Serializable {
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
    @SerializedName("product_category_id")
	@RIndex 
    String productCategoryId;
    @SerializedName("and_group_id")
	@RIndex 
    String andGroupId;
    @SerializedName("product_promo_appl_enum_id") 
    String productPromoApplEnumId;
    @SerializedName("include_sub_categories") 
    Character includeSubCategories;
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

    public ProductPromoCategoryData.Builder toDataBuilder() {
        ProductPromoCategoryData.Builder builder = ProductPromoCategoryData.newBuilder();
        if (getProductPromoId() != null) {
            builder.setProductPromoId(getProductPromoId());
        }
        if (getProductPromoRuleId() != null) {
            builder.setProductPromoRuleId(getProductPromoRuleId());
        }
        if (getProductPromoActionSeqId() != null) {
            builder.setProductPromoActionSeqId(getProductPromoActionSeqId());
        }
        if (getProductPromoCondSeqId() != null) {
            builder.setProductPromoCondSeqId(getProductPromoCondSeqId());
        }
        if (getProductCategoryId() != null) {
            builder.setProductCategoryId(getProductCategoryId());
        }
        if (getAndGroupId() != null) {
            builder.setAndGroupId(getAndGroupId());
        }
        if (getProductPromoApplEnumId() != null) {
            builder.setProductPromoApplEnumId(getProductPromoApplEnumId());
        }
        if (getIncludeSubCategories() != null) {
            builder.setIncludeSubCategories(getIndicator(getIncludeSubCategories()));
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

    public static ProductPromoCategory fromData(ProductPromoCategoryData data) {
        return fromPrototype(data).build();
    }

    public static ProductPromoCategory.ProductPromoCategoryBuilder fromPrototype(ProductPromoCategoryData data) {
        return ProductPromoCategory.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productPromoCondSeqId(data.getProductPromoCondSeqId())
                .productCategoryId(data.getProductCategoryId())
                .andGroupId(data.getAndGroupId())
                .productPromoApplEnumId(data.getProductPromoApplEnumId())
                .includeSubCategories(getIndicatorChar(data.getIncludeSubCategories()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productPromoId, productPromoRuleId, productPromoActionSeqId, productPromoCondSeqId, productCategoryId, andGroupId

-- fields --
    
    String productPromoId
    String productPromoRuleId
    String productPromoActionSeqId
    String productPromoCondSeqId
    String productCategoryId
    String andGroupId
    String productPromoApplEnumId
    Character includeSubCategories

-- relations --
    
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    - ApplEnumeration (one, autoRelation: false, keymaps: productPromoApplEnumId -> enumId)
*/

