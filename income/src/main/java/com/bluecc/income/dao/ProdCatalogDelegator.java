package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.ProdCatalog;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class ProdCatalogDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = ProdCatalog.class)
    public interface ProdCatalogDao {
        @SqlQuery("select * from prod_catalog")
        List<ProdCatalog> listProdCatalog();
        @SqlQuery("select * from prod_catalog where prod_catalog_id=:id")
        ProdCatalog getProdCatalog(@Bind("id") String id);

        @SqlQuery("select count(*) from prod_catalog")
        int countProdCatalog();
    }

}
