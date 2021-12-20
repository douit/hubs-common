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

import com.bluecc.hubs.stub.BudgetStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = BudgetStatusData.class,
        symbol = EntityNames.BudgetStatus)
public class BudgetStatus implements IEventModel<BudgetStatusData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("budget_id")
	@RIndex 
    String budgetId;
    @SerializedName("status_id")
	@RIndex 
    String statusId;
    @SerializedName("status_date") 
    java.time.LocalDateTime statusDate;
    @SerializedName("comments") 
    String comments;
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

    public BudgetStatusData.Builder toDataBuilder() {
        BudgetStatusData.Builder builder = BudgetStatusData.newBuilder();
        if (getBudgetId() != null) {
            builder.setBudgetId(getBudgetId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getStatusDate() != null) {
            builder.setStatusDate(getTimestamp(getStatusDate()));
        }
        if (getComments() != null) {
            builder.setComments(getComments());
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

    public static BudgetStatus fromData(BudgetStatusData data) {
        return fromPrototype(data).build();
    }

    public static BudgetStatus.BudgetStatusBuilder fromPrototype(BudgetStatusData data) {
        return BudgetStatus.builder()
                .budgetId(data.getBudgetId())
                .statusId(data.getStatusId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .comments(data.getComments())
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                ;
    }

    
}


/*
-- keys: budgetId, statusId

-- fields --
    
    String budgetId
    String statusId
    java.time.LocalDateTime statusDate
    String comments
    String changeByUserLoginId

-- relations --
    
    - Budget (one, autoRelation: false, keymaps: budgetId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - ChangeByUserLogin (one, autoRelation: false, keymaps: changeByUserLoginId -> userLoginId)
*/

