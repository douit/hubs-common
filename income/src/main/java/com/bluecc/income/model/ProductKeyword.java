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

import com.bluecc.hubs.stub.ProductKeywordData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductKeywordData.class,
        symbol = EntityNames.ProductKeyword)
public class ProductKeyword implements IEventModel<ProductKeywordData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("keyword")
	@RIndex 
    String keyword;
    @SerializedName("keyword_type_id")
	@RIndex 
    String keywordTypeId;
    @SerializedName("relevancy_weight") 
    Long relevancyWeight;
    @SerializedName("status_id") 
    String statusId;
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

    public ProductKeywordData.Builder toDataBuilder() {
        ProductKeywordData.Builder builder = ProductKeywordData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (keyword != null) {
            builder.setKeyword(keyword);
        }
        if (keywordTypeId != null) {
            builder.setKeywordTypeId(keywordTypeId);
        }
        if (relevancyWeight != null) {
            builder.setRelevancyWeight(relevancyWeight);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
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

    public static ProductKeyword fromData(ProductKeywordData data) {
        return ProductKeyword.builder()
                .productId(data.getProductId())
                .keyword(data.getKeyword())
                .keywordTypeId(data.getKeywordTypeId())
                .relevancyWeight(data.getRelevancyWeight())
                .statusId(data.getStatusId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productId, keyword, keywordTypeId

-- fields --
    
    String productId
    String keyword
    String keywordTypeId
    Long relevancyWeight
    String statusId

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - Enumeration (one, autoRelation: false, keymaps: keywordTypeId -> enumId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
*/

