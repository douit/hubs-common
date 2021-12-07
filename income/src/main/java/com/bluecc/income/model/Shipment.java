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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.ShipmentFlatData;

import com.bluecc.hubs.stub.ShipmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class Shipment implements IEventModel<ShipmentFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentId;
    String shipmentTypeId;
    String statusId;
    String primaryOrderId;
    String primaryReturnId;
    String primaryShipGroupSeqId;
    String picklistBinId;
    java.time.LocalDateTime estimatedReadyDate;
    java.time.LocalDateTime estimatedShipDate;
    String estimatedShipWorkEffId;
    java.time.LocalDateTime estimatedArrivalDate;
    String estimatedArrivalWorkEffId;
    java.time.LocalDateTime latestCancelDate;
    java.math.BigDecimal estimatedShipCost;
    String currencyUomId;
    String handlingInstructions;
    String originFacilityId;
    String destinationFacilityId;
    String originContactMechId;
    String originTelecomNumberId;
    String destinationContactMechId;
    String destinationTelecomNumberId;
    String partyIdTo;
    String partyIdFrom;
    java.math.BigDecimal additionalShippingCharge;
    String addtlShippingChargeDesc;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentFlatData.Builder toDataBuilder() {
        ShipmentFlatData.Builder builder = ShipmentFlatData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentTypeId != null) {
            builder.setShipmentTypeId(shipmentTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (primaryOrderId != null) {
            builder.setPrimaryOrderId(primaryOrderId);
        }
        if (primaryReturnId != null) {
            builder.setPrimaryReturnId(primaryReturnId);
        }
        if (primaryShipGroupSeqId != null) {
            builder.setPrimaryShipGroupSeqId(primaryShipGroupSeqId);
        }
        if (picklistBinId != null) {
            builder.setPicklistBinId(picklistBinId);
        }
        if (estimatedReadyDate != null) {
            builder.setEstimatedReadyDate(getTimestamp(estimatedReadyDate));
        }
        if (estimatedShipDate != null) {
            builder.setEstimatedShipDate(getTimestamp(estimatedShipDate));
        }
        if (estimatedShipWorkEffId != null) {
            builder.setEstimatedShipWorkEffId(estimatedShipWorkEffId);
        }
        if (estimatedArrivalDate != null) {
            builder.setEstimatedArrivalDate(getTimestamp(estimatedArrivalDate));
        }
        if (estimatedArrivalWorkEffId != null) {
            builder.setEstimatedArrivalWorkEffId(estimatedArrivalWorkEffId);
        }
        if (latestCancelDate != null) {
            builder.setLatestCancelDate(getTimestamp(latestCancelDate));
        }
        if (estimatedShipCost != null) {
            builder.setEstimatedShipCost(getCurrency(estimatedShipCost));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (handlingInstructions != null) {
            builder.setHandlingInstructions(handlingInstructions);
        }
        if (originFacilityId != null) {
            builder.setOriginFacilityId(originFacilityId);
        }
        if (destinationFacilityId != null) {
            builder.setDestinationFacilityId(destinationFacilityId);
        }
        if (originContactMechId != null) {
            builder.setOriginContactMechId(originContactMechId);
        }
        if (originTelecomNumberId != null) {
            builder.setOriginTelecomNumberId(originTelecomNumberId);
        }
        if (destinationContactMechId != null) {
            builder.setDestinationContactMechId(destinationContactMechId);
        }
        if (destinationTelecomNumberId != null) {
            builder.setDestinationTelecomNumberId(destinationTelecomNumberId);
        }
        if (partyIdTo != null) {
            builder.setPartyIdTo(partyIdTo);
        }
        if (partyIdFrom != null) {
            builder.setPartyIdFrom(partyIdFrom);
        }
        if (additionalShippingCharge != null) {
            builder.setAdditionalShippingCharge(getCurrency(additionalShippingCharge));
        }
        if (addtlShippingChargeDesc != null) {
            builder.setAddtlShippingChargeDesc(addtlShippingChargeDesc);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Shipment fromData(ShipmentFlatData data) {
        return Shipment.builder()
                .shipmentId(data.getShipmentId())
                .shipmentTypeId(data.getShipmentTypeId())
                .statusId(data.getStatusId())
                .primaryOrderId(data.getPrimaryOrderId())
                .primaryReturnId(data.getPrimaryReturnId())
                .primaryShipGroupSeqId(data.getPrimaryShipGroupSeqId())
                .picklistBinId(data.getPicklistBinId())
                .estimatedReadyDate(getLocalDateTime(data.getEstimatedReadyDate()))
                .estimatedShipDate(getLocalDateTime(data.getEstimatedShipDate()))
                .estimatedShipWorkEffId(data.getEstimatedShipWorkEffId())
                .estimatedArrivalDate(getLocalDateTime(data.getEstimatedArrivalDate()))
                .estimatedArrivalWorkEffId(data.getEstimatedArrivalWorkEffId())
                .latestCancelDate(getLocalDateTime(data.getLatestCancelDate()))
                .estimatedShipCost(getBigDecimal(data.getEstimatedShipCost()))
                .currencyUomId(data.getCurrencyUomId())
                .handlingInstructions(data.getHandlingInstructions())
                .originFacilityId(data.getOriginFacilityId())
                .destinationFacilityId(data.getDestinationFacilityId())
                .originContactMechId(data.getOriginContactMechId())
                .originTelecomNumberId(data.getOriginTelecomNumberId())
                .destinationContactMechId(data.getDestinationContactMechId())
                .destinationTelecomNumberId(data.getDestinationTelecomNumberId())
                .partyIdTo(data.getPartyIdTo())
                .partyIdFrom(data.getPartyIdFrom())
                .additionalShippingCharge(getBigDecimal(data.getAdditionalShippingCharge()))
                .addtlShippingChargeDesc(data.getAddtlShippingChargeDesc())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

        
    public ShipmentData.Builder toHeadBuilder() {
        ShipmentData.Builder builder = ShipmentData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentTypeId != null) {
            builder.setShipmentTypeId(shipmentTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (primaryReturnId != null) {
            builder.setPrimaryReturnId(primaryReturnId);
        }
        if (primaryShipGroupSeqId != null) {
            builder.setPrimaryShipGroupSeqId(primaryShipGroupSeqId);
        }
        if (picklistBinId != null) {
            builder.setPicklistBinId(picklistBinId);
        }
        if (estimatedReadyDate != null) {
            builder.setEstimatedReadyDate(getTimestamp(estimatedReadyDate));
        }
        if (estimatedShipDate != null) {
            builder.setEstimatedShipDate(getTimestamp(estimatedShipDate));
        }
        if (estimatedArrivalDate != null) {
            builder.setEstimatedArrivalDate(getTimestamp(estimatedArrivalDate));
        }
        if (latestCancelDate != null) {
            builder.setLatestCancelDate(getTimestamp(latestCancelDate));
        }
        if (estimatedShipCost != null) {
            builder.setEstimatedShipCost(getCurrency(estimatedShipCost));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (handlingInstructions != null) {
            builder.setHandlingInstructions(handlingInstructions);
        }
        if (originFacilityId != null) {
            builder.setOriginFacilityId(originFacilityId);
        }
        if (destinationFacilityId != null) {
            builder.setDestinationFacilityId(destinationFacilityId);
        }
        if (additionalShippingCharge != null) {
            builder.setAdditionalShippingCharge(getCurrency(additionalShippingCharge));
        }
        if (addtlShippingChargeDesc != null) {
            builder.setAddtlShippingChargeDesc(addtlShippingChargeDesc);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}
