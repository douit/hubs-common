package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.SalesOrderAccounting_DEMO1002.*;

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

public final class SalesOrderAccounting_DEMO1002List {
    public static List<ShipmentRouteSegmentData> shipmentRouteSegmentList() {
        return ImmutableList.of(        
            ShipmentRouteSegment_9996_00001());
    }

    public static List<InvoiceFlatData> invoiceList() {
        return ImmutableList.of(        
            Invoice_8009(),        
            Invoice_8010());
    }

    public static List<InvoiceItemFlatData> invoiceItemList() {
        return ImmutableList.of(        
            InvoiceItem_8009_00001(),        
            InvoiceItem_8009_00002(),        
            InvoiceItem_8009_00003(),        
            InvoiceItem_8009_00004(),        
            InvoiceItem_8009_00005(),        
            InvoiceItem_8009_00006(),        
            InvoiceItem_8009_00007(),        
            InvoiceItem_8009_00008(),        
            InvoiceItem_8009_00009(),        
            InvoiceItem_8010_00001());
    }

    public static List<OrderAdjustmentData> orderAdjustmentList() {
        return ImmutableList.of(        
            OrderAdjustment_8000(),        
            OrderAdjustment_8001(),        
            OrderAdjustment_8002(),        
            OrderAdjustment_8003(),        
            OrderAdjustment_8004(),        
            OrderAdjustment_8005(),        
            OrderAdjustment_8006());
    }

    public static List<ItemIssuanceData> itemIssuanceList() {
        return ImmutableList.of(        
            ItemIssuance_9001(),        
            ItemIssuance_9002());
    }

    public static List<PaymentGatewayResponseData> paymentGatewayResponseList() {
        return ImmutableList.of(        
            PaymentGatewayResponse_9001(),        
            PaymentGatewayResponse_9002());
    }

    public static List<ShipmentItemBillingData> shipmentItemBillingList() {
        return ImmutableList.of(        
            ShipmentItemBilling_9996_00001_8009_00001());
    }

    public static List<OrderPaymentPreferenceData> orderPaymentPreferenceList() {
        return ImmutableList.of(        
            OrderPaymentPreference_9001());
    }

    public static List<OrderContactMechData> orderContactMechList() {
        return ImmutableList.of(        
            OrderContactMech_Demo1002_BILLING_LOCATION_9015(),        
            OrderContactMech_Demo1002_ORDER_EMAIL_9026(),        
            OrderContactMech_Demo1002_SHIPPING_LOCATION_9015());
    }

    public static List<ShipmentPackageRouteSegData> shipmentPackageRouteSegList() {
        return ImmutableList.of(        
            ShipmentPackageRouteSeg_9996_00001_00001());
    }

    public static List<OrderStatusData> orderStatusList() {
        return ImmutableList.of(        
            OrderStatus_8000(),        
            OrderStatus_8001(),        
            OrderStatus_8002(),        
            OrderStatus_8003(),        
            OrderStatus_8004(),        
            OrderStatus_8005(),        
            OrderStatus_8006(),        
            OrderStatus_8007(),        
            OrderStatus_8008(),        
            OrderStatus_8009(),        
            OrderStatus_8010(),        
            OrderStatus_8011(),        
            OrderStatus_8012());
    }

    public static List<ShipmentStatusData> shipmentStatusList() {
        return ImmutableList.of(        
            ShipmentStatus_SHIPMENT_INPUT_9996(),        
            ShipmentStatus_SHIPMENT_PACKED_9996(),        
            ShipmentStatus_SHIPMENT_SHIPPED_9996());
    }

