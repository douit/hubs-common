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
import com.bluecc.hubs.stub.SystemPropertyData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemProperty implements IEventModel<SystemPropertyData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String systemResourceId;
    String systemPropertyId;
    String systemPropertyValue;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
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
