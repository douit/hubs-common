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

import com.bluecc.hubs.stub.OrderItemShipGrpInvResData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemShipGrpInvResData.class,
        symbol = EntityNames.OrderItemShipGrpInvRes)
public class OrderItemShipGrpInvRes implements IEventModel<OrderItemShipGrpInvResData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_id")
	@RIndex 
    String orderId;
    @SerializedName("ship_group_seq_id")
	@RIndex 
    String shipGroupSeqId;
    @SerializedName("order_item_seq_id")
	@RIndex 
    String orderItemSeqId;
    @SerializedName("inventory_item_id")
	@RIndex 
    String inventoryItemId;
    @SerializedName("reserve_order_enum_id") 
    String reserveOrderEnumId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("quantity_not_available") 
    java.math.BigDecimal quantityNotAvailable;
    @SerializedName("reserved_datetime") 
    java.time.LocalDateTime reservedDatetime;
    @SerializedName("created_datetime") 
    java.time.LocalDateTime createdDatetime;
    @SerializedName("promised_datetime") 
    java.time.LocalDateTime promisedDatetime;
    @SerializedName("current_promised_date") 
    java.time.LocalDateTime currentPromisedDate;
    @SerializedName("priority") 
    Character priority;
    @SerializedName("sequence_id") 
    Long sequenceId;
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

    public OrderItemShipGrpInvResData.Builder toDataBuilder() {
        OrderItemShipGrpInvResData.Builder builder = OrderItemShipGrpInvResData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (reserveOrderEnumId != null) {
            builder.setReserveOrderEnumId(reserveOrderEnumId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (quantityNotAvailable != null) {
            builder.setQuantityNotAvailable(getFixedPoint(quantityNotAvailable));
        }
        if (reservedDatetime != null) {
            builder.setReservedDatetime(getTimestamp(reservedDatetime));
        }
        if (createdDatetime != null) {
            builder.setCreatedDatetime(getTimestamp(createdDatetime));
        }
        if (promisedDatetime != null) {
            builder.setPromisedDatetime(getTimestamp(promisedDatetime));
        }
        if (currentPromisedDate != null) {
            builder.setCurrentPromisedDate(getTimestamp(currentPromisedDate));
        }
        if (priority != null) {
            builder.setPriority(getIndicator(priority));
        }
        if (sequenceId != null) {
            builder.setSequenceId(sequenceId);
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

    public static OrderItemShipGrpInvRes fromData(OrderItemShipGrpInvResData data) {
        return OrderItemShipGrpInvRes.builder()
                .orderId(data.getOrderId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .inventoryItemId(data.getInventoryItemId())
                .reserveOrderEnumId(data.getReserveOrderEnumId())
                .quantity(getBigDecimal(data.getQuantity()))
                .quantityNotAvailable(getBigDecimal(data.getQuantityNotAvailable()))
                .reservedDatetime(getLocalDateTime(data.getReservedDatetime()))
                .createdDatetime(getLocalDateTime(data.getCreatedDatetime()))
                .promisedDatetime(getLocalDateTime(data.getPromisedDatetime()))
                .currentPromisedDate(getLocalDateTime(data.getCurrentPromisedDate()))
                .priority(getIndicatorChar(data.getPriority()))
                .sequenceId(data.getSequenceId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: orderId, shipGroupSeqId, orderItemSeqId, inventoryItemId

-- fields --
    
    String orderId
    String shipGroupSeqId
    String orderItemSeqId
    String inventoryItemId
    String reserveOrderEnumId
    java.math.BigDecimal quantity
    java.math.BigDecimal quantityNotAvailable
    java.time.LocalDateTime reservedDatetime
    java.time.LocalDateTime createdDatetime
    java.time.LocalDateTime promisedDatetime
    java.time.LocalDateTime currentPromisedDate
    Character priority
    Long sequenceId

-- relations --
    
    - OrderHeader (one-nofk, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - OrderItemShipGroup (one-nofk, autoRelation: false, keymaps: orderId, shipGroupSeqId)
    - OrderItemShipGroupAssoc (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    + InventoryItemDetail (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId)
    + ItemIssuance (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId)
    + PicklistItem (many, autoRelation: true, keymaps: orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId)
*/

