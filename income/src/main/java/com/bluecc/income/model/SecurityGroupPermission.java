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

import com.bluecc.hubs.stub.SecurityGroupPermissionData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = SecurityGroupPermissionData.class,
        symbol = EntityNames.SecurityGroupPermission)
public class SecurityGroupPermission implements IEventModel<SecurityGroupPermissionData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("group_id")
	@RIndex 
    String groupId;
    @SerializedName("permission_id")
	@RIndex 
    String permissionId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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

    public SecurityGroupPermissionData.Builder toDataBuilder() {
        SecurityGroupPermissionData.Builder builder = SecurityGroupPermissionData.newBuilder();
        if (groupId != null) {
            builder.setGroupId(groupId);
        }
        if (permissionId != null) {
            builder.setPermissionId(permissionId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
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

    public static SecurityGroupPermission fromData(SecurityGroupPermissionData data) {
        return SecurityGroupPermission.builder()
                .groupId(data.getGroupId())
                .permissionId(data.getPermissionId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: groupId, permissionId, fromDate

-- fields --
    
    String groupId
    String permissionId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - SecurityGroup (one, autoRelation: false, keymaps: groupId)
    - SecurityPermission (one-nofk, autoRelation: false, keymaps: permissionId)
*/

