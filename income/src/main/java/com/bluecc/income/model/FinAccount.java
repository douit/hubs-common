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
public class FinAccount implements IEventModel<FinAccountFlatData.Builder>, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RId String finAccountId;
    String finAccountTypeId;
    String statusId;
    String finAccountName;
    String finAccountCode;
    String finAccountPin;
    String currencyUomId;
    String organizationPartyId;
    String ownerPartyId;
    String postToGlAccountId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    Character isRefundable;
    String replenishPaymentId;
    java.math.BigDecimal replenishLevel;
    java.math.BigDecimal actualBalance;
    java.math.BigDecimal availableBalance;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FinAccountFlatData.Builder toDataBuilder() {
        FinAccountFlatData.Builder builder = FinAccountFlatData.newBuilder();
        if (finAccountId != null) {
            builder.setFinAccountId(finAccountId);
        }
        if (finAccountTypeId != null) {
            builder.setFinAccountTypeId(finAccountTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (finAccountName != null) {
            builder.setFinAccountName(finAccountName);
        }
        if (finAccountCode != null) {
            builder.setFinAccountCode(finAccountCode);
        }
        if (finAccountPin != null) {
            builder.setFinAccountPin(finAccountPin);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (organizationPartyId != null) {
            builder.setOrganizationPartyId(organizationPartyId);
        }
        if (ownerPartyId != null) {
            builder.setOwnerPartyId(ownerPartyId);
        }
        if (postToGlAccountId != null) {
            builder.setPostToGlAccountId(postToGlAccountId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (isRefundable != null) {
            builder.setIsRefundable(getIndicator(isRefundable));
        }
        if (replenishPaymentId != null) {
            builder.setReplenishPaymentId(replenishPaymentId);
        }
        if (replenishLevel != null) {
            builder.setReplenishLevel(getCurrency(replenishLevel));
        }
        if (actualBalance != null) {
            builder.setActualBalance(getCurrency(actualBalance));
        }
        if (availableBalance != null) {
            builder.setAvailableBalance(getCurrency(availableBalance));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static FinAccount fromData(FinAccountFlatData data) {
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
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addOrganizationParty")
    List<Party> relOrganizationParty= new ArrayList<>(); 
    @Exclude
    @Singular("addOwnerParty")
    List<Party> relOwnerParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPostToGlAccount")
    List<GlAccount> relPostToGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addReplenishPaymentMethod")
    List<PaymentMethod> relReplenishPaymentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountRole")
    List<FinAccountRole> relFinAccountRole= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountStatus")
    List<FinAccountStatus> relFinAccountStatus= new ArrayList<>(); 
    @Exclude
    @Singular("addFinAccountTrans")
    List<FinAccountTrans> relFinAccountTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderPaymentPreference")
    List<OrderPaymentPreference> relOrderPaymentPreference= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentMethod")
    List<PaymentMethod> relPaymentMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
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
        supplierMap.put(TENANT, getter(this, FinAccount::getRelTenant));

        return supplierMap;
    };

    public FinAccountDelegator.Agent agent(IProc.ProcContext ctx,
                                             FinAccountDelegator delegator){
        return delegator.getAgent(ctx, this.getFinAccountId());
    }

    public FinAccountData.Builder toHeadBuilder() {
        FinAccountData.Builder builder = FinAccountData.newBuilder();
        if (finAccountId != null) {
            builder.setFinAccountId(finAccountId);
        }
        if (finAccountTypeId != null) {
            builder.setFinAccountTypeId(finAccountTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (finAccountName != null) {
            builder.setFinAccountName(finAccountName);
        }
        if (finAccountCode != null) {
            builder.setFinAccountCode(finAccountCode);
        }
        if (finAccountPin != null) {
            builder.setFinAccountPin(finAccountPin);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (isRefundable != null) {
            builder.setIsRefundable(getIndicator(isRefundable));
        }
        if (replenishLevel != null) {
            builder.setReplenishLevel(getCurrency(replenishLevel));
        }
        if (actualBalance != null) {
            builder.setActualBalance(getCurrency(actualBalance));
        }
        if (availableBalance != null) {
            builder.setAvailableBalance(getCurrency(availableBalance));
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

