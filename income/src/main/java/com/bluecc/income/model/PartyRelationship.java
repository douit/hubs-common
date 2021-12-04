package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRelationshipData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyRelationship implements IEventModel<PartyRelationshipData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String partyIdFrom;
    String partyIdTo;
    String roleTypeIdFrom;
    String roleTypeIdTo;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String statusId;
    String relationshipName;
    String securityGroupId;
    String priorityTypeId;
    String partyRelationshipTypeId;
    String permissionsEnumId;
    String positionTitle;
    String comments;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
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