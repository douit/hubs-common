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

import com.bluecc.hubs.stub.ContentAttributeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ContentAttributeData.class,
        symbol = EntityNames.ContentAttribute)
public class ContentAttribute implements IEventModel<ContentAttributeData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("content_id")
	@RIndex 
    String contentId;
    @SerializedName("attr_name")
	@RIndex 
    String attrName;
    @SerializedName("attr_value") 
    String attrValue;
    @SerializedName("attr_description") 
    String attrDescription;
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

    public ContentAttributeData.Builder toDataBuilder() {
        ContentAttributeData.Builder builder = ContentAttributeData.newBuilder();
        if (getContentId() != null) {
            builder.setContentId(getContentId());
        }
        if (getAttrName() != null) {
            builder.setAttrName(getAttrName());
        }
        if (getAttrValue() != null) {
            builder.setAttrValue(getAttrValue());
        }
        if (getAttrDescription() != null) {
            builder.setAttrDescription(getAttrDescription());
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

    public static ContentAttribute fromData(ContentAttributeData data) {
        return fromPrototype(data).build();
    }

    public static ContentAttribute.ContentAttributeBuilder fromPrototype(ContentAttributeData data) {
        return ContentAttribute.builder()
                .contentId(data.getContentId())
                .attrName(data.getAttrName())
                .attrValue(data.getAttrValue())
                .attrDescription(data.getAttrDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
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

