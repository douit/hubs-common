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
import com.bluecc.hubs.stub.WebSiteData;

public class WebSiteDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(WebSite.class)
    public interface Dao {
        @SqlQuery("select * from web_site")
        List<WebSite> listWebSite();
        @SqlQuery("select * from web_site where web_site_id=:id")
        WebSite getWebSite(@Bind("id") String id);

        @SqlQuery("select count(*) from web_site")
        int countWebSite();
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


    
}
