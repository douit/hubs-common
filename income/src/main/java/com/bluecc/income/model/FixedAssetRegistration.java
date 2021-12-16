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

import com.bluecc.hubs.stub.FixedAssetRegistrationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetRegistrationData.class,
        symbol = EntityNames.FixedAssetRegistration)
public class FixedAssetRegistration implements IEventModel<FixedAssetRegistrationData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String fixedAssetId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime registrationDate;
    String govAgencyPartyId;
    String registrationNumber;
    String licenseNumber;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FixedAssetRegistrationData.Builder toDataBuilder() {
        FixedAssetRegistrationData.Builder builder = FixedAssetRegistrationData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (registrationDate != null) {
            builder.setRegistrationDate(getTimestamp(registrationDate));
        }
        if (govAgencyPartyId != null) {
            builder.setGovAgencyPartyId(govAgencyPartyId);
        }
        if (registrationNumber != null) {
            builder.setRegistrationNumber(registrationNumber);
        }
        if (licenseNumber != null) {
            builder.setLicenseNumber(licenseNumber);
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

    public static FixedAssetRegistration fromData(FixedAssetRegistrationData data) {
        return FixedAssetRegistration.builder()
                .fixedAssetId(data.getFixedAssetId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .registrationDate(getLocalDateTime(data.getRegistrationDate()))
                .govAgencyPartyId(data.getGovAgencyPartyId())
                .registrationNumber(data.getRegistrationNumber())
                .licenseNumber(data.getLicenseNumber())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: fixedAssetId, fromDate

-- fields --
    
    String fixedAssetId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.time.LocalDateTime registrationDate
    String govAgencyPartyId
    String registrationNumber
    String licenseNumber

-- relations --
    
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    - GovAgencyParty (one, autoRelation: false, keymaps: govAgencyPartyId -> partyId)
*/

