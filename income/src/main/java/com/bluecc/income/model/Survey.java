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
public class Survey implements IEventModel<SurveyData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String surveyId;
    String surveyName;
    String description;
    String comments;
    String submitCaption;
    String responseService;
    Character isAnonymous;
    Character allowMultiple;
    Character allowUpdate;
    String acroFormContentId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyData.Builder toDataBuilder() {
        SurveyData.Builder builder = SurveyData.newBuilder();
        if (surveyId != null) {
            builder.setSurveyId(surveyId);
        }
        if (surveyName != null) {
            builder.setSurveyName(surveyName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (submitCaption != null) {
            builder.setSubmitCaption(submitCaption);
        }
        if (responseService != null) {
            builder.setResponseService(responseService);
        }
        if (isAnonymous != null) {
            builder.setIsAnonymous(getIndicator(isAnonymous));
        }
        if (allowMultiple != null) {
            builder.setAllowMultiple(getIndicator(allowMultiple));
        }
        if (allowUpdate != null) {
            builder.setAllowUpdate(getIndicator(allowUpdate));
        }
        if (acroFormContentId != null) {
            builder.setAcroFormContentId(acroFormContentId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Survey fromData(SurveyData data) {
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
                
                .build();
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

