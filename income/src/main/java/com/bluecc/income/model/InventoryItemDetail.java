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
import com.bluecc.hubs.stub.InventoryItemDetailData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemDetail implements IEventModel<InventoryItemDetailData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String inventoryItemId;
    String inventoryItemDetailSeqId;
    java.time.LocalDateTime effectiveDate;
    java.math.BigDecimal quantityOnHandDiff;
    java.math.BigDecimal availableToPromiseDiff;
    java.math.BigDecimal accountingQuantityDiff;
    java.math.BigDecimal unitCost;
    String orderId;
    String orderItemSeqId;
    String shipGroupSeqId;
    String shipmentId;
    String shipmentItemSeqId;
    String returnId;
    String returnItemSeqId;
    String workEffortId;
    String fixedAssetId;
    String maintHistSeqId;
    String itemIssuanceId;
    String receiptId;
    String physicalInventoryId;
    String reasonEnumId;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InventoryItemDetailData.Builder toDataBuilder() {
        InventoryItemDetailData.Builder builder = InventoryItemDetailData.newBuilder();
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (inventoryItemDetailSeqId != null) {
            builder.setInventoryItemDetailSeqId(inventoryItemDetailSeqId);
        }
        if (effectiveDate != null) {
            builder.setEffectiveDate(getTimestamp(effectiveDate));
        }
        if (quantityOnHandDiff != null) {
            builder.setQuantityOnHandDiff(getFixedPoint(quantityOnHandDiff));
        }
        if (availableToPromiseDiff != null) {
            builder.setAvailableToPromiseDiff(getFixedPoint(availableToPromiseDiff));
        }
        if (accountingQuantityDiff != null) {
            builder.setAccountingQuantityDiff(getFixedPoint(accountingQuantityDiff));
        }
        if (unitCost != null) {
            builder.setUnitCost(getFixedPoint(unitCost));
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
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentItemSeqId != null) {
            builder.setShipmentItemSeqId(shipmentItemSeqId);
        }
        if (returnId != null) {
            builder.setReturnId(returnId);
        }
        if (returnItemSeqId != null) {
            builder.setReturnItemSeqId(returnItemSeqId);
        }
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (maintHistSeqId != null) {
            builder.setMaintHistSeqId(maintHistSeqId);
        }
        if (itemIssuanceId != null) {
            builder.setItemIssuanceId(itemIssuanceId);
        }
        if (receiptId != null) {
            builder.setReceiptId(receiptId);
        }
        if (physicalInventoryId != null) {
            builder.setPhysicalInventoryId(physicalInventoryId);
        }
        if (reasonEnumId != null) {
            builder.setReasonEnumId(reasonEnumId);
        }
        if (description != null) {
            builder.setDescription(description);
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

    public static InventoryItemDetail fromData(InventoryItemDetailData data) {
        return InventoryItemDetail.builder()
                .inventoryItemId(data.getInventoryItemId())
                .inventoryItemDetailSeqId(data.getInventoryItemDetailSeqId())
                .effectiveDate(getLocalDateTime(data.getEffectiveDate()))
                .quantityOnHandDiff(getBigDecimal(data.getQuantityOnHandDiff()))
                .availableToPromiseDiff(getBigDecimal(data.getAvailableToPromiseDiff()))
                .accountingQuantityDiff(getBigDecimal(data.getAccountingQuantityDiff()))
                .unitCost(getBigDecimal(data.getUnitCost()))
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .shipmentId(data.getShipmentId())
                .shipmentItemSeqId(data.getShipmentItemSeqId())
                .returnId(data.getReturnId())
                .returnItemSeqId(data.getReturnItemSeqId())
                .workEffortId(data.getWorkEffortId())
                .fixedAssetId(data.getFixedAssetId())
                .maintHistSeqId(data.getMaintHistSeqId())
                .itemIssuanceId(data.getItemIssuanceId())
                .receiptId(data.getReceiptId())
                .physicalInventoryId(data.getPhysicalInventoryId())
                .reasonEnumId(data.getReasonEnumId())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
