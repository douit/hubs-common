package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.FixedAssetProductData;
import com.bluecc.hubs.stub.ProductStoreEmailSettingData;
import com.bluecc.hubs.stub.ProdCatalogFlatData;
import com.bluecc.hubs.stub.ProductStoreFlatData;
import com.bluecc.hubs.stub.ProductFlatData;
import com.bluecc.hubs.stub.ProductPriceData;
import com.bluecc.hubs.stub.FixedAssetFlatData;
import com.bluecc.hubs.stub.ProductCategoryRollupFlatData;
import com.bluecc.hubs.stub.ProductCategoryMemberFlatData;
import com.bluecc.hubs.stub.ProdCatalogCategoryFlatData;
import com.bluecc.hubs.stub.ProductStoreFacilityFlatData;
import com.bluecc.hubs.stub.WebSiteFlatData;
import com.bluecc.hubs.stub.ProductCategoryFlatData;
import com.bluecc.hubs.stub.ProductStorePaymentSettingData;
import com.bluecc.hubs.stub.ProductStoreKeywordOvrdData;
import com.bluecc.hubs.stub.ProductStoreCatalogFlatData;
import com.bluecc.hubs.stub.ProductStoreRoleData;

public final class StereoDemoRentalProduct {
    public final static FixedAssetProductData FixedAssetProduct_RoomStd_RoomStd_FAPT_USE_ = FixedAssetProductData.newBuilder()
        .setFixedAssetId("RoomStd")
        .setFixedAssetProductTypeId("FAPT_USE")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductId("RoomStd")
        .build();


    public final static FixedAssetProductData FixedAssetProduct_RoomLux_RoomLux_FAPT_USE_ = FixedAssetProductData.newBuilder()
        .setFixedAssetId("RoomLux")
        .setFixedAssetProductTypeId("FAPT_USE")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductId("RoomLux")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_ODR_CONFIRM = ProductStoreEmailSettingData.newBuilder()
        .setBccAddress("ofbiztest@example.com")
        .setBodyScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#OrderConfirmNotice")
        .setEmailType("PRDS_ODR_CONFIRM")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Order Confirmation #${orderId}")
        .setXslfoAttachScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#OrderConfirmNoticePdf")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_ODR_COMPLETE = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#OrderCompleteNotice")
        .setEmailType("PRDS_ODR_COMPLETE")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Your Order Is Complete #${orderId}")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_ODR_BACKORDER = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#BackorderNotice")
        .setEmailType("PRDS_ODR_BACKORDER")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Backorder Notification #${orderId}")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_ODR_CHANGE = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#OrderChangeNotice")
        .setEmailType("PRDS_ODR_CHANGE")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Order Change Notification #${orderId}")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_ODR_PAYRETRY = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailOrderScreens.xml#PaymentRetryNotice")
        .setEmailType("PRDS_ODR_PAYRETRY")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Order Payment Notification #${orderId}")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_RTN_ACCEPT = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailReturnScreens.xml#ReturnAccept")
        .setEmailType("PRDS_RTN_ACCEPT")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Return Accepted #${returnHeader.returnId}")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_RTN_COMPLETE = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailReturnScreens.xml#ReturnComplete")
        .setEmailType("PRDS_RTN_COMPLETE")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Return Completed #${returnHeader.returnId}")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_RTN_CANCEL = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailReturnScreens.xml#ReturnCancel")
        .setEmailType("PRDS_RTN_CANCEL")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Return Cancelled #${returnHeader.returnId}")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_GC_PURCHASE = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailGiftCardScreens.xml#GiftCardPurchase")
        .setEmailType("PRDS_GC_PURCHASE")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("A Gift From ${senderName}!")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_GC_RELOAD = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailGiftCardScreens.xml#GiftCardReload")
        .setEmailType("PRDS_GC_RELOAD")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("Gift Card Reload Results")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_TELL_FRIEND = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://ecommerce/widget/EmailProductScreens.xml#TellFriend")
        .setEmailType("PRDS_TELL_FRIEND")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("${sendFrom} has sent you a link!")
        .build();


