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

import com.bluecc.hubs.stub.PaymentFlatData;

import com.bluecc.hubs.stub.PaymentData;
import com.bluecc.income.dao.PaymentDelegator;
import static com.bluecc.income.dao.PaymentDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentData.class,
        symbol = EntityNames.Payment)
public class Payment implements IEventModel<PaymentFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_id")
	@RId 
    String paymentId;
    @SerializedName("payment_type_id") 
    String paymentTypeId;
    @SerializedName("payment_method_type_id") 
    String paymentMethodTypeId;
    @SerializedName("payment_method_id") 
    String paymentMethodId;
    @SerializedName("payment_gateway_response_id") 
    String paymentGatewayResponseId;
    @SerializedName("payment_preference_id") 
    String paymentPreferenceId;
    @SerializedName("party_id_from") 
    String partyIdFrom;
    @SerializedName("party_id_to") 
    String partyIdTo;
    @SerializedName("role_type_id_to") 
    String roleTypeIdTo;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("effective_date") 
    java.time.LocalDateTime effectiveDate;
    @SerializedName("payment_ref_num") 
    String paymentRefNum;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("comments") 
    String comments;
    @SerializedName("fin_account_trans_id") 
    String finAccountTransId;
    @SerializedName("override_gl_account_id") 
    String overrideGlAccountId;
    @SerializedName("actual_currency_amount") 
    java.math.BigDecimal actualCurrencyAmount;
    @SerializedName("actual_currency_uom_id") 
    String actualCurrencyUomId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return paymentId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentFlatData.Builder toDataBuilder() {
        PaymentFlatData.Builder builder = PaymentFlatData.newBuilder();
        if (getPaymentId() != null) {
            builder.setPaymentId(getPaymentId());
        }
        if (getPaymentTypeId() != null) {
            builder.setPaymentTypeId(getPaymentTypeId());
        }
        if (getPaymentMethodTypeId() != null) {
            builder.setPaymentMethodTypeId(getPaymentMethodTypeId());
        }
        if (getPaymentMethodId() != null) {
            builder.setPaymentMethodId(getPaymentMethodId());
        }
        if (getPaymentGatewayResponseId() != null) {
            builder.setPaymentGatewayResponseId(getPaymentGatewayResponseId());
        }
        if (getPaymentPreferenceId() != null) {
            builder.setPaymentPreferenceId(getPaymentPreferenceId());
        }
        if (getPartyIdFrom() != null) {
            builder.setPartyIdFrom(getPartyIdFrom());
        }
        if (getPartyIdTo() != null) {
            builder.setPartyIdTo(getPartyIdTo());
        }
        if (getRoleTypeIdTo() != null) {
            builder.setRoleTypeIdTo(getRoleTypeIdTo());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getEffectiveDate() != null) {
            builder.setEffectiveDate(getTimestamp(getEffectiveDate()));
        }
        if (getPaymentRefNum() != null) {
            builder.setPaymentRefNum(getPaymentRefNum());
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getFinAccountTransId() != null) {
            builder.setFinAccountTransId(getFinAccountTransId());
        }
        if (getOverrideGlAccountId() != null) {
            builder.setOverrideGlAccountId(getOverrideGlAccountId());
        }
        if (getActualCurrencyAmount() != null) {
            builder.setActualCurrencyAmount(getCurrency(getActualCurrencyAmount()));
        }
        if (getActualCurrencyUomId() != null) {
            builder.setActualCurrencyUomId(getActualCurrencyUomId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static Payment fromData(PaymentFlatData data) {
        return fromPrototype(data).build();
    }

    public static Payment.PaymentBuilder fromPrototype(PaymentFlatData data) {
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
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addPaymentMethod")
    @SerializedName("payment_method") 
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addCreditCard")
    @SerializedName("credit_card") 
    List<CreditCard> relCreditCard= new ArrayList<>(); 
    @Exclude
    @Singular("addEftAccount")
    @SerializedName("eft_account") 
    List<EftAccount> relEftAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderPaymentPreference")
    @SerializedName("order_payment_preference") 
    List<OrderPaymentPreference> relOrderPaymentPreference= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentGatewayResponse")
    @SerializedName("payment_gateway_response") 
    List<PaymentGatewayResponse> relPaymentGatewayResponse= new ArrayList<>(); 
    @Exclude
    @Singular("addFromParty")
    @SerializedName("from_party") 
    List<Party> relFromParty= new ArrayList<>(); 
    @Exclude
    @Singular("addToParty")
    @SerializedName("to_party") 
    List<Party> relToParty= new ArrayList<>(); 
    @Exclude
    @Singular("addToPartyRole")
    @SerializedName("to_party_role") 
    List<PartyRole> relToPartyRole= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountTrans")
    @SerializedName("fin_account_trans") 
    List<FinAccountTrans> relFinAccountTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addGlAccount")
    @SerializedName("gl_account") 
    List<GlAccount> relGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    @SerializedName("acctg_trans") 
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentApplication")
    @SerializedName("payment_application") 
    List<PaymentApplication> relPaymentApplication= new ArrayList<>(); 
    @Exclude
    @Singular("addToPaymentApplication")
    @SerializedName("to_payment_application") 
    List<PaymentApplication> relToPaymentApplication= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PAYMENT_METHOD, getter(this, Payment::getRelPaymentMethod)); 
        supplierMap.put(CREDIT_CARD, getter(this, Payment::getRelCreditCard)); 
        supplierMap.put(EFT_ACCOUNT, getter(this, Payment::getRelEftAccount)); 
        supplierMap.put(ORDER_PAYMENT_PREFERENCE, getter(this, Payment::getRelOrderPaymentPreference)); 
        supplierMap.put(PAYMENT_GATEWAY_RESPONSE, getter(this, Payment::getRelPaymentGatewayResponse)); 
        supplierMap.put(FROM_PARTY, getter(this, Payment::getRelFromParty)); 
        supplierMap.put(TO_PARTY, getter(this, Payment::getRelToParty)); 
        supplierMap.put(TO_PARTY_ROLE, getter(this, Payment::getRelToPartyRole)); 
        supplierMap.put(FIN_ACCOUNT_TRANS, getter(this, Payment::getRelFinAccountTrans)); 
        supplierMap.put(GL_ACCOUNT, getter(this, Payment::getRelGlAccount)); 
        supplierMap.put(ACCTG_TRANS, getter(this, Payment::getRelAcctgTrans)); 
        supplierMap.put(PAYMENT_APPLICATION, getter(this, Payment::getRelPaymentApplication)); 
        supplierMap.put(TO_PAYMENT_APPLICATION, getter(this, Payment::getRelToPaymentApplication)); 
        supplierMap.put(TENANT, getter(this, Payment::getRelTenant));

        return supplierMap;
    };

    public PaymentDelegator.Agent agent(IProc.ProcContext ctx,
                                             PaymentDelegator delegator){
        return delegator.getAgent(ctx, this.getPaymentId());
    }

    public PaymentData.Builder toHeadBuilder() {
        PaymentData.Builder builder = PaymentData.newBuilder();
        if (getPaymentId() != null) {
            builder.setPaymentId(getPaymentId());
        }
        if (getPaymentTypeId() != null) {
            builder.setPaymentTypeId(getPaymentTypeId());
        }
        if (getPaymentMethodTypeId() != null) {
            builder.setPaymentMethodTypeId(getPaymentMethodTypeId());
        }
        if (getRoleTypeIdTo() != null) {
            builder.setRoleTypeIdTo(getRoleTypeIdTo());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getEffectiveDate() != null) {
            builder.setEffectiveDate(getTimestamp(getEffectiveDate()));
        }
        if (getPaymentRefNum() != null) {
            builder.setPaymentRefNum(getPaymentRefNum());
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getActualCurrencyAmount() != null) {
            builder.setActualCurrencyAmount(getCurrency(getActualCurrencyAmount()));
        }
        if (getActualCurrencyUomId() != null) {
            builder.setActualCurrencyUomId(getActualCurrencyUomId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

