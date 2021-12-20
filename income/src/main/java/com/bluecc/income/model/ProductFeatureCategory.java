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

import com.bluecc.hubs.stub.ProductFeatureCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFeatureCategoryData.class,
        symbol = EntityNames.ProductFeatureCategory)
public class ProductFeatureCategory implements IEventModel<ProductFeatureCategoryData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_feature_category_id")
	@RId 
    String productFeatureCategoryId;
    @SerializedName("parent_category_id") 
    String parentCategoryId;
    @SerializedName("description") 
    String description;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return productFeatureCategoryId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFeatureCategoryData.Builder toDataBuilder() {
        ProductFeatureCategoryData.Builder builder = ProductFeatureCategoryData.newBuilder();
        if (getProductFeatureCategoryId() != null) {
            builder.setProductFeatureCategoryId(getProductFeatureCategoryId());
        }
        if (getParentCategoryId() != null) {
            builder.setParentCategoryId(getParentCategoryId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static ProductFeatureCategory fromData(ProductFeatureCategoryData data) {
        return fromPrototype(data).build();
    }

    public static ProductFeatureCategory.ProductFeatureCategoryBuilder fromPrototype(ProductFeatureCategoryData data) {
        return ProductFeatureCategory.builder()
                .productFeatureCategoryId(data.getProductFeatureCategoryId())
                .parentCategoryId(data.getParentCategoryId())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: productFeatureCategoryId

-- fields --
    
    String productFeatureCategoryId
    String parentCategoryId
    String description

-- relations --
    
    - ParentProductFeatureCategory (one, autoRelation: false, keymaps: parentCategoryId -> productFeatureCategoryId)
    + ProductFeature (many, autoRelation: true, keymaps: productFeatureCategoryId)
    + ChildProductFeatureCategory (many, autoRelation: true, keymaps: productFeatureCategoryId -> parentCategoryId)
    + ProductFeatureCategoryAppl (many, autoRelation: true, keymaps: productFeatureCategoryId)
*/

