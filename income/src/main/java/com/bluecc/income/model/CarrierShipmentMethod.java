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

import com.bluecc.hubs.stub.CarrierShipmentMethodData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CarrierShipmentMethodData.class,
        symbol = EntityNames.CarrierShipmentMethod)
public class CarrierShipmentMethod implements IEventModel<CarrierShipmentMethodData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_method_type_id")
	@RIndex 
    String shipmentMethodTypeId;
    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("role_type_id")
	@RIndex 
    String roleTypeId;
    @SerializedName("sequence_number") 
    Long sequenceNumber;
    @SerializedName("carrier_service_code") 
    String carrierServiceCode;
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

    public CarrierShipmentMethodData.Builder toDataBuilder() {
        CarrierShipmentMethodData.Builder builder = CarrierShipmentMethodData.newBuilder();
        if (getShipmentMethodTypeId() != null) {
            builder.setShipmentMethodTypeId(getShipmentMethodTypeId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getSequenceNumber() != null) {
            builder.setSequenceNumber(getSequenceNumber());
        }
        if (getCarrierServiceCode() != null) {
            builder.setCarrierServiceCode(getCarrierServiceCode());
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

    public static CarrierShipmentMethod fromData(CarrierShipmentMethodData data) {
        return fromPrototype(data).build();
    }

    public static CarrierShipmentMethod.CarrierShipmentMethodBuilder fromPrototype(CarrierShipmentMethodData data) {
        return CarrierShipmentMethod.builder()
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .sequenceNumber(data.getSequenceNumber())
                .carrierServiceCode(data.getCarrierServiceCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: shipmentMethodTypeId, partyId, roleTypeId

-- fields --
    
    String shipmentMethodTypeId
    String partyId
    String roleTypeId
    Long sequenceNumber
    String carrierServiceCode

-- relations --
    
    - ShipmentMethodType (one, autoRelation: false, keymaps: shipmentMethodTypeId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
    + FacilityCarrierShipment (many, autoRelation: true, keymaps: shipmentMethodTypeId, partyId, roleTypeId)
    + OrderItemShipGroup (many, autoRelation: true, keymaps: shipmentMethodTypeId, partyId -> carrierPartyId, roleTypeId -> carrierRoleTypeId)
    + ShipmentCostEstimate (many, autoRelation: true, keymaps: shipmentMethodTypeId, partyId -> carrierPartyId, roleTypeId -> carrierRoleTypeId)
    + ShipmentTimeEstimate (many, autoRelation: true, keymaps: shipmentMethodTypeId, partyId, roleTypeId)
    + ShoppingList (many, autoRelation: true, keymaps: shipmentMethodTypeId, partyId -> carrierPartyId, roleTypeId -> carrierRoleTypeId)
*/

