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

import com.bluecc.hubs.stub.TechDataCalendarExcDayData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TechDataCalendarExcDayData.class,
        symbol = EntityNames.TechDataCalendarExcDay)
public class TechDataCalendarExcDay implements IEventModel<TechDataCalendarExcDayData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RIndex String calendarId;
    java.time.LocalDateTime exceptionDateStartTime;
    java.math.BigDecimal exceptionCapacity;
    java.math.BigDecimal usedCapacity;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TechDataCalendarExcDayData.Builder toDataBuilder() {
        TechDataCalendarExcDayData.Builder builder = TechDataCalendarExcDayData.newBuilder();
        if (calendarId != null) {
            builder.setCalendarId(calendarId);
        }
        if (exceptionDateStartTime != null) {
            builder.setExceptionDateStartTime(getTimestamp(exceptionDateStartTime));
        }
        if (exceptionCapacity != null) {
            builder.setExceptionCapacity(getFixedPoint(exceptionCapacity));
        }
        if (usedCapacity != null) {
            builder.setUsedCapacity(getFixedPoint(usedCapacity));
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
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static TechDataCalendarExcDay fromData(TechDataCalendarExcDayData data) {
        return TechDataCalendarExcDay.builder()
                .calendarId(data.getCalendarId())
                .exceptionDateStartTime(getLocalDateTime(data.getExceptionDateStartTime()))
                .exceptionCapacity(getBigDecimal(data.getExceptionCapacity()))
                .usedCapacity(getBigDecimal(data.getUsedCapacity()))
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: calendarId, exceptionDateStartTime

-- fields --
    
    String calendarId
    java.time.LocalDateTime exceptionDateStartTime
    java.math.BigDecimal exceptionCapacity
    java.math.BigDecimal usedCapacity
    String description

-- relations --
    
    - TechDataCalendar (one, autoRelation: false, keymaps: calendarId)
*/

