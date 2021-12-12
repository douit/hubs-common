package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.OrderItemShipGroupAssocData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderItemShipGroupAssocData.class,
        symbol = EntityNames.OrderItemShipGroupAssoc)
public class OrderItemShipGroupAssoc implements IEventModel<OrderItemShipGroupAssocData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String orderId;
    @RIndex String orderItemSeqId;
    @RIndex String shipGroupSeqId;
    java.math.BigDecimal quantity;
    java.math.BigDecimal cancelQuantity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemShipGroupAssocData.Builder toDataBuilder() {
        OrderItemShipGroupAssocData.Builder builder = OrderItemShipGroupAssocData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (cancelQuantity != null) {
            builder.setCancelQuantity(getFixedPoint(cancelQuantity));
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

    public static OrderItemShipGroupAssoc fromData(OrderItemShipGroupAssocData data) {
        return OrderItemShipGroupAssoc.builder()
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .quantity(getBigDecimal(data.getQuantity()))
                .cancelQuantity(getBigDecimal(data.getCancelQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
