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
public class ProductStore implements Serializable {
    private static final long serialVersionUID = 1L;

    String productStoreId;
    String primaryStoreGroupId;
    String storeName;
    String companyName;
    String title;
    String subtitle;
    String payToPartyId;
    Long daysToCancelNonPay;
    Character manualAuthIsCapture;
    Character prorateShipping;
    Character prorateTaxes;
    Character viewCartOnAdd;
    Character autoSaveCart;
    Character autoApproveReviews;
    Character isDemoStore;
    Character isImmediatelyFulfilled;
    String inventoryFacilityId;
    Character oneInventoryFacility;
    Character checkInventory;
    Character reserveInventory;
    String reserveOrderEnumId;
    Character requireInventory;
    Character balanceResOnOrderCreation;
    String requirementMethodEnumId;
    String orderNumberPrefix;
    String defaultLocaleString;
    String defaultCurrencyUomId;
    String defaultTimeZoneString;
    String defaultSalesChannelEnumId;
    Character allowPassword;
    String defaultPassword;
    Character explodeOrderItems;
    Character checkGcBalance;
    Character retryFailedAuths;
    String headerApprovedStatus;
    String itemApprovedStatus;
    String digitalItemApprovedStatus;
    String headerDeclinedStatus;
    String itemDeclinedStatus;
    String headerCancelStatus;
    String itemCancelStatus;
    String authDeclinedMessage;
    String authFraudMessage;
    String authErrorMessage;
    String visualThemeId;
    String storeCreditAccountEnumId;
    Character usePrimaryEmailUsername;
    Character requireCustomerRole;
    Character autoInvoiceDigitalItems;
    Character reqShipAddrForDigItems;
    Character showCheckoutGiftOptions;
    Character selectPaymentTypePerItem;
    Character showPricesWithVatTax;
    Character showTaxIsExempt;
    String vatTaxAuthGeoId;
    String vatTaxAuthPartyId;
    Character enableAutoSuggestionList;
    Character enableDigProdUpload;
    Character prodSearchExcludeVariants;
    String digProdUploadCategoryId;
    Character autoOrderCcTryExp;
    Character autoOrderCcTryOtherCards;
    Character autoOrderCcTryLaterNsf;
    Long autoOrderCcTryLaterMax;
    Long storeCreditValidDays;
    Character autoApproveInvoice;
    Character autoApproveOrder;
    Character shipIfCaptureFails;
    Character setOwnerUponIssuance;
    Character reqReturnInventoryReceive;
    Character addToCartRemoveIncompat;
    Character addToCartReplaceUpsell;
    Character splitPayPrefPerShpGrp;
    Character managedByLot;
    Character showOutOfStockProducts;
    Character orderDecimalQuantity;
    Character allowComment;
    Character allocateInventory;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    
}
