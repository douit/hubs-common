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

import com.bluecc.hubs.stub.PartyRelationshipData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyRelationshipData.class,
        symbol = EntityNames.PartyRelationship)
public class PartyRelationship implements IEventModel<PartyRelationshipData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id_from")
	@RIndex 
    String partyIdFrom;
    @SerializedName("party_id_to")
	@RIndex 
    String partyIdTo;
    @SerializedName("role_type_id_from")
	@RIndex 
    String roleTypeIdFrom;
    @SerializedName("role_type_id_to")
	@RIndex 
    String roleTypeIdTo;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("relationship_name") 
    String relationshipName;
    @SerializedName("security_group_id") 
    String securityGroupId;
    @SerializedName("priority_type_id") 
    String priorityTypeId;
    @SerializedName("party_relationship_type_id") 
    String partyRelationshipTypeId;
    @SerializedName("permissions_enum_id") 
    String permissionsEnumId;
    @SerializedName("position_title") 
    String positionTitle;
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

    public PartyRelationshipData.Builder toDataBuilder() {
        PartyRelationshipData.Builder builder = PartyRelationshipData.newBuilder();
        if (partyIdFrom != null) {
            builder.setPartyIdFrom(partyIdFrom);
        }
        if (partyIdTo != null) {
            builder.setPartyIdTo(partyIdTo);
        }
        if (roleTypeIdFrom != null) {
            builder.setRoleTypeIdFrom(roleTypeIdFrom);
        }
        if (roleTypeIdTo != null) {
            builder.setRoleTypeIdTo(roleTypeIdTo);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (relationshipName != null) {
            builder.setRelationshipName(relationshipName);
        }
        if (securityGroupId != null) {
            builder.setSecurityGroupId(securityGroupId);
        }
        if (priorityTypeId != null) {
            builder.setPriorityTypeId(priorityTypeId);
        }
        if (partyRelationshipTypeId != null) {
            builder.setPartyRelationshipTypeId(partyRelationshipTypeId);
        }
        if (permissionsEnumId != null) {
            builder.setPermissionsEnumId(permissionsEnumId);
        }
        if (positionTitle != null) {
            builder.setPositionTitle(positionTitle);
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

    public static PartyRelationship fromData(PartyRelationshipData data) {
        return PartyRelationship.builder()
                .partyIdFrom(data.getPartyIdFrom())
                .partyIdTo(data.getPartyIdTo())
                .roleTypeIdFrom(data.getRoleTypeIdFrom())
                .roleTypeIdTo(data.getRoleTypeIdTo())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .statusId(data.getStatusId())
                .relationshipName(data.getRelationshipName())
                .securityGroupId(data.getSecurityGroupId())
                .priorityTypeId(data.getPriorityTypeId())
                .partyRelationshipTypeId(data.getPartyRelationshipTypeId())
                .permissionsEnumId(data.getPermissionsEnumId())
                .positionTitle(data.getPositionTitle())
                .comments(data.getComments())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: partyIdFrom, partyIdTo, roleTypeIdFrom, roleTypeIdTo, fromDate

-- fields --
    
    String partyIdFrom
    String partyIdTo
    String roleTypeIdFrom
    String roleTypeIdTo
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String statusId
    String relationshipName
    String securityGroupId
    String priorityTypeId
    String partyRelationshipTypeId
    String permissionsEnumId
    String positionTitle
    String comments

-- relations --
    
    - FromParty (one-nofk, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - ToParty (one-nofk, autoRelation: false, keymaps: partyIdTo -> partyId)
    - FromRoleType (one-nofk, autoRelation: false, keymaps: roleTypeIdFrom -> roleTypeId)
    - ToRoleType (one-nofk, autoRelation: false, keymaps: roleTypeIdTo -> roleTypeId)
    - FromPartyRole (one, autoRelation: false, keymaps: partyIdFrom -> partyId, roleTypeIdFrom -> roleTypeId)
    - ToPartyRole (one, autoRelation: false, keymaps: partyIdTo -> partyId, roleTypeIdTo -> roleTypeId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - PriorityType (one, autoRelation: false, keymaps: priorityTypeId)
    - PartyRelationshipType (one, autoRelation: false, keymaps: partyRelationshipTypeId)
    - SecurityGroup (one, autoRelation: false, keymaps: securityGroupId -> groupId)
*/

