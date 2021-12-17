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
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.OrderItemFlatData;

import com.bluecc.hubs.stub.OrderItemData;
import com.bluecc.income.dao.OrderItemDelegator;
import static com.bluecc.income.dao.OrderItemDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemData.class,
        symbol = EntityNames.OrderItem)
public class OrderItem implements IEventModel<OrderItemFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_id")
	@RIndex 
    String orderId;
    @SerializedName("order_item_seq_id")
	@RIndex 
    String orderItemSeqId;
    @SerializedName("external_id") 
    String externalId;
    @SerializedName("order_item_type_id") 
    String orderItemTypeId;
    @SerializedName("order_item_group_seq_id") 
    String orderItemGroupSeqId;
    @SerializedName("is_item_group_primary") 
    Character isItemGroupPrimary;
    @SerializedName("from_inventory_item_id") 
    String fromInventoryItemId;
    @SerializedName("budget_id") 
    String budgetId;
    @SerializedName("budget_item_seq_id") 
    String budgetItemSeqId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("supplier_product_id") 
    String supplierProductId;
    @SerializedName("product_feature_id") 
    String productFeatureId;
    @SerializedName("prod_catalog_id") 
    String prodCatalogId;
    @SerializedName("product_category_id") 
    String productCategoryId;
    @SerializedName("is_promo") 
    Character isPromo;
    @SerializedName("quote_id") 
    String quoteId;
    @SerializedName("quote_item_seq_id") 
    String quoteItemSeqId;
    @SerializedName("shopping_list_id") 
    String shoppingListId;
    @SerializedName("shopping_list_item_seq_id") 
    String shoppingListItemSeqId;
    @SerializedName("subscription_id") 
    String subscriptionId;
    @SerializedName("deployment_id") 
    String deploymentId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("cancel_quantity") 
    java.math.BigDecimal cancelQuantity;
    @SerializedName("selected_amount") 
    java.math.BigDecimal selectedAmount;
    @SerializedName("unit_price") 
    java.math.BigDecimal unitPrice;
    @SerializedName("unit_list_price") 
    java.math.BigDecimal unitListPrice;
    @SerializedName("unit_average_cost") 
    java.math.BigDecimal unitAverageCost;
    @SerializedName("unit_recurring_price") 
    java.math.BigDecimal unitRecurringPrice;
    @SerializedName("is_modified_price") 
    Character isModifiedPrice;
    @SerializedName("recurring_freq_uom_id") 
    String recurringFreqUomId;
    @SerializedName("item_description") 
    String itemDescription;
    @SerializedName("comments") 
    String comments;
    @SerializedName("corresponding_po_id") 
    String correspondingPoId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("sync_status_id") 
    String syncStatusId;
    @SerializedName("estimated_ship_date") 
    java.time.LocalDateTime estimatedShipDate;
    @SerializedName("estimated_delivery_date") 
    java.time.LocalDateTime estimatedDeliveryDate;
    @SerializedName("auto_cancel_date") 
    java.time.LocalDateTime autoCancelDate;
    @SerializedName("dont_cancel_set_date") 
    java.time.LocalDateTime dontCancelSetDate;
    @SerializedName("dont_cancel_set_user_login") 
    String dontCancelSetUserLogin;
    @SerializedName("ship_before_date") 
    java.time.LocalDateTime shipBeforeDate;
    @SerializedName("ship_after_date") 
    java.time.LocalDateTime shipAfterDate;
    @SerializedName("reserve_after_date") 
    java.time.LocalDateTime reserveAfterDate;
    @SerializedName("cancel_back_order_date") 
    java.time.LocalDateTime cancelBackOrderDate;
    @SerializedName("override_gl_account_id") 
    String overrideGlAccountId;
    @SerializedName("sales_opportunity_id") 
    String salesOpportunityId;
    @SerializedName("change_by_user_login_id") 
    String changeByUserLoginId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    @SerializedName("tenant_id") 
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemFlatData.Builder toDataBuilder() {
        OrderItemFlatData.Builder builder = OrderItemFlatData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (orderItemTypeId != null) {
            builder.setOrderItemTypeId(orderItemTypeId);
        }
        if (orderItemGroupSeqId != null) {
            builder.setOrderItemGroupSeqId(orderItemGroupSeqId);
        }
        if (isItemGroupPrimary != null) {
            builder.setIsItemGroupPrimary(getIndicator(isItemGroupPrimary));
        }
        if (fromInventoryItemId != null) {
            builder.setFromInventoryItemId(fromInventoryItemId);
        }
        if (budgetId != null) {
            builder.setBudgetId(budgetId);
        }
        if (budgetItemSeqId != null) {
            builder.setBudgetItemSeqId(budgetItemSeqId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (supplierProductId != null) {
            builder.setSupplierProductId(supplierProductId);
        }
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (isPromo != null) {
            builder.setIsPromo(getIndicator(isPromo));
        }
        if (quoteId != null) {
            builder.setQuoteId(quoteId);
        }
        if (quoteItemSeqId != null) {
            builder.setQuoteItemSeqId(quoteItemSeqId);
        }
        if (shoppingListId != null) {
            builder.setShoppingListId(shoppingListId);
        }
        if (shoppingListItemSeqId != null) {
            builder.setShoppingListItemSeqId(shoppingListItemSeqId);
        }
        if (subscriptionId != null) {
            builder.setSubscriptionId(subscriptionId);
        }
        if (deploymentId != null) {
            builder.setDeploymentId(deploymentId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (cancelQuantity != null) {
            builder.setCancelQuantity(getFixedPoint(cancelQuantity));
        }
        if (selectedAmount != null) {
            builder.setSelectedAmount(getFixedPoint(selectedAmount));
        }
        if (unitPrice != null) {
            builder.setUnitPrice(getCurrency(unitPrice));
        }
        if (unitListPrice != null) {
            builder.setUnitListPrice(getCurrency(unitListPrice));
        }
        if (unitAverageCost != null) {
            builder.setUnitAverageCost(getCurrency(unitAverageCost));
        }
        if (unitRecurringPrice != null) {
            builder.setUnitRecurringPrice(getCurrency(unitRecurringPrice));
        }
        if (isModifiedPrice != null) {
            builder.setIsModifiedPrice(getIndicator(isModifiedPrice));
        }
        if (recurringFreqUomId != null) {
            builder.setRecurringFreqUomId(recurringFreqUomId);
        }
        if (itemDescription != null) {
            builder.setItemDescription(itemDescription);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (correspondingPoId != null) {
            builder.setCorrespondingPoId(correspondingPoId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (syncStatusId != null) {
            builder.setSyncStatusId(syncStatusId);
        }
        if (estimatedShipDate != null) {
            builder.setEstimatedShipDate(getTimestamp(estimatedShipDate));
        }
        if (estimatedDeliveryDate != null) {
            builder.setEstimatedDeliveryDate(getTimestamp(estimatedDeliveryDate));
        }
        if (autoCancelDate != null) {
            builder.setAutoCancelDate(getTimestamp(autoCancelDate));
        }
        if (dontCancelSetDate != null) {
            builder.setDontCancelSetDate(getTimestamp(dontCancelSetDate));
        }
        if (dontCancelSetUserLogin != null) {
            builder.setDontCancelSetUserLogin(dontCancelSetUserLogin);
        }
        if (shipBeforeDate != null) {
            builder.setShipBeforeDate(getTimestamp(shipBeforeDate));
        }
        if (shipAfterDate != null) {
            builder.setShipAfterDate(getTimestamp(shipAfterDate));
        }
        if (reserveAfterDate != null) {
            builder.setReserveAfterDate(getTimestamp(reserveAfterDate));
        }
        if (cancelBackOrderDate != null) {
            builder.setCancelBackOrderDate(getTimestamp(cancelBackOrderDate));
        }
        if (overrideGlAccountId != null) {
            builder.setOverrideGlAccountId(overrideGlAccountId);
        }
        if (salesOpportunityId != null) {
            builder.setSalesOpportunityId(salesOpportunityId);
        }
        if (changeByUserLoginId != null) {
            builder.setChangeByUserLoginId(changeByUserLoginId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static OrderItem fromData(OrderItemFlatData data) {
        return OrderItem.builder()
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .externalId(data.getExternalId())
                .orderItemTypeId(data.getOrderItemTypeId())
                .orderItemGroupSeqId(data.getOrderItemGroupSeqId())
                .isItemGroupPrimary(getIndicatorChar(data.getIsItemGroupPrimary()))
                .fromInventoryItemId(data.getFromInventoryItemId())
                .budgetId(data.getBudgetId())
                .budgetItemSeqId(data.getBudgetItemSeqId())
                .productId(data.getProductId())
                .supplierProductId(data.getSupplierProductId())
                .productFeatureId(data.getProductFeatureId())
                .prodCatalogId(data.getProdCatalogId())
                .productCategoryId(data.getProductCategoryId())
                .isPromo(getIndicatorChar(data.getIsPromo()))
                .quoteId(data.getQuoteId())
                .quoteItemSeqId(data.getQuoteItemSeqId())
                .shoppingListId(data.getShoppingListId())
                .shoppingListItemSeqId(data.getShoppingListItemSeqId())
                .subscriptionId(data.getSubscriptionId())
                .deploymentId(data.getDeploymentId())
                .quantity(getBigDecimal(data.getQuantity()))
                .cancelQuantity(getBigDecimal(data.getCancelQuantity()))
                .selectedAmount(getBigDecimal(data.getSelectedAmount()))
                .unitPrice(getBigDecimal(data.getUnitPrice()))
                .unitListPrice(getBigDecimal(data.getUnitListPrice()))
                .unitAverageCost(getBigDecimal(data.getUnitAverageCost()))
                .unitRecurringPrice(getBigDecimal(data.getUnitRecurringPrice()))
                .isModifiedPrice(getIndicatorChar(data.getIsModifiedPrice()))
                .recurringFreqUomId(data.getRecurringFreqUomId())
                .itemDescription(data.getItemDescription())
                .comments(data.getComments())
                .correspondingPoId(data.getCorrespondingPoId())
                .statusId(data.getStatusId())
                .syncStatusId(data.getSyncStatusId())
                .estimatedShipDate(getLocalDateTime(data.getEstimatedShipDate()))
                .estimatedDeliveryDate(getLocalDateTime(data.getEstimatedDeliveryDate()))
                .autoCancelDate(getLocalDateTime(data.getAutoCancelDate()))
                .dontCancelSetDate(getLocalDateTime(data.getDontCancelSetDate()))
                .dontCancelSetUserLogin(data.getDontCancelSetUserLogin())
                .shipBeforeDate(getLocalDateTime(data.getShipBeforeDate()))
                .shipAfterDate(getLocalDateTime(data.getShipAfterDate()))
                .reserveAfterDate(getLocalDateTime(data.getReserveAfterDate()))
                .cancelBackOrderDate(getLocalDateTime(data.getCancelBackOrderDate()))
                .overrideGlAccountId(data.getOverrideGlAccountId())
                .salesOpportunityId(data.getSalesOpportunityId())
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addOrderHeader")
    List<OrderHeader> relOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addProduct")
    List<Product> relProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addFromInventoryItem")
    List<InventoryItem> relFromInventoryItem= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacilityLocation")
    List<ProductFacilityLocation> relProductFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addDontCancelSetUserLogin")
    List<UserLogin> relDontCancelSetUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteItem")
    List<QuoteItem> relQuoteItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOverrideGlAccount")
    List<GlAccount> relOverrideGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addChangeByUserLogin")
    List<UserLogin> relChangeByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountTrans")
    List<FinAccountTrans> relFinAccountTrans= new ArrayList<>(); 
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
    @Singular("addOrderItemBilling")
    List<OrderItemBilling> relOrderItemBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemPriceInfo")
    List<OrderItemPriceInfo> relOrderItemPriceInfo= new ArrayList<>(); 
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
    @Singular("addOrderStatus")
    List<OrderStatus> relOrderStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(ORDER_HEADER, getter(this, OrderItem::getRelOrderHeader)); 
        supplierMap.put(PRODUCT, getter(this, OrderItem::getRelProduct)); 
        supplierMap.put(FROM_INVENTORY_ITEM, getter(this, OrderItem::getRelFromInventoryItem)); 
        supplierMap.put(PRODUCT_FACILITY_LOCATION, getter(this, OrderItem::getRelProductFacilityLocation)); 
        supplierMap.put(DONT_CANCEL_SET_USER_LOGIN, getter(this, OrderItem::getRelDontCancelSetUserLogin)); 
        supplierMap.put(QUOTE_ITEM, getter(this, OrderItem::getRelQuoteItem)); 
        supplierMap.put(OVERRIDE_GL_ACCOUNT, getter(this, OrderItem::getRelOverrideGlAccount)); 
        supplierMap.put(CHANGE_BY_USER_LOGIN, getter(this, OrderItem::getRelChangeByUserLogin)); 
        supplierMap.put(FIN_ACCOUNT_TRANS, getter(this, OrderItem::getRelFinAccountTrans)); 
        supplierMap.put(ACQUIRE_FIXED_ASSET, getter(this, OrderItem::getRelAcquireFixedAsset)); 
        supplierMap.put(ITEM_ISSUANCE, getter(this, OrderItem::getRelItemIssuance)); 
        supplierMap.put(ORDER_ADJUSTMENT, getter(this, OrderItem::getRelOrderAdjustment)); 
        supplierMap.put(ORDER_ITEM_BILLING, getter(this, OrderItem::getRelOrderItemBilling)); 
        supplierMap.put(ORDER_ITEM_PRICE_INFO, getter(this, OrderItem::getRelOrderItemPriceInfo)); 
        supplierMap.put(ORDER_ITEM_SHIP_GROUP_ASSOC, getter(this, OrderItem::getRelOrderItemShipGroupAssoc)); 
        supplierMap.put(ORDER_ITEM_SHIP_GRP_INV_RES, getter(this, OrderItem::getRelOrderItemShipGrpInvRes)); 
        supplierMap.put(ORDER_PAYMENT_PREFERENCE, getter(this, OrderItem::getRelOrderPaymentPreference)); 
        supplierMap.put(ORDER_STATUS, getter(this, OrderItem::getRelOrderStatus)); 
        supplierMap.put(SHIPMENT_RECEIPT, getter(this, OrderItem::getRelShipmentReceipt)); 
        supplierMap.put(TENANT, getter(this, OrderItem::getRelTenant));

        return supplierMap;
    };

    public OrderItemDelegator.Agent agent(IProc.ProcContext ctx,
                                             OrderItemDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public OrderItemData.Builder toHeadBuilder() {
        OrderItemData.Builder builder = OrderItemData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (externalId != null) {
            builder.setExternalId(externalId);
        }
        if (orderItemTypeId != null) {
            builder.setOrderItemTypeId(orderItemTypeId);
        }
        if (orderItemGroupSeqId != null) {
            builder.setOrderItemGroupSeqId(orderItemGroupSeqId);
        }
        if (isItemGroupPrimary != null) {
            builder.setIsItemGroupPrimary(getIndicator(isItemGroupPrimary));
        }
        if (budgetId != null) {
            builder.setBudgetId(budgetId);
        }
        if (budgetItemSeqId != null) {
            builder.setBudgetItemSeqId(budgetItemSeqId);
        }
        if (supplierProductId != null) {
            builder.setSupplierProductId(supplierProductId);
        }
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (prodCatalogId != null) {
            builder.setProdCatalogId(prodCatalogId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (isPromo != null) {
            builder.setIsPromo(getIndicator(isPromo));
        }
        if (quoteItemSeqId != null) {
            builder.setQuoteItemSeqId(quoteItemSeqId);
        }
        if (shoppingListId != null) {
            builder.setShoppingListId(shoppingListId);
        }
        if (shoppingListItemSeqId != null) {
            builder.setShoppingListItemSeqId(shoppingListItemSeqId);
        }
        if (subscriptionId != null) {
            builder.setSubscriptionId(subscriptionId);
        }
        if (deploymentId != null) {
            builder.setDeploymentId(deploymentId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (cancelQuantity != null) {
            builder.setCancelQuantity(getFixedPoint(cancelQuantity));
        }
        if (selectedAmount != null) {
            builder.setSelectedAmount(getFixedPoint(selectedAmount));
        }
        if (unitPrice != null) {
            builder.setUnitPrice(getCurrency(unitPrice));
        }
        if (unitListPrice != null) {
            builder.setUnitListPrice(getCurrency(unitListPrice));
        }
        if (unitAverageCost != null) {
            builder.setUnitAverageCost(getCurrency(unitAverageCost));
        }
        if (unitRecurringPrice != null) {
            builder.setUnitRecurringPrice(getCurrency(unitRecurringPrice));
        }
        if (isModifiedPrice != null) {
            builder.setIsModifiedPrice(getIndicator(isModifiedPrice));
        }
        if (recurringFreqUomId != null) {
            builder.setRecurringFreqUomId(recurringFreqUomId);
        }
        if (itemDescription != null) {
            builder.setItemDescription(itemDescription);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (correspondingPoId != null) {
            builder.setCorrespondingPoId(correspondingPoId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (syncStatusId != null) {
            builder.setSyncStatusId(syncStatusId);
        }
        if (estimatedShipDate != null) {
            builder.setEstimatedShipDate(getTimestamp(estimatedShipDate));
        }
        if (estimatedDeliveryDate != null) {
            builder.setEstimatedDeliveryDate(getTimestamp(estimatedDeliveryDate));
        }
        if (autoCancelDate != null) {
            builder.setAutoCancelDate(getTimestamp(autoCancelDate));
        }
        if (dontCancelSetDate != null) {
            builder.setDontCancelSetDate(getTimestamp(dontCancelSetDate));
        }
        if (shipBeforeDate != null) {
            builder.setShipBeforeDate(getTimestamp(shipBeforeDate));
        }
        if (shipAfterDate != null) {
            builder.setShipAfterDate(getTimestamp(shipAfterDate));
        }
        if (reserveAfterDate != null) {
            builder.setReserveAfterDate(getTimestamp(reserveAfterDate));
        }
        if (cancelBackOrderDate != null) {
            builder.setCancelBackOrderDate(getTimestamp(cancelBackOrderDate));
        }
        if (salesOpportunityId != null) {
            builder.setSalesOpportunityId(salesOpportunityId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

}


/*
-- keys: orderId, orderItemSeqId

-- fields --
    
    String orderId
    String orderItemSeqId
    String externalId
    String orderItemTypeId
    String orderItemGroupSeqId
    Character isItemGroupPrimary
    String fromInventoryItemId
    String budgetId
    String budgetItemSeqId
    String productId
    String supplierProductId
    String productFeatureId
    String prodCatalogId
    String productCategoryId
    Character isPromo
    String quoteId
    String quoteItemSeqId
    String shoppingListId
    String shoppingListItemSeqId
    String subscriptionId
    String deploymentId
    java.math.BigDecimal quantity
    java.math.BigDecimal cancelQuantity
    java.math.BigDecimal selectedAmount
    java.math.BigDecimal unitPrice
    java.math.BigDecimal unitListPrice
    java.math.BigDecimal unitAverageCost
    java.math.BigDecimal unitRecurringPrice
    Character isModifiedPrice
    String recurringFreqUomId
    String itemDescription
    String comments
    String correspondingPoId
    String statusId
    String syncStatusId
    java.time.LocalDateTime estimatedShipDate
    java.time.LocalDateTime estimatedDeliveryDate
    java.time.LocalDateTime autoCancelDate
    java.time.LocalDateTime dontCancelSetDate
    String dontCancelSetUserLogin
    java.time.LocalDateTime shipBeforeDate
    java.time.LocalDateTime shipAfterDate
    java.time.LocalDateTime reserveAfterDate
    java.time.LocalDateTime cancelBackOrderDate
    String overrideGlAccountId
    String salesOpportunityId
    String changeByUserLoginId

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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

