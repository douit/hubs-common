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

import com.bluecc.hubs.stub.ShipmentRouteSegmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentRouteSegmentData.class,
        symbol = EntityNames.ShipmentRouteSegment)
public class ShipmentRouteSegment implements IEventModel<ShipmentRouteSegmentData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("shipment_id")
	@RIndex 
    String shipmentId;
    @SerializedName("shipment_route_segment_id")
	@RIndex 
    String shipmentRouteSegmentId;
    @SerializedName("delivery_id") 
    String deliveryId;
    @SerializedName("origin_facility_id") 
    String originFacilityId;
    @SerializedName("dest_facility_id") 
    String destFacilityId;
    @SerializedName("origin_contact_mech_id") 
    String originContactMechId;
    @SerializedName("origin_telecom_number_id") 
    String originTelecomNumberId;
    @SerializedName("dest_contact_mech_id") 
    String destContactMechId;
    @SerializedName("dest_telecom_number_id") 
    String destTelecomNumberId;
    @SerializedName("carrier_party_id") 
    String carrierPartyId;
    @SerializedName("shipment_method_type_id") 
    String shipmentMethodTypeId;
    @SerializedName("carrier_service_status_id") 
    String carrierServiceStatusId;
    @SerializedName("carrier_delivery_zone") 
    String carrierDeliveryZone;
    @SerializedName("carrier_restriction_codes") 
    String carrierRestrictionCodes;
    @SerializedName("carrier_restriction_desc") 
    String carrierRestrictionDesc;
    @SerializedName("billing_weight") 
    java.math.BigDecimal billingWeight;
    @SerializedName("billing_weight_uom_id") 
    String billingWeightUomId;
    @SerializedName("actual_transport_cost") 
    java.math.BigDecimal actualTransportCost;
    @SerializedName("actual_service_cost") 
    java.math.BigDecimal actualServiceCost;
    @SerializedName("actual_other_cost") 
    java.math.BigDecimal actualOtherCost;
    @SerializedName("actual_cost") 
    java.math.BigDecimal actualCost;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("actual_start_date") 
    java.time.LocalDateTime actualStartDate;
    @SerializedName("actual_arrival_date") 
    java.time.LocalDateTime actualArrivalDate;
    @SerializedName("estimated_start_date") 
    java.time.LocalDateTime estimatedStartDate;
    @SerializedName("estimated_arrival_date") 
    java.time.LocalDateTime estimatedArrivalDate;
    @SerializedName("tracking_id_number") 
    String trackingIdNumber;
    @SerializedName("tracking_digest") 
    String trackingDigest;
    @SerializedName("updated_by_user_login_id") 
    String updatedByUserLoginId;
    @SerializedName("last_updated_date") 
    java.time.LocalDateTime lastUpdatedDate;
    @SerializedName("home_delivery_type") 
    String homeDeliveryType;
    @SerializedName("home_delivery_date") 
    java.time.LocalDateTime homeDeliveryDate;
    @SerializedName("third_party_account_number") 
    String thirdPartyAccountNumber;
    @SerializedName("third_party_postal_code") 
    String thirdPartyPostalCode;
    @SerializedName("third_party_country_geo_code") 
    String thirdPartyCountryGeoCode;
    @SerializedName("ups_high_value_report") 
    byte[] upsHighValueReport;
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

    public ShipmentRouteSegmentData.Builder toDataBuilder() {
        ShipmentRouteSegmentData.Builder builder = ShipmentRouteSegmentData.newBuilder();
        if (getShipmentId() != null) {
            builder.setShipmentId(getShipmentId());
        }
        if (getShipmentRouteSegmentId() != null) {
            builder.setShipmentRouteSegmentId(getShipmentRouteSegmentId());
        }
        if (getDeliveryId() != null) {
            builder.setDeliveryId(getDeliveryId());
        }
        if (getOriginFacilityId() != null) {
            builder.setOriginFacilityId(getOriginFacilityId());
        }
        if (getDestFacilityId() != null) {
            builder.setDestFacilityId(getDestFacilityId());
        }
        if (getOriginContactMechId() != null) {
            builder.setOriginContactMechId(getOriginContactMechId());
        }
        if (getOriginTelecomNumberId() != null) {
            builder.setOriginTelecomNumberId(getOriginTelecomNumberId());
        }
        if (getDestContactMechId() != null) {
            builder.setDestContactMechId(getDestContactMechId());
        }
        if (getDestTelecomNumberId() != null) {
            builder.setDestTelecomNumberId(getDestTelecomNumberId());
        }
        if (getCarrierPartyId() != null) {
            builder.setCarrierPartyId(getCarrierPartyId());
        }
        if (getShipmentMethodTypeId() != null) {
            builder.setShipmentMethodTypeId(getShipmentMethodTypeId());
        }
        if (getCarrierServiceStatusId() != null) {
            builder.setCarrierServiceStatusId(getCarrierServiceStatusId());
        }
        if (getCarrierDeliveryZone() != null) {
            builder.setCarrierDeliveryZone(getCarrierDeliveryZone());
        }
        if (getCarrierRestrictionCodes() != null) {
            builder.setCarrierRestrictionCodes(getCarrierRestrictionCodes());
        }
        if (getCarrierRestrictionDesc() != null) {
            builder.setCarrierRestrictionDesc(getCarrierRestrictionDesc());
        }
        if (getBillingWeight() != null) {
            builder.setBillingWeight(getFixedPoint(getBillingWeight()));
        }
        if (getBillingWeightUomId() != null) {
            builder.setBillingWeightUomId(getBillingWeightUomId());
        }
        if (getActualTransportCost() != null) {
            builder.setActualTransportCost(getCurrency(getActualTransportCost()));
        }
        if (getActualServiceCost() != null) {
            builder.setActualServiceCost(getCurrency(getActualServiceCost()));
        }
        if (getActualOtherCost() != null) {
            builder.setActualOtherCost(getCurrency(getActualOtherCost()));
        }
        if (getActualCost() != null) {
            builder.setActualCost(getCurrency(getActualCost()));
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getActualStartDate() != null) {
            builder.setActualStartDate(getTimestamp(getActualStartDate()));
        }
        if (getActualArrivalDate() != null) {
            builder.setActualArrivalDate(getTimestamp(getActualArrivalDate()));
        }
        if (getEstimatedStartDate() != null) {
            builder.setEstimatedStartDate(getTimestamp(getEstimatedStartDate()));
        }
        if (getEstimatedArrivalDate() != null) {
            builder.setEstimatedArrivalDate(getTimestamp(getEstimatedArrivalDate()));
        }
        if (getTrackingIdNumber() != null) {
            builder.setTrackingIdNumber(getTrackingIdNumber());
        }
        if (getTrackingDigest() != null) {
            builder.setTrackingDigest(getTrackingDigest());
        }
        if (getUpdatedByUserLoginId() != null) {
            builder.setUpdatedByUserLoginId(getUpdatedByUserLoginId());
        }
        if (getLastUpdatedDate() != null) {
            builder.setLastUpdatedDate(getTimestamp(getLastUpdatedDate()));
        }
        if (getHomeDeliveryType() != null) {
            builder.setHomeDeliveryType(getHomeDeliveryType());
        }
        if (getHomeDeliveryDate() != null) {
            builder.setHomeDeliveryDate(getTimestamp(getHomeDeliveryDate()));
        }
        if (getThirdPartyAccountNumber() != null) {
            builder.setThirdPartyAccountNumber(getThirdPartyAccountNumber());
        }
        if (getThirdPartyPostalCode() != null) {
            builder.setThirdPartyPostalCode(getThirdPartyPostalCode());
        }
        if (getThirdPartyCountryGeoCode() != null) {
            builder.setThirdPartyCountryGeoCode(getThirdPartyCountryGeoCode());
        }
        if (getUpsHighValueReport() != null) {
            builder.setUpsHighValueReport(ByteString.copyFrom(getUpsHighValueReport()));
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

    public static ShipmentRouteSegment fromData(ShipmentRouteSegmentData data) {
        return fromPrototype(data).build();
    }

    public static ShipmentRouteSegment.ShipmentRouteSegmentBuilder fromPrototype(ShipmentRouteSegmentData data) {
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
                ;
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

