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

import com.bluecc.hubs.stub.SurveyApplTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class SurveyApplType implements IEventModel<SurveyApplTypeData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String surveyApplTypeId;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyApplTypeData.Builder toDataBuilder() {
        SurveyApplTypeData.Builder builder = SurveyApplTypeData.newBuilder();
        if (surveyApplTypeId != null) {
            builder.setSurveyApplTypeId(surveyApplTypeId);
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

    public static SurveyApplType fromData(SurveyApplTypeData data) {
        return SurveyApplType.builder()
                .surveyApplTypeId(data.getSurveyApplTypeId())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
