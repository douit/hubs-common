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

import com.bluecc.hubs.stub.SubscriptionResourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class SubscriptionResource implements IEventModel<SubscriptionResourceData.Builder>, Serializable {
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
