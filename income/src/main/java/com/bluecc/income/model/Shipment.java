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

import com.bluecc.hubs.stub.ShipmentFlatData;

import com.bluecc.hubs.stub.ShipmentData;
import com.bluecc.income.dao.ShipmentDelegator;
import static com.bluecc.income.dao.ShipmentDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentData.class,
        symbol = EntityNames.Shipment)
public class Shipment implements IEventModel<ShipmentFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_id")
	@RId 
    String shipmentId;
    @SerializedName("shipment_type_id") 
    String shipmentTypeId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("primary_order_id") 
    String primaryOrderId;
    @SerializedName("primary_return_id") 
    String primaryReturnId;
    @SerializedName("primary_ship_group_seq_id") 
    String primaryShipGroupSeqId;
    @SerializedName("picklist_bin_id") 
    String picklistBinId;
    @SerializedName("estimated_ready_date") 
    java.time.LocalDateTime estimatedReadyDate;
    @SerializedName("estimated_ship_date") 
    java.time.LocalDateTime estimatedShipDate;
    @SerializedName("estimated_ship_work_eff_id") 
    String estimatedShipWorkEffId;
    @SerializedName("estimated_arrival_date") 
    java.time.LocalDateTime estimatedArrivalDate;
    @SerializedName("estimated_arrival_work_eff_id") 
    String estimatedArrivalWorkEffId;
    @SerializedName("latest_cancel_date") 
    java.time.LocalDateTime latestCancelDate;
    @SerializedName("estimated_ship_cost") 
    java.math.BigDecimal estimatedShipCost;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("handling_instructions") 
    String handlingInstructions;
    @SerializedName("origin_facility_id") 
    String originFacilityId;
    @SerializedName("destination_facility_id") 
    String destinationFacilityId;
    @SerializedName("origin_contact_mech_id") 
    String originContactMechId;
    @SerializedName("origin_telecom_number_id") 
    String originTelecomNumberId;
    @SerializedName("destination_contact_mech_id") 
    String destinationContactMechId;
    @SerializedName("destination_telecom_number_id") 
    String destinationTelecomNumberId;
    @SerializedName("party_id_to") 
    String partyIdTo;
    @SerializedName("party_id_from") 
    String partyIdFrom;
    @SerializedName("additional_shipping_charge") 
    java.math.BigDecimal additionalShippingCharge;
    @SerializedName("addtl_shipping_charge_desc") 
    String addtlShippingChargeDesc;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login") 
    String lastModifiedByUserLogin;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return shipmentId;
    }

        
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
        if (tenantId != null) {
            builder.setTenantId(tenantId);
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
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addEstimatedShipWorkEffort")
    List<WorkEffort> relEstimatedShipWorkEffort= new ArrayList<>(); 
    @Exclude
    @Singular("addEstimatedArrivalWorkEffort")
    List<WorkEffort> relEstimatedArrivalWorkEffort= new ArrayList<>(); 
    @Exclude
    @Singular("addOriginFacility")
    List<Facility> relOriginFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addDestinationFacility")
    List<Facility> relDestinationFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addOriginContactMech")
    List<ContactMech> relOriginContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addDestContactMech")
    List<ContactMech> relDestContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addOriginPostalAddress")
    List<PostalAddress> relOriginPostalAddress= new ArrayList<>(); 
    @Exclude
    @Singular("addOriginTelecomNumber")
    List<TelecomNumber> relOriginTelecomNumber= new ArrayList<>(); 
    @Exclude
    @Singular("addDestinationPostalAddress")
    List<PostalAddress> relDestinationPostalAddress= new ArrayList<>(); 
    @Exclude
    @Singular("addDestinationTelecomNumber")
    List<TelecomNumber> relDestinationTelecomNumber= new ArrayList<>(); 
    @Exclude
    @Singular("addPrimaryOrderHeader")
    List<OrderHeader> relPrimaryOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addPrimaryOrderItemShipGroup")
    List<OrderItemShipGroup> relPrimaryOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addToParty")
    List<Party> relToParty= new ArrayList<>(); 
    @Exclude
    @Singular("addToPerson")
    List<Person> relToPerson= new ArrayList<>(); 
    @Exclude
    @Singular("addToPartyGroup")
    List<PartyGroup> relToPartyGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addFromParty")
    List<Party> relFromParty= new ArrayList<>(); 
    @Exclude
    @Singular("addFromPerson")
    List<Person> relFromPerson= new ArrayList<>(); 
    @Exclude
    @Singular("addFromPartyGroup")
    List<PartyGroup> relFromPartyGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addItemIssuance")
    List<ItemIssuance> relItemIssuance= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentItem")
    List<ShipmentItem> relShipmentItem= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentItemBilling")
    List<ShipmentItemBilling> relShipmentItemBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentPackage")
    List<ShipmentPackage> relShipmentPackage= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentPackageContent")
    List<ShipmentPackageContent> relShipmentPackageContent= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentPackageRouteSeg")
    List<ShipmentPackageRouteSeg> relShipmentPackageRouteSeg= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentRouteSegment")
    List<ShipmentRouteSegment> relShipmentRouteSegment= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentStatus")
    List<ShipmentStatus> relShipmentStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(ESTIMATED_SHIP_WORK_EFFORT, getter(this, Shipment::getRelEstimatedShipWorkEffort)); 
        supplierMap.put(ESTIMATED_ARRIVAL_WORK_EFFORT, getter(this, Shipment::getRelEstimatedArrivalWorkEffort)); 
        supplierMap.put(ORIGIN_FACILITY, getter(this, Shipment::getRelOriginFacility)); 
        supplierMap.put(DESTINATION_FACILITY, getter(this, Shipment::getRelDestinationFacility)); 
        supplierMap.put(ORIGIN_CONTACT_MECH, getter(this, Shipment::getRelOriginContactMech)); 
        supplierMap.put(DEST_CONTACT_MECH, getter(this, Shipment::getRelDestContactMech)); 
        supplierMap.put(ORIGIN_POSTAL_ADDRESS, getter(this, Shipment::getRelOriginPostalAddress)); 
        supplierMap.put(ORIGIN_TELECOM_NUMBER, getter(this, Shipment::getRelOriginTelecomNumber)); 
        supplierMap.put(DESTINATION_POSTAL_ADDRESS, getter(this, Shipment::getRelDestinationPostalAddress)); 
        supplierMap.put(DESTINATION_TELECOM_NUMBER, getter(this, Shipment::getRelDestinationTelecomNumber)); 
        supplierMap.put(PRIMARY_ORDER_HEADER, getter(this, Shipment::getRelPrimaryOrderHeader)); 
        supplierMap.put(PRIMARY_ORDER_ITEM_SHIP_GROUP, getter(this, Shipment::getRelPrimaryOrderItemShipGroup)); 
        supplierMap.put(TO_PARTY, getter(this, Shipment::getRelToParty)); 
        supplierMap.put(TO_PERSON, getter(this, Shipment::getRelToPerson)); 
        supplierMap.put(TO_PARTY_GROUP, getter(this, Shipment::getRelToPartyGroup)); 
        supplierMap.put(FROM_PARTY, getter(this, Shipment::getRelFromParty)); 
        supplierMap.put(FROM_PERSON, getter(this, Shipment::getRelFromPerson)); 
        supplierMap.put(FROM_PARTY_GROUP, getter(this, Shipment::getRelFromPartyGroup)); 
        supplierMap.put(ACCTG_TRANS, getter(this, Shipment::getRelAcctgTrans)); 
        supplierMap.put(ITEM_ISSUANCE, getter(this, Shipment::getRelItemIssuance)); 
        supplierMap.put(SHIPMENT_ITEM, getter(this, Shipment::getRelShipmentItem)); 
        supplierMap.put(SHIPMENT_ITEM_BILLING, getter(this, Shipment::getRelShipmentItemBilling)); 
        supplierMap.put(SHIPMENT_PACKAGE, getter(this, Shipment::getRelShipmentPackage)); 
        supplierMap.put(SHIPMENT_PACKAGE_CONTENT, getter(this, Shipment::getRelShipmentPackageContent)); 
        supplierMap.put(SHIPMENT_PACKAGE_ROUTE_SEG, getter(this, Shipment::getRelShipmentPackageRouteSeg)); 
        supplierMap.put(SHIPMENT_RECEIPT, getter(this, Shipment::getRelShipmentReceipt)); 
        supplierMap.put(SHIPMENT_ROUTE_SEGMENT, getter(this, Shipment::getRelShipmentRouteSegment)); 
        supplierMap.put(SHIPMENT_STATUS, getter(this, Shipment::getRelShipmentStatus)); 
        supplierMap.put(TENANT, getter(this, Shipment::getRelTenant));

        return supplierMap;
    };

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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

