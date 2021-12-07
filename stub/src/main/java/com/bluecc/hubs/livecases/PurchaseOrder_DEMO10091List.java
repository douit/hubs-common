package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.PurchaseOrder_DEMO10091.*;

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

public final class PurchaseOrder_DEMO10091List {
    public static List<OrderHeaderFlatData> orderHeaderList() {
        return ImmutableList.of(        
            OrderHeader_DEMO10091());
    }

    public static List<ShipmentFlatData> shipmentList() {
        return ImmutableList.of(        
            Shipment_9999());
    }

    public static List<ItemIssuanceData> itemIssuanceList() {
        return ImmutableList.of(        
            ItemIssuance_9003());
    }

    public static List<OrderItemShipGroupData> orderItemShipGroupList() {
        return ImmutableList.of(        
            OrderItemShipGroup_DEMO10091_00001());
    }

    public static List<ShipmentItemData> shipmentItemList() {
        return ImmutableList.of(        
            ShipmentItem_9999_00001());
    }

    public static List<OrderContactMechData> orderContactMechList() {
        return ImmutableList.of(        
            OrderContactMech_DEMO10091_SHIPPING_LOCATION_9200());
    }

    public static List<PaymentFlatData> paymentList() {
        return ImmutableList.of(        
            Payment_9000());
    }

    public static List<OrderStatusData> orderStatusList() {
        return ImmutableList.of(        
            OrderStatus_9007(),        
            OrderStatus_9008());
    }

    public static List<OrderItemFlatData> orderItemList() {
        return ImmutableList.of(        
            OrderItem_DEMO10091_00001());
    }

    public static List<OrderItemShipGroupAssocData> orderItemShipGroupAssocList() {
        return ImmutableList.of(        
            OrderItemShipGroupAssoc_DEMO10091_00001_00001());
    }

    public static List<OrderItemPriceInfoData> orderItemPriceInfoList() {
        return ImmutableList.of(        
            OrderItemPriceInfo_10001(),        
            OrderItemPriceInfo_10002());
    }

    public static List<OrderRoleData> orderRoleList() {
        return ImmutableList.of(        
            OrderRole_DEMO10091_Company_BILL_TO_CUSTOMER(),        
            OrderRole_DEMO10091_DemoSupplier_BILL_FROM_VENDOR(),        
            OrderRole_DEMO10091_DemoSupplier_SHIP_FROM_VENDOR(),        
            OrderRole_DEMO10091_DemoSupplier_SUPPLIER_AGENT());
    }

}
