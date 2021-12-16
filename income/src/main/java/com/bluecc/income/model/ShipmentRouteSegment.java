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

import com.bluecc.hubs.stub.ShipmentRouteSegmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentRouteSegmentData.class,
        symbol = EntityNames.ShipmentRouteSegment)
public class ShipmentRouteSegment implements IEventModel<ShipmentRouteSegmentData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String shipmentId;
    @RIndex String shipmentRouteSegmentId;
    String deliveryId;
    String originFacilityId;
    String destFacilityId;
    String originContactMechId;
    String originTelecomNumberId;
    String destContactMechId;
    String destTelecomNumberId;
    String carrierPartyId;
    String shipmentMethodTypeId;
    String carrierServiceStatusId;
    String carrierDeliveryZone;
    String carrierRestrictionCodes;
    String carrierRestrictionDesc;
    java.math.BigDecimal billingWeight;
    String billingWeightUomId;
    java.math.BigDecimal actualTransportCost;
    java.math.BigDecimal actualServiceCost;
    java.math.BigDecimal actualOtherCost;
    java.math.BigDecimal actualCost;
    String currencyUomId;
    java.time.LocalDateTime actualStartDate;
    java.time.LocalDateTime actualArrivalDate;
    java.time.LocalDateTime estimatedStartDate;
    java.time.LocalDateTime estimatedArrivalDate;
    String trackingIdNumber;
    String trackingDigest;
    String updatedByUserLoginId;
    java.time.LocalDateTime lastUpdatedDate;
    String homeDeliveryType;
    java.time.LocalDateTime homeDeliveryDate;
    String thirdPartyAccountNumber;
    String thirdPartyPostalCode;
    String thirdPartyCountryGeoCode;
    byte[] upsHighValueReport;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ShipmentRouteSegmentData.Builder toDataBuilder() {
        ShipmentRouteSegmentData.Builder builder = ShipmentRouteSegmentData.newBuilder();
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (shipmentRouteSegmentId != null) {
            builder.setShipmentRouteSegmentId(shipmentRouteSegmentId);
        }
        if (deliveryId != null) {
            builder.setDeliveryId(deliveryId);
        }
        if (originFacilityId != null) {
            builder.setOriginFacilityId(originFacilityId);
        }
        if (destFacilityId != null) {
            builder.setDestFacilityId(destFacilityId);
        }
        if (originContactMechId != null) {
            builder.setOriginContactMechId(originContactMechId);
        }
        if (originTelecomNumberId != null) {
            builder.setOriginTelecomNumberId(originTelecomNumberId);
        }
        if (destContactMechId != null) {
            builder.setDestContactMechId(destContactMechId);
        }
        if (destTelecomNumberId != null) {
            builder.setDestTelecomNumberId(destTelecomNumberId);
        }
        if (carrierPartyId != null) {
            builder.setCarrierPartyId(carrierPartyId);
        }
        if (shipmentMethodTypeId != null) {
            builder.setShipmentMethodTypeId(shipmentMethodTypeId);
        }
        if (carrierServiceStatusId != null) {
            builder.setCarrierServiceStatusId(carrierServiceStatusId);
        }
        if (carrierDeliveryZone != null) {
            builder.setCarrierDeliveryZone(carrierDeliveryZone);
        }
        if (carrierRestrictionCodes != null) {
            builder.setCarrierRestrictionCodes(carrierRestrictionCodes);
        }
        if (carrierRestrictionDesc != null) {
            builder.setCarrierRestrictionDesc(carrierRestrictionDesc);
        }
        if (billingWeight != null) {
            builder.setBillingWeight(getFixedPoint(billingWeight));
        }
        if (billingWeightUomId != null) {
            builder.setBillingWeightUomId(billingWeightUomId);
        }
        if (actualTransportCost != null) {
            builder.setActualTransportCost(getCurrency(actualTransportCost));
        }
        if (actualServiceCost != null) {
            builder.setActualServiceCost(getCurrency(actualServiceCost));
        }
        if (actualOtherCost != null) {
            builder.setActualOtherCost(getCurrency(actualOtherCost));
        }
        if (actualCost != null) {
            builder.setActualCost(getCurrency(actualCost));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (actualStartDate != null) {
            builder.setActualStartDate(getTimestamp(actualStartDate));
        }
        if (actualArrivalDate != null) {
            builder.setActualArrivalDate(getTimestamp(actualArrivalDate));
        }
        if (estimatedStartDate != null) {
            builder.setEstimatedStartDate(getTimestamp(estimatedStartDate));
        }
        if (estimatedArrivalDate != null) {
            builder.setEstimatedArrivalDate(getTimestamp(estimatedArrivalDate));
        }
        if (trackingIdNumber != null) {
            builder.setTrackingIdNumber(trackingIdNumber);
        }
        if (trackingDigest != null) {
            builder.setTrackingDigest(trackingDigest);
        }
        if (updatedByUserLoginId != null) {
            builder.setUpdatedByUserLoginId(updatedByUserLoginId);
        }
        if (lastUpdatedDate != null) {
            builder.setLastUpdatedDate(getTimestamp(lastUpdatedDate));
        }
        if (homeDeliveryType != null) {
            builder.setHomeDeliveryType(homeDeliveryType);
        }
        if (homeDeliveryDate != null) {
            builder.setHomeDeliveryDate(getTimestamp(homeDeliveryDate));
        }
        if (thirdPartyAccountNumber != null) {
            builder.setThirdPartyAccountNumber(thirdPartyAccountNumber);
        }
        if (thirdPartyPostalCode != null) {
            builder.setThirdPartyPostalCode(thirdPartyPostalCode);
        }
        if (thirdPartyCountryGeoCode != null) {
            builder.setThirdPartyCountryGeoCode(thirdPartyCountryGeoCode);
        }
        if (upsHighValueReport != null) {
            builder.setUpsHighValueReport(ByteString.copyFrom(upsHighValueReport));
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

    public static ShipmentRouteSegment fromData(ShipmentRouteSegmentData data) {
        return ShipmentRouteSegment.builder()
                .shipmentId(data.getShipmentId())
                .shipmentRouteSegmentId(data.getShipmentRouteSegmentId())
                .deliveryId(data.getDeliveryId())
                .originFacilityId(data.getOriginFacilityId())
                .destFacilityId(data.getDestFacilityId())
                .originContactMechId(data.getOriginContactMechId())
                .originTelecomNumberId(data.getOriginTelecomNumberId())
                .destContactMechId(data.getDestContactMechId())
                .destTelecomNumberId(data.getDestTelecomNumberId())
                .carrierPartyId(data.getCarrierPartyId())
                .shipmentMethodTypeId(data.getShipmentMethodTypeId())
                .carrierServiceStatusId(data.getCarrierServiceStatusId())
                .carrierDeliveryZone(data.getCarrierDeliveryZone())
                .carrierRestrictionCodes(data.getCarrierRestrictionCodes())
                .carrierRestrictionDesc(data.getCarrierRestrictionDesc())
                .billingWeight(getBigDecimal(data.getBillingWeight()))
                .billingWeightUomId(data.getBillingWeightUomId())
                .actualTransportCost(getBigDecimal(data.getActualTransportCost()))
                .actualServiceCost(getBigDecimal(data.getActualServiceCost()))
                .actualOtherCost(getBigDecimal(data.getActualOtherCost()))
                .actualCost(getBigDecimal(data.getActualCost()))
                .currencyUomId(data.getCurrencyUomId())
                .actualStartDate(getLocalDateTime(data.getActualStartDate()))
                .actualArrivalDate(getLocalDateTime(data.getActualArrivalDate()))
                .estimatedStartDate(getLocalDateTime(data.getEstimatedStartDate()))
                .estimatedArrivalDate(getLocalDateTime(data.getEstimatedArrivalDate()))
                .trackingIdNumber(data.getTrackingIdNumber())
                .trackingDigest(data.getTrackingDigest())
                .updatedByUserLoginId(data.getUpdatedByUserLoginId())
                .lastUpdatedDate(getLocalDateTime(data.getLastUpdatedDate()))
                .homeDeliveryType(data.getHomeDeliveryType())
                .homeDeliveryDate(getLocalDateTime(data.getHomeDeliveryDate()))
                .thirdPartyAccountNumber(data.getThirdPartyAccountNumber())
                .thirdPartyPostalCode(data.getThirdPartyPostalCode())
                .thirdPartyCountryGeoCode(data.getThirdPartyCountryGeoCode())
                .upsHighValueReport(data.getUpsHighValueReport().toByteArray())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: shipmentId, shipmentRouteSegmentId

-- fields --
    
    String shipmentId
    String shipmentRouteSegmentId
    String deliveryId
    String originFacilityId
    String destFacilityId
    String originContactMechId
    String originTelecomNumberId
    String destContactMechId
    String destTelecomNumberId
    String carrierPartyId
    String shipmentMethodTypeId
    String carrierServiceStatusId
    String carrierDeliveryZone
    String carrierRestrictionCodes
    String carrierRestrictionDesc
    java.math.BigDecimal billingWeight
    String billingWeightUomId
    java.math.BigDecimal actualTransportCost
    java.math.BigDecimal actualServiceCost
    java.math.BigDecimal actualOtherCost
    java.math.BigDecimal actualCost
    String currencyUomId
    java.time.LocalDateTime actualStartDate
    java.time.LocalDateTime actualArrivalDate
    java.time.LocalDateTime estimatedStartDate
    java.time.LocalDateTime estimatedArrivalDate
    String trackingIdNumber
    String trackingDigest
    String updatedByUserLoginId
    java.time.LocalDateTime lastUpdatedDate
    String homeDeliveryType
    java.time.LocalDateTime homeDeliveryDate
    String thirdPartyAccountNumber
    String thirdPartyPostalCode
    String thirdPartyCountryGeoCode
    byte[] upsHighValueReport

-- relations --
    
    - Shipment (one, autoRelation: false, keymaps: shipmentId)
    - Delivery (one, autoRelation: false, keymaps: deliveryId)
    - CarrierParty (one, autoRelation: false, keymaps: carrierPartyId -> partyId)
    - CarrierPerson (one-nofk, autoRelation: false, keymaps: carrierPartyId -> partyId)
    - CarrierPartyGroup (one-nofk, autoRelation: false, keymaps: carrierPartyId -> partyId)
    - ShipmentMethodType (one, autoRelation: false, keymaps: shipmentMethodTypeId)
    - OriginFacility (one, autoRelation: false, keymaps: originFacilityId -> facilityId)
    - DestFacility (one, autoRelation: false, keymaps: destFacilityId -> facilityId)
    - OriginContactMech (one-nofk, autoRelation: false, keymaps: originContactMechId -> contactMechId)
    - DestContactMech (one-nofk, autoRelation: false, keymaps: destContactMechId -> contactMechId)
    - OriginPostalAddress (one, autoRelation: false, keymaps: originContactMechId -> contactMechId)
    - OriginTelecomNumber (one, autoRelation: false, keymaps: originTelecomNumberId -> contactMechId)
    - DestPostalAddress (one, autoRelation: false, keymaps: destContactMechId -> contactMechId)
    - DestTelecomNumber (one, autoRelation: false, keymaps: destTelecomNumberId -> contactMechId)
    - CarrierServiceStatusItem (one, autoRelation: false, keymaps: carrierServiceStatusId -> statusId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - BillingWeightUom (one, autoRelation: false, keymaps: billingWeightUomId -> uomId)
    + ShipmentPackageRouteSeg (many, autoRelation: true, keymaps: shipmentId, shipmentRouteSegmentId)
*/

