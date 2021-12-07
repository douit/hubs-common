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

import com.bluecc.hubs.stub.TenantDataSourceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class TenantDataSource implements IEventModel<TenantDataSourceData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String tenantId;
    @RIndex String entityGroupName;
    String jdbcUri;
    String jdbcUsername;
    String jdbcPassword;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
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
