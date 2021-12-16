//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.OrderHeaderFlatData;

import com.bluecc.hubs.stub.OrderHeaderData;
import com.bluecc.income.dao.OrderHeaderDelegator;
import static com.bluecc.income.dao.OrderHeaderDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderHeaderData.class,
        symbol = EntityNames.OrderHeader)
public class OrderHeader implements IEventModel<OrderHeaderFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String orderId;
    String orderTypeId;
    String orderName;
    String externalId;
    String salesChannelEnumId;
    java.time.LocalDateTime orderDate;
    Character priority;
    java.time.LocalDateTime entryDate;
    java.time.LocalDateTime pickSheetPrintedDate;
    String visitId;
    String statusId;
    String createdBy;
    String firstAttemptOrderId;
    String currencyUom;
    String syncStatusId;
    String billingAccountId;
    String originFacilityId;
    String webSiteId;
    String productStoreId;
    String agreementId;
    String terminalId;
    String transactionId;
    String autoOrderShoppingListId;
    Character needsInventoryIssuance;
    Character isRushOrder;
    String internalCode;
    java.math.BigDecimal remainingSubTotal;
    java.math.BigDecimal grandTotal;
    Character isViewed;
    Character invoicePerShipment;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderHeaderFlatData.Builder toDataBuilder() {
        OrderHeaderFlatData.Builder builder = OrderHeaderFlatData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderTypeId != null) {
            builder.setOrderTypeId(orderTypeId);
        }
        if (orderName != null) {
            builder.setOrderName(orderName);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (salesChannelEnumId != null) {
            builder.setSalesChannelEnumId(salesChannelEnumId);
        }
        if (orderDate != null) {
            builder.setOrderDate(getTimestamp(orderDate));
        }
        if (priority != null) {
            builder.setPriority(getIndicator(priority));
        }
        if (entryDate != null) {
            builder.setEntryDate(getTimestamp(entryDate));
        }
        if (pickSheetPrintedDate != null) {
            builder.setPickSheetPrintedDate(getTimestamp(pickSheetPrintedDate));
        }
        if (visitId != null) {
            builder.setVisitId(visitId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (createdBy != null) {
            builder.setCreatedBy(createdBy);
        }
        if (firstAttemptOrderId != null) {
            builder.setFirstAttemptOrderId(firstAttemptOrderId);
        }
        if (currencyUom != null) {
            builder.setCurrencyUom(currencyUom);
        }
        if (syncStatusId != null) {
            builder.setSyncStatusId(syncStatusId);
        }
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (originFacilityId != null) {
            builder.setOriginFacilityId(originFacilityId);
        }
        if (webSiteId != null) {
            builder.setWebSiteId(webSiteId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (terminalId != null) {
            builder.setTerminalId(terminalId);
        }
        if (transactionId != null) {
            builder.setTransactionId(transactionId);
        }
        if (autoOrderShoppingListId != null) {
            builder.setAutoOrderShoppingListId(autoOrderShoppingListId);
        }
        if (needsInventoryIssuance != null) {
            builder.setNeedsInventoryIssuance(getIndicator(needsInventoryIssuance));
        }
        if (isRushOrder != null) {
            builder.setIsRushOrder(getIndicator(isRushOrder));
        }
        if (internalCode != null) {
            builder.setInternalCode(internalCode);
        }
        if (remainingSubTotal != null) {
            builder.setRemainingSubTotal(getCurrency(remainingSubTotal));
        }
        if (grandTotal != null) {
            builder.setGrandTotal(getCurrency(grandTotal));
        }
        if (isViewed != null) {
            builder.setIsViewed(getIndicator(isViewed));
        }
        if (invoicePerShipment != null) {
            builder.setInvoicePerShipment(getIndicator(invoicePerShipment));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static OrderHeader fromData(OrderHeaderFlatData data) {
        return OrderHeader.builder()
                .orderId(data.getOrderId())
                .orderTypeId(data.getOrderTypeId())
                .orderName(data.getOrderName())
                .externalId(data.getExternalId())
                .salesChannelEnumId(data.getSalesChannelEnumId())
                .orderDate(getLocalDateTime(data.getOrderDate()))
                .priority(getIndicatorChar(data.getPriority()))
                .entryDate(getLocalDateTime(data.getEntryDate()))
                .pickSheetPrintedDate(getLocalDateTime(data.getPickSheetPrintedDate()))
                .visitId(data.getVisitId())
                .statusId(data.getStatusId())
                .createdBy(data.getCreatedBy())
                .firstAttemptOrderId(data.getFirstAttemptOrderId())
                .currencyUom(data.getCurrencyUom())
                .syncStatusId(data.getSyncStatusId())
                .billingAccountId(data.getBillingAccountId())
                .originFacilityId(data.getOriginFacilityId())
                .webSiteId(data.getWebSiteId())
                .productStoreId(data.getProductStoreId())
                .agreementId(data.getAgreementId())
                .terminalId(data.getTerminalId())
                .transactionId(data.getTransactionId())
                .autoOrderShoppingListId(data.getAutoOrderShoppingListId())
                .needsInventoryIssuance(getIndicatorChar(data.getNeedsInventoryIssuance()))
                .isRushOrder(getIndicatorChar(data.getIsRushOrder()))
                .internalCode(data.getInternalCode())
                .remainingSubTotal(getBigDecimal(data.getRemainingSubTotal()))
                .grandTotal(getBigDecimal(data.getGrandTotal()))
                .isViewed(getIndicatorChar(data.getIsViewed()))
                .invoicePerShipment(getIndicatorChar(data.getInvoicePerShipment()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addOriginFacility")
    List<Facility> relOriginFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addBillingAccount")
    List<BillingAccount> relBillingAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStore")
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByUserLogin")
    List<UserLogin> relCreatedByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addWebSite")
    List<WebSite> relWebSite= new ArrayList<>(); 
    @Exclude
    @Singular("addAcquireFixedAsset")
    List<FixedAsset> relAcquireFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addItemIssuance")
    List<ItemIssuance> relItemIssuance= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderAdjustment")
    List<OrderAdjustment> relOrderAdjustment= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderContactMech")
    List<OrderContactMech> relOrderContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItem")
    List<OrderItem> relOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemBilling")
    List<OrderItemBilling> relOrderItemBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemPriceInfo")
    List<OrderItemPriceInfo> relOrderItemPriceInfo= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemShipGroup")
    List<OrderItemShipGroup> relOrderItemShipGroup= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemShipGroupAssoc")
    List<OrderItemShipGroupAssoc> relOrderItemShipGroupAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemShipGrpInvRes")
    List<OrderItemShipGrpInvRes> relOrderItemShipGrpInvRes= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderPaymentPreference")
    List<OrderPaymentPreference> relOrderPaymentPreference= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderRole")
    List<OrderRole> relOrderRole= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderStatus")
    List<OrderStatus> relOrderStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addPrimaryShipment")
    List<Shipment> relPrimaryShipment= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(ORIGIN_FACILITY, getter(this, OrderHeader::getRelOriginFacility)); 
        supplierMap.put(BILLING_ACCOUNT, getter(this, OrderHeader::getRelBillingAccount)); 
        supplierMap.put(PRODUCT_STORE, getter(this, OrderHeader::getRelProductStore)); 
        supplierMap.put(CREATED_BY_USER_LOGIN, getter(this, OrderHeader::getRelCreatedByUserLogin)); 
        supplierMap.put(WEB_SITE, getter(this, OrderHeader::getRelWebSite)); 
        supplierMap.put(ACQUIRE_FIXED_ASSET, getter(this, OrderHeader::getRelAcquireFixedAsset)); 
        supplierMap.put(ITEM_ISSUANCE, getter(this, OrderHeader::getRelItemIssuance)); 
        supplierMap.put(ORDER_ADJUSTMENT, getter(this, OrderHeader::getRelOrderAdjustment)); 
        supplierMap.put(ORDER_CONTACT_MECH, getter(this, OrderHeader::getRelOrderContactMech)); 
        supplierMap.put(ORDER_ITEM, getter(this, OrderHeader::getRelOrderItem)); 
        supplierMap.put(ORDER_ITEM_BILLING, getter(this, OrderHeader::getRelOrderItemBilling)); 
        supplierMap.put(ORDER_ITEM_PRICE_INFO, getter(this, OrderHeader::getRelOrderItemPriceInfo)); 
        supplierMap.put(ORDER_ITEM_SHIP_GROUP, getter(this, OrderHeader::getRelOrderItemShipGroup)); 
        supplierMap.put(ORDER_ITEM_SHIP_GROUP_ASSOC, getter(this, OrderHeader::getRelOrderItemShipGroupAssoc)); 
        supplierMap.put(ORDER_ITEM_SHIP_GRP_INV_RES, getter(this, OrderHeader::getRelOrderItemShipGrpInvRes)); 
        supplierMap.put(ORDER_PAYMENT_PREFERENCE, getter(this, OrderHeader::getRelOrderPaymentPreference)); 
        supplierMap.put(ORDER_ROLE, getter(this, OrderHeader::getRelOrderRole)); 
        supplierMap.put(ORDER_STATUS, getter(this, OrderHeader::getRelOrderStatus)); 
        supplierMap.put(PRIMARY_SHIPMENT, getter(this, OrderHeader::getRelPrimaryShipment)); 
        supplierMap.put(SHIPMENT_RECEIPT, getter(this, OrderHeader::getRelShipmentReceipt)); 
        supplierMap.put(TENANT, getter(this, OrderHeader::getRelTenant));

        return supplierMap;
    };

    public OrderHeaderDelegator.Agent agent(IProc.ProcContext ctx,
                                             OrderHeaderDelegator delegator){
        return delegator.getAgent(ctx, this.getOrderId());
    }

    public OrderHeaderData.Builder toHeadBuilder() {
        OrderHeaderData.Builder builder = OrderHeaderData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderTypeId != null) {
            builder.setOrderTypeId(orderTypeId);
        }
        if (orderName != null) {
            builder.setOrderName(orderName);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (salesChannelEnumId != null) {
            builder.setSalesChannelEnumId(salesChannelEnumId);
        }
        if (orderDate != null) {
            builder.setOrderDate(getTimestamp(orderDate));
        }
        if (priority != null) {
            builder.setPriority(getIndicator(priority));
        }
        if (entryDate != null) {
            builder.setEntryDate(getTimestamp(entryDate));
        }
        if (pickSheetPrintedDate != null) {
            builder.setPickSheetPrintedDate(getTimestamp(pickSheetPrintedDate));
        }
        if (visitId != null) {
            builder.setVisitId(visitId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (firstAttemptOrderId != null) {
            builder.setFirstAttemptOrderId(firstAttemptOrderId);
        }
        if (currencyUom != null) {
            builder.setCurrencyUom(currencyUom);
        }
        if (syncStatusId != null) {
            builder.setSyncStatusId(syncStatusId);
        }
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (terminalId != null) {
            builder.setTerminalId(terminalId);
        }
        if (transactionId != null) {
            builder.setTransactionId(transactionId);
        }
        if (autoOrderShoppingListId != null) {
            builder.setAutoOrderShoppingListId(autoOrderShoppingListId);
        }
        if (needsInventoryIssuance != null) {
            builder.setNeedsInventoryIssuance(getIndicator(needsInventoryIssuance));
        }
        if (isRushOrder != null) {
            builder.setIsRushOrder(getIndicator(isRushOrder));
        }
        if (internalCode != null) {
            builder.setInternalCode(internalCode);
        }
        if (remainingSubTotal != null) {
            builder.setRemainingSubTotal(getCurrency(remainingSubTotal));
        }
        if (grandTotal != null) {
            builder.setGrandTotal(getCurrency(grandTotal));
        }
        if (isViewed != null) {
            builder.setIsViewed(getIndicator(isViewed));
        }
        if (invoicePerShipment != null) {
            builder.setInvoicePerShipment(getIndicator(invoicePerShipment));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
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
    java.time.LocalDateTime orderDate
    Character priority
    java.time.LocalDateTime entryDate
    java.time.LocalDateTime pickSheetPrintedDate
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
    Character needsInventoryIssuance
    Character isRushOrder
    String internalCode
    java.math.BigDecimal remainingSubTotal
    java.math.BigDecimal grandTotal
    Character isViewed
    Character invoicePerShipment

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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

