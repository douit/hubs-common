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

import com.bluecc.hubs.stub.ProductCategoryLinkData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryLinkData.class,
        symbol = EntityNames.ProductCategoryLink)
public class ProductCategoryLink implements IEventModel<ProductCategoryLinkData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String productCategoryId;
    @RIndex String linkSeqId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String comments;
    Long sequenceNum;
    String titleText;
    String detailText;
    String imageUrl;
    String imageTwoUrl;
    String linkTypeEnumId;
    String linkInfo;
    String detailSubScreen;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductCategoryLinkData.Builder toDataBuilder() {
        ProductCategoryLinkData.Builder builder = ProductCategoryLinkData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (linkSeqId != null) {
            builder.setLinkSeqId(linkSeqId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (titleText != null) {
            builder.setTitleText(titleText);
        }
        if (detailText != null) {
            builder.setDetailText(detailText);
        }
        if (imageUrl != null) {
            builder.setImageUrl(imageUrl);
        }
        if (imageTwoUrl != null) {
            builder.setImageTwoUrl(imageTwoUrl);
        }
        if (linkTypeEnumId != null) {
            builder.setLinkTypeEnumId(linkTypeEnumId);
        }
        if (linkInfo != null) {
            builder.setLinkInfo(linkInfo);
        }
        if (detailSubScreen != null) {
            builder.setDetailSubScreen(detailSubScreen);
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

    public static ProductCategoryLink fromData(ProductCategoryLinkData data) {
        return ProductCategoryLink.builder()
                .productCategoryId(data.getProductCategoryId())
                .linkSeqId(data.getLinkSeqId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .comments(data.getComments())
                .sequenceNum(data.getSequenceNum())
                .titleText(data.getTitleText())
                .detailText(data.getDetailText())
                .imageUrl(data.getImageUrl())
                .imageTwoUrl(data.getImageTwoUrl())
                .linkTypeEnumId(data.getLinkTypeEnumId())
                .linkInfo(data.getLinkInfo())
                .detailSubScreen(data.getDetailSubScreen())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productCategoryId, linkSeqId, fromDate

-- fields --
    
    String productCategoryId
    String linkSeqId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String comments
    Long sequenceNum
    String titleText
    String detailText
    String imageUrl
    String imageTwoUrl
    String linkTypeEnumId
    String linkInfo
    String detailSubScreen

-- relations --
    
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    - LinkTypeEnumeration (one, autoRelation: false, keymaps: linkTypeEnumId -> enumId)
*/

