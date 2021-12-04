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
import com.bluecc.hubs.stub.CarrierShipmentMethodData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarrierShipmentMethod implements IEventModel<CarrierShipmentMethodData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String shipmentMethodTypeId;
    String partyId;
    String roleTypeId;
    Long sequenceNumber;
    String carrierServiceCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
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