    public final static ProductStoreEmailSettingData ProductStoreEmailSetting_RentalStore_PRDS_PWD_RETRIEVE = ProductStoreEmailSettingData.newBuilder()
        .setBodyScreenLocation("component://securityext/widget/EmailSecurityScreens.xml#PasswordEmail")
        .setEmailType("PRDS_PWD_RETRIEVE")
        .setFromAddress("ofbiztest@example.com")
        .setProductStoreId("RentalStore")
        .setSubject("OFBiz Demo - Password Reminder (${userLoginId})")
        .build();


    public final static ProdCatalogFlatData ProdCatalog_RentalCatalog = ProdCatalogFlatData.newBuilder()
        .setCatalogName("Rental Catalog")
        .setProdCatalogId("RentalCatalog")
        .setUseQuickAdd(castIndicator("N"))
        .build();


    public final static ProductStoreFlatData ProductStore_RentalStore = ProductStoreFlatData.newBuilder()
        .setAllowPassword(castIndicator("Y"))
        .setAuthDeclinedMessage("There has been a problem with your method of payment. Please try a different method or call customer service.")
        .setAuthErrorMessage("Problem connecting to payment processor; we will continue to retry and notify you by email.")
        .setAuthFraudMessage("Your order has been rejected and your account has been disabled due to fraud.")
        .setAutoApproveInvoice(castIndicator("Y"))
        .setAutoApproveOrder(castIndicator("Y"))
        .setCheckInventory(castIndicator("N"))
        .setCompanyName("Open Travel Ltd")
        .setDaysToCancelNonPay(30)
        .setDefaultCurrencyUomId("EUR")
        .setDefaultLocaleString("en_US")
        .setDigitalItemApprovedStatus("ITEM_APPROVED")
        .setExplodeOrderItems(castIndicator("N"))
        .setHeaderApprovedStatus("ORDER_APPROVED")
        .setHeaderCancelStatus("ORDER_CANCELLED")
        .setHeaderDeclinedStatus("ORDER_REJECTED")
        .setInventoryFacilityId("WebStoreWarehouse")
        .setIsImmediatelyFulfilled(castIndicator("Y"))
        .setItemApprovedStatus("ITEM_APPROVED")
        .setItemCancelStatus("ITEM_CANCELLED")
        .setItemDeclinedStatus("ITEM_REJECTED")
        .setOneInventoryFacility(castIndicator("N"))
        .setOrderNumberPrefix("WS")
        .setPayToPartyId("Company")
        .setProductStoreId("RentalStore")
        .setProrateShipping(castIndicator("Y"))
        .setProrateTaxes(castIndicator("Y"))
        .setRequireInventory(castIndicator("N"))
        .setReserveInventory(castIndicator("N"))
        .setReserveOrderEnumId("INVRO_FIFO_REC")
        .setRetryFailedAuths(castIndicator("Y"))
        .setShipIfCaptureFails(castIndicator("Y"))
        .setStoreName("Open Travel system Demo Site")
        .setSubtitle("Part of the Apache OFBiz Family of Open Source Software")
        .setTitle("Ready for your reservation")
        .setVisualThemeId("EC_DEFAULT")
        .build();


    public final static ProductFlatData Product_RoomStd = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setDescription("The standard business room")
        .setInternalName("StdRoom")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setLongDescription("This is the standard room mostly for business")
        .setPrimaryProductCategoryId("Rooms")
        .setProductId("RoomStd")
        .setProductName("Standard Room")
        .setProductTypeId("ASSET_USAGE")
        .setReserv2NdPPPerc(getFixedPoint("20"))
        .setReservMaxPersons(getFixedPoint("3"))
        .setReservNthPPPerc(getFixedPoint("5"))
        .setTaxable(castIndicator("Y"))
        .build();


