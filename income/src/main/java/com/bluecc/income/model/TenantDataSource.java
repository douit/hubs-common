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

import com.bluecc.hubs.stub.TenantDataSourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TenantDataSourceData.class,
        symbol = EntityNames.TenantDataSource)
public class TenantDataSource implements IEventModel<TenantDataSourceData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("tenant_id")
	@RIndex 
    String tenantId;
    @SerializedName("entity_group_name")
	@RIndex 
    String entityGroupName;
    @SerializedName("jdbc_uri") 
    String jdbcUri;
    @SerializedName("jdbc_username") 
    String jdbcUsername;
    @SerializedName("jdbc_password") 
    String jdbcPassword;
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

    public TenantDataSourceData.Builder toDataBuilder() {
        TenantDataSourceData.Builder builder = TenantDataSourceData.newBuilder();
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
        if (entityGroupName != null) {
            builder.setEntityGroupName(entityGroupName);
        }
        if (jdbcUri != null) {
            builder.setJdbcUri(jdbcUri);
        }
        if (jdbcUsername != null) {
            builder.setJdbcUsername(jdbcUsername);
        }
        if (jdbcPassword != null) {
            builder.setJdbcPassword(jdbcPassword);
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

    public static TenantDataSource fromData(TenantDataSourceData data) {
        return TenantDataSource.builder()
                .tenantId(data.getTenantId())
                .entityGroupName(data.getEntityGroupName())
                .jdbcUri(data.getJdbcUri())
                .jdbcUsername(data.getJdbcUsername())
                .jdbcPassword(data.getJdbcPassword())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: tenantId, entityGroupName

-- fields --
    
    String tenantId
    String entityGroupName
    String jdbcUri
    String jdbcUsername
    String jdbcPassword

-- relations --
    
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

