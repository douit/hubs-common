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
import com.bluecc.hubs.stub.OrderContactMechData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderContactMech implements IEventModel<OrderContactMechData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String orderId;
    String contactMechPurposeTypeId;
    String contactMechId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderContactMechData.Builder toDataBuilder() {
        OrderContactMechData.Builder builder = OrderContactMechData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (contactMechPurposeTypeId != null) {
            builder.setContactMechPurposeTypeId(contactMechPurposeTypeId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
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

    public static OrderContactMech fromData(OrderContactMechData data) {
        return OrderContactMech.builder()
                .orderId(data.getOrderId())
                .contactMechPurposeTypeId(data.getContactMechPurposeTypeId())
                .contactMechId(data.getContactMechId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
