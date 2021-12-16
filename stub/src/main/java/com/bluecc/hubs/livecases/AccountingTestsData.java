package com.bluecc.hubs.livecases;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.InventoryItemFlatData;
import com.bluecc.hubs.stub.InvoiceFlatData;
import com.bluecc.hubs.stub.InvoiceItemFlatData;
import com.bluecc.hubs.stub.FinAccountTransData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.FixedAssetFlatData;
import com.bluecc.hubs.stub.BudgetStatusData;
import com.bluecc.hubs.stub.FixedAssetStdCostData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.FixedAssetRegistrationData;
import com.bluecc.hubs.stub.GlAccountTypeDefaultData;
import com.bluecc.hubs.stub.InvoiceItemTypeGlAccountData;
import com.bluecc.hubs.stub.FinAccountRoleData;
import com.bluecc.hubs.stub.BudgetData;
import com.bluecc.hubs.stub.PaymentContentTypeData;
import com.bluecc.hubs.stub.PaymentGlAccountTypeMapData;
import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.FixedAssetMeterData;
import com.bluecc.hubs.stub.AgreementItemData;
import com.bluecc.hubs.stub.AcctgTransData;
import com.bluecc.hubs.stub.InventoryItemDetailData;
import com.bluecc.hubs.stub.GlAccountData;
import com.bluecc.hubs.stub.AgreementProductApplData;
import com.bluecc.hubs.stub.AgreementData;
import com.bluecc.hubs.stub.FinAccountFlatData;
import com.bluecc.hubs.stub.PartyAcctgPreferenceData;
import com.bluecc.hubs.stub.AgreementTermData;
import com.bluecc.hubs.stub.PaymentFlatData;
import com.bluecc.hubs.stub.PaymentMethodTypeGlAccountData;
import com.bluecc.hubs.stub.ContentData;
import com.bluecc.hubs.stub.PaymentMethodData;
import com.bluecc.hubs.stub.UomConversionDatedData;
import com.bluecc.hubs.stub.FacilityData;

public final class AccountingTestsData {
    public static InventoryItemFlatData InventoryItem_TEST_9000() {
        return InventoryItemFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setFacilityId("WebStoreWarehouse")
            .setInventoryItemId("TEST_9000")
            .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
            .setLocationSeqId("TLTLTLLL01")
            .setOwnerPartyId("Company")
            .setProductId("MAT_A_COST")
            .setUnitCost(getFixedPoint("9"))
            .build();
    }


    public static InventoryItemFlatData InventoryItem_TEST_9001() {
        return InventoryItemFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setFacilityId("WebStoreWarehouse")
            .setInventoryItemId("TEST_9001")
            .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
            .setLocationSeqId("TLTLTLLL01")
            .setOwnerPartyId("Company")
            .setProductId("MAT_B_COST")
            .setUnitCost(getFixedPoint("7"))
            .build();
    }


    public static InventoryItemFlatData InventoryItem_9999() {
        return InventoryItemFlatData.newBuilder()
            .setCurrencyUomId("USD")
            .setFacilityId("DemoFacility1")
            .setInventoryItemId("9999")
            .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
            .setOwnerPartyId("DEMO_COMPANY2")
            .setProductId("TestProduct3")
            .setUnitCost(getFixedPoint("9"))
            .build();
    }


