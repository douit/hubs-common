package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IStore;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ClickHouseStore extends AbstractStore{
    ClickHouseFac fac;
    Jdbi jdbi;

    @Inject
    ClickHouseStore(ClickHouseFac fac){
        this.fac=fac;
        this.jdbi = Jdbi.create(fac.getDataSource());
        installPlugins();
    }

    public Jdbi getJdbi() {
        return jdbi;
    }

}
