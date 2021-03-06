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

import com.bluecc.hubs.stub.PartyTaxAuthInfoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyTaxAuthInfoData.class,
        symbol = EntityNames.PartyTaxAuthInfo)
public class PartyTaxAuthInfo implements IEventModel<PartyTaxAuthInfoData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("tax_auth_geo_id")
	@RIndex 
    String taxAuthGeoId;
    @SerializedName("tax_auth_party_id")
	@RIndex 
    String taxAuthPartyId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("party_tax_id") 
    String partyTaxId;
    @SerializedName("is_exempt") 
    Character isExempt;
    @SerializedName("is_nexus") 
    Character isNexus;
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

    public PartyTaxAuthInfoData.Builder toDataBuilder() {
        PartyTaxAuthInfoData.Builder builder = PartyTaxAuthInfoData.newBuilder();
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getTaxAuthGeoId() != null) {
            builder.setTaxAuthGeoId(getTaxAuthGeoId());
        }
        if (getTaxAuthPartyId() != null) {
            builder.setTaxAuthPartyId(getTaxAuthPartyId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getPartyTaxId() != null) {
            builder.setPartyTaxId(getPartyTaxId());
        }
        if (getIsExempt() != null) {
            builder.setIsExempt(getIndicator(getIsExempt()));
        }
        if (getIsNexus() != null) {
            builder.setIsNexus(getIndicator(getIsNexus()));
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

    public static PartyTaxAuthInfo fromData(PartyTaxAuthInfoData data) {
        return fromPrototype(data).build();
    }

    public static PartyTaxAuthInfo.PartyTaxAuthInfoBuilder fromPrototype(PartyTaxAuthInfoData data) {
        return PartyTaxAuthInfo.builder()
                .partyId(data.getPartyId())
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .partyTaxId(data.getPartyTaxId())
                .isExempt(getIndicatorChar(data.getIsExempt()))
                .isNexus(getIndicatorChar(data.getIsNexus()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: partyId, taxAuthGeoId, taxAuthPartyId, fromDate

-- fields --
    
    String partyId
    String taxAuthGeoId
    String taxAuthPartyId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String partyTaxId
    Character isExempt
    Character isNexus

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
*/

