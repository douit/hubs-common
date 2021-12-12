package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import javax.inject.Inject;
import javax.inject.Provider;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.income.exchange.IProc;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.ProductCategoryData;

public class ProductCategoryDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductCategory.class)
    public interface Dao {
        @SqlQuery("select * from product_category")
        List<ProductCategory> listProductCategory();
        @SqlQuery("select * from product_category where product_category_id=:id")
        ProductCategory getProductCategory(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category")
        int countProductCategory();
    }

    public ProductCategory get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductCategory(id);
    }

    public List<ProductCategory> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductCategory();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductCategory();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductCategory rec;
        final Message p1;
        ProductCategory persistObject;

        Agent(IProc.ProcContext ctx, ProductCategory rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductCategory getRecord(){
            return rec;
        }

        public ProductCategory merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ProductCategory> getPrimaryParentProductCategory(){
            return getRelationValues(ctx, p1, "primary_parent_product_category", ProductCategory.class);
        }

        public List<ProductCategory> mergePrimaryParentProductCategory(){
            return getPrimaryParentProductCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryParentProductCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategory> getPrimaryChildProductCategory(){
            return getRelationValues(ctx, p1, "primary_child_product_category", ProductCategory.class);
        }

        public List<ProductCategory> mergePrimaryChildProductCategory(){
            return getPrimaryChildProductCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryChildProductCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProdCatalogCategory> getProdCatalogCategory(){
            return getRelationValues(ctx, p1, "prod_catalog_category", ProdCatalogCategory.class);
        }

        public List<ProdCatalogCategory> mergeProdCatalogCategory(){
            return getProdCatalogCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProdCatalogCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Product> getPrimaryProduct(){
            return getRelationValues(ctx, p1, "primary_product", Product.class);
        }

        public List<Product> mergePrimaryProduct(){
            return getPrimaryProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryContent> getProductCategoryContent(){
            return getRelationValues(ctx, p1, "product_category_content", ProductCategoryContent.class);
        }

        public List<ProductCategoryContent> mergeProductCategoryContent(){
            return getProductCategoryContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategoryContent().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryLink> getProductCategoryLink(){
            return getRelationValues(ctx, p1, "product_category_link", ProductCategoryLink.class);
        }

        public List<ProductCategoryLink> mergeProductCategoryLink(){
            return getProductCategoryLink().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategoryLink().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryMember> getProductCategoryMember(){
            return getRelationValues(ctx, p1, "product_category_member", ProductCategoryMember.class);
        }

        public List<ProductCategoryMember> mergeProductCategoryMember(){
            return getProductCategoryMember().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategoryMember().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryRole> getProductCategoryRole(){
            return getRelationValues(ctx, p1, "product_category_role", ProductCategoryRole.class);
        }

        public List<ProductCategoryRole> mergeProductCategoryRole(){
            return getProductCategoryRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategoryRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryRollup> getCurrentProductCategoryRollup(){
            return getRelationValues(ctx, p1, "current_product_category_rollup", ProductCategoryRollup.class);
        }

        public List<ProductCategoryRollup> mergeCurrentProductCategoryRollup(){
            return getCurrentProductCategoryRollup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCurrentProductCategoryRollup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryRollup> getParentProductCategoryRollup(){
            return getRelationValues(ctx, p1, "parent_product_category_rollup", ProductCategoryRollup.class);
        }

        public List<ProductCategoryRollup> mergeParentProductCategoryRollup(){
            return getParentProductCategoryRollup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParentProductCategoryRollup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFeatureCategoryAppl> getProductFeatureCategoryAppl(){
            return getRelationValues(ctx, p1, "product_feature_category_appl", ProductFeatureCategoryAppl.class);
        }

        public List<ProductFeatureCategoryAppl> mergeProductFeatureCategoryAppl(){
            return getProductFeatureCategoryAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFeatureCategoryAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoCategory> getProductPromoCategory(){
            return getRelationValues(ctx, p1, "product_promo_category", ProductPromoCategory.class);
        }

        public List<ProductPromoCategory> mergeProductPromoCategory(){
            return getProductPromoCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductPromoCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreSurveyAppl> getProductStoreSurveyAppl(){
            return getRelationValues(ctx, p1, "product_store_survey_appl", ProductStoreSurveyAppl.class);
        }

        public List<ProductStoreSurveyAppl> mergeProductStoreSurveyAppl(){
            return getProductStoreSurveyAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreSurveyAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TaxAuthorityCategory> getTaxAuthorityCategory(){
            return getRelationValues(ctx, p1, "tax_authority_category", TaxAuthorityCategory.class);
        }

        public List<TaxAuthorityCategory> mergeTaxAuthorityCategory(){
            return getTaxAuthorityCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTaxAuthorityCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TaxAuthorityRateProduct> getTaxAuthorityRateProduct(){
            return getRelationValues(ctx, p1, "tax_authority_rate_product", TaxAuthorityRateProduct.class);
        }

        public List<TaxAuthorityRateProduct> mergeTaxAuthorityRateProduct(){
            return getTaxAuthorityRateProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTaxAuthorityRateProduct().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductCategoryData p = ProductCategoryData.newBuilder()
                .setProductCategoryId(key)
                .build();
        ProductCategory rec = findOne(ctx, p, ProductCategory.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PRIMARY_PARENT_PRODUCT_CATEGORY="primary_parent_product_category";
         
    public static final String PRIMARY_CHILD_PRODUCT_CATEGORY="primary_child_product_category";
         
    public static final String PROD_CATALOG_CATEGORY="prod_catalog_category";
         
    public static final String PRIMARY_PRODUCT="primary_product";
         
    public static final String PRODUCT_CATEGORY_CONTENT="product_category_content";
         
    public static final String PRODUCT_CATEGORY_LINK="product_category_link";
         
    public static final String PRODUCT_CATEGORY_MEMBER="product_category_member";
         
    public static final String PRODUCT_CATEGORY_ROLE="product_category_role";
         
    public static final String CURRENT_PRODUCT_CATEGORY_ROLLUP="current_product_category_rollup";
         
    public static final String PARENT_PRODUCT_CATEGORY_ROLLUP="parent_product_category_rollup";
         
    public static final String PRODUCT_FEATURE_CATEGORY_APPL="product_feature_category_appl";
         
    public static final String PRODUCT_PROMO_CATEGORY="product_promo_category";
         
    public static final String PRODUCT_STORE_SURVEY_APPL="product_store_survey_appl";
         
    public static final String TAX_AUTHORITY_CATEGORY="tax_authority_category";
         
    public static final String TAX_AUTHORITY_RATE_PRODUCT="tax_authority_rate_product";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductCategoryRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductCategoryData p = ProductCategoryData.newBuilder()
                    .setProductCategoryId(key)
                    .build();
            List<ProductCategoryData.Builder> ds = find(ctx, p, ProductCategory.class).stream()
                    .map(e -> {
                        ProductCategoryData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set primary_parent_product_category to head entity                        
                        if(relationsDemand.contains("primary_parent_product_category")) {
                            getRelationValues(ctx, p1, "primary_parent_product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.setPrimaryParentProductCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set primary_child_product_category to head entity                        
                        if(relationsDemand.contains("primary_child_product_category")) {
                            getRelationValues(ctx, p1, "primary_child_product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.addPrimaryChildProductCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set prod_catalog_category to head entity                        
                        if(relationsDemand.contains("prod_catalog_category")) {
                            getRelationValues(ctx, p1, "prod_catalog_category",
                                            ProdCatalogCategory.class)
                                    .forEach(el -> pb.addProdCatalogCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set primary_product to head entity                        
                        if(relationsDemand.contains("primary_product")) {
                            getRelationValues(ctx, p1, "primary_product",
                                            Product.class)
                                    .forEach(el -> pb.addPrimaryProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_category_content to head entity                        
                        if(relationsDemand.contains("product_category_content")) {
                            getRelationValues(ctx, p1, "product_category_content",
                                            ProductCategoryContent.class)
                                    .forEach(el -> pb.addProductCategoryContent(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_category_link to head entity                        
                        if(relationsDemand.contains("product_category_link")) {
                            getRelationValues(ctx, p1, "product_category_link",
                                            ProductCategoryLink.class)
                                    .forEach(el -> pb.addProductCategoryLink(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_category_member to head entity                        
                        if(relationsDemand.contains("product_category_member")) {
                            getRelationValues(ctx, p1, "product_category_member",
                                            ProductCategoryMember.class)
                                    .forEach(el -> pb.addProductCategoryMember(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_category_role to head entity                        
                        if(relationsDemand.contains("product_category_role")) {
                            getRelationValues(ctx, p1, "product_category_role",
                                            ProductCategoryRole.class)
                                    .forEach(el -> pb.addProductCategoryRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set current_product_category_rollup to head entity                        
                        if(relationsDemand.contains("current_product_category_rollup")) {
                            getRelationValues(ctx, p1, "current_product_category_rollup",
                                            ProductCategoryRollup.class)
                                    .forEach(el -> pb.addCurrentProductCategoryRollup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set parent_product_category_rollup to head entity                        
                        if(relationsDemand.contains("parent_product_category_rollup")) {
                            getRelationValues(ctx, p1, "parent_product_category_rollup",
                                            ProductCategoryRollup.class)
                                    .forEach(el -> pb.addParentProductCategoryRollup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_feature_category_appl to head entity                        
                        if(relationsDemand.contains("product_feature_category_appl")) {
                            getRelationValues(ctx, p1, "product_feature_category_appl",
                                            ProductFeatureCategoryAppl.class)
                                    .forEach(el -> pb.addProductFeatureCategoryAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_promo_category to head entity                        
                        if(relationsDemand.contains("product_promo_category")) {
                            getRelationValues(ctx, p1, "product_promo_category",
                                            ProductPromoCategory.class)
                                    .forEach(el -> pb.addProductPromoCategory(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_survey_appl to head entity                        
                        if(relationsDemand.contains("product_store_survey_appl")) {
                            getRelationValues(ctx, p1, "product_store_survey_appl",
                                            ProductStoreSurveyAppl.class)
                                    .forEach(el -> pb.addProductStoreSurveyAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set tax_authority_category to head entity                        
                        if(relationsDemand.contains("tax_authority_category")) {
                            getRelationValues(ctx, p1, "tax_authority_category",
                                            TaxAuthorityCategory.class)
                                    .forEach(el -> pb.addTaxAuthorityCategory(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set tax_authority_rate_product to head entity                        
                        if(relationsDemand.contains("tax_authority_rate_product")) {
                            getRelationValues(ctx, p1, "tax_authority_rate_product",
                                            TaxAuthorityRateProduct.class)
                                    .forEach(el -> pb.addTaxAuthorityRateProduct(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}
