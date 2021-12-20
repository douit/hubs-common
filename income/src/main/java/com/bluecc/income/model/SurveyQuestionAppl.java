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

import com.bluecc.hubs.stub.SurveyQuestionApplData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyQuestionApplData.class,
        symbol = EntityNames.SurveyQuestionAppl)
public class SurveyQuestionAppl implements IEventModel<SurveyQuestionApplData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_id")
	@RIndex 
    String surveyId;
    @SerializedName("survey_question_id")
	@RIndex 
    String surveyQuestionId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("survey_page_seq_id") 
    String surveyPageSeqId;
    @SerializedName("survey_multi_resp_id") 
    String surveyMultiRespId;
    @SerializedName("survey_multi_resp_col_id") 
    String surveyMultiRespColId;
    @SerializedName("required_field") 
    Character requiredField;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("external_field_ref") 
    String externalFieldRef;
    @SerializedName("with_survey_question_id") 
    String withSurveyQuestionId;
    @SerializedName("with_survey_option_seq_id") 
    String withSurveyOptionSeqId;
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

    public SurveyQuestionApplData.Builder toDataBuilder() {
        SurveyQuestionApplData.Builder builder = SurveyQuestionApplData.newBuilder();
        if (getSurveyId() != null) {
            builder.setSurveyId(getSurveyId());
        }
        if (getSurveyQuestionId() != null) {
            builder.setSurveyQuestionId(getSurveyQuestionId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getSurveyPageSeqId() != null) {
            builder.setSurveyPageSeqId(getSurveyPageSeqId());
        }
        if (getSurveyMultiRespId() != null) {
            builder.setSurveyMultiRespId(getSurveyMultiRespId());
        }
        if (getSurveyMultiRespColId() != null) {
            builder.setSurveyMultiRespColId(getSurveyMultiRespColId());
        }
        if (getRequiredField() != null) {
            builder.setRequiredField(getIndicator(getRequiredField()));
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getExternalFieldRef() != null) {
            builder.setExternalFieldRef(getExternalFieldRef());
        }
        if (getWithSurveyQuestionId() != null) {
            builder.setWithSurveyQuestionId(getWithSurveyQuestionId());
        }
        if (getWithSurveyOptionSeqId() != null) {
            builder.setWithSurveyOptionSeqId(getWithSurveyOptionSeqId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static SurveyQuestionAppl fromData(SurveyQuestionApplData data) {
        return fromPrototype(data).build();
    }

    public static SurveyQuestionAppl.SurveyQuestionApplBuilder fromPrototype(SurveyQuestionApplData data) {
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
                ;
    }

    
}


/*
-- keys: surveyId, surveyQuestionId, fromDate

-- fields --
    
    String surveyId
    String surveyQuestionId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String surveyPageSeqId
    String surveyMultiRespId
    String surveyMultiRespColId
    Character requiredField
    Long sequenceNum
    String externalFieldRef
    String withSurveyQuestionId
    String withSurveyOptionSeqId

-- relations --
    
    - Survey (one, autoRelation: false, keymaps: surveyId)
    - SurveyQuestion (one, autoRelation: false, keymaps: surveyQuestionId)
    - WithSurveyQuestionOption (one, autoRelation: false, keymaps: withSurveyQuestionId -> surveyQuestionId, withSurveyOptionSeqId -> surveyOptionSeqId)
    - SurveyPage (one-nofk, autoRelation: false, keymaps: surveyId, surveyPageSeqId)
    - SurveyMultiResp (one-nofk, autoRelation: false, keymaps: surveyId, surveyMultiRespId)
    - SurveyMultiRespColumn (one-nofk, autoRelation: false, keymaps: surveyId, surveyMultiRespId, surveyMultiRespColId)
*/

