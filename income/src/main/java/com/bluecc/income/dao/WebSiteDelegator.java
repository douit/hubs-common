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
import com.bluecc.hubs.stub.WebSiteData;

public class WebSiteDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

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
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        default Map<String, WebSite> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        default Map<String, WebSite> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("ps_product_store_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "ec")
        default Map<String, WebSite> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainEbayConfig(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = EbayConfig.class, prefix = "ec")
        default Map<String, WebSite> chainEbayConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(EBAY_CONFIG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("ec_web_site_id", String.class) != null) {
                            p.getRelEbayConfig()
                                    .add(rr.getRow(EbayConfig.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        default Map<String, WebSite> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainOrderHeader(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = OrderHeader.class, prefix = "oh")
        default Map<String, WebSite> chainOrderHeader(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(ORDER_HEADER);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("oh_web_site_id", String.class) != null) {
                            p.getRelOrderHeader()
                                    .add(rr.getRow(OrderHeader.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = SubscriptionResource.class, prefix = "sr")
        default Map<String, WebSite> chainSubscriptionResource(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainSubscriptionResource(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = SubscriptionResource.class, prefix = "sr")
        default Map<String, WebSite> chainSubscriptionResource(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SUBSCRIPTION_RESOURCE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("sr_web_site_id", String.class) != null) {
                            p.getRelSubscriptionResource()
                                    .add(rr.getRow(SubscriptionResource.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebAnalyticsConfig.class, prefix = "wac")
        default Map<String, WebSite> chainWebAnalyticsConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainWebAnalyticsConfig(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebAnalyticsConfig.class, prefix = "wac")
        default Map<String, WebSite> chainWebAnalyticsConfig(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WEB_ANALYTICS_CONFIG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("wac_web_site_id", String.class) != null) {
                            p.getRelWebAnalyticsConfig()
                                    .add(rr.getRow(WebAnalyticsConfig.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebSiteContent.class, prefix = "wsc")
        default Map<String, WebSite> chainWebSiteContent(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               boolean succInvoke) {
            return chainWebSiteContent(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = WebSite.class, prefix = "ws")
        @RegisterBeanMapper(value = WebSiteContent.class, prefix = "wsc")
        default Map<String, WebSite> chainWebSiteContent(ProtoMeta protoMeta,
                                               Map<String, WebSite> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("WebSite", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(WEB_SITE_CONTENT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        WebSite p = map.computeIfAbsent(rr.getColumn("ws_web_site_id", String.class),
                                id -> rr.getRow(WebSite.class));
                        if (rr.getColumn("wsc_web_site_id", String.class) != null) {
                            p.getRelWebSiteContent()
                                    .add(rr.getRow(WebSiteContent.class));
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
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> ebayConfig(Dao dao, boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> ebayConfig(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainEbayConfig(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> orderHeader(Dao dao, boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> orderHeader(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainOrderHeader(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> subscriptionResource(Dao dao, boolean succ) {
        return e -> dao.chainSubscriptionResource(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> subscriptionResource(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSubscriptionResource(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> webAnalyticsConfig(Dao dao, boolean succ) {
        return e -> dao.chainWebAnalyticsConfig(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> webAnalyticsConfig(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainWebAnalyticsConfig(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, WebSite>> webSiteContent(Dao dao, boolean succ) {
        return e -> dao.chainWebSiteContent(protoMeta, e, succ);
    }

    public Consumer<Map<String, WebSite>> webSiteContent(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainWebSiteContent(protoMeta, e, whereClause, binds, succ);
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
