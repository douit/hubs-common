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

import com.bluecc.hubs.stub.ShipmentReceiptData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentReceiptData.class,
        symbol = EntityNames.ShipmentReceipt)
public class ShipmentReceipt implements IEventModel<ShipmentReceiptData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("receipt_id")
	@RId 
    String receiptId;
    @SerializedName("inventory_item_id") 
    String inventoryItemId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("shipment_id") 
    String shipmentId;
    @SerializedName("shipment_item_seq_id") 
    String shipmentItemSeqId;
    @SerializedName("shipment_package_seq_id") 
    String shipmentPackageSeqId;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("return_id") 
    String returnId;
    @SerializedName("return_item_seq_id") 
    String returnItemSeqId;
    @SerializedName("rejection_id") 
    String rejectionId;
    @SerializedName("received_by_user_login_id") 
    String receivedByUserLoginId;
    @SerializedName("datetime_received") 
    java.time.LocalDateTime datetimeReceived;
    @SerializedName("item_description") 
    String itemDescription;
    @SerializedName("quantity_accepted") 
    java.math.BigDecimal quantityAccepted;
    @SerializedName("quantity_rejected") 
    java.math.BigDecimal quantityRejected;
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
        return receiptId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentReceiptData.Builder toDataBuilder() {
        ShipmentReceiptData.Builder builder = ShipmentReceiptData.newBuilder();
        if (getReceiptId() != null) {
            builder.setReceiptId(getReceiptId());
        }
        if (getInventoryItemId() != null) {
            builder.setInventoryItemId(getInventoryItemId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getShipmentId() != null) {
            builder.setShipmentId(getShipmentId());
        }
        if (getShipmentItemSeqId() != null) {
            builder.setShipmentItemSeqId(getShipmentItemSeqId());
        }
        if (getShipmentPackageSeqId() != null) {
            builder.setShipmentPackageSeqId(getShipmentPackageSeqId());
        }
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getReturnId() != null) {
            builder.setReturnId(getReturnId());
        }
        if (getReturnItemSeqId() != null) {
            builder.setReturnItemSeqId(getReturnItemSeqId());
        }
        if (getRejectionId() != null) {
            builder.setRejectionId(getRejectionId());
        }
        if (getReceivedByUserLoginId() != null) {
            builder.setReceivedByUserLoginId(getReceivedByUserLoginId());
        }
        if (getDatetimeReceived() != null) {
            builder.setDatetimeReceived(getTimestamp(getDatetimeReceived()));
        }
        if (getItemDescription() != null) {
            builder.setItemDescription(getItemDescription());
        }
        if (getQuantityAccepted() != null) {
            builder.setQuantityAccepted(getFixedPoint(getQuantityAccepted()));
        }
        if (getQuantityRejected() != null) {
            builder.setQuantityRejected(getFixedPoint(getQuantityRejected()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static ShipmentReceipt fromData(ShipmentReceiptData data) {
        return fromPrototype(data).build();
    }

    public static ShipmentReceipt.ShipmentReceiptBuilder fromPrototype(ShipmentReceiptData data) {
        return ShipmentReceipt.builder()
                .receiptId(data.getReceiptId())
                .inventoryItemId(data.getInventoryItemId())
                .productId(data.getProductId())
                .shipmentId(data.getShipmentId())
                .shipmentItemSeqId(data.getShipmentItemSeqId())
                .shipmentPackageSeqId(data.getShipmentPackageSeqId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .returnId(data.getReturnId())
                .returnItemSeqId(data.getReturnItemSeqId())
                .rejectionId(data.getRejectionId())
                .receivedByUserLoginId(data.getReceivedByUserLoginId())
                .datetimeReceived(getLocalDateTime(data.getDatetimeReceived()))
                .itemDescription(data.getItemDescription())
                .quantityAccepted(getBigDecimal(data.getQuantityAccepted()))
                .quantityRejected(getBigDecimal(data.getQuantityRejected()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: receiptId

-- fields --
    
    String receiptId
    String inventoryItemId
    String productId
    String shipmentId
    String shipmentItemSeqId
    String shipmentPackageSeqId
    String orderId
    String orderItemSeqId
    String returnId
    String returnItemSeqId
    String rejectionId
    String receivedByUserLoginId
    java.time.LocalDateTime datetimeReceived
    String itemDescription
    java.math.BigDecimal quantityAccepted
    java.math.BigDecimal quantityRejected

-- relations --
    
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    - Product (one, autoRelation: false, keymaps: productId)
    - ShipmentPackage (one, autoRelation: false, keymaps: shipmentId, shipmentPackageSeqId)
    - OrderHeader (one-nofk, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - RejectionReason (one, autoRelation: false, keymaps: rejectionId)
    - UserLogin (one, autoRelation: false, keymaps: receivedByUserLoginId -> userLoginId)
    - Shipment (one-nofk, autoRelation: false, keymaps: shipmentId)
    - ShipmentItem (one-nofk, autoRelation: false, keymaps: shipmentId, shipmentItemSeqId)
    - ReturnItem (one, autoRelation: false, keymaps: returnId, returnItemSeqId)
    + AcctgTrans (many, autoRelation: true, keymaps: receiptId)
    + InventoryItemDetail (many, autoRelation: true, keymaps: receiptId)
    + OrderItemBilling (many, autoRelation: true, keymaps: receiptId -> shipmentReceiptId)
    + ReturnItemBilling (many, autoRelation: true, keymaps: receiptId -> shipmentReceiptId)
    + ShipmentReceiptRole (many, autoRelation: true, keymaps: receiptId)
*/

