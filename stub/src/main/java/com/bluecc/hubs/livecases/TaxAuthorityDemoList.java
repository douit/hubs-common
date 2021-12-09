package com.bluecc.hubs.livecases;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.livecases.TaxAuthorityDemo.*;

import com.bluecc.hubs.stub.PartyRoleData;
import com.bluecc.hubs.stub.PartyTaxAuthInfoData;
import com.bluecc.hubs.stub.TaxAuthorityCategoryData;
import com.bluecc.hubs.stub.TaxAuthorityAssocData;
import com.bluecc.hubs.stub.PartyGroupFlatData;
import com.bluecc.hubs.stub.ContactMechData;
import com.bluecc.hubs.stub.PostalAddressData;
import com.bluecc.hubs.stub.PartyFlatData;
import com.bluecc.hubs.stub.PartyContactMechPurposeData;
import com.bluecc.hubs.stub.TaxAuthorityGlAccountData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.TaxAuthorityRateProductData;
import com.bluecc.hubs.stub.TaxAuthorityData;
import com.bluecc.hubs.stub.PartyContactMechData;

public final class TaxAuthorityDemoList {
    public static List<PartyRoleData> partyRoleList() {
        return ImmutableList.of(        
            PartyRole_USA_IRS_TAX_AUTHORITY(),        
            PartyRole_CA_BOE_TAX_AUTHORITY(),        
            PartyRole_NY_DTF_TAX_AUTHORITY(),        
            PartyRole_TX_TAXMAN_TAX_AUTHORITY(),        
            PartyRole_UT_TAXMAN_TAX_AUTHORITY(),        
            PartyRole_UT_UTAH_TAXMAN_TAX_AUTHORITY(),        
            PartyRole_CAN_TAXMAN_TAX_AUTHORITY(),        
            PartyRole_ON_TAXMAN_TAX_AUTHORITY(),        
            PartyRole_CHN_STA_TAX_AUTHORITY(),        
            PartyRole_AUT_BMF_TAX_AUTHORITY(),        
            PartyRole_BEL_FOD_TAX_AUTHORITY(),        
            PartyRole_BGR_TA_TAX_AUTHORITY(),        
            PartyRole_DEU_BZSt_TAX_AUTHORITY(),        
            PartyRole_DNK_SKAT_TAX_AUTHORITY(),        
            PartyRole_CYP_ΤΕΠ_TAX_AUTHORITY(),        
            PartyRole_CZE_CDS_TAX_AUTHORITY(),        
            PartyRole_ESP_AT_TAX_AUTHORITY(),        
            PartyRole_EST_EMTA_TAX_AUTHORITY(),        
            PartyRole_FIN_VERO_TAX_AUTHORITY(),        
            PartyRole_FRA_TA_TAX_AUTHORITY(),        
            PartyRole_GBR_TA_TAX_AUTHORITY(),        
            PartyRole_GRC_TA_TAX_AUTHORITY(),        
            PartyRole_HRV_TA_TAX_AUTHORITY(),        
            PartyRole_HUN_TA_TAX_AUTHORITY(),        
            PartyRole_IRL_ITC_TAX_AUTHORITY(),        
            PartyRole_ITA_ADE_TAX_AUTHORITY(),        
            PartyRole_LVA_TA_TAX_AUTHORITY(),        
            PartyRole_LTU_TA_TAX_AUTHORITY(),        
            PartyRole_LUX_ACD_TAX_AUTHORITY(),        
            PartyRole_MLT_TA_TAX_AUTHORITY(),        
            PartyRole_NLD_NBD_TAX_AUTHORITY(),        
            PartyRole_POL_TA_TAX_AUTHORITY(),        
            PartyRole_PRT_AT_TAX_AUTHORITY(),        
            PartyRole_ROM_TA_TAX_AUTHORITY(),        
            PartyRole_SVK_TA_TAX_AUTHORITY(),        
            PartyRole_SVN_TA_TAX_AUTHORITY(),        
            PartyRole_SWE_SV_TAX_AUTHORITY());
    }

    public static List<PartyTaxAuthInfoData> partyTaxAuthInfoList() {
        return ImmutableList.of(        
            PartyTaxAuthInfo_Company__NA___NA__(),        
            PartyTaxAuthInfo_Company_USA_USA_IRS_(),        
            PartyTaxAuthInfo_Company_CA_CA_BOE_(),        
            PartyTaxAuthInfo_Company_NY_NY_DTF_(),        
            PartyTaxAuthInfo_Company_TX_TX_TAXMAN_(),        
            PartyTaxAuthInfo_Company_UT_UT_TAXMAN_(),        
            PartyTaxAuthInfo_Company_UT_UTAH_UT_UTAH_TAXMAN_(),        
            PartyTaxAuthInfo_Company_CAN_CAN_TAXMAN_(),        
            PartyTaxAuthInfo_Company_ON_ON_TAXMAN_());
    }

