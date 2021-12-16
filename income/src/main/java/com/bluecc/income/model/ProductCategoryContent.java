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

import com.bluecc.hubs.stub.ProductCategoryContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryContentData.class,
        symbol = EntityNames.ProductCategoryContent)
public class ProductCategoryContent implements IEventModel<ProductCategoryContentData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String productCategoryId;
    @RIndex String contentId;
    @RIndex String prodCatContentTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime purchaseFromDate;
    java.time.LocalDateTime purchaseThruDate;
    Long useCountLimit;
    java.math.BigDecimal useDaysLimit;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductCategoryContentData.Builder toDataBuilder() {
        ProductCategoryContentData.Builder builder = ProductCategoryContentData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (prodCatContentTypeId != null) {
            builder.setProdCatContentTypeId(prodCatContentTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (purchaseFromDate != null) {
            builder.setPurchaseFromDate(getTimestamp(purchaseFromDate));
        }
        if (purchaseThruDate != null) {
            builder.setPurchaseThruDate(getTimestamp(purchaseThruDate));
        }
        if (useCountLimit != null) {
            builder.setUseCountLimit(useCountLimit);
        }
        if (useDaysLimit != null) {
            builder.setUseDaysLimit(getFixedPoint(useDaysLimit));
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

    public static ProductCategoryContent fromData(ProductCategoryContentData data) {
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
                
                .build();
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

