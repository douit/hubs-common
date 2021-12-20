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

import com.bluecc.hubs.stub.TechDataCalendarExcDayData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TechDataCalendarExcDayData.class,
        symbol = EntityNames.TechDataCalendarExcDay)
public class TechDataCalendarExcDay implements IEventModel<TechDataCalendarExcDayData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("calendar_id")
	@RIndex 
    String calendarId;
    @SerializedName("exception_date_start_time") 
    java.time.LocalDateTime exceptionDateStartTime;
    @SerializedName("exception_capacity") 
    java.math.BigDecimal exceptionCapacity;
    @SerializedName("used_capacity") 
    java.math.BigDecimal usedCapacity;
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
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TechDataCalendarExcDayData.Builder toDataBuilder() {
        TechDataCalendarExcDayData.Builder builder = TechDataCalendarExcDayData.newBuilder();
        if (getCalendarId() != null) {
            builder.setCalendarId(getCalendarId());
        }
        if (getExceptionDateStartTime() != null) {
            builder.setExceptionDateStartTime(getTimestamp(getExceptionDateStartTime()));
        }
        if (getExceptionCapacity() != null) {
            builder.setExceptionCapacity(getFixedPoint(getExceptionCapacity()));
        }
        if (getUsedCapacity() != null) {
            builder.setUsedCapacity(getFixedPoint(getUsedCapacity()));
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
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static TechDataCalendarExcDay fromData(TechDataCalendarExcDayData data) {
        return fromPrototype(data).build();
    }

    public static TechDataCalendarExcDay.TechDataCalendarExcDayBuilder fromPrototype(TechDataCalendarExcDayData data) {
        return TechDataCalendarExcDay.builder()
                .calendarId(data.getCalendarId())
                .exceptionDateStartTime(getLocalDateTime(data.getExceptionDateStartTime()))
                .exceptionCapacity(getBigDecimal(data.getExceptionCapacity()))
                .usedCapacity(getBigDecimal(data.getUsedCapacity()))
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
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

