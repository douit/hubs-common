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
import com.bluecc.hubs.stub.CustRequestTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustRequestType implements IEventModel<CustRequestTypeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String custRequestTypeId;
    String parentTypeId;
    Character hasTable;
    String description;
    String partyId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CustRequestTypeData.Builder toDataBuilder() {
        CustRequestTypeData.Builder builder = CustRequestTypeData.newBuilder();
        if (custRequestTypeId != null) {
            builder.setCustRequestTypeId(custRequestTypeId);
        }
        if (parentTypeId != null) {
            builder.setParentTypeId(parentTypeId);
        }
        if (hasTable != null) {
            builder.setHasTable(getIndicator(hasTable));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static CustRequestType fromData(CustRequestTypeData data) {
        return CustRequestType.builder()
                .custRequestTypeId(data.getCustRequestTypeId())
                .parentTypeId(data.getParentTypeId())
                .hasTable(getIndicatorChar(data.getHasTable()))
                .description(data.getDescription())
                .partyId(data.getPartyId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