    public static List<OrderRoleData> orderRoleList() {
        return ImmutableList.of(        
            OrderRole_Demo1002_Company_BILL_FROM_VENDOR(),        
            OrderRole_Demo1002_DemoCustomer_BILL_TO_CUSTOMER(),        
            OrderRole_Demo1002_DemoCustomer_END_USER_CUSTOMER(),        
            OrderRole_Demo1002_DemoCustomer_PLACING_CUSTOMER(),        
            OrderRole_Demo1002_DemoCustomer_SHIP_TO_CUSTOMER());
    }

    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DemoCustomer_END_USER_CUSTOMER(),        
            PartyRole_DemoCustomer_SHIP_TO_CUSTOMER(),        
            PartyRole_DemoCustomer_PLACING_CUSTOMER());
    }

    public static List<PaymentApplicationData> paymentApplicationList() {
        return ImmutableList.of(        
            PaymentApplication_9003());
    }

    public static List<OrderHeaderFlatData> orderHeaderList() {
        return ImmutableList.of(        
            OrderHeader_Demo1002());
    }

    public static List<AcctgTransEntryData> acctgTransEntryList() {
        return ImmutableList.of(        
            AcctgTransEntry_9002_00001(),        
            AcctgTransEntry_9002_00002(),        
            AcctgTransEntry_9003_00001(),        
            AcctgTransEntry_9003_00002(),        
            AcctgTransEntry_9004_00001(),        
            AcctgTransEntry_9004_00002(),        
            AcctgTransEntry_9004_00003(),        
            AcctgTransEntry_9004_00004(),        
            AcctgTransEntry_9004_00005(),        
            AcctgTransEntry_9004_00006(),        
            AcctgTransEntry_9004_00007(),        
            AcctgTransEntry_9004_00008(),        
            AcctgTransEntry_9004_00009(),        
            AcctgTransEntry_9004_00010(),        
            AcctgTransEntry_9005_00001(),        
            AcctgTransEntry_9005_00002(),        
            AcctgTransEntry_9006_00001(),        
            AcctgTransEntry_9006_00002(),        
            AcctgTransEntry_9007_00001(),        
            AcctgTransEntry_9007_00002());
    }

    public static List<AcctgTransData> acctgTransList() {
        return ImmutableList.of(        
            AcctgTrans_9002(),        
            AcctgTrans_9003(),        
            AcctgTrans_9004(),        
            AcctgTrans_9005(),        
            AcctgTrans_9006(),        
            AcctgTrans_9007());
    }

    public static List<ShipmentFlatData> shipmentList() {
        return ImmutableList.of(        
            Shipment_9996());
    }

    public static List<OrderItemBillingData> orderItemBillingList() {
        return ImmutableList.of(        
            OrderItemBilling_Demo1002_00001_8009_00001(),        
            OrderItemBilling_Demo1002_00004_8009_00005());
    }

    public static List<ShipmentPackageContentData> shipmentPackageContentList() {
        return ImmutableList.of(        
            ShipmentPackageContent_9996_00001_00001());
    }

    public static List<OrderItemShipGroupData> orderItemShipGroupList() {
        return ImmutableList.of(        
            OrderItemShipGroup_Demo1002_00001());
    }

    public static List<ShipmentItemData> shipmentItemList() {
        return ImmutableList.of(        
            ShipmentItem_9996_00001());
    }

    public static List<OrderAdjustmentBillingData> orderAdjustmentBillingList() {
        return ImmutableList.of(        
            OrderAdjustmentBilling_8000_8009_00007(),        
            OrderAdjustmentBilling_8001_8009_00006(),        
            OrderAdjustmentBilling_8002_8009_00008(),        
            OrderAdjustmentBilling_8003_8009_00009(),        
            OrderAdjustmentBilling_8004_8009_00002(),        
            OrderAdjustmentBilling_8005_8009_00003(),        
            OrderAdjustmentBilling_8006_8009_00004());
    }

    public static List<PaymentFlatData> paymentList() {
        return ImmutableList.of(        
            Payment_8004());
    }

    public static List<ShipmentPackageData> shipmentPackageList() {
        return ImmutableList.of(        
            ShipmentPackage_9996_00001());
    }

    public static List<OrderItemFlatData> orderItemList() {
        return ImmutableList.of(        
            OrderItem_Demo1002_00001(),        
            OrderItem_Demo1002_00004());
    }

    public static List<OrderItemShipGroupAssocData> orderItemShipGroupAssocList() {
        return ImmutableList.of(        
            OrderItemShipGroupAssoc_Demo1002_00001_00001(),        
            OrderItemShipGroupAssoc_Demo1002_00004_00001());
    }

}
