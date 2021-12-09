package com.bluecc.income.procs;

import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.income.dao.ProductDelegator;
import com.bluecc.income.model.Product;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class Products extends ProductDelegator {
    @RegisterBeanMapper(value = Product.class)
    public interface ProductDao {
        @SqlQuery("select * from product")
        List<Product> listProduct();
        @SqlQuery("select * from product where product_id=:id")
        Product getProduct(@Bind("id") String id);

        @SqlQuery("select count(*) from product")
        int countProduct();
    }

    // public void setProductStatus(ProductFlatData product, String statusId){
    //     process(c ->{
    //         update(c, ProductFlatData.newBuilder()
    //                 .setProductId(product.getProductId())
    //                 .setStatusId(statusId)
    //                 .build());
    //     });
    // }
}
