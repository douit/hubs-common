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
import com.bluecc.hubs.stub.ProductStoreCatalogData;

public class ProductStoreCatalogDelegator extends AbstractProcs{

    @Inject
    Provider<LiveObjects> liveObjectsProvider;

    @RegisterBeanMapper(ProductStoreCatalog.class)
    public interface Dao {
        @SqlQuery("select * from product_store_catalog")
        List<ProductStoreCatalog> listProductStoreCatalog();
        @SqlQuery("select * from product_store_catalog where id=:id")
        ProductStoreCatalog getProductStoreCatalog(@Bind("id") String id);

        @SqlQuery("select count(*) from product_store_catalog")
        int countProductStoreCatalog();
    }


    public class Agent{
        final IProc.ProcContext ctx;
        final ProductStoreCatalog rec;
        final Message p1;
        ProductStoreCatalog persistObject;

        Agent(IProc.ProcContext ctx, ProductStoreCatalog rec){
            this.ctx=ctx;
            this.rec=rec;
            this.p1=rec.toData();
        }

        public ProductStoreCatalog getRecord(){
            return rec;
        }

        public ProductStoreCatalog merge(){
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
         
        public List<ProdCatalog> getProdCatalog(){
            return getRelationValues(ctx, p1, "prod_catalog", ProdCatalog.class);
        }

        public List<ProdCatalog> mergeProdCatalog(){
            return getProdCatalog().stream()
                    .map(p -> liveObjectsProvider.get().merge(p))
                    .peek(c -> persistObject.getRelProdCatalog().add(c))
                    .collect(Collectors.toList());
        }
        

    }

    public Agent getAgent(IProc.ProcContext ctx, String key) {
        ProductStoreCatalogData p = ProductStoreCatalogData.newBuilder()
                .setId(key)
                .build();
        ProductStoreCatalog rec = findOne(ctx, p, ProductStoreCatalog.class);
        return new Agent(ctx, rec);
    }

         
    public static final String PRODUCT_STORE="product_store";
         
    public static final String PROD_CATALOG="prod_catalog";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProductStoreCatalogRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProductStoreCatalogData p = ProductStoreCatalogData.newBuilder()
                    .setId(key)
                    .build();
            List<ProductStoreCatalogData.Builder> ds = find(ctx, p, ProductStoreCatalog.class).stream()
                    .map(e -> {
                        ProductStoreCatalogData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set product_store to head entity                        
                        if(relationsDemand.contains("product_store")) {
                            getRelationValues(ctx, p1, "product_store",
                                            ProductStore.class)
                                    .forEach(el -> pb.setProductStore(
                                             el.toHeadBuilder().build()));
                        }
                                               
                        // add/set prod_catalog to head entity                        
                        if(relationsDemand.contains("prod_catalog")) {
                            getRelationValues(ctx, p1, "prod_catalog",
                                            ProdCatalog.class)
                                    .forEach(el -> pb.setProdCatalog(
                                             el.toHeadBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}
