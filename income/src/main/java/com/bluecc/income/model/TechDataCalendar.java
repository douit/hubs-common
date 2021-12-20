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

import com.bluecc.hubs.stub.TechDataCalendarData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TechDataCalendarData.class,
        symbol = EntityNames.TechDataCalendar)
public class TechDataCalendar implements IEventModel<TechDataCalendarData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("calendar_id")
	@RId 
    String calendarId;
    @SerializedName("description") 
    String description;
    @SerializedName("calendar_week_id") 
    String calendarWeekId;
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
        return calendarId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TechDataCalendarData.Builder toDataBuilder() {
        TechDataCalendarData.Builder builder = TechDataCalendarData.newBuilder();
        if (getCalendarId() != null) {
            builder.setCalendarId(getCalendarId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getCalendarWeekId() != null) {
            builder.setCalendarWeekId(getCalendarWeekId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static TechDataCalendar fromData(TechDataCalendarData data) {
        return fromPrototype(data).build();
    }

    public static TechDataCalendar.TechDataCalendarBuilder fromPrototype(TechDataCalendarData data) {
        return TechDataCalendar.builder()
                .calendarId(data.getCalendarId())
                .description(data.getDescription())
                .calendarWeekId(data.getCalendarWeekId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: calendarId

-- fields --
    
    String calendarId
    String description
    String calendarWeekId

-- relations --
    
    - TechDataCalendarWeek (one, autoRelation: false, keymaps: calendarWeekId)
    + FixedAsset (many, autoRelation: true, keymaps: calendarId)
    + TechDataCalendarExcDay (many, autoRelation: true, keymaps: calendarId)
    + TechDataCalendarExcWeek (many, autoRelation: true, keymaps: calendarId)
*/

