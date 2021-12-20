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

import com.bluecc.hubs.stub.QuoteItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = QuoteItemData.class,
        symbol = EntityNames.QuoteItem)
public class QuoteItem implements IEventModel<QuoteItemData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("quote_id")
	@RIndex 
    String quoteId;
    @SerializedName("quote_item_seq_id")
	@RIndex 
    String quoteItemSeqId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("product_feature_id") 
    String productFeatureId;
    @SerializedName("deliverable_type_id") 
    String deliverableTypeId;
    @SerializedName("skill_type_id") 
    String skillTypeId;
    @SerializedName("uom_id") 
    String uomId;
    @SerializedName("work_effort_id") 
    String workEffortId;
    @SerializedName("cust_request_id") 
    String custRequestId;
    @SerializedName("cust_request_item_seq_id") 
    String custRequestItemSeqId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("selected_amount") 
    java.math.BigDecimal selectedAmount;
    @SerializedName("quote_unit_price") 
    java.math.BigDecimal quoteUnitPrice;
    @SerializedName("reserv_start") 
    java.time.LocalDateTime reservStart;
    @SerializedName("reserv_length") 
    java.math.BigDecimal reservLength;
    @SerializedName("reserv_persons") 
    java.math.BigDecimal reservPersons;
    @SerializedName("config_id") 
    String configId;
    @SerializedName("estimated_delivery_date") 
    java.time.LocalDateTime estimatedDeliveryDate;
    @SerializedName("comments") 
    String comments;
    @SerializedName("is_promo") 
    Character isPromo;
    @SerializedName("lead_time_days") 
    Long leadTimeDays;
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

    public QuoteItemData.Builder toDataBuilder() {
        QuoteItemData.Builder builder = QuoteItemData.newBuilder();
        if (getQuoteId() != null) {
            builder.setQuoteId(getQuoteId());
        }
        if (getQuoteItemSeqId() != null) {
            builder.setQuoteItemSeqId(getQuoteItemSeqId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getProductFeatureId() != null) {
            builder.setProductFeatureId(getProductFeatureId());
        }
        if (getDeliverableTypeId() != null) {
            builder.setDeliverableTypeId(getDeliverableTypeId());
        }
        if (getSkillTypeId() != null) {
            builder.setSkillTypeId(getSkillTypeId());
        }
        if (getUomId() != null) {
            builder.setUomId(getUomId());
        }
        if (getWorkEffortId() != null) {
            builder.setWorkEffortId(getWorkEffortId());
        }
        if (getCustRequestId() != null) {
            builder.setCustRequestId(getCustRequestId());
        }
        if (getCustRequestItemSeqId() != null) {
            builder.setCustRequestItemSeqId(getCustRequestItemSeqId());
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getSelectedAmount() != null) {
            builder.setSelectedAmount(getFixedPoint(getSelectedAmount()));
        }
        if (getQuoteUnitPrice() != null) {
            builder.setQuoteUnitPrice(getCurrency(getQuoteUnitPrice()));
        }
        if (getReservStart() != null) {
            builder.setReservStart(getTimestamp(getReservStart()));
        }
        if (getReservLength() != null) {
            builder.setReservLength(getFixedPoint(getReservLength()));
        }
        if (getReservPersons() != null) {
            builder.setReservPersons(getFixedPoint(getReservPersons()));
        }
        if (getConfigId() != null) {
            builder.setConfigId(getConfigId());
        }
        if (getEstimatedDeliveryDate() != null) {
            builder.setEstimatedDeliveryDate(getTimestamp(getEstimatedDeliveryDate()));
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getIsPromo() != null) {
            builder.setIsPromo(getIndicator(getIsPromo()));
        }
        if (getLeadTimeDays() != null) {
            builder.setLeadTimeDays(getLeadTimeDays());
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

    public static QuoteItem fromData(QuoteItemData data) {
        return fromPrototype(data).build();
    }

    public static QuoteItem.QuoteItemBuilder fromPrototype(QuoteItemData data) {
        return QuoteItem.builder()
                .quoteId(data.getQuoteId())
                .quoteItemSeqId(data.getQuoteItemSeqId())
                .productId(data.getProductId())
                .productFeatureId(data.getProductFeatureId())
                .deliverableTypeId(data.getDeliverableTypeId())
                .skillTypeId(data.getSkillTypeId())
                .uomId(data.getUomId())
                .workEffortId(data.getWorkEffortId())
                .custRequestId(data.getCustRequestId())
                .custRequestItemSeqId(data.getCustRequestItemSeqId())
                .quantity(getBigDecimal(data.getQuantity()))
                .selectedAmount(getBigDecimal(data.getSelectedAmount()))
                .quoteUnitPrice(getBigDecimal(data.getQuoteUnitPrice()))
                .reservStart(getLocalDateTime(data.getReservStart()))
                .reservLength(getBigDecimal(data.getReservLength()))
                .reservPersons(getBigDecimal(data.getReservPersons()))
                .configId(data.getConfigId())
                .estimatedDeliveryDate(getLocalDateTime(data.getEstimatedDeliveryDate()))
                .comments(data.getComments())
                .isPromo(getIndicatorChar(data.getIsPromo()))
                .leadTimeDays(data.getLeadTimeDays())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: quoteId, quoteItemSeqId

-- fields --
    
    String quoteId
    String quoteItemSeqId
    String productId
    String productFeatureId
    String deliverableTypeId
    String skillTypeId
    String uomId
    String workEffortId
    String custRequestId
    String custRequestItemSeqId
    java.math.BigDecimal quantity
    java.math.BigDecimal selectedAmount
    java.math.BigDecimal quoteUnitPrice
    java.time.LocalDateTime reservStart
    java.math.BigDecimal reservLength
    java.math.BigDecimal reservPersons
    String configId
    java.time.LocalDateTime estimatedDeliveryDate
    String comments
    Character isPromo
    Long leadTimeDays

-- relations --
    
    - Quote (one, autoRelation: false, keymaps: quoteId)
    - Product (one, autoRelation: false, keymaps: productId)
    - ProductFeature (one, autoRelation: false, keymaps: productFeatureId)
    - DeliverableType (one, autoRelation: false, keymaps: deliverableTypeId)
    - SkillType (one, autoRelation: false, keymaps: skillTypeId)
    - Uom (one, autoRelation: false, keymaps: uomId)
    - WorkEffort (one, autoRelation: false, keymaps: workEffortId)
    - CustRequest (one, autoRelation: false, keymaps: custRequestId)
    - CustRequestItem (one, autoRelation: false, keymaps: custRequestId, custRequestItemSeqId)
    + OrderItem (many, autoRelation: true, keymaps: quoteId, quoteItemSeqId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: quoteId, quoteItemSeqId)
    + QuoteTerm (many, autoRelation: true, keymaps: quoteId, quoteItemSeqId)
*/

