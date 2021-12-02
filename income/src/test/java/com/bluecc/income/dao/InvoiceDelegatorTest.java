package com.bluecc.income.dao;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.descriptor.INameSymbol;
import com.bluecc.hubs.stub.InvoiceData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.income.AbstractStoreProcTest;
import com.bluecc.income.dao.InvoiceDelegator.InvoiceDao;
import com.bluecc.income.exchange.IProc;
import com.github.javafaker.Faker;
import com.google.protobuf.Message;
import lombok.Builder;
import lombok.Data;
import org.jdbi.v3.core.statement.Query;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.bluecc.hubs.fund.Util.pretty;
import static com.bluecc.hubs.fund.descriptor.EntityNames.Invoice;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

public class InvoiceDelegatorTest extends AbstractStoreProcTest {
    @Inject InvoiceDelegator invoices;

    @Before
    public void setUp() throws Exception {
        setupEntities("Invoice");
    }

    Faker faker = new Faker(new Locale("zh-CN"));

    @Test
    public void crud() {
        process(ctx -> {
            String newId=sequence.nextStringId();
            InvoiceFlatData flatData= InvoiceFlatData.newBuilder()
                    .setInvoiceId(newId)
                    // .setDescription(faker.hipster().word())
                    .build();
            assertEquals(1, invoices.create(ctx, flatData));
            assertEquals(1, invoices.update(ctx, flatData));
            assertEquals(1, invoices.find(ctx, flatData).size());
            assertEquals(1, invoices.findById(ctx, flatData).size());
            assertEquals(1, invoices.delete(ctx, flatData));
            assertEquals(0, invoices.find(ctx, flatData).size());
        });
    }

    @Test
    public void testCount() {
        process(c -> {
            InvoiceDao dao = c.getHandle().attach(InvoiceDao.class);
            System.out.println(dao.countInvoice());
        });
    }

    @Test
    public void testListAll() {
        process(c -> {
            //Dao dao = c.getHandle().attach(Dao.class);
            InvoiceFlatData flatData=InvoiceFlatData.newBuilder()
                    .setInvoiceId(sequence.nextStringId())
                    .build();
            genericProcs.create(c, flatData);
            List<Map<String, Object>> rs = genericProcs.all(c, flatData, 5);
            rs.forEach(e -> pretty(e));
        });
    }

    @Data
    @Builder
    public static class QueryClue{
        INameSymbol symbol;
        int limit;
        public Query select(IProc.ProcContext c){
            return c.getHandle().createQuery(format("select * from %s", symbol.getTable()));
        }
    }


    static final InvoiceData invoiceProto=InvoiceData.newBuilder().build();
    @Test
    public void testSelectBuilder() {
        process(c -> {
            // Dao dao = c.getHandle().attach(Dao.class);
            InvoiceFlatData flatData=InvoiceFlatData.newBuilder()
                    .setInvoiceId(sequence.nextStringId())
                    .build();
            genericProcs.create(c, flatData);

            QueryClue.builder().symbol(Invoice).limit(5).build()
                    .select(c).mapToMap()
                    .list()
                    .forEach(e -> pretty(e));
        });
    }
}
