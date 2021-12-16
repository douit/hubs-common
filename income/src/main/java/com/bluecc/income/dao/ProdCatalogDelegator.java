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
import io.grpc.stub.StreamObserver;

import com.bluecc.hubs.stub.ProdCatalogData;

public class ProdCatalogDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProdCatalog.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from prod_catalog")
        List<ProdCatalog> listProdCatalog();
        @SqlQuery("select * from prod_catalog where prod_catalog_id=:id")
        ProdCatalog getProdCatalog(@Bind("id") String id);

        @SqlQuery("select count(*) from prod_catalog")
        int countProdCatalog();

        // for relations
         
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        default Map<String, ProdCatalog> chainProdCatalogCategory(ProtoMeta protoMeta,
                                               Map<String, ProdCatalog> inMap,
                                               boolean succInvoke) {
            return chainProdCatalogCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        default Map<String, ProdCatalog> chainProdCatalogCategory(ProtoMeta protoMeta,
                                               Map<String, ProdCatalog> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalog", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PROD_CATALOG_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalog p = map.computeIfAbsent(rr.getColumn("pc_prod_catalog_id", String.class),
                                id -> rr.getRow(ProdCatalog.class));
                        if (rr.getColumn("pcc_prod_catalog_id", String.class) != null) {
                            p.getRelProdCatalogCategory()
                                    .add(rr.getRow(ProdCatalogCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        default Map<String, ProdCatalog> chainProductStoreCatalog(ProtoMeta protoMeta,
                                               Map<String, ProdCatalog> inMap,
                                               boolean succInvoke) {
            return chainProductStoreCatalog(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        @RegisterBeanMapper(value = ProductStoreCatalog.class, prefix = "psc")
        default Map<String, ProdCatalog> chainProductStoreCatalog(ProtoMeta protoMeta,
                                               Map<String, ProdCatalog> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalog", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE_CATALOG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalog p = map.computeIfAbsent(rr.getColumn("pc_prod_catalog_id", String.class),
                                id -> rr.getRow(ProdCatalog.class));
                        if (rr.getColumn("psc_prod_catalog_id", String.class) != null) {
                            p.getRelProductStoreCatalog()
                                    .add(rr.getRow(ProductStoreCatalog.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, ProdCatalog> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProdCatalog> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        @RegisterBeanMapper(value = Tenant.class, prefix = "te")
        default Map<String, ProdCatalog> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProdCatalog> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalog", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalog p = map.computeIfAbsent(rr.getColumn("pc_prod_catalog_id", String.class),
                                id -> rr.getRow(ProdCatalog.class));
                        if (rr.getColumn("te_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProdCatalog>> prodCatalogCategory(Dao dao, boolean succ) {
        return e -> dao.chainProdCatalogCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProdCatalog>> prodCatalogCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProdCatalogCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProdCatalog>> productStoreCatalog(Dao dao, boolean succ) {
        return e -> dao.chainProductStoreCatalog(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProdCatalog>> productStoreCatalog(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStoreCatalog(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProdCatalog>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProdCatalog>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    

    public Map<String, ProdCatalog> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, ProdCatalog> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ProdCatalog>> chain = tenant(dao, false);
         
        if (incls.contains(PROD_CATALOG_CATEGORY)) {
            chain = chain.andThen(prodCatalogCategory(dao, true));
        }
         
        if (incls.contains(PRODUCT_STORE_CATALOG)) {
            chain = chain.andThen(productStoreCatalog(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProdCatalogData> responseObserver) {
        Map<String, ProdCatalog> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            ProdCatalogData.Builder prodCatalogData = data.toHeadBuilder();
             
            data.getRelProdCatalogCategory().forEach(e -> 
                prodCatalogData.addProdCatalogCategory(e.toHeadBuilder())); 
            data.getRelProductStoreCatalog().forEach(e -> 
                prodCatalogData.addProductStoreCatalog(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                prodCatalogData.setTenant(e.toDataBuilder()));
            return prodCatalogData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public ProdCatalog get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProdCatalog(id);
    }

    public List<ProdCatalog> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProdCatalog();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProdCatalog();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProdCatalog rec;
        final Message p1;
        ProdCatalog persistObject;

        Agent(IProc.ProcContext ctx, ProdCatalog rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProdCatalog getRecord(){
            return rec;
        }

        public ProdCatalog merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ProdCatalogCategory> getProdCatalogCategory(){
            return getRelationValues(ctx, p1, "prod_catalog_category", ProdCatalogCategory.class);
        }

        public List<ProdCatalogCategory> mergeProdCatalogCategory(){
            return getProdCatalogCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProdCatalogCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductStoreCatalog> getProductStoreCatalog(){
            return getRelationValues(ctx, p1, "product_store_catalog", ProductStoreCatalog.class);
        }

        public List<ProductStoreCatalog> mergeProductStoreCatalog(){
            return getProductStoreCatalog().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProductStoreCatalog().add(c))
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
        ProdCatalogData p = ProdCatalogData.newBuilder()
                .setProdCatalogId(key)
                .build();
        ProdCatalog rec = findOne(ctx, p, ProdCatalog.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProdCatalog rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PROD_CATALOG_CATEGORY="prod_catalog_category";
         
    public static final String PRODUCT_STORE_CATALOG="product_store_catalog";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProdCatalogRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProdCatalogData p = ProdCatalogData.newBuilder()
                    .setProdCatalogId(key)
                    .build();
            List<ProdCatalogData.Builder> ds = find(ctx, p, ProdCatalog.class).stream()
                    .map(e -> {
                        ProdCatalogData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set prod_catalog_category to head entity                        
                        if(relationsDemand.contains("prod_catalog_category")) {
                            getRelationValues(ctx, p1, "prod_catalog_category",
                                            ProdCatalogCategory.class)
                                    .forEach(el -> pb.addProdCatalogCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set product_store_catalog to head entity                        
                        if(relationsDemand.contains("product_store_catalog")) {
                            getRelationValues(ctx, p1, "product_store_catalog",
                                            ProductStoreCatalog.class)
                                    .forEach(el -> pb.addProductStoreCatalog(
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


    
    public ProdCatalog.ProdCatalogBuilder seed(){
        return ProdCatalog.builder()
                .prodCatalogId(sequence.nextStringId());
    }
}
