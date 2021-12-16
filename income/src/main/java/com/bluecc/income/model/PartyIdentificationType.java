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

import com.bluecc.hubs.stub.PartyIdentificationTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyIdentificationTypeData.class,
        symbol = EntityNames.PartyIdentificationType)
public class PartyIdentificationType implements IEventModel<PartyIdentificationTypeData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String partyIdentificationTypeId;
    String parentTypeId;
    Character hasTable;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
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

