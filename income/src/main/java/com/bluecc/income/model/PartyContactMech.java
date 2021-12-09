package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.PartyContactMechData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyContactMechData.class,
        symbol = EntityNames.PartyContactMech)
public class PartyContactMech implements IEventModel<PartyContactMechData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String partyId;
    @RIndex String contactMechId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String roleTypeId;
    Character allowSolicitation;
    String extension;
    Character verified;
    String comments;
    Long yearsWithContactMech;
    Long monthsWithContactMech;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyContactMechData.Builder toDataBuilder() {
        PartyContactMechData.Builder builder = PartyContactMechData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
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
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (allowSolicitation != null) {
            builder.setAllowSolicitation(getIndicator(allowSolicitation));
        }
        if (extension != null) {
            builder.setExtension(extension);
        }
        if (verified != null) {
            builder.setVerified(getIndicator(verified));
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (yearsWithContactMech != null) {
            builder.setYearsWithContactMech(yearsWithContactMech);
        }
        if (monthsWithContactMech != null) {
            builder.setMonthsWithContactMech(monthsWithContactMech);
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

    public static PartyContactMech fromData(PartyContactMechData data) {
        return PartyContactMech.builder()
                .partyId(data.getPartyId())
                .contactMechId(data.getContactMechId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .roleTypeId(data.getRoleTypeId())
                .allowSolicitation(getIndicatorChar(data.getAllowSolicitation()))
                .extension(data.getExtension())
                .verified(getIndicatorChar(data.getVerified()))
                .comments(data.getComments())
                .yearsWithContactMech(data.getYearsWithContactMech())
                .monthsWithContactMech(data.getMonthsWithContactMech())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
