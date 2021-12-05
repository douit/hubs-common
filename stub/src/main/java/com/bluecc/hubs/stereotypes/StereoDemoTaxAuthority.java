package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.TaxAuthorityRateProductData;

public final class StereoDemoTaxAuthority {
    public final static TaxAuthorityRateProductData TaxAuthorityRateProduct_9000 = TaxAuthorityRateProductData.newBuilder()
        .setDescription("1% OFB _NA_ Tax")
        .setFromDate(getTimestamp("2001-05-13 00:00:00.001"))
        .setMinItemPrice(getCurrency("25.00"))
        .setMinPurchase(getCurrency("0.00"))
        .setProductCategoryId("")
        .setProductStoreId("")
        .setTaxAuthGeoId("_NA_")
        .setTaxAuthPartyId("_NA_")
        .setTaxAuthorityRateSeqId("9000")
        .setTaxAuthorityRateTypeId("SALES_TAX")
        .setTaxPercentage(getFixedPoint("1"))
        .setTaxPromotions(castIndicator("N"))
        .setTaxShipping(castIndicator("N"))
        .setThruDate(getTimestamp(""))
        .setTitleTransferEnumId("")
        .build();


    public final static TaxAuthorityRateProductData TaxAuthorityRateProduct_9001 = TaxAuthorityRateProductData.newBuilder()
        .setDescription("California State Sales Tax")
        .setFromDate(getTimestamp("2001-05-13 00:00:00.001"))
        .setMinItemPrice(getCurrency("0.00"))
        .setMinPurchase(getCurrency("0.00"))
        .setProductCategoryId("")
        .setProductStoreId("")
        .setTaxAuthGeoId("CA")
        .setTaxAuthPartyId("CA_BOE")
        .setTaxAuthorityRateSeqId("9001")
        .setTaxAuthorityRateTypeId("SALES_TAX")
        .setTaxPercentage(getFixedPoint("6.25"))
        .setTaxPromotions(castIndicator("N"))
        .setTaxShipping(castIndicator("N"))
        .setThruDate(getTimestamp(""))
        .setTitleTransferEnumId("")
        .build();


    public final static TaxAuthorityRateProductData TaxAuthorityRateProduct_9002 = TaxAuthorityRateProductData.newBuilder()
        .setDescription("New York State Sales Tax")
        .setFromDate(getTimestamp("2001-05-13 00:00:00.001"))
        .setMinItemPrice(getCurrency("0.00"))
        .setMinPurchase(getCurrency("0.00"))
        .setProductCategoryId("")
        .setProductStoreId("")
        .setTaxAuthGeoId("NY")
        .setTaxAuthPartyId("NY_DTF")
        .setTaxAuthorityRateSeqId("9002")
        .setTaxAuthorityRateTypeId("SALES_TAX")
        .setTaxPercentage(getFixedPoint("4.25"))
        .setTaxPromotions(castIndicator("N"))
        .setTaxShipping(castIndicator("N"))
        .setThruDate(getTimestamp(""))
        .setTitleTransferEnumId("")
        .build();


    public final static TaxAuthorityRateProductData TaxAuthorityRateProduct_9003 = TaxAuthorityRateProductData.newBuilder()
        .setDescription("Texas State Sales Tax")
        .setFromDate(getTimestamp("2001-05-13 00:00:00.001"))
        .setMinItemPrice(getCurrency("0.00"))
        .setMinPurchase(getCurrency("0.00"))
        .setProductCategoryId("")
        .setProductStoreId("")
        .setTaxAuthGeoId("TX")
        .setTaxAuthPartyId("TX_TAXMAN")
        .setTaxAuthorityRateSeqId("9003")
        .setTaxAuthorityRateTypeId("SALES_TAX")
        .setTaxPercentage(getFixedPoint("6.25"))
        .setTaxPromotions(castIndicator("N"))
        .setTaxShipping(castIndicator("N"))
        .setThruDate(getTimestamp(""))
        .setTitleTransferEnumId("")
        .build();


    public final static TaxAuthorityRateProductData TaxAuthorityRateProduct_9004 = TaxAuthorityRateProductData.newBuilder()
        .setDescription("Utah State Sales Tax")
        .setFromDate(getTimestamp("2001-05-13 00:00:00.001"))
        .setMinItemPrice(getCurrency("0.00"))
        .setMinPurchase(getCurrency("0.00"))
        .setProductCategoryId("")
        .setProductStoreId("")
        .setTaxAuthGeoId("UT")
        .setTaxAuthPartyId("UT_TAXMAN")
        .setTaxAuthorityRateSeqId("9004")
        .setTaxAuthorityRateTypeId("SALES_TAX")
        .setTaxPercentage(getFixedPoint("4.75"))
        .setTaxPromotions(castIndicator("N"))
        .setTaxShipping(castIndicator("N"))
        .setThruDate(getTimestamp(""))
        .setTitleTransferEnumId("")
        .build();


    public final static TaxAuthorityRateProductData TaxAuthorityRateProduct_9005 = TaxAuthorityRateProductData.newBuilder()
        .setDescription("Utah County, Utah Sales Tax")
        .setFromDate(getTimestamp("2001-05-13 00:00:00.001"))
        .setMinItemPrice(getCurrency("0.00"))
        .setMinPurchase(getCurrency("0.00"))
        .setProductCategoryId("")
        .setProductStoreId("")
        .setTaxAuthGeoId("UT-UTAH")
        .setTaxAuthPartyId("UT_UTAH_TAXMAN")
        .setTaxAuthorityRateSeqId("9005")
        .setTaxAuthorityRateTypeId("SALES_TAX")
        .setTaxPercentage(getFixedPoint("0.1"))
        .setTaxShipping(castIndicator("N"))
        .setThruDate(getTimestamp(""))
        .setTitleTransferEnumId("")
        .build();

}
