package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.ProductFeatureData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.ProductStoreSurveyApplData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;
import com.bluecc.hubs.stub.ProductContentData;
import com.bluecc.hubs.stub.ProductStoreFinActSettingData;
import com.bluecc.hubs.stub.SurveyData;
import com.bluecc.hubs.stub.ProductCategoryMemberFlatData;
import com.bluecc.hubs.stub.ProductFeatureApplData;
import com.bluecc.hubs.stub.SurveyQuestionCategoryData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductFeatureCategoryData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductStorePaymentSettingData;
import com.bluecc.hubs.stub.ProductCategoryContentData;
import com.bluecc.hubs.stub.ProductAssocData;
import com.bluecc.hubs.stub.SurveyQuestionApplData;
import com.bluecc.hubs.stub.SurveyQuestionData;

public final class StereoDemoFinAccount {
    public final static ElectronicTextData ElectronicText_FA_100_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("FA-100-ALT")
        .setTextData("account-activation")
        .build();


    public final static ElectronicTextData ElectronicText_FA_001_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("FA-001-ALT")
        .setTextData("financial-account-activation")
        .build();


    public final static ElectronicTextData ElectronicText_FA_001_30_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("FA-001-30-ALT")
        .setTextData("financial-account-activation-30")
        .build();


    public final static ElectronicTextData ElectronicText_FA_001_50_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("FA-001-50-ALT")
        .setTextData("financial-account-activation-50")
        .build();


    public final static ElectronicTextData ElectronicText_FA_001_O_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("FA-001-O-ALT")
        .setTextData("financial-account-activation-o")
        .build();


    public final static ElectronicTextData ElectronicText_DRFA_100_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRFA-100-ALTEN")
        .setTextData("account-activation")
        .build();


    public final static ElectronicTextData ElectronicText_DRFA_001_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRFA-001-ALTEN")
        .setTextData("financial-account-activation")
        .build();


    public final static ElectronicTextData ElectronicText_DRFA_001_30_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRFA-001-30-ALTEN")
        .setTextData("financial-account-activation-30")
        .build();


    public final static ElectronicTextData ElectronicText_DRFA_001_50_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRFA-001-50-ALTEN")
        .setTextData("financial-account-activation-50")
        .build();


    public final static ElectronicTextData ElectronicText_DRFA_001_O_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRFA-001-O-ALTEN")
        .setTextData("financial-account-activation-o")
        .build();


