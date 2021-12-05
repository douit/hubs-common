package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.StereoDemoRentalProduct.*;

import com.bluecc.hubs.stub.FixedAssetProductData;
import com.bluecc.hubs.stub.ProductStoreEmailSettingData;
import com.bluecc.hubs.stub.ProdCatalogFlatData;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.FixedAssetData;
import com.bluecc.hubs.stub.ProductCategoryRollupData;
import com.bluecc.hubs.stub.ProductCategoryMemberData;
import com.bluecc.hubs.stub.ProdCatalogCategoryData;
import com.bluecc.hubs.stub.ProductStoreFacilityData;
import com.bluecc.hubs.stub.WebSiteData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductStorePaymentSettingData;
import com.bluecc.hubs.stub.ProductStoreKeywordOvrdData;
import com.bluecc.hubs.stub.ProductStoreCatalogData;
import com.bluecc.hubs.stub.ProductStoreRoleData;

public final class StereoDemoRentalProductList {
    public static final List<FixedAssetProductData> fixedAssetProductList=ImmutableList.of(        
            FixedAssetProduct_RoomStd_RoomStd_FAPT_USE_,        
            FixedAssetProduct_RoomLux_RoomLux_FAPT_USE_);

    public static final List<ProductStoreEmailSettingData> productStoreEmailSettingList=ImmutableList.of(        
            ProductStoreEmailSetting_RentalStore_PRDS_ODR_CONFIRM,        
            ProductStoreEmailSetting_RentalStore_PRDS_ODR_COMPLETE,        
            ProductStoreEmailSetting_RentalStore_PRDS_ODR_BACKORDER,        
            ProductStoreEmailSetting_RentalStore_PRDS_ODR_CHANGE,        
            ProductStoreEmailSetting_RentalStore_PRDS_ODR_PAYRETRY,        
            ProductStoreEmailSetting_RentalStore_PRDS_RTN_ACCEPT,        
            ProductStoreEmailSetting_RentalStore_PRDS_RTN_COMPLETE,        
            ProductStoreEmailSetting_RentalStore_PRDS_RTN_CANCEL,        
            ProductStoreEmailSetting_RentalStore_PRDS_GC_PURCHASE,        
            ProductStoreEmailSetting_RentalStore_PRDS_GC_RELOAD,        
            ProductStoreEmailSetting_RentalStore_PRDS_TELL_FRIEND,        
            ProductStoreEmailSetting_RentalStore_PRDS_PWD_RETRIEVE);

    public static final List<ProdCatalogFlatData> prodCatalogList=ImmutableList.of(        
            ProdCatalog_RentalCatalog);

    public static final List<ProductStoreFlatData> productStoreList=ImmutableList.of(        
            ProductStore_RentalStore);

    public static final List<ProductFlatData> productList=ImmutableList.of(        
            Product_RoomStd,        
            Product_RoomLux,        
            Product_RoomLarge,        
            Product_BoatRowSimple,        
            Product_Cap);

    public static final List<ProductPriceData> productPriceList=ImmutableList.of(        
            ProductPrice_RoomStd_DEFAULT_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_RoomStd_LIST_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_RoomLux_DEFAULT_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_RoomLux_LIST_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_RoomLarge_AVERAGE_COST_PURCHASE_EUR__NA__,        
            ProductPrice_RoomLarge_DEFAULT_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_BoatRowSimple_DEFAULT_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_BoatRowSimple_LIST_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_BoatRowSimple_COMPETITIVE_PRICE_PURCHASE_EUR__NA__,        
            ProductPrice_Cap_DEFAULT_PRICE_PURCHASE_EUR__NA__);

    public static final List<FixedAssetData> fixedAssetList=ImmutableList.of(        
            FixedAsset_RoomStd,        
            FixedAsset_RoomLux);

    public static final List<ProductCategoryRollupData> productCategoryRollupList=ImmutableList.of(        
            ProductCategoryRollup_ConfRooms_HotelFac_,        
            ProductCategoryRollup_Rooms_HotelFac_,        
            ProductCategoryRollup_Suites_HotelFac_,        
            ProductCategoryRollup_SpeedBoats_BoatRental_,        
            ProductCategoryRollup_MotorBoats_BoatRental_,        
            ProductCategoryRollup_RowBoats_BoatRental_,        
            ProductCategoryRollup_SailBoats_BoatRental_);

    public static final List<ProductCategoryMemberData> productCategoryMemberList=ImmutableList.of(        
            ProductCategoryMember_RentalPromo_RoomLux_,        
            ProductCategoryMember_RentalPromo_RoomStd_,        
            ProductCategoryMember_RentalPromo_Cap_);

    public static final List<ProdCatalogCategoryData> prodCatalogCategoryList=ImmutableList.of(        
            ProdCatalogCategory_RentalCatalog_RentBrowseRoot_PCCT_BROWSE_ROOT_,        
            ProdCatalogCategory_RentalCatalog_RentBrowseRoot_SRCH_PCCT_SEARCH_,        
            ProdCatalogCategory_RentalCatalog_RentalPromo_PCCT_PROMOTIONS_);

    public static final List<ProductStoreFacilityData> productStoreFacilityList=ImmutableList.of(        
            ProductStoreFacility_RentalStore_WebStoreWarehouse_);

    public static final List<WebSiteData> webSiteList=ImmutableList.of(        
            WebSite_OpenTravelSystem);

    public static final List<ProductCategoryFlatData> productCategoryList=ImmutableList.of(        
            ProductCategory_RentBrowseRoot,        
            ProductCategory_RentBrowseRoot_SRCH,        
            ProductCategory_RentalPromo,        
            ProductCategory_HotelFac,        
            ProductCategory_Rooms,        
            ProductCategory_Suites,        
            ProductCategory_ConfRooms,        
            ProductCategory_BoatRental,        
            ProductCategory_RowBoats,        
            ProductCategory_SailBoats,        
            ProductCategory_MotorBoats,        
            ProductCategory_SpeedBoats);

    public static final List<ProductStorePaymentSettingData> productStorePaymentSettingList=ImmutableList.of(        
            ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_AUTH,        
            ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_RELEASE,        
            ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_CAPTURE,        
            ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_REAUTH,        
            ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_REFUND,        
            ProductStorePaymentSetting_RentalStore_EFT_ACCOUNT_PRDS_PAY_AUTH,        
            ProductStorePaymentSetting_RentalStore_GIFT_CARD_PRDS_PAY_AUTH,        
            ProductStorePaymentSetting_RentalStore_GIFT_CARD_PRDS_PAY_RELEASE,        
            ProductStorePaymentSetting_RentalStore_EXT_PAYPAL_PRDS_PAY_EXTERNAL,        
            ProductStorePaymentSetting_RentalStore_EXT_WORLDPAY_PRDS_PAY_EXTERNAL);

    public static final List<ProductStoreKeywordOvrdData> productStoreKeywordOvrdList=ImmutableList.of(        
            ProductStoreKeywordOvrd_RentalStore_gizmo_);

    public static final List<ProductStoreCatalogData> productStoreCatalogList=ImmutableList.of(        
            ProductStoreCatalog_RentalStore_RentalCatalog_);

    public static final List<ProductStoreRoleData> productStoreRoleList=ImmutableList.of(        
            ProductStoreRole_admin_SALES_REP_RentalStore_);

}
