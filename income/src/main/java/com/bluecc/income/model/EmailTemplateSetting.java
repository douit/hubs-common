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

import com.bluecc.hubs.stub.EmailTemplateSettingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = EmailTemplateSettingData.class,
        symbol = EntityNames.EmailTemplateSetting)
public class EmailTemplateSetting implements IEventModel<EmailTemplateSettingData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("email_template_setting_id")
	@RId 
    String emailTemplateSettingId;
    @SerializedName("email_type") 
    String emailType;
    @SerializedName("description") 
    String description;
    @SerializedName("body_screen_location") 
    String bodyScreenLocation;
    @SerializedName("xslfo_attach_screen_location") 
    String xslfoAttachScreenLocation;
    @SerializedName("from_address") 
    String fromAddress;
    @SerializedName("cc_address") 
    String ccAddress;
    @SerializedName("bcc_address") 
    String bccAddress;
    @SerializedName("subject") 
    String subject;
    @SerializedName("content_type") 
    String contentType;
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
        return emailTemplateSettingId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EmailTemplateSettingData.Builder toDataBuilder() {
        EmailTemplateSettingData.Builder builder = EmailTemplateSettingData.newBuilder();
        if (getEmailTemplateSettingId() != null) {
            builder.setEmailTemplateSettingId(getEmailTemplateSettingId());
        }
        if (getEmailType() != null) {
            builder.setEmailType(getEmailType());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getBodyScreenLocation() != null) {
            builder.setBodyScreenLocation(getBodyScreenLocation());
        }
        if (getXslfoAttachScreenLocation() != null) {
            builder.setXslfoAttachScreenLocation(getXslfoAttachScreenLocation());
        }
        if (getFromAddress() != null) {
            builder.setFromAddress(getFromAddress());
        }
        if (getCcAddress() != null) {
            builder.setCcAddress(getCcAddress());
        }
        if (getBccAddress() != null) {
            builder.setBccAddress(getBccAddress());
        }
        if (getSubject() != null) {
            builder.setSubject(getSubject());
        }
        if (getContentType() != null) {
            builder.setContentType(getContentType());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static EmailTemplateSetting fromData(EmailTemplateSettingData data) {
        return fromPrototype(data).build();
    }

    public static EmailTemplateSetting.EmailTemplateSettingBuilder fromPrototype(EmailTemplateSettingData data) {
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
                ;
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

