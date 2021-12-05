package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.OfbizSetupChartOfAccountsData.*;

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

public final class OfbizSetupChartOfAccountsDataList {
    public static final List<PaymentMethodTypeData> paymentMethodTypeList=ImmutableList.of(        
            PaymentMethodType_CREDIT_CARD,        
            PaymentMethodType_GIFT_CARD,        
            PaymentMethodType_GIFT_CERTIFICATE,        
            PaymentMethodType_CASH,        
            PaymentMethodType_EFT_ACCOUNT,        
            PaymentMethodType_FIN_ACCOUNT,        
            PaymentMethodType_PERSONAL_CHECK,        
            PaymentMethodType_COMPANY_CHECK,        
            PaymentMethodType_CERTIFIED_CHECK,        
            PaymentMethodType_MONEY_ORDER,        
            PaymentMethodType_COMPANY_ACCOUNT,        
            PaymentMethodType_EXT_BILLACT,        
            PaymentMethodType_EXT_COD,        
            PaymentMethodType_EXT_EBAY,        
            PaymentMethodType_EXT_OFFLINE,        
            PaymentMethodType_EXT_PAYPAL,        
            PaymentMethodType_EXT_WORLDPAY);

    public static final List<GlAccountCategoryData> glAccountCategoryList=ImmutableList.of(        
            GlAccountCategory_9301,        
            GlAccountCategory_9302,        
            GlAccountCategory_9303);

    public static final List<GlJournalData> glJournalList=ImmutableList.of(        
            GlJournal_ERROR_JOURNAL);

    public static final List<GlAccountOrganizationData> glAccountOrganizationList=ImmutableList.of(        
            GlAccountOrganization_100000_Company,        
            GlAccountOrganization_110000_Company,        
            GlAccountOrganization_111000_Company,        
            GlAccountOrganization_111100_Company,        
            GlAccountOrganization_111900_Company,        
            GlAccountOrganization_112000_Company,        
            GlAccountOrganization_120000_Company,        
            GlAccountOrganization_125000_Company,        
            GlAccountOrganization_121800_Company,        
            GlAccountOrganization_122000_Company,        
            GlAccountOrganization_122100_Company,        
            GlAccountOrganization_122200_Company,        
            GlAccountOrganization_122300_Company,        
            GlAccountOrganization_122500_Company,        
            GlAccountOrganization_126000_Company,        
            GlAccountOrganization_140000_Company,        
            GlAccountOrganization_141000_Company,        
            GlAccountOrganization_142000_Company,        
            GlAccountOrganization_150000_Company,        
            GlAccountOrganization_171000_Company,        
            GlAccountOrganization_174000_Company,        
            GlAccountOrganization_188000_Company,        
            GlAccountOrganization_210000_Company,        
            GlAccountOrganization_213000_Company,        
            GlAccountOrganization_213200_Company,        
            GlAccountOrganization_213300_Company,        
            GlAccountOrganization_213500_Company,        
            GlAccountOrganization_214000_Company,        
            GlAccountOrganization_215000_Company,        
            GlAccountOrganization_216000_Company,        
            GlAccountOrganization_221100_Company,        
            GlAccountOrganization_224000_Company,        
            GlAccountOrganization_224100_Company,        
            GlAccountOrganization_224106_Company,        
            GlAccountOrganization_224140_Company,        
            GlAccountOrganization_224151_Company,        
            GlAccountOrganization_224153_Company,        
            GlAccountOrganization_224209_Company,        
            GlAccountOrganization_231000_Company,        
            GlAccountOrganization_310000_Company,        
            GlAccountOrganization_336000_Company,        
            GlAccountOrganization_400000_Company,        
            GlAccountOrganization_401000_Company,        
            GlAccountOrganization_409000_Company,        
            GlAccountOrganization_410000_Company,        
            GlAccountOrganization_421000_Company,        
            GlAccountOrganization_422000_Company,        
            GlAccountOrganization_423000_Company,        
            GlAccountOrganization_424000_Company,        
            GlAccountOrganization_500000_Company,        
            GlAccountOrganization_510000_Company,        
            GlAccountOrganization_514000_Company,        
            GlAccountOrganization_515000_Company,        
            GlAccountOrganization_516100_Company,        
            GlAccountOrganization_518000_Company,        
            GlAccountOrganization_600000_Company,        
            GlAccountOrganization_601000_Company,        
            GlAccountOrganization_601100_Company,        
            GlAccountOrganization_601200_Company,        
            GlAccountOrganization_601300_Company,        
            GlAccountOrganization_601400_Company,        
            GlAccountOrganization_602100_Company,        
            GlAccountOrganization_602200_Company,        
            GlAccountOrganization_603100_Company,        
            GlAccountOrganization_603200_Company,        
            GlAccountOrganization_604000_Company,        
            GlAccountOrganization_605000_Company,        
            GlAccountOrganization_625000_Company,        
            GlAccountOrganization_649000_Company,        
            GlAccountOrganization_650000_Company,        
            GlAccountOrganization_675400_Company,        
            GlAccountOrganization_804000_Company,        
            GlAccountOrganization_810000_Company,        
            GlAccountOrganization_850000_Company,        
            GlAccountOrganization_900000_Company);

