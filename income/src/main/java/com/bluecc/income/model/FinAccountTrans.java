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

import com.bluecc.hubs.stub.FinAccountTransData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FinAccountTransData.class,
        symbol = EntityNames.FinAccountTrans)
public class FinAccountTrans implements IEventModel<FinAccountTransData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("fin_account_trans_id")
	@RId 
    String finAccountTransId;
    @SerializedName("fin_account_trans_type_id") 
    String finAccountTransTypeId;
    @SerializedName("fin_account_id") 
    String finAccountId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("gl_reconciliation_id") 
    String glReconciliationId;
    @SerializedName("transaction_date") 
    java.time.LocalDateTime transactionDate;
    @SerializedName("entry_date") 
    java.time.LocalDateTime entryDate;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("payment_id") 
    String paymentId;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("performed_by_party_id") 
    String performedByPartyId;
    @SerializedName("reason_enum_id") 
    String reasonEnumId;
    @SerializedName("comments") 
    String comments;
    @SerializedName("status_id") 
    String statusId;
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
        return finAccountTransId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FinAccountTransData.Builder toDataBuilder() {
        FinAccountTransData.Builder builder = FinAccountTransData.newBuilder();
        if (getFinAccountTransId() != null) {
            builder.setFinAccountTransId(getFinAccountTransId());
        }
        if (getFinAccountTransTypeId() != null) {
            builder.setFinAccountTransTypeId(getFinAccountTransTypeId());
        }
        if (getFinAccountId() != null) {
            builder.setFinAccountId(getFinAccountId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getGlReconciliationId() != null) {
            builder.setGlReconciliationId(getGlReconciliationId());
        }
        if (getTransactionDate() != null) {
            builder.setTransactionDate(getTimestamp(getTransactionDate()));
        }
        if (getEntryDate() != null) {
            builder.setEntryDate(getTimestamp(getEntryDate()));
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getPaymentId() != null) {
            builder.setPaymentId(getPaymentId());
        }
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getPerformedByPartyId() != null) {
            builder.setPerformedByPartyId(getPerformedByPartyId());
        }
        if (getReasonEnumId() != null) {
            builder.setReasonEnumId(getReasonEnumId());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static FinAccountTrans fromData(FinAccountTransData data) {
        return fromPrototype(data).build();
    }

    public static FinAccountTrans.FinAccountTransBuilder fromPrototype(FinAccountTransData data) {
        return FinAccountTrans.builder()
                .finAccountTransId(data.getFinAccountTransId())
                .finAccountTransTypeId(data.getFinAccountTransTypeId())
                .finAccountId(data.getFinAccountId())
                .partyId(data.getPartyId())
                .glReconciliationId(data.getGlReconciliationId())
                .transactionDate(getLocalDateTime(data.getTransactionDate()))
                .entryDate(getLocalDateTime(data.getEntryDate()))
                .amount(getBigDecimal(data.getAmount()))
                .paymentId(data.getPaymentId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .performedByPartyId(data.getPerformedByPartyId())
                .reasonEnumId(data.getReasonEnumId())
                .comments(data.getComments())
                .statusId(data.getStatusId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: finAccountTransId

-- fields --
    
    String finAccountTransId
    String finAccountTransTypeId
    String finAccountId
    String partyId
    String glReconciliationId
    java.time.LocalDateTime transactionDate
    java.time.LocalDateTime entryDate
    java.math.BigDecimal amount
    String paymentId
    String orderId
    String orderItemSeqId
    String performedByPartyId
    String reasonEnumId
    String comments
    String statusId

-- relations --
    
    - FinAccountTransType (one, autoRelation: false, keymaps: finAccountTransTypeId)
    + FinAccountTransTypeAttr (many, autoRelation: false, keymaps: finAccountTransTypeId)
    - FinAccount (one, autoRelation: false, keymaps: finAccountId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - Payment (one, autoRelation: false, keymaps: paymentId)
    - OrderItem (one, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - PerformedByParty (one, autoRelation: false, keymaps: performedByPartyId -> partyId)
    - ReasonEnumeration (one, autoRelation: false, keymaps: reasonEnumId -> enumId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - GlReconciliation (one, autoRelation: false, keymaps: glReconciliationId)
    + AcctgTrans (many, autoRelation: true, keymaps: finAccountTransId)
    + FinAccountTransAttribute (many, autoRelation: true, keymaps: finAccountTransId)
    + ReturnItemResponse (many, autoRelation: true, keymaps: finAccountTransId)
*/

