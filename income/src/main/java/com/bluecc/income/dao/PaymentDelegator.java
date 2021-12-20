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

import com.bluecc.hubs.stub.PaymentData;

public class PaymentDelegator extends AbstractProcs implements IChainQuery<Payment>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

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
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmo")
        default Map<String, Payment> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainPaymentMethod(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmo")
        default Map<String, Payment> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_METHOD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("pmo_payment_method_id", String.class) != null) {
                            p.getRelPaymentMethod()
                                    .add(rr.getRow(PaymentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = CreditCard.class, prefix = "cco")
        default Map<String, Payment> chainCreditCard(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainCreditCard(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = CreditCard.class, prefix = "cco")
        default Map<String, Payment> chainCreditCard(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CREDIT_CARD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("cco_payment_method_id", String.class) != null) {
                            p.getRelCreditCard()
                                    .add(rr.getRow(CreditCard.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = EftAccount.class, prefix = "eao")
        default Map<String, Payment> chainEftAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainEftAccount(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = EftAccount.class, prefix = "eao")
        default Map<String, Payment> chainEftAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(EFT_ACCOUNT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("eao_payment_method_id", String.class) != null) {
                            p.getRelEftAccount()
                                    .add(rr.getRow(EftAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppo")
        default Map<String, Payment> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainOrderPaymentPreference(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppo")
        default Map<String, Payment> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_PAYMENT_PREFERENCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("oppo_order_payment_preference_id", String.class) != null) {
                            p.getRelOrderPaymentPreference()
                                    .add(rr.getRow(OrderPaymentPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentGatewayResponse.class, prefix = "pgro")
        default Map<String, Payment> chainPaymentGatewayResponse(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainPaymentGatewayResponse(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentGatewayResponse.class, prefix = "pgro")
        default Map<String, Payment> chainPaymentGatewayResponse(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_GATEWAY_RESPONSE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("pgro_payment_gateway_response_id", String.class) != null) {
                            p.getRelPaymentGatewayResponse()
                                    .add(rr.getRow(PaymentGatewayResponse.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "fpo")
        default Map<String, Payment> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainFromParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "fpo")
        default Map<String, Payment> chainFromParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FROM_PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("fpo_party_id", String.class) != null) {
                            p.getRelFromParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "tpo")
        default Map<String, Payment> chainToParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainToParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Party.class, prefix = "tpo")
        default Map<String, Payment> chainToParty(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("tpo_party_id", String.class) != null) {
                            p.getRelToParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "tpro")
        default Map<String, Payment> chainToPartyRole(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainToPartyRole(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PartyRole.class, prefix = "tpro")
        default Map<String, Payment> chainToPartyRole(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PARTY_ROLE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("tpro_party_id", String.class) != null) {
                            p.getRelToPartyRole()
                                    .add(rr.getRow(PartyRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fato")
        default Map<String, Payment> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainFinAccountTrans(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fato")
        default Map<String, Payment> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_TRANS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("fato_fin_account_trans_id", String.class) != null) {
                            p.getRelFinAccountTrans()
                                    .add(rr.getRow(FinAccountTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "gao")
        default Map<String, Payment> chainGlAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainGlAccount(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "gao")
        default Map<String, Payment> chainGlAccount(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(GL_ACCOUNT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("gao_gl_account_id", String.class) != null) {
                            p.getRelGlAccount()
                                    .add(rr.getRow(GlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Payment> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainAcctgTrans(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = AcctgTrans.class, prefix = "atm")
        default Map<String, Payment> chainAcctgTrans(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ACCTG_TRANS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("atm_payment_id", String.class) != null) {
                            p.getRelAcctgTrans()
                                    .add(rr.getRow(AcctgTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pam")
        default Map<String, Payment> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainPaymentApplication(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pam")
        default Map<String, Payment> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_APPLICATION);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("pam_payment_id", String.class) != null) {
                            p.getRelPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "tpam")
        default Map<String, Payment> chainToPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainToPaymentApplication(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "tpam")
        default Map<String, Payment> chainToPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TO_PAYMENT_APPLICATION);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("tpam_to_payment_id", String.class) != null) {
                            p.getRelToPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Payment> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = Payment.class, prefix = "pa")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, Payment> chainTenant(ProtoMeta protoMeta,
                                               Map<String, Payment> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("Payment", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        Payment p = map.computeIfAbsent(rr.getColumn("pa_payment_id", String.class),
                                id -> rr.getRow(Payment.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
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
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> creditCard(Dao dao, boolean succ) {
        return e -> dao.chainCreditCard(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> creditCard(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCreditCard(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> eftAccount(Dao dao, boolean succ) {
        return e -> dao.chainEftAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> eftAccount(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainEftAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> orderPaymentPreference(Dao dao, boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> orderPaymentPreference(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> paymentGatewayResponse(Dao dao, boolean succ) {
        return e -> dao.chainPaymentGatewayResponse(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> paymentGatewayResponse(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPaymentGatewayResponse(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> fromParty(Dao dao, boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> fromParty(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFromParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> toParty(Dao dao, boolean succ) {
        return e -> dao.chainToParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> toParty(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainToParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> toPartyRole(Dao dao, boolean succ) {
        return e -> dao.chainToPartyRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> toPartyRole(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainToPartyRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> finAccountTrans(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> finAccountTrans(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> glAccount(Dao dao, boolean succ) {
        return e -> dao.chainGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> glAccount(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> acctgTrans(Dao dao, boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> acctgTrans(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainAcctgTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> paymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> paymentApplication(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> toPaymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainToPaymentApplication(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> toPaymentApplication(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainToPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, Payment>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, Payment>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, Payment> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, Payment> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, Payment> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, Payment> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, Payment>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PAYMENT_METHOD)) {
            chain = chain.andThen(paymentMethod(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CREDIT_CARD)) {
            chain = chain.andThen(creditCard(dao, whereClause, binds, true));
        }
         
        if (incls.contains(EFT_ACCOUNT)) {
            chain = chain.andThen(eftAccount(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_PAYMENT_PREFERENCE)) {
            chain = chain.andThen(orderPaymentPreference(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PAYMENT_GATEWAY_RESPONSE)) {
            chain = chain.andThen(paymentGatewayResponse(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FROM_PARTY)) {
            chain = chain.andThen(fromParty(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TO_PARTY)) {
            chain = chain.andThen(toParty(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TO_PARTY_ROLE)) {
            chain = chain.andThen(toPartyRole(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_TRANS)) {
            chain = chain.andThen(finAccountTrans(dao, whereClause, binds, true));
        }
         
        if (incls.contains(GL_ACCOUNT)) {
            chain = chain.andThen(glAccount(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ACCTG_TRANS)) {
            chain = chain.andThen(acctgTrans(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PAYMENT_APPLICATION)) {
            chain = chain.andThen(paymentApplication(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TO_PAYMENT_APPLICATION)) {
            chain = chain.andThen(toPaymentApplication(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<PaymentData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<PaymentData> responseObserver) {

        Map<String, Payment> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            PaymentData.Builder paymentData = data.toHeadBuilder();
             
            data.getRelPaymentMethod().forEach(e -> 
                paymentData.setPaymentMethod(e.toDataBuilder())); 
            data.getRelCreditCard().forEach(e -> 
                paymentData.setCreditCard(e.toDataBuilder())); 
            data.getRelEftAccount().forEach(e -> 
                paymentData.setEftAccount(e.toDataBuilder())); 
            data.getRelOrderPaymentPreference().forEach(e -> 
                paymentData.setOrderPaymentPreference(e.toDataBuilder())); 
            data.getRelPaymentGatewayResponse().forEach(e -> 
                paymentData.setPaymentGatewayResponse(e.toDataBuilder())); 
            data.getRelFromParty().forEach(e -> 
                paymentData.setFromParty(e.toHeadBuilder())); 
            data.getRelToParty().forEach(e -> 
                paymentData.setToParty(e.toHeadBuilder())); 
            data.getRelToPartyRole().forEach(e -> 
                paymentData.setToPartyRole(e.toDataBuilder())); 
            data.getRelFinAccountTrans().forEach(e -> 
                paymentData.setFinAccountTrans(e.toDataBuilder())); 
            data.getRelGlAccount().forEach(e -> 
                paymentData.setGlAccount(e.toDataBuilder())); 
            data.getRelAcctgTrans().forEach(e -> 
                paymentData.addAcctgTrans(e.toDataBuilder())); 
            data.getRelPaymentApplication().forEach(e -> 
                paymentData.addPaymentApplication(e.toDataBuilder())); 
            data.getRelToPaymentApplication().forEach(e -> 
                paymentData.addToPaymentApplication(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                paymentData.setTenant(e.toDataBuilder()));
            return paymentData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public Payment get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getPayment(id);
    }

    @Get("/payments/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Payment get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<Payment> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listPayment();
    }

    @Get("/payments")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<Payment> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countPayment();
    }

    @Get("/payments/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/payments")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(Payment payment){
        return store(payment, true);
    }

    @Put("/payments")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(Payment payment){
        return store(payment, false);
    }

    public String store(Payment payment, boolean genId){
        process(c ->{
            if(genId){
                payment.setPaymentId(sequence.nextStringId());
            }
            storeOrUpdate(c, payment.toData());
        });
        return payment.getPaymentId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "Payment", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
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
         
    public static final String TENANT="tenant";
    

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


    
    public Payment.PaymentBuilder seed(){
        return Payment.builder()
                .paymentId(sequence.nextStringId());
    }
}
