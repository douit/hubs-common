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

import com.bluecc.hubs.stub.SurveyMultiRespColumnData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyMultiRespColumnData.class,
        symbol = EntityNames.SurveyMultiRespColumn)
public class SurveyMultiRespColumn implements IEventModel<SurveyMultiRespColumnData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String surveyId;
    @RIndex String surveyMultiRespId;
    @RIndex String surveyMultiRespColId;
    String columnTitle;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyMultiRespColumnData.Builder toDataBuilder() {
        SurveyMultiRespColumnData.Builder builder = SurveyMultiRespColumnData.newBuilder();
        if (surveyId != null) {
            builder.setSurveyId(surveyId);
        }
        if (surveyMultiRespId != null) {
            builder.setSurveyMultiRespId(surveyMultiRespId);
        }
        if (surveyMultiRespColId != null) {
            builder.setSurveyMultiRespColId(surveyMultiRespColId);
        }
        if (columnTitle != null) {
            builder.setColumnTitle(columnTitle);
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
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

    public static SurveyMultiRespColumn fromData(SurveyMultiRespColumnData data) {
        return SurveyMultiRespColumn.builder()
                .surveyId(data.getSurveyId())
                .surveyMultiRespId(data.getSurveyMultiRespId())
                .surveyMultiRespColId(data.getSurveyMultiRespColId())
                .columnTitle(data.getColumnTitle())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
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

