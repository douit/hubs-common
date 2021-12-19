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

import com.bluecc.hubs.stub.WebSiteData;

public class WebSiteDelegator extends AbstractProcs implements IChainQuery<WebSite>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(WebSite.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from web_site")
        List<WebSite> listWebSite();
        @SqlQuery("select * from web_site where web_site_id=:id")
        WebSite getWebSite(@Bind("id") String id);

        @SqlQuery("select count(*) from web_site")
        int countWebSite();

        // for relations
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, WebSite> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, WebSite> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("pso_product_store_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "ecm")
        default Map<String, WebSite> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainEbayConfig(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "ecm")
        default Map<String, WebSite> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(EBAY_CONFIG);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("ecm_web_site_id", String.class) != null) {
                            p.getRelEbayConfig()
                                    .add(rr.getRow(EbayConfig.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "ohm")
        default Map<String, WebSite> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainOrderHeader(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "ohm")
        default Map<String, WebSite> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_HEADER);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("ohm_web_site_id", String.class) != null) {
                            p.getRelOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = SubscriptionResource.class, prefix = "srm")
        default Map<String, WebSite> chainSubscriptionResource(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainSubscriptionResource(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = SubscriptionResource.class, prefix = "srm")
        default Map<String, WebSite> chainSubscriptionResource(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SUBSCRIPTION_RESOURCE);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("srm_web_site_id", String.class) != null) {
                            p.getRelSubscriptionResource()
                                    .add(rr.getRow(SubscriptionResource.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebAnalyticsConfig.class, prefix = "wacm")
        default Map<String, WebSite> chainWebAnalyticsConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainWebAnalyticsConfig(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebAnalyticsConfig.class, prefix = "wacm")
        default Map<String, WebSite> chainWebAnalyticsConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WEB_ANALYTICS_CONFIG);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("wacm_web_site_id", String.class) != null) {
                            p.getRelWebAnalyticsConfig()
                                    .add(rr.getRow(WebAnalyticsConfig.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebSiteContent.class, prefix = "wscm")
        default Map<String, WebSite> chainWebSiteContent(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainWebSiteContent(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebSiteContent.class, prefix = "wscm")
        default Map<String, WebSite> chainWebSiteContent(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WEB_SITE_CONTENT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("wscm_web_site_id", String.class) != null) {
                            p.getRelWebSiteContent()
                                    .add(rr.getRow(WebSiteContent.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, WebSite> chainTenant(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, WebSite> chainTenant(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, WebSite>> productStore(Dao dao, boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> productStore(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> ebayConfig(Dao dao, boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> ebayConfig(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> orderHeader(Dao dao, boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> orderHeader(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> subscriptionResource(Dao dao, boolean succ) {
        return e -> dao.chainSubscriptionResource(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> subscriptionResource(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainSubscriptionResource(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> webAnalyticsConfig(Dao dao, boolean succ) {
        return e -> dao.chainWebAnalyticsConfig(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> webAnalyticsConfig(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWebAnalyticsConfig(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> webSiteContent(Dao dao, boolean succ) {
        return e -> dao.chainWebSiteContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> webSiteContent(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainWebSiteContent(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, WebSite> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, WebSite> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, WebSite> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, WebSite> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, WebSite>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PRODUCT_STORE)) {
            chain = chain.andThen(productStore(dao, whereClause, binds, true));
        }
         
        if (incls.contains(EBAY_CONFIG)) {
            chain = chain.andThen(ebayConfig(dao, whereClause, binds, true));
        }
         
        if (incls.contains(ORDER_HEADER)) {
            chain = chain.andThen(orderHeader(dao, whereClause, binds, true));
        }
         
        if (incls.contains(SUBSCRIPTION_RESOURCE)) {
            chain = chain.andThen(subscriptionResource(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WEB_ANALYTICS_CONFIG)) {
            chain = chain.andThen(webAnalyticsConfig(dao, whereClause, binds, true));
        }
         
        if (incls.contains(WEB_SITE_CONTENT)) {
            chain = chain.andThen(webSiteContent(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<WebSiteData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<WebSiteData> responseObserver) {

        Map<String, WebSite> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            WebSiteData.Builder webSiteData = data.toHeadBuilder();
             
            data.getRelProductStore().forEach(e -> 
                webSiteData.setProductStore(e.toHeadBuilder())); 
            data.getRelEbayConfig().forEach(e -> 
                webSiteData.addEbayConfig(e.toDataBuilder())); 
            data.getRelOrderHeader().forEach(e -> 
                webSiteData.addOrderHeader(e.toHeadBuilder())); 
            data.getRelSubscriptionResource().forEach(e -> 
                webSiteData.addSubscriptionResource(e.toDataBuilder())); 
            data.getRelWebAnalyticsConfig().forEach(e -> 
                webSiteData.addWebAnalyticsConfig(e.toDataBuilder())); 
            data.getRelWebSiteContent().forEach(e -> 
                webSiteData.addWebSiteContent(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                webSiteData.setTenant(e.toDataBuilder()));
            return webSiteData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public WebSite get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getWebSite(id);
    }

    public List<WebSite> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listWebSite();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countWebSite();
    }


    public void store(WebSite webSite){
        store(webSite, true);
    }

    public void store(WebSite webSite, boolean genId){
        process(c ->{
            if(genId){
                webSite.setWebSiteId(sequence.nextStringId());
            }
            storeOrUpdate(c, webSite.toData());
        });
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "WebSite", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final WebSite rec;
        final Message p1;
        WebSite persistObject;

        Agent(IProc.ProcContext ctx, WebSite rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public WebSite getRecord(){
            return rec;
        }

        public WebSite merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ProductStore> getProductStore(){
            return getRelationValues(ctx, p1, "product_store", ProductStore.class);
        }

        public List<ProductStore> mergeProductStore(){
            return getProductStore().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStore().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<EbayConfig> getEbayConfig(){
            return getRelationValues(ctx, p1, "ebay_config", EbayConfig.class);
        }

        public List<EbayConfig> mergeEbayConfig(){
            return getEbayConfig().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelEbayConfig().add(c))
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
         
        public List<SubscriptionResource> getSubscriptionResource(){
            return getRelationValues(ctx, p1, "subscription_resource", SubscriptionResource.class);
        }

        public List<SubscriptionResource> mergeSubscriptionResource(){
            return getSubscriptionResource().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSubscriptionResource().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WebAnalyticsConfig> getWebAnalyticsConfig(){
            return getRelationValues(ctx, p1, "web_analytics_config", WebAnalyticsConfig.class);
        }

        public List<WebAnalyticsConfig> mergeWebAnalyticsConfig(){
            return getWebAnalyticsConfig().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWebAnalyticsConfig().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<WebSiteContent> getWebSiteContent(){
            return getRelationValues(ctx, p1, "web_site_content", WebSiteContent.class);
        }

        public List<WebSiteContent> mergeWebSiteContent(){
            return getWebSiteContent().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelWebSiteContent().add(c))
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
        WebSiteData p = WebSiteData.newBuilder()
                .setWebSiteId(key)
                .build();
        WebSite rec = findOne(ctx, p, WebSite.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, WebSite rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String EBAY_CONFIG="ebay_config";
         
    public static final String ORDER_HEADER="order_header";
         
    public static final String SUBSCRIPTION_RESOURCE="subscription_resource";
         
    public static final String WEB_ANALYTICS_CONFIG="web_analytics_config";
         
    public static final String WEB_SITE_CONTENT="web_site_content";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryWebSiteRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            WebSiteData p = WebSiteData.newBuilder()
                    .setWebSiteId(key)
                    .build();
            List<WebSiteData.Builder> ds = find(ctx, p, WebSite.class).stream()
                    .map(e -> {
                        WebSiteData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set ebay_config to head entity                        
                        if(relationsDemand.contains("ebay_config")) {
                            getRelationValues(ctx, p1, "ebay_config",
                                            EbayConfig.class)
                                    .forEach(el -> pb.addEbayConfig(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set order_header to head entity                        
                        if(relationsDemand.contains("order_header")) {
                            getRelationValues(ctx, p1, "order_header",
                                            OrderHeader.class)
                                    .forEach(el -> pb.addOrderHeader(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set subscription_resource to head entity                        
                        if(relationsDemand.contains("subscription_resource")) {
                            getRelationValues(ctx, p1, "subscription_resource",
                                            SubscriptionResource.class)
                                    .forEach(el -> pb.addSubscriptionResource(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set web_analytics_config to head entity                        
                        if(relationsDemand.contains("web_analytics_config")) {
                            getRelationValues(ctx, p1, "web_analytics_config",
                                            WebAnalyticsConfig.class)
                                    .forEach(el -> pb.addWebAnalyticsConfig(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set web_site_content to head entity                        
                        if(relationsDemand.contains("web_site_content")) {
                            getRelationValues(ctx, p1, "web_site_content",
                                            WebSiteContent.class)
                                    .forEach(el -> pb.addWebSiteContent(
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


    
    public WebSite.WebSiteBuilder seed(){
        return WebSite.builder()
                .webSiteId(sequence.nextStringId());
    }
}
