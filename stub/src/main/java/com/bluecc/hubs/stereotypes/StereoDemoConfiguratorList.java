package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoDemoConfigurator.*;

import com.bluecc.hubs.stub.FixedAssetGeoPointData;
import com.bluecc.hubs.stub.ProductConfigProductData;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.ProductConfigItemData;
import com.bluecc.hubs.stub.ProductConfigData;
import com.bluecc.hubs.stub.ProductFeatureData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.FixedAssetFlatData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;
import com.bluecc.hubs.stub.ProductContentData;
import com.bluecc.hubs.stub.ProductConfigOptionData;
import com.bluecc.hubs.stub.ProductCategoryMemberFlatData;
import com.bluecc.hubs.stub.ProductFeatureApplData;
import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductFeatureCategoryData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductCategoryContentData;
import com.bluecc.hubs.stub.ProductAssocData;
import com.bluecc.hubs.stub.WorkEffortGoodStandardData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class StereoDemoConfiguratorList {
    public static final List<FixedAssetGeoPointData> fixedAssetGeoPointList=ImmutableList.of(        
            FixedAssetGeoPoint_DEMO_BOOK_GROUP_9000_,        
            FixedAssetGeoPoint_DEMO_MACHINE_GROUP_9000_,        
            FixedAssetGeoPoint_DEMO_FOOD_GROUP_9000_);

    public static final List<ProductConfigProductData> productConfigProductList=ImmutableList.of(        
            ProductConfigProduct_IT0000_OP000_RAM1GB_BRAND,        
            ProductConfigProduct_IT0000_OP001_RAM1GB_BRAND,        
            ProductConfigProduct_IT0001_OP002_HD250GB_BRAND,        
            ProductConfigProduct_IT0001_OP003_HD500GB_BRAND,        
            ProductConfigProduct_IT0002_OP004_ETH_BRAND,        
            ProductConfigProduct_IT0002_OP005_MOD_BRAND,        
            ProductConfigProduct_IT0003_OP006_MOTHER_BOARD_ASS,        
            ProductConfigProduct_TEXMEX0000_OP010_ENCHILADAS,        
            ProductConfigProduct_TEXMEX0000_OP011_FAJITA_BEEF,        
            ProductConfigProduct_TEXMEX0001_OP012_JALAPENOS,        
            ProductConfigProduct_PZ0000_PZOP000_DOUGH,        
            ProductConfigProduct_PZ0000_PZOP001_DOUGH,        
            ProductConfigProduct_PZ0001_PZOP003_PEPPERS,        
            ProductConfigProduct_PZ0001_PZOP002_SAUCE);

    public static final List<ElectronicTextData> electronicTextList=ImmutableList.of(        
            ElectronicText_PC_100_ALT,        
            ElectronicText_FOOD_001_ALT,        
            ElectronicText_PC001_ALT,        
            ElectronicText_RAM1GB_BRAND_ALT,        
            ElectronicText_HD250GB_BRAND_ALT,        
            ElectronicText_HD500GB_BRAND_ALT,        
            ElectronicText_ETH_BRAND_ALT,        
            ElectronicText_MOD_BRAND_ALT,        
            ElectronicText_MOTHER_BOARD_ASS_ALT,        
            ElectronicText_MOTHER_BOARD_ALT,        
            ElectronicText_CPU_586_ALT,        
            ElectronicText_ENCHILADAS_ALT,        
            ElectronicText_FAJITA_BEEF_ALT,        
            ElectronicText_JALAPENOS_ALT,        
            ElectronicText_PIZZA_ALT,        
            ElectronicText_DOUGH_ALT,        
            ElectronicText_SAUCE_ALT,        
            ElectronicText_SAUCE_TM_ALT,        
            ElectronicText_SAUCE_CM_ALT,        
            ElectronicText_SAUCE_TP_ALT,        
            ElectronicText_SAUCE_CP_ALT,        
            ElectronicText_PEPPERS_ALT,        
            ElectronicText_PEPPERS_G_ALT,        
            ElectronicText_PEPPERS_H_ALT,        
            ElectronicText_PEPPERS_R_ALT,        
            ElectronicText_DRPC_100_ALTEN,        
            ElectronicText_DRFOOD_001_ALTEN,        
            ElectronicText_DRPC001_ALTEN,        
            ElectronicText_DRRAM1GB_BRAND_ALTEN,        
            ElectronicText_DRHD250GB_BRAND_ALT,        
            ElectronicText_DRHD500GB_BRAND_ALT,        
            ElectronicText_DRETH_BRAND_ALTEN,        
            ElectronicText_DRMOD_BRAND_ALTEN,        
            ElectronicText_DMOTHER_BOARD_ASS,        
            ElectronicText_DRMOTHER_BOARD_ALTEN,        
            ElectronicText_DRCPU_586_ALTEN,        
            ElectronicText_DRENCHILADAS_ALTEN,        
            ElectronicText_DRFAJITA_BEEF_ALTEN,        
            ElectronicText_DRJALAPENOS_ALTEN,        
            ElectronicText_DRPIZZA_ALTEN,        
            ElectronicText_DRDOUGH_ALTEN,        
            ElectronicText_DRSAUCE_ALTEN,        
            ElectronicText_DRSAUCE_TM_ALTEN,        
            ElectronicText_DRSAUCE_CM_ALTEN,        
            ElectronicText_DRSAUCE_TP_ALTEN,        
            ElectronicText_DRSAUCE_CP_ALTEN,        
            ElectronicText_DRPEPPERS_ALTEN,        
            ElectronicText_DRPEPPERS_G_ALTEN,        
            ElectronicText_DRPEPPERS_H_ALTEN,        
            ElectronicText_DRPEPPERS_R_ALTEN);

    public static final List<ContentAssocData> contentAssocList=ImmutableList.of(        
            ContentAssoc_PC_100_ALT_CPC_100_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_FOOD_001_ALT_CFOOD_001_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_PC001_ALT_CPC001_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_RAM1GB_BRAND_ALT_CRAM1GB_BRAND_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_HD250GB_BRAND_ALT_CHD250GB_BRAND_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_HD500GB_BRAND_ALT_CHD500GB_BRAND_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_ETH_BRAND_ALT_CETH_BRAND_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_MOD_BRAND_ALT_CMOD_BRAND_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_MOTHER_BOARD_ASS_ALT_CMOTHER_BOARD_ASS_ALTERNATE_LOCALE_,        
            ContentAssoc_MOTHER_BOARD_ALT_CMOTHER_BOARD_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_CPU_586_ALT_CCPU_586_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_ENCHILADAS_ALT_CENCHILADAS_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_FAJITA_BEEF_ALT_CFAJITA_BEEF_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_JALAPENOS_ALT_CJALAPENOS_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_PIZZA_ALT_CPIZZA_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_DOUGH_ALT_CDOUGH_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_SAUCE_ALT_CSAUCE_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_SAUCE_TM_ALT_CSAUCE_TM_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_SAUCE_CM_ALT_CSAUCE_CM_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_SAUCE_TP_ALT_CSAUCE_TP_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_SAUCE_CP_ALT_CSAUCE_CP_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_PEPPERS_ALT_CPEPPERS_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_PEPPERS_G_ALT_CPEPPERS_G_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_PEPPERS_H_ALT_CPEPPERS_H_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_PEPPERS_R_ALT_CPEPPERS_R_ALTEN_ALTERNATE_LOCALE_);

    public static final List<ProductConfigItemData> productConfigItemList=ImmutableList.of(        
            ProductConfigItem_IT0000,        
            ProductConfigItem_IT0001,        
            ProductConfigItem_IT0002,        
            ProductConfigItem_IT0003,        
            ProductConfigItem_TEXMEX0000,        
            ProductConfigItem_TEXMEX0001,        
            ProductConfigItem_PZ0000,        
            ProductConfigItem_PZ0001);

    public static final List<ProductConfigData> productConfigList=ImmutableList.of(        
            ProductConfig_PC001_IT0000_10_,        
            ProductConfig_PC001_IT0001_20_,        
            ProductConfig_PC001_IT0001_30_,        
            ProductConfig_PC001_IT0002_40_,        
            ProductConfig_PC001_IT0003_1_,        
            ProductConfig_ENCHILADAS_TEXMEX0000_10_,        
            ProductConfig_ENCHILADAS_TEXMEX0001_20_,        
            ProductConfig_PIZZA_PZ0000_10_,        
            ProductConfig_PIZZA_PZ0001_30_);

    public static final List<ProductFeatureData> productFeatureList=ImmutableList.of(        
            ProductFeature_3001,        
            ProductFeature_3002,        
            ProductFeature_3003,        
            ProductFeature_3004,        
            ProductFeature_3010,        
            ProductFeature_3011,        
            ProductFeature_3012);

    public static final List<ProductFlatData> productList=ImmutableList.of(        
            Product_PC001,        
            Product_RAM1GB_BRAND,        
            Product_HD250GB_BRAND,        
            Product_HD500GB_BRAND,        
            Product_ETH_BRAND,        
            Product_MOD_BRAND,        
            Product_MOTHER_BOARD_ASS,        
            Product_MOTHER_BOARD,        
            Product_CPU_586,        
            Product_ENCHILADAS,        
            Product_FAJITA_BEEF,        
            Product_JALAPENOS,        
            Product_PIZZA,        
            Product_DOUGH,        
            Product_SAUCE,        
            Product_SAUCE_TM,        
            Product_SAUCE_CM,        
            Product_SAUCE_TP,        
            Product_SAUCE_CP,        
            Product_PEPPERS,        
            Product_PEPPERS_G,        
            Product_PEPPERS_H,        
            Product_PEPPERS_R);

    public static final List<ProductPriceData> productPriceList=ImmutableList.of(        
            ProductPrice_PC001_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_RAM1GB_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_RAM1GB_BRAND_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_HD250GB_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_HD500GB_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_ETH_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_MOD_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_MOTHER_BOARD_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_CPU_586_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_ENCHILADAS_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_FAJITA_BEEF_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_FAJITA_BEEF_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_JALAPENOS_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_PIZZA_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_DOUGH_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_SAUCE_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_SAUCE_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_SAUCE_TM_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_SAUCE_TM_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_SAUCE_CM_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_SAUCE_CM_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_SAUCE_TP_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_SAUCE_TP_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_SAUCE_CP_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_SAUCE_CP_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_PEPPERS_G_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_PEPPERS_G_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_PEPPERS_H_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_PEPPERS_H_DEFAULT_PRICE_PURCHASE_USD__NA__,        
            ProductPrice_PEPPERS_R_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__,        
            ProductPrice_PEPPERS_R_DEFAULT_PRICE_PURCHASE_USD__NA__);

    public static final List<FixedAssetFlatData> fixedAssetList=ImmutableList.of(        
            FixedAsset_DEMO_BOOK_GROUP,        
            FixedAsset_DEMO_MACHINE_GROUP,        
            FixedAsset_DEMO_FOOD_GROUP);

    public static final List<DataResourceData> dataResourceList=ImmutableList.of(        
            DataResource_PC_100_ALT,        
            DataResource_DRPC_100_ALTEN,        
            DataResource_FOOD_001_ALT,        
            DataResource_DRFOOD_001_ALTEN,        
            DataResource_PC001_ALT,        
            DataResource_DRPC001_ALTEN,        
            DataResource_RAM1GB_BRAND_ALT,        
            DataResource_DRRAM1GB_BRAND_ALTEN,        
            DataResource_HD250GB_BRAND_ALT,        
            DataResource_DRHD250GB_BRAND_ALT,        
            DataResource_HD500GB_BRAND_ALT,        
            DataResource_DRHD500GB_BRAND_ALT,        
            DataResource_ETH_BRAND_ALT,        
            DataResource_DRETH_BRAND_ALTEN,        
            DataResource_MOD_BRAND_ALT,        
            DataResource_DRMOD_BRAND_ALTEN,        
            DataResource_MOTHER_BOARD_ASS_ALT,        
            DataResource_DMOTHER_BOARD_ASS,        
            DataResource_MOTHER_BOARD_ALT,        
            DataResource_DRMOTHER_BOARD_ALTEN,        
            DataResource_CPU_586_ALT,        
            DataResource_DRCPU_586_ALTEN,        
            DataResource_ENCHILADAS_ALT,        
            DataResource_DRENCHILADAS_ALTEN,        
            DataResource_FAJITA_BEEF_ALT,        
            DataResource_DRFAJITA_BEEF_ALTEN,        
            DataResource_JALAPENOS_ALT,        
            DataResource_DRJALAPENOS_ALTEN,        
            DataResource_PIZZA_ALT,        
            DataResource_DRPIZZA_ALTEN,        
            DataResource_DOUGH_ALT,        
            DataResource_DRDOUGH_ALTEN,        
            DataResource_SAUCE_ALT,        
            DataResource_DRSAUCE_ALTEN,        
            DataResource_SAUCE_TM_ALT,        
            DataResource_DRSAUCE_TM_ALTEN,        
            DataResource_SAUCE_CM_ALT,        
            DataResource_DRSAUCE_CM_ALTEN,        
            DataResource_SAUCE_TP_ALT,        
            DataResource_DRSAUCE_TP_ALTEN,        
            DataResource_SAUCE_CP_ALT,        
            DataResource_DRSAUCE_CP_ALTEN,        
            DataResource_PEPPERS_ALT,        
            DataResource_DRPEPPERS_ALTEN,        
            DataResource_PEPPERS_H_ALT,        
            DataResource_DRPEPPERS_H_ALTEN,        
            DataResource_PEPPERS_G_ALT,        
            DataResource_DRPEPPERS_G_ALTEN,        
            DataResource_PEPPERS_R_ALT,        
            DataResource_DRPEPPERS_R_ALTEN);

    public static final List<ProductCategoryRollupFlatData> productCategoryRollupList=ImmutableList.of(        
            ProductCategoryRollup_PC_100_CATALOG1_,        
            ProductCategoryRollup_FOOD_001_CATALOG1_);

    public static final List<ProductContentData> productContentList=ImmutableList.of(        
            ProductContent_PC001_PC001_ALT_ALTERNATIVE_URL_,        
            ProductContent_RAM1GB_BRAND_RAM1GB_BRAND_ALT_ALTERNATIVE_URL_,        
            ProductContent_HD250GB_BRAND_HD250GB_BRAND_ALT_ALTERNATIVE_URL_,        
            ProductContent_HD500GB_BRAND_HD500GB_BRAND_ALT_ALTERNATIVE_URL_,        
            ProductContent_ETH_BRAND_ETH_BRAND_ALT_ALTERNATIVE_URL_,        
            ProductContent_MOD_BRAND_MOD_BRAND_ALT_ALTERNATIVE_URL_,        
            ProductContent_MOTHER_BOARD_ASS_MOTHER_BOARD_ASS_ALT_ALTERNATIVE_URL_,        
            ProductContent_MOTHER_BOARD_MOTHER_BOARD_ALT_ALTERNATIVE_URL_,        
            ProductContent_CPU_586_CPU_586_ALT_ALTERNATIVE_URL_,        
            ProductContent_ENCHILADAS_ENCHILADAS_ALT_ALTERNATIVE_URL_,        
            ProductContent_FAJITA_BEEF_FAJITA_BEEF_ALT_ALTERNATIVE_URL_,        
            ProductContent_JALAPENOS_JALAPENOS_ALT_ALTERNATIVE_URL_,        
            ProductContent_PIZZA_PIZZA_ALT_ALTERNATIVE_URL_,        
            ProductContent_DOUGH_DOUGH_ALT_ALTERNATIVE_URL_,        
            ProductContent_SAUCE_SAUCE_ALT_ALTERNATIVE_URL_,        
            ProductContent_SAUCE_TM_SAUCE_TM_ALT_ALTERNATIVE_URL_,        
            ProductContent_SAUCE_CM_SAUCE_CM_ALT_ALTERNATIVE_URL_,        
            ProductContent_SAUCE_TP_SAUCE_TP_ALT_ALTERNATIVE_URL_,        
            ProductContent_SAUCE_CP_SAUCE_CP_ALT_ALTERNATIVE_URL_,        
            ProductContent_PEPPERS_PEPPERS_ALT_ALTERNATIVE_URL_,        
            ProductContent_PEPPERS_G_PEPPERS_G_ALT_ALTERNATIVE_URL_,        
            ProductContent_PEPPERS_H_PEPPERS_H_ALT_ALTERNATIVE_URL_,        
            ProductContent_PEPPERS_R_PEPPERS_R_ALT_ALTERNATIVE_URL_);

    public static final List<ProductConfigOptionData> productConfigOptionList=ImmutableList.of(        
            ProductConfigOption_IT0000_OP000,        
            ProductConfigOption_IT0000_OP001,        
            ProductConfigOption_IT0001_OP002,        
            ProductConfigOption_IT0001_OP003,        
            ProductConfigOption_IT0002_OP004,        
            ProductConfigOption_IT0002_OP005,        
            ProductConfigOption_IT0003_OP006,        
            ProductConfigOption_TEXMEX0000_OP010,        
            ProductConfigOption_TEXMEX0000_OP011,        
            ProductConfigOption_TEXMEX0001_OP012,        
            ProductConfigOption_PZ0000_PZOP000,        
            ProductConfigOption_PZ0000_PZOP001,        
            ProductConfigOption_PZ0001_PZOP003,        
            ProductConfigOption_PZ0001_PZOP002);

    public static final List<ProductCategoryMemberFlatData> productCategoryMemberList=ImmutableList.of(        
            ProductCategoryMember_PROMOTIONS_PC001_,        
            ProductCategoryMember_PC_100_PC001_,        
            ProductCategoryMember_CATALOG1_SEARCH_PC001_,        
            ProductCategoryMember_PROMOTIONS_ENCHILADAS_,        
            ProductCategoryMember_FOOD_001_ENCHILADAS_,        
            ProductCategoryMember_CATALOG1_SEARCH_ENCHILADAS_,        
            ProductCategoryMember_FOOD_001_PIZZA_,        
            ProductCategoryMember_CATALOG1_SEARCH_PIZZA_,        
            ProductCategoryMember_PROMOTIONS_PIZZA_);

    public static final List<ProductFeatureApplData> productFeatureApplList=ImmutableList.of(        
            ProductFeatureAppl_SAUCE_3001_,        
            ProductFeatureAppl_SAUCE_3002_,        
            ProductFeatureAppl_SAUCE_3003_,        
            ProductFeatureAppl_SAUCE_3004_,        
            ProductFeatureAppl_PEPPERS_3010_,        
            ProductFeatureAppl_PEPPERS_3011_,        
            ProductFeatureAppl_PEPPERS_3012_,        
            ProductFeatureAppl_SAUCE_TM_3001_,        
            ProductFeatureAppl_SAUCE_TM_3003_,        
            ProductFeatureAppl_SAUCE_CM_3002_,        
            ProductFeatureAppl_SAUCE_CM_3003_,        
            ProductFeatureAppl_SAUCE_TP_3001_,        
            ProductFeatureAppl_SAUCE_TP_3004_,        
            ProductFeatureAppl_SAUCE_CP_3002_,        
            ProductFeatureAppl_SAUCE_CP_3004_,        
            ProductFeatureAppl_PEPPERS_G_3010_,        
            ProductFeatureAppl_PEPPERS_H_3011_,        
            ProductFeatureAppl_PEPPERS_R_3012_);

    public static final List<WorkEffortData> workEffortList=ImmutableList.of(        
            WorkEffort_TASK01,        
            WorkEffort_TASK02,        
            WorkEffort_TASK03,        
            WorkEffort_ROUT01,        
            WorkEffort_TASK11,        
            WorkEffort_TASK12,        
            WorkEffort_TASK13,        
            WorkEffort_ROUT11,        
            WorkEffort_PZTASK01,        
            WorkEffort_PZTASK02,        
            WorkEffort_PZROUT01);

    public static final List<ContentData> contentList=ImmutableList.of(        
            Content_PC_100_ALT,        
            Content_CPC_100_ALTEN,        
            Content_FOOD_001_ALT,        
            Content_CFOOD_001_ALTEN,        
            Content_PC001_ALT,        
            Content_CPC001_ALTEN,        
            Content_RAM1GB_BRAND_ALT,        
            Content_CRAM1GB_BRAND_ALTEN,        
            Content_HD250GB_BRAND_ALT,        
            Content_CHD250GB_BRAND_ALTEN,        
            Content_HD500GB_BRAND_ALT,        
            Content_CHD500GB_BRAND_ALTEN,        
            Content_ETH_BRAND_ALT,        
            Content_CETH_BRAND_ALTEN,        
            Content_MOD_BRAND_ALT,        
            Content_CMOD_BRAND_ALTEN,        
            Content_MOTHER_BOARD_ASS_ALT,        
            Content_CMOTHER_BOARD_ASS,        
            Content_MOTHER_BOARD_ALT,        
            Content_CMOTHER_BOARD_ALTEN,        
            Content_CPU_586_ALT,        
            Content_CCPU_586_ALTEN,        
            Content_ENCHILADAS_ALT,        
            Content_CENCHILADAS_ALTEN,        
            Content_FAJITA_BEEF_ALT,        
            Content_CFAJITA_BEEF_ALTEN,        
            Content_JALAPENOS_ALT,        
            Content_CJALAPENOS_ALTEN,        
            Content_PIZZA_ALT,        
            Content_CPIZZA_ALTEN,        
            Content_DOUGH_ALT,        
            Content_CDOUGH_ALTEN,        
            Content_SAUCE_ALT,        
            Content_CSAUCE_ALTEN,        
            Content_SAUCE_TM_ALT,        
            Content_CSAUCE_TM_ALTEN,        
            Content_SAUCE_CM_ALT,        
            Content_CSAUCE_CM_ALTEN,        
            Content_SAUCE_TP_ALT,        
            Content_CSAUCE_TP_ALTEN,        
            Content_SAUCE_CP_ALT,        
            Content_CSAUCE_CP_ALTEN,        
            Content_PEPPERS_ALT,        
            Content_CPEPPERS_ALTEN,        
            Content_PEPPERS_G_ALT,        
            Content_CPEPPERS_G_ALTEN,        
            Content_PEPPERS_H_ALT,        
            Content_CPEPPERS_H_ALTEN,        
            Content_PEPPERS_R_ALT,        
            Content_CPEPPERS_R_ALTEN);

    public static final List<ProductFeatureCategoryData> productFeatureCategoryList=ImmutableList.of(        
            ProductFeatureCategory_3000);

    public static final List<ProductCategoryFlatData> productCategoryList=ImmutableList.of(        
            ProductCategory_PC_100,        
            ProductCategory_FOOD_001);

    public static final List<ProductCategoryContentData> productCategoryContentList=ImmutableList.of(        
            ProductCategoryContent_PC_100_PC_100_ALT_ALTERNATIVE_URL_,        
            ProductCategoryContent_FOOD_001_FOOD_001_ALT_ALTERNATIVE_URL_);

    public static final List<ProductAssocData> productAssocList=ImmutableList.of(        
            ProductAssoc_MOTHER_BOARD_ASS_MOTHER_BOARD_MANUF_COMPONENT_,        
            ProductAssoc_MOTHER_BOARD_ASS_CPU_586_MANUF_COMPONENT_,        
            ProductAssoc_PEPPERS_PEPPERS_G_PRODUCT_VARIANT_,        
            ProductAssoc_PEPPERS_PEPPERS_H_PRODUCT_VARIANT_,        
            ProductAssoc_PEPPERS_PEPPERS_R_PRODUCT_VARIANT_,        
            ProductAssoc_SAUCE_SAUCE_TM_PRODUCT_VARIANT_,        
            ProductAssoc_SAUCE_SAUCE_CM_PRODUCT_VARIANT_,        
            ProductAssoc_SAUCE_SAUCE_TP_PRODUCT_VARIANT_,        
            ProductAssoc_SAUCE_SAUCE_CP_PRODUCT_VARIANT_);

    public static final List<WorkEffortGoodStandardData> workEffortGoodStandardList=ImmutableList.of(        
            WorkEffortGoodStandard_ROUT01_PC001_ROU_PROD_TEMPLATE_,        
            WorkEffortGoodStandard_ROUT11_ENCHILADAS_ROU_PROD_TEMPLATE_,        
            WorkEffortGoodStandard_PZROUT01_PIZZA_ROU_PROD_TEMPLATE_);

    public static final List<WorkEffortAssocData> workEffortAssocList=ImmutableList.of(        
            WorkEffortAssoc_ROUT01_TASK01_ROUTING_COMPONENT_,        
            WorkEffortAssoc_ROUT01_TASK02_ROUTING_COMPONENT_,        
            WorkEffortAssoc_ROUT01_TASK03_ROUTING_COMPONENT_,        
            WorkEffortAssoc_ROUT11_TASK11_ROUTING_COMPONENT_,        
            WorkEffortAssoc_ROUT11_TASK12_ROUTING_COMPONENT_,        
            WorkEffortAssoc_ROUT11_TASK13_ROUTING_COMPONENT_,        
            WorkEffortAssoc_PZROUT01_PZTASK01_ROUTING_COMPONENT_,        
            WorkEffortAssoc_PZROUT01_PZTASK02_ROUTING_COMPONENT_);

}
