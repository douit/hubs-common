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

import com.bluecc.hubs.stub.BudgetData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = BudgetData.class,
        symbol = EntityNames.Budget)
public class Budget implements IEventModel<BudgetData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("budget_id")
	@RId 
    String budgetId;
    @SerializedName("budget_type_id") 
    String budgetTypeId;
    @SerializedName("custom_time_period_id") 
    String customTimePeriodId;
    @SerializedName("comments") 
    String comments;
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
        return budgetId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public BudgetData.Builder toDataBuilder() {
        BudgetData.Builder builder = BudgetData.newBuilder();
        if (budgetId != null) {
            builder.setBudgetId(budgetId);
        }
        if (budgetTypeId != null) {
            builder.setBudgetTypeId(budgetTypeId);
        }
        if (customTimePeriodId != null) {
            builder.setCustomTimePeriodId(customTimePeriodId);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Budget fromData(BudgetData data) {
        return Budget.builder()
                .budgetId(data.getBudgetId())
                .budgetTypeId(data.getBudgetTypeId())
                .customTimePeriodId(data.getCustomTimePeriodId())
                .comments(data.getComments())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: budgetId

-- fields --
    
    String budgetId
    String budgetTypeId
    String customTimePeriodId
    String comments

-- relations --
    
    - BudgetType (one, autoRelation: false, keymaps: budgetTypeId)
    - CustomTimePeriod (one, autoRelation: false, keymaps: customTimePeriodId)
    + BudgetTypeAttr (many, autoRelation: false, keymaps: budgetTypeId)
    + BudgetAttribute (many, autoRelation: true, keymaps: budgetId)
    + BudgetItem (many, autoRelation: true, keymaps: budgetId)
    + BudgetReview (many, autoRelation: true, keymaps: budgetId)
    + BudgetRevision (many, autoRelation: true, keymaps: budgetId)
    + BudgetRevisionImpact (many, autoRelation: true, keymaps: budgetId)
    + BudgetRole (many, autoRelation: true, keymaps: budgetId)
    + BudgetScenarioApplication (many, autoRelation: true, keymaps: budgetId)
    + BudgetStatus (many, autoRelation: true, keymaps: budgetId)
    + PaymentBudgetAllocation (many, autoRelation: true, keymaps: budgetId)
    + RequirementBudgetAllocation (many, autoRelation: true, keymaps: budgetId)
*/

