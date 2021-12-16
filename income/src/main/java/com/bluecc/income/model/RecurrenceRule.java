package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.RecurrenceRuleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = RecurrenceRuleData.class,
        symbol = EntityNames.RecurrenceRule)
public class RecurrenceRule implements IEventModel<RecurrenceRuleData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String recurrenceRuleId;
    String frequency;
    java.time.LocalDateTime untilDateTime;
    Long countNumber;
    Long intervalNumber;
    String bySecondList;
    String byMinuteList;
    String byHourList;
    String byDayList;
    String byMonthDayList;
    String byYearDayList;
    String byWeekNoList;
    String byMonthList;
    String bySetPosList;
    String weekStart;
    String xName;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public RecurrenceRuleData.Builder toDataBuilder() {
        RecurrenceRuleData.Builder builder = RecurrenceRuleData.newBuilder();
        if (recurrenceRuleId != null) {
            builder.setRecurrenceRuleId(recurrenceRuleId);
        }
        if (frequency != null) {
            builder.setFrequency(frequency);
        }
        if (untilDateTime != null) {
            builder.setUntilDateTime(getTimestamp(untilDateTime));
        }
        if (countNumber != null) {
            builder.setCountNumber(countNumber);
        }
        if (intervalNumber != null) {
            builder.setIntervalNumber(intervalNumber);
        }
        if (bySecondList != null) {
            builder.setBySecondList(bySecondList);
        }
        if (byMinuteList != null) {
            builder.setByMinuteList(byMinuteList);
        }
        if (byHourList != null) {
            builder.setByHourList(byHourList);
        }
        if (byDayList != null) {
            builder.setByDayList(byDayList);
        }
        if (byMonthDayList != null) {
            builder.setByMonthDayList(byMonthDayList);
        }
        if (byYearDayList != null) {
            builder.setByYearDayList(byYearDayList);
        }
        if (byWeekNoList != null) {
            builder.setByWeekNoList(byWeekNoList);
        }
        if (byMonthList != null) {
            builder.setByMonthList(byMonthList);
        }
        if (bySetPosList != null) {
            builder.setBySetPosList(bySetPosList);
        }
        if (weekStart != null) {
            builder.setWeekStart(weekStart);
        }
        if (xName != null) {
            builder.setXName(xName);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static RecurrenceRule fromData(RecurrenceRuleData data) {
        return RecurrenceRule.builder()
                .recurrenceRuleId(data.getRecurrenceRuleId())
                .frequency(data.getFrequency())
                .untilDateTime(getLocalDateTime(data.getUntilDateTime()))
                .countNumber(data.getCountNumber())
                .intervalNumber(data.getIntervalNumber())
                .bySecondList(data.getBySecondList())
                .byMinuteList(data.getByMinuteList())
                .byHourList(data.getByHourList())
                .byDayList(data.getByDayList())
                .byMonthDayList(data.getByMonthDayList())
                .byYearDayList(data.getByYearDayList())
                .byWeekNoList(data.getByWeekNoList())
                .byMonthList(data.getByMonthList())
                .bySetPosList(data.getBySetPosList())
                .weekStart(data.getWeekStart())
                .xName(data.getXName())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: recurrenceRuleId

-- fields --
    
    String recurrenceRuleId
    String frequency
    java.time.LocalDateTime untilDateTime
    Long countNumber
    Long intervalNumber
    String bySecondList
    String byMinuteList
    String byHourList
    String byDayList
    String byMonthDayList
    String byYearDayList
    String byWeekNoList
    String byMonthList
    String bySetPosList
    String weekStart
    String xName

-- relations --
    
    + RecurrenceInfo (many, autoRelation: true, keymaps: recurrenceRuleId)
    + ExceptionRecurrenceInfo (many, autoRelation: true, keymaps: recurrenceRuleId -> exceptionRuleId)
*/

