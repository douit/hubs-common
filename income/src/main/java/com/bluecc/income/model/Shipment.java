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

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ShipmentFlatData;

import com.bluecc.hubs.stub.ShipmentData;
import com.bluecc.income.dao.ShipmentDelegator;
import com.bluecc.income.exchange.IProc;


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
     
    @Exclude
    List<WorkEffort> relEstimatedShipWorkEffort= new ArrayList<>(); 
    @Exclude
    List<WorkEffort> relEstimatedArrivalWorkEffort= new ArrayList<>(); 
    @Exclude
    List<Facility> relOriginFacility= new ArrayList<>(); 
    @Exclude
    List<Facility> relDestinationFacility= new ArrayList<>(); 
    @Exclude
    List<ContactMech> relOriginContactMech= new ArrayList<>(); 
    @Exclude
    List<ContactMech> relDestContactMech= new ArrayList<>(); 
    @Exclude
    List<PostalAddress> relOriginPostalAddress= new ArrayList<>(); 
    @Exclude
    List<TelecomNumber> relOriginTelecomNumber= new ArrayList<>(); 
    @Exclude
    List<PostalAddress> relDestinationPostalAddress= new ArrayList<>(); 
    @Exclude
    List<TelecomNumber> relDestinationTelecomNumber= new ArrayList<>(); 
    @Exclude
    List<OrderHeader> relPrimaryOrderHeader= new ArrayList<>(); 
    @Exclude
    List<OrderItemShipGroup> relPrimaryOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    List<Party> relToParty= new ArrayList<>(); 
    @Exclude
    List<Person> relToPerson= new ArrayList<>(); 
    @Exclude
    List<PartyGroup> relToPartyGroup= new ArrayList<>(); 
    @Exclude
    List<Party> relFromParty= new ArrayList<>(); 
    @Exclude
    List<Person> relFromPerson= new ArrayList<>(); 
    @Exclude
    List<PartyGroup> relFromPartyGroup= new ArrayList<>(); 
    @Exclude
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    List<ItemIssuance> relItemIssuance= new ArrayList<>(); 
    @Exclude
    List<ShipmentItem> relShipmentItem= new ArrayList<>(); 
    @Exclude
    List<ShipmentItemBilling> relShipmentItemBilling= new ArrayList<>(); 
    @Exclude
    List<ShipmentPackage> relShipmentPackage= new ArrayList<>(); 
    @Exclude
    List<ShipmentPackageContent> relShipmentPackageContent= new ArrayList<>(); 
    @Exclude
    List<ShipmentPackageRouteSeg> relShipmentPackageRouteSeg= new ArrayList<>(); 
    @Exclude
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    List<ShipmentRouteSegment> relShipmentRouteSegment= new ArrayList<>(); 
    @Exclude
    List<ShipmentStatus> relShipmentStatus= new ArrayList<>();

    public ShipmentDelegator.Agent agent(IProc.ProcContext ctx,
                                             ShipmentDelegator delegator){
        return delegator.getAgent(ctx, this.getShipmentId());
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


/*
-- keys: shipmentId

-- fields --
    
    String shipmentId
    String shipmentTypeId
    String statusId
    String primaryOrderId
    String primaryReturnId
    String primaryShipGroupSeqId
    String picklistBinId
    java.time.LocalDateTime estimatedReadyDate
    java.time.LocalDateTime estimatedShipDate
    String estimatedShipWorkEffId
    java.time.LocalDateTime estimatedArrivalDate
    String estimatedArrivalWorkEffId
    java.time.LocalDateTime latestCancelDate
    java.math.BigDecimal estimatedShipCost
    String currencyUomId
    String handlingInstructions
    String originFacilityId
    String destinationFacilityId
    String originContactMechId
    String originTelecomNumberId
    String destinationContactMechId
    String destinationTelecomNumberId
    String partyIdTo
    String partyIdFrom
    java.math.BigDecimal additionalShippingCharge
    String addtlShippingChargeDesc
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - ShipmentType (one, autoRelation: false, keymaps: shipmentTypeId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - EstimatedShipWorkEffort (one, autoRelation: false, keymaps: estimatedShipWorkEffId -> workEffortId)
    - EstimatedArrivalWorkEffort (one, autoRelation: false, keymaps: estimatedArrivalWorkEffId -> workEffortId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - OriginFacility (one, autoRelation: false, keymaps: originFacilityId -> facilityId)
    - DestinationFacility (one, autoRelation: false, keymaps: destinationFacilityId -> facilityId)
    - OriginContactMech (one-nofk, autoRelation: false, keymaps: originContactMechId -> contactMechId)
    - DestContactMech (one-nofk, autoRelation: false, keymaps: destinationContactMechId -> contactMechId)
    - OriginPostalAddress (one, autoRelation: false, keymaps: originContactMechId -> contactMechId)
    - OriginTelecomNumber (one, autoRelation: false, keymaps: originTelecomNumberId -> contactMechId)
    - DestinationPostalAddress (one, autoRelation: false, keymaps: destinationContactMechId -> contactMechId)
    - DestinationTelecomNumber (one, autoRelation: false, keymaps: destinationTelecomNumberId -> contactMechId)
    - PrimaryOrderHeader (one, autoRelation: false, keymaps: primaryOrderId -> orderId)
    - PrimaryReturnHeader (one, autoRelation: false, keymaps: primaryReturnId -> returnId)
    - PicklistBin (one, autoRelation: false, keymaps: picklistBinId)
    - PrimaryOrderItemShipGroup (one-nofk, autoRelation: false, keymaps: primaryOrderId -> orderId, primaryShipGroupSeqId -> shipGroupSeqId)
    + ShipmentTypeAttr (many, autoRelation: false, keymaps: shipmentTypeId)
    - ToParty (one, autoRelation: false, keymaps: partyIdTo -> partyId)
    - ToPerson (one-nofk, autoRelation: false, keymaps: partyIdTo -> partyId)
    - ToPartyGroup (one-nofk, autoRelation: false, keymaps: partyIdTo -> partyId)
    - FromParty (one, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - FromPerson (one-nofk, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - FromPartyGroup (one-nofk, autoRelation: false, keymaps: partyIdFrom -> partyId)
    + ShipmentManifestView (many, autoRelation: false, keymaps: shipmentId)
    + AcctgTrans (many, autoRelation: true, keymaps: shipmentId)
    + ItemIssuance (many, autoRelation: true, keymaps: shipmentId)
    + OrderShipment (many, autoRelation: true, keymaps: shipmentId)
    + ReturnItemShipment (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentAttribute (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentContactMech (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentItem (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentItemBilling (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentItemFeature (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentPackage (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentPackageContent (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentPackageRouteSeg (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentRouteSegment (many, autoRelation: true, keymaps: shipmentId)
    + ShipmentStatus (many, autoRelation: true, keymaps: shipmentId)
*/

