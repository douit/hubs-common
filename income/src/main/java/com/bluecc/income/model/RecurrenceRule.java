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

import com.bluecc.hubs.stub.RecurrenceRuleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = RecurrenceRuleData.class,
        symbol = EntityNames.RecurrenceRule)
public class RecurrenceRule implements IEventModel<RecurrenceRuleData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("recurrence_rule_id")
	@RId 
    String recurrenceRuleId;
    @SerializedName("frequency") 
    String frequency;
    @SerializedName("until_date_time") 
    java.time.LocalDateTime untilDateTime;
    @SerializedName("count_number") 
    Long countNumber;
    @SerializedName("interval_number") 
    Long intervalNumber;
    @SerializedName("by_second_list") 
    String bySecondList;
    @SerializedName("by_minute_list") 
    String byMinuteList;
    @SerializedName("by_hour_list") 
    String byHourList;
    @SerializedName("by_day_list") 
    String byDayList;
    @SerializedName("by_month_day_list") 
    String byMonthDayList;
    @SerializedName("by_year_day_list") 
    String byYearDayList;
    @SerializedName("by_week_no_list") 
    String byWeekNoList;
    @SerializedName("by_month_list") 
    String byMonthList;
    @SerializedName("by_set_pos_list") 
    String bySetPosList;
    @SerializedName("week_start") 
    String weekStart;
    @SerializedName("x_name") 
    String xName;
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
        return recurrenceRuleId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public RecurrenceRuleData.Builder toDataBuilder() {
        RecurrenceRuleData.Builder builder = RecurrenceRuleData.newBuilder();
        if (getRecurrenceRuleId() != null) {
            builder.setRecurrenceRuleId(getRecurrenceRuleId());
        }
        if (getFrequency() != null) {
            builder.setFrequency(getFrequency());
        }
        if (getUntilDateTime() != null) {
            builder.setUntilDateTime(getTimestamp(getUntilDateTime()));
        }
        if (getCountNumber() != null) {
            builder.setCountNumber(getCountNumber());
        }
        if (getIntervalNumber() != null) {
            builder.setIntervalNumber(getIntervalNumber());
        }
        if (getBySecondList() != null) {
            builder.setBySecondList(getBySecondList());
        }
        if (getByMinuteList() != null) {
            builder.setByMinuteList(getByMinuteList());
        }
        if (getByHourList() != null) {
            builder.setByHourList(getByHourList());
        }
        if (getByDayList() != null) {
            builder.setByDayList(getByDayList());
        }
        if (getByMonthDayList() != null) {
            builder.setByMonthDayList(getByMonthDayList());
        }
        if (getByYearDayList() != null) {
            builder.setByYearDayList(getByYearDayList());
        }
        if (getByWeekNoList() != null) {
            builder.setByWeekNoList(getByWeekNoList());
        }
        if (getByMonthList() != null) {
            builder.setByMonthList(getByMonthList());
        }
        if (getBySetPosList() != null) {
            builder.setBySetPosList(getBySetPosList());
        }
        if (getWeekStart() != null) {
            builder.setWeekStart(getWeekStart());
        }
        if (getXName() != null) {
            builder.setXName(getXName());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static RecurrenceRule fromData(RecurrenceRuleData data) {
        return fromPrototype(data).build();
    }

    public static RecurrenceRule.RecurrenceRuleBuilder fromPrototype(RecurrenceRuleData data) {
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
                ;
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

