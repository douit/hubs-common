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

import com.bluecc.hubs.stub.SystemPropertyData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SystemPropertyData.class,
        symbol = EntityNames.SystemProperty)
public class SystemProperty implements IEventModel<SystemPropertyData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("system_resource_id")
	@RIndex 
    String systemResourceId;
    @SerializedName("system_property_id")
	@RIndex 
    String systemPropertyId;
    @SerializedName("system_property_value") 
    String systemPropertyValue;
    @SerializedName("description") 
    String description;
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

    public SystemPropertyData.Builder toDataBuilder() {
        SystemPropertyData.Builder builder = SystemPropertyData.newBuilder();
        if (systemResourceId != null) {
            builder.setSystemResourceId(systemResourceId);
        }
        if (systemPropertyId != null) {
            builder.setSystemPropertyId(systemPropertyId);
        }
        if (systemPropertyValue != null) {
            builder.setSystemPropertyValue(systemPropertyValue);
        }
        if (description != null) {
            builder.setDescription(description);
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

    public static SystemProperty fromData(SystemPropertyData data) {
        return SystemProperty.builder()
                .systemResourceId(data.getSystemResourceId())
                .systemPropertyId(data.getSystemPropertyId())
                .systemPropertyValue(data.getSystemPropertyValue())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: systemResourceId, systemPropertyId

-- fields --
    
    String systemResourceId
    String systemPropertyId
    String systemPropertyValue
    String description

-- relations --
    
*/

