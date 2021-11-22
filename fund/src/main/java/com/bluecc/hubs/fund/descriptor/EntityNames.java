package com.bluecc.hubs.fund.descriptor;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public enum EntityNames implements INameSymbol{

    AcctgTrans("AcctgTrans", "Accounting Transaction"),
    AcctgTransEntry("AcctgTransEntry", "Transaction Entry"),
    Agreement("Agreement", "Agreement"),
    AgreementItem("AgreementItem", "Agreement Item"),
    AgreementProductAppl("AgreementProductAppl", "Agreement Product Application"),
    AgreementTerm("AgreementTerm", "Agreement Term"),
    BillingAccount("BillingAccount", "Billing Account"),
    BillingAccountRole("BillingAccountRole", "Billing Account Role"),
    CarrierShipmentBoxType("CarrierShipmentBoxType", "Carrier Shipment Method"),
    CarrierShipmentMethod("CarrierShipmentMethod", "Carrier Shipment Method"),
    ContactMech("ContactMech", "Contact Mechanism"),
    Content("Content", "Content"),
    ContentAssoc("ContentAssoc", "Content Association"),
    CreditCard("CreditCard", "Credit Card Information"),
    CustRequest("CustRequest", "CustRequest"),
    CustRequestItem("CustRequestItem", "Customer Request Item"),
    CustRequestType("CustRequestType", "Customer Request Type"),
    DataResource("DataResource", "Data Object"),
    ElectronicText("ElectronicText", "Electronic Text"),
    FacilityContactMech("FacilityContactMech", "Facility Contact Mechanism"),
    FacilityContactMechPurpose("FacilityContactMechPurpose", "Facility Contact Mechanism Purpose"),
    FacilityLocation("FacilityLocation", "Facility Location"),
    FacilityLocationGeoPoint("FacilityLocationGeoPoint", "Facility Location Geo Location with history"),
    FixedAsset("FixedAsset", "Fixed Asset"),
    FixedAssetGeoPoint("FixedAssetGeoPoint", "Fixed Asset Geo Location with history"),
    FixedAssetProduct("FixedAssetProduct", "Fixed Asset Product Representation"),
    GeoPoint("GeoPoint", "Geographic Location"),
    InventoryItem("InventoryItem", "Inventory Item"),
    InventoryItemDetail("InventoryItemDetail", "Inventory Item Detail"),
    Invoice("Invoice", "Invoice"),
    InvoiceItem("InvoiceItem", "Invoice Item"),
    ItemIssuance("ItemIssuance", "Item Issuance"),
    OrderAdjustment("OrderAdjustment", "Order Adjustment"),
    OrderAdjustmentBilling("OrderAdjustmentBilling", "Order Adjustment Billing"),
    OrderContactMech("OrderContactMech", "Order Contact Mechanism"),
    OrderHeader("OrderHeader", "Order Header"),
    OrderItem("OrderItem", "Order Item"),
    OrderItemBilling("OrderItemBilling", "Order Item Billing"),
    OrderItemPriceInfo("OrderItemPriceInfo", "Order Item Price Info"),
    OrderItemShipGroup("OrderItemShipGroup", "Order Item Ship Group"),
    OrderItemShipGroupAssoc("OrderItemShipGroupAssoc", "Order Item Package Association"),
    OrderItemShipGrpInvRes("OrderItemShipGrpInvRes", "Order Item Inventory Reservation"),
    OrderPaymentPreference("OrderPaymentPreference", "The Order Payment Preference"),
    OrderRole("OrderRole", "Order Role"),
    OrderStatus("OrderStatus", "Order Status"),
    Party("Party", "Party"),
    PartyContactMech("PartyContactMech", "Party Contact Mechanism"),
    PartyContactMechPurpose("PartyContactMechPurpose", "Party Contact Mechanism Purpose"),
    PartyGeoPoint("PartyGeoPoint", "Party Geo Location with history"),
    PartyGroup("PartyGroup", "Party Group"),
    PartyRelationship("PartyRelationship", "Party Relationship"),
    PartyRole("PartyRole", "Party Role"),
    PartyStatus("PartyStatus", "Tracks a history of the status of a Party"),
    PartyTaxAuthInfo("PartyTaxAuthInfo", "Party Tax Information"),
    Payment("Payment", "Payment"),
    PaymentApplication("PaymentApplication", "Payment Application"),
    PaymentGatewayResponse("PaymentGatewayResponse", "Payment Gateway Response"),
    PaymentMethod("PaymentMethod", "Payment Method"),
    Person("Person", "Person"),
    PostalAddress("PostalAddress", "Postal Address"),
    ProdCatalog("ProdCatalog", "Catalog"),
    ProdCatalogCategory("ProdCatalogCategory", "Catalog Category Association"),
    Product("Product", "Product"),
    ProductAssoc("ProductAssoc", "Product Association"),
    ProductCategory("ProductCategory", "Product Category"),
    ProductCategoryContent("ProductCategoryContent", "Product Category Data Object"),
    ProductCategoryLink("ProductCategoryLink", "Product Category Link"),
    ProductCategoryMember("ProductCategoryMember", "Product Category Member"),
    ProductCategoryRole("ProductCategoryRole", "Product Category Role"),
    ProductCategoryRollup("ProductCategoryRollup", "Product Category Rollup"),
    ProductConfig("ProductConfig", "Product Configuration Templates"),
    ProductConfigItem("ProductConfigItem", "Product Configuration Question"),
    ProductConfigOption("ProductConfigOption", "Product Configuration Options"),
    ProductConfigProduct("ProductConfigProduct", "Product Configuration Option to Products"),
    ProductContent("ProductContent", "Product Data Object"),
    ProductFacility("ProductFacility", "Product Facility"),
    ProductFacilityAssoc("ProductFacilityAssoc", "Define associations between Product facilities"),
    ProductFacilityLocation("ProductFacilityLocation", "Product Facility"),
    ProductFeature("ProductFeature", "Product Feature"),
    ProductFeatureAppl("ProductFeatureAppl", "Product Feature Applicability"),
    ProductFeatureCategory("ProductFeatureCategory", "Product Feature Category"),
    ProductFeatureCategoryAppl("ProductFeatureCategoryAppl", "Product Feature Category Application"),
    ProductFeatureIactn("ProductFeatureIactn", "Product Feature Interaction"),
    ProductFeaturePrice("ProductFeaturePrice", "Product Feature Price"),
    ProductKeyword("ProductKeyword", "Product Keyword"),
    ProductPrice("ProductPrice", "Product Price"),
    ProductPriceAction("ProductPriceAction", "Product Price Action"),
    ProductPriceCond("ProductPriceCond", "Product Price Condition"),
    ProductPriceRule("ProductPriceRule", "Product Pice Rule"),
    ProductPromo("ProductPromo", "Product Promotion"),
    ProductPromoAction("ProductPromoAction", "Product Promotion Action"),
    ProductPromoCategory("ProductPromoCategory", "Product Promotion Category"),
    ProductPromoCode("ProductPromoCode", "Product Promotion"),
    ProductPromoCond("ProductPromoCond", "Product Promotion Condition"),
    ProductPromoProduct("ProductPromoProduct", "Product Promotion Category"),
    ProductPromoRule("ProductPromoRule", "Product Promotion Rule"),
    ProductReview("ProductReview", "Product Review"),
    ProductStore("ProductStore", "Product Store"),
    ProductStoreCatalog("ProductStoreCatalog", "Product Store Catalog Association"),
    ProductStoreEmailSetting("ProductStoreEmailSetting", "Product Store Email Settings"),
    ProductStoreFacility("ProductStoreFacility", "Product Store Inventory Facility Applicability"),
    ProductStoreKeywordOvrd("ProductStoreKeywordOvrd", "Product Store Inventory Facility Applicability"),
    ProductStorePaymentSetting("ProductStorePaymentSetting", "Product Store Payment Settings"),
    ProductStorePromoAppl("ProductStorePromoAppl", "Product Store Promotion Applicability"),
    ProductStoreRole("ProductStoreRole", "Product Store Role Association"),
    ProductStoreShipmentMeth("ProductStoreShipmentMeth", "Product Store Carrier Shipment Method"),
    ProductSubscriptionResource("ProductSubscriptionResource", "Product Subscription Resource"),
    QuantityBreak("QuantityBreak", "Quantity Break"),
    Quote("Quote", "Quote"),
    QuoteItem("QuoteItem", "Quote Item"),
    QuoteRole("QuoteRole", "Quote Role"),
    QuoteTerm("QuoteTerm", "Quote Term"),
    RecurrenceInfo("RecurrenceInfo", "Recurrence Info"),
    RecurrenceRule("RecurrenceRule", "Recurrence Rule"),
    SecurityGroup("SecurityGroup", "Security Component - Security Group"),
    SecurityGroupPermission("SecurityGroupPermission", "Security Component - Security Group Permission"),
    Shipment("Shipment", "Shipment"),
    ShipmentBoxType("ShipmentBoxType", "Shipment Contact Mechanism Type"),
    ShipmentCostEstimate("ShipmentCostEstimate", "Shipment Cost Estimate"),
    ShipmentItem("ShipmentItem", "Shipment Item"),
    ShipmentItemBilling("ShipmentItemBilling", "Shipment Item Billing"),
    ShipmentMethodType("ShipmentMethodType", "Shipment Method Type"),
    ShipmentPackage("ShipmentPackage", "Shipment Package"),
    ShipmentPackageContent("ShipmentPackageContent", "Shipment Package Content"),
    ShipmentPackageRouteSeg("ShipmentPackageRouteSeg", "Shipment Package Route Segment"),
    ShipmentReceipt("ShipmentReceipt", "Shipment Receipt"),
    ShipmentRouteSegment("ShipmentRouteSegment", "Shipment Route Segment"),
    ShipmentStatus("ShipmentStatus", "Shipment Status"),
    ShipmentTimeEstimate("ShipmentTimeEstimate", "Shipment Time Estimation Entity"),
    SubscriptionResource("SubscriptionResource", "Subscription Resource"),
    SupplierProduct("SupplierProduct", "Supplier Product"),
    TelecomNumber("TelecomNumber", "Telecommunications Number"),
    Tenant("Tenant", "Tenant"),
    TenantDataSource("TenantDataSource", "TenantDataSource"),
    TenantDomainName("TenantDomainName", "Tenant and its Domain Name"),
    UserLogin("UserLogin", "UserLogin"),
    UserLoginSecurityGroup("UserLoginSecurityGroup", "Security Component - User Login Security Group"),
    WebAnalyticsConfig("WebAnalyticsConfig", "Web Analytics Configuration"),
    WebSite("WebSite", "WebSite"),
    WorkEffort("WorkEffort", "WorkEffort"),
    WorkEffortAssoc("WorkEffortAssoc", "Work Effort Association"),
    WorkEffortGoodStandard("WorkEffortGoodStandard", "Work Effort Good Standard"),
    
    ;

    @Getter(onMethod_ = {@Override})
    public final String entityName;
    @Getter(onMethod_ = {@Override})
    public final String description;

    @Getter
    private final List<String> fields= Lists.newArrayList();
    @Getter
    private final List<String> includes=Lists.newArrayList();
    @Getter
    private final List<String> excludes=Lists.newArrayList();

    private EntityNames(String entityName, String description){
        this.entityName=entityName;
        this.description=description;
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
}


