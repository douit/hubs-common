package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.ProductCategory;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class ProductCategoryDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = ProductCategory.class)
    public interface ProductCategoryDao {
        @SqlQuery("select * from product_category")
        List<ProductCategory> listProductCategory();
        @SqlQuery("select * from product_category where product_category_id=:id")
        ProductCategory getProductCategory(@Bind("id") String id);

        @SqlQuery("select count(*) from product_category")
        int countProductCategory();
    }

}
