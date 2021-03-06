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

import com.bluecc.hubs.stub.EftAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = EftAccountData.class,
        symbol = EntityNames.EftAccount)
public class EftAccount implements IEventModel<EftAccountData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_method_id")
	@RId 
    String paymentMethodId;
    @SerializedName("bank_name") 
    String bankName;
    @SerializedName("routing_number") 
    String routingNumber;
    @SerializedName("account_type") 
    String accountType;
    @SerializedName("account_number") 
    String accountNumber;
    @SerializedName("name_on_account") 
    String nameOnAccount;
    @SerializedName("company_name_on_account") 
    String companyNameOnAccount;
    @SerializedName("contact_mech_id") 
    String contactMechId;
    @SerializedName("years_at_bank") 
    Long yearsAtBank;
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
        return paymentMethodId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EftAccountData.Builder toDataBuilder() {
        EftAccountData.Builder builder = EftAccountData.newBuilder();
        if (getPaymentMethodId() != null) {
            builder.setPaymentMethodId(getPaymentMethodId());
        }
        if (getBankName() != null) {
            builder.setBankName(getBankName());
        }
        if (getRoutingNumber() != null) {
            builder.setRoutingNumber(getRoutingNumber());
        }
        if (getAccountType() != null) {
            builder.setAccountType(getAccountType());
        }
        if (getAccountNumber() != null) {
            builder.setAccountNumber(getAccountNumber());
        }
        if (getNameOnAccount() != null) {
            builder.setNameOnAccount(getNameOnAccount());
        }
        if (getCompanyNameOnAccount() != null) {
            builder.setCompanyNameOnAccount(getCompanyNameOnAccount());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getYearsAtBank() != null) {
            builder.setYearsAtBank(getYearsAtBank());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static EftAccount fromData(EftAccountData data) {
        return fromPrototype(data).build();
    }

    public static EftAccount.EftAccountBuilder fromPrototype(EftAccountData data) {
        return EftAccount.builder()
                .paymentMethodId(data.getPaymentMethodId())
                .bankName(data.getBankName())
                .routingNumber(data.getRoutingNumber())
                .accountType(data.getAccountType())
                .accountNumber(data.getAccountNumber())
                .nameOnAccount(data.getNameOnAccount())
                .companyNameOnAccount(data.getCompanyNameOnAccount())
                .contactMechId(data.getContactMechId())
                .yearsAtBank(data.getYearsAtBank())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: paymentMethodId

-- fields --
    
    String paymentMethodId
    String bankName
    String routingNumber
    String accountType
    String accountNumber
    String nameOnAccount
    String companyNameOnAccount
    String contactMechId
    Long yearsAtBank

-- relations --
    
    - PaymentMethod (one, autoRelation: false, keymaps: paymentMethodId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - PostalAddress (one, autoRelation: false, keymaps: contactMechId)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: paymentMethodId)
    + Payment (many, autoRelation: true, keymaps: paymentMethodId)
*/

