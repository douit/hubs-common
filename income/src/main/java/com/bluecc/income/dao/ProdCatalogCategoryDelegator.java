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
import com.bluecc.hubs.stub.ProdCatalogCategoryData;

public class ProdCatalogCategoryDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProdCatalogCategory.class)
    public interface Dao {
        @SqlQuery("select * from prod_catalog_category")
        List<ProdCatalogCategory> listProdCatalogCategory();
        @SqlQuery("select * from prod_catalog_category where id=:id")
        ProdCatalogCategory getProdCatalogCategory(@Bind("id") String id);

        @SqlQuery("select count(*) from prod_catalog_category")
        int countProdCatalogCategory();
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


    
}
