package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.ProductStoreFlatData;

import com.bluecc.hubs.stub.ProductStoreData;
import com.bluecc.income.dao.ProductStoreDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreData.class,
        symbol = EntityNames.ProductStore)
public class ProductStore implements IEventModel<ProductStoreFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String productStoreId;
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
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreFlatData.Builder toDataBuilder() {
        ProductStoreFlatData.Builder builder = ProductStoreFlatData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (primaryStoreGroupId != null) {
            builder.setPrimaryStoreGroupId(primaryStoreGroupId);
        }
        if (storeName != null) {
            builder.setStoreName(storeName);
        }
        if (companyName != null) {
            builder.setCompanyName(companyName);
        }
        if (title != null) {
            builder.setTitle(title);
        }
        if (subtitle != null) {
            builder.setSubtitle(subtitle);
        }
        if (payToPartyId != null) {
            builder.setPayToPartyId(payToPartyId);
        }
        if (daysToCancelNonPay != null) {
            builder.setDaysToCancelNonPay(daysToCancelNonPay);
        }
        if (manualAuthIsCapture != null) {
            builder.setManualAuthIsCapture(getIndicator(manualAuthIsCapture));
        }
        if (prorateShipping != null) {
            builder.setProrateShipping(getIndicator(prorateShipping));
        }
        if (prorateTaxes != null) {
            builder.setProrateTaxes(getIndicator(prorateTaxes));
        }
        if (viewCartOnAdd != null) {
            builder.setViewCartOnAdd(getIndicator(viewCartOnAdd));
        }
        if (autoSaveCart != null) {
            builder.setAutoSaveCart(getIndicator(autoSaveCart));
        }
        if (autoApproveReviews != null) {
            builder.setAutoApproveReviews(getIndicator(autoApproveReviews));
        }
        if (isDemoStore != null) {
            builder.setIsDemoStore(getIndicator(isDemoStore));
        }
        if (isImmediatelyFulfilled != null) {
            builder.setIsImmediatelyFulfilled(getIndicator(isImmediatelyFulfilled));
        }
        if (inventoryFacilityId != null) {
            builder.setInventoryFacilityId(inventoryFacilityId);
        }
        if (oneInventoryFacility != null) {
            builder.setOneInventoryFacility(getIndicator(oneInventoryFacility));
        }
        if (checkInventory != null) {
            builder.setCheckInventory(getIndicator(checkInventory));
        }
        if (reserveInventory != null) {
            builder.setReserveInventory(getIndicator(reserveInventory));
        }
        if (reserveOrderEnumId != null) {
            builder.setReserveOrderEnumId(reserveOrderEnumId);
        }
        if (requireInventory != null) {
            builder.setRequireInventory(getIndicator(requireInventory));
        }
        if (balanceResOnOrderCreation != null) {
            builder.setBalanceResOnOrderCreation(getIndicator(balanceResOnOrderCreation));
        }
        if (requirementMethodEnumId != null) {
            builder.setRequirementMethodEnumId(requirementMethodEnumId);
        }
        if (orderNumberPrefix != null) {
            builder.setOrderNumberPrefix(orderNumberPrefix);
        }
        if (defaultLocaleString != null) {
            builder.setDefaultLocaleString(defaultLocaleString);
        }
        if (defaultCurrencyUomId != null) {
            builder.setDefaultCurrencyUomId(defaultCurrencyUomId);
        }
        if (defaultTimeZoneString != null) {
            builder.setDefaultTimeZoneString(defaultTimeZoneString);
        }
        if (defaultSalesChannelEnumId != null) {
            builder.setDefaultSalesChannelEnumId(defaultSalesChannelEnumId);
        }
        if (allowPassword != null) {
            builder.setAllowPassword(getIndicator(allowPassword));
        }
        if (defaultPassword != null) {
            builder.setDefaultPassword(defaultPassword);
        }
        if (explodeOrderItems != null) {
            builder.setExplodeOrderItems(getIndicator(explodeOrderItems));
        }
        if (checkGcBalance != null) {
            builder.setCheckGcBalance(getIndicator(checkGcBalance));
        }
        if (retryFailedAuths != null) {
            builder.setRetryFailedAuths(getIndicator(retryFailedAuths));
        }
        if (headerApprovedStatus != null) {
            builder.setHeaderApprovedStatus(headerApprovedStatus);
        }
        if (itemApprovedStatus != null) {
            builder.setItemApprovedStatus(itemApprovedStatus);
        }
        if (digitalItemApprovedStatus != null) {
            builder.setDigitalItemApprovedStatus(digitalItemApprovedStatus);
        }
        if (headerDeclinedStatus != null) {
            builder.setHeaderDeclinedStatus(headerDeclinedStatus);
        }
        if (itemDeclinedStatus != null) {
            builder.setItemDeclinedStatus(itemDeclinedStatus);
        }
        if (headerCancelStatus != null) {
            builder.setHeaderCancelStatus(headerCancelStatus);
        }
        if (itemCancelStatus != null) {
            builder.setItemCancelStatus(itemCancelStatus);
        }
        if (authDeclinedMessage != null) {
            builder.setAuthDeclinedMessage(authDeclinedMessage);
        }
        if (authFraudMessage != null) {
            builder.setAuthFraudMessage(authFraudMessage);
        }
        if (authErrorMessage != null) {
            builder.setAuthErrorMessage(authErrorMessage);
        }
        if (visualThemeId != null) {
            builder.setVisualThemeId(visualThemeId);
        }
        if (storeCreditAccountEnumId != null) {
            builder.setStoreCreditAccountEnumId(storeCreditAccountEnumId);
        }
        if (usePrimaryEmailUsername != null) {
            builder.setUsePrimaryEmailUsername(getIndicator(usePrimaryEmailUsername));
        }
        if (requireCustomerRole != null) {
            builder.setRequireCustomerRole(getIndicator(requireCustomerRole));
        }
        if (autoInvoiceDigitalItems != null) {
            builder.setAutoInvoiceDigitalItems(getIndicator(autoInvoiceDigitalItems));
        }
        if (reqShipAddrForDigItems != null) {
            builder.setReqShipAddrForDigItems(getIndicator(reqShipAddrForDigItems));
        }
        if (showCheckoutGiftOptions != null) {
            builder.setShowCheckoutGiftOptions(getIndicator(showCheckoutGiftOptions));
        }
        if (selectPaymentTypePerItem != null) {
            builder.setSelectPaymentTypePerItem(getIndicator(selectPaymentTypePerItem));
        }
        if (showPricesWithVatTax != null) {
            builder.setShowPricesWithVatTax(getIndicator(showPricesWithVatTax));
        }
        if (showTaxIsExempt != null) {
            builder.setShowTaxIsExempt(getIndicator(showTaxIsExempt));
        }
        if (vatTaxAuthGeoId != null) {
            builder.setVatTaxAuthGeoId(vatTaxAuthGeoId);
        }
        if (vatTaxAuthPartyId != null) {
            builder.setVatTaxAuthPartyId(vatTaxAuthPartyId);
        }
        if (enableAutoSuggestionList != null) {
            builder.setEnableAutoSuggestionList(getIndicator(enableAutoSuggestionList));
        }
        if (enableDigProdUpload != null) {
            builder.setEnableDigProdUpload(getIndicator(enableDigProdUpload));
        }
        if (prodSearchExcludeVariants != null) {
            builder.setProdSearchExcludeVariants(getIndicator(prodSearchExcludeVariants));
        }
        if (digProdUploadCategoryId != null) {
            builder.setDigProdUploadCategoryId(digProdUploadCategoryId);
        }
        if (autoOrderCcTryExp != null) {
            builder.setAutoOrderCcTryExp(getIndicator(autoOrderCcTryExp));
        }
        if (autoOrderCcTryOtherCards != null) {
            builder.setAutoOrderCcTryOtherCards(getIndicator(autoOrderCcTryOtherCards));
        }
        if (autoOrderCcTryLaterNsf != null) {
            builder.setAutoOrderCcTryLaterNsf(getIndicator(autoOrderCcTryLaterNsf));
        }
        if (autoOrderCcTryLaterMax != null) {
            builder.setAutoOrderCcTryLaterMax(autoOrderCcTryLaterMax);
        }
        if (storeCreditValidDays != null) {
            builder.setStoreCreditValidDays(storeCreditValidDays);
        }
        if (autoApproveInvoice != null) {
            builder.setAutoApproveInvoice(getIndicator(autoApproveInvoice));
        }
        if (autoApproveOrder != null) {
            builder.setAutoApproveOrder(getIndicator(autoApproveOrder));
        }
        if (shipIfCaptureFails != null) {
            builder.setShipIfCaptureFails(getIndicator(shipIfCaptureFails));
        }
        if (setOwnerUponIssuance != null) {
            builder.setSetOwnerUponIssuance(getIndicator(setOwnerUponIssuance));
        }
        if (reqReturnInventoryReceive != null) {
            builder.setReqReturnInventoryReceive(getIndicator(reqReturnInventoryReceive));
        }
        if (addToCartRemoveIncompat != null) {
            builder.setAddToCartRemoveIncompat(getIndicator(addToCartRemoveIncompat));
        }
        if (addToCartReplaceUpsell != null) {
            builder.setAddToCartReplaceUpsell(getIndicator(addToCartReplaceUpsell));
        }
        if (splitPayPrefPerShpGrp != null) {
            builder.setSplitPayPrefPerShpGrp(getIndicator(splitPayPrefPerShpGrp));
        }
        if (managedByLot != null) {
            builder.setManagedByLot(getIndicator(managedByLot));
        }
        if (showOutOfStockProducts != null) {
            builder.setShowOutOfStockProducts(getIndicator(showOutOfStockProducts));
        }
        if (orderDecimalQuantity != null) {
            builder.setOrderDecimalQuantity(getIndicator(orderDecimalQuantity));
        }
        if (allowComment != null) {
            builder.setAllowComment(getIndicator(allowComment));
        }
        if (allocateInventory != null) {
            builder.setAllocateInventory(getIndicator(allocateInventory));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductStore fromData(ProductStoreFlatData data) {
        return ProductStore.builder()
                .productStoreId(data.getProductStoreId())
                .primaryStoreGroupId(data.getPrimaryStoreGroupId())
                .storeName(data.getStoreName())
                .companyName(data.getCompanyName())
                .title(data.getTitle())
                .subtitle(data.getSubtitle())
                .payToPartyId(data.getPayToPartyId())
                .daysToCancelNonPay(data.getDaysToCancelNonPay())
                .manualAuthIsCapture(getIndicatorChar(data.getManualAuthIsCapture()))
                .prorateShipping(getIndicatorChar(data.getProrateShipping()))
                .prorateTaxes(getIndicatorChar(data.getProrateTaxes()))
                .viewCartOnAdd(getIndicatorChar(data.getViewCartOnAdd()))
                .autoSaveCart(getIndicatorChar(data.getAutoSaveCart()))
                .autoApproveReviews(getIndicatorChar(data.getAutoApproveReviews()))
                .isDemoStore(getIndicatorChar(data.getIsDemoStore()))
                .isImmediatelyFulfilled(getIndicatorChar(data.getIsImmediatelyFulfilled()))
                .inventoryFacilityId(data.getInventoryFacilityId())
                .oneInventoryFacility(getIndicatorChar(data.getOneInventoryFacility()))
                .checkInventory(getIndicatorChar(data.getCheckInventory()))
                .reserveInventory(getIndicatorChar(data.getReserveInventory()))
                .reserveOrderEnumId(data.getReserveOrderEnumId())
                .requireInventory(getIndicatorChar(data.getRequireInventory()))
                .balanceResOnOrderCreation(getIndicatorChar(data.getBalanceResOnOrderCreation()))
                .requirementMethodEnumId(data.getRequirementMethodEnumId())
                .orderNumberPrefix(data.getOrderNumberPrefix())
                .defaultLocaleString(data.getDefaultLocaleString())
                .defaultCurrencyUomId(data.getDefaultCurrencyUomId())
                .defaultTimeZoneString(data.getDefaultTimeZoneString())
                .defaultSalesChannelEnumId(data.getDefaultSalesChannelEnumId())
                .allowPassword(getIndicatorChar(data.getAllowPassword()))
                .defaultPassword(data.getDefaultPassword())
                .explodeOrderItems(getIndicatorChar(data.getExplodeOrderItems()))
                .checkGcBalance(getIndicatorChar(data.getCheckGcBalance()))
                .retryFailedAuths(getIndicatorChar(data.getRetryFailedAuths()))
                .headerApprovedStatus(data.getHeaderApprovedStatus())
                .itemApprovedStatus(data.getItemApprovedStatus())
                .digitalItemApprovedStatus(data.getDigitalItemApprovedStatus())
                .headerDeclinedStatus(data.getHeaderDeclinedStatus())
                .itemDeclinedStatus(data.getItemDeclinedStatus())
                .headerCancelStatus(data.getHeaderCancelStatus())
                .itemCancelStatus(data.getItemCancelStatus())
                .authDeclinedMessage(data.getAuthDeclinedMessage())
                .authFraudMessage(data.getAuthFraudMessage())
                .authErrorMessage(data.getAuthErrorMessage())
                .visualThemeId(data.getVisualThemeId())
                .storeCreditAccountEnumId(data.getStoreCreditAccountEnumId())
                .usePrimaryEmailUsername(getIndicatorChar(data.getUsePrimaryEmailUsername()))
                .requireCustomerRole(getIndicatorChar(data.getRequireCustomerRole()))
                .autoInvoiceDigitalItems(getIndicatorChar(data.getAutoInvoiceDigitalItems()))
                .reqShipAddrForDigItems(getIndicatorChar(data.getReqShipAddrForDigItems()))
                .showCheckoutGiftOptions(getIndicatorChar(data.getShowCheckoutGiftOptions()))
                .selectPaymentTypePerItem(getIndicatorChar(data.getSelectPaymentTypePerItem()))
                .showPricesWithVatTax(getIndicatorChar(data.getShowPricesWithVatTax()))
                .showTaxIsExempt(getIndicatorChar(data.getShowTaxIsExempt()))
                .vatTaxAuthGeoId(data.getVatTaxAuthGeoId())
                .vatTaxAuthPartyId(data.getVatTaxAuthPartyId())
                .enableAutoSuggestionList(getIndicatorChar(data.getEnableAutoSuggestionList()))
                .enableDigProdUpload(getIndicatorChar(data.getEnableDigProdUpload()))
                .prodSearchExcludeVariants(getIndicatorChar(data.getProdSearchExcludeVariants()))
                .digProdUploadCategoryId(data.getDigProdUploadCategoryId())
                .autoOrderCcTryExp(getIndicatorChar(data.getAutoOrderCcTryExp()))
                .autoOrderCcTryOtherCards(getIndicatorChar(data.getAutoOrderCcTryOtherCards()))
                .autoOrderCcTryLaterNsf(getIndicatorChar(data.getAutoOrderCcTryLaterNsf()))
                .autoOrderCcTryLaterMax(data.getAutoOrderCcTryLaterMax())
                .storeCreditValidDays(data.getStoreCreditValidDays())
                .autoApproveInvoice(getIndicatorChar(data.getAutoApproveInvoice()))
                .autoApproveOrder(getIndicatorChar(data.getAutoApproveOrder()))
                .shipIfCaptureFails(getIndicatorChar(data.getShipIfCaptureFails()))
                .setOwnerUponIssuance(getIndicatorChar(data.getSetOwnerUponIssuance()))
                .reqReturnInventoryReceive(getIndicatorChar(data.getReqReturnInventoryReceive()))
                .addToCartRemoveIncompat(getIndicatorChar(data.getAddToCartRemoveIncompat()))
                .addToCartReplaceUpsell(getIndicatorChar(data.getAddToCartReplaceUpsell()))
                .splitPayPrefPerShpGrp(getIndicatorChar(data.getSplitPayPrefPerShpGrp()))
                .managedByLot(getIndicatorChar(data.getManagedByLot()))
                .showOutOfStockProducts(getIndicatorChar(data.getShowOutOfStockProducts()))
                .orderDecimalQuantity(getIndicatorChar(data.getOrderDecimalQuantity()))
                .allowComment(getIndicatorChar(data.getAllowComment()))
                .allocateInventory(getIndicatorChar(data.getAllocateInventory()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

        // relations
     
    @Exclude
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    List<TaxAuthority> relVatTaxAuthority= new ArrayList<>(); 
    @Exclude
    List<CustRequest> relCustRequest= new ArrayList<>(); 
    @Exclude
    List<EbayConfig> relEbayConfig= new ArrayList<>(); 
    @Exclude
    List<OrderHeader> relOrderHeader= new ArrayList<>(); 
    @Exclude
    List<ProductReview> relProductReview= new ArrayList<>(); 
    @Exclude
    List<ProductStoreCatalog> relProductStoreCatalog= new ArrayList<>(); 
    @Exclude
    List<ProductStoreEmailSetting> relProductStoreEmailSetting= new ArrayList<>(); 
    @Exclude
    List<ProductStoreFacility> relProductStoreFacility= new ArrayList<>(); 
    @Exclude
    List<ProductStoreFinActSetting> relProductStoreFinActSetting= new ArrayList<>(); 
    @Exclude
    List<ProductStoreKeywordOvrd> relProductStoreKeywordOvrd= new ArrayList<>(); 
    @Exclude
    List<ProductStorePaymentSetting> relProductStorePaymentSetting= new ArrayList<>(); 
    @Exclude
    List<ProductStorePromoAppl> relProductStorePromoAppl= new ArrayList<>(); 
    @Exclude
    List<ProductStoreRole> relProductStoreRole= new ArrayList<>(); 
    @Exclude
    List<ProductStoreSurveyAppl> relProductStoreSurveyAppl= new ArrayList<>(); 
    @Exclude
    List<Quote> relQuote= new ArrayList<>(); 
    @Exclude
    List<TaxAuthorityRateProduct> relTaxAuthorityRateProduct= new ArrayList<>(); 
    @Exclude
    List<WebSite> relWebSite= new ArrayList<>();

    public ProductStoreDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductStoreDelegator delegator){
        return delegator.getAgent(ctx, this.getProductStoreId());
    }

    public ProductStoreData.Builder toHeadBuilder() {
        ProductStoreData.Builder builder = ProductStoreData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (primaryStoreGroupId != null) {
            builder.setPrimaryStoreGroupId(primaryStoreGroupId);
        }
        if (storeName != null) {
            builder.setStoreName(storeName);
        }
        if (companyName != null) {
            builder.setCompanyName(companyName);
        }
        if (title != null) {
            builder.setTitle(title);
        }
        if (subtitle != null) {
            builder.setSubtitle(subtitle);
        }
        if (daysToCancelNonPay != null) {
            builder.setDaysToCancelNonPay(daysToCancelNonPay);
        }
        if (manualAuthIsCapture != null) {
            builder.setManualAuthIsCapture(getIndicator(manualAuthIsCapture));
        }
        if (prorateShipping != null) {
            builder.setProrateShipping(getIndicator(prorateShipping));
        }
        if (prorateTaxes != null) {
            builder.setProrateTaxes(getIndicator(prorateTaxes));
        }
        if (viewCartOnAdd != null) {
            builder.setViewCartOnAdd(getIndicator(viewCartOnAdd));
        }
        if (autoSaveCart != null) {
            builder.setAutoSaveCart(getIndicator(autoSaveCart));
        }
        if (autoApproveReviews != null) {
            builder.setAutoApproveReviews(getIndicator(autoApproveReviews));
        }
        if (isDemoStore != null) {
            builder.setIsDemoStore(getIndicator(isDemoStore));
        }
        if (isImmediatelyFulfilled != null) {
            builder.setIsImmediatelyFulfilled(getIndicator(isImmediatelyFulfilled));
        }
        if (oneInventoryFacility != null) {
            builder.setOneInventoryFacility(getIndicator(oneInventoryFacility));
        }
        if (checkInventory != null) {
            builder.setCheckInventory(getIndicator(checkInventory));
        }
        if (reserveInventory != null) {
            builder.setReserveInventory(getIndicator(reserveInventory));
        }
        if (reserveOrderEnumId != null) {
            builder.setReserveOrderEnumId(reserveOrderEnumId);
        }
        if (requireInventory != null) {
            builder.setRequireInventory(getIndicator(requireInventory));
        }
        if (balanceResOnOrderCreation != null) {
            builder.setBalanceResOnOrderCreation(getIndicator(balanceResOnOrderCreation));
        }
        if (requirementMethodEnumId != null) {
            builder.setRequirementMethodEnumId(requirementMethodEnumId);
        }
        if (orderNumberPrefix != null) {
            builder.setOrderNumberPrefix(orderNumberPrefix);
        }
        if (defaultLocaleString != null) {
            builder.setDefaultLocaleString(defaultLocaleString);
        }
        if (defaultCurrencyUomId != null) {
            builder.setDefaultCurrencyUomId(defaultCurrencyUomId);
        }
        if (defaultTimeZoneString != null) {
            builder.setDefaultTimeZoneString(defaultTimeZoneString);
        }
        if (defaultSalesChannelEnumId != null) {
            builder.setDefaultSalesChannelEnumId(defaultSalesChannelEnumId);
        }
        if (allowPassword != null) {
            builder.setAllowPassword(getIndicator(allowPassword));
        }
        if (defaultPassword != null) {
            builder.setDefaultPassword(defaultPassword);
        }
        if (explodeOrderItems != null) {
            builder.setExplodeOrderItems(getIndicator(explodeOrderItems));
        }
        if (checkGcBalance != null) {
            builder.setCheckGcBalance(getIndicator(checkGcBalance));
        }
        if (retryFailedAuths != null) {
            builder.setRetryFailedAuths(getIndicator(retryFailedAuths));
        }
        if (headerApprovedStatus != null) {
            builder.setHeaderApprovedStatus(headerApprovedStatus);
        }
        if (itemApprovedStatus != null) {
            builder.setItemApprovedStatus(itemApprovedStatus);
        }
        if (digitalItemApprovedStatus != null) {
            builder.setDigitalItemApprovedStatus(digitalItemApprovedStatus);
        }
        if (headerDeclinedStatus != null) {
            builder.setHeaderDeclinedStatus(headerDeclinedStatus);
        }
        if (itemDeclinedStatus != null) {
            builder.setItemDeclinedStatus(itemDeclinedStatus);
        }
        if (headerCancelStatus != null) {
            builder.setHeaderCancelStatus(headerCancelStatus);
        }
        if (itemCancelStatus != null) {
            builder.setItemCancelStatus(itemCancelStatus);
        }
        if (authDeclinedMessage != null) {
            builder.setAuthDeclinedMessage(authDeclinedMessage);
        }
        if (authFraudMessage != null) {
            builder.setAuthFraudMessage(authFraudMessage);
        }
        if (authErrorMessage != null) {
            builder.setAuthErrorMessage(authErrorMessage);
        }
        if (visualThemeId != null) {
            builder.setVisualThemeId(visualThemeId);
        }
        if (storeCreditAccountEnumId != null) {
            builder.setStoreCreditAccountEnumId(storeCreditAccountEnumId);
        }
        if (usePrimaryEmailUsername != null) {
            builder.setUsePrimaryEmailUsername(getIndicator(usePrimaryEmailUsername));
        }
        if (requireCustomerRole != null) {
            builder.setRequireCustomerRole(getIndicator(requireCustomerRole));
        }
        if (autoInvoiceDigitalItems != null) {
            builder.setAutoInvoiceDigitalItems(getIndicator(autoInvoiceDigitalItems));
        }
        if (reqShipAddrForDigItems != null) {
            builder.setReqShipAddrForDigItems(getIndicator(reqShipAddrForDigItems));
        }
        if (showCheckoutGiftOptions != null) {
            builder.setShowCheckoutGiftOptions(getIndicator(showCheckoutGiftOptions));
        }
        if (selectPaymentTypePerItem != null) {
            builder.setSelectPaymentTypePerItem(getIndicator(selectPaymentTypePerItem));
        }
        if (showPricesWithVatTax != null) {
            builder.setShowPricesWithVatTax(getIndicator(showPricesWithVatTax));
        }
        if (showTaxIsExempt != null) {
            builder.setShowTaxIsExempt(getIndicator(showTaxIsExempt));
        }
        if (vatTaxAuthPartyId != null) {
            builder.setVatTaxAuthPartyId(vatTaxAuthPartyId);
        }
        if (enableAutoSuggestionList != null) {
            builder.setEnableAutoSuggestionList(getIndicator(enableAutoSuggestionList));
        }
        if (enableDigProdUpload != null) {
            builder.setEnableDigProdUpload(getIndicator(enableDigProdUpload));
        }
        if (prodSearchExcludeVariants != null) {
            builder.setProdSearchExcludeVariants(getIndicator(prodSearchExcludeVariants));
        }
        if (digProdUploadCategoryId != null) {
            builder.setDigProdUploadCategoryId(digProdUploadCategoryId);
        }
        if (autoOrderCcTryExp != null) {
            builder.setAutoOrderCcTryExp(getIndicator(autoOrderCcTryExp));
        }
        if (autoOrderCcTryOtherCards != null) {
            builder.setAutoOrderCcTryOtherCards(getIndicator(autoOrderCcTryOtherCards));
        }
        if (autoOrderCcTryLaterNsf != null) {
            builder.setAutoOrderCcTryLaterNsf(getIndicator(autoOrderCcTryLaterNsf));
        }
        if (autoOrderCcTryLaterMax != null) {
            builder.setAutoOrderCcTryLaterMax(autoOrderCcTryLaterMax);
        }
        if (storeCreditValidDays != null) {
            builder.setStoreCreditValidDays(storeCreditValidDays);
        }
        if (autoApproveInvoice != null) {
            builder.setAutoApproveInvoice(getIndicator(autoApproveInvoice));
        }
        if (autoApproveOrder != null) {
            builder.setAutoApproveOrder(getIndicator(autoApproveOrder));
        }
        if (shipIfCaptureFails != null) {
            builder.setShipIfCaptureFails(getIndicator(shipIfCaptureFails));
        }
        if (setOwnerUponIssuance != null) {
            builder.setSetOwnerUponIssuance(getIndicator(setOwnerUponIssuance));
        }
        if (reqReturnInventoryReceive != null) {
            builder.setReqReturnInventoryReceive(getIndicator(reqReturnInventoryReceive));
        }
        if (addToCartRemoveIncompat != null) {
            builder.setAddToCartRemoveIncompat(getIndicator(addToCartRemoveIncompat));
        }
        if (addToCartReplaceUpsell != null) {
            builder.setAddToCartReplaceUpsell(getIndicator(addToCartReplaceUpsell));
        }
        if (splitPayPrefPerShpGrp != null) {
            builder.setSplitPayPrefPerShpGrp(getIndicator(splitPayPrefPerShpGrp));
        }
        if (managedByLot != null) {
            builder.setManagedByLot(getIndicator(managedByLot));
        }
        if (showOutOfStockProducts != null) {
            builder.setShowOutOfStockProducts(getIndicator(showOutOfStockProducts));
        }
        if (orderDecimalQuantity != null) {
            builder.setOrderDecimalQuantity(getIndicator(orderDecimalQuantity));
        }
        if (allowComment != null) {
            builder.setAllowComment(getIndicator(allowComment));
        }
        if (allocateInventory != null) {
            builder.setAllocateInventory(getIndicator(allocateInventory));
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
-- keys: productStoreId

-- fields --
    
    String productStoreId
    String primaryStoreGroupId
    String storeName
    String companyName
    String title
    String subtitle
    String payToPartyId
    Long daysToCancelNonPay
    Character manualAuthIsCapture
    Character prorateShipping
    Character prorateTaxes
    Character viewCartOnAdd
    Character autoSaveCart
    Character autoApproveReviews
    Character isDemoStore
    Character isImmediatelyFulfilled
    String inventoryFacilityId
    Character oneInventoryFacility
    Character checkInventory
    Character reserveInventory
    String reserveOrderEnumId
    Character requireInventory
    Character balanceResOnOrderCreation
    String requirementMethodEnumId
    String orderNumberPrefix
    String defaultLocaleString
    String defaultCurrencyUomId
    String defaultTimeZoneString
    String defaultSalesChannelEnumId
    Character allowPassword
    String defaultPassword
    Character explodeOrderItems
    Character checkGcBalance
    Character retryFailedAuths
    String headerApprovedStatus
    String itemApprovedStatus
    String digitalItemApprovedStatus
    String headerDeclinedStatus
    String itemDeclinedStatus
    String headerCancelStatus
    String itemCancelStatus
    String authDeclinedMessage
    String authFraudMessage
    String authErrorMessage
    String visualThemeId
    String storeCreditAccountEnumId
    Character usePrimaryEmailUsername
    Character requireCustomerRole
    Character autoInvoiceDigitalItems
    Character reqShipAddrForDigItems
    Character showCheckoutGiftOptions
    Character selectPaymentTypePerItem
    Character showPricesWithVatTax
    Character showTaxIsExempt
    String vatTaxAuthGeoId
    String vatTaxAuthPartyId
    Character enableAutoSuggestionList
    Character enableDigProdUpload
    Character prodSearchExcludeVariants
    String digProdUploadCategoryId
    Character autoOrderCcTryExp
    Character autoOrderCcTryOtherCards
    Character autoOrderCcTryLaterNsf
    Long autoOrderCcTryLaterMax
    Long storeCreditValidDays
    Character autoApproveInvoice
    Character autoApproveOrder
    Character shipIfCaptureFails
    Character setOwnerUponIssuance
    Character reqReturnInventoryReceive
    Character addToCartRemoveIncompat
    Character addToCartReplaceUpsell
    Character splitPayPrefPerShpGrp
    Character managedByLot
    Character showOutOfStockProducts
    Character orderDecimalQuantity
    Character allowComment
    Character allocateInventory

-- relations --
    
    - PrimaryProductStoreGroup (one, autoRelation: false, keymaps: primaryStoreGroupId -> productStoreGroupId)
    - Facility (one, autoRelation: false, keymaps: inventoryFacilityId -> facilityId)
    - ReserveOrderEnumeration (one, autoRelation: false, keymaps: reserveOrderEnumId -> enumId)
    - RequirementMethodEnumeration (one, autoRelation: false, keymaps: requirementMethodEnumId -> enumId)
    - Party (one, autoRelation: false, keymaps: payToPartyId -> partyId)
    - Uom (one, autoRelation: false, keymaps: defaultCurrencyUomId -> uomId)
    - DefaultSalesChannelEnumeration (one, autoRelation: false, keymaps: defaultSalesChannelEnumId -> enumId)
    - HeaderApprovedStatusItem (one, autoRelation: false, keymaps: headerApprovedStatus -> statusId)
    - ItemApprovedStatusItem (one, autoRelation: false, keymaps: itemApprovedStatus -> statusId)
    - DigitalItemApprovedStatusItem (one, autoRelation: false, keymaps: digitalItemApprovedStatus -> statusId)
    - HeaderDeclinedStatusItem (one, autoRelation: false, keymaps: headerDeclinedStatus -> statusId)
    - ItemDeclinedStatusItem (one, autoRelation: false, keymaps: itemDeclinedStatus -> statusId)
    - HeaderCancelStatusItem (one, autoRelation: false, keymaps: headerCancelStatus -> statusId)
    - ItemCancelStatusItem (one, autoRelation: false, keymaps: itemCancelStatus -> statusId)
    - VatTaxAuthority (one, autoRelation: false, keymaps: vatTaxAuthGeoId -> taxAuthGeoId, vatTaxAuthPartyId -> taxAuthPartyId)
    - StoreCreditAccountEnumeration (one, autoRelation: false, keymaps: storeCreditAccountEnumId -> enumId)
    + CustRequest (many, autoRelation: true, keymaps: productStoreId)
    - EbayConfig (one-nofk, autoRelation: true, keymaps: productStoreId)
    + EbayShippingMethod (many, autoRelation: true, keymaps: productStoreId)
    + GitHubUser (many, autoRelation: true, keymaps: productStoreId)
    + InventoryItemTempRes (many, autoRelation: true, keymaps: productStoreId)
    + LinkedInUser (many, autoRelation: true, keymaps: productStoreId)
    + OAuth2GitHub (many, autoRelation: true, keymaps: productStoreId)
    + OAuth2LinkedIn (many, autoRelation: true, keymaps: productStoreId)
    + OrderHeader (many, autoRelation: true, keymaps: productStoreId)
    + PartyProfileDefault (many, autoRelation: true, keymaps: productStoreId)
    + ProductReview (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreCatalog (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreEmailSetting (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreFacility (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreFinActSetting (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreGroupMember (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreKeywordOvrd (many, autoRelation: true, keymaps: productStoreId)
    + ProductStorePaymentSetting (many, autoRelation: true, keymaps: productStoreId)
    + ProductStorePromoAppl (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreRole (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreSurveyAppl (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreTelecomSetting (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreVendorPayment (many, autoRelation: true, keymaps: productStoreId)
    + ProductStoreVendorShipment (many, autoRelation: true, keymaps: productStoreId)
    + Quote (many, autoRelation: true, keymaps: productStoreId)
    + SegmentGroup (many, autoRelation: true, keymaps: productStoreId)
    + ShoppingList (many, autoRelation: true, keymaps: productStoreId)
    + TaxAuthorityRateProduct (many, autoRelation: true, keymaps: productStoreId)
    + ThirdPartyLogin (many, autoRelation: true, keymaps: productStoreId)
    + WebSite (many, autoRelation: true, keymaps: productStoreId)
*/

