package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.InventoryItemData;
import com.bluecc.hubs.stub.OrderHeaderFlatData;
import com.bluecc.hubs.stub.ShipmentRouteSegmentData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.AcctgTransEntryData;
import com.bluecc.hubs.stub.ShipmentReceiptData;
import com.bluecc.hubs.stub.AcctgTransData;
import com.bluecc.hubs.stub.ShipmentFlatData;
import com.bluecc.hubs.stub.InventoryItemDetailData;
import com.bluecc.hubs.stub.OrderItemBillingData;
import com.bluecc.hubs.stub.ShipmentPackageContentData;
import com.bluecc.hubs.stub.ItemIssuanceData;
import com.bluecc.hubs.stub.OrderItemShipGroupData;
import com.bluecc.hubs.stub.ShipmentItemData;
import com.bluecc.hubs.stub.OrderContactMechData;
import com.bluecc.hubs.stub.ShipmentPackageRouteSegData;
import com.bluecc.hubs.stub.OrderStatusData;
import com.bluecc.hubs.stub.ShipmentStatusData;
import com.bluecc.hubs.stub.ShipmentPackageData;
import com.bluecc.hubs.stub.OrderItemFlatData;
import com.bluecc.hubs.stub.OrderItemShipGroupAssocData;
import com.bluecc.hubs.stub.OrderItemPriceInfoData;
import com.bluecc.hubs.stub.OrderRoleData;

public final class PurchaseOrderAccounting_DEMO1001 {
    public static InventoryItemData InventoryItem_9025() {
        return InventoryItemData.newBuilder()
            .setAvailableToPromiseTotal(getFixedPoint("2.000000"))
            .setCurrencyUomId("USD")
            .setDatetimeReceived(getTimestamp("2009-08-13 17:47:31.095"))
            .setFacilityId("WebStoreWarehouse")
            .setInventoryItemId("9025")
            .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
            .setLocationSeqId("TLTLTLLL01")
            .setOwnerPartyId("Company")
            .setProductId("GZ-2644")
            .setQuantityOnHandTotal(getFixedPoint("2.000000"))
            .setUnitCost(getFixedPoint("24.000000"))
            .build();
    }


    public static OrderHeaderFlatData OrderHeader_Demo1001() {
        return OrderHeaderFlatData.newBuilder()
            .setCurrencyUom("USD")
            .setEntryDate(getTimestamp("2009-08-13 17:45:50.419"))
            .setGrandTotal(getCurrency("48.00"))
            .setOrderDate(getTimestamp("2009-08-13 17:45:50.419"))
            .setOrderId("Demo1001")
            .setOrderName("Demo Purchase Order ")
            .setOrderTypeId("PURCHASE_ORDER")
            .setPriority(castIndicator("2"))
            .setRemainingSubTotal(getCurrency("48.00"))
            .setSalesChannelEnumId("UNKNWN_SALES_CHANNEL")
            .setStatusId("ORDER_COMPLETED")
            .setWebSiteId("WebStore")
            .build();
    }


    public static ShipmentRouteSegmentData ShipmentRouteSegment_9997_00001() {
        return ShipmentRouteSegmentData.newBuilder()
            .setCarrierPartyId("_NA_")
            .setCarrierServiceStatusId("SHRSCS_NOT_STARTED")
            .setDestContactMechId("9200")
            .setDestFacilityId("WebStoreWarehouse")
            .setDestTelecomNumberId("9201")
            .setShipmentId("9997")
            .setShipmentMethodTypeId("NO_SHIPPING")
            .setShipmentRouteSegmentId("00001")
            .build();
    }


