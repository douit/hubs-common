package com.bluecc.domain.generic.dao;

import com.querydsl.core.types.Predicate;
import com.bluecc.domain.dummy.guice.Transactional;
import com.querydsl.sql.dml.SQLInsertClause;
import com.bluecc.domain.dummy.repository.AbstractRepository;

import java.util.List;

import com.bluecc.domain.sql.model.*;

import static com.bluecc.domain.sql.model.QOrderItem.orderItem;

// Order Item
public class OrderItemRepository extends AbstractRepository {
    @Transactional
    public Long save(OrderItem entity) {
        if (entity.getId() != null) {
            update(orderItem).populate(entity).execute();
            return entity.getId();
        }
        return insert(orderItem).populate(entity)
                .executeWithKey(orderItem.id);
    }

    @Transactional
    public OrderItem findById(Long id) {
        return selectFrom(orderItem).where(orderItem.id.eq(id)).fetchOne();
    }


    @Transactional
    public List<OrderItem> findAll(Predicate expr) {
        return selectFrom(orderItem).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(orderItem).fetchCount();
    }

    @Transactional
    public void delete(OrderItem s) {
        delete(orderItem)
            .where(orderItem.id.eq(s.getId()))
            .execute();
    }
}

/*
-- keys: orderId, orderItemSeqId

-- fields --
    
    Long orderId
    Long orderItemSeqId
    Long externalId
    Long orderItemTypeId
    Long orderItemGroupSeqId
    String isItemGroupPrimary
    Long fromInventoryItemId
    Long budgetId
    Long budgetItemSeqId
    Long productId
    Long supplierProductId
    Long productFeatureId
    Long prodCatalogId
    Long productCategoryId
    String isPromo
    Long quoteId
    Long quoteItemSeqId
    Long shoppingListId
    Long shoppingListItemSeqId
    Long subscriptionId
    Long deploymentId
    java.math.BigDecimal quantity
    java.math.BigDecimal cancelQuantity
    java.math.BigDecimal selectedAmount
    java.math.BigDecimal unitPrice
    java.math.BigDecimal unitListPrice
    java.math.BigDecimal unitAverageCost
    java.math.BigDecimal unitRecurringPrice
    String isModifiedPrice
    Long recurringFreqUomId
    String itemDescription
    String comments
    Long correspondingPoId
    Long statusId
    Long syncStatusId
    java.sql.Timestamp estimatedShipDate
    java.sql.Timestamp estimatedDeliveryDate
    java.sql.Timestamp autoCancelDate
    java.sql.Timestamp dontCancelSetDate
    Long dontCancelSetUserLogin
    java.sql.Timestamp shipBeforeDate
    java.sql.Timestamp shipAfterDate
    java.sql.Timestamp reserveAfterDate
    java.sql.Timestamp cancelBackOrderDate
    Long overrideGlAccountId
    Long salesOpportunityId
    Long changeByUserLoginId

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - OrderItemType (one, autoRelation: false, keymaps: orderItemTypeId)
    - OrderItemGroup (one, autoRelation: false, keymaps: orderId, orderItemGroupSeqId)
    + OrderItemTypeAttr (many, autoRelation: false, keymaps: orderItemTypeId)
    - Product (one, autoRelation: false, keymaps: productId)
    - FromInventoryItem (one, autoRelation: false, keymaps: fromInventoryItemId -> inventoryItemId)
    - RecurringFreqUom (one, autoRelation: false, keymaps: recurringFreqUomId -> uomId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    + ProductFacilityLocation (many, autoRelation: false, keymaps: productId)
    + StatusValidChange (many, autoRelation: false, keymaps: statusId)
    - SyncStatusItem (one, autoRelation: false, keymaps: syncStatusId -> statusId)
    - DontCancelSetUserLogin (one, autoRelation: false, keymaps: dontCancelSetUserLogin -> userLoginId)
    - QuoteItem (one, autoRelation: false, keymaps: quoteId, quoteItemSeqId)
    - ShoppingListItem (one-nofk, autoRelation: false, keymaps: shoppingListId, shoppingListItemSeqId)
    - OverrideGlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
    - SalesOpportunity (one, autoRelation: false, keymaps: salesOpportunityId)
    - ChangeByUserLogin (one, autoRelation: false, keymaps: changeByUserLoginId -> userLoginId)
    + Order ItemAllocationPlanItem (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + FinAccountTrans (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + AcquireFixedAsset (many, autoRelation: true, keymaps: orderId -> acquireOrderId, orderItemSeqId -> acquireOrderItemSeqId)
    + FixedAssetMaintOrder (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + GiftCardFulfillment (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + ItemIssuance (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderAdjustment (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    - OrderDeliverySchedule (one-nofk, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + FromOrderItemAssoc (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + ToOrderItemAssoc (many, autoRelation: true, keymaps: orderId -> toOrderId, orderItemSeqId -> toOrderItemSeqId)
    + OrderItemAttribute (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemBilling (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemChange (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemContactMech (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemGroupOrder (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemPriceInfo (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemRole (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemShipGroupAssoc (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderItemShipGrpInvRes (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderRequirementCommitment (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderShipment (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderStatus (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + OrderTerm (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + PicklistItem (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + ProductOrderItem (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + EngagementProductOrderItem (many, autoRelation: true, keymaps: orderId -> engagementId, orderItemSeqId -> engagementItemSeqId)
    + ReturnItem (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + Subscription (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + SurveyResponse (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
    + WorkOrderItemFulfillment (many, autoRelation: true, keymaps: orderId, orderItemSeqId)
*/


