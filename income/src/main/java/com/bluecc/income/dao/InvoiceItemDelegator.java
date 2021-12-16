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
import io.grpc.stub.StreamObserver;

import com.bluecc.hubs.stub.InvoiceItemData;

public class InvoiceItemDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(InvoiceItem.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from invoice_item")
        List<InvoiceItem> listInvoiceItem();
        @SqlQuery("select * from invoice_item where id=:id")
        InvoiceItem getInvoiceItem(@Bind("id") String id);

        @SqlQuery("select count(*) from invoice_item")
        int countInvoiceItem();

        // for relations
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        default Map<String, InvoiceItem> chainInvoice(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainInvoice(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        default Map<String, InvoiceItem> chainInvoice(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("in_invoice_id", String.class) != null) {
                            p.getRelInvoice()
                                    .add(rr.getRow(Invoice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        default Map<String, InvoiceItem> chainInventoryItem(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainInventoryItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InventoryItem.class, prefix = "ii")
        default Map<String, InvoiceItem> chainInventoryItem(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVENTORY_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("ii_inventory_item_id", String.class) != null) {
                            p.getRelInventoryItem()
                                    .add(rr.getRow(InventoryItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        default Map<String, InvoiceItem> chainProduct(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        default Map<String, InvoiceItem> chainProduct(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("pr_product_id", String.class) != null) {
                            p.getRelProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ProductFeature.class, prefix = "pf")
        default Map<String, InvoiceItem> chainProductFeature(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainProductFeature(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ProductFeature.class, prefix = "pf")
        default Map<String, InvoiceItem> chainProductFeature(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_FEATURE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("pf_product_feature_id", String.class) != null) {
                            p.getRelProductFeature()
                                    .add(rr.getRow(ProductFeature.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        default Map<String, InvoiceItem> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainInvoiceItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        default Map<String, InvoiceItem> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("ii_invoice_id", String.class) != null) {
                            p.getRelInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "cii")
        default Map<String, InvoiceItem> chainChildrenInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainChildrenInvoiceItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "cii")
        default Map<String, InvoiceItem> chainChildrenInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHILDREN_INVOICE_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("cii_parent_invoice_id", String.class) != null) {
                            p.getRelChildrenInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "oga")
        default Map<String, InvoiceItem> chainOverrideGlAccount(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainOverrideGlAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "oga")
        default Map<String, InvoiceItem> chainOverrideGlAccount(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OVERRIDE_GL_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("oga_gl_account_id", String.class) != null) {
                            p.getRelOverrideGlAccount()
                                    .add(rr.getRow(GlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "tap")
        default Map<String, InvoiceItem> chainTaxAuthorityParty(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "tap")
        default Map<String, InvoiceItem> chainTaxAuthorityParty(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("tap_party_id", String.class) != null) {
                            p.getRelTaxAuthorityParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarp")
        default Map<String, InvoiceItem> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainTaxAuthorityRateProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = TaxAuthorityRateProduct.class, prefix = "tarp")
        default Map<String, InvoiceItem> chainTaxAuthorityRateProduct(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TAX_AUTHORITY_RATE_PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("tarp_tax_authority_rate_seq_id", String.class) != null) {
                            p.getRelTaxAuthorityRateProduct()
                                    .add(rr.getRow(TaxAuthorityRateProduct.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "oop")
        default Map<String, InvoiceItem> chainOverrideOrgParty(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainOverrideOrgParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Party.class, prefix = "oop")
        default Map<String, InvoiceItem> chainOverrideOrgParty(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OVERRIDE_ORG_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("oop_party_id", String.class) != null) {
                            p.getRelOverrideOrgParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderAdjustmentBilling.class, prefix = "oab")
        default Map<String, InvoiceItem> chainOrderAdjustmentBilling(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainOrderAdjustmentBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderAdjustmentBilling.class, prefix = "oab")
        default Map<String, InvoiceItem> chainOrderAdjustmentBilling(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ADJUSTMENT_BILLING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("oab_invoice_id", String.class) != null) {
                            p.getRelOrderAdjustmentBilling()
                                    .add(rr.getRow(OrderAdjustmentBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oib")
        default Map<String, InvoiceItem> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainOrderItemBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oib")
        default Map<String, InvoiceItem> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_BILLING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("oib_invoice_id", String.class) != null) {
                            p.getRelOrderItemBilling()
                                    .add(rr.getRow(OrderItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pa")
        default Map<String, InvoiceItem> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainPaymentApplication(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pa")
        default Map<String, InvoiceItem> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_APPLICATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("pa_invoice_id", String.class) != null) {
                            p.getRelPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sib")
        default Map<String, InvoiceItem> chainShipmentItemBilling(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainShipmentItemBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sib")
        default Map<String, InvoiceItem> chainShipmentItemBilling(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_ITEM_BILLING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("sib_invoice_id", String.class) != null) {
                            p.getRelShipmentItemBilling()
                                    .add(rr.getRow(ShipmentItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, InvoiceItem> chainTenant(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, InvoiceItem> chainTenant(ProtoMeta protoMeta,
                                               Map<String, InvoiceItem> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("InvoiceItem", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        InvoiceItem p = map.computeIfAbsent(rr.getColumn("ii_id", String.class),
                                id -> rr.getRow(InvoiceItem.class));
                        if (rr.getColumn("te_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, InvoiceItem>> invoice(Dao dao, boolean succ) {
        return e -> dao.chainInvoice(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> invoice(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> inventoryItem(Dao dao, boolean succ) {
        return e -> dao.chainInventoryItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> inventoryItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInventoryItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> product(Dao dao, boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> product(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> productFeature(Dao dao, boolean succ) {
        return e -> dao.chainProductFeature(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> productFeature(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductFeature(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> invoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> invoiceItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> childrenInvoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainChildrenInvoiceItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> childrenInvoiceItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainChildrenInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> overrideGlAccount(Dao dao, boolean succ) {
        return e -> dao.chainOverrideGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> overrideGlAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOverrideGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> taxAuthorityParty(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> taxAuthorityParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> taxAuthorityRateProduct(Dao dao, boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> taxAuthorityRateProduct(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTaxAuthorityRateProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> overrideOrgParty(Dao dao, boolean succ) {
        return e -> dao.chainOverrideOrgParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> overrideOrgParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOverrideOrgParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> orderAdjustmentBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderAdjustmentBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> orderAdjustmentBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderAdjustmentBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> orderItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> orderItemBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> paymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> paymentApplication(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> shipmentItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> shipmentItemBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, InvoiceItem>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, InvoiceItem>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    

    public Map<String, InvoiceItem> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, InvoiceItem> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, InvoiceItem>> chain = tenant(dao, false);
         
        if (incls.contains(INVOICE)) {
            chain = chain.andThen(invoice(dao, true));
        }
         
        if (incls.contains(INVENTORY_ITEM)) {
            chain = chain.andThen(inventoryItem(dao, true));
        }
         
        if (incls.contains(PRODUCT)) {
            chain = chain.andThen(product(dao, true));
        }
         
        if (incls.contains(PRODUCT_FEATURE)) {
            chain = chain.andThen(productFeature(dao, true));
        }
         
        if (incls.contains(INVOICE_ITEM)) {
            chain = chain.andThen(invoiceItem(dao, true));
        }
         
        if (incls.contains(CHILDREN_INVOICE_ITEM)) {
            chain = chain.andThen(childrenInvoiceItem(dao, true));
        }
         
        if (incls.contains(OVERRIDE_GL_ACCOUNT)) {
            chain = chain.andThen(overrideGlAccount(dao, true));
        }
         
        if (incls.contains(TAX_AUTHORITY_PARTY)) {
            chain = chain.andThen(taxAuthorityParty(dao, true));
        }
         
        if (incls.contains(TAX_AUTHORITY_RATE_PRODUCT)) {
            chain = chain.andThen(taxAuthorityRateProduct(dao, true));
        }
         
        if (incls.contains(OVERRIDE_ORG_PARTY)) {
            chain = chain.andThen(overrideOrgParty(dao, true));
        }
         
        if (incls.contains(ORDER_ADJUSTMENT_BILLING)) {
            chain = chain.andThen(orderAdjustmentBilling(dao, true));
        }
         
        if (incls.contains(ORDER_ITEM_BILLING)) {
            chain = chain.andThen(orderItemBilling(dao, true));
        }
         
        if (incls.contains(PAYMENT_APPLICATION)) {
            chain = chain.andThen(paymentApplication(dao, true));
        }
         
        if (incls.contains(SHIPMENT_ITEM_BILLING)) {
            chain = chain.andThen(shipmentItemBilling(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<InvoiceItemData> responseObserver) {
        Map<String, InvoiceItem> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            InvoiceItemData.Builder invoiceItemData = data.toHeadBuilder();
             
            data.getRelInvoice().forEach(e -> 
                invoiceItemData.setInvoice(e.toHeadBuilder())); 
            data.getRelInventoryItem().forEach(e -> 
                invoiceItemData.setInventoryItem(e.toHeadBuilder())); 
            data.getRelProduct().forEach(e -> 
                invoiceItemData.setProduct(e.toHeadBuilder())); 
            data.getRelProductFeature().forEach(e -> 
                invoiceItemData.setProductFeature(e.toDataBuilder())); 
            data.getRelInvoiceItem().forEach(e -> 
                invoiceItemData.setInvoiceItem(e.toHeadBuilder())); 
            data.getRelChildrenInvoiceItem().forEach(e -> 
                invoiceItemData.addChildrenInvoiceItem(e.toHeadBuilder())); 
            data.getRelOverrideGlAccount().forEach(e -> 
                invoiceItemData.setOverrideGlAccount(e.toDataBuilder())); 
            data.getRelTaxAuthorityParty().forEach(e -> 
                invoiceItemData.setTaxAuthorityParty(e.toHeadBuilder())); 
            data.getRelTaxAuthorityRateProduct().forEach(e -> 
                invoiceItemData.setTaxAuthorityRateProduct(e.toDataBuilder())); 
            data.getRelOverrideOrgParty().forEach(e -> 
                invoiceItemData.setOverrideOrgParty(e.toHeadBuilder())); 
            data.getRelOrderAdjustmentBilling().forEach(e -> 
                invoiceItemData.addOrderAdjustmentBilling(e.toDataBuilder())); 
            data.getRelOrderItemBilling().forEach(e -> 
                invoiceItemData.addOrderItemBilling(e.toDataBuilder())); 
            data.getRelPaymentApplication().forEach(e -> 
                invoiceItemData.addPaymentApplication(e.toDataBuilder())); 
            data.getRelShipmentItemBilling().forEach(e -> 
                invoiceItemData.addShipmentItemBilling(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                invoiceItemData.setTenant(e.toDataBuilder()));
            return invoiceItemData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public InvoiceItem get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getInvoiceItem(id);
    }

    public List<InvoiceItem> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listInvoiceItem();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countInvoiceItem();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final InvoiceItem rec;
        final Message p1;
        InvoiceItem persistObject;

        Agent(IProc.ProcContext ctx, InvoiceItem rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public InvoiceItem getRecord(){
            return rec;
        }

        public InvoiceItem merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<Invoice> getInvoice(){
            return getRelationValues(ctx, p1, "invoice", Invoice.class);
        }

        public List<Invoice> mergeInvoice(){
            return getInvoice().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoice().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InventoryItem> getInventoryItem(){
            return getRelationValues(ctx, p1, "inventory_item", InventoryItem.class);
        }

        public List<InventoryItem> mergeInventoryItem(){
            return getInventoryItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInventoryItem().add(c))
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
         
        public List<ProductFeature> getProductFeature(){
            return getRelationValues(ctx, p1, "product_feature", ProductFeature.class);
        }

        public List<ProductFeature> mergeProductFeature(){
            return getProductFeature().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductFeature().add(c))
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
         
        public List<InvoiceItem> getChildrenInvoiceItem(){
            return getRelationValues(ctx, p1, "children_invoice_item", InvoiceItem.class);
        }

        public List<InvoiceItem> mergeChildrenInvoiceItem(){
            return getChildrenInvoiceItem().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChildrenInvoiceItem().add(c))
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
         
        public List<Party> getTaxAuthorityParty(){
            return getRelationValues(ctx, p1, "tax_authority_party", Party.class);
        }

        public List<Party> mergeTaxAuthorityParty(){
            return getTaxAuthorityParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelTaxAuthorityParty().add(c))
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
         
        public List<Party> getOverrideOrgParty(){
            return getRelationValues(ctx, p1, "override_org_party", Party.class);
        }

        public List<Party> mergeOverrideOrgParty(){
            return getOverrideOrgParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOverrideOrgParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<OrderAdjustmentBilling> getOrderAdjustmentBilling(){
            return getRelationValues(ctx, p1, "order_adjustment_billing", OrderAdjustmentBilling.class);
        }

        public List<OrderAdjustmentBilling> mergeOrderAdjustmentBilling(){
            return getOrderAdjustmentBilling().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderAdjustmentBilling().add(c))
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
         
        public List<PaymentApplication> getPaymentApplication(){
            return getRelationValues(ctx, p1, "payment_application", PaymentApplication.class);
        }

        public List<PaymentApplication> mergePaymentApplication(){
            return getPaymentApplication().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPaymentApplication().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ShipmentItemBilling> getShipmentItemBilling(){
            return getRelationValues(ctx, p1, "shipment_item_billing", ShipmentItemBilling.class);
        }

        public List<ShipmentItemBilling> mergeShipmentItemBilling(){
            return getShipmentItemBilling().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelShipmentItemBilling().add(c))
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
        InvoiceItemData p = InvoiceItemData.newBuilder()
                .setId(key)
                .build();
        InvoiceItem rec = findOne(ctx, p, InvoiceItem.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, InvoiceItem rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String INVOICE="invoice";
         
    public static final String INVENTORY_ITEM="inventory_item";
         
    public static final String PRODUCT="product";
         
    public static final String PRODUCT_FEATURE="product_feature";
         
    public static final String INVOICE_ITEM="invoice_item";
         
    public static final String CHILDREN_INVOICE_ITEM="children_invoice_item";
         
    public static final String OVERRIDE_GL_ACCOUNT="override_gl_account";
         
    public static final String TAX_AUTHORITY_PARTY="tax_authority_party";
         
    public static final String TAX_AUTHORITY_RATE_PRODUCT="tax_authority_rate_product";
         
    public static final String OVERRIDE_ORG_PARTY="override_org_party";
         
    public static final String ORDER_ADJUSTMENT_BILLING="order_adjustment_billing";
         
    public static final String ORDER_ITEM_BILLING="order_item_billing";
         
    public static final String PAYMENT_APPLICATION="payment_application";
         
    public static final String SHIPMENT_ITEM_BILLING="shipment_item_billing";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryInvoiceItemRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            InvoiceItemData p = InvoiceItemData.newBuilder()
                    .setId(key)
                    .build();
            List<InvoiceItemData.Builder> ds = find(ctx, p, InvoiceItem.class).stream()
                    .map(e -> {
                        InvoiceItemData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set invoice to head entity                        
                        if(relationsDemand.contains("invoice")) {
                            getRelationValues(ctx, p1, "invoice",
                                            Invoice.class)
                                    .forEach(el -> pb.setInvoice(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set inventory_item to head entity                        
                        if(relationsDemand.contains("inventory_item")) {
                            getRelationValues(ctx, p1, "inventory_item",
                                            InventoryItem.class)
                                    .forEach(el -> pb.setInventoryItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product to head entity                        
                        if(relationsDemand.contains("product")) {
                            getRelationValues(ctx, p1, "product",
                                            Product.class)
                                    .forEach(el -> pb.setProduct(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_feature to head entity                        
                        if(relationsDemand.contains("product_feature")) {
                            getRelationValues(ctx, p1, "product_feature",
                                            ProductFeature.class)
                                    .forEach(el -> pb.setProductFeature(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice_item to head entity                        
                        if(relationsDemand.contains("invoice_item")) {
                            getRelationValues(ctx, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.setInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set children_invoice_item to head entity                        
                        if(relationsDemand.contains("children_invoice_item")) {
                            getRelationValues(ctx, p1, "children_invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addChildrenInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set override_gl_account to head entity                        
                        if(relationsDemand.contains("override_gl_account")) {
                            getRelationValues(ctx, p1, "override_gl_account",
                                            GlAccount.class)
                                    .forEach(el -> pb.setOverrideGlAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set tax_authority_party to head entity                        
                        if(relationsDemand.contains("tax_authority_party")) {
                            getRelationValues(ctx, p1, "tax_authority_party",
                                            Party.class)
                                    .forEach(el -> pb.setTaxAuthorityParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set tax_authority_rate_product to head entity                        
                        if(relationsDemand.contains("tax_authority_rate_product")) {
                            getRelationValues(ctx, p1, "tax_authority_rate_product",
                                            TaxAuthorityRateProduct.class)
                                    .forEach(el -> pb.setTaxAuthorityRateProduct(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set override_org_party to head entity                        
                        if(relationsDemand.contains("override_org_party")) {
                            getRelationValues(ctx, p1, "override_org_party",
                                            Party.class)
                                    .forEach(el -> pb.setOverrideOrgParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_adjustment_billing to head entity                        
                        if(relationsDemand.contains("order_adjustment_billing")) {
                            getRelationValues(ctx, p1, "order_adjustment_billing",
                                            OrderAdjustmentBilling.class)
                                    .forEach(el -> pb.addOrderAdjustmentBilling(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_item_billing to head entity                        
                        if(relationsDemand.contains("order_item_billing")) {
                            getRelationValues(ctx, p1, "order_item_billing",
                                            OrderItemBilling.class)
                                    .forEach(el -> pb.addOrderItemBilling(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set payment_application to head entity                        
                        if(relationsDemand.contains("payment_application")) {
                            getRelationValues(ctx, p1, "payment_application",
                                            PaymentApplication.class)
                                    .forEach(el -> pb.addPaymentApplication(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set shipment_item_billing to head entity                        
                        if(relationsDemand.contains("shipment_item_billing")) {
                            getRelationValues(ctx, p1, "shipment_item_billing",
                                            ShipmentItemBilling.class)
                                    .forEach(el -> pb.addShipmentItemBilling(
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


    
    public InvoiceItem.InvoiceItemBuilder seed(){
        return InvoiceItem.builder()
                .id(sequence.nextStringId());
    }
}
