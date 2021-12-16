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

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ProductReviewData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductReviewData.class,
        symbol = EntityNames.ProductReview)
public class ProductReview implements IEventModel<ProductReviewData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String productReviewId;
    String productStoreId;
    String productId;
    String userLoginId;
    String statusId;
    Character postedAnonymous;
    java.time.LocalDateTime postedDateTime;
    java.math.BigDecimal productRating;
    String productReview;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
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

