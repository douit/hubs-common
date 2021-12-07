package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.OrderAdjustmentData;
import com.bluecc.hubs.stub.ShipmentFlatData;
import com.bluecc.hubs.stub.OrderItemShipGroupData;
import com.bluecc.hubs.stub.PaymentGatewayResponseData;
import com.bluecc.hubs.stub.OrderPaymentPreferenceData;
import com.bluecc.hubs.stub.OrderItemShipGrpInvResData;
import com.bluecc.hubs.stub.OrderContactMechData;
import com.bluecc.hubs.stub.OrderStatusData;
import com.bluecc.hubs.stub.OrderItemFlatData;
import com.bluecc.hubs.stub.OrderItemShipGroupAssocData;
import com.bluecc.hubs.stub.OrderItemPriceInfoData;
import com.bluecc.hubs.stub.OrderRoleData;

public final class SalesOrder_DEMO10090 {
    public static PartyRoleData PartyRole_DemoCustomer_END_USER_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer")
            .setRoleTypeId("END_USER_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer_SHIP_TO_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer")
            .setRoleTypeId("SHIP_TO_CUSTOMER")
            .build();
    }


    public static PartyRoleData PartyRole_DemoCustomer_PLACING_CUSTOMER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DemoCustomer")
            .setRoleTypeId("PLACING_CUSTOMER")
            .build();
    }


    public static OrderHeaderFlatData OrderHeader_DEMO10090() {
        return OrderHeaderFlatData.newBuilder()
            .setCreatedBy("admin")
            .setCurrencyUom("USD")
            .setEntryDate(getTimestamp("2008-04-23 16:49:27.392"))
            .setGrandTotal(getCurrency("50.85"))
            .setInvoicePerShipment(castIndicator("Y"))
            .setOrderDate(getTimestamp("2008-04-23 16:49:27.392"))
            .setOrderId("DEMO10090")
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


    public static OrderAdjustmentData OrderAdjustment_9000() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("-38.4"))
            .setCreatedByUserLogin("admin")
            .setCreatedDate(getTimestamp("2008-04-23 16:49:27.866"))
            .setOrderAdjustmentId("9000")
            .setOrderAdjustmentTypeId("PROMOTION_ADJUSTMENT")
            .setOrderId("DEMO10090")
            .setOrderItemSeqId("00001")
            .setProductPromoActionSeqId("01")
            .setProductPromoId("9016")
            .setProductPromoRuleId("01")
            .setShipGroupSeqId("_NA_")
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_9001() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("12.45"))
            .setCreatedByUserLogin("admin")
            .setCreatedDate(getTimestamp("2008-04-23 16:49:27.866"))
            .setOrderAdjustmentId("9001")
            .setOrderAdjustmentTypeId("SHIPPING_CHARGES")
            .setOrderId("DEMO10090")
            .setOrderItemSeqId("_NA_")
            .setShipGroupSeqId("00001")
            .build();
    }


    public static ShipmentFlatData Shipment_9998() {
        return ShipmentFlatData.newBuilder()
            .setCreatedDate(getTimestamp("2008-06-10 12:59:26.8"))
            .setDestinationContactMechId("9015")
            .setDestinationTelecomNumberId("9025")
            .setEstimatedShipCost(getCurrency("12.45"))
            .setOriginContactMechId("9200")
            .setOriginFacilityId("WebStoreWarehouse")
            .setOriginTelecomNumberId("9201")
            .setPartyIdTo("DemoCustomer")
            .setPrimaryOrderId("DEMO10090")
            .setPrimaryShipGroupSeqId("00001")
            .setShipmentId("9998")
            .setShipmentTypeId("SALES_SHIPMENT")
            .setStatusId("SHIPMENT_INPUT")
            .build();
    }


    public static OrderItemShipGroupData OrderItemShipGroup_DEMO10090_00001() {
        return OrderItemShipGroupData.newBuilder()
            .setCarrierPartyId("UPS")
            .setCarrierRoleTypeId("CARRIER")
            .setContactMechId("9015")
            .setIsGift(castIndicator("N"))
            .setMaySplit(castIndicator("N"))
            .setOrderId("DEMO10090")
            .setShipGroupSeqId("00001")
            .setShipmentMethodTypeId("NEXT_DAY")
            .build();
    }


    public static PaymentGatewayResponseData PaymentGatewayResponse_9000() {
        return PaymentGatewayResponseData.newBuilder()
            .setAltReference("1250501206473")
            .setAmount(getCurrency("50.85"))
            .setCurrencyUomId("USD")
            .setGatewayCode("100")
            .setGatewayFlag("A")
            .setGatewayMessage("This is a test processor; no payments were captured or authorized.")
            .setOrderPaymentPreferenceId("9000")
            .setPaymentGatewayResponseId("9000")
            .setPaymentMethodId("9015")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .setPaymentServiceTypeEnumId("PRDS_PAY_AUTH")
            .setReferenceNum("1250501206473")
            .setTransCodeEnumId("PGT_AUTHORIZE")
            .setTransactionDate(getTimestamp("2009-08-17 14:56:46.498"))
            .build();
    }


    public static OrderPaymentPreferenceData OrderPaymentPreference_9000() {
        return OrderPaymentPreferenceData.newBuilder()
            .setCreatedByUserLogin("admin")
            .setCreatedDate(getTimestamp("2008-04-23 16:49:27.966"))
            .setMaxAmount(getCurrency("50.85"))
            .setNeedsNsfRetry(castIndicator("N"))
            .setOrderId("DEMO10090")
            .setOrderPaymentPreferenceId("9000")
            .setOverflowFlag(castIndicator("N"))
            .setPaymentMethodId("9015")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .setPresentFlag(castIndicator("N"))
            .setProcessAttempt(1)
            .setStatusId("PAYMENT_AUTHORIZED")
            .setSwipedFlag(castIndicator("N"))
            .build();
    }


    public static OrderItemShipGrpInvResData OrderItemShipGrpInvRes_DEMO10090_00001_00001_9001() {
        return OrderItemShipGrpInvResData.newBuilder()
            .setCreatedDatetime(getTimestamp("2008-04-23 16:49:31.474"))
            .setInventoryItemId("9001")
            .setOrderId("DEMO10090")
            .setOrderItemSeqId("00001")
            .setPriority(castIndicator("2"))
            .setPromisedDatetime(getTimestamp("2008-05-08 16:49:27.392"))
            .setQuantity(getFixedPoint("2.0"))
            .setQuantityNotAvailable(getFixedPoint("0.0"))
            .setReserveOrderEnumId("INVRO_FIFO_REC")
            .setReservedDatetime(getTimestamp("2008-04-23 16:49:31.474"))
            .setShipGroupSeqId("00001")
            .build();
    }


    public static OrderContactMechData OrderContactMech_DEMO10090_BILLING_LOCATION_9015() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9015")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setOrderId("DEMO10090")
            .build();
    }


    public static OrderContactMechData OrderContactMech_DEMO10090_ORDER_EMAIL_9026() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9026")
            .setContactMechPurposeTypeId("ORDER_EMAIL")
            .setOrderId("DEMO10090")
            .build();
    }


    public static OrderContactMechData OrderContactMech_DEMO10090_SHIPPING_LOCATION_9015() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9015")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setOrderId("DEMO10090")
            .build();
    }


    public static OrderStatusData OrderStatus_9000() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10090")
            .setOrderStatusId("9000")
            .setStatusDatetime(getTimestamp("2008-04-23 16:49:27.392"))
            .setStatusId("ORDER_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9001() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10090")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("9001")
            .setStatusDatetime(getTimestamp("2008-04-23 16:49:27.392"))
            .setStatusId("ITEM_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9002() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10090")
            .setOrderPaymentPreferenceId("9000")
            .setOrderStatusId("9002")
            .setStatusDatetime(getTimestamp("2008-04-23 16:49:29.008"))
            .setStatusId("PAYMENT_NOT_AUTH")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9003() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10090")
            .setOrderPaymentPreferenceId("9000")
            .setOrderStatusId("9003")
            .setStatusDatetime(getTimestamp("2008-04-23 16:49:33.094"))
            .setStatusId("PAYMENT_AUTHORIZED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9004() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10090")
            .setOrderStatusId("9004")
            .setStatusDatetime(getTimestamp("2008-04-23 16:49:33.196"))
            .setStatusId("ORDER_APPROVED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9005() {
        return OrderStatusData.newBuilder()
            .setOrderId("DEMO10090")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("9005")
            .setStatusDatetime(getTimestamp("2008-04-23 16:49:33.513"))
            .setStatusId("ITEM_APPROVED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderItemFlatData OrderItem_DEMO10090_00001() {
        return OrderItemFlatData.newBuilder()
            .setIsModifiedPrice(castIndicator("N"))
            .setIsPromo(castIndicator("N"))
            .setItemDescription("Round Gizmo")
            .setOrderId("DEMO10090")
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


    public static OrderItemShipGroupAssocData OrderItemShipGroupAssoc_DEMO10090_00001_00001() {
        return OrderItemShipGroupAssocData.newBuilder()
            .setOrderId("DEMO10090")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("2.0"))
            .setShipGroupSeqId("00001")
            .build();
    }


    public static OrderItemPriceInfoData OrderItemPriceInfo_9000() {
        return OrderItemPriceInfoData.newBuilder()
            .setDescription("[PRODUCT_CATEGORY_IDIsPROMOTIONS] [list:48.0;avgCost:48.0;margin:0.0] [type:PRICE_POL]")
            .setModifyAmount(getCurrency("-9.600"))
            .setOrderId("DEMO10090")
            .setOrderItemPriceInfoId("9000")
            .setOrderItemSeqId("00001")
            .setProductPriceActionSeqId("01")
            .setProductPriceRuleId("9000")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10090_Company_BILL_FROM_VENDOR() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10090")
            .setPartyId("Company")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10090_DemoCustomer_BILL_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10090")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10090_DemoCustomer_END_USER_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10090")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("END_USER_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10090_DemoCustomer_PLACING_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10090")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("PLACING_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_DEMO10090_DemoCustomer_SHIP_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("DEMO10090")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("SHIP_TO_CUSTOMER")
            .build();
    }

}
