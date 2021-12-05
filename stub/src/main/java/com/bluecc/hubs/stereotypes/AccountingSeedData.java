package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.PeriodTypeData;
import com.bluecc.hubs.stub.ProductAverageCostTypeData;
import com.bluecc.hubs.stub.PartyIdentificationTypeData;
import com.bluecc.hubs.stub.FixedAssetProductTypeData;
import com.bluecc.hubs.stub.RoleTypeData;
import com.bluecc.hubs.stub.AcctgTransTypeData;
import com.bluecc.hubs.stub.CustomMethodData;
import com.bluecc.hubs.stub.GlFiscalTypeData;
import com.bluecc.hubs.stub.InvoiceItemAssocTypeData;
import com.bluecc.hubs.stub.BudgetItemTypeData;
import com.bluecc.hubs.stub.BudgetTypeData;
import com.bluecc.hubs.stub.InvoiceItemTypeMapData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.hubs.stub.GlAccountTypeData;
import com.bluecc.hubs.stub.WorkEffortData;
import com.bluecc.hubs.stub.PaymentGroupTypeData;
import com.bluecc.hubs.stub.GlAccountCategoryTypeData;
import com.bluecc.hubs.stub.FixedAssetStdCostTypeData;
import com.bluecc.hubs.stub.PaymentTypeData;
import com.bluecc.hubs.stub.RateTypeData;
import com.bluecc.hubs.stub.InvoiceItemTypeData;
import com.bluecc.hubs.stub.FinAccountTypeData;
import com.bluecc.hubs.stub.GlResourceTypeData;
import com.bluecc.hubs.stub.InvoiceContentTypeData;
import com.bluecc.hubs.stub.PaymentMethodTypeData;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.GlAccountClassData;
import com.bluecc.hubs.stub.BudgetReviewResultTypeData;
import com.bluecc.hubs.stub.FinAccountTransTypeData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.TaxAuthorityRateTypeData;
import com.bluecc.hubs.stub.GoodIdentificationTypeData;
import com.bluecc.hubs.stub.TaxAuthorityAssocTypeData;
import com.bluecc.hubs.stub.InvoiceTypeData;
import com.bluecc.hubs.stub.GlAccountGroupTypeData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.FixedAssetIdentTypeData;
import com.bluecc.hubs.stub.AcctgTransEntryTypeData;
import com.bluecc.hubs.stub.GlXbrlClassData;
import com.bluecc.hubs.stub.EmplPositionTypeData;
import com.bluecc.hubs.stub.GlAccountGroupData;
import com.bluecc.hubs.stub.CustomMethodTypeData;
import com.bluecc.hubs.stub.CustomScreenTypeData;
import com.bluecc.hubs.stub.FixedAssetTypeData;
import com.bluecc.hubs.stub.PaymentGatewayConfigTypeData;
import com.bluecc.hubs.stub.SettlementTermData;

public final class AccountingSeedData {
    public final static PeriodTypeData PeriodType_RATE_HOUR = PeriodTypeData.newBuilder()
        .setDescription("Rate amount per Hour")
        .setPeriodLength(1)
        .setPeriodTypeId("RATE_HOUR")
        .setUomId("TF_hr")
        .build();


    public final static PeriodTypeData PeriodType_RATE_WEEK = PeriodTypeData.newBuilder()
        .setDescription("Rate amount per Week")
        .setPeriodLength(1)
        .setPeriodTypeId("RATE_WEEK")
        .setUomId("TF_wk")
        .build();


    public final static PeriodTypeData PeriodType_RATE_MONTH = PeriodTypeData.newBuilder()
        .setDescription("Rate amount per month")
        .setPeriodLength(1)
        .setPeriodTypeId("RATE_MONTH")
        .setUomId("TF_mon")
        .build();


    public final static PeriodTypeData PeriodType_RATE_QUARTER = PeriodTypeData.newBuilder()
        .setDescription("Rate amount per Quarter")
        .setPeriodLength(3)
        .setPeriodTypeId("RATE_QUARTER")
        .setUomId("TF_mon")
        .build();


    public final static ProductAverageCostTypeData ProductAverageCostType_SIMPLE_AVG_COST = ProductAverageCostTypeData.newBuilder()
        .setDescription("Simple Average Cost")
        .setHasTable(castIndicator("N"))
        .setProductAverageCostTypeId("SIMPLE_AVG_COST")
        .build();


    public final static ProductAverageCostTypeData ProductAverageCostType_WEIGHTED_AVG_COST = ProductAverageCostTypeData.newBuilder()
        .setDescription("Weighted Average Cost")
        .setHasTable(castIndicator("N"))
        .setProductAverageCostTypeId("WEIGHTED_AVG_COST")
        .build();


    public final static ProductAverageCostTypeData ProductAverageCostType_MOVING_AVG_COST = ProductAverageCostTypeData.newBuilder()
        .setDescription("Moving Average Cost")
        .setHasTable(castIndicator("N"))
        .setProductAverageCostTypeId("MOVING_AVG_COST")
        .build();


    public final static PartyIdentificationTypeData PartyIdentificationType_INVOICE_EXPORT = PartyIdentificationTypeData.newBuilder()
        .setDescription("replacement value for partyId in the invoice export function in accounting")
        .setPartyIdentificationTypeId("INVOICE_EXPORT")
        .build();


    public final static FixedAssetProductTypeData FixedAssetProductType_FAPT_USE = FixedAssetProductTypeData.newBuilder()
        .setDescription("Use of Asset")
        .setFixedAssetProductTypeId("FAPT_USE")
        .build();


    public final static FixedAssetProductTypeData FixedAssetProductType_FAPT_SALE = FixedAssetProductTypeData.newBuilder()
        .setDescription("Sale of Asset")
        .setFixedAssetProductTypeId("FAPT_SALE")
        .build();


    public final static RoleTypeData RoleType_BUDGET = RoleTypeData.newBuilder()
        .setDescription("Budget Roles Group (not to be assigned to parties)")
        .setHasTable(castIndicator("Y"))
        .setRoleTypeId("BUDGET")
        .build();


    public final static RoleTypeData RoleType_BUDGET_APPL = RoleTypeData.newBuilder()
        .setDescription("Budget Application")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("BUDGET")
        .setRoleTypeId("BUDGET_APPL")
        .build();


    public final static RoleTypeData RoleType_BUDGET_MGR = RoleTypeData.newBuilder()
        .setDescription("Budget Manager")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("BUDGET")
        .setRoleTypeId("BUDGET_MGR")
        .build();


    public final static RoleTypeData RoleType_BUDGET_RVR = RoleTypeData.newBuilder()
        .setDescription("Budget Reviewer")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("BUDGET")
        .setRoleTypeId("BUDGET_RVR")
        .build();


    public final static RoleTypeData RoleType_BUDGET_APPRV = RoleTypeData.newBuilder()
        .setDescription("Budget Approver")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("BUDGET")
        .setRoleTypeId("BUDGET_APPRV")
        .build();


    public final static RoleTypeData RoleType_FAM_ASSIGNEE = RoleTypeData.newBuilder()
        .setDescription("Fixed Asset Maint Assignee")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("FAM_ASSIGNEE")
        .build();


    public final static RoleTypeData RoleType_FAM_SUPPLIER = RoleTypeData.newBuilder()
        .setDescription("Maintenance Supplier or Service")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FAM_ASSIGNEE")
        .setRoleTypeId("FAM_SUPPLIER")
        .build();


    public final static RoleTypeData RoleType_FAM_MANAGER = RoleTypeData.newBuilder()
        .setDescription("Maintenance Manager or Supervisor")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FAM_ASSIGNEE")
        .setRoleTypeId("FAM_MANAGER")
        .build();


    public final static RoleTypeData RoleType_FAM_WORKER = RoleTypeData.newBuilder()
        .setDescription("Maintenance Worker")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FAM_ASSIGNEE")
        .setRoleTypeId("FAM_WORKER")
        .build();


    public final static AcctgTransTypeData AcctgTransType__NA_ = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("_NA_")
        .setDescription("Not Applicable")
        .setHasTable(castIndicator("N"))
        .build();


