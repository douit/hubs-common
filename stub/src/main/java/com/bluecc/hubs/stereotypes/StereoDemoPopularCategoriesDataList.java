package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoDemoPopularCategoriesData.*;import com.bluecc.hubs.stub.ElectronicTextData;
import com.bluecc.hubs.stub.ContentAssocData;
import com.bluecc.hubs.stub.DataResourceData;
import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.hubs.stub.ProductCategoryMemberData;
import com.bluecc.hubs.stub.ProdCatalogCategoryData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductCategoryContentData;

public final class StereoDemoPopularCategoriesDataList {
    public static final List<ElectronicTextData> electronicTextList=ImmutableList.of(        
            ElectronicText_BEST_SELL_1_ALT,        
            ElectronicText_BEST_SELL_2_ALT,        
            ElectronicText_DRBEST_SELL_1_ALTEN,        
            ElectronicText_DRBEST_SELL_2_ALTEN);

    public static final List<ContentAssocData> contentAssocList=ImmutableList.of(        
            ContentAssoc_BEST_SELL_1_ALT_CBEST_SELL_1_ALTEN_ALTERNATE_LOCALE_,        
            ContentAssoc_BEST_SELL_2_ALT_CBEST_SELL_2_ALTEN_ALTERNATE_LOCALE_);

    public static final List<DataResourceData> dataResourceList=ImmutableList.of(        
            DataResource_BEST_SELL_1_ALT,        
            DataResource_DRBEST_SELL_1_ALTEN,        
            DataResource_BEST_SELL_2_ALT,        
            DataResource_DRBEST_SELL_2_ALTEN);

    public static final List<ProductCategoryRollupData> productCategoryRollupList=ImmutableList.of(        
            ProductCategoryRollup_BEST_SELL_1_CATALOG1_BEST_SELL_,        
            ProductCategoryRollup_BEST_SELL_2_CATALOG1_BEST_SELL_,        
            ProductCategoryRollup_101_BEST_SELL_1_,        
            ProductCategoryRollup_102_BEST_SELL_1_,        
            ProductCategoryRollup_202_BEST_SELL_2_);

    public static final List<ProductCategoryMemberData> productCategoryMemberList=ImmutableList.of(        
            ProductCategoryMember_BEST_SELL_1_GZ_1000_,        
            ProductCategoryMember_BEST_SELL_1_GZ_1001_,        
            ProductCategoryMember_BEST_SELL_1_GZ_1004_,        
            ProductCategoryMember_BEST_SELL_1_GZ_1005_,        
            ProductCategoryMember_BEST_SELL_1_GZ_1006_,        
            ProductCategoryMember_BEST_SELL_2_WG_9943_,        
            ProductCategoryMember_BEST_SELL_2_WG_9944_,        
            ProductCategoryMember_BEST_SELL_2_WG_1111_,        
            ProductCategoryMember_BEST_SELL_2_WG_5569_);

    public static final List<ProdCatalogCategoryData> prodCatalogCategoryList=ImmutableList.of(        
            ProdCatalogCategory_DemoCatalog_CATALOG1_BEST_SELL_PCCT_BEST_SELL_);

    public static final List<ContentData> contentList=ImmutableList.of(        
            Content_BEST_SELL_1_ALT,        
            Content_CBEST_SELL_1_ALTEN,        
            Content_BEST_SELL_2_ALT,        
            Content_CBEST_SELL_2_ALTEN);

    public static final List<ProductCategoryFlatData> productCategoryList=ImmutableList.of(        
            ProductCategory_CATALOG1_BEST_SELL,        
            ProductCategory_BEST_SELL_1,        
            ProductCategory_BEST_SELL_2);

    public static final List<ProductCategoryContentData> productCategoryContentList=ImmutableList.of(        
            ProductCategoryContent_BEST_SELL_1_BEST_SELL_1_ALT_ALTERNATIVE_URL_,        
            ProductCategoryContent_BEST_SELL_2_BEST_SELL_2_ALT_ALTERNATIVE_URL_);

}
