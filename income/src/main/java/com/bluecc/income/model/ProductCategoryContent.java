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

import com.bluecc.hubs.stub.ProductCategoryContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryContentData.class,
        symbol = EntityNames.ProductCategoryContent)
public class ProductCategoryContent implements IEventModel<ProductCategoryContentData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_category_id")
	@RIndex 
    String productCategoryId;
    @SerializedName("content_id")
	@RIndex 
    String contentId;
    @SerializedName("prod_cat_content_type_id")
	@RIndex 
    String prodCatContentTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("purchase_from_date") 
    java.time.LocalDateTime purchaseFromDate;
    @SerializedName("purchase_thru_date") 
    java.time.LocalDateTime purchaseThruDate;
    @SerializedName("use_count_limit") 
    Long useCountLimit;
    @SerializedName("use_days_limit") 
    java.math.BigDecimal useDaysLimit;
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

    public ProductCategoryContentData.Builder toDataBuilder() {
        ProductCategoryContentData.Builder builder = ProductCategoryContentData.newBuilder();
        if (getProductCategoryId() != null) {
            builder.setProductCategoryId(getProductCategoryId());
        }
        if (getContentId() != null) {
            builder.setContentId(getContentId());
        }
        if (getProdCatContentTypeId() != null) {
            builder.setProdCatContentTypeId(getProdCatContentTypeId());
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
        if (getUseCountLimit() != null) {
            builder.setUseCountLimit(getUseCountLimit());
        }
        if (getUseDaysLimit() != null) {
            builder.setUseDaysLimit(getFixedPoint(getUseDaysLimit()));
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

    public static ProductCategoryContent fromData(ProductCategoryContentData data) {
        return fromPrototype(data).build();
    }

    public static ProductCategoryContent.ProductCategoryContentBuilder fromPrototype(ProductCategoryContentData data) {
        return ProductCategoryContent.builder()
                .productCategoryId(data.getProductCategoryId())
                .contentId(data.getContentId())
                .prodCatContentTypeId(data.getProdCatContentTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .purchaseFromDate(getLocalDateTime(data.getPurchaseFromDate()))
                .purchaseThruDate(getLocalDateTime(data.getPurchaseThruDate()))
                .useCountLimit(data.getUseCountLimit())
                .useDaysLimit(getBigDecimal(data.getUseDaysLimit()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productCategoryId, contentId, prodCatContentTypeId, fromDate

-- fields --
    
    String productCategoryId
    String contentId
    String prodCatContentTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.time.LocalDateTime purchaseFromDate
    java.time.LocalDateTime purchaseThruDate
    Long useCountLimit
    java.math.BigDecimal useDaysLimit

-- relations --
    
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    - Content (one, autoRelation: false, keymaps: contentId)
    - ProductCategoryContentType (one, autoRelation: false, keymaps: prodCatContentTypeId)
*/

