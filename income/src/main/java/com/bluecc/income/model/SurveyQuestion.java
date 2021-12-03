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
import com.bluecc.hubs.stub.SurveyQuestionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyQuestion implements IEventModel<SurveyQuestionData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String surveyQuestionId;
    String surveyQuestionCategoryId;
    String surveyQuestionTypeId;
    String description;
    String question;
    String hint;
    String enumTypeId;
    String geoId;
    String formatString;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyQuestionData.Builder toDataBuilder() {
        SurveyQuestionData.Builder builder = SurveyQuestionData.newBuilder();
        if (surveyQuestionId != null) {
            builder.setSurveyQuestionId(surveyQuestionId);
        }
        if (surveyQuestionCategoryId != null) {
            builder.setSurveyQuestionCategoryId(surveyQuestionCategoryId);
        }
        if (surveyQuestionTypeId != null) {
            builder.setSurveyQuestionTypeId(surveyQuestionTypeId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (question != null) {
            builder.setQuestion(question);
        }
        if (hint != null) {
            builder.setHint(hint);
        }
        if (enumTypeId != null) {
            builder.setEnumTypeId(enumTypeId);
        }
        if (geoId != null) {
            builder.setGeoId(geoId);
        }
        if (formatString != null) {
            builder.setFormatString(formatString);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static SurveyQuestion fromData(SurveyQuestionData data) {
        return SurveyQuestion.builder()
                .surveyQuestionId(data.getSurveyQuestionId())
                .surveyQuestionCategoryId(data.getSurveyQuestionCategoryId())
                .surveyQuestionTypeId(data.getSurveyQuestionTypeId())
                .description(data.getDescription())
                .question(data.getQuestion())
                .hint(data.getHint())
                .enumTypeId(data.getEnumTypeId())
                .geoId(data.getGeoId())
                .formatString(data.getFormatString())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
