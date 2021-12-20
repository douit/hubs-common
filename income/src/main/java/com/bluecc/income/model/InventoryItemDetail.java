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
        if (getInventoryItemId() != null) {
            builder.setInventoryItemId(getInventoryItemId());
        }
        if (getInventoryItemDetailSeqId() != null) {
            builder.setInventoryItemDetailSeqId(getInventoryItemDetailSeqId());
        }
        if (getEffectiveDate() != null) {
            builder.setEffectiveDate(getTimestamp(getEffectiveDate()));
        }
        if (getQuantityOnHandDiff() != null) {
            builder.setQuantityOnHandDiff(getFixedPoint(getQuantityOnHandDiff()));
        }
        if (getAvailableToPromiseDiff() != null) {
            builder.setAvailableToPromiseDiff(getFixedPoint(getAvailableToPromiseDiff()));
        }
        if (getAccountingQuantityDiff() != null) {
            builder.setAccountingQuantityDiff(getFixedPoint(getAccountingQuantityDiff()));
        }
        if (getUnitCost() != null) {
            builder.setUnitCost(getFixedPoint(getUnitCost()));
        }
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getShipGroupSeqId() != null) {
            builder.setShipGroupSeqId(getShipGroupSeqId());
        }
        if (getShipmentId() != null) {
            builder.setShipmentId(getShipmentId());
        }
        if (getShipmentItemSeqId() != null) {
            builder.setShipmentItemSeqId(getShipmentItemSeqId());
        }
        if (getReturnId() != null) {
            builder.setReturnId(getReturnId());
        }
        if (getReturnItemSeqId() != null) {
            builder.setReturnItemSeqId(getReturnItemSeqId());
        }
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getFixedAssetId() != null) {
            builder.setFixedAssetId(getFixedAssetId());
        }
        if (getMaintHistSeqId() != null) {
            builder.setMaintHistSeqId(getMaintHistSeqId());
        }
        if (getItemIssuanceId() != null) {
            builder.setItemIssuanceId(getItemIssuanceId());
        }
        if (getReceiptId() != null) {
            builder.setReceiptId(getReceiptId());
        }
        if (getPhysicalInventoryId() != null) {
            builder.setPhysicalInventoryId(getPhysicalInventoryId());
        }
        if (getReasonEnumId() != null) {
            builder.setReasonEnumId(getReasonEnumId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
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

    public static InventoryItemDetail fromData(InventoryItemDetailData data) {
        return fromPrototype(data).build();
    }

    public static InventoryItemDetail.InventoryItemDetailBuilder fromPrototype(InventoryItemDetailData data) {
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
                ;
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

