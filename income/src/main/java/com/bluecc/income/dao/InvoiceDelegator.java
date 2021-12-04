package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.Set;
import com.bluecc.income.model.*;
import com.bluecc.income.helper.ModelWrapper;

public class InvoiceDelegator extends AbstractProcs{

    @RegisterBeanMapper(value = Invoice.class)
    public interface InvoiceDao {
        @SqlQuery("select * from invoice")
        List<Invoice> listInvoice();
        @SqlQuery("select * from invoice where invoice_id=:id")
        Invoice getInvoice(@Bind("id") String id);

        @SqlQuery("select count(*) from invoice")
        int countInvoice();
    }

    
    
    
}
