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

import com.bluecc.hubs.stub.OrderItemPriceInfoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemPriceInfoData.class,
        symbol = EntityNames.OrderItemPriceInfo)
public class OrderItemPriceInfo implements IEventModel<OrderItemPriceInfoData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_item_price_info_id")
	@RId 
    String orderItemPriceInfoId;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("product_price_rule_id") 
    String productPriceRuleId;
    @SerializedName("product_price_action_seq_id") 
    String productPriceActionSeqId;
    @SerializedName("modify_amount") 
    java.math.BigDecimal modifyAmount;
    @SerializedName("description") 
    String description;
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
    
    @Override
    public String getId(){
        return orderItemPriceInfoId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemPriceInfoData.Builder toDataBuilder() {
        OrderItemPriceInfoData.Builder builder = OrderItemPriceInfoData.newBuilder();
        if (getOrderItemPriceInfoId() != null) {
            builder.setOrderItemPriceInfoId(getOrderItemPriceInfoId());
        }
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getProductPriceRuleId() != null) {
            builder.setProductPriceRuleId(getProductPriceRuleId());
        }
        if (getProductPriceActionSeqId() != null) {
            builder.setProductPriceActionSeqId(getProductPriceActionSeqId());
        }
        if (getModifyAmount() != null) {
            builder.setModifyAmount(getCurrency(getModifyAmount()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getRateCode() != null) {
            builder.setRateCode(getRateCode());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static OrderItemPriceInfo fromData(OrderItemPriceInfoData data) {
        return fromPrototype(data).build();
    }

    public static OrderItemPriceInfo.OrderItemPriceInfoBuilder fromPrototype(OrderItemPriceInfoData data) {
        return OrderItemPriceInfo.builder()
                .orderItemPriceInfoId(data.getOrderItemPriceInfoId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .productPriceRuleId(data.getProductPriceRuleId())
                .productPriceActionSeqId(data.getProductPriceActionSeqId())
                .modifyAmount(getBigDecimal(data.getModifyAmount()))
                .description(data.getDescription())
                .rateCode(data.getRateCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: orderItemPriceInfoId

-- fields --
    
    String orderItemPriceInfoId
    String orderId
    String orderItemSeqId
    String productPriceRuleId
    String productPriceActionSeqId
    java.math.BigDecimal modifyAmount
    String description
    String rateCode

-- relations --
    
    - OrderHeader (one-nofk, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - ProductPriceRule (one-nofk, autoRelation: false, keymaps: productPriceRuleId)
    - ProductPriceAction (one, autoRelation: false, keymaps: productPriceRuleId, productPriceActionSeqId)
*/

