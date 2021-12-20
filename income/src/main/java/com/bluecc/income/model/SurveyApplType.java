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

import com.bluecc.hubs.stub.SurveyApplTypeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SurveyApplTypeData.class,
        symbol = EntityNames.SurveyApplType)
public class SurveyApplType implements IEventModel<SurveyApplTypeData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("survey_appl_type_id")
	@RId 
    String surveyApplTypeId;
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
        return surveyApplTypeId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public SurveyApplTypeData.Builder toDataBuilder() {
        SurveyApplTypeData.Builder builder = SurveyApplTypeData.newBuilder();
        if (getSurveyApplTypeId() != null) {
            builder.setSurveyApplTypeId(getSurveyApplTypeId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static SurveyApplType fromData(SurveyApplTypeData data) {
        return fromPrototype(data).build();
    }

    public static SurveyApplType.SurveyApplTypeBuilder fromPrototype(SurveyApplTypeData data) {
        return SurveyApplType.builder()
                .surveyApplTypeId(data.getSurveyApplTypeId())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
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

