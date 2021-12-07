package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.SalesOrder_DEMO10090.*;

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

public final class SalesOrder_DEMO10090List {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DemoCustomer_END_USER_CUSTOMER(),        
            PartyRole_DemoCustomer_SHIP_TO_CUSTOMER(),        
            PartyRole_DemoCustomer_PLACING_CUSTOMER());
    }

    public static List<OrderHeaderFlatData> orderHeaderList() {
        return ImmutableList.of(        
            OrderHeader_DEMO10090());
    }

    public static List<OrderAdjustmentData> orderAdjustmentList() {
        return ImmutableList.of(        
            OrderAdjustment_9000(),        
            OrderAdjustment_9001());
    }

    public static List<ShipmentFlatData> shipmentList() {
        return ImmutableList.of(        
            Shipment_9998());
    }

    public static List<OrderItemShipGroupData> orderItemShipGroupList() {
        return ImmutableList.of(        
            OrderItemShipGroup_DEMO10090_00001());
    }

    public static List<PaymentGatewayResponseData> paymentGatewayResponseList() {
        return ImmutableList.of(        
            PaymentGatewayResponse_9000());
    }

    public static List<OrderPaymentPreferenceData> orderPaymentPreferenceList() {
        return ImmutableList.of(        
            OrderPaymentPreference_9000());
    }

    public static List<OrderItemShipGrpInvResData> orderItemShipGrpInvResList() {
        return ImmutableList.of(        
            OrderItemShipGrpInvRes_DEMO10090_00001_00001_9001());
    }

    public static List<OrderContactMechData> orderContactMechList() {
        return ImmutableList.of(        
            OrderContactMech_DEMO10090_BILLING_LOCATION_9015(),        
            OrderContactMech_DEMO10090_ORDER_EMAIL_9026(),        
            OrderContactMech_DEMO10090_SHIPPING_LOCATION_9015());
    }

    public static List<OrderStatusData> orderStatusList() {
        return ImmutableList.of(        
            OrderStatus_9000(),        
            OrderStatus_9001(),        
            OrderStatus_9002(),        
            OrderStatus_9003(),        
            OrderStatus_9004(),        
            OrderStatus_9005());
    }

    public static List<OrderItemFlatData> orderItemList() {
        return ImmutableList.of(        
            OrderItem_DEMO10090_00001());
    }

    public static List<OrderItemShipGroupAssocData> orderItemShipGroupAssocList() {
        return ImmutableList.of(        
            OrderItemShipGroupAssoc_DEMO10090_00001_00001());
    }

    public static List<OrderItemPriceInfoData> orderItemPriceInfoList() {
        return ImmutableList.of(        
            OrderItemPriceInfo_9000());
    }

    public static List<OrderRoleData> orderRoleList() {
        return ImmutableList.of(        
            OrderRole_DEMO10090_Company_BILL_FROM_VENDOR(),        
            OrderRole_DEMO10090_DemoCustomer_BILL_TO_CUSTOMER(),        
            OrderRole_DEMO10090_DemoCustomer_END_USER_CUSTOMER(),        
            OrderRole_DEMO10090_DemoCustomer_PLACING_CUSTOMER(),        
            OrderRole_DEMO10090_DemoCustomer_SHIP_TO_CUSTOMER());
    }

}
