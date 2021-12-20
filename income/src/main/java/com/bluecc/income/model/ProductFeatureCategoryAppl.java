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

import com.bluecc.hubs.stub.ProductFeatureCategoryApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFeatureCategoryApplData.class,
        symbol = EntityNames.ProductFeatureCategoryAppl)
public class ProductFeatureCategoryAppl implements IEventModel<ProductFeatureCategoryApplData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_category_id")
	@RIndex 
    String productCategoryId;
    @SerializedName("product_feature_category_id")
	@RIndex 
    String productFeatureCategoryId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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

    public ProductFeatureCategoryApplData.Builder toDataBuilder() {
        ProductFeatureCategoryApplData.Builder builder = ProductFeatureCategoryApplData.newBuilder();
        if (getProductCategoryId() != null) {
            builder.setProductCategoryId(getProductCategoryId());
        }
        if (getProductFeatureCategoryId() != null) {
            builder.setProductFeatureCategoryId(getProductFeatureCategoryId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
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

    public static ProductFeatureCategoryAppl fromData(ProductFeatureCategoryApplData data) {
        return fromPrototype(data).build();
    }

    public static ProductFeatureCategoryAppl.ProductFeatureCategoryApplBuilder fromPrototype(ProductFeatureCategoryApplData data) {
        return ProductFeatureCategoryAppl.builder()
                .productCategoryId(data.getProductCategoryId())
                .productFeatureCategoryId(data.getProductFeatureCategoryId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productCategoryId, productFeatureCategoryId, fromDate

-- fields --
    
    String productCategoryId
    String productFeatureCategoryId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    - ProductFeatureCategory (one, autoRelation: false, keymaps: productFeatureCategoryId)
*/

