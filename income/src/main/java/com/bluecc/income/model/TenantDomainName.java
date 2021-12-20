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

import com.bluecc.hubs.stub.TenantDomainNameData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TenantDomainNameData.class,
        symbol = EntityNames.TenantDomainName)
public class TenantDomainName implements IEventModel<TenantDomainNameData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("tenant_id") 
    String tenantId;
    @SerializedName("domain_name")
	@RId 
    String domainName;
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
        return domainName;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TenantDomainNameData.Builder toDataBuilder() {
        TenantDomainNameData.Builder builder = TenantDomainNameData.newBuilder();
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
        if (getDomainName() != null) {
            builder.setDomainName(getDomainName());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static TenantDomainName fromData(TenantDomainNameData data) {
        return fromPrototype(data).build();
    }

    public static TenantDomainName.TenantDomainNameBuilder fromPrototype(TenantDomainNameData data) {
        return TenantDomainName.builder()
                .tenantId(data.getTenantId())
                .domainName(data.getDomainName())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: domainName

-- fields --
    
    String tenantId
    String domainName

-- relations --
    
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

