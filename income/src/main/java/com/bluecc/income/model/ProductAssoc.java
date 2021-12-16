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

import com.bluecc.hubs.stub.ProductAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductAssocData.class,
        symbol = EntityNames.ProductAssoc)
public class ProductAssoc implements IEventModel<ProductAssocData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RIndex String productId;
    @RIndex String productIdTo;
    @RIndex String productAssocTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Long sequenceNum;
    String reason;
    java.math.BigDecimal quantity;
    java.math.BigDecimal scrapFactor;
    String instruction;
    String routingWorkEffortId;
    String estimateCalcMethod;
    String recurrenceInfoId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductAssocData.Builder toDataBuilder() {
        ProductAssocData.Builder builder = ProductAssocData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productIdTo != null) {
            builder.setProductIdTo(productIdTo);
        }
        if (productAssocTypeId != null) {
            builder.setProductAssocTypeId(productAssocTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (sequenceNum != null) {
            builder.setSequenceNum(sequenceNum);
        }
        if (reason != null) {
            builder.setReason(reason);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (scrapFactor != null) {
            builder.setScrapFactor(getFixedPoint(scrapFactor));
        }
        if (instruction != null) {
            builder.setInstruction(instruction);
        }
        if (routingWorkEffortId != null) {
            builder.setRoutingWorkEffortId(routingWorkEffortId);
        }
        if (estimateCalcMethod != null) {
            builder.setEstimateCalcMethod(estimateCalcMethod);
        }
        if (recurrenceInfoId != null) {
            builder.setRecurrenceInfoId(recurrenceInfoId);
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

    public static ProductAssoc fromData(ProductAssocData data) {
        return ProductAssoc.builder()
                .productId(data.getProductId())
                .productIdTo(data.getProductIdTo())
                .productAssocTypeId(data.getProductAssocTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .sequenceNum(data.getSequenceNum())
                .reason(data.getReason())
                .quantity(getBigDecimal(data.getQuantity()))
                .scrapFactor(getBigDecimal(data.getScrapFactor()))
                .instruction(data.getInstruction())
                .routingWorkEffortId(data.getRoutingWorkEffortId())
                .estimateCalcMethod(data.getEstimateCalcMethod())
                .recurrenceInfoId(data.getRecurrenceInfoId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productId, productIdTo, productAssocTypeId, fromDate

-- fields --
    
    String productId
    String productIdTo
    String productAssocTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Long sequenceNum
    String reason
    java.math.BigDecimal quantity
    java.math.BigDecimal scrapFactor
    String instruction
    String routingWorkEffortId
    String estimateCalcMethod
    String recurrenceInfoId

-- relations --
    
    - ProductAssocType (one, autoRelation: false, keymaps: productAssocTypeId)
    - MainProduct (one, autoRelation: false, keymaps: productId)
    - AssocProduct (one, autoRelation: false, keymaps: productIdTo -> productId)
    - RoutingWorkEffort (one, autoRelation: false, keymaps: routingWorkEffortId -> workEffortId)
    - CustomMethod (one, autoRelation: false, keymaps: estimateCalcMethod -> customMethodId)
    - RecurrenceInfo (one, autoRelation: false, keymaps: recurrenceInfoId)
*/

