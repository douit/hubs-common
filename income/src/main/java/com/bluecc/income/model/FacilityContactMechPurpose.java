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

import com.bluecc.hubs.stub.FacilityContactMechPurposeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FacilityContactMechPurposeData.class,
        symbol = EntityNames.FacilityContactMechPurpose)
public class FacilityContactMechPurpose implements IEventModel<FacilityContactMechPurposeData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("facility_id")
	@RIndex 
    String facilityId;
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

    public FacilityContactMechPurposeData.Builder toDataBuilder() {
        FacilityContactMechPurposeData.Builder builder = FacilityContactMechPurposeData.newBuilder();
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getContactMechPurposeTypeId() != null) {
            builder.setContactMechPurposeTypeId(getContactMechPurposeTypeId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
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

    public static FacilityContactMechPurpose fromData(FacilityContactMechPurposeData data) {
        return fromPrototype(data).build();
    }

    public static FacilityContactMechPurpose.FacilityContactMechPurposeBuilder fromPrototype(FacilityContactMechPurposeData data) {
        return FacilityContactMechPurpose.builder()
                .facilityId(data.getFacilityId())
                .contactMechId(data.getContactMechId())
                .contactMechPurposeTypeId(data.getContactMechPurposeTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: facilityId, contactMechId, contactMechPurposeTypeId, fromDate

-- fields --
    
    String facilityId
    String contactMechId
    String contactMechPurposeTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    + FacilityContactMech (many, autoRelation: false, keymaps: facilityId, contactMechId)
    - ContactMechPurposeType (one, autoRelation: false, keymaps: contactMechPurposeTypeId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
*/

