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

import com.bluecc.hubs.stub.ProductCategoryFlatData;

import com.bluecc.hubs.stub.ProductCategoryData;
import com.bluecc.income.dao.ProductCategoryDelegator;
import static com.bluecc.income.dao.ProductCategoryDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryData.class,
        symbol = EntityNames.ProductCategory)
public class ProductCategory implements IEventModel<ProductCategoryFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_category_id")
	@RId 
    String productCategoryId;
    @SerializedName("product_category_type_id") 
    String productCategoryTypeId;
    @SerializedName("primary_parent_category_id") 
    String primaryParentCategoryId;
    @SerializedName("category_name") 
    String categoryName;
    @SerializedName("description") 
    String description;
    @SerializedName("long_description") 
    String longDescription;
    @SerializedName("category_image_url") 
    String categoryImageUrl;
    @SerializedName("link_one_image_url") 
    String linkOneImageUrl;
    @SerializedName("link_two_image_url") 
    String linkTwoImageUrl;
    @SerializedName("detail_screen") 
    String detailScreen;
    @SerializedName("show_in_select") 
    Character showInSelect;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return productCategoryId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductCategoryFlatData.Builder toDataBuilder() {
        ProductCategoryFlatData.Builder builder = ProductCategoryFlatData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (productCategoryTypeId != null) {
            builder.setProductCategoryTypeId(productCategoryTypeId);
        }
        if (primaryParentCategoryId != null) {
            builder.setPrimaryParentCategoryId(primaryParentCategoryId);
        }
        if (categoryName != null) {
            builder.setCategoryName(categoryName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (longDescription != null) {
            builder.setLongDescription(longDescription);
        }
        if (categoryImageUrl != null) {
            builder.setCategoryImageUrl(categoryImageUrl);
        }
        if (linkOneImageUrl != null) {
            builder.setLinkOneImageUrl(linkOneImageUrl);
        }
        if (linkTwoImageUrl != null) {
            builder.setLinkTwoImageUrl(linkTwoImageUrl);
        }
        if (detailScreen != null) {
            builder.setDetailScreen(detailScreen);
        }
        if (showInSelect != null) {
            builder.setShowInSelect(getIndicator(showInSelect));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static ProductCategory fromData(ProductCategoryFlatData data) {
        return ProductCategory.builder()
                .productCategoryId(data.getProductCategoryId())
                .productCategoryTypeId(data.getProductCategoryTypeId())
                .primaryParentCategoryId(data.getPrimaryParentCategoryId())
                .categoryName(data.getCategoryName())
                .description(data.getDescription())
                .longDescription(data.getLongDescription())
                .categoryImageUrl(data.getCategoryImageUrl())
                .linkOneImageUrl(data.getLinkOneImageUrl())
                .linkTwoImageUrl(data.getLinkTwoImageUrl())
                .detailScreen(data.getDetailScreen())
                .showInSelect(getIndicatorChar(data.getShowInSelect()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addPrimaryParentProductCategory")
    @SerializedName("primary_parent_product_category") 
    List<ProductCategory> relPrimaryParentProductCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addPrimaryChildProductCategory")
    @SerializedName("primary_child_product_category") 
    List<ProductCategory> relPrimaryChildProductCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addProdCatalogCategory")
    @SerializedName("prod_catalog_category") 
    List<ProdCatalogCategory> relProdCatalogCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addPrimaryProduct")
    @SerializedName("primary_product") 
    List<Product> relPrimaryProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategoryContent")
    @SerializedName("product_category_content") 
    List<ProductCategoryContent> relProductCategoryContent= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategoryLink")
    @SerializedName("product_category_link") 
    List<ProductCategoryLink> relProductCategoryLink= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategoryMember")
    @SerializedName("product_category_member") 
    List<ProductCategoryMember> relProductCategoryMember= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategoryRole")
    @SerializedName("product_category_role") 
    List<ProductCategoryRole> relProductCategoryRole= new ArrayList<>(); 
    @Exclude
    @Singular("addCurrentProductCategoryRollup")
    @SerializedName("current_product_category_rollup") 
    List<ProductCategoryRollup> relCurrentProductCategoryRollup= new ArrayList<>(); 
    @Exclude
    @Singular("addParentProductCategoryRollup")
    @SerializedName("parent_product_category_rollup") 
    List<ProductCategoryRollup> relParentProductCategoryRollup= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFeatureCategoryAppl")
    @SerializedName("product_feature_category_appl") 
    List<ProductFeatureCategoryAppl> relProductFeatureCategoryAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addProductPromoCategory")
    @SerializedName("product_promo_category") 
    List<ProductPromoCategory> relProductPromoCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreSurveyAppl")
    @SerializedName("product_store_survey_appl") 
    List<ProductStoreSurveyAppl> relProductStoreSurveyAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addTaxAuthorityCategory")
    @SerializedName("tax_authority_category") 
    List<TaxAuthorityCategory> relTaxAuthorityCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addTaxAuthorityRateProduct")
    @SerializedName("tax_authority_rate_product") 
    List<TaxAuthorityRateProduct> relTaxAuthorityRateProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PRIMARY_PARENT_PRODUCT_CATEGORY, getter(this, ProductCategory::getRelPrimaryParentProductCategory)); 
        supplierMap.put(PRIMARY_CHILD_PRODUCT_CATEGORY, getter(this, ProductCategory::getRelPrimaryChildProductCategory)); 
        supplierMap.put(PROD_CATALOG_CATEGORY, getter(this, ProductCategory::getRelProdCatalogCategory)); 
        supplierMap.put(PRIMARY_PRODUCT, getter(this, ProductCategory::getRelPrimaryProduct)); 
        supplierMap.put(PRODUCT_CATEGORY_CONTENT, getter(this, ProductCategory::getRelProductCategoryContent)); 
        supplierMap.put(PRODUCT_CATEGORY_LINK, getter(this, ProductCategory::getRelProductCategoryLink)); 
        supplierMap.put(PRODUCT_CATEGORY_MEMBER, getter(this, ProductCategory::getRelProductCategoryMember)); 
        supplierMap.put(PRODUCT_CATEGORY_ROLE, getter(this, ProductCategory::getRelProductCategoryRole)); 
        supplierMap.put(CURRENT_PRODUCT_CATEGORY_ROLLUP, getter(this, ProductCategory::getRelCurrentProductCategoryRollup)); 
        supplierMap.put(PARENT_PRODUCT_CATEGORY_ROLLUP, getter(this, ProductCategory::getRelParentProductCategoryRollup)); 
        supplierMap.put(PRODUCT_FEATURE_CATEGORY_APPL, getter(this, ProductCategory::getRelProductFeatureCategoryAppl)); 
        supplierMap.put(PRODUCT_PROMO_CATEGORY, getter(this, ProductCategory::getRelProductPromoCategory)); 
        supplierMap.put(PRODUCT_STORE_SURVEY_APPL, getter(this, ProductCategory::getRelProductStoreSurveyAppl)); 
        supplierMap.put(TAX_AUTHORITY_CATEGORY, getter(this, ProductCategory::getRelTaxAuthorityCategory)); 
        supplierMap.put(TAX_AUTHORITY_RATE_PRODUCT, getter(this, ProductCategory::getRelTaxAuthorityRateProduct)); 
        supplierMap.put(TENANT, getter(this, ProductCategory::getRelTenant));

        return supplierMap;
    };

    public ProductCategoryDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductCategoryDelegator delegator){
        return delegator.getAgent(ctx, this.getProductCategoryId());
    }

    public ProductCategoryData.Builder toHeadBuilder() {
        ProductCategoryData.Builder builder = ProductCategoryData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (productCategoryTypeId != null) {
            builder.setProductCategoryTypeId(productCategoryTypeId);
        }
        if (categoryName != null) {
            builder.setCategoryName(categoryName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (longDescription != null) {
            builder.setLongDescription(longDescription);
        }
        if (categoryImageUrl != null) {
            builder.setCategoryImageUrl(categoryImageUrl);
        }
        if (linkOneImageUrl != null) {
            builder.setLinkOneImageUrl(linkOneImageUrl);
        }
        if (linkTwoImageUrl != null) {
            builder.setLinkTwoImageUrl(linkTwoImageUrl);
        }
        if (detailScreen != null) {
            builder.setDetailScreen(detailScreen);
        }
        if (showInSelect != null) {
            builder.setShowInSelect(getIndicator(showInSelect));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: productCategoryId

-- fields --
    
    String productCategoryId
    String productCategoryTypeId
    String primaryParentCategoryId
    String categoryName
    String description
    String longDescription
    String categoryImageUrl
    String linkOneImageUrl
    String linkTwoImageUrl
    String detailScreen
    Character showInSelect

-- relations --
    
    - ProductCategoryType (one, autoRelation: false, keymaps: productCategoryTypeId)
    + ProductCategoryTypeAttr (many, autoRelation: false, keymaps: productCategoryTypeId)
    - PrimaryParentProductCategory (one, autoRelation: false, keymaps: primaryParentCategoryId -> productCategoryId)
    + PrimaryChildProductCategory (many, autoRelation: false, keymaps: productCategoryId -> primaryParentCategoryId)
    + MarketInterest (many, autoRelation: true, keymaps: productCategoryId)
    + PartyNeed (many, autoRelation: true, keymaps: productCategoryId)
    + ProdCatalogCategory (many, autoRelation: true, keymaps: productCategoryId)
    + PrimaryProduct (many, autoRelation: true, keymaps: productCategoryId -> primaryProductCategoryId)
    + ProductCategoryAttribute (many, autoRelation: true, keymaps: productCategoryId)
    + ProductCategoryContent (many, autoRelation: true, keymaps: productCategoryId)
    + ProductCategoryGlAccount (many, autoRelation: true, keymaps: productCategoryId)
    + ProductCategoryLink (many, autoRelation: true, keymaps: productCategoryId)
    + ProductCategoryMember (many, autoRelation: true, keymaps: productCategoryId)
    + ProductCategoryRole (many, autoRelation: true, keymaps: productCategoryId)
    + CurrentProductCategoryRollup (many, autoRelation: true, keymaps: productCategoryId)
    + ParentProductCategoryRollup (many, autoRelation: true, keymaps: productCategoryId -> parentProductCategoryId)
    + ProductFeatureCatGrpAppl (many, autoRelation: true, keymaps: productCategoryId)
    + ProductFeatureCategoryAppl (many, autoRelation: true, keymaps: productCategoryId)
    + ProductPromoCategory (many, autoRelation: true, keymaps: productCategoryId)
    + ProductStoreSurveyAppl (many, autoRelation: true, keymaps: productCategoryId)
    + SalesForecastDetail (many, autoRelation: true, keymaps: productCategoryId)
    + Subscription (many, autoRelation: true, keymaps: productCategoryId)
    + TaxAuthorityCategory (many, autoRelation: true, keymaps: productCategoryId)
    + TaxAuthorityRateProduct (many, autoRelation: true, keymaps: productCategoryId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

