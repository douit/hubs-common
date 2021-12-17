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

import com.bluecc.hubs.stub.PartyIdentificationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyIdentificationData.class,
        symbol = EntityNames.PartyIdentification)
public class PartyIdentification implements IEventModel<PartyIdentificationData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("party_identification_type_id")
	@RIndex 
    String partyIdentificationTypeId;
    @SerializedName("id_value") 
    String idValue;
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

    public PartyIdentificationData.Builder toDataBuilder() {
        PartyIdentificationData.Builder builder = PartyIdentificationData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (partyIdentificationTypeId != null) {
            builder.setPartyIdentificationTypeId(partyIdentificationTypeId);
        }
        if (idValue != null) {
            builder.setIdValue(idValue);
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

    public static PartyIdentification fromData(PartyIdentificationData data) {
        return PartyIdentification.builder()
                .partyId(data.getPartyId())
                .partyIdentificationTypeId(data.getPartyIdentificationTypeId())
                .idValue(data.getIdValue())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: partyId, partyIdentificationTypeId

-- fields --
    
    String partyId
    String partyIdentificationTypeId
    String idValue

-- relations --
    
    - PartyIdentificationType (one, autoRelation: false, keymaps: partyIdentificationTypeId)
    - Party (one, autoRelation: false, keymaps: partyId)
*/

