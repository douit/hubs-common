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

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.OrderAdjustmentBillingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderAdjustmentBillingData.class,
        symbol = EntityNames.OrderAdjustmentBilling)
public class OrderAdjustmentBilling implements IEventModel<OrderAdjustmentBillingData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String orderAdjustmentId;
    @RIndex String invoiceId;
    @RIndex String invoiceItemSeqId;
    java.math.BigDecimal amount;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
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


/*
-- keys: orderAdjustmentId, invoiceId, invoiceItemSeqId

-- fields --
    
    String orderAdjustmentId
    String invoiceId
    String invoiceItemSeqId
    java.math.BigDecimal amount

-- relations --
    
    - OrderAdjustment (one, autoRelation: false, keymaps: orderAdjustmentId)
    - Invoice (one-nofk, autoRelation: false, keymaps: invoiceId)
    - InvoiceItem (one, autoRelation: false, keymaps: invoiceId, invoiceItemSeqId)
*/

