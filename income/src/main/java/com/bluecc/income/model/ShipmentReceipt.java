package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ShipmentReceiptData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentReceipt implements IEventModel<ShipmentReceiptData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String receiptId;
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