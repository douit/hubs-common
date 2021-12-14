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
import com.bluecc.hubs.stub.ProductCategoryRollupData;

public class ProductCategoryRollupDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

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
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "cpc")
        default Map<String, ProductCategoryRollup> chainCurrentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainCurrentProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "cpc")
        default Map<String, ProductCategoryRollup> chainCurrentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CURRENT_PRODUCT_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("cpc_product_category_id", String.class) != null) {
                            p.getRelCurrentProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "ppc")
        default Map<String, ProductCategoryRollup> chainParentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainParentProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "ppc")
        default Map<String, ProductCategoryRollup> chainParentProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_PRODUCT_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("ppc_product_category_id", String.class) != null) {
                            p.getRelParentProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "cpcr")
        default Map<String, ProductCategoryRollup> chainChildProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainChildProductCategoryRollup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "cpcr")
        default Map<String, ProductCategoryRollup> chainChildProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(CHILD_PRODUCT_CATEGORY_ROLLUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("cpcr_parent_product_category_id", String.class) != null) {
                            p.getRelChildProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "ppcr")
        default Map<String, ProductCategoryRollup> chainParentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainParentProductCategoryRollup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "ppcr")
        default Map<String, ProductCategoryRollup> chainParentProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PARENT_PRODUCT_CATEGORY_ROLLUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("ppcr_product_category_id", String.class) != null) {
                            p.getRelParentProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "spcr")
        default Map<String, ProductCategoryRollup> chainSiblingProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               boolean succInvoke) {
            return chainSiblingProductCategoryRollup(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "pcr")
        @RegisterBeanMapper(value = ProductCategoryRollup.class, prefix = "spcr")
        default Map<String, ProductCategoryRollup> chainSiblingProductCategoryRollup(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryRollup> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProductCategoryRollup", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(SIBLING_PRODUCT_CATEGORY_ROLLUP);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProductCategoryRollup p = map.computeIfAbsent(rr.getColumn("pcr_id", String.class),
                                id -> rr.getRow(ProductCategoryRollup.class));
                        if (rr.getColumn("spcr_parent_product_category_id", String.class) != null) {
                            p.getRelSiblingProductCategoryRollup()
                                    .add(rr.getRow(ProductCategoryRollup.class));
                        }
                        return map;
                    });
        }
        
    }

     
    Consumer<Map<String, ProductCategoryRollup>> currentProductCategory(Dao dao, boolean succ) {
        return e -> dao.chainCurrentProductCategory(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductCategoryRollup>> currentProductCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainCurrentProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, ProductCategoryRollup>> parentProductCategory(Dao dao, boolean succ) {
        return e -> dao.chainParentProductCategory(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductCategoryRollup>> parentProductCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParentProductCategory(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, ProductCategoryRollup>> childProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainChildProductCategoryRollup(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductCategoryRollup>> childProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainChildProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, ProductCategoryRollup>> parentProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainParentProductCategoryRollup(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductCategoryRollup>> parentProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainParentProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, ProductCategoryRollup>> siblingProductCategoryRollup(Dao dao, boolean succ) {
        return e -> dao.chainSiblingProductCategoryRollup(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductCategoryRollup>> siblingProductCategoryRollup(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainSiblingProductCategoryRollup(protoMeta, e, whereClause, binds, succ);
    }
    

    public ProductCategoryRollup get(IProc.ProcContext ctx, String id){
        return ctx.attach(Dao.class).getProductCategoryRollup(id);
    }

    public List<ProductCategoryRollup> all(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).listProductCategoryRollup();
    }

    public int count(IProc.ProcContext ctx){
        return ctx.attach(Dao.class).countProductCategoryRollup();
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
