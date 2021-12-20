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

import com.bluecc.hubs.stub.FinAccountStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FinAccountStatusData.class,
        symbol = EntityNames.FinAccountStatus)
public class FinAccountStatus implements IEventModel<FinAccountStatusData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("fin_account_id")
	@RIndex 
    String finAccountId;
    @SerializedName("status_id")
	@RIndex 
    String statusId;
    @SerializedName("status_date") 
    java.time.LocalDateTime statusDate;
    @SerializedName("status_end_date") 
    java.time.LocalDateTime statusEndDate;
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

    public FinAccountStatusData.Builder toDataBuilder() {
        FinAccountStatusData.Builder builder = FinAccountStatusData.newBuilder();
        if (getFinAccountId() != null) {
            builder.setFinAccountId(getFinAccountId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getStatusDate() != null) {
            builder.setStatusDate(getTimestamp(getStatusDate()));
        }
        if (getStatusEndDate() != null) {
            builder.setStatusEndDate(getTimestamp(getStatusEndDate()));
        }
        if (getChangeByUserLoginId() != null) {
            builder.setChangeByUserLoginId(getChangeByUserLoginId());
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

    public static FinAccountStatus fromData(FinAccountStatusData data) {
        return fromPrototype(data).build();
    }

    public static FinAccountStatus.FinAccountStatusBuilder fromPrototype(FinAccountStatusData data) {
        return FinAccountStatus.builder()
                .finAccountId(data.getFinAccountId())
                .statusId(data.getStatusId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .statusEndDate(getLocalDateTime(data.getStatusEndDate()))
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: finAccountId, statusId, statusDate

-- fields --
    
    String finAccountId
    String statusId
    java.time.LocalDateTime statusDate
    java.time.LocalDateTime statusEndDate
    String changeByUserLoginId

-- relations --
    
    - FinAccount (one, autoRelation: false, keymaps: finAccountId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - UserLogin (one, autoRelation: false, keymaps: changeByUserLoginId -> userLoginId)
*/

