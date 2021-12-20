package com.bluecc.income.dummy.store;

import com.bluecc.income.dao.*;
import com.bluecc.income.exchange.IDelegator;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

public class DelegatorsPluginModule extends AbstractModule {
    public void configure() {
        MapBinder<String, IDelegator> uriBinder =
                MapBinder.newMapBinder(binder(), String.class, IDelegator.class);

        
        uriBinder.addBinding("ProdCatalog").to(ProdCatalogDelegator.class);
        uriBinder.addBinding("ProductStore").to(ProductStoreDelegator.class);
        uriBinder.addBinding("ProductStoreFacility").to(ProductStoreFacilityDelegator.class);
        uriBinder.addBinding("ProductStoreCatalog").to(ProductStoreCatalogDelegator.class);
        uriBinder.addBinding("WebSite").to(WebSiteDelegator.class);
        uriBinder.addBinding("ProdCatalogCategory").to(ProdCatalogCategoryDelegator.class);
        uriBinder.addBinding("ProductCategory").to(ProductCategoryDelegator.class);
        uriBinder.addBinding("ProductCategoryRollup").to(ProductCategoryRollupDelegator.class);
        uriBinder.addBinding("ProductCategoryMember").to(ProductCategoryMemberDelegator.class);
        uriBinder.addBinding("Product").to(ProductDelegator.class);
        uriBinder.addBinding("OrderHeader").to(OrderHeaderDelegator.class);
        uriBinder.addBinding("OrderItem").to(OrderItemDelegator.class);
        uriBinder.addBinding("ShoppingList").to(ShoppingListDelegator.class);
        uriBinder.addBinding("Payment").to(PaymentDelegator.class);
        uriBinder.addBinding("Invoice").to(InvoiceDelegator.class);
        uriBinder.addBinding("InvoiceItem").to(InvoiceItemDelegator.class);
        uriBinder.addBinding("Shipment").to(ShipmentDelegator.class);
        uriBinder.addBinding("InventoryItem").to(InventoryItemDelegator.class);
        uriBinder.addBinding("Party").to(PartyDelegator.class);
        uriBinder.addBinding("Person").to(PersonDelegator.class);
        uriBinder.addBinding("PartyGroup").to(PartyGroupDelegator.class);
        uriBinder.addBinding("UserLogin").to(UserLoginDelegator.class);
        uriBinder.addBinding("BillingAccount").to(BillingAccountDelegator.class);
        uriBinder.addBinding("FinAccount").to(FinAccountDelegator.class);
        uriBinder.addBinding("Quote").to(QuoteDelegator.class);
        uriBinder.addBinding("FixedAsset").to(FixedAssetDelegator.class);
        uriBinder.addBinding("SecurityGroup").to(SecurityGroupDelegator.class);
        uriBinder.addBinding("WorkEffort").to(WorkEffortDelegator.class);
    }
}

