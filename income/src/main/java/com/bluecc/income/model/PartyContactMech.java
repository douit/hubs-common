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
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (allowSolicitation != null) {
            builder.setAllowSolicitation(getIndicator(allowSolicitation));
        }
        if (extension != null) {
            builder.setExtension(extension);
        }
        if (verified != null) {
            builder.setVerified(getIndicator(verified));
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (yearsWithContactMech != null) {
            builder.setYearsWithContactMech(yearsWithContactMech);
        }
        if (monthsWithContactMech != null) {
            builder.setMonthsWithContactMech(monthsWithContactMech);
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

    public static PartyContactMech fromData(PartyContactMechData data) {
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
                
                .build();
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

