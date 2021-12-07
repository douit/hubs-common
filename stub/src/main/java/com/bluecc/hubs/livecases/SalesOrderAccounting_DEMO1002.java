package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ShipmentRouteSegmentData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.OrderAdjustmentData;
import com.bluecc.hubs.stub.ItemIssuanceData;
import com.bluecc.hubs.stub.PaymentGatewayResponseData;
import com.bluecc.hubs.stub.ShipmentItemBillingData;
import com.bluecc.hubs.stub.OrderPaymentPreferenceData;
import com.bluecc.hubs.stub.OrderContactMechData;
import com.bluecc.hubs.stub.ShipmentPackageRouteSegData;
import com.bluecc.hubs.stub.OrderStatusData;
import com.bluecc.hubs.stub.ShipmentStatusData;
import com.bluecc.hubs.stub.OrderRoleData;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PaymentApplicationData;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.AcctgTransEntryData;
import com.bluecc.hubs.stub.AcctgTransData;
import com.bluecc.hubs.stub.ShipmentFlatData;
import com.bluecc.hubs.stub.OrderItemBillingData;
import com.bluecc.hubs.stub.ShipmentPackageContentData;
import com.bluecc.hubs.stub.OrderItemShipGroupData;
import com.bluecc.hubs.stub.ShipmentItemData;
import com.bluecc.hubs.stub.OrderAdjustmentBillingData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.ShipmentPackageData;
import com.bluecc.hubs.stub.OrderItemFlatData;
import com.bluecc.hubs.stub.OrderItemShipGroupAssocData;

public final class SalesOrderAccounting_DEMO1002 {
    public static ShipmentRouteSegmentData ShipmentRouteSegment_9996_00001() {
        return ShipmentRouteSegmentData.newBuilder()
            .setCarrierPartyId("UPS")
            .setCarrierServiceStatusId("SHRSCS_NOT_STARTED")
            .setDestContactMechId("9015")
            .setDestTelecomNumberId("9025")
            .setOriginContactMechId("9200")
            .setOriginFacilityId("WebStoreWarehouse")
            .setOriginTelecomNumberId("9201")
            .setShipmentId("9996")
            .setShipmentMethodTypeId("NEXT_DAY")
            .setShipmentRouteSegmentId("00001")
            .build();
    }


