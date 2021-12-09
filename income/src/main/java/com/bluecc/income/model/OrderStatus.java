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

import com.bluecc.hubs.stub.OrderStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class OrderStatus implements IEventModel<OrderStatusData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String orderStatusId;
    String statusId;
    String orderId;
    String orderItemSeqId;
    String orderPaymentPreferenceId;
    java.time.LocalDateTime statusDatetime;
    String statusUserLogin;
    String changeReason;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderStatusData.Builder toDataBuilder() {
        OrderStatusData.Builder builder = OrderStatusData.newBuilder();
        if (orderStatusId != null) {
            builder.setOrderStatusId(orderStatusId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (orderPaymentPreferenceId != null) {
            builder.setOrderPaymentPreferenceId(orderPaymentPreferenceId);
        }
        if (statusDatetime != null) {
            builder.setStatusDatetime(getTimestamp(statusDatetime));
        }
        if (statusUserLogin != null) {
            builder.setStatusUserLogin(statusUserLogin);
        }
        if (changeReason != null) {
            builder.setChangeReason(changeReason);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static OrderStatus fromData(OrderStatusData data) {
        return OrderStatus.builder()
                .orderStatusId(data.getOrderStatusId())
                .statusId(data.getStatusId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .orderPaymentPreferenceId(data.getOrderPaymentPreferenceId())
                .statusDatetime(getLocalDateTime(data.getStatusDatetime()))
                .statusUserLogin(data.getStatusUserLogin())
                .changeReason(data.getChangeReason())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
