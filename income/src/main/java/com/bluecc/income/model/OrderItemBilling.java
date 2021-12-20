//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.OrderItemBillingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemBillingData.class,
        symbol = EntityNames.OrderItemBilling)
public class OrderItemBilling implements IEventModel<OrderItemBillingData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_id")
	@RIndex 
    String orderId;
    @SerializedName("order_item_seq_id")
	@RIndex 
    String orderItemSeqId;
    @SerializedName("invoice_id")
	@RIndex 
    String invoiceId;
    @SerializedName("invoice_item_seq_id")
	@RIndex 
    String invoiceItemSeqId;
    @SerializedName("item_issuance_id") 
    String itemIssuanceId;
    @SerializedName("shipment_receipt_id") 
    String shipmentReceiptId;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemBillingData.Builder toDataBuilder() {
        OrderItemBillingData.Builder builder = OrderItemBillingData.newBuilder();
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getInvoiceId() != null) {
            builder.setInvoiceId(getInvoiceId());
        }
        if (getInvoiceItemSeqId() != null) {
            builder.setInvoiceItemSeqId(getInvoiceItemSeqId());
        }
        if (getItemIssuanceId() != null) {
            builder.setItemIssuanceId(getItemIssuanceId());
        }
        if (getShipmentReceiptId() != null) {
            builder.setShipmentReceiptId(getShipmentReceiptId());
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
                    
        return builder;
    }

    public static OrderItemBilling fromData(OrderItemBillingData data) {
        return fromPrototype(data).build();
    }

    public static OrderItemBilling.OrderItemBillingBuilder fromPrototype(OrderItemBillingData data) {
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
                ;
    }

    
}


/*
-- keys: orderId, orderItemSeqId, invoiceId, invoiceItemSeqId

-- fields --
    
    String orderId
    String orderItemSeqId
    String invoiceId
    String invoiceItemSeqId
    String itemIssuanceId
    String shipmentReceiptId
    java.math.BigDecimal quantity
    java.math.BigDecimal amount

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - Invoice (one-nofk, autoRelation: false, keymaps: invoiceId)
    - InvoiceItem (one, autoRelation: false, keymaps: invoiceId, invoiceItemSeqId)
    - ShipmentReceipt (one, autoRelation: false, keymaps: shipmentReceiptId -> receiptId)
    - ItemIssuance (one, autoRelation: false, keymaps: itemIssuanceId)
*/

