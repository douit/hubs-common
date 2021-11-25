package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IStore;
import org.jdbi.v3.guava.GuavaPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public abstract class AbstractStore implements IStore {
    protected void installPlugins(){
        getJdbi().installPlugin(new SqlObjectPlugin());
        getJdbi().installPlugin(new GuavaPlugin());
    }
}
