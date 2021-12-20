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

import com.bluecc.hubs.stub.ShipmentMethodTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentMethodTypeData.class,
        symbol = EntityNames.ShipmentMethodType)
public class ShipmentMethodType implements IEventModel<ShipmentMethodTypeData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_method_type_id")
	@RId 
    String shipmentMethodTypeId;
    @SerializedName("description") 
    String description;
    @SerializedName("sequence_num") 
    Long sequenceNum;
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
        return shipmentMethodTypeId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentMethodTypeData.Builder toDataBuilder() {
        ShipmentMethodTypeData.Builder builder = ShipmentMethodTypeData.newBuilder();
        if (getShipmentMethodTypeId() != null) {
            builder.setShipmentMethodTypeId(getShipmentMethodTypeId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static ShipmentMethodType fromData(ShipmentMethodTypeData data) {
        return fromPrototype(data).build();
    }

    public static ShipmentMethodType.ShipmentMethodTypeBuilder fromPrototype(ShipmentMethodTypeData data) {
        return ShipmentMethodType.builder()
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .description(data.getDescription())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: shipmentMethodTypeId

-- fields --
    
    String shipmentMethodTypeId
    String description
    Long sequenceNum

-- relations --
    
    + CarrierShipmentMethod (many, autoRelation: true, keymaps: shipmentMethodTypeId)
    + EbayShippingMethod (many, autoRelation: true, keymaps: shipmentMethodTypeId)
    + FacilityCarrierShipment (many, autoRelation: true, keymaps: shipmentMethodTypeId)
    + OrderItemShipGroup (many, autoRelation: true, keymaps: shipmentMethodTypeId)
    + Picklist (many, autoRelation: true, keymaps: shipmentMethodTypeId)
    + ProductStoreShipmentMeth (many, autoRelation: true, keymaps: shipmentMethodTypeId)
    + ProductStoreVendorShipment (many, autoRelation: true, keymaps: shipmentMethodTypeId)
    + ShipmentRouteSegment (many, autoRelation: true, keymaps: shipmentMethodTypeId)
*/

