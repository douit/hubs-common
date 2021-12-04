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
import com.bluecc.hubs.stub.SurveyQuestionOptionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyQuestionOption implements IEventModel<SurveyQuestionOptionData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String surveyQuestionId;
    String surveyOptionSeqId;
    String description;
    Long sequenceNum;
    java.math.BigDecimal amountBase;
    String amountBaseUomId;
    Double weightFactor;
    Long duration;
    String durationUomId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyQuestionOptionData.Builder toDataBuilder() {
        SurveyQuestionOptionData.Builder builder = SurveyQuestionOptionData.newBuilder();
        if (surveyQuestionId != null) {
            builder.setSurveyQuestionId(surveyQuestionId);
        }
        if (surveyOptionSeqId != null) {
            builder.setSurveyOptionSeqId(surveyOptionSeqId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (amountBase != null) {
            builder.setAmountBase(getCurrency(amountBase));
        }
        if (amountBaseUomId != null) {
            builder.setAmountBaseUomId(amountBaseUomId);
        }
        if (weightFactor != null) {
            builder.setWeightFactor(weightFactor);
        }
        if (duration != null) {
            builder.setDuration(duration);
        }
        if (durationUomId != null) {
            builder.setDurationUomId(durationUomId);
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

    public static SurveyQuestionOption fromData(SurveyQuestionOptionData data) {
        return SurveyQuestionOption.builder()
                .surveyQuestionId(data.getSurveyQuestionId())
                .surveyOptionSeqId(data.getSurveyOptionSeqId())
                .description(data.getDescription())
                .sequenceNum(data.getSequenceNum())
                .amountBase(getBigDecimal(data.getAmountBase()))
                .amountBaseUomId(data.getAmountBaseUomId())
                .weightFactor(data.getWeightFactor())
                .duration(data.getDuration())
                .durationUomId(data.getDurationUomId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}