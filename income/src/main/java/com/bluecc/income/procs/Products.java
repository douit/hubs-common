package com.bluecc.income.procs;

import com.bluecc.income.model.Product;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class Products extends AbstractProcs{
    @RegisterBeanMapper(value = Product.class)
    public interface ProductDao {
        @SqlQuery("select * from product")
        List<Product> listProduct();
        @SqlQuery("select * from product where product_id=:id")
        Product getProduct(@Bind("id") String id);

        @SqlQuery("select count(*) from product")
        int countProduct();
    }

}
