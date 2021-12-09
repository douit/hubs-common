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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.CommunicationEventData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class CommunicationEvent implements IEventModel<CommunicationEventData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String communicationEventId;
    String communicationEventTypeId;
    String origCommEventId;
    String parentCommEventId;
    String statusId;
    String contactMechTypeId;
    String contactMechIdFrom;
    String contactMechIdTo;
    String roleTypeIdFrom;
    String roleTypeIdTo;
    String partyIdFrom;
    String partyIdTo;
    java.time.LocalDateTime entryDate;
    java.time.LocalDateTime datetimeStarted;
    java.time.LocalDateTime datetimeEnded;
    String subject;
    String contentMimeTypeId;
    String content;
    String note;
    String reasonEnumId;
    String contactListId;
    String headerString;
    String fromText;
    String toText;
    String ccString;
    String bccString;
    String messageId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CommunicationEventData.Builder toDataBuilder() {
        CommunicationEventData.Builder builder = CommunicationEventData.newBuilder();
        if (communicationEventId != null) {
            builder.setCommunicationEventId(communicationEventId);
        }
        if (communicationEventTypeId != null) {
            builder.setCommunicationEventTypeId(communicationEventTypeId);
        }
        if (origCommEventId != null) {
            builder.setOrigCommEventId(origCommEventId);
        }
        if (parentCommEventId != null) {
            builder.setParentCommEventId(parentCommEventId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (contactMechTypeId != null) {
            builder.setContactMechTypeId(contactMechTypeId);
        }
        if (contactMechIdFrom != null) {
            builder.setContactMechIdFrom(contactMechIdFrom);
        }
        if (contactMechIdTo != null) {
            builder.setContactMechIdTo(contactMechIdTo);
        }
        if (roleTypeIdFrom != null) {
            builder.setRoleTypeIdFrom(roleTypeIdFrom);
        }
        if (roleTypeIdTo != null) {
            builder.setRoleTypeIdTo(roleTypeIdTo);
        }
        if (partyIdFrom != null) {
            builder.setPartyIdFrom(partyIdFrom);
        }
        if (partyIdTo != null) {
            builder.setPartyIdTo(partyIdTo);
        }
        if (entryDate != null) {
            builder.setEntryDate(getTimestamp(entryDate));
        }
        if (datetimeStarted != null) {
            builder.setDatetimeStarted(getTimestamp(datetimeStarted));
        }
        if (datetimeEnded != null) {
            builder.setDatetimeEnded(getTimestamp(datetimeEnded));
        }
        if (subject != null) {
            builder.setSubject(subject);
        }
        if (contentMimeTypeId != null) {
            builder.setContentMimeTypeId(contentMimeTypeId);
        }
        if (content != null) {
            builder.setContent(content);
        }
        if (note != null) {
            builder.setNote(note);
        }
        if (reasonEnumId != null) {
            builder.setReasonEnumId(reasonEnumId);
        }
        if (contactListId != null) {
            builder.setContactListId(contactListId);
        }
        if (headerString != null) {
            builder.setHeaderString(headerString);
        }
        if (fromText != null) {
            builder.setFromText(fromText);
        }
        if (toText != null) {
            builder.setToText(toText);
        }
        if (ccString != null) {
            builder.setCcString(ccString);
        }
        if (bccString != null) {
            builder.setBccString(bccString);
        }
        if (messageId != null) {
            builder.setMessageId(messageId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static CommunicationEvent fromData(CommunicationEventData data) {
        return CommunicationEvent.builder()
                .communicationEventId(data.getCommunicationEventId())
                .communicationEventTypeId(data.getCommunicationEventTypeId())
                .origCommEventId(data.getOrigCommEventId())
                .parentCommEventId(data.getParentCommEventId())
                .statusId(data.getStatusId())
                .contactMechTypeId(data.getContactMechTypeId())
                .contactMechIdFrom(data.getContactMechIdFrom())
                .contactMechIdTo(data.getContactMechIdTo())
                .roleTypeIdFrom(data.getRoleTypeIdFrom())
                .roleTypeIdTo(data.getRoleTypeIdTo())
                .partyIdFrom(data.getPartyIdFrom())
                .partyIdTo(data.getPartyIdTo())
                .entryDate(getLocalDateTime(data.getEntryDate()))
                .datetimeStarted(getLocalDateTime(data.getDatetimeStarted()))
                .datetimeEnded(getLocalDateTime(data.getDatetimeEnded()))
                .subject(data.getSubject())
                .contentMimeTypeId(data.getContentMimeTypeId())
                .content(data.getContent())
                .note(data.getNote())
                .reasonEnumId(data.getReasonEnumId())
                .contactListId(data.getContactListId())
                .headerString(data.getHeaderString())
                .fromText(data.getFromText())
                .toText(data.getToText())
                .ccString(data.getCcString())
                .bccString(data.getBccString())
                .messageId(data.getMessageId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
