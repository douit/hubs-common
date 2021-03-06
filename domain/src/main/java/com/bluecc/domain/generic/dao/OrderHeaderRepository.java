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

import static com.bluecc.domain.sql.model.QOrderHeader.orderHeader;

// Order Header
public class OrderHeaderRepository extends AbstractRepository {
    @Inject Sequence sequence;

    public static final QBean<OrderHeader> orderHeaderBean = bean(OrderHeader.class, orderHeader.all());

    @Transactional
    public String save(OrderHeader entity) {
        if (entity.getOrderId() != null) {
            entity.setLastUpdatedStamp(DateTime.now());
            update(orderHeader).populate(entity).execute();
            return entity.getOrderId();
        }
        entity.setCreatedStamp(DateTime.now());
        String uid=sequence.nextStringId();
        entity.setOrderId(uid);
        return create(entity);
        // return insert(orderHeader).populate(entity)
        //        .executeWithKey(orderHeader.orderId);
    }

    @Transactional
    public String create(OrderHeader entity){
        // 因为没有自增键, 所以ps.getGeneratedKeys()没有返回值
        insert(orderHeader).populate(entity)
                .executeWithKey(orderHeader.orderId);
        return entity.getOrderId();
    }

    @Transactional
    public OrderHeader findById(String id) {
        return selectFrom(orderHeader).where(orderHeader.orderId.eq(id)).fetchOne();
    }


    @Transactional
    public List<OrderHeader> findAll(Predicate expr) {
        return selectFrom(orderHeader).where(expr).fetch();
    }

    @Transactional
    public long count() {
        return selectFrom(orderHeader).fetchCount();
    }

    @Transactional
    public void delete(OrderHeader s) {
        delete(orderHeader)
            .where(orderHeader.orderId.eq(s.getOrderId()))
            .execute();
    }
}

/*
-- keys: orderId

-- fields --
    
    String orderId
    String orderTypeId
    String orderName
    String externalId
    String salesChannelEnumId
    java.sql.Timestamp orderDate
    String priority
    java.sql.Timestamp entryDate
    java.sql.Timestamp pickSheetPrintedDate
    String visitId
    String statusId
    String createdBy
    String firstAttemptOrderId
    String currencyUom
    String syncStatusId
    String billingAccountId
    String originFacilityId
    String webSiteId
    String productStoreId
    String agreementId
    String terminalId
    String transactionId
    String autoOrderShoppingListId
    String needsInventoryIssuance
    String isRushOrder
    String internalCode
    java.math.BigDecimal remainingSubTotal
    java.math.BigDecimal grandTotal
    String isViewed
    String invoicePerShipment

-- relations --
    
    - OrderType (one, autoRelation: false, keymaps: orderTypeId)
    - SalesChannelEnumeration (one, autoRelation: false, keymaps: salesChannelEnumId -> enumId)
    - OriginFacility (one, autoRelation: false, keymaps: originFacilityId -> facilityId)
    + OrderTypeAttr (many, autoRelation: false, keymaps: orderTypeId)
    - BillingAccount (one, autoRelation: false, keymaps: billingAccountId)
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - AutoOrderShoppingList (one, autoRelation: false, keymaps: autoOrderShoppingListId -> shoppingListId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdBy -> userLoginId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - SyncStatusItem (one, autoRelation: false, keymaps: syncStatusId -> statusId)
    - Uom (one, autoRelation: false, keymaps: currencyUom -> uomId)
    - WebSite (one, autoRelation: false, keymaps: webSiteId)
    + Order IdAllocationPlanItem (many, autoRelation: true, keymaps: orderId)
    + CommunicationEventOrder (many, autoRelation: true, keymaps: orderId)
    + AcquireFixedAsset (many, autoRelation: true, keymaps: orderId -> acquireOrderId)
    + PurchaseFixedAssetMaint (many, autoRelation: true, keymaps: orderId -> purchaseOrderId)
    + FixedAssetMaintOrder (many, autoRelation: true, keymaps: orderId)
    + GiftCardFulfillment (many, autoRelation: true, keymaps: orderId)
    + ItemIssuance (many, autoRelation: true, keymaps: orderId)
    + OrderAdjustment (many, autoRelation: true, keymaps: orderId)
    + OrderAttribute (many, autoRelation: true, keymaps: orderId)
    + OrderContactMech (many, autoRelation: true, keymaps: orderId)
    + OrderContent (many, autoRelation: true, keymaps: orderId)
    + OrderDeliverySchedule (many, autoRelation: true, keymaps: orderId)
    + OrderHeaderNote (many, autoRelation: true, keymaps: orderId)
    + OrderHeaderWorkEffort (many, autoRelation: true, keymaps: orderId)
    + OrderItem (many, autoRelation: true, keymaps: orderId)
    + FromOrderItemAssoc (many, autoRelation: true, keymaps: orderId)
    + ToOrderItemAssoc (many, autoRelation: true, keymaps: orderId -> toOrderId)
    + OrderItemBilling (many, autoRelation: true, keymaps: orderId)
    + OrderItemChange (many, autoRelation: true, keymaps: orderId)
    + OrderItemContactMech (many, autoRelation: true, keymaps: orderId)
    + OrderItemGroup (many, autoRelation: true, keymaps: orderId)
    + OrderItemPriceInfo (many, autoRelation: true, keymaps: orderId)
    + OrderItemRole (many, autoRelation: true, keymaps: orderId)
    + OrderItemShipGroup (many, autoRelation: true, keymaps: orderId)
    + OrderItemShipGroupAssoc (many, autoRelation: true, keymaps: orderId)
    + OrderItemShipGrpInvRes (many, autoRelation: true, keymaps: orderId)
    + OrderNotification (many, autoRelation: true, keymaps: orderId)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: orderId)
    + OrderProductPromoCode (many, autoRelation: true, keymaps: orderId)
    + OrderRequirementCommitment (many, autoRelation: true, keymaps: orderId)
    + OrderRole (many, autoRelation: true, keymaps: orderId)
    + OrderShipment (many, autoRelation: true, keymaps: orderId)
    + OrderStatus (many, autoRelation: true, keymaps: orderId)
    + OrderTerm (many, autoRelation: true, keymaps: orderId)
    + PrimaryPicklistBin (many, autoRelation: true, keymaps: orderId -> primaryOrderId)
    + PicklistItem (many, autoRelation: true, keymaps: orderId)
    + PosTerminalLog (many, autoRelation: true, keymaps: orderId)
    + ProductOrderItem (many, autoRelation: true, keymaps: orderId)
    + EngagementProductOrderItem (many, autoRelation: true, keymaps: orderId -> engagementId)
    + ProductPromoUse (many, autoRelation: true, keymaps: orderId)
    + ReturnItem (many, autoRelation: true, keymaps: orderId)
    + ReplacementReturnItemResponse (many, autoRelation: true, keymaps: orderId -> replacementOrderId)
    + PrimaryShipment (many, autoRelation: true, keymaps: orderId -> primaryOrderId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: orderId)
    + Subscription (many, autoRelation: true, keymaps: orderId)
    + SurveyResponse (many, autoRelation: true, keymaps: orderId)
    + TrackingCodeOrder (many, autoRelation: true, keymaps: orderId)
    + TrackingCodeOrderReturn (many, autoRelation: true, keymaps: orderId)
    + WorkOrderItemFulfillment (many, autoRelation: true, keymaps: orderId)
*/


