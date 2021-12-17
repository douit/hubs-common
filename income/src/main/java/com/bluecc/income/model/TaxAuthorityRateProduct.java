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

import com.bluecc.hubs.stub.TaxAuthorityRateProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = TaxAuthorityRateProductData.class,
        symbol = EntityNames.TaxAuthorityRateProduct)
public class TaxAuthorityRateProduct implements IEventModel<TaxAuthorityRateProductData.Builder>, HasId, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("tax_authority_rate_seq_id")
	@RId 
    String taxAuthorityRateSeqId;
    @SerializedName("tax_auth_geo_id") 
    String taxAuthGeoId;
    @SerializedName("tax_auth_party_id") 
    String taxAuthPartyId;
    @SerializedName("tax_authority_rate_type_id") 
    String taxAuthorityRateTypeId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("product_category_id") 
    String productCategoryId;
    @SerializedName("title_transfer_enum_id") 
    String titleTransferEnumId;
    @SerializedName("min_item_price") 
    java.math.BigDecimal minItemPrice;
    @SerializedName("min_purchase") 
    java.math.BigDecimal minPurchase;
    @SerializedName("tax_shipping") 
    Character taxShipping;
    @SerializedName("tax_percentage") 
    java.math.BigDecimal taxPercentage;
    @SerializedName("tax_promotions") 
    Character taxPromotions;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("description") 
    String description;
    @SerializedName("is_tax_in_shipping_price") 
    Character isTaxInShippingPrice;
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
        return taxAuthorityRateSeqId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TaxAuthorityRateProductData.Builder toDataBuilder() {
        TaxAuthorityRateProductData.Builder builder = TaxAuthorityRateProductData.newBuilder();
        if (taxAuthorityRateSeqId != null) {
            builder.setTaxAuthorityRateSeqId(taxAuthorityRateSeqId);
        }
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (taxAuthorityRateTypeId != null) {
            builder.setTaxAuthorityRateTypeId(taxAuthorityRateTypeId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (titleTransferEnumId != null) {
            builder.setTitleTransferEnumId(titleTransferEnumId);
        }
        if (minItemPrice != null) {
            builder.setMinItemPrice(getCurrency(minItemPrice));
        }
        if (minPurchase != null) {
            builder.setMinPurchase(getCurrency(minPurchase));
        }
        if (taxShipping != null) {
            builder.setTaxShipping(getIndicator(taxShipping));
        }
        if (taxPercentage != null) {
            builder.setTaxPercentage(getFixedPoint(taxPercentage));
        }
        if (taxPromotions != null) {
            builder.setTaxPromotions(getIndicator(taxPromotions));
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (isTaxInShippingPrice != null) {
            builder.setIsTaxInShippingPrice(getIndicator(isTaxInShippingPrice));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static TaxAuthorityRateProduct fromData(TaxAuthorityRateProductData data) {
        return TaxAuthorityRateProduct.builder()
                .taxAuthorityRateSeqId(data.getTaxAuthorityRateSeqId())
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .taxAuthorityRateTypeId(data.getTaxAuthorityRateTypeId())
                .productStoreId(data.getProductStoreId())
                .productCategoryId(data.getProductCategoryId())
                .titleTransferEnumId(data.getTitleTransferEnumId())
                .minItemPrice(getBigDecimal(data.getMinItemPrice()))
                .minPurchase(getBigDecimal(data.getMinPurchase()))
                .taxShipping(getIndicatorChar(data.getTaxShipping()))
                .taxPercentage(getBigDecimal(data.getTaxPercentage()))
                .taxPromotions(getIndicatorChar(data.getTaxPromotions()))
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .description(data.getDescription())
                .isTaxInShippingPrice(getIndicatorChar(data.getIsTaxInShippingPrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: taxAuthorityRateSeqId

-- fields --
    
    String taxAuthorityRateSeqId
    String taxAuthGeoId
    String taxAuthPartyId
    String taxAuthorityRateTypeId
    String productStoreId
    String productCategoryId
    String titleTransferEnumId
    java.math.BigDecimal minItemPrice
    java.math.BigDecimal minPurchase
    Character taxShipping
    java.math.BigDecimal taxPercentage
    Character taxPromotions
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String description
    Character isTaxInShippingPrice

-- relations --
    
    - TaxAuthority (one, autoRelation: false, keymaps: taxAuthGeoId, taxAuthPartyId)
    - TaxAuthorityRateType (one, autoRelation: false, keymaps: taxAuthorityRateTypeId)
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - ProductCategory (one, autoRelation: false, keymaps: productCategoryId)
    + InvoiceItem (many, autoRelation: true, keymaps: taxAuthorityRateSeqId)
    + OrderAdjustment (many, autoRelation: true, keymaps: taxAuthorityRateSeqId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: taxAuthorityRateSeqId)
*/

