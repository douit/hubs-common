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

import com.bluecc.hubs.stub.ProductPriceActionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPriceActionData.class,
        symbol = EntityNames.ProductPriceAction)
public class ProductPriceAction implements IEventModel<ProductPriceActionData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_price_rule_id")
	@RIndex 
    String productPriceRuleId;
    @SerializedName("product_price_action_seq_id")
	@RIndex 
    String productPriceActionSeqId;
    @SerializedName("product_price_action_type_id") 
    String productPriceActionTypeId;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("rate_code") 
    String rateCode;
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

    public ProductPriceActionData.Builder toDataBuilder() {
        ProductPriceActionData.Builder builder = ProductPriceActionData.newBuilder();
        if (productPriceRuleId != null) {
            builder.setProductPriceRuleId(productPriceRuleId);
        }
        if (productPriceActionSeqId != null) {
            builder.setProductPriceActionSeqId(productPriceActionSeqId);
        }
        if (productPriceActionTypeId != null) {
            builder.setProductPriceActionTypeId(productPriceActionTypeId);
        }
        if (amount != null) {
            builder.setAmount(getFixedPoint(amount));
        }
        if (rateCode != null) {
            builder.setRateCode(rateCode);
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

    public static ProductPriceAction fromData(ProductPriceActionData data) {
        return ProductPriceAction.builder()
                .productPriceRuleId(data.getProductPriceRuleId())
                .productPriceActionSeqId(data.getProductPriceActionSeqId())
                .productPriceActionTypeId(data.getProductPriceActionTypeId())
                .amount(getBigDecimal(data.getAmount()))
                .rateCode(data.getRateCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productPriceRuleId, productPriceActionSeqId

-- fields --
    
    String productPriceRuleId
    String productPriceActionSeqId
    String productPriceActionTypeId
    java.math.BigDecimal amount
    String rateCode

-- relations --
    
    - ProductPriceActionType (one, autoRelation: false, keymaps: productPriceActionTypeId)
    - ProductPriceRule (one, autoRelation: false, keymaps: productPriceRuleId)
    + OrderItemPriceInfo (many, autoRelation: true, keymaps: productPriceRuleId, productPriceActionSeqId)
*/

