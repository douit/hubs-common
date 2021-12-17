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

import com.bluecc.hubs.stub.PartyIdentificationTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyIdentificationTypeData.class,
        symbol = EntityNames.PartyIdentificationType)
public class PartyIdentificationType implements IEventModel<PartyIdentificationTypeData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_identification_type_id")
	@RId 
    String partyIdentificationTypeId;
    @SerializedName("parent_type_id") 
    String parentTypeId;
    @SerializedName("has_table") 
    Character hasTable;
    @SerializedName("description") 
    String description;
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
        return partyIdentificationTypeId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyIdentificationTypeData.Builder toDataBuilder() {
        PartyIdentificationTypeData.Builder builder = PartyIdentificationTypeData.newBuilder();
        if (partyIdentificationTypeId != null) {
            builder.setPartyIdentificationTypeId(partyIdentificationTypeId);
        }
        if (parentTypeId != null) {
            builder.setParentTypeId(parentTypeId);
        }
        if (hasTable != null) {
            builder.setHasTable(getIndicator(hasTable));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static PartyIdentificationType fromData(PartyIdentificationTypeData data) {
        return PartyIdentificationType.builder()
                .partyIdentificationTypeId(data.getPartyIdentificationTypeId())
                .parentTypeId(data.getParentTypeId())
                .hasTable(getIndicatorChar(data.getHasTable()))
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: partyIdentificationTypeId

-- fields --
    
    String partyIdentificationTypeId
    String parentTypeId
    Character hasTable
    String description

-- relations --
    
    - ParentPartyIdentificationType (one, autoRelation: false, keymaps: parentTypeId -> partyIdentificationTypeId)
    + PartyIdentification (many, autoRelation: true, keymaps: partyIdentificationTypeId)
    + ChildPartyIdentificationType (many, autoRelation: true, keymaps: partyIdentificationTypeId -> parentTypeId)
*/

