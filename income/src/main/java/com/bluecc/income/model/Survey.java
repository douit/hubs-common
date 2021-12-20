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

import com.bluecc.hubs.stub.SurveyData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyData.class,
        symbol = EntityNames.Survey)
public class Survey implements IEventModel<SurveyData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_id")
	@RId 
    String surveyId;
    @SerializedName("survey_name") 
    String surveyName;
    @SerializedName("description") 
    String description;
    @SerializedName("comments") 
    String comments;
    @SerializedName("submit_caption") 
    String submitCaption;
    @SerializedName("response_service") 
    String responseService;
    @SerializedName("is_anonymous") 
    Character isAnonymous;
    @SerializedName("allow_multiple") 
    Character allowMultiple;
    @SerializedName("allow_update") 
    Character allowUpdate;
    @SerializedName("acro_form_content_id") 
    String acroFormContentId;
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
        return surveyId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyData.Builder toDataBuilder() {
        SurveyData.Builder builder = SurveyData.newBuilder();
        if (getSurveyId() != null) {
            builder.setSurveyId(getSurveyId());
        }
        if (getSurveyName() != null) {
            builder.setSurveyName(getSurveyName());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getSubmitCaption() != null) {
            builder.setSubmitCaption(getSubmitCaption());
        }
        if (getResponseService() != null) {
            builder.setResponseService(getResponseService());
        }
        if (getIsAnonymous() != null) {
            builder.setIsAnonymous(getIndicator(getIsAnonymous()));
        }
        if (getAllowMultiple() != null) {
            builder.setAllowMultiple(getIndicator(getAllowMultiple()));
        }
        if (getAllowUpdate() != null) {
            builder.setAllowUpdate(getIndicator(getAllowUpdate()));
        }
        if (getAcroFormContentId() != null) {
            builder.setAcroFormContentId(getAcroFormContentId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static Survey fromData(SurveyData data) {
        return fromPrototype(data).build();
    }

    public static Survey.SurveyBuilder fromPrototype(SurveyData data) {
        return Survey.builder()
                .surveyId(data.getSurveyId())
                .surveyName(data.getSurveyName())
                .description(data.getDescription())
                .comments(data.getComments())
                .submitCaption(data.getSubmitCaption())
                .responseService(data.getResponseService())
                .isAnonymous(getIndicatorChar(data.getIsAnonymous()))
                .allowMultiple(getIndicatorChar(data.getAllowMultiple()))
                .allowUpdate(getIndicatorChar(data.getAllowUpdate()))
                .acroFormContentId(data.getAcroFormContentId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: surveyId

-- fields --
    
    String surveyId
    String surveyName
    String description
    String comments
    String submitCaption
    String responseService
    Character isAnonymous
    Character allowMultiple
    Character allowUpdate
    String acroFormContentId

-- relations --
    
    + DataResource (many, autoRelation: true, keymaps: surveyId)
    + ProductStoreFinActSetting (many, autoRelation: true, keymaps: surveyId -> purchaseSurveyId)
    + ProductStoreSurveyAppl (many, autoRelation: true, keymaps: surveyId)
    + SurveyMultiResp (many, autoRelation: true, keymaps: surveyId)
    + SurveyPage (many, autoRelation: true, keymaps: surveyId)
    + SurveyQuestionAppl (many, autoRelation: true, keymaps: surveyId)
    + SurveyResponse (many, autoRelation: true, keymaps: surveyId)
    + SurveyTrigger (many, autoRelation: true, keymaps: surveyId)
    + WorkEffortSurveyAppl (many, autoRelation: true, keymaps: surveyId)
*/

