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

import com.bluecc.hubs.stub.OrderItemShipGroupAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemShipGroupAssocData.class,
        symbol = EntityNames.OrderItemShipGroupAssoc)
public class OrderItemShipGroupAssoc implements IEventModel<OrderItemShipGroupAssocData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_id")
	@RIndex 
    String orderId;
    @SerializedName("order_item_seq_id")
	@RIndex 
    String orderItemSeqId;
    @SerializedName("ship_group_seq_id")
	@RIndex 
    String shipGroupSeqId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("cancel_quantity") 
    java.math.BigDecimal cancelQuantity;
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

    public OrderItemShipGroupAssocData.Builder toDataBuilder() {
        OrderItemShipGroupAssocData.Builder builder = OrderItemShipGroupAssocData.newBuilder();
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getShipGroupSeqId() != null) {
            builder.setShipGroupSeqId(getShipGroupSeqId());
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getCancelQuantity() != null) {
            builder.setCancelQuantity(getFixedPoint(getCancelQuantity()));
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

    public static OrderItemShipGroupAssoc fromData(OrderItemShipGroupAssocData data) {
        return fromPrototype(data).build();
    }

    public static OrderItemShipGroupAssoc.OrderItemShipGroupAssocBuilder fromPrototype(OrderItemShipGroupAssocData data) {
        return OrderItemShipGroupAssoc.builder()
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .quantity(getBigDecimal(data.getQuantity()))
                .cancelQuantity(getBigDecimal(data.getCancelQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: orderId, orderItemSeqId, shipGroupSeqId

-- fields --
    
    String orderId
    String orderItemSeqId
    String shipGroupSeqId
    java.math.BigDecimal quantity
    java.math.BigDecimal cancelQuantity

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - OrderItemShipGroup (one, autoRelation: false, keymaps: orderId, shipGroupSeqId)
    + OrderAdjustment (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
    + FromOrderItemAssoc (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
    + ToOrderItemAssoc (many, autoRelation: true, keymaps: orderId -> toOrderId, orderItemSeqId -> toOrderItemSeqId, shipGroupSeqId -> toShipGroupSeqId)
    + OrderItemShipGrpInvRes (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
    + OrderShipment (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
    + WorkOrderItemFulfillment (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
*/

