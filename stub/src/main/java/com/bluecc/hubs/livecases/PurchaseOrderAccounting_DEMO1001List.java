package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.PurchaseOrderAccounting_DEMO1001.*;

import com.bluecc.hubs.stub.InventoryItemFlatData;
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

public final class PurchaseOrderAccounting_DEMO1001List {
    public static List<InventoryItemFlatData> inventoryItemList() {
        return ImmutableList.of(        
            InventoryItem_9025());
    }

    public static List<OrderHeaderFlatData> orderHeaderList() {
        return ImmutableList.of(        
            OrderHeader_Demo1001());
    }

    public static List<ShipmentRouteSegmentData> shipmentRouteSegmentList() {
        return ImmutableList.of(        
            ShipmentRouteSegment_9997_00001());
    }

    public static List<InvoiceFlatData> invoiceList() {
        return ImmutableList.of(        
            Invoice_8008());
    }

    public static List<InvoiceItemFlatData> invoiceItemList() {
        return ImmutableList.of(        
            InvoiceItem_8008_00001());
    }

    public static List<AcctgTransEntryData> acctgTransEntryList() {
        return ImmutableList.of(        
            AcctgTransEntry_9000_00001(),        
            AcctgTransEntry_9000_00002(),        
            AcctgTransEntry_9001_00001(),        
            AcctgTransEntry_9001_00002());
    }

    public static List<ShipmentReceiptData> shipmentReceiptList() {
        return ImmutableList.of(        
            ShipmentReceipt_9000());
    }

    public static List<AcctgTransData> acctgTransList() {
        return ImmutableList.of(        
            AcctgTrans_9000(),        
            AcctgTrans_9001());
    }

    public static List<ShipmentFlatData> shipmentList() {
        return ImmutableList.of(        
            Shipment_9997());
    }

    public static List<InventoryItemDetailData> inventoryItemDetailList() {
        return ImmutableList.of(        
            InventoryItemDetail_9025_00001());
    }

    public static List<OrderItemBillingData> orderItemBillingList() {
        return ImmutableList.of(        
            OrderItemBilling_Demo1001_00001_8008_00001());
    }

    public static List<ShipmentPackageContentData> shipmentPackageContentList() {
        return ImmutableList.of(        
            ShipmentPackageContent_9997_00001_00001());
    }

    public static List<ItemIssuanceData> itemIssuanceList() {
        return ImmutableList.of(        
            ItemIssuance_9000());
    }

    public static List<OrderItemShipGroupData> orderItemShipGroupList() {
        return ImmutableList.of(        
            OrderItemShipGroup_Demo1001_00001());
    }

    public static List<ShipmentItemData> shipmentItemList() {
        return ImmutableList.of(        
            ShipmentItem_9997_00001());
    }

    public static List<OrderContactMechData> orderContactMechList() {
        return ImmutableList.of(        
            OrderContactMech_Demo1001_SHIPPING_LOCATION_9200());
    }

    public static List<ShipmentPackageRouteSegData> shipmentPackageRouteSegList() {
        return ImmutableList.of(        
            ShipmentPackageRouteSeg_9997_00001_00001());
    }

    public static List<OrderStatusData> orderStatusList() {
        return ImmutableList.of(        
            OrderStatus_9009(),        
            OrderStatus_9010(),        
            OrderStatus_9011(),        
            OrderStatus_9012(),        
            OrderStatus_9013(),        
            OrderStatus_9014());
    }

    public static List<ShipmentStatusData> shipmentStatusList() {
        return ImmutableList.of(        
            ShipmentStatus_PURCH_SHIP_CREATED_9997(),        
            ShipmentStatus_PURCH_SHIP_RECEIVED_9997(),        
            ShipmentStatus_PURCH_SHIP_SHIPPED_9997());
    }

    public static List<ShipmentPackageData> shipmentPackageList() {
        return ImmutableList.of(        
            ShipmentPackage_9997_00001());
    }

    public static List<OrderItemFlatData> orderItemList() {
        return ImmutableList.of(        
            OrderItem_Demo1001_00001());
    }

    public static List<OrderItemShipGroupAssocData> orderItemShipGroupAssocList() {
        return ImmutableList.of(        
            OrderItemShipGroupAssoc_Demo1001_00001_00001());
    }

    public static List<OrderItemPriceInfoData> orderItemPriceInfoList() {
        return ImmutableList.of(        
            OrderItemPriceInfo_9001());
    }

    public static List<OrderRoleData> orderRoleList() {
        return ImmutableList.of(        
            OrderRole_Demo1001_Company_BILL_TO_CUSTOMER(),        
            OrderRole_Demo1001_DemoSupplier_BILL_FROM_VENDOR(),        
            OrderRole_Demo1001_DemoSupplier_SHIP_FROM_VENDOR(),        
            OrderRole_Demo1001_DemoSupplier_SUPPLIER_AGENT());
    }

}
