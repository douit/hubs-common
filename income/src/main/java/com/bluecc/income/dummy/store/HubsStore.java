package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IStore;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class HubsStore implements IStore {
    MysqlFac fac;
    Jdbi jdbi;

    @Inject
    HubsStore(MysqlFac fac){
        this.fac=fac;
        this.jdbi = Jdbi.create(fac.getDataSource());
        this.jdbi.installPlugin(new SqlObjectPlugin());
    }

    public Jdbi getJdbi() {
        return jdbi;
    }

}
