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

import com.bluecc.hubs.stub.FinAccountData;

public class FinAccountDelegator extends AbstractProcs implements IChainQuery<FinAccount>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(FinAccount.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from fin_account")
        List<FinAccount> listFinAccount();
        @SqlQuery("select * from fin_account where fin_account_id=:id")
        FinAccount getFinAccount(@Bind("id") String id);

        @SqlQuery("select count(*) from fin_account")
        int countFinAccount();

        // for relations
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = Party.class, prefix = "opo")
        default Map<String, FinAccount> chainOrganizationParty(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainOrganizationParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = Party.class, prefix = "opo")
        default Map<String, FinAccount> chainOrganizationParty(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORGANIZATION_PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("opo_party_id", String.class) != null) {
                            p.getRelOrganizationParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = Party.class, prefix = "opo")
        default Map<String, FinAccount> chainOwnerParty(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainOwnerParty(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = Party.class, prefix = "opo")
        default Map<String, FinAccount> chainOwnerParty(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(OWNER_PARTY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("opo_party_id", String.class) != null) {
                            p.getRelOwnerParty()
                                    .add(rr.getRow(Party.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "ptgao")
        default Map<String, FinAccount> chainPostToGlAccount(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainPostToGlAccount(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = GlAccount.class, prefix = "ptgao")
        default Map<String, FinAccount> chainPostToGlAccount(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(POST_TO_GL_ACCOUNT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("ptgao_gl_account_id", String.class) != null) {
                            p.getRelPostToGlAccount()
                                    .add(rr.getRow(GlAccount.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "rpmo")
        default Map<String, FinAccount> chainReplenishPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainReplenishPaymentMethod(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "rpmo")
        default Map<String, FinAccount> chainReplenishPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(REPLENISH_PAYMENT_METHOD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("rpmo_payment_method_id", String.class) != null) {
                            p.getRelReplenishPaymentMethod()
                                    .add(rr.getRow(PaymentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = FinAccountRole.class, prefix = "farm")
        default Map<String, FinAccount> chainFinAccountRole(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainFinAccountRole(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = FinAccountRole.class, prefix = "farm")
        default Map<String, FinAccount> chainFinAccountRole(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_ROLE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("farm_fin_account_id", String.class) != null) {
                            p.getRelFinAccountRole()
                                    .add(rr.getRow(FinAccountRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = FinAccountStatus.class, prefix = "fasm")
        default Map<String, FinAccount> chainFinAccountStatus(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainFinAccountStatus(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = FinAccountStatus.class, prefix = "fasm")
        default Map<String, FinAccount> chainFinAccountStatus(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_STATUS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("fasm_fin_account_id", String.class) != null) {
                            p.getRelFinAccountStatus()
                                    .add(rr.getRow(FinAccountStatus.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fatm")
        default Map<String, FinAccount> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainFinAccountTrans(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = FinAccountTrans.class, prefix = "fatm")
        default Map<String, FinAccount> chainFinAccountTrans(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FIN_ACCOUNT_TRANS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("fatm_fin_account_id", String.class) != null) {
                            p.getRelFinAccountTrans()
                                    .add(rr.getRow(FinAccountTrans.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, FinAccount> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainOrderPaymentPreference(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = OrderPaymentPreference.class, prefix = "oppm")
        default Map<String, FinAccount> chainOrderPaymentPreference(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_PAYMENT_PREFERENCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("oppm_fin_account_id", String.class) != null) {
                            p.getRelOrderPaymentPreference()
                                    .add(rr.getRow(OrderPaymentPreference.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmm")
        default Map<String, FinAccount> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainPaymentMethod(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = PaymentMethod.class, prefix = "pmm")
        default Map<String, FinAccount> chainPaymentMethod(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_METHOD);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("pmm_fin_account_id", String.class) != null) {
                            p.getRelPaymentMethod()
                                    .add(rr.getRow(PaymentMethod.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, FinAccount> chainTenant(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = FinAccount.class, prefix = "fa")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, FinAccount> chainTenant(ProtoMeta protoMeta,
                                               Map<String, FinAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("FinAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        FinAccount p = map.computeIfAbsent(rr.getColumn("fa_fin_account_id", String.class),
                                id -> rr.getRow(FinAccount.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, FinAccount>> organizationParty(Dao dao, boolean succ) {
        return e -> dao.chainOrganizationParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> organizationParty(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrganizationParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> ownerParty(Dao dao, boolean succ) {
        return e -> dao.chainOwnerParty(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> ownerParty(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOwnerParty(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> postToGlAccount(Dao dao, boolean succ) {
        return e -> dao.chainPostToGlAccount(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> postToGlAccount(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPostToGlAccount(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> replenishPaymentMethod(Dao dao, boolean succ) {
        return e -> dao.chainReplenishPaymentMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> replenishPaymentMethod(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainReplenishPaymentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> finAccountRole(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> finAccountRole(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> finAccountStatus(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountStatus(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> finAccountStatus(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountStatus(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> finAccountTrans(Dao dao, boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> finAccountTrans(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainFinAccountTrans(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> orderPaymentPreference(Dao dao, boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> orderPaymentPreference(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderPaymentPreference(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> paymentMethod(Dao dao, boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> paymentMethod(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPaymentMethod(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, FinAccount>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, FinAccount>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, FinAccount> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, FinAccount> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, FinAccount> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, FinAccount> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, FinAccount>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(ORGANIZATION_PARTY)) {
            chain = chain.andThen(organizationParty(dao, whereClause, binds, true));
        }
         
        if (incls.contains(OWNER_PARTY)) {
            chain = chain.andThen(ownerParty(dao, whereClause, binds, true));
        }
         
        if (incls.contains(POST_TO_GL_ACCOUNT)) {
            chain = chain.andThen(postToGlAccount(dao, whereClause, binds, true));
        }
         
        if (incls.contains(REPLENISH_PAYMENT_METHOD)) {
            chain = chain.andThen(replenishPaymentMethod(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_ROLE)) {
            chain = chain.andThen(finAccountRole(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_STATUS)) {
            chain = chain.andThen(finAccountStatus(dao, whereClause, binds, true));
        }
         
        if (incls.contains(FIN_ACCOUNT_TRANS)) {
            chain = chain.andThen(finAccountTrans(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_PAYMENT_PREFERENCE)) {
            chain = chain.andThen(orderPaymentPreference(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PAYMENT_METHOD)) {
            chain = chain.andThen(paymentMethod(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<FinAccountData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<FinAccountData> responseObserver) {

        Map<String, FinAccount> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            FinAccountData.Builder finAccountData = data.toHeadBuilder();
             
            data.getRelOrganizationParty().forEach(e -> 
                finAccountData.setOrganizationParty(e.toHeadBuilder())); 
            data.getRelOwnerParty().forEach(e -> 
                finAccountData.setOwnerParty(e.toHeadBuilder())); 
            data.getRelPostToGlAccount().forEach(e -> 
                finAccountData.setPostToGlAccount(e.toDataBuilder())); 
            data.getRelReplenishPaymentMethod().forEach(e -> 
                finAccountData.setReplenishPaymentMethod(e.toDataBuilder())); 
            data.getRelFinAccountRole().forEach(e -> 
                finAccountData.addFinAccountRole(e.toDataBuilder())); 
            data.getRelFinAccountStatus().forEach(e -> 
                finAccountData.addFinAccountStatus(e.toDataBuilder())); 
            data.getRelFinAccountTrans().forEach(e -> 
                finAccountData.addFinAccountTrans(e.toDataBuilder())); 
            data.getRelOrderPaymentPreference().forEach(e -> 
                finAccountData.addOrderPaymentPreference(e.toDataBuilder())); 
            data.getRelPaymentMethod().forEach(e -> 
                finAccountData.addPaymentMethod(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                finAccountData.setTenant(e.toDataBuilder()));
            return finAccountData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public FinAccount get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getFinAccount(id);
    }

    @Get("/fin_accounts/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public FinAccount get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<FinAccount> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listFinAccount();
    }

    @Get("/fin_accounts")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<FinAccount> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countFinAccount();
    }

    @Get("/fin_accounts/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/fin_accounts")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(FinAccount finAccount){
        return store(finAccount, true);
    }

    @Put("/fin_accounts")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(FinAccount finAccount){
        return store(finAccount, false);
    }

    public String store(FinAccount finAccount, boolean genId){
        process(c ->{
            if(genId){
                finAccount.setFinAccountId(sequence.nextStringId());
            }
            storeOrUpdate(c, finAccount.toData());
        });
        return finAccount.getFinAccountId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "FinAccount", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final FinAccount rec;
        final Message p1;
        FinAccount persistObject;

        Agent(IProc.ProcContext ctx, FinAccount rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public FinAccount getRecord(){
            return rec;
        }

        public FinAccount merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<Party> getOrganizationParty(){
            return getRelationValues(ctx, p1, "organization_party", Party.class);
        }

        public List<Party> mergeOrganizationParty(){
            return getOrganizationParty().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrganizationParty().add(c))
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
         
        public List<GlAccount> getPostToGlAccount(){
            return getRelationValues(ctx, p1, "post_to_gl_account", GlAccount.class);
        }

        public List<GlAccount> mergePostToGlAccount(){
            return getPostToGlAccount().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelPostToGlAccount().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<PaymentMethod> getReplenishPaymentMethod(){
            return getRelationValues(ctx, p1, "replenish_payment_method", PaymentMethod.class);
        }

        public List<PaymentMethod> mergeReplenishPaymentMethod(){
            return getReplenishPaymentMethod().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelReplenishPaymentMethod().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountRole> getFinAccountRole(){
            return getRelationValues(ctx, p1, "fin_account_role", FinAccountRole.class);
        }

        public List<FinAccountRole> mergeFinAccountRole(){
            return getFinAccountRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFinAccountRole().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<FinAccountStatus> getFinAccountStatus(){
            return getRelationValues(ctx, p1, "fin_account_status", FinAccountStatus.class);
        }

        public List<FinAccountStatus> mergeFinAccountStatus(){
            return getFinAccountStatus().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFinAccountStatus().add(c))
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
         
        public List<OrderPaymentPreference> getOrderPaymentPreference(){
            return getRelationValues(ctx, p1, "order_payment_preference", OrderPaymentPreference.class);
        }

        public List<OrderPaymentPreference> mergeOrderPaymentPreference(){
            return getOrderPaymentPreference().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderPaymentPreference().add(c))
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
        FinAccountData p = FinAccountData.newBuilder()
                .setFinAccountId(key)
                .build();
        FinAccount rec = findOne(ctx, p, FinAccount.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, FinAccount rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String ORGANIZATION_PARTY="organization_party";
         
    public static final String OWNER_PARTY="owner_party";
         
    public static final String POST_TO_GL_ACCOUNT="post_to_gl_account";
         
    public static final String REPLENISH_PAYMENT_METHOD="replenish_payment_method";
         
    public static final String FIN_ACCOUNT_ROLE="fin_account_role";
         
    public static final String FIN_ACCOUNT_STATUS="fin_account_status";
         
    public static final String FIN_ACCOUNT_TRANS="fin_account_trans";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String PAYMENT_METHOD="payment_method";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryFinAccountRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            FinAccountData p = FinAccountData.newBuilder()
                    .setFinAccountId(key)
                    .build();
            List<FinAccountData.Builder> ds = find(ctx, p, FinAccount.class).stream()
                    .map(e -> {
                        FinAccountData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set organization_party to head entity                        
                        if(relationsDemand.contains("organization_party")) {
                            getRelationValues(ctx, p1, "organization_party",
                                            Party.class)
                                    .forEach(el -> pb.setOrganizationParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set owner_party to head entity                        
                        if(relationsDemand.contains("owner_party")) {
                            getRelationValues(ctx, p1, "owner_party",
                                            Party.class)
                                    .forEach(el -> pb.setOwnerParty(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set post_to_gl_account to head entity                        
                        if(relationsDemand.contains("post_to_gl_account")) {
                            getRelationValues(ctx, p1, "post_to_gl_account",
                                            GlAccount.class)
                                    .forEach(el -> pb.setPostToGlAccount(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set replenish_payment_method to head entity                        
                        if(relationsDemand.contains("replenish_payment_method")) {
                            getRelationValues(ctx, p1, "replenish_payment_method",
                                            PaymentMethod.class)
                                    .forEach(el -> pb.setReplenishPaymentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_role to head entity                        
                        if(relationsDemand.contains("fin_account_role")) {
                            getRelationValues(ctx, p1, "fin_account_role",
                                            FinAccountRole.class)
                                    .forEach(el -> pb.addFinAccountRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_status to head entity                        
                        if(relationsDemand.contains("fin_account_status")) {
                            getRelationValues(ctx, p1, "fin_account_status",
                                            FinAccountStatus.class)
                                    .forEach(el -> pb.addFinAccountStatus(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_trans to head entity                        
                        if(relationsDemand.contains("fin_account_trans")) {
                            getRelationValues(ctx, p1, "fin_account_trans",
                                            FinAccountTrans.class)
                                    .forEach(el -> pb.addFinAccountTrans(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_payment_preference to head entity                        
                        if(relationsDemand.contains("order_payment_preference")) {
                            getRelationValues(ctx, p1, "order_payment_preference",
                                            OrderPaymentPreference.class)
                                    .forEach(el -> pb.addOrderPaymentPreference(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set payment_method to head entity                        
                        if(relationsDemand.contains("payment_method")) {
                            getRelationValues(ctx, p1, "payment_method",
                                            PaymentMethod.class)
                                    .forEach(el -> pb.addPaymentMethod(
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


    
    public FinAccount.FinAccountBuilder seed(){
        return FinAccount.builder()
                .finAccountId(sequence.nextStringId());
    }
}
