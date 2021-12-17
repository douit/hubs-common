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

import com.bluecc.hubs.stub.CommunicationEventData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CommunicationEventData.class,
        symbol = EntityNames.CommunicationEvent)
public class CommunicationEvent implements IEventModel<CommunicationEventData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("communication_event_id")
	@RId 
    String communicationEventId;
    @SerializedName("communication_event_type_id") 
    String communicationEventTypeId;
    @SerializedName("orig_comm_event_id") 
    String origCommEventId;
    @SerializedName("parent_comm_event_id") 
    String parentCommEventId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("contact_mech_type_id") 
    String contactMechTypeId;
    @SerializedName("contact_mech_id_from") 
    String contactMechIdFrom;
    @SerializedName("contact_mech_id_to") 
    String contactMechIdTo;
    @SerializedName("role_type_id_from") 
    String roleTypeIdFrom;
    @SerializedName("role_type_id_to") 
    String roleTypeIdTo;
    @SerializedName("party_id_from") 
    String partyIdFrom;
    @SerializedName("party_id_to") 
    String partyIdTo;
    @SerializedName("entry_date") 
    java.time.LocalDateTime entryDate;
    @SerializedName("datetime_started") 
    java.time.LocalDateTime datetimeStarted;
    @SerializedName("datetime_ended") 
    java.time.LocalDateTime datetimeEnded;
    @SerializedName("subject") 
    String subject;
    @SerializedName("content_mime_type_id") 
    String contentMimeTypeId;
    @SerializedName("content") 
    String content;
    @SerializedName("note") 
    String note;
    @SerializedName("reason_enum_id") 
    String reasonEnumId;
    @SerializedName("contact_list_id") 
    String contactListId;
    @SerializedName("header_string") 
    String headerString;
    @SerializedName("from_text") 
    String fromText;
    @SerializedName("to_text") 
    String toText;
    @SerializedName("cc_string") 
    String ccString;
    @SerializedName("bcc_string") 
    String bccString;
    @SerializedName("message_id") 
    String messageId;
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
        return communicationEventId;
    }

        
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


/*
-- keys: communicationEventId

-- fields --
    
    String communicationEventId
    String communicationEventTypeId
    String origCommEventId
    String parentCommEventId
    String statusId
    String contactMechTypeId
    String contactMechIdFrom
    String contactMechIdTo
    String roleTypeIdFrom
    String roleTypeIdTo
    String partyIdFrom
    String partyIdTo
    java.time.LocalDateTime entryDate
    java.time.LocalDateTime datetimeStarted
    java.time.LocalDateTime datetimeEnded
    String subject
    String contentMimeTypeId
    String content
    String note
    String reasonEnumId
    String contactListId
    String headerString
    String fromText
    String toText
    String ccString
    String bccString
    String messageId

-- relations --
    
    - CommunicationEventType (one, autoRelation: false, keymaps: communicationEventTypeId)
    - ToParty (one, autoRelation: false, keymaps: partyIdTo -> partyId)
    - ToRoleType (one, autoRelation: false, keymaps: roleTypeIdTo -> roleTypeId)
    - ToPartyRole (one-nofk, autoRelation: false, keymaps: partyIdTo -> partyId, roleTypeIdTo -> roleTypeId)
    - FromParty (one, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - FromRoleType (one, autoRelation: false, keymaps: roleTypeIdFrom -> roleTypeId)
    - FromPartyRole (one-nofk, autoRelation: false, keymaps: partyIdFrom -> partyId, roleTypeIdFrom -> roleTypeId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - ContactMechType (one, autoRelation: false, keymaps: contactMechTypeId)
    - FromContactMech (one, autoRelation: false, keymaps: contactMechIdFrom -> contactMechId)
    - ToContactMech (one, autoRelation: false, keymaps: contactMechIdTo -> contactMechId)
    - ContactList (one, autoRelation: false, keymaps: contactListId)
    - MimeType (one, autoRelation: false, keymaps: contentMimeTypeId -> mimeTypeId)
    - Enumeration (one, autoRelation: false, keymaps: reasonEnumId -> enumId)
    + CommEventContentAssoc (many, autoRelation: true, keymaps: communicationEventId)
    + CommunicationEventOrder (many, autoRelation: true, keymaps: communicationEventId)
    + CommunicationEventProduct (many, autoRelation: true, keymaps: communicationEventId)
    + CommunicationEventPurpose (many, autoRelation: true, keymaps: communicationEventId)
    + CommunicationEventReturn (many, autoRelation: true, keymaps: communicationEventId)
    + CommunicationEventRole (many, autoRelation: true, keymaps: communicationEventId)
    + CommunicationEventWorkEff (many, autoRelation: true, keymaps: communicationEventId)
    + ContactListCommStatus (many, autoRelation: true, keymaps: communicationEventId)
    + CustRequestCommEvent (many, autoRelation: true, keymaps: communicationEventId)
    + PartyNeed (many, autoRelation: true, keymaps: communicationEventId)
    + SubscriptionCommEvent (many, autoRelation: true, keymaps: communicationEventId)
*/

