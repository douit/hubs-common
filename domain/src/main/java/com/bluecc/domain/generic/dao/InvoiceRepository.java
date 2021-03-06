package com.bluecc.domain.generic.dao;

import com.bluecc.domain.util.Sequence;
import com.google.inject.Inject;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;
import org.joda.time.DateTime;

import com.bluecc.domain.sql.model.*;
import com.querydsl.core.types.QBean;
import static com.querydsl.core.types.Projections.bean;

import static com.bluecc.domain.sql.model.QInvoice.invoice;

// Invoice
public class InvoiceRepository extends AbstractRepository {
    @Inject Sequence sequence;

    public static final QBean<Invoice> invoiceBean = bean(Invoice.class, invoice.all());

    @Transactional
    public String save(Invoice entity) {
        if (entity.getInvoiceId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(invoice).populate(entity).execute();
            return entity.getInvoiceId();
        }
        entity.setCreatedStamp(DateTime.now());
        String uid=sequence.nextStringId();
        entity.setInvoiceId(uid);
        return create(entity);
        // return insert(invoice).populate(entity)
        //        .executeWithKey(invoice.invoiceId);
    }

    @Transactional
    public String create(Invoice entity){
        // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        insert(invoice).populate(entity)
                .executeWithKey(invoice.invoiceId);
        return entity.getInvoiceId();
    }

    @Transactional
    public Invoice findById(String id) {
        return selectFrom(invoice).where(invoice.invoiceId.eq(id)).fetchOne();
    }


    @Transactional
    public List<Invoice> findAll(Predicate expr) {
        return selectFrom(invoice).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(invoice).fetchCount();
    }

    @Transactional
    public void delete(Invoice s) {
        delete(invoice)
            .where(invoice.invoiceId.eq(s.getInvoiceId()))
            .execute();
    }
}

/*
-- keys: invoiceId

-- fields --
    
    String invoiceId
    String invoiceTypeId
    String partyIdFrom
    String partyId
    String roleTypeId
    String statusId
    String billingAccountId
    String contactMechId
    java.sql.Timestamp invoiceDate
    java.sql.Timestamp dueDate
    java.sql.Timestamp paidDate
    String invoiceMessage
    String referenceNumber
    String description
    String currencyUomId
    String recurrenceInfoId

-- relations --
    
    - InvoiceType (one, autoRelation: false, keymaps: invoiceTypeId)
    + InvoiceTypeAttr (many, autoRelation: false, keymaps: invoiceTypeId)
    - FromParty (one, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one-nofk, autoRelation: false, keymaps: partyId, roleTypeId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - BillingAccount (one, autoRelation: false, keymaps: billingAccountId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - RecurrenceInfo (one, autoRelation: false, keymaps: recurrenceInfoId)
    + AcctgTrans (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceAttribute (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceContactMech (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceContent (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceItem (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceNote (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceRole (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceStatus (many, autoRelation: true, keymaps: invoiceId)
    + InvoiceTerm (many, autoRelation: true, keymaps: invoiceId)
    + OrderAdjustmentBilling (many, autoRelation: true, keymaps: invoiceId)
    + OrderItemBilling (many, autoRelation: true, keymaps: invoiceId)
    + PaymentApplication (many, autoRelation: true, keymaps: invoiceId)
    + ReturnItemBilling (many, autoRelation: true, keymaps: invoiceId)
    + ShipmentItemBilling (many, autoRelation: true, keymaps: invoiceId)
    + TimeEntry (many, autoRelation: true, keymaps: invoiceId)
    + WorkEffortBilling (many, autoRelation: true, keymaps: invoiceId)
*/


