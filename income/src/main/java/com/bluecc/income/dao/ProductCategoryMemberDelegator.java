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
import com.bluecc.hubs.stub.ProductCategoryMemberData;

public class ProductCategoryMemberDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

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
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
        default Map<String, ProductCategoryMember> chainProduct(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               boolean succInvoke) {
            return chainProduct(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = Product.class, prefix = "pr")
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
                        if (rr.getColumn("pr_product_id", String.class) != null) {
                            p.getRelProduct()
                                    .add(rr.getRow(Product.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        default Map<String, ProductCategoryMember> chainProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProductCategoryMember> inMap,
                                               boolean succInvoke) {
            return chainProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProductCategoryMember.class, prefix = "pcm")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
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
                        if (rr.getColumn("pc_product_category_id", String.class) != null) {
                            p.getRelProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
                        }
                        return map;
                    });
        }
        
    }

     
    Consumer<Map<String, ProductCategoryMember>> product(Dao dao, boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductCategoryMember>> product(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProduct(protoMeta, e, whereClause, binds, succ);
    }
     
    Consumer<Map<String, ProductCategoryMember>> productCategory(Dao dao, boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, succ);
    }

    Consumer<Map<String, ProductCategoryMember>> productCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, whereClause, binds, succ);
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

    public Agent getAgent(IProc.ProcContext ctx, ProductCategoryMember rec) {
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
