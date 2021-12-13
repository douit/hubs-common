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
import com.bluecc.hubs.stub.BillingAccountData;

public class BillingAccountDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(BillingAccount.class)
    public interface Dao {
        @SqlQuery("select * from billing_account")
        List<BillingAccount> listBillingAccount();
        @SqlQuery("select * from billing_account where billing_account_id=:id")
        BillingAccount getBillingAccount(@Bind("id") String id);

        @SqlQuery("select count(*) from billing_account")
        int countBillingAccount();
    }

    public BillingAccount get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getBillingAccount(id);
    }

    public List<BillingAccount> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listBillingAccount();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countBillingAccount();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final BillingAccount rec;
        final Message p1;
        BillingAccount persistObject;

        Agent(IProc.ProcContext ctx, BillingAccount rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public BillingAccount getRecord(){
            return rec;
        }

        public BillingAccount merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
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
         
        public List<BillingAccountRole> getBillingAccountRole(){
            return getRelationValues(ctx, p1, "billing_account_role", BillingAccountRole.class);
        }

        public List<BillingAccountRole> mergeBillingAccountRole(){
            return getBillingAccountRole().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelBillingAccountRole().add(c))
                    .collect(Collectors.toList());
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
         
        public List<OrderHeader> getOrderHeader(){
            return getRelationValues(ctx, p1, "order_header", OrderHeader.class);
        }

        public List<OrderHeader> mergeOrderHeader(){
            return getOrderHeader().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelOrderHeader().add(c))
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
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        BillingAccountData p = BillingAccountData.newBuilder()
                .setBillingAccountId(key)
                .build();
        BillingAccount rec = findOne(ctx, p, BillingAccount.class);
        return new Agent(ctx, rec);
    }

         
    public static final String CONTACT_MECH="contact_mech";
         
    public static final String POSTAL_ADDRESS="postal_address";
         
    public static final String BILLING_ACCOUNT_ROLE="billing_account_role";
         
    public static final String INVOICE="invoice";
         
    public static final String ORDER_HEADER="order_header";
         
    public static final String PAYMENT_APPLICATION="payment_application";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryBillingAccountRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            BillingAccountData p = BillingAccountData.newBuilder()
                    .setBillingAccountId(key)
                    .build();
            List<BillingAccountData.Builder> ds = find(ctx, p, BillingAccount.class).stream()
                    .map(e -> {
                        BillingAccountData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
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
                                               
                        // add/set billing_account_role to head entity                        
                        if(relationsDemand.contains("billing_account_role")) {
                            getRelationValues(ctx, p1, "billing_account_role",
                                            BillingAccountRole.class)
                                    .forEach(el -> pb.addBillingAccountRole(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set invoice to head entity                        
                        if(relationsDemand.contains("invoice")) {
                            getRelationValues(ctx, p1, "invoice",
                                            Invoice.class)
                                    .forEach(el -> pb.addInvoice(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set order_header to head entity                        
                        if(relationsDemand.contains("order_header")) {
                            getRelationValues(ctx, p1, "order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.addOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set payment_application to head entity                        
                        if(relationsDemand.contains("payment_application")) {
                            getRelationValues(ctx, p1, "payment_application",
                                            PaymentApplication.class)
                                    .forEach(el -> pb.addPaymentApplication(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
    public BillingAccount.BillingAccountBuilder seed(){
        return BillingAccount.builder()
                .billingAccountId(sequence.nextStringId());
    }
}