    public static final List<FinAccountTypeGlAccountData> finAccountTypeGlAccountList=ImmutableList.of(        
            FinAccountTypeGlAccount_GIFTCERT_ACCOUNT_Company,        
            FinAccountTypeGlAccount_DEPOSIT_ACCOUNT_Company,        
            FinAccountTypeGlAccount_BANK_ACCOUNT_Company,        
            FinAccountTypeGlAccount_INVESTMENT_ACCOUNT_Company);

    public static final List<CreditCardTypeGlAccountData> creditCardTypeGlAccountList=ImmutableList.of(        
            CreditCardTypeGlAccount_CCT_AMERICANEXPRESS_Company,        
            CreditCardTypeGlAccount_CCT_DINERSCLUB_Company,        
            CreditCardTypeGlAccount_CCT_DISCOVER_Company,        
            CreditCardTypeGlAccount_CCT_VISA_Company,        
            CreditCardTypeGlAccount_CCT_MASTERCARD_Company);

    public static final List<GlReconciliationData> glReconciliationList=ImmutableList.of(        
            GlReconciliation_9000,        
            GlReconciliation_9001);

    public static final List<PartyAcctgPreferenceData> partyAcctgPreferenceList=ImmutableList.of(        
            PartyAcctgPreference_Company);

    public static final List<PaymentMethodTypeGlAccountData> paymentMethodTypeGlAccountList=ImmutableList.of(        
            PaymentMethodTypeGlAccount_GIFT_CERTIFICATE_Company,        
            PaymentMethodTypeGlAccount_CASH_Company,        
            PaymentMethodTypeGlAccount_EFT_ACCOUNT_Company,        
            PaymentMethodTypeGlAccount_FIN_ACCOUNT_Company,        
            PaymentMethodTypeGlAccount_PERSONAL_CHECK_Company,        
            PaymentMethodTypeGlAccount_COMPANY_CHECK_Company,        
            PaymentMethodTypeGlAccount_CERTIFIED_CHECK_Company,        
            PaymentMethodTypeGlAccount_MONEY_ORDER_Company,        
            PaymentMethodTypeGlAccount_COMPANY_ACCOUNT_Company,        
            PaymentMethodTypeGlAccount_EXT_BILLACT_Company,        
            PaymentMethodTypeGlAccount_EXT_COD_Company,        
            PaymentMethodTypeGlAccount_EXT_EBAY_Company,        
            PaymentMethodTypeGlAccount_EXT_OFFLINE_Company,        
            PaymentMethodTypeGlAccount_EXT_PAYPAL_Company,        
            PaymentMethodTypeGlAccount_EXT_WORLDPAY_Company);

    public static final List<CostComponentCalcData> costComponentCalcList=ImmutableList.of(        
            CostComponentCalc_GEN_COST_CALC,        
            CostComponentCalc_TASK_COST_CALC);

