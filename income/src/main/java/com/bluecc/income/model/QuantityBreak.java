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

import com.bluecc.hubs.stub.QuantityBreakData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = QuantityBreakData.class,
        symbol = EntityNames.QuantityBreak)
public class QuantityBreak implements IEventModel<QuantityBreakData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("quantity_break_id")
	@RId 
    String quantityBreakId;
    @SerializedName("quantity_break_type_id") 
    String quantityBreakTypeId;
    @SerializedName("from_quantity") 
    java.math.BigDecimal fromQuantity;
    @SerializedName("thru_quantity") 
    java.math.BigDecimal thruQuantity;
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
        return quantityBreakId;
    }

        
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


/*
-- keys: quantityBreakId

-- fields --
    
    String quantityBreakId
    String quantityBreakTypeId
    java.math.BigDecimal fromQuantity
    java.math.BigDecimal thruQuantity

-- relations --
    
    - QuantityBreakType (one, autoRelation: false, keymaps: quantityBreakTypeId)
    + WeightShipmentCostEstimate (many, autoRelation: true, keymaps: quantityBreakId -> weightBreakId)
    + QuantityShipmentCostEstimate (many, autoRelation: true, keymaps: quantityBreakId)
    + PriceShipmentCostEstimate (many, autoRelation: true, keymaps: quantityBreakId -> priceBreakId)
*/

