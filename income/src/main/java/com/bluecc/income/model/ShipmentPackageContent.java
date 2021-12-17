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

import com.bluecc.hubs.stub.ShipmentPackageContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentPackageContentData.class,
        symbol = EntityNames.ShipmentPackageContent)
public class ShipmentPackageContent implements IEventModel<ShipmentPackageContentData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_id")
	@RIndex 
    String shipmentId;
    @SerializedName("shipment_package_seq_id")
	@RIndex 
    String shipmentPackageSeqId;
    @SerializedName("shipment_item_seq_id")
	@RIndex 
    String shipmentItemSeqId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("sub_product_id") 
    String subProductId;
    @SerializedName("sub_product_quantity") 
    java.math.BigDecimal subProductQuantity;
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

    public ShipmentPackageContentData.Builder toDataBuilder() {
        ShipmentPackageContentData.Builder builder = ShipmentPackageContentData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentPackageSeqId != null) {
            builder.setShipmentPackageSeqId(shipmentPackageSeqId);
        }
        if (shipmentItemSeqId != null) {
            builder.setShipmentItemSeqId(shipmentItemSeqId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (subProductId != null) {
            builder.setSubProductId(subProductId);
        }
        if (subProductQuantity != null) {
            builder.setSubProductQuantity(getFixedPoint(subProductQuantity));
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

    public static ShipmentPackageContent fromData(ShipmentPackageContentData data) {
        return ShipmentPackageContent.builder()
                .shipmentId(data.getShipmentId())
                .shipmentPackageSeqId(data.getShipmentPackageSeqId())
                .shipmentItemSeqId(data.getShipmentItemSeqId())
                .quantity(getBigDecimal(data.getQuantity()))
                .subProductId(data.getSubProductId())
                .subProductQuantity(getBigDecimal(data.getSubProductQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: shipmentId, shipmentPackageSeqId, shipmentItemSeqId

-- fields --
    
    String shipmentId
    String shipmentPackageSeqId
    String shipmentItemSeqId
    java.math.BigDecimal quantity
    String subProductId
    java.math.BigDecimal subProductQuantity

-- relations --
    
    - ShipmentPackage (one, autoRelation: false, keymaps: shipmentId, shipmentPackageSeqId)
    - Shipment (one-nofk, autoRelation: false, keymaps: shipmentId)
    - ShipmentItem (one, autoRelation: false, keymaps: shipmentId, shipmentItemSeqId)
    - SubProduct (one, autoRelation: false, keymaps: subProductId -> productId)
*/

