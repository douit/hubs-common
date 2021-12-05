package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

public class BillingAccountDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = BillingAccount.class)
    public interface BillingAccountDao {
        @SqlQuery("select * from billing_account")
        List<BillingAccount> listBillingAccount();
        @SqlQuery("select * from billing_account where billing_account_id=:id")
        BillingAccount getBillingAccount(@Bind("id") String id);

        @SqlQuery("select count(*) from billing_account")
        int countBillingAccount();
    }

    
    
    
}
