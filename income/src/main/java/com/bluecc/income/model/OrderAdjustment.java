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

import com.bluecc.hubs.stub.OrderAdjustmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderAdjustmentData.class,
        symbol = EntityNames.OrderAdjustment)
public class OrderAdjustment implements IEventModel<OrderAdjustmentData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_adjustment_id")
	@RId 
    String orderAdjustmentId;
    @SerializedName("order_adjustment_type_id") 
    String orderAdjustmentTypeId;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("ship_group_seq_id") 
    String shipGroupSeqId;
    @SerializedName("comments") 
    String comments;
    @SerializedName("description") 
    String description;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("recurring_amount") 
    java.math.BigDecimal recurringAmount;
    @SerializedName("amount_already_included") 
    java.math.BigDecimal amountAlreadyIncluded;
    @SerializedName("product_promo_id") 
    String productPromoId;
    @SerializedName("product_promo_rule_id") 
    String productPromoRuleId;
    @SerializedName("product_promo_action_seq_id") 
    String productPromoActionSeqId;
    @SerializedName("product_feature_id") 
    String productFeatureId;
    @SerializedName("corresponding_product_id") 
    String correspondingProductId;
    @SerializedName("tax_authority_rate_seq_id") 
    String taxAuthorityRateSeqId;
    @SerializedName("source_reference_id") 
    String sourceReferenceId;
    @SerializedName("source_percentage") 
    java.math.BigDecimal sourcePercentage;
    @SerializedName("customer_reference_id") 
    String customerReferenceId;
    @SerializedName("primary_geo_id") 
    String primaryGeoId;
    @SerializedName("secondary_geo_id") 
    String secondaryGeoId;
    @SerializedName("exempt_amount") 
    java.math.BigDecimal exemptAmount;
    @SerializedName("tax_auth_geo_id") 
    String taxAuthGeoId;
    @SerializedName("tax_auth_party_id") 
    String taxAuthPartyId;
    @SerializedName("override_gl_account_id") 
    String overrideGlAccountId;
    @SerializedName("include_in_tax") 
    Character includeInTax;
    @SerializedName("include_in_shipping") 
    Character includeInShipping;
    @SerializedName("is_manual") 
    Character isManual;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
    @SerializedName("original_adjustment_id") 
    String originalAdjustmentId;
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
        return orderAdjustmentId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderAdjustmentData.Builder toDataBuilder() {
        OrderAdjustmentData.Builder builder = OrderAdjustmentData.newBuilder();
        if (getOrderAdjustmentId() != null) {
            builder.setOrderAdjustmentId(getOrderAdjustmentId());
        }
        if (getOrderAdjustmentTypeId() != null) {
            builder.setOrderAdjustmentTypeId(getOrderAdjustmentTypeId());
        }
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getShipGroupSeqId() != null) {
            builder.setShipGroupSeqId(getShipGroupSeqId());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getRecurringAmount() != null) {
            builder.setRecurringAmount(getCurrency(getRecurringAmount()));
        }
        if (getAmountAlreadyIncluded() != null) {
            builder.setAmountAlreadyIncluded(getCurrency(getAmountAlreadyIncluded()));
        }
        if (getProductPromoId() != null) {
            builder.setProductPromoId(getProductPromoId());
        }
        if (getProductPromoRuleId() != null) {
            builder.setProductPromoRuleId(getProductPromoRuleId());
        }
        if (getProductPromoActionSeqId() != null) {
            builder.setProductPromoActionSeqId(getProductPromoActionSeqId());
        }
        if (getProductFeatureId() != null) {
            builder.setProductFeatureId(getProductFeatureId());
        }
        if (getCorrespondingProductId() != null) {
            builder.setCorrespondingProductId(getCorrespondingProductId());
        }
        if (getTaxAuthorityRateSeqId() != null) {
            builder.setTaxAuthorityRateSeqId(getTaxAuthorityRateSeqId());
        }
        if (getSourceReferenceId() != null) {
            builder.setSourceReferenceId(getSourceReferenceId());
        }
        if (getSourcePercentage() != null) {
            builder.setSourcePercentage(getFixedPoint(getSourcePercentage()));
        }
        if (getCustomerReferenceId() != null) {
            builder.setCustomerReferenceId(getCustomerReferenceId());
        }
        if (getPrimaryGeoId() != null) {
            builder.setPrimaryGeoId(getPrimaryGeoId());
        }
        if (getSecondaryGeoId() != null) {
            builder.setSecondaryGeoId(getSecondaryGeoId());
        }
        if (getExemptAmount() != null) {
            builder.setExemptAmount(getCurrency(getExemptAmount()));
        }
        if (getTaxAuthGeoId() != null) {
            builder.setTaxAuthGeoId(getTaxAuthGeoId());
        }
        if (getTaxAuthPartyId() != null) {
            builder.setTaxAuthPartyId(getTaxAuthPartyId());
        }
        if (getOverrideGlAccountId() != null) {
            builder.setOverrideGlAccountId(getOverrideGlAccountId());
        }
        if (getIncludeInTax() != null) {
            builder.setIncludeInTax(getIndicator(getIncludeInTax()));
        }
        if (getIncludeInShipping() != null) {
            builder.setIncludeInShipping(getIndicator(getIncludeInShipping()));
        }
        if (getIsManual() != null) {
            builder.setIsManual(getIndicator(getIsManual()));
        }
        if (getCreatedDate() != null) {
            builder.setCreatedDate(getTimestamp(getCreatedDate()));
        }
        if (getCreatedByUserLogin() != null) {
            builder.setCreatedByUserLogin(getCreatedByUserLogin());
        }
        if (getLastModifiedDate() != null) {
            builder.setLastModifiedDate(getTimestamp(getLastModifiedDate()));
        }
        if (getLastModifiedByUserLogin() != null) {
            builder.setLastModifiedByUserLogin(getLastModifiedByUserLogin());
        }
        if (getOriginalAdjustmentId() != null) {
            builder.setOriginalAdjustmentId(getOriginalAdjustmentId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static OrderAdjustment fromData(OrderAdjustmentData data) {
        return fromPrototype(data).build();
    }

    public static OrderAdjustment.OrderAdjustmentBuilder fromPrototype(OrderAdjustmentData data) {
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
                ;
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

