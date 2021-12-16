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

import com.bluecc.hubs.stub.PaymentFlatData;

import com.bluecc.hubs.stub.PaymentData;
import com.bluecc.income.dao.PaymentDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentData.class,
        symbol = EntityNames.Payment)
public class Payment implements IEventModel<PaymentFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String paymentId;
    String paymentTypeId;
    String paymentMethodTypeId;
    String paymentMethodId;
    String paymentGatewayResponseId;
    String paymentPreferenceId;
    String partyIdFrom;
    String partyIdTo;
    String roleTypeIdTo;
    String statusId;
    java.time.LocalDateTime effectiveDate;
    String paymentRefNum;
    java.math.BigDecimal amount;
    String currencyUomId;
    String comments;
    String finAccountTransId;
    String overrideGlAccountId;
    java.math.BigDecimal actualCurrencyAmount;
    String actualCurrencyUomId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentFlatData.Builder toDataBuilder() {
        PaymentFlatData.Builder builder = PaymentFlatData.newBuilder();
        if (paymentId != null) {
            builder.setPaymentId(paymentId);
        }
        if (paymentTypeId != null) {
            builder.setPaymentTypeId(paymentTypeId);
        }
        if (paymentMethodTypeId != null) {
            builder.setPaymentMethodTypeId(paymentMethodTypeId);
        }
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (paymentGatewayResponseId != null) {
            builder.setPaymentGatewayResponseId(paymentGatewayResponseId);
        }
        if (paymentPreferenceId != null) {
            builder.setPaymentPreferenceId(paymentPreferenceId);
        }
        if (partyIdFrom != null) {
            builder.setPartyIdFrom(partyIdFrom);
        }
        if (partyIdTo != null) {
            builder.setPartyIdTo(partyIdTo);
        }
        if (roleTypeIdTo != null) {
            builder.setRoleTypeIdTo(roleTypeIdTo);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (effectiveDate != null) {
            builder.setEffectiveDate(getTimestamp(effectiveDate));
        }
        if (paymentRefNum != null) {
            builder.setPaymentRefNum(paymentRefNum);
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (finAccountTransId != null) {
            builder.setFinAccountTransId(finAccountTransId);
        }
        if (overrideGlAccountId != null) {
            builder.setOverrideGlAccountId(overrideGlAccountId);
        }
        if (actualCurrencyAmount != null) {
            builder.setActualCurrencyAmount(getCurrency(actualCurrencyAmount));
        }
        if (actualCurrencyUomId != null) {
            builder.setActualCurrencyUomId(actualCurrencyUomId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Payment fromData(PaymentFlatData data) {
        return Payment.builder()
                .paymentId(data.getPaymentId())
                .paymentTypeId(data.getPaymentTypeId())
                .paymentMethodTypeId(data.getPaymentMethodTypeId())
                .paymentMethodId(data.getPaymentMethodId())
                .paymentGatewayResponseId(data.getPaymentGatewayResponseId())
                .paymentPreferenceId(data.getPaymentPreferenceId())
                .partyIdFrom(data.getPartyIdFrom())
                .partyIdTo(data.getPartyIdTo())
                .roleTypeIdTo(data.getRoleTypeIdTo())
                .statusId(data.getStatusId())
                .effectiveDate(getLocalDateTime(data.getEffectiveDate()))
                .paymentRefNum(data.getPaymentRefNum())
                .amount(getBigDecimal(data.getAmount()))
                .currencyUomId(data.getCurrencyUomId())
                .comments(data.getComments())
                .finAccountTransId(data.getFinAccountTransId())
                .overrideGlAccountId(data.getOverrideGlAccountId())
                .actualCurrencyAmount(getBigDecimal(data.getActualCurrencyAmount()))
                .actualCurrencyUomId(data.getActualCurrencyUomId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

        // relations
     
    @Exclude
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    @Exclude
    List<CreditCard> relCreditCard= new ArrayList<>(); 
    @Exclude
    List<EftAccount> relEftAccount= new ArrayList<>(); 
    @Exclude
    List<OrderPaymentPreference> relOrderPaymentPreference= new ArrayList<>(); 
    @Exclude
    List<PaymentGatewayResponse> relPaymentGatewayResponse= new ArrayList<>(); 
    @Exclude
    List<Party> relFromParty= new ArrayList<>(); 
    @Exclude
    List<Party> relToParty= new ArrayList<>(); 
    @Exclude
    List<PartyRole> relToPartyRole= new ArrayList<>(); 
    @Exclude
    List<FinAccountTrans> relFinAccountTrans= new ArrayList<>(); 
    @Exclude
    List<GlAccount> relGlAccount= new ArrayList<>(); 
    @Exclude
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    List<PaymentApplication> relPaymentApplication= new ArrayList<>(); 
    @Exclude
    List<PaymentApplication> relToPaymentApplication= new ArrayList<>();

    public PaymentDelegator.Agent agent(IProc.ProcContext ctx,
                                             PaymentDelegator delegator){
        return delegator.getAgent(ctx, this.getPaymentId());
    }

    public PaymentData.Builder toHeadBuilder() {
        PaymentData.Builder builder = PaymentData.newBuilder();
        if (paymentId != null) {
            builder.setPaymentId(paymentId);
        }
        if (paymentTypeId != null) {
            builder.setPaymentTypeId(paymentTypeId);
        }
        if (paymentMethodTypeId != null) {
            builder.setPaymentMethodTypeId(paymentMethodTypeId);
        }
        if (roleTypeIdTo != null) {
            builder.setRoleTypeIdTo(roleTypeIdTo);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (effectiveDate != null) {
            builder.setEffectiveDate(getTimestamp(effectiveDate));
        }
        if (paymentRefNum != null) {
            builder.setPaymentRefNum(paymentRefNum);
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (actualCurrencyAmount != null) {
            builder.setActualCurrencyAmount(getCurrency(actualCurrencyAmount));
        }
        if (actualCurrencyUomId != null) {
            builder.setActualCurrencyUomId(actualCurrencyUomId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: paymentId

-- fields --
    
    String paymentId
    String paymentTypeId
    String paymentMethodTypeId
    String paymentMethodId
    String paymentGatewayResponseId
    String paymentPreferenceId
    String partyIdFrom
    String partyIdTo
    String roleTypeIdTo
    String statusId
    java.time.LocalDateTime effectiveDate
    String paymentRefNum
    java.math.BigDecimal amount
    String currencyUomId
    String comments
    String finAccountTransId
    String overrideGlAccountId
    java.math.BigDecimal actualCurrencyAmount
    String actualCurrencyUomId

-- relations --
    
    - PaymentType (one, autoRelation: false, keymaps: paymentTypeId)
    + PaymentTypeAttr (many, autoRelation: false, keymaps: paymentTypeId)
    - PaymentMethodType (one, autoRelation: false, keymaps: paymentMethodTypeId)
    - PaymentMethod (one, autoRelation: false, keymaps: paymentMethodId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - ActualCurrencyUom (one, autoRelation: false, keymaps: actualCurrencyUomId -> uomId)
    - CreditCard (one-nofk, autoRelation: false, keymaps: paymentMethodId)
    - EftAccount (one-nofk, autoRelation: false, keymaps: paymentMethodId)
    - GiftCard (one-nofk, autoRelation: false, keymaps: paymentMethodId)
    - OrderPaymentPreference (one, autoRelation: false, keymaps: paymentPreferenceId -> orderPaymentPreferenceId)
    - PaymentGatewayResponse (one, autoRelation: false, keymaps: paymentGatewayResponseId)
    - FromParty (one, autoRelation: false, keymaps: partyIdFrom -> partyId)
    - ToParty (one, autoRelation: false, keymaps: partyIdTo -> partyId)
    - ToRoleType (one, autoRelation: false, keymaps: roleTypeIdTo -> roleTypeId)
    - ToPartyRole (one-nofk, autoRelation: false, keymaps: partyIdTo -> partyId, roleTypeIdTo -> roleTypeId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - FinAccountTrans (one, autoRelation: false, keymaps: finAccountTransId)
    - GlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
    + AcctgTrans (many, autoRelation: true, keymaps: paymentId)
    + Deduction (many, autoRelation: true, keymaps: paymentId)
    + PaymentApplication (many, autoRelation: true, keymaps: paymentId)
    + ToPaymentApplication (many, autoRelation: true, keymaps: paymentId -> toPaymentId)
    + PaymentAttribute (many, autoRelation: true, keymaps: paymentId)
    + PaymentBudgetAllocation (many, autoRelation: true, keymaps: paymentId)
    + PaymentContent (many, autoRelation: true, keymaps: paymentId)
    + PaymentGroupMember (many, autoRelation: true, keymaps: paymentId)
    + PerfReview (many, autoRelation: true, keymaps: paymentId)
    + ReturnItemResponse (many, autoRelation: true, keymaps: paymentId)
*/

