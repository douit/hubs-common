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

import com.bluecc.hubs.stub.BudgetStatusData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = BudgetStatusData.class,
        symbol = EntityNames.BudgetStatus)
public class BudgetStatus implements IEventModel<BudgetStatusData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String budgetId;
    @RIndex String statusId;
    java.time.LocalDateTime statusDate;
    String comments;
    String changeByUserLoginId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public BudgetStatusData.Builder toDataBuilder() {
        BudgetStatusData.Builder builder = BudgetStatusData.newBuilder();
        if (budgetId != null) {
            builder.setBudgetId(budgetId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (statusDate != null) {
            builder.setStatusDate(getTimestamp(statusDate));
        }
        if (comments != null) {
            builder.setComments(comments);
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

    public static BudgetStatus fromData(BudgetStatusData data) {
        return BudgetStatus.builder()
                .budgetId(data.getBudgetId())
                .statusId(data.getStatusId())
                .statusDate(getLocalDateTime(data.getStatusDate()))
                .comments(data.getComments())
                .changeByUserLoginId(data.getChangeByUserLoginId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
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