    public static final List<GlAccountTypeDefaultData> glAccountTypeDefaultList=ImmutableList.of(        
            GlAccountTypeDefault_ACCOUNTS_RECEIVABLE_Company,        
            GlAccountTypeDefault_ACCREC_UNAPPLIED_Company,        
            GlAccountTypeDefault_INTRSTINC_RECEIVABLE_Company,        
            GlAccountTypeDefault_INVENTORY_XFER_OUT_Company,        
            GlAccountTypeDefault_INVENTORY_ACCOUNT_Company,        
            GlAccountTypeDefault_RAWMAT_INVENTORY_Company,        
            GlAccountTypeDefault_WIP_INVENTORY_Company,        
            GlAccountTypeDefault_PREPAID_EXPENSES_Company,        
            GlAccountTypeDefault_ACCOUNTS_PAYABLE_Company,        
            GlAccountTypeDefault_CUSTOMER_CREDIT_Company,        
            GlAccountTypeDefault_CUSTOMER_DEPOSIT_Company,        
            GlAccountTypeDefault_UNINVOICED_SHIP_RCPT_Company,        
            GlAccountTypeDefault_INVENTORY_XFER_IN_Company,        
            GlAccountTypeDefault_ACCPAYABLE_UNAPPLIED_Company,        
            GlAccountTypeDefault_COMMISSIONS_PAYABLE_Company,        
            GlAccountTypeDefault_RETAINED_EARNINGS_Company,        
            GlAccountTypeDefault_SALES_ACCOUNT_Company,        
            GlAccountTypeDefault_COGS_ACCOUNT_Company,        
            GlAccountTypeDefault_INV_ADJ_VAL_Company,        
            GlAccountTypeDefault_FX_GAIN_LOSS_ACCT_Company,        
            GlAccountTypeDefault_OPERATING_EXPENSE_Company,        
            GlAccountTypeDefault_PROFIT_LOSS_ACCOUNT_Company,        
            GlAccountTypeDefault_TAX_ACCOUNT_Company);

    public static final List<VarianceReasonGlAccountData> varianceReasonGlAccountList=ImmutableList.of(        
            VarianceReasonGlAccount_VAR_LOST_Company,        
            VarianceReasonGlAccount_VAR_STOLEN_Company,        
            VarianceReasonGlAccount_VAR_FOUND_Company,        
            VarianceReasonGlAccount_VAR_DAMAGED_Company,        
            VarianceReasonGlAccount_VAR_INTEGR_Company,        
            VarianceReasonGlAccount_VAR_SAMPLE_Company);

    public static final List<CustomTimePeriodData> customTimePeriodList=ImmutableList.of(        
            CustomTimePeriod_6010,        
            CustomTimePeriod_6011,        
            CustomTimePeriod_6012,        
            CustomTimePeriod_6013,        
            CustomTimePeriod_6014,        
            CustomTimePeriod_6015);

    public static final List<UomConversionDatedData> uomConversionDatedList=ImmutableList.of(        
            UomConversionDated_USD_EUR_,        
            UomConversionDated_EUR_USD_,        
            UomConversionDated_USD_USD_);

    public static final List<GlAccountCategoryMemberData> glAccountCategoryMemberList=ImmutableList.of(        
            GlAccountCategoryMember_112000_9301_,        
            GlAccountCategoryMember_112000_9302_,        
            GlAccountCategoryMember_112000_9303_,        
            GlAccountCategoryMember_140000_9301_,        
            GlAccountCategoryMember_140000_9302_,        
            GlAccountCategoryMember_140000_9303_,        
            GlAccountCategoryMember_516100_9301_,        
            GlAccountCategoryMember_516100_9302_,        
            GlAccountCategoryMember_516100_9303_);

