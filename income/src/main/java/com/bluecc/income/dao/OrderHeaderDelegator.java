package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

public class OrderHeaderDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = OrderHeader.class)
    public interface OrderHeaderDao {
        @SqlQuery("select * from order_header")
        List<OrderHeader> listOrderHeader();
        @SqlQuery("select * from order_header where order_id=:id")
        OrderHeader getOrderHeader(@Bind("id") String id);

        @SqlQuery("select count(*) from order_header")
        int countOrderHeader();
    }

    
    
    
}
