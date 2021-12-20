package com.bluecc.income.dao;

import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.procs.Buckets;
import com.bluecc.income.procs.SelectorBindings;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import com.bluecc.income.exchange.GsonConverters;
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.annotation.RequestConverter;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Consumer;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;
import com.bluecc.income.procs.Buckets;

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
import io.grpc.stub.StreamObserver;
import com.bluecc.income.exchange.IChainQuery;

import com.bluecc.hubs.stub.ProductStoreData;

public class ProductStoreDelegator extends AbstractProcs implements IChainQuery<ProductStore>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

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
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, ProductStore> chainFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainFacility(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, ProductStore> chainFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FACILITY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("fao_facility_id", String.class) != null) {
                            p.getRelFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, ProductStore> chainParty(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, ProductStore> chainParty(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pao_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthority.class, prefix = "vtao")
        default Map<String, ProductStore> chainVatTaxAuthority(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainVatTaxAuthority(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthority.class, prefix = "vtao")
        default Map<String, ProductStore> chainVatTaxAuthority(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(VAT_TAX_AUTHORITY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("vtao_tax_auth_geo_id", String.class) != null) {
                            p.getRelVatTaxAuthority()
                                    .add(rr.getRow(TaxAuthority.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = CustRequest.class, prefix = "crm")
        default Map<String, ProductStore> chainCustRequest(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainCustRequest(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = CustRequest.class, prefix = "crm")
        default Map<String, ProductStore> chainCustRequest(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CUST_REQUEST);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("crm_product_store_id", String.class) != null) {
                            p.getRelCustRequest()
                                    .add(rr.getRow(CustRequest.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "eco")
        default Map<String, ProductStore> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainEbayConfig(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "eco")
        default Map<String, ProductStore> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(EBAY_CONFIG);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("eco_product_store_id", String.class) != null) {
                            p.getRelEbayConfig()
                                    .add(rr.getRow(EbayConfig.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "ohm")
        default Map<String, ProductStore> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainOrderHeader(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "ohm")
        default Map<String, ProductStore> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_HEADER);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("ohm_product_store_id", String.class) != null) {
                            p.getRelOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "prm")
        default Map<String, ProductStore> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductReview(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductReview.class, prefix = "prm")
        default Map<String, ProductStore> chainProductReview(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_REVIEW);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("prm_product_store_id", String.class) != null) {
                            p.getRelProductReview()
                                    .add(rr.getRow(ProductReview.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "pscm")
        default Map<String, ProductStore> chainProductStoreCatalog(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreCatalog(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "pscm")
        default Map<String, ProductStore> chainProductStoreCatalog(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_CATALOG);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pscm_product_store_id", String.class) != null) {
                            p.getRelProductStoreCatalog()
                                    .add(rr.getRow(ProductStoreCatalog.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreEmailSetting.class, prefix = "psesm")
        default Map<String, ProductStore> chainProductStoreEmailSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreEmailSetting(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreEmailSetting.class, prefix = "psesm")
        default Map<String, ProductStore> chainProductStoreEmailSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_EMAIL_SETTING);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psesm_product_store_id", String.class) != null) {
                            p.getRelProductStoreEmailSetting()
                                    .add(rr.getRow(ProductStoreEmailSetting.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psfm")
        default Map<String, ProductStore> chainProductStoreFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreFacility(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psfm")
        default Map<String, ProductStore> chainProductStoreFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_FACILITY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psfm_product_store_id", String.class) != null) {
                            p.getRelProductStoreFacility()
                                    .add(rr.getRow(ProductStoreFacility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFinActSetting.class, prefix = "psfasm")
        default Map<String, ProductStore> chainProductStoreFinActSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreFinActSetting(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreFinActSetting.class, prefix = "psfasm")
        default Map<String, ProductStore> chainProductStoreFinActSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_FIN_ACT_SETTING);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psfasm_product_store_id", String.class) != null) {
                            p.getRelProductStoreFinActSetting()
                                    .add(rr.getRow(ProductStoreFinActSetting.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreKeywordOvrd.class, prefix = "pskom")
        default Map<String, ProductStore> chainProductStoreKeywordOvrd(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreKeywordOvrd(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreKeywordOvrd.class, prefix = "pskom")
        default Map<String, ProductStore> chainProductStoreKeywordOvrd(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_KEYWORD_OVRD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pskom_product_store_id", String.class) != null) {
                            p.getRelProductStoreKeywordOvrd()
                                    .add(rr.getRow(ProductStoreKeywordOvrd.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePaymentSetting.class, prefix = "pspsm")
        default Map<String, ProductStore> chainProductStorePaymentSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStorePaymentSetting(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePaymentSetting.class, prefix = "pspsm")
        default Map<String, ProductStore> chainProductStorePaymentSetting(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_PAYMENT_SETTING);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pspsm_product_store_id", String.class) != null) {
                            p.getRelProductStorePaymentSetting()
                                    .add(rr.getRow(ProductStorePaymentSetting.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePromoAppl.class, prefix = "pspam")
        default Map<String, ProductStore> chainProductStorePromoAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStorePromoAppl(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStorePromoAppl.class, prefix = "pspam")
        default Map<String, ProductStore> chainProductStorePromoAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_PROMO_APPL);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pspam_product_store_id", String.class) != null) {
                            p.getRelProductStorePromoAppl()
                                    .add(rr.getRow(ProductStorePromoAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psrm")
        default Map<String, ProductStore> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreRole(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreRole.class, prefix = "psrm")
        default Map<String, ProductStore> chainProductStoreRole(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_ROLE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("psrm_product_store_id", String.class) != null) {
                            p.getRelProductStoreRole()
                                    .add(rr.getRow(ProductStoreRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssam")
        default Map<String, ProductStore> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainProductStoreSurveyAppl(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = ProductStoreSurveyAppl.class, prefix = "pssam")
        default Map<String, ProductStore> chainProductStoreSurveyAppl(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_SURVEY_APPL);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("pssam_product_store_id", String.class) != null) {
                            p.getRelProductStoreSurveyAppl()
                                    .add(rr.getRow(ProductStoreSurveyAppl.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Quote.class, prefix = "qum")
        default Map<String, ProductStore> chainQuote(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainQuote(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Quote.class, prefix = "qum")
        default Map<String, ProductStore> chainQuote(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(QUOTE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("qum_product_store_id", String.class) != null) {
                            p.getRelQuote()
                                    .add(rr.getRow(Quote.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarpm")
        default Map<String, ProductStore> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityRateProduct(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarpm")
        default Map<String, ProductStore> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_RATE_PRODUCT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("tarpm_product_store_id", String.class) != null) {
                            p.getRelTaxAuthorityRateProduct()
                                    .add(rr.getRow(TaxAuthorityRateProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = WebSite.class, prefix = "wsm")
        default Map<String, ProductStore> chainWebSite(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainWebSite(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = WebSite.class, prefix = "wsm")
        default Map<String, ProductStore> chainWebSite(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WEB_SITE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("wsm_product_store_id", String.class) != null) {
                            p.getRelWebSite()
                                    .add(rr.getRow(WebSite.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductStore> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductStore> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductStore> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStore", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStore p = map.computeIfAbsent(rr.getColumn("ps_product_store_id", String.class),
                                id -> rr.getRow(ProductStore.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
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
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> party(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> vatTaxAuthority(Dao dao, boolean succ) {
        return e -> dao.chainVatTaxAuthority(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> vatTaxAuthority(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainVatTaxAuthority(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> custRequest(Dao dao, boolean succ) {
        return e -> dao.chainCustRequest(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> custRequest(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCustRequest(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> ebayConfig(Dao dao, boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> ebayConfig(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> orderHeader(Dao dao, boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> orderHeader(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productReview(Dao dao, boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productReview(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductReview(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreCatalog(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreCatalog(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreCatalog(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreCatalog(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreEmailSetting(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreEmailSetting(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreEmailSetting(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreEmailSetting(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreFacility(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreFacility(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreFinActSetting(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreFinActSetting(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreFinActSetting(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreFinActSetting(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreKeywordOvrd(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreKeywordOvrd(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreKeywordOvrd(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreKeywordOvrd(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStorePaymentSetting(Dao dao, boolean succ) {
        return e -> dao.chainProductStorePaymentSetting(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStorePaymentSetting(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStorePaymentSetting(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStorePromoAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductStorePromoAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStorePromoAppl(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStorePromoAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreRole(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreRole(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> productStoreSurveyAppl(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> productStoreSurveyAppl(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreSurveyAppl(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> quote(Dao dao, boolean succ) {
        return e -> dao.chainQuote(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> quote(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainQuote(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> taxAuthorityRateProduct(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> taxAuthorityRateProduct(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> webSite(Dao dao, boolean succ) {
        return e -> dao.chainWebSite(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> webSite(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWebSite(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStore>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStore>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, ProductStore> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, ProductStore> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, ProductStore> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, ProductStore> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ProductStore>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(FACILITY)) {
            chain = chain.andThen(facility(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARTY)) {
            chain = chain.andThen(party(dao, whereClause, binds, true));
        }
         
        if (incls.contains(VAT_TAX_AUTHORITY)) {
            chain = chain.andThen(vatTaxAuthority(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CUST_REQUEST)) {
            chain = chain.andThen(custRequest(dao, whereClause, binds, true));
        }
         
        if (incls.contains(EBAY_CONFIG)) {
            chain = chain.andThen(ebayConfig(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_HEADER)) {
            chain = chain.andThen(orderHeader(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_REVIEW)) {
            chain = chain.andThen(productReview(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_CATALOG)) {
            chain = chain.andThen(productStoreCatalog(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_EMAIL_SETTING)) {
            chain = chain.andThen(productStoreEmailSetting(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_FACILITY)) {
            chain = chain.andThen(productStoreFacility(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_FIN_ACT_SETTING)) {
            chain = chain.andThen(productStoreFinActSetting(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_KEYWORD_OVRD)) {
            chain = chain.andThen(productStoreKeywordOvrd(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_PAYMENT_SETTING)) {
            chain = chain.andThen(productStorePaymentSetting(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_PROMO_APPL)) {
            chain = chain.andThen(productStorePromoAppl(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_ROLE)) {
            chain = chain.andThen(productStoreRole(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_SURVEY_APPL)) {
            chain = chain.andThen(productStoreSurveyAppl(dao, whereClause, binds, true));
        }
         
        if (incls.contains(QUOTE)) {
            chain = chain.andThen(quote(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TAX_AUTHORITY_RATE_PRODUCT)) {
            chain = chain.andThen(taxAuthorityRateProduct(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WEB_SITE)) {
            chain = chain.andThen(webSite(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProductStoreData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<ProductStoreData> responseObserver) {

        Map<String, ProductStore> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            ProductStoreData.Builder productStoreData = data.toHeadBuilder();
             
            data.getRelFacility().forEach(e -> 
                productStoreData.setFacility(e.toDataBuilder())); 
            data.getRelParty().forEach(e -> 
                productStoreData.setParty(e.toHeadBuilder())); 
            data.getRelVatTaxAuthority().forEach(e -> 
                productStoreData.setVatTaxAuthority(e.toDataBuilder())); 
            data.getRelCustRequest().forEach(e -> 
                productStoreData.addCustRequest(e.toDataBuilder())); 
            data.getRelEbayConfig().forEach(e -> 
                productStoreData.setEbayConfig(e.toDataBuilder())); 
            data.getRelOrderHeader().forEach(e -> 
                productStoreData.addOrderHeader(e.toHeadBuilder())); 
            data.getRelProductReview().forEach(e -> 
                productStoreData.addProductReview(e.toDataBuilder())); 
            data.getRelProductStoreCatalog().forEach(e -> 
                productStoreData.addProductStoreCatalog(e.toHeadBuilder())); 
            data.getRelProductStoreEmailSetting().forEach(e -> 
                productStoreData.addProductStoreEmailSetting(e.toDataBuilder())); 
            data.getRelProductStoreFacility().forEach(e -> 
                productStoreData.addProductStoreFacility(e.toHeadBuilder())); 
            data.getRelProductStoreFinActSetting().forEach(e -> 
                productStoreData.addProductStoreFinActSetting(e.toDataBuilder())); 
            data.getRelProductStoreKeywordOvrd().forEach(e -> 
                productStoreData.addProductStoreKeywordOvrd(e.toDataBuilder())); 
            data.getRelProductStorePaymentSetting().forEach(e -> 
                productStoreData.addProductStorePaymentSetting(e.toDataBuilder())); 
            data.getRelProductStorePromoAppl().forEach(e -> 
                productStoreData.addProductStorePromoAppl(e.toDataBuilder())); 
            data.getRelProductStoreRole().forEach(e -> 
                productStoreData.addProductStoreRole(e.toDataBuilder())); 
            data.getRelProductStoreSurveyAppl().forEach(e -> 
                productStoreData.addProductStoreSurveyAppl(e.toDataBuilder())); 
            data.getRelQuote().forEach(e -> 
                productStoreData.addQuote(e.toHeadBuilder())); 
            data.getRelTaxAuthorityRateProduct().forEach(e -> 
                productStoreData.addTaxAuthorityRateProduct(e.toDataBuilder())); 
            data.getRelWebSite().forEach(e -> 
                productStoreData.addWebSite(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                productStoreData.setTenant(e.toDataBuilder()));
            return productStoreData.build();
        }).forEach(e -> responseObserver.onNext(e));
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

    @Post("/product_stores")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(ProductStore productStore){
        return store(productStore, true);
    }

    public String store(ProductStore productStore, boolean genId){
        process(c ->{
            if(genId){
                productStore.setProductStoreId(sequence.nextStringId());
            }
            storeOrUpdate(c, productStore.toData());
        });
        return productStore.getProductStoreId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "ProductStore", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
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
         
        public List<Tenant> getTenant(){
            return getRelationValues(ctx, p1, "tenant", Tenant.class);
        }

        public List<Tenant> mergeTenant(){
            return getTenant().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTenant().add(c))
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
         
    public static final String TENANT="tenant";
    

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
                                               
                        // add/set tenant to head entity                        
                        if(relationsDemand.contains("tenant")) {
                            getRelationValues(ctx, p1, "tenant",
                                            Tenant.class)
                                    .forEach(el -> pb.setTenant(
                                             el.toDataBuilder().build()));
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
