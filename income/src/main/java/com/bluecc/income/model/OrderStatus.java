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

import com.bluecc.hubs.stub.OrderStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderStatusData.class,
        symbol = EntityNames.OrderStatus)
public class OrderStatus implements IEventModel<OrderStatusData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_status_id")
	@RId 
    String orderStatusId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("order_payment_preference_id") 
    String orderPaymentPreferenceId;
    @SerializedName("status_datetime") 
    java.time.LocalDateTime statusDatetime;
    @SerializedName("status_user_login") 
    String statusUserLogin;
    @SerializedName("change_reason") 
    String changeReason;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return orderStatusId;
    }

        
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


/*
-- keys: orderStatusId

-- fields --
    
    String orderStatusId
    String statusId
    String orderId
    String orderItemSeqId
    String orderPaymentPreferenceId
    java.time.LocalDateTime statusDatetime
    String statusUserLogin
    String changeReason

-- relations --
    
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - OrderItem (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - OrderPaymentPreference (one-nofk, autoRelation: false, keymaps: orderPaymentPreferenceId)
    - UserLogin (one, autoRelation: false, keymaps: statusUserLogin -> userLoginId)
*/

