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
import com.bluecc.hubs.stub.ItemIssuanceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemIssuance implements IEventModel<ItemIssuanceData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String itemIssuanceId;
    String orderId;
    String orderItemSeqId;
    String shipGroupSeqId;
    String inventoryItemId;
    String shipmentId;
    String shipmentItemSeqId;
    String fixedAssetId;
    String maintHistSeqId;
    java.time.LocalDateTime issuedDateTime;
    String issuedByUserLoginId;
    java.math.BigDecimal quantity;
    java.math.BigDecimal cancelQuantity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ItemIssuanceData.Builder toDataBuilder() {
        ItemIssuanceData.Builder builder = ItemIssuanceData.newBuilder();
        if (itemIssuanceId != null) {
            builder.setItemIssuanceId(itemIssuanceId);
        }
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentItemSeqId != null) {
            builder.setShipmentItemSeqId(shipmentItemSeqId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (maintHistSeqId != null) {
            builder.setMaintHistSeqId(maintHistSeqId);
        }
        if (issuedDateTime != null) {
            builder.setIssuedDateTime(getTimestamp(issuedDateTime));
        }
        if (issuedByUserLoginId != null) {
            builder.setIssuedByUserLoginId(issuedByUserLoginId);
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
                    
        return builder;
    }

    public static ItemIssuance fromData(ItemIssuanceData data) {
        return ItemIssuance.builder()
                .itemIssuanceId(data.getItemIssuanceId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .inventoryItemId(data.getInventoryItemId())
                .shipmentId(data.getShipmentId())
                .shipmentItemSeqId(data.getShipmentItemSeqId())
                .fixedAssetId(data.getFixedAssetId())
                .maintHistSeqId(data.getMaintHistSeqId())
                .issuedDateTime(getLocalDateTime(data.getIssuedDateTime()))
                .issuedByUserLoginId(data.getIssuedByUserLoginId())
                .quantity(getBigDecimal(data.getQuantity()))
                .cancelQuantity(getBigDecimal(data.getCancelQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
