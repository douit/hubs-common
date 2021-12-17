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

import com.bluecc.hubs.stub.SurveyQuestionCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyQuestionCategoryData.class,
        symbol = EntityNames.SurveyQuestionCategory)
public class SurveyQuestionCategory implements IEventModel<SurveyQuestionCategoryData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_question_category_id")
	@RId 
    String surveyQuestionCategoryId;
    @SerializedName("parent_category_id") 
    String parentCategoryId;
    @SerializedName("description") 
    String description;
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
        return surveyQuestionCategoryId;
    }

        
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


/*
-- keys: surveyQuestionCategoryId

-- fields --
    
    String surveyQuestionCategoryId
    String parentCategoryId
    String description

-- relations --
    
    - ParentSurveyQuestionCategory (one, autoRelation: false, keymaps: parentCategoryId -> surveyQuestionCategoryId)
    + SurveyQuestion (many, autoRelation: true, keymaps: surveyQuestionCategoryId)
    + ChildSurveyQuestionCategory (many, autoRelation: true, keymaps: surveyQuestionCategoryId -> parentCategoryId)
*/

