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

import com.bluecc.hubs.stub.ProductCategoryLinkData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryLinkData.class,
        symbol = EntityNames.ProductCategoryLink)
public class ProductCategoryLink implements IEventModel<ProductCategoryLinkData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_category_id")
	@RIndex 
    String productCategoryId;
    @SerializedName("link_seq_id")
	@RIndex 
    String linkSeqId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("comments") 
    String comments;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("title_text") 
    String titleText;
    @SerializedName("detail_text") 
    String detailText;
    @SerializedName("image_url") 
    String imageUrl;
    @SerializedName("image_two_url") 
    String imageTwoUrl;
    @SerializedName("link_type_enum_id") 
    String linkTypeEnumId;
    @SerializedName("link_info") 
    String linkInfo;
    @SerializedName("detail_sub_screen") 
    String detailSubScreen;
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

    public ProductCategoryLinkData.Builder toDataBuilder() {
        ProductCategoryLinkData.Builder builder = ProductCategoryLinkData.newBuilder();
        if (getProductCategoryId() != null) {
            builder.setProductCategoryId(getProductCategoryId());
        }
        if (getLinkSeqId() != null) {
            builder.setLinkSeqId(getLinkSeqId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getTitleText() != null) {
            builder.setTitleText(getTitleText());
        }
        if (getDetailText() != null) {
            builder.setDetailText(getDetailText());
        }
        if (getImageUrl() != null) {
            builder.setImageUrl(getImageUrl());
        }
        if (getImageTwoUrl() != null) {
            builder.setImageTwoUrl(getImageTwoUrl());
        }
        if (getLinkTypeEnumId() != null) {
            builder.setLinkTypeEnumId(getLinkTypeEnumId());
        }
        if (getLinkInfo() != null) {
            builder.setLinkInfo(getLinkInfo());
        }
        if (getDetailSubScreen() != null) {
            builder.setDetailSubScreen(getDetailSubScreen());
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

    public static ProductCategoryLink fromData(ProductCategoryLinkData data) {
        return fromPrototype(data).build();
    }

    public static ProductCategoryLink.ProductCategoryLinkBuilder fromPrototype(ProductCategoryLinkData data) {
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
                ;
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

