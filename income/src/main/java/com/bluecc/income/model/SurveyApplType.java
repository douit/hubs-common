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

import com.bluecc.hubs.stub.SurveyApplTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyApplTypeData.class,
        symbol = EntityNames.SurveyApplType)
public class SurveyApplType implements IEventModel<SurveyApplTypeData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String surveyApplTypeId;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyApplTypeData.Builder toDataBuilder() {
        SurveyApplTypeData.Builder builder = SurveyApplTypeData.newBuilder();
        if (surveyApplTypeId != null) {
            builder.setSurveyApplTypeId(surveyApplTypeId);
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

    public static SurveyApplType fromData(SurveyApplTypeData data) {
        return SurveyApplType.builder()
                .surveyApplTypeId(data.getSurveyApplTypeId())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: surveyApplTypeId

-- fields --
    
    String surveyApplTypeId
    String description

-- relations --
    
    + ProductStoreSurveyAppl (many, autoRelation: true, keymaps: surveyApplTypeId)
    + SurveyTrigger (many, autoRelation: true, keymaps: surveyApplTypeId)
*/

