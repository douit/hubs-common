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

import com.bluecc.hubs.stub.SubscriptionResourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SubscriptionResourceData.class,
        symbol = EntityNames.SubscriptionResource)
public class SubscriptionResource implements IEventModel<SubscriptionResourceData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String subscriptionResourceId;
    String parentResourceId;
    String description;
    String contentId;
    String webSiteId;
    String serviceNameOnExpiry;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SubscriptionResourceData.Builder toDataBuilder() {
        SubscriptionResourceData.Builder builder = SubscriptionResourceData.newBuilder();
        if (subscriptionResourceId != null) {
            builder.setSubscriptionResourceId(subscriptionResourceId);
        }
        if (parentResourceId != null) {
            builder.setParentResourceId(parentResourceId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (contentId != null) {
            builder.setContentId(contentId);
        }
        if (webSiteId != null) {
            builder.setWebSiteId(webSiteId);
        }
        if (serviceNameOnExpiry != null) {
            builder.setServiceNameOnExpiry(serviceNameOnExpiry);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static SubscriptionResource fromData(SubscriptionResourceData data) {
        return SubscriptionResource.builder()
                .subscriptionResourceId(data.getSubscriptionResourceId())
                .parentResourceId(data.getParentResourceId())
                .description(data.getDescription())
                .contentId(data.getContentId())
                .webSiteId(data.getWebSiteId())
                .serviceNameOnExpiry(data.getServiceNameOnExpiry())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: subscriptionResourceId

-- fields --
    
    String subscriptionResourceId
    String parentResourceId
    String description
    String contentId
    String webSiteId
    String serviceNameOnExpiry

-- relations --
    
    - ParentSubscriptionResource (one, autoRelation: false, keymaps: parentResourceId -> subscriptionResourceId)
    - Content (one, autoRelation: false, keymaps: contentId)
    - WebSite (one, autoRelation: false, keymaps: webSiteId)
    + ProductSubscriptionResource (many, autoRelation: true, keymaps: subscriptionResourceId)
    + Subscription (many, autoRelation: true, keymaps: subscriptionResourceId)
    + ChildSubscriptionResource (many, autoRelation: true, keymaps: subscriptionResourceId -> parentResourceId)
*/

