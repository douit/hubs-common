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

import com.bluecc.hubs.stub.ContentAttributeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ContentAttributeData.class,
        symbol = EntityNames.ContentAttribute)
public class ContentAttribute implements IEventModel<ContentAttributeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String contentId;
    @RIndex String attrName;
    String attrValue;
    String attrDescription;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ContentAttributeData.Builder toDataBuilder() {
        ContentAttributeData.Builder builder = ContentAttributeData.newBuilder();
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (attrName != null) {
            builder.setAttrName(attrName);
        }
        if (attrValue != null) {
            builder.setAttrValue(attrValue);
        }
        if (attrDescription != null) {
            builder.setAttrDescription(attrDescription);
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

    public static ContentAttribute fromData(ContentAttributeData data) {
        return ContentAttribute.builder()
                .contentId(data.getContentId())
                .attrName(data.getAttrName())
                .attrValue(data.getAttrValue())
                .attrDescription(data.getAttrDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: contentId, attrName

-- fields --
    
    String contentId
    String attrName
    String attrValue
    String attrDescription

-- relations --
    
    - Content (one, autoRelation: false, keymaps: contentId)
    + ContentTypeAttr (many, autoRelation: false, keymaps: attrName)
*/

