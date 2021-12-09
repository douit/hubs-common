package com.bluecc.income.procs;

import com.bluecc.hubs.stub.*;
import com.bluecc.income.dao.ShipmentDelegator;

import java.math.BigDecimal;

import static com.bluecc.hubs.ProtoTypes.*;

public class Shipments extends ShipmentDelegator {

    public ShipmentFlatData createShipment(String partyFrom,
                                           OrderHeaderFlatData order,
                                           CommonData.ShipmentDestination destination) {
        return ShipmentFlatData.newBuilder()
                .setCreatedDate(nowTimestamp())
                .setDestinationContactMechId(destination.getContactMechId())
                .setDestinationFacilityId(destination.getFacilityId())
                .setDestinationTelecomNumberId(destination.getTelecomNumberId())
                .setEstimatedShipCost(getCurrency("0.00"))
                .setPartyIdFrom(partyFrom)
                .setPrimaryOrderId(order.getOrderId())
                .setPrimaryShipGroupSeqId("00001")
                .setShipmentId(sequence.nextStringId())
                .setShipmentTypeId("PURCHASE_SHIPMENT")
                .setStatusId("SHIPMENT_INPUT")
                .build();
    }

    public ShipmentReceiptData createShipmentReceipt(
            ShipmentFlatData shipment,
            OrderItemFlatData orderItem,
            InventoryItemFlatData inventoryItem,
            BigDecimal quantityAccepted,
            BigDecimal quantityRejected) {
        return ShipmentReceiptData.newBuilder()
                .setDatetimeReceived(nowTimestamp())
                .setInventoryItemId(inventoryItem.getInventoryItemId())
                .setOrderId(orderItem.getOrderId())
                .setOrderItemSeqId(orderItem.getOrderItemSeqId())
                .setProductId(orderItem.getProductId())
                .setQuantityAccepted(getFixedPoint(quantityAccepted))
                .setQuantityRejected(getFixedPoint(quantityRejected))
                .setReceiptId(sequence.nextStringId())
                .setShipmentId(shipment.getShipmentId())
                .build();
    }


    public OrderItemBillingData createOrderItemBilling(
            InvoiceItemFlatData invoiceItem,
            OrderItemFlatData orderItem,
            ShipmentReceiptData shipmentReceipt,
            BigDecimal amount) {
        return OrderItemBillingData.newBuilder()
                .setAmount(getCurrency(amount))
                .setInvoiceId(invoiceItem.getInvoiceId())
                .setInvoiceItemSeqId(invoiceItem.getInvoiceItemSeqId())
                .setOrderId(orderItem.getOrderId())
                .setOrderItemSeqId(orderItem.getOrderItemSeqId())
                .setQuantity(getFixedPoint("1.000000"))
                .setShipmentReceiptId(shipmentReceipt.getReceiptId())
                .build();
    }


    public AcctgTransData postAcctgTrans(ShipmentFlatData shipment) {
        return AcctgTransData.newBuilder()
                .setAcctgTransId(sequence.nextStringId())
                .setAcctgTransTypeId("SHIPMENT_RECEIPT")
                .setGlFiscalTypeId("ACTUAL")
                .setIsPosted(castIndicator("Y"))
                .setPartyId(shipment.getPartyIdFrom())
                .setPostedDate(nowTimestamp())
                .setShipmentId(shipment.getShipmentId())
                .setTransactionDate(nowTimestamp())
                .build();
    }


    public static ShipmentStatusData addShipmentStatus(ShipmentFlatData shipment,
                                                          String statusId) {
        return ShipmentStatusData.newBuilder()
                .setShipmentId(shipment.getShipmentId())
                .setStatusDate(nowTimestamp())
                .setStatusId(statusId)
                .build();
    }

    public void setShipmentStatus(ShipmentFlatData shipment, String statusId){
        process(c ->{
            ShipmentStatusData statusData=addShipmentStatus(shipment, statusId);
            create(c, statusData);
            update(c, ShipmentFlatData.newBuilder()
                    .setShipmentId(shipment.getShipmentId())
                    .setStatusId(statusId)
                    .build());
        });
    }
}
