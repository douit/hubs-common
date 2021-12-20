package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.OrderTestData.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.ReturnHeaderData;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.ProductStoreEmailSettingData;
import com.bluecc.hubs.stub.ReturnItemData;
import com.bluecc.hubs.stub.ProdCatalogFlatData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.hubs.stub.ShipmentFlatData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.PartyStatusData;
import com.bluecc.hubs.stub.ContactMechData;
import com.bluecc.hubs.stub.ShipmentItemData;
import com.bluecc.hubs.stub.OrderContactMechData;
import com.bluecc.hubs.stub.RequirementData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.WorkEffortFlatData;
import com.bluecc.hubs.stub.ProdCatalogCategoryFlatData;
import com.bluecc.hubs.stub.PartyContactMechPurposeData;
import com.bluecc.hubs.stub.OrderItemFlatData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.PersonFlatData;
import com.bluecc.hubs.stub.OrderRoleData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class OrderTestDataList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_TestDemoCustomer_CUSTOMER(),        
            PartyRole_TestDemoCustomer_CONTACT(),        
            PartyRole_TestDemoCustomer_ACCOUNTANT(),        
            PartyRole_TestDemoCustomer_END_USER_CUSTOMER(),        
            PartyRole_TestDemoCustomer_SHIP_TO_CUSTOMER(),        
            PartyRole_TestDemoCustomer_PLACING_CUSTOMER(),        
            PartyRole_TestDemoCustomer_BILL_TO_CUSTOMER());
    }

    public static List<ReturnHeaderData> returnHeaderList() {
        return ImmutableList.of(        
            ReturnHeader_1009());
    }

    public static List<OrderHeaderFlatData> orderHeaderList() {
        return ImmutableList.of(        
            OrderHeader_TEST_DEMO10090());
    }

    public static List<ProductStoreEmailSettingData> productStoreEmailSettingList() {
        return ImmutableList.of(        
            ProductStoreEmailSetting_9000_PRDS_ODR_CONFIRM());
    }

    public static List<ReturnItemData> returnItemList() {
        return ImmutableList.of(        
            ReturnItem_1009_00001());
    }

    public static List<ProdCatalogFlatData> prodCatalogList() {
        return ImmutableList.of(        
            ProdCatalog_DemoCatalog());
    }

    public static List<ProductFlatData> productList() {
        return ImmutableList.of(        
            Product_GZ_2644());
    }

    public static List<ProductStoreFlatData> productStoreList() {
        return ImmutableList.of(        
            ProductStore_9000());
    }

    public static List<ShipmentFlatData> shipmentList() {
        return ImmutableList.of(        
            Shipment_1014());
    }

    public static List<ProductPriceData> productPriceList() {
        return ImmutableList.of(        
            ProductPrice_GZ_2644_SPECIAL_PROMO_PRICE_PURCHASE_USD__NA__());
    }

    public static List<PartyStatusData> partyStatusList() {
        return ImmutableList.of(        
            PartyStatus_PARTY_ENABLED_TestDemoCustomer_());
    }

    public static List<ContactMechData> contactMechList() {
        return ImmutableList.of(        
            ContactMech_TestContactMech());
    }

    public static List<ShipmentItemData> shipmentItemList() {
        return ImmutableList.of(        
            ShipmentItem_1014_00001());
    }

    public static List<OrderContactMechData> orderContactMechList() {
        return ImmutableList.of(        
            OrderContactMech_TEST_DEMO10090_ORDER_EMAIL_TestContactMech());
    }

    public static List<RequirementData> requirementList() {
        return ImmutableList.of(        
            Requirement_1000());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_TestDemoCustomer());
    }

    public static List<WorkEffortFlatData> workEffortList() {
        return ImmutableList.of(        
            WorkEffort_9000());
    }

    public static List<ProdCatalogCategoryFlatData> prodCatalogCategoryList() {
        return ImmutableList.of(        
            ProdCatalogCategory_DemoCatalog_CATALOG1_BEST_SELL_PCCT_BEST_SELL_());
    }

    public static List<PartyContactMechPurposeData> partyContactMechPurposeList() {
        return ImmutableList.of(        
            PartyContactMechPurpose_TestDemoCustomer_TestContactMech_PRIMARY_EMAIL_());
    }

    public static List<OrderItemFlatData> orderItemList() {
        return ImmutableList.of(        
            OrderItem_TEST_DEMO10090_00001());
    }

    public static List<ProductCategoryFlatData> productCategoryList() {
        return ImmutableList.of(        
            ProductCategory_CATALOG1_BEST_SELL());
    }

    public static List<PersonFlatData> personList() {
        return ImmutableList.of(        
            Person_TestDemoCustomer());
    }

    public static List<OrderRoleData> orderRoleList() {
        return ImmutableList.of(        
            OrderRole_TEST_DEMO10090_TestDemoCustomer_BILL_TO_CUSTOMER(),        
            OrderRole_TEST_DEMO10090_TestDemoCustomer_END_USER_CUSTOMER(),        
            OrderRole_TEST_DEMO10090_TestDemoCustomer_PLACING_CUSTOMER(),        
            OrderRole_TEST_DEMO10090_TestDemoCustomer_SHIP_TO_CUSTOMER());
    }

    public static List<PartyContactMechData> partyContactMechList() {
        return ImmutableList.of(        
            PartyContactMech_TestDemoCustomer_TestContactMech_());
    }

}
