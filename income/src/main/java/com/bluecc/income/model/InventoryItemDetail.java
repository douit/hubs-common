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

import com.bluecc.hubs.stub.InventoryItemDetailData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InventoryItemDetailData.class,
        symbol = EntityNames.InventoryItemDetail)
public class InventoryItemDetail implements IEventModel<InventoryItemDetailData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("inventory_item_id")
	@RIndex 
    String inventoryItemId;
    @SerializedName("inventory_item_detail_seq_id")
	@RIndex 
    String inventoryItemDetailSeqId;
    @SerializedName("effective_date") 
    java.time.LocalDateTime effectiveDate;
    @SerializedName("quantity_on_hand_diff") 
    java.math.BigDecimal quantityOnHandDiff;
    @SerializedName("available_to_promise_diff") 
    java.math.BigDecimal availableToPromiseDiff;
    @SerializedName("accounting_quantity_diff") 
    java.math.BigDecimal accountingQuantityDiff;
    @SerializedName("unit_cost") 
    java.math.BigDecimal unitCost;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("ship_group_seq_id") 
    String shipGroupSeqId;
    @SerializedName("shipment_id") 
    String shipmentId;
    @SerializedName("shipment_item_seq_id") 
    String shipmentItemSeqId;
    @SerializedName("return_id") 
    String returnId;
    @SerializedName("return_item_seq_id") 
    String returnItemSeqId;
    @SerializedName("work_effort_id") 
    String workEffortId;
    @SerializedName("fixed_asset_id") 
    String fixedAssetId;
    @SerializedName("maint_hist_seq_id") 
    String maintHistSeqId;
    @SerializedName("item_issuance_id") 
    String itemIssuanceId;
    @SerializedName("receipt_id") 
    String receiptId;
    @SerializedName("physical_inventory_id") 
    String physicalInventoryId;
    @SerializedName("reason_enum_id") 
    String reasonEnumId;
    @SerializedName("description") 
    String description;
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


/*
-- keys: inventoryItemId, inventoryItemDetailSeqId

-- fields --
    
    String inventoryItemId
    String inventoryItemDetailSeqId
    java.time.LocalDateTime effectiveDate
    java.math.BigDecimal quantityOnHandDiff
    java.math.BigDecimal availableToPromiseDiff
    java.math.BigDecimal accountingQuantityDiff
    java.math.BigDecimal unitCost
    String orderId
    String orderItemSeqId
    String shipGroupSeqId
    String shipmentId
    String shipmentItemSeqId
    String returnId
    String returnItemSeqId
    String workEffortId
    String fixedAssetId
    String maintHistSeqId
    String itemIssuanceId
    String receiptId
    String physicalInventoryId
    String reasonEnumId
    String description

-- relations --
    
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    - OrderItemShipGrpInvRes (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId)
    - FixedAssetMaint (one, autoRelation: false, keymaps: fixedAssetId, maintHistSeqId)
    - ItemIssuance (one, autoRelation: false, keymaps: itemIssuanceId)
    - WorkEffortInventoryAssign (one-nofk, autoRelation: false, keymaps: workEffortId, inventoryItemId)
    - WorkEffortInventoryProduced (one-nofk, autoRelation: false, keymaps: workEffortId, inventoryItemId)
    - ShipmentReceipt (one, autoRelation: false, keymaps: receiptId)
    - PhysicalInventory (one, autoRelation: false, keymaps: physicalInventoryId)
    - ReasonEnumeration (one, autoRelation: false, keymaps: reasonEnumId -> enumId)
    - InventoryItemVariance (one-nofk, autoRelation: false, keymaps: inventoryItemId, physicalInventoryId)
*/

