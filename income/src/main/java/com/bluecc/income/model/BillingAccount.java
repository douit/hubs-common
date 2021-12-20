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
        if (getBillingAccountId() != null) {
            builder.setBillingAccountId(getBillingAccountId());
        }
        if (getAccountLimit() != null) {
            builder.setAccountLimit(getCurrency(getAccountLimit()));
        }
        if (getAccountCurrencyUomId() != null) {
            builder.setAccountCurrencyUomId(getAccountCurrencyUomId());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getExternalAccountId() != null) {
            builder.setExternalAccountId(getExternalAccountId());
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

    public static BillingAccount fromData(BillingAccountFlatData data) {
        return fromPrototype(data).build();
    }

    public static BillingAccount.BillingAccountBuilder fromPrototype(BillingAccountFlatData data) {
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
                ;
    }

        // relations
     
    @Exclude
    @Singular("addContactMech")
    @SerializedName("contact_mech") 
    List<ContactMech> relContactMech= new ArrayList<>(); 
    @Exclude
    @Singular("addPostalAddress")
    @SerializedName("postal_address") 
    List<PostalAddress> relPostalAddress= new ArrayList<>(); 
    @Exclude
    @Singular("addBillingAccountRole")
    @SerializedName("billing_account_role") 
    List<BillingAccountRole> relBillingAccountRole= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoice")
    @SerializedName("invoice") 
    List<Invoice> relInvoice= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderHeader")
    @SerializedName("order_header") 
    List<OrderHeader> relOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentApplication")
    @SerializedName("payment_application") 
    List<PaymentApplication> relPaymentApplication= new ArrayList<>(); 
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
         
        supplierMap.put(CONTACT_MECH, getter(this, BillingAccount::getRelContactMech)); 
        supplierMap.put(POSTAL_ADDRESS, getter(this, BillingAccount::getRelPostalAddress)); 
        supplierMap.put(BILLING_ACCOUNT_ROLE, getter(this, BillingAccount::getRelBillingAccountRole)); 
        supplierMap.put(INVOICE, getter(this, BillingAccount::getRelInvoice)); 
        supplierMap.put(ORDER_HEADER, getter(this, BillingAccount::getRelOrderHeader)); 
        supplierMap.put(PAYMENT_APPLICATION, getter(this, BillingAccount::getRelPaymentApplication)); 
        supplierMap.put(RETURN_HEADER, getter(this, BillingAccount::getRelReturnHeader)); 
        supplierMap.put(TENANT, getter(this, BillingAccount::getRelTenant));

        return supplierMap;
    };

    public BillingAccountDelegator.Agent agent(IProc.ProcContext ctx,
                                             BillingAccountDelegator delegator){
        return delegator.getAgent(ctx, this.getBillingAccountId());
    }

    public BillingAccountData.Builder toHeadBuilder() {
        BillingAccountData.Builder builder = BillingAccountData.newBuilder();
        if (getBillingAccountId() != null) {
            builder.setBillingAccountId(getBillingAccountId());
        }
        if (getAccountLimit() != null) {
            builder.setAccountLimit(getCurrency(getAccountLimit()));
        }
        if (getAccountCurrencyUomId() != null) {
            builder.setAccountCurrencyUomId(getAccountCurrencyUomId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getExternalAccountId() != null) {
            builder.setExternalAccountId(getExternalAccountId());
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

