package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

public class InvoiceItemDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = InvoiceItem.class)
    public interface InvoiceItemDao {
        @SqlQuery("select * from invoice_item")
        List<InvoiceItem> listInvoiceItem();
        @SqlQuery("select * from invoice_item where id=:id")
        InvoiceItem getInvoiceItem(@Bind("id") String id);

        @SqlQuery("select count(*) from invoice_item")
        int countInvoiceItem();
    }

    
    
    
}
