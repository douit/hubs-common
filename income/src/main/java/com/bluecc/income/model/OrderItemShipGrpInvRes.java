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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.OrderItemShipGrpInvResData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class OrderItemShipGrpInvRes implements IEventModel<OrderItemShipGrpInvResData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String orderId;
    @RIndex String shipGroupSeqId;
    @RIndex String orderItemSeqId;
    @RIndex String inventoryItemId;
    String reserveOrderEnumId;
    java.math.BigDecimal quantity;
    java.math.BigDecimal quantityNotAvailable;
    java.time.LocalDateTime reservedDatetime;
    java.time.LocalDateTime createdDatetime;
    java.time.LocalDateTime promisedDatetime;
    java.time.LocalDateTime currentPromisedDate;
    Character priority;
    Long sequenceId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderItemShipGrpInvResData.Builder toDataBuilder() {
        OrderItemShipGrpInvResData.Builder builder = OrderItemShipGrpInvResData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (reserveOrderEnumId != null) {
            builder.setReserveOrderEnumId(reserveOrderEnumId);
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (quantityNotAvailable != null) {
            builder.setQuantityNotAvailable(getFixedPoint(quantityNotAvailable));
        }
        if (reservedDatetime != null) {
            builder.setReservedDatetime(getTimestamp(reservedDatetime));
        }
        if (createdDatetime != null) {
            builder.setCreatedDatetime(getTimestamp(createdDatetime));
        }
        if (promisedDatetime != null) {
            builder.setPromisedDatetime(getTimestamp(promisedDatetime));
        }
        if (currentPromisedDate != null) {
            builder.setCurrentPromisedDate(getTimestamp(currentPromisedDate));
        }
        if (priority != null) {
            builder.setPriority(getIndicator(priority));
        }
        if (sequenceId != null) {
            builder.setSequenceId(sequenceId);
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

    public static OrderItemShipGrpInvRes fromData(OrderItemShipGrpInvResData data) {
        return OrderItemShipGrpInvRes.builder()
                .orderId(data.getOrderId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .inventoryItemId(data.getInventoryItemId())
                .reserveOrderEnumId(data.getReserveOrderEnumId())
                .quantity(getBigDecimal(data.getQuantity()))
                .quantityNotAvailable(getBigDecimal(data.getQuantityNotAvailable()))
                .reservedDatetime(getLocalDateTime(data.getReservedDatetime()))
                .createdDatetime(getLocalDateTime(data.getCreatedDatetime()))
                .promisedDatetime(getLocalDateTime(data.getPromisedDatetime()))
                .currentPromisedDate(getLocalDateTime(data.getCurrentPromisedDate()))
                .priority(getIndicatorChar(data.getPriority()))
                .sequenceId(data.getSequenceId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
