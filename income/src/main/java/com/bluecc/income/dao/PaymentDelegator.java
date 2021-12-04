package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

public class PaymentDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = Payment.class)
    public interface PaymentDao {
        @SqlQuery("select * from payment")
        List<Payment> listPayment();
        @SqlQuery("select * from payment where payment_id=:id")
        Payment getPayment(@Bind("id") String id);

        @SqlQuery("select count(*) from payment")
        int countPayment();
    }

    
    
    
}
