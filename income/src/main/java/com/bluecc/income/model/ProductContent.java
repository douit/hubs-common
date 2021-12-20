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

import com.bluecc.hubs.stub.ProductContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductContentData.class,
        symbol = EntityNames.ProductContent)
public class ProductContent implements IEventModel<ProductContentData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("content_id")
	@RIndex 
    String contentId;
    @SerializedName("product_content_type_id")
	@RIndex 
    String productContentTypeId;
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
    @SerializedName("use_time") 
    Long useTime;
    @SerializedName("use_time_uom_id") 
    String useTimeUomId;
    @SerializedName("use_role_type_id") 
    String useRoleTypeId;
    @SerializedName("sequence_num") 
    Long sequenceNum;
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

    public ProductContentData.Builder toDataBuilder() {
        ProductContentData.Builder builder = ProductContentData.newBuilder();
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getContentId() != null) {
            builder.setContentId(getContentId());
        }
        if (getProductContentTypeId() != null) {
            builder.setProductContentTypeId(getProductContentTypeId());
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
        if (getUseTime() != null) {
            builder.setUseTime(getUseTime());
        }
        if (getUseTimeUomId() != null) {
            builder.setUseTimeUomId(getUseTimeUomId());
        }
        if (getUseRoleTypeId() != null) {
            builder.setUseRoleTypeId(getUseRoleTypeId());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
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

    public static ProductContent fromData(ProductContentData data) {
        return fromPrototype(data).build();
    }

    public static ProductContent.ProductContentBuilder fromPrototype(ProductContentData data) {
        return ProductContent.builder()
                .productId(data.getProductId())
                .contentId(data.getContentId())
                .productContentTypeId(data.getProductContentTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .purchaseFromDate(getLocalDateTime(data.getPurchaseFromDate()))
                .purchaseThruDate(getLocalDateTime(data.getPurchaseThruDate()))
                .useCountLimit(data.getUseCountLimit())
                .useTime(data.getUseTime())
                .useTimeUomId(data.getUseTimeUomId())
                .useRoleTypeId(data.getUseRoleTypeId())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productId, contentId, productContentTypeId, fromDate

-- fields --
    
    String productId
    String contentId
    String productContentTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.time.LocalDateTime purchaseFromDate
    java.time.LocalDateTime purchaseThruDate
    Long useCountLimit
    Long useTime
    String useTimeUomId
    String useRoleTypeId
    Long sequenceNum

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - Content (one, autoRelation: false, keymaps: contentId)
    - ProductContentType (one, autoRelation: false, keymaps: productContentTypeId)
    - UseRoleType (one, autoRelation: false, keymaps: useRoleTypeId -> roleTypeId)
    - UseTimeUom (one, autoRelation: false, keymaps: useTimeUomId -> uomId)
*/

