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

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.OrderRoleData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderRoleData.class,
        symbol = EntityNames.OrderRole)
public class OrderRole implements IEventModel<OrderRoleData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String orderId;
    @RIndex String partyId;
    @RIndex String roleTypeId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderRoleData.Builder toDataBuilder() {
        OrderRoleData.Builder builder = OrderRoleData.newBuilder();
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
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

    public static OrderRole fromData(OrderRoleData data) {
        return OrderRole.builder()
                .orderId(data.getOrderId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: orderId, partyId, roleTypeId

-- fields --
    
    String orderId
    String partyId
    String roleTypeId

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - PartyRole (one, autoRelation: false, keymaps: partyId, roleTypeId)
    - RoleType (one-nofk, autoRelation: false, keymaps: roleTypeId)
    + OrderItem (many, autoRelation: false, keymaps: orderId)
*/

