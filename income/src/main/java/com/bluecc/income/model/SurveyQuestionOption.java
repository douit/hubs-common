//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.SurveyQuestionOptionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyQuestionOptionData.class,
        symbol = EntityNames.SurveyQuestionOption)
public class SurveyQuestionOption implements IEventModel<SurveyQuestionOptionData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_question_id")
	@RIndex 
    String surveyQuestionId;
    @SerializedName("survey_option_seq_id")
	@RIndex 
    String surveyOptionSeqId;
    @SerializedName("description") 
    String description;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("amount_base") 
    java.math.BigDecimal amountBase;
    @SerializedName("amount_base_uom_id") 
    String amountBaseUomId;
    @SerializedName("weight_factor") 
    Double weightFactor;
    @SerializedName("duration") 
    Long duration;
    @SerializedName("duration_uom_id") 
    String durationUomId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
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


/*
-- keys: surveyQuestionId, surveyOptionSeqId

-- fields --
    
    String surveyQuestionId
    String surveyOptionSeqId
    String description
    Long sequenceNum
    java.math.BigDecimal amountBase
    String amountBaseUomId
    Double weightFactor
    Long duration
    String durationUomId

-- relations --
    
    - SurveyQuestion (one, autoRelation: false, keymaps: surveyQuestionId)
    + WithSurveyQuestionAppl (many, autoRelation: true, keymaps: surveyQuestionId -> withSurveyQuestionId, surveyOptionSeqId -> withSurveyOptionSeqId)
    + SurveyResponseAnswer (many, autoRelation: true, keymaps: surveyQuestionId, surveyOptionSeqId)
*/

