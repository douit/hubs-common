package com.bluecc.income.dao;

import com.bluecc.income.procs.AbstractProcs;
import com.bluecc.income.model.Invoice;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

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
