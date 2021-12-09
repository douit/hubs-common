package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.EftAccountData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class EftAccount implements IEventModel<EftAccountData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String paymentMethodId;
    String bankName;
    String routingNumber;
    String accountType;
    String accountNumber;
    String nameOnAccount;
    String companyNameOnAccount;
    String contactMechId;
    Long yearsAtBank;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public EftAccountData.Builder toDataBuilder() {
        EftAccountData.Builder builder = EftAccountData.newBuilder();
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (bankName != null) {
            builder.setBankName(bankName);
        }
        if (routingNumber != null) {
            builder.setRoutingNumber(routingNumber);
        }
        if (accountType != null) {
            builder.setAccountType(accountType);
        }
        if (accountNumber != null) {
            builder.setAccountNumber(accountNumber);
        }
        if (nameOnAccount != null) {
            builder.setNameOnAccount(nameOnAccount);
        }
        if (companyNameOnAccount != null) {
            builder.setCompanyNameOnAccount(companyNameOnAccount);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (yearsAtBank != null) {
            builder.setYearsAtBank(yearsAtBank);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static EftAccount fromData(EftAccountData data) {
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
                
                .build();
    }

    
}
