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

import com.bluecc.hubs.stub.ShipmentTimeEstimateData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentTimeEstimateData.class,
        symbol = EntityNames.ShipmentTimeEstimate)
public class ShipmentTimeEstimate implements IEventModel<ShipmentTimeEstimateData.Builder>, HasId, Serializable, WithPeriod {
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
    @SerializedName("geo_id_to")
	@RIndex 
    String geoIdTo;
    @SerializedName("geo_id_from")
	@RIndex 
    String geoIdFrom;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("lead_time") 
    java.math.BigDecimal leadTime;
    @SerializedName("lead_time_uom_id") 
    String leadTimeUomId;
    @SerializedName("sequence_number") 
    Long sequenceNumber;
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

    public ShipmentTimeEstimateData.Builder toDataBuilder() {
        ShipmentTimeEstimateData.Builder builder = ShipmentTimeEstimateData.newBuilder();
        if (getShipmentMethodTypeId() != null) {
            builder.setShipmentMethodTypeId(getShipmentMethodTypeId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getGeoIdTo() != null) {
            builder.setGeoIdTo(getGeoIdTo());
        }
        if (getGeoIdFrom() != null) {
            builder.setGeoIdFrom(getGeoIdFrom());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getLeadTime() != null) {
            builder.setLeadTime(getFixedPoint(getLeadTime()));
        }
        if (getLeadTimeUomId() != null) {
            builder.setLeadTimeUomId(getLeadTimeUomId());
        }
        if (getSequenceNumber() != null) {
            builder.setSequenceNumber(getSequenceNumber());
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

    public static ShipmentTimeEstimate fromData(ShipmentTimeEstimateData data) {
        return fromPrototype(data).build();
    }

    public static ShipmentTimeEstimate.ShipmentTimeEstimateBuilder fromPrototype(ShipmentTimeEstimateData data) {
        return ShipmentTimeEstimate.builder()
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .geoIdTo(data.getGeoIdTo())
                .geoIdFrom(data.getGeoIdFrom())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .leadTime(getBigDecimal(data.getLeadTime()))
                .leadTimeUomId(data.getLeadTimeUomId())
                .sequenceNumber(data.getSequenceNumber())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: shipmentMethodTypeId, partyId, roleTypeId, geoIdTo, geoIdFrom, fromDate

-- fields --
    
    String shipmentMethodTypeId
    String partyId
    String roleTypeId
    String geoIdTo
    String geoIdFrom
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.math.BigDecimal leadTime
    String leadTimeUomId
    Long sequenceNumber

-- relations --
    
    - CarrierShipmentMethod (one, autoRelation: false, keymaps: shipmentMethodTypeId, partyId, roleTypeId)
    - ToGeo (one, autoRelation: false, keymaps: geoIdTo -> geoId)
    - fromGeo (one, autoRelation: false, keymaps: geoIdFrom -> geoId)
    - Time unitUom (one, autoRelation: false, keymaps: leadTimeUomId -> uomId)
*/