    public static List<TaxAuthorityCategoryData> taxAuthorityCategoryList() {
        return ImmutableList.of(        
            TaxAuthorityCategory__NA___NA__20111());
    }

    public static List<TaxAuthorityAssocData> taxAuthorityAssocList() {
        return ImmutableList.of(        
            TaxAuthorityAssoc_USA_USA_IRS_CA_CA_BOE_(),        
            TaxAuthorityAssoc_USA_USA_IRS_NY_NY_DTF_(),        
            TaxAuthorityAssoc_USA_USA_IRS_TX_TX_TAXMAN_(),        
            TaxAuthorityAssoc_USA_USA_IRS_UT_UT_TAXMAN_(),        
            TaxAuthorityAssoc_UT_UT_TAXMAN_UT_UTAH_UT_UTAH_TAXMAN_());
    }

    public static List<PartyGroupFlatData> partyGroupList() {
        return ImmutableList.of(        
            PartyGroup_USA_IRS(),        
            PartyGroup_CA_BOE(),        
            PartyGroup_NY_DTF(),        
            PartyGroup_TX_TAXMAN(),        
            PartyGroup_UT_TAXMAN(),        
            PartyGroup_UT_UTAH_TAXMAN(),        
            PartyGroup_CAN_TAXMAN(),        
            PartyGroup_ON_TAXMAN(),        
            PartyGroup_CHN_STA(),        
            PartyGroup_AUT_BMF(),        
            PartyGroup_BEL_FOD(),        
            PartyGroup_BGR_TA(),        
            PartyGroup_DEU_BZSt(),        
            PartyGroup_DNK_SKAT(),        
            PartyGroup_CYP_ΤΕΠ(),        
            PartyGroup_CZE_CDS(),        
            PartyGroup_ESP_AT(),        
            PartyGroup_EST_EMTA(),        
            PartyGroup_FIN_VERO(),        
            PartyGroup_FRA_TA(),        
            PartyGroup_GBR_TA(),        
            PartyGroup_GRC_TA(),        
            PartyGroup_HRV_TA(),        
            PartyGroup_HUN_TA(),        
            PartyGroup_IRL_ITC(),        
            PartyGroup_ITA_ADE(),        
            PartyGroup_LVA_TA(),        
            PartyGroup_LTU_TA(),        
            PartyGroup_LUX_ACD(),        
            PartyGroup_MLT_TA(),        
            PartyGroup_NLD_NBD(),        
            PartyGroup_POL_TA(),        
            PartyGroup_PRT_AT(),        
            PartyGroup_ROM_TA(),        
            PartyGroup_SVK_TA(),        
            PartyGroup_SVN_TA(),        
            PartyGroup_SWE_SV());
    }

    public static List<ContactMechData> contactMechList() {
        return ImmutableList.of(        
            ContactMech_CA_BOE_0(),        
            ContactMech_NY_DTF_0());
    }

    public static List<PostalAddressData> postalAddressList() {
        return ImmutableList.of(        
            PostalAddress_CA_BOE_0(),        
            PostalAddress_NY_DTF_0());
    }

    public static List<PartyFlatData> partyList() {
        return ImmutableList.of(        
            Party_USA_IRS(),        
            Party_CA_BOE(),        
            Party_NY_DTF(),        
            Party_TX_TAXMAN(),        
            Party_UT_TAXMAN(),        
            Party_UT_UTAH_TAXMAN(),        
            Party_CAN_TAXMAN(),        
            Party_ON_TAXMAN(),        
            Party_CHN_STA(),        
            Party_AUT_BMF(),        
            Party_BEL_FOD(),        
            Party_BGR_TA(),        
            Party_DEU_BZSt(),        
            Party_DNK_SKAT(),        
            Party_CYP_ΤΕΠ(),        
            Party_CZE_CDS(),        
            Party_ESP_AT(),        
            Party_EST_EMTA(),        
            Party_FIN_VERO(),        
            Party_FRA_TA(),        
            Party_GBR_TA(),        
            Party_GRC_TA(),        
            Party_HRV_TA(),        
            Party_HUN_TA(),        
            Party_IRL_ITC(),        
            Party_ITA_ADE(),        
            Party_LVA_TA(),        
            Party_LTU_TA(),        
            Party_LUX_ACD(),        
            Party_MLT_TA(),        
            Party_NLD_NBD(),        
            Party_POL_TA(),        
            Party_PRT_AT(),        
            Party_ROM_TA(),        
            Party_SVK_TA(),        
            Party_SVN_TA(),        
            Party_SWE_SV());
    }

