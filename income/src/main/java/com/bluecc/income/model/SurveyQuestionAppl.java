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

import com.bluecc.hubs.stub.SurveyQuestionApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class SurveyQuestionAppl implements IEventModel<SurveyQuestionApplData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String surveyId;
    @RIndex String surveyQuestionId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String surveyPageSeqId;
    String surveyMultiRespId;
    String surveyMultiRespColId;
    Character requiredField;
    Long sequenceNum;
    String externalFieldRef;
    String withSurveyQuestionId;
    String withSurveyOptionSeqId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyQuestionApplData.Builder toDataBuilder() {
        SurveyQuestionApplData.Builder builder = SurveyQuestionApplData.newBuilder();
        if (surveyId != null) {
            builder.setSurveyId(surveyId);
        }
        if (surveyQuestionId != null) {
            builder.setSurveyQuestionId(surveyQuestionId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (surveyPageSeqId != null) {
            builder.setSurveyPageSeqId(surveyPageSeqId);
        }
        if (surveyMultiRespId != null) {
            builder.setSurveyMultiRespId(surveyMultiRespId);
        }
        if (surveyMultiRespColId != null) {
            builder.setSurveyMultiRespColId(surveyMultiRespColId);
        }
        if (requiredField != null) {
            builder.setRequiredField(getIndicator(requiredField));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (externalFieldRef != null) {
            builder.setExternalFieldRef(externalFieldRef);
        }
        if (withSurveyQuestionId != null) {
            builder.setWithSurveyQuestionId(withSurveyQuestionId);
        }
        if (withSurveyOptionSeqId != null) {
            builder.setWithSurveyOptionSeqId(withSurveyOptionSeqId);
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

    public static SurveyQuestionAppl fromData(SurveyQuestionApplData data) {
        return SurveyQuestionAppl.builder()
                .surveyId(data.getSurveyId())
                .surveyQuestionId(data.getSurveyQuestionId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .surveyPageSeqId(data.getSurveyPageSeqId())
                .surveyMultiRespId(data.getSurveyMultiRespId())
                .surveyMultiRespColId(data.getSurveyMultiRespColId())
                .requiredField(getIndicatorChar(data.getRequiredField()))
                .sequenceNum(data.getSequenceNum())
                .externalFieldRef(data.getExternalFieldRef())
                .withSurveyQuestionId(data.getWithSurveyQuestionId())
                .withSurveyOptionSeqId(data.getWithSurveyOptionSeqId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
