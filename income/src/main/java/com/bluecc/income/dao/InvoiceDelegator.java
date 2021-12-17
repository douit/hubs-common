package com.bluecc.income.dao;

import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.procs.Buckets;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
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

import com.bluecc.hubs.stub.InvoiceData;

public class InvoiceDelegator extends AbstractProcs implements IChainQuery<Invoice>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(Invoice.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from invoice")
        List<Invoice> listInvoice();
        @SqlQuery("select * from invoice where invoice_id=:id")
        Invoice getInvoice(@Bind("id") String id);

        @SqlQuery("select count(*) from invoice")
        int countInvoice();

        // for relations
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = Party.class, prefix = "fpo")
        default Map<String, Invoice> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainFromParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = Party.class, prefix = "fpo")
        default Map<String, Invoice> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("fpo_party_id", String.class) != null) {
                            p.getRelFromParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, Invoice> chainParty(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = Party.class, prefix = "pao")
        default Map<String, Invoice> chainParty(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("pao_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "pro")
        default Map<String, Invoice> chainPartyRole(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainPartyRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "pro")
        default Map<String, Invoice> chainPartyRole(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARTY_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("pro_party_id", String.class) != null) {
                            p.getRelPartyRole()
                                    .add(rr.getRow(PartyRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "bao")
        default Map<String, Invoice> chainBillingAccount(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainBillingAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "bao")
        default Map<String, Invoice> chainBillingAccount(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(BILLING_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("bao_billing_account_id", String.class) != null) {
                            p.getRelBillingAccount()
                                    .add(rr.getRow(BillingAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cmo")
        default Map<String, Invoice> chainContactMech(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainContactMech(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cmo")
        default Map<String, Invoice> chainContactMech(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CONTACT_MECH);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("cmo_contact_mech_id", String.class) != null) {
                            p.getRelContactMech()
                                    .add(rr.getRow(ContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "rio")
        default Map<String, Invoice> chainRecurrenceInfo(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainRecurrenceInfo(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "rio")
        default Map<String, Invoice> chainRecurrenceInfo(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(RECURRENCE_INFO);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("rio_recurrence_info_id", String.class) != null) {
                            p.getRelRecurrenceInfo()
                                    .add(rr.getRow(RecurrenceInfo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Invoice> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Invoice> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("atm_invoice_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "iim")
        default Map<String, Invoice> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainInvoiceItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "iim")
        default Map<String, Invoice> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE_ITEM);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("iim_invoice_id", String.class) != null) {
                            p.getRelInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = InvoiceRole.class, prefix = "irm")
        default Map<String, Invoice> chainInvoiceRole(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainInvoiceRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = InvoiceRole.class, prefix = "irm")
        default Map<String, Invoice> chainInvoiceRole(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("irm_invoice_id", String.class) != null) {
                            p.getRelInvoiceRole()
                                    .add(rr.getRow(InvoiceRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "ism")
        default Map<String, Invoice> chainInvoiceStatus(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainInvoiceStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "ism")
        default Map<String, Invoice> chainInvoiceStatus(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE_STATUS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("ism_invoice_id", String.class) != null) {
                            p.getRelInvoiceStatus()
                                    .add(rr.getRow(InvoiceStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = OrderAdjustmentBilling.class, prefix = "oabm")
        default Map<String, Invoice> chainOrderAdjustmentBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainOrderAdjustmentBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = OrderAdjustmentBilling.class, prefix = "oabm")
        default Map<String, Invoice> chainOrderAdjustmentBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ADJUSTMENT_BILLING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("oabm_invoice_id", String.class) != null) {
                            p.getRelOrderAdjustmentBilling()
                                    .add(rr.getRow(OrderAdjustmentBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oibm")
        default Map<String, Invoice> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainOrderItemBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oibm")
        default Map<String, Invoice> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_ITEM_BILLING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("oibm_invoice_id", String.class) != null) {
                            p.getRelOrderItemBilling()
                                    .add(rr.getRow(OrderItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pam")
        default Map<String, Invoice> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainPaymentApplication(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pam")
        default Map<String, Invoice> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_APPLICATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("pam_invoice_id", String.class) != null) {
                            p.getRelPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sibm")
        default Map<String, Invoice> chainShipmentItemBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainShipmentItemBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sibm")
        default Map<String, Invoice> chainShipmentItemBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SHIPMENT_ITEM_BILLING);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("sibm_invoice_id", String.class) != null) {
                            p.getRelShipmentItemBilling()
                                    .add(rr.getRow(ShipmentItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Invoice> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "inz")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Invoice> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Invoice", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Invoice p = map.computeIfAbsent(rr.getColumn("inz_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, Invoice>> fromParty(Dao dao, boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> fromParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> party(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> partyRole(Dao dao, boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> partyRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> billingAccount(Dao dao, boolean succ) {
        return e -> dao.chainBillingAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> billingAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainBillingAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> contactMech(Dao dao, boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> contactMech(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> recurrenceInfo(Dao dao, boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> recurrenceInfo(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> acctgTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> invoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> invoiceItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> invoiceRole(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> invoiceRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> invoiceStatus(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> invoiceStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> orderAdjustmentBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderAdjustmentBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> orderAdjustmentBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderAdjustmentBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> orderItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> orderItemBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> paymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> paymentApplication(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> shipmentItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> shipmentItemBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Invoice>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, Invoice>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, Invoice> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, Invoice> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, Invoice> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, Invoice>> chain = tenant(dao, false);
         
        if (incls.contains(FROM_PARTY)) {
            chain = chain.andThen(fromParty(dao, true));
        }
         
        if (incls.contains(PARTY)) {
            chain = chain.andThen(party(dao, true));
        }
         
        if (incls.contains(PARTY_ROLE)) {
            chain = chain.andThen(partyRole(dao, true));
        }
         
        if (incls.contains(BILLING_ACCOUNT)) {
            chain = chain.andThen(billingAccount(dao, true));
        }
         
        if (incls.contains(CONTACT_MECH)) {
            chain = chain.andThen(contactMech(dao, true));
        }
         
        if (incls.contains(RECURRENCE_INFO)) {
            chain = chain.andThen(recurrenceInfo(dao, true));
        }
         
        if (incls.contains(ACCTG_TRANS)) {
            chain = chain.andThen(acctgTrans(dao, true));
        }
         
        if (incls.contains(INVOICE_ITEM)) {
            chain = chain.andThen(invoiceItem(dao, true));
        }
         
        if (incls.contains(INVOICE_ROLE)) {
            chain = chain.andThen(invoiceRole(dao, true));
        }
         
        if (incls.contains(INVOICE_STATUS)) {
            chain = chain.andThen(invoiceStatus(dao, true));
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
                                   StreamObserver<InvoiceData> responseObserver) {
        Map<String, Invoice> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            InvoiceData.Builder invoiceData = data.toHeadBuilder();
             
            data.getRelFromParty().forEach(e -> 
                invoiceData.setFromParty(e.toHeadBuilder())); 
            data.getRelParty().forEach(e -> 
                invoiceData.setParty(e.toHeadBuilder())); 
            data.getRelPartyRole().forEach(e -> 
                invoiceData.setPartyRole(e.toDataBuilder())); 
            data.getRelBillingAccount().forEach(e -> 
                invoiceData.setBillingAccount(e.toHeadBuilder())); 
            data.getRelContactMech().forEach(e -> 
                invoiceData.setContactMech(e.toDataBuilder())); 
            data.getRelRecurrenceInfo().forEach(e -> 
                invoiceData.setRecurrenceInfo(e.toDataBuilder())); 
            data.getRelAcctgTrans().forEach(e -> 
                invoiceData.addAcctgTrans(e.toDataBuilder())); 
            data.getRelInvoiceItem().forEach(e -> 
                invoiceData.addInvoiceItem(e.toHeadBuilder())); 
            data.getRelInvoiceRole().forEach(e -> 
                invoiceData.addInvoiceRole(e.toDataBuilder())); 
            data.getRelInvoiceStatus().forEach(e -> 
                invoiceData.addInvoiceStatus(e.toDataBuilder())); 
            data.getRelOrderAdjustmentBilling().forEach(e -> 
                invoiceData.addOrderAdjustmentBilling(e.toDataBuilder())); 
            data.getRelOrderItemBilling().forEach(e -> 
                invoiceData.addOrderItemBilling(e.toDataBuilder())); 
            data.getRelPaymentApplication().forEach(e -> 
                invoiceData.addPaymentApplication(e.toDataBuilder())); 
            data.getRelShipmentItemBilling().forEach(e -> 
                invoiceData.addShipmentItemBilling(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                invoiceData.setTenant(e.toDataBuilder()));
            return invoiceData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public Invoice get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getInvoice(id);
    }

    public List<Invoice> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listInvoice();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countInvoice();
    }


    public void store(Invoice invoice){
        store(invoice, true);
    }

    public void store(Invoice invoice, boolean genId){
        process(c ->{
            if(genId){
                invoice.setInvoiceId(sequence.nextStringId());
            }
            storeOrUpdate(c, invoice.toData());
        });
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "Invoice", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Invoice rec;
        final Message p1;
        Invoice persistObject;

        Agent(IProc.ProcContext ctx, Invoice rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Invoice getRecord(){
            return rec;
        }

        public Invoice merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<Party> getFromParty(){
            return getRelationValues(ctx, p1, "from_party", Party.class);
        }

        public List<Party> mergeFromParty(){
            return getFromParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFromParty().add(c))
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
         
        public List<PartyRole> getPartyRole(){
            return getRelationValues(ctx, p1, "party_role", PartyRole.class);
        }

        public List<PartyRole> mergePartyRole(){
            return getPartyRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPartyRole().add(c))
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
         
        public List<ContactMech> getContactMech(){
            return getRelationValues(ctx, p1, "contact_mech", ContactMech.class);
        }

        public List<ContactMech> mergeContactMech(){
            return getContactMech().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelContactMech().add(c))
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
         
        public List<AcctgTrans> getAcctgTrans(){
            return getRelationValues(ctx, p1, "acctg_trans", AcctgTrans.class);
        }

        public List<AcctgTrans> mergeAcctgTrans(){
            return getAcctgTrans().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelAcctgTrans().add(c))
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
         
        public List<InvoiceRole> getInvoiceRole(){
            return getRelationValues(ctx, p1, "invoice_role", InvoiceRole.class);
        }

        public List<InvoiceRole> mergeInvoiceRole(){
            return getInvoiceRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoiceRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<InvoiceStatus> getInvoiceStatus(){
            return getRelationValues(ctx, p1, "invoice_status", InvoiceStatus.class);
        }

        public List<InvoiceStatus> mergeInvoiceStatus(){
            return getInvoiceStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelInvoiceStatus().add(c))
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
        InvoiceData p = InvoiceData.newBuilder()
                .setInvoiceId(key)
                .build();
        Invoice rec = findOne(ctx, p, Invoice.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, Invoice rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String FROM_PARTY="from_party";
         
    public static final String PARTY="party";
         
    public static final String PARTY_ROLE="party_role";
         
    public static final String BILLING_ACCOUNT="billing_account";
         
    public static final String CONTACT_MECH="contact_mech";
         
    public static final String RECURRENCE_INFO="recurrence_info";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String INVOICE_ITEM="invoice_item";
         
    public static final String INVOICE_ROLE="invoice_role";
         
    public static final String INVOICE_STATUS="invoice_status";
         
    public static final String ORDER_ADJUSTMENT_BILLING="order_adjustment_billing";
         
    public static final String ORDER_ITEM_BILLING="order_item_billing";
         
    public static final String PAYMENT_APPLICATION="payment_application";
         
    public static final String SHIPMENT_ITEM_BILLING="shipment_item_billing";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryInvoiceRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            InvoiceData p = InvoiceData.newBuilder()
                    .setInvoiceId(key)
                    .build();
            List<InvoiceData.Builder> ds = find(ctx, p, Invoice.class).stream()
                    .map(e -> {
                        InvoiceData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set from_party to head entity                        
                        if(relationsDemand.contains("from_party")) {
                            getRelationValues(ctx, p1, "from_party",
                                            Party.class)
                                    .forEach(el -> pb.setFromParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party to head entity                        
                        if(relationsDemand.contains("party")) {
                            getRelationValues(ctx, p1, "party",
                                            Party.class)
                                    .forEach(el -> pb.setParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set party_role to head entity                        
                        if(relationsDemand.contains("party_role")) {
                            getRelationValues(ctx, p1, "party_role",
                                            PartyRole.class)
                                    .forEach(el -> pb.setPartyRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set billing_account to head entity                        
                        if(relationsDemand.contains("billing_account")) {
                            getRelationValues(ctx, p1, "billing_account",
                                            BillingAccount.class)
                                    .forEach(el -> pb.setBillingAccount(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set contact_mech to head entity                        
                        if(relationsDemand.contains("contact_mech")) {
                            getRelationValues(ctx, p1, "contact_mech",
                                            ContactMech.class)
                                    .forEach(el -> pb.setContactMech(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set recurrence_info to head entity                        
                        if(relationsDemand.contains("recurrence_info")) {
                            getRelationValues(ctx, p1, "recurrence_info",
                                            RecurrenceInfo.class)
                                    .forEach(el -> pb.setRecurrenceInfo(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice_item to head entity                        
                        if(relationsDemand.contains("invoice_item")) {
                            getRelationValues(ctx, p1, "invoice_item",
                                            InvoiceItem.class)
                                    .forEach(el -> pb.addInvoiceItem(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set invoice_role to head entity                        
                        if(relationsDemand.contains("invoice_role")) {
                            getRelationValues(ctx, p1, "invoice_role",
                                            InvoiceRole.class)
                                    .forEach(el -> pb.addInvoiceRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice_status to head entity                        
                        if(relationsDemand.contains("invoice_status")) {
                            getRelationValues(ctx, p1, "invoice_status",
                                            InvoiceStatus.class)
                                    .forEach(el -> pb.addInvoiceStatus(
                                             el.toDataBuilder().build()));
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


    
    public Invoice.InvoiceBuilder seed(){
        return Invoice.builder()
                .invoiceId(sequence.nextStringId());
    }
}
