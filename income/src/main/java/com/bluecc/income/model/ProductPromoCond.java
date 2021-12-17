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

import com.bluecc.hubs.stub.ProductPromoCondData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoCondData.class,
        symbol = EntityNames.ProductPromoCond)
public class ProductPromoCond implements IEventModel<ProductPromoCondData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_promo_id")
	@RIndex 
    String productPromoId;
    @SerializedName("product_promo_rule_id")
	@RIndex 
    String productPromoRuleId;
    @SerializedName("product_promo_cond_seq_id")
	@RIndex 
    String productPromoCondSeqId;
    @SerializedName("custom_method_id") 
    String customMethodId;
    @SerializedName("input_param_enum_id") 
    String inputParamEnumId;
    @SerializedName("operator_enum_id") 
    String operatorEnumId;
    @SerializedName("cond_value") 
    String condValue;
    @SerializedName("other_value") 
    String otherValue;
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

    public ProductPromoCondData.Builder toDataBuilder() {
        ProductPromoCondData.Builder builder = ProductPromoCondData.newBuilder();
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (productPromoRuleId != null) {
            builder.setProductPromoRuleId(productPromoRuleId);
        }
        if (productPromoCondSeqId != null) {
            builder.setProductPromoCondSeqId(productPromoCondSeqId);
        }
        if (customMethodId != null) {
            builder.setCustomMethodId(customMethodId);
        }
        if (inputParamEnumId != null) {
            builder.setInputParamEnumId(inputParamEnumId);
        }
        if (operatorEnumId != null) {
            builder.setOperatorEnumId(operatorEnumId);
        }
        if (condValue != null) {
            builder.setCondValue(condValue);
        }
        if (otherValue != null) {
            builder.setOtherValue(otherValue);
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

    public static ProductPromoCond fromData(ProductPromoCondData data) {
        return ProductPromoCond.builder()
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoCondSeqId(data.getProductPromoCondSeqId())
                .customMethodId(data.getCustomMethodId())
                .inputParamEnumId(data.getInputParamEnumId())
                .operatorEnumId(data.getOperatorEnumId())
                .condValue(data.getCondValue())
                .otherValue(data.getOtherValue())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productPromoId, productPromoRuleId, productPromoCondSeqId

-- fields --
    
    String productPromoId
    String productPromoRuleId
    String productPromoCondSeqId
    String customMethodId
    String inputParamEnumId
    String operatorEnumId
    String condValue
    String otherValue

-- relations --
    
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - ProductPromoRule (one, autoRelation: false, keymaps: productPromoId, productPromoRuleId)
    - CustomMethod (one, autoRelation: false, keymaps: customMethodId)
    - InputParamEnumeration (one, autoRelation: false, keymaps: inputParamEnumId -> enumId)
    - OperatorEnumeration (one, autoRelation: false, keymaps: operatorEnumId -> enumId)
    + ProductPromoCategory (many, autoRelation: false, keymaps: productPromoId, productPromoRuleId, productPromoCondSeqId)
    + ProductPromoProduct (many, autoRelation: false, keymaps: productPromoId, productPromoRuleId, productPromoCondSeqId)
*/

