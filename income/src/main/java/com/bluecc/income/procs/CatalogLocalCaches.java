package com.bluecc.income.procs;

import com.bluecc.hubs.fund.ProtoMeta;
import com.bluecc.income.dao.ProductDelegator;
import com.bluecc.income.exchange.GsonConverters;
import com.bluecc.income.model.Product;
import com.google.common.base.Suppliers;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.ProducesJson;
import com.linecorp.armeria.server.annotation.ResponseConverter;

import javax.inject.Inject;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CatalogLocalCaches {
    @Inject
    ProductDelegator productDelegator;
    @Inject
    Catalogs catalogs;
    @Inject
    ProtoMeta protoMeta;

    Supplier<Collection<Product>> productsSupplier;
    LoadingCache<String, Collection<Product>> productsMemo;

    static final String rootCatalog="RentalCatalog";
    Collection<Product> productsInRootCatalog(){
        return productsInCatalog(rootCatalog);
    }

    Collection<Product> productsInCatalog(String catalog){
        return productDelegator.collect(c -> {
            Collection<Product> ds=  productDelegator.chainQuery(c, "where pr.product_id in (<ids>)",
                    SelectorBindings.stringList("ids",
                            catalogs.getProductsInCatalog(c, catalog)),
                    protoMeta.getInspectMeta("Product").getValidRelationNames()).values();
            return ds;
        });
    }

    CatalogLocalCaches(){
        productsSupplier=Suppliers.memoize(this::productsInRootCatalog);
        productsMemo= CacheBuilder.newBuilder()
                // evict the entries which have been idle for 10 minutes
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .maximumSize(1000)
                .build(CacheLoader.from(this::productsInCatalog));
    }

    @Get("/catalogs/:catalog")
    @ProducesJson
    @ResponseConverter(GsonConverters.GsonResponseConverter.class)
    public Collection<Product> cachedProductsInCatalog(@Param String catalog){
        return productsMemo.getUnchecked(catalog);
    }
}