    public static final List<InvoiceItemTypeData> invoiceItemTypeList=ImmutableList.of(        
            InvoiceItemType_INVOICE_ADJ,        
            InvoiceItemType_INV_PROMOTION_ADJ,        
            InvoiceItemType_INV_DISCOUNT_ADJ,        
            InvoiceItemType_FEE,        
            InvoiceItemType_INV_MISC_CHARGE,        
            InvoiceItemType_INV_SHIPPING_CHARGES,        
            InvoiceItemType_INV_SURCHARGE_ADJ,        
            InvoiceItemType_INV_ADD_FEATURE,        
            InvoiceItemType_INV_WARRANTY_ADJ,        
            InvoiceItemType_INV_INTRST_CHRG,        
            InvoiceItemType_INVOICE_ITM_ADJ,        
            InvoiceItemType_ITM_PROMOTION_ADJ,        
            InvoiceItemType_ITM_REPLACE_ADJ,        
            InvoiceItemType_ITM_DISCOUNT_ADJ,        
            InvoiceItemType_ITM_FEE,        
            InvoiceItemType_ITM_MISC_CHARGE,        
            InvoiceItemType_ITM_SALES_TAX,        
            InvoiceItemType_ITM_SHIPPING_CHARGES,        
            InvoiceItemType_ITM_SURCHARGE_ADJ,        
            InvoiceItemType_ITM_ADD_FEATURE,        
            InvoiceItemType_ITM_WARRANTY_ADJ,        
            InvoiceItemType_INV_PROD_ITEM,        
            InvoiceItemType_INV_FPROD_ITEM,        
            InvoiceItemType_INV_DPROD_ITEM,        
            InvoiceItemType_INV_FDPROD_ITEM,        
            InvoiceItemType_INV_PROD_FEATR_ITEM,        
            InvoiceItemType_INV_SPROD_ITEM,        
            InvoiceItemType_INV_WE_ITEM,        
            InvoiceItemType_INV_TE_ITEM,        
            InvoiceItemType_PINVOICE_ADJ,        
            InvoiceItemType_PINV_PROMOTION_ADJ,        
            InvoiceItemType_PINV_DISCOUNT_ADJ,        
            InvoiceItemType_P_FEE,        
            InvoiceItemType_PINV_MISC_CHARGE,        
            InvoiceItemType_PINV_SALES_TAX,        
            InvoiceItemType_PINV_SHIP_CHARGES,        
            InvoiceItemType_PINV_SURCHARGE_ADJ,        
            InvoiceItemType_PINV_ADD_FEATURE,        
            InvoiceItemType_PINV_WARRANTY_ADJ,        
            InvoiceItemType_PINVOICE_ITM_ADJ,        
            InvoiceItemType_PITM_PROMOTION_ADJ,        
            InvoiceItemType_PITM_REPLACE_ADJ,        
            InvoiceItemType_PITM_DISCOUNT_ADJ,        
            InvoiceItemType_PITM_FEE,        
            InvoiceItemType_PITM_MISC_CHARGE,        
            InvoiceItemType_PITM_SALES_TAX,        
            InvoiceItemType_PITM_SHIP_CHARGES,        
            InvoiceItemType_PITM_SURCHARGE_ADJ,        
            InvoiceItemType_PITM_ADD_FEATURE,        
            InvoiceItemType_PITM_WARRANTY_ADJ,        
            InvoiceItemType_PINV_PROD_ITEM,        
            InvoiceItemType_PINV_FPROD_ITEM,        
            InvoiceItemType_PINV_DPROD_ITEM,        
            InvoiceItemType_PINV_FDPROD_ITEM,        
            InvoiceItemType_PINV_PROD_FEATR_ITEM,        
            InvoiceItemType_PINV_RPROD_ITEM,        
            InvoiceItemType_PINV_SPROD_ITEM,        
            InvoiceItemType_PINV_INVPRD_ITEM,        
            InvoiceItemType_PINV_SUPLPRD_ITEM,        
            InvoiceItemType_PINV_FXASTPRD_ITEM,        
            InvoiceItemType_PINV_WE_ITEM,        
            InvoiceItemType_PINV_TE_ITEM,        
            InvoiceItemType_CRT_PROD_ITEM,        
            InvoiceItemType_CRT_FPROD_ITEM,        
            InvoiceItemType_CRT_DPROD_ITEM,        
            InvoiceItemType_CRT_FDPROD_ITEM,        
            InvoiceItemType_CRT_RPROD_ITEM,        
            InvoiceItemType_CRT_PROD_FEATR_ITEM,        
            InvoiceItemType_CRT_SPROD_ITEM,        
            InvoiceItemType_CRT_WE_ITEM,        
            InvoiceItemType_CRT_TE_ITEM,        
            InvoiceItemType_CRT_PROMOTION_ADJ,        
            InvoiceItemType_CRT_REPLACE_ADJ,        
            InvoiceItemType_CRT_DISCOUNT_ADJ,        
            InvoiceItemType_CRT_FEE_ADJ,        
            InvoiceItemType_CRT_MISC_ADJ,        
            InvoiceItemType_CRT_SHIPPING_ADJ,        
            InvoiceItemType_CRT_SURCHARGE_ADJ,        
            InvoiceItemType_CRT_ADD_FEATURE_ADJ,        
            InvoiceItemType_CRT_WARRANTY_ADJ,        
            InvoiceItemType_CRT_MKTG_PKG_ADJ,        
            InvoiceItemType_CRT_MAN_ADJ,        
            InvoiceItemType_SRT_PROD_ITEM,        
            InvoiceItemType_SRT_FPROD_ITEM,        
            InvoiceItemType_SRT_DPROD_ITEM,        
            InvoiceItemType_SRT_FDPROD_ITEM,        
            InvoiceItemType_SRT_RPROD_ITEM,        
            InvoiceItemType_SRT_PROD_FEATR_ITEM,        
            InvoiceItemType_SRT_SPROD_ITEM,        
            InvoiceItemType_SRT_WE_ITEM,        
            InvoiceItemType_SRT_TE_ITEM,        
            InvoiceItemType_SRT_PROMOTION_ADJ,        
            InvoiceItemType_SRT_REPLACE_ADJ,        
            InvoiceItemType_SRT_DISCOUNT_ADJ,        
            InvoiceItemType_SRT_FEE_ADJ,        
            InvoiceItemType_SRT_MISC_ADJ,        
            InvoiceItemType_SRT_SHIPPING_ADJ,        
            InvoiceItemType_SRT_SURCHARGE_ADJ,        
            InvoiceItemType_SRT_ADD_FEATURE_ADJ,        
            InvoiceItemType_SRT_WARRANTY_ADJ,        
            InvoiceItemType_SRT_MKTG_PKG_ADJ,        
            InvoiceItemType_SRT_MAN_ADJ,        
            InvoiceItemType_COMM_INV_ITEM,        
            InvoiceItemType_COMM_INV_ADJ,        
            InvoiceItemType_PAYROL_HRLY_RATE,        
            InvoiceItemType_PAYROL_HRLY_RATE_SIC,        
            InvoiceItemType_PAYROL_SALARY,        
            InvoiceItemType_PAYROL_SALARY_SICK,        
            InvoiceItemType_PAYROL_SALARY_VAC,        
            InvoiceItemType_PAYROL_BONUS,        
            InvoiceItemType_PAYROL_COMMISSION,        
            InvoiceItemType_PAYROL_ADV_PAY,        
            InvoiceItemType_PAYROL_MIL_REIMB,        
            InvoiceItemType_PAYROL_OFF_EXP_REIMB,        
            InvoiceItemType_PAYROL_PAYPER_OVRPAY,        
            InvoiceItemType_PAYROL_PAYPER_PAY,        
            InvoiceItemType_PAYROL_DD_FROM_GROSS,        
            InvoiceItemType_PAYROL_DD_125COMPY,        
            InvoiceItemType_PAYROL_DD_125PPO,        
            InvoiceItemType_PAYROL_DD_125HSA,        
            InvoiceItemType_PAYROL_DD_401K,        
            InvoiceItemType_PAYROL_DD_REPAY,        
            InvoiceItemType_PAYROL_DD_CHAR_DONAT,        
            InvoiceItemType_PAYROL_DD_CHILD_SUPP,        
            InvoiceItemType_PAYROL_DD_MISC,        
            InvoiceItemType_PAYROL_DD_ROTH_401K,        
            InvoiceItemType_PAYROL_DD_SIMP_IRA,        
            InvoiceItemType_PAYROL_DD_UNION,        
            InvoiceItemType_PAYROL_DD_SAL_TIMOFF,        
            InvoiceItemType_PAYROL_DD_WAG_GARN,        
            InvoiceItemType_PAYROL_TAXES,        
            InvoiceItemType_PAYROL_TAX_FEDERAL,        
            InvoiceItemType_PAYROL_SOC_SEC_EMPL,        
            InvoiceItemType_PAYROL_TAX_MED_EMPL,        
            InvoiceItemType_PAYROL_TAX_MD_WITHOL);

