package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    String orderId;
    String orderItemSeqId;
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
    String id;
    
}
