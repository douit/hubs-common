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

import com.bluecc.hubs.stub.TechDataCalendarData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TechDataCalendarData.class,
        symbol = EntityNames.TechDataCalendar)
public class TechDataCalendar implements IEventModel<TechDataCalendarData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String calendarId;
    String description;
    String calendarWeekId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TechDataCalendarData.Builder toDataBuilder() {
        TechDataCalendarData.Builder builder = TechDataCalendarData.newBuilder();
        if (calendarId != null) {
            builder.setCalendarId(calendarId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (calendarWeekId != null) {
            builder.setCalendarWeekId(calendarWeekId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static TechDataCalendar fromData(TechDataCalendarData data) {
        return TechDataCalendar.builder()
                .calendarId(data.getCalendarId())
                .description(data.getDescription())
                .calendarWeekId(data.getCalendarWeekId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
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

