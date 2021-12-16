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

import com.bluecc.hubs.stub.PartyRateData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyRateData.class,
        symbol = EntityNames.PartyRate)
public class PartyRate implements IEventModel<PartyRateData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String partyId;
    @RIndex String rateTypeId;
    Character defaultRate;
    Double percentageUsed;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyRateData.Builder toDataBuilder() {
        PartyRateData.Builder builder = PartyRateData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (rateTypeId != null) {
            builder.setRateTypeId(rateTypeId);
        }
        if (defaultRate != null) {
            builder.setDefaultRate(getIndicator(defaultRate));
        }
        if (percentageUsed != null) {
            builder.setPercentageUsed(percentageUsed);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
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

    public static PartyRate fromData(PartyRateData data) {
        return PartyRate.builder()
                .partyId(data.getPartyId())
                .rateTypeId(data.getRateTypeId())
                .defaultRate(getIndicatorChar(data.getDefaultRate()))
                .percentageUsed(data.getPercentageUsed())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: partyId, rateTypeId, fromDate

-- fields --
    
    String partyId
    String rateTypeId
    Character defaultRate
    Double percentageUsed
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - RateType (one, autoRelation: false, keymaps: rateTypeId)
*/

