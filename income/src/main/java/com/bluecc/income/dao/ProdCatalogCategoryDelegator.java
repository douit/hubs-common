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
import com.bluecc.hubs.stub.ProdCatalogCategoryData;

public class ProdCatalogCategoryDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

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
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        default Map<String, ProdCatalogCategory> chainProdCatalog(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               boolean succInvoke) {
            return chainProdCatalog(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = ProdCatalog.class, prefix = "pc")
        default Map<String, ProdCatalogCategory> chainProdCatalog(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalogCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PROD_CATALOG);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalogCategory p = map.computeIfAbsent(rr.getColumn("pcc_id", String.class),
                                id -> rr.getRow(ProdCatalogCategory.class));
                        if (rr.getColumn("pc_prod_catalog_id", String.class) != null) {
                            p.getRelProdCatalog()
                                    .add(rr.getRow(ProdCatalog.class));
                        }
                        return map;
                    });
        }
         
        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        default Map<String, ProdCatalogCategory> chainProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               boolean succInvoke) {
            return chainProductCategory(protoMeta, inMap, "", Maps.newHashMap(), succInvoke);
        }

        @RegisterBeanMapper(value = ProdCatalogCategory.class, prefix = "pcc")
        @RegisterBeanMapper(value = ProductCategory.class, prefix = "pc")
        default Map<String, ProdCatalogCategory> chainProductCategory(ProtoMeta protoMeta,
                                               Map<String, ProdCatalogCategory> inMap,
                                               String whereClause,
                                               Map<String, Object> binds,
                                               boolean succInvoke) {
            SqlMeta sqlMeta = protoMeta.getSqlMeta("ProdCatalogCategory", succInvoke);
            SqlMeta.ViewDecl view = sqlMeta.leftJoin(PRODUCT_CATEGORY);
            return getHandle().select(view.getSql() + " " + whereClause)
                    .bindMap(binds)
                    .reduceRows(inMap, (map, rr) -> {
                        ProdCatalogCategory p = map.computeIfAbsent(rr.getColumn("pcc_id", String.class),
                                id -> rr.getRow(ProdCatalogCategory.class));
                        if (rr.getColumn("pc_product_category_id", String.class) != null) {
                            p.getRelProductCategory()
                                    .add(rr.getRow(ProductCategory.class));
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
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProdCatalog(protoMeta, e, whereClause, binds, succ);
    }
     
    public Consumer<Map<String, ProdCatalogCategory>> productCategory(Dao dao, boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, succ);
    }

    public Consumer<Map<String, ProdCatalogCategory>> productCategory(Dao dao,
                                        String whereClause,
                                        Map<String, Object> binds,
                                        boolean succ) {
        return e -> dao.chainProductCategory(protoMeta, e, whereClause, binds, succ);
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
