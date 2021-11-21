package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;
import org.joda.time.DateTime;

import com.bluecc.domain.sql.model.*;
import com.querydsl.core.types.QBean;
import static com.querydsl.core.types.Projections.bean;

import static com.bluecc.domain.sql.model.QInvoiceItem.invoiceItem;

// Invoice Item
public class InvoiceItemRepository extends AbstractRepository {
    public static final QBean<InvoiceItem> invoiceItemBean = bean(InvoiceItem.class, invoiceItem.all());

    @Transactional
    public Long save(InvoiceItem entity) {
        if (entity.getId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(invoiceItem).populate(entity).execute();
            return entity.getId();
        }
        entity.setCreatedStamp(DateTime.now());
        return insert(invoiceItem).populate(entity)
                .executeWithKey(invoiceItem.id);
    }

    @Transactional
    public InvoiceItem findById(Long id) {
        return selectFrom(invoiceItem).where(invoiceItem.id.eq(id)).fetchOne();
    }


    @Transactional
    public List<InvoiceItem> findAll(Predicate expr) {
        return selectFrom(invoiceItem).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(invoiceItem).fetchCount();
    }

    @Transactional
    public void delete(InvoiceItem s) {
        delete(invoiceItem)
            .where(invoiceItem.id.eq(s.getId()))
            .execute();
    }
}

/*
-- keys: invoiceId, invoiceItemSeqId

-- fields --
    
    Long invoiceId
    Long invoiceItemSeqId
    String invoiceItemTypeId
    Long overrideGlAccountId
    Long overrideOrgPartyId
    Long inventoryItemId
    Long productId
    Long productFeatureId
    Long parentInvoiceId
    Long parentInvoiceItemSeqId
    String uomId
    String taxableFlag
    java.math.BigDecimal quantity
    java.math.BigDecimal amount
    String description
    Long taxAuthPartyId
    String taxAuthGeoId
    Long taxAuthorityRateSeqId
    Long salesOpportunityId

-- relations --
    
    - InvoiceItemType (one, autoRelation: false, keymaps: invoiceItemTypeId)
    + InvoiceItemTypeAttr (many, autoRelation: false, keymaps: invoiceItemTypeId)
    - Invoice (one, autoRelation: false, keymaps: invoiceId)
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    - Product (one, autoRelation: false, keymaps: productId)
    - ProductFeature (one, autoRelation: false, keymaps: productFeatureId)
    - InvoiceItem (one, autoRelation: false, keymaps: parentInvoiceId -> invoiceId, parentInvoiceItemSeqId -> invoiceItemSeqId)
    + ChildrenInvoiceItem (many, autoRelation: false, keymaps: invoiceId -> parentInvoiceId, invoiceItemSeqId -> parentInvoiceItemSeqId)
    - Uom (one, autoRelation: false, keymaps: uomId)
    - OverrideGlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
    - TaxAuthorityParty (one, autoRelation: false, keymaps: taxAuthPartyId -> partyId)
    - TaxGeo (one, autoRelation: false, keymaps: taxAuthGeoId -> geoId)
    - TaxAuthorityRateProduct (one, autoRelation: false, keymaps: taxAuthorityRateSeqId)
    - OverrideOrgParty (one, autoRelation: false, keymaps: overrideOrgPartyId -> partyId)
    - SalesOpportunity (one, autoRelation: false, keymaps: salesOpportunityId)
    + FromInvoiceItemAssoc (many, autoRelation: true, keymaps: invoiceId -> invoiceIdFrom, invoiceItemSeqId -> invoiceItemSeqIdFrom)
    + ToInvoiceItemAssoc (many, autoRelation: true, keymaps: invoiceId -> invoiceIdTo, invoiceItemSeqId -> invoiceItemSeqIdTo)
    + InvoiceItemAttribute (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + InvoiceTerm (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + OrderAdjustmentBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + OrderItemBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + PaymentApplication (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + ReturnItemBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + ShipmentItemBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + TimeEntry (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + WorkEffortBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
*/


