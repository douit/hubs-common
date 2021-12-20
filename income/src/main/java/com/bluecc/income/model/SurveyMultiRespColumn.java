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

import com.bluecc.hubs.stub.SurveyMultiRespColumnData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyMultiRespColumnData.class,
        symbol = EntityNames.SurveyMultiRespColumn)
public class SurveyMultiRespColumn implements IEventModel<SurveyMultiRespColumnData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_id")
	@RIndex 
    String surveyId;
    @SerializedName("survey_multi_resp_id")
	@RIndex 
    String surveyMultiRespId;
    @SerializedName("survey_multi_resp_col_id")
	@RIndex 
    String surveyMultiRespColId;
    @SerializedName("column_title") 
    String columnTitle;
    @SerializedName("sequence_num") 
    Long sequenceNum;
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

    public SurveyMultiRespColumnData.Builder toDataBuilder() {
        SurveyMultiRespColumnData.Builder builder = SurveyMultiRespColumnData.newBuilder();
        if (getSurveyId() != null) {
            builder.setSurveyId(getSurveyId());
        }
        if (getSurveyMultiRespId() != null) {
            builder.setSurveyMultiRespId(getSurveyMultiRespId());
        }
        if (getSurveyMultiRespColId() != null) {
            builder.setSurveyMultiRespColId(getSurveyMultiRespColId());
        }
        if (getColumnTitle() != null) {
            builder.setColumnTitle(getColumnTitle());
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
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

    public static SurveyMultiRespColumn fromData(SurveyMultiRespColumnData data) {
        return fromPrototype(data).build();
    }

    public static SurveyMultiRespColumn.SurveyMultiRespColumnBuilder fromPrototype(SurveyMultiRespColumnData data) {
        return SurveyMultiRespColumn.builder()
                .surveyId(data.getSurveyId())
                .surveyMultiRespId(data.getSurveyMultiRespId())
                .surveyMultiRespColId(data.getSurveyMultiRespColId())
                .columnTitle(data.getColumnTitle())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: surveyId, surveyMultiRespId, surveyMultiRespColId

-- fields --
    
    String surveyId
    String surveyMultiRespId
    String surveyMultiRespColId
    String columnTitle
    Long sequenceNum

-- relations --
    
    - SurveyMultiResp (one, autoRelation: false, keymaps: surveyId, surveyMultiRespId)
    + SurveyQuestionAppl (many, autoRelation: true, keymaps: surveyId, surveyMultiRespId, surveyMultiRespColId)
*/

