package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.OrderItem;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public class OrderItemDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = OrderItem.class)
    public interface OrderItemDao {
        @SqlQuery("select * from order_item")
        List<OrderItem> listOrderItem();
        @SqlQuery("select * from order_item where id=:id")
        OrderItem getOrderItem(@Bind("id") String id);

        @SqlQuery("select count(*) from order_item")
        int countOrderItem();
    }

}
