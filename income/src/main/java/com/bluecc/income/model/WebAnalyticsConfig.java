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

import com.bluecc.hubs.stub.WebAnalyticsConfigData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WebAnalyticsConfigData.class,
        symbol = EntityNames.WebAnalyticsConfig)
public class WebAnalyticsConfig implements IEventModel<WebAnalyticsConfigData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("web_site_id")
	@RIndex 
    String webSiteId;
    @SerializedName("web_analytics_type_id")
	@RIndex 
    String webAnalyticsTypeId;
    @SerializedName("web_analytics_code") 
    String webAnalyticsCode;
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

    public WebAnalyticsConfigData.Builder toDataBuilder() {
        WebAnalyticsConfigData.Builder builder = WebAnalyticsConfigData.newBuilder();
        if (getWebSiteId() != null) {
            builder.setWebSiteId(getWebSiteId());
        }
        if (getWebAnalyticsTypeId() != null) {
            builder.setWebAnalyticsTypeId(getWebAnalyticsTypeId());
        }
        if (getWebAnalyticsCode() != null) {
            builder.setWebAnalyticsCode(getWebAnalyticsCode());
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

    public static WebAnalyticsConfig fromData(WebAnalyticsConfigData data) {
        return fromPrototype(data).build();
    }

    public static WebAnalyticsConfig.WebAnalyticsConfigBuilder fromPrototype(WebAnalyticsConfigData data) {
        return WebAnalyticsConfig.builder()
                .webSiteId(data.getWebSiteId())
                .webAnalyticsTypeId(data.getWebAnalyticsTypeId())
                .webAnalyticsCode(data.getWebAnalyticsCode())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: webSiteId, webAnalyticsTypeId

-- fields --
    
    String webSiteId
    String webAnalyticsTypeId
    String webAnalyticsCode

-- relations --
    
    - WebAnalyticsType (one-nofk, autoRelation: false, keymaps: webAnalyticsTypeId)
    - WebSite (one-nofk, autoRelation: false, keymaps: webSiteId)
*/

