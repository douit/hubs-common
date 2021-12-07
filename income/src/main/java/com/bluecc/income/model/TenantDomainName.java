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

import com.bluecc.hubs.stub.TenantDomainNameData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class TenantDomainName implements IEventModel<TenantDomainNameData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String tenantId;
    @RIndex String domainName;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TenantDomainNameData.Builder toDataBuilder() {
        TenantDomainNameData.Builder builder = TenantDomainNameData.newBuilder();
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
        if (domainName != null) {
            builder.setDomainName(domainName);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static TenantDomainName fromData(TenantDomainNameData data) {
        return TenantDomainName.builder()
                .tenantId(data.getTenantId())
                .domainName(data.getDomainName())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
