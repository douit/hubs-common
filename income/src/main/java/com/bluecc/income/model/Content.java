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
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ContentData.class,
        symbol = EntityNames.Content)
public class Content implements IEventModel<ContentData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String contentId;
    String contentTypeId;
    String ownerContentId;
    String decoratorContentId;
    String instanceOfContentId;
    String dataResourceId;
    String templateDataResourceId;
    String dataSourceId;
    String statusId;
    String privilegeEnumId;
    String serviceName;
    String customMethodId;
    String contentName;
    String description;
    String localeString;
    String mimeTypeId;
    String characterSetId;
    Long childLeafCount;
    Long childBranchCount;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ContentData.Builder toDataBuilder() {
        ContentData.Builder builder = ContentData.newBuilder();
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (contentTypeId != null) {
            builder.setContentTypeId(contentTypeId);
        }
        if (ownerContentId != null) {
            builder.setOwnerContentId(ownerContentId);
        }
        if (decoratorContentId != null) {
            builder.setDecoratorContentId(decoratorContentId);
        }
        if (instanceOfContentId != null) {
            builder.setInstanceOfContentId(instanceOfContentId);
        }
        if (dataResourceId != null) {
            builder.setDataResourceId(dataResourceId);
        }
        if (templateDataResourceId != null) {
            builder.setTemplateDataResourceId(templateDataResourceId);
        }
        if (dataSourceId != null) {
            builder.setDataSourceId(dataSourceId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (privilegeEnumId != null) {
            builder.setPrivilegeEnumId(privilegeEnumId);
        }
        if (serviceName != null) {
            builder.setServiceName(serviceName);
        }
        if (customMethodId != null) {
            builder.setCustomMethodId(customMethodId);
        }
        if (contentName != null) {
            builder.setContentName(contentName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (localeString != null) {
            builder.setLocaleString(localeString);
        }
        if (mimeTypeId != null) {
            builder.setMimeTypeId(mimeTypeId);
        }
        if (characterSetId != null) {
            builder.setCharacterSetId(characterSetId);
        }
        if (childLeafCount != null) {
            builder.setChildLeafCount(childLeafCount);
        }
        if (childBranchCount != null) {
            builder.setChildBranchCount(childBranchCount);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Content fromData(ContentData data) {
        return Content.builder()
                .contentId(data.getContentId())
                .contentTypeId(data.getContentTypeId())
                .ownerContentId(data.getOwnerContentId())
                .decoratorContentId(data.getDecoratorContentId())
                .instanceOfContentId(data.getInstanceOfContentId())
                .dataResourceId(data.getDataResourceId())
                .templateDataResourceId(data.getTemplateDataResourceId())
                .dataSourceId(data.getDataSourceId())
                .statusId(data.getStatusId())
                .privilegeEnumId(data.getPrivilegeEnumId())
                .serviceName(data.getServiceName())
                .customMethodId(data.getCustomMethodId())
                .contentName(data.getContentName())
                .description(data.getDescription())
                .localeString(data.getLocaleString())
                .mimeTypeId(data.getMimeTypeId())
                .characterSetId(data.getCharacterSetId())
                .childLeafCount(data.getChildLeafCount())
                .childBranchCount(data.getChildBranchCount())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
