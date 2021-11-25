package com.bluecc.hubs.fund.descriptor;

import com.bluecc.hubs.fund.Util;
import lombok.Getter;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum EntityNames implements INameSymbol{

    AcctgTrans("AcctgTrans", "Accounting Transaction","acctgTransId"),
    AcctgTransEntry("AcctgTransEntry", "Transaction Entry","acctgTransId", "acctgTransEntrySeqId"),
    Agreement("Agreement", "Agreement","agreementId"),
    AgreementItem("AgreementItem", "Agreement Item","agreementId", "agreementItemSeqId"),
    AgreementProductAppl("AgreementProductAppl", "Agreement Product Application","agreementId", "agreementItemSeqId", "productId"),
    AgreementTerm("AgreementTerm", "Agreement Term","agreementTermId"),
    BillingAccount("BillingAccount", "Billing Account","billingAccountId"),
    BillingAccountRole("BillingAccountRole", "Billing Account Role","billingAccountId", "partyId", "roleTypeId", "fromDate"),
    CarrierShipmentBoxType("CarrierShipmentBoxType", "Carrier Shipment Method","shipmentBoxTypeId", "partyId"),
    CarrierShipmentMethod("CarrierShipmentMethod", "Carrier Shipment Method","shipmentMethodTypeId", "partyId", "roleTypeId"),
    ContactMech("ContactMech", "Contact Mechanism","contactMechId"),
    Content("Content", "Content","contentId"),
    ContentAssoc("ContentAssoc", "Content Association","contentId", "contentIdTo", "contentAssocTypeId", "fromDate"),
    CreditCard("CreditCard", "Credit Card Information","paymentMethodId"),
    CustRequest("CustRequest", "CustRequest","custRequestId"),
    CustRequestItem("CustRequestItem", "Customer Request Item","custRequestId", "custRequestItemSeqId"),
    CustRequestType("CustRequestType", "Customer Request Type","custRequestTypeId"),
    DataResource("DataResource", "Data Object","dataResourceId"),
    ElectronicText("ElectronicText", "Electronic Text","dataResourceId"),
    FacilityContactMech("FacilityContactMech", "Facility Contact Mechanism","facilityId", "contactMechId", "fromDate"),
    FacilityContactMechPurpose("FacilityContactMechPurpose", "Facility Contact Mechanism Purpose","facilityId", "contactMechId", "contactMechPurposeTypeId", "fromDate"),
    FacilityLocation("FacilityLocation", "Facility Location","facilityId", "locationSeqId"),
    FacilityLocationGeoPoint("FacilityLocationGeoPoint", "Facility Location Geo Location with history","facilityId", "locationSeqId", "geoPointId", "fromDate"),
    FixedAsset("FixedAsset", "Fixed Asset","fixedAssetId"),
    FixedAssetGeoPoint("FixedAssetGeoPoint", "Fixed Asset Geo Location with history","fixedAssetId", "geoPointId", "fromDate"),
    FixedAssetProduct("FixedAssetProduct", "Fixed Asset Product Representation","fixedAssetId", "productId", "fixedAssetProductTypeId", "fromDate"),
    GeoPoint("GeoPoint", "Geographic Location","geoPointId"),
    InventoryItem("InventoryItem", "Inventory Item","inventoryItemId"),
    InventoryItemDetail("InventoryItemDetail", "Inventory Item Detail","inventoryItemId", "inventoryItemDetailSeqId"),
    Invoice("Invoice", "Invoice","invoiceId"),
    InvoiceItem("InvoiceItem", "Invoice Item","invoiceId", "invoiceItemSeqId"),
    ItemIssuance("ItemIssuance", "Item Issuance","itemIssuanceId"),
    OrderAdjustment("OrderAdjustment", "Order Adjustment","orderAdjustmentId"),
    OrderAdjustmentBilling("OrderAdjustmentBilling", "Order Adjustment Billing","orderAdjustmentId", "invoiceId", "invoiceItemSeqId"),
    OrderContactMech("OrderContactMech", "Order Contact Mechanism","orderId", "contactMechPurposeTypeId", "contactMechId"),
    OrderHeader("OrderHeader", "Order Header","orderId"),
    OrderItem("OrderItem", "Order Item","orderId", "orderItemSeqId"),
    OrderItemBilling("OrderItemBilling", "Order Item Billing","orderId", "orderItemSeqId", "invoiceId", "invoiceItemSeqId"),
    OrderItemPriceInfo("OrderItemPriceInfo", "Order Item Price Info","orderItemPriceInfoId"),
    OrderItemShipGroup("OrderItemShipGroup", "Order Item Ship Group","orderId", "shipGroupSeqId"),
    OrderItemShipGroupAssoc("OrderItemShipGroupAssoc", "Order Item Package Association","orderId", "orderItemSeqId", "shipGroupSeqId"),
    OrderItemShipGrpInvRes("OrderItemShipGrpInvRes", "Order Item Inventory Reservation","orderId", "shipGroupSeqId", "orderItemSeqId", "inventoryItemId"),
    OrderPaymentPreference("OrderPaymentPreference", "The Order Payment Preference","orderPaymentPreferenceId"),
    OrderRole("OrderRole", "Order Role","orderId", "partyId", "roleTypeId"),
    OrderStatus("OrderStatus", "Order Status","orderStatusId"),
    Party("Party", "Party","partyId"),
    PartyContactMech("PartyContactMech", "Party Contact Mechanism","partyId", "contactMechId", "fromDate"),
    PartyContactMechPurpose("PartyContactMechPurpose", "Party Contact Mechanism Purpose","partyId", "contactMechId", "contactMechPurposeTypeId", "fromDate"),
    PartyGeoPoint("PartyGeoPoint", "Party Geo Location with history","partyId", "geoPointId", "fromDate"),
    PartyGroup("PartyGroup", "Party Group","partyId"),
    PartyRelationship("PartyRelationship", "Party Relationship","partyIdFrom", "partyIdTo", "roleTypeIdFrom", "roleTypeIdTo", "fromDate"),
    PartyRole("PartyRole", "Party Role","partyId", "roleTypeId"),
    PartyStatus("PartyStatus", "Tracks a history of the status of a Party","statusId", "partyId", "statusDate"),
    PartyTaxAuthInfo("PartyTaxAuthInfo", "Party Tax Information","partyId", "taxAuthGeoId", "taxAuthPartyId", "fromDate"),
    Payment("Payment", "Payment","paymentId"),
    PaymentApplication("PaymentApplication", "Payment Application","paymentApplicationId"),
    PaymentGatewayResponse("PaymentGatewayResponse", "Payment Gateway Response","paymentGatewayResponseId"),
    PaymentMethod("PaymentMethod", "Payment Method","paymentMethodId"),
    Person("Person", "Person","partyId"),
    PostalAddress("PostalAddress", "Postal Address","contactMechId"),
    ProdCatalog("ProdCatalog", "Catalog","prodCatalogId"),
    ProdCatalogCategory("ProdCatalogCategory", "Catalog Category Association","prodCatalogId", "productCategoryId", "prodCatalogCategoryTypeId", "fromDate"),
    Product("Product", "Product","productId"),
    ProductAssoc("ProductAssoc", "Product Association","productId", "productIdTo", "productAssocTypeId", "fromDate"),
    ProductCategory("ProductCategory", "Product Category","productCategoryId"),
    ProductCategoryContent("ProductCategoryContent", "Product Category Data Object","productCategoryId", "contentId", "prodCatContentTypeId", "fromDate"),
    ProductCategoryLink("ProductCategoryLink", "Product Category Link","productCategoryId", "linkSeqId", "fromDate"),
    ProductCategoryMember("ProductCategoryMember", "Product Category Member","productCategoryId", "productId", "fromDate"),
    ProductCategoryRole("ProductCategoryRole", "Product Category Role","productCategoryId", "partyId", "roleTypeId", "fromDate"),
    ProductCategoryRollup("ProductCategoryRollup", "Product Category Rollup","productCategoryId", "parentProductCategoryId", "fromDate"),
    ProductConfig("ProductConfig", "Product Configuration Templates","productId", "configItemId", "sequenceNum", "fromDate"),
    ProductConfigItem("ProductConfigItem", "Product Configuration Question","configItemId"),
    ProductConfigOption("ProductConfigOption", "Product Configuration Options","configItemId", "configOptionId"),
    ProductConfigProduct("ProductConfigProduct", "Product Configuration Option to Products","configItemId", "configOptionId", "productId"),
    ProductContent("ProductContent", "Product Data Object","productId", "contentId", "productContentTypeId", "fromDate"),
    ProductFacility("ProductFacility", "Product Facility","productId", "facilityId"),
    ProductFacilityAssoc("ProductFacilityAssoc", "Define associations between Product facilities","productId", "facilityId", "facilityIdTo", "facilityAssocTypeId", "fromDate"),
    ProductFacilityLocation("ProductFacilityLocation", "Product Facility","productId", "facilityId", "locationSeqId"),
    ProductFeature("ProductFeature", "Product Feature","productFeatureId"),
    ProductFeatureAppl("ProductFeatureAppl", "Product Feature Applicability","productId", "productFeatureId", "fromDate"),
    ProductFeatureCategory("ProductFeatureCategory", "Product Feature Category","productFeatureCategoryId"),
    ProductFeatureCategoryAppl("ProductFeatureCategoryAppl", "Product Feature Category Application","productCategoryId", "productFeatureCategoryId", "fromDate"),
    ProductFeatureIactn("ProductFeatureIactn", "Product Feature Interaction","productFeatureId", "productFeatureIdTo"),
    ProductFeaturePrice("ProductFeaturePrice", "Product Feature Price","productFeatureId", "productPriceTypeId", "currencyUomId", "fromDate"),
    ProductKeyword("ProductKeyword", "Product Keyword","productId", "keyword", "keywordTypeId"),
    ProductPrice("ProductPrice", "Product Price","productId", "productPriceTypeId", "productPricePurposeId", "currencyUomId", "productStoreGroupId", "fromDate"),
    ProductPriceAction("ProductPriceAction", "Product Price Action","productPriceRuleId", "productPriceActionSeqId"),
    ProductPriceCond("ProductPriceCond", "Product Price Condition","productPriceRuleId", "productPriceCondSeqId"),
    ProductPriceRule("ProductPriceRule", "Product Pice Rule","productPriceRuleId"),
    ProductPromo("ProductPromo", "Product Promotion","productPromoId"),
    ProductPromoAction("ProductPromoAction", "Product Promotion Action","productPromoId", "productPromoRuleId", "productPromoActionSeqId"),
    ProductPromoCategory("ProductPromoCategory", "Product Promotion Category","productPromoId", "productPromoRuleId", "productPromoActionSeqId", "productPromoCondSeqId", "productCategoryId", "andGroupId"),
    ProductPromoCode("ProductPromoCode", "Product Promotion","productPromoCodeId"),
    ProductPromoCond("ProductPromoCond", "Product Promotion Condition","productPromoId", "productPromoRuleId", "productPromoCondSeqId"),
    ProductPromoProduct("ProductPromoProduct", "Product Promotion Category","productPromoId", "productPromoRuleId", "productPromoActionSeqId", "productPromoCondSeqId", "productId"),
    ProductPromoRule("ProductPromoRule", "Product Promotion Rule","productPromoId", "productPromoRuleId"),
    ProductReview("ProductReview", "Product Review","productReviewId"),
    ProductStore("ProductStore", "Product Store","productStoreId"),
    ProductStoreCatalog("ProductStoreCatalog", "Product Store Catalog Association","productStoreId", "prodCatalogId", "fromDate"),
    ProductStoreEmailSetting("ProductStoreEmailSetting", "Product Store Email Settings","productStoreId", "emailType"),
    ProductStoreFacility("ProductStoreFacility", "Product Store Inventory Facility Applicability","productStoreId", "facilityId", "fromDate"),
    ProductStoreKeywordOvrd("ProductStoreKeywordOvrd", "Product Store Inventory Facility Applicability","productStoreId", "keyword", "fromDate"),
    ProductStorePaymentSetting("ProductStorePaymentSetting", "Product Store Payment Settings","productStoreId", "paymentMethodTypeId", "paymentServiceTypeEnumId"),
    ProductStorePromoAppl("ProductStorePromoAppl", "Product Store Promotion Applicability","productStoreId", "productPromoId", "fromDate"),
    ProductStoreRole("ProductStoreRole", "Product Store Role Association","partyId", "roleTypeId", "productStoreId", "fromDate"),
    ProductStoreShipmentMeth("ProductStoreShipmentMeth", "Product Store Carrier Shipment Method","productStoreShipMethId"),
    ProductSubscriptionResource("ProductSubscriptionResource", "Product Subscription Resource","productId", "subscriptionResourceId", "fromDate"),
    QuantityBreak("QuantityBreak", "Quantity Break","quantityBreakId"),
    Quote("Quote", "Quote","quoteId"),
    QuoteItem("QuoteItem", "Quote Item","quoteId", "quoteItemSeqId"),
    QuoteRole("QuoteRole", "Quote Role","quoteId", "partyId", "roleTypeId"),
    QuoteTerm("QuoteTerm", "Quote Term","termTypeId", "quoteId", "quoteItemSeqId"),
    RecurrenceInfo("RecurrenceInfo", "Recurrence Info","recurrenceInfoId"),
    RecurrenceRule("RecurrenceRule", "Recurrence Rule","recurrenceRuleId"),
    SecurityGroup("SecurityGroup", "Security Component - Security Group","groupId"),
    SecurityGroupPermission("SecurityGroupPermission", "Security Component - Security Group Permission","groupId", "permissionId", "fromDate"),
    Shipment("Shipment", "Shipment","shipmentId"),
    ShipmentBoxType("ShipmentBoxType", "Shipment Contact Mechanism Type","shipmentBoxTypeId"),
    ShipmentCostEstimate("ShipmentCostEstimate", "Shipment Cost Estimate","shipmentCostEstimateId"),
    ShipmentItem("ShipmentItem", "Shipment Item","shipmentId", "shipmentItemSeqId"),
    ShipmentItemBilling("ShipmentItemBilling", "Shipment Item Billing","shipmentId", "shipmentItemSeqId", "invoiceId", "invoiceItemSeqId"),
    ShipmentMethodType("ShipmentMethodType", "Shipment Method Type","shipmentMethodTypeId"),
    ShipmentPackage("ShipmentPackage", "Shipment Package","shipmentId", "shipmentPackageSeqId"),
    ShipmentPackageContent("ShipmentPackageContent", "Shipment Package Content","shipmentId", "shipmentPackageSeqId", "shipmentItemSeqId"),
    ShipmentPackageRouteSeg("ShipmentPackageRouteSeg", "Shipment Package Route Segment","shipmentId", "shipmentPackageSeqId", "shipmentRouteSegmentId"),
    ShipmentReceipt("ShipmentReceipt", "Shipment Receipt","receiptId"),
    ShipmentRouteSegment("ShipmentRouteSegment", "Shipment Route Segment","shipmentId", "shipmentRouteSegmentId"),
    ShipmentStatus("ShipmentStatus", "Shipment Status","statusId", "shipmentId"),
    ShipmentTimeEstimate("ShipmentTimeEstimate", "Shipment Time Estimation Entity","shipmentMethodTypeId", "partyId", "roleTypeId", "geoIdTo", "geoIdFrom", "fromDate"),
    SubscriptionResource("SubscriptionResource", "Subscription Resource","subscriptionResourceId"),
    SupplierProduct("SupplierProduct", "Supplier Product","productId", "partyId", "currencyUomId", "minimumOrderQuantity", "availableFromDate"),
    TelecomNumber("TelecomNumber", "Telecommunications Number","contactMechId"),
    Tenant("Tenant", "Tenant","tenantId"),
    TenantDataSource("TenantDataSource", "TenantDataSource","tenantId", "entityGroupName"),
    TenantDomainName("TenantDomainName", "Tenant and its Domain Name","domainName"),
    UserLogin("UserLogin", "UserLogin","userLoginId"),
    UserLoginSecurityGroup("UserLoginSecurityGroup", "Security Component - User Login Security Group","userLoginId", "groupId", "fromDate"),
    WebAnalyticsConfig("WebAnalyticsConfig", "Web Analytics Configuration","webSiteId", "webAnalyticsTypeId"),
    WebSite("WebSite", "WebSite","webSiteId"),
    WorkEffort("WorkEffort", "WorkEffort","workEffortId"),
    WorkEffortAssoc("WorkEffortAssoc", "Work Effort Association","workEffortIdFrom", "workEffortIdTo", "workEffortAssocTypeId", "fromDate"),
    WorkEffortGoodStandard("WorkEffortGoodStandard", "Work Effort Good Standard","workEffortId", "productId", "workEffortGoodStdTypeId", "fromDate"),
    
    ;

    @Getter(onMethod_ = {@Override})
    public final String entityName;
    @Getter(onMethod_ = {@Override})
    public final String description;
    @Getter(onMethod_ = {@Override})
    public final String[] keys;

    @Getter
    private final List<String> fields= Lists.newArrayList();
    @Getter
    private final List<String> includes=Lists.newArrayList();
    @Getter
    private final List<String> excludes=Lists.newArrayList();

    private static final Map<String, EntityNames> BY_TYPE = new HashMap<>();
    static {
        for (EntityNames e : values()) {
            BY_TYPE.put(e.entityName, e);
        }
    }
    public static EntityNames valueOfType(String typeId) {
        return BY_TYPE.get(typeId);
    }

    private EntityNames(String entityName, String description, String... keys){
        this.entityName=entityName;
        this.description=description;
        this.keys=keys;
    }

    public EntityNames fields(String...flds){
        this.fields.addAll(Arrays.asList(flds));
        return this;
    }

    public EntityNames includes(String...flds){
        this.includes.addAll(Arrays.asList(flds));
        return this;
    }
    
    public EntityNames excludes(String...flds){
        this.excludes.addAll(Arrays.asList(flds));
        return this;
    }
    
    public String getTable(){
        return Util.toSnakecase(entityName);
    }
    
    public List<String> getTableKeys(){
        return Arrays.stream(keys).map(k -> 
                Util.toSnakecase(k))
                .collect(Collectors.toList());
    }
}