    public final static ProductFlatData Product_RoomLux = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setDescription("The luxery business room")
        .setInternalName("LuxRoom")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setLongDescription("This is the luxery room mostly for business")
        .setPrimaryProductCategoryId("Rooms")
        .setProductId("RoomLux")
        .setProductName("Luxury Room")
        .setProductTypeId("ASSET_USAGE")
        .setReserv2NdPPPerc(getFixedPoint("20"))
        .setReservMaxPersons(getFixedPoint("4"))
        .setReservNthPPPerc(getFixedPoint(""))
        .setTaxable(castIndicator("Y"))
        .build();


    public final static ProductFlatData Product_RoomLarge = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setDescription("The large room for families")
        .setInternalName("LargeRoom")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setLongDescription("This is the large room mostly for large families")
        .setPrimaryProductCategoryId("Rooms")
        .setProductId("RoomLarge")
        .setProductName("Large Room")
        .setProductTypeId("ASSET_USAGE")
        .setReserv2NdPPPerc(getFixedPoint("20"))
        .setReservMaxPersons(getFixedPoint("8"))
        .setReservNthPPPerc(getFixedPoint("3"))
        .setTaxable(castIndicator("Y"))
        .build();


    public final static ProductFlatData Product_BoatRowSimple = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("N"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setDescription("A simple row boat to rent short time")
        .setInternalName("SmpRwBoat")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setLongDescription("This is the most simplest row boat we have for short term rental only")
        .setPrimaryProductCategoryId("RowBoats")
        .setProductId("BoatRowSimple")
        .setProductName("Simple row boat")
        .setProductTypeId("ASSET_USAGE")
        .setReserv2NdPPPerc(getFixedPoint(""))
        .setReservMaxPersons(getFixedPoint("12"))
        .setReservNthPPPerc(getFixedPoint(""))
        .setTaxable(castIndicator("Y"))
        .build();


    public final static ProductFlatData Product_Cap = ProductFlatData.newBuilder()
        .setAutoCreateKeywords(castIndicator("Y"))
        .setChargeShipping(castIndicator("Y"))
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setDescription("A cap with the hotel logo")
        .setInternalName("Cap")
        .setIsVariant(castIndicator("N"))
        .setIsVirtual(castIndicator("N"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2004-03-04 18:48:34.612"))
        .setLongDescription("This is the nicest cap you have ever seen with the hotel logo in gold!")
        .setProductId("Cap")
        .setProductName("Cap with hotel Logo")
        .setProductTypeId("FINISHED_GOOD")
        .setTaxable(castIndicator("Y"))
        .build();


    public final static ProductPriceData ProductPrice_RoomStd_DEFAULT_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2003-03-04 18:49:03.163"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("15.99"))
        .setProductId("RoomStd")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_RoomStd_LIST_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2003-03-04 18:48:49.113"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("15.0"))
        .setProductId("RoomStd")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("LIST_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_RoomLux_DEFAULT_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2003-03-04 18:57:38.033"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("25.99"))
        .setProductId("RoomLux")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_RoomLux_LIST_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2003-03-04 18:57:29.421"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("25.99"))
        .setProductId("RoomLux")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("LIST_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_RoomLarge_AVERAGE_COST_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2003-03-04 18:50:35.866"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("29.99"))
        .setProductId("RoomLarge")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("AVERAGE_COST")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_RoomLarge_DEFAULT_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2003-03-04 18:50:45.25"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("25.99"))
        .setProductId("RoomLarge")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_BoatRowSimple_DEFAULT_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("549.99"))
        .setProductId("BoatRowSimple")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_BoatRowSimple_LIST_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("550.0"))
        .setProductId("BoatRowSimple")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("LIST_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_BoatRowSimple_COMPETITIVE_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("922.0"))
        .setProductId("BoatRowSimple")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("COMPETITIVE_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static ProductPriceData ProductPrice_Cap_DEFAULT_PRICE_PURCHASE_EUR__NA__ = ProductPriceData.newBuilder()
        .setCreatedByUserLogin("admin")
        .setCreatedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setCurrencyUomId("EUR")
        .setFromDate(getTimestamp("2003-03-04 18:50:45.25"))
        .setLastModifiedByUserLogin("admin")
        .setLastModifiedDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPrice(getCurrency("5.99"))
        .setProductId("Cap")
        .setProductPricePurposeId("PURCHASE")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .setProductStoreGroupId("_NA_")
        .build();


    public final static FixedAssetFlatData FixedAsset_RoomStd = FixedAssetFlatData.newBuilder()
        .setFixedAssetId("RoomStd")
        .setFixedAssetName("Standard Room")
        .setFixedAssetTypeId("PROPERTY")
        .setProductionCapacity(getFixedPoint("10"))
        .build();


    public final static FixedAssetFlatData FixedAsset_RoomLux = FixedAssetFlatData.newBuilder()
        .setFixedAssetId("RoomLux")
        .setFixedAssetName("Luxury Room")
        .setFixedAssetTypeId("PROPERTY")
        .setProductionCapacity(getFixedPoint("10"))
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_ConfRooms_HotelFac_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 15:21:07.613"))
        .setParentProductCategoryId("HotelFac")
        .setProductCategoryId("ConfRooms")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_Rooms_HotelFac_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 15:22:29.139"))
        .setParentProductCategoryId("HotelFac")
        .setProductCategoryId("Rooms")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_Suites_HotelFac_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 15:23:05.706"))
        .setParentProductCategoryId("HotelFac")
        .setProductCategoryId("Suites")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_SpeedBoats_BoatRental_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 15:23:54.452"))
        .setParentProductCategoryId("BoatRental")
        .setProductCategoryId("SpeedBoats")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_MotorBoats_BoatRental_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 15:30:56.77"))
        .setParentProductCategoryId("BoatRental")
        .setProductCategoryId("MotorBoats")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_RowBoats_BoatRental_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 15:32:27.359"))
        .setParentProductCategoryId("BoatRental")
        .setProductCategoryId("RowBoats")
        .build();


    public final static ProductCategoryRollupFlatData ProductCategoryRollup_SailBoats_BoatRental_ = ProductCategoryRollupFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 15:32:48.86"))
        .setParentProductCategoryId("BoatRental")
        .setProductCategoryId("SailBoats")
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_RentalPromo_RoomLux_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 20:39:58.563"))
        .setProductCategoryId("RentalPromo")
        .setProductId("RoomLux")
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_RentalPromo_RoomStd_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 20:40:12.749"))
        .setProductCategoryId("RentalPromo")
        .setProductId("RoomStd")
        .build();


    public final static ProductCategoryMemberFlatData ProductCategoryMember_RentalPromo_Cap_ = ProductCategoryMemberFlatData.newBuilder()
        .setFromDate(getTimestamp("2004-10-18 20:40:12.749"))
        .setProductCategoryId("RentalPromo")
        .setProductId("Cap")
        .build();


    public final static ProdCatalogCategoryFlatData ProdCatalogCategory_RentalCatalog_RentBrowseRoot_PCCT_BROWSE_ROOT_ = ProdCatalogCategoryFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatalogCategoryTypeId("PCCT_BROWSE_ROOT")
        .setProdCatalogId("RentalCatalog")
        .setProductCategoryId("RentBrowseRoot")
        .setSequenceNum(1)
        .build();


    public final static ProdCatalogCategoryFlatData ProdCatalogCategory_RentalCatalog_RentBrowseRoot_SRCH_PCCT_SEARCH_ = ProdCatalogCategoryFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatalogCategoryTypeId("PCCT_SEARCH")
        .setProdCatalogId("RentalCatalog")
        .setProductCategoryId("RentBrowseRoot_SRCH")
        .setSequenceNum(1)
        .build();


    public final static ProdCatalogCategoryFlatData ProdCatalogCategory_RentalCatalog_RentalPromo_PCCT_PROMOTIONS_ = ProdCatalogCategoryFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatalogCategoryTypeId("PCCT_PROMOTIONS")
        .setProdCatalogId("RentalCatalog")
        .setProductCategoryId("RentalPromo")
        .setSequenceNum(1)
        .build();


    public final static ProductStoreFacilityFlatData ProductStoreFacility_RentalStore_WebStoreWarehouse_ = ProductStoreFacilityFlatData.newBuilder()
        .setFacilityId("WebStoreWarehouse")
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProductStoreId("RentalStore")
        .build();


    public final static WebSiteFlatData WebSite_OpenTravelSystem = WebSiteFlatData.newBuilder()
        .setProductStoreId("RentalStore")
        .setSiteName("The Open source Travel System")
        .setWebSiteId("OpenTravelSystem")
        .build();


    public final static ProductCategoryFlatData ProductCategory_RentBrowseRoot = ProductCategoryFlatData.newBuilder()
        .setDescription("Rental Browse Root")
        .setLongDescription("Rental Catalog Primary Browse Root Category")
        .setProductCategoryId("RentBrowseRoot")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_RentBrowseRoot_SRCH = ProductCategoryFlatData.newBuilder()
        .setDescription("Rental Browse Root to search")
        .setLongDescription("Rental Catalog Primary Browse Root Category")
        .setProductCategoryId("RentBrowseRoot_SRCH")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_RentalPromo = ProductCategoryFlatData.newBuilder()
        .setDescription("Rental Promotions")
        .setLongDescription("Rental Catalog Primary Browse Root Category")
        .setProductCategoryId("RentalPromo")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_HotelFac = ProductCategoryFlatData.newBuilder()
        .setDescription("Hotel Facilities")
        .setLongDescription("long description of Hotel facilities")
        .setPrimaryParentCategoryId("RentBrowseRoot")
        .setProductCategoryId("HotelFac")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_Rooms = ProductCategoryFlatData.newBuilder()
        .setDescription("Rooms")
        .setLongDescription("long description of Hotel rooms")
        .setPrimaryParentCategoryId("HotelFac")
        .setProductCategoryId("Rooms")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_Suites = ProductCategoryFlatData.newBuilder()
        .setDescription("Suites")
        .setLongDescription("long description of Hotel suites")
        .setPrimaryParentCategoryId("HotelFac")
        .setProductCategoryId("Suites")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_ConfRooms = ProductCategoryFlatData.newBuilder()
        .setDescription("Conference Rooms")
        .setLongDescription("long description of Hotel conference rooms")
        .setPrimaryParentCategoryId("HotelFac")
        .setProductCategoryId("ConfRooms")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_BoatRental = ProductCategoryFlatData.newBuilder()
        .setDescription("Boat Rental")
        .setLongDescription("long description of Boat rentals")
        .setPrimaryParentCategoryId("RentBrowseRoot")
        .setProductCategoryId("BoatRental")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_RowBoats = ProductCategoryFlatData.newBuilder()
        .setDescription("Row Boats")
        .setLongDescription("long description of Row Boats")
        .setPrimaryParentCategoryId("BoatRental")
        .setProductCategoryId("RowBoats")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_SailBoats = ProductCategoryFlatData.newBuilder()
        .setDescription("Sailing Boats")
        .setLongDescription("long description of Sailing Boats")
        .setPrimaryParentCategoryId("BoatRental")
        .setProductCategoryId("SailBoats")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_MotorBoats = ProductCategoryFlatData.newBuilder()
        .setDescription("Motor Boats")
        .setLongDescription("long description of Motor Boats")
        .setPrimaryParentCategoryId("BoatRental")
        .setProductCategoryId("MotorBoats")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryFlatData ProductCategory_SpeedBoats = ProductCategoryFlatData.newBuilder()
        .setDescription("Speed Boats")
        .setLongDescription("long description of Speed Boats")
        .setPrimaryParentCategoryId("BoatRental")
        .setProductCategoryId("SpeedBoats")
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_AUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("CC_AUTH_ALWAYSAPPROV")
        .setPaymentMethodTypeId("CREDIT_CARD")
        .setPaymentService("alwaysApproveCCProcessor")
        .setPaymentServiceTypeEnumId("PRDS_PAY_AUTH")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_RELEASE = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("CC_RELEASE_TEST")
        .setPaymentMethodTypeId("CREDIT_CARD")
        .setPaymentService("testCCRelease")
        .setPaymentServiceTypeEnumId("PRDS_PAY_RELEASE")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_CAPTURE = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("CC_CAPTURE_TEST")
        .setPaymentMethodTypeId("CREDIT_CARD")
        .setPaymentService("testCCCapture")
        .setPaymentServiceTypeEnumId("PRDS_PAY_CAPTURE")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_REAUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("CC_AUTH_ALWAYSAPPROV")
        .setPaymentMethodTypeId("CREDIT_CARD")
        .setPaymentService("alwaysApproveCCProcessor")
        .setPaymentServiceTypeEnumId("PRDS_PAY_REAUTH")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_CREDIT_CARD_PRDS_PAY_REFUND = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("CC_REFUND_TEST")
        .setPaymentMethodTypeId("CREDIT_CARD")
        .setPaymentService("testCCRefund")
        .setPaymentServiceTypeEnumId("PRDS_PAY_REFUND")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_EFT_ACCOUNT_PRDS_PAY_AUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("EFT_AUTH_ALWAYSAPPRO")
        .setPaymentMethodTypeId("EFT_ACCOUNT")
        .setPaymentService("alwaysApproveEFTProcessor")
        .setPaymentServiceTypeEnumId("PRDS_PAY_AUTH")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_GIFT_CARD_PRDS_PAY_AUTH = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("GIFT_AUTH_ALWAYSAPPR")
        .setPaymentMethodTypeId("GIFT_CARD")
        .setPaymentService("alwaysApproveGCProcessor")
        .setPaymentServiceTypeEnumId("PRDS_PAY_AUTH")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_GIFT_CARD_PRDS_PAY_RELEASE = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("GIFT_RELEASE_TEST")
        .setPaymentMethodTypeId("GIFT_CARD")
        .setPaymentService("testGCRelease")
        .setPaymentServiceTypeEnumId("PRDS_PAY_RELEASE")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_EXT_PAYPAL_PRDS_PAY_EXTERNAL = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("")
        .setPaymentGatewayConfigId("PAYPAL_CONFIG")
        .setPaymentMethodTypeId("EXT_PAYPAL")
        .setPaymentService("")
        .setPaymentServiceTypeEnumId("PRDS_PAY_EXTERNAL")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStorePaymentSettingData ProductStorePaymentSetting_RentalStore_EXT_WORLDPAY_PRDS_PAY_EXTERNAL = ProductStorePaymentSettingData.newBuilder()
        .setPaymentCustomMethodId("")
        .setPaymentGatewayConfigId("WORLDPAY_CONFIG")
        .setPaymentMethodTypeId("EXT_WORLDPAY")
        .setPaymentService("")
        .setPaymentServiceTypeEnumId("PRDS_PAY_EXTERNAL")
        .setProductStoreId("RentalStore")
        .build();


    public final static ProductStoreKeywordOvrdData ProductStoreKeywordOvrd_RentalStore_gizmo_ = ProductStoreKeywordOvrdData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setKeyword("gizmo")
        .setProductStoreId("RentalStore")
        .setTarget("100")
        .setTargetTypeEnumId("KOTT_PRODCAT")
        .build();


    public final static ProductStoreCatalogFlatData ProductStoreCatalog_RentalStore_RentalCatalog_ = ProductStoreCatalogFlatData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setProdCatalogId("RentalCatalog")
        .setProductStoreId("RentalStore")
        .setSequenceNum(1)
        .build();


    public final static ProductStoreRoleData ProductStoreRole_admin_SALES_REP_RentalStore_ = ProductStoreRoleData.newBuilder()
        .setFromDate(getTimestamp("2001-05-13 12:00:00.0"))
        .setPartyId("admin")
        .setProductStoreId("RentalStore")
        .setRoleTypeId("SALES_REP")
        .build();

}
