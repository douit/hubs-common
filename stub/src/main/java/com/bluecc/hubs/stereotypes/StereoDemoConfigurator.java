package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.FixedAssetGeoPointData;
import com.bluecc.hubs.stub.ProductConfigProductData;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.ProductConfigItemData;
import com.bluecc.hubs.stub.ProductConfigData;
import com.bluecc.hubs.stub.ProductFeatureData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.FixedAssetData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.hubs.stub.ProductContentData;
import com.bluecc.hubs.stub.ProductConfigOptionData;
import com.bluecc.hubs.stub.ProductCategoryMemberData;
import com.bluecc.hubs.stub.ProductFeatureApplData;
import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductFeatureCategoryData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductCategoryContentData;
import com.bluecc.hubs.stub.ProductAssocData;
import com.bluecc.hubs.stub.WorkEffortGoodStandardData;
import com.bluecc.hubs.stub.WorkEffortAssocData;

public final class StereoDemoConfigurator {
    public final static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_BOOK_GROUP_9000_ = FixedAssetGeoPointData.newBuilder()
        .setFixedAssetId("DEMO_BOOK_GROUP")
        .setFromDate(getTimestamp("2011-08-02 00:00:00.000"))
        .setGeoPointId("9000")
        .build();


    public final static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_MACHINE_GROUP_9000_ = FixedAssetGeoPointData.newBuilder()
        .setFixedAssetId("DEMO_MACHINE_GROUP")
        .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
        .setGeoPointId("9000")
        .build();


    public final static FixedAssetGeoPointData FixedAssetGeoPoint_DEMO_FOOD_GROUP_9000_ = FixedAssetGeoPointData.newBuilder()
        .setFixedAssetId("DEMO_FOOD_GROUP")
        .setFromDate(getTimestamp("2009-01-09 00:00:00.000"))
        .setGeoPointId("9000")
        .build();


