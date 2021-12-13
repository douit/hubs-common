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
import com.bluecc.hubs.stub.ProductCategoryMemberData;

public class ProductCategoryMemberDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductCategoryMember.class)
    public interface Dao {
        @SqlQuery("select * from product_category_member")
        List<ProductCategoryMember> listProductCategoryMember();
        @SqlQuery("select * from product_category_member where id=:id")
        ProductCategoryMember getProductCategoryMember(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category_member")
        int countProductCategoryMember();
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
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductCategoryMemberData p = ProductCategoryMemberData.newBuilder()
                .setId(key)
                .build();
        ProductCategoryMember rec = findOne(ctx, p, ProductCategoryMember.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PRODUCT="product";
         
    public static final String PRODUCT_CATEGORY="product_category";
    

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
