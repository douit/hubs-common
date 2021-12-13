package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import javax.inject.Inject;
import javax.inject.Provider;

import com.bluecc.hubs.feed.LiveObjects;
import com.bluecc.income.exchange.IProc;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.FinAccountData;

public class FinAccountDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(FinAccount.class)
    public interface Dao {
        @SqlQuery("select * from fin_account")
        List<FinAccount> listFinAccount();
        @SqlQuery("select * from fin_account where fin_account_id=:id")
        FinAccount getFinAccount(@Bind("id") String id);

        @SqlQuery("select count(*) from fin_account")
        int countFinAccount();
    }

    public FinAccount get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getFinAccount(id);
    }

    public List<FinAccount> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listFinAccount();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countFinAccount();
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
         
        public List<PaymentMethod> getReplenishPaymentMethod(){
            return getRelationValues(ctx, p1, "replenish_payment_method", PaymentMethod.class);
        }

        public List<PaymentMethod> mergeReplenishPaymentMethod(){
            return getReplenishPaymentMethod().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelReplenishPaymentMethod().add(c))
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
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        FinAccountData p = FinAccountData.newBuilder()
                .setFinAccountId(key)
                .build();
        FinAccount rec = findOne(ctx, p, FinAccount.class);
        return new Agent(ctx, rec);
    }

         
    public static final String ORGANIZATION_PARTY="organization_party";
         
    public static final String OWNER_PARTY="owner_party";
         
    public static final String REPLENISH_PAYMENT_METHOD="replenish_payment_method";
         
    public static final String FIN_ACCOUNT_STATUS="fin_account_status";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String PAYMENT_METHOD="payment_method";
    

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
                                               
                        // add/set replenish_payment_method to head entity                        
                        if(relationsDemand.contains("replenish_payment_method")) {
                            getRelationValues(ctx, p1, "replenish_payment_method",
                                            PaymentMethod.class)
                                    .forEach(el -> pb.setReplenishPaymentMethod(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set fin_account_status to head entity                        
                        if(relationsDemand.contains("fin_account_status")) {
                            getRelationValues(ctx, p1, "fin_account_status",
                                            FinAccountStatus.class)
                                    .forEach(el -> pb.addFinAccountStatus(
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
