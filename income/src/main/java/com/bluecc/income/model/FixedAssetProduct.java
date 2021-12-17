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

import com.bluecc.hubs.stub.FixedAssetProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetProductData.class,
        symbol = EntityNames.FixedAssetProduct)
public class FixedAssetProduct implements IEventModel<FixedAssetProductData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("fixed_asset_id")
	@RIndex 
    String fixedAssetId;
    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("fixed_asset_product_type_id")
	@RIndex 
    String fixedAssetProductTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("comments") 
    String comments;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("quantity_uom_id") 
    String quantityUomId;
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

    public FixedAssetProductData.Builder toDataBuilder() {
        FixedAssetProductData.Builder builder = FixedAssetProductData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (fixedAssetProductTypeId != null) {
            builder.setFixedAssetProductTypeId(fixedAssetProductTypeId);
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
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (quantityUomId != null) {
            builder.setQuantityUomId(quantityUomId);
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

    public static FixedAssetProduct fromData(FixedAssetProductData data) {
        return FixedAssetProduct.builder()
                .fixedAssetId(data.getFixedAssetId())
                .productId(data.getProductId())
                .fixedAssetProductTypeId(data.getFixedAssetProductTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .comments(data.getComments())
                .sequenceNum(data.getSequenceNum())
                .quantity(getBigDecimal(data.getQuantity()))
                .quantityUomId(data.getQuantityUomId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: fixedAssetId, productId, fixedAssetProductTypeId, fromDate

-- fields --
    
    String fixedAssetId
    String productId
    String fixedAssetProductTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String comments
    Long sequenceNum
    java.math.BigDecimal quantity
    String quantityUomId

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    - FixedAssetProductType (one, autoRelation: false, keymaps: fixedAssetProductTypeId)
    - Uom (one, autoRelation: false, keymaps: quantityUomId -> uomId)
*/

