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

import com.bluecc.hubs.stub.OrderContactMechData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderContactMechData.class,
        symbol = EntityNames.OrderContactMech)
public class OrderContactMech implements IEventModel<OrderContactMechData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_id")
	@RIndex 
    String orderId;
    @SerializedName("contact_mech_purpose_type_id")
	@RIndex 
    String contactMechPurposeTypeId;
    @SerializedName("contact_mech_id")
	@RIndex 
    String contactMechId;
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

    public OrderContactMechData.Builder toDataBuilder() {
        OrderContactMechData.Builder builder = OrderContactMechData.newBuilder();
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getContactMechPurposeTypeId() != null) {
            builder.setContactMechPurposeTypeId(getContactMechPurposeTypeId());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
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

    public static OrderContactMech fromData(OrderContactMechData data) {
        return fromPrototype(data).build();
    }

    public static OrderContactMech.OrderContactMechBuilder fromPrototype(OrderContactMechData data) {
        return OrderContactMech.builder()
                .orderId(data.getOrderId())
                .contactMechPurposeTypeId(data.getContactMechPurposeTypeId())
                .contactMechId(data.getContactMechId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: orderId, contactMechPurposeTypeId, contactMechId

-- fields --
    
    String orderId
    String contactMechPurposeTypeId
    String contactMechId

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - ContactMechPurposeType (one, autoRelation: false, keymaps: contactMechPurposeTypeId)
*/

