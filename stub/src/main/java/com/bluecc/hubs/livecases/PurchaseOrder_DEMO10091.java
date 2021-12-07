package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.ShipmentFlatData;
import com.bluecc.hubs.stub.ItemIssuanceData;
import com.bluecc.hubs.stub.OrderItemShipGroupData;
import com.bluecc.hubs.stub.ShipmentItemData;
import com.bluecc.hubs.stub.OrderContactMechData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.OrderStatusData;
import com.bluecc.hubs.stub.OrderItemFlatData;
import com.bluecc.hubs.stub.OrderItemShipGroupAssocData;
import com.bluecc.hubs.stub.OrderItemPriceInfoData;
import com.bluecc.hubs.stub.OrderRoleData;

public final class PurchaseOrder_DEMO10091 {
    public static OrderHeaderFlatData OrderHeader_DEMO10091() {
        return OrderHeaderFlatData.newBuilder()
            .setCreatedBy("admin")
            .setCurrencyUom("USD")
            .setEntryDate(getTimestamp("2008-06-10 13:27:07.024"))
            .setGrandTotal(getCurrency("108.0"))
            .setOrderDate(getTimestamp("2008-06-10 13:27:07.024"))
            .setOrderId("DEMO10091")
            .setOrderName("New Purchase Order")
            .setOrderTypeId("PURCHASE_ORDER")
            .setProductStoreId("9000")
            .setRemainingSubTotal(getCurrency("108.0"))
            .setSalesChannelEnumId("UNKNWN_SALES_CHANNEL")
            .setStatusId("ORDER_CREATED")
            .setVisitId("10000")
            .setWebSiteId("WebStore")
            .build();
    }


    public static ShipmentFlatData Shipment_9999() {
        return ShipmentFlatData.newBuilder()
            .setCreatedDate(getTimestamp("2008-06-10 12:59:26.8"))
            .setPrimaryOrderId("DEMO10091")
            .setPrimaryShipGroupSeqId("00001")
            .setShipmentId("9999")
            .setShipmentTypeId("PURCHASE_SHIPMENT")
            .setStatusId("PURCH_SHIP_CREATED")
            .build();
    }


    public static ItemIssuanceData ItemIssuance_9003() {
        return ItemIssuanceData.newBuilder()
            .setIssuedDateTime(getTimestamp("2009-08-13 17:46:29.603"))
            .setItemIssuanceId("9003")
            .setOrderId("DEMO10091")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("5"))
            .setShipGroupSeqId("00001")
            .setShipmentId("9999")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static OrderItemShipGroupData OrderItemShipGroup_DEMO10091_00001() {
        return OrderItemShipGroupData.newBuilder()
            .setCarrierPartyId("_NA_")
            .setCarrierRoleTypeId("CARRIER")
            .setContactMechId("9200")
            .setIsGift(castIndicator("N"))
            .setMaySplit(castIndicator("N"))
            .setOrderId("DEMO10091")
            .setShipGroupSeqId("00001")
            .setShipmentMethodTypeId("NO_SHIPPING")
            .build();
    }


    public static ShipmentItemData ShipmentItem_9999_00001() {
        return ShipmentItemData.newBuilder()
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("5"))
            .setShipmentId("9999")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static OrderContactMechData OrderContactMech_DEMO10091_SHIPPING_LOCATION_9200() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9200")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setOrderId("DEMO10091")
            .build();
    }


    public static PaymentFlatData Payment_9000() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("190.97"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2006-04-25 12:56:54.292"))
            .setPartyIdFrom("Company")
            .setPartyIdTo("DemoSupplier")
            .setPaymentId("9000")
            .setPaymentMethodId("SC_CHECKING")
            .setPaymentMethodTypeId("EFT_ACCOUNT")
            .setPaymentTypeId("VENDOR_PAYMENT")
            .setStatusId("PMNT_NOT_PAID")
            .build();
    }


    public static OrderStatusData OrderStatus_9007() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10091")
            .setOrderStatusId("9007")
            .setStatusDatetime(getTimestamp("2008-06-10 13:27:07.024"))
            .setStatusId("ORDER_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9008() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10091")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("9008")
            .setStatusDatetime(getTimestamp("2008-06-10 13:27:07.024"))
            .setStatusId("ITEM_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderItemFlatData OrderItem_DEMO10091_00001() {
        return OrderItemFlatData.newBuilder()
            .setIsModifiedPrice(castIndicator("N"))
            .setIsPromo(castIndicator("N"))
            .setItemDescription("GZ-2644-5 Round Gizmo")
            .setOrderId("DEMO10091")
            .setOrderItemSeqId("00001")
            .setOrderItemTypeId("PRODUCT_ORDER_ITEM")
            .setProdCatalogId("DemoCatalog")
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("5.0"))
            .setSelectedAmount(getFixedPoint("0.0"))
            .setStatusId("ITEM_CREATED")
            .setUnitListPrice(getCurrency("0.0"))
            .setUnitPrice(getCurrency("21.6"))
            .build();
    }


    public static OrderItemShipGroupAssocData OrderItemShipGroupAssoc_DEMO10091_00001_00001() {
        return OrderItemShipGroupAssocData.newBuilder()
            .setOrderId("DEMO10091")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("5.0"))
            .setShipGroupSeqId("00001")
            .build();
    }


    public static OrderItemPriceInfoData OrderItemPriceInfo_10001() {
        return OrderItemPriceInfoData.newBuilder()
            .setDescription("SupplierProduct [minimumOrderQuantity:5.0, lastPrice: 21.6]")
            .setOrderId("DEMO10091")
            .setOrderItemPriceInfoId("10001")
            .setOrderItemSeqId("00001")
            .build();
    }


    public static OrderItemPriceInfoData OrderItemPriceInfo_10002() {
        return OrderItemPriceInfoData.newBuilder()
            .setDescription("SupplierProduct [minimumOrderQuantity:0.0, lastPrice: 24.0]")
            .setOrderId("DEMO10091")
            .setOrderItemPriceInfoId("10002")
            .setOrderItemSeqId("00001")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10091_Company_BILL_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10091")
            .setPartyId("Company")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10091_DemoSupplier_BILL_FROM_VENDOR() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10091")
            .setPartyId("DemoSupplier")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10091_DemoSupplier_SHIP_FROM_VENDOR() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10091")
            .setPartyId("DemoSupplier")
            .setRoleTypeId("SHIP_FROM_VENDOR")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10091_DemoSupplier_SUPPLIER_AGENT() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10091")
            .setPartyId("DemoSupplier")
            .setRoleTypeId("SUPPLIER_AGENT")
            .build();
    }

}
