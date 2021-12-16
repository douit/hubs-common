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
import com.google.common.collect.Sets;

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
import io.grpc.stub.StreamObserver;

import com.bluecc.hubs.stub.ProductStoreCatalogData;

public class ProductStoreCatalogDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductStoreCatalog.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product_store_catalog")
        List<ProductStoreCatalog> listProductStoreCatalog();
        @SqlQuery("select * from product_store_catalog where id=:id")
        ProductStoreCatalog getProductStoreCatalog(@Bind("id") String id);

        @SqlQuery("select count(*) from product_store_catalog")
        int countProductStoreCatalog();

        // for relations
         
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        default Map<String, ProductStoreCatalog> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ProductStoreCatalog> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "ps")
        default Map<String, ProductStoreCatalog> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ProductStoreCatalog> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStoreCatalog", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStoreCatalog p = map.computeIfAbsent(rr.getColumn("psc_id", String.class),
                                id -> rr.getRow(ProductStoreCatalog.class));
                        if (rr.getColumn("ps_product_store_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        default Map<String, ProductStoreCatalog> chainProdCatalog(ProtoMeta protoMeta,
                                               Map<String, ProductStoreCatalog> inMap,
                                               boolean succInvoke) {
            return chainProdCatalog(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        default Map<String, ProductStoreCatalog> chainProdCatalog(ProtoMeta protoMeta,
                                               Map<String, ProductStoreCatalog> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStoreCatalog", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PROD_CATALOG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStoreCatalog p = map.computeIfAbsent(rr.getColumn("psc_id", String.class),
                                id -> rr.getRow(ProductStoreCatalog.class));
                        if (rr.getColumn("pc_prod_catalog_id", String.class) != null) {
                            p.getRelProdCatalog()
                                    .add(rr.getRow(ProdCatalog.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, ProductStoreCatalog> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductStoreCatalog> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, ProductStoreCatalog> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductStoreCatalog> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStoreCatalog", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStoreCatalog p = map.computeIfAbsent(rr.getColumn("psc_id", String.class),
                                id -> rr.getRow(ProductStoreCatalog.class));
                        if (rr.getColumn("te_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProductStoreCatalog>> productStore(Dao dao, boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStoreCatalog>> productStore(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStoreCatalog>> prodCatalog(Dao dao, boolean succ) {
        return e -> dao.chainProdCatalog(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStoreCatalog>> prodCatalog(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProdCatalog(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStoreCatalog>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStoreCatalog>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, ProductStoreCatalog> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, ProductStoreCatalog> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, ProductStoreCatalog> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ProductStoreCatalog>> chain = tenant(dao, false);
         
        if (incls.contains(PRODUCT_STORE)) {
            chain = chain.andThen(productStore(dao, true));
        }
         
        if (incls.contains(PROD_CATALOG)) {
            chain = chain.andThen(prodCatalog(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProductStoreCatalogData> responseObserver) {
        Map<String, ProductStoreCatalog> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            ProductStoreCatalogData.Builder productStoreCatalogData = data.toHeadBuilder();
             
            data.getRelProductStore().forEach(e -> 
                productStoreCatalogData.setProductStore(e.toHeadBuilder())); 
            data.getRelProdCatalog().forEach(e -> 
                productStoreCatalogData.setProdCatalog(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                productStoreCatalogData.setTenant(e.toDataBuilder()));
            return productStoreCatalogData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public ProductStoreCatalog get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductStoreCatalog(id);
    }

    public List<ProductStoreCatalog> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductStoreCatalog();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductStoreCatalog();
    }


    public void store(ProductStoreCatalog productStoreCatalog){
        store(productStoreCatalog, true);
    }

    public void store(ProductStoreCatalog productStoreCatalog, boolean genId){
        process(c ->{
            if(genId){
                productStoreCatalog.setId(sequence.nextStringId());
            }
            storeOrUpdate(c, productStoreCatalog.toData());
        });
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductStoreCatalog rec;
        final Message p1;
        ProductStoreCatalog persistObject;

        Agent(IProc.ProcContext ctx, ProductStoreCatalog rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductStoreCatalog getRecord(){
            return rec;
        }

        public ProductStoreCatalog merge(){
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
         
        public List<ProdCatalog> getProdCatalog(){
            return getRelationValues(ctx, p1, "prod_catalog", ProdCatalog.class);
        }

        public List<ProdCatalog> mergeProdCatalog(){
            return getProdCatalog().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProdCatalog().add(c))
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
        ProductStoreCatalogData p = ProductStoreCatalogData.newBuilder()
                .setId(key)
                .build();
        ProductStoreCatalog rec = findOne(ctx, p, ProductStoreCatalog.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProductStoreCatalog rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String PROD_CATALOG="prod_catalog";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductStoreCatalogRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductStoreCatalogData p = ProductStoreCatalogData.newBuilder()
                    .setId(key)
                    .build();
            List<ProductStoreCatalogData.Builder> ds = find(ctx, p, ProductStoreCatalog.class).stream()
                    .map(e -> {
                        ProductStoreCatalogData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set prod_catalog to head entity                        
                        if(relationsDemand.contains("prod_catalog")) {
                            getRelationValues(ctx, p1, "prod_catalog",
                                            ProdCatalog.class)
                                    .forEach(el -> pb.setProdCatalog(
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


    
    public ProductStoreCatalog.ProductStoreCatalogBuilder seed(){
        return ProductStoreCatalog.builder()
                .id(sequence.nextStringId());
    }
}
