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

import com.bluecc.hubs.stub.PostalAddressData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PostalAddressData.class,
        symbol = EntityNames.PostalAddress)
public class PostalAddress implements IEventModel<PostalAddressData.Builder>, HasId, Serializable, WithLocation {
    private static final long serialVersionUID = 1L;

    @SerializedName("contact_mech_id")
	@RId 
    String contactMechId;
    @SerializedName("to_name") 
    String toName;
    @SerializedName("attn_name") 
    String attnName;
    @SerializedName("address1") 
    String address1;
    @SerializedName("address2") 
    String address2;
    @SerializedName("house_number") 
    Long houseNumber;
    @SerializedName("house_number_ext") 
    String houseNumberExt;
    @SerializedName("directions") 
    String directions;
    @SerializedName("city") 
    String city;
    @SerializedName("city_geo_id") 
    String cityGeoId;
    @SerializedName("postal_code") 
    String postalCode;
    @SerializedName("postal_code_ext") 
    String postalCodeExt;
    @SerializedName("country_geo_id") 
    String countryGeoId;
    @SerializedName("state_province_geo_id") 
    String stateProvinceGeoId;
    @SerializedName("county_geo_id") 
    String countyGeoId;
    @SerializedName("municipality_geo_id") 
    String municipalityGeoId;
    @SerializedName("postal_code_geo_id") 
    String postalCodeGeoId;
    @SerializedName("geo_point_id") 
    String geoPointId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return contactMechId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PostalAddressData.Builder toDataBuilder() {
        PostalAddressData.Builder builder = PostalAddressData.newBuilder();
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getToName() != null) {
            builder.setToName(getToName());
        }
        if (getAttnName() != null) {
            builder.setAttnName(getAttnName());
        }
        if (getAddress1() != null) {
            builder.setAddress1(getAddress1());
        }
        if (getAddress2() != null) {
            builder.setAddress2(getAddress2());
        }
        if (getHouseNumber() != null) {
            builder.setHouseNumber(getHouseNumber());
        }
        if (getHouseNumberExt() != null) {
            builder.setHouseNumberExt(getHouseNumberExt());
        }
        if (getDirections() != null) {
            builder.setDirections(getDirections());
        }
        if (getCity() != null) {
            builder.setCity(getCity());
        }
        if (getCityGeoId() != null) {
            builder.setCityGeoId(getCityGeoId());
        }
        if (getPostalCode() != null) {
            builder.setPostalCode(getPostalCode());
        }
        if (getPostalCodeExt() != null) {
            builder.setPostalCodeExt(getPostalCodeExt());
        }
        if (getCountryGeoId() != null) {
            builder.setCountryGeoId(getCountryGeoId());
        }
        if (getStateProvinceGeoId() != null) {
            builder.setStateProvinceGeoId(getStateProvinceGeoId());
        }
        if (getCountyGeoId() != null) {
            builder.setCountyGeoId(getCountyGeoId());
        }
        if (getMunicipalityGeoId() != null) {
            builder.setMunicipalityGeoId(getMunicipalityGeoId());
        }
        if (getPostalCodeGeoId() != null) {
            builder.setPostalCodeGeoId(getPostalCodeGeoId());
        }
        if (getGeoPointId() != null) {
            builder.setGeoPointId(getGeoPointId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static PostalAddress fromData(PostalAddressData data) {
        return fromPrototype(data).build();
    }

    public static PostalAddress.PostalAddressBuilder fromPrototype(PostalAddressData data) {
        return PostalAddress.builder()
                .contactMechId(data.getContactMechId())
                .toName(data.getToName())
                .attnName(data.getAttnName())
                .address1(data.getAddress1())
                .address2(data.getAddress2())
                .houseNumber(data.getHouseNumber())
                .houseNumberExt(data.getHouseNumberExt())
                .directions(data.getDirections())
                .city(data.getCity())
                .cityGeoId(data.getCityGeoId())
                .postalCode(data.getPostalCode())
                .postalCodeExt(data.getPostalCodeExt())
                .countryGeoId(data.getCountryGeoId())
                .stateProvinceGeoId(data.getStateProvinceGeoId())
                .countyGeoId(data.getCountyGeoId())
                .municipalityGeoId(data.getMunicipalityGeoId())
                .postalCodeGeoId(data.getPostalCodeGeoId())
                .geoPointId(data.getGeoPointId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: contactMechId

-- fields --
    
    String contactMechId
    String toName
    String attnName
    String address1
    String address2
    Long houseNumber
    String houseNumberExt
    String directions
    String city
    String cityGeoId
    String postalCode
    String postalCodeExt
    String countryGeoId
    String stateProvinceGeoId
    String countyGeoId
    String municipalityGeoId
    String postalCodeGeoId
    String geoPointId

-- relations --
    
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - CountryGeo (one, autoRelation: false, keymaps: countryGeoId -> geoId)
    - StateProvinceGeo (one, autoRelation: false, keymaps: stateProvinceGeoId -> geoId)
    - CountyGeo (one, autoRelation: false, keymaps: countyGeoId -> geoId)
    - MunicipalityGeo (one, autoRelation: false, keymaps: municipalityGeoId -> geoId)
    - CityGeo (one, autoRelation: false, keymaps: cityGeoId -> geoId)
    - PostalCodeGeo (one, autoRelation: false, keymaps: postalCodeGeoId -> geoId)
    - GeoPoint (one, autoRelation: false, keymaps: geoPointId)
    + BillingAccount (many, autoRelation: true, keymaps: contactMechId)
    + CheckAccount (many, autoRelation: true, keymaps: contactMechId)
    + CreditCard (many, autoRelation: true, keymaps: contactMechId)
    + EftAccount (many, autoRelation: true, keymaps: contactMechId)
    + GiftCard (many, autoRelation: true, keymaps: contactMechId)
    + OrderItemShipGroup (many, autoRelation: true, keymaps: contactMechId)
    + PartyContactMech (many, autoRelation: true, keymaps: contactMechId)
    + PartyContactMechPurpose (many, autoRelation: true, keymaps: contactMechId)
    + PayPalPaymentMethod (many, autoRelation: true, keymaps: contactMechId)
    + PostalAddressBoundary (many, autoRelation: true, keymaps: contactMechId)
    + ReturnHeader (many, autoRelation: true, keymaps: contactMechId -> originContactMechId)
    + OriginShipment (many, autoRelation: true, keymaps: contactMechId -> originContactMechId)
    + DestinationShipment (many, autoRelation: true, keymaps: contactMechId -> destinationContactMechId)
    + OriginShipmentRouteSegment (many, autoRelation: true, keymaps: contactMechId -> originContactMechId)
    + DestShipmentRouteSegment (many, autoRelation: true, keymaps: contactMechId -> destContactMechId)
    + ShoppingList (many, autoRelation: true, keymaps: contactMechId)
*/

