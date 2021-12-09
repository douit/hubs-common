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

import com.bluecc.hubs.stub.PostalAddressData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PostalAddressData.class,
        symbol = EntityNames.PostalAddress)
public class PostalAddress implements IEventModel<PostalAddressData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String contactMechId;
    String toName;
    String attnName;
    String address1;
    String address2;
    Long houseNumber;
    String houseNumberExt;
    String directions;
    String city;
    String cityGeoId;
    String postalCode;
    String postalCodeExt;
    String countryGeoId;
    String stateProvinceGeoId;
    String countyGeoId;
    String municipalityGeoId;
    String postalCodeGeoId;
    String geoPointId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PostalAddressData.Builder toDataBuilder() {
        PostalAddressData.Builder builder = PostalAddressData.newBuilder();
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (toName != null) {
            builder.setToName(toName);
        }
        if (attnName != null) {
            builder.setAttnName(attnName);
        }
        if (address1 != null) {
            builder.setAddress1(address1);
        }
        if (address2 != null) {
            builder.setAddress2(address2);
        }
        if (houseNumber != null) {
            builder.setHouseNumber(houseNumber);
        }
        if (houseNumberExt != null) {
            builder.setHouseNumberExt(houseNumberExt);
        }
        if (directions != null) {
            builder.setDirections(directions);
        }
        if (city != null) {
            builder.setCity(city);
        }
        if (cityGeoId != null) {
            builder.setCityGeoId(cityGeoId);
        }
        if (postalCode != null) {
            builder.setPostalCode(postalCode);
        }
        if (postalCodeExt != null) {
            builder.setPostalCodeExt(postalCodeExt);
        }
        if (countryGeoId != null) {
            builder.setCountryGeoId(countryGeoId);
        }
        if (stateProvinceGeoId != null) {
            builder.setStateProvinceGeoId(stateProvinceGeoId);
        }
        if (countyGeoId != null) {
            builder.setCountyGeoId(countyGeoId);
        }
        if (municipalityGeoId != null) {
            builder.setMunicipalityGeoId(municipalityGeoId);
        }
        if (postalCodeGeoId != null) {
            builder.setPostalCodeGeoId(postalCodeGeoId);
        }
        if (geoPointId != null) {
            builder.setGeoPointId(geoPointId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static PostalAddress fromData(PostalAddressData data) {
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
                
                .build();
    }

    
}
