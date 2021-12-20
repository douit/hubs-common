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

import com.bluecc.hubs.stub.QuoteAdjustmentData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = QuoteAdjustmentData.class,
        symbol = EntityNames.QuoteAdjustment)
public class QuoteAdjustment implements IEventModel<QuoteAdjustmentData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("quote_adjustment_id")
	@RId 
    String quoteAdjustmentId;
    @SerializedName("quote_adjustment_type_id") 
    String quoteAdjustmentTypeId;
    @SerializedName("quote_id") 
    String quoteId;
    @SerializedName("quote_item_seq_id") 
    String quoteItemSeqId;
    @SerializedName("comments") 
    String comments;
    @SerializedName("description") 
    String description;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
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
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
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
        return quoteAdjustmentId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public QuoteAdjustmentData.Builder toDataBuilder() {
        QuoteAdjustmentData.Builder builder = QuoteAdjustmentData.newBuilder();
        if (getQuoteAdjustmentId() != null) {
            builder.setQuoteAdjustmentId(getQuoteAdjustmentId());
        }
        if (getQuoteAdjustmentTypeId() != null) {
            builder.setQuoteAdjustmentTypeId(getQuoteAdjustmentTypeId());
        }
        if (getQuoteId() != null) {
            builder.setQuoteId(getQuoteId());
        }
        if (getQuoteItemSeqId() != null) {
            builder.setQuoteItemSeqId(getQuoteItemSeqId());
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
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static QuoteAdjustment fromData(QuoteAdjustmentData data) {
        return fromPrototype(data).build();
    }

    public static QuoteAdjustment.QuoteAdjustmentBuilder fromPrototype(QuoteAdjustmentData data) {
        return QuoteAdjustment.builder()
                .quoteAdjustmentId(data.getQuoteAdjustmentId())
                .quoteAdjustmentTypeId(data.getQuoteAdjustmentTypeId())
                .quoteId(data.getQuoteId())
                .quoteItemSeqId(data.getQuoteItemSeqId())
                .comments(data.getComments())
                .description(data.getDescription())
                .amount(getBigDecimal(data.getAmount()))
                .productPromoId(data.getProductPromoId())
                .productPromoRuleId(data.getProductPromoRuleId())
                .productPromoActionSeqId(data.getProductPromoActionSeqId())
                .productFeatureId(data.getProductFeatureId())
                .correspondingProductId(data.getCorrespondingProductId())
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
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: quoteAdjustmentId

-- fields --
    
    String quoteAdjustmentId
    String quoteAdjustmentTypeId
    String quoteId
    String quoteItemSeqId
    String comments
    String description
    java.math.BigDecimal amount
    String productPromoId
    String productPromoRuleId
    String productPromoActionSeqId
    String productFeatureId
    String correspondingProductId
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
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - OrderAdjustmentType (one, autoRelation: false, keymaps: quoteAdjustmentTypeId -> orderAdjustmentTypeId)
    - Quote (one, autoRelation: false, keymaps: quoteId)
    - UserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - QuoteItem (one-nofk, autoRelation: false, keymaps: quoteId, quoteItemSeqId)
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - ProductPromoRule (one-nofk, autoRelation: false, keymaps: productPromoId, productPromoRuleId)
    - ProductPromoAction (one-nofk, autoRelation: false, keymaps: productPromoId, productPromoRuleId, productPromoActionSeqId)
    - PrimaryGeo (one, autoRelation: false, keymaps: primaryGeoId -> geoId)
    - SecondaryGeo (one, autoRelation: false, keymaps: secondaryGeoId -> geoId)
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
    - OverrideGlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
*/

