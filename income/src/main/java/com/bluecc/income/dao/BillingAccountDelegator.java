package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.BillingAccountData;

public class BillingAccountDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = BillingAccount.class)
    public interface BillingAccountDao {
        @SqlQuery("select * from billing_account")
        List<BillingAccount> listBillingAccount();
        @SqlQuery("select * from billing_account where billing_account_id=:id")
        BillingAccount getBillingAccount(@Bind("id") String id);

        @SqlQuery("select count(*) from billing_account")
        int countBillingAccount();
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


    
}
