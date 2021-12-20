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

import com.bluecc.hubs.stub.TemporalExpressionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TemporalExpressionData.class,
        symbol = EntityNames.TemporalExpression)
public class TemporalExpression implements IEventModel<TemporalExpressionData.Builder>, HasId, Serializable, WithSchedule, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("temp_expr_id")
	@RId 
    String tempExprId;
    @SerializedName("temp_expr_type_id") 
    String tempExprTypeId;
    @SerializedName("description") 
    String description;
    @SerializedName("date1") 
    java.time.LocalDateTime date1;
    @SerializedName("date2") 
    java.time.LocalDateTime date2;
    @SerializedName("integer1") 
    Long integer1;
    @SerializedName("integer2") 
    Long integer2;
    @SerializedName("string1") 
    String string1;
    @SerializedName("string2") 
    String string2;
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
        return tempExprId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TemporalExpressionData.Builder toDataBuilder() {
        TemporalExpressionData.Builder builder = TemporalExpressionData.newBuilder();
        if (getTempExprId() != null) {
            builder.setTempExprId(getTempExprId());
        }
        if (getTempExprTypeId() != null) {
            builder.setTempExprTypeId(getTempExprTypeId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getDate1() != null) {
            builder.setDate1(getTimestamp(getDate1()));
        }
        if (getDate2() != null) {
            builder.setDate2(getTimestamp(getDate2()));
        }
        if (getInteger1() != null) {
            builder.setInteger1(getInteger1());
        }
        if (getInteger2() != null) {
            builder.setInteger2(getInteger2());
        }
        if (getString1() != null) {
            builder.setString1(getString1());
        }
        if (getString2() != null) {
            builder.setString2(getString2());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static TemporalExpression fromData(TemporalExpressionData data) {
        return fromPrototype(data).build();
    }

    public static TemporalExpression.TemporalExpressionBuilder fromPrototype(TemporalExpressionData data) {
        return TemporalExpression.builder()
                .tempExprId(data.getTempExprId())
                .tempExprTypeId(data.getTempExprTypeId())
                .description(data.getDescription())
                .date1(getLocalDateTime(data.getDate1()))
                .date2(getLocalDateTime(data.getDate2()))
                .integer1(data.getInteger1())
                .integer2(data.getInteger2())
                .string1(data.getString1())
                .string2(data.getString2())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: tempExprId

-- fields --
    
    String tempExprId
    String tempExprTypeId
    String description
    java.time.LocalDateTime date1
    java.time.LocalDateTime date2
    Long integer1
    Long integer2
    String string1
    String string2

-- relations --
    
    + JobSandbox (many, autoRelation: true, keymaps: tempExprId)
    + FromTemporalExpressionAssoc (many, autoRelation: true, keymaps: tempExprId -> fromTempExprId)
    + ToTemporalExpressionAssoc (many, autoRelation: true, keymaps: tempExprId -> toTempExprId)
    + WorkEffort (many, autoRelation: true, keymaps: tempExprId)
*/

