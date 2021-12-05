package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.PartyGroupFlatData;
import com.bluecc.hubs.stub.ContactMechData;
import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.hubs.stub.SupplierProductData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PartyContactMechPurposeData;
import com.bluecc.hubs.stub.SupplierProductFeatureData;
import com.bluecc.hubs.stub.UserLoginSecurityGroupData;
import com.bluecc.hubs.stub.UserLoginFlatData;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.AgreementItemData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ProductContentData;
import com.bluecc.hubs.stub.PostalAddressData;
import com.bluecc.hubs.stub.AgreementData;
import com.bluecc.hubs.stub.AgreementTermData;
import com.bluecc.hubs.stub.ProductCategoryMemberData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductCategoryContentData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class StereoDemoPurchasing {
    public final static ElectronicTextData ElectronicText_dropShip_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("dropShip-ALT")
        .setTextData("dropship")
        .build();


    public final static ElectronicTextData ElectronicText_dropShip1_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("dropShip1-ALT")
        .setTextData("dropship1")
        .build();


    public final static ElectronicTextData ElectronicText_dropShip2_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("dropShip2-ALT")
        .setTextData("dropship2")
        .build();


    public final static ElectronicTextData ElectronicText_dropShip3_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("dropShip3-ALT")
        .setTextData("dropship3")
        .build();


    public final static ElectronicTextData ElectronicText_orderWhenSold_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("orderWhenSold-ALT")
        .setTextData("order-when-sold")
        .build();


    public final static ElectronicTextData ElectronicText_DRdropShip_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRdropShip-ALTEN")
        .setTextData("dropship")
        .build();


    public final static ElectronicTextData ElectronicText_DRdropShip1_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRdropShip1-ALTEN")
        .setTextData("dropship1")
        .build();


    public final static ElectronicTextData ElectronicText_DRdropShip2_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRdropShip2-ALTEN")
        .setTextData("dropship2")
        .build();


    public final static ElectronicTextData ElectronicText_DRdropShip3_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRdropShip3-ALTEN")
        .setTextData("dropship3")
        .build();


    public final static ElectronicTextData ElectronicText_DRorderWhenSold_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("DRorderWhenSold-ALT")
        .setTextData("order-when-sold")
        .build();


    public final static ContentAssocData ContentAssoc_dropShip_ALT_CdropShip_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("dropShip-ALT")
        .setContentIdTo("CdropShip-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_dropShip1_ALT_CdropShip1_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("dropShip1-ALT")
        .setContentIdTo("CdropShip1-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_dropShip2_ALT_CdropShip2_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("dropShip2-ALT")
        .setContentIdTo("CdropShip2-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_dropShip3_ALT_CdropShip3_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("dropShip3-ALT")
        .setContentIdTo("CdropShip3-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_orderWhenSold_ALT_CorderWhenSold_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("orderWhenSold-ALT")
        .setContentIdTo("CorderWhenSold-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ProductFlatData Product_dropShip1 = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-05-05 14:50:58.584"))
        .setInShippingBox(castIndicator("N"))
        .setInternalName("DropShip from DemoSupplier")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLargeImageUrl("/images/products/dropShip1/large.jpg")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2007-05-05 15:05:41.62"))
        .setMediumImageUrl("/images/products/dropShip1/medium.jpg")
        .setProductId("dropShip1")
        .setProductName("DropShip from DemoSupplier")
        .setProductTypeId("FINISHED_GOOD")
        .setRequirementMethodEnumId("PRODRQM_DS")
        .setSmallImageUrl("/images/products/dropShip1/small.jpg")
        .build();


    public final static ProductFlatData Product_dropShip2 = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-05-05 14:50:58.584"))
        .setInShippingBox(castIndicator("N"))
        .setInternalName("DropShip from BigSupplier")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLargeImageUrl("/images/products/dropShip2/large.jpg")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2007-05-05 15:05:41.62"))
        .setMediumImageUrl("/images/products/dropShip2/medium.jpg")
        .setProductId("dropShip2")
        .setProductName("DropShip from BigSupplier")
        .setProductTypeId("FINISHED_GOOD")
        .setRequirementMethodEnumId("PRODRQM_DS")
        .setSmallImageUrl("/images/products/dropShip2/small.jpg")
        .build();


    public final static ProductFlatData Product_dropShip3 = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-05-05 14:50:58.584"))
        .setInShippingBox(castIndicator("N"))
        .setInternalName("DropShip from EuroSupplier")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLargeImageUrl("/images/products/dropShip3/large.jpg")
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2007-05-05 15:05:41.62"))
        .setMediumImageUrl("/images/products/dropShip3/medium.jpg")
        .setProductId("dropShip3")
        .setProductName("DropShip from EuroSupplier")
        .setProductTypeId("FINISHED_GOOD")
        .setRequirementMethodEnumId("PRODRQM_DS")
        .setSmallImageUrl("/images/products/dropShip3/small.jpg")
        .build();


    public final static ProductFlatData Product_orderWhenSold = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-05-05 14:50:58.584"))
        .setInShippingBox(castIndicator("N"))
        .setInternalName("Order product from DemoSupplier when sold")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLargeImageUrl("/images/products/orderWhenSold/large.jpg")
        .setMediumImageUrl("/images/products/orderWhenSold/medium.jpg")
        .setProductId("orderWhenSold")
        .setProductName("Order product from DemoSupplier when sold")
        .setProductTypeId("FINISHED_GOOD")
        .setRequirementMethodEnumId("PRODRQM_AUTO")
        .setSmallImageUrl("/images/products/orderWhenSold/small.jpg")
        .build();


    public final static ProductPriceData ProductPrice_dropShip1_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("13.99"))
        .setProductId("dropShip1")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_dropShip2_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("15.99"))
        .setProductId("dropShip2")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_dropShip3_DEFAULT_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("14.99"))
        .setProductId("dropShip3")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_dropShip3_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("14.99"))
        .setProductId("dropShip3")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_orderWhenSold_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("13.99"))
        .setProductId("orderWhenSold")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static PartyGroupFlatData PartyGroup_BigSupplier = PartyGroupFlatData.newBuilder()
        .setGroupName("Big Supplier")
        .setPartyId("BigSupplier")
        .build();


    public final static PartyGroupFlatData PartyGroup_EuroSupplier = PartyGroupFlatData.newBuilder()
        .setGroupName("European Supplier")
        .setPartyId("EuroSupplier")
        .build();


    public final static ContactMechData ContactMech_9002 = ContactMechData.newBuilder()
        .setContactMechId("9002")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ContactMechData ContactMech_9003 = ContactMechData.newBuilder()
        .setContactMechId("9003")
        .setContactMechTypeId("POSTAL_ADDRESS")
        .build();


    public final static ProductCategoryRollupData ProductCategoryRollup_dropShip_CATALOG1_ = ProductCategoryRollupData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setParentProductCategoryId("CATALOG1")
        .setProductCategoryId("dropShip")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1000_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("7.5"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1000")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("GZ-1000-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1001_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("12.99"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1001")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("GZ-1001-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1005_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("1399.5"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1005")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("GZ-1005-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1006_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("2.99"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1006")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("GZ-1006-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2002_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("24.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-2002")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("GZ-2002-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2644_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("24.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-2644")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("GZ-2644-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_5005_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("24.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-5005")
        .setSupplierProductId("GZ-5005-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_7000_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("499.99"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-7000")
        .setSupplierProductId("GZ-7000-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_8544_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("135.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-8544")
        .setSupplierProductId("GZ-8544-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_9290_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("49.99"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-9290")
        .setSupplierProductId("GZ-9290-0")
        .build();


    public final static SupplierProductData SupplierProduct_WG_1111_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("30.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-1111")
        .setSupplierProductId("WG-1111-0")
        .build();


    public final static SupplierProductData SupplierProduct_WG_5569_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("30.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-5569")
        .setSupplierProductId("WG-5569-0")
        .build();


    public final static SupplierProductData SupplierProduct_WG_9943_DemoSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("275.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-9943")
        .setSupplierProductId("WG-9943-0")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1000_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("6.75"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1000")
        .setSupplierProductId("GZ-1000-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1001_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("11.69"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1001")
        .setSupplierProductId("GZ-1001-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1005_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("1259.55"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1005")
        .setSupplierProductId("GZ-1005-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1006_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("2.69"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1006")
        .setSupplierProductId("GZ-1006-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2002_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("21.6"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-2002")
        .setSupplierProductId("GZ-2002-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2644_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("21.6"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-2644")
        .setSupplierProductId("GZ-2644-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_5005_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("21.6"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-5005")
        .setSupplierProductId("GZ-5005-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_7000_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("449.99"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-7000")
        .setSupplierProductId("GZ-7000-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_8544_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("121.5"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-8544")
        .setSupplierProductId("GZ-8544-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_9290_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("44.99"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-9290")
        .setSupplierProductId("GZ-9290-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_WG_1111_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("27.0"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-1111")
        .setSupplierProductId("WG-1111-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_WG_5569_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("27.0"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-5569")
        .setSupplierProductId("WG-5569-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_WG_9943_DemoSupplier_USD_5_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("247.5"))
        .setMinimumOrderQuantity(getFixedPoint("5"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-9943")
        .setSupplierProductId("WG-9943-5")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1000_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("5.65"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1000")
        .setSupplierProductId("GZ-1000-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1001_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("9.75"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1001")
        .setSupplierProductId("GZ-1001-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1005_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("1049.65"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1005")
        .setSupplierProductId("GZ-1005-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1006_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("2.25"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-1006")
        .setSupplierProductId("GZ-1006-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2002_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("18.0"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-2002")
        .setSupplierProductId("GZ-2002-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2644_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("18.0"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-2644")
        .setSupplierProductId("GZ-2644-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_5005_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("18.0"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-5005")
        .setSupplierProductId("GZ-5005-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_7000_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("374.00"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-7000")
        .setSupplierProductId("GZ-7000-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_8544_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("101.25"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-8544")
        .setSupplierProductId("GZ-8544-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_9290_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("37.5"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("GZ-9290")
        .setSupplierProductId("GZ-9290-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_WG_1111_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("22.5"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-1111")
        .setSupplierProductId("WG-1111-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_WG_5569_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("22.5"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-5569")
        .setSupplierProductId("WG-5569-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_WG_9943_DemoSupplier_USD_25_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("206.25"))
        .setMinimumOrderQuantity(getFixedPoint("25"))
        .setPartyId("DemoSupplier")
        .setProductId("WG-9943")
        .setSupplierProductId("WG-9943-25")
        .setSupplierProductName("")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1000_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("3.75"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-1000")
        .setSupplierProductId("BKGZ-1000")
        .setSupplierProductName("Bulk Tiny Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1001_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("6.49"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-1001")
        .setSupplierProductId("BKGZ-1001")
        .setSupplierProductName("Bulk Nan Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1005_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("699.75"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-1005")
        .setSupplierProductId("BKGZ-1005")
        .setSupplierProductName("Bulk .NIT Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1006_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("1.4975"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-1006")
        .setSupplierProductId("BKGZ-1006")
        .setSupplierProductName("Bulk Open Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2002_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("12.0"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-2002")
        .setSupplierProductId("BKGZ-2002")
        .setSupplierProductName("Bulk Square Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2644_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("12.0"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-2644")
        .setSupplierProductId("BKGZ-2644")
        .setSupplierProductName("Bulk Round Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_5005_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("12.0"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-5005")
        .setSupplierProductId("BKGZ-5005")
        .setSupplierProductName("Bulk Purple Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_7000_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("249.99"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-7000")
        .setSupplierProductId("BKGZ-7000")
        .setSupplierProductName("Bulk Massive Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_8544_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("67.5"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-8544")
        .setSupplierProductId("BKGZ-8544")
        .setSupplierProductName("Bulk Big Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_9290_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("24.99"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("GZ-9290")
        .setSupplierProductId("BKGZ-9290")
        .setSupplierProductName("Bulk His/Her Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_WG_1111_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("15.0"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("WG-1111")
        .setSupplierProductId("BKWG-1111")
        .setSupplierProductName("Bulk Micro Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_5569_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("15.0"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("WG-5569")
        .setSupplierProductId("BKWG-5569")
        .setSupplierProductName("Bulk Tiny Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_9943_BigSupplier_USD_500_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("137.5"))
        .setMinimumOrderQuantity(getFixedPoint("500"))
        .setPartyId("BigSupplier")
        .setProductId("WG-9943")
        .setSupplierProductId("BKWG-9943")
        .setSupplierProductName("Bulk Giant Widget")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1000_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("6.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1000")
        .setSupplierProductId("USGZ-1000")
        .setSupplierProductName("US Tiny Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1001_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("10.40"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1001")
        .setSupplierProductId("USGZ-1001")
        .setSupplierProductName("US Nan Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1005_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("1119.6"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1005")
        .setSupplierProductId("USGZ-1005")
        .setSupplierProductName("US .NIT Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1006_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("2.396"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1006")
        .setSupplierProductId("USGZ-1006")
        .setSupplierProductName("US Open Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2002_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("19.2"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-2002")
        .setSupplierProductId("USGZ-2002")
        .setSupplierProductName("US Square Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2644_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("19.2"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-2644")
        .setSupplierProductId("USGZ-2644")
        .setSupplierProductName("US Round Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_5005_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("19.2"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-5005")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("USGZ-5005")
        .setSupplierProductName("US Purple Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_7000_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("400.00"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-7000")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("USGZ-7000")
        .setSupplierProductName("US Massive Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_8544_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("108.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-8544")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("USGZ-8544")
        .setSupplierProductName("US Big Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_9290_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("40.00"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-9290")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("USGZ-9290")
        .setSupplierProductName("US His/Her Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_WG_1111_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("24.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-1111")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("USWG-1111")
        .setSupplierProductName("US Micro Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_5569_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("24.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-5569")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("USWG-5569")
        .setSupplierProductName("US Tiny Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_9943_EuroSupplier_USD_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("220.0"))
        .setMinimumOrderQuantity(getFixedPoint("0"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-9943")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .setSupplierProductId("USWG-9943")
        .setSupplierProductName("US Giant Widget")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1000_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("4.6"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1000")
        .setSupplierProductId("US1-GZ-1000")
        .setSupplierProductName("US Tiny Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1001_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("7.23"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1001")
        .setSupplierProductId("US1-GZ-1001")
        .setSupplierProductName("US Nan Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1005_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("771.75"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1005")
        .setSupplierProductId("US1-GZ-1005")
        .setSupplierProductName("US .NIT Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1006_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("1.75"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1006")
        .setSupplierProductId("US1-GZ-1006")
        .setSupplierProductName("US Open Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2002_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("16.52"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-2002")
        .setSupplierProductId("US1-GZ-2002")
        .setSupplierProductName("US Square Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2644_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("16.52"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-2644")
        .setSupplierProductId("US1-GZ-2644")
        .setSupplierProductName("US Round Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_5005_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("16.52"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-5005")
        .setSupplierProductId("US1-GZ-5005")
        .setSupplierProductName("US Purple Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_7000_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("340.0"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-7000")
        .setSupplierProductId("US1-GZ-7000")
        .setSupplierProductName("US Massive Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_8544_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("85.0"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-8544")
        .setSupplierProductId("US1-GZ-8544")
        .setSupplierProductName("US Big Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_9290_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("34.0"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-9290")
        .setSupplierProductId("US1-GZ-9290")
        .setSupplierProductName("US His/Her Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_WG_1111_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("20.00"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-1111")
        .setSupplierProductId("US1-WG-1111")
        .setSupplierProductName("US Micro Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_5569_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("20.00"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-5569")
        .setSupplierProductId("US1-WG-5569")
        .setSupplierProductName("US Tiny Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_9943_EuroSupplier_USD_10_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("180.0"))
        .setMinimumOrderQuantity(getFixedPoint("10"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-9943")
        .setSupplierProductId("US1-WG-9943")
        .setSupplierProductName("US Giant Widget")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1000_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("3.0"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1000")
        .setSupplierProductId("EU-GZ-1000")
        .setSupplierProductName("EU Tiny Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1001_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("5.20"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1001")
        .setSupplierProductId("EU-GZ-1001")
        .setSupplierProductName("EU Nan Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1005_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("559.8"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1005")
        .setSupplierProductId("EU-GZ-1005")
        .setSupplierProductName("EU .NIT Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_1006_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("1.198"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-1006")
        .setSupplierProductId("EU-GZ-1006")
        .setSupplierProductName("EU Open Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2002_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("9.6"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-2002")
        .setSupplierProductId("EU-GZ-2002")
        .setSupplierProductName("EU Square Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_2644_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("9.6"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-2644")
        .setSupplierProductId("EU-GZ-2644")
        .setSupplierProductName("EU Round Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_5005_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("9.6"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-5005")
        .setSupplierProductId("EU-GZ-5005")
        .setSupplierProductName("EU Purple Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_7000_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("200.00"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-7000")
        .setSupplierProductId("EU-GZ-7000")
        .setSupplierProductName("EU Massive Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_8544_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("54.0"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-8544")
        .setSupplierProductId("EU-GZ-8544")
        .setSupplierProductName("EU Big Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_GZ_9290_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("20.00"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("GZ-9290")
        .setSupplierProductId("EU-GZ-9290")
        .setSupplierProductName("EU His/Her Gizmo")
        .build();


    public final static SupplierProductData SupplierProduct_WG_1111_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("12.0"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-1111")
        .setSupplierProductId("EU-WG-1111")
        .setSupplierProductName("EU Micro Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_5569_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("12.0"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-5569")
        .setSupplierProductId("EU-WG-5569")
        .setSupplierProductName("EU Tiny Chrome Widget")
        .build();


    public final static SupplierProductData SupplierProduct_WG_9943_EuroSupplier_EUR_20_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2005-01-01 00:00:00.000"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("110.0"))
        .setMinimumOrderQuantity(getFixedPoint("20"))
        .setPartyId("EuroSupplier")
        .setProductId("WG-9943")
        .setSupplierProductId("EU-WG-9943")
        .setSupplierProductName("EU Giant Widget")
        .build();


    public final static SupplierProductData SupplierProduct_dropShip1_DemoSupplier_USD_0_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2007-01-01 14:51:52.627"))
        .setCanDropShip(castIndicator("Y"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("10.0"))
        .setMinimumOrderQuantity(getFixedPoint("0.0"))
        .setPartyId("DemoSupplier")
        .setProductId("dropShip1")
        .setSupplierProductId("dropShip1-DS")
        .setSupplierProductName("Drop ship product from demo supplier")
        .build();


    public final static SupplierProductData SupplierProduct_dropShip2_BigSupplier_USD_0_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2007-01-01 14:51:52.627"))
        .setCanDropShip(castIndicator("Y"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("12.0"))
        .setMinimumOrderQuantity(getFixedPoint("0.0"))
        .setPartyId("BigSupplier")
        .setProductId("dropShip2")
        .setSupplierProductId("dropShip2-DS")
        .setSupplierProductName("Drop ship product from big supplier")
        .build();


    public final static SupplierProductData SupplierProduct_dropShip3_EuroSupplier_EUR_0_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2007-01-01 14:51:52.627"))
        .setCanDropShip(castIndicator("Y"))
        .setCurrencyUomId("EUR")
        .setLastPrice(getCurrency("11.0"))
        .setMinimumOrderQuantity(getFixedPoint("0.0"))
        .setPartyId("EuroSupplier")
        .setProductId("dropShip3")
        .setSupplierProductId("dropShip3-DS")
        .setSupplierProductName("Drop ship product from Euro supplier")
        .build();


    public final static SupplierProductData SupplierProduct_dropShip3_EuroSupplier_USD_0_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2007-01-01 14:51:52.627"))
        .setCanDropShip(castIndicator("Y"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("11.0"))
        .setMinimumOrderQuantity(getFixedPoint("0.0"))
        .setPartyId("EuroSupplier")
        .setProductId("dropShip3")
        .setSupplierProductId("dropShip3-DS")
        .setSupplierProductName("Drop ship product from Euro supplier")
        .build();


    public final static SupplierProductData SupplierProduct_orderWhenSold_DemoSupplier_USD_0_0_ = SupplierProductData.newBuilder()
        .setAvailableFromDate(getTimestamp("2007-01-01 14:51:52.627"))
        .setCanDropShip(castIndicator("Y"))
        .setCurrencyUomId("USD")
        .setLastPrice(getCurrency("10.0"))
        .setMinimumOrderQuantity(getFixedPoint("0.0"))
        .setPartyId("DemoSupplier")
        .setProductId("orderWhenSold")
        .setSupplierProductId("dropShip1-DS")
        .setSupplierProductName("Drop ship product from demo supplier")
        .build();


    public final static PartyFlatData Party_BigSupplier = PartyFlatData.newBuilder()
        .setPartyId("BigSupplier")
        .setPartyTypeId("PARTY_GROUP")
        .build();


    public final static PartyFlatData Party_EuroSupplier = PartyFlatData.newBuilder()
        .setPartyId("EuroSupplier")
        .setPartyTypeId("PARTY_GROUP")
        .build();


    public final static PartyContactMechPurposeData PartyContactMechPurpose_BigSupplier_9002_BILLING_LOCATION_ = PartyContactMechPurposeData.newBuilder()
        .setContactMechId("9002")
        .setContactMechPurposeTypeId("BILLING_LOCATION")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("BigSupplier")
        .build();


    public final static PartyContactMechPurposeData PartyContactMechPurpose_BigSupplier_9002_GENERAL_LOCATION_ = PartyContactMechPurposeData.newBuilder()
        .setContactMechId("9002")
        .setContactMechPurposeTypeId("GENERAL_LOCATION")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("BigSupplier")
        .build();


    public final static PartyContactMechPurposeData PartyContactMechPurpose_BigSupplier_9002_PAYMENT_LOCATION_ = PartyContactMechPurposeData.newBuilder()
        .setContactMechId("9002")
        .setContactMechPurposeTypeId("PAYMENT_LOCATION")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("BigSupplier")
        .build();


    public final static PartyContactMechPurposeData PartyContactMechPurpose_EuroSupplier_9003_BILLING_LOCATION_ = PartyContactMechPurposeData.newBuilder()
        .setContactMechId("9003")
        .setContactMechPurposeTypeId("BILLING_LOCATION")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("EuroSupplier")
        .build();


    public final static PartyContactMechPurposeData PartyContactMechPurpose_EuroSupplier_9003_GENERAL_LOCATION_ = PartyContactMechPurposeData.newBuilder()
        .setContactMechId("9003")
        .setContactMechPurposeTypeId("GENERAL_LOCATION")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("EuroSupplier")
        .build();


    public final static PartyContactMechPurposeData PartyContactMechPurpose_EuroSupplier_9003_PAYMENT_LOCATION_ = PartyContactMechPurposeData.newBuilder()
        .setContactMechId("9003")
        .setContactMechPurposeTypeId("PAYMENT_LOCATION")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("EuroSupplier")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_8000 = SupplierProductFeatureData.newBuilder()
        .setDescription("EURO-LGPL")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("8000")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_8001 = SupplierProductFeatureData.newBuilder()
        .setDescription("EURO-GPL")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("8001")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_8002 = SupplierProductFeatureData.newBuilder()
        .setDescription("EURO-BSD")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("8002")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_8003 = SupplierProductFeatureData.newBuilder()
        .setDescription("EURO-MIT")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("8003")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_9000 = SupplierProductFeatureData.newBuilder()
        .setDescription("Noir")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("9000")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_9001 = SupplierProductFeatureData.newBuilder()
        .setDescription("Argent")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("9001")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_9002 = SupplierProductFeatureData.newBuilder()
        .setDescription("a trois roues")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("9002")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_EuroSupplier_9003 = SupplierProductFeatureData.newBuilder()
        .setDescription("a quatre roues")
        .setPartyId("EuroSupplier")
        .setProductFeatureId("9003")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_8000 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-LGP")
        .setPartyId("BigSupplier")
        .setProductFeatureId("8000")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_8001 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-GPL")
        .setPartyId("BigSupplier")
        .setProductFeatureId("8001")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_8002 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-BSD")
        .setPartyId("BigSupplier")
        .setProductFeatureId("8002")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_8003 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-MIT")
        .setPartyId("BigSupplier")
        .setProductFeatureId("8003")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_9000 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-BLK")
        .setPartyId("BigSupplier")
        .setProductFeatureId("9000")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_9001 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-SIL")
        .setPartyId("BigSupplier")
        .setProductFeatureId("9001")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_9002 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-3WL")
        .setPartyId("BigSupplier")
        .setProductFeatureId("9002")
        .build();


    public final static SupplierProductFeatureData SupplierProductFeature_BigSupplier_9003 = SupplierProductFeatureData.newBuilder()
        .setDescription("BIG-4WL")
        .setPartyId("BigSupplier")
        .setProductFeatureId("9003")
        .build();


    public final static UserLoginSecurityGroupData UserLoginSecurityGroup_DemoCustomer_ECOMMERCE_CUSTOMER_ = UserLoginSecurityGroupData.newBuilder()
        .setFromDate(getTimestamp("2000-01-01 00:00:00.0"))
        .setGroupId("ECOMMERCE_CUSTOMER")
        .setUserLoginId("DemoCustomer")
        .build();


    public final static UserLoginFlatData UserLogin_BigSupplier = UserLoginFlatData.newBuilder()
        .setCurrentPassword("{SHA}47b56994cbc2b6d10aa1be30f70165adb305a41a")
        .setPartyId("BigSupplier")
        .setUserLoginId("BigSupplier")
        .build();


    public final static UserLoginFlatData UserLogin_EuroSupplier = UserLoginFlatData.newBuilder()
        .setCurrentPassword("{SHA}47b56994cbc2b6d10aa1be30f70165adb305a41a")
        .setPartyId("EuroSupplier")
        .setUserLoginId("EuroSupplier")
        .build();


    public final static PartyRoleData PartyRole_BigSupplier_SUPPLIER = PartyRoleData.newBuilder()
        .setPartyId("BigSupplier")
        .setRoleTypeId("SUPPLIER")
        .build();


    public final static PartyRoleData PartyRole_EuroSupplier_SUPPLIER = PartyRoleData.newBuilder()
        .setPartyId("EuroSupplier")
        .setRoleTypeId("SUPPLIER")
        .build();


    public final static AgreementItemData AgreementItem_AGR_TEST_10000 = AgreementItemData.newBuilder()
        .setAgreementId("AGR_TEST")
        .setAgreementItemSeqId("10000")
        .setAgreementItemTypeId("AGREEMENT_PRICING_PR")
        .setAgreementText("Price list in US Dollars")
        .setCurrencyUomId("USD")
        .build();


    public final static AgreementItemData AgreementItem_1000_0001 = AgreementItemData.newBuilder()
        .setAgreementId("1000")
        .setAgreementItemSeqId("0001")
        .setAgreementItemTypeId("AGREEMENT_PRICING_PR")
        .setAgreementText("Price list in USD")
        .setCurrencyUomId("USD")
        .build();


    public final static AgreementItemData AgreementItem_1001_0001 = AgreementItemData.newBuilder()
        .setAgreementId("1001")
        .setAgreementItemSeqId("0001")
        .setAgreementItemTypeId("AGREEMENT_PRICING_PR")
        .setAgreementText("Price list in EURO")
        .setCurrencyUomId("EUR")
        .build();


    public final static AgreementItemData AgreementItem_1002_0001 = AgreementItemData.newBuilder()
        .setAgreementId("1002")
        .setAgreementItemSeqId("0001")
        .setAgreementItemTypeId("AGREEMENT_PRICING_PR")
        .setAgreementText("Price list in US Dollars")
        .setCurrencyUomId("USD")
        .build();


    public final static DataResourceData DataResource_dropShip_ALT = DataResourceData.newBuilder()
        .setDataResourceId("dropShip-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRdropShip_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRdropShip-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_dropShip1_ALT = DataResourceData.newBuilder()
        .setDataResourceId("dropShip1-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRdropShip1_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRdropShip1-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_dropShip2_ALT = DataResourceData.newBuilder()
        .setDataResourceId("dropShip2-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRdropShip2_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRdropShip2-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_dropShip3_ALT = DataResourceData.newBuilder()
        .setDataResourceId("dropShip3-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRdropShip3_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRdropShip3-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_orderWhenSold_ALT = DataResourceData.newBuilder()
        .setDataResourceId("orderWhenSold-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRorderWhenSold_ALT = DataResourceData.newBuilder()
        .setDataResourceId("DRorderWhenSold-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static ProductContentData ProductContent_dropShip1_dropShip1_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("dropShip1-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("dropShip1")
        .build();


    public final static ProductContentData ProductContent_dropShip2_dropShip2_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("dropShip2-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("dropShip2")
        .build();


    public final static ProductContentData ProductContent_dropShip3_dropShip3_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("dropShip3-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("dropShip3")
        .build();


    public final static ProductContentData ProductContent_orderWhenSold_orderWhenSold_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("orderWhenSold-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("orderWhenSold")
        .build();


    public final static PostalAddressData PostalAddress_9002 = PostalAddressData.newBuilder()
        .setAddress1("2005 Industrial Park Blvd")
        .setCity("New York")
        .setContactMechId("9002")
        .setCountryGeoId("USA")
        .setPostalCode("10000")
        .setStateProvinceGeoId("NY")
        .setToName("Big Supplier Company")
        .build();


    public final static PostalAddressData PostalAddress_9003 = PostalAddressData.newBuilder()
        .setAddress1("2005 Boulevard Industrie")
        .setCity("Roissy")
        .setContactMechId("9003")
        .setCountryGeoId("FRA")
        .setPostalCode("95700")
        .setToName("Euro Supplier Company")
        .build();


    public final static AgreementData Agreement_AGR_TEST = AgreementData.newBuilder()
        .setAgreementId("AGR_TEST")
        .setAgreementTypeId("PURCHASE_AGREEMENT")
        .setDescription("Agreement for DemoSupplier")
        .setPartyIdFrom("Company")
        .setPartyIdTo("DemoSupplier")
        .setRoleTypeIdTo("SUPPLIER")
        .build();


    public final static AgreementData Agreement_1000 = AgreementData.newBuilder()
        .setAgreementId("1000")
        .setAgreementTypeId("PURCHASE_AGREEMENT")
        .setDescription("Purchasing Agreement with BigSupplier")
        .setPartyIdFrom("Company")
        .setPartyIdTo("BigSupplier")
        .setRoleTypeIdTo("SUPPLIER")
        .build();


    public final static AgreementData Agreement_1001 = AgreementData.newBuilder()
        .setAgreementId("1001")
        .setAgreementTypeId("PURCHASE_AGREEMENT")
        .setDescription("Purchasing Agreement with EuroSupplier-Milan")
        .setPartyIdFrom("Company")
        .setPartyIdTo("EuroSupplier")
        .setRoleTypeIdTo("SUPPLIER")
        .build();


    public final static AgreementData Agreement_1002 = AgreementData.newBuilder()
        .setAgreementId("1002")
        .setAgreementTypeId("PURCHASE_AGREEMENT")
        .setDescription("Purchasing Agreement with EuroSupplier-New York")
        .setPartyIdFrom("Company")
        .setPartyIdTo("EuroSupplier")
        .setRoleTypeIdTo("SUPPLIER")
        .build();


    public final static AgreementTermData AgreementTerm_1000 = AgreementTermData.newBuilder()
        .setAgreementId("AGR_TEST")
        .setAgreementTermId("1000")
        .setTermDays(30)
        .setTermTypeId("FIN_PAYMENT_TERM")
        .build();


    public final static AgreementTermData AgreementTerm_1001 = AgreementTermData.newBuilder()
        .setAgreementId("AGR_TEST")
        .setAgreementTermId("1001")
        .setTermDays(10)
        .setTermTypeId("FIN_PAYMENT_DISC")
        .setTermValue(getCurrency("2"))
        .build();


    public final static AgreementTermData AgreementTerm_1003 = AgreementTermData.newBuilder()
        .setAgreementId("AGR_TEST")
        .setAgreementTermId("1003")
        .setTermTypeId("PURCH_VENDOR_ID")
        .setTextValue("OPEN-001")
        .build();


    public final static AgreementTermData AgreementTerm_1004 = AgreementTermData.newBuilder()
        .setAgreementId("AGR_TEST")
        .setAgreementTermId("1004")
        .setTermTypeId("PURCH_FREIGHT")
        .setTextValue("Shp via Open Express")
        .build();


    public final static AgreementTermData AgreementTerm_1100 = AgreementTermData.newBuilder()
        .setAgreementId("1000")
        .setAgreementTermId("1100")
        .setTermDays(30)
        .setTermTypeId("FIN_PAYMENT_TERM")
        .build();


    public final static AgreementTermData AgreementTerm_1101 = AgreementTermData.newBuilder()
        .setAgreementId("1000")
        .setAgreementTermId("1101")
        .setTermDays(10)
        .setTermTypeId("FIN_PAYMENT_DISC")
        .setTermValue(getCurrency("2"))
        .build();


    public final static AgreementTermData AgreementTerm_1200 = AgreementTermData.newBuilder()
        .setAgreementId("1001")
        .setAgreementTermId("1200")
        .setTermDays(60)
        .setTermTypeId("FIN_PAYMENT_TERM")
        .build();


    public final static AgreementTermData AgreementTerm_1210 = AgreementTermData.newBuilder()
        .setAgreementId("1002")
        .setAgreementTermId("1210")
        .setTermDays(30)
        .setTermTypeId("FIN_PAYMENT_TERM")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_dropShip_dropShip1_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("dropShip")
        .setProductId("dropShip1")
        .setSequenceNum(1)
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_dropShip_dropShip2_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("dropShip")
        .setProductId("dropShip2")
        .setSequenceNum(1)
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_dropShip_dropShip3_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("dropShip")
        .setProductId("dropShip3")
        .setSequenceNum(1)
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_dropShip_orderWhenSold_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("dropShip")
        .setProductId("orderWhenSold")
        .setSequenceNum(1)
        .build();


    public final static ContentData Content_dropShip_ALT = ContentData.newBuilder()
        .setContentId("dropShip-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("dropShip-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CdropShip_ALTEN = ContentData.newBuilder()
        .setContentId("CdropShip-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRdropShip-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_dropShip1_ALT = ContentData.newBuilder()
        .setContentId("dropShip1-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("dropShip1-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CdropShip1_ALTEN = ContentData.newBuilder()
        .setContentId("CdropShip1-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRdropShip1-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_dropShip2_ALT = ContentData.newBuilder()
        .setContentId("dropShip2-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("dropShip2-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CdropShip2_ALTEN = ContentData.newBuilder()
        .setContentId("CdropShip2-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRdropShip2-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_dropShip3_ALT = ContentData.newBuilder()
        .setContentId("dropShip3-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("dropShip3-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CdropShip3_ALTEN = ContentData.newBuilder()
        .setContentId("CdropShip3-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRdropShip3-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_orderWhenSold_ALT = ContentData.newBuilder()
        .setContentId("orderWhenSold-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("orderWhenSold-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CorderWhenSold_ALTEN = ContentData.newBuilder()
        .setContentId("CorderWhenSold-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRorderWhenSold-ALT")
        .setLocaleString("en_US")
        .build();


    public final static ProductCategoryFlatData ProductCategory_dropShip = ProductCategoryFlatData.newBuilder()
        .setDescription("DropShip Products")
        .setPrimaryParentCategoryId("CATALOG1")
        .setProductCategoryId("dropShip")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryContentData ProductCategoryContent_dropShip_dropShip_ALT_ALTERNATIVE_URL_ = ProductCategoryContentData.newBuilder()
        .setContentId("dropShip-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatContentTypeId("ALTERNATIVE_URL")
        .setProductCategoryId("dropShip")
        .build();


    public final static PartyContactMechData PartyContactMech_BigSupplier_9002_ = PartyContactMechData.newBuilder()
        .setAllowSolicitation(castIndicator("Y"))
        .setContactMechId("9002")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("BigSupplier")
        .build();


    public final static PartyContactMechData PartyContactMech_EuroSupplier_9003_ = PartyContactMechData.newBuilder()
        .setAllowSolicitation(castIndicator("Y"))
        .setContactMechId("9003")
        .setFromDate(getTimestamp("2000-01-01 00:00:00.000"))
        .setPartyId("EuroSupplier")
        .build();

}
