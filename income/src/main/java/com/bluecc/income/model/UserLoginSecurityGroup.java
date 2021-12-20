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

import com.bluecc.hubs.stub.UserLoginSecurityGroupData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = UserLoginSecurityGroupData.class,
        symbol = EntityNames.UserLoginSecurityGroup)
public class UserLoginSecurityGroup implements IEventModel<UserLoginSecurityGroupData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("user_login_id")
	@RIndex 
    String userLoginId;
    @SerializedName("group_id")
	@RIndex 
    String groupId;
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

    public UserLoginSecurityGroupData.Builder toDataBuilder() {
        UserLoginSecurityGroupData.Builder builder = UserLoginSecurityGroupData.newBuilder();
        if (getUserLoginId() != null) {
            builder.setUserLoginId(getUserLoginId());
        }
        if (getGroupId() != null) {
            builder.setGroupId(getGroupId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
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

    public static UserLoginSecurityGroup fromData(UserLoginSecurityGroupData data) {
        return fromPrototype(data).build();
    }

    public static UserLoginSecurityGroup.UserLoginSecurityGroupBuilder fromPrototype(UserLoginSecurityGroupData data) {
        return UserLoginSecurityGroup.builder()
                .userLoginId(data.getUserLoginId())
                .groupId(data.getGroupId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: userLoginId, groupId, fromDate

-- fields --
    
    String userLoginId
    String groupId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate

-- relations --
    
    - UserLogin (one, autoRelation: false, keymaps: userLoginId)
    - SecurityGroup (one, autoRelation: false, keymaps: groupId)
    + SecurityGroupPermission (many, autoRelation: false, keymaps: groupId)
*/

