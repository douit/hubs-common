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

import com.bluecc.hubs.stub.ProductStoreEmailSettingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreEmailSettingData.class,
        symbol = EntityNames.ProductStoreEmailSetting)
public class ProductStoreEmailSetting implements IEventModel<ProductStoreEmailSettingData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_id")
	@RIndex 
    String productStoreId;
    @SerializedName("email_type")
	@RIndex 
    String emailType;
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
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreEmailSettingData.Builder toDataBuilder() {
        ProductStoreEmailSettingData.Builder builder = ProductStoreEmailSettingData.newBuilder();
        if (getProductStoreId() != null) {
            builder.setProductStoreId(getProductStoreId());
        }
        if (getEmailType() != null) {
            builder.setEmailType(getEmailType());
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
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static ProductStoreEmailSetting fromData(ProductStoreEmailSettingData data) {
        return fromPrototype(data).build();
    }

    public static ProductStoreEmailSetting.ProductStoreEmailSettingBuilder fromPrototype(ProductStoreEmailSettingData data) {
        return ProductStoreEmailSetting.builder()
                .productStoreId(data.getProductStoreId())
                .emailType(data.getEmailType())
                .bodyScreenLocation(data.getBodyScreenLocation())
                .xslfoAttachScreenLocation(data.getXslfoAttachScreenLocation())
                .fromAddress(data.getFromAddress())
                .ccAddress(data.getCcAddress())
                .bccAddress(data.getBccAddress())
                .subject(data.getSubject())
                .contentType(data.getContentType())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: productStoreId, emailType

-- fields --
    
    String productStoreId
    String emailType
    String bodyScreenLocation
    String xslfoAttachScreenLocation
    String fromAddress
    String ccAddress
    String bccAddress
    String subject
    String contentType

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - Enumeration (one, autoRelation: false, keymaps: emailType -> enumId)
*/

