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
import com.bluecc.hubs.stub.WebAnalyticsConfigData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebAnalyticsConfig implements IEventModel<WebAnalyticsConfigData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String webSiteId;
    String webAnalyticsTypeId;
    String webAnalyticsCode;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public WebAnalyticsConfigData.Builder toDataBuilder() {
        WebAnalyticsConfigData.Builder builder = WebAnalyticsConfigData.newBuilder();
        if (webSiteId != null) {
            builder.setWebSiteId(webSiteId);
        }
        if (webAnalyticsTypeId != null) {
            builder.setWebAnalyticsTypeId(webAnalyticsTypeId);
        }
        if (webAnalyticsCode != null) {
            builder.setWebAnalyticsCode(webAnalyticsCode);
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

    public static WebAnalyticsConfig fromData(WebAnalyticsConfigData data) {
        return WebAnalyticsConfig.builder()
                .webSiteId(data.getWebSiteId())
                .webAnalyticsTypeId(data.getWebAnalyticsTypeId())
                .webAnalyticsCode(data.getWebAnalyticsCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}