    public static InvoiceFlatData Invoice_1000() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1000")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .build();
    }


    public static InvoiceFlatData Invoice_1001() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1001")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .build();
    }


    public static InvoiceFlatData Invoice_1002() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1002")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_1003() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1003")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_1004() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1004")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .build();
    }


    public static InvoiceFlatData Invoice_1005() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1005")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_1006() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1006")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_1007() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1007")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_1008() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1008")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceFlatData Invoice_1009() {
        return InvoiceFlatData.newBuilder()
            .setInvoiceDate(getTimestamp("2016-11-03 00:00:00"))
            .setInvoiceId("1009")
            .setInvoiceTypeId("PURCHASE_INVOICE")
            .setPartyId("DEMO_COMPANY1")
            .setPartyIdFrom("DEMO_COMPANY")
            .setStatusId("INVOICE_IN_PROCESS")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_1001_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setInvoiceId("1001")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("PINV_FXASTPRD_ITEM")
            .build();
    }


    public static InvoiceItemFlatData InvoiceItem_1006_00001() {
        return InvoiceItemFlatData.newBuilder()
            .setInvoiceId("1006")
            .setInvoiceItemSeqId("00001")
            .setInvoiceItemTypeId("PINV_FXASTPRD_ITEM")
            .build();
    }


    public static FinAccountTransData FinAccountTrans_1010() {
        return FinAccountTransData.newBuilder()
            .setFinAccountId("1005")
            .setFinAccountTransId("1010")
            .setFinAccountTransTypeId("ADJUSTMENT")
            .setStatusId("FINACT_TRNS_CREATED")
            .build();
    }


    public static ProductFlatData Product_TestProduct2() {
        return ProductFlatData.newBuilder()
            .setDescription("Test Product For Testing getCommissionForProduct services")
            .setInternalName("Test Product 2")
            .setProductId("TestProduct2")
            .setProductName("Test Product 2")
            .build();
    }


    public static ProductFlatData Product_TestProduct3() {
        return ProductFlatData.newBuilder()
            .setDescription("Test Product For Testing updateProductAverageCostOnReceiveInventory services")
            .setInternalName("Test Product 3")
            .setProductId("TestProduct3")
            .setProductName("Test Product 3")
            .build();
    }


    public static FixedAssetFlatData FixedAsset_1000() {
        return FixedAssetFlatData.newBuilder()
            .setFixedAssetId("1000")
            .setFixedAssetTypeId("REAL_ESTATE")
            .setPartyId("DEMO_COMPANY")
            .setRoleTypeId("INTERNAL_ORGANIZATIO")
            .build();
    }


    public static BudgetStatusData BudgetStatus_9999_BG_CREATED() {
        return BudgetStatusData.newBuilder()
            .setBudgetId("9999")
            .setStatusDate(getTimestamp("2016-09-29 00:00:00"))
            .setStatusId("BG_CREATED")
            .build();
    }


    public static FixedAssetStdCostData FixedAssetStdCost_1000_SETUP_COST_() {
        return FixedAssetStdCostData.newBuilder()
            .setAmount(getCurrency("1000.00"))
            .setAmountUomId("USD")
            .setFixedAssetId("1000")
            .setFixedAssetStdCostTypeId("SETUP_COST")
            .setFromDate(getTimestamp("2016-11-03 00:00:00"))
            .build();
    }


    public static PartyFlatData Party_DEMO_COMPANY() {
        return PartyFlatData.newBuilder()
            .setPartyId("DEMO_COMPANY")
            .setPartyTypeId("PARTY_GROUP")
            .build();
    }


    public static PartyFlatData Party_DEMO_COMPANY1() {
        return PartyFlatData.newBuilder()
            .setPartyId("DEMO_COMPANY1")
            .setPartyTypeId("PARTY_GROUP")
            .build();
    }


    public static PartyFlatData Party_DEMO_COMPANY2() {
        return PartyFlatData.newBuilder()
            .setPartyId("DEMO_COMPANY2")
            .setPartyTypeId("PARTY_GROUP")
            .build();
    }


    public static FixedAssetRegistrationData FixedAssetRegistration_DEMO_VEHICLE_01_() {
        return FixedAssetRegistrationData.newBuilder()
            .setFixedAssetId("DEMO_VEHICLE_01")
            .setFromDate(getTimestamp("2020-04-01 00:00:00.0"))
            .setRegistrationDate(getTimestamp("2020-04-01 00:00:00.0"))
            .setRegistrationNumber("abcde")
            .build();
    }


    public static GlAccountTypeDefaultData GlAccountTypeDefault_ACCOUNTS_PAYABLE_DEMO_COMPANY1() {
        return GlAccountTypeDefaultData.newBuilder()
            .setGlAccountId("999999")
            .setGlAccountTypeId("ACCOUNTS_PAYABLE")
            .setOrganizationPartyId("DEMO_COMPANY1")
            .build();
    }


    public static InvoiceItemTypeGlAccountData InvoiceItemTypeGlAccount_PINV_SALES_TAX_DEMO_COMPANY1() {
        return InvoiceItemTypeGlAccountData.newBuilder()
            .setGlAccountId("999999")
            .setInvoiceItemTypeId("PINV_SALES_TAX")
            .setOrganizationPartyId("DEMO_COMPANY1")
            .build();
    }


    public static FinAccountRoleData FinAccountRole_1004_DEMO_COMPANY_SUPPLIER_() {
        return FinAccountRoleData.newBuilder()
            .setFinAccountId("1004")
            .setFromDate(getTimestamp("2016-11-03 00:00:00"))
            .setPartyId("DEMO_COMPANY")
            .setRoleTypeId("SUPPLIER")
            .build();
    }


    public static BudgetData Budget_9999() {
        return BudgetData.newBuilder()
            .setBudgetId("9999")
            .setBudgetTypeId("CAPITAL_BUDGET")
            .setComments("This is the capital budget")
            .build();
    }


    public static PaymentContentTypeData PaymentContentType_COMMENTS() {
        return PaymentContentTypeData.newBuilder()
            .setHasTable(castIndicator("N"))
            .setPaymentContentTypeId("COMMENTS")
            .build();
    }


    public static PaymentGlAccountTypeMapData PaymentGlAccountTypeMap_COMMISSION_PAYMENT_DEMO_COMPANY1() {
        return PaymentGlAccountTypeMapData.newBuilder()
            .setGlAccountTypeId("COMMISSIONS_PAYABLE")
            .setOrganizationPartyId("DEMO_COMPANY1")
            .setPaymentTypeId("COMMISSION_PAYMENT")
            .build();
    }


    public static PartyRoleData PartyRole_DEMO_COMPANY_INTERNAL_ORGANIZATIO() {
        return PartyRoleData.newBuilder()
            .setPartyId("DEMO_COMPANY")
            .setRoleTypeId("INTERNAL_ORGANIZATIO")
            .build();
    }


    public static PartyRoleData PartyRole_DEMO_COMPANY1_INTERNAL_ORGANIZATIO() {
        return PartyRoleData.newBuilder()
            .setPartyId("DEMO_COMPANY1")
            .setRoleTypeId("INTERNAL_ORGANIZATIO")
            .build();
    }


    public static PartyRoleData PartyRole_DEMO_COMPANY_SUPPLIER() {
        return PartyRoleData.newBuilder()
            .setPartyId("DEMO_COMPANY")
            .setRoleTypeId("SUPPLIER")
            .build();
    }


    public static PartyRoleData PartyRole_DEMO_COMPANY1_DISTRIBUTOR() {
        return PartyRoleData.newBuilder()
            .setPartyId("DEMO_COMPANY1")
            .setRoleTypeId("DISTRIBUTOR")
            .build();
    }


    public static PartyRoleData PartyRole_DEMO_COMPANY2_INTERNAL_ORGANIZATIO() {
        return PartyRoleData.newBuilder()
            .setPartyId("DEMO_COMPANY2")
            .setRoleTypeId("INTERNAL_ORGANIZATIO")
            .build();
    }


    public static FixedAssetMeterData FixedAssetMeter_DEMO_VEHICLE_01_ODOMETER_() {
        return FixedAssetMeterData.newBuilder()
            .setFixedAssetId("DEMO_VEHICLE_01")
            .setMeterValue(getFixedPoint("10.000000"))
            .setProductMeterTypeId("ODOMETER")
            .setReadingDate(getTimestamp("2020-04-01 00:00:00.0"))
            .build();
    }


    public static AgreementItemData AgreementItem_1010_0001() {
        return AgreementItemData.newBuilder()
            .setAgreementId("1010")
            .setAgreementItemSeqId("0001")
            .setAgreementItemTypeId("AGREEMENT_COMMISSION")
            .setAgreementText("Commission in USD")
            .setCurrencyUomId("USD")
            .build();
    }


    public static AcctgTransData AcctgTrans_1000() {
        return AcctgTransData.newBuilder()
            .setAcctgTransId("1000")
            .setAcctgTransTypeId("CREDIT_MEMO")
            .setPostedDate(getTimestamp("2016-11-03 00:00:00"))
            .build();
    }


    public static InventoryItemDetailData InventoryItemDetail_TEST_9000_0001() {
        return InventoryItemDetailData.newBuilder()
            .setAvailableToPromiseDiff(getFixedPoint("4"))
            .setEffectiveDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setInventoryItemDetailSeqId("0001")
            .setInventoryItemId("TEST_9000")
            .setQuantityOnHandDiff(getFixedPoint("4"))
            .build();
    }


    public static InventoryItemDetailData InventoryItemDetail_TEST_9001_0001() {
        return InventoryItemDetailData.newBuilder()
            .setAvailableToPromiseDiff(getFixedPoint("6"))
            .setEffectiveDate(getTimestamp("2001-05-13 12:00:00.0"))
            .setInventoryItemDetailSeqId("0001")
            .setInventoryItemId("TEST_9001")
            .setQuantityOnHandDiff(getFixedPoint("6"))
            .build();
    }


    public static GlAccountData GlAccount_999999() {
        return GlAccountData.newBuilder()
            .setGlAccountId("999999")
            .build();
    }


    public static AgreementProductApplData AgreementProductAppl_1010_0001_TestProduct2() {
        return AgreementProductApplData.newBuilder()
            .setAgreementId("1010")
            .setAgreementItemSeqId("0001")
            .setProductId("TestProduct2")
            .build();
    }


    public static AgreementData Agreement_1000() {
        return AgreementData.newBuilder()
            .setAgreementId("1000")
            .setAgreementTypeId("COMMISSION_AGREEMENT")
            .setDescription("Commission Agreement")
            .setFromDate(getTimestamp("2016-09-29 00:00:00"))
            .setPartyIdFrom("DEMO_COMPANY")
            .setPartyIdTo("DEMO_COMPANY1")
            .setRoleTypeIdFrom("SUPPLIER")
            .setRoleTypeIdTo("DISTRIBUTOR")
            .build();
    }


    public static AgreementData Agreement_1010() {
        return AgreementData.newBuilder()
            .setAgreementId("1010")
            .setAgreementTypeId("COMMISSION_AGREEMENT")
            .setDescription("Commission Agreement")
            .setFromDate(getTimestamp("2016-09-29 00:00:00"))
            .setPartyIdFrom("DEMO_COMPANY")
            .setPartyIdTo("DEMO_COMPANY1")
            .setRoleTypeIdFrom("SUPPLIER")
            .setRoleTypeIdTo("DISTRIBUTOR")
            .build();
    }


    public static FinAccountFlatData FinAccount_1001() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("2000.00"))
            .setAvailableBalance(getCurrency("1500.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("1001")
            .setFinAccountId("1001")
            .setFinAccountName("Deposit Account")
            .setFinAccountTypeId("DEPOSIT_ACCOUNT")
            .setFromDate(getTimestamp("2016-11-03 00:00:00"))
            .setOrganizationPartyId("DEMO_COMPANY")
            .build();
    }


    public static FinAccountFlatData FinAccount_1002() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("2000.00"))
            .setAvailableBalance(getCurrency("1500.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("1002")
            .setFinAccountId("1002")
            .setFinAccountName("Credit Cart Account")
            .setFinAccountTypeId("CREDIT_CARD_ACCOUNT")
            .setFromDate(getTimestamp("2016-11-03 00:00:00"))
            .setOrganizationPartyId("DEMO_COMPANY")
            .build();
    }


    public static FinAccountFlatData FinAccount_1003() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("2000.00"))
            .setAvailableBalance(getCurrency("1500.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("1001")
            .setFinAccountId("1003")
            .setFinAccountName("Deposit Account")
            .setFinAccountTypeId("DEPOSIT_ACCOUNT")
            .setFromDate(getTimestamp("2016-11-03 00:00:00"))
            .setOrganizationPartyId("DEMO_COMPANY")
            .build();
    }


    public static FinAccountFlatData FinAccount_1004() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("2000.00"))
            .setAvailableBalance(getCurrency("1500.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("1001")
            .setFinAccountId("1004")
            .setFinAccountName("Deposit Account")
            .setFinAccountTypeId("DEPOSIT_ACCOUNT")
            .setFromDate(getTimestamp("2016-11-03 00:00:00"))
            .setOrganizationPartyId("DEMO_COMPANY")
            .build();
    }


    public static FinAccountFlatData FinAccount_1005() {
        return FinAccountFlatData.newBuilder()
            .setActualBalance(getCurrency("2000.00"))
            .setAvailableBalance(getCurrency("1500.00"))
            .setCurrencyUomId("USD")
            .setFinAccountCode("1001")
            .setFinAccountId("1005")
            .setFinAccountName("Deposit Account")
            .setFinAccountTypeId("DEPOSIT_ACCOUNT")
            .setFromDate(getTimestamp("2016-11-03 00:00:00"))
            .setOrganizationPartyId("DEMO_COMPANY")
            .build();
    }


    public static PartyAcctgPreferenceData PartyAcctgPreference_DEMO_COMPANY1() {
        return PartyAcctgPreferenceData.newBuilder()
            .setPartyId("DEMO_COMPANY1")
            .build();
    }


    public static PartyAcctgPreferenceData PartyAcctgPreference_DEMO_COMPANY2() {
        return PartyAcctgPreferenceData.newBuilder()
            .setCogsMethodId("COGS_LIFO")
            .setPartyId("DEMO_COMPANY2")
            .build();
    }


    public static AgreementTermData AgreementTerm_1010() {
        return AgreementTermData.newBuilder()
            .setAgreementId("1010")
            .setAgreementItemSeqId("0001")
            .setAgreementTermId("1010")
            .setDescription("Agreement Term for Test Product 2 Commission")
            .setFromDate(getTimestamp("2016-09-29 00:00:00"))
            .setInvoiceItemTypeId("COMM_INV_ITEM")
            .setMaxQuantity(100)
            .setMinQuantity(1)
            .setTermDays(30)
            .setTermTypeId("FIN_COMM_VARIABLE")
            .setTermValue(getCurrency("10"))
            .setThruDate(getTimestamp("2017-09-29 00:00:00"))
            .build();
    }


    public static PaymentFlatData Payment_1000() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("100.00"))
            .setPartyIdFrom("DEMO_COMPANY")
            .setPartyIdTo("DEMO_COMPANY1")
            .setPaymentId("1000")
            .setPaymentMethodTypeId("COMPANY_CHECK")
            .setPaymentTypeId("CUSTOMER_PAYMENT")
            .setStatusId("PAYMENT_NOT_AUTH")
            .build();
    }


    public static PaymentFlatData Payment_1001() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("100.00"))
            .setPartyIdFrom("DEMO_COMPANY")
            .setPartyIdTo("DEMO_COMPANY1")
            .setPaymentId("1001")
            .setPaymentMethodId("1001")
            .setPaymentMethodTypeId("COMPANY_CHECK")
            .setPaymentTypeId("CUSTOMER_PAYMENT")
            .setStatusId("PMNT_CONFIRMED")
            .build();
    }


    public static PaymentFlatData Payment_1006() {
        return PaymentFlatData.newBuilder()
            .setAmount(getCurrency("100.00"))
            .setPartyIdFrom("DEMO_COMPANY")
            .setPartyIdTo("DEMO_COMPANY1")
            .setPaymentId("1006")
            .setPaymentMethodTypeId("COMPANY_CHECK")
            .setPaymentTypeId("CUSTOMER_PAYMENT")
            .setStatusId("PMNT_CONFIRMED")
            .build();
    }


    public static PaymentMethodTypeGlAccountData PaymentMethodTypeGlAccount_CASH_DEMO_COMPANY1() {
        return PaymentMethodTypeGlAccountData.newBuilder()
            .setGlAccountId("999999")
            .setOrganizationPartyId("DEMO_COMPANY1")
            .setPaymentMethodTypeId("CASH")
            .build();
    }


    public static ContentData Content_1000() {
        return ContentData.newBuilder()
            .setContentId("1000")
            .setContentTypeId("DOCUMENT")
            .build();
    }


    public static ContentData Content_1006() {
        return ContentData.newBuilder()
            .setContentId("1006")
            .setContentTypeId("DOCUMENT")
            .build();
    }


    public static PaymentMethodData PaymentMethod_9020() {
        return PaymentMethodData.newBuilder()
            .setFromDate(getTimestamp("2001-05-13 00:00:00.0"))
            .setPartyId("DEMO_COMPANY")
            .setPaymentMethodId("9020")
            .setPaymentMethodTypeId("CREDIT_CARD")
            .build();
    }


    public static PaymentMethodData PaymentMethod_1001() {
        return PaymentMethodData.newBuilder()
            .setPaymentMethodId("1001")
            .setPaymentMethodTypeId("COMPANY_CHECK")
            .build();
    }


    public static UomConversionDatedData UomConversionDated_EUR_USD_() {
        return UomConversionDatedData.newBuilder()
            .setConversionFactor(1.5)
            .setFromDate(getTimestamp("2001-01-01 00:00:00.0"))
            .setUomId("EUR")
            .setUomIdTo("USD")
            .build();
    }


    public static FacilityData Facility_DemoFacility1() {
        return FacilityData.newBuilder()
            .setFacilityId("DemoFacility1")
            .setFacilityName("Demo Facility")
            .setFacilityTypeId("WAREHOUSE")
            .build();
    }

}
