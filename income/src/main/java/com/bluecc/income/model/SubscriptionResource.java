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

import com.bluecc.hubs.stub.SubscriptionResourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SubscriptionResourceData.class,
        symbol = EntityNames.SubscriptionResource)
public class SubscriptionResource implements IEventModel<SubscriptionResourceData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("subscription_resource_id")
	@RId 
    String subscriptionResourceId;
    @SerializedName("parent_resource_id") 
    String parentResourceId;
    @SerializedName("description") 
    String description;
    @SerializedName("content_id") 
    String contentId;
    @SerializedName("web_site_id") 
    String webSiteId;
    @SerializedName("service_name_on_expiry") 
    String serviceNameOnExpiry;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return subscriptionResourceId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SubscriptionResourceData.Builder toDataBuilder() {
        SubscriptionResourceData.Builder builder = SubscriptionResourceData.newBuilder();
        if (getSubscriptionResourceId() != null) {
            builder.setSubscriptionResourceId(getSubscriptionResourceId());
        }
        if (getParentResourceId() != null) {
            builder.setParentResourceId(getParentResourceId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getContentId() != null) {
            builder.setContentId(getContentId());
        }
        if (getWebSiteId() != null) {
            builder.setWebSiteId(getWebSiteId());
        }
        if (getServiceNameOnExpiry() != null) {
            builder.setServiceNameOnExpiry(getServiceNameOnExpiry());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static SubscriptionResource fromData(SubscriptionResourceData data) {
        return fromPrototype(data).build();
    }

    public static SubscriptionResource.SubscriptionResourceBuilder fromPrototype(SubscriptionResourceData data) {
        return SubscriptionResource.builder()
                .subscriptionResourceId(data.getSubscriptionResourceId())
                .parentResourceId(data.getParentResourceId())
                .description(data.getDescription())
                .contentId(data.getContentId())
                .webSiteId(data.getWebSiteId())
                .serviceNameOnExpiry(data.getServiceNameOnExpiry())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
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

