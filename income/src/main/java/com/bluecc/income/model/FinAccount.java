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

import com.bluecc.hubs.stub.FinAccountFlatData;

import com.bluecc.hubs.stub.FinAccountData;
import com.bluecc.income.dao.FinAccountDelegator;
import static com.bluecc.income.dao.FinAccountDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FinAccountData.class,
        symbol = EntityNames.FinAccount)
public class FinAccount implements IEventModel<FinAccountFlatData.Builder>, HasId, Serializable, WithSuppliers, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("fin_account_id")
	@RId 
    String finAccountId;
    @SerializedName("fin_account_type_id") 
    String finAccountTypeId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("fin_account_name") 
    String finAccountName;
    @SerializedName("fin_account_code") 
    String finAccountCode;
    @SerializedName("fin_account_pin") 
    String finAccountPin;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("organization_party_id") 
    String organizationPartyId;
    @SerializedName("owner_party_id") 
    String ownerPartyId;
    @SerializedName("post_to_gl_account_id") 
    String postToGlAccountId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("is_refundable") 
    Character isRefundable;
    @SerializedName("replenish_payment_id") 
    String replenishPaymentId;
    @SerializedName("replenish_level") 
    java.math.BigDecimal replenishLevel;
    @SerializedName("actual_balance") 
    java.math.BigDecimal actualBalance;
    @SerializedName("available_balance") 
    java.math.BigDecimal availableBalance;
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
        return finAccountId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FinAccountFlatData.Builder toDataBuilder() {
        FinAccountFlatData.Builder builder = FinAccountFlatData.newBuilder();
        if (getFinAccountId() != null) {
            builder.setFinAccountId(getFinAccountId());
        }
        if (getFinAccountTypeId() != null) {
            builder.setFinAccountTypeId(getFinAccountTypeId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getFinAccountName() != null) {
            builder.setFinAccountName(getFinAccountName());
        }
        if (getFinAccountCode() != null) {
            builder.setFinAccountCode(getFinAccountCode());
        }
        if (getFinAccountPin() != null) {
            builder.setFinAccountPin(getFinAccountPin());
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getOrganizationPartyId() != null) {
            builder.setOrganizationPartyId(getOrganizationPartyId());
        }
        if (getOwnerPartyId() != null) {
            builder.setOwnerPartyId(getOwnerPartyId());
        }
        if (getPostToGlAccountId() != null) {
            builder.setPostToGlAccountId(getPostToGlAccountId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getIsRefundable() != null) {
            builder.setIsRefundable(getIndicator(getIsRefundable()));
        }
        if (getReplenishPaymentId() != null) {
            builder.setReplenishPaymentId(getReplenishPaymentId());
        }
        if (getReplenishLevel() != null) {
            builder.setReplenishLevel(getCurrency(getReplenishLevel()));
        }
        if (getActualBalance() != null) {
            builder.setActualBalance(getCurrency(getActualBalance()));
        }
        if (getAvailableBalance() != null) {
            builder.setAvailableBalance(getCurrency(getAvailableBalance()));
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

    public static FinAccount fromData(FinAccountFlatData data) {
        return fromPrototype(data).build();
    }

    public static FinAccount.FinAccountBuilder fromPrototype(FinAccountFlatData data) {
        return FinAccount.builder()
                .finAccountId(data.getFinAccountId())
                .finAccountTypeId(data.getFinAccountTypeId())
                .statusId(data.getStatusId())
                .finAccountName(data.getFinAccountName())
                .finAccountCode(data.getFinAccountCode())
                .finAccountPin(data.getFinAccountPin())
                .currencyUomId(data.getCurrencyUomId())
                .organizationPartyId(data.getOrganizationPartyId())
                .ownerPartyId(data.getOwnerPartyId())
                .postToGlAccountId(data.getPostToGlAccountId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .isRefundable(getIndicatorChar(data.getIsRefundable()))
                .replenishPaymentId(data.getReplenishPaymentId())
                .replenishLevel(getBigDecimal(data.getReplenishLevel()))
                .actualBalance(getBigDecimal(data.getActualBalance()))
                .availableBalance(getBigDecimal(data.getAvailableBalance()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addOrganizationParty")
    @SerializedName("organization_party") 
    List<Party> relOrganizationParty= new ArrayList<>(); 
    @Exclude
    @Singular("addOwnerParty")
    @SerializedName("owner_party") 
    List<Party> relOwnerParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPostToGlAccount")
    @SerializedName("post_to_gl_account") 
    List<GlAccount> relPostToGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addReplenishPaymentMethod")
    @SerializedName("replenish_payment_method") 
    List<PaymentMethod> relReplenishPaymentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountRole")
    @SerializedName("fin_account_role") 
    List<FinAccountRole> relFinAccountRole= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountStatus")
    @SerializedName("fin_account_status") 
    List<FinAccountStatus> relFinAccountStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountTrans")
    @SerializedName("fin_account_trans") 
    List<FinAccountTrans> relFinAccountTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderPaymentPreference")
    @SerializedName("order_payment_preference") 
    List<OrderPaymentPreference> relOrderPaymentPreference= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentMethod")
    @SerializedName("payment_method") 
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addReturnHeader")
    @SerializedName("return_header") 
    List<ReturnHeader> relReturnHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(ORGANIZATION_PARTY, getter(this, FinAccount::getRelOrganizationParty)); 
        supplierMap.put(OWNER_PARTY, getter(this, FinAccount::getRelOwnerParty)); 
        supplierMap.put(POST_TO_GL_ACCOUNT, getter(this, FinAccount::getRelPostToGlAccount)); 
        supplierMap.put(REPLENISH_PAYMENT_METHOD, getter(this, FinAccount::getRelReplenishPaymentMethod)); 
        supplierMap.put(FIN_ACCOUNT_ROLE, getter(this, FinAccount::getRelFinAccountRole)); 
        supplierMap.put(FIN_ACCOUNT_STATUS, getter(this, FinAccount::getRelFinAccountStatus)); 
        supplierMap.put(FIN_ACCOUNT_TRANS, getter(this, FinAccount::getRelFinAccountTrans)); 
        supplierMap.put(ORDER_PAYMENT_PREFERENCE, getter(this, FinAccount::getRelOrderPaymentPreference)); 
        supplierMap.put(PAYMENT_METHOD, getter(this, FinAccount::getRelPaymentMethod)); 
        supplierMap.put(RETURN_HEADER, getter(this, FinAccount::getRelReturnHeader)); 
        supplierMap.put(TENANT, getter(this, FinAccount::getRelTenant));

        return supplierMap;
    };

    public FinAccountDelegator.Agent agent(IProc.ProcContext ctx,
                                             FinAccountDelegator delegator){
        return delegator.getAgent(ctx, this.getFinAccountId());
    }

    public FinAccountData.Builder toHeadBuilder() {
        FinAccountData.Builder builder = FinAccountData.newBuilder();
        if (getFinAccountId() != null) {
            builder.setFinAccountId(getFinAccountId());
        }
        if (getFinAccountTypeId() != null) {
            builder.setFinAccountTypeId(getFinAccountTypeId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getFinAccountName() != null) {
            builder.setFinAccountName(getFinAccountName());
        }
        if (getFinAccountCode() != null) {
            builder.setFinAccountCode(getFinAccountCode());
        }
        if (getFinAccountPin() != null) {
            builder.setFinAccountPin(getFinAccountPin());
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getIsRefundable() != null) {
            builder.setIsRefundable(getIndicator(getIsRefundable()));
        }
        if (getReplenishLevel() != null) {
            builder.setReplenishLevel(getCurrency(getReplenishLevel()));
        }
        if (getActualBalance() != null) {
            builder.setActualBalance(getCurrency(getActualBalance()));
        }
        if (getAvailableBalance() != null) {
            builder.setAvailableBalance(getCurrency(getAvailableBalance()));
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
-- keys: finAccountId

-- fields --
    
    String finAccountId
    String finAccountTypeId
    String statusId
    String finAccountName
    String finAccountCode
    String finAccountPin
    String currencyUomId
    String organizationPartyId
    String ownerPartyId
    String postToGlAccountId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    Character isRefundable
    String replenishPaymentId
    java.math.BigDecimal replenishLevel
    java.math.BigDecimal actualBalance
    java.math.BigDecimal availableBalance

-- relations --
    
    - FinAccountType (one, autoRelation: false, keymaps: finAccountTypeId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - OrganizationParty (one, autoRelation: false, keymaps: organizationPartyId -> partyId)
    - OwnerParty (one, autoRelation: false, keymaps: ownerPartyId -> partyId)
    - PostToGlAccount (one, autoRelation: false, keymaps: postToGlAccountId -> glAccountId)
    - ReplenishPaymentMethod (one, autoRelation: false, keymaps: replenishPaymentId -> paymentMethodId)
    + FinAccountTypeAttr (many, autoRelation: false, keymaps: finAccountTypeId)
    + FinAccountAttribute (many, autoRelation: true, keymaps: finAccountId)
    + FinAccountAuth (many, autoRelation: true, keymaps: finAccountId)
    + FinAccountRole (many, autoRelation: true, keymaps: finAccountId)
    + FinAccountStatus (many, autoRelation: true, keymaps: finAccountId)
    + FinAccountTrans (many, autoRelation: true, keymaps: finAccountId)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: finAccountId)
    + PaymentMethod (many, autoRelation: true, keymaps: finAccountId)
    + ReturnHeader (many, autoRelation: true, keymaps: finAccountId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

