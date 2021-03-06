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

import com.bluecc.hubs.stub.ShipmentItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentItemData.class,
        symbol = EntityNames.ShipmentItem)
public class ShipmentItem implements IEventModel<ShipmentItemData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_id")
	@RIndex 
    String shipmentId;
    @SerializedName("shipment_item_seq_id")
	@RIndex 
    String shipmentItemSeqId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("shipment_content_description") 
    String shipmentContentDescription;
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

    public ShipmentItemData.Builder toDataBuilder() {
        ShipmentItemData.Builder builder = ShipmentItemData.newBuilder();
        if (getShipmentId() != null) {
            builder.setShipmentId(getShipmentId());
        }
        if (getShipmentItemSeqId() != null) {
            builder.setShipmentItemSeqId(getShipmentItemSeqId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getShipmentContentDescription() != null) {
            builder.setShipmentContentDescription(getShipmentContentDescription());
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

    public static ShipmentItem fromData(ShipmentItemData data) {
        return fromPrototype(data).build();
    }

    public static ShipmentItem.ShipmentItemBuilder fromPrototype(ShipmentItemData data) {
        return ShipmentItem.builder()
                .shipmentId(data.getShipmentId())
                .shipmentItemSeqId(data.getShipmentItemSeqId())
                .productId(data.getProductId())
                .quantity(getBigDecimal(data.getQuantity()))
                .shipmentContentDescription(data.getShipmentContentDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: shipmentId, shipmentItemSeqId

-- fields --
    
    String shipmentId
    String shipmentItemSeqId
    String productId
    java.math.BigDecimal quantity
    String shipmentContentDescription

-- relations --
    
    - Shipment (one, autoRelation: false, keymaps: shipmentId)
    - Product (one, autoRelation: false, keymaps: productId)
    + ItemIssuance (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
    + OrderShipment (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
    + ReturnItemShipment (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
    + ShipmentItemBilling (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
    + ShipmentItemFeature (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
    + ShipmentPackageContent (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
    + ShippingDocument (many, autoRelation: true, keymaps: shipmentId, shipmentItemSeqId)
*/

