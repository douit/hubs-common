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

import com.bluecc.hubs.stub.SurveyMultiRespData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyMultiRespData.class,
        symbol = EntityNames.SurveyMultiResp)
public class SurveyMultiResp implements IEventModel<SurveyMultiRespData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_id")
	@RIndex 
    String surveyId;
    @SerializedName("survey_multi_resp_id")
	@RIndex 
    String surveyMultiRespId;
    @SerializedName("multi_resp_title") 
    String multiRespTitle;
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

    public SurveyMultiRespData.Builder toDataBuilder() {
        SurveyMultiRespData.Builder builder = SurveyMultiRespData.newBuilder();
        if (surveyId != null) {
            builder.setSurveyId(surveyId);
        }
        if (surveyMultiRespId != null) {
            builder.setSurveyMultiRespId(surveyMultiRespId);
        }
        if (multiRespTitle != null) {
            builder.setMultiRespTitle(multiRespTitle);
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

    public static SurveyMultiResp fromData(SurveyMultiRespData data) {
        return SurveyMultiResp.builder()
                .surveyId(data.getSurveyId())
                .surveyMultiRespId(data.getSurveyMultiRespId())
                .multiRespTitle(data.getMultiRespTitle())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: surveyId, surveyMultiRespId

-- fields --
    
    String surveyId
    String surveyMultiRespId
    String multiRespTitle

-- relations --
    
    - Survey (one, autoRelation: false, keymaps: surveyId)
    + SurveyMultiRespColumn (many, autoRelation: true, keymaps: surveyId, surveyMultiRespId)
    + SurveyQuestionAppl (many, autoRelation: true, keymaps: surveyId, surveyMultiRespId)
*/

