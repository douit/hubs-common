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

import com.bluecc.hubs.stub.OrderItemData;

public class OrderItemDelegator extends AbstractProcs implements IChainQuery<OrderItem>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(OrderItem.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from order_item")
        List<OrderItem> listOrderItem();
        @SqlQuery("select * from order_item where id=:id")
        OrderItem getOrderItem(@Bind("id") String id);

        @SqlQuery("select count(*) from order_item")
        int countOrderItem();

        // for relations
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oho")
        default Map<String, OrderItem> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderHeader(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oho")
        default Map<String, OrderItem> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_HEADER);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("oho_order_id", String.class) != null) {
                            p.getRelOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = Product.class, prefix = "pro")
        default Map<String, OrderItem> chainProduct(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainProduct(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = Product.class, prefix = "pro")
        default Map<String, OrderItem> chainProduct(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("pro_product_id", String.class) != null) {
                            p.getRelProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "fiio")
        default Map<String, OrderItem> chainFromInventoryItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainFromInventoryItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "fiio")
        default Map<String, OrderItem> chainFromInventoryItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_INVENTORY_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("fiio_inventory_item_id", String.class) != null) {
                            p.getRelFromInventoryItem()
                                    .add(rr.getRow(InventoryItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ProductFacilityLocation.class, prefix = "pflm")
        default Map<String, OrderItem> chainProductFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainProductFacilityLocation(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ProductFacilityLocation.class, prefix = "pflm")
        default Map<String, OrderItem> chainProductFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FACILITY_LOCATION);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("pflm_product_id", String.class) != null) {
                            p.getRelProductFacilityLocation()
                                    .add(rr.getRow(ProductFacilityLocation.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "dcsulo")
        default Map<String, OrderItem> chainDontCancelSetUserLogin(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainDontCancelSetUserLogin(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "dcsulo")
        default Map<String, OrderItem> chainDontCancelSetUserLogin(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(DONT_CANCEL_SET_USER_LOGIN);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("dcsulo_user_login_id", String.class) != null) {
                            p.getRelDontCancelSetUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = QuoteItem.class, prefix = "qio")
        default Map<String, OrderItem> chainQuoteItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainQuoteItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = QuoteItem.class, prefix = "qio")
        default Map<String, OrderItem> chainQuoteItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(QUOTE_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("qio_quote_id", String.class) != null) {
                            p.getRelQuoteItem()
                                    .add(rr.getRow(QuoteItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ShoppingListItem.class, prefix = "slio")
        default Map<String, OrderItem> chainShoppingListItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainShoppingListItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ShoppingListItem.class, prefix = "slio")
        default Map<String, OrderItem> chainShoppingListItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHOPPING_LIST_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("slio_shopping_list_id", String.class) != null) {
                            p.getRelShoppingListItem()
                                    .add(rr.getRow(ShoppingListItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "ogao")
        default Map<String, OrderItem> chainOverrideGlAccount(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOverrideGlAccount(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "ogao")
        default Map<String, OrderItem> chainOverrideGlAccount(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OVERRIDE_GL_ACCOUNT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("ogao_gl_account_id", String.class) != null) {
                            p.getRelOverrideGlAccount()
                                    .add(rr.getRow(GlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbulo")
        default Map<String, OrderItem> chainChangeByUserLogin(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainChangeByUserLogin(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = UserLogin.class, prefix = "cbulo")
        default Map<String, OrderItem> chainChangeByUserLogin(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHANGE_BY_USER_LOGIN);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("cbulo_user_login_id", String.class) != null) {
                            p.getRelChangeByUserLogin()
                                    .add(rr.getRow(UserLogin.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fatm")
        default Map<String, OrderItem> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainFinAccountTrans(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fatm")
        default Map<String, OrderItem> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_TRANS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("fatm_order_id", String.class) != null) {
                            p.getRelFinAccountTrans()
                                    .add(rr.getRow(FinAccountTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "afam")
        default Map<String, OrderItem> chainAcquireFixedAsset(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainAcquireFixedAsset(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "afam")
        default Map<String, OrderItem> chainAcquireFixedAsset(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACQUIRE_FIXED_ASSET);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("afam_acquire_order_id", String.class) != null) {
                            p.getRelAcquireFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, OrderItem> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainItemIssuance(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, OrderItem> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ITEM_ISSUANCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("iim_order_id", String.class) != null) {
                            p.getRelItemIssuance()
                                    .add(rr.getRow(ItemIssuance.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oam")
        default Map<String, OrderItem> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderAdjustment(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderAdjustment.class, prefix = "oam")
        default Map<String, OrderItem> chainOrderAdjustment(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ADJUSTMENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("oam_order_id", String.class) != null) {
                            p.getRelOrderAdjustment()
                                    .add(rr.getRow(OrderAdjustment.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oibm")
        default Map<String, OrderItem> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderItemBilling(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oibm")
        default Map<String, OrderItem> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_BILLING);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("oibm_order_id", String.class) != null) {
                            p.getRelOrderItemBilling()
                                    .add(rr.getRow(OrderItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemPriceInfo.class, prefix = "oipim")
        default Map<String, OrderItem> chainOrderItemPriceInfo(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderItemPriceInfo(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemPriceInfo.class, prefix = "oipim")
        default Map<String, OrderItem> chainOrderItemPriceInfo(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_PRICE_INFO);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("oipim_order_id", String.class) != null) {
                            p.getRelOrderItemPriceInfo()
                                    .add(rr.getRow(OrderItemPriceInfo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemShipGroupAssoc.class, prefix = "oisgam")
        default Map<String, OrderItem> chainOrderItemShipGroupAssoc(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderItemShipGroupAssoc(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemShipGroupAssoc.class, prefix = "oisgam")
        default Map<String, OrderItem> chainOrderItemShipGroupAssoc(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_SHIP_GROUP_ASSOC);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("oisgam_order_id", String.class) != null) {
                            p.getRelOrderItemShipGroupAssoc()
                                    .add(rr.getRow(OrderItemShipGroupAssoc.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemShipGrpInvRes.class, prefix = "oisgirm")
        default Map<String, OrderItem> chainOrderItemShipGrpInvRes(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderItemShipGrpInvRes(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderItemShipGrpInvRes.class, prefix = "oisgirm")
        default Map<String, OrderItem> chainOrderItemShipGrpInvRes(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_SHIP_GRP_INV_RES);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("oisgirm_order_id", String.class) != null) {
                            p.getRelOrderItemShipGrpInvRes()
                                    .add(rr.getRow(OrderItemShipGrpInvRes.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, OrderItem> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderPaymentPreference(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, OrderItem> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_PAYMENT_PREFERENCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("oppm_order_id", String.class) != null) {
                            p.getRelOrderPaymentPreference()
                                    .add(rr.getRow(OrderPaymentPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "osm")
        default Map<String, OrderItem> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainOrderStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = OrderStatus.class, prefix = "osm")
        default Map<String, OrderItem> chainOrderStatus(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("osm_order_id", String.class) != null) {
                            p.getRelOrderStatus()
                                    .add(rr.getRow(OrderStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ReturnItem.class, prefix = "rim")
        default Map<String, OrderItem> chainReturnItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainReturnItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ReturnItem.class, prefix = "rim")
        default Map<String, OrderItem> chainReturnItem(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(RETURN_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("rim_order_id", String.class) != null) {
                            p.getRelReturnItem()
                                    .add(rr.getRow(ReturnItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, OrderItem> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainShipmentReceipt(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, OrderItem> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_RECEIPT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("srm_order_id", String.class) != null) {
                            p.getRelShipmentReceipt()
                                    .add(rr.getRow(ShipmentReceipt.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, OrderItem> chainTenant(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = OrderItem.class, prefix = "oi")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, OrderItem> chainTenant(ProtoMeta protoMeta,
                                               Map<String, OrderItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("OrderItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        OrderItem p = map.computeIfAbsent(rr.getColumn("oi_id", String.class),
                                id -> rr.getRow(OrderItem.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, OrderItem>> orderHeader(Dao dao, boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderHeader(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> product(Dao dao, boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> product(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> fromInventoryItem(Dao dao, boolean succ) {
        return e -> dao.chainFromInventoryItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> fromInventoryItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFromInventoryItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> productFacilityLocation(Dao dao, boolean succ) {
        return e -> dao.chainProductFacilityLocation(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> productFacilityLocation(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductFacilityLocation(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> dontCancelSetUserLogin(Dao dao, boolean succ) {
        return e -> dao.chainDontCancelSetUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> dontCancelSetUserLogin(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainDontCancelSetUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> quoteItem(Dao dao, boolean succ) {
        return e -> dao.chainQuoteItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> quoteItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainQuoteItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> shoppingListItem(Dao dao, boolean succ) {
        return e -> dao.chainShoppingListItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> shoppingListItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainShoppingListItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> overrideGlAccount(Dao dao, boolean succ) {
        return e -> dao.chainOverrideGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> overrideGlAccount(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOverrideGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> changeByUserLogin(Dao dao, boolean succ) {
        return e -> dao.chainChangeByUserLogin(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> changeByUserLogin(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChangeByUserLogin(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> finAccountTrans(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> finAccountTrans(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> acquireFixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainAcquireFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> acquireFixedAsset(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAcquireFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> itemIssuance(Dao dao, boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> itemIssuance(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> orderAdjustment(Dao dao, boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderAdjustment(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderAdjustment(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> orderItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderItemBilling(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> orderItemPriceInfo(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemPriceInfo(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderItemPriceInfo(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemPriceInfo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> orderItemShipGroupAssoc(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemShipGroupAssoc(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderItemShipGroupAssoc(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemShipGroupAssoc(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> orderItemShipGrpInvRes(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemShipGrpInvRes(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderItemShipGrpInvRes(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemShipGrpInvRes(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> orderPaymentPreference(Dao dao, boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderPaymentPreference(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> orderStatus(Dao dao, boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> orderStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> returnItem(Dao dao, boolean succ) {
        return e -> dao.chainReturnItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> returnItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainReturnItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> shipmentReceipt(Dao dao, boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> shipmentReceipt(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, OrderItem>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, OrderItem>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, OrderItem> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, OrderItem> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, OrderItem> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, OrderItem> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, OrderItem>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(ORDER_HEADER)) {
            chain = chain.andThen(orderHeader(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT)) {
            chain = chain.andThen(product(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FROM_INVENTORY_ITEM)) {
            chain = chain.andThen(fromInventoryItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_FACILITY_LOCATION)) {
            chain = chain.andThen(productFacilityLocation(dao, whereClause, binds, true));
        }
         
        if (incls.contains(DONT_CANCEL_SET_USER_LOGIN)) {
            chain = chain.andThen(dontCancelSetUserLogin(dao, whereClause, binds, true));
        }
         
        if (incls.contains(QUOTE_ITEM)) {
            chain = chain.andThen(quoteItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(SHOPPING_LIST_ITEM)) {
            chain = chain.andThen(shoppingListItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(OVERRIDE_GL_ACCOUNT)) {
            chain = chain.andThen(overrideGlAccount(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHANGE_BY_USER_LOGIN)) {
            chain = chain.andThen(changeByUserLogin(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_TRANS)) {
            chain = chain.andThen(finAccountTrans(dao, whereClause, binds, true));
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
         
        if (incls.contains(ORDER_ITEM_BILLING)) {
            chain = chain.andThen(orderItemBilling(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM_PRICE_INFO)) {
            chain = chain.andThen(orderItemPriceInfo(dao, whereClause, binds, true));
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
         
        if (incls.contains(ORDER_STATUS)) {
            chain = chain.andThen(orderStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(RETURN_ITEM)) {
            chain = chain.andThen(returnItem(dao, whereClause, binds, true));
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
                                   StreamObserver<OrderItemData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<OrderItemData> responseObserver) {

        Map<String, OrderItem> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            OrderItemData.Builder orderItemData = data.toHeadBuilder();
             
            data.getRelOrderHeader().forEach(e -> 
                orderItemData.setOrderHeader(e.toHeadBuilder())); 
            data.getRelProduct().forEach(e -> 
                orderItemData.setProduct(e.toHeadBuilder())); 
            data.getRelFromInventoryItem().forEach(e -> 
                orderItemData.setFromInventoryItem(e.toHeadBuilder())); 
            data.getRelProductFacilityLocation().forEach(e -> 
                orderItemData.addProductFacilityLocation(e.toDataBuilder())); 
            data.getRelDontCancelSetUserLogin().forEach(e -> 
                orderItemData.setDontCancelSetUserLogin(e.toHeadBuilder())); 
            data.getRelQuoteItem().forEach(e -> 
                orderItemData.setQuoteItem(e.toDataBuilder())); 
            data.getRelShoppingListItem().forEach(e -> 
                orderItemData.setShoppingListItem(e.toDataBuilder())); 
            data.getRelOverrideGlAccount().forEach(e -> 
                orderItemData.setOverrideGlAccount(e.toDataBuilder())); 
            data.getRelChangeByUserLogin().forEach(e -> 
                orderItemData.setChangeByUserLogin(e.toHeadBuilder())); 
            data.getRelFinAccountTrans().forEach(e -> 
                orderItemData.addFinAccountTrans(e.toDataBuilder())); 
            data.getRelAcquireFixedAsset().forEach(e -> 
                orderItemData.addAcquireFixedAsset(e.toHeadBuilder())); 
            data.getRelItemIssuance().forEach(e -> 
                orderItemData.addItemIssuance(e.toDataBuilder())); 
            data.getRelOrderAdjustment().forEach(e -> 
                orderItemData.addOrderAdjustment(e.toDataBuilder())); 
            data.getRelOrderItemBilling().forEach(e -> 
                orderItemData.addOrderItemBilling(e.toDataBuilder())); 
            data.getRelOrderItemPriceInfo().forEach(e -> 
                orderItemData.addOrderItemPriceInfo(e.toDataBuilder())); 
            data.getRelOrderItemShipGroupAssoc().forEach(e -> 
                orderItemData.addOrderItemShipGroupAssoc(e.toDataBuilder())); 
            data.getRelOrderItemShipGrpInvRes().forEach(e -> 
                orderItemData.addOrderItemShipGrpInvRes(e.toDataBuilder())); 
            data.getRelOrderPaymentPreference().forEach(e -> 
                orderItemData.addOrderPaymentPreference(e.toDataBuilder())); 
            data.getRelOrderStatus().forEach(e -> 
                orderItemData.addOrderStatus(e.toDataBuilder())); 
            data.getRelReturnItem().forEach(e -> 
                orderItemData.addReturnItem(e.toDataBuilder())); 
            data.getRelShipmentReceipt().forEach(e -> 
                orderItemData.addShipmentReceipt(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                orderItemData.setTenant(e.toDataBuilder()));
            return orderItemData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public OrderItem get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getOrderItem(id);
    }

    @Get("/order_items/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public OrderItem get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<OrderItem> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listOrderItem();
    }

    @Get("/order_items")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<OrderItem> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countOrderItem();
    }

    @Get("/order_items/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/order_items")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(OrderItem orderItem){
        return store(orderItem, true);
    }

    @Put("/order_items")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(OrderItem orderItem){
        return store(orderItem, false);
    }

    public String store(OrderItem orderItem, boolean genId){
        process(c ->{
            if(genId){
                orderItem.setId(sequence.nextStringId());
            }
            storeOrUpdate(c, orderItem.toData());
        });
        return orderItem.getId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "OrderItem", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final OrderItem rec;
        final Message p1;
        OrderItem persistObject;

        Agent(IProc.ProcContext ctx, OrderItem rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public OrderItem getRecord(){
            return rec;
        }

        public OrderItem merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
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
         
        public List<Product> getProduct(){
            return getRelationValues(ctx, p1, "product", Product.class);
        }

        public List<Product> mergeProduct(){
            return getProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProduct().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InventoryItem> getFromInventoryItem(){
            return getRelationValues(ctx, p1, "from_inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeFromInventoryItem(){
            return getFromInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromInventoryItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductFacilityLocation> getProductFacilityLocation(){
            return getRelationValues(ctx, p1, "product_facility_location", ProductFacilityLocation.class);
        }

        public List<ProductFacilityLocation> mergeProductFacilityLocation(){
            return getProductFacilityLocation().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacilityLocation().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getDontCancelSetUserLogin(){
            return getRelationValues(ctx, p1, "dont_cancel_set_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeDontCancelSetUserLogin(){
            return getDontCancelSetUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelDontCancelSetUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<QuoteItem> getQuoteItem(){
            return getRelationValues(ctx, p1, "quote_item", QuoteItem.class);
        }

        public List<QuoteItem> mergeQuoteItem(){
            return getQuoteItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelQuoteItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShoppingListItem> getShoppingListItem(){
            return getRelationValues(ctx, p1, "shopping_list_item", ShoppingListItem.class);
        }

        public List<ShoppingListItem> mergeShoppingListItem(){
            return getShoppingListItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShoppingListItem().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<GlAccount> getOverrideGlAccount(){
            return getRelationValues(ctx, p1, "override_gl_account", GlAccount.class);
        }

        public List<GlAccount> mergeOverrideGlAccount(){
            return getOverrideGlAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOverrideGlAccount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<UserLogin> getChangeByUserLogin(){
            return getRelationValues(ctx, p1, "change_by_user_login", UserLogin.class);
        }

        public List<UserLogin> mergeChangeByUserLogin(){
            return getChangeByUserLogin().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChangeByUserLogin().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountTrans> getFinAccountTrans(){
            return getRelationValues(ctx, p1, "fin_account_trans", FinAccountTrans.class);
        }

        public List<FinAccountTrans> mergeFinAccountTrans(){
            return getFinAccountTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFinAccountTrans().add(c))
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
         
        public List<OrderStatus> getOrderStatus(){
            return getRelationValues(ctx, p1, "order_status", OrderStatus.class);
        }

        public List<OrderStatus> mergeOrderStatus(){
            return getOrderStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderStatus().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ReturnItem> getReturnItem(){
            return getRelationValues(ctx, p1, "return_item", ReturnItem.class);
        }

        public List<ReturnItem> mergeReturnItem(){
            return getReturnItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelReturnItem().add(c))
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
        OrderItemData p = OrderItemData.newBuilder()
                .setId(key)
                .build();
        OrderItem rec = findOne(ctx, p, OrderItem.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, OrderItem rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String ORDER_HEADER="order_header";
         
    public static final String PRODUCT="product";
         
    public static final String FROM_INVENTORY_ITEM="from_inventory_item";
         
    public static final String PRODUCT_FACILITY_LOCATION="product_facility_location";
         
    public static final String DONT_CANCEL_SET_USER_LOGIN="dont_cancel_set_user_login";
         
    public static final String QUOTE_ITEM="quote_item";
         
    public static final String SHOPPING_LIST_ITEM="shopping_list_item";
         
    public static final String OVERRIDE_GL_ACCOUNT="override_gl_account";
         
    public static final String CHANGE_BY_USER_LOGIN="change_by_user_login";
         
    public static final String FIN_ACCOUNT_TRANS="fin_account_trans";
         
    public static final String ACQUIRE_FIXED_ASSET="acquire_fixed_asset";
         
    public static final String ITEM_ISSUANCE="item_issuance";
         
    public static final String ORDER_ADJUSTMENT="order_adjustment";
         
    public static final String ORDER_ITEM_BILLING="order_item_billing";
         
    public static final String ORDER_ITEM_PRICE_INFO="order_item_price_info";
         
    public static final String ORDER_ITEM_SHIP_GROUP_ASSOC="order_item_ship_group_assoc";
         
    public static final String ORDER_ITEM_SHIP_GRP_INV_RES="order_item_ship_grp_inv_res";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String ORDER_STATUS="order_status";
         
    public static final String RETURN_ITEM="return_item";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryOrderItemRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            OrderItemData p = OrderItemData.newBuilder()
                    .setId(key)
                    .build();
            List<OrderItemData.Builder> ds = find(ctx, p, OrderItem.class).stream()
                    .map(e -> {
                        OrderItemData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set order_header to head entity                        
                        if(relationsDemand.contains("order_header")) {
                            getRelationValues(ctx, p1, "order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.setOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product to head entity                        
                        if(relationsDemand.contains("product")) {
                            getRelationValues(ctx, p1, "product",
                                            Product.class)
                                    .forEach(el -> pb.setProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set from_inventory_item to head entity                        
                        if(relationsDemand.contains("from_inventory_item")) {
                            getRelationValues(ctx, p1, "from_inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.setFromInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_facility_location to head entity                        
                        if(relationsDemand.contains("product_facility_location")) {
                            getRelationValues(ctx, p1, "product_facility_location",
                                            ProductFacilityLocation.class)
                                    .forEach(el -> pb.addProductFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set dont_cancel_set_user_login to head entity                        
                        if(relationsDemand.contains("dont_cancel_set_user_login")) {
                            getRelationValues(ctx, p1, "dont_cancel_set_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setDontCancelSetUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set quote_item to head entity                        
                        if(relationsDemand.contains("quote_item")) {
                            getRelationValues(ctx, p1, "quote_item",
                                            QuoteItem.class)
                                    .forEach(el -> pb.setQuoteItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shopping_list_item to head entity                        
                        if(relationsDemand.contains("shopping_list_item")) {
                            getRelationValues(ctx, p1, "shopping_list_item",
                                            ShoppingListItem.class)
                                    .forEach(el -> pb.setShoppingListItem(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set override_gl_account to head entity                        
                        if(relationsDemand.contains("override_gl_account")) {
                            getRelationValues(ctx, p1, "override_gl_account",
                                            GlAccount.class)
                                    .forEach(el -> pb.setOverrideGlAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set change_by_user_login to head entity                        
                        if(relationsDemand.contains("change_by_user_login")) {
                            getRelationValues(ctx, p1, "change_by_user_login",
                                            UserLogin.class)
                                    .forEach(el -> pb.setChangeByUserLogin(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set fin_account_trans to head entity                        
                        if(relationsDemand.contains("fin_account_trans")) {
                            getRelationValues(ctx, p1, "fin_account_trans",
                                            FinAccountTrans.class)
                                    .forEach(el -> pb.addFinAccountTrans(
                                             el.toDataBuilder().build()));
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
                                               
                        // add/set order_status to head entity                        
                        if(relationsDemand.contains("order_status")) {
                            getRelationValues(ctx, p1, "order_status",
                                            OrderStatus.class)
                                    .forEach(el -> pb.addOrderStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set return_item to head entity                        
                        if(relationsDemand.contains("return_item")) {
                            getRelationValues(ctx, p1, "return_item",
                                            ReturnItem.class)
                                    .forEach(el -> pb.addReturnItem(
                                             el.toDataBuilder().build()));
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


    
    public OrderItem.OrderItemBuilder seed(){
        return OrderItem.builder()
                .id(sequence.nextStringId());
    }
}