    public static final List<PaymentGlAccountTypeMapData> paymentGlAccountTypeMapList=ImmutableList.of(        
            PaymentGlAccountTypeMap_CUSTOMER_REFUND_Company,        
            PaymentGlAccountTypeMap_VENDOR_PAYMENT_Company,        
            PaymentGlAccountTypeMap_VENDOR_PREPAY_Company,        
            PaymentGlAccountTypeMap_COMMISSION_PAYMENT_Company,        
            PaymentGlAccountTypeMap_PAY_CHECK_Company,        
            PaymentGlAccountTypeMap_GC_WITHDRAWAL_Company,        
            PaymentGlAccountTypeMap_SALES_TAX_PAYMENT_Company,        
            PaymentGlAccountTypeMap_PAYROL_PAYMENT_Company,        
            PaymentGlAccountTypeMap_PAYROLL_TAX_PAYMENT_Company,        
            PaymentGlAccountTypeMap_INCOME_TAX_PAYMENT_Company,        
            PaymentGlAccountTypeMap_CUSTOMER_PAYMENT_Company,        
            PaymentGlAccountTypeMap_CUSTOMER_DEPOSIT_Company,        
            PaymentGlAccountTypeMap_INTEREST_RECEIPT_Company,        
            PaymentGlAccountTypeMap_GC_DEPOSIT_Company);

}
