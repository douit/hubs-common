package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
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

public final class OrderTestData {
    public static PartyRoleData PartyRole_TestDemoCustomer_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_TestDemoCustomer_CONTACT() {
        return PartyRoleData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("CONTACT")
            .build();
    }


    public static PartyRoleData PartyRole_TestDemoCustomer_ACCOUNTANT() {
        return PartyRoleData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("ACCOUNTANT")
            .build();
    }


    public static PartyRoleData PartyRole_TestDemoCustomer_END_USER_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("END_USER_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_TestDemoCustomer_SHIP_TO_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("SHIP_TO_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_TestDemoCustomer_PLACING_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("PLACING_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_TestDemoCustomer_BILL_TO_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static ReturnHeaderData ReturnHeader_1009() {
        return ReturnHeaderData.newBuilder()
            .setReturnHeaderTypeId("CUSTOMER_RETURN")
            .setReturnId("1009")
            .setStatusId("RETURN_RECEIVED")
            .build();
    }


    public static OrderHeaderFlatData OrderHeader_TEST_DEMO10090() {
        return OrderHeaderFlatData.newBuilder()
            .setCurrencyUom("USD")
            .setEntryDate(getTimestamp("2008-04-23 16:49:27.392"))
            .setGrandTotal(getCurrency("50.85"))
            .setInvoicePerShipment(castIndicator("Y"))
            .setOrderDate(getTimestamp("2008-04-23 16:49:27.392"))
            .setOrderId("TEST_DEMO10090")
            .setOrderTypeId("SALES_ORDER")
            .setPriority(castIndicator("2"))
            .setProductStoreId("9000")
            .setRemainingSubTotal(getCurrency("38.40"))
            .setSalesChannelEnumId("WEB_SALES_CHANNEL")
            .setStatusId("ORDER_APPROVED")
            .setVisitId("10002")
            .setWebSiteId("WebStore")
            .build();
    }


    public static ProductStoreEmailSettingData ProductStoreEmailSetting_9000_PRDS_ODR_CONFIRM() {
        return ProductStoreEmailSettingData.newBuilder()
            .setBccAddress("ofbiztest@example.com")
            .setBodyScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#OrderConfirmNotice")
            .setEmailType("PRDS_ODR_CONFIRM")
            .setFromAddress("ofbiztest@example.com")
            .setProductStoreId("9000")
            .setSubject("OFBiz Demo - Order Confirmation #${orderId}")
            .setXslfoAttachScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#OrderConfirmNoticePdf")
            .build();
    }


    public static ReturnItemData ReturnItem_1009_00001() {
        return ReturnItemData.newBuilder()
            .setReturnId("1009")
            .setReturnItemSeqId("00001")
            .setReturnItemTypeId("RET_FPROD_ITEM")
            .setReturnQuantity(getFixedPoint("1.000000"))
            .setReturnReasonId("RTN_NOT_WANT")
            .setReturnTypeId("RTN_REFUND")
            .build();
    }


    public static ProdCatalogFlatData ProdCatalog_DemoCatalog() {
        return ProdCatalogFlatData.newBuilder()
            .setCatalogName("Demo Catalog")
            .setProdCatalogId("DemoCatalog")
            .setUseQuickAdd(castIndicator("Y"))
            .build();
    }


    public static ProductFlatData Product_GZ_2644() {
        return ProductFlatData.newBuilder()
            .setInternalName("Round Gizmo")
            .setIsVariant(castIndicator("N"))
            .setIsVirtual(castIndicator("N"))
            .setLongDescription("A small round gizmo with multi-colored lights. Works great in the dark. Small and compact.")
            .setProductId("GZ-2644")
            .setProductTypeId("FINISHED_GOOD")
            .setProductWeight(getFixedPoint("7.0"))
            .setQuantityIncluded(getFixedPoint("100.0"))
            .build();
    }


    public static ProductStoreFlatData ProductStore_9000() {
        return ProductStoreFlatData.newBuilder()
            .setCompanyName("Apache Ofbiz")
            .setProductStoreId("9000")
            .setStoreName("OFBiz Ebay Store1-AU")
            .setTitle("Test OFBiz store1")
            .build();
    }


    public static ShipmentFlatData Shipment_1014() {
        return ShipmentFlatData.newBuilder()
            .setPrimaryOrderId("DEMO10090")
            .setPrimaryShipGroupSeqId("00001")
            .setShipmentId("1014")
            .setShipmentTypeId("SALES_SHIPMENT")
            .setStatusId("SHIPMENT_SHIPPED")
            .build();
    }


    public static ProductPriceData ProductPrice_GZ_2644_SPECIAL_PROMO_PRICE_PURCHASE_USD__NA__() {
        return ProductPriceData.newBuilder()
            .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setCurrencyUomId("USD")
            .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setPrice(getCurrency("31.99"))
            .setProductId("GZ-2644")
            .setProductPricePurposeId("PURCHASE")
            .setProductPriceTypeId("SPECIAL_PROMO_PRICE")
            .setProductStoreGroupId("_NA_")
            .build();
    }


    public static PartyStatusData PartyStatus_PARTY_ENABLED_TestDemoCustomer_() {
        return PartyStatusData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setStatusDate(getTimestamp("2001-01-01 12:00:00.0"))
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static ContactMechData ContactMech_TestContactMech() {
        return ContactMechData.newBuilder()
            .setContactMechId("TestContactMech")
            .setContactMechTypeId("EMAIL_ADDRESS")
            .setInfoString("newtest_email@example.com")
            .build();
    }


    public static ShipmentItemData ShipmentItem_1014_00001() {
        return ShipmentItemData.newBuilder()
            .setShipmentId("1014")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static OrderContactMechData OrderContactMech_TEST_DEMO10090_ORDER_EMAIL_TestContactMech() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("TestContactMech")
            .setContactMechPurposeTypeId("ORDER_EMAIL")
            .setOrderId("TEST_DEMO10090")
            .build();
    }


    public static RequirementData Requirement_1000() {
        return RequirementData.newBuilder()
            .setRequirementId("1000")
            .setRequirementTypeId("CUSTOMER_REQUIREMENT")
            .build();
    }


    public static PartyFlatData Party_TestDemoCustomer() {
        return PartyFlatData.newBuilder()
            .setPartyId("TestDemoCustomer")
            .setPartyTypeId("PERSON")
            .setStatusId("PARTY_ENABLED")
            .build();
    }


    public static WorkEffortFlatData WorkEffort_9000() {
        return WorkEffortFlatData.newBuilder()
            .setCurrentStatusId("_NA_")
            .setLastStatusUpdate(getTimestamp("2007-12-14 15:07:52.901"))
            .setRevisionNumber(1)
            .setScopeEnumId("WES_PRIVATE")
            .setWorkEffortId("9000")
            .setWorkEffortName("Demo Project1 Cust1")
            .setWorkEffortTypeId("PROJECT")
            .build();
    }


    public static ProdCatalogCategoryFlatData ProdCatalogCategory_DemoCatalog_CATALOG1_BEST_SELL_PCCT_BEST_SELL_() {
        return ProdCatalogCategoryFlatData.newBuilder()
            .setFromDate(getTimestamp("2010-01-01 12:00:00.0"))
            .setProdCatalogCategoryTypeId("PCCT_BEST_SELL")
            .setProdCatalogId("DemoCatalog")
            .setProductCategoryId("CATALOG1_BEST_SELL")
            .setSequenceNum(1)
            .build();
    }


    public static PartyContactMechPurposeData PartyContactMechPurpose_TestDemoCustomer_TestContactMech_PRIMARY_EMAIL_() {
        return PartyContactMechPurposeData.newBuilder()
            .setContactMechId("TestContactMech")
            .setContactMechPurposeTypeId("PRIMARY_EMAIL")
            .setFromDate(getTimestamp("2000-01-01 00:00:00"))
            .setPartyId("TestDemoCustomer")
            .build();
    }


    public static OrderItemFlatData OrderItem_TEST_DEMO10090_00001() {
        return OrderItemFlatData.newBuilder()
            .setIsModifiedPrice(castIndicator("N"))
            .setIsPromo(castIndicator("N"))
            .setItemDescription("Round Gizmo")
            .setOrderId("TEST_DEMO10090")
            .setOrderItemSeqId("00001")
            .setOrderItemTypeId("PRODUCT_ORDER_ITEM")
            .setProdCatalogId("DemoCatalog")
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("2.0"))
            .setSelectedAmount(getFixedPoint("0.0"))
            .setStatusId("ITEM_APPROVED")
            .setUnitListPrice(getCurrency("48.0"))
            .setUnitPrice(getCurrency("38.4"))
            .build();
    }


    public static ProductCategoryFlatData ProductCategory_CATALOG1_BEST_SELL() {
        return ProductCategoryFlatData.newBuilder()
            .setCategoryName("Demo Best Selling")
            .setProductCategoryId("CATALOG1_BEST_SELL")
            .setProductCategoryTypeId("BEST_SELL_CATEGORY")
            .build();
    }


    public static PersonFlatData Person_TestDemoCustomer() {
        return PersonFlatData.newBuilder()
            .setFirstName("Test")
            .setLastName("Customer")
            .setPartyId("TestDemoCustomer")
            .build();
    }


    public static OrderRoleData OrderRole_TEST_DEMO10090_TestDemoCustomer_BILL_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("TEST_DEMO10090")
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_TEST_DEMO10090_TestDemoCustomer_END_USER_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("TEST_DEMO10090")
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("END_USER_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_TEST_DEMO10090_TestDemoCustomer_PLACING_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("TEST_DEMO10090")
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("PLACING_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_TEST_DEMO10090_TestDemoCustomer_SHIP_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("TEST_DEMO10090")
            .setPartyId("TestDemoCustomer")
            .setRoleTypeId("SHIP_TO_CUSTOMER")
            .build();
    }


    public static PartyContactMechData PartyContactMech_TestDemoCustomer_TestContactMech_() {
        return PartyContactMechData.newBuilder()
            .setContactMechId("TestContactMech")
            .setFromDate(getTimestamp("2001-05-13 00:00:00.000"))
            .setPartyId("TestDemoCustomer")
            .build();
    }

}