    public final static AcctgTransTypeData AcctgTransType_INTERNAL_ACCTG_TRANS = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("INTERNAL_ACCTG_TRANS")
        .setDescription("Internal")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static AcctgTransTypeData AcctgTransType_AMORTIZATION = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("AMORTIZATION")
        .setDescription("Amortization")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_DEPRECIATION = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("DEPRECIATION")
        .setDescription("Depreciation")
        .setHasTable(castIndicator("Y"))
        .setParentTypeId("INTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_CAPITALIZATION = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("CAPITALIZATION")
        .setDescription("Capitalization")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_INVENTORY = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("INVENTORY")
        .setDescription("Inventory")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_ITEM_VARIANCE = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("ITEM_VARIANCE")
        .setDescription("Inventory Item Variance")
        .setHasTable(castIndicator("Y"))
        .setParentTypeId("INTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_OTHER_INTERNAL = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("OTHER_INTERNAL")
        .setDescription("Other Internal")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_PERIOD_CLOSING = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("PERIOD_CLOSING")
        .setDescription("Period Closing")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_EXTERNAL_ACCTG_TRANS = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("EXTERNAL_ACCTG_TRANS")
        .setDescription("External")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static AcctgTransTypeData AcctgTransType_OBLIGATION_ACCTG_TRA = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("OBLIGATION_ACCTG_TRA")
        .setDescription("Obligation")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EXTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_CREDIT_LINE = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("CREDIT_LINE")
        .setDescription("Credit Line")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_CREDIT_MEMO = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("CREDIT_MEMO")
        .setDescription("Credit Memo")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_NOTE = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("NOTE")
        .setDescription("Note")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_OTHER_OBLIGATION = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("OTHER_OBLIGATION")
        .setDescription("Other Obligation")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_SALES = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("SALES")
        .setDescription("Sales")
        .setHasTable(castIndicator("Y"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_TAX_DUE = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("TAX_DUE")
        .setDescription("Tax Due")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_PAYMENT_ACCTG_TRANS = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("PAYMENT_ACCTG_TRANS")
        .setDescription("Payment")
        .setHasTable(castIndicator("Y"))
        .setParentTypeId("EXTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_DISBURSEMENT = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("DISBURSEMENT")
        .setDescription("Disbursement")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PAYMENT_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_RECEIPT = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("RECEIPT")
        .setDescription("Receipt")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PAYMENT_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_INVENTORY_RETURN = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("INVENTORY_RETURN")
        .setDescription("Inventory from Return")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EXTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_SALES_INVOICE = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("SALES_INVOICE")
        .setDescription("Sales Invoice")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_PURCHASE_INVOICE = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("PURCHASE_INVOICE")
        .setDescription("Purchase Invoice")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_CUST_RTN_INVOICE = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("CUST_RTN_INVOICE")
        .setDescription("Customer Return")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OBLIGATION_ACCTG_TRA")
        .build();


    public final static AcctgTransTypeData AcctgTransType_SALES_SHIPMENT = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("SALES_SHIPMENT")
        .setDescription("Sales Shipment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EXTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_SHIPMENT_RECEIPT = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("SHIPMENT_RECEIPT")
        .setDescription("Shipment Receipt")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EXTERNAL_ACCTG_TRANS")
        .build();


    public final static AcctgTransTypeData AcctgTransType_MANUFACTURING = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("MANUFACTURING")
        .setDescription("Manufacturing")
        .setHasTable(castIndicator("N"))
        .build();


    public final static AcctgTransTypeData AcctgTransType_INCOMING_PAYMENT = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("INCOMING_PAYMENT")
        .setDescription("Incoming Payment")
        .setHasTable(castIndicator("N"))
        .build();


    public final static AcctgTransTypeData AcctgTransType_OUTGOING_PAYMENT = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("OUTGOING_PAYMENT")
        .setDescription("Outgoing Payment")
        .setHasTable(castIndicator("N"))
        .build();


    public final static AcctgTransTypeData AcctgTransType_PAYMENT_APPL = AcctgTransTypeData.newBuilder()
        .setAcctgTransTypeId("PAYMENT_APPL")
        .setDescription("Payment Applied")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_TEST")
        .setCustomMethodName("testCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Test authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_CAPTURE_TST = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_CAPTURE_TST")
        .setCustomMethodName("testCCProcessorWithCapture")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Test authorize and capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_RANDOM_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_RANDOM_TEST")
        .setCustomMethodName("testRandomAuthorize")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Test random authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_AIM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_AIM")
        .setCustomMethodName("aimCCAuth")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Authorize dot net authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_CAPTURE_AIM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_CAPTURE_AIM")
        .setCustomMethodName("aimCCAuthCapture")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Authorize dot net authorize and capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_CLEARCOMMERC = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_CLEARCOMMERC")
        .setCustomMethodName("clearCommerceCCAuth")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Clear Commerce authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_CLEARCOM_REP = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_CLEARCOM_REP")
        .setCustomMethodName("clearCommerceCCReport")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Clear Commerce authorize reporting facility")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_CYBERSOURCE = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_CYBERSOURCE")
        .setCustomMethodName("cyberSourceCCAuth")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC CyberSource authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_PAYFLOW = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_PAYFLOW")
        .setCustomMethodName("payflowCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Payflow Pro authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_PCCHARGE = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_PCCHARGE")
        .setCustomMethodName("pcChargeCCAuth")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC PCCharge authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_RITA = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_RITA")
        .setCustomMethodName("ritaCCAuth")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC RiTA authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_RITA_REMOTE = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_RITA_REMOTE")
        .setCustomMethodName("ritaCCAuthRemote")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC RiTA remote authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ALWAYSAPPROV = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ALWAYSAPPROV")
        .setCustomMethodName("alwaysApproveCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ALWAYSDECLIN = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ALWAYSDECLIN")
        .setCustomMethodName("alwaysDeclineCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always decline")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ALWAYSNSF = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ALWAYSNSF")
        .setCustomMethodName("alwaysNsfCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always decline for not sufficient funds")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ALWAYSBAD = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ALWAYSBAD")
        .setCustomMethodName("alwaysBadExpireCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always decline for fail/bad expire date")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ALWAYSEVEN = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ALWAYSEVEN")
        .setCustomMethodName("badExpireEvenCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always decline for fail/bad expire date when year is even")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ALWAYSBADNUM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ALWAYSBADNUM")
        .setCustomMethodName("alwaysBadCardNumberCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always decline for bad card number")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ALWAYSFAIL = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ALWAYSFAIL")
        .setCustomMethodName("alwaysBadCardNumberCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always fail")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_CAPTURE_ALWA = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_CAPTURE_ALWA")
        .setCustomMethodName("alwaysApproveWithCaptureCCProcessor")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Always authorize and capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_ORBITAL = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_ORBITAL")
        .setCustomMethodName("orbitalCCAuth")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Orbital authorize")
        .build();


    public final static CustomMethodData CustomMethod_CC_AUTH_CAPTR_ORBTL = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_AUTH_CAPTR_ORBTL")
        .setCustomMethodName("orbitalCCAuthCapture")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("CC Orbital authorize and capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_TEST")
        .setCustomMethodName("testCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC Test capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_REAUTH = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_REAUTH")
        .setCustomMethodName("testCCCaptureWithReAuth")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC Test reauth capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_ALWAYSDEC = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_ALWAYSDEC")
        .setCustomMethodName("testCCProcessorCaptureAlwaysDecline")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC Always decline capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_AIM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_AIM")
        .setCustomMethodName("aimCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC Authorize dot net capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_CLEARCOMM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_CLEARCOMM")
        .setCustomMethodName("clearCommerceCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC Clear Commerce capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_CYBERSOUR = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_CYBERSOUR")
        .setCustomMethodName("cyberSourceCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC CyberSource capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_PAYFLOW = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_PAYFLOW")
        .setCustomMethodName("payflowCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC Payflow Pro capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_PCCHARGE = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_PCCHARGE")
        .setCustomMethodName("pcChargeCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC PCCharge capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_RITA = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_RITA")
        .setCustomMethodName("ritaCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC RiTA capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_RITA_REMO = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_RITA_REMO")
        .setCustomMethodName("ritaCCCaptureRemote")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC RiTA remote capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_CAPTURE_ORBITAL = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CAPTURE_ORBITAL")
        .setCustomMethodName("orbitalCCCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("CC Orbital capture")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_TEST")
        .setCustomMethodName("testCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC Test refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_TEST_FAIL = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_TEST_FAIL")
        .setCustomMethodName("testCCRefundFailure")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC Test refund failure")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_AIM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_AIM")
        .setCustomMethodName("aimCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC Authorize dot net refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_CLEARCOMME = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_CLEARCOMME")
        .setCustomMethodName("clearCommerceCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC Clear Commerce refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_CYBERSOURC = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_CYBERSOURC")
        .setCustomMethodName("cyberSourceCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC CyberSource refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_PAYFLOW = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_PAYFLOW")
        .setCustomMethodName("payflowCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC Payflow Pro refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_PCCHARGE = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_PCCHARGE")
        .setCustomMethodName("pcChargeCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC PCCharge refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_RITA = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_RITA")
        .setCustomMethodName("ritaCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC RiTA refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_RITA_REMOT = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_RITA_REMOT")
        .setCustomMethodName("ritaCCRefundRemote")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC RiTA remote refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_ORBITAL = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_ORBITAL")
        .setCustomMethodName("orbitalCCRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("CC Orbital refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_TEST")
        .setCustomMethodName("testCCRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC Test release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_AIM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_AIM")
        .setCustomMethodName("aimCCRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC Authorize dot net release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_CLEARCOMM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_CLEARCOMM")
        .setCustomMethodName("clearCommerceCCRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC Clear Commerce release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_CYBERSOUR = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_CYBERSOUR")
        .setCustomMethodName("cyberSourceCCRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC CyberSource release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_PAYFLOW = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_PAYFLOW")
        .setCustomMethodName("payflowCCVoid")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC Payflow Pro release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_PCCHARGE = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_PCCHARGE")
        .setCustomMethodName("pcChargeCCRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC PCCharge release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_RITA = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_RITA")
        .setCustomMethodName("ritaCCRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC RiTA release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_RITA_REMO = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_RITA_REMO")
        .setCustomMethodName("ritaCCReleaseRemote")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC RiTA remote release")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_ORBITAL = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_ORBITAL")
        .setCustomMethodName("orbitalCCRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("CC Orbital release")
        .build();


    public final static CustomMethodData CustomMethod_CC_CREDIT_AIM = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CREDIT_AIM")
        .setCustomMethodName("aimCCCredit")
        .setCustomMethodTypeId("CC_CREDIT")
        .setDescription("CC Authorize dot net credit")
        .build();


    public final static CustomMethodData CustomMethod_CC_CREDIT_CLEARCOMME = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CREDIT_CLEARCOMME")
        .setCustomMethodName("clearCommerceCCCredit")
        .setCustomMethodTypeId("CC_CREDIT")
        .setDescription("CC Clear Commerce credit")
        .build();


    public final static CustomMethodData CustomMethod_CC_CREDIT_CYBERSOURC = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CREDIT_CYBERSOURC")
        .setCustomMethodName("cyberSourceCCCredit")
        .setCustomMethodTypeId("CC_CREDIT")
        .setDescription("CC CyberSource credit")
        .build();


    public final static CustomMethodData CustomMethod_CC_CREDIT_RITA = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CREDIT_RITA")
        .setCustomMethodName("ritaCCCreditRefund")
        .setCustomMethodTypeId("CC_CREDIT")
        .setDescription("CC RiTA credit")
        .build();


    public final static CustomMethodData CustomMethod_EFT_AUTH_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("EFT_AUTH_TEST")
        .setCustomMethodName("testEFTProcessor")
        .setCustomMethodTypeId("EFT_AUTH")
        .setDescription("EFT test authorize")
        .build();


    public final static CustomMethodData CustomMethod_EFT_AUTH_ALWAYSAPPRO = CustomMethodData.newBuilder()
        .setCustomMethodId("EFT_AUTH_ALWAYSAPPRO")
        .setCustomMethodName("alwaysApproveEFTProcessor")
        .setCustomMethodTypeId("EFT_AUTH")
        .setDescription("EFT always authorize")
        .build();


    public final static CustomMethodData CustomMethod_EFT_AUTH_ALWAYSDECLI = CustomMethodData.newBuilder()
        .setCustomMethodId("EFT_AUTH_ALWAYSDECLI")
        .setCustomMethodName("alwaysDeclineEFTProcessor")
        .setCustomMethodTypeId("EFT_AUTH")
        .setDescription("EFT always decline")
        .build();


    public final static CustomMethodData CustomMethod_EFT_RELEASE_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("EFT_RELEASE_TEST")
        .setCustomMethodName("testEFTRelease")
        .setCustomMethodTypeId("EFT_RELEASE")
        .setDescription("EFT test release")
        .build();


    public final static CustomMethodData CustomMethod_FIN_AUTH_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("FIN_AUTH_OFBIZ")
        .setCustomMethodName("ofbFaAuthorize")
        .setCustomMethodTypeId("FIN_AUTH")
        .setDescription("FIN account authorize")
        .build();


    public final static CustomMethodData CustomMethod_FIN_CAPTURE_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("FIN_CAPTURE_OFBIZ")
        .setCustomMethodName("ofbFaCapture")
        .setCustomMethodTypeId("FIN_CAPTURE")
        .setDescription("FIN account capture")
        .build();


    public final static CustomMethodData CustomMethod_FIN_REFUND_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("FIN_REFUND_OFBIZ")
        .setCustomMethodName("ofbFaRefund")
        .setCustomMethodTypeId("FIN_REFUND")
        .setDescription("FIN account refund")
        .build();


    public final static CustomMethodData CustomMethod_FIN_RELEASE_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("FIN_RELEASE_OFBIZ")
        .setCustomMethodName("ofbFaRelease")
        .setCustomMethodTypeId("FIN_RELEASE")
        .setDescription("FIN account release")
        .build();


    public final static CustomMethodData CustomMethod_FIN_PURCH_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("FIN_PURCH_OFBIZ")
        .setCustomMethodName("createPartyFinAccountFromPurchase")
        .setCustomMethodTypeId("FIN_PURCHASE")
        .setDescription("FIN account purchase")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_AUTH_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_AUTH_OFBIZ")
        .setCustomMethodName("ofbGcAuthorize")
        .setCustomMethodTypeId("GIFT_AUTH")
        .setDescription("GIFT card authorize")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_AUTH_ALWAYSAPPR = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_AUTH_ALWAYSAPPR")
        .setCustomMethodName("alwaysApproveGCProcessor")
        .setCustomMethodTypeId("GIFT_AUTH")
        .setDescription("GIFT card always authorize")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_AUTH_ALWAYSDECL = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_AUTH_ALWAYSDECL")
        .setCustomMethodName("alwaysDeclineGCProcessor")
        .setCustomMethodTypeId("GIFT_AUTH")
        .setDescription("GIFT card always decline")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_AUTH_VALUELINK = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_AUTH_VALUELINK")
        .setCustomMethodName("valueLinkProcessor")
        .setCustomMethodTypeId("GIFT_AUTH")
        .setDescription("GIFT card ValueLink authorize")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_CAPTURE_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_CAPTURE_OFBIZ")
        .setCustomMethodName("ofbGcProcessor")
        .setCustomMethodTypeId("GIFT_CAPTURE")
        .setDescription("GIFT card capture")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_REFUND_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_REFUND_OFBIZ")
        .setCustomMethodName("ofbGcRefund")
        .setCustomMethodTypeId("GIFT_REFUND")
        .setDescription("GIFT card refund")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_REFUND_VALUELI = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_REFUND_VALUELI")
        .setCustomMethodName("valueLinkRefund")
        .setCustomMethodTypeId("GIFT_REFUND")
        .setDescription("GIFT card ValueLink refund")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_RELEASE_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_RELEASE_OFBIZ")
        .setCustomMethodName("ofbGcRelease")
        .setCustomMethodTypeId("GIFT_RELEASE")
        .setDescription("GIFT card release")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_RELEASE_TEST = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_RELEASE_TEST")
        .setCustomMethodName("testGCRelease")
        .setCustomMethodTypeId("GIFT_RELEASE")
        .setDescription("GIFT card test release")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_RELEASE_VALUEL = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_RELEASE_VALUEL")
        .setCustomMethodName("valueLinkRelease")
        .setCustomMethodTypeId("GIFT_RELEASE")
        .setDescription("GIFT card ValueLink release")
        .build();


    public final static CustomMethodData CustomMethod_GIFT_PURCH_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("GIFT_PURCH_OFBIZ")
        .setCustomMethodName("ofbGcPurchase")
        .setCustomMethodTypeId("GIFT_PURCHASE")
        .setDescription("GIFT card Purchase Fulfillment Service")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_AUTH_PFP = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_AUTH_PFP")
        .setCustomMethodName("payflowPayPalProcessor")
        .setCustomMethodTypeId("PAYPAL_AUTH")
        .setDescription("Payflow PayPal payment authorize")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_AUTH = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_AUTH")
        .setCustomMethodName("payPalProcessor")
        .setCustomMethodTypeId("PAYPAL_AUTH")
        .setDescription("PayPal payment authorize")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_CAPTURE_PFP = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_CAPTURE_PFP")
        .setCustomMethodName("payflowPayPalCapture")
        .setCustomMethodTypeId("PAYPAL_CAPTURE")
        .setDescription("Payflow PayPal payment capture")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_CAPTURE = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_CAPTURE")
        .setCustomMethodName("payPalCapture")
        .setCustomMethodTypeId("PAYPAL_CAPTURE")
        .setDescription("PayPal payment capture")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_REFUND_PFP = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_REFUND_PFP")
        .setCustomMethodName("payflowPayPalRefund")
        .setCustomMethodTypeId("PAYPAL_REFUND")
        .setDescription("Payflow PayPal payment refund")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_REFUND = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_REFUND")
        .setCustomMethodName("payPalRefund")
        .setCustomMethodTypeId("PAYPAL_REFUND")
        .setDescription("PayPal payment refund")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_RELEASE_PFP = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_RELEASE_PFP")
        .setCustomMethodName("payflowPayPalVoid")
        .setCustomMethodTypeId("PAYPAL_RELEASE")
        .setDescription("Payflow PayPal Order release")
        .build();


    public final static CustomMethodData CustomMethod_PAYPAL_RELEASE = CustomMethodData.newBuilder()
        .setCustomMethodId("PAYPAL_RELEASE")
        .setCustomMethodName("payPalVoid")
        .setCustomMethodTypeId("PAYPAL_RELEASE")
        .setDescription("PayPal Order Release")
        .build();


    public final static CustomMethodData CustomMethod_CC_CHARGE_EWAY = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_CHARGE_EWAY")
        .setCustomMethodName("ewayCharge")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("eWay CC Charge")
        .build();


    public final static CustomMethodData CustomMethod_CC_REFUND_EWAY = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_REFUND_EWAY")
        .setCustomMethodName("ewayRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("eWay CC Refund")
        .build();


    public final static CustomMethodData CustomMethod_CC_RELEASE_EWAY = CustomMethodData.newBuilder()
        .setCustomMethodId("CC_RELEASE_EWAY")
        .setCustomMethodName("ewayRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("eWay CC Release")
        .build();


    public final static CustomMethodData CustomMethod_SECURE_AUTH_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("SECURE_AUTH_OFBIZ")
        .setCustomMethodName("ofbScAuthorize")
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("SecurePay payment authorize")
        .build();


    public final static CustomMethodData CustomMethod_SECURE_CAPTURE_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("SECURE_CAPTURE_OFBIZ")
        .setCustomMethodName("ofbScCapture")
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("SecurePay payment capture")
        .build();


    public final static CustomMethodData CustomMethod_SECURE_REFUND_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("SECURE_REFUND_OFBIZ")
        .setCustomMethodName("ofbScRefund")
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("SecurePay payment refund")
        .build();


    public final static CustomMethodData CustomMethod_SECURE_RELEASE_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("SECURE_RELEASE_OFBIZ")
        .setCustomMethodName("ofbScRelease")
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("SecurePay payment release")
        .build();


    public final static CustomMethodData CustomMethod_SECURE_CREDIT_OFBIZ = CustomMethodData.newBuilder()
        .setCustomMethodId("SECURE_CREDIT_OFBIZ")
        .setCustomMethodName("ofbScCCCredit")
        .setCustomMethodTypeId("CC_CREDIT")
        .setDescription("SecurePay Credit Card")
        .build();


    public final static CustomMethodData CustomMethod_INV_HOOK_ENF_SEQ = CustomMethodData.newBuilder()
        .setCustomMethodId("INV_HOOK_ENF_SEQ")
        .setCustomMethodName("invoiceSequenceEnforced")
        .setCustomMethodTypeId("INVOICE_HOOK")
        .setDescription("Enforced Sequence (no gaps, per organization)")
        .build();


    public final static CustomMethodData CustomMethod_INV_HOOK_RES_YR = CustomMethodData.newBuilder()
        .setCustomMethodId("INV_HOOK_RES_YR")
        .setCustomMethodName("invoiceSequenceRestart")
        .setCustomMethodTypeId("INVOICE_HOOK")
        .setDescription("Restart on Fiscal Year (no gaps, per org, reset to 1 each year)")
        .build();


    public final static CustomMethodData CustomMethod_QUOTE_HOOK_ENF_SEQ = CustomMethodData.newBuilder()
        .setCustomMethodId("QUOTE_HOOK_ENF_SEQ")
        .setCustomMethodName("quoteSequenceEnforced")
        .setCustomMethodTypeId("QUOTE_HOOK")
        .setDescription("Enforced Sequence (no gaps, per organization)")
        .build();


    public final static CustomMethodData CustomMethod_ORDER_HOOK_ENF_SEQ = CustomMethodData.newBuilder()
        .setCustomMethodId("ORDER_HOOK_ENF_SEQ")
        .setCustomMethodName("orderSequence_enforced")
        .setCustomMethodTypeId("ORDER_HOOK")
        .setDescription("Enforced Sequence (no gaps, per organization)")
        .build();


    public final static CustomMethodData CustomMethod_STR_LINE_DEP_FORMULA = CustomMethodData.newBuilder()
        .setCustomMethodId("STR_LINE_DEP_FORMULA")
        .setCustomMethodName("straightLineDepreciation")
        .setCustomMethodTypeId("DEPRECIATION_FORMULA")
        .setDescription("Straight Line depreciation algorithm for fixed asset ((purchaseCost - salvageCost)/expectedLifeInYears)")
        .build();


    public final static CustomMethodData CustomMethod_DBL_DECL_DEP_FORMULA = CustomMethodData.newBuilder()
        .setCustomMethodId("DBL_DECL_DEP_FORMULA")
        .setCustomMethodName("doubleDecliningBalanceDepreciation")
        .setCustomMethodTypeId("DEPRECIATION_FORMULA")
        .setDescription("Double decline depreciation algorithm for fixed asset ((NetBookValue - salvageCost)*2/remainingLifeInYears)")
        .build();


    public final static GlFiscalTypeData GlFiscalType_ACTUAL = GlFiscalTypeData.newBuilder()
        .setDescription("Actual")
        .setGlFiscalTypeId("ACTUAL")
        .build();


    public final static GlFiscalTypeData GlFiscalType_BUDGET = GlFiscalTypeData.newBuilder()
        .setDescription("Budget")
        .setGlFiscalTypeId("BUDGET")
        .build();


    public final static GlFiscalTypeData GlFiscalType_FORECAST = GlFiscalTypeData.newBuilder()
        .setDescription("Forecast")
        .setGlFiscalTypeId("FORECAST")
        .build();


    public final static GlFiscalTypeData GlFiscalType_PLAN = GlFiscalTypeData.newBuilder()
        .setDescription("Plan")
        .setGlFiscalTypeId("PLAN")
        .build();


    public final static GlFiscalTypeData GlFiscalType_SCENARIO = GlFiscalTypeData.newBuilder()
        .setDescription("Scenario")
        .setGlFiscalTypeId("SCENARIO")
        .build();


    public final static InvoiceItemAssocTypeData InvoiceItemAssocType_COMMISSION_INVOICE = InvoiceItemAssocTypeData.newBuilder()
        .setDescription("Commission")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemAssocTypeId("COMMISSION_INVOICE")
        .build();


    public final static InvoiceItemAssocTypeData InvoiceItemAssocType_WITHDRAW_INVOICE = InvoiceItemAssocTypeData.newBuilder()
        .setDescription("Withdraw")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemAssocTypeId("WITHDRAW_INVOICE")
        .build();


    public final static BudgetItemTypeData BudgetItemType_REQUIREMENT_BUDGET_A = BudgetItemTypeData.newBuilder()
        .setBudgetItemTypeId("REQUIREMENT_BUDGET_A")
        .setDescription("Requirement")
        .setHasTable(castIndicator("Y"))
        .build();


    public final static BudgetTypeData BudgetType_CAPITAL_BUDGET = BudgetTypeData.newBuilder()
        .setBudgetTypeId("CAPITAL_BUDGET")
        .setDescription("Capital")
        .setHasTable(castIndicator("N"))
        .build();


    public final static BudgetTypeData BudgetType_OPERATING_BUDGET = BudgetTypeData.newBuilder()
        .setBudgetTypeId("OPERATING_BUDGET")
        .setDescription("Operating")
        .setHasTable(castIndicator("N"))
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_FINISHED_GOOD_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("FINISHED_GOOD")
        .setInvoiceItemTypeId("INV_FPROD_ITEM")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SERVICE_PRODUCT_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SERVICE_PRODUCT")
        .setInvoiceItemTypeId("INV_SPROD_ITEM")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SERVICE_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SERVICE")
        .setInvoiceItemTypeId("INV_SPROD_ITEM")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_DIGITAL_GOOD_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("DIGITAL_GOOD")
        .setInvoiceItemTypeId("INV_DPROD_ITEM")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_FINDIG_GOOD_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("FINDIG_GOOD")
        .setInvoiceItemTypeId("INV_FDPROD_ITEM")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_PROMOTION_ADJUSTMENT_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("PROMOTION_ADJUSTMENT")
        .setInvoiceItemTypeId("ITM_PROMOTION_ADJ")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_REPLACE_ADJUSTMENT_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("REPLACE_ADJUSTMENT")
        .setInvoiceItemTypeId("ITM_REPLACE_ADJ")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_DISCOUNT_ADJUSTMENT_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("DISCOUNT_ADJUSTMENT")
        .setInvoiceItemTypeId("ITM_DISCOUNT_ADJ")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_FEE_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("FEE")
        .setInvoiceItemTypeId("ITM_FEE")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_MISCELLANEOUS_CHARGE_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("MISCELLANEOUS_CHARGE")
        .setInvoiceItemTypeId("ITM_MISC_CHARGE")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SALES_TAX_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SALES_TAX")
        .setInvoiceItemTypeId("ITM_SALES_TAX")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SHIPPING_CHARGES_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SHIPPING_CHARGES")
        .setInvoiceItemTypeId("ITM_SHIPPING_CHARGES")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SURCHARGE_ADJUSTMENT_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SURCHARGE_ADJUSTMENT")
        .setInvoiceItemTypeId("ITM_SURCHARGE_ADJ")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_ADDITIONAL_FEATURE_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("ADDITIONAL_FEATURE")
        .setInvoiceItemTypeId("ITM_ADD_FEATURE")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_WARRANTY_ADJUSTMENT_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("WARRANTY_ADJUSTMENT")
        .setInvoiceItemTypeId("ITM_WARRANTY_ADJ")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_VAT_TAX_SALES_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("VAT_TAX")
        .setInvoiceItemTypeId("ITM_VAT_TAX")
        .setInvoiceTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_INVENTORY_ORDER_ITEM_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("INVENTORY_ORDER_ITEM")
        .setInvoiceItemTypeId("PINV_INVPRD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SUPPLIES_ORDER_ITEM_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SUPPLIES_ORDER_ITEM")
        .setInvoiceItemTypeId("PINV_SUPLPRD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_ASSET_ORDER_ITEM_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("ASSET_ORDER_ITEM")
        .setInvoiceItemTypeId("PINV_FXASTPRD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_FINISHED_GOOD_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("FINISHED_GOOD")
        .setInvoiceItemTypeId("PINV_FPROD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_DIGITAL_GOOD_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("DIGITAL_GOOD")
        .setInvoiceItemTypeId("PINV_DPROD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_FINDIG_GOOD_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("FINDIG_GOOD")
        .setInvoiceItemTypeId("PINV_FDPROD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SERVICE_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SERVICE")
        .setInvoiceItemTypeId("PINV_SPROD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RAW_MATERIAL_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RAW_MATERIAL")
        .setInvoiceItemTypeId("PINV_RPROD_ITEM")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_PROMOTION_ADJUSTMENT_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("PROMOTION_ADJUSTMENT")
        .setInvoiceItemTypeId("PITM_PROMOTION_ADJ")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_REPLACE_ADJUSTMENT_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("REPLACE_ADJUSTMENT")
        .setInvoiceItemTypeId("PITM_REPLACE_ADJ")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_DISCOUNT_ADJUSTMENT_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("DISCOUNT_ADJUSTMENT")
        .setInvoiceItemTypeId("PITM_DISCOUNT_ADJ")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_FEE_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("FEE")
        .setInvoiceItemTypeId("PITM_FEE")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_MISCELLANEOUS_CHARGE_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("MISCELLANEOUS_CHARGE")
        .setInvoiceItemTypeId("PITM_MISC_CHARGE")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SALES_TAX_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SALES_TAX")
        .setInvoiceItemTypeId("PITM_SALES_TAX")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SHIPPING_CHARGES_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SHIPPING_CHARGES")
        .setInvoiceItemTypeId("PITM_SHIP_CHARGES")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_SURCHARGE_ADJUSTMENT_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("SURCHARGE_ADJUSTMENT")
        .setInvoiceItemTypeId("PITM_SURCHARGE_ADJ")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_ADDITIONAL_FEATURE_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("ADDITIONAL_FEATURE")
        .setInvoiceItemTypeId("PITM_ADD_FEATURE")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_WARRANTY_ADJUSTMENT_PURCHASE_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("WARRANTY_ADJUSTMENT")
        .setInvoiceItemTypeId("PITM_WARRANTY_ADJ")
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_FPROD_ITEM_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_FPROD_ITEM")
        .setInvoiceItemTypeId("CRT_FPROD_ITEM")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_DPROD_ITEM_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_DPROD_ITEM")
        .setInvoiceItemTypeId("CRT_DPROD_ITEM")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_FDPROD_ITEM_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_FDPROD_ITEM")
        .setInvoiceItemTypeId("CRT_FDPROD_ITEM")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_RPROD_ITEM_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_RPROD_ITEM")
        .setInvoiceItemTypeId("CRT_RPROD_ITEM")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_PROMOTION_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_PROMOTION_ADJ")
        .setInvoiceItemTypeId("CRT_PROMOTION_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_REPLACE_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_REPLACE_ADJ")
        .setInvoiceItemTypeId("CRT_REPLACE_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_DISCOUNT_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_DISCOUNT_ADJ")
        .setInvoiceItemTypeId("CRT_DISCOUNT_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_FEE_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_FEE_ADJ")
        .setInvoiceItemTypeId("CRT_FEE_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_MISC_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_MISC_ADJ")
        .setInvoiceItemTypeId("CRT_MISC_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_SALES_TAX_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_SALES_TAX_ADJ")
        .setInvoiceItemTypeId("CRT_SALES_TAX_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_VAT_TAX_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_VAT_TAX_ADJ")
        .setInvoiceItemTypeId("CRT_VAT_TAX_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_VAT_PC_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_VAT_PC_ADJ")
        .setInvoiceItemTypeId("CRT_VAT_PC_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_SHIPPING_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_SHIPPING_ADJ")
        .setInvoiceItemTypeId("CRT_SHIPPING_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_SURCHARGE_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_SURCHARGE_ADJ")
        .setInvoiceItemTypeId("CRT_SURCHARGE_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_ADD_FEATURE_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_ADD_FEATURE_ADJ")
        .setInvoiceItemTypeId("CRT_ADD_FEATURE_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_WARRANTY_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_WARRANTY_ADJ")
        .setInvoiceItemTypeId("CRT_WARRANTY_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_MAN_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_MAN_ADJ")
        .setInvoiceItemTypeId("CRT_MAN_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_MKTG_PKG_ADJ_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_MKTG_PKG_ADJ")
        .setInvoiceItemTypeId("CRT_MKTG_PKG_ADJ")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_SPROD_ITEM_CUST_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_SPROD_ITEM")
        .setInvoiceItemTypeId("CRT_SPROD_ITEM")
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_FPROD_ITEM_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_FPROD_ITEM")
        .setInvoiceItemTypeId("SRT_FPROD_ITEM")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_DPROD_ITEM_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_DPROD_ITEM")
        .setInvoiceItemTypeId("SRT_DPROD_ITEM")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_FDPROD_ITEM_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_FDPROD_ITEM")
        .setInvoiceItemTypeId("SRT_FDPROD_ITEM")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_RPROD_ITEM_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_RPROD_ITEM")
        .setInvoiceItemTypeId("SRT_RPROD_ITEM")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_PROMOTION_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_PROMOTION_ADJ")
        .setInvoiceItemTypeId("SRT_PROMOTION_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_REPLACE_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_REPLACE_ADJ")
        .setInvoiceItemTypeId("SRT_REPLACE_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_DISCOUNT_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_DISCOUNT_ADJ")
        .setInvoiceItemTypeId("SRT_DISCOUNT_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_FEE_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_FEE_ADJ")
        .setInvoiceItemTypeId("SRT_FEE_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_MISC_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_MISC_ADJ")
        .setInvoiceItemTypeId("SRT_MISC_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_SALES_TAX_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_SALES_TAX_ADJ")
        .setInvoiceItemTypeId("SRT_SALES_TAX_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_VAT_TAX_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_VAT_TAX_ADJ")
        .setInvoiceItemTypeId("SRT_VAT_TAX_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_VAT_PC_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_VAT_PC_ADJ")
        .setInvoiceItemTypeId("SRT_VAT_PC_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_SHIPPING_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_SHIPPING_ADJ")
        .setInvoiceItemTypeId("SRT_SHIPPING_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_SURCHARGE_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_SURCHARGE_ADJ")
        .setInvoiceItemTypeId("SRT_SURCHARGE_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_ADD_FEATURE_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_ADD_FEATURE_ADJ")
        .setInvoiceItemTypeId("SRT_ADD_FEATURE_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_WARRANTY_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_WARRANTY_ADJ")
        .setInvoiceItemTypeId("SRT_WARRANTY_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_MAN_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_MAN_ADJ")
        .setInvoiceItemTypeId("SRT_MAN_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_RET_MKTG_PKG_ADJ_PURC_RTN_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("RET_MKTG_PKG_ADJ")
        .setInvoiceItemTypeId("SRT_MKTG_PKG_ADJ")
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_COM_COMM_ITEM_COMMISSION_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("COM_COMM_ITEM")
        .setInvoiceItemTypeId("COMM_INV_ITEM")
        .setInvoiceTypeId("COMMISSION_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_COM_COMM_ADJ_COMMISSION_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("COM_COMM_ADJ")
        .setInvoiceItemTypeId("COMM_INV_ADJ")
        .setInvoiceTypeId("COMMISSION_INVOICE")
        .build();


    public final static InvoiceItemTypeMapData InvoiceItemTypeMap_INT_INV_CHRG_INTEREST_INVOICE = InvoiceItemTypeMapData.newBuilder()
        .setInvoiceItemMapKey("INT_INV_CHRG")
        .setInvoiceItemTypeId("INV_INTRST_CHRG")
        .setInvoiceTypeId("INTEREST_INVOICE")
        .build();


    public final static StatusItemData StatusItem_AES_NOT_RECONCILED = StatusItemData.newBuilder()
        .setDescription("Not Reconciled")
        .setSequenceId("01")
        .setStatusCode("NOT_RECONCILED")
        .setStatusId("AES_NOT_RECONCILED")
        .setStatusTypeId("ACCTG_ENREC_STATUS")
        .build();


    public final static StatusItemData StatusItem_AES_PARTLY_RECON = StatusItemData.newBuilder()
        .setDescription("Partly Reconciled")
        .setSequenceId("02")
        .setStatusCode("PARTLY_RECONCILED")
        .setStatusId("AES_PARTLY_RECON")
        .setStatusTypeId("ACCTG_ENREC_STATUS")
        .build();


    public final static StatusItemData StatusItem_AES_RECONCILED = StatusItemData.newBuilder()
        .setDescription("Reconciled")
        .setSequenceId("03")
        .setStatusCode("RECONCILED")
        .setStatusId("AES_RECONCILED")
        .setStatusTypeId("ACCTG_ENREC_STATUS")
        .build();


    public final static StatusItemData StatusItem_FNACT_ACTIVE = StatusItemData.newBuilder()
        .setDescription("Active")
        .setSequenceId("01")
        .setStatusCode("ACTIVE")
        .setStatusId("FNACT_ACTIVE")
        .setStatusTypeId("FINACCT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FNACT_NEGPENDREPL = StatusItemData.newBuilder()
        .setDescription("Negative Pending Replenishment")
        .setSequenceId("02")
        .setStatusCode("NEGPENDREPL")
        .setStatusId("FNACT_NEGPENDREPL")
        .setStatusTypeId("FINACCT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FNACT_MANFROZEN = StatusItemData.newBuilder()
        .setDescription("Manually Frozen")
        .setSequenceId("03")
        .setStatusCode("MANFROZEN")
        .setStatusId("FNACT_MANFROZEN")
        .setStatusTypeId("FINACCT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FNACT_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("09")
        .setStatusCode("CANCELLED")
        .setStatusId("FNACT_CANCELLED")
        .setStatusTypeId("FINACCT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FINACT_TRNS_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("11")
        .setStatusCode("APPROVED")
        .setStatusId("FINACT_TRNS_APPROVED")
        .setStatusTypeId("FINACT_TRNS_STATUS")
        .build();


    public final static StatusItemData StatusItem_FINACT_TRNS_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("12")
        .setStatusCode("CREATED")
        .setStatusId("FINACT_TRNS_CREATED")
        .setStatusTypeId("FINACT_TRNS_STATUS")
        .build();


    public final static StatusItemData StatusItem_FINACT_TRNS_CANCELED = StatusItemData.newBuilder()
        .setDescription("Canceled")
        .setSequenceId("13")
        .setStatusCode("CANCELED")
        .setStatusId("FINACT_TRNS_CANCELED")
        .setStatusTypeId("FINACT_TRNS_STATUS")
        .build();


    public final static StatusItemData StatusItem_FAM_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("FAM_CREATED")
        .setStatusTypeId("FIXEDAST_MNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FAM_SCHEDULED = StatusItemData.newBuilder()
        .setDescription("Scheduled")
        .setSequenceId("03")
        .setStatusCode("SCHEDULED")
        .setStatusId("FAM_SCHEDULED")
        .setStatusTypeId("FIXEDAST_MNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FAM_IN_PROCESS = StatusItemData.newBuilder()
        .setDescription("In Process")
        .setSequenceId("05")
        .setStatusCode("IN_PROCESS")
        .setStatusId("FAM_IN_PROCESS")
        .setStatusTypeId("FIXEDAST_MNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FAM_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("10")
        .setStatusCode("COMPLETED")
        .setStatusId("FAM_COMPLETED")
        .setStatusTypeId("FIXEDAST_MNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_FAM_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("FAM_CANCELLED")
        .setStatusTypeId("FIXEDAST_MNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_IN_PROCESS = StatusItemData.newBuilder()
        .setDescription("In-Process")
        .setSequenceId("01")
        .setStatusCode("IN_PROCESS")
        .setStatusId("INVOICE_IN_PROCESS")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("INVOICE_APPROVED")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_SENT = StatusItemData.newBuilder()
        .setDescription("Sent")
        .setSequenceId("10")
        .setStatusCode("SENT")
        .setStatusId("INVOICE_SENT")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_RECEIVED = StatusItemData.newBuilder()
        .setDescription("Received")
        .setSequenceId("11")
        .setStatusCode("RECEIVED")
        .setStatusId("INVOICE_RECEIVED")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_READY = StatusItemData.newBuilder()
        .setDescription("Ready for Posting")
        .setSequenceId("20")
        .setStatusCode("READY")
        .setStatusId("INVOICE_READY")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_PAID = StatusItemData.newBuilder()
        .setDescription("Paid")
        .setSequenceId("30")
        .setStatusCode("PAID")
        .setStatusId("INVOICE_PAID")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_WRITEOFF = StatusItemData.newBuilder()
        .setDescription("Write Off")
        .setSequenceId("31")
        .setStatusCode("WRITE OFF")
        .setStatusId("INVOICE_WRITEOFF")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_INVOICE_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("INVOICE_CANCELLED")
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusItemData StatusItem_PMNT_NOT_PAID = StatusItemData.newBuilder()
        .setDescription("Not Paid")
        .setSequenceId("01")
        .setStatusCode("NOT_PAID")
        .setStatusId("PMNT_NOT_PAID")
        .setStatusTypeId("PMNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_PMNT_SENT = StatusItemData.newBuilder()
        .setDescription("Sent")
        .setSequenceId("03")
        .setStatusCode("SENT")
        .setStatusId("PMNT_SENT")
        .setStatusTypeId("PMNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_PMNT_RECEIVED = StatusItemData.newBuilder()
        .setDescription("Received")
        .setSequenceId("04")
        .setStatusCode("RECEIVED")
        .setStatusId("PMNT_RECEIVED")
        .setStatusTypeId("PMNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_PMNT_CONFIRMED = StatusItemData.newBuilder()
        .setDescription("Confirmed")
        .setSequenceId("05")
        .setStatusCode("CONFIRMED")
        .setStatusId("PMNT_CONFIRMED")
        .setStatusTypeId("PMNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_PMNT_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("10")
        .setStatusCode("CANCELLED")
        .setStatusId("PMNT_CANCELLED")
        .setStatusTypeId("PMNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_PMNT_VOID = StatusItemData.newBuilder()
        .setDescription("Voided")
        .setSequenceId("11")
        .setStatusCode("VOID")
        .setStatusId("PMNT_VOID")
        .setStatusTypeId("PMNT_STATUS")
        .build();


    public final static StatusItemData StatusItem_GLREC_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("11")
        .setStatusCode("CREATED")
        .setStatusId("GLREC_CREATED")
        .setStatusTypeId("GLREC_STATUS")
        .build();


    public final static StatusItemData StatusItem_GLREC_RECONCILED = StatusItemData.newBuilder()
        .setDescription("Reconciled")
        .setSequenceId("12")
        .setStatusCode("RECONCILED")
        .setStatusId("GLREC_RECONCILED")
        .setStatusTypeId("GLREC_STATUS")
        .build();


    public final static StatusItemData StatusItem_BG_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("00")
        .setStatusCode("CREATED")
        .setStatusId("BG_CREATED")
        .setStatusTypeId("BUDGET_STATUS")
        .build();


    public final static StatusItemData StatusItem_BG_REVIEWED = StatusItemData.newBuilder()
        .setDescription("Reviewed")
        .setSequenceId("01")
        .setStatusCode("REVIEWED")
        .setStatusId("BG_REVIEWED")
        .setStatusTypeId("BUDGET_STATUS")
        .build();


    public final static StatusItemData StatusItem_BG_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("BG_APPROVED")
        .setStatusTypeId("BUDGET_STATUS")
        .build();


    public final static StatusItemData StatusItem_BG_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("03")
        .setStatusCode("REJECTED")
        .setStatusId("BG_REJECTED")
        .setStatusTypeId("BUDGET_STATUS")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_ACTIVE_FNACT_NEGPENDREPL = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_ACTIVE")
        .setStatusIdTo("FNACT_NEGPENDREPL")
        .setTransitionName("Set Negative Pending Replenishment")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_ACTIVE_FNACT_MANFROZEN = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_ACTIVE")
        .setStatusIdTo("FNACT_MANFROZEN")
        .setTransitionName("Set Manually Frozen")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_ACTIVE_FNACT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_ACTIVE")
        .setStatusIdTo("FNACT_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_NEGPENDREPL_FNACT_ACTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_NEGPENDREPL")
        .setStatusIdTo("FNACT_ACTIVE")
        .setTransitionName("Re-activate")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_NEGPENDREPL_FNACT_MANFROZEN = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_NEGPENDREPL")
        .setStatusIdTo("FNACT_MANFROZEN")
        .setTransitionName("Manually Freeze")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_NEGPENDREPL_FNACT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_NEGPENDREPL")
        .setStatusIdTo("FNACT_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_MANFROZEN_FNACT_ACTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_MANFROZEN")
        .setStatusIdTo("FNACT_ACTIVE")
        .setTransitionName("Re-activate")
        .build();


    public final static StatusValidChangeData StatusValidChange_FNACT_MANFROZEN_FNACT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("FNACT_MANFROZEN")
        .setStatusIdTo("FNACT_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_FINACT_TRNS_CREATED_FINACT_TRNS_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("FINACT_TRNS_CREATED")
        .setStatusIdTo("FINACT_TRNS_APPROVED")
        .setTransitionName("Set Created to Approved")
        .build();


    public final static StatusValidChangeData StatusValidChange_FINACT_TRNS_CREATED_FINACT_TRNS_CANCELED = StatusValidChangeData.newBuilder()
        .setStatusId("FINACT_TRNS_CREATED")
        .setStatusIdTo("FINACT_TRNS_CANCELED")
        .setTransitionName("Set Created to Canceled")
        .build();


    public final static StatusValidChangeData StatusValidChange_FINACT_TRNS_APPROVED_FINACT_TRNS_CANCELED = StatusValidChangeData.newBuilder()
        .setStatusId("FINACT_TRNS_APPROVED")
        .setStatusIdTo("FINACT_TRNS_CANCELED")
        .setTransitionName("Set Approved to Canceled")
        .build();


    public final static StatusValidChangeData StatusValidChange_FAM_CREATED_FAM_SCHEDULED = StatusValidChangeData.newBuilder()
        .setStatusId("FAM_CREATED")
        .setStatusIdTo("FAM_SCHEDULED")
        .setTransitionName("Created Maintenance Scheduled")
        .build();


    public final static StatusValidChangeData StatusValidChange_FAM_CREATED_FAM_IN_PROCESS = StatusValidChangeData.newBuilder()
        .setStatusId("FAM_CREATED")
        .setStatusIdTo("FAM_IN_PROCESS")
        .setTransitionName("Created Maintenance In-Process")
        .build();


    public final static StatusValidChangeData StatusValidChange_FAM_CREATED_FAM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("FAM_CREATED")
        .setStatusIdTo("FAM_CANCELLED")
        .setTransitionName("Created Maintenace Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_FAM_SCHEDULED_FAM_IN_PROCESS = StatusValidChangeData.newBuilder()
        .setStatusId("FAM_SCHEDULED")
        .setStatusIdTo("FAM_IN_PROCESS")
        .setTransitionName("Scheduled Maintenace In-Process")
        .build();


    public final static StatusValidChangeData StatusValidChange_FAM_SCHEDULED_FAM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("FAM_SCHEDULED")
        .setStatusIdTo("FAM_CANCELLED")
        .setTransitionName("Scheduled Maintenace Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_FAM_IN_PROCESS_FAM_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("FAM_IN_PROCESS")
        .setStatusIdTo("FAM_COMPLETED")
        .setTransitionName("In-Process Maintenance Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_IN_PROCESS_INVOICE_READY = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_IN_PROCESS")
        .setStatusIdTo("INVOICE_READY")
        .setTransitionName("Mark Ready")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_IN_PROCESS_INVOICE_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_IN_PROCESS")
        .setStatusIdTo("INVOICE_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_IN_PROCESS_INVOICE_SENT = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_IN_PROCESS")
        .setStatusIdTo("INVOICE_SENT")
        .setTransitionName("Send")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_IN_PROCESS_INVOICE_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_IN_PROCESS")
        .setStatusIdTo("INVOICE_RECEIVED")
        .setTransitionName("Receive")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_SENT_INVOICE_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_SENT")
        .setStatusIdTo("INVOICE_APPROVED")
        .setTransitionName("Mark Approved")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_SENT_INVOICE_READY = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_SENT")
        .setStatusIdTo("INVOICE_READY")
        .setTransitionName("Mark Ready")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_SENT_INVOICE_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_SENT")
        .setStatusIdTo("INVOICE_RECEIVED")
        .setTransitionName("Receive")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_RECEIVED_INVOICE_READY = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_RECEIVED")
        .setStatusIdTo("INVOICE_READY")
        .setTransitionName("Mark Receive")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_SENT_INVOICE_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_SENT")
        .setStatusIdTo("INVOICE_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_RECEIVED_INVOICE_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_RECEIVED")
        .setStatusIdTo("INVOICE_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_SENT_INVOICE_IN_PROCESS = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_SENT")
        .setStatusIdTo("INVOICE_IN_PROCESS")
        .setTransitionName("Enable sales invoice update")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_RECEIVED_INVOICE_IN_PROCESS = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_RECEIVED")
        .setStatusIdTo("INVOICE_IN_PROCESS")
        .setTransitionName("Enable purch.invoice update")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_IN_PROCESS_INVOICE_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_IN_PROCESS")
        .setStatusIdTo("INVOICE_APPROVED")
        .setTransitionName("Approve")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_APPROVED_INVOICE_SENT = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_APPROVED")
        .setStatusIdTo("INVOICE_SENT")
        .setTransitionName("Send")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_RECEIVED_INVOICE_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_RECEIVED")
        .setStatusIdTo("INVOICE_APPROVED")
        .setTransitionName("Approve")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_APPROVED_INVOICE_READY = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_APPROVED")
        .setStatusIdTo("INVOICE_READY")
        .setTransitionName("Mark Ready")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_APPROVED_INVOICE_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_APPROVED")
        .setStatusIdTo("INVOICE_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_READY_INVOICE_PAID = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_READY")
        .setStatusIdTo("INVOICE_PAID")
        .setTransitionName("Pay")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_READY_INVOICE_WRITEOFF = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_READY")
        .setStatusIdTo("INVOICE_WRITEOFF")
        .setTransitionName("Write Off")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_PAID_INVOICE_READY = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_PAID")
        .setStatusIdTo("INVOICE_READY")
        .setTransitionName("Unpay")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_READY_INVOICE_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_READY")
        .setStatusIdTo("INVOICE_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_INVOICE_PAID_INVOICE_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("INVOICE_PAID")
        .setStatusIdTo("INVOICE_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_NOT_PAID_PMNT_SENT = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_NOT_PAID")
        .setStatusIdTo("PMNT_SENT")
        .setTransitionName("Payment Send")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_NOT_PAID_PMNT_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_NOT_PAID")
        .setStatusIdTo("PMNT_RECEIVED")
        .setTransitionName("Payment Received")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_NOT_PAID_PMNT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_NOT_PAID")
        .setStatusIdTo("PMNT_CANCELLED")
        .setTransitionName("Payment Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_SENT_PMNT_CONFIRMED = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_SENT")
        .setStatusIdTo("PMNT_CONFIRMED")
        .setTransitionName("Payment Confirmed")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_RECEIVED_PMNT_CONFIRMED = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_RECEIVED")
        .setStatusIdTo("PMNT_CONFIRMED")
        .setTransitionName("Payment Confirmed")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_SENT_PMNT_VOID = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_SENT")
        .setStatusIdTo("PMNT_VOID")
        .setTransitionName("Payment Voided")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_RECEIVED_PMNT_VOID = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_RECEIVED")
        .setStatusIdTo("PMNT_VOID")
        .setTransitionName("Payment Voided")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_NOT_PAID_PMNT_VOID = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_NOT_PAID")
        .setStatusIdTo("PMNT_VOID")
        .setTransitionName("Payment Voided")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_SENT_PMNT_NOT_PAID = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_SENT")
        .setStatusIdTo("PMNT_NOT_PAID")
        .setTransitionName("Payment Not Paid")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_RECEIVED_PMNT_NOT_PAID = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_RECEIVED")
        .setStatusIdTo("PMNT_NOT_PAID")
        .setTransitionName("Payment Not Paid")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_CONFIRMED_PMNT_SENT = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_CONFIRMED")
        .setStatusIdTo("PMNT_SENT")
        .setTransitionName("Payment Confirmed to Sent")
        .build();


    public final static StatusValidChangeData StatusValidChange_PMNT_CONFIRMED_PMNT_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("PMNT_CONFIRMED")
        .setStatusIdTo("PMNT_RECEIVED")
        .setTransitionName("Payment Confirmed to Received")
        .build();


    public final static StatusValidChangeData StatusValidChange_GLREC_CREATED_GLREC_RECONCILED = StatusValidChangeData.newBuilder()
        .setStatusId("GLREC_CREATED")
        .setStatusIdTo("GLREC_RECONCILED")
        .setTransitionName("Set Created to Reconciled")
        .build();


    public final static StatusValidChangeData StatusValidChange_BG_CREATED_BG_REVIEWED = StatusValidChangeData.newBuilder()
        .setStatusId("BG_CREATED")
        .setStatusIdTo("BG_REVIEWED")
        .setTransitionName("Review Budget")
        .build();


    public final static StatusValidChangeData StatusValidChange_BG_CREATED_BG_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("BG_CREATED")
        .setStatusIdTo("BG_APPROVED")
        .setTransitionName("Submit Budget")
        .build();


    public final static StatusValidChangeData StatusValidChange_BG_CREATED_BG_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("BG_CREATED")
        .setStatusIdTo("BG_REJECTED")
        .setTransitionName("Reject Budget")
        .build();


    public final static StatusValidChangeData StatusValidChange_BG_REVIEWED_BG_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("BG_REVIEWED")
        .setStatusIdTo("BG_APPROVED")
        .setTransitionName("Approved Budget")
        .build();


    public final static StatusValidChangeData StatusValidChange_BG_REVIEWED_BG_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("BG_REVIEWED")
        .setStatusIdTo("BG_REJECTED")
        .setTransitionName("Reject Budget")
        .build();


    public final static StatusValidChangeData StatusValidChange_BG_APPROVED_BG_CREATED = StatusValidChangeData.newBuilder()
        .setStatusId("BG_APPROVED")
        .setStatusIdTo("BG_CREATED")
        .setTransitionName("Accept Budget")
        .build();


    public final static StatusValidChangeData StatusValidChange_BG_APPROVED_BG_REJECTED = StatusValidChangeData.newBuilder()
        .setStatusId("BG_APPROVED")
        .setStatusIdTo("BG_REJECTED")
        .setTransitionName("Reject Budget")
        .build();


    public final static GlAccountTypeData GlAccountType__NA_ = GlAccountTypeData.newBuilder()
        .setDescription("Not Applicable")
        .setGlAccountTypeId("_NA_")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_ACCOUNTS_RECEIVABLE = GlAccountTypeData.newBuilder()
        .setDescription("Accounts Receivable")
        .setGlAccountTypeId("ACCOUNTS_RECEIVABLE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_ACCOUNTS_PAYABLE = GlAccountTypeData.newBuilder()
        .setDescription("Accounts Payable")
        .setGlAccountTypeId("ACCOUNTS_PAYABLE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_BALANCE_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Balance")
        .setGlAccountTypeId("BALANCE_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_BANK_STLMNT_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Bank Settlement")
        .setGlAccountTypeId("BANK_STLMNT_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_UNDEPOSITED_RECEIPTS = GlAccountTypeData.newBuilder()
        .setDescription("Undeposited Receipts")
        .setGlAccountTypeId("UNDEPOSITED_RECEIPTS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_MRCH_STLMNT_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Merchant Account Settlement")
        .setGlAccountTypeId("MRCH_STLMNT_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ACCOUNTS_RECEIVABLE")
        .build();


    public final static GlAccountTypeData GlAccountType_CURRENT_ASSET = GlAccountTypeData.newBuilder()
        .setDescription("Current Asset")
        .setGlAccountTypeId("CURRENT_ASSET")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_FIXED_ASSET = GlAccountTypeData.newBuilder()
        .setDescription("Fixed Asset")
        .setGlAccountTypeId("FIXED_ASSET")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_FIXED_ASSET_MAINT = GlAccountTypeData.newBuilder()
        .setDescription("Fixed Asset Maintenance")
        .setGlAccountTypeId("FIXED_ASSET_MAINT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_OTHER_ASSET = GlAccountTypeData.newBuilder()
        .setDescription("Other Asset")
        .setGlAccountTypeId("OTHER_ASSET")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_CREDIT_CARD = GlAccountTypeData.newBuilder()
        .setDescription("Credit Card")
        .setGlAccountTypeId("CREDIT_CARD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_CURRENT_LIABILITY = GlAccountTypeData.newBuilder()
        .setDescription("Current Liability")
        .setGlAccountTypeId("CURRENT_LIABILITY")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_LONG_TERM_LIABILITY = GlAccountTypeData.newBuilder()
        .setDescription("Long Term Liability")
        .setGlAccountTypeId("LONG_TERM_LIABILITY")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_CUSTOMER_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Customer")
        .setGlAccountTypeId("CUSTOMER_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_SUPPLIER_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Supplier")
        .setGlAccountTypeId("SUPPLIER_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_PRODUCT_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Product")
        .setGlAccountTypeId("PRODUCT_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_INVENTORY_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Inventory")
        .setGlAccountTypeId("INVENTORY_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_INV_ADJ_AVG_COST = GlAccountTypeData.newBuilder()
        .setDescription("Inventory Adjustment from Average Cost")
        .setGlAccountTypeId("INV_ADJ_AVG_COST")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INVENTORY_ACCOUNT")
        .build();


    public final static GlAccountTypeData GlAccountType_INV_ADJ_VAL = GlAccountTypeData.newBuilder()
        .setDescription("Inventory Item Value Adjustment")
        .setGlAccountTypeId("INV_ADJ_VAL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_RAWMAT_INVENTORY = GlAccountTypeData.newBuilder()
        .setDescription("Raw Materials Inventory")
        .setGlAccountTypeId("RAWMAT_INVENTORY")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_WIP_INVENTORY = GlAccountTypeData.newBuilder()
        .setDescription("Work In Progress Inventory")
        .setGlAccountTypeId("WIP_INVENTORY")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_TAX_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Tax")
        .setGlAccountTypeId("TAX_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_PROFIT_LOSS_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Profit Loss")
        .setGlAccountTypeId("PROFIT_LOSS_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_SALES_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Sales")
        .setGlAccountTypeId("SALES_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_SALES_RETURNS = GlAccountTypeData.newBuilder()
        .setDescription("Customer Returns")
        .setGlAccountTypeId("SALES_RETURNS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_DISCOUNTS_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Discounts")
        .setGlAccountTypeId("DISCOUNTS_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_COGS_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Cost of Goods Sold")
        .setGlAccountTypeId("COGS_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_COGS_ADJ_AVG_COST = GlAccountTypeData.newBuilder()
        .setDescription("COGS - Average Cost Adjustment")
        .setGlAccountTypeId("COGS_ADJ_AVG_COST")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("COGS_ACCOUNT")
        .build();


    public final static GlAccountTypeData GlAccountType_PURCHASE_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Purchase")
        .setGlAccountTypeId("PURCHASE_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_INV_CHANGE_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Inventory Change")
        .setGlAccountTypeId("INV_CHANGE_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_EXPENSE = GlAccountTypeData.newBuilder()
        .setDescription("Expense")
        .setGlAccountTypeId("EXPENSE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_OPERATING_EXPENSE = GlAccountTypeData.newBuilder()
        .setDescription("Operating Expense")
        .setGlAccountTypeId("OPERATING_EXPENSE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EXPENSE")
        .build();


    public final static GlAccountTypeData GlAccountType_OTHER_EXPENSE = GlAccountTypeData.newBuilder()
        .setDescription("Other Expense")
        .setGlAccountTypeId("OTHER_EXPENSE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("EXPENSE")
        .build();


    public final static GlAccountTypeData GlAccountType_OWNERS_EQUITY = GlAccountTypeData.newBuilder()
        .setDescription("Owner's Equity")
        .setGlAccountTypeId("OWNERS_EQUITY")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_RETAINED_EARNINGS = GlAccountTypeData.newBuilder()
        .setDescription("Retained Earnings")
        .setGlAccountTypeId("RETAINED_EARNINGS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_CUSTOMER_DEPOSIT = GlAccountTypeData.newBuilder()
        .setDescription("Customer Deposits")
        .setGlAccountTypeId("CUSTOMER_DEPOSIT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_LIABILITY")
        .build();


    public final static GlAccountTypeData GlAccountType_CUSTOMER_CREDIT = GlAccountTypeData.newBuilder()
        .setDescription("Customer Credits")
        .setGlAccountTypeId("CUSTOMER_CREDIT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_LIABILITY")
        .build();


    public final static GlAccountTypeData GlAccountType_CUSTOMER_GC_DEPOSIT = GlAccountTypeData.newBuilder()
        .setDescription("Customer Gift Certificate Balances")
        .setGlAccountTypeId("CUSTOMER_GC_DEPOSIT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_LIABILITY")
        .build();


    public final static GlAccountTypeData GlAccountType_UNINVOICED_SHIP_RCPT = GlAccountTypeData.newBuilder()
        .setDescription("Uninvoiced Shipment Receipts")
        .setGlAccountTypeId("UNINVOICED_SHIP_RCPT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_LIABILITY")
        .build();


    public final static GlAccountTypeData GlAccountType_PURCHASE_PRICE_VAR = GlAccountTypeData.newBuilder()
        .setDescription("Purchase Price Variance")
        .setGlAccountTypeId("PURCHASE_PRICE_VAR")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OTHER_EXPENSE")
        .build();


    public final static GlAccountTypeData GlAccountType_INCOME = GlAccountTypeData.newBuilder()
        .setDescription("Income")
        .setGlAccountTypeId("INCOME")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlAccountTypeData GlAccountType_OTHER_INCOME = GlAccountTypeData.newBuilder()
        .setDescription("Other Income")
        .setGlAccountTypeId("OTHER_INCOME")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INCOME")
        .build();


    public final static GlAccountTypeData GlAccountType_INTEREST_INCOME = GlAccountTypeData.newBuilder()
        .setDescription("Interest Income")
        .setGlAccountTypeId("INTEREST_INCOME")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INCOME")
        .build();


    public final static GlAccountTypeData GlAccountType_INTRSTINC_RECEIVABLE = GlAccountTypeData.newBuilder()
        .setDescription("Interest Income Receivables")
        .setGlAccountTypeId("INTRSTINC_RECEIVABLE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ACCOUNTS_RECEIVABLE")
        .build();


    public final static GlAccountTypeData GlAccountType_PREPAID_EXPENSES = GlAccountTypeData.newBuilder()
        .setDescription("Prepaid Expenses")
        .setGlAccountTypeId("PREPAID_EXPENSES")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_ASSET")
        .build();


    public final static GlAccountTypeData GlAccountType_INVENTORY_XFER_OUT = GlAccountTypeData.newBuilder()
        .setDescription("Receivable from Inventory Transferred Out")
        .setGlAccountTypeId("INVENTORY_XFER_OUT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_ASSET")
        .build();


    public final static GlAccountTypeData GlAccountType_INVENTORY_XFER_IN = GlAccountTypeData.newBuilder()
        .setDescription("Payable from Inventory Transferred In")
        .setGlAccountTypeId("INVENTORY_XFER_IN")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_LIABILITY")
        .build();


    public final static GlAccountTypeData GlAccountType_ACCPAYABLE_UNAPPLIED = GlAccountTypeData.newBuilder()
        .setDescription("Accounts Payable - Unapplied Payments")
        .setGlAccountTypeId("ACCPAYABLE_UNAPPLIED")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ACCOUNTS_PAYABLE")
        .build();


    public final static GlAccountTypeData GlAccountType_ACCREC_UNAPPLIED = GlAccountTypeData.newBuilder()
        .setDescription("Accounts Receivable - Unapplied Payments")
        .setGlAccountTypeId("ACCREC_UNAPPLIED")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ACCOUNTS_RECEIVABLE")
        .build();


    public final static GlAccountTypeData GlAccountType_COMMISSION_EXPENSE = GlAccountTypeData.newBuilder()
        .setDescription("Commission Expense")
        .setGlAccountTypeId("COMMISSION_EXPENSE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OPERATING_EXPENSE")
        .build();


    public final static GlAccountTypeData GlAccountType_COMMISSIONS_PAYABLE = GlAccountTypeData.newBuilder()
        .setDescription("Commissions Payables")
        .setGlAccountTypeId("COMMISSIONS_PAYABLE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("CURRENT_LIABILITY")
        .build();


    public final static GlAccountTypeData GlAccountType_WRITEOFF = GlAccountTypeData.newBuilder()
        .setDescription("Write Off")
        .setGlAccountTypeId("WRITEOFF")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OTHER_EXPENSE")
        .build();


    public final static GlAccountTypeData GlAccountType_ACCTRECV_WRITEOFF = GlAccountTypeData.newBuilder()
        .setDescription("Accounts Receivables Write Off")
        .setGlAccountTypeId("ACCTRECV_WRITEOFF")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WRITEOFF")
        .build();


    public final static GlAccountTypeData GlAccountType_ACCTPAY_WRITEOFF = GlAccountTypeData.newBuilder()
        .setDescription("Accounts Payables Write Off")
        .setGlAccountTypeId("ACCTPAY_WRITEOFF")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WRITEOFF")
        .build();


    public final static GlAccountTypeData GlAccountType_COMMISSIONS_WRITEOFF = GlAccountTypeData.newBuilder()
        .setDescription("Commissions Payables Write Off")
        .setGlAccountTypeId("COMMISSIONS_WRITEOFF")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WRITEOFF")
        .build();


    public final static GlAccountTypeData GlAccountType_INTRSTINC_WRITEOFF = GlAccountTypeData.newBuilder()
        .setDescription("Interest Income Write Off")
        .setGlAccountTypeId("INTRSTINC_WRITEOFF")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("WRITEOFF")
        .build();


    public final static GlAccountTypeData GlAccountType_FX_GAIN_LOSS_ACCT = GlAccountTypeData.newBuilder()
        .setDescription("Foreign Exchange Gain/Loss")
        .setGlAccountTypeId("FX_GAIN_LOSS_ACCT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OTHER_EXPENSE")
        .build();


    public final static GlAccountTypeData GlAccountType_FX_GAIN_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Foreign Exchange Gain")
        .setGlAccountTypeId("FX_GAIN_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FX_GAIN_LOSS_ACCT")
        .build();


    public final static GlAccountTypeData GlAccountType_FX_LOSS_ACCOUNT = GlAccountTypeData.newBuilder()
        .setDescription("Foreign Exchange Loss")
        .setGlAccountTypeId("FX_LOSS_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FX_GAIN_LOSS_ACCT")
        .build();


    public final static WorkEffortData WorkEffort__NA_ = WorkEffortData.newBuilder()
        .setWorkEffortId("_NA_")
        .build();


    public final static PaymentGroupTypeData PaymentGroupType_CHECK_RUN = PaymentGroupTypeData.newBuilder()
        .setDescription("Check Run")
        .setHasTable(castIndicator("N"))
        .setPaymentGroupTypeId("CHECK_RUN")
        .build();


    public final static PaymentGroupTypeData PaymentGroupType_BATCH_PAYMENT = PaymentGroupTypeData.newBuilder()
        .setDescription("Batch of Payments")
        .setHasTable(castIndicator("N"))
        .setPaymentGroupTypeId("BATCH_PAYMENT")
        .build();


    public final static GlAccountCategoryTypeData GlAccountCategoryType_COST_CENTER = GlAccountCategoryTypeData.newBuilder()
        .setDescription("Cost Center Category")
        .setGlAccountCategoryTypeId("COST_CENTER")
        .build();


    public final static FixedAssetStdCostTypeData FixedAssetStdCostType_SETUP_COST = FixedAssetStdCostTypeData.newBuilder()
        .setDescription("Standard Setup Cost")
        .setFixedAssetStdCostTypeId("SETUP_COST")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetStdCostTypeData FixedAssetStdCostType_USAGE_COST = FixedAssetStdCostTypeData.newBuilder()
        .setDescription("Standard Usage Cost")
        .setFixedAssetStdCostTypeId("USAGE_COST")
        .setHasTable(castIndicator("N"))
        .build();


    public final static PaymentTypeData PaymentType_DISBURSEMENT = PaymentTypeData.newBuilder()
        .setDescription("Disbursement")
        .setHasTable(castIndicator("N"))
        .setPaymentTypeId("DISBURSEMENT")
        .build();


    public final static PaymentTypeData PaymentType_CUSTOMER_REFUND = PaymentTypeData.newBuilder()
        .setDescription("Customer Refund")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("CUSTOMER_REFUND")
        .build();


    public final static PaymentTypeData PaymentType_VENDOR_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Vendor Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("VENDOR_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_VENDOR_PREPAY = PaymentTypeData.newBuilder()
        .setDescription("Vendor Prepayment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("VENDOR_PREPAY")
        .build();


    public final static PaymentTypeData PaymentType_COMMISSION_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Commission Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("COMMISSION_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_PAYROL_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Payrol Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("PAYROL_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_PAY_CHECK = PaymentTypeData.newBuilder()
        .setDescription("Pay Check")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("PAY_CHECK")
        .build();


    public final static PaymentTypeData PaymentType_TAX_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Tax Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("TAX_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_SALES_TAX_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Sales Tax Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("TAX_PAYMENT")
        .setPaymentTypeId("SALES_TAX_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_PAYROLL_TAX_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Payroll Tax Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("TAX_PAYMENT")
        .setPaymentTypeId("PAYROLL_TAX_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_INCOME_TAX_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Income Tax Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("TAX_PAYMENT")
        .setPaymentTypeId("INCOME_TAX_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_GC_WITHDRAWAL = PaymentTypeData.newBuilder()
        .setDescription("Gift Certificate Withdrawal")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DISBURSEMENT")
        .setPaymentTypeId("GC_WITHDRAWAL")
        .build();


    public final static PaymentTypeData PaymentType_RECEIPT = PaymentTypeData.newBuilder()
        .setDescription("Receipt")
        .setHasTable(castIndicator("N"))
        .setPaymentTypeId("RECEIPT")
        .build();


    public final static PaymentTypeData PaymentType_CUSTOMER_PAYMENT = PaymentTypeData.newBuilder()
        .setDescription("Customer Payment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("RECEIPT")
        .setPaymentTypeId("CUSTOMER_PAYMENT")
        .build();


    public final static PaymentTypeData PaymentType_CUSTOMER_DEPOSIT = PaymentTypeData.newBuilder()
        .setDescription("Customer Deposit")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("RECEIPT")
        .setPaymentTypeId("CUSTOMER_DEPOSIT")
        .build();


    public final static PaymentTypeData PaymentType_INTEREST_RECEIPT = PaymentTypeData.newBuilder()
        .setDescription("Interest Receipt")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("RECEIPT")
        .setPaymentTypeId("INTEREST_RECEIPT")
        .build();


    public final static PaymentTypeData PaymentType_GC_DEPOSIT = PaymentTypeData.newBuilder()
        .setDescription("Gift Certificate Deposit")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("RECEIPT")
        .setPaymentTypeId("GC_DEPOSIT")
        .build();


    public final static RateTypeData RateType_STANDARD = RateTypeData.newBuilder()
        .setDescription("Standard Rate")
        .setRateTypeId("STANDARD")
        .build();


    public final static RateTypeData RateType_DISCOUNTED = RateTypeData.newBuilder()
        .setDescription("Discounted Rate")
        .setRateTypeId("DISCOUNTED")
        .build();


    public final static RateTypeData RateType_OVERTIME = RateTypeData.newBuilder()
        .setDescription("Overtime Rate")
        .setRateTypeId("OVERTIME")
        .build();


    public final static RateTypeData RateType_AVERAGE_PAY_RATE = RateTypeData.newBuilder()
        .setDescription("Average Pay Rate")
        .setRateTypeId("AVERAGE_PAY_RATE")
        .build();


    public final static RateTypeData RateType_HIGH_PAY_RATE = RateTypeData.newBuilder()
        .setDescription("Highest Pay Rate")
        .setRateTypeId("HIGH_PAY_RATE")
        .build();


    public final static RateTypeData RateType_LOW_PAY_RATE = RateTypeData.newBuilder()
        .setDescription("Lowest Pay Rate")
        .setRateTypeId("LOW_PAY_RATE")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INVOICE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INVOICE_HEAD_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Header Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INVOICE_HEAD_ADJ")
        .setParentTypeId("INVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INVOICE_ITM_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INVOICE_ITM_ADJ")
        .setParentTypeId("INVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SINVOICE_HEAD_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Sales Invoice Header Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SINVOICE_HEAD_ADJ")
        .setParentTypeId("INVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SINVOICE_ITM_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Sales Invoice Item Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SINVOICE_ITM_ADJ")
        .setParentTypeId("INVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINVOICE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Purchase Invoice Header Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINVOICE_ADJ")
        .setParentTypeId("INVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINVOICE_ITM_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Purchase Invoice Item Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINVOICE_ITM_ADJ")
        .setParentTypeId("INVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRETURN_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Customer Return Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRETURN_ADJ")
        .setParentTypeId("INVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRETURN_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Supplier Return Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRETURN_ADJ")
        .setParentTypeId("INVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Promotion(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_PROMOTION_ADJ")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Discount(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_DISCOUNT_ADJ")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_FEE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Fee(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("FEE")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Miscellaneous Charges(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_MISC_CHARGE")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_SALES_TAX = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Sales Tax(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_SALES_TAX")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_SHIPPING_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Shipping and Handling(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_SHIPPING_CHARGES")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Surcharge(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_SURCHARGE_ADJ")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Additional Feature(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_ADD_FEATURE")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Warranty(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_WARRANTY_ADJ")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_INTRST_CHRG = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Interest Charge")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_INTRST_CHRG")
        .setParentTypeId("SINVOICE_HEAD_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Promotion(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_PROMOTION_ADJ")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Replacement(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_REPLACE_ADJ")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Discount(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_DISCOUNT_ADJ")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_FEE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Fee(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_FEE")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Miscellaneous Charges(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_MISC_CHARGE")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_SALES_TAX = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Sales Tax(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_SALES_TAX")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_SHIPPING_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Shipping and Handling(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_SHIPPING_CHARGES")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Surcharge(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_SURCHARGE_ADJ")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Additional Feature(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_ADD_FEATURE")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Warranty(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_WARRANTY_ADJ")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_ITM_VAT_TAX = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item VAT Tax(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("ITM_VAT_TAX")
        .setParentTypeId("SINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Product Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Finished Good Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_FPROD_ITEM")
        .setParentTypeId("INV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Digital Good Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_DPROD_ITEM")
        .setParentTypeId("INV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Finished/Digital Good Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_FDPROD_ITEM")
        .setParentTypeId("INV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Product-Feature Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_PROD_FEATR_ITEM")
        .setParentTypeId("INV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Service Product Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_SPROD_ITEM")
        .setParentTypeId("INV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Work-Effort Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_INV_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Time-Entry Item(Sales)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("INV_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Promotion(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_PROMOTION_ADJ")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Discount(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_DISCOUNT_ADJ")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_P_FEE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Fee(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("P_FEE")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Miscellaneous Charges(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_MISC_CHARGE")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SALES_TAX = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Sales Tax(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_SALES_TAX")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SHIP_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Shipping and Handling(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_SHIP_CHARGES")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Surcharge(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_SURCHARGE_ADJ")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Additional Feature(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_ADD_FEATURE")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Warranty(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_WARRANTY_ADJ")
        .setParentTypeId("PINVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Promotion(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_PROMOTION_ADJ")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Replacement(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_REPLACE_ADJ")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Discount(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_DISCOUNT_ADJ")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_FEE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Fee(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_FEE")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_MISC_CHARGE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Miscellaneous Charges(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_MISC_CHARGE")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_SALES_TAX = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Sales Tax(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_SALES_TAX")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_SHIP_CHARGES = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Shipping and Handling(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_SHIP_CHARGES")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Surcharge(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_SURCHARGE_ADJ")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_ADD_FEATURE = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Additional Feature(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_ADD_FEATURE")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PITM_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Item Warranty(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PITM_WARRANTY_ADJ")
        .setParentTypeId("PINVOICE_ITM_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Product Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Finished Good Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_FPROD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Digital Good Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_DPROD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Finished/Digital Good Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_FDPROD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Product-Feature Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_PROD_FEATR_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_RPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Raw Material(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_RPROD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Service Product Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_SPROD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_INVPRD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Inventory Product Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_INVPRD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_SUPLPRD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Supplies (to Expense) Product Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_SUPLPRD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_FXASTPRD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Fixed Asset Product Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_FXASTPRD_ITEM")
        .setParentTypeId("PINV_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Work-Effort Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PINV_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Invoice Time-Entry Item(Purchase)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PINV_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Product Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Finished Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_FPROD_ITEM")
        .setParentTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Digital Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_DPROD_ITEM")
        .setParentTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Finished/Digital Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_FDPROD_ITEM")
        .setParentTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_RPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Raw Material Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_RPROD_ITEM")
        .setParentTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Product-Feature Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_PROD_FEATR_ITEM")
        .setParentTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Service Product Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_SPROD_ITEM")
        .setParentTypeId("CRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Work-Effort Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Time-Entry Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Promotion")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_PROMOTION_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Replacement")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_REPLACE_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Discount")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_DISCOUNT_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_FEE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Fee")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_FEE_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_MISC_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Miscellaneous Charges")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_MISC_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_SALES_TAX_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Sales Tax")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_SALES_TAX_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_VAT_TAX_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return VAT Tax")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_VAT_TAX_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_VAT_PC_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return VAT Price Correct")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_VAT_PC_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_SHIPPING_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Shipping and Handling")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_SHIPPING_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Surcharge")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_SURCHARGE_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_ADD_FEATURE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Additional Feature")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_ADD_FEATURE_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Warranty")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_WARRANTY_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_MKTG_PKG_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Marketing Package Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_MKTG_PKG_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_CRT_MAN_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Manual Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("CRT_MAN_ADJ")
        .setParentTypeId("CRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_PROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Product Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_FPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Finished Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_FPROD_ITEM")
        .setParentTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_DPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Digital Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_DPROD_ITEM")
        .setParentTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_FDPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Finished/Digital Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_FDPROD_ITEM")
        .setParentTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_RPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Raw Material Good Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_RPROD_ITEM")
        .setParentTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_PROD_FEATR_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Product-Feature Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_PROD_FEATR_ITEM")
        .setParentTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_SPROD_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Service Product Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_SPROD_ITEM")
        .setParentTypeId("SRT_PROD_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_WE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Work-Effort Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_WE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_TE_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Time-Entry Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_TE_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_PROMOTION_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Promotion")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_PROMOTION_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_REPLACE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Replacement")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_REPLACE_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_DISCOUNT_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Discount")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_DISCOUNT_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_FEE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Fee")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_FEE_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_MISC_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Miscellaneous Charges")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_MISC_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_SALES_TAX_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Sales Tax")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_SALES_TAX_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_VAT_TAX_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return VAT Tax")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_VAT_TAX_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_VAT_PC_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return VAT Price Correct")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_VAT_PC_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_SHIPPING_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Shipping and Handling")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_SHIPPING_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_SURCHARGE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Surcharge")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_SURCHARGE_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_ADD_FEATURE_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Additional Feature")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_ADD_FEATURE_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_WARRANTY_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Warranty")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_WARRANTY_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_MKTG_PKG_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Marketing Package Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_MKTG_PKG_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_SRT_MAN_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Return Manual Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("SRT_MAN_ADJ")
        .setParentTypeId("SRETURN_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_COMM_INV_ITEM = InvoiceItemTypeData.newBuilder()
        .setDescription("Commission Invoice Line Item")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("COMM_INV_ITEM")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_COMM_INV_ADJ = InvoiceItemTypeData.newBuilder()
        .setDescription("Commission Invoice Adjustment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("COMM_INV_ADJ")
        .setParentTypeId("INVOICE_ADJ")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL = InvoiceItemTypeData.newBuilder()
        .setDescription("Payrol")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_EARN_HOURS = InvoiceItemTypeData.newBuilder()
        .setDescription("Earnings and Hours")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_EARN_HOURS")
        .setParentTypeId("PAYROL")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_HRLY_RATE = InvoiceItemTypeData.newBuilder()
        .setDescription("Hourly Rate")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_HRLY_RATE")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_HRLY_RATE_SIC = InvoiceItemTypeData.newBuilder()
        .setDescription("Sick Hourly Rate")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_HRLY_RATE_SIC")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SALARY = InvoiceItemTypeData.newBuilder()
        .setDescription("Salary")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_SALARY")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SALARY_VAC = InvoiceItemTypeData.newBuilder()
        .setDescription("Vacation Salary")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_SALARY_VAC")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SALARY_SICK = InvoiceItemTypeData.newBuilder()
        .setDescription("Sick Salary")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_SALARY_SICK")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_BONUS = InvoiceItemTypeData.newBuilder()
        .setDescription("Bonus")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_BONUS")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_COMMISSION = InvoiceItemTypeData.newBuilder()
        .setDescription("Commission")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_COMMISSION")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_ADV_PAY = InvoiceItemTypeData.newBuilder()
        .setDescription("Advance Pay")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_ADV_PAY")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_MIL_REIMB = InvoiceItemTypeData.newBuilder()
        .setDescription("Mileage Reimboursement")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_MIL_REIMB")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_OFF_EXP_REIMB = InvoiceItemTypeData.newBuilder()
        .setDescription("Office Exp. reimboursement")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_OFF_EXP_REIMB")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_PAYPER_OVRPAY = InvoiceItemTypeData.newBuilder()
        .setDescription("Pay Period adj(over pay)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_PAYPER_OVRPAY")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_PAYPER_PAY = InvoiceItemTypeData.newBuilder()
        .setDescription("Pay Period adj pay")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_PAYPER_PAY")
        .setParentTypeId("PAYROL_EARN_HOURS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_FROM_GROSS = InvoiceItemTypeData.newBuilder()
        .setDescription("Deductions from Gross")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_FROM_GROSS")
        .setParentTypeId("PAYROL")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_125COMPY = InvoiceItemTypeData.newBuilder()
        .setDescription("125*Compy. Contr Other Prem.")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_125COMPY")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_125PPO = InvoiceItemTypeData.newBuilder()
        .setDescription("125*PPO (pre tax)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_125PPO")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_125HSA = InvoiceItemTypeData.newBuilder()
        .setDescription("125*HSA Contribution (pre tax)")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_125HSA")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_401K = InvoiceItemTypeData.newBuilder()
        .setDescription("401K Emp.")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_401K")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_REPAY = InvoiceItemTypeData.newBuilder()
        .setDescription("Advance Repayment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_REPAY")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_CHAR_DONAT = InvoiceItemTypeData.newBuilder()
        .setDescription("Charity Donation")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_CHAR_DONAT")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_CHILD_SUPP = InvoiceItemTypeData.newBuilder()
        .setDescription("Child Support Garnishment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_CHILD_SUPP")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_MISC = InvoiceItemTypeData.newBuilder()
        .setDescription("Miscellaneous Deduction")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_MISC")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_ROTH_401K = InvoiceItemTypeData.newBuilder()
        .setDescription("Roth 401k Emp.")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_ROTH_401K")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_SIMP_IRA = InvoiceItemTypeData.newBuilder()
        .setDescription("Simple IRA emp.")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_SIMP_IRA")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_UNION = InvoiceItemTypeData.newBuilder()
        .setDescription("Union Dues")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_UNION")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_SAL_TIMOFF = InvoiceItemTypeData.newBuilder()
        .setDescription("Unpaid Salary Time off.")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_SAL_TIMOFF")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_DD_WAG_GARN = InvoiceItemTypeData.newBuilder()
        .setDescription("Wage Garnishment")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_DD_WAG_GARN")
        .setParentTypeId("PAYROL_DD_FROM_GROSS")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAXES = InvoiceItemTypeData.newBuilder()
        .setDescription("Taxes")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_TAXES")
        .setParentTypeId("PAYROL")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAX_FEDERAL = InvoiceItemTypeData.newBuilder()
        .setDescription("Federal Witholding")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_TAX_FEDERAL")
        .setParentTypeId("PAYROL_TAXES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_SOC_SEC_EMPL = InvoiceItemTypeData.newBuilder()
        .setDescription("Social Security Employee")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_SOC_SEC_EMPL")
        .setParentTypeId("PAYROL_TAXES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAX_MED_EMPL = InvoiceItemTypeData.newBuilder()
        .setDescription("Medicare Employee")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_TAX_MED_EMPL")
        .setParentTypeId("PAYROL_TAXES")
        .build();


    public final static InvoiceItemTypeData InvoiceItemType_PAYROL_TAX_MD_WITHOL = InvoiceItemTypeData.newBuilder()
        .setDescription("MD Withholding")
        .setHasTable(castIndicator("N"))
        .setInvoiceItemTypeId("PAYROL_TAX_MD_WITHOL")
        .setParentTypeId("PAYROL_TAXES")
        .build();


    public final static FinAccountTypeData FinAccountType_GIFTCERT_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Gift Certificate")
        .setFinAccountTypeId("GIFTCERT_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("N"))
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_DEPOSIT_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Deposit Account")
        .setFinAccountTypeId("DEPOSIT_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_BANK_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Bank Account")
        .setFinAccountTypeId("BANK_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setParentTypeId("DEPOSIT_ACCOUNT")
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_STORE_CREDIT_ACCT = FinAccountTypeData.newBuilder()
        .setDescription("Store Credit Account")
        .setFinAccountTypeId("STORE_CREDIT_ACCT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setParentTypeId("DEPOSIT_ACCOUNT")
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_INVESTMENT_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Investment Account")
        .setFinAccountTypeId("INVESTMENT_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setParentTypeId("DEPOSIT_ACCOUNT")
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_REPLENISH_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Replenish Account")
        .setFinAccountTypeId("REPLENISH_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setParentTypeId("DEPOSIT_ACCOUNT")
        .setReplenishEnumId("FARP_AUTOMATIC")
        .build();


    public final static FinAccountTypeData FinAccountType_SVCCRED_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Service Credit Account")
        .setFinAccountTypeId("SVCCRED_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("N"))
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_LOAN_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Loan Account")
        .setFinAccountTypeId("LOAN_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_CREDIT_CARD_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Credit Card Account")
        .setFinAccountTypeId("CREDIT_CARD_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setParentTypeId("LOAN_ACCOUNT")
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static FinAccountTypeData FinAccountType_EQUITY_LINE_ACCOUNT = FinAccountTypeData.newBuilder()
        .setDescription("Equity Line Account")
        .setFinAccountTypeId("EQUITY_LINE_ACCOUNT")
        .setHasTable(castIndicator("N"))
        .setIsRefundable(castIndicator("Y"))
        .setParentTypeId("LOAN_ACCOUNT")
        .setReplenishEnumId("FARP_MANUAL")
        .build();


    public final static GlResourceTypeData GlResourceType__NA_ = GlResourceTypeData.newBuilder()
        .setDescription("Not Applicable")
        .setGlResourceTypeId("_NA_")
        .build();


    public final static GlResourceTypeData GlResourceType_MONEY = GlResourceTypeData.newBuilder()
        .setDescription("Money")
        .setGlResourceTypeId("MONEY")
        .build();


    public final static GlResourceTypeData GlResourceType_RAW_MATERIALS = GlResourceTypeData.newBuilder()
        .setDescription("Raw Materials")
        .setGlResourceTypeId("RAW_MATERIALS")
        .build();


    public final static GlResourceTypeData GlResourceType_LABOR = GlResourceTypeData.newBuilder()
        .setDescription("Labor")
        .setGlResourceTypeId("LABOR")
        .build();


    public final static GlResourceTypeData GlResourceType_SERVICES = GlResourceTypeData.newBuilder()
        .setDescription("Services")
        .setGlResourceTypeId("SERVICES")
        .build();


    public final static GlResourceTypeData GlResourceType_FINISHED_GOODS = GlResourceTypeData.newBuilder()
        .setDescription("Finished Goods")
        .setGlResourceTypeId("FINISHED_GOODS")
        .build();


    public final static GlResourceTypeData GlResourceType_DELIVERED_GOODS = GlResourceTypeData.newBuilder()
        .setDescription("Delivered Goods")
        .setGlResourceTypeId("DELIVERED_GOODS")
        .build();


    public final static InvoiceContentTypeData InvoiceContentType_COMMENTS = InvoiceContentTypeData.newBuilder()
        .setDescription("comments")
        .setHasTable(castIndicator("N"))
        .setInvoiceContentTypeId("COMMENTS")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_CREDIT_CARD = PaymentMethodTypeData.newBuilder()
        .setDescription("Credit Card")
        .setPaymentMethodTypeId("CREDIT_CARD")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_GIFT_CARD = PaymentMethodTypeData.newBuilder()
        .setDescription("Gift Card")
        .setPaymentMethodTypeId("GIFT_CARD")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_GIFT_CERTIFICATE = PaymentMethodTypeData.newBuilder()
        .setDescription("Gift Certificate")
        .setPaymentMethodTypeId("GIFT_CERTIFICATE")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_CASH = PaymentMethodTypeData.newBuilder()
        .setDescription("Cash")
        .setPaymentMethodTypeId("CASH")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EFT_ACCOUNT = PaymentMethodTypeData.newBuilder()
        .setDescription("Electronic Funds Transfer")
        .setPaymentMethodTypeId("EFT_ACCOUNT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_FIN_ACCOUNT = PaymentMethodTypeData.newBuilder()
        .setDescription("Financial Account")
        .setPaymentMethodTypeId("FIN_ACCOUNT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_PERSONAL_CHECK = PaymentMethodTypeData.newBuilder()
        .setDescription("Personal Check")
        .setPaymentMethodTypeId("PERSONAL_CHECK")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_COMPANY_CHECK = PaymentMethodTypeData.newBuilder()
        .setDescription("Company Check")
        .setPaymentMethodTypeId("COMPANY_CHECK")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_CERTIFIED_CHECK = PaymentMethodTypeData.newBuilder()
        .setDescription("Certified Check")
        .setPaymentMethodTypeId("CERTIFIED_CHECK")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_MONEY_ORDER = PaymentMethodTypeData.newBuilder()
        .setDescription("Money Order")
        .setPaymentMethodTypeId("MONEY_ORDER")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_COMPANY_ACCOUNT = PaymentMethodTypeData.newBuilder()
        .setDescription("Company Account")
        .setPaymentMethodTypeId("COMPANY_ACCOUNT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_BILLACT = PaymentMethodTypeData.newBuilder()
        .setDescription("Billing Account")
        .setPaymentMethodTypeId("EXT_BILLACT")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_COD = PaymentMethodTypeData.newBuilder()
        .setDescription("Cash On Delivery")
        .setPaymentMethodTypeId("EXT_COD")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_EBAY = PaymentMethodTypeData.newBuilder()
        .setDescription("eBay")
        .setPaymentMethodTypeId("EXT_EBAY")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_OFFLINE = PaymentMethodTypeData.newBuilder()
        .setDescription("Offline Payment")
        .setPaymentMethodTypeId("EXT_OFFLINE")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_PAYPAL = PaymentMethodTypeData.newBuilder()
        .setDescription("PayPal")
        .setPaymentMethodTypeId("EXT_PAYPAL")
        .build();


    public final static PaymentMethodTypeData PaymentMethodType_EXT_WORLDPAY = PaymentMethodTypeData.newBuilder()
        .setDescription("RBS WorldPay")
        .setPaymentMethodTypeId("EXT_WORLDPAY")
        .build();


    public final static EnumerationData Enumeration_GC_ACTIVATE = EnumerationData.newBuilder()
        .setDescription("Activate")
        .setEnumCode("ACTIVATE")
        .setEnumId("GC_ACTIVATE")
        .setEnumTypeId("GC_FULFILL")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_GC_RELOAD = EnumerationData.newBuilder()
        .setDescription("Reload")
        .setEnumCode("RELOAD")
        .setEnumId("GC_RELOAD")
        .setEnumTypeId("GC_FULFILL")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PGT_AUTHORIZE = EnumerationData.newBuilder()
        .setDescription("Authorize")
        .setEnumCode("AUTHORIZE")
        .setEnumId("PGT_AUTHORIZE")
        .setEnumTypeId("PGT_CODE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PGT_CAPTURE = EnumerationData.newBuilder()
        .setDescription("Capture")
        .setEnumCode("CAPTURE")
        .setEnumId("PGT_CAPTURE")
        .setEnumTypeId("PGT_CODE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PGT_RELEASE = EnumerationData.newBuilder()
        .setDescription("Release")
        .setEnumCode("RELEASE")
        .setEnumId("PGT_RELEASE")
        .setEnumTypeId("PGT_CODE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PGT_REFUND = EnumerationData.newBuilder()
        .setDescription("Refund")
        .setEnumCode("REFUND")
        .setEnumId("PGT_REFUND")
        .setEnumTypeId("PGT_CODE")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PGT_CREDIT = EnumerationData.newBuilder()
        .setDescription("Credit")
        .setEnumCode("CREDIT")
        .setEnumId("PGT_CREDIT")
        .setEnumTypeId("PGT_CODE")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_FARP_AUTOMATIC = EnumerationData.newBuilder()
        .setDescription("Automatic Replenish")
        .setEnumCode("AUTOMATIC")
        .setEnumId("FARP_AUTOMATIC")
        .setEnumTypeId("FARP_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FARP_MANUAL = EnumerationData.newBuilder()
        .setDescription("Manual Replenish")
        .setEnumCode("MANUAL")
        .setEnumId("FARP_MANUAL")
        .setEnumTypeId("FARP_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_FARP_NONE = EnumerationData.newBuilder()
        .setDescription("No Replenish")
        .setEnumCode("NONE")
        .setEnumId("FARP_NONE")
        .setEnumTypeId("FARP_TYPE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_FARP_TOP_OFF = EnumerationData.newBuilder()
        .setDescription("Top-off")
        .setEnumCode("TOP_OFF")
        .setEnumId("FARP_TOP_OFF")
        .setEnumTypeId("FARP_METHOD")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FARP_REPLENISH_LEVEL = EnumerationData.newBuilder()
        .setDescription("Replenish-level")
        .setEnumCode("REPLENISH_LEVEL")
        .setEnumId("FARP_REPLENISH_LEVEL")
        .setEnumTypeId("FARP_METHOD")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_FATR_PURCHASE = EnumerationData.newBuilder()
        .setDescription("Purchase")
        .setEnumCode("PURCHASE")
        .setEnumId("FATR_PURCHASE")
        .setEnumTypeId("FINACCT_TRANS_REASON")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FATR_IDEPOSIT = EnumerationData.newBuilder()
        .setDescription("Initial Deposit")
        .setEnumCode("IDEPOSIT")
        .setEnumId("FATR_IDEPOSIT")
        .setEnumTypeId("FINACCT_TRANS_REASON")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_FATR_REPLENISH = EnumerationData.newBuilder()
        .setDescription("Replenishment")
        .setEnumCode("REPLENISH")
        .setEnumId("FATR_REPLENISH")
        .setEnumTypeId("FINACCT_TRANS_REASON")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_FATR_REFUND = EnumerationData.newBuilder()
        .setDescription("Refund")
        .setEnumCode("REFUND")
        .setEnumId("FATR_REFUND")
        .setEnumTypeId("FINACCT_TRANS_REASON")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_FAC_BOAT = EnumerationData.newBuilder()
        .setDescription("Boat")
        .setEnumCode("BOAT")
        .setEnumId("FAC_BOAT")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_FORKLIFT = EnumerationData.newBuilder()
        .setDescription("Forklift")
        .setEnumCode("FORKLIFT")
        .setEnumId("FAC_FORKLIFT")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_DIGGER = EnumerationData.newBuilder()
        .setDescription("Digger")
        .setEnumCode("DIGGER")
        .setEnumId("FAC_DIGGER")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_MANLIFT = EnumerationData.newBuilder()
        .setDescription("Manlift")
        .setEnumCode("MANLIFT")
        .setEnumId("FAC_MANLIFT")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_SERVICE_BODY = EnumerationData.newBuilder()
        .setDescription("Service Body")
        .setEnumCode("SERVICE_BODY")
        .setEnumId("FAC_SERVICE_BODY")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_TRACTOR = EnumerationData.newBuilder()
        .setDescription("Tractor")
        .setEnumCode("TRACTOR")
        .setEnumId("FAC_TRACTOR")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_PASSENGER = EnumerationData.newBuilder()
        .setDescription("Passenger Vehicle")
        .setEnumCode("PASSENGER")
        .setEnumId("FAC_PASSENGER")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_COMPRESSOR = EnumerationData.newBuilder()
        .setDescription("Compressor")
        .setEnumCode("COMPRESSOR")
        .setEnumId("FAC_COMPRESSOR")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_TRENCHER = EnumerationData.newBuilder()
        .setDescription("Trencher")
        .setEnumCode("TRENCHER")
        .setEnumId("FAC_TRENCHER")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_PULLER = EnumerationData.newBuilder()
        .setDescription("Puller")
        .setEnumCode("PULLER")
        .setEnumId("FAC_PULLER")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_MOBILE = EnumerationData.newBuilder()
        .setDescription("Mobile")
        .setEnumCode("MOBILE")
        .setEnumId("FAC_MOBILE")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_TANKER = EnumerationData.newBuilder()
        .setDescription("Tanker")
        .setEnumCode("TANKER")
        .setEnumId("FAC_TANKER")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_REEL_STAND = EnumerationData.newBuilder()
        .setDescription("Reel Stand")
        .setEnumCode("REEL_STAND")
        .setEnumId("FAC_REEL_STAND")
        .setEnumTypeId("FXAST_CLASS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_DESKTOP = EnumerationData.newBuilder()
        .setDescription("Desktop")
        .setEnumCode("DESKTOP")
        .setEnumId("FAC_DESKTOP")
        .setEnumTypeId("FXAST_COMPU_HARDWARE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_LAPTOP = EnumerationData.newBuilder()
        .setDescription("Laptop")
        .setEnumCode("LAPTOP")
        .setEnumId("FAC_LAPTOP")
        .setEnumTypeId("FXAST_COMPU_HARDWARE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_MONITOR = EnumerationData.newBuilder()
        .setDescription("Monitor")
        .setEnumCode("MONITOR")
        .setEnumId("FAC_MONITOR")
        .setEnumTypeId("FXAST_COMPU_HARDWARE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_PRG_SOFTWARE = EnumerationData.newBuilder()
        .setDescription("Programming Software")
        .setEnumCode("PRG_SOFTWARE")
        .setEnumId("FAC_PRG_SOFTWARE")
        .setEnumTypeId("FXAST_COMPU_SOFTWARE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_SYS_SOFTWARE = EnumerationData.newBuilder()
        .setDescription("System Software")
        .setEnumCode("SYS_SOFTWARE")
        .setEnumId("FAC_SYS_SOFTWARE")
        .setEnumTypeId("FXAST_COMPU_SOFTWARE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_APP_SOFTWARE = EnumerationData.newBuilder()
        .setDescription("Application Software")
        .setEnumCode("APP_SOFTWARE")
        .setEnumId("FAC_APP_SOFTWARE")
        .setEnumTypeId("FXAST_COMPU_SOFTWARE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FAC_UTIL_SOFTWARE = EnumerationData.newBuilder()
        .setDescription("Utility Software")
        .setEnumCode("UTIL_SOFTWARE")
        .setEnumId("FAC_UTIL_SOFTWARE")
        .setEnumTypeId("FXAST_COMPU_SOFTWARE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_INV_SALES_TAX = EnumerationData.newBuilder()
        .setDescription("Sales Invoice Sales Tax")
        .setEnumCode("INV_SALES_TAX")
        .setEnumId("INV_SALES_TAX")
        .setEnumTypeId("TAXABLE_INV_ITM_TY")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_ITM_SALES_TAX = EnumerationData.newBuilder()
        .setDescription("Sales Invoice Line Item Sales Tax")
        .setEnumCode("ITM_SALES_TAX")
        .setEnumId("ITM_SALES_TAX")
        .setEnumTypeId("TAXABLE_INV_ITM_TY")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PINV_SALES_TAX = EnumerationData.newBuilder()
        .setDescription("Purchase Invoice Sales Tax")
        .setEnumCode("PINV_SALES_TAX")
        .setEnumId("PINV_SALES_TAX")
        .setEnumTypeId("TAXABLE_INV_ITM_TY")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PITM_SALES_TAX = EnumerationData.newBuilder()
        .setDescription("Purchase Invoice Line Item Sales Tax")
        .setEnumCode("PITM_SALES_TAX")
        .setEnumId("PITM_SALES_TAX")
        .setEnumTypeId("TAXABLE_INV_ITM_TY")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_CRT_SALES_TAX_ADJ = EnumerationData.newBuilder()
        .setDescription("Customer Return Sales Tax Adjustment")
        .setEnumCode("CRT_SALES_TAX_ADJ")
        .setEnumId("CRT_SALES_TAX_ADJ")
        .setEnumTypeId("TAXABLE_INV_ITM_TY")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_CCT_VISA = EnumerationData.newBuilder()
        .setDescription("Visa")
        .setEnumCode("Visa")
        .setEnumId("CCT_VISA")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_CCT_MASTERCARD = EnumerationData.newBuilder()
        .setDescription("Master Card")
        .setEnumCode("MasterCard")
        .setEnumId("CCT_MASTERCARD")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_CCT_AMERICANEXPRESS = EnumerationData.newBuilder()
        .setDescription("American Express")
        .setEnumCode("AmericanExpress")
        .setEnumId("CCT_AMERICANEXPRESS")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_CCT_DINERSCLUB = EnumerationData.newBuilder()
        .setDescription("Diners Club")
        .setEnumCode("DinersClub")
        .setEnumId("CCT_DINERSCLUB")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_CCT_DISCOVER = EnumerationData.newBuilder()
        .setDescription("Discover")
        .setEnumCode("Discover")
        .setEnumId("CCT_DISCOVER")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_CCT_ENROUTE = EnumerationData.newBuilder()
        .setDescription("EnRoute")
        .setEnumCode("EnRoute")
        .setEnumId("CCT_ENROUTE")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_CCT_CARTEBLANCHE = EnumerationData.newBuilder()
        .setDescription("Carte Blanche")
        .setEnumCode("CarteBlanche")
        .setEnumId("CCT_CARTEBLANCHE")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_CCT_JCB = EnumerationData.newBuilder()
        .setDescription("JCB")
        .setEnumCode("JCB")
        .setEnumId("CCT_JCB")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("08")
        .build();


    public final static EnumerationData Enumeration_CCT_SOLO = EnumerationData.newBuilder()
        .setDescription("Solo")
        .setEnumCode("Solo")
        .setEnumId("CCT_SOLO")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("09")
        .build();


    public final static EnumerationData Enumeration_CCT_SWITCH = EnumerationData.newBuilder()
        .setDescription("Switch")
        .setEnumCode("Switch")
        .setEnumId("CCT_SWITCH")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("10")
        .build();


    public final static EnumerationData Enumeration_CCT_VISAELECTRON = EnumerationData.newBuilder()
        .setDescription("Visa Electron")
        .setEnumCode("VisaElectron")
        .setEnumId("CCT_VISAELECTRON")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("11")
        .build();


    public final static EnumerationData Enumeration_CCT_UATP = EnumerationData.newBuilder()
        .setDescription("Universal Air Travel Plan")
        .setEnumCode("UATP")
        .setEnumId("CCT_UATP")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setSequenceId("12")
        .build();


    public final static EnumerationData Enumeration_US_IRS_1120 = EnumerationData.newBuilder()
        .setDescription("Form 1120 (US IRS)")
        .setEnumCode("1120")
        .setEnumId("US_IRS_1120")
        .setEnumTypeId("TAX_FORMS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_US_IRS_1120S = EnumerationData.newBuilder()
        .setDescription("Form 1120S (US IRS)")
        .setEnumCode("1120S")
        .setEnumId("US_IRS_1120S")
        .setEnumTypeId("TAX_FORMS")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_US_IRS_1065 = EnumerationData.newBuilder()
        .setDescription("Form 1065 (US IRS)")
        .setEnumCode("1065")
        .setEnumId("US_IRS_1065")
        .setEnumTypeId("TAX_FORMS")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_US_IRS_990 = EnumerationData.newBuilder()
        .setDescription("Form 990 (US IRS)")
        .setEnumCode("990")
        .setEnumId("US_IRS_990")
        .setEnumTypeId("TAX_FORMS")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_US_IRS_990PF = EnumerationData.newBuilder()
        .setDescription("Form 990-PF (US IRS)")
        .setEnumCode("990PF")
        .setEnumId("US_IRS_990PF")
        .setEnumTypeId("TAX_FORMS")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_US_IRS_990T = EnumerationData.newBuilder()
        .setDescription("Form 990-T (US IRS)")
        .setEnumCode("990T")
        .setEnumId("US_IRS_990T")
        .setEnumTypeId("TAX_FORMS")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_US_IRS_1040 = EnumerationData.newBuilder()
        .setDescription("Form 1040 (US IRS)")
        .setEnumCode("1040")
        .setEnumId("US_IRS_1040")
        .setEnumTypeId("TAX_FORMS")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_COGS_LIFO = EnumerationData.newBuilder()
        .setDescription("LIFO")
        .setEnumCode("LIFO")
        .setEnumId("COGS_LIFO")
        .setEnumTypeId("COGS_METHODS")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_COGS_FIFO = EnumerationData.newBuilder()
        .setDescription("FIFO")
        .setEnumCode("FIFO")
        .setEnumId("COGS_FIFO")
        .setEnumTypeId("COGS_METHODS")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_COGS_AVG_COST = EnumerationData.newBuilder()
        .setDescription("Average Cost")
        .setEnumCode("AVG_COST")
        .setEnumId("COGS_AVG_COST")
        .setEnumTypeId("COGS_METHODS")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_COGS_INV_COST = EnumerationData.newBuilder()
        .setDescription("Inventory Item Cost")
        .setEnumCode("INV_COST")
        .setEnumId("COGS_INV_COST")
        .setEnumTypeId("COGS_METHODS")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_INVSQ_STANDARD = EnumerationData.newBuilder()
        .setDescription("Standard (faster, may have gaps, per system)")
        .setEnumCode("STANDARD")
        .setEnumId("INVSQ_STANDARD")
        .setEnumTypeId("INVOICE_SEQMD")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_INVSQ_ENF_SEQ = EnumerationData.newBuilder()
        .setDescription("Enforced Sequence (no gaps, per organization)")
        .setEnumCode("ENF_SEQ")
        .setEnumId("INVSQ_ENF_SEQ")
        .setEnumTypeId("INVOICE_SEQMD")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_INVSQ_RESTARTYR = EnumerationData.newBuilder()
        .setDescription("Restart on Fiscal Year (no gaps, per org, reset to 1 each year)")
        .setEnumCode("RESTARTYR")
        .setEnumId("INVSQ_RESTARTYR")
        .setEnumTypeId("INVOICE_SEQMD")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_QTESQ_STANDARD = EnumerationData.newBuilder()
        .setDescription("Standard (faster, may have gaps, per system)")
        .setEnumCode("STANDARD")
        .setEnumId("QTESQ_STANDARD")
        .setEnumTypeId("QUOTE_SEQMD")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_QTESQ_ENF_SEQ = EnumerationData.newBuilder()
        .setDescription("Enforced Sequence (no gaps, per organization)")
        .setEnumCode("ENF_SEQ")
        .setEnumId("QTESQ_ENF_SEQ")
        .setEnumTypeId("QUOTE_SEQMD")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_ODRSQ_STANDARD = EnumerationData.newBuilder()
        .setDescription("Standard (faster, may have gaps, per system)")
        .setEnumCode("STANDARD")
        .setEnumId("ODRSQ_STANDARD")
        .setEnumTypeId("ORDER_SEQMD")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_ODRSQ_ENF_SEQ = EnumerationData.newBuilder()
        .setDescription("Enforced Sequence (no gaps, per organization)")
        .setEnumCode("ENF_SEQ")
        .setEnumId("ODRSQ_ENF_SEQ")
        .setEnumTypeId("ORDER_SEQMD")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_POTT_DEST = EnumerationData.newBuilder()
        .setDescription("Desination")
        .setEnumCode("DEST")
        .setEnumId("POTT_DEST")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_POTT_ORIG = EnumerationData.newBuilder()
        .setDescription("Origin")
        .setEnumCode("ORIG")
        .setEnumId("POTT_ORIG")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_POTT_INTR = EnumerationData.newBuilder()
        .setDescription("In Transit")
        .setEnumCode("INTR")
        .setEnumId("POTT_INTR")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_POTT_EXW = EnumerationData.newBuilder()
        .setDescription("EX-Works")
        .setEnumCode("EXW")
        .setEnumId("POTT_EXW")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("11")
        .build();


    public final static EnumerationData Enumeration_POTT_FOB = EnumerationData.newBuilder()
        .setDescription("Free On Board")
        .setEnumCode("FOB")
        .setEnumId("POTT_FOB")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("12")
        .build();


    public final static EnumerationData Enumeration_POTT_FCA = EnumerationData.newBuilder()
        .setDescription("Free Carrier")
        .setEnumCode("FCA")
        .setEnumId("POTT_FCA")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("13")
        .build();


    public final static EnumerationData Enumeration_POTT_FAS = EnumerationData.newBuilder()
        .setDescription("Free Alongside Ship")
        .setEnumCode("FAS")
        .setEnumId("POTT_FAS")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("14")
        .build();


    public final static EnumerationData Enumeration_POTT_CFR = EnumerationData.newBuilder()
        .setDescription("Cost and Freight")
        .setEnumCode("CFR")
        .setEnumId("POTT_CFR")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("15")
        .build();


    public final static EnumerationData Enumeration_POTT_CIF = EnumerationData.newBuilder()
        .setDescription("Cost, Insurance and Freight")
        .setEnumCode("CIF")
        .setEnumId("POTT_CIF")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("16")
        .build();


    public final static EnumerationData Enumeration_POTT_CPT = EnumerationData.newBuilder()
        .setDescription("Carriage Paid To")
        .setEnumCode("CPT")
        .setEnumId("POTT_CPT")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("17")
        .build();


    public final static EnumerationData Enumeration_POTT_CIP = EnumerationData.newBuilder()
        .setDescription("Carriage and Insurance Paid To")
        .setEnumCode("CIP")
        .setEnumId("POTT_CIP")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("18")
        .build();


    public final static EnumerationData Enumeration_POTT_DAF = EnumerationData.newBuilder()
        .setDescription("Delivered At Frontier")
        .setEnumCode("DAF")
        .setEnumId("POTT_DAF")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("19")
        .build();


    public final static EnumerationData Enumeration_POTT_DES = EnumerationData.newBuilder()
        .setDescription("Delivered Ex Ship")
        .setEnumCode("DES")
        .setEnumId("POTT_DES")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("20")
        .build();


    public final static EnumerationData Enumeration_POTT_DEQ = EnumerationData.newBuilder()
        .setDescription("Delivered Ex Quay")
        .setEnumCode("DEQ")
        .setEnumId("POTT_DEQ")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("21")
        .build();


    public final static EnumerationData Enumeration_POTT_DDP = EnumerationData.newBuilder()
        .setDescription("Delivered Duty Paid")
        .setEnumCode("DDP")
        .setEnumId("POTT_DDP")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("22")
        .build();


    public final static EnumerationData Enumeration_POTT_DDQ = EnumerationData.newBuilder()
        .setDescription("Delivered Duty Unpaid")
        .setEnumCode("DDQ")
        .setEnumId("POTT_DDQ")
        .setEnumTypeId("PTSOFTTFR")
        .setSequenceId("23")
        .build();


    public final static EnumerationData Enumeration_FIN_ACCOUNT = EnumerationData.newBuilder()
        .setDescription("Financial Account")
        .setEnumCode("FINACCOUNT")
        .setEnumId("FIN_ACCOUNT")
        .setEnumTypeId("STR_CRDT_ACT")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_BILLING_ACCOUNT = EnumerationData.newBuilder()
        .setDescription("Billing Account")
        .setEnumCode("BILLACCOUNT")
        .setEnumId("BILLING_ACCOUNT")
        .setEnumTypeId("STR_CRDT_ACT")
        .setSequenceId("02")
        .build();


    public final static GlAccountClassData GlAccountClass_DEBIT = GlAccountClassData.newBuilder()
        .setDescription("Debit")
        .setGlAccountClassId("DEBIT")
        .setSequenceNum(100)
        .build();


    public final static GlAccountClassData GlAccountClass_CREDIT = GlAccountClassData.newBuilder()
        .setDescription("Credit")
        .setGlAccountClassId("CREDIT")
        .setSequenceNum(200)
        .build();


    public final static GlAccountClassData GlAccountClass_RESOURCE = GlAccountClassData.newBuilder()
        .setDescription("Resource")
        .setGlAccountClassId("RESOURCE")
        .setSequenceNum(300)
        .build();


    public final static GlAccountClassData GlAccountClass_ASSET = GlAccountClassData.newBuilder()
        .setDescription("Asset")
        .setGlAccountClassId("ASSET")
        .setParentClassId("DEBIT")
        .setSequenceNum(110)
        .build();


    public final static GlAccountClassData GlAccountClass_DISTRIBUTION = GlAccountClassData.newBuilder()
        .setDescription("Equity Distribution")
        .setGlAccountClassId("DISTRIBUTION")
        .setParentClassId("DEBIT")
        .setSequenceNum(130)
        .build();


    public final static GlAccountClassData GlAccountClass_EXPENSE = GlAccountClassData.newBuilder()
        .setDescription("Expense")
        .setGlAccountClassId("EXPENSE")
        .setParentClassId("DEBIT")
        .setSequenceNum(150)
        .build();


    public final static GlAccountClassData GlAccountClass_CONTRA_REVENUE = GlAccountClassData.newBuilder()
        .setDescription("Contra Revenue")
        .setGlAccountClassId("CONTRA_REVENUE")
        .setParentClassId("DEBIT")
        .setSequenceNum(170)
        .build();


    public final static GlAccountClassData GlAccountClass_NON_POSTING = GlAccountClassData.newBuilder()
        .setDescription("Non-Posting")
        .setGlAccountClassId("NON_POSTING")
        .setParentClassId("DEBIT")
        .setSequenceNum(190)
        .build();


    public final static GlAccountClassData GlAccountClass_LIABILITY = GlAccountClassData.newBuilder()
        .setDescription("Liability")
        .setGlAccountClassId("LIABILITY")
        .setParentClassId("CREDIT")
        .setSequenceNum(210)
        .build();


    public final static GlAccountClassData GlAccountClass_EQUITY = GlAccountClassData.newBuilder()
        .setDescription("Equity")
        .setGlAccountClassId("EQUITY")
        .setParentClassId("CREDIT")
        .setSequenceNum(230)
        .build();


    public final static GlAccountClassData GlAccountClass_REVENUE = GlAccountClassData.newBuilder()
        .setDescription("Revenue")
        .setGlAccountClassId("REVENUE")
        .setParentClassId("CREDIT")
        .setSequenceNum(250)
        .build();


    public final static GlAccountClassData GlAccountClass_CONTRA_ASSET = GlAccountClassData.newBuilder()
        .setDescription("Contra Asset")
        .setGlAccountClassId("CONTRA_ASSET")
        .setParentClassId("CREDIT")
        .setSequenceNum(270)
        .build();


    public final static GlAccountClassData GlAccountClass_INCOME = GlAccountClassData.newBuilder()
        .setDescription("Income")
        .setGlAccountClassId("INCOME")
        .setParentClassId("CREDIT")
        .setSequenceNum(290)
        .build();


    public final static GlAccountClassData GlAccountClass_CURRENT_ASSET = GlAccountClassData.newBuilder()
        .setDescription("Current Asset")
        .setGlAccountClassId("CURRENT_ASSET")
        .setParentClassId("ASSET")
        .setSequenceNum(115)
        .build();


    public final static GlAccountClassData GlAccountClass_LONGTERM_ASSET = GlAccountClassData.newBuilder()
        .setDescription("Long Term Asset")
        .setGlAccountClassId("LONGTERM_ASSET")
        .setParentClassId("ASSET")
        .setSequenceNum(125)
        .build();


    public final static GlAccountClassData GlAccountClass_CASH_EQUIVALENT = GlAccountClassData.newBuilder()
        .setDescription("Cash and Equivalent")
        .setGlAccountClassId("CASH_EQUIVALENT")
        .setParentClassId("CURRENT_ASSET")
        .setSequenceNum(120)
        .build();


    public final static GlAccountClassData GlAccountClass_INVENTORY_ASSET = GlAccountClassData.newBuilder()
        .setDescription("Inventory Asset")
        .setGlAccountClassId("INVENTORY_ASSET")
        .setParentClassId("CURRENT_ASSET")
        .setSequenceNum(122)
        .build();


    public final static GlAccountClassData GlAccountClass_RETURN_OF_CAPITAL = GlAccountClassData.newBuilder()
        .setDescription("Return of Capital")
        .setGlAccountClassId("RETURN_OF_CAPITAL")
        .setParentClassId("DISTRIBUTION")
        .setSequenceNum(135)
        .build();


    public final static GlAccountClassData GlAccountClass_DIVIDEND = GlAccountClassData.newBuilder()
        .setDescription("Dividends")
        .setGlAccountClassId("DIVIDEND")
        .setParentClassId("DISTRIBUTION")
        .setSequenceNum(145)
        .build();


    public final static GlAccountClassData GlAccountClass_CASH_EXPENSE = GlAccountClassData.newBuilder()
        .setDescription("Cash Expense")
        .setGlAccountClassId("CASH_EXPENSE")
        .setParentClassId("EXPENSE")
        .setSequenceNum(155)
        .build();


    public final static GlAccountClassData GlAccountClass_NON_CASH_EXPENSE = GlAccountClassData.newBuilder()
        .setDescription("Non-Cash Expense")
        .setGlAccountClassId("NON_CASH_EXPENSE")
        .setParentClassId("EXPENSE")
        .setSequenceNum(165)
        .build();


    public final static GlAccountClassData GlAccountClass_INTEREST_EXPENSE = GlAccountClassData.newBuilder()
        .setDescription("Interest Expense")
        .setGlAccountClassId("INTEREST_EXPENSE")
        .setParentClassId("CASH_EXPENSE")
        .setSequenceNum(160)
        .build();


    public final static GlAccountClassData GlAccountClass_COGS_EXPENSE = GlAccountClassData.newBuilder()
        .setDescription("Cost of Goods Sold Expense")
        .setGlAccountClassId("COGS_EXPENSE")
        .setParentClassId("CASH_EXPENSE")
        .setSequenceNum(162)
        .build();


    public final static GlAccountClassData GlAccountClass_SGA_EXPENSE = GlAccountClassData.newBuilder()
        .setDescription("Selling, General, and Administrative Expense")
        .setGlAccountClassId("SGA_EXPENSE")
        .setParentClassId("CASH_EXPENSE")
        .setSequenceNum(165)
        .build();


    public final static GlAccountClassData GlAccountClass_DEPRECIATION = GlAccountClassData.newBuilder()
        .setDescription("Depreciation")
        .setGlAccountClassId("DEPRECIATION")
        .setParentClassId("NON_CASH_EXPENSE")
        .setSequenceNum(166)
        .build();


    public final static GlAccountClassData GlAccountClass_AMORTIZATION = GlAccountClassData.newBuilder()
        .setDescription("Amortization")
        .setGlAccountClassId("AMORTIZATION")
        .setParentClassId("NON_CASH_EXPENSE")
        .setSequenceNum(168)
        .build();


    public final static GlAccountClassData GlAccountClass_INVENTORY_ADJUST = GlAccountClassData.newBuilder()
        .setDescription("Inventory Adjustment")
        .setGlAccountClassId("INVENTORY_ADJUST")
        .setParentClassId("NON_CASH_EXPENSE")
        .setSequenceNum(169)
        .build();


    public final static GlAccountClassData GlAccountClass_CURRENT_LIABILITY = GlAccountClassData.newBuilder()
        .setDescription("Current Liability")
        .setGlAccountClassId("CURRENT_LIABILITY")
        .setParentClassId("LIABILITY")
        .setSequenceNum(215)
        .build();


    public final static GlAccountClassData GlAccountClass_LONGTERM_LIABILITY = GlAccountClassData.newBuilder()
        .setDescription("Long Term Liability")
        .setGlAccountClassId("LONGTERM_LIABILITY")
        .setParentClassId("LIABILITY")
        .setSequenceNum(225)
        .build();


    public final static GlAccountClassData GlAccountClass_OWNERS_EQUITY = GlAccountClassData.newBuilder()
        .setDescription("Owners Equity")
        .setGlAccountClassId("OWNERS_EQUITY")
        .setParentClassId("EQUITY")
        .setSequenceNum(235)
        .build();


    public final static GlAccountClassData GlAccountClass_RETAINED_EARNINGS = GlAccountClassData.newBuilder()
        .setDescription("Retained Earnings")
        .setGlAccountClassId("RETAINED_EARNINGS")
        .setParentClassId("EQUITY")
        .setSequenceNum(245)
        .build();


    public final static GlAccountClassData GlAccountClass_ACCUM_DEPRECIATION = GlAccountClassData.newBuilder()
        .setDescription("Accumulated Depreciation")
        .setGlAccountClassId("ACCUM_DEPRECIATION")
        .setParentClassId("CONTRA_ASSET")
        .setSequenceNum(275)
        .build();


    public final static GlAccountClassData GlAccountClass_ACCUM_AMORTIZATION = GlAccountClassData.newBuilder()
        .setDescription("Accumulated Amortization")
        .setGlAccountClassId("ACCUM_AMORTIZATION")
        .setParentClassId("CONTRA_ASSET")
        .setSequenceNum(285)
        .build();


    public final static GlAccountClassData GlAccountClass_CASH_INCOME = GlAccountClassData.newBuilder()
        .setDescription("Cash Income")
        .setGlAccountClassId("CASH_INCOME")
        .setParentClassId("INCOME")
        .setSequenceNum(295)
        .build();


    public final static GlAccountClassData GlAccountClass_NON_CASH_INCOME = GlAccountClassData.newBuilder()
        .setDescription("Non-Cash Income")
        .setGlAccountClassId("NON_CASH_INCOME")
        .setParentClassId("INCOME")
        .setSequenceNum(298)
        .build();


    public final static BudgetReviewResultTypeData BudgetReviewResultType_BGR_ACCEPTED = BudgetReviewResultTypeData.newBuilder()
        .setBudgetReviewResultTypeId("BGR_ACCEPTED")
        .setDescription("Accepted")
        .build();


    public final static BudgetReviewResultTypeData BudgetReviewResultType_BGR_REJECTED = BudgetReviewResultTypeData.newBuilder()
        .setBudgetReviewResultTypeId("BGR_REJECTED")
        .setDescription("Rejected")
        .build();


    public final static FinAccountTransTypeData FinAccountTransType_DEPOSIT = FinAccountTransTypeData.newBuilder()
        .setDescription("Deposit")
        .setFinAccountTransTypeId("DEPOSIT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FinAccountTransTypeData FinAccountTransType_WITHDRAWAL = FinAccountTransTypeData.newBuilder()
        .setDescription("Withdraw")
        .setFinAccountTransTypeId("WITHDRAWAL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FinAccountTransTypeData FinAccountTransType_ADJUSTMENT = FinAccountTransTypeData.newBuilder()
        .setDescription("Adjustment")
        .setFinAccountTransTypeId("ADJUSTMENT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_GC_FULFILL = EnumerationTypeData.newBuilder()
        .setDescription("Gift Card Fulfillment")
        .setEnumTypeId("GC_FULFILL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PGT_CODE = EnumerationTypeData.newBuilder()
        .setDescription("Payment Gateway Transaction Code")
        .setEnumTypeId("PGT_CODE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_FARP_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Financial Account Replenish Type")
        .setEnumTypeId("FARP_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_FARP_METHOD = EnumerationTypeData.newBuilder()
        .setDescription("Financial Account Replenish Method")
        .setEnumTypeId("FARP_METHOD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_FINACCT_TRANS_REASON = EnumerationTypeData.newBuilder()
        .setDescription("Service Debit Reasons")
        .setEnumTypeId("FINACCT_TRANS_REASON")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_FXAST_CLASS = EnumerationTypeData.newBuilder()
        .setDescription("Fixed Asset Class")
        .setEnumTypeId("FXAST_CLASS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_FXAST_COMPU_HARDWARE = EnumerationTypeData.newBuilder()
        .setDescription("Computer Hardware")
        .setEnumTypeId("FXAST_COMPU_HARDWARE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FXAST_CLASS")
        .build();


    public final static EnumerationTypeData EnumerationType_FXAST_COMPU_SOFTWARE = EnumerationTypeData.newBuilder()
        .setDescription("Computer Software")
        .setEnumTypeId("FXAST_COMPU_SOFTWARE")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("FXAST_CLASS")
        .build();


    public final static EnumerationTypeData EnumerationType_TAXABLE_INV_ITM_TY = EnumerationTypeData.newBuilder()
        .setDescription("Taxable Invoice Item Types")
        .setEnumTypeId("TAXABLE_INV_ITM_TY")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_CREDIT_CARD_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Credit Card Type")
        .setEnumTypeId("CREDIT_CARD_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_TAX_FORMS = EnumerationTypeData.newBuilder()
        .setDescription("Tax Forms")
        .setEnumTypeId("TAX_FORMS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_COGS_METHODS = EnumerationTypeData.newBuilder()
        .setDescription("COGS Methods")
        .setEnumTypeId("COGS_METHODS")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_INVOICE_SEQMD = EnumerationTypeData.newBuilder()
        .setDescription("Invoice Sequence Mode")
        .setEnumTypeId("INVOICE_SEQMD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_QUOTE_SEQMD = EnumerationTypeData.newBuilder()
        .setDescription("Quote Sequence Mode")
        .setEnumTypeId("QUOTE_SEQMD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_ORDER_SEQMD = EnumerationTypeData.newBuilder()
        .setDescription("Order Sequence Mode")
        .setEnumTypeId("ORDER_SEQMD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PTSOFTTFR = EnumerationTypeData.newBuilder()
        .setDescription("Points of Title Transfer")
        .setEnumTypeId("PTSOFTTFR")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_STR_CRDT_ACT = EnumerationTypeData.newBuilder()
        .setDescription("Store Credit Account")
        .setEnumTypeId("STR_CRDT_ACT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static TaxAuthorityRateTypeData TaxAuthorityRateType_SALES_TAX = TaxAuthorityRateTypeData.newBuilder()
        .setDescription("Sales Tax")
        .setTaxAuthorityRateTypeId("SALES_TAX")
        .build();


    public final static TaxAuthorityRateTypeData TaxAuthorityRateType_USE_TAX = TaxAuthorityRateTypeData.newBuilder()
        .setDescription("Use Tax")
        .setTaxAuthorityRateTypeId("USE_TAX")
        .build();


    public final static TaxAuthorityRateTypeData TaxAuthorityRateType_INCOME_TAX = TaxAuthorityRateTypeData.newBuilder()
        .setDescription("Income Tax")
        .setTaxAuthorityRateTypeId("INCOME_TAX")
        .build();


    public final static TaxAuthorityRateTypeData TaxAuthorityRateType_EXPORT_TAX = TaxAuthorityRateTypeData.newBuilder()
        .setDescription("Export Tax")
        .setTaxAuthorityRateTypeId("EXPORT_TAX")
        .build();


    public final static TaxAuthorityRateTypeData TaxAuthorityRateType_IMPORT_TAX = TaxAuthorityRateTypeData.newBuilder()
        .setDescription("Import Tax")
        .setTaxAuthorityRateTypeId("IMPORT_TAX")
        .build();


    public final static TaxAuthorityRateTypeData TaxAuthorityRateType_VAT_TAX = TaxAuthorityRateTypeData.newBuilder()
        .setDescription("Value Added Tax")
        .setTaxAuthorityRateTypeId("VAT_TAX")
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_INVOICE_EXPORT = GoodIdentificationTypeData.newBuilder()
        .setDescription("replacement value for partyId in the invoice export function in accounting")
        .setGoodIdentificationTypeId("INVOICE_EXPORT")
        .build();


    public final static TaxAuthorityAssocTypeData TaxAuthorityAssocType_EXEMPT_INHER = TaxAuthorityAssocTypeData.newBuilder()
        .setDescription("Exemption Inheritance")
        .setTaxAuthorityAssocTypeId("EXEMPT_INHER")
        .build();


    public final static TaxAuthorityAssocTypeData TaxAuthorityAssocType_COLLECT_AGENT = TaxAuthorityAssocTypeData.newBuilder()
        .setDescription("Collection Agent")
        .setTaxAuthorityAssocTypeId("COLLECT_AGENT")
        .build();


    public final static InvoiceTypeData InvoiceType_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Invoice")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_PURCHASE_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Purchase Invoice")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("PURCHASE_INVOICE")
        .setParentTypeId("INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_SALES_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Sales Invoice")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("SALES_INVOICE")
        .setParentTypeId("INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_CUST_RTN_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Customer Return")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("CUST_RTN_INVOICE")
        .setParentTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_PURC_RTN_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Purchase Return")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("PURC_RTN_INVOICE")
        .setParentTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_COMMISSION_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Commission")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("COMMISSION_INVOICE")
        .setParentTypeId("PURCHASE_INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_INTEREST_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Interest")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("INTEREST_INVOICE")
        .setParentTypeId("SALES_INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_TEMPLATE = InvoiceTypeData.newBuilder()
        .setDescription("Invoice Template")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("TEMPLATE")
        .setParentTypeId("INVOICE")
        .build();


    public final static InvoiceTypeData InvoiceType_SALES_INV_TEMPLATE = InvoiceTypeData.newBuilder()
        .setDescription("Sales Invoice Template")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("SALES_INV_TEMPLATE")
        .setParentTypeId("TEMPLATE")
        .build();


    public final static InvoiceTypeData InvoiceType_PUR_INV_TEMPLATE = InvoiceTypeData.newBuilder()
        .setDescription("Purchase Invoice Template")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("PUR_INV_TEMPLATE")
        .setParentTypeId("TEMPLATE")
        .build();


    public final static InvoiceTypeData InvoiceType_PAYROL_INVOICE = InvoiceTypeData.newBuilder()
        .setDescription("Payrol")
        .setHasTable(castIndicator("N"))
        .setInvoiceTypeId("PAYROL_INVOICE")
        .setParentTypeId("PURCHASE_INVOICE")
        .build();


    public final static GlAccountGroupTypeData GlAccountGroupType_TAX_FIELD_US = GlAccountGroupTypeData.newBuilder()
        .setDescription("Tax Form Field: USA")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static StatusTypeData StatusType_ACCTG_ENREC_STATUS = StatusTypeData.newBuilder()
        .setDescription("Acctg Entry Reconcile")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("ACCTG_ENREC_STATUS")
        .build();


    public final static StatusTypeData StatusType_FINACCT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Financial Account Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("FINACCT_STATUS")
        .build();


    public final static StatusTypeData StatusType_FINACT_TRNS_STATUS = StatusTypeData.newBuilder()
        .setDescription("Financial Account Trans Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("FINACT_TRNS_STATUS")
        .build();


    public final static StatusTypeData StatusType_FIXEDAST_MNT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Fixed Asset Maintenance")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("FIXEDAST_MNT_STATUS")
        .build();


    public final static StatusTypeData StatusType_BUDGET_STATUS = StatusTypeData.newBuilder()
        .setDescription("Budget")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("BUDGET_STATUS")
        .build();


    public final static StatusTypeData StatusType_PARTY_ASSET_STATUS = StatusTypeData.newBuilder()
        .setDescription("Party Asset")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PARTY_ASSET_STATUS")
        .build();


    public final static StatusTypeData StatusType_INVOICE_STATUS = StatusTypeData.newBuilder()
        .setDescription("Invoice Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("INVOICE_STATUS")
        .build();


    public final static StatusTypeData StatusType_PMNT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Payment Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PMNT_STATUS")
        .build();


    public final static StatusTypeData StatusType_GLREC_STATUS = StatusTypeData.newBuilder()
        .setDescription("Gl Reconciliation Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("GLREC_STATUS")
        .build();


    public final static FixedAssetIdentTypeData FixedAssetIdentType_MFG_SERIAL = FixedAssetIdentTypeData.newBuilder()
        .setDescription("Mfg Serial Number")
        .setFixedAssetIdentTypeId("MFG_SERIAL")
        .build();


    public final static FixedAssetIdentTypeData FixedAssetIdentType_TRACKING_VENDOR = FixedAssetIdentTypeData.newBuilder()
        .setDescription("Vendor Tracking/Inventory Number")
        .setFixedAssetIdentTypeId("TRACKING_VENDOR")
        .build();


    public final static FixedAssetIdentTypeData FixedAssetIdentType_TRACKING_LABEL = FixedAssetIdentTypeData.newBuilder()
        .setDescription("Internal Tracking Label Number")
        .setFixedAssetIdentTypeId("TRACKING_LABEL")
        .build();


    public final static FixedAssetIdentTypeData FixedAssetIdentType_VIN = FixedAssetIdentTypeData.newBuilder()
        .setDescription("Vehicle Identification Number (VIN)")
        .setFixedAssetIdentTypeId("VIN")
        .build();


    public final static FixedAssetIdentTypeData FixedAssetIdentType_GAS_CARD1 = FixedAssetIdentTypeData.newBuilder()
        .setDescription("Gas Card Number 1")
        .setFixedAssetIdentTypeId("GAS_CARD1")
        .build();


    public final static FixedAssetIdentTypeData FixedAssetIdentType_GAS_CARD2 = FixedAssetIdentTypeData.newBuilder()
        .setDescription("Gas Card Number 2")
        .setFixedAssetIdentTypeId("GAS_CARD2")
        .build();


    public final static FixedAssetIdentTypeData FixedAssetIdentType_GAS_CARD3 = FixedAssetIdentTypeData.newBuilder()
        .setDescription("Gas Card Number 3")
        .setFixedAssetIdentTypeId("GAS_CARD3")
        .build();


    public final static AcctgTransEntryTypeData AcctgTransEntryType__NA_ = AcctgTransEntryTypeData.newBuilder()
        .setAcctgTransEntryTypeId("_NA_")
        .setDescription("Not Applicable")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GlXbrlClassData GlXbrlClass_US_GAAP = GlXbrlClassData.newBuilder()
        .setDescription("US GAAP")
        .setGlXbrlClassId("US_GAAP")
        .build();


    public final static GlXbrlClassData GlXbrlClass_IAS = GlXbrlClassData.newBuilder()
        .setDescription("IAS")
        .setGlXbrlClassId("IAS")
        .build();


    public final static EmplPositionTypeData EmplPositionType__NA_ = EmplPositionTypeData.newBuilder()
        .setEmplPositionTypeId("_NA_")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9001 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: Other income, misc.")
        .setGlAccountGroupId("9001")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9002 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: IRA contribution, self")
        .setGlAccountGroupId("9002")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9003 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: IRA contribution, spouse")
        .setGlAccountGroupId("9003")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9004 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: Keogh deduction, self")
        .setGlAccountGroupId("9004")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9005 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: Keogh deduction, spouse")
        .setGlAccountGroupId("9005")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9006 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: SEP deduction, self")
        .setGlAccountGroupId("9006")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9007 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: SEP deduction, spouse")
        .setGlAccountGroupId("9007")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9008 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: SIMPLE contribution, self")
        .setGlAccountGroupId("9008")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9009 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: SIMPLE contribution, spouse")
        .setGlAccountGroupId("9009")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9010 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1040: Federal estimated tax, quarterly")
        .setGlAccountGroupId("9010")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9021 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule B: Interest income")
        .setGlAccountGroupId("9021")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9022 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule B: Dividend income")
        .setGlAccountGroupId("9022")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9031 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Gross receipts or sales")
        .setGlAccountGroupId("9031")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9032 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Returns and allowances")
        .setGlAccountGroupId("9032")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9033 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Other business income")
        .setGlAccountGroupId("9033")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9034 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Advertising")
        .setGlAccountGroupId("9034")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9035 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Bad debts from sales/services")
        .setGlAccountGroupId("9035")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9036 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Car and truck expenses")
        .setGlAccountGroupId("9036")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9037 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Commissions and fees")
        .setGlAccountGroupId("9037")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9038 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Depletion")
        .setGlAccountGroupId("9038")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9039 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Employee benefit programs")
        .setGlAccountGroupId("9039")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9040 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Insurance (other than health)")
        .setGlAccountGroupId("9040")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9041 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Interest expense, mortgage")
        .setGlAccountGroupId("9041")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9042 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Interest expense, other")
        .setGlAccountGroupId("9042")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9043 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Legal and professional fees")
        .setGlAccountGroupId("9043")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9044 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Office expenses")
        .setGlAccountGroupId("9044")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9045 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Pension/profit-sharing plans")
        .setGlAccountGroupId("9045")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9046 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Rent/lease vehicles, equipment")
        .setGlAccountGroupId("9046")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9047 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Rent/lease other business property")
        .setGlAccountGroupId("9047")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9048 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Repairs and maintenance")
        .setGlAccountGroupId("9048")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9049 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Supplies purchased (not from COGS)")
        .setGlAccountGroupId("9049")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9050 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Taxes and licenses")
        .setGlAccountGroupId("9050")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9051 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Travel")
        .setGlAccountGroupId("9051")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9052 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Meals and entertainment")
        .setGlAccountGroupId("9052")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9053 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Utilities")
        .setGlAccountGroupId("9053")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9054 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Wages paid")
        .setGlAccountGroupId("9054")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9055 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: Other business expenses")
        .setGlAccountGroupId("9055")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9056 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: COGS purchases")
        .setGlAccountGroupId("9056")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9057 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: COGS labor")
        .setGlAccountGroupId("9057")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9058 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: COGS materials/supplies")
        .setGlAccountGroupId("9058")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9059 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule C: COGS other")
        .setGlAccountGroupId("9059")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9071 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Rents received")
        .setGlAccountGroupId("9071")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9072 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Royalties received")
        .setGlAccountGroupId("9072")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9073 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Advertising")
        .setGlAccountGroupId("9073")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9074 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Auto and travel")
        .setGlAccountGroupId("9074")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9075 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Cleaning and maintenance")
        .setGlAccountGroupId("9075")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9076 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Commissions")
        .setGlAccountGroupId("9076")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9077 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Insurance")
        .setGlAccountGroupId("9077")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9078 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Legal and professional fees")
        .setGlAccountGroupId("9078")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9079 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Management fees")
        .setGlAccountGroupId("9079")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9080 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Interest expense, mortgage")
        .setGlAccountGroupId("9080")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9081 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Interest expense, other")
        .setGlAccountGroupId("9081")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9082 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Repairs and maintenance")
        .setGlAccountGroupId("9082")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9083 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Supplies purchased")
        .setGlAccountGroupId("9083")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9084 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Taxes")
        .setGlAccountGroupId("9084")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9085 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Utilities")
        .setGlAccountGroupId("9085")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9086 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule E: Other expenses")
        .setGlAccountGroupId("9086")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9101 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Resales livestock/items")
        .setGlAccountGroupId("9101")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9102 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Cost of resale livestock/items")
        .setGlAccountGroupId("9102")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9103 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Sale of livestock/produce")
        .setGlAccountGroupId("9103")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9104 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Total co-op distributions")
        .setGlAccountGroupId("9104")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9105 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Agricultural program payments")
        .setGlAccountGroupId("9105")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9106 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: CCC loans reported/election")
        .setGlAccountGroupId("9106")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9107 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: CCC loans forfeited/repaid")
        .setGlAccountGroupId("9107")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9108 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Crop insurance proceeds received")
        .setGlAccountGroupId("9108")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9109 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Crop insurance proceeds deferred")
        .setGlAccountGroupId("9109")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9110 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Custom hire income")
        .setGlAccountGroupId("9110")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9111 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Other farm income")
        .setGlAccountGroupId("9111")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9112 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Car and truck expenses")
        .setGlAccountGroupId("9112")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9113 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Chemicals")
        .setGlAccountGroupId("9113")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9114 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Conservation expenses")
        .setGlAccountGroupId("9114")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9115 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Custom hire expenses")
        .setGlAccountGroupId("9115")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9116 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Employee benefit programs")
        .setGlAccountGroupId("9116")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9117 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Feed purchased")
        .setGlAccountGroupId("9117")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9118 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Fertilizers and lime")
        .setGlAccountGroupId("9118")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9119 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Freight and trucking")
        .setGlAccountGroupId("9119")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9120 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Gasoline, fuel, and oil")
        .setGlAccountGroupId("9120")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9121 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Insurance (other than health)")
        .setGlAccountGroupId("9121")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9122 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Interest expense, mortgage")
        .setGlAccountGroupId("9122")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9123 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Interest expense, other")
        .setGlAccountGroupId("9123")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9124 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Labor hired")
        .setGlAccountGroupId("9124")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9125 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Pension/profit-sharing plans")
        .setGlAccountGroupId("9125")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9126 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Rent/lease vehicles, equipment")
        .setGlAccountGroupId("9126")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9127 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Rent/lease land, animals")
        .setGlAccountGroupId("9127")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9128 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Repairs and maintenance")
        .setGlAccountGroupId("9128")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9129 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Seeds and plants purchased")
        .setGlAccountGroupId("9129")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9130 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Storage and warehousing")
        .setGlAccountGroupId("9130")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9131 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Supplies purchased")
        .setGlAccountGroupId("9131")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9132 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Taxes")
        .setGlAccountGroupId("9132")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9133 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Utilities")
        .setGlAccountGroupId("9133")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9134 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Vet, breeding, medicine")
        .setGlAccountGroupId("9134")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9135 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule F: Other farm expenses")
        .setGlAccountGroupId("9135")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9151 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Ordinary income or loss")
        .setGlAccountGroupId("9151")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9152 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Rental RE income or loss")
        .setGlAccountGroupId("9152")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9153 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Other rental income or loss")
        .setGlAccountGroupId("9153")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9154 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Interest income")
        .setGlAccountGroupId("9154")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9155 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Dividends")
        .setGlAccountGroupId("9155")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9156 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Royalties")
        .setGlAccountGroupId("9156")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9157 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Net ST capital gain or loss")
        .setGlAccountGroupId("9157")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9158 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Net LT capital gain or loss")
        .setGlAccountGroupId("9158")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9159 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: 28% rate gain or loss")
        .setGlAccountGroupId("9159")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9160 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Qualified 5-year gain")
        .setGlAccountGroupId("9160")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9161 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Guaranteed partner payments")
        .setGlAccountGroupId("9161")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9162 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Net Section 1231 gain or loss")
        .setGlAccountGroupId("9162")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9163 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Other income or loss")
        .setGlAccountGroupId("9163")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9164 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Tax-exempt interest income")
        .setGlAccountGroupId("9164")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9165 = GlAccountGroupData.newBuilder()
        .setDescription("Schedule K-1: Total foreign tax")
        .setGlAccountGroupId("9165")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9201 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Prizes and awards")
        .setGlAccountGroupId("9201")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9202 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Rents")
        .setGlAccountGroupId("9202")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9203 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Royalties")
        .setGlAccountGroupId("9203")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9204 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Other income")
        .setGlAccountGroupId("9204")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9205 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Federal tax withheld")
        .setGlAccountGroupId("9205")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9206 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Fishing boat proceeds")
        .setGlAccountGroupId("9206")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9207 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Medical/health payments")
        .setGlAccountGroupId("9207")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9208 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Nonemployee compensation")
        .setGlAccountGroupId("9208")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9209 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: Crop insurance proceeds")
        .setGlAccountGroupId("9209")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9210 = GlAccountGroupData.newBuilder()
        .setDescription("Form 1099-MISC: State tax withheld")
        .setGlAccountGroupId("9210")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9401 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Sale of livestock/produce")
        .setGlAccountGroupId("9401")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9402 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Total co-op distributions")
        .setGlAccountGroupId("9402")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9403 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Agricultural program payments")
        .setGlAccountGroupId("9403")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9404 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: CCC loans reported/election")
        .setGlAccountGroupId("9404")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9405 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: CCC loans forfeited/repaid")
        .setGlAccountGroupId("9405")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9406 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Crop insurance proceeds received")
        .setGlAccountGroupId("9406")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9407 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Crop insurance proceeds deferred")
        .setGlAccountGroupId("9407")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9408 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Other income")
        .setGlAccountGroupId("9408")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9409 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Car and truck expenses")
        .setGlAccountGroupId("9409")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9410 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Chemicals")
        .setGlAccountGroupId("9410")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9411 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Conservation expenses")
        .setGlAccountGroupId("9411")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9412 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Custom hire expenses")
        .setGlAccountGroupId("9412")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9413 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Employee benefit programs")
        .setGlAccountGroupId("9413")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9414 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Feed purchased")
        .setGlAccountGroupId("9414")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9415 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Fertilizers and lime")
        .setGlAccountGroupId("9415")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9416 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Freight and trucking")
        .setGlAccountGroupId("9416")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9417 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Gasoline, fuel, and oil")
        .setGlAccountGroupId("9417")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9418 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Insurance (other than health)")
        .setGlAccountGroupId("9418")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9419 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Interest expense, mortgage")
        .setGlAccountGroupId("9419")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9420 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Interest expense, other")
        .setGlAccountGroupId("9420")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9421 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Labor hired")
        .setGlAccountGroupId("9421")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9422 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Pension/profit-sharing plans")
        .setGlAccountGroupId("9422")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9423 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Rent/lease vehicles, equipment")
        .setGlAccountGroupId("9423")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9424 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Rent/lease land, animals")
        .setGlAccountGroupId("9424")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9425 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Repairs and maintenance")
        .setGlAccountGroupId("9425")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9426 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Seeds and plants purchased")
        .setGlAccountGroupId("9426")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9427 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Storage and warehousing")
        .setGlAccountGroupId("9427")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9428 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Supplies purchased")
        .setGlAccountGroupId("9428")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9429 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Taxes")
        .setGlAccountGroupId("9429")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9430 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Utilities")
        .setGlAccountGroupId("9430")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9431 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Vet, breeding, medicine")
        .setGlAccountGroupId("9431")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9432 = GlAccountGroupData.newBuilder()
        .setDescription("Form 4835: Other expenses")
        .setGlAccountGroupId("9432")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9801 = GlAccountGroupData.newBuilder()
        .setDescription("Form 8829: Deductable mortgage expense")
        .setGlAccountGroupId("9801")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9802 = GlAccountGroupData.newBuilder()
        .setDescription("Form 8829: Real estate taxes")
        .setGlAccountGroupId("9802")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9803 = GlAccountGroupData.newBuilder()
        .setDescription("Form 8829: Insurance")
        .setGlAccountGroupId("9803")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9804 = GlAccountGroupData.newBuilder()
        .setDescription("Form 8829: Repairs and maintenance")
        .setGlAccountGroupId("9804")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9805 = GlAccountGroupData.newBuilder()
        .setDescription("Form 8829: Utilities")
        .setGlAccountGroupId("9805")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static GlAccountGroupData GlAccountGroup_9806 = GlAccountGroupData.newBuilder()
        .setDescription("Form 8829: Other expenses")
        .setGlAccountGroupId("9806")
        .setGlAccountGroupTypeId("TAX_FIELD_US")
        .build();


    public final static CustomMethodTypeData CustomMethodType_CC_AUTH = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("CC_AUTH")
        .setDescription("Credit Card authorize methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_CC_CAPTURE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("CC_CAPTURE")
        .setDescription("Credit Card capture methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_CC_REFUND = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("CC_REFUND")
        .setDescription("Credit Card refund methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_CC_RELEASE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("CC_RELEASE")
        .setDescription("Credit Card release methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_CC_CREDIT = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("CC_CREDIT")
        .setDescription("Credit Card credit methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_EFT_AUTH = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("EFT_AUTH")
        .setDescription("EFT authorize methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_EFT_RELEASE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("EFT_RELEASE")
        .setDescription("EFT release methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_FIN_AUTH = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("FIN_AUTH")
        .setDescription("FIN account authorize methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_FIN_CAPTURE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("FIN_CAPTURE")
        .setDescription("FIN account capture methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_FIN_REFUND = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("FIN_REFUND")
        .setDescription("FIN account refund methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_FIN_RELEASE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("FIN_RELEASE")
        .setDescription("FIN account release methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_FIN_PURCHASE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("FIN_PURCHASE")
        .setDescription("FIN account purchase methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_GIFT_AUTH = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("GIFT_AUTH")
        .setDescription("GIFT card authorize methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_GIFT_CAPTURE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("GIFT_CAPTURE")
        .setDescription("GIFT card capture methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_GIFT_REFUND = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("GIFT_REFUND")
        .setDescription("GIFT card refund methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_GIFT_RELEASE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("GIFT_RELEASE")
        .setDescription("GIFT card release methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_GIFT_PURCHASE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("GIFT_PURCHASE")
        .setDescription("GIFT card purchase methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_PAYPAL_AUTH = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("PAYPAL_AUTH")
        .setDescription("PayPal authorize methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_PAYPAL_CAPTURE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("PAYPAL_CAPTURE")
        .setDescription("PayPal capture methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_PAYPAL_REFUND = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("PAYPAL_REFUND")
        .setDescription("PayPal refund methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_PAYPAL_RELEASE = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("PAYPAL_RELEASE")
        .setDescription("PayPal release methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CustomMethodTypeData CustomMethodType_HOOK = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("HOOK")
        .setDescription("Custom Methode Type define HOOK method to resolve specific sequence")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("HOOK")
        .build();


    public final static CustomMethodTypeData CustomMethodType_INVOICE_HOOK = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("INVOICE_HOOK")
        .setDescription("Invoice Sequence methods")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("HOOK")
        .build();


    public final static CustomMethodTypeData CustomMethodType_QUOTE_HOOK = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("QUOTE_HOOK")
        .setDescription("Quote Sequence methods")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("HOOK")
        .build();


    public final static CustomMethodTypeData CustomMethodType_ORDER_HOOK = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("ORDER_HOOK")
        .setDescription("Order Sequence methods")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("HOOK")
        .build();


    public final static CustomMethodTypeData CustomMethodType_DEPRECIATION_FORMULA = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("DEPRECIATION_FORMULA")
        .setDescription("Formula for calculating depreciation for fixed asset")
        .build();


    public final static CustomScreenTypeData CustomScreenType_CST_INVOICE_TPL = CustomScreenTypeData.newBuilder()
        .setCustomScreenTypeId("CST_INVOICE_TPL")
        .setDescription("Invoice types template")
        .build();


    public final static CustomScreenTypeData CustomScreenType_CST_ORDER_TPL = CustomScreenTypeData.newBuilder()
        .setCustomScreenTypeId("CST_ORDER_TPL")
        .setDescription("Order types template")
        .build();


    public final static CustomScreenTypeData CustomScreenType_CST_QUOTE_TPL = CustomScreenTypeData.newBuilder()
        .setCustomScreenTypeId("CST_QUOTE_TPL")
        .setDescription("Quote types template")
        .build();


    public final static FixedAssetTypeData FixedAssetType_EQUIPMENT = FixedAssetTypeData.newBuilder()
        .setDescription("Equipment")
        .setFixedAssetTypeId("EQUIPMENT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_PRODUCTION_EQUIPMENT = FixedAssetTypeData.newBuilder()
        .setDescription("The fixed asset used in the operation-routing definition")
        .setFixedAssetTypeId("PRODUCTION_EQUIPMENT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_GROUP_EQUIPMENT = FixedAssetTypeData.newBuilder()
        .setDescription("Group of machines, used for task and routing definition")
        .setFixedAssetTypeId("GROUP_EQUIPMENT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_OTHER_FIXED_ASSET = FixedAssetTypeData.newBuilder()
        .setDescription("Other Fixed Asset")
        .setFixedAssetTypeId("OTHER_FIXED_ASSET")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_PROPERTY = FixedAssetTypeData.newBuilder()
        .setDescription("Property")
        .setFixedAssetTypeId("PROPERTY")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_VEHICLE = FixedAssetTypeData.newBuilder()
        .setDescription("Vehicle")
        .setFixedAssetTypeId("VEHICLE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_REAL_ESTATE = FixedAssetTypeData.newBuilder()
        .setDescription("Real Estate")
        .setFixedAssetTypeId("REAL_ESTATE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_COMPUTER_SOFTWARE = FixedAssetTypeData.newBuilder()
        .setDescription("Computer Software")
        .setFixedAssetTypeId("COMPUTER_SOFTWARE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FixedAssetTypeData FixedAssetType_COMPUTER_HARDWARE = FixedAssetTypeData.newBuilder()
        .setDescription("Computer Hardware")
        .setFixedAssetTypeId("COMPUTER_HARDWARE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_SAGEPAY = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway SagePay")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_SAGEPAY")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_AUTH_NET = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway Authorize Dot Net")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_AUTH_NET")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_CYBERSRC = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway CyberSource")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_CYBERSRC")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_EWAY = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway eWay")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_EWAY")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_PAYFLOWPRO = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway Payflow Pro")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_PAYFLOWPRO")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_PAYPAL = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway PayPal")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_PAYPAL")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_CLRCOMRC = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway Clear Commerce")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_CLRCOMRC")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_WORLDPAY = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway RBS WorldPay")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_WORLDPAY")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_ORBITAL = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway Orbital")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_ORBITAL")
        .build();


    public final static PaymentGatewayConfigTypeData PaymentGatewayConfigType_PAY_GATWY_SECUREPAY = PaymentGatewayConfigTypeData.newBuilder()
        .setDescription("Payment Gateway SecurePay")
        .setHasTable(castIndicator("Y"))
        .setPaymentGatewayConfigTypeId("PAY_GATWY_SECUREPAY")
        .build();


    public final static SettlementTermData SettlementTerm_COD = SettlementTermData.newBuilder()
        .setSettlementTermId("COD")
        .setTermName("Cash Due on Delivery")
        .setTermValue(0)
        .setUomId("TF_day")
        .build();


    public final static SettlementTermData SettlementTerm_NET_15 = SettlementTermData.newBuilder()
        .setSettlementTermId("NET_15")
        .setTermName("Net Due in 15 Days")
        .setTermValue(15)
        .setUomId("TF_day")
        .build();


    public final static SettlementTermData SettlementTerm_NET_30 = SettlementTermData.newBuilder()
        .setSettlementTermId("NET_30")
        .setTermName("Net Due in 30 Days")
        .setTermValue(30)
        .setUomId("TF_day")
        .build();


    public final static SettlementTermData SettlementTerm_NET_60 = SettlementTermData.newBuilder()
        .setSettlementTermId("NET_60")
        .setTermName("Net Due in 60 Days")
        .setTermValue(60)
        .setUomId("TF_day")
        .build();


    public final static SettlementTermData SettlementTerm_NET_90 = SettlementTermData.newBuilder()
        .setSettlementTermId("NET_90")
        .setTermName("Net Due in 90 Days")
        .setTermValue(90)
        .setUomId("TF_day")
        .build();

}
