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

import com.bluecc.hubs.stub.ShipmentStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ShipmentStatusData.class,
        symbol = EntityNames.ShipmentStatus)
public class ShipmentStatus implements IEventModel<ShipmentStatusData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("status_id")
	@RIndex 
    String statusId;
    @SerializedName("shipment_id")
	@RIndex 
    String shipmentId;
    @SerializedName("status_date") 
    java.time.LocalDateTime statusDate;
    @SerializedName("change_by_user_login_id") 
    String changeByUserLoginId;
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

    public ShipmentStatusData.Builder toDataBuilder() {
        ShipmentStatusData.Builder builder = ShipmentStatusData.newBuilder();
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (shipmentId != null) {
            builder.setShipmentId(shipmentId);
        }
        if (statusDate != null) {
            builder.setStatusDate(getTimestamp(statusDate));
        }
        if (changeByUserLoginId != null) {
            builder.setChangeByUserLoginId(changeByUserLoginId);
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

    public static ShipmentStatus fromData(ShipmentStatusData data) {
        return ShipmentStatus.builder()
                .statusId(data.getStatusId())
                .shipmentId(data.getShipmentId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: statusId, shipmentId

-- fields --
    
    String statusId
    String shipmentId
    java.time.LocalDateTime statusDate
    String changeByUserLoginId

-- relations --
    
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - Shipment (one, autoRelation: false, keymaps: shipmentId)
    - ChangeByUserLogin (one, autoRelation: false, keymaps: changeByUserLoginId -> userLoginId)
*/

