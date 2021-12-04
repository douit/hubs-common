package com.bluecc.income.dummy.store;

import com.bluecc.income.types.ObjectRegistries;
import org.jdbi.v3.core.Jdbi;

public abstract class AbstractSqlStore extends AbstractStore{

    protected Jdbi jdbi;
    protected ObjectRegistries objectRegistries;
    protected IDataSourceFac fac;

    protected void initJdbi() {
        this.jdbi = Jdbi.create(fac.getDataSource());

        installPlugins();
        rowMapper(objectRegistries.getModelClasses());
    }

    public Jdbi getJdbi() {
        return jdbi;
    }

}
