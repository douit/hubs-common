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

import com.bluecc.hubs.stub.TenantData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TenantData.class,
        symbol = EntityNames.Tenant)
public class Tenant implements IEventModel<TenantData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("tenant_id")
	@RId 
    String tenantId;
    @SerializedName("tenant_name") 
    String tenantName;
    @SerializedName("initial_path") 
    String initialPath;
    @SerializedName("disabled") 
    Character disabled;
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
        return tenantId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TenantData.Builder toDataBuilder() {
        TenantData.Builder builder = TenantData.newBuilder();
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
        if (getTenantName() != null) {
            builder.setTenantName(getTenantName());
        }
        if (getInitialPath() != null) {
            builder.setInitialPath(getInitialPath());
        }
        if (getDisabled() != null) {
            builder.setDisabled(getIndicator(getDisabled()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static Tenant fromData(TenantData data) {
        return fromPrototype(data).build();
    }

    public static Tenant.TenantBuilder fromPrototype(TenantData data) {
        return Tenant.builder()
                .tenantId(data.getTenantId())
                .tenantName(data.getTenantName())
                .initialPath(data.getInitialPath())
                .disabled(getIndicatorChar(data.getDisabled()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: tenantId

-- fields --
    
    String tenantId
    String tenantName
    String initialPath
    Character disabled

-- relations --
    
    + TenantComponent (many, autoRelation: true, keymaps: tenantId)
    + TenantDataSource (many, autoRelation: true, keymaps: tenantId)
    + TenantDomainName (many, autoRelation: true, keymaps: tenantId)
    - TenantKeyEncryptingKey (one-nofk, autoRelation: true, keymaps: tenantId)
*/

