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

import com.bluecc.hubs.stub.ProductPriceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPriceData.class,
        symbol = EntityNames.ProductPrice)
public class ProductPrice implements IEventModel<ProductPriceData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RIndex 
    String productId;
    @SerializedName("product_price_type_id")
	@RIndex 
    String productPriceTypeId;
    @SerializedName("product_price_purpose_id")
	@RIndex 
    String productPricePurposeId;
    @SerializedName("currency_uom_id")
	@RIndex 
    String currencyUomId;
    @SerializedName("product_store_group_id")
	@RIndex 
    String productStoreGroupId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("price") 
    java.math.BigDecimal price;
    @SerializedName("term_uom_id") 
    String termUomId;
    @SerializedName("custom_price_calc_service") 
    String customPriceCalcService;
    @SerializedName("price_without_tax") 
    java.math.BigDecimal priceWithoutTax;
    @SerializedName("price_with_tax") 
    java.math.BigDecimal priceWithTax;
    @SerializedName("tax_amount") 
    java.math.BigDecimal taxAmount;
    @SerializedName("tax_percentage") 
    java.math.BigDecimal taxPercentage;
    @SerializedName("tax_auth_party_id") 
    String taxAuthPartyId;
    @SerializedName("tax_auth_geo_id") 
    String taxAuthGeoId;
    @SerializedName("tax_in_price") 
    Character taxInPrice;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login") 
    String lastModifiedByUserLogin;
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

    public ProductPriceData.Builder toDataBuilder() {
        ProductPriceData.Builder builder = ProductPriceData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productPriceTypeId != null) {
            builder.setProductPriceTypeId(productPriceTypeId);
        }
        if (productPricePurposeId != null) {
            builder.setProductPricePurposeId(productPricePurposeId);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (productStoreGroupId != null) {
            builder.setProductStoreGroupId(productStoreGroupId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (price != null) {
            builder.setPrice(getCurrency(price));
        }
        if (termUomId != null) {
            builder.setTermUomId(termUomId);
        }
        if (customPriceCalcService != null) {
            builder.setCustomPriceCalcService(customPriceCalcService);
        }
        if (priceWithoutTax != null) {
            builder.setPriceWithoutTax(getCurrency(priceWithoutTax));
        }
        if (priceWithTax != null) {
            builder.setPriceWithTax(getCurrency(priceWithTax));
        }
        if (taxAmount != null) {
            builder.setTaxAmount(getCurrency(taxAmount));
        }
        if (taxPercentage != null) {
            builder.setTaxPercentage(getFixedPoint(taxPercentage));
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxInPrice != null) {
            builder.setTaxInPrice(getIndicator(taxInPrice));
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

    public static ProductPrice fromData(ProductPriceData data) {
        return ProductPrice.builder()
                .productId(data.getProductId())
                .productPriceTypeId(data.getProductPriceTypeId())
                .productPricePurposeId(data.getProductPricePurposeId())
                .currencyUomId(data.getCurrencyUomId())
                .productStoreGroupId(data.getProductStoreGroupId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .price(getBigDecimal(data.getPrice()))
                .termUomId(data.getTermUomId())
                .customPriceCalcService(data.getCustomPriceCalcService())
                .priceWithoutTax(getBigDecimal(data.getPriceWithoutTax()))
                .priceWithTax(getBigDecimal(data.getPriceWithTax()))
                .taxAmount(getBigDecimal(data.getTaxAmount()))
                .taxPercentage(getBigDecimal(data.getTaxPercentage()))
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxInPrice(getIndicatorChar(data.getTaxInPrice()))
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productId, productPriceTypeId, productPricePurposeId, currencyUomId, productStoreGroupId, fromDate

-- fields --
    
    String productId
    String productPriceTypeId
    String productPricePurposeId
    String currencyUomId
    String productStoreGroupId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.math.BigDecimal price
    String termUomId
    String customPriceCalcService
    java.math.BigDecimal priceWithoutTax
    java.math.BigDecimal priceWithTax
    java.math.BigDecimal taxAmount
    java.math.BigDecimal taxPercentage
    String taxAuthPartyId
    String taxAuthGeoId
    Character taxInPrice
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - Product (one, autoRelation: false, keymaps: productId)
    - ProductPriceType (one, autoRelation: false, keymaps: productPriceTypeId)
    - ProductPricePurpose (one, autoRelation: false, keymaps: productPricePurposeId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - TermUom (one, autoRelation: false, keymaps: termUomId -> uomId)
    - ProductStoreGroup (one, autoRelation: false, keymaps: productStoreGroupId)
    - CustomMethod (one, autoRelation: false, keymaps: customPriceCalcService -> customMethodId)
    - TaxAuthorityParty (one, autoRelation: false, keymaps: taxAuthPartyId -> partyId)
    - TaxAuthorityGeo (one, autoRelation: false, keymaps: taxAuthGeoId -> geoId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    + ProductPriceChange (many, autoRelation: true, keymaps: productId, productPriceTypeId, productPricePurposeId, currencyUomId, productStoreGroupId, fromDate)
*/

