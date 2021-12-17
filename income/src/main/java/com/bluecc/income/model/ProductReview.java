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

import com.bluecc.hubs.stub.ProductReviewData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductReviewData.class,
        symbol = EntityNames.ProductReview)
public class ProductReview implements IEventModel<ProductReviewData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_review_id")
	@RId 
    String productReviewId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("user_login_id") 
    String userLoginId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("posted_anonymous") 
    Character postedAnonymous;
    @SerializedName("posted_date_time") 
    java.time.LocalDateTime postedDateTime;
    @SerializedName("product_rating") 
    java.math.BigDecimal productRating;
    @SerializedName("product_review") 
    String productReview;
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
        return productReviewId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductReviewData.Builder toDataBuilder() {
        ProductReviewData.Builder builder = ProductReviewData.newBuilder();
        if (productReviewId != null) {
            builder.setProductReviewId(productReviewId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (userLoginId != null) {
            builder.setUserLoginId(userLoginId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (postedAnonymous != null) {
            builder.setPostedAnonymous(getIndicator(postedAnonymous));
        }
        if (postedDateTime != null) {
            builder.setPostedDateTime(getTimestamp(postedDateTime));
        }
        if (productRating != null) {
            builder.setProductRating(getFixedPoint(productRating));
        }
        if (productReview != null) {
            builder.setProductReview(productReview);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductReview fromData(ProductReviewData data) {
        return ProductReview.builder()
                .productReviewId(data.getProductReviewId())
                .productStoreId(data.getProductStoreId())
                .productId(data.getProductId())
                .userLoginId(data.getUserLoginId())
                .statusId(data.getStatusId())
                .postedAnonymous(getIndicatorChar(data.getPostedAnonymous()))
                .postedDateTime(getLocalDateTime(data.getPostedDateTime()))
                .productRating(getBigDecimal(data.getProductRating()))
                .productReview(data.getProductReview())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: productReviewId

-- fields --
    
    String productReviewId
    String productStoreId
    String productId
    String userLoginId
    String statusId
    Character postedAnonymous
    java.time.LocalDateTime postedDateTime
    java.math.BigDecimal productRating
    String productReview

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - Product (one, autoRelation: false, keymaps: productId)
    - UserLogin (one, autoRelation: false, keymaps: userLoginId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
*/

