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

import com.bluecc.hubs.stub.CommunicationEventRoleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CommunicationEventRoleData.class,
        symbol = EntityNames.CommunicationEventRole)
public class CommunicationEventRole implements IEventModel<CommunicationEventRoleData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("communication_event_id")
	@RIndex 
    String communicationEventId;
    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("role_type_id")
	@RIndex 
    String roleTypeId;
    @SerializedName("contact_mech_id") 
    String contactMechId;
    @SerializedName("status_id") 
    String statusId;
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

    public CommunicationEventRoleData.Builder toDataBuilder() {
        CommunicationEventRoleData.Builder builder = CommunicationEventRoleData.newBuilder();
        if (getCommunicationEventId() != null) {
            builder.setCommunicationEventId(getCommunicationEventId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getRoleTypeId() != null) {
            builder.setRoleTypeId(getRoleTypeId());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
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

    public static CommunicationEventRole fromData(CommunicationEventRoleData data) {
        return fromPrototype(data).build();
    }

    public static CommunicationEventRole.CommunicationEventRoleBuilder fromPrototype(CommunicationEventRoleData data) {
        return CommunicationEventRole.builder()
                .communicationEventId(data.getCommunicationEventId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .contactMechId(data.getContactMechId())
                .statusId(data.getStatusId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
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

