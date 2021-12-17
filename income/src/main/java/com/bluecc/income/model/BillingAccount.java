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

import com.bluecc.hubs.stub.BillingAccountFlatData;

import com.bluecc.hubs.stub.BillingAccountData;
import com.bluecc.income.dao.BillingAccountDelegator;
import static com.bluecc.income.dao.BillingAccountDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = BillingAccountData.class,
        symbol = EntityNames.BillingAccount)
public class BillingAccount implements IEventModel<BillingAccountFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("billing_account_id")
	@RId 
    String billingAccountId;
    @SerializedName("account_limit") 
    java.math.BigDecimal accountLimit;
    @SerializedName("account_currency_uom_id") 
    String accountCurrencyUomId;
    @SerializedName("contact_mech_id") 
    String contactMechId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("description") 
    String description;
    @SerializedName("external_account_id") 
    String externalAccountId;
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
        return billingAccountId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public BillingAccountFlatData.Builder toDataBuilder() {
        BillingAccountFlatData.Builder builder = BillingAccountFlatData.newBuilder();
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (accountLimit != null) {
            builder.setAccountLimit(getCurrency(accountLimit));
        }
        if (accountCurrencyUomId != null) {
            builder.setAccountCurrencyUomId(accountCurrencyUomId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (externalAccountId != null) {
            builder.setExternalAccountId(externalAccountId);
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

    public static BillingAccount fromData(BillingAccountFlatData data) {
        return BillingAccount.builder()
                .billingAccountId(data.getBillingAccountId())
                .accountLimit(getBigDecimal(data.getAccountLimit()))
                .accountCurrencyUomId(data.getAccountCurrencyUomId())
                .contactMechId(data.getContactMechId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .description(data.getDescription())
                .externalAccountId(data.getExternalAccountId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addContactMech")
    List<ContactMech> relContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addPostalAddress")
    List<PostalAddress> relPostalAddress= new ArrayList<>(); 
    @Exclude
    @Singular("addBillingAccountRole")
    List<BillingAccountRole> relBillingAccountRole= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoice")
    List<Invoice> relInvoice= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderHeader")
    List<OrderHeader> relOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentApplication")
    List<PaymentApplication> relPaymentApplication= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(CONTACT_MECH, getter(this, BillingAccount::getRelContactMech)); 
        supplierMap.put(POSTAL_ADDRESS, getter(this, BillingAccount::getRelPostalAddress)); 
        supplierMap.put(BILLING_ACCOUNT_ROLE, getter(this, BillingAccount::getRelBillingAccountRole)); 
        supplierMap.put(INVOICE, getter(this, BillingAccount::getRelInvoice)); 
        supplierMap.put(ORDER_HEADER, getter(this, BillingAccount::getRelOrderHeader)); 
        supplierMap.put(PAYMENT_APPLICATION, getter(this, BillingAccount::getRelPaymentApplication)); 
        supplierMap.put(TENANT, getter(this, BillingAccount::getRelTenant));

        return supplierMap;
    };

    public BillingAccountDelegator.Agent agent(IProc.ProcContext ctx,
                                             BillingAccountDelegator delegator){
        return delegator.getAgent(ctx, this.getBillingAccountId());
    }

    public BillingAccountData.Builder toHeadBuilder() {
        BillingAccountData.Builder builder = BillingAccountData.newBuilder();
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (accountLimit != null) {
            builder.setAccountLimit(getCurrency(accountLimit));
        }
        if (accountCurrencyUomId != null) {
            builder.setAccountCurrencyUomId(accountCurrencyUomId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (externalAccountId != null) {
            builder.setExternalAccountId(externalAccountId);
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
-- keys: billingAccountId

-- fields --
    
    String billingAccountId
    java.math.BigDecimal accountLimit
    String accountCurrencyUomId
    String contactMechId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    String description
    String externalAccountId

-- relations --
    
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - Uom (one, autoRelation: false, keymaps: accountCurrencyUomId -> uomId)
    - PostalAddress (one, autoRelation: false, keymaps: contactMechId)
    + BillingAccountRole (many, autoRelation: true, keymaps: billingAccountId)
    + BillingAccountTerm (many, autoRelation: true, keymaps: billingAccountId)
    + Invoice (many, autoRelation: true, keymaps: billingAccountId)
    + OrderHeader (many, autoRelation: true, keymaps: billingAccountId)
    + PaymentApplication (many, autoRelation: true, keymaps: billingAccountId)
    + ReturnHeader (many, autoRelation: true, keymaps: billingAccountId)
    + ReturnItemResponse (many, autoRelation: true, keymaps: billingAccountId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

