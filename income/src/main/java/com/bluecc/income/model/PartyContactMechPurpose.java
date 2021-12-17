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

import com.bluecc.hubs.stub.PartyContactMechPurposeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyContactMechPurposeData.class,
        symbol = EntityNames.PartyContactMechPurpose)
public class PartyContactMechPurpose implements IEventModel<PartyContactMechPurposeData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("contact_mech_id")
	@RIndex 
    String contactMechId;
    @SerializedName("contact_mech_purpose_type_id")
	@RIndex 
    String contactMechPurposeTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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

    public PartyContactMechPurposeData.Builder toDataBuilder() {
        PartyContactMechPurposeData.Builder builder = PartyContactMechPurposeData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (contactMechPurposeTypeId != null) {
            builder.setContactMechPurposeTypeId(contactMechPurposeTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
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

    public static PartyContactMechPurpose fromData(PartyContactMechPurposeData data) {
        return PartyContactMechPurpose.builder()
                .partyId(data.getPartyId())
                .contactMechId(data.getContactMechId())
                .contactMechPurposeTypeId(data.getContactMechPurposeTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: partyId, contactMechId, contactMechPurposeTypeId, fromDate

-- fields --
    
    String partyId
    String contactMechId
    String contactMechPurposeTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    + PartyContactMech (many, autoRelation: false, keymaps: partyId, contactMechId)
    - ContactMechPurposeType (one, autoRelation: false, keymaps: contactMechPurposeTypeId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - Person (one-nofk, autoRelation: false, keymaps: partyId)
    - PartyGroup (one-nofk, autoRelation: false, keymaps: partyId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - PostalAddress (one-nofk, autoRelation: false, keymaps: contactMechId)
    - TelecomNumber (one-nofk, autoRelation: false, keymaps: contactMechId)
*/

