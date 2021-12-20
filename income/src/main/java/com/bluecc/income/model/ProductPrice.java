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
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPriceData.Builder toDataBuilder() {
        ProductPriceData.Builder builder = ProductPriceData.newBuilder();
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getProductPriceTypeId() != null) {
            builder.setProductPriceTypeId(getProductPriceTypeId());
        }
        if (getProductPricePurposeId() != null) {
            builder.setProductPricePurposeId(getProductPricePurposeId());
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getProductStoreGroupId() != null) {
            builder.setProductStoreGroupId(getProductStoreGroupId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getPrice() != null) {
            builder.setPrice(getCurrency(getPrice()));
        }
        if (getTermUomId() != null) {
            builder.setTermUomId(getTermUomId());
        }
        if (getCustomPriceCalcService() != null) {
            builder.setCustomPriceCalcService(getCustomPriceCalcService());
        }
        if (getPriceWithoutTax() != null) {
            builder.setPriceWithoutTax(getCurrency(getPriceWithoutTax()));
        }
        if (getPriceWithTax() != null) {
            builder.setPriceWithTax(getCurrency(getPriceWithTax()));
        }
        if (getTaxAmount() != null) {
            builder.setTaxAmount(getCurrency(getTaxAmount()));
        }
        if (getTaxPercentage() != null) {
            builder.setTaxPercentage(getFixedPoint(getTaxPercentage()));
        }
        if (getTaxAuthPartyId() != null) {
            builder.setTaxAuthPartyId(getTaxAuthPartyId());
        }
        if (getTaxAuthGeoId() != null) {
            builder.setTaxAuthGeoId(getTaxAuthGeoId());
        }
        if (getTaxInPrice() != null) {
            builder.setTaxInPrice(getIndicator(getTaxInPrice()));
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
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static ProductPrice fromData(ProductPriceData data) {
        return fromPrototype(data).build();
    }

    public static ProductPrice.ProductPriceBuilder fromPrototype(ProductPriceData data) {
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
                ;
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