    public final static ProductConfigProductData ProductConfigProduct_IT0000_OP000_RAM1GB_BRAND = ProductConfigProductData.newBuilder()
        .setConfigItemId("IT0000")
        .setConfigOptionId("OP000")
        .setProductId("RAM1GB_BRAND")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_IT0000_OP001_RAM1GB_BRAND = ProductConfigProductData.newBuilder()
        .setConfigItemId("IT0000")
        .setConfigOptionId("OP001")
        .setProductId("RAM1GB_BRAND")
        .setQuantity(getFixedPoint("2"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_IT0001_OP002_HD250GB_BRAND = ProductConfigProductData.newBuilder()
        .setConfigItemId("IT0001")
        .setConfigOptionId("OP002")
        .setProductId("HD250GB_BRAND")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_IT0001_OP003_HD500GB_BRAND = ProductConfigProductData.newBuilder()
        .setConfigItemId("IT0001")
        .setConfigOptionId("OP003")
        .setProductId("HD500GB_BRAND")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_IT0002_OP004_ETH_BRAND = ProductConfigProductData.newBuilder()
        .setConfigItemId("IT0002")
        .setConfigOptionId("OP004")
        .setProductId("ETH_BRAND")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_IT0002_OP005_MOD_BRAND = ProductConfigProductData.newBuilder()
        .setConfigItemId("IT0002")
        .setConfigOptionId("OP005")
        .setProductId("MOD_BRAND")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_IT0003_OP006_MOTHER_BOARD_ASS = ProductConfigProductData.newBuilder()
        .setConfigItemId("IT0003")
        .setConfigOptionId("OP006")
        .setProductId("MOTHER_BOARD_ASS")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_TEXMEX0000_OP010_ENCHILADAS = ProductConfigProductData.newBuilder()
        .setConfigItemId("TEXMEX0000")
        .setConfigOptionId("OP010")
        .setProductId("ENCHILADAS")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_TEXMEX0000_OP011_FAJITA_BEEF = ProductConfigProductData.newBuilder()
        .setConfigItemId("TEXMEX0000")
        .setConfigOptionId("OP011")
        .setProductId("FAJITA_BEEF")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_TEXMEX0001_OP012_JALAPENOS = ProductConfigProductData.newBuilder()
        .setConfigItemId("TEXMEX0001")
        .setConfigOptionId("OP012")
        .setProductId("JALAPENOS")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_PZ0000_PZOP000_DOUGH = ProductConfigProductData.newBuilder()
        .setConfigItemId("PZ0000")
        .setConfigOptionId("PZOP000")
        .setProductId("DOUGH")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_PZ0000_PZOP001_DOUGH = ProductConfigProductData.newBuilder()
        .setConfigItemId("PZ0000")
        .setConfigOptionId("PZOP001")
        .setProductId("DOUGH")
        .setQuantity(getFixedPoint("2"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_PZ0001_PZOP003_PEPPERS = ProductConfigProductData.newBuilder()
        .setConfigItemId("PZ0001")
        .setConfigOptionId("PZOP003")
        .setProductId("PEPPERS")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProductConfigProductData ProductConfigProduct_PZ0001_PZOP002_SAUCE = ProductConfigProductData.newBuilder()
        .setConfigItemId("PZ0001")
        .setConfigOptionId("PZOP002")
        .setProductId("SAUCE")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ElectronicTextData ElectronicText_PC_100_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("PC-100-ALT")
        .setTextData("configurable-pcs")
        .build();


    public final static ElectronicTextData ElectronicText_FOOD_001_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("FOOD-001-ALT")
        .setTextData("configurable-foods")
        .build();


    public final static ElectronicTextData ElectronicText_PC001_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("PC001-ALT")
        .setTextData("configurable-pc")
        .build();


    public final static ElectronicTextData ElectronicText_RAM1GB_BRAND_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("RAM1GB_BRAND-ALT")
        .setTextData("ram-1-gb-ddr2")
        .build();


    public final static ElectronicTextData ElectronicText_HD250GB_BRAND_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("HD250GB_BRAND-ALT")
        .setTextData("hd-250-gb")
        .build();


    public final static ElectronicTextData ElectronicText_HD500GB_BRAND_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("HD500GB_BRAND-ALT")
        .setTextData("hd-450-gb")
        .build();


    public final static ElectronicTextData ElectronicText_ETH_BRAND_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("ETH_BRAND-ALT")
        .setTextData("ethernet-card-10-100")
        .build();


    public final static ElectronicTextData ElectronicText_MOD_BRAND_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("MOD_BRAND-ALT")
        .setTextData("modem-card-56k")
        .build();


    public final static ElectronicTextData ElectronicText_MOTHER_BOARD_ASS_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("MOTHER_BOARD_ASS-ALT")
        .setTextData("motherboard-assembly")
        .build();


    public final static ElectronicTextData ElectronicText_MOTHER_BOARD_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("MOTHER_BOARD-ALT")
        .setTextData("motherboard")
        .build();


    public final static ElectronicTextData ElectronicText_CPU_586_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("CPU-586-ALT")
        .setTextData("cpu-intel-586")
        .build();


    public final static ElectronicTextData ElectronicText_ENCHILADAS_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("ENCHILADAS-ALT")
        .setTextData("enchiladas")
        .build();


    public final static ElectronicTextData ElectronicText_FAJITA_BEEF_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("FAJITA_BEEF-ALT")
        .setTextData("fajita-beef")
        .build();


    public final static ElectronicTextData ElectronicText_JALAPENOS_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("JALAPENOS-ALT")
        .setTextData("jalapenos")
        .build();


    public final static ElectronicTextData ElectronicText_PIZZA_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("PIZZA-ALT")
        .setTextData("pizza")
        .build();


    public final static ElectronicTextData ElectronicText_DOUGH_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("DOUGH-ALT")
        .setTextData("dough")
        .build();


    public final static ElectronicTextData ElectronicText_SAUCE_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("SAUCE-ALT")
        .setTextData("sauce")
        .build();


    public final static ElectronicTextData ElectronicText_SAUCE_TM_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("SAUCE-TM-ALT")
        .setTextData("tomato-sauce-with-mozzarella")
        .build();


    public final static ElectronicTextData ElectronicText_SAUCE_CM_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("SAUCE-CM-ALT")
        .setTextData("chili-sauce-with-mozzarella")
        .build();


    public final static ElectronicTextData ElectronicText_SAUCE_TP_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("SAUCE-TP-ALT")
        .setTextData("tomato-sauce-with-parmesan")
        .build();


    public final static ElectronicTextData ElectronicText_SAUCE_CP_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("SAUCE-CP-ALT")
        .setTextData("chili-sauce-with-parmesan")
        .build();


    public final static ElectronicTextData ElectronicText_PEPPERS_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("PEPPERS-ALT")
        .setTextData("pepper")
        .build();


    public final static ElectronicTextData ElectronicText_PEPPERS_G_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("PEPPERS-G-ALT")
        .setTextData("green-peppers")
        .build();


    public final static ElectronicTextData ElectronicText_PEPPERS_H_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("PEPPERS-H-ALT")
        .setTextData("hot-peppers")
        .build();


    public final static ElectronicTextData ElectronicText_PEPPERS_R_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("PEPPERS-R-ALT")
        .setTextData("roasted-peppers")
        .build();


    public final static ElectronicTextData ElectronicText_DRPC_100_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRPC-100-ALTEN")
        .setTextData("configurable-pcs")
        .build();


    public final static ElectronicTextData ElectronicText_DRFOOD_001_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRFOOD-001-ALTEN")
        .setTextData("configurable-foods")
        .build();


    public final static ElectronicTextData ElectronicText_DRPC001_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRPC001-ALTEN")
        .setTextData("configurable-pc")
        .build();


    public final static ElectronicTextData ElectronicText_DRRAM1GB_BRAND_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRRAM1GB_BRAND-ALTEN")
        .setTextData("ram-1-gb-ddr2")
        .build();


    public final static ElectronicTextData ElectronicText_DRHD250GB_BRAND_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("DRHD250GB_BRAND-ALT")
        .setTextData("hd-250-gb")
        .build();


    public final static ElectronicTextData ElectronicText_DRHD500GB_BRAND_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("DRHD500GB_BRAND-ALT")
        .setTextData("hd-450-gb")
        .build();


    public final static ElectronicTextData ElectronicText_DRETH_BRAND_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRETH_BRAND-ALTEN")
        .setTextData("ethernet-card-10-100")
        .build();


    public final static ElectronicTextData ElectronicText_DRMOD_BRAND_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRMOD_BRAND-ALTEN")
        .setTextData("modem-card-56k")
        .build();


    public final static ElectronicTextData ElectronicText_DMOTHER_BOARD_ASS = ElectronicTextData.newBuilder()
        .setDataResourceId("DMOTHER_BOARD_ASS")
        .setTextData("motherboard-assembly")
        .build();


    public final static ElectronicTextData ElectronicText_DRMOTHER_BOARD_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRMOTHER_BOARD-ALTEN")
        .setTextData("motherboard")
        .build();


    public final static ElectronicTextData ElectronicText_DRCPU_586_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRCPU-586-ALTEN")
        .setTextData("cpu-intel-586")
        .build();


    public final static ElectronicTextData ElectronicText_DRENCHILADAS_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRENCHILADAS-ALTEN")
        .setTextData("enchiladas")
        .build();


    public final static ElectronicTextData ElectronicText_DRFAJITA_BEEF_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRFAJITA_BEEF-ALTEN")
        .setTextData("fajita-beef")
        .build();


    public final static ElectronicTextData ElectronicText_DRJALAPENOS_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRJALAPENOS-ALTEN")
        .setTextData("jalapenos")
        .build();


    public final static ElectronicTextData ElectronicText_DRPIZZA_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRPIZZA-ALTEN")
        .setTextData("pizza")
        .build();


    public final static ElectronicTextData ElectronicText_DRDOUGH_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRDOUGH-ALTEN")
        .setTextData("dough")
        .build();


    public final static ElectronicTextData ElectronicText_DRSAUCE_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRSAUCE-ALTEN")
        .setTextData("sauce")
        .build();


    public final static ElectronicTextData ElectronicText_DRSAUCE_TM_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRSAUCE-TM-ALTEN")
        .setTextData("tomato-sauce-with-mozzarella")
        .build();


    public final static ElectronicTextData ElectronicText_DRSAUCE_CM_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRSAUCE-CM-ALTEN")
        .setTextData("chili-sauce-with-mozzarella")
        .build();


    public final static ElectronicTextData ElectronicText_DRSAUCE_TP_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRSAUCE-TP-ALTEN")
        .setTextData("tomato-sauce-with-parmesan")
        .build();


    public final static ElectronicTextData ElectronicText_DRSAUCE_CP_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRSAUCE-CP-ALTEN")
        .setTextData("chili-sauce-with-parmesan")
        .build();


    public final static ElectronicTextData ElectronicText_DRPEPPERS_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRPEPPERS-ALTEN")
        .setTextData("pepper")
        .build();


    public final static ElectronicTextData ElectronicText_DRPEPPERS_G_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRPEPPERS-G-ALTEN")
        .setTextData("green-peppers")
        .build();


    public final static ElectronicTextData ElectronicText_DRPEPPERS_H_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRPEPPERS-H-ALTEN")
        .setTextData("hot-peppers")
        .build();


    public final static ElectronicTextData ElectronicText_DRPEPPERS_R_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRPEPPERS-R-ALTEN")
        .setTextData("roasted-peppers")
        .build();


    public final static ContentAssocData ContentAssoc_PC_100_ALT_CPC_100_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("PC-100-ALT")
        .setContentIdTo("CPC-100-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_FOOD_001_ALT_CFOOD_001_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("FOOD-001-ALT")
        .setContentIdTo("CFOOD-001-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_PC001_ALT_CPC001_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("PC001-ALT")
        .setContentIdTo("CPC001-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_RAM1GB_BRAND_ALT_CRAM1GB_BRAND_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("RAM1GB_BRAND-ALT")
        .setContentIdTo("CRAM1GB_BRAND-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_HD250GB_BRAND_ALT_CHD250GB_BRAND_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("HD250GB_BRAND-ALT")
        .setContentIdTo("CHD250GB_BRAND-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_HD500GB_BRAND_ALT_CHD500GB_BRAND_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("HD500GB_BRAND-ALT")
        .setContentIdTo("CHD500GB_BRAND-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_ETH_BRAND_ALT_CETH_BRAND_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("ETH_BRAND-ALT")
        .setContentIdTo("CETH_BRAND-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_MOD_BRAND_ALT_CMOD_BRAND_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("MOD_BRAND-ALT")
        .setContentIdTo("CMOD_BRAND-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_MOTHER_BOARD_ASS_ALT_CMOTHER_BOARD_ASS_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("MOTHER_BOARD_ASS-ALT")
        .setContentIdTo("CMOTHER_BOARD_ASS")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_MOTHER_BOARD_ALT_CMOTHER_BOARD_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("MOTHER_BOARD-ALT")
        .setContentIdTo("CMOTHER_BOARD-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_CPU_586_ALT_CCPU_586_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("CPU-586-ALT")
        .setContentIdTo("CCPU-586-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_ENCHILADAS_ALT_CENCHILADAS_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("ENCHILADAS-ALT")
        .setContentIdTo("CENCHILADAS-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_FAJITA_BEEF_ALT_CFAJITA_BEEF_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("FAJITA_BEEF-ALT")
        .setContentIdTo("CFAJITA_BEEF-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_JALAPENOS_ALT_CJALAPENOS_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("JALAPENOS-ALT")
        .setContentIdTo("CJALAPENOS-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_PIZZA_ALT_CPIZZA_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("PIZZA-ALT")
        .setContentIdTo("CPIZZA-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_DOUGH_ALT_CDOUGH_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("DOUGH-ALT")
        .setContentIdTo("CDOUGH-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_SAUCE_ALT_CSAUCE_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("SAUCE-ALT")
        .setContentIdTo("CSAUCE-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_SAUCE_TM_ALT_CSAUCE_TM_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("SAUCE-TM-ALT")
        .setContentIdTo("CSAUCE-TM-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_SAUCE_CM_ALT_CSAUCE_CM_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("SAUCE-CM-ALT")
        .setContentIdTo("CSAUCE-CM-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_SAUCE_TP_ALT_CSAUCE_TP_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("SAUCE-TP-ALT")
        .setContentIdTo("CSAUCE-TP-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_SAUCE_CP_ALT_CSAUCE_CP_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("SAUCE-CP-ALT")
        .setContentIdTo("CSAUCE-CP-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_PEPPERS_ALT_CPEPPERS_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("PEPPERS-ALT")
        .setContentIdTo("CPEPPERS-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_PEPPERS_G_ALT_CPEPPERS_G_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("PEPPERS-G-ALT")
        .setContentIdTo("CPEPPERS-G-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_PEPPERS_H_ALT_CPEPPERS_H_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("PEPPERS-H-ALT")
        .setContentIdTo("CPEPPERS-H-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_PEPPERS_R_ALT_CPEPPERS_R_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("PEPPERS-R-ALT")
        .setContentIdTo("CPEPPERS-R-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ProductConfigItemData ProductConfigItem_IT0000 = ProductConfigItemData.newBuilder()
        .setConfigItemId("IT0000")
        .setConfigItemName("RAM (brand)")
        .setConfigItemTypeId("SINGLE")
        .setDescription("Select the memory configuration:")
        .build();


    public final static ProductConfigItemData ProductConfigItem_IT0001 = ProductConfigItemData.newBuilder()
        .setConfigItemId("IT0001")
        .setConfigItemName("HD (brand)")
        .setConfigItemTypeId("SINGLE")
        .setDescription("Select the Hard Disk:")
        .build();


    public final static ProductConfigItemData ProductConfigItem_IT0002 = ProductConfigItemData.newBuilder()
        .setConfigItemId("IT0002")
        .setConfigItemName("PCI slot")
        .setConfigItemTypeId("MULTIPLE")
        .setDescription("Select the PCI cards:")
        .build();


    public final static ProductConfigItemData ProductConfigItem_IT0003 = ProductConfigItemData.newBuilder()
        .setConfigItemId("IT0003")
        .setConfigItemName("Standard Items")
        .setConfigItemTypeId("SINGLE")
        .setDescription("Standard Items")
        .build();


    public final static ProductConfigItemData ProductConfigItem_TEXMEX0000 = ProductConfigItemData.newBuilder()
        .setConfigItemId("TEXMEX0000")
        .setConfigItemName("Enchiladas type")
        .setConfigItemTypeId("SINGLE")
        .setDescription("Select cheese or beef (default to cheese):")
        .build();


    public final static ProductConfigItemData ProductConfigItem_TEXMEX0001 = ProductConfigItemData.newBuilder()
        .setConfigItemId("TEXMEX0001")
        .setConfigItemName("Peppers")
        .setConfigItemTypeId("MULTIPLE")
        .setDescription("Add jalapenos :")
        .build();


    public final static ProductConfigItemData ProductConfigItem_PZ0000 = ProductConfigItemData.newBuilder()
        .setConfigItemId("PZ0000")
        .setConfigItemName("Dough")
        .setConfigItemTypeId("SINGLE")
        .setDescription("Select type:")
        .build();


    public final static ProductConfigItemData ProductConfigItem_PZ0001 = ProductConfigItemData.newBuilder()
        .setConfigItemId("PZ0001")
        .setConfigItemName("Toppings")
        .setConfigItemTypeId("MULTIPLE")
        .setDescription("Select the Toppings:")
        .build();


    public final static ProductConfigData ProductConfig_PC001_IT0000_10_ = ProductConfigData.newBuilder()
        .setConfigItemId("IT0000")
        .setConfigTypeId("QUESTION")
        .setDefaultConfigOptionId("OP001")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("Y"))
        .setProductId("PC001")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigData ProductConfig_PC001_IT0001_20_ = ProductConfigData.newBuilder()
        .setConfigItemId("IT0001")
        .setConfigTypeId("QUESTION")
        .setDefaultConfigOptionId("OP003")
        .setDescription("1st Hard Disk drive")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("Y"))
        .setProductId("PC001")
        .setSequenceNum(20)
        .build();


    public final static ProductConfigData ProductConfig_PC001_IT0001_30_ = ProductConfigData.newBuilder()
        .setConfigItemId("IT0001")
        .setConfigTypeId("QUESTION")
        .setDescription("2nd Hard Disk drive")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("N"))
        .setProductId("PC001")
        .setSequenceNum(30)
        .build();


    public final static ProductConfigData ProductConfig_PC001_IT0002_40_ = ProductConfigData.newBuilder()
        .setConfigItemId("IT0002")
        .setConfigTypeId("QUESTION")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("N"))
        .setProductId("PC001")
        .setSequenceNum(40)
        .build();


    public final static ProductConfigData ProductConfig_PC001_IT0003_1_ = ProductConfigData.newBuilder()
        .setConfigItemId("IT0003")
        .setConfigTypeId("STANDARD")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("Y"))
        .setProductId("PC001")
        .setSequenceNum(1)
        .build();


    public final static ProductConfigData ProductConfig_ENCHILADAS_TEXMEX0000_10_ = ProductConfigData.newBuilder()
        .setConfigItemId("TEXMEX0000")
        .setConfigTypeId("QUESTION")
        .setDefaultConfigOptionId("OP010")
        .setDescription("Enchiladas type")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("Y"))
        .setProductId("ENCHILADAS")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigData ProductConfig_ENCHILADAS_TEXMEX0001_20_ = ProductConfigData.newBuilder()
        .setConfigItemId("TEXMEX0001")
        .setConfigTypeId("QUESTION")
        .setDescription("Peppers")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("N"))
        .setProductId("ENCHILADAS")
        .setSequenceNum(20)
        .build();


    public final static ProductConfigData ProductConfig_PIZZA_PZ0000_10_ = ProductConfigData.newBuilder()
        .setConfigItemId("PZ0000")
        .setConfigTypeId("QUESTION")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("Y"))
        .setProductId("PIZZA")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigData ProductConfig_PIZZA_PZ0001_30_ = ProductConfigData.newBuilder()
        .setConfigItemId("PZ0001")
        .setConfigTypeId("QUESTION")
        .setFromDate(getTimestamp("2004-08-20 12:59:26.209"))
        .setIsMandatory(castIndicator("N"))
        .setProductId("PIZZA")
        .setSequenceNum(30)
        .build();


    public final static ProductFeatureData ProductFeature_3001 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(1)
        .setDescription("Tomato")
        .setProductFeatureCategoryId("3000")
        .setProductFeatureId("3001")
        .setProductFeatureTypeId("TYPE")
        .build();


    public final static ProductFeatureData ProductFeature_3002 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(2)
        .setDescription("Chili")
        .setProductFeatureCategoryId("3000")
        .setProductFeatureId("3002")
        .setProductFeatureTypeId("TYPE")
        .build();


    public final static ProductFeatureData ProductFeature_3003 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(3)
        .setDescription("Mozzarella")
        .setProductFeatureCategoryId("3000")
        .setProductFeatureId("3003")
        .setProductFeatureTypeId("OTHER_FEATURE")
        .build();


    public final static ProductFeatureData ProductFeature_3004 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(4)
        .setDescription("Parmesan")
        .setProductFeatureCategoryId("3000")
        .setProductFeatureId("3004")
        .setProductFeatureTypeId("OTHER_FEATURE")
        .build();


    public final static ProductFeatureData ProductFeature_3010 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(1)
        .setDescription("Green")
        .setProductFeatureCategoryId("3000")
        .setProductFeatureId("3010")
        .setProductFeatureTypeId("TYPE")
        .build();


    public final static ProductFeatureData ProductFeature_3011 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(2)
        .setDescription("Hot")
        .setProductFeatureCategoryId("3000")
        .setProductFeatureId("3011")
        .setProductFeatureTypeId("TYPE")
        .build();


    public final static ProductFeatureData ProductFeature_3012 = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(3)
        .setDescription("Roasted")
        .setProductFeatureCategoryId("3000")
        .setProductFeatureId("3012")
        .setProductFeatureTypeId("TYPE")
        .build();


    public final static ProductFlatData Product_PC001 = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:49:13.418"))
        .setDescription("Configurable PC")
        .setInternalName("Configurable PC")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("PC001")
        .setProductName("Configurable PC")
        .setProductTypeId("AGGREGATED")
        .build();


    public final static ProductFlatData Product_RAM1GB_BRAND = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("1 GB Dual Channel DDR2 SDRAM")
        .setInternalName("RAM 1 GB DDR2")
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("RAM1GB_BRAND")
        .setProductName("RAM1GB")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_HD250GB_BRAND = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("250 GB Hard Drive")
        .setInternalName("HD 250 GB")
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("HD250GB_BRAND")
        .setProductName("HD250GB")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_HD500GB_BRAND = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("500 GB Hard Drive")
        .setInternalName("HD 450 GB")
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("HD500GB_BRAND")
        .setProductName("HD500GB")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_ETH_BRAND = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("Ethernet Card 10/100")
        .setInternalName("Ethernet Card 10/100")
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("ETH_BRAND")
        .setProductName("Ethernet100")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_MOD_BRAND = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("Modem Card 56k")
        .setInternalName("Modem Card 56k")
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("MOD_BRAND")
        .setProductName("Modem56k")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_MOTHER_BOARD_ASS = ProductFlatData.newBuilder()
        .setDescription("Motherboard Assembly")
        .setInternalName("Motherboard assembly")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("MOTHER_BOARD_ASS")
        .setProductName("MotherBoard Assembly")
        .setProductTypeId("MARKETING_PKG_AUTO")
        .build();


    public final static ProductFlatData Product_MOTHER_BOARD = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setDescription("Motherboard")
        .setInternalName("Motherboard")
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("MOTHER_BOARD")
        .setProductName("MotherBoard")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_CPU_586 = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setDescription("CPU intel 586")
        .setInternalName("CPU intel 586")
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("CPU-586")
        .setProductName("CPU 586")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_ENCHILADAS = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setDescription("Cheese enchiladas")
        .setInternalName("Enchiladas")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("ENCHILADAS")
        .setProductName("Enchiladas")
        .setProductTypeId("AGGREGATED")
        .build();


    public final static ProductFlatData Product_FAJITA_BEEF = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setDescription("Fajita beef")
        .setInternalName("Fajita beef")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("FAJITA_BEEF")
        .setProductName("Fajita beef")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_JALAPENOS = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setDescription("Jalapenos")
        .setInternalName("Jalapenos")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("JALAPENOS")
        .setProductName("Jalapenos")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_PIZZA = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:49:13.418"))
        .setDescription("Create your own pizza")
        .setInternalName("Pizza")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("PIZZA")
        .setProductName("Gold Pizza")
        .setProductTypeId("AGGREGATED")
        .build();


    public final static ProductFlatData Product_DOUGH = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("Dough")
        .setInternalName("Dough")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setProductId("DOUGH")
        .setProductName("Dough")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_SAUCE = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("Sauce")
        .setInternalName("Sauce")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("Y"))
        .setProductId("SAUCE")
        .setProductName("Sauce")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_SAUCE_TM = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Tomato Sauce with Mozzarella")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Tomato Sauce with Mozzarella")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("SAUCE-TM")
        .setProductName("Tomato Sauce with Mozzarella")
        .setProductTypeId("FINISHED_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_SAUCE_CM = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Chili Sauce with Mozzarella")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Chili Sauce with Mozzarella")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("SAUCE-CM")
        .setProductName("Chili Sauce with Mozzarella")
        .setProductTypeId("FINISHED_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_SAUCE_TP = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Tomato Sauce")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Tomato Sauce with Parmesan")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("SAUCE-TP")
        .setProductName("Tomato Sauce with Parmesan")
        .setProductTypeId("FINISHED_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_SAUCE_CP = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Chili Sauce with Parmesan")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Chili Sauce")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("SAUCE-CP")
        .setProductName("Chili Sauce with Parmesan")
        .setProductTypeId("FINISHED_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_PEPPERS = ProductFlatData.newBuilder()
        .setBillOfMaterialLevel(0)
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:50:54.794"))
        .setDescription("Pepper")
        .setInternalName("Pepper")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("Y"))
        .setProductId("PEPPERS")
        .setProductName("Peppers")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductFlatData Product_PEPPERS_G = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Green Peppers")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Green Peppers")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("PEPPERS-G")
        .setProductName("Green Peppers")
        .setProductTypeId("FINISHED_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_PEPPERS_H = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Hot Peppers")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Hot Peppers")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("PEPPERS-H")
        .setProductName("Hot Peppers")
        .setProductTypeId("FINISHED_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductFlatData Product_PEPPERS_R = ProductFlatData.newBuilder()
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setDescription("Roasted Peppers")
        .setIncludeInPromotions(castIndicator("N"))
        .setInternalName("Roasted Peppers")
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .setIsVariant(castIndicator("Y"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2003-11-20 13:48:19.105"))
        .setProductId("PEPPERS-R")
        .setProductName("Roasted Peppers")
        .setProductTypeId("FINISHED_GOOD")
        .setReturnable(castIndicator("N"))
        .setTaxable(castIndicator("N"))
        .build();


    public final static ProductPriceData ProductPrice_PC001_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setPrice(getCurrency("50"))
        .setProductId("PC001")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_RAM1GB_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setPrice(getCurrency("115"))
        .setProductId("RAM1GB_BRAND")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_RAM1GB_BRAND_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("120"))
        .setProductId("RAM1GB_BRAND")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_HD250GB_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setPrice(getCurrency("220"))
        .setProductId("HD250GB_BRAND")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_HD500GB_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("420"))
        .setProductId("HD500GB_BRAND")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_ETH_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("18"))
        .setProductId("ETH_BRAND")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_MOD_BRAND_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("15"))
        .setProductId("MOD_BRAND")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_MOTHER_BOARD_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("150"))
        .setProductId("MOTHER_BOARD")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_CPU_586_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("250"))
        .setProductId("CPU-586")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_ENCHILADAS_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setPrice(getCurrency("6"))
        .setProductId("ENCHILADAS")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_FAJITA_BEEF_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setPrice(getCurrency("2"))
        .setProductId("FAJITA_BEEF")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_FAJITA_BEEF_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setPrice(getCurrency("8"))
        .setProductId("FAJITA_BEEF")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_JALAPENOS_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setPrice(getCurrency("0.75"))
        .setProductId("JALAPENOS")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_PIZZA_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setPrice(getCurrency("5"))
        .setProductId("PIZZA")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_DOUGH_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:53.223"))
        .setPrice(getCurrency("3"))
        .setProductId("DOUGH")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("1.5"))
        .setProductId("SAUCE")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2004-08-20 12:55:36.479"))
        .setPrice(getCurrency("1.5"))
        .setProductId("SAUCE")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_TM_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.0"))
        .setProductId("SAUCE-TM")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_TM_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.0"))
        .setProductId("SAUCE-TM")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_CM_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("2.0"))
        .setProductId("SAUCE-CM")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_CM_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("2.0"))
        .setProductId("SAUCE-CM")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_TP_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.5"))
        .setProductId("SAUCE-TP")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_TP_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.5"))
        .setProductId("SAUCE-TP")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_CP_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("2.5"))
        .setProductId("SAUCE-CP")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_SAUCE_CP_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("2.5"))
        .setProductId("SAUCE-CP")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_PEPPERS_G_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("2.0"))
        .setProductId("PEPPERS-G")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_PEPPERS_G_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.0"))
        .setProductId("PEPPERS-G")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_PEPPERS_H_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("2.0"))
        .setProductId("PEPPERS-H")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_PEPPERS_H_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("2.0"))
        .setProductId("PEPPERS-H")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_PEPPERS_R_DEFAULT_PRICE_COMPONENT_PRICE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.5"))
        .setProductId("PEPPERS-R")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_PEPPERS_R_DEFAULT_PRICE_PURCHASE_USD__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("USD")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("1.5"))
        .setProductId("PEPPERS-R")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static FixedAssetData FixedAsset_DEMO_BOOK_GROUP = FixedAssetData.newBuilder()
        .setFixedAssetId("DEMO_BOOK_GROUP")
        .setFixedAssetName("Demo Book Group")
        .setFixedAssetTypeId("GROUP_EQUIPMENT")
        .build();


    public final static FixedAssetData FixedAsset_DEMO_MACHINE_GROUP = FixedAssetData.newBuilder()
        .setFixedAssetId("DEMO_MACHINE_GROUP")
        .setFixedAssetName("Demo Machine Group")
        .setFixedAssetTypeId("GROUP_EQUIPMENT")
        .build();


    public final static FixedAssetData FixedAsset_DEMO_FOOD_GROUP = FixedAssetData.newBuilder()
        .setFixedAssetId("DEMO_FOOD_GROUP")
        .setFixedAssetName("Demo Food Group")
        .setFixedAssetTypeId("GROUP_EQUIPMENT")
        .build();


    public final static DataResourceData DataResource_PC_100_ALT = DataResourceData.newBuilder()
        .setDataResourceId("PC-100-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRPC_100_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRPC-100-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_FOOD_001_ALT = DataResourceData.newBuilder()
        .setDataResourceId("FOOD-001-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRFOOD_001_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRFOOD-001-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_PC001_ALT = DataResourceData.newBuilder()
        .setDataResourceId("PC001-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRPC001_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRPC001-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_RAM1GB_BRAND_ALT = DataResourceData.newBuilder()
        .setDataResourceId("RAM1GB_BRAND-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRRAM1GB_BRAND_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRRAM1GB_BRAND-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_HD250GB_BRAND_ALT = DataResourceData.newBuilder()
        .setDataResourceId("HD250GB_BRAND-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRHD250GB_BRAND_ALT = DataResourceData.newBuilder()
        .setDataResourceId("DRHD250GB_BRAND-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_HD500GB_BRAND_ALT = DataResourceData.newBuilder()
        .setDataResourceId("HD500GB_BRAND-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRHD500GB_BRAND_ALT = DataResourceData.newBuilder()
        .setDataResourceId("DRHD500GB_BRAND-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_ETH_BRAND_ALT = DataResourceData.newBuilder()
        .setDataResourceId("ETH_BRAND-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRETH_BRAND_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRETH_BRAND-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_MOD_BRAND_ALT = DataResourceData.newBuilder()
        .setDataResourceId("MOD_BRAND-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRMOD_BRAND_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRMOD_BRAND-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_MOTHER_BOARD_ASS_ALT = DataResourceData.newBuilder()
        .setDataResourceId("MOTHER_BOARD_ASS-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DMOTHER_BOARD_ASS = DataResourceData.newBuilder()
        .setDataResourceId("DMOTHER_BOARD_ASS")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_MOTHER_BOARD_ALT = DataResourceData.newBuilder()
        .setDataResourceId("MOTHER_BOARD-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRMOTHER_BOARD_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRMOTHER_BOARD-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_CPU_586_ALT = DataResourceData.newBuilder()
        .setDataResourceId("CPU-586-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRCPU_586_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRCPU-586-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_ENCHILADAS_ALT = DataResourceData.newBuilder()
        .setDataResourceId("ENCHILADAS-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRENCHILADAS_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRENCHILADAS-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_FAJITA_BEEF_ALT = DataResourceData.newBuilder()
        .setDataResourceId("FAJITA_BEEF-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRFAJITA_BEEF_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRFAJITA_BEEF-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_JALAPENOS_ALT = DataResourceData.newBuilder()
        .setDataResourceId("JALAPENOS-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRJALAPENOS_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRJALAPENOS-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_PIZZA_ALT = DataResourceData.newBuilder()
        .setDataResourceId("PIZZA-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRPIZZA_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRPIZZA-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_DOUGH_ALT = DataResourceData.newBuilder()
        .setDataResourceId("DOUGH-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRDOUGH_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRDOUGH-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_SAUCE_ALT = DataResourceData.newBuilder()
        .setDataResourceId("SAUCE-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRSAUCE_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRSAUCE-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_SAUCE_TM_ALT = DataResourceData.newBuilder()
        .setDataResourceId("SAUCE-TM-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRSAUCE_TM_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRSAUCE-TM-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_SAUCE_CM_ALT = DataResourceData.newBuilder()
        .setDataResourceId("SAUCE-CM-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRSAUCE_CM_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRSAUCE-CM-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_SAUCE_TP_ALT = DataResourceData.newBuilder()
        .setDataResourceId("SAUCE-TP-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRSAUCE_TP_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRSAUCE-TP-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_SAUCE_CP_ALT = DataResourceData.newBuilder()
        .setDataResourceId("SAUCE-CP-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRSAUCE_CP_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRSAUCE-CP-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_PEPPERS_ALT = DataResourceData.newBuilder()
        .setDataResourceId("PEPPERS-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRPEPPERS_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRPEPPERS-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_PEPPERS_H_ALT = DataResourceData.newBuilder()
        .setDataResourceId("PEPPERS-H-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRPEPPERS_H_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRPEPPERS-H-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_PEPPERS_G_ALT = DataResourceData.newBuilder()
        .setDataResourceId("PEPPERS-G-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRPEPPERS_G_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRPEPPERS-G-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_PEPPERS_R_ALT = DataResourceData.newBuilder()
        .setDataResourceId("PEPPERS-R-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRPEPPERS_R_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRPEPPERS-R-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static ProductCategoryRollupData ProductCategoryRollup_PC_100_CATALOG1_ = ProductCategoryRollupData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setParentProductCategoryId("CATALOG1")
        .setProductCategoryId("PC-100")
        .build();


    public final static ProductCategoryRollupData ProductCategoryRollup_FOOD_001_CATALOG1_ = ProductCategoryRollupData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setParentProductCategoryId("CATALOG1")
        .setProductCategoryId("FOOD-001")
        .build();


    public final static ProductContentData ProductContent_PC001_PC001_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("PC001-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("PC001")
        .build();


    public final static ProductContentData ProductContent_RAM1GB_BRAND_RAM1GB_BRAND_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("RAM1GB_BRAND-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("RAM1GB_BRAND")
        .build();


    public final static ProductContentData ProductContent_HD250GB_BRAND_HD250GB_BRAND_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("HD250GB_BRAND-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("HD250GB_BRAND")
        .build();


    public final static ProductContentData ProductContent_HD500GB_BRAND_HD500GB_BRAND_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("HD500GB_BRAND-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("HD500GB_BRAND")
        .build();


    public final static ProductContentData ProductContent_ETH_BRAND_ETH_BRAND_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("ETH_BRAND-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("ETH_BRAND")
        .build();


    public final static ProductContentData ProductContent_MOD_BRAND_MOD_BRAND_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("MOD_BRAND-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("MOD_BRAND")
        .build();


    public final static ProductContentData ProductContent_MOTHER_BOARD_ASS_MOTHER_BOARD_ASS_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("MOTHER_BOARD_ASS-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("MOTHER_BOARD_ASS")
        .build();


    public final static ProductContentData ProductContent_MOTHER_BOARD_MOTHER_BOARD_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("MOTHER_BOARD-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("MOTHER_BOARD")
        .build();


    public final static ProductContentData ProductContent_CPU_586_CPU_586_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("CPU-586-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("CPU-586")
        .build();


    public final static ProductContentData ProductContent_ENCHILADAS_ENCHILADAS_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("ENCHILADAS-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("ENCHILADAS")
        .build();


    public final static ProductContentData ProductContent_FAJITA_BEEF_FAJITA_BEEF_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("FAJITA_BEEF-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("FAJITA_BEEF")
        .build();


    public final static ProductContentData ProductContent_JALAPENOS_JALAPENOS_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("JALAPENOS-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("JALAPENOS")
        .build();


    public final static ProductContentData ProductContent_PIZZA_PIZZA_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("PIZZA-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("PIZZA")
        .build();


    public final static ProductContentData ProductContent_DOUGH_DOUGH_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("DOUGH-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("DOUGH")
        .build();


    public final static ProductContentData ProductContent_SAUCE_SAUCE_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("SAUCE-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("SAUCE")
        .build();


    public final static ProductContentData ProductContent_SAUCE_TM_SAUCE_TM_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("SAUCE-TM-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("SAUCE-TM")
        .build();


    public final static ProductContentData ProductContent_SAUCE_CM_SAUCE_CM_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("SAUCE-CM-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("SAUCE-CM")
        .build();


    public final static ProductContentData ProductContent_SAUCE_TP_SAUCE_TP_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("SAUCE-TP-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("SAUCE-TP")
        .build();


    public final static ProductContentData ProductContent_SAUCE_CP_SAUCE_CP_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("SAUCE-CP-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("SAUCE-CP")
        .build();


    public final static ProductContentData ProductContent_PEPPERS_PEPPERS_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("PEPPERS-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("PEPPERS")
        .build();


    public final static ProductContentData ProductContent_PEPPERS_G_PEPPERS_G_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("PEPPERS-G-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("PEPPERS-G")
        .build();


    public final static ProductContentData ProductContent_PEPPERS_H_PEPPERS_H_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("PEPPERS-H-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("PEPPERS-H")
        .build();


    public final static ProductContentData ProductContent_PEPPERS_R_PEPPERS_R_ALT_ALTERNATIVE_URL_ = ProductContentData.newBuilder()
        .setContentId("PEPPERS-R-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .setProductId("PEPPERS-R")
        .build();


    public final static ProductConfigOptionData ProductConfigOption_IT0000_OP000 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("IT0000")
        .setConfigOptionId("OP000")
        .setConfigOptionName("OPT001")
        .setDescription("1GB Dual Channel DDR2 SDRAM at 667MHz")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_IT0000_OP001 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("IT0000")
        .setConfigOptionId("OP001")
        .setConfigOptionName("OPT002")
        .setDescription("2GB Dual Channel DDR2 SDRAM at 667MHz")
        .setSequenceNum(20)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_IT0001_OP002 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("IT0001")
        .setConfigOptionId("OP002")
        .setConfigOptionName("OPT001")
        .setDescription("HD 250 GB")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_IT0001_OP003 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("IT0001")
        .setConfigOptionId("OP003")
        .setConfigOptionName("OPT002")
        .setDescription("HD 500 GB")
        .setSequenceNum(20)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_IT0002_OP004 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("IT0002")
        .setConfigOptionId("OP004")
        .setConfigOptionName("OPT001")
        .setDescription("Ethernet Card")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_IT0002_OP005 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("IT0002")
        .setConfigOptionId("OP005")
        .setConfigOptionName("OPT002")
        .setDescription("Modem 56k")
        .setSequenceNum(20)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_IT0003_OP006 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("IT0003")
        .setConfigOptionId("OP006")
        .setConfigOptionName("OPT001")
        .setDescription("Motherboard with BOM")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_TEXMEX0000_OP010 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("TEXMEX0000")
        .setConfigOptionId("OP010")
        .setConfigOptionName("OPT001")
        .setDescription("Cheese enchiladas")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_TEXMEX0000_OP011 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("TEXMEX0000")
        .setConfigOptionId("OP011")
        .setConfigOptionName("OPT002")
        .setDescription("Fajita beef")
        .setSequenceNum(20)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_TEXMEX0001_OP012 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("TEXMEX0001")
        .setConfigOptionId("OP012")
        .setConfigOptionName("OPT001")
        .setDescription("Jalapenos")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_PZ0000_PZOP000 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("PZ0000")
        .setConfigOptionId("PZOP000")
        .setConfigOptionName("PZOPT001")
        .setDescription("Small Pizza")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_PZ0000_PZOP001 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("PZ0000")
        .setConfigOptionId("PZOP001")
        .setConfigOptionName("PZOPT002")
        .setDescription("Large Pizza")
        .setSequenceNum(20)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_PZ0001_PZOP003 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("PZ0001")
        .setConfigOptionId("PZOP003")
        .setConfigOptionName("PZOPT002")
        .setDescription("Peppers")
        .setSequenceNum(10)
        .build();


    public final static ProductConfigOptionData ProductConfigOption_PZ0001_PZOP002 = ProductConfigOptionData.newBuilder()
        .setConfigItemId("PZ0001")
        .setConfigOptionId("PZOP002")
        .setConfigOptionName("PZOPT001")
        .setDescription("Sauce")
        .setSequenceNum(20)
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_PROMOTIONS_PC001_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("PROMOTIONS")
        .setProductId("PC001")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_PC_100_PC001_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("PC-100")
        .setProductId("PC001")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_CATALOG1_SEARCH_PC001_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductCategoryId("CATALOG1_SEARCH")
        .setProductId("PC001")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_PROMOTIONS_ENCHILADAS_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setProductCategoryId("PROMOTIONS")
        .setProductId("ENCHILADAS")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_FOOD_001_ENCHILADAS_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setProductCategoryId("FOOD-001")
        .setProductId("ENCHILADAS")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_CATALOG1_SEARCH_ENCHILADAS_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setProductCategoryId("CATALOG1_SEARCH")
        .setProductId("ENCHILADAS")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_FOOD_001_PIZZA_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:47.338"))
        .setProductCategoryId("FOOD-001")
        .setProductId("PIZZA")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_CATALOG1_SEARCH_PIZZA_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:47.338"))
        .setProductCategoryId("CATALOG1_SEARCH")
        .setProductId("PIZZA")
        .build();


    public final static ProductCategoryMemberData ProductCategoryMember_PROMOTIONS_PIZZA_ = ProductCategoryMemberData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:47.338"))
        .setProductCategoryId("PROMOTIONS")
        .setProductId("PIZZA")
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_3001_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:07.796"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("3001")
        .setProductId("SAUCE")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_3002_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:26.411"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("3002")
        .setProductId("SAUCE")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_3003_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:07.796"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("3003")
        .setProductId("SAUCE")
        .setSequenceNum(3)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_3004_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:26.411"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("3004")
        .setProductId("SAUCE")
        .setSequenceNum(4)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_PEPPERS_3010_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:07.796"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("3010")
        .setProductId("PEPPERS")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_PEPPERS_3011_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:26.411"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("3011")
        .setProductId("PEPPERS")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_PEPPERS_3012_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:50:07.796"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .setProductFeatureId("3012")
        .setProductId("PEPPERS")
        .setSequenceNum(3)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_TM_3001_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3001")
        .setProductId("SAUCE-TM")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_TM_3003_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3003")
        .setProductId("SAUCE-TM")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_CM_3002_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3002")
        .setProductId("SAUCE-CM")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_CM_3003_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3003")
        .setProductId("SAUCE-CM")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_TP_3001_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3001")
        .setProductId("SAUCE-TP")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_TP_3004_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3004")
        .setProductId("SAUCE-TP")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_CP_3002_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3002")
        .setProductId("SAUCE-CP")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_SAUCE_CP_3004_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3004")
        .setProductId("SAUCE-CP")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_PEPPERS_G_3010_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3010")
        .setProductId("PEPPERS-G")
        .setSequenceNum(1)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_PEPPERS_H_3011_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3011")
        .setProductId("PEPPERS-H")
        .setSequenceNum(2)
        .build();


    public final static ProductFeatureApplData ProductFeatureAppl_PEPPERS_R_3012_ = ProductFeatureApplData.newBuilder()
        .setFromDate(getTimestamp("2003-11-20 13:51:53.35"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .setProductFeatureId("3012")
        .setProductId("PEPPERS-R")
        .setSequenceNum(3)
        .build();


    public final static WorkEffortData WorkEffort_TASK01 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Components")
        .setEstimatedMilliSeconds(600000)
        .setEstimatedSetupMillis(0)
        .setFixedAssetId("DEMO_MACHINE_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("TASK01")
        .setWorkEffortName("Stock out")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_TASK02 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Assembly")
        .setEstimatedMilliSeconds(900000)
        .setEstimatedSetupMillis(0)
        .setFixedAssetId("DEMO_MACHINE_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("TASK02")
        .setWorkEffortName("Assembly")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_TASK03 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Test")
        .setEstimatedMilliSeconds(450000)
        .setEstimatedSetupMillis(20000)
        .setFixedAssetId("DEMO_MACHINE_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("TASK03")
        .setWorkEffortName("Test")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_ROUT01 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("PC Assembly")
        .setQuantityToProduce(getFixedPoint("0"))
        .setRevisionNumber(1)
        .setWorkEffortId("ROUT01")
        .setWorkEffortName("PC assembly")
        .setWorkEffortTypeId("ROUTING")
        .build();


    public final static WorkEffortData WorkEffort_TASK11 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Components")
        .setEstimatedMilliSeconds(600000)
        .setEstimatedSetupMillis(0)
        .setFixedAssetId("DEMO_FOOD_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("TASK11")
        .setWorkEffortName("Stock out")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_TASK12 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Assembly")
        .setEstimatedMilliSeconds(900000)
        .setEstimatedSetupMillis(0)
        .setFixedAssetId("DEMO_FOOD_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("TASK12")
        .setWorkEffortName("Assembly")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_TASK13 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Test")
        .setEstimatedMilliSeconds(450000)
        .setEstimatedSetupMillis(20000)
        .setFixedAssetId("DEMO_FOOD_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("TASK13")
        .setWorkEffortName("Test")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_ROUT11 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Food delivery")
        .setQuantityToProduce(getFixedPoint("0"))
        .setRevisionNumber(1)
        .setWorkEffortId("ROUT11")
        .setWorkEffortName("Food delivery")
        .setWorkEffortTypeId("ROUTING")
        .build();


    public final static WorkEffortData WorkEffort_PZTASK01 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Components")
        .setEstimatedMilliSeconds(600000)
        .setEstimatedSetupMillis(0)
        .setFixedAssetId("DEMO_FOOD_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("PZTASK01")
        .setWorkEffortName("Stock out")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_PZTASK02 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Preparation")
        .setEstimatedMilliSeconds(900000)
        .setEstimatedSetupMillis(0)
        .setFixedAssetId("DEMO_FOOD_GROUP")
        .setRevisionNumber(1)
        .setWorkEffortId("PZTASK02")
        .setWorkEffortName("Preparation")
        .setWorkEffortPurposeTypeId("ROU_ASSEMBLING")
        .setWorkEffortTypeId("ROU_TASK")
        .build();


    public final static WorkEffortData WorkEffort_PZROUT01 = WorkEffortData.newBuilder()
        .setCurrentStatusId("ROU_ACTIVE")
        .setDescription("Pizza preparation")
        .setQuantityToProduce(getFixedPoint("0"))
        .setRevisionNumber(1)
        .setWorkEffortId("PZROUT01")
        .setWorkEffortName("Pizza preparation")
        .setWorkEffortTypeId("ROUTING")
        .build();


    public final static ContentData Content_PC_100_ALT = ContentData.newBuilder()
        .setContentId("PC-100-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("PC-100-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CPC_100_ALTEN = ContentData.newBuilder()
        .setContentId("CPC-100-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRPC-100-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_FOOD_001_ALT = ContentData.newBuilder()
        .setContentId("FOOD-001-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("FOOD-001-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CFOOD_001_ALTEN = ContentData.newBuilder()
        .setContentId("CFOOD-001-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRFOOD-001-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_PC001_ALT = ContentData.newBuilder()
        .setContentId("PC001-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("PC001-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CPC001_ALTEN = ContentData.newBuilder()
        .setContentId("CPC001-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRPC001-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_RAM1GB_BRAND_ALT = ContentData.newBuilder()
        .setContentId("RAM1GB_BRAND-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("RAM1GB_BRAND-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CRAM1GB_BRAND_ALTEN = ContentData.newBuilder()
        .setContentId("CRAM1GB_BRAND-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRRAM1GB_BRAND-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_HD250GB_BRAND_ALT = ContentData.newBuilder()
        .setContentId("HD250GB_BRAND-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("HD250GB_BRAND-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CHD250GB_BRAND_ALTEN = ContentData.newBuilder()
        .setContentId("CHD250GB_BRAND-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRHD250GB_BRAND-ALT")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_HD500GB_BRAND_ALT = ContentData.newBuilder()
        .setContentId("HD500GB_BRAND-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("HD500GB_BRAND-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CHD500GB_BRAND_ALTEN = ContentData.newBuilder()
        .setContentId("CHD500GB_BRAND-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRHD500GB_BRAND-ALT")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_ETH_BRAND_ALT = ContentData.newBuilder()
        .setContentId("ETH_BRAND-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("ETH_BRAND-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CETH_BRAND_ALTEN = ContentData.newBuilder()
        .setContentId("CETH_BRAND-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRETH_BRAND-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_MOD_BRAND_ALT = ContentData.newBuilder()
        .setContentId("MOD_BRAND-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("MOD_BRAND-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CMOD_BRAND_ALTEN = ContentData.newBuilder()
        .setContentId("CMOD_BRAND-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRMOD_BRAND-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_MOTHER_BOARD_ASS_ALT = ContentData.newBuilder()
        .setContentId("MOTHER_BOARD_ASS-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("MOTHER_BOARD_ASS-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CMOTHER_BOARD_ASS = ContentData.newBuilder()
        .setContentId("CMOTHER_BOARD_ASS")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DMOTHER_BOARD_ASS")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_MOTHER_BOARD_ALT = ContentData.newBuilder()
        .setContentId("MOTHER_BOARD-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("MOTHER_BOARD-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CMOTHER_BOARD_ALTEN = ContentData.newBuilder()
        .setContentId("CMOTHER_BOARD-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRMOTHER_BOARD-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_CPU_586_ALT = ContentData.newBuilder()
        .setContentId("CPU-586-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("CPU-586-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CCPU_586_ALTEN = ContentData.newBuilder()
        .setContentId("CCPU-586-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRCPU-586-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_ENCHILADAS_ALT = ContentData.newBuilder()
        .setContentId("ENCHILADAS-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("ENCHILADAS-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CENCHILADAS_ALTEN = ContentData.newBuilder()
        .setContentId("CENCHILADAS-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRENCHILADAS-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_FAJITA_BEEF_ALT = ContentData.newBuilder()
        .setContentId("FAJITA_BEEF-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("FAJITA_BEEF-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CFAJITA_BEEF_ALTEN = ContentData.newBuilder()
        .setContentId("CFAJITA_BEEF-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRFAJITA_BEEF-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_JALAPENOS_ALT = ContentData.newBuilder()
        .setContentId("JALAPENOS-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("JALAPENOS-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CJALAPENOS_ALTEN = ContentData.newBuilder()
        .setContentId("CJALAPENOS-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRJALAPENOS-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_PIZZA_ALT = ContentData.newBuilder()
        .setContentId("PIZZA-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("PIZZA-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CPIZZA_ALTEN = ContentData.newBuilder()
        .setContentId("CPIZZA-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRPIZZA-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_DOUGH_ALT = ContentData.newBuilder()
        .setContentId("DOUGH-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DOUGH-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CDOUGH_ALTEN = ContentData.newBuilder()
        .setContentId("CDOUGH-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRDOUGH-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_SAUCE_ALT = ContentData.newBuilder()
        .setContentId("SAUCE-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("SAUCE-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CSAUCE_ALTEN = ContentData.newBuilder()
        .setContentId("CSAUCE-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRSAUCE-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_SAUCE_TM_ALT = ContentData.newBuilder()
        .setContentId("SAUCE-TM-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("SAUCE-TM-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CSAUCE_TM_ALTEN = ContentData.newBuilder()
        .setContentId("CSAUCE-TM-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRSAUCE-TM-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_SAUCE_CM_ALT = ContentData.newBuilder()
        .setContentId("SAUCE-CM-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("SAUCE-CM-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CSAUCE_CM_ALTEN = ContentData.newBuilder()
        .setContentId("CSAUCE-CM-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRSAUCE-CM-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_SAUCE_TP_ALT = ContentData.newBuilder()
        .setContentId("SAUCE-TP-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("SAUCE-TP-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CSAUCE_TP_ALTEN = ContentData.newBuilder()
        .setContentId("CSAUCE-TP-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRSAUCE-TP-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_SAUCE_CP_ALT = ContentData.newBuilder()
        .setContentId("SAUCE-CP-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("SAUCE-CP-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CSAUCE_CP_ALTEN = ContentData.newBuilder()
        .setContentId("CSAUCE-CP-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRSAUCE-CP-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_PEPPERS_ALT = ContentData.newBuilder()
        .setContentId("PEPPERS-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("PEPPERS-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CPEPPERS_ALTEN = ContentData.newBuilder()
        .setContentId("CPEPPERS-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRPEPPERS-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_PEPPERS_G_ALT = ContentData.newBuilder()
        .setContentId("PEPPERS-G-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("PEPPERS-G-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CPEPPERS_G_ALTEN = ContentData.newBuilder()
        .setContentId("CPEPPERS-G-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRPEPPERS-G-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_PEPPERS_H_ALT = ContentData.newBuilder()
        .setContentId("PEPPERS-H-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("PEPPERS-H-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CPEPPERS_H_ALTEN = ContentData.newBuilder()
        .setContentId("CPEPPERS-H-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRPEPPERS-H-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_PEPPERS_R_ALT = ContentData.newBuilder()
        .setContentId("PEPPERS-R-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("PEPPERS-R-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CPEPPERS_R_ALTEN = ContentData.newBuilder()
        .setContentId("CPEPPERS-R-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRPEPPERS-R-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ProductFeatureCategoryData ProductFeatureCategory_3000 = ProductFeatureCategoryData.newBuilder()
        .setDescription("Taste")
        .setProductFeatureCategoryId("3000")
        .build();


    public final static ProductCategoryFlatData ProductCategory_PC_100 = ProductCategoryFlatData.newBuilder()
        .setProductCategoryId("PC-100")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_FOOD_001 = ProductCategoryFlatData.newBuilder()
        .setProductCategoryId("FOOD-001")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryContentData ProductCategoryContent_PC_100_PC_100_ALT_ALTERNATIVE_URL_ = ProductCategoryContentData.newBuilder()
        .setContentId("PC-100-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatContentTypeId("ALTERNATIVE_URL")
        .setProductCategoryId("PC-100")
        .build();


    public final static ProductCategoryContentData ProductCategoryContent_FOOD_001_FOOD_001_ALT_ALTERNATIVE_URL_ = ProductCategoryContentData.newBuilder()
        .setContentId("FOOD-001-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatContentTypeId("ALTERNATIVE_URL")
        .setProductCategoryId("FOOD-001")
        .build();


    public final static ProductAssocData ProductAssoc_MOTHER_BOARD_ASS_MOTHER_BOARD_MANUF_COMPONENT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2007-01-01 12:00:00.0"))
        .setProductAssocTypeId("MANUF_COMPONENT")
        .setProductId("MOTHER_BOARD_ASS")
        .setProductIdTo("MOTHER_BOARD")
        .setQuantity(getFixedPoint("1.000000"))
        .build();


    public final static ProductAssocData ProductAssoc_MOTHER_BOARD_ASS_CPU_586_MANUF_COMPONENT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2007-01-01 12:00:00.0"))
        .setProductAssocTypeId("MANUF_COMPONENT")
        .setProductId("MOTHER_BOARD_ASS")
        .setProductIdTo("CPU-586")
        .setQuantity(getFixedPoint("1.000000"))
        .build();


    public final static ProductAssocData ProductAssoc_PEPPERS_PEPPERS_G_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("PEPPERS")
        .setProductIdTo("PEPPERS-G")
        .build();


    public final static ProductAssocData ProductAssoc_PEPPERS_PEPPERS_H_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("PEPPERS")
        .setProductIdTo("PEPPERS-H")
        .build();


    public final static ProductAssocData ProductAssoc_PEPPERS_PEPPERS_R_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("PEPPERS")
        .setProductIdTo("PEPPERS-R")
        .build();


    public final static ProductAssocData ProductAssoc_SAUCE_SAUCE_TM_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("SAUCE")
        .setProductIdTo("SAUCE-TM")
        .build();


    public final static ProductAssocData ProductAssoc_SAUCE_SAUCE_CM_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("SAUCE")
        .setProductIdTo("SAUCE-CM")
        .build();


    public final static ProductAssocData ProductAssoc_SAUCE_SAUCE_TP_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("SAUCE")
        .setProductIdTo("SAUCE-TP")
        .build();


    public final static ProductAssocData ProductAssoc_SAUCE_SAUCE_CP_PRODUCT_VARIANT_ = ProductAssocData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .setProductId("SAUCE")
        .setProductIdTo("SAUCE-CP")
        .build();


    public final static WorkEffortGoodStandardData WorkEffortGoodStandard_ROUT01_PC001_ROU_PROD_TEMPLATE_ = WorkEffortGoodStandardData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:10:14.227"))
        .setProductId("PC001")
        .setStatusId("WEGS_CREATED")
        .setWorkEffortGoodStdTypeId("ROU_PROD_TEMPLATE")
        .setWorkEffortId("ROUT01")
        .build();


    public final static WorkEffortGoodStandardData WorkEffortGoodStandard_ROUT11_ENCHILADAS_ROU_PROD_TEMPLATE_ = WorkEffortGoodStandardData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setProductId("ENCHILADAS")
        .setStatusId("WEGS_CREATED")
        .setWorkEffortGoodStdTypeId("ROU_PROD_TEMPLATE")
        .setWorkEffortId("ROUT11")
        .build();


    public final static WorkEffortGoodStandardData WorkEffortGoodStandard_PZROUT01_PIZZA_ROU_PROD_TEMPLATE_ = WorkEffortGoodStandardData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:10:14.227"))
        .setProductId("PIZZA")
        .setStatusId("WEGS_CREATED")
        .setWorkEffortGoodStdTypeId("ROU_PROD_TEMPLATE")
        .setWorkEffortId("PZROUT01")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_ROUT01_TASK01_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:38.736"))
        .setSequenceNum(10)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("ROUT01")
        .setWorkEffortIdTo("TASK01")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_ROUT01_TASK02_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:47.338"))
        .setSequenceNum(20)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("ROUT01")
        .setWorkEffortIdTo("TASK02")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_ROUT01_TASK03_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:55.279"))
        .setSequenceNum(30)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("ROUT01")
        .setWorkEffortIdTo("TASK03")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_ROUT11_TASK11_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setSequenceNum(10)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("ROUT11")
        .setWorkEffortIdTo("TASK11")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_ROUT11_TASK12_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setSequenceNum(20)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("ROUT11")
        .setWorkEffortIdTo("TASK12")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_ROUT11_TASK13_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2007-12-27 12:00:00.0"))
        .setSequenceNum(30)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("ROUT11")
        .setWorkEffortIdTo("TASK13")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_PZROUT01_PZTASK01_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:38.736"))
        .setSequenceNum(10)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("PZROUT01")
        .setWorkEffortIdTo("PZTASK01")
        .build();


    public final static WorkEffortAssocData WorkEffortAssoc_PZROUT01_PZTASK02_ROUTING_COMPONENT_ = WorkEffortAssocData.newBuilder()
        .setFromDate(getTimestamp("2004-09-24 15:09:47.338"))
        .setSequenceNum(20)
        .setWorkEffortAssocTypeId("ROUTING_COMPONENT")
        .setWorkEffortIdFrom("PZROUT01")
        .setWorkEffortIdTo("PZTASK02")
        .build();

}
