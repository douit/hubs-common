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

import com.bluecc.hubs.stub.FacilityContactMechData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FacilityContactMechData.class,
        symbol = EntityNames.FacilityContactMech)
public class FacilityContactMech implements IEventModel<FacilityContactMechData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("facility_id")
	@RIndex 
    String facilityId;
    @SerializedName("contact_mech_id")
	@RIndex 
    String contactMechId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("extension") 
    String extension;
    @SerializedName("comments") 
    String comments;
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

    public FacilityContactMechData.Builder toDataBuilder() {
        FacilityContactMechData.Builder builder = FacilityContactMechData.newBuilder();
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
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
        if (extension != null) {
            builder.setExtension(extension);
        }
        if (comments != null) {
            builder.setComments(comments);
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

    public static FacilityContactMech fromData(FacilityContactMechData data) {
        return FacilityContactMech.builder()
                .facilityId(data.getFacilityId())
                .contactMechId(data.getContactMechId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .extension(data.getExtension())
                .comments(data.getComments())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: facilityId, contactMechId, fromDate

-- fields --
    
    String facilityId
    String contactMechId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String extension
    String comments

-- relations --
    
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - TelecomNumber (one-nofk, autoRelation: false, keymaps: contactMechId)
    + FacilityContactMechPurpose (many, autoRelation: false, keymaps: facilityId, contactMechId)
*/

