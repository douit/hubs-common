package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.AccountingTestsData.*;

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

public final class AccountingTestsDataList {
    public static List<InventoryItemFlatData> inventoryItemList() {
        return ImmutableList.of(        
            InventoryItem_TEST_9000(),        
            InventoryItem_TEST_9001(),        
            InventoryItem_9999());
    }

    public static List<InvoiceFlatData> invoiceList() {
        return ImmutableList.of(        
            Invoice_1000(),        
            Invoice_1001(),        
            Invoice_1002(),        
            Invoice_1003(),        
            Invoice_1004(),        
            Invoice_1005(),        
            Invoice_1006(),        
            Invoice_1007(),        
            Invoice_1008(),        
            Invoice_1009());
    }

    public static List<InvoiceItemFlatData> invoiceItemList() {
        return ImmutableList.of(        
            InvoiceItem_1001_00001(),        
            InvoiceItem_1006_00001());
    }

    public static List<FinAccountTransData> finAccountTransList() {
        return ImmutableList.of(        
            FinAccountTrans_1010());
    }

    public static List<ProductFlatData> productList() {
        return ImmutableList.of(        
            Product_TestProduct2(),        
            Product_TestProduct3());
    }

    public static List<FixedAssetFlatData> fixedAssetList() {
        return ImmutableList.of(        
            FixedAsset_1000());
    }

    public static List<BudgetStatusData> budgetStatusList() {
        return ImmutableList.of(        
            BudgetStatus_9999_BG_CREATED());
    }

    public static List<FixedAssetStdCostData> fixedAssetStdCostList() {
        return ImmutableList.of(        
            FixedAssetStdCost_1000_SETUP_COST_());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_DEMO_COMPANY(),        
            Party_DEMO_COMPANY1(),        
            Party_DEMO_COMPANY2());
    }

    public static List<FixedAssetRegistrationData> fixedAssetRegistrationList() {
        return ImmutableList.of(        
            FixedAssetRegistration_DEMO_VEHICLE_01_());
    }

    public static List<GlAccountTypeDefaultData> glAccountTypeDefaultList() {
        return ImmutableList.of(        
            GlAccountTypeDefault_ACCOUNTS_PAYABLE_DEMO_COMPANY1());
    }

    public static List<InvoiceItemTypeGlAccountData> invoiceItemTypeGlAccountList() {
        return ImmutableList.of(        
            InvoiceItemTypeGlAccount_PINV_SALES_TAX_DEMO_COMPANY1());
    }

    public static List<FinAccountRoleData> finAccountRoleList() {
        return ImmutableList.of(        
            FinAccountRole_1004_DEMO_COMPANY_SUPPLIER_());
    }

    public static List<BudgetData> budgetList() {
        return ImmutableList.of(        
            Budget_9999());
    }

    public static List<PaymentContentTypeData> paymentContentTypeList() {
        return ImmutableList.of(        
            PaymentContentType_COMMENTS());
    }

    public static List<PaymentGlAccountTypeMapData> paymentGlAccountTypeMapList() {
        return ImmutableList.of(        
            PaymentGlAccountTypeMap_COMMISSION_PAYMENT_DEMO_COMPANY1());
    }

    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_DEMO_COMPANY_INTERNAL_ORGANIZATIO(),        
            PartyRole_DEMO_COMPANY1_INTERNAL_ORGANIZATIO(),        
            PartyRole_DEMO_COMPANY_SUPPLIER(),        
            PartyRole_DEMO_COMPANY1_DISTRIBUTOR(),        
            PartyRole_DEMO_COMPANY2_INTERNAL_ORGANIZATIO());
    }

    public static List<FixedAssetMeterData> fixedAssetMeterList() {
        return ImmutableList.of(        
            FixedAssetMeter_DEMO_VEHICLE_01_ODOMETER_());
    }

    public static List<AgreementItemData> agreementItemList() {
        return ImmutableList.of(        
            AgreementItem_1010_0001());
    }

    public static List<AcctgTransData> acctgTransList() {
        return ImmutableList.of(        
            AcctgTrans_1000());
    }

    public static List<InventoryItemDetailData> inventoryItemDetailList() {
        return ImmutableList.of(        
            InventoryItemDetail_TEST_9000_0001(),        
            InventoryItemDetail_TEST_9001_0001());
    }

    public static List<GlAccountData> glAccountList() {
        return ImmutableList.of(        
            GlAccount_999999());
    }

    public static List<AgreementProductApplData> agreementProductApplList() {
        return ImmutableList.of(        
            AgreementProductAppl_1010_0001_TestProduct2());
    }

    public static List<AgreementData> agreementList() {
        return ImmutableList.of(        
            Agreement_1000(),        
            Agreement_1010());
    }

    public static List<FinAccountFlatData> finAccountList() {
        return ImmutableList.of(        
            FinAccount_1001(),        
            FinAccount_1002(),        
            FinAccount_1003(),        
            FinAccount_1004(),        
            FinAccount_1005());
    }

    public static List<PartyAcctgPreferenceData> partyAcctgPreferenceList() {
        return ImmutableList.of(        
            PartyAcctgPreference_DEMO_COMPANY1(),        
            PartyAcctgPreference_DEMO_COMPANY2());
    }

    public static List<AgreementTermData> agreementTermList() {
        return ImmutableList.of(        
            AgreementTerm_1010());
    }

    public static List<PaymentFlatData> paymentList() {
        return ImmutableList.of(        
            Payment_1000(),        
            Payment_1001(),        
            Payment_1006());
    }

    public static List<PaymentMethodTypeGlAccountData> paymentMethodTypeGlAccountList() {
        return ImmutableList.of(        
            PaymentMethodTypeGlAccount_CASH_DEMO_COMPANY1());
    }

    public static List<ContentData> contentList() {
        return ImmutableList.of(        
            Content_1000(),        
            Content_1006());
    }

    public static List<PaymentMethodData> paymentMethodList() {
        return ImmutableList.of(        
            PaymentMethod_9020(),        
            PaymentMethod_1001());
    }

    public static List<UomConversionDatedData> uomConversionDatedList() {
        return ImmutableList.of(        
            UomConversionDated_EUR_USD_());
    }

    public static List<FacilityData> facilityList() {
        return ImmutableList.of(        
            Facility_DemoFacility1());
    }

}
