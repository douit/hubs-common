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

import com.bluecc.hubs.stub.RecurrenceInfoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = RecurrenceInfoData.class,
        symbol = EntityNames.RecurrenceInfo)
public class RecurrenceInfo implements IEventModel<RecurrenceInfoData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("recurrence_info_id")
	@RId 
    String recurrenceInfoId;
    @SerializedName("start_date_time") 
    java.time.LocalDateTime startDateTime;
    @SerializedName("exception_date_times") 
    String exceptionDateTimes;
    @SerializedName("recurrence_date_times") 
    String recurrenceDateTimes;
    @SerializedName("exception_rule_id") 
    String exceptionRuleId;
    @SerializedName("recurrence_rule_id") 
    String recurrenceRuleId;
    @SerializedName("recurrence_count") 
    Long recurrenceCount;
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
        return recurrenceInfoId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public RecurrenceInfoData.Builder toDataBuilder() {
        RecurrenceInfoData.Builder builder = RecurrenceInfoData.newBuilder();
        if (getRecurrenceInfoId() != null) {
            builder.setRecurrenceInfoId(getRecurrenceInfoId());
        }
        if (getStartDateTime() != null) {
            builder.setStartDateTime(getTimestamp(getStartDateTime()));
        }
        if (getExceptionDateTimes() != null) {
            builder.setExceptionDateTimes(getExceptionDateTimes());
        }
        if (getRecurrenceDateTimes() != null) {
            builder.setRecurrenceDateTimes(getRecurrenceDateTimes());
        }
        if (getExceptionRuleId() != null) {
            builder.setExceptionRuleId(getExceptionRuleId());
        }
        if (getRecurrenceRuleId() != null) {
            builder.setRecurrenceRuleId(getRecurrenceRuleId());
        }
        if (getRecurrenceCount() != null) {
            builder.setRecurrenceCount(getRecurrenceCount());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static RecurrenceInfo fromData(RecurrenceInfoData data) {
        return fromPrototype(data).build();
    }

    public static RecurrenceInfo.RecurrenceInfoBuilder fromPrototype(RecurrenceInfoData data) {
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
                ;
    }

    
}


/*
-- keys: recurrenceInfoId

-- fields --
    
    String recurrenceInfoId
    java.time.LocalDateTime startDateTime
    String exceptionDateTimes
    String recurrenceDateTimes
    String exceptionRuleId
    String recurrenceRuleId
    Long recurrenceCount

-- relations --
    
    - RecurrenceRule (one, autoRelation: false, keymaps: recurrenceRuleId)
    - ExceptionRecurrenceRule (one, autoRelation: false, keymaps: exceptionRuleId -> recurrenceRuleId)
    + Invoice (many, autoRelation: true, keymaps: recurrenceInfoId)
    + JobSandbox (many, autoRelation: true, keymaps: recurrenceInfoId)
    + ProductAssoc (many, autoRelation: true, keymaps: recurrenceInfoId)
    + ShoppingList (many, autoRelation: true, keymaps: recurrenceInfoId)
    + WorkEffort (many, autoRelation: true, keymaps: recurrenceInfoId)
*/

