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

import com.bluecc.hubs.stub.CarrierShipmentBoxTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CarrierShipmentBoxTypeData.class,
        symbol = EntityNames.CarrierShipmentBoxType)
public class CarrierShipmentBoxType implements IEventModel<CarrierShipmentBoxTypeData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_box_type_id")
	@RIndex 
    String shipmentBoxTypeId;
    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("packaging_type_code") 
    String packagingTypeCode;
    @SerializedName("oversize_code") 
    String oversizeCode;
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

    public CarrierShipmentBoxTypeData.Builder toDataBuilder() {
        CarrierShipmentBoxTypeData.Builder builder = CarrierShipmentBoxTypeData.newBuilder();
        if (getShipmentBoxTypeId() != null) {
            builder.setShipmentBoxTypeId(getShipmentBoxTypeId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getPackagingTypeCode() != null) {
            builder.setPackagingTypeCode(getPackagingTypeCode());
        }
        if (getOversizeCode() != null) {
            builder.setOversizeCode(getOversizeCode());
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

    public static CarrierShipmentBoxType fromData(CarrierShipmentBoxTypeData data) {
        return fromPrototype(data).build();
    }

    public static CarrierShipmentBoxType.CarrierShipmentBoxTypeBuilder fromPrototype(CarrierShipmentBoxTypeData data) {
        return CarrierShipmentBoxType.builder()
                .shipmentBoxTypeId(data.getShipmentBoxTypeId())
                .partyId(data.getPartyId())
                .packagingTypeCode(data.getPackagingTypeCode())
                .oversizeCode(data.getOversizeCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
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

