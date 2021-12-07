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

import com.bluecc.hubs.stub.TenantData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class Tenant implements IEventModel<TenantData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String tenantId;
    String tenantName;
    String initialPath;
    Character disabled;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TenantData.Builder toDataBuilder() {
        TenantData.Builder builder = TenantData.newBuilder();
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
        if (tenantName != null) {
            builder.setTenantName(tenantName);
        }
        if (initialPath != null) {
            builder.setInitialPath(initialPath);
        }
        if (disabled != null) {
            builder.setDisabled(getIndicator(disabled));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Tenant fromData(TenantData data) {
        return Tenant.builder()
                .tenantId(data.getTenantId())
                .tenantName(data.getTenantName())
                .initialPath(data.getInitialPath())
                .disabled(getIndicatorChar(data.getDisabled()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
