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

import com.bluecc.hubs.stub.EmailTemplateSettingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = EmailTemplateSettingData.class,
        symbol = EntityNames.EmailTemplateSetting)
public class EmailTemplateSetting implements IEventModel<EmailTemplateSettingData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String emailTemplateSettingId;
    String emailType;
    String description;
    String bodyScreenLocation;
    String xslfoAttachScreenLocation;
    String fromAddress;
    String ccAddress;
    String bccAddress;
    String subject;
    String contentType;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EmailTemplateSettingData.Builder toDataBuilder() {
        EmailTemplateSettingData.Builder builder = EmailTemplateSettingData.newBuilder();
        if (emailTemplateSettingId != null) {
            builder.setEmailTemplateSettingId(emailTemplateSettingId);
        }
        if (emailType != null) {
            builder.setEmailType(emailType);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (bodyScreenLocation != null) {
            builder.setBodyScreenLocation(bodyScreenLocation);
        }
        if (xslfoAttachScreenLocation != null) {
            builder.setXslfoAttachScreenLocation(xslfoAttachScreenLocation);
        }
        if (fromAddress != null) {
            builder.setFromAddress(fromAddress);
        }
        if (ccAddress != null) {
            builder.setCcAddress(ccAddress);
        }
        if (bccAddress != null) {
            builder.setBccAddress(bccAddress);
        }
        if (subject != null) {
            builder.setSubject(subject);
        }
        if (contentType != null) {
            builder.setContentType(contentType);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static EmailTemplateSetting fromData(EmailTemplateSettingData data) {
        return EmailTemplateSetting.builder()
                .emailTemplateSettingId(data.getEmailTemplateSettingId())
                .emailType(data.getEmailType())
                .description(data.getDescription())
                .bodyScreenLocation(data.getBodyScreenLocation())
                .xslfoAttachScreenLocation(data.getXslfoAttachScreenLocation())
                .fromAddress(data.getFromAddress())
                .ccAddress(data.getCcAddress())
                .bccAddress(data.getBccAddress())
                .subject(data.getSubject())
                .contentType(data.getContentType())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: emailTemplateSettingId

-- fields --
    
    String emailTemplateSettingId
    String emailType
    String description
    String bodyScreenLocation
    String xslfoAttachScreenLocation
    String fromAddress
    String ccAddress
    String bccAddress
    String subject
    String contentType

-- relations --
    
    - Enumeration (one, autoRelation: false, keymaps: emailType -> enumId)
*/

