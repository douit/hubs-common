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

import com.bluecc.hubs.stub.ItemIssuanceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ItemIssuanceData.class,
        symbol = EntityNames.ItemIssuance)
public class ItemIssuance implements IEventModel<ItemIssuanceData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("item_issuance_id")
	@RId 
    String itemIssuanceId;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("ship_group_seq_id") 
    String shipGroupSeqId;
    @SerializedName("inventory_item_id") 
    String inventoryItemId;
    @SerializedName("shipment_id") 
    String shipmentId;
    @SerializedName("shipment_item_seq_id") 
    String shipmentItemSeqId;
    @SerializedName("fixed_asset_id") 
    String fixedAssetId;
    @SerializedName("maint_hist_seq_id") 
    String maintHistSeqId;
    @SerializedName("issued_date_time") 
    java.time.LocalDateTime issuedDateTime;
    @SerializedName("issued_by_user_login_id") 
    String issuedByUserLoginId;
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
    
    @Override
    public String getId(){
        return itemIssuanceId;
    }

        
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


/*
-- keys: itemIssuanceId

-- fields --
    
    String itemIssuanceId
    String orderId
    String orderItemSeqId
    String shipGroupSeqId
    String inventoryItemId
    String shipmentId
    String shipmentItemSeqId
    String fixedAssetId
    String maintHistSeqId
    java.time.LocalDateTime issuedDateTime
    String issuedByUserLoginId
    java.math.BigDecimal quantity
    java.math.BigDecimal cancelQuantity

-- relations --
    
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    - OrderItemShipGrpInvRes (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId, shipGroupSeqId, inventoryItemId)
    - Shipment (one-nofk, autoRelation: false, keymaps: shipmentId)
    - ShipmentItem (one, autoRelation: false, keymaps: shipmentId, shipmentItemSeqId)
    - FixedAssetMaint (one, autoRelation: false, keymaps: fixedAssetId, maintHistSeqId)
    - OrderHeader (one-nofk, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - IssuedByUserLogin (one, autoRelation: false, keymaps: issuedByUserLoginId -> userLoginId)
    + InventoryItemDetail (many, autoRelation: true, keymaps: itemIssuanceId)
    + InventoryTransfer (many, autoRelation: true, keymaps: itemIssuanceId)
    + ItemIssuanceRole (many, autoRelation: true, keymaps: itemIssuanceId)
    + OrderItemBilling (many, autoRelation: true, keymaps: itemIssuanceId)
*/

