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
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.annotation.RequestConverter;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
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

import com.bluecc.hubs.stub.BillingAccountData;

public class BillingAccountDelegator extends AbstractProcs implements IChainQuery<BillingAccount>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(BillingAccount.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from billing_account")
        List<BillingAccount> listBillingAccount();
        @SqlQuery("select * from billing_account where billing_account_id=:id")
        BillingAccount getBillingAccount(@Bind("id") String id);

        @SqlQuery("select count(*) from billing_account")
        int countBillingAccount();

        // for relations
         
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cmo")
        default Map<String, BillingAccount> chainContactMech(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               boolean succInvoke) {
            return chainContactMech(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = ContactMech.class, prefix = "cmo")
        default Map<String, BillingAccount> chainContactMech(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("BillingAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CONTACT_MECH);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        BillingAccount p = map.computeIfAbsent(rr.getColumn("ba_billing_account_id", String.class),
                                id -> rr.getRow(BillingAccount.class));
                        if (rr.getColumn("cmo_contact_mech_id", String.class) != null) {
                            p.getRelContactMech()
                                    .add(rr.getRow(ContactMech.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "pao")
        default Map<String, BillingAccount> chainPostalAddress(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               boolean succInvoke) {
            return chainPostalAddress(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = PostalAddress.class, prefix = "pao")
        default Map<String, BillingAccount> chainPostalAddress(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("BillingAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(POSTAL_ADDRESS);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        BillingAccount p = map.computeIfAbsent(rr.getColumn("ba_billing_account_id", String.class),
                                id -> rr.getRow(BillingAccount.class));
                        if (rr.getColumn("pao_contact_mech_id", String.class) != null) {
                            p.getRelPostalAddress()
                                    .add(rr.getRow(PostalAddress.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = BillingAccountRole.class, prefix = "barm")
        default Map<String, BillingAccount> chainBillingAccountRole(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               boolean succInvoke) {
            return chainBillingAccountRole(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = BillingAccountRole.class, prefix = "barm")
        default Map<String, BillingAccount> chainBillingAccountRole(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("BillingAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(BILLING_ACCOUNT_ROLE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        BillingAccount p = map.computeIfAbsent(rr.getColumn("ba_billing_account_id", String.class),
                                id -> rr.getRow(BillingAccount.class));
                        if (rr.getColumn("barm_billing_account_id", String.class) != null) {
                            p.getRelBillingAccountRole()
                                    .add(rr.getRow(BillingAccountRole.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = Invoice.class, prefix = "inzm")
        default Map<String, BillingAccount> chainInvoice(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               boolean succInvoke) {
            return chainInvoice(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = Invoice.class, prefix = "inzm")
        default Map<String, BillingAccount> chainInvoice(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("BillingAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(INVOICE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        BillingAccount p = map.computeIfAbsent(rr.getColumn("ba_billing_account_id", String.class),
                                id -> rr.getRow(BillingAccount.class));
                        if (rr.getColumn("inzm_billing_account_id", String.class) != null) {
                            p.getRelInvoice()
                                    .add(rr.getRow(Invoice.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "ohm")
        default Map<String, BillingAccount> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               boolean succInvoke) {
            return chainOrderHeader(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "ohm")
        default Map<String, BillingAccount> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("BillingAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_HEADER);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        BillingAccount p = map.computeIfAbsent(rr.getColumn("ba_billing_account_id", String.class),
                                id -> rr.getRow(BillingAccount.class));
                        if (rr.getColumn("ohm_billing_account_id", String.class) != null) {
                            p.getRelOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pam")
        default Map<String, BillingAccount> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               boolean succInvoke) {
            return chainPaymentApplication(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = PaymentApplication.class, prefix = "pam")
        default Map<String, BillingAccount> chainPaymentApplication(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("BillingAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PAYMENT_APPLICATION);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        BillingAccount p = map.computeIfAbsent(rr.getColumn("ba_billing_account_id", String.class),
                                id -> rr.getRow(BillingAccount.class));
                        if (rr.getColumn("pam_billing_account_id", String.class) != null) {
                            p.getRelPaymentApplication()
                                    .add(rr.getRow(PaymentApplication.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, BillingAccount> chainTenant(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = BillingAccount.class, prefix = "ba")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, BillingAccount> chainTenant(ProtoMeta protoMeta,
                                               Map<String, BillingAccount> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("BillingAccount", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        BillingAccount p = map.computeIfAbsent(rr.getColumn("ba_billing_account_id", String.class),
                                id -> rr.getRow(BillingAccount.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, BillingAccount>> contactMech(Dao dao, boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, succ);
    }

    public Consumer<Map<String, BillingAccount>> contactMech(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainContactMech(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, BillingAccount>> postalAddress(Dao dao, boolean succ) {
        return e -> dao.chainPostalAddress(protoMeta, e, succ);
    }

    public Consumer<Map<String, BillingAccount>> postalAddress(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPostalAddress(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, BillingAccount>> billingAccountRole(Dao dao, boolean succ) {
        return e -> dao.chainBillingAccountRole(protoMeta, e, succ);
    }

    public Consumer<Map<String, BillingAccount>> billingAccountRole(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainBillingAccountRole(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, BillingAccount>> invoice(Dao dao, boolean succ) {
        return e -> dao.chainInvoice(protoMeta, e, succ);
    }

    public Consumer<Map<String, BillingAccount>> invoice(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainInvoice(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, BillingAccount>> orderHeader(Dao dao, boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, BillingAccount>> orderHeader(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, BillingAccount>> paymentApplication(Dao dao, boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, succ);
    }

    public Consumer<Map<String, BillingAccount>> paymentApplication(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainPaymentApplication(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, BillingAccount>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, BillingAccount>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, BillingAccount> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, BillingAccount> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, BillingAccount> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, BillingAccount> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, BillingAccount>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(CONTACT_MECH)) {
            chain = chain.andThen(contactMech(dao, whereClause, binds, true));
        }
         
        if (incls.contains(POSTAL_ADDRESS)) {
            chain = chain.andThen(postalAddress(dao, whereClause, binds, true));
        }
         
        if (incls.contains(BILLING_ACCOUNT_ROLE)) {
            chain = chain.andThen(billingAccountRole(dao, whereClause, binds, true));
        }
         
        if (incls.contains(INVOICE)) {
            chain = chain.andThen(invoice(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_HEADER)) {
            chain = chain.andThen(orderHeader(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PAYMENT_APPLICATION)) {
            chain = chain.andThen(paymentApplication(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<BillingAccountData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<BillingAccountData> responseObserver) {

        Map<String, BillingAccount> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            BillingAccountData.Builder billingAccountData = data.toHeadBuilder();
             
            data.getRelContactMech().forEach(e -> 
                billingAccountData.setContactMech(e.toDataBuilder())); 
            data.getRelPostalAddress().forEach(e -> 
                billingAccountData.setPostalAddress(e.toDataBuilder())); 
            data.getRelBillingAccountRole().forEach(e -> 
                billingAccountData.addBillingAccountRole(e.toDataBuilder())); 
            data.getRelInvoice().forEach(e -> 
                billingAccountData.addInvoice(e.toHeadBuilder())); 
            data.getRelOrderHeader().forEach(e -> 
                billingAccountData.addOrderHeader(e.toHeadBuilder())); 
            data.getRelPaymentApplication().forEach(e -> 
                billingAccountData.addPaymentApplication(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                billingAccountData.setTenant(e.toDataBuilder()));
            return billingAccountData.build();
        }).forEach(e -> responseObserver.onNext(e));
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

    @Post("/billing_accounts")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(BillingAccount billingAccount){
        return store(billingAccount, true);
    }

    public String store(BillingAccount billingAccount, boolean genId){
        process(c ->{
            if(genId){
                billingAccount.setBillingAccountId(sequence.nextStringId());
            }
            storeOrUpdate(c, billingAccount.toData());
        });
        return billingAccount.getBillingAccountId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "BillingAccount", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
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
        BillingAccountData p = BillingAccountData.newBuilder()
                .setBillingAccountId(key)
                .build();
        BillingAccount rec = findOne(ctx, p, BillingAccount.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, BillingAccount rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String CONTACT_MECH="contact_mech";
         
    public static final String POSTAL_ADDRESS="postal_address";
         
    public static final String BILLING_ACCOUNT_ROLE="billing_account_role";
         
    public static final String INVOICE="invoice";
         
    public static final String ORDER_HEADER="order_header";
         
    public static final String PAYMENT_APPLICATION="payment_application";
         
    public static final String TENANT="tenant";
    

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


    
    public BillingAccount.BillingAccountBuilder seed(){
        return BillingAccount.builder()
                .billingAccountId(sequence.nextStringId());
    }
}
