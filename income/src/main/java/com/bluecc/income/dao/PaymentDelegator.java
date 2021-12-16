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
import com.bluecc.hubs.stub.PaymentData;

public class PaymentDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(Payment.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from payment")
        List<Payment> listPayment();
        @SqlQuery("select * from payment where payment_id=:id")
        Payment getPayment(@Bind("id") String id);

        @SqlQuery("select count(*) from payment")
        int countPayment();

        // for relations
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pm")
        default Map<String, Payment> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainPaymentMethod(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pm")
        default Map<String, Payment> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_METHOD);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("pm_payment_method_id", String.class) != null) {
                            p.getRelPaymentMethod()
                                    .add(rr.getRow(PaymentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = CreditCard.class, prefix = "cc")
        default Map<String, Payment> chainCreditCard(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainCreditCard(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = CreditCard.class, prefix = "cc")
        default Map<String, Payment> chainCreditCard(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREDIT_CARD);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("cc_payment_method_id", String.class) != null) {
                            p.getRelCreditCard()
                                    .add(rr.getRow(CreditCard.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = EftAccount.class, prefix = "ea")
        default Map<String, Payment> chainEftAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainEftAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = EftAccount.class, prefix = "ea")
        default Map<String, Payment> chainEftAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(EFT_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("ea_payment_method_id", String.class) != null) {
                            p.getRelEftAccount()
                                    .add(rr.getRow(EftAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "opp")
        default Map<String, Payment> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainOrderPaymentPreference(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "opp")
        default Map<String, Payment> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_PAYMENT_PREFERENCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("opp_order_payment_preference_id", String.class) != null) {
                            p.getRelOrderPaymentPreference()
                                    .add(rr.getRow(OrderPaymentPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentGatewayResponse.class, prefix = "pgr")
        default Map<String, Payment> chainPaymentGatewayResponse(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainPaymentGatewayResponse(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentGatewayResponse.class, prefix = "pgr")
        default Map<String, Payment> chainPaymentGatewayResponse(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_GATEWAY_RESPONSE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("pgr_payment_gateway_response_id", String.class) != null) {
                            p.getRelPaymentGatewayResponse()
                                    .add(rr.getRow(PaymentGatewayResponse.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "fp")
        default Map<String, Payment> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainFromParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "fp")
        default Map<String, Payment> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("fp_party_id", String.class) != null) {
                            p.getRelFromParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "tp")
        default Map<String, Payment> chainToParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainToParty(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "tp")
        default Map<String, Payment> chainToParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PARTY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("tp_party_id", String.class) != null) {
                            p.getRelToParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "tpr")
        default Map<String, Payment> chainToPartyRole(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainToPartyRole(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "tpr")
        default Map<String, Payment> chainToPartyRole(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PARTY_ROLE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("tpr_party_id", String.class) != null) {
                            p.getRelToPartyRole()
                                    .add(rr.getRow(PartyRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fat")
        default Map<String, Payment> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainFinAccountTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fat")
        default Map<String, Payment> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("fat_fin_account_trans_id", String.class) != null) {
                            p.getRelFinAccountTrans()
                                    .add(rr.getRow(FinAccountTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "ga")
        default Map<String, Payment> chainGlAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainGlAccount(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "ga")
        default Map<String, Payment> chainGlAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(GL_ACCOUNT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("ga_gl_account_id", String.class) != null) {
                            p.getRelGlAccount()
                                    .add(rr.getRow(GlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "at")
        default Map<String, Payment> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "at")
        default Map<String, Payment> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("at_payment_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pa")
        default Map<String, Payment> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainPaymentApplication(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pa")
        default Map<String, Payment> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_APPLICATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("pa_payment_id", String.class) != null) {
                            p.getRelPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "tpa")
        default Map<String, Payment> chainToPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainToPaymentApplication(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "tpa")
        default Map<String, Payment> chainToPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PAYMENT_APPLICATION);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("tpa_to_payment_id", String.class) != null) {
                            p.getRelToPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, Payment>> paymentMethod(Dao dao, boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> paymentMethod(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> creditCard(Dao dao, boolean succ) {
        return e -> dao.chainCreditCard(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> creditCard(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCreditCard(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> eftAccount(Dao dao, boolean succ) {
        return e -> dao.chainEftAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> eftAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainEftAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> orderPaymentPreference(Dao dao, boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> orderPaymentPreference(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> paymentGatewayResponse(Dao dao, boolean succ) {
        return e -> dao.chainPaymentGatewayResponse(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> paymentGatewayResponse(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentGatewayResponse(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> fromParty(Dao dao, boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> fromParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> toParty(Dao dao, boolean succ) {
        return e -> dao.chainToParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> toParty(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> toPartyRole(Dao dao, boolean succ) {
        return e -> dao.chainToPartyRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> toPartyRole(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToPartyRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> finAccountTrans(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> finAccountTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> glAccount(Dao dao, boolean succ) {
        return e -> dao.chainGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> glAccount(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> acctgTrans(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> paymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> paymentApplication(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> toPaymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainToPaymentApplication(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> toPaymentApplication(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainToPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
    

    public Payment get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getPayment(id);
    }

    public List<Payment> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listPayment();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countPayment();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final Payment rec;
        final Message p1;
        Payment persistObject;

        Agent(IProc.ProcContext ctx, Payment rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public Payment getRecord(){
            return rec;
        }

        public Payment merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
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
         
        public List<CreditCard> getCreditCard(){
            return getRelationValues(ctx, p1, "credit_card", CreditCard.class);
        }

        public List<CreditCard> mergeCreditCard(){
            return getCreditCard().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCreditCard().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<EftAccount> getEftAccount(){
            return getRelationValues(ctx, p1, "eft_account", EftAccount.class);
        }

        public List<EftAccount> mergeEftAccount(){
            return getEftAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEftAccount().add(c))
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
         
        public List<PaymentGatewayResponse> getPaymentGatewayResponse(){
            return getRelationValues(ctx, p1, "payment_gateway_response", PaymentGatewayResponse.class);
        }

        public List<PaymentGatewayResponse> mergePaymentGatewayResponse(){
            return getPaymentGatewayResponse().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPaymentGatewayResponse().add(c))
                    .collect(Collectors.toList());
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
         
        public List<Party> getToParty(){
            return getRelationValues(ctx, p1, "to_party", Party.class);
        }

        public List<Party> mergeToParty(){
            return getToParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToParty().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PartyRole> getToPartyRole(){
            return getRelationValues(ctx, p1, "to_party_role", PartyRole.class);
        }

        public List<PartyRole> mergeToPartyRole(){
            return getToPartyRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToPartyRole().add(c))
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
         
        public List<GlAccount> getGlAccount(){
            return getRelationValues(ctx, p1, "gl_account", GlAccount.class);
        }

        public List<GlAccount> mergeGlAccount(){
            return getGlAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelGlAccount().add(c))
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
         
        public List<PaymentApplication> getPaymentApplication(){
            return getRelationValues(ctx, p1, "payment_application", PaymentApplication.class);
        }

        public List<PaymentApplication> mergePaymentApplication(){
            return getPaymentApplication().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPaymentApplication().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PaymentApplication> getToPaymentApplication(){
            return getRelationValues(ctx, p1, "to_payment_application", PaymentApplication.class);
        }

        public List<PaymentApplication> mergeToPaymentApplication(){
            return getToPaymentApplication().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelToPaymentApplication().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        PaymentData p = PaymentData.newBuilder()
                .setPaymentId(key)
                .build();
        Payment rec = findOne(ctx, p, Payment.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, Payment rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PAYMENT_METHOD="payment_method";
         
    public static final String CREDIT_CARD="credit_card";
         
    public static final String EFT_ACCOUNT="eft_account";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String PAYMENT_GATEWAY_RESPONSE="payment_gateway_response";
         
    public static final String FROM_PARTY="from_party";
         
    public static final String TO_PARTY="to_party";
         
    public static final String TO_PARTY_ROLE="to_party_role";
         
    public static final String FIN_ACCOUNT_TRANS="fin_account_trans";
         
    public static final String GL_ACCOUNT="gl_account";
         
    public static final String ACCTG_TRANS="acctg_trans";
         
    public static final String PAYMENT_APPLICATION="payment_application";
         
    public static final String TO_PAYMENT_APPLICATION="to_payment_application";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryPaymentRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            PaymentData p = PaymentData.newBuilder()
                    .setPaymentId(key)
                    .build();
            List<PaymentData.Builder> ds = find(ctx, p, Payment.class).stream()
                    .map(e -> {
                        PaymentData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set payment_method to head entity                        
                        if(relationsDemand.contains("payment_method")) {
                            getRelationValues(ctx, p1, "payment_method",
                                            PaymentMethod.class)
                                    .forEach(el -> pb.setPaymentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set credit_card to head entity                        
                        if(relationsDemand.contains("credit_card")) {
                            getRelationValues(ctx, p1, "credit_card",
                                            CreditCard.class)
                                    .forEach(el -> pb.setCreditCard(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set eft_account to head entity                        
                        if(relationsDemand.contains("eft_account")) {
                            getRelationValues(ctx, p1, "eft_account",
                                            EftAccount.class)
                                    .forEach(el -> pb.setEftAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_payment_preference to head entity                        
                        if(relationsDemand.contains("order_payment_preference")) {
                            getRelationValues(ctx, p1, "order_payment_preference",
                                            OrderPaymentPreference.class)
                                    .forEach(el -> pb.setOrderPaymentPreference(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set payment_gateway_response to head entity                        
                        if(relationsDemand.contains("payment_gateway_response")) {
                            getRelationValues(ctx, p1, "payment_gateway_response",
                                            PaymentGatewayResponse.class)
                                    .forEach(el -> pb.setPaymentGatewayResponse(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set from_party to head entity                        
                        if(relationsDemand.contains("from_party")) {
                            getRelationValues(ctx, p1, "from_party",
                                            Party.class)
                                    .forEach(el -> pb.setFromParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set to_party to head entity                        
                        if(relationsDemand.contains("to_party")) {
                            getRelationValues(ctx, p1, "to_party",
                                            Party.class)
                                    .forEach(el -> pb.setToParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set to_party_role to head entity                        
                        if(relationsDemand.contains("to_party_role")) {
                            getRelationValues(ctx, p1, "to_party_role",
                                            PartyRole.class)
                                    .forEach(el -> pb.setToPartyRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_trans to head entity                        
                        if(relationsDemand.contains("fin_account_trans")) {
                            getRelationValues(ctx, p1, "fin_account_trans",
                                            FinAccountTrans.class)
                                    .forEach(el -> pb.setFinAccountTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set gl_account to head entity                        
                        if(relationsDemand.contains("gl_account")) {
                            getRelationValues(ctx, p1, "gl_account",
                                            GlAccount.class)
                                    .forEach(el -> pb.setGlAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set acctg_trans to head entity                        
                        if(relationsDemand.contains("acctg_trans")) {
                            getRelationValues(ctx, p1, "acctg_trans",
                                            AcctgTrans.class)
                                    .forEach(el -> pb.addAcctgTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set payment_application to head entity                        
                        if(relationsDemand.contains("payment_application")) {
                            getRelationValues(ctx, p1, "payment_application",
                                            PaymentApplication.class)
                                    .forEach(el -> pb.addPaymentApplication(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set to_payment_application to head entity                        
                        if(relationsDemand.contains("to_payment_application")) {
                            getRelationValues(ctx, p1, "to_payment_application",
                                            PaymentApplication.class)
                                    .forEach(el -> pb.addToPaymentApplication(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
    public Payment.PaymentBuilder seed(){
        return Payment.builder()
                .paymentId(sequence.nextStringId());
    }
}
