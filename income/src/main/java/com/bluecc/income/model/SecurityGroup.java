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
import com.bluecc.hubs.stub.SecurityGroupData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SecurityGroup implements IEventModel<SecurityGroupData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String groupId;
    String groupName;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SecurityGroupData.Builder toDataBuilder() {
        SecurityGroupData.Builder builder = SecurityGroupData.newBuilder();
        if (groupId != null) {
            builder.setGroupId(groupId);
        }
        if (groupName != null) {
            builder.setGroupName(groupName);
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
                    
        return builder;
    }

    public static SecurityGroup fromData(SecurityGroupData data) {
        return SecurityGroup.builder()
                .groupId(data.getGroupId())
                .groupName(data.getGroupName())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}