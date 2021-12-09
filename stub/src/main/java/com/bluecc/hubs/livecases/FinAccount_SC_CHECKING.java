package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.FinAccountStatusData;
import com.bluecc.hubs.stub.CreditCardData;
import com.bluecc.hubs.stub.FinAccountFlatData;
import com.bluecc.hubs.stub.PaymentMethodData;
import com.bluecc.hubs.stub.EftAccountData;

public final class FinAccount_SC_CHECKING {
    public static FinAccountStatusData FinAccountStatus_SC_CHECKING_FNACT_ACTIVE_() {
        return FinAccountStatusData.newBuilder()
            .setFinAccountId("SC_CHECKING")
            .setStatusDate(getTimestamp("2009-04-01 00:00:01.000"))
            .setStatusId("FNACT_ACTIVE")
            .build();
    }


    public static FinAccountStatusData FinAccountStatus_ABN_CHECKING_FNACT_ACTIVE_() {
        return FinAccountStatusData.newBuilder()
            .setFinAccountId("ABN_CHECKING")
            .setStatusDate(getTimestamp("2009-04-01 00:00:01.000"))
            .setStatusId("FNACT_ACTIVE")
            .build();
    }


    public static FinAccountStatusData FinAccountStatus_AMEX_01_FNACT_ACTIVE_() {
        return FinAccountStatusData.newBuilder()
            .setFinAccountId("AMEX_01")
            .setStatusDate(getTimestamp("2009-04-01 00:00:01.000"))
            .setStatusId("FNACT_ACTIVE")
            .build();
    }


    public static CreditCardData CreditCard_AMEX_01() {
        return CreditCardData.newBuilder()
            .setCardNumber("378282246310005")
            .setCardType("CCT_AMERICANEXPRESS")
            .setCompanyNameOnCard("Your Company Name")
            .setContactMechId("9000")
            .setExpireDate("02/2100")
            .setFirstNameOnCard("Smart")
            .setLastNameOnCard("Guy")
            .setPaymentMethodId("AMEX_01")
            .build();
    }


    public static FinAccountFlatData FinAccount_SC_CHECKING() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("0.00"))
            .setAvailableBalance(getCurrency("0.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("1247854852147")
            .setFinAccountId("SC_CHECKING")
            .setFinAccountName("Standard Chartered")
            .setFinAccountPin("1234")
            .setFinAccountTypeId("BANK_ACCOUNT")
            .setIsRefundable(castIndicator("Y"))
            .setOrganizationPartyId("Company")
            .setOwnerPartyId("Company")
            .setPostToGlAccountId("111100")
            .setReplenishLevel(getCurrency("0.00"))
            .setStatusId("FNACT_ACTIVE")
            .build();
    }


    public static FinAccountFlatData FinAccount_ABN_CHECKING() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("0.00"))
            .setAvailableBalance(getCurrency("0.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("6577852521447")
            .setFinAccountId("ABN_CHECKING")
            .setFinAccountName("ABN AMRO")
            .setFinAccountPin("1234")
            .setFinAccountTypeId("BANK_ACCOUNT")
            .setIsRefundable(castIndicator("Y"))
            .setOrganizationPartyId("Company")
            .setOwnerPartyId("Company")
            .setPostToGlAccountId("111100")
            .setReplenishLevel(getCurrency("0.00"))
            .setStatusId("FNACT_ACTIVE")
            .build();
    }


    public static FinAccountFlatData FinAccount_AMEX_01() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("0.00"))
            .setAvailableBalance(getCurrency("0.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("378282246310005")
            .setFinAccountId("AMEX_01")
            .setFinAccountName("Corporate AMEX ")
            .setFinAccountPin("9876")
            .setFinAccountTypeId("CREDIT_CARD_ACCOUNT")
            .setIsRefundable(castIndicator("Y"))
            .setOrganizationPartyId("Company")
            .setOwnerPartyId("Company")
            .setPostToGlAccountId("231000")
            .setReplenishLevel(getCurrency("0.00"))
            .setStatusId("FNACT_ACTIVE")
            .build();
    }


    public static PaymentMethodData PaymentMethod_SC_CHECKING() {
        return PaymentMethodData.newBuilder()
            .setDescription("Checking Account at Standard Chartered Bank")
            .setFinAccountId("SC_CHECKING")
            .setFromDate(getTimestamp("2009-04-01 00:00:00.000"))
            .setGlAccountId("111100")
            .setPartyId("Company")
            .setPaymentMethodId("SC_CHECKING")
            .setPaymentMethodTypeId("COMPANY_CHECK")
            .build();
    }


    public static PaymentMethodData PaymentMethod_ABN_CHECKING() {
        return PaymentMethodData.newBuilder()
            .setDescription("Checking Account at ABN AMRO Bank")
            .setFinAccountId("ABN_CHECKING")
            .setFromDate(getTimestamp("2009-04-01 00:00:00.000"))
            .setGlAccountId("111100")
            .setPartyId("Company")
            .setPaymentMethodId("ABN_CHECKING")
            .setPaymentMethodTypeId("COMPANY_CHECK")
            .build();
    }


    public static PaymentMethodData PaymentMethod_AMEX_01() {
        return PaymentMethodData.newBuilder()
            .setDescription("AmEx 0005")
            .setFinAccountId("AMEX_01")
            .setFromDate(getTimestamp("2009-04-01 00:00:00.000"))
            .setGlAccountId("231000")
            .setPartyId("Company")
            .setPaymentMethodId("AMEX_01")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .build();
    }


    public static PaymentMethodData PaymentMethod_PETTY_CASH() {
        return PaymentMethodData.newBuilder()
            .setDescription("Petty Cash")
            .setFromDate(getTimestamp("2009-04-01 00:00:00.000"))
            .setGlAccountId("110000")
            .setPartyId("Company")
            .setPaymentMethodId("PETTY_CASH")
            .setPaymentMethodTypeId("CASH")
            .build();
    }


    public static EftAccountData EftAccount_SC_CHECKING() {
        return EftAccountData.newBuilder()
            .setAccountNumber("316253011064226")
            .setAccountType("Checking")
            .setBankName("Standard Chartered Bank")
            .setContactMechId("9000")
            .setNameOnAccount("Company")
            .setPaymentMethodId("SC_CHECKING")
            .setRoutingNumber("307075259")
            .build();
    }


    public static EftAccountData EftAccount_ABN_CHECKING() {
        return EftAccountData.newBuilder()
            .setAccountNumber("427253011064227")
            .setAccountType("Checking")
            .setBankName("ABN AMRO Bank")
            .setContactMechId("9000")
            .setNameOnAccount("Company")
            .setPaymentMethodId("ABN_CHECKING")
            .setRoutingNumber("222371863")
            .build();
    }

}
