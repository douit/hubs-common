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
import com.linecorp.armeria.server.annotation.*;

import java.io.Writer;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
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

import com.bluecc.hubs.stub.ProductCategoryRollupData;

public class ProductCategoryRollupDelegator extends AbstractProcs implements IChainQuery<ProductCategoryRollup>, IDelegator {

    @Inject
    Provider<LiveObjects> liveObjectsProvider;
    @Inject
    Provider<Buckets> buckets;

    @RegisterBeanMapper(ProductCategoryRollup.class)
    public interface Dao extends SqlObject{
        @SqlQuery("select * from product_category_rollup")
        List<ProductCategoryRollup> listProductCategoryRollup();
        @SqlQuery("select * from product_category_rollup where id=:id")
        ProductCategoryRollup getProductCategoryRollup(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category_rollup")
        int countProductCategoryRollup();

        // for relations
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "cpco")
        default Map<String, ProductCategoryRollup> chainCurrentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainCurrentProductCategory(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "cpco")
        default Map<String, ProductCategoryRollup> chainCurrentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CURRENT_PRODUCT_CATEGORY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("cpco_product_category_id", String.class) != null) {
                            p.getRelCurrentProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "ppco")
        default Map<String, ProductCategoryRollup> chainParentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainParentProductCategory(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "ppco")
        default Map<String, ProductCategoryRollup> chainParentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_PRODUCT_CATEGORY);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("ppco_product_category_id", String.class) != null) {
                            p.getRelParentProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "cpcrm")
        default Map<String, ProductCategoryRollup> chainChildProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainChildProductCategoryRollup(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "cpcrm")
        default Map<String, ProductCategoryRollup> chainChildProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHILD_PRODUCT_CATEGORY_ROLLUP);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("cpcrm_parent_product_category_id", String.class) != null) {
                            p.getRelChildProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "ppcrm")
        default Map<String, ProductCategoryRollup> chainParentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainParentProductCategoryRollup(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "ppcrm")
        default Map<String, ProductCategoryRollup> chainParentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_PRODUCT_CATEGORY_ROLLUP);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("ppcrm_product_category_id", String.class) != null) {
                            p.getRelParentProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "spcrm")
        default Map<String, ProductCategoryRollup> chainSiblingProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainSiblingProductCategoryRollup(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "spcrm")
        default Map<String, ProductCategoryRollup> chainSiblingProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SIBLING_PRODUCT_CATEGORY_ROLLUP);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("spcrm_parent_product_category_id", String.class) != null) {
                            p.getRelSiblingProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductCategoryRollup> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainTenant(protoMeta, inMap, "", SelectorBindings.EMPTY, succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = Tenant.class, prefix = "teo")
        default Map<String, ProductCategoryRollup> chainTenant(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               SelectorBindings binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(TENANT);
            return binds.enrich(getHandle().select(view.getSql() + " " + whereClause))
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("teo_tenant_id", String.class) != null) {
                            p.getRelTenant()
                                    .add(rr.getRow(Tenant.class));
                        }
                        return map;
                    });
        }
        
    }

     
    public Consumer<Map<String, ProductCategoryRollup>> currentProductCategory(Dao dao, boolean succ) {
        return e -> dao.chainCurrentProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryRollup>> currentProductCategory(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainCurrentProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategoryRollup>> parentProductCategory(Dao dao, boolean succ) {
        return e -> dao.chainParentProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryRollup>> parentProductCategory(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParentProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategoryRollup>> childProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainChildProductCategoryRollup(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryRollup>> childProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainChildProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategoryRollup>> parentProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainParentProductCategoryRollup(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryRollup>> parentProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainParentProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategoryRollup>> siblingProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainSiblingProductCategoryRollup(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryRollup>> siblingProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainSiblingProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProductCategoryRollup>> tenant(Dao dao, boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProductCategoryRollup>> tenant(Dao dao,
                                        String whereClause,
                                        SelectorBindings binds,
                                        boolean succ) {
        return e -> dao.chainTenant(protoMeta, e, whereClause, binds, succ);
    }
    


    public Map<String, ProductCategoryRollup> chainQuery(IProc.ProcContext c, String... incls) {
        return chainQuery(c, Sets.newHashSet(incls));
    }
    
    public Map<String, ProductCategoryRollup> chainQuery(IProc.ProcContext c, Set<String> incls) {
        return chainQuery(c, "", SelectorBindings.EMPTY, incls);
    }
    public Map<String, ProductCategoryRollup> chainQuery(IProc.ProcContext c, String whereClause,
                                           SelectorBindings binds,
                                           Set<String> incls) {
        Map<String, ProductCategoryRollup> dataMap = Maps.newHashMap();
        Dao dao = c.getHandle().attach(Dao.class);
        Consumer<Map<String, ProductCategoryRollup>> chain = tenant(dao, whereClause, binds, false);
         
        if (incls.contains(CURRENT_PRODUCT_CATEGORY)) {
            chain = chain.andThen(currentProductCategory(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARENT_PRODUCT_CATEGORY)) {
            chain = chain.andThen(parentProductCategory(dao, whereClause, binds, true));
        }
         
        if (incls.contains(CHILD_PRODUCT_CATEGORY_ROLLUP)) {
            chain = chain.andThen(childProductCategoryRollup(dao, whereClause, binds, true));
        }
         
        if (incls.contains(PARENT_PRODUCT_CATEGORY_ROLLUP)) {
            chain = chain.andThen(parentProductCategoryRollup(dao, whereClause, binds, true));
        }
         
        if (incls.contains(SIBLING_PRODUCT_CATEGORY_ROLLUP)) {
            chain = chain.andThen(siblingProductCategoryRollup(dao, whereClause, binds, true));
        }
         
        if (incls.contains(TENANT)) {
            chain = chain.andThen(tenant(dao, whereClause, binds, true));
        }
        
        chain.accept(dataMap);
        return dataMap;
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   StreamObserver<ProductCategoryRollupData> responseObserver){
        chainQueryDataList(c, incls, "", SelectorBindings.EMPTY, responseObserver);
    }

    public void chainQueryDataList(IProc.ProcContext c,
                                   Set<String> incls,
                                   String whereClause,
                                   SelectorBindings binds,
                                   StreamObserver<ProductCategoryRollupData> responseObserver) {

        Map<String, ProductCategoryRollup> dataMap = chainQuery(c, whereClause, binds, incls);
        dataMap.values().stream().map(data -> {
            ProductCategoryRollupData.Builder productCategoryRollupData = data.toHeadBuilder();
             
            data.getRelCurrentProductCategory().forEach(e -> 
                productCategoryRollupData.setCurrentProductCategory(e.toHeadBuilder())); 
            data.getRelParentProductCategory().forEach(e -> 
                productCategoryRollupData.setParentProductCategory(e.toHeadBuilder())); 
            data.getRelChildProductCategoryRollup().forEach(e -> 
                productCategoryRollupData.addChildProductCategoryRollup(e.toHeadBuilder())); 
            data.getRelParentProductCategoryRollup().forEach(e -> 
                productCategoryRollupData.addParentProductCategoryRollup(e.toHeadBuilder())); 
            data.getRelSiblingProductCategoryRollup().forEach(e -> 
                productCategoryRollupData.addSiblingProductCategoryRollup(e.toHeadBuilder())); 
            data.getRelTenant().forEach(e -> 
                productCategoryRollupData.setTenant(e.toDataBuilder()));
            return productCategoryRollupData.build();
        }).forEach(e -> responseObserver.onNext(e));
    }    

    public ProductCategoryRollup get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductCategoryRollup(id);
    }

    @Get("/product_category_rollups/:id")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public ProductCategoryRollup get(@Param String id){
        return single(c -> get(c, id));
    }

    public List<ProductCategoryRollup> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductCategoryRollup();
    }

    @Get("/product_category_rollups")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<ProductCategoryRollup> all(){
        return collect(c -> all(c));
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductCategoryRollup();
    }

    @Get("/product_category_rollups/count")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Integer count(){
        return single(c -> count(c));
    }

    @Post("/product_category_rollups")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String store(ProductCategoryRollup productCategoryRollup){
        return store(productCategoryRollup, true);
    }

    @Put("/product_category_rollups")
    @RequestConverter(GsonConverters.GsonRequestConverter.class)
    public String storeOrUpdate(ProductCategoryRollup productCategoryRollup){
        return store(productCategoryRollup, false);
    }

    public String store(ProductCategoryRollup productCategoryRollup, boolean genId){
        process(c ->{
            if(genId){
                productCategoryRollup.setId(sequence.nextStringId());
            }
            storeOrUpdate(c, productCategoryRollup.toData());
        });
        return productCategoryRollup.getId();
    }

    @Override
    public void serialize(QueryList queryList, Writer writer) {
        buckets.get().writeTo(this, "ProductCategoryRollup", writer);
    }

    @Override
    public void queryList(QueryProfile request, StreamObserver<EntityBucket> responseObserver){
        buckets.get().queryList(this, request, responseObserver);
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductCategoryRollup rec;
        final Message p1;
        ProductCategoryRollup persistObject;

        Agent(IProc.ProcContext ctx, ProductCategoryRollup rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductCategoryRollup getRecord(){
            return rec;
        }

        public ProductCategoryRollup merge(){
            this.persistObject= liveObjectsProvider.get().merge(rec);
            return persistObject;
        }

         
        public List<ProductCategory> getCurrentProductCategory(){
            return getRelationValues(ctx, p1, "current_product_category", ProductCategory.class);
        }

        public List<ProductCategory> mergeCurrentProductCategory(){
            return getCurrentProductCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelCurrentProductCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategory> getParentProductCategory(){
            return getRelationValues(ctx, p1, "parent_product_category", ProductCategory.class);
        }

        public List<ProductCategory> mergeParentProductCategory(){
            return getParentProductCategory().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParentProductCategory().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryRollup> getChildProductCategoryRollup(){
            return getRelationValues(ctx, p1, "child_product_category_rollup", ProductCategoryRollup.class);
        }

        public List<ProductCategoryRollup> mergeChildProductCategoryRollup(){
            return getChildProductCategoryRollup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelChildProductCategoryRollup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryRollup> getParentProductCategoryRollup(){
            return getRelationValues(ctx, p1, "parent_product_category_rollup", ProductCategoryRollup.class);
        }

        public List<ProductCategoryRollup> mergeParentProductCategoryRollup(){
            return getParentProductCategoryRollup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelParentProductCategoryRollup().add(c))
                    .collect(Collectors.toList());
        }
         
        public List<ProductCategoryRollup> getSiblingProductCategoryRollup(){
            return getRelationValues(ctx, p1, "sibling_product_category_rollup", ProductCategoryRollup.class);
        }

        public List<ProductCategoryRollup> mergeSiblingProductCategoryRollup(){
            return getSiblingProductCategoryRollup().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelSiblingProductCategoryRollup().add(c))
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
        ProductCategoryRollupData p = ProductCategoryRollupData.newBuilder()
                .setId(key)
                .build();
        ProductCategoryRollup rec = findOne(ctx, p, ProductCategoryRollup.class);
        return new Agent(ctx, rec);
    }

    public Agent getAgent(IProc.ProcContext ctx, ProductCategoryRollup rec) {
        return new Agent(ctx, rec);
    }
    

         
    public static final String CURRENT_PRODUCT_CATEGORY="current_product_category";
         
    public static final String PARENT_PRODUCT_CATEGORY="parent_product_category";
         
    public static final String CHILD_PRODUCT_CATEGORY_ROLLUP="child_product_category_rollup";
         
    public static final String PARENT_PRODUCT_CATEGORY_ROLLUP="parent_product_category_rollup";
         
    public static final String SIBLING_PRODUCT_CATEGORY_ROLLUP="sibling_product_category_rollup";
         
    public static final String TENANT="tenant";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductCategoryRollupRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductCategoryRollupData p = ProductCategoryRollupData.newBuilder()
                    .setId(key)
                    .build();
            List<ProductCategoryRollupData.Builder> ds = find(ctx, p, ProductCategoryRollup.class).stream()
                    .map(e -> {
                        ProductCategoryRollupData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set current_product_category to head entity                        
                        if(relationsDemand.contains("current_product_category")) {
                            getRelationValues(ctx, p1, "current_product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.setCurrentProductCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set parent_product_category to head entity                        
                        if(relationsDemand.contains("parent_product_category")) {
                            getRelationValues(ctx, p1, "parent_product_category",
                                            ProductCategory.class)
                                    .forEach(el -> pb.setParentProductCategory(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set child_product_category_rollup to head entity                        
                        if(relationsDemand.contains("child_product_category_rollup")) {
                            getRelationValues(ctx, p1, "child_product_category_rollup",
                                            ProductCategoryRollup.class)
                                    .forEach(el -> pb.addChildProductCategoryRollup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set parent_product_category_rollup to head entity                        
                        if(relationsDemand.contains("parent_product_category_rollup")) {
                            getRelationValues(ctx, p1, "parent_product_category_rollup",
                                            ProductCategoryRollup.class)
                                    .forEach(el -> pb.addParentProductCategoryRollup(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set sibling_product_category_rollup to head entity                        
                        if(relationsDemand.contains("sibling_product_category_rollup")) {
                            getRelationValues(ctx, p1, "sibling_product_category_rollup",
                                            ProductCategoryRollup.class)
                                    .forEach(el -> pb.addSiblingProductCategoryRollup(
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


    
    public ProductCategoryRollup.ProductCategoryRollupBuilder seed(){
        return ProductCategoryRollup.builder()
                .id(sequence.nextStringId());
    }
}
