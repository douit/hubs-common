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

import com.bluecc.hubs.stub.QuantityBreakData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = QuantityBreakData.class,
        symbol = EntityNames.QuantityBreak)
public class QuantityBreak implements IEventModel<QuantityBreakData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String quantityBreakId;
    String quantityBreakTypeId;
    java.math.BigDecimal fromQuantity;
    java.math.BigDecimal thruQuantity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public QuantityBreakData.Builder toDataBuilder() {
        QuantityBreakData.Builder builder = QuantityBreakData.newBuilder();
        if (quantityBreakId != null) {
            builder.setQuantityBreakId(quantityBreakId);
        }
        if (quantityBreakTypeId != null) {
            builder.setQuantityBreakTypeId(quantityBreakTypeId);
        }
        if (fromQuantity != null) {
            builder.setFromQuantity(getFixedPoint(fromQuantity));
        }
        if (thruQuantity != null) {
            builder.setThruQuantity(getFixedPoint(thruQuantity));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static QuantityBreak fromData(QuantityBreakData data) {
        return QuantityBreak.builder()
                .quantityBreakId(data.getQuantityBreakId())
                .quantityBreakTypeId(data.getQuantityBreakTypeId())
                .fromQuantity(getBigDecimal(data.getFromQuantity()))
                .thruQuantity(getBigDecimal(data.getThruQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
