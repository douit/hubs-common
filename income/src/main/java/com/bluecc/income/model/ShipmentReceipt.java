package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ShipmentReceiptData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentReceiptData.class,
        symbol = EntityNames.ShipmentReceipt)
public class ShipmentReceipt implements IEventModel<ShipmentReceiptData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String receiptId;
    String inventoryItemId;
    String productId;
    String shipmentId;
    String shipmentItemSeqId;
    String shipmentPackageSeqId;
    String orderId;
    String orderItemSeqId;
    String returnId;
    String returnItemSeqId;
    String rejectionId;
    String receivedByUserLoginId;
    java.time.LocalDateTime datetimeReceived;
    String itemDescription;
    java.math.BigDecimal quantityAccepted;
    java.math.BigDecimal quantityRejected;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentReceiptData.Builder toDataBuilder() {
        ShipmentReceiptData.Builder builder = ShipmentReceiptData.newBuilder();
        if (receiptId != null) {
            builder.setReceiptId(receiptId);
        }
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentItemSeqId != null) {
            builder.setShipmentItemSeqId(shipmentItemSeqId);
        }
        if (shipmentPackageSeqId != null) {
            builder.setShipmentPackageSeqId(shipmentPackageSeqId);
        }
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (returnId != null) {
            builder.setReturnId(returnId);
        }
        if (returnItemSeqId != null) {
            builder.setReturnItemSeqId(returnItemSeqId);
        }
        if (rejectionId != null) {
            builder.setRejectionId(rejectionId);
        }
        if (receivedByUserLoginId != null) {
            builder.setReceivedByUserLoginId(receivedByUserLoginId);
        }
        if (datetimeReceived != null) {
            builder.setDatetimeReceived(getTimestamp(datetimeReceived));
        }
        if (itemDescription != null) {
            builder.setItemDescription(itemDescription);
        }
        if (quantityAccepted != null) {
            builder.setQuantityAccepted(getFixedPoint(quantityAccepted));
        }
        if (quantityRejected != null) {
            builder.setQuantityRejected(getFixedPoint(quantityRejected));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ShipmentReceipt fromData(ShipmentReceiptData data) {
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
                
                .build();
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

