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

import com.bluecc.hubs.stub.ProductFeatureApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductFeatureApplData.class,
        symbol = EntityNames.ProductFeatureAppl)
public class ProductFeatureAppl implements IEventModel<ProductFeatureApplData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("product_feature_id")
	@RIndex 
    String productFeatureId;
    @SerializedName("product_feature_appl_type_id") 
    String productFeatureApplTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("recurring_amount") 
    java.math.BigDecimal recurringAmount;
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

    public ProductFeatureApplData.Builder toDataBuilder() {
        ProductFeatureApplData.Builder builder = ProductFeatureApplData.newBuilder();
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getProductFeatureId() != null) {
            builder.setProductFeatureId(getProductFeatureId());
        }
        if (getProductFeatureApplTypeId() != null) {
            builder.setProductFeatureApplTypeId(getProductFeatureApplTypeId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getRecurringAmount() != null) {
            builder.setRecurringAmount(getCurrency(getRecurringAmount()));
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

    public static ProductFeatureAppl fromData(ProductFeatureApplData data) {
        return fromPrototype(data).build();
    }

    public static ProductFeatureAppl.ProductFeatureApplBuilder fromPrototype(ProductFeatureApplData data) {
        return ProductFeatureAppl.builder()
                .productId(data.getProductId())
                .productFeatureId(data.getProductFeatureId())
                .productFeatureApplTypeId(data.getProductFeatureApplTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .amount(getBigDecimal(data.getAmount()))
                .recurringAmount(getBigDecimal(data.getRecurringAmount()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productId, productFeatureId, fromDate

-- fields --
    
    String productId
    String productFeatureId
    String productFeatureApplTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum
    java.math.BigDecimal amount
    java.math.BigDecimal recurringAmount

-- relations --
    
    - ProductFeatureApplType (one, autoRelation: false, keymaps: productFeatureApplTypeId)
    - Product (one, autoRelation: false, keymaps: productId)
    - ProductFeature (one, autoRelation: false, keymaps: productFeatureId)
    + ProductFeatureApplAttr (many, autoRelation: true, keymaps: productId, productFeatureId, fromDate)
*/

