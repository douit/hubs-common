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

import com.bluecc.hubs.stub.ProductPriceCondData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPriceCondData.class,
        symbol = EntityNames.ProductPriceCond)
public class ProductPriceCond implements IEventModel<ProductPriceCondData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_price_rule_id")
	@RIndex 
    String productPriceRuleId;
    @SerializedName("product_price_cond_seq_id")
	@RIndex 
    String productPriceCondSeqId;
    @SerializedName("input_param_enum_id") 
    String inputParamEnumId;
    @SerializedName("operator_enum_id") 
    String operatorEnumId;
    @SerializedName("cond_value") 
    String condValue;
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

    public ProductPriceCondData.Builder toDataBuilder() {
        ProductPriceCondData.Builder builder = ProductPriceCondData.newBuilder();
        if (getProductPriceRuleId() != null) {
            builder.setProductPriceRuleId(getProductPriceRuleId());
        }
        if (getProductPriceCondSeqId() != null) {
            builder.setProductPriceCondSeqId(getProductPriceCondSeqId());
        }
        if (getInputParamEnumId() != null) {
            builder.setInputParamEnumId(getInputParamEnumId());
        }
        if (getOperatorEnumId() != null) {
            builder.setOperatorEnumId(getOperatorEnumId());
        }
        if (getCondValue() != null) {
            builder.setCondValue(getCondValue());
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

    public static ProductPriceCond fromData(ProductPriceCondData data) {
        return fromPrototype(data).build();
    }

    public static ProductPriceCond.ProductPriceCondBuilder fromPrototype(ProductPriceCondData data) {
        return ProductPriceCond.builder()
                .productPriceRuleId(data.getProductPriceRuleId())
                .productPriceCondSeqId(data.getProductPriceCondSeqId())
                .inputParamEnumId(data.getInputParamEnumId())
                .operatorEnumId(data.getOperatorEnumId())
                .condValue(data.getCondValue())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productPriceRuleId, productPriceCondSeqId

-- fields --
    
    String productPriceRuleId
    String productPriceCondSeqId
    String inputParamEnumId
    String operatorEnumId
    String condValue

-- relations --
    
    - ProductPriceRule (one, autoRelation: false, keymaps: productPriceRuleId)
    - InputParamEnumeration (one, autoRelation: false, keymaps: inputParamEnumId -> enumId)
    - OperatorEnumeration (one, autoRelation: false, keymaps: operatorEnumId -> enumId)
*/

