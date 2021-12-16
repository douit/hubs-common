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
public class CarrierShipmentMethod implements IEventModel<CarrierShipmentMethodData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentMethodTypeId;
    @RIndex String partyId;
    @RIndex String roleTypeId;
    Long sequenceNumber;
    String carrierServiceCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CarrierShipmentMethodData.Builder toDataBuilder() {
        CarrierShipmentMethodData.Builder builder = CarrierShipmentMethodData.newBuilder();
        if (shipmentMethodTypeId != null) {
            builder.setShipmentMethodTypeId(shipmentMethodTypeId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (sequenceNumber != null) {
            builder.setSequenceNumber(sequenceNumber);
        }
        if (carrierServiceCode != null) {
            builder.setCarrierServiceCode(carrierServiceCode);
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

    public static CarrierShipmentMethod fromData(CarrierShipmentMethodData data) {
        return CarrierShipmentMethod.builder()
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .sequenceNumber(data.getSequenceNumber())
                .carrierServiceCode(data.getCarrierServiceCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
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

