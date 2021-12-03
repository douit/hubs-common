package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.OrderItemBillingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemBilling implements IEventModel<OrderItemBillingData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String orderId;
    String orderItemSeqId;
    String invoiceId;
    String invoiceItemSeqId;
    String itemIssuanceId;
    String shipmentReceiptId;
    java.math.BigDecimal quantity;
    java.math.BigDecimal amount;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemBillingData.Builder toDataBuilder() {
        OrderItemBillingData.Builder builder = OrderItemBillingData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceItemSeqId != null) {
            builder.setInvoiceItemSeqId(invoiceItemSeqId);
        }
        if (itemIssuanceId != null) {
            builder.setItemIssuanceId(itemIssuanceId);
        }
        if (shipmentReceiptId != null) {
            builder.setShipmentReceiptId(shipmentReceiptId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static OrderItemBilling fromData(OrderItemBillingData data) {
        return OrderItemBilling.builder()
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .invoiceId(data.getInvoiceId())
                .invoiceItemSeqId(data.getInvoiceItemSeqId())
                .itemIssuanceId(data.getItemIssuanceId())
                .shipmentReceiptId(data.getShipmentReceiptId())
                .quantity(getBigDecimal(data.getQuantity()))
                .amount(getBigDecimal(data.getAmount()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
