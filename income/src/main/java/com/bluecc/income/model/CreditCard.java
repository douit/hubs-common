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

import com.bluecc.hubs.stub.CreditCardData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CreditCardData.class,
        symbol = EntityNames.CreditCard)
public class CreditCard implements IEventModel<CreditCardData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String paymentMethodId;
    String cardType;
    String cardNumber;
    String validFromDate;
    String expireDate;
    String issueNumber;
    String companyNameOnCard;
    String titleOnCard;
    String firstNameOnCard;
    String middleNameOnCard;
    String lastNameOnCard;
    String suffixOnCard;
    String contactMechId;
    Long consecutiveFailedAuths;
    java.time.LocalDateTime lastFailedAuthDate;
    Long consecutiveFailedNsf;
    java.time.LocalDateTime lastFailedNsfDate;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public CreditCardData.Builder toDataBuilder() {
        CreditCardData.Builder builder = CreditCardData.newBuilder();
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (cardType != null) {
            builder.setCardType(cardType);
        }
        if (cardNumber != null) {
            builder.setCardNumber(cardNumber);
        }
        if (validFromDate != null) {
            builder.setValidFromDate(validFromDate);
        }
        if (expireDate != null) {
            builder.setExpireDate(expireDate);
        }
        if (issueNumber != null) {
            builder.setIssueNumber(issueNumber);
        }
        if (companyNameOnCard != null) {
            builder.setCompanyNameOnCard(companyNameOnCard);
        }
        if (titleOnCard != null) {
            builder.setTitleOnCard(titleOnCard);
        }
        if (firstNameOnCard != null) {
            builder.setFirstNameOnCard(firstNameOnCard);
        }
        if (middleNameOnCard != null) {
            builder.setMiddleNameOnCard(middleNameOnCard);
        }
        if (lastNameOnCard != null) {
            builder.setLastNameOnCard(lastNameOnCard);
        }
        if (suffixOnCard != null) {
            builder.setSuffixOnCard(suffixOnCard);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (consecutiveFailedAuths != null) {
            builder.setConsecutiveFailedAuths(consecutiveFailedAuths);
        }
        if (lastFailedAuthDate != null) {
            builder.setLastFailedAuthDate(getTimestamp(lastFailedAuthDate));
        }
        if (consecutiveFailedNsf != null) {
            builder.setConsecutiveFailedNsf(consecutiveFailedNsf);
        }
        if (lastFailedNsfDate != null) {
            builder.setLastFailedNsfDate(getTimestamp(lastFailedNsfDate));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static CreditCard fromData(CreditCardData data) {
        return CreditCard.builder()
                .paymentMethodId(data.getPaymentMethodId())
                .cardType(data.getCardType())
                .cardNumber(data.getCardNumber())
                .validFromDate(data.getValidFromDate())
                .expireDate(data.getExpireDate())
                .issueNumber(data.getIssueNumber())
                .companyNameOnCard(data.getCompanyNameOnCard())
                .titleOnCard(data.getTitleOnCard())
                .firstNameOnCard(data.getFirstNameOnCard())
                .middleNameOnCard(data.getMiddleNameOnCard())
                .lastNameOnCard(data.getLastNameOnCard())
                .suffixOnCard(data.getSuffixOnCard())
                .contactMechId(data.getContactMechId())
                .consecutiveFailedAuths(data.getConsecutiveFailedAuths())
                .lastFailedAuthDate(getLocalDateTime(data.getLastFailedAuthDate()))
                .consecutiveFailedNsf(data.getConsecutiveFailedNsf())
                .lastFailedNsfDate(getLocalDateTime(data.getLastFailedNsfDate()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: paymentMethodId

-- fields --
    
    String paymentMethodId
    String cardType
    String cardNumber
    String validFromDate
    String expireDate
    String issueNumber
    String companyNameOnCard
    String titleOnCard
    String firstNameOnCard
    String middleNameOnCard
    String lastNameOnCard
    String suffixOnCard
    String contactMechId
    Long consecutiveFailedAuths
    java.time.LocalDateTime lastFailedAuthDate
    Long consecutiveFailedNsf
    java.time.LocalDateTime lastFailedNsfDate

-- relations --
    
    - PaymentMethod (one, autoRelation: false, keymaps: paymentMethodId)
    - ContactMech (one, autoRelation: false, keymaps: contactMechId)
    - PostalAddress (one, autoRelation: false, keymaps: contactMechId)
    + OrderPaymentPreference (many, autoRelation: true, keymaps: paymentMethodId)
    + Payment (many, autoRelation: true, keymaps: paymentMethodId)
*/

