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

import com.bluecc.hubs.stub.WebSiteContentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = WebSiteContentData.class,
        symbol = EntityNames.WebSiteContent)
public class WebSiteContent implements IEventModel<WebSiteContentData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("web_site_id")
	@RIndex 
    String webSiteId;
    @SerializedName("content_id")
	@RIndex 
    String contentId;
    @SerializedName("web_site_content_type_id")
	@RIndex 
    String webSiteContentTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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


/*
-- keys: webSiteId, contentId, webSiteContentTypeId, fromDate

-- fields --
    
    String webSiteId
    String contentId
    String webSiteContentTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - WebSite (one, autoRelation: false, keymaps: webSiteId)
    - Content (one, autoRelation: false, keymaps: contentId)
    - WebSiteContentType (one, autoRelation: false, keymaps: webSiteContentTypeId)
*/

