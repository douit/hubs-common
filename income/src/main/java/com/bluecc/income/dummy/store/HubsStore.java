package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IStore;
import com.bluecc.income.types.ObjectRegistries;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HubsStore extends AbstractStore {
    MysqlFac fac;
    Jdbi jdbi;
    ObjectRegistries objectRegistries;

    @Inject
    HubsStore(ObjectRegistries objectRegistries, MysqlFac fac){
        this.objectRegistries=objectRegistries;
        this.fac=fac;
        this.jdbi = Jdbi.create(fac.getDataSource());

        installPlugins();
        rowMapper(objectRegistries.getModelClasses());
    }

    public Jdbi getJdbi() {
        return jdbi;
    }

}
