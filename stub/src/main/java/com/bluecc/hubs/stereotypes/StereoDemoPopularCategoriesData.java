package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;
import com.bluecc.hubs.stub.ProductCategoryMemberFlatData;
import com.bluecc.hubs.stub.ProdCatalogCategoryFlatData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductCategoryContentData;

public final class StereoDemoPopularCategoriesData {
    public final static ElectronicTextData ElectronicText_BEST_SELL_1_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("BEST-SELL-1-ALT")
        .setTextData("best-sell-1")
        .build();


    public final static ElectronicTextData ElectronicText_BEST_SELL_2_ALT = ElectronicTextData.newBuilder()
        .setDataResourceId("BEST-SELL-2-ALT")
        .setTextData("best-sell-2")
        .build();


    public final static ElectronicTextData ElectronicText_DRBEST_SELL_1_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRBEST-SELL-1-ALTEN")
        .setTextData("best-sell-1")
        .build();


    public final static ElectronicTextData ElectronicText_DRBEST_SELL_2_ALTEN = ElectronicTextData.newBuilder()
        .setDataResourceId("DRBEST-SELL-2-ALTEN")
        .setTextData("best-sell-2")
        .build();


    public final static ContentAssocData ContentAssoc_BEST_SELL_1_ALT_CBEST_SELL_1_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("BEST-SELL-1-ALT")
        .setContentIdTo("CBEST-SELL-1-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static ContentAssocData ContentAssoc_BEST_SELL_2_ALT_CBEST_SELL_2_ALTEN_ALTERNATE_LOCALE_ = ContentAssocData.newBuilder()
        .setContentAssocTypeId("ALTERNATE_LOCALE")
        .setContentId("BEST-SELL-2-ALT")
        .setContentIdTo("CBEST-SELL-2-ALTEN")
        .setFromDate(getTimestamp("2011-04-26 12:00:00.0"))
        .build();


    public final static DataResourceData DataResource_BEST_SELL_1_ALT = DataResourceData.newBuilder()
        .setDataResourceId("BEST-SELL-1-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRBEST_SELL_1_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRBEST-SELL-1-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static DataResourceData DataResource_BEST_SELL_2_ALT = DataResourceData.newBuilder()
        .setDataResourceId("BEST-SELL-2-ALT")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en")
        .build();


    public final static DataResourceData DataResource_DRBEST_SELL_2_ALTEN = DataResourceData.newBuilder()
        .setDataResourceId("DRBEST-SELL-2-ALTEN")
        .setDataResourceTypeId("ELECTRONIC_TEXT")
        .setLocaleString("en_US")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_BEST_SELL_1_CATALOG1_BEST_SELL_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setParentProductCategoryId("CATALOG1_BEST_SELL")
        .setProductCategoryId("BEST-SELL-1")
        .setSequenceNum(1)
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_BEST_SELL_2_CATALOG1_BEST_SELL_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setParentProductCategoryId("CATALOG1_BEST_SELL")
        .setProductCategoryId("BEST-SELL-2")
        .setSequenceNum(2)
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_101_BEST_SELL_1_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setParentProductCategoryId("BEST-SELL-1")
        .setProductCategoryId("101")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_102_BEST_SELL_1_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setParentProductCategoryId("BEST-SELL-1")
        .setProductCategoryId("102")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_202_BEST_SELL_2_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setParentProductCategoryId("BEST-SELL-2")
        .setProductCategoryId("202")
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_1_GZ_1000_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-1")
        .setProductId("GZ-1000")
        .setQuantity(getFixedPoint("10"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_1_GZ_1001_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-1")
        .setProductId("GZ-1001")
        .setQuantity(getFixedPoint("8"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_1_GZ_1004_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-1")
        .setProductId("GZ-1004")
        .setQuantity(getFixedPoint("6"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_1_GZ_1005_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-1")
        .setProductId("GZ-1005")
        .setQuantity(getFixedPoint("4"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_1_GZ_1006_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-1")
        .setProductId("GZ-1006")
        .setQuantity(getFixedPoint("2"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_2_WG_9943_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-2")
        .setProductId("WG-9943")
        .setQuantity(getFixedPoint("3"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_2_WG_9944_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-2")
        .setProductId("WG-9944")
        .setQuantity(getFixedPoint("5"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_2_WG_1111_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-2")
        .setProductId("WG-1111")
        .setQuantity(getFixedPoint("7"))
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_BEST_SELL_2_WG_5569_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProductCategoryId("BEST-SELL-2")
        .setProductId("WG-5569")
        .setQuantity(getFixedPoint("1"))
        .build();


    public final static ProdCatalogCategoryFlatData ProdCatalogCategory_DemoCatalog_CATALOG1_BEST_SELL_PCCT_BEST_SELL_ = ProdCatalogCategoryFlatData.newBuilder()
        .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
        .setProdCatalogCategoryTypeId("PCCT_BEST_SELL")
        .setProdCatalogId("DemoCatalog")
        .setProductCategoryId("CATALOG1_BEST_SELL")
        .setSequenceNum(1)
        .build();


    public final static ContentData Content_BEST_SELL_1_ALT = ContentData.newBuilder()
        .setContentId("BEST-SELL-1-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("BEST-SELL-1-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CBEST_SELL_1_ALTEN = ContentData.newBuilder()
        .setContentId("CBEST-SELL-1-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRBEST-SELL-2-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ContentData Content_BEST_SELL_2_ALT = ContentData.newBuilder()
        .setContentId("BEST-SELL-2-ALT")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("BEST-SELL-2-ALT")
        .setLocaleString("en")
        .build();


    public final static ContentData Content_CBEST_SELL_2_ALTEN = ContentData.newBuilder()
        .setContentId("CBEST-SELL-2-ALTEN")
        .setContentTypeId("DOCUMENT")
        .setDataResourceId("DRBEST-SELL-2-ALTEN")
        .setLocaleString("en_US")
        .build();


    public final static ProductCategoryFlatData ProductCategory_CATALOG1_BEST_SELL = ProductCategoryFlatData.newBuilder()
        .setCategoryName("Demo Best Selling")
        .setProductCategoryId("CATALOG1_BEST_SELL")
        .setProductCategoryTypeId("BEST_SELL_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_BEST_SELL_1 = ProductCategoryFlatData.newBuilder()
        .setCategoryName("Gizmos")
        .setProductCategoryId("BEST-SELL-1")
        .setProductCategoryTypeId("BEST_SELL_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_BEST_SELL_2 = ProductCategoryFlatData.newBuilder()
        .setCategoryName("Widgets")
        .setProductCategoryId("BEST-SELL-2")
        .setProductCategoryTypeId("BEST_SELL_CATEGORY")
        .build();


    public final static ProductCategoryContentData ProductCategoryContent_BEST_SELL_1_BEST_SELL_1_ALT_ALTERNATIVE_URL_ = ProductCategoryContentData.newBuilder()
        .setContentId("BEST-SELL-1-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatContentTypeId("ALTERNATIVE_URL")
        .setProductCategoryId("BEST-SELL-1")
        .build();


    public final static ProductCategoryContentData ProductCategoryContent_BEST_SELL_2_BEST_SELL_2_ALT_ALTERNATIVE_URL_ = ProductCategoryContentData.newBuilder()
        .setContentId("BEST-SELL-2-ALT")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatContentTypeId("ALTERNATIVE_URL")
        .setProductCategoryId("BEST-SELL-2")
        .build();

}
