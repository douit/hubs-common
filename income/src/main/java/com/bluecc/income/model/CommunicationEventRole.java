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

import com.bluecc.hubs.stub.CommunicationEventRoleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CommunicationEventRoleData.class,
        symbol = EntityNames.CommunicationEventRole)
public class CommunicationEventRole implements IEventModel<CommunicationEventRoleData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String communicationEventId;
    @RIndex String partyId;
    @RIndex String roleTypeId;
    String contactMechId;
    String statusId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CommunicationEventRoleData.Builder toDataBuilder() {
        CommunicationEventRoleData.Builder builder = CommunicationEventRoleData.newBuilder();
        if (communicationEventId != null) {
            builder.setCommunicationEventId(communicationEventId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
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

    public static CommunicationEventRole fromData(CommunicationEventRoleData data) {
        return CommunicationEventRole.builder()
                .communicationEventId(data.getCommunicationEventId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .contactMechId(data.getContactMechId())
                .statusId(data.getStatusId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: communicationEventId, partyId, roleTypeId

-- fields --
    
    String communicationEventId
    String partyId
    String roleTypeId
    String contactMechId
    String statusId

-- relations --
    
    - CommunicationEvent (one, autoRelation: false, keymaps: communicationEventId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one-nofk, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
*/

