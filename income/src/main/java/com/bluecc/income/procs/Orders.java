package com.bluecc.income.procs;

import com.bluecc.hubs.ProtoTypes;
import com.bluecc.hubs.stub.*;
import com.bluecc.income.dao.OrderHeaderDelegator;
import com.bluecc.income.model.OrderHeader;
import com.bluecc.income.procs.CommonData.PartyFromTo;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.bluecc.hubs.ProtoTypes.*;
import static com.bluecc.hubs.ProtoTypes.getCurrency;

public class Orders extends OrderHeaderDelegator {

    public OrderHeaderFlatData createOrderHeader() {
        return OrderHeaderFlatData.newBuilder()
                .setCreatedBy("admin")
                .setCurrencyUom("USD")
                .setEntryDate(getTimestamp("2009-08-17 14:23:49.475"))
                .setGrandTotal(getCurrency("127.09"))
                .setOrderDate(getTimestamp("2009-08-17 14:23:49.475"))
                .setOrderId(sequence.nextStringId())
                .setOrderName("Demo Sales Order")
                .setOrderTypeId("SALES_ORDER")
                .setPriority(castIndicator("2"))
                .setProductStoreId("9000")
                .setRemainingSubTotal(getCurrency("107.98"))
                .setSalesChannelEnumId("WEB_SALES_CHANNEL")
                .setStatusId("ORDER_CREATED")
                .setVisitId("10000")
                .setWebSiteId("WebStore")
                .build();
    }

    public OrderItemFlatData addOrderItem(OrderHeaderFlatData order,
                                                 String seqId,
                                                 String productId) {
        return OrderItemFlatData.newBuilder()
                .setIsModifiedPrice(castIndicator("N"))
                .setIsPromo(castIndicator("N"))
                .setItemDescription("Micro Chrome Widget")
                .setOrderId(order.getOrderId())
                .setOrderItemSeqId(seqId)
                .setOrderItemTypeId("PRODUCT_ORDER_ITEM")
                .setProdCatalogId("DemoCatalog")
                .setProductId(productId)
                .setQuantity(getFixedPoint("2.000000"))
                .setSelectedAmount(getFixedPoint("0.000000"))
                .setStatusId("ITEM_COMPLETED")
                .setUnitListPrice(getCurrency("60.00"))
                .setUnitPrice(getCurrency("59.99"))
                .build();
    }

    public InvoiceFlatData createInvoice(PartyFromTo fromTo, LocalDateTime paidDate) {
        return InvoiceFlatData.newBuilder()
                .setCurrencyUomId("USD")
                .setInvoiceDate(getTimestamp(LocalDateTime.now()))
                .setInvoiceId(sequence.nextStringId())
                .setInvoiceTypeId("SALES_INVOICE")
                .setPaidDate(getTimestamp(paidDate))
                .setPartyId(fromTo.from)
                .setPartyIdFrom(fromTo.to)
                .setStatusId("INVOICE_PAID")
                .build();
    }

    public InvoiceItemFlatData addInvoiceItem(InvoiceFlatData invoice,
                                                     String seqId,
                                                     String inventoryItemId,
                                                     BigDecimal amount,
                                                     BigDecimal quantity) {
        return InvoiceItemFlatData.newBuilder()
                .setAmount(getCurrency(amount))
                .setDescription("Micro Chrome Widget")
                .setInventoryItemId(inventoryItemId)
                .setInvoiceId(invoice.getInvoiceId())
                .setInvoiceItemSeqId(seqId)
                .setInvoiceItemTypeId("INV_FPROD_ITEM")
                .setProductId("WG-1111")
                .setQuantity(getFixedPoint(quantity))
                .build();
    }

    public static OrderItemBillingData addOrderItemBilling(
            OrderItemFlatData orderItem,
            InvoiceItemFlatData invoiceItem,
            ItemIssuanceData itemIssuance) {
        return OrderItemBillingData.newBuilder()
                .setAmount(getCurrency(calcAmount(orderItem.getUnitPrice(),
                        orderItem.getQuantity())))
                .setInvoiceId(invoiceItem.getInvoiceId())
                .setInvoiceItemSeqId(invoiceItem.getInvoiceItemSeqId())
                .setItemIssuanceId(itemIssuance.getItemIssuanceId())
                .setOrderId(orderItem.getOrderId())
                .setOrderItemSeqId(orderItem.getOrderItemSeqId())
                .setQuantity(orderItem.getQuantity())
                .build();
    }

    public ShipmentFlatData createShipment(PartyFromTo fromTo,
                                           OrderHeaderFlatData order,
                                           BigDecimal estimatedShipCost) {
        return ShipmentFlatData.newBuilder()
                .setCreatedDate(getTimestamp(LocalDateTime.now()))
                .setDestinationContactMechId("9015")
                .setDestinationTelecomNumberId("9025")
                .setEstimatedShipCost(getCurrency(estimatedShipCost))
                .setOriginContactMechId("9200")
                .setOriginFacilityId("WebStoreWarehouse")
                .setOriginTelecomNumberId("9201")
                .setPartyIdFrom(fromTo.from)
                .setPartyIdTo(fromTo.to)
                .setPrimaryOrderId(order.getOrderId())
                .setPrimaryShipGroupSeqId("00001")
                .setShipmentId(sequence.nextStringId())
                .setShipmentTypeId("SALES_SHIPMENT")
                .setStatusId("SHIPMENT_SHIPPED")
                .build();
    }

    public static ShipmentItemData addShipmentItem(ShipmentFlatData shipment,
                                                   String seqId,
                                                   BigDecimal quantity) {
        return ShipmentItemData.newBuilder()
                .setProductId("WG-1111")
                .setQuantity(getFixedPoint(quantity))
                .setShipmentId(shipment.getShipmentId())
                .setShipmentItemSeqId(seqId)
                .build();
    }

    private static BigDecimal calcAmount(Currency unitPrice, FixedPoint quantity) {
        return getBigDecimal(unitPrice).multiply(getBigDecimal(quantity));
    }

    public OrderStatusData addOrderStatus(OrderHeaderFlatData order, String statusId) {
        return OrderStatusData.newBuilder()
                .setOrderId(order.getOrderId())
                .setOrderStatusId(sequence.nextStringId())
                .setStatusDatetime(getTimestamp(LocalDateTime.now()))
                .setStatusId(statusId)
                .setStatusUserLogin("admin")
                .build();
    }

    public void setOrderStatus(OrderHeaderFlatData order, String statusId){
        process(c ->{
            OrderStatusData statusData=addOrderStatus(order, statusId);
            create(c, statusData);
            // OrderHeader orderHeader=findOne(c, order, OrderHeader.class);
            // orderHeader.setStatusId(statusId); // StatusItem
            update(c, OrderHeaderFlatData.newBuilder()
                    .setOrderId(order.getOrderId())
                    .setStatusId(statusId)
                    .build());
        });
    }
}
