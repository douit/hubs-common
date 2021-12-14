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
import com.bluecc.hubs.stub.InvoiceData;

public class InvoiceDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(Invoice.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from invoice")
        List<Invoice> listInvoice();
        @SqlQuery("select * from invoice where invoice_id=:id")
        Invoice getInvoice(@Bind("id") String id);

        @SqlQuery("select count(*) from invoice")
        int countInvoice();

        // for relations
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = Party.class, prefix = "fp")
        default Map<String, Invoice> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainFromParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = Party.class, prefix = "fp")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("fp_party_id", String.class) != null) {
                            p.getRelFromParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
        default Map<String, Invoice> chainParty(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = Party.class, prefix = "pa")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("pa_party_id", String.class) != null) {
                            p.getRelParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "pr")
        default Map<String, Invoice> chainPartyRole(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainPartyRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "pr")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("pr_party_id", String.class) != null) {
                            p.getRelPartyRole()
                                    .add(rr.getRow(PartyRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        default Map<String, Invoice> chainBillingAccount(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainBillingAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("ba_billing_account_id", String.class) != null) {
                            p.getRelBillingAccount()
                                    .add(rr.getRow(BillingAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cm")
        default Map<String, Invoice> chainContactMech(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainContactMech(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cm")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("cm_contact_mech_id", String.class) != null) {
                            p.getRelContactMech()
                                    .add(rr.getRow(ContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "ri")
        default Map<String, Invoice> chainRecurrenceInfo(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainRecurrenceInfo(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = RecurrenceInfo.class, prefix = "ri")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("ri_recurrence_info_id", String.class) != null) {
                            p.getRelRecurrenceInfo()
                                    .add(rr.getRow(RecurrenceInfo.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "at")
        default Map<String, Invoice> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "at")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("at_invoice_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
        default Map<String, Invoice> chainInvoiceItem(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainInvoiceItem(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = InvoiceItem.class, prefix = "ii")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("ii_invoice_id", String.class) != null) {
                            p.getRelInvoiceItem()
                                    .add(rr.getRow(InvoiceItem.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = InvoiceRole.class, prefix = "ir")
        default Map<String, Invoice> chainInvoiceRole(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainInvoiceRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = InvoiceRole.class, prefix = "ir")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("ir_invoice_id", String.class) != null) {
                            p.getRelInvoiceRole()
                                    .add(rr.getRow(InvoiceRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "is")
        default Map<String, Invoice> chainInvoiceStatus(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainInvoiceStatus(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = InvoiceStatus.class, prefix = "is")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("is_invoice_id", String.class) != null) {
                            p.getRelInvoiceStatus()
                                    .add(rr.getRow(InvoiceStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = OrderAdjustmentBilling.class, prefix = "oab")
        default Map<String, Invoice> chainOrderAdjustmentBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainOrderAdjustmentBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = OrderAdjustmentBilling.class, prefix = "oab")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("oab_invoice_id", String.class) != null) {
                            p.getRelOrderAdjustmentBilling()
                                    .add(rr.getRow(OrderAdjustmentBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oib")
        default Map<String, Invoice> chainOrderItemBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainOrderItemBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = OrderItemBilling.class, prefix = "oib")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("oib_invoice_id", String.class) != null) {
                            p.getRelOrderItemBilling()
                                    .add(rr.getRow(OrderItemBilling.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pa")
        default Map<String, Invoice> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainPaymentApplication(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pa")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("pa_invoice_id", String.class) != null) {
                            p.getRelPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sib")
        default Map<String, Invoice> chainShipmentItemBilling(ProtoMeta protoMeta,
                                               Map<String, Invoice> inMap,
                                               boolean succInvoke) {
            return chainShipmentItemBilling(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Invoice.class, prefix = "in")
        @RegisterBeanMapper(value = ShipmentItemBilling.class, prefix = "sib")
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
                        Invoice p = map.computeIfAbsent(rr.getColumn("in_invoice_id", String.class),
                                id -> rr.getRow(Invoice.class));
                        if (rr.getColumn("sib_invoice_id", String.class) != null) {
                            p.getRelShipmentItemBilling()
                                    .add(rr.getRow(ShipmentItemBilling.class));
                        }
                        return map;
                    });
        }
        
    }

     
    Consumer<Map<String, Invoice>> fromParty(Dao dao, boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> fromParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> party(Dao dao, boolean succ) {
        return e -> dao.chainParty(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> party(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParty(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> partyRole(Dao dao, boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> partyRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPartyRole(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> billingAccount(Dao dao, boolean succ) {
        return e -> dao.chainBillingAccount(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> billingAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainBillingAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> contactMech(Dao dao, boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> contactMech(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> recurrenceInfo(Dao dao, boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> recurrenceInfo(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainRecurrenceInfo(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> acctgTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> invoiceItem(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> invoiceItem(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceItem(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> invoiceRole(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceRole(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> invoiceRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceRole(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> invoiceStatus(Dao dao, boolean succ) {
        return e -> dao.chainInvoiceStatus(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> invoiceStatus(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainInvoiceStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> orderAdjustmentBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderAdjustmentBilling(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> orderAdjustmentBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderAdjustmentBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> orderItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> orderItemBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderItemBilling(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> paymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> paymentApplication(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, Invoice>> shipmentItemBilling(Dao dao, boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, succ);
    }

    Consumer<Map<String, Invoice>> shipmentItemBilling(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainShipmentItemBilling(protoMeta, e, whereClause, binds, succ);
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
