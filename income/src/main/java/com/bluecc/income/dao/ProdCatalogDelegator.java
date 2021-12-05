package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

import com.bluecc.hubs.fund.pubs.Action;
import com.bluecc.hubs.fund.model.IModel;
import reactor.core.publisher.Flux;
import java.util.function.Function;
import com.google.protobuf.Message;
import java.util.stream.Collectors;
import com.bluecc.hubs.stub.ProdCatalogData;

public class ProdCatalogDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = ProdCatalog.class)
    public interface ProdCatalogDao {
        @SqlQuery("select * from prod_catalog")
        List<ProdCatalog> listProdCatalog();
        @SqlQuery("select * from prod_catalog where prod_catalog_id=:id")
        ProdCatalog getProdCatalog(@Bind("id") String id);

        @SqlQuery("select count(*) from prod_catalog")
        int countProdCatalog();
    }

         
    public static final String PROD_CATALOG_CATEGORY="prod_catalog_category";
         
    public static final String PRODUCT_STORE_CATALOG="product_store_catalog";
    

    @Action
    public Function<String, Flux<IModel<?>>> queryProdCatalogRelations(String key, Set<String> relationsDemand) { 
        return input -> process(ctx -> {
            ProdCatalogData p = ProdCatalogData.newBuilder()
                    .setProdCatalogId(key)
                    .build();
            List<ProdCatalogData.Builder> ds = find(ctx, p, ProdCatalog.class).stream()
                    .map(e -> {
                        ProdCatalogData.Builder pb = e.toHeadBuilder();
                        Message p1=e.toData();

                                               
                        // add/set prod_catalog_category to head entity                        
                        if(relationsDemand.contains("prod_catalog_category")) {
                            getRelationValues(ctx, p1, "prod_catalog_category",
                                            ProdCatalogCategory.class)
                                    .forEach(el -> pb.addProdCatalogCategory(
                                             el.toDataBuilder().build()));
                        }
                                               
                        // add/set product_store_catalog to head entity                        
                        if(relationsDemand.contains("product_store_catalog")) {
                            getRelationValues(ctx, p1, "product_store_catalog",
                                            ProductStoreCatalog.class)
                                    .forEach(el -> pb.addProductStoreCatalog(
                                             el.toDataBuilder().build()));
                        }
                        

                        return pb;
                    }).collect(Collectors.toList());
            
            ds.forEach(e -> ctx.getSubscriber().onNext(new ModelWrapper<>(e)));
            ctx.getSubscriber().onComplete();
        });
    }


    
}
