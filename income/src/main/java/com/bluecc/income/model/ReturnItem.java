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

import com.bluecc.hubs.stub.ReturnItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ReturnItemData.class,
        symbol = EntityNames.ReturnItem)
public class ReturnItem implements IEventModel<ReturnItemData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("return_id")
	@RIndex 
    String returnId;
    @SerializedName("return_item_seq_id")
	@RIndex 
    String returnItemSeqId;
    @SerializedName("return_reason_id") 
    String returnReasonId;
    @SerializedName("return_type_id") 
    String returnTypeId;
    @SerializedName("return_item_type_id") 
    String returnItemTypeId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("description") 
    String description;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("expected_item_status") 
    String expectedItemStatus;
    @SerializedName("return_quantity") 
    java.math.BigDecimal returnQuantity;
    @SerializedName("received_quantity") 
    java.math.BigDecimal receivedQuantity;
    @SerializedName("return_price") 
    java.math.BigDecimal returnPrice;
    @SerializedName("return_item_response_id") 
    String returnItemResponseId;
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

    public ReturnItemData.Builder toDataBuilder() {
        ReturnItemData.Builder builder = ReturnItemData.newBuilder();
        if (getReturnId() != null) {
            builder.setReturnId(getReturnId());
        }
        if (getReturnItemSeqId() != null) {
            builder.setReturnItemSeqId(getReturnItemSeqId());
        }
        if (getReturnReasonId() != null) {
            builder.setReturnReasonId(getReturnReasonId());
        }
        if (getReturnTypeId() != null) {
            builder.setReturnTypeId(getReturnTypeId());
        }
        if (getReturnItemTypeId() != null) {
            builder.setReturnItemTypeId(getReturnItemTypeId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getExpectedItemStatus() != null) {
            builder.setExpectedItemStatus(getExpectedItemStatus());
        }
        if (getReturnQuantity() != null) {
            builder.setReturnQuantity(getFixedPoint(getReturnQuantity()));
        }
        if (getReceivedQuantity() != null) {
            builder.setReceivedQuantity(getFixedPoint(getReceivedQuantity()));
        }
        if (getReturnPrice() != null) {
            builder.setReturnPrice(getCurrency(getReturnPrice()));
        }
        if (getReturnItemResponseId() != null) {
            builder.setReturnItemResponseId(getReturnItemResponseId());
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

    public static ReturnItem fromData(ReturnItemData data) {
        return fromPrototype(data).build();
    }

    public static ReturnItem.ReturnItemBuilder fromPrototype(ReturnItemData data) {
        return ReturnItem.builder()
                .returnId(data.getReturnId())
                .returnItemSeqId(data.getReturnItemSeqId())
                .returnReasonId(data.getReturnReasonId())
                .returnTypeId(data.getReturnTypeId())
                .returnItemTypeId(data.getReturnItemTypeId())
                .productId(data.getProductId())
                .description(data.getDescription())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .statusId(data.getStatusId())
                .expectedItemStatus(data.getExpectedItemStatus())
                .returnQuantity(getBigDecimal(data.getReturnQuantity()))
                .receivedQuantity(getBigDecimal(data.getReceivedQuantity()))
                .returnPrice(getBigDecimal(data.getReturnPrice()))
                .returnItemResponseId(data.getReturnItemResponseId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: returnId, returnItemSeqId

-- fields --
    
    String returnId
    String returnItemSeqId
    String returnReasonId
    String returnTypeId
    String returnItemTypeId
    String productId
    String description
    String orderId
    String orderItemSeqId
    String statusId
    String expectedItemStatus
    java.math.BigDecimal returnQuantity
    java.math.BigDecimal receivedQuantity
    java.math.BigDecimal returnPrice
    String returnItemResponseId

-- relations --
    
    - ReturnHeader (one, autoRelation: false, keymaps: returnId)
    - ReturnReason (one, autoRelation: false, keymaps: returnReasonId)
    - ReturnType (one, autoRelation: false, keymaps: returnTypeId)
    - ReturnItemType (one, autoRelation: false, keymaps: returnItemTypeId)
    - ReturnItemResponse (one, autoRelation: false, keymaps: returnItemResponseId)
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - InventoryStatusItem (one, autoRelation: false, keymaps: expectedItemStatus -> statusId)
    - Product (one, autoRelation: false, keymaps: productId)
    + OrderItemShipGrpInvRes (many, autoRelation: false, keymaps: orderId, orderItemSeqId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: returnId, returnItemSeqId)
    + ReturnItemBilling (many, autoRelation: true, keymaps: returnId, returnItemSeqId)
    + ReturnItemShipment (many, autoRelation: true, keymaps: returnId, returnItemSeqId)
    + ReturnStatus (many, autoRelation: true, keymaps: returnId, returnItemSeqId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: returnId, returnItemSeqId)
*/

