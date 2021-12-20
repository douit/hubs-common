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

import com.bluecc.hubs.stub.ProductAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductAssocData.class,
        symbol = EntityNames.ProductAssoc)
public class ProductAssoc implements IEventModel<ProductAssocData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("product_id_to")
	@RIndex 
    String productIdTo;
    @SerializedName("product_assoc_type_id")
	@RIndex 
    String productAssocTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("sequence_num") 
    Long sequenceNum;
    @SerializedName("reason") 
    String reason;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("scrap_factor") 
    java.math.BigDecimal scrapFactor;
    @SerializedName("instruction") 
    String instruction;
    @SerializedName("routing_work_effort_id") 
    String routingWorkEffortId;
    @SerializedName("estimate_calc_method") 
    String estimateCalcMethod;
    @SerializedName("recurrence_info_id") 
    String recurrenceInfoId;
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

    public ProductAssocData.Builder toDataBuilder() {
        ProductAssocData.Builder builder = ProductAssocData.newBuilder();
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getProductIdTo() != null) {
            builder.setProductIdTo(getProductIdTo());
        }
        if (getProductAssocTypeId() != null) {
            builder.setProductAssocTypeId(getProductAssocTypeId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getSequenceNum() != null) {
            builder.setSequenceNum(getSequenceNum());
        }
        if (getReason() != null) {
            builder.setReason(getReason());
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getScrapFactor() != null) {
            builder.setScrapFactor(getFixedPoint(getScrapFactor()));
        }
        if (getInstruction() != null) {
            builder.setInstruction(getInstruction());
        }
        if (getRoutingWorkEffortId() != null) {
            builder.setRoutingWorkEffortId(getRoutingWorkEffortId());
        }
        if (getEstimateCalcMethod() != null) {
            builder.setEstimateCalcMethod(getEstimateCalcMethod());
        }
        if (getRecurrenceInfoId() != null) {
            builder.setRecurrenceInfoId(getRecurrenceInfoId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static ProductAssoc fromData(ProductAssocData data) {
        return fromPrototype(data).build();
    }

    public static ProductAssoc.ProductAssocBuilder fromPrototype(ProductAssocData data) {
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
                ;
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

