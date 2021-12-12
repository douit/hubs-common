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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.RecurrenceInfoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = RecurrenceInfoData.class,
        symbol = EntityNames.RecurrenceInfo)
public class RecurrenceInfo implements IEventModel<RecurrenceInfoData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String recurrenceInfoId;
    java.time.LocalDateTime startDateTime;
    String exceptionDateTimes;
    String recurrenceDateTimes;
    String exceptionRuleId;
    String recurrenceRuleId;
    Long recurrenceCount;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public RecurrenceInfoData.Builder toDataBuilder() {
        RecurrenceInfoData.Builder builder = RecurrenceInfoData.newBuilder();
        if (recurrenceInfoId != null) {
            builder.setRecurrenceInfoId(recurrenceInfoId);
        }
        if (startDateTime != null) {
            builder.setStartDateTime(getTimestamp(startDateTime));
        }
        if (exceptionDateTimes != null) {
            builder.setExceptionDateTimes(exceptionDateTimes);
        }
        if (recurrenceDateTimes != null) {
            builder.setRecurrenceDateTimes(recurrenceDateTimes);
        }
        if (exceptionRuleId != null) {
            builder.setExceptionRuleId(exceptionRuleId);
        }
        if (recurrenceRuleId != null) {
            builder.setRecurrenceRuleId(recurrenceRuleId);
        }
        if (recurrenceCount != null) {
            builder.setRecurrenceCount(recurrenceCount);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static RecurrenceInfo fromData(RecurrenceInfoData data) {
        return RecurrenceInfo.builder()
                .recurrenceInfoId(data.getRecurrenceInfoId())
                .startDateTime(getLocalDateTime(data.getStartDateTime()))
                .exceptionDateTimes(data.getExceptionDateTimes())
                .recurrenceDateTimes(data.getRecurrenceDateTimes())
                .exceptionRuleId(data.getExceptionRuleId())
                .recurrenceRuleId(data.getRecurrenceRuleId())
                .recurrenceCount(data.getRecurrenceCount())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
