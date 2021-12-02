package com.bluecc.income.dummy.store;

import com.bluecc.income.exchange.IStore;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.guava.GuavaPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.Collection;

public abstract class AbstractStore implements IStore {
    protected void installPlugins(){
        getJdbi().installPlugin(new SqlObjectPlugin());
        getJdbi().installPlugin(new GuavaPlugin());
    }

    protected void rowMapper(Collection<Class<?>> types){
        for (Class<?> type : types) {
            getJdbi().registerRowMapper(BeanMapper.factory(type));
        }
    }
}