    public static List<PartyContactMechPurposeData> partyContactMechPurposeList() {
        return ImmutableList.of(        
            PartyContactMechPurpose_CA_BOE_CA_BOE_0_PAYMENT_LOCATION_(),        
            PartyContactMechPurpose_CA_BOE_CA_BOE_0_BILLING_LOCATION_(),        
            PartyContactMechPurpose_NY_DTF_NY_DTF_0_PAYMENT_LOCATION_(),        
            PartyContactMechPurpose_NY_DTF_NY_DTF_0_BILLING_LOCATION_());
    }

    public static List<TaxAuthorityGlAccountData> taxAuthorityGlAccountList() {
        return ImmutableList.of(        
            TaxAuthorityGlAccount__NA___NA__Company(),        
            TaxAuthorityGlAccount_USA_USA_IRS_Company(),        
            TaxAuthorityGlAccount_CA_CA_BOE_Company(),        
            TaxAuthorityGlAccount_NY_NY_DTF_Company(),        
            TaxAuthorityGlAccount_TX_TX_TAXMAN_Company(),        
            TaxAuthorityGlAccount_UT_UT_TAXMAN_Company(),        
            TaxAuthorityGlAccount_UT_UTAH_UT_UTAH_TAXMAN_Company(),        
            TaxAuthorityGlAccount_CAN_CAN_TAXMAN_Company(),        
            TaxAuthorityGlAccount_ON_ON_TAXMAN_Company(),        
            TaxAuthorityGlAccount_CHN_CHN_STA_Company());
    }

    public static List<ProductCategoryFlatData> productCategoryList() {
        return ImmutableList.of(        
            ProductCategory_20111());
    }

    public static List<TaxAuthorityRateProductData> taxAuthorityRateProductList() {
        return ImmutableList.of(        
            TaxAuthorityRateProduct_9000(),        
            TaxAuthorityRateProduct_9001(),        
            TaxAuthorityRateProduct_9002(),        
            TaxAuthorityRateProduct_9003(),        
            TaxAuthorityRateProduct_9004(),        
            TaxAuthorityRateProduct_9005());
    }

    public static List<TaxAuthorityData> taxAuthorityList() {
        return ImmutableList.of(        
            TaxAuthority__NA___NA_(),        
            TaxAuthority_USA_USA_IRS(),        
            TaxAuthority_CA_CA_BOE(),        
            TaxAuthority_NY_NY_DTF(),        
            TaxAuthority_TX_TX_TAXMAN(),        
            TaxAuthority_UT_UT_TAXMAN(),        
            TaxAuthority_UT_UTAH_UT_UTAH_TAXMAN(),        
            TaxAuthority_CAN_CAN_TAXMAN(),        
            TaxAuthority_ON_ON_TAXMAN(),        
            TaxAuthority_CHN_CHN_STA(),        
            TaxAuthority_AUT_AUT_BMF(),        
            TaxAuthority_BEL_BEL_FOD(),        
            TaxAuthority_BGR_BGR_TA(),        
            TaxAuthority_DEU_DEU_BZSt(),        
            TaxAuthority_DNK_DNK_SKAT(),        
            TaxAuthority_CYP_CYP_ΤΕΠ(),        
            TaxAuthority_CZE_CZE_CDS(),        
            TaxAuthority_ESP_ESP_AT(),        
            TaxAuthority_EST_EST_EMTA(),        
            TaxAuthority_FIN_FIN_VERO(),        
            TaxAuthority_FRA_FRA_TA(),        
            TaxAuthority_GBR_GBR_TA(),        
            TaxAuthority_GRC_GRC_TA(),        
            TaxAuthority_HRV_HRV_TA(),        
            TaxAuthority_HUN_HUN_TA(),        
            TaxAuthority_IRL_IRL_ITC(),        
            TaxAuthority_ITA_ITA_ADE(),        
            TaxAuthority_LVA_LVA_TA(),        
            TaxAuthority_LTU_LTU_TA(),        
            TaxAuthority_LUX_LUX_ACD(),        
            TaxAuthority_MLT_MLT_TA(),        
            TaxAuthority_NLD_NLD_NBD(),        
            TaxAuthority_POL_POL_TA(),        
            TaxAuthority_PRT_PRT_AT(),        
            TaxAuthority_ROU_ROM_TA(),        
            TaxAuthority_SVK_SVK_TA(),        
            TaxAuthority_SVN_SVN_TA(),        
            TaxAuthority_SWE_SWE_SV());
    }

    public static List<PartyContactMechData> partyContactMechList() {
        return ImmutableList.of(        
            PartyContactMech_CA_BOE_CA_BOE_0_(),        
            PartyContactMech_NY_DTF_NY_DTF_0_());
    }

}
