package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IStore;
import com.bluecc.income.helper.TenantHubs;
import com.bluecc.income.types.ObjectRegistries;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HubsStore extends AbstractSqlStore {

    @Inject
    HubsStore(ObjectRegistries objectRegistries,
              @TenantHubs IDataSourceFac fac){
        this.objectRegistries=objectRegistries;
        this.fac=fac;
        initJdbi();
    }

}
