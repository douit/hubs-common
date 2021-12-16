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

import com.bluecc.hubs.stub.TechDataCalendarWeekData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TechDataCalendarWeekData.class,
        symbol = EntityNames.TechDataCalendarWeek)
public class TechDataCalendarWeek implements IEventModel<TechDataCalendarWeekData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String calendarWeekId;
    String description;
    java.time.LocalTime mondayStartTime;
    Double mondayCapacity;
    java.time.LocalTime tuesdayStartTime;
    Double tuesdayCapacity;
    java.time.LocalTime wednesdayStartTime;
    Double wednesdayCapacity;
    java.time.LocalTime thursdayStartTime;
    Double thursdayCapacity;
    java.time.LocalTime fridayStartTime;
    Double fridayCapacity;
    java.time.LocalTime saturdayStartTime;
    Double saturdayCapacity;
    java.time.LocalTime sundayStartTime;
    Double sundayCapacity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TechDataCalendarWeekData.Builder toDataBuilder() {
        TechDataCalendarWeekData.Builder builder = TechDataCalendarWeekData.newBuilder();
        if (calendarWeekId != null) {
            builder.setCalendarWeekId(calendarWeekId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (mondayStartTime != null) {
            builder.setMondayStartTime(getTimeOfDay(mondayStartTime));
        }
        if (mondayCapacity != null) {
            builder.setMondayCapacity(mondayCapacity);
        }
        if (tuesdayStartTime != null) {
            builder.setTuesdayStartTime(getTimeOfDay(tuesdayStartTime));
        }
        if (tuesdayCapacity != null) {
            builder.setTuesdayCapacity(tuesdayCapacity);
        }
        if (wednesdayStartTime != null) {
            builder.setWednesdayStartTime(getTimeOfDay(wednesdayStartTime));
        }
        if (wednesdayCapacity != null) {
            builder.setWednesdayCapacity(wednesdayCapacity);
        }
        if (thursdayStartTime != null) {
            builder.setThursdayStartTime(getTimeOfDay(thursdayStartTime));
        }
        if (thursdayCapacity != null) {
            builder.setThursdayCapacity(thursdayCapacity);
        }
        if (fridayStartTime != null) {
            builder.setFridayStartTime(getTimeOfDay(fridayStartTime));
        }
        if (fridayCapacity != null) {
            builder.setFridayCapacity(fridayCapacity);
        }
        if (saturdayStartTime != null) {
            builder.setSaturdayStartTime(getTimeOfDay(saturdayStartTime));
        }
        if (saturdayCapacity != null) {
            builder.setSaturdayCapacity(saturdayCapacity);
        }
        if (sundayStartTime != null) {
            builder.setSundayStartTime(getTimeOfDay(sundayStartTime));
        }
        if (sundayCapacity != null) {
            builder.setSundayCapacity(sundayCapacity);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static TechDataCalendarWeek fromData(TechDataCalendarWeekData data) {
        return TechDataCalendarWeek.builder()
                .calendarWeekId(data.getCalendarWeekId())
                .description(data.getDescription())
                .mondayStartTime(getTime(data.getMondayStartTime()))
                .mondayCapacity(data.getMondayCapacity())
                .tuesdayStartTime(getTime(data.getTuesdayStartTime()))
                .tuesdayCapacity(data.getTuesdayCapacity())
                .wednesdayStartTime(getTime(data.getWednesdayStartTime()))
                .wednesdayCapacity(data.getWednesdayCapacity())
                .thursdayStartTime(getTime(data.getThursdayStartTime()))
                .thursdayCapacity(data.getThursdayCapacity())
                .fridayStartTime(getTime(data.getFridayStartTime()))
                .fridayCapacity(data.getFridayCapacity())
                .saturdayStartTime(getTime(data.getSaturdayStartTime()))
                .saturdayCapacity(data.getSaturdayCapacity())
                .sundayStartTime(getTime(data.getSundayStartTime()))
                .sundayCapacity(data.getSundayCapacity())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: calendarWeekId

-- fields --
    
    String calendarWeekId
    String description
    java.time.LocalTime mondayStartTime
    Double mondayCapacity
    java.time.LocalTime tuesdayStartTime
    Double tuesdayCapacity
    java.time.LocalTime wednesdayStartTime
    Double wednesdayCapacity
    java.time.LocalTime thursdayStartTime
    Double thursdayCapacity
    java.time.LocalTime fridayStartTime
    Double fridayCapacity
    java.time.LocalTime saturdayStartTime
    Double saturdayCapacity
    java.time.LocalTime sundayStartTime
    Double sundayCapacity

-- relations --
    
    + TechDataCalendar (many, autoRelation: true, keymaps: calendarWeekId)
    + TechDataCalendarExcWeek (many, autoRelation: true, keymaps: calendarWeekId)
*/

