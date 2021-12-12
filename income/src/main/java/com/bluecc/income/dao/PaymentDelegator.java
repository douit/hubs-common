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
import com.bluecc.hubs.stub.PaymentData;

public class PaymentDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(Payment.class)
    public interface Dao {
        @SqlQuery("select * from payment")
        List<Payment> listPayment();
        @SqlQuery("select * from payment where payment_id=:id")
        Payment getPayment(@Bind("id") String id);

        @SqlQuery("select count(*) from payment")
        int countPayment();
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

         
    public static final String PAYMENT_METHOD="payment_method";
         
    public static final String CREDIT_CARD="credit_card";
         
    public static final String EFT_ACCOUNT="eft_account";
         
    public static final String ORDER_PAYMENT_PREFERENCE="order_payment_preference";
         
    public static final String PAYMENT_GATEWAY_RESPONSE="payment_gateway_response";
         
    public static final String FROM_PARTY="from_party";
         
    public static final String TO_PARTY="to_party";
         
    public static final String TO_PARTY_ROLE="to_party_role";
         
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


    
}
