package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.SurveyPageData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyPage implements IEventModel<SurveyPageData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String surveyId;
    String surveyPageSeqId;
    String pageName;
    Long sequenceNum;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
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