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

import com.bluecc.hubs.stub.ProductStoreKeywordOvrdData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreKeywordOvrdData.class,
        symbol = EntityNames.ProductStoreKeywordOvrd)
public class ProductStoreKeywordOvrd implements IEventModel<ProductStoreKeywordOvrdData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_id")
	@RIndex 
    String productStoreId;
    @SerializedName("keyword")
	@RIndex 
    String keyword;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("target") 
    String target;
    @SerializedName("target_type_enum_id") 
    String targetTypeEnumId;
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

    public ProductStoreKeywordOvrdData.Builder toDataBuilder() {
        ProductStoreKeywordOvrdData.Builder builder = ProductStoreKeywordOvrdData.newBuilder();
        if (getProductStoreId() != null) {
            builder.setProductStoreId(getProductStoreId());
        }
        if (getKeyword() != null) {
            builder.setKeyword(getKeyword());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getTarget() != null) {
            builder.setTarget(getTarget());
        }
        if (getTargetTypeEnumId() != null) {
            builder.setTargetTypeEnumId(getTargetTypeEnumId());
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

    public static ProductStoreKeywordOvrd fromData(ProductStoreKeywordOvrdData data) {
        return fromPrototype(data).build();
    }

    public static ProductStoreKeywordOvrd.ProductStoreKeywordOvrdBuilder fromPrototype(ProductStoreKeywordOvrdData data) {
        return ProductStoreKeywordOvrd.builder()
                .productStoreId(data.getProductStoreId())
                .keyword(data.getKeyword())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .target(data.getTarget())
                .targetTypeEnumId(data.getTargetTypeEnumId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productStoreId, keyword, fromDate

-- fields --
    
    String productStoreId
    String keyword
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String target
    String targetTypeEnumId

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - Enumeration (one, autoRelation: false, keymaps: targetTypeEnumId -> enumId)
*/

