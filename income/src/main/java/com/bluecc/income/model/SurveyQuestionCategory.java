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

import com.bluecc.hubs.stub.SurveyQuestionCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class SurveyQuestionCategory implements IEventModel<SurveyQuestionCategoryData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String surveyQuestionCategoryId;
    String parentCategoryId;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyQuestionCategoryData.Builder toDataBuilder() {
        SurveyQuestionCategoryData.Builder builder = SurveyQuestionCategoryData.newBuilder();
        if (surveyQuestionCategoryId != null) {
            builder.setSurveyQuestionCategoryId(surveyQuestionCategoryId);
        }
        if (parentCategoryId != null) {
            builder.setParentCategoryId(parentCategoryId);
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

    public static SurveyQuestionCategory fromData(SurveyQuestionCategoryData data) {
        return SurveyQuestionCategory.builder()
                .surveyQuestionCategoryId(data.getSurveyQuestionCategoryId())
                .parentCategoryId(data.getParentCategoryId())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
