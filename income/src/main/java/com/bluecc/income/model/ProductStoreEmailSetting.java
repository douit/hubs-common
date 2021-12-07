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

import com.bluecc.hubs.stub.ProductStoreEmailSettingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class ProductStoreEmailSetting implements IEventModel<ProductStoreEmailSettingData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String productStoreId;
    @RIndex String emailType;
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
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreEmailSettingData.Builder toDataBuilder() {
        ProductStoreEmailSettingData.Builder builder = ProductStoreEmailSettingData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (emailType != null) {
            builder.setEmailType(emailType);
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
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static ProductStoreEmailSetting fromData(ProductStoreEmailSettingData data) {
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
                
                .build();
    }

    
}
