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
import com.linecorp.armeria.server.annotation.*;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
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

import com.bluecc.hubs.stub.OrderHeaderData;

public class OrderHeaderDelegator extends AbstractProcs implements IChainQuery<OrderHeader>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(OrderHeader.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from order_header")
        List<OrderHeader> listOrderHeader();
        @SqlQuery("select * from order_header where order_id=:id")
        OrderHeader getOrderHeader(@Bind("id") String id);

        @SqlQuery("select count(*) from order_header")
        int countOrderHeader();

        // for relations
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = Facility.class, prefix = "ofzo")
        default Map<String, OrderHeader> chainOriginFacility(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOriginFacility(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = Facility.class, prefix = "ofzo")
        default Map<String, OrderHeader> chainOriginFacility(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORIGIN_FACILITY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("ofzo_facility_id", String.class) != null) {
                            p.getRelOriginFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "bao")
        default Map<String, OrderHeader> chainBillingAccount(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainBillingAccount(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "bao")
        default Map<String, OrderHeader> chainBillingAccount(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(BILLING_ACCOUNT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("bao_billing_account_id", String.class) != null) {
                            p.getRelBillingAccount()
                                    .add(rr.getRow(BillingAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, OrderHeader> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, OrderHeader> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("pso_product_store_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbulo")
        default Map<String, OrderHeader> chainCreatedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainCreatedByUserLogin(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbulo")
        default Map<String, OrderHeader> chainCreatedByUserLogin(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREATED_BY_USER_LOGIN);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("cbulo_user_login_id", String.class) != null) {
                            p.getRelCreatedByUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = WebSite.class, prefix = "wso")
        default Map<String, OrderHeader> chainWebSite(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainWebSite(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = WebSite.class, prefix = "wso")
        default Map<String, OrderHeader> chainWebSite(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WEB_SITE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("wso_web_site_id", String.class) != null) {
                            p.getRelWebSite()
                                    .add(rr.getRow(WebSite.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "afam")
        default Map<String, OrderHeader> chainAcquireFixedAsset(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainAcquireFixedAsset(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "afam")
        default Map<String, OrderHeader> chainAcquireFixedAsset(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACQUIRE_FIXED_ASSET);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("afam_acquire_order_id", String.class) != null) {
                            p.getRelAcquireFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, OrderHeader> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainItemIssuance(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, OrderHeader> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ITEM_ISSUANCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("iim_order_id", String.class) != null) {
                            p.getRelItemIssuance()
                                    .add(rr.getRow(ItemIssuance.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oam")
        default Map<String, OrderHeader> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderAdjustment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oam")
        default Map<String, OrderHeader> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ADJUSTMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oam_order_id", String.class) != null) {
                            p.getRelOrderAdjustment()
                                    .add(rr.getRow(OrderAdjustment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderContactMech.class, prefix = "ocmm")
        default Map<String, OrderHeader> chainOrderContactMech(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderContactMech(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderContactMech.class, prefix = "ocmm")
        default Map<String, OrderHeader> chainOrderContactMech(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_CONTACT_MECH);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("ocmm_order_id", String.class) != null) {
                            p.getRelOrderContactMech()
                                    .add(rr.getRow(OrderContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oim")
        default Map<String, OrderHeader> chainOrderItem(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oim")
        default Map<String, OrderHeader> chainOrderItem(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oim_order_id", String.class) != null) {
                            p.getRelOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oibm")
        default Map<String, OrderHeader> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderItemBilling(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oibm")
        default Map<String, OrderHeader> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_BILLING);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oibm_order_id", String.class) != null) {
                            p.getRelOrderItemBilling()
                                    .add(rr.getRow(OrderItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemPriceInfo.class, prefix = "oipim")
        default Map<String, OrderHeader> chainOrderItemPriceInfo(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderItemPriceInfo(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemPriceInfo.class, prefix = "oipim")
        default Map<String, OrderHeader> chainOrderItemPriceInfo(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_PRICE_INFO);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oipim_order_id", String.class) != null) {
                            p.getRelOrderItemPriceInfo()
                                    .add(rr.getRow(OrderItemPriceInfo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "oisgm")
        default Map<String, OrderHeader> chainOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderItemShipGroup(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemShipGroup.class, prefix = "oisgm")
        default Map<String, OrderHeader> chainOrderItemShipGroup(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_SHIP_GROUP);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oisgm_order_id", String.class) != null) {
                            p.getRelOrderItemShipGroup()
                                    .add(rr.getRow(OrderItemShipGroup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemShipGroupAssoc.class, prefix = "oisgam")
        default Map<String, OrderHeader> chainOrderItemShipGroupAssoc(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderItemShipGroupAssoc(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemShipGroupAssoc.class, prefix = "oisgam")
        default Map<String, OrderHeader> chainOrderItemShipGroupAssoc(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_SHIP_GROUP_ASSOC);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oisgam_order_id", String.class) != null) {
                            p.getRelOrderItemShipGroupAssoc()
                                    .add(rr.getRow(OrderItemShipGroupAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemShipGrpInvRes.class, prefix = "oisgirm")
        default Map<String, OrderHeader> chainOrderItemShipGrpInvRes(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderItemShipGrpInvRes(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderItemShipGrpInvRes.class, prefix = "oisgirm")
        default Map<String, OrderHeader> chainOrderItemShipGrpInvRes(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_SHIP_GRP_INV_RES);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oisgirm_order_id", String.class) != null) {
                            p.getRelOrderItemShipGrpInvRes()
                                    .add(rr.getRow(OrderItemShipGrpInvRes.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, OrderHeader> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderPaymentPreference(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, OrderHeader> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_PAYMENT_PREFERENCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("oppm_order_id", String.class) != null) {
                            p.getRelOrderPaymentPreference()
                                    .add(rr.getRow(OrderPaymentPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderRole.class, prefix = "orzm")
        default Map<String, OrderHeader> chainOrderRole(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderRole(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderRole.class, prefix = "orzm")
        default Map<String, OrderHeader> chainOrderRole(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ROLE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("orzm_order_id", String.class) != null) {
                            p.getRelOrderRole()
                                    .add(rr.getRow(OrderRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "osm")
        default Map<String, OrderHeader> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainOrderStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "osm")
        default Map<String, OrderHeader> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("osm_order_id", String.class) != null) {
                            p.getRelOrderStatus()
                                    .add(rr.getRow(OrderStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = Shipment.class, prefix = "psm")
        default Map<String, OrderHeader> chainPrimaryShipment(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainPrimaryShipment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = Shipment.class, prefix = "psm")
        default Map<String, OrderHeader> chainPrimaryShipment(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRIMARY_SHIPMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("psm_primary_order_id", String.class) != null) {
                            p.getRelPrimaryShipment()
                                    .add(rr.getRow(Shipment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, OrderHeader> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainShipmentReceipt(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, OrderHeader> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_RECEIPT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("srm_order_id", String.class) != null) {
                            p.getRelShipmentReceipt()
                                    .add(rr.getRow(ShipmentReceipt.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, OrderHeader> chainTenant(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, OrderHeader> chainTenant(ProtoMeta protoMeta,
                                               Map<String, OrderHeader> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderHeader", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderHeader p = map.computeIfAbsent(rr.getColumn("oh_order_id", String.class),
                                id -> rr.getRow(OrderHeader.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, OrderHeader>> originFacility(Dao dao, boolean succ) {
        return e -> dao.chainOriginFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> originFacility(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOriginFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> billingAccount(Dao dao, boolean succ) {
        return e -> dao.chainBillingAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> billingAccount(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainBillingAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> productStore(Dao dao, boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> productStore(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> createdByUserLogin(Dao dao, boolean succ) {
        return e -> dao.chainCreatedByUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> createdByUserLogin(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreatedByUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> webSite(Dao dao, boolean succ) {
        return e -> dao.chainWebSite(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> webSite(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWebSite(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> acquireFixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainAcquireFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> acquireFixedAsset(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAcquireFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> itemIssuance(Dao dao, boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> itemIssuance(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderAdjustment(Dao dao, boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderAdjustment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderContactMech(Dao dao, boolean succ) {
        return e -> dao.chainOrderContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderContactMech(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderItem(Dao dao, boolean succ) {
        return e -> dao.chainOrderItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderItemBilling(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderItemPriceInfo(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemPriceInfo(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderItemPriceInfo(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemPriceInfo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderItemShipGroup(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemShipGroup(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderItemShipGroup(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemShipGroup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderItemShipGroupAssoc(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemShipGroupAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderItemShipGroupAssoc(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemShipGroupAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderItemShipGrpInvRes(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemShipGrpInvRes(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderItemShipGrpInvRes(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemShipGrpInvRes(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderPaymentPreference(Dao dao, boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderPaymentPreference(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderRole(Dao dao, boolean succ) {
        return e -> dao.chainOrderRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderRole(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> orderStatus(Dao dao, boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> orderStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> primaryShipment(Dao dao, boolean succ) {
        return e -> dao.chainPrimaryShipment(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> primaryShipment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPrimaryShipment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> shipmentReceipt(Dao dao, boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> shipmentReceipt(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderHeader>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderHeader>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, OrderHeader> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, OrderHeader> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, OrderHeader> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, OrderHeader> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, OrderHeader>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(ORIGIN_FACILITY)) {
            chain = chain.andThen(originFacility(dao, whereClause, binds, true));
        }
         
        if (incls.contains(BILLING_ACCOUNT)) {
            chain = chain.andThen(billingAccount(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE)) {
            chain = chain.andThen(productStore(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREATED_BY_USER_LOGIN)) {
            chain = chain.andThen(createdByUserLogin(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WEB_SITE)) {
            chain = chain.andThen(webSite(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ACQUIRE_FIXED_ASSET)) {
            chain = chain.andThen(acquireFixedAsset(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ITEM_ISSUANCE)) {
            chain = chain.andThen(itemIssuance(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ADJUSTMENT)) {
            chain = chain.andThen(orderAdjustment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_CONTACT_MECH)) {
            chain = chain.andThen(orderContactMech(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM)) {
            chain = chain.andThen(orderItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM_BILLING)) {
            chain = chain.andThen(orderItemBilling(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM_PRICE_INFO)) {
            chain = chain.andThen(orderItemPriceInfo(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM_SHIP_GROUP)) {
            chain = chain.andThen(orderItemShipGroup(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM_SHIP_GROUP_ASSOC)) {
            chain = chain.andThen(orderItemShipGroupAssoc(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM_SHIP_GRP_INV_RES)) {
            chain = chain.andThen(orderItemShipGrpInvRes(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_PAYMENT_PREFERENCE)) {
            chain = chain.andThen(orderPaymentPreference(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ROLE)) {
            chain = chain.andThen(orderRole(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_STATUS)) {
            chain = chain.andThen(orderStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRIMARY_SHIPMENT)) {
            chain = chain.andThen(primaryShipment(dao, whereClause, binds, true));
        }
         
        if (incls.contains(SHIPMENT_RECEIPT)) {
            chain = chain.andThen(shipmentReceipt(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<OrderHeaderData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<OrderHeaderData> responseObserver) {

        Map<String, OrderHeader> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            OrderHeaderData.Builder orderHeaderData = data.toHeadBuilder();
             
            data.getRelOriginFacility().forEach(e -> 
                orderHeaderData.setOriginFacility(e.toDataBuilder())); 
            data.getRelBillingAccount().forEach(e -> 
                orderHeaderData.setBillingAccount(e.toHeadBuilder())); 
            data.getRelProductStore().forEach(e -> 
                orderHeaderData.setProductStore(e.toHeadBuilder())); 
            data.getRelCreatedByUserLogin().forEach(e -> 
                orderHeaderData.setCreatedByUserLogin(e.toHeadBuilder())); 
            data.getRelWebSite().forEach(e -> 
                orderHeaderData.setWebSite(e.toHeadBuilder())); 
            data.getRelAcquireFixedAsset().forEach(e -> 
                orderHeaderData.addAcquireFixedAsset(e.toHeadBuilder())); 
            data.getRelItemIssuance().forEach(e -> 
                orderHeaderData.addItemIssuance(e.toDataBuilder())); 
            data.getRelOrderAdjustment().forEach(e -> 
                orderHeaderData.addOrderAdjustment(e.toDataBuilder())); 
            data.getRelOrderContactMech().forEach(e -> 
                orderHeaderData.addOrderContactMech(e.toDataBuilder())); 
            data.getRelOrderItem().forEach(e -> 
                orderHeaderData.addOrderItem(e.toHeadBuilder())); 
            data.getRelOrderItemBilling().forEach(e -> 
                orderHeaderData.addOrderItemBilling(e.toDataBuilder())); 
            data.getRelOrderItemPriceInfo().forEach(e -> 
                orderHeaderData.addOrderItemPriceInfo(e.toDataBuilder())); 
            data.getRelOrderItemShipGroup().forEach(e -> 
                orderHeaderData.addOrderItemShipGroup(e.toDataBuilder())); 
            data.getRelOrderItemShipGroupAssoc().forEach(e -> 
                orderHeaderData.addOrderItemShipGroupAssoc(e.toDataBuilder())); 
            data.getRelOrderItemShipGrpInvRes().forEach(e -> 
                orderHeaderData.addOrderItemShipGrpInvRes(e.toDataBuilder())); 
            data.getRelOrderPaymentPreference().forEach(e -> 
                orderHeaderData.addOrderPaymentPreference(e.toDataBuilder())); 
            data.getRelOrderRole().forEach(e -> 
                orderHeaderData.addOrderRole(e.toDataBuilder())); 
            data.getRelOrderStatus().forEach(e -> 
                orderHeaderData.addOrderStatus(e.toDataBuilder())); 
            data.getRelPrimaryShipment().forEach(e -> 
                orderHeaderData.addPrimaryShipment(e.toHeadBuilder())); 
            data.getRelShipmentReceipt().forEach(e -> 
                orderHeaderData.addShipmentReceipt(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                orderHeaderData.setTenant(e.toDataBuilder()));
            return orderHeaderData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public OrderHeader get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getOrderHeader(id);
    }

    @Get("/order_headers/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public OrderHeader get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<OrderHeader> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listOrderHeader();
    }

    @Get("/order_headers")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<OrderHeader> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countOrderHeader();
    }

    @Get("/order_headers/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/order_headers")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(OrderHeader orderHeader){
        return store(orderHeader, true);
    }

    @Put("/order_headers")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(OrderHeader orderHeader){
        return store(orderHeader, false);
    }

    public String store(OrderHeader orderHeader, boolean genId){
        process(c ->{
            if(genId){
                orderHeader.setOrderId(sequence.nextStringId());
            }
            storeOrUpdate(c, orderHeader.toData());
        });
        return orderHeader.getOrderId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "OrderHeader", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final OrderHeader rec;
        final Message p1;
        OrderHeader persistObject;

        Agent(IProc.ProcContext ctx, OrderHeader rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public OrderHeader getRecord(){
            return rec;
        }

        public OrderHeader merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<Facility> getOriginFacility(){
            return getRelationValues(ctx, p1, "origin_facility", Facility.class);
        }

        public List<Facility> mergeOriginFacility(){
            return getOriginFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOriginFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<BillingAccount> getBillingAccount(){
            return getRelationValues(ctx, p1, "billing_account", BillingAccount.class);
        }

        public List<BillingAccount> mergeBillingAccount(){
            return getBillingAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelBillingAccount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStore> getProductStore(){
            return getRelationValues(ctx, p1, "product_store", ProductStore.class);
        }

        public List<ProductStore> mergeProductStore(){
            return getProductStore().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStore().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getCreatedByUserLogin(){
            return getRelationValues(ctx, p1, "created_by_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeCreatedByUserLogin(){
            return getCreatedByUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreatedByUserLogin().add(c))
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
         
        public List<FixedAsset> getAcquireFixedAsset(){
            return getRelationValues(ctx, p1, "acquire_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeAcquireFixedAsset(){
            return getAcquireFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcquireFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ItemIssuance> getItemIssuance(){
            return getRelationValues(ctx, p1, "item_issuance", ItemIssuance.class);
        }

        public List<ItemIssuance> mergeItemIssuance(){
            return getItemIssuance().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelItemIssuance().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderAdjustment> getOrderAdjustment(){
            return getRelationValues(ctx, p1, "order_adjustment", OrderAdjustment.class);
        }

        public List<OrderAdjustment> mergeOrderAdjustment(){
            return getOrderAdjustment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderAdjustment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderContactMech> getOrderContactMech(){
            return getRelationValues(ctx, p1, "order_contact_mech", OrderContactMech.class);
        }

        public List<OrderContactMech> mergeOrderContactMech(){
            return getOrderContactMech().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderContactMech().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItem> getOrderItem(){
            return getRelationValues(ctx, p1, "order_item", OrderItem.class);
        }

        public List<OrderItem> mergeOrderItem(){
            return getOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemBilling> getOrderItemBilling(){
            return getRelationValues(ctx, p1, "order_item_billing", OrderItemBilling.class);
        }

        public List<OrderItemBilling> mergeOrderItemBilling(){
            return getOrderItemBilling().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemBilling().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemPriceInfo> getOrderItemPriceInfo(){
            return getRelationValues(ctx, p1, "order_item_price_info", OrderItemPriceInfo.class);
        }

        public List<OrderItemPriceInfo> mergeOrderItemPriceInfo(){
            return getOrderItemPriceInfo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemPriceInfo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGroup> getOrderItemShipGroup(){
            return getRelationValues(ctx, p1, "order_item_ship_group", OrderItemShipGroup.class);
        }

        public List<OrderItemShipGroup> mergeOrderItemShipGroup(){
            return getOrderItemShipGroup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemShipGroup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGroupAssoc> getOrderItemShipGroupAssoc(){
            return getRelationValues(ctx, p1, "order_item_ship_group_assoc", OrderItemShipGroupAssoc.class);
        }

        public List<OrderItemShipGroupAssoc> mergeOrderItemShipGroupAssoc(){
            return getOrderItemShipGroupAssoc().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemShipGroupAssoc().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderItemShipGrpInvRes> getOrderItemShipGrpInvRes(){
            return getRelationValues(ctx, p1, "order_item_ship_grp_inv_res", OrderItemShipGrpInvRes.class);
        }

        public List<OrderItemShipGrpInvRes> mergeOrderItemShipGrpInvRes(){
            return getOrderItemShipGrpInvRes().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderItemShipGrpInvRes().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderPaymentPreference> getOrderPaymentPreference(){
            return getRelationValues(ctx, p1, "order_payment_preference", OrderPaymentPreference.class);
        }

        public List<OrderPaymentPreference> mergeOrderPaymentPreference(){
            return getOrderPaymentPreference().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderPaymentPreference().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderRole> getOrderRole(){
            return getRelationValues(ctx, p1, "order_role", OrderRole.class);
        }

        public List<OrderRole> mergeOrderRole(){
            return getOrderRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderStatus> getOrderStatus(){
            return getRelationValues(ctx, p1, "order_status", OrderStatus.class);
        }

        public List<OrderStatus> mergeOrderStatus(){
            return getOrderStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Shipment> getPrimaryShipment(){
            return getRelationValues(ctx, p1, "primary_shipment", Shipment.class);
        }

        public List<Shipment> mergePrimaryShipment(){
            return getPrimaryShipment().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPrimaryShipment().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentReceipt> getShipmentReceipt(){
            return getRelationValues(ctx, p1, "shipment_receipt", ShipmentReceipt.class);
        }

        public List<ShipmentReceipt> mergeShipmentReceipt(){
            return getShipmentReceipt().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentReceipt().add(c))
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
        OrderHeaderData p = OrderHeaderData.newBuilder()
                .setOrderId(key)
                .build();
        OrderHeader rec = findOne(ctx, p, OrderHeader.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, OrderHeader rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String ORIGIN_FACILITY="origin_facility";
         
    public static final String BILLING_ACCOUNT="billing_account";
         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String CREATED_BY_USER_LOGIN="created_by_user_login";
         
    public static final String WEB_SITE="web_site";
         
    public static final String ACQUIRE_FIXED_ASSET="acquire_fixed_asset";
         
    public static final String ITEM_ISSUANCE="item_issuance";
         
    public static final String ORDER_ADJUSTMENT="order_adjustment";
         
    public static final String ORDER_CONTACT_MECH="order_contact_mech";
         
    public static final String ORDER_ITEM="order_item";
         
    public static final String ORDER_ITEM_BILLING="order_item_billing";
         
    public static final String ORDER_ITEM_PRICE_INFO="order_item_price_info";
         
    public static final String ORDER_ITEM_SHIP_GROUP="order_item_ship_group";
         
    public static final String ORDER_ITEM_SHIP_GROUP_ASSOC="order_item_ship_group_assoc";
         
    public static final String ORDER_ITEM_SHIP_GRP_INV_RES="order_item_ship_grp_inv_res";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String ORDER_ROLE="order_role";
         
    public static final String ORDER_STATUS="order_status";
         
    public static final String PRIMARY_SHIPMENT="primary_shipment";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryOrderHeaderRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            OrderHeaderData p = OrderHeaderData.newBuilder()
                    .setOrderId(key)
                    .build();
            List<OrderHeaderData.Builder> ds = find(ctx, p, OrderHeader.class).stream()
                    .map(e -> {
                        OrderHeaderData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set origin_facility to head entity                        
                        if(relationsDemand.contains("origin_facility")) {
                            getRelationValues(ctx, p1, "origin_facility",
                                            Facility.class)
                                    .forEach(el -> pb.setOriginFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set billing_account to head entity                        
                        if(relationsDemand.contains("billing_account")) {
                            getRelationValues(ctx, p1, "billing_account",
                                            BillingAccount.class)
                                    .forEach(el -> pb.setBillingAccount(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set created_by_user_login to head entity                        
                        if(relationsDemand.contains("created_by_user_login")) {
                            getRelationValues(ctx, p1, "created_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setCreatedByUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set web_site to head entity                        
                        if(relationsDemand.contains("web_site")) {
                            getRelationValues(ctx, p1, "web_site",
                                            WebSite.class)
                                    .forEach(el -> pb.setWebSite(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set acquire_fixed_asset to head entity                        
                        if(relationsDemand.contains("acquire_fixed_asset")) {
                            getRelationValues(ctx, p1, "acquire_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.addAcquireFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set item_issuance to head entity                        
                        if(relationsDemand.contains("item_issuance")) {
                            getRelationValues(ctx, p1, "item_issuance",
                                            ItemIssuance.class)
                                    .forEach(el -> pb.addItemIssuance(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_adjustment to head entity                        
                        if(relationsDemand.contains("order_adjustment")) {
                            getRelationValues(ctx, p1, "order_adjustment",
                                            OrderAdjustment.class)
                                    .forEach(el -> pb.addOrderAdjustment(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_contact_mech to head entity                        
                        if(relationsDemand.contains("order_contact_mech")) {
                            getRelationValues(ctx, p1, "order_contact_mech",
                                            OrderContactMech.class)
                                    .forEach(el -> pb.addOrderContactMech(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item to head entity                        
                        if(relationsDemand.contains("order_item")) {
                            getRelationValues(ctx, p1, "order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_item_billing to head entity                        
                        if(relationsDemand.contains("order_item_billing")) {
                            getRelationValues(ctx, p1, "order_item_billing",
                                            OrderItemBilling.class)
                                    .forEach(el -> pb.addOrderItemBilling(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_price_info to head entity                        
                        if(relationsDemand.contains("order_item_price_info")) {
                            getRelationValues(ctx, p1, "order_item_price_info",
                                            OrderItemPriceInfo.class)
                                    .forEach(el -> pb.addOrderItemPriceInfo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_ship_group to head entity                        
                        if(relationsDemand.contains("order_item_ship_group")) {
                            getRelationValues(ctx, p1, "order_item_ship_group",
                                            OrderItemShipGroup.class)
                                    .forEach(el -> pb.addOrderItemShipGroup(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_ship_group_assoc to head entity                        
                        if(relationsDemand.contains("order_item_ship_group_assoc")) {
                            getRelationValues(ctx, p1, "order_item_ship_group_assoc",
                                            OrderItemShipGroupAssoc.class)
                                    .forEach(el -> pb.addOrderItemShipGroupAssoc(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_ship_grp_inv_res to head entity                        
                        if(relationsDemand.contains("order_item_ship_grp_inv_res")) {
                            getRelationValues(ctx, p1, "order_item_ship_grp_inv_res",
                                            OrderItemShipGrpInvRes.class)
                                    .forEach(el -> pb.addOrderItemShipGrpInvRes(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_payment_preference to head entity                        
                        if(relationsDemand.contains("order_payment_preference")) {
                            getRelationValues(ctx, p1, "order_payment_preference",
                                            OrderPaymentPreference.class)
                                    .forEach(el -> pb.addOrderPaymentPreference(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_role to head entity                        
                        if(relationsDemand.contains("order_role")) {
                            getRelationValues(ctx, p1, "order_role",
                                            OrderRole.class)
                                    .forEach(el -> pb.addOrderRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_status to head entity                        
                        if(relationsDemand.contains("order_status")) {
                            getRelationValues(ctx, p1, "order_status",
                                            OrderStatus.class)
                                    .forEach(el -> pb.addOrderStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set primary_shipment to head entity                        
                        if(relationsDemand.contains("primary_shipment")) {
                            getRelationValues(ctx, p1, "primary_shipment",
                                            Shipment.class)
                                    .forEach(el -> pb.addPrimaryShipment(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set shipment_receipt to head entity                        
                        if(relationsDemand.contains("shipment_receipt")) {
                            getRelationValues(ctx, p1, "shipment_receipt",
                                            ShipmentReceipt.class)
                                    .forEach(el -> pb.addShipmentReceipt(
                                             el.toDataBuilder().build()));
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


    
    public OrderHeader.OrderHeaderBuilder seed(){
        return OrderHeader.builder()
                .orderId(sequence.nextStringId());
    }
}
