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

import com.bluecc.hubs.stub.OrderAdjustmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderAdjustmentData.class,
        symbol = EntityNames.OrderAdjustment)
public class OrderAdjustment implements IEventModel<OrderAdjustmentData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String orderAdjustmentId;
    String orderAdjustmentTypeId;
    String orderId;
    String orderItemSeqId;
    String shipGroupSeqId;
    String comments;
    String description;
    java.math.BigDecimal amount;
    java.math.BigDecimal recurringAmount;
    java.math.BigDecimal amountAlreadyIncluded;
    String productPromoId;
    String productPromoRuleId;
    String productPromoActionSeqId;
    String productFeatureId;
    String correspondingProductId;
    String taxAuthorityRateSeqId;
    String sourceReferenceId;
    java.math.BigDecimal sourcePercentage;
    String customerReferenceId;
    String primaryGeoId;
    String secondaryGeoId;
    java.math.BigDecimal exemptAmount;
    String taxAuthGeoId;
    String taxAuthPartyId;
    String overrideGlAccountId;
    Character includeInTax;
    Character includeInShipping;
    Character isManual;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    String originalAdjustmentId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderAdjustmentData.Builder toDataBuilder() {
        OrderAdjustmentData.Builder builder = OrderAdjustmentData.newBuilder();
        if (orderAdjustmentId != null) {
            builder.setOrderAdjustmentId(orderAdjustmentId);
        }
        if (orderAdjustmentTypeId != null) {
            builder.setOrderAdjustmentTypeId(orderAdjustmentTypeId);
        }
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
        }
        if (recurringAmount != null) {
            builder.setRecurringAmount(getCurrency(recurringAmount));
        }
        if (amountAlreadyIncluded != null) {
            builder.setAmountAlreadyIncluded(getCurrency(amountAlreadyIncluded));
        }
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (productPromoRuleId != null) {
            builder.setProductPromoRuleId(productPromoRuleId);
        }
        if (productPromoActionSeqId != null) {
            builder.setProductPromoActionSeqId(productPromoActionSeqId);
        }
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (correspondingProductId != null) {
            builder.setCorrespondingProductId(correspondingProductId);
        }
        if (taxAuthorityRateSeqId != null) {
            builder.setTaxAuthorityRateSeqId(taxAuthorityRateSeqId);
        }
        if (sourceReferenceId != null) {
            builder.setSourceReferenceId(sourceReferenceId);
        }
        if (sourcePercentage != null) {
            builder.setSourcePercentage(getFixedPoint(sourcePercentage));
        }
        if (customerReferenceId != null) {
            builder.setCustomerReferenceId(customerReferenceId);
        }
        if (primaryGeoId != null) {
            builder.setPrimaryGeoId(primaryGeoId);
        }
        if (secondaryGeoId != null) {
            builder.setSecondaryGeoId(secondaryGeoId);
        }
        if (exemptAmount != null) {
            builder.setExemptAmount(getCurrency(exemptAmount));
        }
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (overrideGlAccountId != null) {
            builder.setOverrideGlAccountId(overrideGlAccountId);
        }
        if (includeInTax != null) {
            builder.setIncludeInTax(getIndicator(includeInTax));
        }
        if (includeInShipping != null) {
            builder.setIncludeInShipping(getIndicator(includeInShipping));
        }
        if (isManual != null) {
            builder.setIsManual(getIndicator(isManual));
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (originalAdjustmentId != null) {
            builder.setOriginalAdjustmentId(originalAdjustmentId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static OrderAdjustment fromData(OrderAdjustmentData data) {
        return OrderAdjustment.builder()
                .orderAdjustmentId(data.getOrderAdjustmentId())
                .orderAdjustmentTypeId(data.getOrderAdjustmentTypeId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .comments(data.getComments())
                .description(data.getDescription())
                .amount(getBigDecimal(data.getAmount()))
                .recurringAmount(getBigDecimal(data.getRecurringAmount()))
                .amountAlreadyIncluded(getBigDecimal(data.getAmountAlreadyIncluded()))
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productFeatureId(data.getProductFeatureId())
                .correspondingProductId(data.getCorrespondingProductId())
                .taxAuthorityRateSeqId(data.getTaxAuthorityRateSeqId())
                .sourceReferenceId(data.getSourceReferenceId())
                .sourcePercentage(getBigDecimal(data.getSourcePercentage()))
                .customerReferenceId(data.getCustomerReferenceId())
                .primaryGeoId(data.getPrimaryGeoId())
                .secondaryGeoId(data.getSecondaryGeoId())
                .exemptAmount(getBigDecimal(data.getExemptAmount()))
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .overrideGlAccountId(data.getOverrideGlAccountId())
                .includeInTax(getIndicatorChar(data.getIncludeInTax()))
                .includeInShipping(getIndicatorChar(data.getIncludeInShipping()))
                .isManual(getIndicatorChar(data.getIsManual()))
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .originalAdjustmentId(data.getOriginalAdjustmentId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: orderAdjustmentId

-- fields --
    
    String orderAdjustmentId
    String orderAdjustmentTypeId
    String orderId
    String orderItemSeqId
    String shipGroupSeqId
    String comments
    String description
    java.math.BigDecimal amount
    java.math.BigDecimal recurringAmount
    java.math.BigDecimal amountAlreadyIncluded
    String productPromoId
    String productPromoRuleId
    String productPromoActionSeqId
    String productFeatureId
    String correspondingProductId
    String taxAuthorityRateSeqId
    String sourceReferenceId
    java.math.BigDecimal sourcePercentage
    String customerReferenceId
    String primaryGeoId
    String secondaryGeoId
    java.math.BigDecimal exemptAmount
    String taxAuthGeoId
    String taxAuthPartyId
    String overrideGlAccountId
    Character includeInTax
    Character includeInShipping
    Character isManual
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin
    String originalAdjustmentId

-- relations --
    
    - OrderAdjustmentType (one, autoRelation: false, keymaps: orderAdjustmentTypeId)
    + OrderAdjustmentTypeAttr (many, autoRelation: false, keymaps: orderAdjustmentTypeId)
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - UserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - OrderItem (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - OrderItemShipGroup (one-nofk, autoRelation: false, keymaps: orderId, shipGroupSeqId)
    - OrderItemShipGroupAssoc (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId, shipGroupSeqId)
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - ProductPromoRule (one-nofk, autoRelation: false, keymaps: productPromoId, productPromoRuleId)
    - ProductPromoAction (one-nofk, autoRelation: false, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
    - PrimaryGeo (one, autoRelation: false, keymaps: primaryGeoId -> geoId)
    - SecondaryGeo (one, autoRelation: false, keymaps: secondaryGeoId -> geoId)
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
    - OverrideGlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
    - TaxAuthorityRateProduct (one, autoRelation: false, keymaps: taxAuthorityRateSeqId)
    - OrderAdjustment (one-nofk, autoRelation: false, keymaps: originalAdjustmentId -> orderAdjustmentId)
    + OrderAdjustmentAttribute (many, autoRelation: true, keymaps: orderAdjustmentId)
    + OrderAdjustmentBilling (many, autoRelation: true, keymaps: orderAdjustmentId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: orderAdjustmentId)
*/

