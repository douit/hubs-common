package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PaymentMethodTypeData;
import com.bluecc.hubs.stub.GlAccountCategoryData;
import com.bluecc.hubs.stub.GlJournalData;
import com.bluecc.hubs.stub.GlAccountOrganizationData;
import com.bluecc.hubs.stub.FinAccountTypeGlAccountData;
import com.bluecc.hubs.stub.CreditCardTypeGlAccountData;
import com.bluecc.hubs.stub.GlReconciliationData;
import com.bluecc.hubs.stub.PartyAcctgPreferenceData;
import com.bluecc.hubs.stub.PaymentMethodTypeGlAccountData;
import com.bluecc.hubs.stub.CostComponentCalcData;
import com.bluecc.hubs.stub.GlAccountTypeDefaultData;
import com.bluecc.hubs.stub.VarianceReasonGlAccountData;
import com.bluecc.hubs.stub.CustomTimePeriodData;
import com.bluecc.hubs.stub.UomConversionDatedData;
import com.bluecc.hubs.stub.GlAccountCategoryMemberData;
import com.bluecc.hubs.stub.InvoiceItemTypeData;
import com.bluecc.hubs.stub.PaymentGlAccountTypeMapData;

public final class OfbizSetupChartOfAccountsData {
    public final static PaymentMethodTypeData PaymentMethodType_CREDIT_CARD = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("CREDIT_CARD")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_GIFT_CARD = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("GIFT_CARD")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_GIFT_CERTIFICATE = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("GIFT_CERTIFICATE")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_CASH = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("CASH")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EFT_ACCOUNT = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("EFT_ACCOUNT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_FIN_ACCOUNT = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_PERSONAL_CHECK = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("PERSONAL_CHECK")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_COMPANY_CHECK = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("COMPANY_CHECK")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_CERTIFIED_CHECK = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("CERTIFIED_CHECK")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_MONEY_ORDER = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("MONEY_ORDER")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_COMPANY_ACCOUNT = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("COMPANY_ACCOUNT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_BILLACT = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("EXT_BILLACT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_COD = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("EXT_COD")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_EBAY = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("EXT_EBAY")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_OFFLINE = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("EXT_OFFLINE")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_PAYPAL = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("EXT_PAYPAL")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_WORLDPAY = PaymentMethodTypeData.newBuilder()
        .setDefaultGlAccountId("122000")
        .setPaymentMethodTypeId("EXT_WORLDPAY")
        .build();


    public final static GlAccountCategoryData GlAccountCategory_9301 = GlAccountCategoryData.newBuilder()
        .setDescription("Cost Center 1")
        .setGlAccountCategoryId("9301")
        .setGlAccountCategoryTypeId("COST_CENTER")
        .build();


    public final static GlAccountCategoryData GlAccountCategory_9302 = GlAccountCategoryData.newBuilder()
        .setDescription("Cost Center 2")
        .setGlAccountCategoryId("9302")
        .setGlAccountCategoryTypeId("COST_CENTER")
        .build();


    public final static GlAccountCategoryData GlAccountCategory_9303 = GlAccountCategoryData.newBuilder()
        .setDescription("Cost Center 3")
        .setGlAccountCategoryId("9303")
        .setGlAccountCategoryTypeId("COST_CENTER")
        .build();


    public final static GlJournalData GlJournal_ERROR_JOURNAL = GlJournalData.newBuilder()
        .setGlJournalId("ERROR_JOURNAL")
        .setGlJournalName("Suspense transactions")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_100000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("100000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_110000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("110000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_111000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("111000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_111100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("111100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_111900_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("111900")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_112000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_120000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("120000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_125000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("125000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_121800_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("121800")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_122000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("122000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_122100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("122100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_122200_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("122200")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_122300_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("122300")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_122500_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("122500")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_126000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("126000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_140000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("140000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_141000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("141000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_142000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("142000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_150000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("150000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_171000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("171000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_174000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("174000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_188000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("188000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_210000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("210000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_213000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("213000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_213200_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("213200")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_213300_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("213300")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_213500_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("213500")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_214000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("214000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_215000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("215000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_216000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("216000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_221100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("221100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_224000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("224000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_224100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("224100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_224106_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("224106")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_224140_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("224140")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_224151_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("224151")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_224153_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("224153")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_224209_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("224209")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_231000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("231000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_310000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("310000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_336000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("336000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_400000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("400000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_401000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("401000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_409000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("409000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_410000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("410000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_421000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("421000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_422000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("422000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_423000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("423000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_424000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("424000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_500000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("500000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_510000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("510000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_514000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("514000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_515000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("515000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_516100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("516100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_518000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("518000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_600000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("600000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_601000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("601000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_601100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("601100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_601200_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("601200")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_601300_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("601300")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_601400_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("601400")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_602100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("602100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_602200_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("602200")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_603100_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("603100")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_603200_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("603200")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_604000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("604000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_605000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("605000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_625000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("625000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_649000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("649000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_650000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("650000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_675400_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("675400")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_804000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("804000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_810000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("810000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_850000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("850000")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountOrganizationData GlAccountOrganization_900000_Company = GlAccountOrganizationData.newBuilder()
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setGlAccountId("900000")
        .setOrganizationPartyId("Company")
        .build();


    public final static FinAccountTypeGlAccountData FinAccountTypeGlAccount_GIFTCERT_ACCOUNT_Company = FinAccountTypeGlAccountData.newBuilder()
        .setFinAccountTypeId("GIFTCERT_ACCOUNT")
        .setGlAccountId("213200")
        .setOrganizationPartyId("Company")
        .build();


    public final static FinAccountTypeGlAccountData FinAccountTypeGlAccount_DEPOSIT_ACCOUNT_Company = FinAccountTypeGlAccountData.newBuilder()
        .setFinAccountTypeId("DEPOSIT_ACCOUNT")
        .setGlAccountId("213500")
        .setOrganizationPartyId("Company")
        .build();


    public final static FinAccountTypeGlAccountData FinAccountTypeGlAccount_BANK_ACCOUNT_Company = FinAccountTypeGlAccountData.newBuilder()
        .setFinAccountTypeId("BANK_ACCOUNT")
        .setGlAccountId("213500")
        .setOrganizationPartyId("Company")
        .build();


    public final static FinAccountTypeGlAccountData FinAccountTypeGlAccount_INVESTMENT_ACCOUNT_Company = FinAccountTypeGlAccountData.newBuilder()
        .setFinAccountTypeId("INVESTMENT_ACCOUNT")
        .setGlAccountId("213500")
        .setOrganizationPartyId("Company")
        .build();


    public final static CreditCardTypeGlAccountData CreditCardTypeGlAccount_CCT_AMERICANEXPRESS_Company = CreditCardTypeGlAccountData.newBuilder()
        .setCardType("CCT_AMERICANEXPRESS")
        .setGlAccountId("122100")
        .setOrganizationPartyId("Company")
        .build();


    public final static CreditCardTypeGlAccountData CreditCardTypeGlAccount_CCT_DINERSCLUB_Company = CreditCardTypeGlAccountData.newBuilder()
        .setCardType("CCT_DINERSCLUB")
        .setGlAccountId("122100")
        .setOrganizationPartyId("Company")
        .build();


    public final static CreditCardTypeGlAccountData CreditCardTypeGlAccount_CCT_DISCOVER_Company = CreditCardTypeGlAccountData.newBuilder()
        .setCardType("CCT_DISCOVER")
        .setGlAccountId("122200")
        .setOrganizationPartyId("Company")
        .build();


    public final static CreditCardTypeGlAccountData CreditCardTypeGlAccount_CCT_VISA_Company = CreditCardTypeGlAccountData.newBuilder()
        .setCardType("CCT_VISA")
        .setGlAccountId("122300")
        .setOrganizationPartyId("Company")
        .build();


    public final static CreditCardTypeGlAccountData CreditCardTypeGlAccount_CCT_MASTERCARD_Company = CreditCardTypeGlAccountData.newBuilder()
        .setCardType("CCT_MASTERCARD")
        .setGlAccountId("122300")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlReconciliationData GlReconciliation_9000 = GlReconciliationData.newBuilder()
        .setGlAccountId("111100")
        .setGlReconciliationId("9000")
        .setGlReconciliationName("demoGlReconciliation")
        .setOrganizationPartyId("Company")
        .setReconciledBalance(getCurrency("75000.00"))
        .setReconciledDate(getTimestamp("2009-08-08 20:03:14.000"))
        .setStatusId("GLREC_RECONCILED")
        .build();


    public final static GlReconciliationData GlReconciliation_9001 = GlReconciliationData.newBuilder()
        .setGlAccountId("111100")
        .setGlReconciliationId("9001")
        .setGlReconciliationName("testGlReconciliation")
        .setOrganizationPartyId("Company")
        .setReconciledDate(getTimestamp("2009-08-12 20:03:14.000"))
        .setStatusId("GLREC_CREATED")
        .build();


    public final static PartyAcctgPreferenceData PartyAcctgPreference_Company = PartyAcctgPreferenceData.newBuilder()
        .setBaseCurrencyUomId("USD")
        .setCogsMethodId("COGS_LIFO")
        .setErrorGlJournalId("ERROR_JOURNAL")
        .setInvoiceIdPrefix("CI")
        .setInvoiceSeqCustMethId("INV_HOOK_ENF_SEQ")
        .setOrderIdPrefix("CO")
        .setPartyId("Company")
        .setQuoteIdPrefix("CQ")
        .setTaxFormId("US_IRS_1120")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_GIFT_CERTIFICATE_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("120000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("GIFT_CERTIFICATE")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_CASH_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("CASH")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_EFT_ACCOUNT_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("111100")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("EFT_ACCOUNT")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_FIN_ACCOUNT_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("111100")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_PERSONAL_CHECK_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("PERSONAL_CHECK")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_COMPANY_CHECK_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("COMPANY_CHECK")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_CERTIFIED_CHECK_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("CERTIFIED_CHECK")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_MONEY_ORDER_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("MONEY_ORDER")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_COMPANY_ACCOUNT_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("111100")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("COMPANY_ACCOUNT")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_EXT_BILLACT_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("213000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("EXT_BILLACT")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_EXT_COD_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("EXT_COD")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_EXT_EBAY_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("EXT_EBAY")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_EXT_OFFLINE_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("112000")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("EXT_OFFLINE")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_EXT_PAYPAL_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("122500")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("EXT_PAYPAL")
        .build();


    public final static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_EXT_WORLDPAY_Company = PaymentMethodTypeGlAccountData.newBuilder()
        .setGlAccountId("122500")
        .setOrganizationPartyId("Company")
        .setPaymentMethodTypeId("EXT_WORLDPAY")
        .build();


    public final static CostComponentCalcData CostComponentCalc_GEN_COST_CALC = CostComponentCalcData.newBuilder()
        .setCostComponentCalcId("GEN_COST_CALC")
        .setCostGlAccountTypeId("OPERATING_EXPENSE")
        .build();


    public final static CostComponentCalcData CostComponentCalc_TASK_COST_CALC = CostComponentCalcData.newBuilder()
        .setCostComponentCalcId("TASK_COST_CALC")
        .setCostGlAccountTypeId("OPERATING_EXPENSE")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_ACCOUNTS_RECEIVABLE_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("120000")
        .setGlAccountTypeId("ACCOUNTS_RECEIVABLE")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_ACCREC_UNAPPLIED_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("126000")
        .setGlAccountTypeId("ACCREC_UNAPPLIED")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_INTRSTINC_RECEIVABLE_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("121800")
        .setGlAccountTypeId("INTRSTINC_RECEIVABLE")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_INVENTORY_XFER_OUT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("125000")
        .setGlAccountTypeId("INVENTORY_XFER_OUT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_INVENTORY_ACCOUNT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("140000")
        .setGlAccountTypeId("INVENTORY_ACCOUNT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_RAWMAT_INVENTORY_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("141000")
        .setGlAccountTypeId("RAWMAT_INVENTORY")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_WIP_INVENTORY_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("142000")
        .setGlAccountTypeId("WIP_INVENTORY")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_PREPAID_EXPENSES_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("150000")
        .setGlAccountTypeId("PREPAID_EXPENSES")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_ACCOUNTS_PAYABLE_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("210000")
        .setGlAccountTypeId("ACCOUNTS_PAYABLE")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_CUSTOMER_CREDIT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("213000")
        .setGlAccountTypeId("CUSTOMER_CREDIT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_CUSTOMER_DEPOSIT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("213300")
        .setGlAccountTypeId("CUSTOMER_DEPOSIT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_UNINVOICED_SHIP_RCPT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("214000")
        .setGlAccountTypeId("UNINVOICED_SHIP_RCPT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_INVENTORY_XFER_IN_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("215000")
        .setGlAccountTypeId("INVENTORY_XFER_IN")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_ACCPAYABLE_UNAPPLIED_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("216000")
        .setGlAccountTypeId("ACCPAYABLE_UNAPPLIED")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_COMMISSIONS_PAYABLE_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("221100")
        .setGlAccountTypeId("COMMISSIONS_PAYABLE")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_RETAINED_EARNINGS_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("336000")
        .setGlAccountTypeId("RETAINED_EARNINGS")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_SALES_ACCOUNT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("400000")
        .setGlAccountTypeId("SALES_ACCOUNT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_COGS_ACCOUNT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("500000")
        .setGlAccountTypeId("COGS_ACCOUNT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_INV_ADJ_VAL_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("515000")
        .setGlAccountTypeId("INV_ADJ_VAL")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_FX_GAIN_LOSS_ACCT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("518000")
        .setGlAccountTypeId("FX_GAIN_LOSS_ACCT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_OPERATING_EXPENSE_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("600000")
        .setGlAccountTypeId("OPERATING_EXPENSE")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_PROFIT_LOSS_ACCOUNT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("850000")
        .setGlAccountTypeId("PROFIT_LOSS_ACCOUNT")
        .setOrganizationPartyId("Company")
        .build();


    public final static GlAccountTypeDefaultData GlAccountTypeDefault_TAX_ACCOUNT_Company = GlAccountTypeDefaultData.newBuilder()
        .setGlAccountId("900000")
        .setGlAccountTypeId("TAX_ACCOUNT")
        .setOrganizationPartyId("Company")
        .build();


    public final static VarianceReasonGlAccountData VarianceReasonGlAccount_VAR_LOST_Company = VarianceReasonGlAccountData.newBuilder()
        .setGlAccountId("514000")
        .setOrganizationPartyId("Company")
        .setVarianceReasonId("VAR_LOST")
        .build();


    public final static VarianceReasonGlAccountData VarianceReasonGlAccount_VAR_STOLEN_Company = VarianceReasonGlAccountData.newBuilder()
        .setGlAccountId("514000")
        .setOrganizationPartyId("Company")
        .setVarianceReasonId("VAR_STOLEN")
        .build();


    public final static VarianceReasonGlAccountData VarianceReasonGlAccount_VAR_FOUND_Company = VarianceReasonGlAccountData.newBuilder()
        .setGlAccountId("514000")
        .setOrganizationPartyId("Company")
        .setVarianceReasonId("VAR_FOUND")
        .build();


    public final static VarianceReasonGlAccountData VarianceReasonGlAccount_VAR_DAMAGED_Company = VarianceReasonGlAccountData.newBuilder()
        .setGlAccountId("514000")
        .setOrganizationPartyId("Company")
        .setVarianceReasonId("VAR_DAMAGED")
        .build();


    public final static VarianceReasonGlAccountData VarianceReasonGlAccount_VAR_INTEGR_Company = VarianceReasonGlAccountData.newBuilder()
        .setGlAccountId("514000")
        .setOrganizationPartyId("Company")
        .setVarianceReasonId("VAR_INTEGR")
        .build();


    public final static VarianceReasonGlAccountData VarianceReasonGlAccount_VAR_SAMPLE_Company = VarianceReasonGlAccountData.newBuilder()
        .setGlAccountId("625000")
        .setOrganizationPartyId("Company")
        .setVarianceReasonId("VAR_SAMPLE")
        .build();


    public final static CustomTimePeriodData CustomTimePeriod_6010 = CustomTimePeriodData.newBuilder()
        .setCustomTimePeriodId("6010")
        .setFromDate(getTimestamp("2010-01-01 00:00:00.000"))
        .setIsClosed(castIndicator("N"))
        .setOrganizationPartyId("Company")
        .setPeriodName("2010")
        .setPeriodNum(1)
        .setPeriodTypeId("FISCAL_YEAR")
        .setThruDate(getTimestamp("2011-01-01 23:59:59.000"))
        .build();


    public final static CustomTimePeriodData CustomTimePeriod_6011 = CustomTimePeriodData.newBuilder()
        .setCustomTimePeriodId("6011")
        .setFromDate(getTimestamp("2010-01-01 00:00:00.000"))
        .setIsClosed(castIndicator("N"))
        .setOrganizationPartyId("Company")
        .setParentPeriodId("6010")
        .setPeriodName("2010/Q1")
        .setPeriodNum(2)
        .setPeriodTypeId("FISCAL_QUARTER")
        .setThruDate(getTimestamp("2010-04-01 23:59:59.000"))
        .build();


    public final static CustomTimePeriodData CustomTimePeriod_6012 = CustomTimePeriodData.newBuilder()
        .setCustomTimePeriodId("6012")
        .setFromDate(getTimestamp("2010-04-01 00:00:00.000"))
        .setIsClosed(castIndicator("N"))
        .setOrganizationPartyId("Company")
        .setParentPeriodId("6010")
        .setPeriodName("2010/Q2")
        .setPeriodNum(3)
        .setPeriodTypeId("FISCAL_QUARTER")
        .setThruDate(getTimestamp("2010-07-01 23:59:59.000"))
        .build();


    public final static CustomTimePeriodData CustomTimePeriod_6013 = CustomTimePeriodData.newBuilder()
        .setCustomTimePeriodId("6013")
        .setFromDate(getTimestamp("2010-07-01 00:00:00.000"))
        .setIsClosed(castIndicator("N"))
        .setOrganizationPartyId("Company")
        .setParentPeriodId("6010")
        .setPeriodName("2010/Q3")
        .setPeriodNum(4)
        .setPeriodTypeId("FISCAL_QUARTER")
        .setThruDate(getTimestamp("2010-10-01 23:59:59.000"))
        .build();


    public final static CustomTimePeriodData CustomTimePeriod_6014 = CustomTimePeriodData.newBuilder()
        .setCustomTimePeriodId("6014")
        .setFromDate(getTimestamp("2010-10-01 00:00:00.000"))
        .setIsClosed(castIndicator("N"))
        .setOrganizationPartyId("Company")
        .setParentPeriodId("6010")
        .setPeriodName("2010/Q4")
        .setPeriodNum(5)
        .setPeriodTypeId("FISCAL_QUARTER")
        .setThruDate(getTimestamp("2011-01-01 23:59:59.000"))
        .build();


    public final static CustomTimePeriodData CustomTimePeriod_6015 = CustomTimePeriodData.newBuilder()
        .setCustomTimePeriodId("6015")
        .setFromDate(getTimestamp("2011-01-01 00:00:00.000"))
        .setIsClosed(castIndicator("N"))
        .setOrganizationPartyId("Company")
        .setPeriodName("2011-2030")
        .setPeriodNum(1)
        .setPeriodTypeId("FISCAL_YEAR")
        .setThruDate(getTimestamp("2030-01-01 23:59:59.000"))
        .build();


    public final static UomConversionDatedData UomConversionDated_USD_EUR_ = UomConversionDatedData.newBuilder()
        .setConversionFactor(0.7)
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setUomId("USD")
        .setUomIdTo("EUR")
        .build();


    public final static UomConversionDatedData UomConversionDated_EUR_USD_ = UomConversionDatedData.newBuilder()
        .setConversionFactor(1.5)
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setUomId("EUR")
        .setUomIdTo("USD")
        .build();


    public final static UomConversionDatedData UomConversionDated_USD_USD_ = UomConversionDatedData.newBuilder()
        .setConversionFactor(1)
        .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
        .setUomId("USD")
        .setUomIdTo("USD")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_112000_9301_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("50"))
        .setFromDate(getTimestamp("2009-07-08 11:54:03.8"))
        .setGlAccountCategoryId("9301")
        .setGlAccountId("112000")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_112000_9302_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("20"))
        .setFromDate(getTimestamp("2009-07-08 11:54:03.8"))
        .setGlAccountCategoryId("9302")
        .setGlAccountId("112000")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_112000_9303_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("30"))
        .setFromDate(getTimestamp("2009-07-08 11:54:03.8"))
        .setGlAccountCategoryId("9303")
        .setGlAccountId("112000")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_140000_9301_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("50"))
        .setFromDate(getTimestamp("2009-05-08 11:54:03.8"))
        .setGlAccountCategoryId("9301")
        .setGlAccountId("140000")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_140000_9302_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("20"))
        .setFromDate(getTimestamp("2009-06-08 11:54:03.8"))
        .setGlAccountCategoryId("9302")
        .setGlAccountId("140000")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_140000_9303_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("30"))
        .setFromDate(getTimestamp("2009-07-08 11:54:03.8"))
        .setGlAccountCategoryId("9303")
        .setGlAccountId("140000")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_516100_9301_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("50"))
        .setFromDate(getTimestamp("2009-06-08 11:54:03.8"))
        .setGlAccountCategoryId("9301")
        .setGlAccountId("516100")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_516100_9302_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("20"))
        .setFromDate(getTimestamp("2009-08-08 11:54:03.8"))
        .setGlAccountCategoryId("9302")
        .setGlAccountId("516100")
        .build();


    public final static GlAccountCategoryMemberData GlAccountCategoryMember_516100_9303_ = GlAccountCategoryMemberData.newBuilder()
        .setAmountPercentage(getFixedPoint("30"))
        .setFromDate(getTimestamp("2009-07-08 11:54:03.8"))
        .setGlAccountCategoryId("9303")
        .setGlAccountId("516100")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INVOICE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("INVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("INV_PROMOTION_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("INV_DISCOUNT_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_FEE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("804000")
        .setInvoiceItemTypeId("FEE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("INV_MISC_CHARGE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_SHIPPING_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("INV_SHIPPING_CHARGES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("INV_SURCHARGE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("INV_ADD_FEATURE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("INV_WARRANTY_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_INTRST_CHRG = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("810000")
        .setInvoiceItemTypeId("INV_INTRST_CHRG")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INVOICE_ITM_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("INVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("ITM_PROMOTION_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("ITM_REPLACE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("ITM_DISCOUNT_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_FEE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("804000")
        .setInvoiceItemTypeId("ITM_FEE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("ITM_MISC_CHARGE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_SALES_TAX = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("224100")
        .setInvoiceItemTypeId("ITM_SALES_TAX")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_SHIPPING_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("ITM_SHIPPING_CHARGES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("ITM_SURCHARGE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("ITM_ADD_FEATURE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("ITM_WARRANTY_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_FPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_DPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_FDPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_PROD_FEATR_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_SPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("INV_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINVOICE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINV_PROMOTION_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINV_DISCOUNT_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_P_FEE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("P_FEE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINV_MISC_CHARGE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SALES_TAX = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINV_SALES_TAX")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SHIP_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("510000")
        .setInvoiceItemTypeId("PINV_SHIP_CHARGES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINV_SURCHARGE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINV_ADD_FEATURE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINV_WARRANTY_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINVOICE_ITM_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_PROMOTION_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_REPLACE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_DISCOUNT_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_FEE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_FEE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_MISC_CHARGE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_SALES_TAX = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_SALES_TAX")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_SHIP_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("510000")
        .setInvoiceItemTypeId("PITM_SHIP_CHARGES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_SURCHARGE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_ADD_FEATURE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("516100")
        .setInvoiceItemTypeId("PITM_WARRANTY_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("214000")
        .setInvoiceItemTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("214000")
        .setInvoiceItemTypeId("PINV_FPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("500000")
        .setInvoiceItemTypeId("PINV_DPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("214000")
        .setInvoiceItemTypeId("PINV_FDPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("214000")
        .setInvoiceItemTypeId("PINV_PROD_FEATR_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_RPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("214000")
        .setInvoiceItemTypeId("PINV_RPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("500000")
        .setInvoiceItemTypeId("PINV_SPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_INVPRD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("650000")
        .setInvoiceItemTypeId("PINV_INVPRD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SUPLPRD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("650000")
        .setInvoiceItemTypeId("PINV_SUPLPRD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_FXASTPRD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("650000")
        .setInvoiceItemTypeId("PINV_FXASTPRD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("140000")
        .setInvoiceItemTypeId("PINV_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("140000")
        .setInvoiceItemTypeId("PINV_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("421000")
        .setInvoiceItemTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("421000")
        .setInvoiceItemTypeId("CRT_FPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("421000")
        .setInvoiceItemTypeId("CRT_DPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("421000")
        .setInvoiceItemTypeId("CRT_FDPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_RPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("421000")
        .setInvoiceItemTypeId("CRT_RPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("421000")
        .setInvoiceItemTypeId("CRT_PROD_FEATR_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("421000")
        .setInvoiceItemTypeId("CRT_SPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("424000")
        .setInvoiceItemTypeId("CRT_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("424000")
        .setInvoiceItemTypeId("CRT_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("422000")
        .setInvoiceItemTypeId("CRT_PROMOTION_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_REPLACE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_DISCOUNT_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_FEE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_FEE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_MISC_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_MISC_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_SHIPPING_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_SHIPPING_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_SURCHARGE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_ADD_FEATURE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_ADD_FEATURE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_WARRANTY_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_MKTG_PKG_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_MKTG_PKG_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_MAN_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("423000")
        .setInvoiceItemTypeId("CRT_MAN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_FPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_DPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_FDPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_RPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_RPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_PROD_FEATR_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_SPROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("401000")
        .setInvoiceItemTypeId("SRT_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("410000")
        .setInvoiceItemTypeId("SRT_PROMOTION_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_REPLACE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_DISCOUNT_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_FEE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_FEE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_MISC_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_MISC_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_SHIPPING_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_SHIPPING_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_SURCHARGE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_ADD_FEATURE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_ADD_FEATURE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_WARRANTY_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_MKTG_PKG_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_MKTG_PKG_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_MAN_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("409000")
        .setInvoiceItemTypeId("SRT_MAN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_COMM_INV_ITEM = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601300")
        .setInvoiceItemTypeId("COMM_INV_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_COMM_INV_ADJ = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601400")
        .setInvoiceItemTypeId("COMM_INV_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_HRLY_RATE = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601100")
        .setInvoiceItemTypeId("PAYROL_HRLY_RATE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_HRLY_RATE_SIC = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("603100")
        .setInvoiceItemTypeId("PAYROL_HRLY_RATE_SIC")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SALARY = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601100")
        .setInvoiceItemTypeId("PAYROL_SALARY")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SALARY_SICK = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("603100")
        .setInvoiceItemTypeId("PAYROL_SALARY_SICK")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SALARY_VAC = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("602100")
        .setInvoiceItemTypeId("PAYROL_SALARY_VAC")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_BONUS = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601000")
        .setInvoiceItemTypeId("PAYROL_BONUS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_COMMISSION = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601300")
        .setInvoiceItemTypeId("PAYROL_COMMISSION")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_ADV_PAY = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601100")
        .setInvoiceItemTypeId("PAYROL_ADV_PAY")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_MIL_REIMB = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601000")
        .setInvoiceItemTypeId("PAYROL_MIL_REIMB")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_OFF_EXP_REIMB = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601000")
        .setInvoiceItemTypeId("PAYROL_OFF_EXP_REIMB")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_PAYPER_OVRPAY = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601100")
        .setInvoiceItemTypeId("PAYROL_PAYPER_OVRPAY")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_PAYPER_PAY = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("601100")
        .setInvoiceItemTypeId("PAYROL_PAYPER_PAY")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_FROM_GROSS = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_125COMPY = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_125COMPY")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_125PPO = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_125PPO")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_125HSA = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_125HSA")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_401K = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_401K")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_REPAY = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_REPAY")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_CHAR_DONAT = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_CHAR_DONAT")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_CHILD_SUPP = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_CHILD_SUPP")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_MISC = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_MISC")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_ROTH_401K = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_ROTH_401K")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_SIMP_IRA = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_SIMP_IRA")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_UNION = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_UNION")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_SAL_TIMOFF = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_SAL_TIMOFF")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_WAG_GARN = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("605000")
        .setInvoiceItemTypeId("PAYROL_DD_WAG_GARN")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAXES = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("604000")
        .setInvoiceItemTypeId("PAYROL_TAXES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAX_FEDERAL = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("604000")
        .setInvoiceItemTypeId("PAYROL_TAX_FEDERAL")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SOC_SEC_EMPL = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("604000")
        .setInvoiceItemTypeId("PAYROL_SOC_SEC_EMPL")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAX_MED_EMPL = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("604000")
        .setInvoiceItemTypeId("PAYROL_TAX_MED_EMPL")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAX_MD_WITHOL = InvoiceItemTypeData.newBuilder()
        .setDefaultGlAccountId("604000")
        .setInvoiceItemTypeId("PAYROL_TAX_MD_WITHOL")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_CUSTOMER_REFUND_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("CUSTOMER_CREDIT")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("CUSTOMER_REFUND")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_VENDOR_PAYMENT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("ACCPAYABLE_UNAPPLIED")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("VENDOR_PAYMENT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_VENDOR_PREPAY_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("PREPAID_EXPENSES")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("VENDOR_PREPAY")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_COMMISSION_PAYMENT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("COMMISSIONS_PAYABLE")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("COMMISSION_PAYMENT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_PAY_CHECK_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("ACCPAYABLE_UNAPPLIED")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("PAY_CHECK")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_GC_WITHDRAWAL_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("CUSTOMER_CREDIT")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("GC_WITHDRAWAL")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_SALES_TAX_PAYMENT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("ACCPAYABLE_UNAPPLIED")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("SALES_TAX_PAYMENT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_PAYROL_PAYMENT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("OPERATING_EXPENSE")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("PAYROL_PAYMENT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_PAYROLL_TAX_PAYMENT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("TAX_ACCOUNT")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("PAYROLL_TAX_PAYMENT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_INCOME_TAX_PAYMENT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("TAX_ACCOUNT")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("INCOME_TAX_PAYMENT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_CUSTOMER_PAYMENT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("ACCREC_UNAPPLIED")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("CUSTOMER_PAYMENT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_CUSTOMER_DEPOSIT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("CUSTOMER_DEPOSIT")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("CUSTOMER_DEPOSIT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_INTEREST_RECEIPT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("INTRSTINC_RECEIVABLE")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("INTEREST_RECEIPT")
        .build();


    public final static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_GC_DEPOSIT_Company = PaymentGlAccountTypeMapData.newBuilder()
        .setGlAccountTypeId("CUSTOMER_DEPOSIT")
        .setOrganizationPartyId("Company")
        .setPaymentTypeId("GC_DEPOSIT")
        .build();

}
