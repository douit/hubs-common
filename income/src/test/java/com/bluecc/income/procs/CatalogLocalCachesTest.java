package com.bluecc.income.procs;

import com.bluecc.income.AbstractStoreProcTest;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Provider;

public class CatalogLocalCachesTest extends AbstractStoreProcTest {

    @Inject
    Provider<CatalogLocalCaches> localCachesProvider;
    @Test
    public void testCached(){
        localCachesProvider.get().cachedProductsInCatalog("HotelFac").forEach(p -> System.out.println(p));
    }
}