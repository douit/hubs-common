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
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (cancelQuantity != null) {
            builder.setCancelQuantity(getFixedPoint(cancelQuantity));
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

    public static OrderItemShipGroupAssoc fromData(OrderItemShipGroupAssocData data) {
        return OrderItemShipGroupAssoc.builder()
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .quantity(getBigDecimal(data.getQuantity()))
                .cancelQuantity(getBigDecimal(data.getCancelQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
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

