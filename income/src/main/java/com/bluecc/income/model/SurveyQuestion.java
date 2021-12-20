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

import com.bluecc.hubs.stub.SurveyQuestionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyQuestionData.class,
        symbol = EntityNames.SurveyQuestion)
public class SurveyQuestion implements IEventModel<SurveyQuestionData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_question_id")
	@RId 
    String surveyQuestionId;
    @SerializedName("survey_question_category_id") 
    String surveyQuestionCategoryId;
    @SerializedName("survey_question_type_id") 
    String surveyQuestionTypeId;
    @SerializedName("description") 
    String description;
    @SerializedName("question") 
    String question;
    @SerializedName("hint") 
    String hint;
    @SerializedName("enum_type_id") 
    String enumTypeId;
    @SerializedName("geo_id") 
    String geoId;
    @SerializedName("format_string") 
    String formatString;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return surveyQuestionId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyQuestionData.Builder toDataBuilder() {
        SurveyQuestionData.Builder builder = SurveyQuestionData.newBuilder();
        if (getSurveyQuestionId() != null) {
            builder.setSurveyQuestionId(getSurveyQuestionId());
        }
        if (getSurveyQuestionCategoryId() != null) {
            builder.setSurveyQuestionCategoryId(getSurveyQuestionCategoryId());
        }
        if (getSurveyQuestionTypeId() != null) {
            builder.setSurveyQuestionTypeId(getSurveyQuestionTypeId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getQuestion() != null) {
            builder.setQuestion(getQuestion());
        }
        if (getHint() != null) {
            builder.setHint(getHint());
        }
        if (getEnumTypeId() != null) {
            builder.setEnumTypeId(getEnumTypeId());
        }
        if (getGeoId() != null) {
            builder.setGeoId(getGeoId());
        }
        if (getFormatString() != null) {
            builder.setFormatString(getFormatString());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static SurveyQuestion fromData(SurveyQuestionData data) {
        return fromPrototype(data).build();
    }

    public static SurveyQuestion.SurveyQuestionBuilder fromPrototype(SurveyQuestionData data) {
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
                ;
    }

    
}


/*
-- keys: surveyQuestionId

-- fields --
    
    String surveyQuestionId
    String surveyQuestionCategoryId
    String surveyQuestionTypeId
    String description
    String question
    String hint
    String enumTypeId
    String geoId
    String formatString

-- relations --
    
    - SurveyQuestionType (one, autoRelation: false, keymaps: surveyQuestionTypeId)
    - SurveyQuestionCategory (one, autoRelation: false, keymaps: surveyQuestionCategoryId)
    - Geo (one, autoRelation: false, keymaps: geoId)
    + Enumeration (many, autoRelation: false, keymaps: enumTypeId)
    + SurveyQuestionAppl (many, autoRelation: true, keymaps: surveyQuestionId)
    + SurveyQuestionOption (many, autoRelation: true, keymaps: surveyQuestionId)
    + SurveyResponseAnswer (many, autoRelation: true, keymaps: surveyQuestionId)
*/

