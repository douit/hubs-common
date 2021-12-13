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
import com.bluecc.hubs.stub.ProductCategoryRollupData;

public class ProductCategoryRollupDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductCategoryRollup.class)
    public interface Dao {
        @SqlQuery("select * from product_category_rollup")
        List<ProductCategoryRollup> listProductCategoryRollup();
        @SqlQuery("select * from product_category_rollup where id=:id")
        ProductCategoryRollup getProductCategoryRollup(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category_rollup")
        int countProductCategoryRollup();
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
