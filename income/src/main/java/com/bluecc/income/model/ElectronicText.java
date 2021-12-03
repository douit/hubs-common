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
import com.bluecc.hubs.stub.ElectronicTextData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElectronicText implements IEventModel<ElectronicTextData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String dataResourceId;
    String textData;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ElectronicTextData.Builder toDataBuilder() {
        ElectronicTextData.Builder builder = ElectronicTextData.newBuilder();
        if (dataResourceId != null) {
            builder.setDataResourceId(dataResourceId);
        }
        if (textData != null) {
            builder.setTextData(textData);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ElectronicText fromData(ElectronicTextData data) {
        return ElectronicText.builder()
                .dataResourceId(data.getDataResourceId())
                .textData(data.getTextData())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
