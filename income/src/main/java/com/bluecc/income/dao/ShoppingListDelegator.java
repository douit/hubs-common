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

import com.bluecc.hubs.stub.ShoppingListData;

public class ShoppingListDelegator extends AbstractProcs implements IChainQuery<ShoppingList>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(ShoppingList.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from shopping_list")
        List<ShoppingList> listShoppingList();
        @SqlQuery("select * from shopping_list where shopping_list_id=:id")
        ShoppingList getShoppingList(@Bind("id") String id);

        @SqlQuery("select count(*) from shopping_list")
        int countShoppingList();

        // for relations
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "pslo")
        default Map<String, ShoppingList> chainParentShoppingList(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainParentShoppingList(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "pslo")
        default Map<String, ShoppingList> chainParentShoppingList(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_SHOPPING_LIST);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("pslo_shopping_list_id", String.class) != null) {
                            p.getRelParentShoppingList()
                                    .add(rr.getRow(ShoppingList.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sslm")
        default Map<String, ShoppingList> chainSiblingShoppingList(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainSiblingShoppingList(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sslm")
        default Map<String, ShoppingList> chainSiblingShoppingList(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SIBLING_SHOPPING_LIST);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("sslm_parent_shopping_list_id", String.class) != null) {
                            p.getRelSiblingShoppingList()
                                    .add(rr.getRow(ShoppingList.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, ShoppingList> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, ShoppingList> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("pso_product_store_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, ShoppingList> chainParty(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, ShoppingList> chainParty(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("pao_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ProductStoreShipmentMeth.class, prefix = "pssmm")
        default Map<String, ShoppingList> chainProductStoreShipmentMeth(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainProductStoreShipmentMeth(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ProductStoreShipmentMeth.class, prefix = "pssmm")
        default Map<String, ShoppingList> chainProductStoreShipmentMeth(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_SHIPMENT_METH);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("pssmm_product_store_id", String.class) != null) {
                            p.getRelProductStoreShipmentMeth()
                                    .add(rr.getRow(ProductStoreShipmentMeth.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = CarrierShipmentMethod.class, prefix = "csmo")
        default Map<String, ShoppingList> chainCarrierShipmentMethod(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainCarrierShipmentMethod(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = CarrierShipmentMethod.class, prefix = "csmo")
        default Map<String, ShoppingList> chainCarrierShipmentMethod(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CARRIER_SHIPMENT_METHOD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("csmo_shipment_method_type_id", String.class) != null) {
                            p.getRelCarrierShipmentMethod()
                                    .add(rr.getRow(CarrierShipmentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cmo")
        default Map<String, ShoppingList> chainContactMech(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainContactMech(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cmo")
        default Map<String, ShoppingList> chainContactMech(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CONTACT_MECH);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("cmo_contact_mech_id", String.class) != null) {
                            p.getRelContactMech()
                                    .add(rr.getRow(ContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "pao")
        default Map<String, ShoppingList> chainPostalAddress(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainPostalAddress(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "pao")
        default Map<String, ShoppingList> chainPostalAddress(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(POSTAL_ADDRESS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("pao_contact_mech_id", String.class) != null) {
                            p.getRelPostalAddress()
                                    .add(rr.getRow(PostalAddress.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmo")
        default Map<String, ShoppingList> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainPaymentMethod(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmo")
        default Map<String, ShoppingList> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_METHOD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("pmo_payment_method_id", String.class) != null) {
                            p.getRelPaymentMethod()
                                    .add(rr.getRow(PaymentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "rio")
        default Map<String, ShoppingList> chainRecurrenceInfo(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainRecurrenceInfo(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "rio")
        default Map<String, ShoppingList> chainRecurrenceInfo(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(RECURRENCE_INFO);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("rio_recurrence_info_id", String.class) != null) {
                            p.getRelRecurrenceInfo()
                                    .add(rr.getRow(RecurrenceInfo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "ppco")
        default Map<String, ShoppingList> chainProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainProductPromoCode(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ProductPromoCode.class, prefix = "ppco")
        default Map<String, ShoppingList> chainProductPromoCode(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_PROMO_CODE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("ppco_product_promo_code_id", String.class) != null) {
                            p.getRelProductPromoCode()
                                    .add(rr.getRow(ProductPromoCode.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "aoohm")
        default Map<String, ShoppingList> chainAutoOrderOrderHeader(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainAutoOrderOrderHeader(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "aoohm")
        default Map<String, ShoppingList> chainAutoOrderOrderHeader(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(AUTO_ORDER_ORDER_HEADER);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("aoohm_auto_order_shopping_list_id", String.class) != null) {
                            p.getRelAutoOrderOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "cslm")
        default Map<String, ShoppingList> chainChildShoppingList(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainChildShoppingList(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "cslm")
        default Map<String, ShoppingList> chainChildShoppingList(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHILD_SHOPPING_LIST);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("cslm_parent_shopping_list_id", String.class) != null) {
                            p.getRelChildShoppingList()
                                    .add(rr.getRow(ShoppingList.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingListItem.class, prefix = "slim")
        default Map<String, ShoppingList> chainShoppingListItem(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainShoppingListItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = ShoppingListItem.class, prefix = "slim")
        default Map<String, ShoppingList> chainShoppingListItem(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHOPPING_LIST_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("slim_shopping_list_id", String.class) != null) {
                            p.getRelShoppingListItem()
                                    .add(rr.getRow(ShoppingListItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ShoppingList> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ShoppingList.class, prefix = "sl")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ShoppingList> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ShoppingList> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ShoppingList", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ShoppingList p = map.computeIfAbsent(rr.getColumn("sl_shopping_list_id", String.class),
                                id -> rr.getRow(ShoppingList.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ShoppingList>> parentShoppingList(Dao dao, boolean succ) {
        return e -> dao.chainParentShoppingList(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> parentShoppingList(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParentShoppingList(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> siblingShoppingList(Dao dao, boolean succ) {
        return e -> dao.chainSiblingShoppingList(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> siblingShoppingList(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainSiblingShoppingList(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> productStore(Dao dao, boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> productStore(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> party(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> productStoreShipmentMeth(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreShipmentMeth(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> productStoreShipmentMeth(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreShipmentMeth(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> carrierShipmentMethod(Dao dao, boolean succ) {
        return e -> dao.chainCarrierShipmentMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> carrierShipmentMethod(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCarrierShipmentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> contactMech(Dao dao, boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> contactMech(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> postalAddress(Dao dao, boolean succ) {
        return e -> dao.chainPostalAddress(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> postalAddress(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPostalAddress(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> paymentMethod(Dao dao, boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> paymentMethod(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> recurrenceInfo(Dao dao, boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> recurrenceInfo(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> productPromoCode(Dao dao, boolean succ) {
        return e -> dao.chainProductPromoCode(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> productPromoCode(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductPromoCode(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> autoOrderOrderHeader(Dao dao, boolean succ) {
        return e -> dao.chainAutoOrderOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> autoOrderOrderHeader(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAutoOrderOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> childShoppingList(Dao dao, boolean succ) {
        return e -> dao.chainChildShoppingList(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> childShoppingList(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChildShoppingList(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> shoppingListItem(Dao dao, boolean succ) {
        return e -> dao.chainShoppingListItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> shoppingListItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainShoppingListItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ShoppingList>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ShoppingList>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, ShoppingList> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, ShoppingList> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, ShoppingList> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, ShoppingList> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ShoppingList>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PARENT_SHOPPING_LIST)) {
            chain = chain.andThen(parentShoppingList(dao, whereClause, binds, true));
        }
         
        if (incls.contains(SIBLING_SHOPPING_LIST)) {
            chain = chain.andThen(siblingShoppingList(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE)) {
            chain = chain.andThen(productStore(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARTY)) {
            chain = chain.andThen(party(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_STORE_SHIPMENT_METH)) {
            chain = chain.andThen(productStoreShipmentMeth(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CARRIER_SHIPMENT_METHOD)) {
            chain = chain.andThen(carrierShipmentMethod(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CONTACT_MECH)) {
            chain = chain.andThen(contactMech(dao, whereClause, binds, true));
        }
         
        if (incls.contains(POSTAL_ADDRESS)) {
            chain = chain.andThen(postalAddress(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PAYMENT_METHOD)) {
            chain = chain.andThen(paymentMethod(dao, whereClause, binds, true));
        }
         
        if (incls.contains(RECURRENCE_INFO)) {
            chain = chain.andThen(recurrenceInfo(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_PROMO_CODE)) {
            chain = chain.andThen(productPromoCode(dao, whereClause, binds, true));
        }
         
        if (incls.contains(AUTO_ORDER_ORDER_HEADER)) {
            chain = chain.andThen(autoOrderOrderHeader(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHILD_SHOPPING_LIST)) {
            chain = chain.andThen(childShoppingList(dao, whereClause, binds, true));
        }
         
        if (incls.contains(SHOPPING_LIST_ITEM)) {
            chain = chain.andThen(shoppingListItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ShoppingListData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<ShoppingListData> responseObserver) {

        Map<String, ShoppingList> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            ShoppingListData.Builder shoppingListData = data.toHeadBuilder();
             
            data.getRelParentShoppingList().forEach(e -> 
                shoppingListData.setParentShoppingList(e.toHeadBuilder())); 
            data.getRelSiblingShoppingList().forEach(e -> 
                shoppingListData.addSiblingShoppingList(e.toHeadBuilder())); 
            data.getRelProductStore().forEach(e -> 
                shoppingListData.setProductStore(e.toHeadBuilder())); 
            data.getRelParty().forEach(e -> 
                shoppingListData.setParty(e.toHeadBuilder())); 
            data.getRelProductStoreShipmentMeth().forEach(e -> 
                shoppingListData.addProductStoreShipmentMeth(e.toDataBuilder())); 
            data.getRelCarrierShipmentMethod().forEach(e -> 
                shoppingListData.setCarrierShipmentMethod(e.toDataBuilder())); 
            data.getRelContactMech().forEach(e -> 
                shoppingListData.setContactMech(e.toDataBuilder())); 
            data.getRelPostalAddress().forEach(e -> 
                shoppingListData.setPostalAddress(e.toDataBuilder())); 
            data.getRelPaymentMethod().forEach(e -> 
                shoppingListData.setPaymentMethod(e.toDataBuilder())); 
            data.getRelRecurrenceInfo().forEach(e -> 
                shoppingListData.setRecurrenceInfo(e.toDataBuilder())); 
            data.getRelProductPromoCode().forEach(e -> 
                shoppingListData.setProductPromoCode(e.toDataBuilder())); 
            data.getRelAutoOrderOrderHeader().forEach(e -> 
                shoppingListData.addAutoOrderOrderHeader(e.toHeadBuilder())); 
            data.getRelChildShoppingList().forEach(e -> 
                shoppingListData.addChildShoppingList(e.toHeadBuilder())); 
            data.getRelShoppingListItem().forEach(e -> 
                shoppingListData.addShoppingListItem(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                shoppingListData.setTenant(e.toDataBuilder()));
            return shoppingListData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public ShoppingList get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getShoppingList(id);
    }

    @Get("/shopping_lists/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public ShoppingList get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<ShoppingList> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listShoppingList();
    }

    @Get("/shopping_lists")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<ShoppingList> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countShoppingList();
    }

    @Get("/shopping_lists/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/shopping_lists")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(ShoppingList shoppingList){
        return store(shoppingList, true);
    }

    @Put("/shopping_lists")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(ShoppingList shoppingList){
        return store(shoppingList, false);
    }

    public String store(ShoppingList shoppingList, boolean genId){
        process(c ->{
            if(genId){
                shoppingList.setShoppingListId(sequence.nextStringId());
            }
            storeOrUpdate(c, shoppingList.toData());
        });
        return shoppingList.getShoppingListId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "ShoppingList", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ShoppingList rec;
        final Message p1;
        ShoppingList persistObject;

        Agent(IProc.ProcContext ctx, ShoppingList rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ShoppingList getRecord(){
            return rec;
        }

        public ShoppingList merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ShoppingList> getParentShoppingList(){
            return getRelationValues(ctx, p1, "parent_shopping_list", ShoppingList.class);
        }

        public List<ShoppingList> mergeParentShoppingList(){
            return getParentShoppingList().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParentShoppingList().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShoppingList> getSiblingShoppingList(){
            return getRelationValues(ctx, p1, "sibling_shopping_list", ShoppingList.class);
        }

        public List<ShoppingList> mergeSiblingShoppingList(){
            return getSiblingShoppingList().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSiblingShoppingList().add(c))
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
         
        public List<Party> getParty(){
            return getRelationValues(ctx, p1, "party", Party.class);
        }

        public List<Party> mergeParty(){
            return getParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreShipmentMeth> getProductStoreShipmentMeth(){
            return getRelationValues(ctx, p1, "product_store_shipment_meth", ProductStoreShipmentMeth.class);
        }

        public List<ProductStoreShipmentMeth> mergeProductStoreShipmentMeth(){
            return getProductStoreShipmentMeth().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreShipmentMeth().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<CarrierShipmentMethod> getCarrierShipmentMethod(){
            return getRelationValues(ctx, p1, "carrier_shipment_method", CarrierShipmentMethod.class);
        }

        public List<CarrierShipmentMethod> mergeCarrierShipmentMethod(){
            return getCarrierShipmentMethod().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCarrierShipmentMethod().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ContactMech> getContactMech(){
            return getRelationValues(ctx, p1, "contact_mech", ContactMech.class);
        }

        public List<ContactMech> mergeContactMech(){
            return getContactMech().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelContactMech().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PostalAddress> getPostalAddress(){
            return getRelationValues(ctx, p1, "postal_address", PostalAddress.class);
        }

        public List<PostalAddress> mergePostalAddress(){
            return getPostalAddress().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPostalAddress().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PaymentMethod> getPaymentMethod(){
            return getRelationValues(ctx, p1, "payment_method", PaymentMethod.class);
        }

        public List<PaymentMethod> mergePaymentMethod(){
            return getPaymentMethod().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPaymentMethod().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<RecurrenceInfo> getRecurrenceInfo(){
            return getRelationValues(ctx, p1, "recurrence_info", RecurrenceInfo.class);
        }

        public List<RecurrenceInfo> mergeRecurrenceInfo(){
            return getRecurrenceInfo().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelRecurrenceInfo().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductPromoCode> getProductPromoCode(){
            return getRelationValues(ctx, p1, "product_promo_code", ProductPromoCode.class);
        }

        public List<ProductPromoCode> mergeProductPromoCode(){
            return getProductPromoCode().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductPromoCode().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderHeader> getAutoOrderOrderHeader(){
            return getRelationValues(ctx, p1, "auto_order_order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeAutoOrderOrderHeader(){
            return getAutoOrderOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAutoOrderOrderHeader().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShoppingList> getChildShoppingList(){
            return getRelationValues(ctx, p1, "child_shopping_list", ShoppingList.class);
        }

        public List<ShoppingList> mergeChildShoppingList(){
            return getChildShoppingList().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChildShoppingList().add(c))
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
        ShoppingListData p = ShoppingListData.newBuilder()
                .setShoppingListId(key)
                .build();
        ShoppingList rec = findOne(ctx, p, ShoppingList.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ShoppingList rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PARENT_SHOPPING_LIST="parent_shopping_list";
         
    public static final String SIBLING_SHOPPING_LIST="sibling_shopping_list";
         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String PARTY="party";
         
    public static final String PRODUCT_STORE_SHIPMENT_METH="product_store_shipment_meth";
         
    public static final String CARRIER_SHIPMENT_METHOD="carrier_shipment_method";
         
    public static final String CONTACT_MECH="contact_mech";
         
    public static final String POSTAL_ADDRESS="postal_address";
         
    public static final String PAYMENT_METHOD="payment_method";
         
    public static final String RECURRENCE_INFO="recurrence_info";
         
    public static final String PRODUCT_PROMO_CODE="product_promo_code";
         
    public static final String AUTO_ORDER_ORDER_HEADER="auto_order_order_header";
         
    public static final String CHILD_SHOPPING_LIST="child_shopping_list";
         
    public static final String SHOPPING_LIST_ITEM="shopping_list_item";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryShoppingListRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ShoppingListData p = ShoppingListData.newBuilder()
                    .setShoppingListId(key)
                    .build();
            List<ShoppingListData.Builder> ds = find(ctx, p, ShoppingList.class).stream()
                    .map(e -> {
                        ShoppingListData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set parent_shopping_list to head entity                        
                        if(relationsDemand.contains("parent_shopping_list")) {
                            getRelationValues(ctx, p1, "parent_shopping_list",
                                            ShoppingList.class)
                                    .forEach(el -> pb.setParentShoppingList(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set sibling_shopping_list to head entity                        
                        if(relationsDemand.contains("sibling_shopping_list")) {
                            getRelationValues(ctx, p1, "sibling_shopping_list",
                                            ShoppingList.class)
                                    .forEach(el -> pb.addSiblingShoppingList(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_shipment_meth to head entity                        
                        if(relationsDemand.contains("product_store_shipment_meth")) {
                            getRelationValues(ctx, p1, "product_store_shipment_meth",
                                            ProductStoreShipmentMeth.class)
                                    .forEach(el -> pb.addProductStoreShipmentMeth(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set carrier_shipment_method to head entity                        
                        if(relationsDemand.contains("carrier_shipment_method")) {
                            getRelationValues(ctx, p1, "carrier_shipment_method",
                                            CarrierShipmentMethod.class)
                                    .forEach(el -> pb.setCarrierShipmentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set contact_mech to head entity                        
                        if(relationsDemand.contains("contact_mech")) {
                            getRelationValues(ctx, p1, "contact_mech",
                                            ContactMech.class)
                                    .forEach(el -> pb.setContactMech(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set postal_address to head entity                        
                        if(relationsDemand.contains("postal_address")) {
                            getRelationValues(ctx, p1, "postal_address",
                                            PostalAddress.class)
                                    .forEach(el -> pb.setPostalAddress(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set payment_method to head entity                        
                        if(relationsDemand.contains("payment_method")) {
                            getRelationValues(ctx, p1, "payment_method",
                                            PaymentMethod.class)
                                    .forEach(el -> pb.setPaymentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set recurrence_info to head entity                        
                        if(relationsDemand.contains("recurrence_info")) {
                            getRelationValues(ctx, p1, "recurrence_info",
                                            RecurrenceInfo.class)
                                    .forEach(el -> pb.setRecurrenceInfo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_promo_code to head entity                        
                        if(relationsDemand.contains("product_promo_code")) {
                            getRelationValues(ctx, p1, "product_promo_code",
                                            ProductPromoCode.class)
                                    .forEach(el -> pb.setProductPromoCode(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set auto_order_order_header to head entity                        
                        if(relationsDemand.contains("auto_order_order_header")) {
                            getRelationValues(ctx, p1, "auto_order_order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.addAutoOrderOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set child_shopping_list to head entity                        
                        if(relationsDemand.contains("child_shopping_list")) {
                            getRelationValues(ctx, p1, "child_shopping_list",
                                            ShoppingList.class)
                                    .forEach(el -> pb.addChildShoppingList(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set shopping_list_item to head entity                        
                        if(relationsDemand.contains("shopping_list_item")) {
                            getRelationValues(ctx, p1, "shopping_list_item",
                                            ShoppingListItem.class)
                                    .forEach(el -> pb.addShoppingListItem(
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


    
    public ShoppingList.ShoppingListBuilder seed(){
        return ShoppingList.builder()
                .shoppingListId(sequence.nextStringId());
    }
}
