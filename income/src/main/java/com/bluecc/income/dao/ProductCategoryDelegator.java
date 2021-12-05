package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.ProductCategoryData;

public class ProductCategoryDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = ProductCategory.class)
    public interface ProductCategoryDao {
        @SqlQuery("select * from product_category")
        List<ProductCategory> listProductCategory();
        @SqlQuery("select * from product_category where product_category_id=:id")
        ProductCategory getProductCategory(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category")
        int countProductCategory();
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
                                             el.toDataBuilder().build()));
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
                                             el.toDataBuilder().build()));
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
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set parent_product_category_rollup to head entity                        
                        if(relationsDemand.contains("parent_product_category_rollup")) {
                            getRelationValues(ctx, p1, "parent_product_category_rollup",
                                            ProductCategoryRollup.class)
                                    .forEach(el -> pb.addParentProductCategoryRollup(
                                             el.toDataBuilder().build()));
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