    public static InvoiceFlatData Invoice_8009() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setInvoiceDate(getTimestamp("2009-08-17 14:57:03.614"))
            .setInvoiceId("8009")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPaidDate(getTimestamp("2009-08-17 14:57:04.99"))
            .setPartyId("DemoCustomer")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_PAID")
            .build();
    }


    public static InvoiceFlatData Invoice_8010() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setInvoiceDate(getTimestamp("2009-09-17 14:57:03.614"))
            .setInvoiceId("8010")
            .setInvoiceTypeId("SALES_INVOICE")
            .setPartyId("DemoCustomer")
            .setPartyIdFrom("Company")
            .setStatusId("INVOICE_APPROVED")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("59.990"))
            .setDescription("Micro Chrome Widget")
            .setInventoryItemId("9005")
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_FPROD_ITEM")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("2.000000"))
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00002() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("0.120"))
            .setDescription("Utah County, Utah Sales Tax")
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00002")
            .setInvoiceItemTypeId("ITM_SALES_TAX")
            .setOverrideGlAccountId("224153")
            .setParentInvoiceId("8009")
            .setParentInvoiceItemSeqId("00001")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("1.000000"))
            .setTaxAuthGeoId("UT-UTAH")
            .setTaxAuthPartyId("UT_UTAH_TAXMAN")
            .setTaxAuthorityRateSeqId("9005")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00003() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("5.699"))
            .setDescription("Utah State Sales Tax")
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00003")
            .setInvoiceItemTypeId("ITM_SALES_TAX")
            .setOverrideGlAccountId("224153")
            .setParentInvoiceId("8009")
            .setParentInvoiceItemSeqId("00001")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("1.000000"))
            .setTaxAuthGeoId("UT")
            .setTaxAuthPartyId("UT_TAXMAN")
            .setTaxAuthorityRateSeqId("9004")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00004() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("1.200"))
            .setDescription("1% OFB _NA_ Tax")
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00004")
            .setInvoiceItemTypeId("ITM_SALES_TAX")
            .setOverrideGlAccountId("224000")
            .setParentInvoiceId("8009")
            .setParentInvoiceItemSeqId("00001")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("1.000000"))
            .setTaxAuthGeoId("_NA_")
            .setTaxAuthPartyId("_NA_")
            .setTaxAuthorityRateSeqId("9000")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00005() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("59.990"))
            .setDescription("Micro Chrome Widget")
            .setInventoryItemId("9005")
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00005")
            .setInvoiceItemTypeId("INV_FPROD_ITEM")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("1.000000"))
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00006() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("-59.990"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00006")
            .setInvoiceItemTypeId("ITM_PROMOTION_ADJ")
            .setParentInvoiceId("8009")
            .setParentInvoiceItemSeqId("00005")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("1.000000"))
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00007() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("-12.000"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00007")
            .setInvoiceItemTypeId("ITM_PROMOTION_ADJ")
            .setQuantity(getFixedPoint("1.000000"))
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00008() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("12.100"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00008")
            .setInvoiceItemTypeId("ITM_SHIPPING_CHARGES")
            .setQuantity(getFixedPoint("1.000000"))
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8009_00009() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("-0.010"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00009")
            .setInvoiceItemTypeId("ITM_SALES_TAX")
            .setOverrideGlAccountId("224153")
            .setQuantity(getFixedPoint("1.000000"))
            .setTaxAuthGeoId("UT-UTAH")
            .setTaxAuthPartyId("UT_UTAH_TAXMAN")
            .setTaxAuthorityRateSeqId("9005")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8010_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("59.990"))
            .setDescription("Micro Chrome Widget")
            .setInventoryItemId("9005")
            .setInvoiceId("8010")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("INV_FPROD_ITEM")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("3.000000"))
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_8000() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("-12.000"))
            .setCreatedDate(getTimestamp("2009-08-17 14:56:44.515"))
            .setOrderAdjustmentId("8000")
            .setOrderAdjustmentTypeId("PROMOTION_ADJUSTMENT")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("_NA_")
            .setProductPromoActionSeqId("01")
            .setProductPromoId("9011")
            .setProductPromoRuleId("01")
            .setShipGroupSeqId("_NA_")
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_8001() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("-59.990"))
            .setCreatedDate(getTimestamp("2009-08-17 14:56:44.515"))
            .setOrderAdjustmentId("8001")
            .setOrderAdjustmentTypeId("PROMOTION_ADJUSTMENT")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setProductPromoActionSeqId("01")
            .setProductPromoId("9000")
            .setProductPromoRuleId("01")
            .setShipGroupSeqId("_NA_")
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_8002() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("12.100"))
            .setCreatedByUserLogin("admin")
            .setCreatedDate(getTimestamp("2009-08-17 14:56:44.515"))
            .setOrderAdjustmentId("8002")
            .setOrderAdjustmentTypeId("SHIPPING_CHARGES")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("_NA_")
            .setShipGroupSeqId("00001")
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_8003() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("-0.012"))
            .setComments("Utah County, Utah Sales Tax")
            .setOrderAdjustmentId("8003")
            .setOrderAdjustmentTypeId("SALES_TAX")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("_NA_")
            .setOverrideGlAccountId("224153")
            .setPrimaryGeoId("UT-UTAH")
            .setShipGroupSeqId("00001")
            .setSourcePercentage(getFixedPoint("0.100000"))
            .setTaxAuthGeoId("UT-UTAH")
            .setTaxAuthPartyId("UT_UTAH_TAXMAN")
            .setTaxAuthorityRateSeqId("9005")
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_8004() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("0.120"))
            .setComments("Utah County, Utah Sales Tax")
            .setCreatedDate(getTimestamp("2009-08-17 14:56:44.515"))
            .setOrderAdjustmentId("8004")
            .setOrderAdjustmentTypeId("SALES_TAX")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setOverrideGlAccountId("224153")
            .setPrimaryGeoId("UT-UTAH")
            .setShipGroupSeqId("00001")
            .setSourcePercentage(getFixedPoint("0.100000"))
            .setTaxAuthGeoId("UT-UTAH")
            .setTaxAuthPartyId("UT_UTAH_TAXMAN")
            .setTaxAuthorityRateSeqId("9005")
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_8005() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("5.699"))
            .setComments("Utah State Sales Tax")
            .setCreatedDate(getTimestamp("2009-08-17 14:56:44.515"))
            .setOrderAdjustmentId("8005")
            .setOrderAdjustmentTypeId("SALES_TAX")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setOverrideGlAccountId("224153")
            .setPrimaryGeoId("UT")
            .setShipGroupSeqId("00001")
            .setSourcePercentage(getFixedPoint("4.750000"))
            .setTaxAuthGeoId("UT")
            .setTaxAuthPartyId("UT_TAXMAN")
            .setTaxAuthorityRateSeqId("9004")
            .build();
    }


    public static OrderAdjustmentData OrderAdjustment_8006() {
        return OrderAdjustmentData.newBuilder()
            .setAmount(getCurrency("1.200"))
            .setComments("1% OFB _NA_ Tax")
            .setCreatedDate(getTimestamp("2009-08-17 14:56:44.515"))
            .setOrderAdjustmentId("8006")
            .setOrderAdjustmentTypeId("SALES_TAX")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setOverrideGlAccountId("224000")
            .setPrimaryGeoId("_NA_")
            .setShipGroupSeqId("00001")
            .setSourcePercentage(getFixedPoint("1.000000"))
            .setTaxAuthGeoId("_NA_")
            .setTaxAuthPartyId("_NA_")
            .setTaxAuthorityRateSeqId("9000")
            .build();
    }


    public static ItemIssuanceData ItemIssuance_9001() {
        return ItemIssuanceData.newBuilder()
            .setInventoryItemId("9005")
            .setIssuedByUserLoginId("admin")
            .setIssuedDateTime(getTimestamp("2009-08-17 14:56:58.664"))
            .setItemIssuanceId("9001")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("2.000000"))
            .setShipGroupSeqId("00001")
            .setShipmentId("9996")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static ItemIssuanceData ItemIssuance_9002() {
        return ItemIssuanceData.newBuilder()
            .setInventoryItemId("9005")
            .setIssuedByUserLoginId("admin")
            .setIssuedDateTime(getTimestamp("2009-08-17 14:57:01.872"))
            .setItemIssuanceId("9002")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setQuantity(getFixedPoint("1.000000"))
            .setShipGroupSeqId("00001")
            .setShipmentId("9996")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static PaymentGatewayResponseData PaymentGatewayResponse_9001() {
        return PaymentGatewayResponseData.newBuilder()
            .setAltReference("1250501206473")
            .setAmount(getCurrency("127.09"))
            .setCurrencyUomId("USD")
            .setGatewayCode("100")
            .setGatewayFlag("A")
            .setGatewayMessage("This is a test processor; no payments were captured or authorized.")
            .setOrderPaymentPreferenceId("9001")
            .setPaymentGatewayResponseId("9001")
            .setPaymentMethodId("9015")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .setPaymentServiceTypeEnumId("PRDS_PAY_AUTH")
            .setReferenceNum("1250501206473")
            .setTransCodeEnumId("PGT_AUTHORIZE")
            .setTransactionDate(getTimestamp("2009-08-17 14:56:46.498"))
            .build();
    }


    public static PaymentGatewayResponseData PaymentGatewayResponse_9002() {
        return PaymentGatewayResponseData.newBuilder()
            .setAltReference("1250501224763")
            .setAmount(getCurrency("127.09"))
            .setCurrencyUomId("USD")
            .setGatewayFlag("C")
            .setGatewayMessage("This is a test capture; no money was transferred")
            .setOrderPaymentPreferenceId("9001")
            .setPaymentGatewayResponseId("9002")
            .setPaymentMethodId("9015")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .setPaymentServiceTypeEnumId("PRDS_PAY_CAPTURE")
            .setReferenceNum("1250501224763")
            .setTransCodeEnumId("PGT_CAPTURE")
            .setTransactionDate(getTimestamp("2009-08-17 14:57:04.836"))
            .build();
    }


    public static ShipmentItemBillingData ShipmentItemBilling_9996_00001_8009_00001() {
        return ShipmentItemBillingData.newBuilder()
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00001")
            .setShipmentId("9996")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static OrderPaymentPreferenceData OrderPaymentPreference_9001() {
        return OrderPaymentPreferenceData.newBuilder()
            .setCreatedDate(getTimestamp("2009-08-17 14:56:44.573"))
            .setMaxAmount(getCurrency("127.09"))
            .setNeedsNsfRetry(castIndicator("N"))
            .setOrderId("Demo1002")
            .setOrderPaymentPreferenceId("9001")
            .setOverflowFlag(castIndicator("N"))
            .setPaymentMethodId("9015")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .setPresentFlag(castIndicator("N"))
            .setProcessAttempt(1)
            .setStatusId("PAYMENT_SETTLED")
            .setSwipedFlag(castIndicator("N"))
            .build();
    }


    public static OrderContactMechData OrderContactMech_Demo1002_BILLING_LOCATION_9015() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9015")
            .setContactMechPurposeTypeId("BILLING_LOCATION")
            .setOrderId("Demo1002")
            .build();
    }


    public static OrderContactMechData OrderContactMech_Demo1002_ORDER_EMAIL_9026() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9026")
            .setContactMechPurposeTypeId("ORDER_EMAIL")
            .setOrderId("Demo1002")
            .build();
    }


    public static OrderContactMechData OrderContactMech_Demo1002_SHIPPING_LOCATION_9015() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9015")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setOrderId("Demo1002")
            .build();
    }


    public static ShipmentPackageRouteSegData ShipmentPackageRouteSeg_9996_00001_00001() {
        return ShipmentPackageRouteSegData.newBuilder()
            .setShipmentId("9996")
            .setShipmentPackageSeqId("00001")
            .setShipmentRouteSegmentId("00001")
            .build();
    }


    public static OrderStatusData OrderStatus_8000() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderStatusId("8000")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:44.162"))
            .setStatusId("ORDER_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8001() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("8001")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:44.162"))
            .setStatusId("ITEM_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8002() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setOrderStatusId("8002")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:44.162"))
            .setStatusId("ITEM_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8003() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderPaymentPreferenceId("9001")
            .setOrderStatusId("8003")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:44.938"))
            .setStatusId("PAYMENT_NOT_AUTH")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8004() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderPaymentPreferenceId("9001")
            .setOrderStatusId("8004")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:46.344"))
            .setStatusId("PAYMENT_NOT_AUTH")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8005() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderPaymentPreferenceId("9001")
            .setOrderStatusId("8005")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:46.523"))
            .setStatusId("PAYMENT_AUTHORIZED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8006() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderStatusId("8006")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:46.558"))
            .setStatusId("ORDER_APPROVED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8007() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("8007")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:46.712"))
            .setStatusId("ITEM_APPROVED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8008() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setOrderStatusId("8008")
            .setStatusDatetime(getTimestamp("2009-08-17 14:56:46.712"))
            .setStatusId("ITEM_APPROVED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8009() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("8009")
            .setStatusDatetime(getTimestamp("2009-08-17 14:57:01.657"))
            .setStatusId("ITEM_COMPLETED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8010() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setOrderStatusId("8010")
            .setStatusDatetime(getTimestamp("2009-08-17 14:57:02.401"))
            .setStatusId("ITEM_COMPLETED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8011() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderStatusId("8011")
            .setStatusDatetime(getTimestamp("2009-08-17 14:57:02.433"))
            .setStatusId("ORDER_COMPLETED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_8012() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderPaymentPreferenceId("9001")
            .setOrderStatusId("8012")
            .setStatusDatetime(getTimestamp("2009-08-17 14:57:04.825"))
            .setStatusId("PAYMENT_SETTLED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static ShipmentStatusData ShipmentStatus_SHIPMENT_INPUT_9996() {
        return ShipmentStatusData.newBuilder()
            .setShipmentId("9996")
            .setStatusDate(getTimestamp("2009-08-17 16:35:36.119"))
            .setStatusId("SHIPMENT_INPUT")
            .build();
    }


    public static ShipmentStatusData ShipmentStatus_SHIPMENT_PACKED_9996() {
        return ShipmentStatusData.newBuilder()
            .setShipmentId("9996")
            .setStatusDate(getTimestamp("2009-08-17 16:35:39.627"))
            .setStatusId("SHIPMENT_PACKED")
            .build();
    }


    public static ShipmentStatusData ShipmentStatus_SHIPMENT_SHIPPED_9996() {
        return ShipmentStatusData.newBuilder()
            .setShipmentId("9996")
            .setStatusDate(getTimestamp("2009-08-17 16:35:42.707"))
            .setStatusId("SHIPMENT_SHIPPED")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1002_Company_BILL_FROM_VENDOR() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1002")
            .setPartyId("Company")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1002_DemoCustomer_BILL_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1002")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1002_DemoCustomer_END_USER_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1002")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("END_USER_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1002_DemoCustomer_PLACING_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1002")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("PLACING_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1002_DemoCustomer_SHIP_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1002")
            .setPartyId("DemoCustomer")
            .setRoleTypeId("SHIP_TO_CUSTOMER")
            .build();
    }


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


    public static PaymentApplicationData PaymentApplication_9003() {
        return PaymentApplicationData.newBuilder()
            .setAmountApplied(getCurrency("127.09"))
            .setInvoiceId("8009")
            .setPaymentApplicationId("9003")
            .setPaymentId("8004")
            .build();
    }


    public static OrderHeaderFlatData OrderHeader_Demo1002() {
        return OrderHeaderFlatData.newBuilder()
            .setCreatedBy("admin")
            .setCurrencyUom("USD")
            .setEntryDate(getTimestamp("2009-08-17 14:23:49.475"))
            .setGrandTotal(getCurrency("127.09"))
            .setOrderDate(getTimestamp("2009-08-17 14:23:49.475"))
            .setOrderId("Demo1002")
            .setOrderName("Demo Sales Order")
            .setOrderTypeId("SALES_ORDER")
            .setPriority(castIndicator("2"))
            .setProductStoreId("9000")
            .setRemainingSubTotal(getCurrency("107.98"))
            .setSalesChannelEnumId("WEB_SALES_CHANNEL")
            .setStatusId("ORDER_COMPLETED")
            .setVisitId("10000")
            .setWebSiteId("WebStore")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9002_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9002")
            .setAmount(getCurrency("9.00"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("140000")
            .setGlAccountTypeId("INVENTORY_ACCOUNT")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("9.00"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9002_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9002")
            .setAmount(getCurrency("9.00"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("500000")
            .setGlAccountTypeId("COGS_ACCOUNT")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("9.00"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9003_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9003")
            .setAmount(getCurrency("4.50"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("140000")
            .setGlAccountTypeId("INVENTORY_ACCOUNT")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("4.50"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9003_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9003")
            .setAmount(getCurrency("4.50"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("500000")
            .setGlAccountTypeId("COGS_ACCOUNT")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("4.50"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("119.98"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("400000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("119.98"))
            .setOrigCurrencyUomId("USD")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("0.12"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("224153")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("0.12"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("UT_UTAH_TAXMAN")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("TAX_AUTHORITY")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00003() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00003")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("5.69"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("224153")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("5.69"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("UT_TAXMAN")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("TAX_AUTHORITY")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00004() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00004")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("1.20"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("224000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("1.20"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("_NA_")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("TAX_AUTHORITY")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00005() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00005")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("59.99"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("400000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("59.99"))
            .setOrigCurrencyUomId("USD")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00006() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00006")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("59.99"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("400000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("59.99"))
            .setOrigCurrencyUomId("USD")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00007() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00007")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("12.00"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("410000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("12.00"))
            .setOrigCurrencyUomId("USD")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00008() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00008")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("12.10"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("409000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("12.10"))
            .setOrigCurrencyUomId("USD")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00009() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00009")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("0.01"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("224153")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("0.01"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("UT_UTAH_TAXMAN")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("TAX_AUTHORITY")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9004_00010() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00010")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9004")
            .setAmount(getCurrency("127.08"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("120000")
            .setGlAccountTypeId("ACCOUNTS_RECEIVABLE")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("127.08"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9005_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9005")
            .setAmount(getCurrency("127.09"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("122300")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("127.09"))
            .setOrigCurrencyUomId("USD")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9005_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9005")
            .setAmount(getCurrency("127.09"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("120000")
            .setGlAccountTypeId("ACCOUNTS_RECEIVABLE")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("127.09"))
            .setOrigCurrencyUomId("USD")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9006_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9006")
            .setAmount(getCurrency("127.09"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("120000")
            .setGlAccountTypeId("ACCOUNTS_RECEIVABLE")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("127.09"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9006_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9006")
            .setAmount(getCurrency("127.09"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("120000")
            .setGlAccountTypeId("ACCOUNTS_RECEIVABLE")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("127.09"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9007_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9007")
            .setAmount(getCurrency("179.97"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("400000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("179.97"))
            .setOrigCurrencyUomId("USD")
            .setProductId("WG-1111")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9007_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9007")
            .setAmount(getCurrency("179.97"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("120000")
            .setGlAccountTypeId("ACCOUNTS_RECEIVABLE")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("179.97"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoCustomer")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static AcctgTransData AcctgTrans_9002() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9002")
            .setAcctgTransTypeId("SALES_SHIPMENT")
            .setGlFiscalTypeId("ACTUAL")
            .setIsPosted(castIndicator("Y"))
            .setPostedDate(getTimestamp("2009-08-17 14:57:01.321"))
            .setShipmentId("9996")
            .setTransactionDate(getTimestamp("2009-08-17 14:56:59.96"))
            .build();
    }


    public static AcctgTransData AcctgTrans_9003() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9003")
            .setAcctgTransTypeId("SALES_SHIPMENT")
            .setGlFiscalTypeId("ACTUAL")
            .setIsPosted(castIndicator("Y"))
            .setPostedDate(getTimestamp("2009-08-17 14:57:02.345"))
            .setShipmentId("9996")
            .setTransactionDate(getTimestamp("2009-08-17 14:57:01.955"))
            .build();
    }


    public static AcctgTransData AcctgTrans_9004() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9004")
            .setAcctgTransTypeId("SALES_INVOICE")
            .setGlFiscalTypeId("ACTUAL")
            .setInvoiceId("8009")
            .setIsPosted(castIndicator("Y"))
            .setPostedDate(getTimestamp("2009-08-17 14:57:06.587"))
            .setTransactionDate(getTimestamp("2009-08-17 14:57:06.129"))
            .build();
    }


    public static AcctgTransData AcctgTrans_9005() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9005")
            .setAcctgTransTypeId("INCOMING_PAYMENT")
            .setGlFiscalTypeId("ACTUAL")
            .setIsPosted(castIndicator("Y"))
            .setPartyId("DemoCustomer")
            .setPaymentId("8004")
            .setPostedDate(getTimestamp("2009-08-17 14:57:05.56"))
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .setTransactionDate(getTimestamp("2009-08-17 14:57:05.182"))
            .build();
    }


    public static AcctgTransData AcctgTrans_9006() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9006")
            .setAcctgTransTypeId("PAYMENT_APPL")
            .setGlFiscalTypeId("ACTUAL")
            .setInvoiceId("8009")
            .setIsPosted(castIndicator("Y"))
            .setPartyId("DemoCustomer")
            .setPaymentId("8004")
            .setPostedDate(getTimestamp("2009-08-17 14:57:05.878"))
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .setTransactionDate(getTimestamp("2009-08-17 14:57:05.741"))
            .build();
    }


    public static AcctgTransData AcctgTrans_9007() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9007")
            .setAcctgTransTypeId("SALES_INVOICE")
            .setGlFiscalTypeId("ACTUAL")
            .setInvoiceId("8010")
            .setIsPosted(castIndicator("Y"))
            .setPostedDate(getTimestamp("2009-09-17 14:57:06.587"))
            .setTransactionDate(getTimestamp("2009-09-17 14:57:06.129"))
            .build();
    }


    public static ShipmentFlatData Shipment_9996() {
        return ShipmentFlatData.newBuilder()
            .setCreatedDate(getTimestamp("2009-08-17 14:56:57.553"))
            .setDestinationContactMechId("9015")
            .setDestinationTelecomNumberId("9025")
            .setEstimatedShipCost(getCurrency("12.10"))
            .setOriginContactMechId("9200")
            .setOriginFacilityId("WebStoreWarehouse")
            .setOriginTelecomNumberId("9201")
            .setPartyIdFrom("Company")
            .setPartyIdTo("DemoCustomer")
            .setPrimaryOrderId("Demo1002")
            .setPrimaryShipGroupSeqId("00001")
            .setShipmentId("9996")
            .setShipmentTypeId("SALES_SHIPMENT")
            .setStatusId("SHIPMENT_SHIPPED")
            .build();
    }


    public static OrderItemBillingData OrderItemBilling_Demo1002_00001_8009_00001() {
        return OrderItemBillingData.newBuilder()
            .setAmount(getCurrency("59.99"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00001")
            .setItemIssuanceId("9001")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("2.000000"))
            .build();
    }


    public static OrderItemBillingData OrderItemBilling_Demo1002_00004_8009_00005() {
        return OrderItemBillingData.newBuilder()
            .setAmount(getCurrency("59.99"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00005")
            .setItemIssuanceId("9002")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setQuantity(getFixedPoint("1.000000"))
            .build();
    }


    public static ShipmentPackageContentData ShipmentPackageContent_9996_00001_00001() {
        return ShipmentPackageContentData.newBuilder()
            .setQuantity(getFixedPoint("3.000000"))
            .setShipmentId("9996")
            .setShipmentItemSeqId("00001")
            .setShipmentPackageSeqId("00001")
            .build();
    }


    public static OrderItemShipGroupData OrderItemShipGroup_Demo1002_00001() {
        return OrderItemShipGroupData.newBuilder()
            .setCarrierPartyId("UPS")
            .setCarrierRoleTypeId("CARRIER")
            .setContactMechId("9015")
            .setIsGift(castIndicator("N"))
            .setMaySplit(castIndicator("N"))
            .setOrderId("Demo1002")
            .setShipGroupSeqId("00001")
            .setShipmentMethodTypeId("NEXT_DAY")
            .build();
    }


    public static ShipmentItemData ShipmentItem_9996_00001() {
        return ShipmentItemData.newBuilder()
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("3.000000"))
            .setShipmentId("9996")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static OrderAdjustmentBillingData OrderAdjustmentBilling_8000_8009_00007() {
        return OrderAdjustmentBillingData.newBuilder()
            .setAmount(getCurrency("-12.00"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00007")
            .setOrderAdjustmentId("8000")
            .build();
    }


    public static OrderAdjustmentBillingData OrderAdjustmentBilling_8001_8009_00006() {
        return OrderAdjustmentBillingData.newBuilder()
            .setAmount(getCurrency("-59.99"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00006")
            .setOrderAdjustmentId("8001")
            .build();
    }


    public static OrderAdjustmentBillingData OrderAdjustmentBilling_8002_8009_00008() {
        return OrderAdjustmentBillingData.newBuilder()
            .setAmount(getCurrency("12.10"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00008")
            .setOrderAdjustmentId("8002")
            .build();
    }


    public static OrderAdjustmentBillingData OrderAdjustmentBilling_8003_8009_00009() {
        return OrderAdjustmentBillingData.newBuilder()
            .setAmount(getCurrency("-0.01"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00009")
            .setOrderAdjustmentId("8003")
            .build();
    }


    public static OrderAdjustmentBillingData OrderAdjustmentBilling_8004_8009_00002() {
        return OrderAdjustmentBillingData.newBuilder()
            .setAmount(getCurrency("0.12"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00002")
            .setOrderAdjustmentId("8004")
            .build();
    }


    public static OrderAdjustmentBillingData OrderAdjustmentBilling_8005_8009_00003() {
        return OrderAdjustmentBillingData.newBuilder()
            .setAmount(getCurrency("5.69"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00003")
            .setOrderAdjustmentId("8005")
            .build();
    }


    public static OrderAdjustmentBillingData OrderAdjustmentBilling_8006_8009_00004() {
        return OrderAdjustmentBillingData.newBuilder()
            .setAmount(getCurrency("1.20"))
            .setInvoiceId("8009")
            .setInvoiceItemSeqId("00004")
            .setOrderAdjustmentId("8006")
            .build();
    }


    public static PaymentFlatData Payment_8004() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("127.09"))
            .setCurrencyUomId("USD")
            .setEffectiveDate(getTimestamp("2009-08-17 14:57:04.99"))
            .setPartyIdFrom("DemoCustomer")
            .setPartyIdTo("Company")
            .setPaymentGatewayResponseId("9002")
            .setPaymentId("8004")
            .setPaymentMethodId("9015")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .setPaymentPreferenceId("9001")
            .setPaymentRefNum("1250501224763")
            .setPaymentTypeId("CUSTOMER_PAYMENT")
            .setStatusId("PMNT_RECEIVED")
            .build();
    }


    public static ShipmentPackageData ShipmentPackage_9996_00001() {
        return ShipmentPackageData.newBuilder()
            .setDateCreated(getTimestamp("2009-08-17 14:57:02.742"))
            .setShipmentId("9996")
            .setShipmentPackageSeqId("00001")
            .build();
    }


    public static OrderItemFlatData OrderItem_Demo1002_00001() {
        return OrderItemFlatData.newBuilder()
            .setIsModifiedPrice(castIndicator("N"))
            .setIsPromo(castIndicator("N"))
            .setItemDescription("Micro Chrome Widget")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setOrderItemTypeId("PRODUCT_ORDER_ITEM")
            .setProdCatalogId("DemoCatalog")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("2.000000"))
            .setSelectedAmount(getFixedPoint("0.000000"))
            .setStatusId("ITEM_COMPLETED")
            .setUnitListPrice(getCurrency("60.00"))
            .setUnitPrice(getCurrency("59.99"))
            .build();
    }


    public static OrderItemFlatData OrderItem_Demo1002_00004() {
        return OrderItemFlatData.newBuilder()
            .setIsModifiedPrice(castIndicator("N"))
            .setIsPromo(castIndicator("Y"))
            .setItemDescription("Micro Chrome Widget")
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setOrderItemTypeId("PRODUCT_ORDER_ITEM")
            .setProductId("WG-1111")
            .setQuantity(getFixedPoint("1.000000"))
            .setSelectedAmount(getFixedPoint("0.000000"))
            .setStatusId("ITEM_COMPLETED")
            .setUnitListPrice(getCurrency("60.00"))
            .setUnitPrice(getCurrency("59.99"))
            .build();
    }


    public static OrderItemShipGroupAssocData OrderItemShipGroupAssoc_Demo1002_00001_00001() {
        return OrderItemShipGroupAssocData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("2.000000"))
            .setShipGroupSeqId("00001")
            .build();
    }


    public static OrderItemShipGroupAssocData OrderItemShipGroupAssoc_Demo1002_00004_00001() {
        return OrderItemShipGroupAssocData.newBuilder()
            .setOrderId("Demo1002")
            .setOrderItemSeqId("00004")
            .setQuantity(getFixedPoint("1.000000"))
            .setShipGroupSeqId("00001")
            .build();
    }

}
