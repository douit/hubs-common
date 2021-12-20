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

import com.bluecc.hubs.stub.InventoryItemData;

public class InventoryItemDelegator extends AbstractProcs implements IChainQuery<InventoryItem>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(InventoryItem.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from inventory_item")
        List<InventoryItem> listInventoryItem();
        @SqlQuery("select * from inventory_item where inventory_item_id=:id")
        InventoryItem getInventoryItem(@Bind("id") String id);

        @SqlQuery("select count(*) from inventory_item")
        int countInventoryItem();

        // for relations
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Product.class, prefix = "pro")
        default Map<String, InventoryItem> chainProduct(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainProduct(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Product.class, prefix = "pro")
        default Map<String, InventoryItem> chainProduct(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("pro_product_id", String.class) != null) {
                            p.getRelProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, InventoryItem> chainParty(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, InventoryItem> chainParty(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("pao_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "opo")
        default Map<String, InventoryItem> chainOwnerParty(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainOwnerParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "opo")
        default Map<String, InventoryItem> chainOwnerParty(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OWNER_PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("opo_party_id", String.class) != null) {
                            p.getRelOwnerParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, InventoryItem> chainFacility(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainFacility(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, InventoryItem> chainFacility(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FACILITY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("fao_facility_id", String.class) != null) {
                            p.getRelFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ProductFacility.class, prefix = "pfo")
        default Map<String, InventoryItem> chainProductFacility(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainProductFacility(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ProductFacility.class, prefix = "pfo")
        default Map<String, InventoryItem> chainProductFacility(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FACILITY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("pfo_product_id", String.class) != null) {
                            p.getRelProductFacility()
                                    .add(rr.getRow(ProductFacility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = FacilityLocation.class, prefix = "flo")
        default Map<String, InventoryItem> chainFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainFacilityLocation(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = FacilityLocation.class, prefix = "flo")
        default Map<String, InventoryItem> chainFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FACILITY_LOCATION);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("flo_facility_id", String.class) != null) {
                            p.getRelFacilityLocation()
                                    .add(rr.getRow(FacilityLocation.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ProductFacilityLocation.class, prefix = "pflo")
        default Map<String, InventoryItem> chainProductFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainProductFacilityLocation(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ProductFacilityLocation.class, prefix = "pflo")
        default Map<String, InventoryItem> chainProductFacilityLocation(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FACILITY_LOCATION);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("pflo_product_id", String.class) != null) {
                            p.getRelProductFacilityLocation()
                                    .add(rr.getRow(ProductFacilityLocation.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fafao")
        default Map<String, InventoryItem> chainFixedAssetFixedAsset(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainFixedAssetFixedAsset(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = FixedAsset.class, prefix = "fafao")
        default Map<String, InventoryItem> chainFixedAssetFixedAsset(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIXED_ASSET_FIXED_ASSET);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("fafao_fixed_asset_id", String.class) != null) {
                            p.getRelFixedAssetFixedAsset()
                                    .add(rr.getRow(FixedAsset.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, InventoryItem> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, InventoryItem> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("atm_inventory_item_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = AcctgTransEntry.class, prefix = "atem")
        default Map<String, InventoryItem> chainAcctgTransEntry(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainAcctgTransEntry(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = AcctgTransEntry.class, prefix = "atem")
        default Map<String, InventoryItem> chainAcctgTransEntry(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS_ENTRY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("atem_inventory_item_id", String.class) != null) {
                            p.getRelAcctgTransEntry()
                                    .add(rr.getRow(AcctgTransEntry.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InventoryItemDetail.class, prefix = "iidm")
        default Map<String, InventoryItem> chainInventoryItemDetail(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainInventoryItemDetail(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InventoryItemDetail.class, prefix = "iidm")
        default Map<String, InventoryItem> chainInventoryItemDetail(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVENTORY_ITEM_DETAIL);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("iidm_inventory_item_id", String.class) != null) {
                            p.getRelInventoryItemDetail()
                                    .add(rr.getRow(InventoryItemDetail.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "iim")
        default Map<String, InventoryItem> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainInvoiceItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "iim")
        default Map<String, InventoryItem> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("iim_inventory_item_id", String.class) != null) {
                            p.getRelInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, InventoryItem> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainItemIssuance(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ItemIssuance.class, prefix = "iim")
        default Map<String, InventoryItem> chainItemIssuance(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ITEM_ISSUANCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("iim_inventory_item_id", String.class) != null) {
                            p.getRelItemIssuance()
                                    .add(rr.getRow(ItemIssuance.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "foim")
        default Map<String, InventoryItem> chainFromOrderItem(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainFromOrderItem(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderItem.class, prefix = "foim")
        default Map<String, InventoryItem> chainFromOrderItem(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_ORDER_ITEM);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("foim_from_inventory_item_id", String.class) != null) {
                            p.getRelFromOrderItem()
                                    .add(rr.getRow(OrderItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderItemShipGrpInvRes.class, prefix = "oisgirm")
        default Map<String, InventoryItem> chainOrderItemShipGrpInvRes(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainOrderItemShipGrpInvRes(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderItemShipGrpInvRes.class, prefix = "oisgirm")
        default Map<String, InventoryItem> chainOrderItemShipGrpInvRes(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_SHIP_GRP_INV_RES);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("oisgirm_inventory_item_id", String.class) != null) {
                            p.getRelOrderItemShipGrpInvRes()
                                    .add(rr.getRow(OrderItemShipGrpInvRes.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, InventoryItem> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainShipmentReceipt(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ShipmentReceipt.class, prefix = "srm")
        default Map<String, InventoryItem> chainShipmentReceipt(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_RECEIPT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("srm_inventory_item_id", String.class) != null) {
                            p.getRelShipmentReceipt()
                                    .add(rr.getRow(ShipmentReceipt.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, InventoryItem> chainTenant(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, InventoryItem> chainTenant(ProtoMeta protoMeta,
                                               Map<String, InventoryItem> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InventoryItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        InventoryItem p = map.computeIfAbsent(rr.getColumn("ii_inventory_item_id", String.class),
                                id -> rr.getRow(InventoryItem.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, InventoryItem>> product(Dao dao, boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> product(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> party(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> ownerParty(Dao dao, boolean succ) {
        return e -> dao.chainOwnerParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> ownerParty(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOwnerParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> facility(Dao dao, boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> facility(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> productFacility(Dao dao, boolean succ) {
        return e -> dao.chainProductFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> productFacility(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> facilityLocation(Dao dao, boolean succ) {
        return e -> dao.chainFacilityLocation(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> facilityLocation(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFacilityLocation(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> productFacilityLocation(Dao dao, boolean succ) {
        return e -> dao.chainProductFacilityLocation(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> productFacilityLocation(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductFacilityLocation(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> fixedAssetFixedAsset(Dao dao, boolean succ) {
        return e -> dao.chainFixedAssetFixedAsset(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> fixedAssetFixedAsset(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFixedAssetFixedAsset(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> acctgTrans(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> acctgTransEntry(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTransEntry(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> acctgTransEntry(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTransEntry(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> inventoryItemDetail(Dao dao, boolean succ) {
        return e -> dao.chainInventoryItemDetail(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> inventoryItemDetail(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainInventoryItemDetail(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> invoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> invoiceItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> itemIssuance(Dao dao, boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> itemIssuance(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainItemIssuance(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> fromOrderItem(Dao dao, boolean succ) {
        return e -> dao.chainFromOrderItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> fromOrderItem(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFromOrderItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> orderItemShipGrpInvRes(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemShipGrpInvRes(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> orderItemShipGrpInvRes(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemShipGrpInvRes(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> shipmentReceipt(Dao dao, boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> shipmentReceipt(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainShipmentReceipt(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InventoryItem>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, InventoryItem>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, InventoryItem> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, InventoryItem> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, InventoryItem> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, InventoryItem> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, InventoryItem>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PRODUCT)) {
            chain = chain.andThen(product(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARTY)) {
            chain = chain.andThen(party(dao, whereClause, binds, true));
        }
         
        if (incls.contains(OWNER_PARTY)) {
            chain = chain.andThen(ownerParty(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FACILITY)) {
            chain = chain.andThen(facility(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_FACILITY)) {
            chain = chain.andThen(productFacility(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FACILITY_LOCATION)) {
            chain = chain.andThen(facilityLocation(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_FACILITY_LOCATION)) {
            chain = chain.andThen(productFacilityLocation(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIXED_ASSET_FIXED_ASSET)) {
            chain = chain.andThen(fixedAssetFixedAsset(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ACCTG_TRANS)) {
            chain = chain.andThen(acctgTrans(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ACCTG_TRANS_ENTRY)) {
            chain = chain.andThen(acctgTransEntry(dao, whereClause, binds, true));
        }
         
        if (incls.contains(INVENTORY_ITEM_DETAIL)) {
            chain = chain.andThen(inventoryItemDetail(dao, whereClause, binds, true));
        }
         
        if (incls.contains(INVOICE_ITEM)) {
            chain = chain.andThen(invoiceItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ITEM_ISSUANCE)) {
            chain = chain.andThen(itemIssuance(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FROM_ORDER_ITEM)) {
            chain = chain.andThen(fromOrderItem(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_ITEM_SHIP_GRP_INV_RES)) {
            chain = chain.andThen(orderItemShipGrpInvRes(dao, whereClause, binds, true));
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
                                   StreamObserver<InventoryItemData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<InventoryItemData> responseObserver) {

        Map<String, InventoryItem> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            InventoryItemData.Builder inventoryItemData = data.toHeadBuilder();
             
            data.getRelProduct().forEach(e -> 
                inventoryItemData.setProduct(e.toHeadBuilder())); 
            data.getRelParty().forEach(e -> 
                inventoryItemData.setParty(e.toHeadBuilder())); 
            data.getRelOwnerParty().forEach(e -> 
                inventoryItemData.setOwnerParty(e.toHeadBuilder())); 
            data.getRelFacility().forEach(e -> 
                inventoryItemData.setFacility(e.toDataBuilder())); 
            data.getRelProductFacility().forEach(e -> 
                inventoryItemData.setProductFacility(e.toDataBuilder())); 
            data.getRelFacilityLocation().forEach(e -> 
                inventoryItemData.setFacilityLocation(e.toDataBuilder())); 
            data.getRelProductFacilityLocation().forEach(e -> 
                inventoryItemData.setProductFacilityLocation(e.toDataBuilder())); 
            data.getRelFixedAssetFixedAsset().forEach(e -> 
                inventoryItemData.setFixedAssetFixedAsset(e.toHeadBuilder())); 
            data.getRelAcctgTrans().forEach(e -> 
                inventoryItemData.addAcctgTrans(e.toDataBuilder())); 
            data.getRelAcctgTransEntry().forEach(e -> 
                inventoryItemData.addAcctgTransEntry(e.toDataBuilder())); 
            data.getRelInventoryItemDetail().forEach(e -> 
                inventoryItemData.addInventoryItemDetail(e.toDataBuilder())); 
            data.getRelInvoiceItem().forEach(e -> 
                inventoryItemData.addInvoiceItem(e.toHeadBuilder())); 
            data.getRelItemIssuance().forEach(e -> 
                inventoryItemData.addItemIssuance(e.toDataBuilder())); 
            data.getRelFromOrderItem().forEach(e -> 
                inventoryItemData.addFromOrderItem(e.toHeadBuilder())); 
            data.getRelOrderItemShipGrpInvRes().forEach(e -> 
                inventoryItemData.addOrderItemShipGrpInvRes(e.toDataBuilder())); 
            data.getRelShipmentReceipt().forEach(e -> 
                inventoryItemData.addShipmentReceipt(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                inventoryItemData.setTenant(e.toDataBuilder()));
            return inventoryItemData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public InventoryItem get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getInventoryItem(id);
    }

    @Get("/inventory_items/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public InventoryItem get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<InventoryItem> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listInventoryItem();
    }

    @Get("/inventory_items")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<InventoryItem> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countInventoryItem();
    }

    @Get("/inventory_items/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/inventory_items")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(InventoryItem inventoryItem){
        return store(inventoryItem, true);
    }

    @Put("/inventory_items")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(InventoryItem inventoryItem){
        return store(inventoryItem, false);
    }

    public String store(InventoryItem inventoryItem, boolean genId){
        process(c ->{
            if(genId){
                inventoryItem.setInventoryItemId(sequence.nextStringId());
            }
            storeOrUpdate(c, inventoryItem.toData());
        });
        return inventoryItem.getInventoryItemId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "InventoryItem", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final InventoryItem rec;
        final Message p1;
        InventoryItem persistObject;

        Agent(IProc.ProcContext ctx, InventoryItem rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public InventoryItem getRecord(){
            return rec;
        }

        public InventoryItem merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
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
         
        public List<Party> getParty(){
            return getRelationValues(ctx, p1, "party", Party.class);
        }

        public List<Party> mergeParty(){
            return getParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<Party> getOwnerParty(){
            return getRelationValues(ctx, p1, "owner_party", Party.class);
        }

        public List<Party> mergeOwnerParty(){
            return getOwnerParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOwnerParty().add(c))
                    .collect(Collectors.toList());
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
         
        public List<ProductFacility> getProductFacility(){
            return getRelationValues(ctx, p1, "product_facility", ProductFacility.class);
        }

        public List<ProductFacility> mergeProductFacility(){
            return getProductFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFacility().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FacilityLocation> getFacilityLocation(){
            return getRelationValues(ctx, p1, "facility_location", FacilityLocation.class);
        }

        public List<FacilityLocation> mergeFacilityLocation(){
            return getFacilityLocation().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFacilityLocation().add(c))
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
         
        public List<FixedAsset> getFixedAssetFixedAsset(){
            return getRelationValues(ctx, p1, "fixed_asset_fixed_asset", FixedAsset.class);
        }

        public List<FixedAsset> mergeFixedAssetFixedAsset(){
            return getFixedAssetFixedAsset().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFixedAssetFixedAsset().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<AcctgTrans> getAcctgTrans(){
            return getRelationValues(ctx, p1, "acctg_trans", AcctgTrans.class);
        }

        public List<AcctgTrans> mergeAcctgTrans(){
            return getAcctgTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcctgTrans().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<AcctgTransEntry> getAcctgTransEntry(){
            return getRelationValues(ctx, p1, "acctg_trans_entry", AcctgTransEntry.class);
        }

        public List<AcctgTransEntry> mergeAcctgTransEntry(){
            return getAcctgTransEntry().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcctgTransEntry().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InventoryItemDetail> getInventoryItemDetail(){
            return getRelationValues(ctx, p1, "inventory_item_detail", InventoryItemDetail.class);
        }

        public List<InventoryItemDetail> mergeInventoryItemDetail(){
            return getInventoryItemDetail().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInventoryItemDetail().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceItem> getInvoiceItem(){
            return getRelationValues(ctx, p1, "invoice_item", InvoiceItem.class);
        }

        public List<InvoiceItem> mergeInvoiceItem(){
            return getInvoiceItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoiceItem().add(c))
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
         
        public List<OrderItem> getFromOrderItem(){
            return getRelationValues(ctx, p1, "from_order_item", OrderItem.class);
        }

        public List<OrderItem> mergeFromOrderItem(){
            return getFromOrderItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromOrderItem().add(c))
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
        InventoryItemData p = InventoryItemData.newBuilder()
                .setInventoryItemId(key)
                .build();
        InventoryItem rec = findOne(ctx, p, InventoryItem.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, InventoryItem rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PRODUCT="product";
         
    public static final String PARTY="party";
         
    public static final String OWNER_PARTY="owner_party";
         
    public static final String FACILITY="facility";
         
    public static final String PRODUCT_FACILITY="product_facility";
         
    public static final String FACILITY_LOCATION="facility_location";
         
    public static final String PRODUCT_FACILITY_LOCATION="product_facility_location";
         
    public static final String FIXED_ASSET_FIXED_ASSET="fixed_asset_fixed_asset";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String ACCTG_TRANS_ENTRY="acctg_trans_entry";
         
    public static final String INVENTORY_ITEM_DETAIL="inventory_item_detail";
         
    public static final String INVOICE_ITEM="invoice_item";
         
    public static final String ITEM_ISSUANCE="item_issuance";
         
    public static final String FROM_ORDER_ITEM="from_order_item";
         
    public static final String ORDER_ITEM_SHIP_GRP_INV_RES="order_item_ship_grp_inv_res";
         
    public static final String SHIPMENT_RECEIPT="shipment_receipt";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryInventoryItemRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            InventoryItemData p = InventoryItemData.newBuilder()
                    .setInventoryItemId(key)
                    .build();
            List<InventoryItemData.Builder> ds = find(ctx, p, InventoryItem.class).stream()
                    .map(e -> {
                        InventoryItemData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product to head entity                        
                        if(relationsDemand.contains("product")) {
                            getRelationValues(ctx, p1, "product",
                                            Product.class)
                                    .forEach(el -> pb.setProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set owner_party to head entity                        
                        if(relationsDemand.contains("owner_party")) {
                            getRelationValues(ctx, p1, "owner_party",
                                            Party.class)
                                    .forEach(el -> pb.setOwnerParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set facility to head entity                        
                        if(relationsDemand.contains("facility")) {
                            getRelationValues(ctx, p1, "facility",
                                            Facility.class)
                                    .forEach(el -> pb.setFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility to head entity                        
                        if(relationsDemand.contains("product_facility")) {
                            getRelationValues(ctx, p1, "product_facility",
                                            ProductFacility.class)
                                    .forEach(el -> pb.setProductFacility(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set facility_location to head entity                        
                        if(relationsDemand.contains("facility_location")) {
                            getRelationValues(ctx, p1, "facility_location",
                                            FacilityLocation.class)
                                    .forEach(el -> pb.setFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_facility_location to head entity                        
                        if(relationsDemand.contains("product_facility_location")) {
                            getRelationValues(ctx, p1, "product_facility_location",
                                            ProductFacilityLocation.class)
                                    .forEach(el -> pb.setProductFacilityLocation(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fixed_asset_fixed_asset to head entity                        
                        if(relationsDemand.contains("fixed_asset_fixed_asset")) {
                            getRelationValues(ctx, p1, "fixed_asset_fixed_asset",
                                            FixedAsset.class)
                                    .forEach(el -> pb.setFixedAssetFixedAsset(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans_entry to head entity                        
                        if(relationsDemand.contains("acctg_trans_entry")) {
                            getRelationValues(ctx, p1, "acctg_trans_entry",
                                            AcctgTransEntry.class)
                                    .forEach(el -> pb.addAcctgTransEntry(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set inventory_item_detail to head entity                        
                        if(relationsDemand.contains("inventory_item_detail")) {
                            getRelationValues(ctx, p1, "inventory_item_detail",
                                            InventoryItemDetail.class)
                                    .forEach(el -> pb.addInventoryItemDetail(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice_item to head entity                        
                        if(relationsDemand.contains("invoice_item")) {
                            getRelationValues(ctx, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set item_issuance to head entity                        
                        if(relationsDemand.contains("item_issuance")) {
                            getRelationValues(ctx, p1, "item_issuance",
                                            ItemIssuance.class)
                                    .forEach(el -> pb.addItemIssuance(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_order_item to head entity                        
                        if(relationsDemand.contains("from_order_item")) {
                            getRelationValues(ctx, p1, "from_order_item",
                                            OrderItem.class)
                                    .forEach(el -> pb.addFromOrderItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_item_ship_grp_inv_res to head entity                        
                        if(relationsDemand.contains("order_item_ship_grp_inv_res")) {
                            getRelationValues(ctx, p1, "order_item_ship_grp_inv_res",
                                            OrderItemShipGrpInvRes.class)
                                    .forEach(el -> pb.addOrderItemShipGrpInvRes(
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


    
    public InventoryItem.InventoryItemBuilder seed(){
        return InventoryItem.builder()
                .inventoryItemId(sequence.nextStringId());
    }
}
