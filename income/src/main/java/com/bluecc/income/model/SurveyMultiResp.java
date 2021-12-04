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
import com.bluecc.hubs.stub.SurveyMultiRespData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyMultiResp implements IEventModel<SurveyMultiRespData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String surveyId;
    String surveyMultiRespId;
    String multiRespTitle;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyMultiRespData.Builder toDataBuilder() {
        SurveyMultiRespData.Builder builder = SurveyMultiRespData.newBuilder();
        if (surveyId != null) {
            builder.setSurveyId(surveyId);
        }
        if (surveyMultiRespId != null) {
            builder.setSurveyMultiRespId(surveyMultiRespId);
        }
        if (multiRespTitle != null) {
            builder.setMultiRespTitle(multiRespTitle);
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

    public static SurveyMultiResp fromData(SurveyMultiRespData data) {
        return SurveyMultiResp.builder()
                .surveyId(data.getSurveyId())
                .surveyMultiRespId(data.getSurveyMultiRespId())
                .multiRespTitle(data.getMultiRespTitle())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}