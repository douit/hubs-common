package com.bluecc.income.dao;

import com.bluecc.hubs.stub.EntityBucket;
import com.bluecc.hubs.stub.QueryList;
import com.bluecc.hubs.stub.QueryProfile;
import com.bluecc.income.exchange.IDelegator;
import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.procs.Buckets;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.SqlObject;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
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

import com.bluecc.hubs.stub.ProductStoreFacilityData;

public class ProductStoreFacilityDelegator extends AbstractProcs implements IChainQuery<ProductStoreFacility>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(ProductStoreFacility.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product_store_facility")
        List<ProductStoreFacility> listProductStoreFacility();
        @SqlQuery("select * from product_store_facility where id=:id")
        ProductStoreFacility getProductStoreFacility(@Bind("id") String id);

        @SqlQuery("select count(*) from product_store_facility")
        int countProductStoreFacility();

        // for relations
         
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, ProductStoreFacility> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               boolean succInvoke) {
            return chainProductStore(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = ProductStore.class, prefix = "pso")
        default Map<String, ProductStoreFacility> chainProductStore(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStoreFacility", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_STORE);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStoreFacility p = map.computeIfAbsent(rr.getColumn("psf_id", String.class),
                                id -> rr.getRow(ProductStoreFacility.class));
                        if (rr.getColumn("pso_product_store_id", String.class) != null) {
                            p.getRelProductStore()
                                    .add(rr.getRow(ProductStore.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, ProductStoreFacility> chainFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               boolean succInvoke) {
            return chainFacility(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = Facility.class, prefix = "fao")
        default Map<String, ProductStoreFacility> chainFacility(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStoreFacility", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(FACILITY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStoreFacility p = map.computeIfAbsent(rr.getColumn("psf_id", String.class),
                                id -> rr.getRow(ProductStoreFacility.class));
                        if (rr.getColumn("fao_facility_id", String.class) != null) {
                            p.getRelFacility()
                                    .add(rr.getRow(Facility.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductStoreFacility> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductStoreFacility.class, prefix = "psf")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductStoreFacility> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductStoreFacility> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductStoreFacility", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductStoreFacility p = map.computeIfAbsent(rr.getColumn("psf_id", String.class),
                                id -> rr.getRow(ProductStoreFacility.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProductStoreFacility>> productStore(Dao dao, boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStoreFacility>> productStore(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductStore(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStoreFacility>> facility(Dao dao, boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStoreFacility>> facility(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainFacility(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductStoreFacility>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductStoreFacility>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, ProductStoreFacility> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, ProductStoreFacility> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, ProductStoreFacility> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ProductStoreFacility>> chain = tenant(dao, false);
         
        if (incls.contains(PRODUCT_STORE)) {
            chain = chain.andThen(productStore(dao, true));
        }
         
        if (incls.contains(FACILITY)) {
            chain = chain.andThen(facility(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProductStoreFacilityData> responseObserver) {
        Map<String, ProductStoreFacility> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            ProductStoreFacilityData.Builder productStoreFacilityData = data.toHeadBuilder();
             
            data.getRelProductStore().forEach(e -> 
                productStoreFacilityData.setProductStore(e.toHeadBuilder())); 
            data.getRelFacility().forEach(e -> 
                productStoreFacilityData.setFacility(e.toDataBuilder())); 
            data.getRelTenant().forEach(e -> 
                productStoreFacilityData.setTenant(e.toDataBuilder()));
            return productStoreFacilityData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public ProductStoreFacility get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductStoreFacility(id);
    }

    public List<ProductStoreFacility> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductStoreFacility();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductStoreFacility();
    }


    public void store(ProductStoreFacility productStoreFacility){
        store(productStoreFacility, true);
    }

    public void store(ProductStoreFacility productStoreFacility, boolean genId){
        process(c ->{
            if(genId){
                productStoreFacility.setId(sequence.nextStringId());
            }
            storeOrUpdate(c, productStoreFacility.toData());
        });
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "ProductStoreFacility", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductStoreFacility rec;
        final Message p1;
        ProductStoreFacility persistObject;

        Agent(IProc.ProcContext ctx, ProductStoreFacility rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductStoreFacility getRecord(){
            return rec;
        }

        public ProductStoreFacility merge(){
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
         
        public List<Facility> getFacility(){
            return getRelationValues(ctx, p1, "facility", Facility.class);
        }

        public List<Facility> mergeFacility(){
            return getFacility().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelFacility().add(c))
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
        ProductStoreFacilityData p = ProductStoreFacilityData.newBuilder()
                .setId(key)
                .build();
        ProductStoreFacility rec = findOne(ctx, p, ProductStoreFacility.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProductStoreFacility rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String FACILITY="facility";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductStoreFacilityRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductStoreFacilityData p = ProductStoreFacilityData.newBuilder()
                    .setId(key)
                    .build();
            List<ProductStoreFacilityData.Builder> ds = find(ctx, p, ProductStoreFacility.class).stream()
                    .map(e -> {
                        ProductStoreFacilityData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set facility to head entity                        
                        if(relationsDemand.contains("facility")) {
                            getRelationValues(ctx, p1, "facility",
                                            Facility.class)
                                    .forEach(el -> pb.setFacility(
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


    
    public ProductStoreFacility.ProductStoreFacilityBuilder seed(){
        return ProductStoreFacility.builder()
                .id(sequence.nextStringId());
    }
}
