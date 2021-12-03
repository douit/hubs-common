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
import com.bluecc.hubs.stub.ContentAttributeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentAttribute implements IEventModel<ContentAttributeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String contentId;
    String attrName;
    String attrValue;
    String attrDescription;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
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
