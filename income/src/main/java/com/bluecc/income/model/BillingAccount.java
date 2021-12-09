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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.BillingAccountFlatData;

import com.bluecc.hubs.stub.BillingAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = BillingAccountData.class,
        symbol = EntityNames.BillingAccount)
public class BillingAccount implements IEventModel<BillingAccountFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String billingAccountId;
    java.math.BigDecimal accountLimit;
    String accountCurrencyUomId;
    String contactMechId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String description;
    String externalAccountId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
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
                
                .build();
    }

        // relations
     
    List<ContactMech> relContactMech= new ArrayList<>(); 
    List<PostalAddress> relPostalAddress= new ArrayList<>(); 
    List<BillingAccountRole> relBillingAccountRole= new ArrayList<>(); 
    List<Invoice> relInvoice= new ArrayList<>(); 
    List<OrderHeader> relOrderHeader= new ArrayList<>(); 
    List<PaymentApplication> relPaymentApplication= new ArrayList<>();

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
