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

import com.bluecc.hubs.stub.CarrierShipmentBoxTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CarrierShipmentBoxTypeData.class,
        symbol = EntityNames.CarrierShipmentBoxType)
public class CarrierShipmentBoxType implements IEventModel<CarrierShipmentBoxTypeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentBoxTypeId;
    @RIndex String partyId;
    String packagingTypeCode;
    String oversizeCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CarrierShipmentBoxTypeData.Builder toDataBuilder() {
        CarrierShipmentBoxTypeData.Builder builder = CarrierShipmentBoxTypeData.newBuilder();
        if (shipmentBoxTypeId != null) {
            builder.setShipmentBoxTypeId(shipmentBoxTypeId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (packagingTypeCode != null) {
            builder.setPackagingTypeCode(packagingTypeCode);
        }
        if (oversizeCode != null) {
            builder.setOversizeCode(oversizeCode);
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

    public static CarrierShipmentBoxType fromData(CarrierShipmentBoxTypeData data) {
        return CarrierShipmentBoxType.builder()
                .shipmentBoxTypeId(data.getShipmentBoxTypeId())
                .partyId(data.getPartyId())
                .packagingTypeCode(data.getPackagingTypeCode())
                .oversizeCode(data.getOversizeCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: shipmentBoxTypeId, partyId

-- fields --
    
    String shipmentBoxTypeId
    String partyId
    String packagingTypeCode
    String oversizeCode

-- relations --
    
    - ShipmentBoxType (one, autoRelation: false, keymaps: shipmentBoxTypeId)
    - Party (one, autoRelation: false, keymaps: partyId)
*/

