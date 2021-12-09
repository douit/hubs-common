package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.ShipmentFlatData;

import com.bluecc.hubs.stub.ShipmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentData.class,
        symbol = EntityNames.Shipment)
public class Shipment implements IEventModel<ShipmentFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String shipmentId;
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

        // relations
     
    List<WorkEffort> relEstimatedShipWorkEffort= new ArrayList<>(); 
    List<WorkEffort> relEstimatedArrivalWorkEffort= new ArrayList<>(); 
    List<ContactMech> relOriginContactMech= new ArrayList<>(); 
    List<ContactMech> relDestContactMech= new ArrayList<>(); 
    List<PostalAddress> relOriginPostalAddress= new ArrayList<>(); 
    List<TelecomNumber> relOriginTelecomNumber= new ArrayList<>(); 
    List<PostalAddress> relDestinationPostalAddress= new ArrayList<>(); 
    List<TelecomNumber> relDestinationTelecomNumber= new ArrayList<>(); 
    List<OrderHeader> relPrimaryOrderHeader= new ArrayList<>(); 
    List<OrderItemShipGroup> relPrimaryOrderItemShipGroup= new ArrayList<>(); 
    List<Party> relToParty= new ArrayList<>(); 
    List<Person> relToPerson= new ArrayList<>(); 
    List<PartyGroup> relToPartyGroup= new ArrayList<>(); 
    List<Party> relFromParty= new ArrayList<>(); 
    List<Person> relFromPerson= new ArrayList<>(); 
    List<PartyGroup> relFromPartyGroup= new ArrayList<>(); 
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    List<ItemIssuance> relItemIssuance= new ArrayList<>(); 
    List<ShipmentItem> relShipmentItem= new ArrayList<>(); 
    List<ShipmentItemBilling> relShipmentItemBilling= new ArrayList<>(); 
    List<ShipmentPackage> relShipmentPackage= new ArrayList<>(); 
    List<ShipmentPackageContent> relShipmentPackageContent= new ArrayList<>(); 
    List<ShipmentPackageRouteSeg> relShipmentPackageRouteSeg= new ArrayList<>(); 
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    List<ShipmentRouteSegment> relShipmentRouteSegment= new ArrayList<>(); 
    List<ShipmentStatus> relShipmentStatus= new ArrayList<>();

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
