package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.OrderItemFlatData;

import com.bluecc.hubs.stub.OrderItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class OrderItem implements IEventModel<OrderItemFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String orderId;
    @RIndex String orderItemSeqId;
    String externalId;
    String orderItemTypeId;
    String orderItemGroupSeqId;
    Character isItemGroupPrimary;
    String fromInventoryItemId;
    String budgetId;
    String budgetItemSeqId;
    String productId;
    String supplierProductId;
    String productFeatureId;
    String prodCatalogId;
    String productCategoryId;
    Character isPromo;
    String quoteId;
    String quoteItemSeqId;
    String shoppingListId;
    String shoppingListItemSeqId;
    String subscriptionId;
    String deploymentId;
    java.math.BigDecimal quantity;
    java.math.BigDecimal cancelQuantity;
    java.math.BigDecimal selectedAmount;
    java.math.BigDecimal unitPrice;
    java.math.BigDecimal unitListPrice;
    java.math.BigDecimal unitAverageCost;
    java.math.BigDecimal unitRecurringPrice;
    Character isModifiedPrice;
    String recurringFreqUomId;
    String itemDescription;
    String comments;
    String correspondingPoId;
    String statusId;
    String syncStatusId;
    java.time.LocalDateTime estimatedShipDate;
    java.time.LocalDateTime estimatedDeliveryDate;
    java.time.LocalDateTime autoCancelDate;
    java.time.LocalDateTime dontCancelSetDate;
    String dontCancelSetUserLogin;
    java.time.LocalDateTime shipBeforeDate;
    java.time.LocalDateTime shipAfterDate;
    java.time.LocalDateTime reserveAfterDate;
    java.time.LocalDateTime cancelBackOrderDate;
    String overrideGlAccountId;
    String salesOpportunityId;
    String changeByUserLoginId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
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
                
                .build();
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
        if (overrideGlAccountId != null) {
            builder.setOverrideGlAccountId(overrideGlAccountId);
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
