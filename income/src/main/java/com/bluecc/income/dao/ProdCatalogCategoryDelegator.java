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

import com.bluecc.hubs.stub.ProdCatalogCategoryData;

public class ProdCatalogCategoryDelegator extends AbstractProcs implements IChainQuery<ProdCatalogCategory>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(ProdCatalogCategory.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from prod_catalog_category")
        List<ProdCatalogCategory> listProdCatalogCategory();
        @SqlQuery("select * from prod_catalog_category where id=:id")
        ProdCatalogCategory getProdCatalogCategory(@Bind("id") String id);

        @SqlQuery("select count(*) from prod_catalog_category")
        int countProdCatalogCategory();

        // for relations
         
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pco")
        default Map<String, ProdCatalogCategory> chainProdCatalog(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               boolean succInvoke) {
            return chainProdCatalog(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pco")
        default Map<String, ProdCatalogCategory> chainProdCatalog(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalogCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PROD_CATALOG);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalogCategory p = map.computeIfAbsent(rr.getColumn("pcc_id", String.class),
                                id -> rr.getRow(ProdCatalogCategory.class));
                        if (rr.getColumn("pco_prod_catalog_id", String.class) != null) {
                            p.getRelProdCatalog()
                                    .add(rr.getRow(ProdCatalog.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pco")
        default Map<String, ProdCatalogCategory> chainProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               boolean succInvoke) {
            return chainProductCategory(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pco")
        default Map<String, ProdCatalogCategory> chainProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalogCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalogCategory p = map.computeIfAbsent(rr.getColumn("pcc_id", String.class),
                                id -> rr.getRow(ProdCatalogCategory.class));
                        if (rr.getColumn("pco_product_category_id", String.class) != null) {
                            p.getRelProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProdCatalogCategory> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProdCatalogCategory> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalogCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalogCategory p = map.computeIfAbsent(rr.getColumn("pcc_id", String.class),
                                id -> rr.getRow(ProdCatalogCategory.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProdCatalogCategory>> prodCatalog(Dao dao, boolean succ) {
        return e -> dao.chainProdCatalog(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProdCatalogCategory>> prodCatalog(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProdCatalog(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProdCatalogCategory>> productCategory(Dao dao, boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProdCatalogCategory>> productCategory(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProdCatalogCategory>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProdCatalogCategory>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, ProdCatalogCategory> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, ProdCatalogCategory> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, ProdCatalogCategory> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, ProdCatalogCategory> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ProdCatalogCategory>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(PROD_CATALOG)) {
            chain = chain.andThen(prodCatalog(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PRODUCT_CATEGORY)) {
            chain = chain.andThen(productCategory(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProdCatalogCategoryData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<ProdCatalogCategoryData> responseObserver) {

        Map<String, ProdCatalogCategory> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            ProdCatalogCategoryData.Builder prodCatalogCategoryData = data.toHeadBuilder();
             
            data.getRelProdCatalog().forEach(e -> 
                prodCatalogCategoryData.setProdCatalog(e.toHeadBuilder())); 
            data.getRelProductCategory().forEach(e -> 
                prodCatalogCategoryData.setProductCategory(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                prodCatalogCategoryData.setTenant(e.toDataBuilder()));
            return prodCatalogCategoryData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public ProdCatalogCategory get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProdCatalogCategory(id);
    }

    public List<ProdCatalogCategory> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProdCatalogCategory();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProdCatalogCategory();
    }

    @Post("/prod_catalog_categories")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(ProdCatalogCategory prodCatalogCategory){
        return store(prodCatalogCategory, true);
    }

    public String store(ProdCatalogCategory prodCatalogCategory, boolean genId){
        process(c ->{
            if(genId){
                prodCatalogCategory.setId(sequence.nextStringId());
            }
            storeOrUpdate(c, prodCatalogCategory.toData());
        });
        return prodCatalogCategory.getId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "ProdCatalogCategory", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProdCatalogCategory rec;
        final Message p1;
        ProdCatalogCategory persistObject;

        Agent(IProc.ProcContext ctx, ProdCatalogCategory rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProdCatalogCategory getRecord(){
            return rec;
        }

        public ProdCatalogCategory merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ProdCatalog> getProdCatalog(){
            return getRelationValues(ctx, p1, "prod_catalog", ProdCatalog.class);
        }

        public List<ProdCatalog> mergeProdCatalog(){
            return getProdCatalog().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProdCatalog().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategory> getProductCategory(){
            return getRelationValues(ctx, p1, "product_category", ProductCategory.class);
        }

        public List<ProductCategory> mergeProductCategory(){
            return getProductCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductCategory().add(c))
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
        ProdCatalogCategoryData p = ProdCatalogCategoryData.newBuilder()
                .setId(key)
                .build();
        ProdCatalogCategory rec = findOne(ctx, p, ProdCatalogCategory.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProdCatalogCategory rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PROD_CATALOG="prod_catalog";
         
    public static final String PRODUCT_CATEGORY="product_category";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProdCatalogCategoryRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProdCatalogCategoryData p = ProdCatalogCategoryData.newBuilder()
                    .setId(key)
                    .build();
            List<ProdCatalogCategoryData.Builder> ds = find(ctx, p, ProdCatalogCategory.class).stream()
                    .map(e -> {
                        ProdCatalogCategoryData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set prod_catalog to head entity                        
                        if(relationsDemand.contains("prod_catalog")) {
                            getRelationValues(ctx, p1, "prod_catalog",
                                            ProdCatalog.class)
                                    .forEach(el -> pb.setProdCatalog(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_category to head entity                        
                        if(relationsDemand.contains("product_category")) {
                            getRelationValues(ctx, p1, "product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.setProductCategory(
                                             el.toHeadBuilder().build()));
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


    
    public ProdCatalogCategory.ProdCatalogCategoryBuilder seed(){
        return ProdCatalogCategory.builder()
                .id(sequence.nextStringId());
    }
}
