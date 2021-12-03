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
import com.bluecc.hubs.stub.OrderAdjustmentBillingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderAdjustmentBilling implements IEventModel<OrderAdjustmentBillingData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String orderAdjustmentId;
    String invoiceId;
    String invoiceItemSeqId;
    java.math.BigDecimal amount;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderAdjustmentBillingData.Builder toDataBuilder() {
        OrderAdjustmentBillingData.Builder builder = OrderAdjustmentBillingData.newBuilder();
        if (orderAdjustmentId != null) {
            builder.setOrderAdjustmentId(orderAdjustmentId);
        }
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceItemSeqId != null) {
            builder.setInvoiceItemSeqId(invoiceItemSeqId);
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

    public static OrderAdjustmentBilling fromData(OrderAdjustmentBillingData data) {
        return OrderAdjustmentBilling.builder()
                .orderAdjustmentId(data.getOrderAdjustmentId())
                .invoiceId(data.getInvoiceId())
                .invoiceItemSeqId(data.getInvoiceItemSeqId())
                .amount(getBigDecimal(data.getAmount()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
