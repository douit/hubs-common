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

import com.bluecc.hubs.stub.SurveyPageData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyPageData.class,
        symbol = EntityNames.SurveyPage)
public class SurveyPage implements IEventModel<SurveyPageData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_id")
	@RIndex 
    String surveyId;
    @SerializedName("survey_page_seq_id")
	@RIndex 
    String surveyPageSeqId;
    @SerializedName("page_name") 
    String pageName;
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

    public SurveyPageData.Builder toDataBuilder() {
        SurveyPageData.Builder builder = SurveyPageData.newBuilder();
        if (surveyId != null) {
            builder.setSurveyId(surveyId);
        }
        if (surveyPageSeqId != null) {
            builder.setSurveyPageSeqId(surveyPageSeqId);
        }
        if (pageName != null) {
            builder.setPageName(pageName);
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

    public static SurveyPage fromData(SurveyPageData data) {
        return SurveyPage.builder()
                .surveyId(data.getSurveyId())
                .surveyPageSeqId(data.getSurveyPageSeqId())
                .pageName(data.getPageName())
                .sequenceNum(data.getSequenceNum())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: surveyId, surveyPageSeqId

-- fields --
    
    String surveyId
    String surveyPageSeqId
    String pageName
    Long sequenceNum

-- relations --
    
    - Survey (one, autoRelation: false, keymaps: surveyId)
    + SurveyQuestionAppl (many, autoRelation: true, keymaps: surveyId, surveyPageSeqId)
*/