    public static InvoiceFlatData Invoice_8008() {
        return InvoiceFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setDescription("Purchase Order Invoice")
            .setInvoiceDate(getTimestamp("2009-08-13 17:47:47.929"))
            .setInvoiceId("8008")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("Company")
            .setPartyIdFrom("DemoSupplier")
            .setStatusId("INVOICE_READY")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_8008_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setAmount(getCurrency("24.000"))
            .setDescription("GZ-2644-0 Round Gizmo")
            .setInvoiceId("8008")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("PINV_FPROD_ITEM")
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("2.000000"))
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9000_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9000")
            .setAmount(getCurrency("48.00"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("214000")
            .setGlAccountTypeId("UNINVOICED_SHIP_RCPT")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("48.00"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoSupplier")
            .setProductId("GZ-2644")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9000_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9000")
            .setAmount(getCurrency("48.00"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("140000")
            .setGlAccountTypeId("INVENTORY_ACCOUNT")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("48.00"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoSupplier")
            .setProductId("GZ-2644")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9001_00001() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00001")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9001")
            .setAmount(getCurrency("48.00"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("D"))
            .setGlAccountId("214000")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("48.00"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoSupplier")
            .setProductId("GZ-2644")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static AcctgTransEntryData AcctgTransEntry_9001_00002() {
        return AcctgTransEntryData.newBuilder()
            .setAcctgTransEntrySeqId("00002")
            .setAcctgTransEntryTypeId("_NA_")
            .setAcctgTransId("9001")
            .setAmount(getCurrency("48.00"))
            .setCurrencyUomId("USD")
            .setDebitCreditFlag(castIndicator("C"))
            .setGlAccountId("210000")
            .setGlAccountTypeId("ACCOUNTS_PAYABLE")
            .setOrganizationPartyId("Company")
            .setOrigAmount(getCurrency("48.00"))
            .setOrigCurrencyUomId("USD")
            .setPartyId("DemoSupplier")
            .setReconcileStatusId("AES_NOT_RECONCILED")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static ShipmentReceiptData ShipmentReceipt_9000() {
        return ShipmentReceiptData.newBuilder()
            .setDatetimeReceived(getTimestamp("2009-08-13 17:47:31.095"))
            .setInventoryItemId("9025")
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setProductId("GZ-2644")
            .setQuantityAccepted(getFixedPoint("2.000000"))
            .setQuantityRejected(getFixedPoint("0.000000"))
            .setReceiptId("9000")
            .setShipmentId("9997")
            .build();
    }


    public static AcctgTransData AcctgTrans_9000() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9000")
            .setAcctgTransTypeId("SHIPMENT_RECEIPT")
            .setGlFiscalTypeId("ACTUAL")
            .setIsPosted(castIndicator("Y"))
            .setPartyId("DemoSupplier")
            .setPostedDate(getTimestamp("2009-08-13 17:47:49.281"))
            .setShipmentId("9997")
            .setTransactionDate(getTimestamp("2009-08-13 17:47:48.642"))
            .build();
    }


    public static AcctgTransData AcctgTrans_9001() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("9001")
            .setAcctgTransTypeId("PURCHASE_INVOICE")
            .setGlFiscalTypeId("ACTUAL")
            .setInvoiceId("8008")
            .setIsPosted(castIndicator("Y"))
            .setPartyId("DemoSupplier")
            .setPostedDate(getTimestamp("2009-08-13 18:58:35.08"))
            .setRoleTypeId("BILL_FROM_VENDOR")
            .setTransactionDate(getTimestamp("2009-08-13 18:58:34.65"))
            .build();
    }


    public static ShipmentFlatData Shipment_9997() {
        return ShipmentFlatData.newBuilder()
            .setCreatedDate(getTimestamp("2008-06-10 12:59:26.8"))
            .setDestinationContactMechId("9200")
            .setDestinationFacilityId("WebStoreWarehouse")
            .setDestinationTelecomNumberId("9201")
            .setEstimatedShipCost(getCurrency("0.00"))
            .setPartyIdFrom("DemoSupplier")
            .setPrimaryOrderId("Demo1001")
            .setPrimaryShipGroupSeqId("00001")
            .setShipmentId("9997")
            .setShipmentTypeId("PURCHASE_SHIPMENT")
            .setStatusId("PURCH_SHIP_RECEIVED")
            .build();
    }


    public static InventoryItemDetailData InventoryItemDetail_9025_00001() {
        return InventoryItemDetailData.newBuilder()
            .setAccountingQuantityDiff(getFixedPoint("2.000000"))
            .setAvailableToPromiseDiff(getFixedPoint("2.000000"))
            .setEffectiveDate(getTimestamp("2009-08-13 17:47:46.78"))
            .setInventoryItemDetailSeqId("00001")
            .setInventoryItemId("9025")
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setQuantityOnHandDiff(getFixedPoint("2.000000"))
            .setReceiptId("9000")
            .setShipmentId("9997")
            .setUnitCost(getFixedPoint("24.000000"))
            .build();
    }


    public static OrderItemBillingData OrderItemBilling_Demo1001_00001_8008_00001() {
        return OrderItemBillingData.newBuilder()
            .setAmount(getCurrency("24.00"))
            .setInvoiceId("8008")
            .setInvoiceItemSeqId("00001")
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("2.000000"))
            .setShipmentReceiptId("9000")
            .build();
    }


    public static ShipmentPackageContentData ShipmentPackageContent_9997_00001_00001() {
        return ShipmentPackageContentData.newBuilder()
            .setQuantity(getFixedPoint("2.000000"))
            .setShipmentId("9997")
            .setShipmentItemSeqId("00001")
            .setShipmentPackageSeqId("00001")
            .build();
    }


    public static ItemIssuanceData ItemIssuance_9000() {
        return ItemIssuanceData.newBuilder()
            .setIssuedDateTime(getTimestamp("2009-08-13 17:46:29.603"))
            .setItemIssuanceId("9000")
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("2.000000"))
            .setShipGroupSeqId("00001")
            .setShipmentId("9997")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static OrderItemShipGroupData OrderItemShipGroup_Demo1001_00001() {
        return OrderItemShipGroupData.newBuilder()
            .setCarrierPartyId("_NA_")
            .setCarrierRoleTypeId("CARRIER")
            .setContactMechId("9200")
            .setEstimatedDeliveryDate(getTimestamp("2009-08-13 17:43:53.0"))
            .setIsGift(castIndicator("N"))
            .setMaySplit(castIndicator("N"))
            .setOrderId("Demo1001")
            .setShipGroupSeqId("00001")
            .setShipmentMethodTypeId("NO_SHIPPING")
            .build();
    }


    public static ShipmentItemData ShipmentItem_9997_00001() {
        return ShipmentItemData.newBuilder()
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("2.000000"))
            .setShipmentId("9997")
            .setShipmentItemSeqId("00001")
            .build();
    }


    public static OrderContactMechData OrderContactMech_Demo1001_SHIPPING_LOCATION_9200() {
        return OrderContactMechData.newBuilder()
            .setContactMechId("9200")
            .setContactMechPurposeTypeId("SHIPPING_LOCATION")
            .setOrderId("Demo1001")
            .build();
    }


    public static ShipmentPackageRouteSegData ShipmentPackageRouteSeg_9997_00001_00001() {
        return ShipmentPackageRouteSegData.newBuilder()
            .setShipmentId("9997")
            .setShipmentPackageSeqId("00001")
            .setShipmentRouteSegmentId("00001")
            .build();
    }


    public static OrderStatusData OrderStatus_9009() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1001")
            .setOrderStatusId("9009")
            .setStatusDatetime(getTimestamp("2009-08-13 17:45:50.419"))
            .setStatusId("ORDER_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9010() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("9010")
            .setStatusDatetime(getTimestamp("2009-08-13 17:45:50.419"))
            .setStatusId("ITEM_CREATED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9011() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("9011")
            .setStatusDatetime(getTimestamp("2009-08-13 17:46:15.144"))
            .setStatusId("ITEM_APPROVED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9012() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1001")
            .setOrderStatusId("9012")
            .setStatusDatetime(getTimestamp("2009-08-13 17:46:15.206"))
            .setStatusId("ORDER_APPROVED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9013() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setOrderStatusId("9013")
            .setStatusDatetime(getTimestamp("2009-08-13 17:47:47.292"))
            .setStatusId("ITEM_COMPLETED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static OrderStatusData OrderStatus_9014() {
        return OrderStatusData.newBuilder()
            .setOrderId("Demo1001")
            .setOrderStatusId("9014")
            .setStatusDatetime(getTimestamp("2009-08-13 17:47:47.344"))
            .setStatusId("ORDER_COMPLETED")
            .setStatusUserLogin("admin")
            .build();
    }


    public static ShipmentStatusData ShipmentStatus_PURCH_SHIP_CREATED_9997() {
        return ShipmentStatusData.newBuilder()
            .setShipmentId("9997")
            .setStatusDate(getTimestamp("2009-08-13 17:46:28.784"))
            .setStatusId("PURCH_SHIP_CREATED")
            .build();
    }


    public static ShipmentStatusData ShipmentStatus_PURCH_SHIP_RECEIVED_9997() {
        return ShipmentStatusData.newBuilder()
            .setShipmentId("9997")
            .setStatusDate(getTimestamp("2009-08-13 17:47:47.602"))
            .setStatusId("PURCH_SHIP_RECEIVED")
            .build();
    }


    public static ShipmentStatusData ShipmentStatus_PURCH_SHIP_SHIPPED_9997() {
        return ShipmentStatusData.newBuilder()
            .setShipmentId("9997")
            .setStatusDate(getTimestamp("2009-08-13 17:46:29.836"))
            .setStatusId("PURCH_SHIP_SHIPPED")
            .build();
    }


    public static ShipmentPackageData ShipmentPackage_9997_00001() {
        return ShipmentPackageData.newBuilder()
            .setDateCreated(getTimestamp("2009-08-13 17:46:29.751"))
            .setShipmentId("9997")
            .setShipmentPackageSeqId("00001")
            .build();
    }


    public static OrderItemFlatData OrderItem_Demo1001_00001() {
        return OrderItemFlatData.newBuilder()
            .setEstimatedDeliveryDate(getTimestamp("2009-08-13 17:43:53.0"))
            .setIsModifiedPrice(castIndicator("N"))
            .setIsPromo(castIndicator("N"))
            .setItemDescription("GZ-2644-0 Round Gizmo")
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setOrderItemTypeId("PRODUCT_ORDER_ITEM")
            .setProdCatalogId("DemoCatalog")
            .setProductId("GZ-2644")
            .setQuantity(getFixedPoint("2.000000"))
            .setSelectedAmount(getFixedPoint("0.000000"))
            .setStatusId("ITEM_COMPLETED")
            .setUnitListPrice(getCurrency("0.00"))
            .setUnitPrice(getCurrency("24.00"))
            .build();
    }


    public static OrderItemShipGroupAssocData OrderItemShipGroupAssoc_Demo1001_00001_00001() {
        return OrderItemShipGroupAssocData.newBuilder()
            .setOrderId("Demo1001")
            .setOrderItemSeqId("00001")
            .setQuantity(getFixedPoint("2.000000"))
            .setShipGroupSeqId("00001")
            .build();
    }


    public static OrderItemPriceInfoData OrderItemPriceInfo_9001() {
        return OrderItemPriceInfoData.newBuilder()
            .setDescription("SupplierProduct [minimumOrderQuantity:0.000000, lastPrice: 24.000]")
            .setOrderId("Demo1001")
            .setOrderItemPriceInfoId("9001")
            .setOrderItemSeqId("00001")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1001_Company_BILL_TO_CUSTOMER() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1001")
            .setPartyId("Company")
            .setRoleTypeId("BILL_TO_CUSTOMER")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1001_DemoSupplier_BILL_FROM_VENDOR() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1001")
            .setPartyId("DemoSupplier")
            .setRoleTypeId("BILL_FROM_VENDOR")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1001_DemoSupplier_SHIP_FROM_VENDOR() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1001")
            .setPartyId("DemoSupplier")
            .setRoleTypeId("SHIP_FROM_VENDOR")
            .build();
    }


    public static OrderRoleData OrderRole_Demo1001_DemoSupplier_SUPPLIER_AGENT() {
        return OrderRoleData.newBuilder()
            .setOrderId("Demo1001")
            .setPartyId("DemoSupplier")
            .setRoleTypeId("SUPPLIER_AGENT")
            .build();
    }

}
