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
import com.bluecc.hubs.stub.ProductStoreData;

public class ProductStoreDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductStore.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product_store")
        List<ProductStore> listProductStore();
        @SqlQuery("select * from product_store where product_store_id=:id")
        ProductStore getProductStore(@Bind("id") String id);

        @SqlQuery("select count(*) from product_store")
        int countProductStore();

        // for relations
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Facility.class, prefix = "fa")
        default Map<String, ProductStore> chainFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Facility.class, prefix = "fa")
        default Map<String, ProductStore> chainFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("fa_facility_id", String.class) != null) {
                            p.getRelFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, ProductStore> chainParty(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, ProductStore> chainParty(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pa_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthority.class, prefix = "vta")
        default Map<String, ProductStore> chainVatTaxAuthority(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainVatTaxAuthority(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthority.class, prefix = "vta")
        default Map<String, ProductStore> chainVatTaxAuthority(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(VAT_TAX_AUTHORITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("vta_tax_auth_geo_id", String.class) != null) {
                            p.getRelVatTaxAuthority()
                                    .add(rr.getRow(TaxAuthority.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = CustRequest.class, prefix = "cr")
        default Map<String, ProductStore> chainCustRequest(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainCustRequest(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = CustRequest.class, prefix = "cr")
        default Map<String, ProductStore> chainCustRequest(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CUST_REQUEST);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("cr_product_store_id", String.class) != null) {
                            p.getRelCustRequest()
                                    .add(rr.getRow(CustRequest.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "ec")
        default Map<String, ProductStore> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainEbayConfig(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "ec")
        default Map<String, ProductStore> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(EBAY_CONFIG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("ec_product_store_id", String.class) != null) {
                            p.getRelEbayConfig()
                                    .add(rr.getRow(EbayConfig.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        default Map<String, ProductStore> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainOrderHeader(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        default Map<String, ProductStore> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_HEADER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("oh_product_store_id", String.class) != null) {
                            p.getRelOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "pr")
        default Map<String, ProductStore> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductReview(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "pr")
        default Map<String, ProductStore> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_REVIEW);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pr_product_store_id", String.class) != null) {
                            p.getRelProductReview()
                                    .add(rr.getRow(ProductReview.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        default Map<String, ProductStore> chainProductStoreCatalog(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreCatalog(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        default Map<String, ProductStore> chainProductStoreCatalog(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_CATALOG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psc_product_store_id", String.class) != null) {
                            p.getRelProductStoreCatalog()
                                    .add(rr.getRow(ProductStoreCatalog.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreEmailSetting.class, prefix = "pses")
        default Map<String, ProductStore> chainProductStoreEmailSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreEmailSetting(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreEmailSetting.class, prefix = "pses")
        default Map<String, ProductStore> chainProductStoreEmailSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_EMAIL_SETTING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pses_product_store_id", String.class) != null) {
                            p.getRelProductStoreEmailSetting()
                                    .add(rr.getRow(ProductStoreEmailSetting.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        default Map<String, ProductStore> chainProductStoreFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        default Map<String, ProductStore> chainProductStoreFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psf_product_store_id", String.class) != null) {
                            p.getRelProductStoreFacility()
                                    .add(rr.getRow(ProductStoreFacility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFinActSetting.class, prefix = "psfas")
        default Map<String, ProductStore> chainProductStoreFinActSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreFinActSetting(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFinActSetting.class, prefix = "psfas")
        default Map<String, ProductStore> chainProductStoreFinActSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_FIN_ACT_SETTING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psfas_product_store_id", String.class) != null) {
                            p.getRelProductStoreFinActSetting()
                                    .add(rr.getRow(ProductStoreFinActSetting.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreKeywordOvrd.class, prefix = "psko")
        default Map<String, ProductStore> chainProductStoreKeywordOvrd(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreKeywordOvrd(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreKeywordOvrd.class, prefix = "psko")
        default Map<String, ProductStore> chainProductStoreKeywordOvrd(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_KEYWORD_OVRD);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psko_product_store_id", String.class) != null) {
                            p.getRelProductStoreKeywordOvrd()
                                    .add(rr.getRow(ProductStoreKeywordOvrd.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePaymentSetting.class, prefix = "psps")
        default Map<String, ProductStore> chainProductStorePaymentSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStorePaymentSetting(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePaymentSetting.class, prefix = "psps")
        default Map<String, ProductStore> chainProductStorePaymentSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_PAYMENT_SETTING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psps_product_store_id", String.class) != null) {
                            p.getRelProductStorePaymentSetting()
                                    .add(rr.getRow(ProductStorePaymentSetting.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePromoAppl.class, prefix = "pspa")
        default Map<String, ProductStore> chainProductStorePromoAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStorePromoAppl(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePromoAppl.class, prefix = "pspa")
        default Map<String, ProductStore> chainProductStorePromoAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_PROMO_APPL);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pspa_product_store_id", String.class) != null) {
                            p.getRelProductStorePromoAppl()
                                    .add(rr.getRow(ProductStorePromoAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psr")
        default Map<String, ProductStore> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psr")
        default Map<String, ProductStore> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psr_product_store_id", String.class) != null) {
                            p.getRelProductStoreRole()
                                    .add(rr.getRow(ProductStoreRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssa")
        default Map<String, ProductStore> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreSurveyAppl(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssa")
        default Map<String, ProductStore> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_SURVEY_APPL);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pssa_product_store_id", String.class) != null) {
                            p.getRelProductStoreSurveyAppl()
                                    .add(rr.getRow(ProductStoreSurveyAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Quote.class, prefix = "qu")
        default Map<String, ProductStore> chainQuote(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainQuote(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Quote.class, prefix = "qu")
        default Map<String, ProductStore> chainQuote(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(QUOTE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("qu_product_store_id", String.class) != null) {
                            p.getRelQuote()
                                    .add(rr.getRow(Quote.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarp")
        default Map<String, ProductStore> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityRateProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarp")
        default Map<String, ProductStore> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_RATE_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("tarp_product_store_id", String.class) != null) {
                            p.getRelTaxAuthorityRateProduct()
                                    .add(rr.getRow(TaxAuthorityRateProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        default Map<String, ProductStore> chainWebSite(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainWebSite(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        default Map<String, ProductStore> chainWebSite(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WEB_SITE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("ws_product_store_id", String.class) != null) {
                            p.getRelWebSite()
                                    .add(rr.getRow(WebSite.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProductStore>> facility(Dao dao, boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> facility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> party(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> vatTaxAuthority(Dao dao, boolean succ) {
        return e -> dao.chainVatTaxAuthority(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> vatTaxAuthority(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainVatTaxAuthority(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> custRequest(Dao dao, boolean succ) {
        return e -> dao.chainCustRequest(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> custRequest(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCustRequest(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> ebayConfig(Dao dao, boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> ebayConfig(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> orderHeader(Dao dao, boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> orderHeader(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productReview(Dao dao, boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productReview(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreCatalog(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreCatalog(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreCatalog(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreCatalog(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreEmailSetting(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreEmailSetting(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreEmailSetting(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreEmailSetting(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreFacility(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreFacility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreFinActSetting(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreFinActSetting(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreFinActSetting(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreFinActSetting(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreKeywordOvrd(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreKeywordOvrd(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreKeywordOvrd(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreKeywordOvrd(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStorePaymentSetting(Dao dao, boolean succ) {
        return e -> dao.chainProductStorePaymentSetting(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStorePaymentSetting(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStorePaymentSetting(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStorePromoAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductStorePromoAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStorePromoAppl(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStorePromoAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreRole(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreSurveyAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreSurveyAppl(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> quote(Dao dao, boolean succ) {
        return e -> dao.chainQuote(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> quote(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainQuote(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> taxAuthorityRateProduct(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> taxAuthorityRateProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> webSite(Dao dao, boolean succ) {
        return e -> dao.chainWebSite(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> webSite(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainWebSite(protoMeta, e, whereClause, binds, succ);
    }
    

    public ProductStore get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductStore(id);
    }

    public List<ProductStore> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductStore();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductStore();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductStore rec;
        final Message p1;
        ProductStore persistObject;

        Agent(IProc.ProcContext ctx, ProductStore rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductStore getRecord(){
            return rec;
        }

        public ProductStore merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<Facility> getFacility(){
            return getRelationValues(ctx, p1, "facility", Facility.class);
        }

        public List<Facility> mergeFacility(){
            return getFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getParty(){
            return getRelationValues(ctx, p1, "party", Party.class);
        }

        public List<Party> mergeParty(){
            return getParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<TaxAuthority> getVatTaxAuthority(){
            return getRelationValues(ctx, p1, "vat_tax_authority", TaxAuthority.class);
        }

        public List<TaxAuthority> mergeVatTaxAuthority(){
            return getVatTaxAuthority().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelVatTaxAuthority().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CustRequest> getCustRequest(){
            return getRelationValues(ctx, p1, "cust_request", CustRequest.class);
        }

        public List<CustRequest> mergeCustRequest(){
            return getCustRequest().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCustRequest().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<EbayConfig> getEbayConfig(){
            return getRelationValues(ctx, p1, "ebay_config", EbayConfig.class);
        }

        public List<EbayConfig> mergeEbayConfig(){
            return getEbayConfig().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEbayConfig().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderHeader> getOrderHeader(){
            return getRelationValues(ctx, p1, "order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeOrderHeader(){
            return getOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductReview> getProductReview(){
            return getRelationValues(ctx, p1, "product_review", ProductReview.class);
        }

        public List<ProductReview> mergeProductReview(){
            return getProductReview().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductReview().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreCatalog> getProductStoreCatalog(){
            return getRelationValues(ctx, p1, "product_store_catalog", ProductStoreCatalog.class);
        }

        public List<ProductStoreCatalog> mergeProductStoreCatalog(){
            return getProductStoreCatalog().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreCatalog().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreEmailSetting> getProductStoreEmailSetting(){
            return getRelationValues(ctx, p1, "product_store_email_setting", ProductStoreEmailSetting.class);
        }

        public List<ProductStoreEmailSetting> mergeProductStoreEmailSetting(){
            return getProductStoreEmailSetting().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreEmailSetting().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreFacility> getProductStoreFacility(){
            return getRelationValues(ctx, p1, "product_store_facility", ProductStoreFacility.class);
        }

        public List<ProductStoreFacility> mergeProductStoreFacility(){
            return getProductStoreFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreFinActSetting> getProductStoreFinActSetting(){
            return getRelationValues(ctx, p1, "product_store_fin_act_setting", ProductStoreFinActSetting.class);
        }

        public List<ProductStoreFinActSetting> mergeProductStoreFinActSetting(){
            return getProductStoreFinActSetting().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreFinActSetting().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreKeywordOvrd> getProductStoreKeywordOvrd(){
            return getRelationValues(ctx, p1, "product_store_keyword_ovrd", ProductStoreKeywordOvrd.class);
        }

        public List<ProductStoreKeywordOvrd> mergeProductStoreKeywordOvrd(){
            return getProductStoreKeywordOvrd().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreKeywordOvrd().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStorePaymentSetting> getProductStorePaymentSetting(){
            return getRelationValues(ctx, p1, "product_store_payment_setting", ProductStorePaymentSetting.class);
        }

        public List<ProductStorePaymentSetting> mergeProductStorePaymentSetting(){
            return getProductStorePaymentSetting().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStorePaymentSetting().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStorePromoAppl> getProductStorePromoAppl(){
            return getRelationValues(ctx, p1, "product_store_promo_appl", ProductStorePromoAppl.class);
        }

        public List<ProductStorePromoAppl> mergeProductStorePromoAppl(){
            return getProductStorePromoAppl().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStorePromoAppl().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreRole> getProductStoreRole(){
            return getRelationValues(ctx, p1, "product_store_role", ProductStoreRole.class);
        }

        public List<ProductStoreRole> mergeProductStoreRole(){
            return getProductStoreRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreRole().add(c))
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
         
        public List<Quote> getQuote(){
            return getRelationValues(ctx, p1, "quote", Quote.class);
        }

        public List<Quote> mergeQuote(){
            return getQuote().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuote().add(c))
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
         
        public List<WebSite> getWebSite(){
            return getRelationValues(ctx, p1, "web_site", WebSite.class);
        }

        public List<WebSite> mergeWebSite(){
            return getWebSite().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWebSite().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductStoreData p = ProductStoreData.newBuilder()
                .setProductStoreId(key)
                .build();
        ProductStore rec = findOne(ctx, p, ProductStore.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProductStore rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String FACILITY="facility";
         
    public static final String PARTY="party";
         
    public static final String VAT_TAX_AUTHORITY="vat_tax_authority";
         
    public static final String CUST_REQUEST="cust_request";
         
    public static final String EBAY_CONFIG="ebay_config";
         
    public static final String ORDER_HEADER="order_header";
         
    public static final String PRODUCT_REVIEW="product_review";
         
    public static final String PRODUCT_STORE_CATALOG="product_store_catalog";
         
    public static final String PRODUCT_STORE_EMAIL_SETTING="product_store_email_setting";
         
    public static final String PRODUCT_STORE_FACILITY="product_store_facility";
         
    public static final String PRODUCT_STORE_FIN_ACT_SETTING="product_store_fin_act_setting";
         
    public static final String PRODUCT_STORE_KEYWORD_OVRD="product_store_keyword_ovrd";
         
    public static final String PRODUCT_STORE_PAYMENT_SETTING="product_store_payment_setting";
         
    public static final String PRODUCT_STORE_PROMO_APPL="product_store_promo_appl";
         
    public static final String PRODUCT_STORE_ROLE="product_store_role";
         
    public static final String PRODUCT_STORE_SURVEY_APPL="product_store_survey_appl";
         
    public static final String QUOTE="quote";
         
    public static final String TAX_AUTHORITY_RATE_PRODUCT="tax_authority_rate_product";
         
    public static final String WEB_SITE="web_site";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductStoreRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductStoreData p = ProductStoreData.newBuilder()
                    .setProductStoreId(key)
                    .build();
            List<ProductStoreData.Builder> ds = find(ctx, p, ProductStore.class).stream()
                    .map(e -> {
                        ProductStoreData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set facility to head entity                        
                        if(relationsDemand.contains("facility")) {
                            getRelationValues(ctx, p1, "facility",
                                            Facility.class)
                                    .forEach(el -> pb.setFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set vat_tax_authority to head entity                        
                        if(relationsDemand.contains("vat_tax_authority")) {
                            getRelationValues(ctx, p1, "vat_tax_authority",
                                            TaxAuthority.class)
                                    .forEach(el -> pb.setVatTaxAuthority(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set cust_request to head entity                        
                        if(relationsDemand.contains("cust_request")) {
                            getRelationValues(ctx, p1, "cust_request",
                                            CustRequest.class)
                                    .forEach(el -> pb.addCustRequest(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set ebay_config to head entity                        
                        if(relationsDemand.contains("ebay_config")) {
                            getRelationValues(ctx, p1, "ebay_config",
                                            EbayConfig.class)
                                    .forEach(el -> pb.setEbayConfig(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_header to head entity                        
                        if(relationsDemand.contains("order_header")) {
                            getRelationValues(ctx, p1, "order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.addOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_review to head entity                        
                        if(relationsDemand.contains("product_review")) {
                            getRelationValues(ctx, p1, "product_review",
                                            ProductReview.class)
                                    .forEach(el -> pb.addProductReview(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_catalog to head entity                        
                        if(relationsDemand.contains("product_store_catalog")) {
                            getRelationValues(ctx, p1, "product_store_catalog",
                                            ProductStoreCatalog.class)
                                    .forEach(el -> pb.addProductStoreCatalog(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_email_setting to head entity                        
                        if(relationsDemand.contains("product_store_email_setting")) {
                            getRelationValues(ctx, p1, "product_store_email_setting",
                                            ProductStoreEmailSetting.class)
                                    .forEach(el -> pb.addProductStoreEmailSetting(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_facility to head entity                        
                        if(relationsDemand.contains("product_store_facility")) {
                            getRelationValues(ctx, p1, "product_store_facility",
                                            ProductStoreFacility.class)
                                    .forEach(el -> pb.addProductStoreFacility(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_fin_act_setting to head entity                        
                        if(relationsDemand.contains("product_store_fin_act_setting")) {
                            getRelationValues(ctx, p1, "product_store_fin_act_setting",
                                            ProductStoreFinActSetting.class)
                                    .forEach(el -> pb.addProductStoreFinActSetting(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_keyword_ovrd to head entity                        
                        if(relationsDemand.contains("product_store_keyword_ovrd")) {
                            getRelationValues(ctx, p1, "product_store_keyword_ovrd",
                                            ProductStoreKeywordOvrd.class)
                                    .forEach(el -> pb.addProductStoreKeywordOvrd(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_payment_setting to head entity                        
                        if(relationsDemand.contains("product_store_payment_setting")) {
                            getRelationValues(ctx, p1, "product_store_payment_setting",
                                            ProductStorePaymentSetting.class)
                                    .forEach(el -> pb.addProductStorePaymentSetting(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_promo_appl to head entity                        
                        if(relationsDemand.contains("product_store_promo_appl")) {
                            getRelationValues(ctx, p1, "product_store_promo_appl",
                                            ProductStorePromoAppl.class)
                                    .forEach(el -> pb.addProductStorePromoAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_role to head entity                        
                        if(relationsDemand.contains("product_store_role")) {
                            getRelationValues(ctx, p1, "product_store_role",
                                            ProductStoreRole.class)
                                    .forEach(el -> pb.addProductStoreRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_survey_appl to head entity                        
                        if(relationsDemand.contains("product_store_survey_appl")) {
                            getRelationValues(ctx, p1, "product_store_survey_appl",
                                            ProductStoreSurveyAppl.class)
                                    .forEach(el -> pb.addProductStoreSurveyAppl(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set quote to head entity                        
                        if(relationsDemand.contains("quote")) {
                            getRelationValues(ctx, p1, "quote",
                                            Quote.class)
                                    .forEach(el -> pb.addQuote(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set tax_authority_rate_product to head entity                        
                        if(relationsDemand.contains("tax_authority_rate_product")) {
                            getRelationValues(ctx, p1, "tax_authority_rate_product",
                                            TaxAuthorityRateProduct.class)
                                    .forEach(el -> pb.addTaxAuthorityRateProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set web_site to head entity                        
                        if(relationsDemand.contains("web_site")) {
                            getRelationValues(ctx, p1, "web_site",
                                            WebSite.class)
                                    .forEach(el -> pb.addWebSite(
                                             el.toHeadBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
    public ProductStore.ProductStoreBuilder seed(){
        return ProductStore.builder()
                .productStoreId(sequence.nextStringId());
    }
}