    public final static ContentAssocData ContentAssoc_FA_100_ALT_CFA_100_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("FA-100-ALT")
        .setContentIdTo("CFA-100-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_FA_001_ALT_CFA_001_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("FA-001-ALT")
        .setContentIdTo("CFA-001-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_FA_001_30_ALT_CFA_001_30_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("FA-001-30-ALT")
        .setContentIdTo("CFA-001-30-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_FA_001_50_ALT_CFA_001_50_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("FA-001-50-ALT")
        .setContentIdTo("CFA-001-50-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_FA_001_O_ALT_CFA_001_O_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("FA-001-O-ALT")
        .setContentIdTo("CFA-001-O-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ProductFeatureData ProductFeature_2101 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(1)
        .setDescription("$30.00")
        .setNumberSpecified(getFixedPoint("10.0"))
        .setProductFeatureCategoryId("2100")
        .setProductFeatureId("2101")
        .setProductFeatureTypeId("AMOUNT")
        .setUomId("USD")
        .build();


    public final static ProductFeatureData ProductFeature_2102 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(2)
        .setDescription("$50.00")
        .setNumberSpecified(getFixedPoint("25.0"))
        .setProductFeatureCategoryId("2100")
        .setProductFeatureId("2102")
        .setProductFeatureTypeId("AMOUNT")
        .setUomId("USD")
        .build();


    public final static ProductFeatureData ProductFeature_2103 = ProductFeatureData.newBuilder()
        .setDescription("Other Amount")
        .setProductFeatureCategoryId("2100")
        .setProductFeatureId("2103")
        .setProductFeatureTypeId("AMOUNT")
        .build();


    public final static ProductFeatureData ProductFeature_2104 = ProductFeatureData.newBuilder()
        .setDescription("Customer Balance Account")
        .setIdCode("DEPOSIT_ACCOUNT")
        .setProductFeatureCategoryId("2100")
        .setProductFeatureId("2104")
        .setProductFeatureTypeId("TYPE")
        .build();


    public final static ProductFlatData Product_FA_001 = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Balance Account Activation")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Financial Account Activation")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("Y"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setPrimaryProductCategoryId("FA-100")
        .setProductId("FA-001")
        .setProductName("Financial Account Activation")
        .setProductTypeId("DIGITAL_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_FA_001_30 = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Financial Account Activation")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Financial Account Activation")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("FA-001-30")
        .setProductName("Financial Account Activation")
        .setProductTypeId("DIGITAL_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_FA_001_50 = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Financial Account Activation")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Financial Account Activation")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("FA-001-50")
        .setProductName("Financial Account Activation")
        .setProductTypeId("DIGITAL_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_FA_001_O = ProductFlatData.newBuilder()
        .setAmountUomTypeId("CURRENCY_MEASURE")
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Financial Account Activation")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Financial Account Activation")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("FA-001-O")
        .setProductName("Financial Account Activation")
        .setProductTypeId("DIGITAL_GOOD")
        .setRequireAmount(castIndicator("Y"))
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductPriceData ProductPrice_FA_001_30_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("30.0"))
        .setProductId("FA-001-30")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_FA_001_50_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("50.0"))
        .setProductId("FA-001-50")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_FA_001_O_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.0"))
        .setProductId("FA-001-O")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductStoreSurveyApplData ProductStoreSurveyAppl_1100 = ProductStoreSurveyApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-24 16:00:02.467"))
        .setProductId("FA-001")
        .setProductStoreId("9000")
        .setProductStoreSurveyId("1100")
        .setSurveyApplTypeId("CART_ADD")
        .setSurveyId("1100")
        .setSurveyTemplate("/applications/content/template/survey/GenericSurvey.ftl")
        .build();


    public final static DataResourceData DataResource_FA_100_ALT = DataResourceData.newBuilder()
        .setDataResourceId("FA-100-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRFA_100_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRFA-100-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_FA_001_ALT = DataResourceData.newBuilder()
        .setDataResourceId("FA-001-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRFA_001_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRFA-001-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_FA_001_30_ALT = DataResourceData.newBuilder()
        .setDataResourceId("FA-001-30-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRFA_001_30_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRFA-001-30-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_FA_001_50_ALT = DataResourceData.newBuilder()
        .setDataResourceId("FA-001-50-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRFA_001_50_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRFA-001-50-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_FA_001_O_ALT = DataResourceData.newBuilder()
        .setDataResourceId("FA-001-O-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRFA_001_O_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRFA-001-O-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_FA_100_CATALOG1_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setParentProductCategoryId("CATALOG1")
        .setProductCategoryId("FA-100")
        .build();


    public final static ProductContentData ProductContent_FA_001_FA_ACTIVATION_FULFILLMENT_EXTASYNC_ = ProductContentData.newBuilder()
        .setContentId("FA_ACTIVATION")
        .setFromDate(getTimestamp("2000-01-01 00:00:00"))
        .setProductContentTypeId("FULFILLMENT_EXTASYNC")
        .setProductId("FA-001")
        .build();


    public final static ProductContentData ProductContent_FA_001_FA_001_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("FA-001-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("FA-001")
        .build();


    public final static ProductContentData ProductContent_FA_001_30_FA_001_30_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("FA-001-30-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("FA-001-30")
        .build();


    public final static ProductContentData ProductContent_FA_001_50_FA_001_50_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("FA-001-50-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("FA-001-50")
        .build();


    public final static ProductContentData ProductContent_FA_001_O_FA_001_O_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("FA-001-O-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("FA-001-O")
        .build();


    public final static ProductStoreFinActSettingData ProductStoreFinActSetting_9000_DEPOSIT_ACCOUNT = ProductStoreFinActSettingData.newBuilder()
        .setAccountCodeLength(12)
        .setAccountValidDays(365)
        .setAllowAuthToNegative(castIndicator("Y"))
        .setAuthValidDays(5)
        .setFinAccountTypeId("DEPOSIT_ACCOUNT")
        .setPinCodeLength(4)
        .setProductStoreId("9000")
        .setPurchSurveyCopyMe("copyMe")
        .setPurchSurveySendTo("recipientEmail")
        .setPurchaseSurveyId("1100")
        .setReplenishThreshold(getCurrency("0.0"))
        .setRequirePinCode(castIndicator("N"))
        .setValidateGCFinAcct(castIndicator("Y"))
        .build();


    public final static ProductStoreFinActSettingData ProductStoreFinActSetting_9000_REPLENISH_ACCOUNT = ProductStoreFinActSettingData.newBuilder()
        .setAccountCodeLength(12)
        .setAccountValidDays(365)
        .setAllowAuthToNegative(castIndicator("Y"))
        .setAuthValidDays(5)
        .setFinAccountTypeId("REPLENISH_ACCOUNT")
        .setPinCodeLength(4)
        .setProductStoreId("9000")
        .setPurchSurveyCopyMe("copyMe")
        .setPurchSurveySendTo("recipientEmail")
        .setPurchaseSurveyId("1100")
        .setReplenishThreshold(getCurrency("0.0"))
        .setRequirePinCode(castIndicator("N"))
        .setValidateGCFinAcct(castIndicator("Y"))
        .build();


    public final static ProductStoreFinActSettingData ProductStoreFinActSetting_9000_STORE_CREDIT_ACCT = ProductStoreFinActSettingData.newBuilder()
        .setAccountCodeLength(12)
        .setAccountValidDays(365)
        .setAllowAuthToNegative(castIndicator("Y"))
        .setAuthValidDays(5)
        .setFinAccountTypeId("STORE_CREDIT_ACCT")
        .setPinCodeLength(4)
        .setProductStoreId("9000")
        .setPurchSurveyCopyMe("copyMe")
        .setPurchSurveySendTo("recipientEmail")
        .setPurchaseSurveyId("1100")
        .setReplenishThreshold(getCurrency("0.0"))
        .setRequirePinCode(castIndicator("N"))
        .setValidateGCFinAcct(castIndicator("Y"))
        .build();


    public final static SurveyData Survey_1100 = SurveyData.newBuilder()
        .setAllowMultiple(castIndicator("Y"))
        .setAllowUpdate(castIndicator("N"))
        .setDescription("Account Activation")
        .setIsAnonymous(castIndicator("Y"))
        .setSurveyId("1100")
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_FA_100_FA_001_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("FA-100")
        .setProductId("FA-001")
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_PROMOTIONS_FA_001_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("PROMOTIONS")
        .setProductId("FA-001")
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_CATALOG1_SEARCH_FA_001_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("CATALOG1_SEARCH")
        .setProductId("FA-001")
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_2101_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:07.796"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("2101")
        .setProductId("FA-001")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_2102_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:26.411"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("2102")
        .setProductId("FA-001")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_2103_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:49:07.293"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("2103")
        .setProductId("FA-001")
        .setSequenceNum(3)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_2003_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:49:26.542"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("2003")
        .setProductId("FA-001")
        .setSequenceNum(4)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_30_2101_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("2101")
        .setProductId("FA-001-30")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_30_2104_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("2104")
        .setProductId("FA-001-30")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_50_2102_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.226"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("2102")
        .setProductId("FA-001-50")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_50_2104_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("2104")
        .setProductId("FA-001-50")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_O_2103_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-21 10:26:48.937"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("2103")
        .setProductId("FA-001-O")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_FA_001_O_2104_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("2104")
        .setProductId("FA-001-O")
        .setSequenceNum(2)
        .build();


    public final static SurveyQuestionCategoryData SurveyQuestionCategory_1100 = SurveyQuestionCategoryData.newBuilder()
        .setDescription("Account Activation Questions")
        .setSurveyQuestionCategoryId("1100")
        .build();


    public final static ContentData Content_FA_ACTIVATION = ContentData.newBuilder()
        .setContentId("FA_ACTIVATION")
        .setCustomMethodId("FIN_PURCH_OFBIZ")
        .build();


    public final static ContentData Content_FA_100_ALT = ContentData.newBuilder()
        .setContentId("FA-100-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("FA-100-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CFA_100_ALTEN = ContentData.newBuilder()
        .setContentId("CFA-100-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRFA-100-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_FA_001_ALT = ContentData.newBuilder()
        .setContentId("FA-001-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("FA-001-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CFA_001_ALTEN = ContentData.newBuilder()
        .setContentId("CFA-001-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRFA-001-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_FA_001_30_ALT = ContentData.newBuilder()
        .setContentId("FA-001-30-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("FA-001-30-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CFA_001_30_ALTEN = ContentData.newBuilder()
        .setContentId("CFA-001-30-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRFA-001-30-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_FA_001_50_ALT = ContentData.newBuilder()
        .setContentId("FA-001-50-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("FA-001-50-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CFA_001_50_ALTEN = ContentData.newBuilder()
        .setContentId("CFA-001-50-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRFA-001-50-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_FA_001_O_ALT = ContentData.newBuilder()
        .setContentId("FA-001-O-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("FA-001-O-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CFA_001_O_ALTEN = ContentData.newBuilder()
        .setContentId("CFA-001-O-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRFA-001-O-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ProductFeatureCategoryData ProductFeatureCategory_2100 = ProductFeatureCategoryData.newBuilder()
        .setDescription("Account Features")
        .setProductFeatureCategoryId("2100")
        .build();


    public final static ProductCategoryFlatData ProductCategory_FA_100 = ProductCategoryFlatData.newBuilder()
        .setDescription("Account Activation")
        .setProductCategoryId("FA-100")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_FIN_ACCOUNT_PRDS_PAY_AUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("FIN_AUTH_OFBIZ")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .setPaymentService("ofbFaAuthorize")
        .setPaymentServiceTypeEnumId("PRDS_PAY_AUTH")
        .setProductStoreId("9000")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_FIN_ACCOUNT_PRDS_PAY_RELEASE = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("FIN_RELEASE_OFBIZ")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .setPaymentService("ofbFaRelease")
        .setPaymentServiceTypeEnumId("PRDS_PAY_RELEASE")
        .setProductStoreId("9000")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_FIN_ACCOUNT_PRDS_PAY_CAPTURE = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("FIN_CAPTURE_OFBIZ")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .setPaymentService("ofbFaCapture")
        .setPaymentServiceTypeEnumId("PRDS_PAY_CAPTURE")
        .setProductStoreId("9000")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_FIN_ACCOUNT_PRDS_PAY_REAUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("FIN_AUTH_OFBIZ")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .setPaymentService("ofbFaAuthorize")
        .setPaymentServiceTypeEnumId("PRDS_PAY_REAUTH")
        .setProductStoreId("9000")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_9000_FIN_ACCOUNT_PRDS_PAY_REFUND = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("FIN_REFUND_OFBIZ")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .setPaymentService("ofbFaRefund")
        .setPaymentServiceTypeEnumId("PRDS_PAY_REFUND")
        .setProductStoreId("9000")
        .build();


    public final static ProductCategoryContentData ProductCategoryContent_FA_100_FA_100_ALT_ALTERNATIVE_URL_ = ProductCategoryContentData.newBuilder()
        .setContentId("FA-100-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatContentTypeId("ALTERNATIVE_URL")
        .setProductCategoryId("FA-100")
        .build();


    public final static ProductAssocData ProductAssoc_FA_001_FA_001_30_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("FA-001")
        .setProductIdTo("FA-001-30")
        .build();


    public final static ProductAssocData ProductAssoc_FA_001_FA_001_50_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("FA-001")
        .setProductIdTo("FA-001-50")
        .build();


    public final static ProductAssocData ProductAssoc_FA_001_FA_001_O_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("FA-001")
        .setProductIdTo("FA-001-O")
        .build();


    public final static SurveyQuestionApplData SurveyQuestionAppl_1100_1100_ = SurveyQuestionApplData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setRequiredField(castIndicator("Y"))
        .setSequenceNum(1)
        .setSurveyId("1100")
        .setSurveyQuestionId("1100")
        .build();


    public final static SurveyQuestionData SurveyQuestion_1100 = SurveyQuestionData.newBuilder()
        .setDescription("activationSerialNumber")
        .setQuestion("Activation Serial Number:")
        .setSurveyQuestionCategoryId("1100")
        .setSurveyQuestionId("1100")
        .setSurveyQuestionTypeId("TEXT_LONG")
        .build();

}
