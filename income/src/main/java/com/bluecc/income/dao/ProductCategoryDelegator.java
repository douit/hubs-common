package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.function.Consumer;
import com.google.common.collect.Maps;

import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import javax.inject.Inject;
import javax.inject.Provider;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.income.exchange.IProc;
import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.hubs.fund.SqlMeta;

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
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product_category")
        List<ProductCategory> listProductCategory();
        @SqlQuery("select * from product_category where product_category_id=:id")
        ProductCategory getProductCategory(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category")
        int countProductCategory();

        // for relations
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pppc")
        default Map<String, ProductCategory> chainPrimaryParentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainPrimaryParentProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pppc")
        default Map<String, ProductCategory> chainPrimaryParentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRIMARY_PARENT_PRODUCT_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pppc_product_category_id", String.class) != null) {
                            p.getRelPrimaryParentProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pcpc")
        default Map<String, ProductCategory> chainPrimaryChildProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainPrimaryChildProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pcpc")
        default Map<String, ProductCategory> chainPrimaryChildProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRIMARY_CHILD_PRODUCT_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pcpc_primary_parent_category_id", String.class) != null) {
                            p.getRelPrimaryChildProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        default Map<String, ProductCategory> chainProdCatalogCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProdCatalogCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        default Map<String, ProductCategory> chainProdCatalogCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PROD_CATALOG_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pcc_product_category_id", String.class) != null) {
                            p.getRelProdCatalogCategory()
                                    .add(rr.getRow(ProdCatalogCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = Product.class, prefix = "pp")
        default Map<String, ProductCategory> chainPrimaryProduct(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainPrimaryProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = Product.class, prefix = "pp")
        default Map<String, ProductCategory> chainPrimaryProduct(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRIMARY_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pp_primary_product_category_id", String.class) != null) {
                            p.getRelPrimaryProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryContent.class, prefix = "pcc")
        default Map<String, ProductCategory> chainProductCategoryContent(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProductCategoryContent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryContent.class, prefix = "pcc")
        default Map<String, ProductCategory> chainProductCategoryContent(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY_CONTENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pcc_product_category_id", String.class) != null) {
                            p.getRelProductCategoryContent()
                                    .add(rr.getRow(ProductCategoryContent.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryLink.class, prefix = "pcl")
        default Map<String, ProductCategory> chainProductCategoryLink(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProductCategoryLink(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryLink.class, prefix = "pcl")
        default Map<String, ProductCategory> chainProductCategoryLink(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY_LINK);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pcl_product_category_id", String.class) != null) {
                            p.getRelProductCategoryLink()
                                    .add(rr.getRow(ProductCategoryLink.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        default Map<String, ProductCategory> chainProductCategoryMember(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProductCategoryMember(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        default Map<String, ProductCategory> chainProductCategoryMember(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY_MEMBER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pcm_product_category_id", String.class) != null) {
                            p.getRelProductCategoryMember()
                                    .add(rr.getRow(ProductCategoryMember.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryRole.class, prefix = "pcr")
        default Map<String, ProductCategory> chainProductCategoryRole(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProductCategoryRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryRole.class, prefix = "pcr")
        default Map<String, ProductCategory> chainProductCategoryRole(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pcr_product_category_id", String.class) != null) {
                            p.getRelProductCategoryRole()
                                    .add(rr.getRow(ProductCategoryRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "cpcr")
        default Map<String, ProductCategory> chainCurrentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainCurrentProductCategoryRollup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "cpcr")
        default Map<String, ProductCategory> chainCurrentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CURRENT_PRODUCT_CATEGORY_ROLLUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("cpcr_product_category_id", String.class) != null) {
                            p.getRelCurrentProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "ppcr")
        default Map<String, ProductCategory> chainParentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainParentProductCategoryRollup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "ppcr")
        default Map<String, ProductCategory> chainParentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_PRODUCT_CATEGORY_ROLLUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("ppcr_parent_product_category_id", String.class) != null) {
                            p.getRelParentProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductFeatureCategoryAppl.class, prefix = "pfca")
        default Map<String, ProductCategory> chainProductFeatureCategoryAppl(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProductFeatureCategoryAppl(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductFeatureCategoryAppl.class, prefix = "pfca")
        default Map<String, ProductCategory> chainProductFeatureCategoryAppl(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FEATURE_CATEGORY_APPL);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pfca_product_category_id", String.class) != null) {
                            p.getRelProductFeatureCategoryAppl()
                                    .add(rr.getRow(ProductFeatureCategoryAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductPromoCategory.class, prefix = "ppc")
        default Map<String, ProductCategory> chainProductPromoCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProductPromoCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductPromoCategory.class, prefix = "ppc")
        default Map<String, ProductCategory> chainProductPromoCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_PROMO_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("ppc_product_category_id", String.class) != null) {
                            p.getRelProductPromoCategory()
                                    .add(rr.getRow(ProductPromoCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssa")
        default Map<String, ProductCategory> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainProductStoreSurveyAppl(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssa")
        default Map<String, ProductCategory> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_SURVEY_APPL);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("pssa_product_category_id", String.class) != null) {
                            p.getRelProductStoreSurveyAppl()
                                    .add(rr.getRow(ProductStoreSurveyAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = TaxAuthorityCategory.class, prefix = "tac")
        default Map<String, ProductCategory> chainTaxAuthorityCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = TaxAuthorityCategory.class, prefix = "tac")
        default Map<String, ProductCategory> chainTaxAuthorityCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("tac_product_category_id", String.class) != null) {
                            p.getRelTaxAuthorityCategory()
                                    .add(rr.getRow(TaxAuthorityCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarp")
        default Map<String, ProductCategory> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityRateProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarp")
        default Map<String, ProductCategory> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, ProductCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_RATE_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategory p = map.computeIfAbsent(rr.getColumn("pc_product_category_id", String.class),
                                id -> rr.getRow(ProductCategory.class));
                        if (rr.getColumn("tarp_product_category_id", String.class) != null) {
                            p.getRelTaxAuthorityRateProduct()
                                    .add(rr.getRow(TaxAuthorityRateProduct.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProductCategory>> primaryParentProductCategory(Dao dao, boolean succ) {
        return e -> dao.chainPrimaryParentProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> primaryParentProductCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPrimaryParentProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> primaryChildProductCategory(Dao dao, boolean succ) {
        return e -> dao.chainPrimaryChildProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> primaryChildProductCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPrimaryChildProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> prodCatalogCategory(Dao dao, boolean succ) {
        return e -> dao.chainProdCatalogCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> prodCatalogCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProdCatalogCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> primaryProduct(Dao dao, boolean succ) {
        return e -> dao.chainPrimaryProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> primaryProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPrimaryProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> productCategoryContent(Dao dao, boolean succ) {
        return e -> dao.chainProductCategoryContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> productCategoryContent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategoryContent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> productCategoryLink(Dao dao, boolean succ) {
        return e -> dao.chainProductCategoryLink(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> productCategoryLink(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategoryLink(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> productCategoryMember(Dao dao, boolean succ) {
        return e -> dao.chainProductCategoryMember(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> productCategoryMember(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategoryMember(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> productCategoryRole(Dao dao, boolean succ) {
        return e -> dao.chainProductCategoryRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> productCategoryRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategoryRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> currentProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainCurrentProductCategoryRollup(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> currentProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCurrentProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> parentProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainParentProductCategoryRollup(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> parentProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParentProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> productFeatureCategoryAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductFeatureCategoryAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> productFeatureCategoryAppl(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductFeatureCategoryAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> productPromoCategory(Dao dao, boolean succ) {
        return e -> dao.chainProductPromoCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> productPromoCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductPromoCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> productStoreSurveyAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> productStoreSurveyAppl(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> taxAuthorityCategory(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> taxAuthorityCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategory>> taxAuthorityRateProduct(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategory>> taxAuthorityRateProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, whereClause, binds, succ);
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

    public Agent getAgent(IProc.ProcContext ctx, ProductCategory rec) {
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


    
    public ProductCategory.ProductCategoryBuilder seed(){
        return ProductCategory.builder()
                .productCategoryId(sequence.nextStringId());
    }
}
