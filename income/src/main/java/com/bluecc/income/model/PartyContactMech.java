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

import com.bluecc.hubs.stub.PartyContactMechData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyContactMechData.class,
        symbol = EntityNames.PartyContactMech)
public class PartyContactMech implements IEventModel<PartyContactMechData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("contact_mech_id")
	@RIndex 
    String contactMechId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("role_type_id") 
    String roleTypeId;
    @SerializedName("allow_solicitation") 
    Character allowSolicitation;
    @SerializedName("extension") 
    String extension;
    @SerializedName("verified") 
    Character verified;
    @SerializedName("comments") 
    String comments;
    @SerializedName("years_with_contact_mech") 
    Long yearsWithContactMech;
    @SerializedName("months_with_contact_mech") 
    Long monthsWithContactMech;
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

    public PartyContactMechData.Builder toDataBuilder() {
        PartyContactMechData.Builder builder = PartyContactMechData.newBuilder();
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getAllowSolicitation() != null) {
            builder.setAllowSolicitation(getIndicator(getAllowSolicitation()));
        }
        if (getExtension() != null) {
            builder.setExtension(getExtension());
        }
        if (getVerified() != null) {
            builder.setVerified(getIndicator(getVerified()));
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getYearsWithContactMech() != null) {
            builder.setYearsWithContactMech(getYearsWithContactMech());
        }
        if (getMonthsWithContactMech() != null) {
            builder.setMonthsWithContactMech(getMonthsWithContactMech());
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

    public static PartyContactMech fromData(PartyContactMechData data) {
        return fromPrototype(data).build();
    }

    public static PartyContactMech.PartyContactMechBuilder fromPrototype(PartyContactMechData data) {
        return PartyContactMech.builder()
                .partyId(data.getPartyId())
                .contactMechId(data.getContactMechId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .roleTypeId(data.getRoleTypeId())
                .allowSolicitation(getIndicatorChar(data.getAllowSolicitation()))
                .extension(data.getExtension())
                .verified(getIndicatorChar(data.getVerified()))
                .comments(data.getComments())
                .yearsWithContactMech(data.getYearsWithContactMech())
                .monthsWithContactMech(data.getMonthsWithContactMech())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: partyId, contactMechId, fromDate

-- fields --
    
    String partyId
    String contactMechId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String roleTypeId
    Character allowSolicitation
    String extension
    Character verified
    String comments
    Long yearsWithContactMech
    Long monthsWithContactMech

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - Person (one-nofk, autoRelation: false, keymaps: partyId)
    - PartyGroup (one-nofk, autoRelation: false, keymaps: partyId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - TelecomNumber (one-nofk, autoRelation: false, keymaps: contactMechId)
    - PostalAddress (one-nofk, autoRelation: false, keymaps: contactMechId)
    + PartyContactMechPurpose (many, autoRelation: false, keymaps: partyId, contactMechId)
*/

