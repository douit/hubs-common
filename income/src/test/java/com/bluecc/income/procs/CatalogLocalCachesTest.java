package com.bluecc.income.procs;

import com.bluecc.hubs.fund.Util;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.model.Product;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Collection;

public class CatalogLocalCachesTest extends AbstractStoreProcTest {

    @Inject
    Provider<CatalogLocalCaches> localCachesProvider;
    @Test
    public void testCached(){
        Collection<Product> hotelFac = localCachesProvider.get().cachedProductsInCatalog("HotelFac");
        // .forEach(p -> System.out.println(p));
        // System.out.println(Util.prettyJson(ImmutableMap.of("result", hotelFac)));
        System.out.println(Util.prettyJson(hotelFac));
    }
}

