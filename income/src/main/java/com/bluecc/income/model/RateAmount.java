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

import com.bluecc.hubs.stub.RateAmountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = RateAmountData.class,
        symbol = EntityNames.RateAmount)
public class RateAmount implements IEventModel<RateAmountData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("rate_type_id")
	@RIndex 
    String rateTypeId;
    @SerializedName("rate_currency_uom_id")
	@RIndex 
    String rateCurrencyUomId;
    @SerializedName("period_type_id")
	@RIndex 
    String periodTypeId;
    @SerializedName("work_effort_id")
	@RIndex 
    String workEffortId;
    @SerializedName("party_id")
	@RIndex 
    String partyId;
    @SerializedName("empl_position_type_id")
	@RIndex 
    String emplPositionTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("rate_amount") 
    java.math.BigDecimal rateAmount;
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

    public RateAmountData.Builder toDataBuilder() {
        RateAmountData.Builder builder = RateAmountData.newBuilder();
        if (rateTypeId != null) {
            builder.setRateTypeId(rateTypeId);
        }
        if (rateCurrencyUomId != null) {
            builder.setRateCurrencyUomId(rateCurrencyUomId);
        }
        if (periodTypeId != null) {
            builder.setPeriodTypeId(periodTypeId);
        }
        if (workEffortId != null) {
            builder.setWorkEffortId(workEffortId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (emplPositionTypeId != null) {
            builder.setEmplPositionTypeId(emplPositionTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (rateAmount != null) {
            builder.setRateAmount(getCurrency(rateAmount));
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

    public static RateAmount fromData(RateAmountData data) {
        return RateAmount.builder()
                .rateTypeId(data.getRateTypeId())
                .rateCurrencyUomId(data.getRateCurrencyUomId())
                .periodTypeId(data.getPeriodTypeId())
                .workEffortId(data.getWorkEffortId())
                .partyId(data.getPartyId())
                .emplPositionTypeId(data.getEmplPositionTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .rateAmount(getBigDecimal(data.getRateAmount()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: rateTypeId, rateCurrencyUomId, periodTypeId, partyId, workEffortId, emplPositionTypeId, fromDate

-- fields --
    
    String rateTypeId
    String rateCurrencyUomId
    String periodTypeId
    String workEffortId
    String partyId
    String emplPositionTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.math.BigDecimal rateAmount

-- relations --
    
    - RateType (one, autoRelation: false, keymaps: rateTypeId)
    - Uom (one, autoRelation: false, keymaps: rateCurrencyUomId -> uomId)
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - EmplPositionType (one, autoRelation: false, keymaps: emplPositionTypeId)
    - PeriodType (one, autoRelation: false, keymaps: periodTypeId)
*/

