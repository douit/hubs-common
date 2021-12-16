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

import com.bluecc.hubs.stub.TemporalExpressionAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TemporalExpressionAssocData.class,
        symbol = EntityNames.TemporalExpressionAssoc)
public class TemporalExpressionAssoc implements IEventModel<TemporalExpressionAssocData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String fromTempExprId;
    @RIndex String toTempExprId;
    String exprAssocType;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TemporalExpressionAssocData.Builder toDataBuilder() {
        TemporalExpressionAssocData.Builder builder = TemporalExpressionAssocData.newBuilder();
        if (fromTempExprId != null) {
            builder.setFromTempExprId(fromTempExprId);
        }
        if (toTempExprId != null) {
            builder.setToTempExprId(toTempExprId);
        }
        if (exprAssocType != null) {
            builder.setExprAssocType(exprAssocType);
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

    public static TemporalExpressionAssoc fromData(TemporalExpressionAssocData data) {
        return TemporalExpressionAssoc.builder()
                .fromTempExprId(data.getFromTempExprId())
                .toTempExprId(data.getToTempExprId())
                .exprAssocType(data.getExprAssocType())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: fromTempExprId, toTempExprId

-- fields --
    
    String fromTempExprId
    String toTempExprId
    String exprAssocType

-- relations --
    
    - FromTemporalExpression (one, autoRelation: false, keymaps: fromTempExprId -> tempExprId)
    - ToTemporalExpression (one, autoRelation: false, keymaps: toTempExprId -> tempExprId)
*/

