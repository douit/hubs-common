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

import com.bluecc.hubs.stub.FixedAssetStdCostData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetStdCostData.class,
        symbol = EntityNames.FixedAssetStdCost)
public class FixedAssetStdCost implements IEventModel<FixedAssetStdCostData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String fixedAssetId;
    @RIndex String fixedAssetStdCostTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String amountUomId;
    java.math.BigDecimal amount;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FixedAssetStdCostData.Builder toDataBuilder() {
        FixedAssetStdCostData.Builder builder = FixedAssetStdCostData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (fixedAssetStdCostTypeId != null) {
            builder.setFixedAssetStdCostTypeId(fixedAssetStdCostTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (amountUomId != null) {
            builder.setAmountUomId(amountUomId);
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
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

    public static FixedAssetStdCost fromData(FixedAssetStdCostData data) {
        return FixedAssetStdCost.builder()
                .fixedAssetId(data.getFixedAssetId())
                .fixedAssetStdCostTypeId(data.getFixedAssetStdCostTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .amountUomId(data.getAmountUomId())
                .amount(getBigDecimal(data.getAmount()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: fixedAssetId, fixedAssetStdCostTypeId, fromDate

-- fields --
    
    String fixedAssetId
    String fixedAssetStdCostTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String amountUomId
    java.math.BigDecimal amount

-- relations --
    
    - FixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    - FixedAssetStdCostType (one, autoRelation: false, keymaps: fixedAssetStdCostTypeId)
    - Uom (one, autoRelation: false, keymaps: amountUomId -> uomId)
*/

