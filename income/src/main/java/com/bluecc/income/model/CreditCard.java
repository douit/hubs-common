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

import com.bluecc.hubs.stub.CreditCardData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = CreditCardData.class,
        symbol = EntityNames.CreditCard)
public class CreditCard implements IEventModel<CreditCardData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_method_id")
	@RId 
    String paymentMethodId;
    @SerializedName("card_type") 
    String cardType;
    @SerializedName("card_number") 
    String cardNumber;
    @SerializedName("valid_from_date") 
    String validFromDate;
    @SerializedName("expire_date") 
    String expireDate;
    @SerializedName("issue_number") 
    String issueNumber;
    @SerializedName("company_name_on_card") 
    String companyNameOnCard;
    @SerializedName("title_on_card") 
    String titleOnCard;
    @SerializedName("first_name_on_card") 
    String firstNameOnCard;
    @SerializedName("middle_name_on_card") 
    String middleNameOnCard;
    @SerializedName("last_name_on_card") 
    String lastNameOnCard;
    @SerializedName("suffix_on_card") 
    String suffixOnCard;
    @SerializedName("contact_mech_id") 
    String contactMechId;
    @SerializedName("consecutive_failed_auths") 
    Long consecutiveFailedAuths;
    @SerializedName("last_failed_auth_date") 
    java.time.LocalDateTime lastFailedAuthDate;
    @SerializedName("consecutive_failed_nsf") 
    Long consecutiveFailedNsf;
    @SerializedName("last_failed_nsf_date") 
    java.time.LocalDateTime lastFailedNsfDate;
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

    public CreditCardData.Builder toDataBuilder() {
        CreditCardData.Builder builder = CreditCardData.newBuilder();
        if (getPaymentMethodId() != null) {
            builder.setPaymentMethodId(getPaymentMethodId());
        }
        if (getCardType() != null) {
            builder.setCardType(getCardType());
        }
        if (getCardNumber() != null) {
            builder.setCardNumber(getCardNumber());
        }
        if (getValidFromDate() != null) {
            builder.setValidFromDate(getValidFromDate());
        }
        if (getExpireDate() != null) {
            builder.setExpireDate(getExpireDate());
        }
        if (getIssueNumber() != null) {
            builder.setIssueNumber(getIssueNumber());
        }
        if (getCompanyNameOnCard() != null) {
            builder.setCompanyNameOnCard(getCompanyNameOnCard());
        }
        if (getTitleOnCard() != null) {
            builder.setTitleOnCard(getTitleOnCard());
        }
        if (getFirstNameOnCard() != null) {
            builder.setFirstNameOnCard(getFirstNameOnCard());
        }
        if (getMiddleNameOnCard() != null) {
            builder.setMiddleNameOnCard(getMiddleNameOnCard());
        }
        if (getLastNameOnCard() != null) {
            builder.setLastNameOnCard(getLastNameOnCard());
        }
        if (getSuffixOnCard() != null) {
            builder.setSuffixOnCard(getSuffixOnCard());
        }
        if (getContactMechId() != null) {
            builder.setContactMechId(getContactMechId());
        }
        if (getConsecutiveFailedAuths() != null) {
            builder.setConsecutiveFailedAuths(getConsecutiveFailedAuths());
        }
        if (getLastFailedAuthDate() != null) {
            builder.setLastFailedAuthDate(getTimestamp(getLastFailedAuthDate()));
        }
        if (getConsecutiveFailedNsf() != null) {
            builder.setConsecutiveFailedNsf(getConsecutiveFailedNsf());
        }
        if (getLastFailedNsfDate() != null) {
            builder.setLastFailedNsfDate(getTimestamp(getLastFailedNsfDate()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static CreditCard fromData(CreditCardData data) {
        return fromPrototype(data).build();
    }

    public static CreditCard.CreditCardBuilder fromPrototype(CreditCardData data) {
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
                ;
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

