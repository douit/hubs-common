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

import com.bluecc.hubs.stub.WebSiteContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class WebSiteContent implements IEventModel<WebSiteContentData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String webSiteId;
    @RIndex String contentId;
    @RIndex String webSiteContentTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WebSiteContentData.Builder toDataBuilder() {
        WebSiteContentData.Builder builder = WebSiteContentData.newBuilder();
        if (webSiteId != null) {
            builder.setWebSiteId(webSiteId);
        }
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (webSiteContentTypeId != null) {
            builder.setWebSiteContentTypeId(webSiteContentTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
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

    public static WebSiteContent fromData(WebSiteContentData data) {
        return WebSiteContent.builder()
                .webSiteId(data.getWebSiteId())
                .contentId(data.getContentId())
                .webSiteContentTypeId(data.getWebSiteContentTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
