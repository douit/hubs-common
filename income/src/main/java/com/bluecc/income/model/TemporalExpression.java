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

import com.bluecc.hubs.stub.TemporalExpressionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TemporalExpressionData.class,
        symbol = EntityNames.TemporalExpression)
public class TemporalExpression implements IEventModel<TemporalExpressionData.Builder>, Serializable, WithSchedule, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String tempExprId;
    String tempExprTypeId;
    String description;
    java.time.LocalDateTime date1;
    java.time.LocalDateTime date2;
    Long integer1;
    Long integer2;
    String string1;
    String string2;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TemporalExpressionData.Builder toDataBuilder() {
        TemporalExpressionData.Builder builder = TemporalExpressionData.newBuilder();
        if (tempExprId != null) {
            builder.setTempExprId(tempExprId);
        }
        if (tempExprTypeId != null) {
            builder.setTempExprTypeId(tempExprTypeId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (date1 != null) {
            builder.setDate1(getTimestamp(date1));
        }
        if (date2 != null) {
            builder.setDate2(getTimestamp(date2));
        }
        if (integer1 != null) {
            builder.setInteger1(integer1);
        }
        if (integer2 != null) {
            builder.setInteger2(integer2);
        }
        if (string1 != null) {
            builder.setString1(string1);
        }
        if (string2 != null) {
            builder.setString2(string2);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static TemporalExpression fromData(TemporalExpressionData data) {
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
                
                .build();
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

