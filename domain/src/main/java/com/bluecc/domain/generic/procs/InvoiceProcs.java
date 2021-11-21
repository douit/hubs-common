package com.bluecc.domain.generic.procs;

import com.bluecc.domain.generic.dao.InvoiceItemRepository;
import com.bluecc.domain.generic.dao.InvoiceRepository;
import com.bluecc.domain.guice.Transactional;
import com.bluecc.domain.sql.model.InvoiceItem;
import com.bluecc.domain.sql.model.PartyRole;
import com.querydsl.sql.dml.SQLInsertClause;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Singleton;

import java.math.BigDecimal;

import static com.bluecc.domain.sql.model.QInvoiceItem.invoiceItem;
import static com.bluecc.domain.sql.model.QPartyRole.partyRole;

@Singleton
public class InvoiceProcs extends InvoiceRepository {
    @Inject
    InvoiceItemRepository invoiceItemRepository;

    @Transactional
    public void addInvoiceItems(Long invoiceId, InvoiceItem... items) {
        SQLInsertClause insert = insert(invoiceItem);
        for (InvoiceItem item : items) {
            item.setInvoiceId(invoiceId);
            item.setCreatedStamp(DateTime.now());
            insert.populate(item).addBatch();
        }
        insert.execute();
    }

    @Transactional
    public BigDecimal getInvoiceTotal(Long invoiceId) {
        BigDecimal invoiceTotal =
                invoiceItemRepository.findAll(invoiceItem.invoiceId.eq(invoiceId))
                        .stream()
                        .map(item -> item.getAmount().multiply(item.getQuantity()))
                        .reduce(BigDecimal.ZERO, (subtotal, element) ->
                                subtotal.add(element));
        return invoiceTotal;
    }

}

