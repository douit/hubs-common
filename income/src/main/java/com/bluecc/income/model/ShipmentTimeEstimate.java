package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ShipmentTimeEstimateData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentTimeEstimate implements IEventModel<ShipmentTimeEstimateData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String shipmentMethodTypeId;
    String partyId;
    String roleTypeId;
    String geoIdTo;
    String geoIdFrom;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.math.BigDecimal leadTime;
    String leadTimeUomId;
    Long sequenceNumber;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentTimeEstimateData.Builder toDataBuilder() {
        ShipmentTimeEstimateData.Builder builder = ShipmentTimeEstimateData.newBuilder();
        if (shipmentMethodTypeId != null) {
            builder.setShipmentMethodTypeId(shipmentMethodTypeId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (geoIdTo != null) {
            builder.setGeoIdTo(geoIdTo);
        }
        if (geoIdFrom != null) {
            builder.setGeoIdFrom(geoIdFrom);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (leadTime != null) {
            builder.setLeadTime(getFixedPoint(leadTime));
        }
        if (leadTimeUomId != null) {
            builder.setLeadTimeUomId(leadTimeUomId);
        }
        if (sequenceNumber != null) {
            builder.setSequenceNumber(sequenceNumber);
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

    public static ShipmentTimeEstimate fromData(ShipmentTimeEstimateData data) {
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
                
                .build();
    }

    
}