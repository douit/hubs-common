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

import com.bluecc.hubs.stub.ProductCategoryMemberData;

public class ProductCategoryMemberDelegator extends AbstractProcs implements IChainQuery<ProductCategoryMember>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(ProductCategoryMember.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product_category_member")
        List<ProductCategoryMember> listProductCategoryMember();
        @SqlQuery("select * from product_category_member where id=:id")
        ProductCategoryMember getProductCategoryMember(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category_member")
        int countProductCategoryMember();

        // for relations
         
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = Product.class, prefix = "pro")
        default Map<String, ProductCategoryMember> chainProduct(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               boolean succInvoke) {
            return chainProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = Product.class, prefix = "pro")
        default Map<String, ProductCategoryMember> chainProduct(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryMember", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryMember p = map.computeIfAbsent(rr.getColumn("pcm_id", String.class),
                                id -> rr.getRow(ProductCategoryMember.class));
                        if (rr.getColumn("pro_product_id", String.class) != null) {
                            p.getRelProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pco")
        default Map<String, ProductCategoryMember> chainProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               boolean succInvoke) {
            return chainProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pco")
        default Map<String, ProductCategoryMember> chainProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryMember", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryMember p = map.computeIfAbsent(rr.getColumn("pcm_id", String.class),
                                id -> rr.getRow(ProductCategoryMember.class));
                        if (rr.getColumn("pco_product_category_id", String.class) != null) {
                            p.getRelProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductCategoryMember> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductCategoryMember> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryMember", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryMember p = map.computeIfAbsent(rr.getColumn("pcm_id", String.class),
                                id -> rr.getRow(ProductCategoryMember.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProductCategoryMember>> product(Dao dao, boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryMember>> product(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategoryMember>> productCategory(Dao dao, boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryMember>> productCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategoryMember>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryMember>> tenant(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, ProductCategoryMember> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, ProductCategoryMember> chainQuery(IProc.ProcContext c, Set<String> incls) {
        Map<String, ProductCategoryMember> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ProductCategoryMember>> chain = tenant(dao, false);
         
        if (incls.contains(PRODUCT)) {
            chain = chain.andThen(product(dao, true));
        }
         
        if (incls.contains(PRODUCT_CATEGORY)) {
            chain = chain.andThen(productCategory(dao, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProductCategoryMemberData> responseObserver) {
        Map<String, ProductCategoryMember> dataMap = chainQuery(c, incls);
        dataMap.values().stream().map(data -> {
            ProductCategoryMemberData.Builder productCategoryMemberData = data.toHeadBuilder();
             
            data.getRelProduct().forEach(e -> 
                productCategoryMemberData.setProduct(e.toHeadBuilder())); 
            data.getRelProductCategory().forEach(e -> 
                productCategoryMemberData.setProductCategory(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                productCategoryMemberData.setTenant(e.toDataBuilder()));
            return productCategoryMemberData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public ProductCategoryMember get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductCategoryMember(id);
    }

    public List<ProductCategoryMember> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductCategoryMember();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductCategoryMember();
    }


    public void store(ProductCategoryMember productCategoryMember){
        store(productCategoryMember, true);
    }

    public void store(ProductCategoryMember productCategoryMember, boolean genId){
        process(c ->{
            if(genId){
                productCategoryMember.setId(sequence.nextStringId());
            }
            storeOrUpdate(c, productCategoryMember.toData());
        });
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "ProductCategoryMember", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductCategoryMember rec;
        final Message p1;
        ProductCategoryMember persistObject;

        Agent(IProc.ProcContext ctx, ProductCategoryMember rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductCategoryMember getRecord(){
            return rec;
        }

        public ProductCategoryMember merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<Product> getProduct(){
            return getRelationValues(ctx, p1, "product", Product.class);
        }

        public List<Product> mergeProduct(){
            return getProduct().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProduct().add(c))
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
        ProductCategoryMemberData p = ProductCategoryMemberData.newBuilder()
                .setId(key)
                .build();
        ProductCategoryMember rec = findOne(ctx, p, ProductCategoryMember.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProductCategoryMember rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String PRODUCT="product";
         
    public static final String PRODUCT_CATEGORY="product_category";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductCategoryMemberRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductCategoryMemberData p = ProductCategoryMemberData.newBuilder()
                    .setId(key)
                    .build();
            List<ProductCategoryMemberData.Builder> ds = find(ctx, p, ProductCategoryMember.class).stream()
                    .map(e -> {
                        ProductCategoryMemberData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product to head entity                        
                        if(relationsDemand.contains("product")) {
                            getRelationValues(ctx, p1, "product",
                                            Product.class)
                                    .forEach(el -> pb.setProduct(
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


    
    public ProductCategoryMember.ProductCategoryMemberBuilder seed(){
        return ProductCategoryMember.builder()
                .id(sequence.nextStringId());
    }
}
