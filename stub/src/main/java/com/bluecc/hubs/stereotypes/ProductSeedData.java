package com.bluecc.hubs.stereotypes;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ContentAssocTypeData;
import com.bluecc.hubs.stub.ProdCatalogCategoryTypeData;
import com.bluecc.hubs.stub.ProductMaintTypeData;
import com.bluecc.hubs.stub.FacilityGroupTypeData;
import com.bluecc.hubs.stub.InventoryItemTypeData;
import com.bluecc.hubs.stub.ContentTypeData;
import com.bluecc.hubs.stub.ProductFeatureIactnTypeData;
import com.bluecc.hubs.stub.ShipmentGatewayUspsData;
import com.bluecc.hubs.stub.RoleTypeData;
import com.bluecc.hubs.stub.ProductMeterTypeData;
import com.bluecc.hubs.stub.ShipmentGatewayConfigData;
import com.bluecc.hubs.stub.ProductFeatureData;
import com.bluecc.hubs.stub.ShipmentGatewayConfigTypeData;
import com.bluecc.hubs.stub.CustomMethodData;
import com.bluecc.hubs.stub.ShipmentContactMechTypeData;
import com.bluecc.hubs.stub.StatusItemData;
import com.bluecc.hubs.stub.StatusValidChangeData;
import com.bluecc.hubs.stub.QuantityBreakTypeData;
import com.bluecc.hubs.stub.FacilityAssocTypeData;
import com.bluecc.hubs.stub.SubscriptionTypeData;
import com.bluecc.hubs.stub.ShipmentTypeData;
import com.bluecc.hubs.stub.ProductCategoryContentTypeData;
import com.bluecc.hubs.stub.ProductFeatureCategoryData;
import com.bluecc.hubs.stub.ProductFeatureApplTypeData;
import com.bluecc.hubs.stub.ProductPricePurposeData;
import com.bluecc.hubs.stub.ProductPriceTypeData;
import com.bluecc.hubs.stub.ShipmentGatewayDhlData;
import com.bluecc.hubs.stub.ProductPriceActionTypeData;
import com.bluecc.hubs.stub.ShipmentGatewayFedexData;
import com.bluecc.hubs.stub.EnumerationData;
import com.bluecc.hubs.stub.ProductAssocTypeData;
import com.bluecc.hubs.stub.FacilityGroupData;
import com.bluecc.hubs.stub.ProductFeatureTypeData;
import com.bluecc.hubs.stub.ProductTypeData;
import com.bluecc.hubs.stub.EnumerationTypeData;
import com.bluecc.hubs.stub.VarianceReasonData;
import com.bluecc.hubs.stub.ProductContentTypeData;
import com.bluecc.hubs.stub.GoodIdentificationTypeData;
import com.bluecc.hubs.stub.ProdConfItemContentTypeData;
import com.bluecc.hubs.stub.SupplierPrefOrderData;
import com.bluecc.hubs.stub.RejectionReasonData;
import com.bluecc.hubs.stub.ShipmentGatewayUpsData;
import com.bluecc.hubs.stub.ProductCategoryTypeData;
import com.bluecc.hubs.stub.CostComponentTypeData;
import com.bluecc.hubs.stub.ProductStoreGroupData;
import com.bluecc.hubs.stub.StatusTypeData;
import com.bluecc.hubs.stub.CustomMethodTypeData;
import com.bluecc.hubs.stub.FacilityTypeData;

public final class ProductSeedData {
    public final static ContentAssocTypeData ContentAssocType_IMAGE_THUMBNAIL = ContentAssocTypeData.newBuilder()
        .setContentAssocTypeId("IMAGE_THUMBNAIL")
        .setDescription("Image Thumbnail")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_BROWSE_ROOT = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Browse Root (One)")
        .setProdCatalogCategoryTypeId("PCCT_BROWSE_ROOT")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_SEARCH = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Default Search (One)")
        .setProdCatalogCategoryTypeId("PCCT_SEARCH")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_OTHER_SEARCH = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Other Search (Many)")
        .setProdCatalogCategoryTypeId("PCCT_OTHER_SEARCH")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_QUICK_ADD = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Quick Add (Many)")
        .setProdCatalogCategoryTypeId("PCCT_QUICK_ADD")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_PROMOTIONS = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Promotions (One)")
        .setProdCatalogCategoryTypeId("PCCT_PROMOTIONS")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_MOST_POPULAR = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Most Popular (One)")
        .setProdCatalogCategoryTypeId("PCCT_MOST_POPULAR")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_WHATS_NEW = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("What's New (One)")
        .setProdCatalogCategoryTypeId("PCCT_WHATS_NEW")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_VIEW_ALLW = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("View Allow (One)")
        .setProdCatalogCategoryTypeId("PCCT_VIEW_ALLW")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_PURCH_ALLW = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Purchase Allow (One)")
        .setProdCatalogCategoryTypeId("PCCT_PURCH_ALLW")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_ADMIN_ALLW = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Admin Allow (One)")
        .setProdCatalogCategoryTypeId("PCCT_ADMIN_ALLW")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_EBAY_ROOT = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Ebay Root (One)")
        .setProdCatalogCategoryTypeId("PCCT_EBAY_ROOT")
        .build();


    public final static ProdCatalogCategoryTypeData ProdCatalogCategoryType_PCCT_BEST_SELL = ProdCatalogCategoryTypeData.newBuilder()
        .setDescription("Best Selling (One)")
        .setProdCatalogCategoryTypeId("PCCT_BEST_SELL")
        .build();


    public final static ProductMaintTypeData ProductMaintType_VEHICLE_MAINT = ProductMaintTypeData.newBuilder()
        .setDescription("Vehicle Maintenance")
        .setProductMaintTypeId("VEHICLE_MAINT")
        .build();


    public final static ProductMaintTypeData ProductMaintType_OIL_CHANGE = ProductMaintTypeData.newBuilder()
        .setDescription("Oil Change")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("OIL_CHANGE")
        .build();


    public final static ProductMaintTypeData ProductMaintType_SERP_BELT = ProductMaintTypeData.newBuilder()
        .setDescription("Serpentine Belt Replacement")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("SERP_BELT")
        .build();


    public final static ProductMaintTypeData ProductMaintType_REFUEL = ProductMaintTypeData.newBuilder()
        .setDescription("Re-Fuel")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("REFUEL")
        .build();


    public final static ProductMaintTypeData ProductMaintType_REPLACE_BATTERY = ProductMaintTypeData.newBuilder()
        .setDescription("Replace Battery")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("REPLACE_BATTERY")
        .build();


    public final static ProductMaintTypeData ProductMaintType_TUNE_UP = ProductMaintTypeData.newBuilder()
        .setDescription("Tune Up")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("TUNE_UP")
        .build();


    public final static ProductMaintTypeData ProductMaintType_CHECK_BATTERY = ProductMaintTypeData.newBuilder()
        .setDescription("Check Battery")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("CHECK_BATTERY")
        .build();


    public final static ProductMaintTypeData ProductMaintType_CHASSIS_LUBE = ProductMaintTypeData.newBuilder()
        .setDescription("Chassis Lubrication")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("CHASSIS_LUBE")
        .build();


    public final static ProductMaintTypeData ProductMaintType_ROTATE_TIRES = ProductMaintTypeData.newBuilder()
        .setDescription("Rotate Tires")
        .setParentTypeId("VEHICLE_MAINT")
        .setProductMaintTypeId("ROTATE_TIRES")
        .build();


    public final static ProductMaintTypeData ProductMaintType_HVAC_MAINT = ProductMaintTypeData.newBuilder()
        .setDescription("HVAC Maintenance")
        .setProductMaintTypeId("HVAC_MAINT")
        .build();


    public final static ProductMaintTypeData ProductMaintType_HVAC_REPLACE_FILTER = ProductMaintTypeData.newBuilder()
        .setDescription("Replace Air Filter")
        .setParentTypeId("HVAC_MAINT")
        .setProductMaintTypeId("HVAC_REPLACE_FILTER")
        .build();


    public final static ProductMaintTypeData ProductMaintType_HVAC_CHECK_REFR = ProductMaintTypeData.newBuilder()
        .setDescription("Check/Recharge Refrigerant")
        .setParentTypeId("HVAC_MAINT")
        .setProductMaintTypeId("HVAC_CHECK_REFR")
        .build();


    public final static ProductMaintTypeData ProductMaintType_WASH = ProductMaintTypeData.newBuilder()
        .setDescription("Wash")
        .setProductMaintTypeId("WASH")
        .build();


    public final static FacilityGroupTypeData FacilityGroupType_MGMT_STRUCTURE = FacilityGroupTypeData.newBuilder()
        .setDescription("Management Structure")
        .setFacilityGroupTypeId("MGMT_STRUCTURE")
        .build();


    public final static FacilityGroupTypeData FacilityGroupType_PRICING_GROUP = FacilityGroupTypeData.newBuilder()
        .setDescription("Pricing Group")
        .setFacilityGroupTypeId("PRICING_GROUP")
        .build();


    public final static InventoryItemTypeData InventoryItemType_SERIALIZED_INV_ITEM = InventoryItemTypeData.newBuilder()
        .setDescription("Serialized")
        .setHasTable(castIndicator("N"))
        .setInventoryItemTypeId("SERIALIZED_INV_ITEM")
        .build();


    public final static InventoryItemTypeData InventoryItemType_NON_SERIAL_INV_ITEM = InventoryItemTypeData.newBuilder()
        .setDescription("Non-Serialized")
        .setHasTable(castIndicator("N"))
        .setInventoryItemTypeId("NON_SERIAL_INV_ITEM")
        .build();


    public final static ContentTypeData ContentType_IMAGE_FRAME = ContentTypeData.newBuilder()
        .setContentTypeId("IMAGE_FRAME")
        .setDescription("Frame Image")
        .build();


    public final static ProductFeatureIactnTypeData ProductFeatureIactnType_FEATURE_IACTN_DEPEND = ProductFeatureIactnTypeData.newBuilder()
        .setDescription("Dependencies")
        .setHasTable(castIndicator("N"))
        .setProductFeatureIactnTypeId("FEATURE_IACTN_DEPEND")
        .build();


    public final static ProductFeatureIactnTypeData ProductFeatureIactnType_FEATURE_IACTN_INCOMP = ProductFeatureIactnTypeData.newBuilder()
        .setDescription("Incompatibility")
        .setHasTable(castIndicator("N"))
        .setProductFeatureIactnTypeId("FEATURE_IACTN_INCOMP")
        .build();


    public final static ShipmentGatewayUspsData ShipmentGatewayUsps_USPS_CONFIG = ShipmentGatewayUspsData.newBuilder()
        .setAccessPassword("999999999999")
        .setAccessUserId("000000000000")
        .setConnectTimeout(60)
        .setConnectUrl("http://production.shippingapis.com/ShippingAPITest.dll")
        .setConnectUrlLabels("http://production.shippingapis.com/ShippingAPITest.dll")
        .setMaxEstimateWeight(70)
        .setShipmentGatewayConfigId("USPS_CONFIG")
        .setTest("N")
        .build();


    public final static RoleTypeData RoleType_IMAGEAPPROVER = RoleTypeData.newBuilder()
        .setDescription("Image Approver")
        .setHasTable(castIndicator("N"))
        .setRoleTypeId("IMAGEAPPROVER")
        .build();


    public final static ProductMeterTypeData ProductMeterType_SPEEDOMETER = ProductMeterTypeData.newBuilder()
        .setDescription("Speedometer")
        .setProductMeterTypeId("SPEEDOMETER")
        .build();


    public final static ProductMeterTypeData ProductMeterType_TACHOMETER = ProductMeterTypeData.newBuilder()
        .setDescription("Tachometer")
        .setProductMeterTypeId("TACHOMETER")
        .build();


    public final static ProductMeterTypeData ProductMeterType_DISTANCE = ProductMeterTypeData.newBuilder()
        .setDescription("Distance Meter")
        .setProductMeterTypeId("DISTANCE")
        .build();


    public final static ProductMeterTypeData ProductMeterType_MOTOR_TIME = ProductMeterTypeData.newBuilder()
        .setDescription("Motor Time Meter")
        .setProductMeterTypeId("MOTOR_TIME")
        .build();


    public final static ProductMeterTypeData ProductMeterType_USE_COUNT = ProductMeterTypeData.newBuilder()
        .setDescription("Use Count Meter")
        .setProductMeterTypeId("USE_COUNT")
        .build();


    public final static ProductMeterTypeData ProductMeterType_COPY_COUNT = ProductMeterTypeData.newBuilder()
        .setDescription("Copy Count Meter")
        .setProductMeterTypeId("COPY_COUNT")
        .build();


    public final static ProductMeterTypeData ProductMeterType_TRIP_METER = ProductMeterTypeData.newBuilder()
        .setDescription("Trip meter")
        .setProductMeterTypeId("TRIP_METER")
        .build();


    public final static ProductMeterTypeData ProductMeterType_TACHOGRAPH = ProductMeterTypeData.newBuilder()
        .setDescription("Tachograph")
        .setProductMeterTypeId("TACHOGRAPH")
        .build();


    public final static ProductMeterTypeData ProductMeterType_TAXIMETER = ProductMeterTypeData.newBuilder()
        .setDescription("Taximeter")
        .setProductMeterTypeId("TAXIMETER")
        .build();


    public final static ProductMeterTypeData ProductMeterType_EVENT_DATA_RECORDER = ProductMeterTypeData.newBuilder()
        .setDescription("Event Data Recorder")
        .setProductMeterTypeId("EVENT_DATA_RECORDER")
        .build();


    public final static ProductMeterTypeData ProductMeterType_PEDOMETER = ProductMeterTypeData.newBuilder()
        .setDescription("Pedometer")
        .setProductMeterTypeId("PEDOMETER")
        .build();


    public final static ProductMeterTypeData ProductMeterType_ODOMETER = ProductMeterTypeData.newBuilder()
        .setDescription("Odometer")
        .setProductMeterTypeId("ODOMETER")
        .build();


    public final static ShipmentGatewayConfigData ShipmentGatewayConfig_DHL_CONFIG = ShipmentGatewayConfigData.newBuilder()
        .setDescription("DHL Config")
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_DHL")
        .setShipmentGatewayConfigId("DHL_CONFIG")
        .build();


    public final static ShipmentGatewayConfigData ShipmentGatewayConfig_FEDEX_CONFIG = ShipmentGatewayConfigData.newBuilder()
        .setDescription("Fedex Config")
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_FEDEX")
        .setShipmentGatewayConfigId("FEDEX_CONFIG")
        .build();


    public final static ShipmentGatewayConfigData ShipmentGatewayConfig_UPS_CONFIG = ShipmentGatewayConfigData.newBuilder()
        .setDescription("UPS Config")
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_UPS")
        .setShipmentGatewayConfigId("UPS_CONFIG")
        .build();


    public final static ShipmentGatewayConfigData ShipmentGatewayConfig_USPS_CONFIG = ShipmentGatewayConfigData.newBuilder()
        .setDescription("USPS Config")
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_USPS")
        .setShipmentGatewayConfigId("USPS_CONFIG")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_AVATAR = ProductFeatureData.newBuilder()
        .setAbbrev("100x75")
        .setDefaultSequenceNum(1)
        .setDescription("100 X 75 (avatar)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_AVATAR")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_THUMBNAIL = ProductFeatureData.newBuilder()
        .setAbbrev("150x112")
        .setDefaultSequenceNum(2)
        .setDescription("150 X 112 (thumbnail)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_THUMBNAIL")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_WEBSITE = ProductFeatureData.newBuilder()
        .setAbbrev("320x240")
        .setDefaultSequenceNum(3)
        .setDescription("320 X 240 (for websites and email)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_WEBSITE")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_BOARD = ProductFeatureData.newBuilder()
        .setAbbrev("640x480")
        .setDefaultSequenceNum(4)
        .setDescription("640 X 480 (for message boards)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_BOARD")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_MONITOR15 = ProductFeatureData.newBuilder()
        .setAbbrev("800x600")
        .setDefaultSequenceNum(5)
        .setDescription("800 X 600 (15-inch monitor)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_MONITOR15")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_MONITOR17 = ProductFeatureData.newBuilder()
        .setAbbrev("1024x768")
        .setDefaultSequenceNum(6)
        .setDescription("1024 X 768 (17-inch monitor)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_MONITOR17")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_MONITOR19 = ProductFeatureData.newBuilder()
        .setAbbrev("1280x1024")
        .setDefaultSequenceNum(7)
        .setDescription("1280 X 1024 (19-inch monitor)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_MONITOR19")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_IMAGE_MONITOR21 = ProductFeatureData.newBuilder()
        .setAbbrev("1600x1200")
        .setDefaultSequenceNum(8)
        .setDescription("1600 X 1200 (21-inch monitor)")
        .setProductFeatureCategoryId("IMAGE")
        .setProductFeatureId("IMAGE_MONITOR21")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_SMALL = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(1)
        .setDescription("Small")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_SMALL")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_MIDDLE = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(2)
        .setDescription("Middle")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_MIDDLE")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_LARGE = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(3)
        .setDescription("Large")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_LARGE")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_VERYLARGE = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(4)
        .setDescription("Very Large")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_VERYLARGE")
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_WHITE = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(1)
        .setDescription("White")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_WHITE")
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_GRAY = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(2)
        .setDescription("Gray")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_GRAY")
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_BLACK = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(3)
        .setDescription("Black")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_BLACK")
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_RED = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(4)
        .setDescription("Red")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_RED")
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_GREEN = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(5)
        .setDescription("Green")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_GREEN")
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_BLUE = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(6)
        .setDescription("Blue")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_BLUE")
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ProductFeatureData ProductFeature_TEXT_YELLOW = ProductFeatureData.newBuilder()
        .setDefaultSequenceNum(7)
        .setDescription("Yellow")
        .setProductFeatureCategoryId("TEXT")
        .setProductFeatureId("TEXT_YELLOW")
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ShipmentGatewayConfigTypeData ShipmentGatewayConfigType_SHIP_GATEWAY_DHL = ShipmentGatewayConfigTypeData.newBuilder()
        .setDescription("Shipment Gateway DHL")
        .setHasTable(castIndicator("Y"))
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_DHL")
        .build();


    public final static ShipmentGatewayConfigTypeData ShipmentGatewayConfigType_SHIP_GATEWAY_FEDEX = ShipmentGatewayConfigTypeData.newBuilder()
        .setDescription("Shipment Gateway Fedex")
        .setHasTable(castIndicator("Y"))
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_FEDEX")
        .build();


    public final static ShipmentGatewayConfigTypeData ShipmentGatewayConfigType_SHIP_GATEWAY_UPS = ShipmentGatewayConfigTypeData.newBuilder()
        .setDescription("Shipment Gateway UPS")
        .setHasTable(castIndicator("Y"))
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_UPS")
        .build();


    public final static ShipmentGatewayConfigTypeData ShipmentGatewayConfigType_SHIP_GATEWAY_USPS = ShipmentGatewayConfigTypeData.newBuilder()
        .setDescription("Shipment Gateway USPS")
        .setHasTable(castIndicator("Y"))
        .setShipmentGatewayConfTypeId("SHIP_GATEWAY_USPS")
        .build();


    public final static CustomMethodData CustomMethod_PROD_PERC_FORMULA = CustomMethodData.newBuilder()
        .setCustomMethodId("PROD_PERC_FORMULA")
        .setCustomMethodName("productCostPercentageFormula")
        .setCustomMethodTypeId("COST_FORMULA")
        .setDescription("Formula that creates a cost component equal to a percentage of total product cost")
        .build();


    public final static CustomMethodData CustomMethod_SHIP_EST_DHL = CustomMethodData.newBuilder()
        .setCustomMethodId("SHIP_EST_DHL")
        .setCustomMethodName("dhlRateEstimate")
        .setCustomMethodTypeId("SHIP_EST")
        .setDescription("DHL rate estimate")
        .build();


    public final static CustomMethodData CustomMethod_SHIP_EST_FEDEX = CustomMethodData.newBuilder()
        .setCustomMethodId("SHIP_EST_FEDEX")
        .setCustomMethodName("fedexRateEstimate")
        .setCustomMethodTypeId("SHIP_EST")
        .setDescription("FedEx rate estimate")
        .build();


    public final static CustomMethodData CustomMethod_SHIP_EST_UPS = CustomMethodData.newBuilder()
        .setCustomMethodId("SHIP_EST_UPS")
        .setCustomMethodName("upsRateEstimate")
        .setCustomMethodTypeId("SHIP_EST")
        .setDescription("UPS rate estimate")
        .build();


    public final static CustomMethodData CustomMethod_SHIP_EST_USPS = CustomMethodData.newBuilder()
        .setCustomMethodId("SHIP_EST_USPS")
        .setCustomMethodName("uspsRateInquire")
        .setCustomMethodTypeId("SHIP_EST")
        .setDescription("USPS rate estimate")
        .build();


    public final static CustomMethodData CustomMethod_SHIP_EST_USPS_INT = CustomMethodData.newBuilder()
        .setCustomMethodId("SHIP_EST_USPS_INT")
        .setCustomMethodName("uspsInternationalRateInquire")
        .setCustomMethodTypeId("SHIP_EST")
        .setDescription("USPS rate estimate international")
        .build();


    public final static ShipmentContactMechTypeData ShipmentContactMechType_SHIP_TO_ADDRESS = ShipmentContactMechTypeData.newBuilder()
        .setDescription("Ship-To Address")
        .setShipmentContactMechTypeId("SHIP_TO_ADDRESS")
        .build();


    public final static ShipmentContactMechTypeData ShipmentContactMechType_SHIP_FROM_ADDRESS = ShipmentContactMechTypeData.newBuilder()
        .setDescription("Ship-From Address")
        .setShipmentContactMechTypeId("SHIP_FROM_ADDRESS")
        .build();


    public final static ShipmentContactMechTypeData ShipmentContactMechType_SHIP_TO_TELECOM = ShipmentContactMechTypeData.newBuilder()
        .setDescription("Ship-To Telecom Number")
        .setShipmentContactMechTypeId("SHIP_TO_TELECOM")
        .build();


    public final static ShipmentContactMechTypeData ShipmentContactMechType_SHIP_FROM_TELECOM = ShipmentContactMechTypeData.newBuilder()
        .setDescription("Ship-From Telecom Number")
        .setShipmentContactMechTypeId("SHIP_FROM_TELECOM")
        .build();


    public final static ShipmentContactMechTypeData ShipmentContactMechType_SHIP_TO_EMAIL = ShipmentContactMechTypeData.newBuilder()
        .setDescription("Ship-To E-Mail")
        .setShipmentContactMechTypeId("SHIP_TO_EMAIL")
        .build();


    public final static ShipmentContactMechTypeData ShipmentContactMechType_SHIP_FROM_EMAIL = ShipmentContactMechTypeData.newBuilder()
        .setDescription("Ship-From E-Mail")
        .setShipmentContactMechTypeId("SHIP_FROM_EMAIL")
        .build();


    public final static StatusItemData StatusItem_INV_ON_ORDER = StatusItemData.newBuilder()
        .setDescription("On Order")
        .setSequenceId("01")
        .setStatusCode("ON_ORDER")
        .setStatusId("INV_ON_ORDER")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_AVAILABLE = StatusItemData.newBuilder()
        .setDescription("Available")
        .setSequenceId("02")
        .setStatusCode("AVAILABLE")
        .setStatusId("INV_AVAILABLE")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_PROMISED = StatusItemData.newBuilder()
        .setDescription("Promised")
        .setSequenceId("03")
        .setStatusCode("PROMISED")
        .setStatusId("INV_PROMISED")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_DELIVERED = StatusItemData.newBuilder()
        .setDescription("Delivered")
        .setSequenceId("04")
        .setStatusCode("DELIVERED")
        .setStatusId("INV_DELIVERED")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_ACTIVATED = StatusItemData.newBuilder()
        .setDescription("Activated")
        .setSequenceId("05")
        .setStatusCode("ACTIVATED")
        .setStatusId("INV_ACTIVATED")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_DEACTIVATED = StatusItemData.newBuilder()
        .setDescription("Deactivated")
        .setSequenceId("06")
        .setStatusCode("DEACTIVATED")
        .setStatusId("INV_DEACTIVATED")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_ON_HOLD = StatusItemData.newBuilder()
        .setDescription("On Hold")
        .setSequenceId("07")
        .setStatusCode("ON_HOLD")
        .setStatusId("INV_ON_HOLD")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_BEING_TRANSFERED = StatusItemData.newBuilder()
        .setDescription("Being Transfered")
        .setSequenceId("10")
        .setStatusCode("BEING_TRANSFERED")
        .setStatusId("INV_BEING_TRANSFERED")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_BEING_TRANS_PRM = StatusItemData.newBuilder()
        .setDescription("Being Transfered (Promised)")
        .setSequenceId("11")
        .setStatusCode("BEING_TRANS_PRM")
        .setStatusId("INV_BEING_TRANS_PRM")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_RETURNED = StatusItemData.newBuilder()
        .setDescription("Returned")
        .setSequenceId("20")
        .setStatusCode("RETURNED")
        .setStatusId("INV_RETURNED")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_DEFECTIVE = StatusItemData.newBuilder()
        .setDescription("Defective")
        .setSequenceId("21")
        .setStatusCode("DEFECTIVE")
        .setStatusId("INV_DEFECTIVE")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_NS_ON_HOLD = StatusItemData.newBuilder()
        .setDescription("On Hold (Non-Serialized)")
        .setSequenceId("01")
        .setStatusCode("ON_HOLD_NS")
        .setStatusId("INV_NS_ON_HOLD")
        .setStatusTypeId("INV_NON_SER_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_NS_DEFECTIVE = StatusItemData.newBuilder()
        .setDescription("Defective (Non-Serialized)")
        .setSequenceId("02")
        .setStatusCode("DEFECTIVE_NS")
        .setStatusId("INV_NS_DEFECTIVE")
        .setStatusTypeId("INV_NON_SER_STTS")
        .build();


    public final static StatusItemData StatusItem_INV_NS_RETURNED = StatusItemData.newBuilder()
        .setDescription("Returned (Non-Serialized)")
        .setSequenceId("02")
        .setStatusCode("RETURNED_NS")
        .setStatusId("INV_NS_RETURNED")
        .setStatusTypeId("INV_NON_SER_STTS")
        .build();


    public final static StatusItemData StatusItem_IXF_REQUESTED = StatusItemData.newBuilder()
        .setDescription("Requested")
        .setSequenceId("01")
        .setStatusCode("REQUESTED")
        .setStatusId("IXF_REQUESTED")
        .setStatusTypeId("INVENTORY_XFER_STTS")
        .build();


    public final static StatusItemData StatusItem_IXF_SCHEDULED = StatusItemData.newBuilder()
        .setDescription("Scheduled")
        .setSequenceId("02")
        .setStatusCode("SCHEDULED")
        .setStatusId("IXF_SCHEDULED")
        .setStatusTypeId("INVENTORY_XFER_STTS")
        .build();


    public final static StatusItemData StatusItem_IXF_EN_ROUTE = StatusItemData.newBuilder()
        .setDescription("En-Route")
        .setSequenceId("03")
        .setStatusCode("EN_ROUTE")
        .setStatusId("IXF_EN_ROUTE")
        .setStatusTypeId("INVENTORY_XFER_STTS")
        .build();


    public final static StatusItemData StatusItem_IXF_COMPLETE = StatusItemData.newBuilder()
        .setDescription("Complete")
        .setSequenceId("04")
        .setStatusCode("COMPLETE")
        .setStatusId("IXF_COMPLETE")
        .setStatusTypeId("INVENTORY_XFER_STTS")
        .build();


    public final static StatusItemData StatusItem_IXF_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("IXF_CANCELLED")
        .setStatusTypeId("INVENTORY_XFER_STTS")
        .build();


    public final static StatusItemData StatusItem_PRR_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending")
        .setSequenceId("01")
        .setStatusCode("PENDING")
        .setStatusId("PRR_PENDING")
        .setStatusTypeId("PRODUCT_REVIEW_STTS")
        .build();


    public final static StatusItemData StatusItem_PRR_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("PRR_APPROVED")
        .setStatusTypeId("PRODUCT_REVIEW_STTS")
        .build();


    public final static StatusItemData StatusItem_PRR_DELETED = StatusItemData.newBuilder()
        .setDescription("Deleted")
        .setSequenceId("99")
        .setStatusCode("DELETED")
        .setStatusId("PRR_DELETED")
        .setStatusTypeId("PRODUCT_REVIEW_STTS")
        .build();


    public final static StatusItemData StatusItem_IM_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending")
        .setSequenceId("01")
        .setStatusCode("PENDING")
        .setStatusId("IM_PENDING")
        .setStatusTypeId("IMAGE_MANAGEMENT_ST")
        .build();


    public final static StatusItemData StatusItem_IM_APPROVED = StatusItemData.newBuilder()
        .setDescription("Approved")
        .setSequenceId("02")
        .setStatusCode("APPROVED")
        .setStatusId("IM_APPROVED")
        .setStatusTypeId("IMAGE_MANAGEMENT_ST")
        .build();


    public final static StatusItemData StatusItem_IM_REJECTED = StatusItemData.newBuilder()
        .setDescription("Rejected")
        .setSequenceId("03")
        .setStatusCode("REJECTED")
        .setStatusId("IM_REJECTED")
        .setStatusTypeId("IMAGE_MANAGEMENT_ST")
        .build();


    public final static StatusItemData StatusItem_GO_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("GO_CREATED")
        .setStatusTypeId("GROUP_ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_GO_SUCCESS = StatusItemData.newBuilder()
        .setDescription("Success")
        .setSequenceId("02")
        .setStatusCode("SUCCESS")
        .setStatusId("GO_SUCCESS")
        .setStatusTypeId("GROUP_ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_GO_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("03")
        .setStatusCode("CANCELLED")
        .setStatusId("GO_CANCELLED")
        .setStatusTypeId("GROUP_ORDER_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHIPMENT_INPUT = StatusItemData.newBuilder()
        .setDescription("Input")
        .setSequenceId("01")
        .setStatusCode("INPUT")
        .setStatusId("SHIPMENT_INPUT")
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHIPMENT_SCHEDULED = StatusItemData.newBuilder()
        .setDescription("Scheduled")
        .setSequenceId("02")
        .setStatusCode("SCHEDULED")
        .setStatusId("SHIPMENT_SCHEDULED")
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHIPMENT_PICKED = StatusItemData.newBuilder()
        .setDescription("Picked")
        .setSequenceId("03")
        .setStatusCode("PICKED")
        .setStatusId("SHIPMENT_PICKED")
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHIPMENT_PACKED = StatusItemData.newBuilder()
        .setDescription("Packed")
        .setSequenceId("04")
        .setStatusCode("PACKED")
        .setStatusId("SHIPMENT_PACKED")
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHIPMENT_SHIPPED = StatusItemData.newBuilder()
        .setDescription("Shipped")
        .setSequenceId("05")
        .setStatusCode("SHIPPED")
        .setStatusId("SHIPMENT_SHIPPED")
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHIPMENT_DELIVERED = StatusItemData.newBuilder()
        .setDescription("Delivered")
        .setSequenceId("06")
        .setStatusCode("DELIVERED")
        .setStatusId("SHIPMENT_DELIVERED")
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHIPMENT_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("SHIPMENT_CANCELLED")
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusItemData StatusItem_PURCH_SHIP_CREATED = StatusItemData.newBuilder()
        .setDescription("Created")
        .setSequenceId("01")
        .setStatusCode("CREATED")
        .setStatusId("PURCH_SHIP_CREATED")
        .setStatusTypeId("PURCH_SHIP_STATUS")
        .build();


    public final static StatusItemData StatusItem_PURCH_SHIP_SHIPPED = StatusItemData.newBuilder()
        .setDescription("Shipped")
        .setSequenceId("02")
        .setStatusCode("SHIPPED")
        .setStatusId("PURCH_SHIP_SHIPPED")
        .setStatusTypeId("PURCH_SHIP_STATUS")
        .build();


    public final static StatusItemData StatusItem_PURCH_SHIP_RECEIVED = StatusItemData.newBuilder()
        .setDescription("Received")
        .setSequenceId("03")
        .setStatusCode("RECEIVED")
        .setStatusId("PURCH_SHIP_RECEIVED")
        .setStatusTypeId("PURCH_SHIP_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHRSCS_NOT_STARTED = StatusItemData.newBuilder()
        .setDescription("Not Started")
        .setSequenceId("01")
        .setStatusCode("NOT_STARTED")
        .setStatusId("SHRSCS_NOT_STARTED")
        .setStatusTypeId("SHPRTSG_CS_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHRSCS_CONFIRMED = StatusItemData.newBuilder()
        .setDescription("Confirmed")
        .setSequenceId("02")
        .setStatusCode("CONFIRMED")
        .setStatusId("SHRSCS_CONFIRMED")
        .setStatusTypeId("SHPRTSG_CS_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHRSCS_ACCEPTED = StatusItemData.newBuilder()
        .setDescription("Accepted")
        .setSequenceId("03")
        .setStatusCode("ACCEPTED")
        .setStatusId("SHRSCS_ACCEPTED")
        .setStatusTypeId("SHPRTSG_CS_STATUS")
        .build();


    public final static StatusItemData StatusItem_SHRSCS_VOIDED = StatusItemData.newBuilder()
        .setDescription("Voided")
        .setSequenceId("08")
        .setStatusCode("VOIDED")
        .setStatusId("SHRSCS_VOIDED")
        .setStatusTypeId("SHPRTSG_CS_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKLIST_INPUT = StatusItemData.newBuilder()
        .setDescription("Input")
        .setSequenceId("01")
        .setStatusCode("INPUT")
        .setStatusId("PICKLIST_INPUT")
        .setStatusTypeId("PICKLIST_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKLIST_ASSIGNED = StatusItemData.newBuilder()
        .setDescription("Assigned")
        .setSequenceId("02")
        .setStatusCode("ASSIGNED")
        .setStatusId("PICKLIST_ASSIGNED")
        .setStatusTypeId("PICKLIST_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKLIST_PRINTED = StatusItemData.newBuilder()
        .setDescription("Printed")
        .setSequenceId("03")
        .setStatusCode("PRINTED")
        .setStatusId("PICKLIST_PRINTED")
        .setStatusTypeId("PICKLIST_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKLIST_PICKED = StatusItemData.newBuilder()
        .setDescription("Picked")
        .setSequenceId("10")
        .setStatusCode("PICKED")
        .setStatusId("PICKLIST_PICKED")
        .setStatusTypeId("PICKLIST_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKLIST_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("PICKLIST_CANCELLED")
        .setStatusTypeId("PICKLIST_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKITEM_PENDING = StatusItemData.newBuilder()
        .setDescription("Pending")
        .setSequenceId("01")
        .setStatusCode("PENDING")
        .setStatusId("PICKITEM_PENDING")
        .setStatusTypeId("PICKITEM_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKITEM_COMPLETED = StatusItemData.newBuilder()
        .setDescription("Completed")
        .setSequenceId("50")
        .setStatusCode("COMPLETED")
        .setStatusId("PICKITEM_COMPLETED")
        .setStatusTypeId("PICKITEM_STATUS")
        .build();


    public final static StatusItemData StatusItem_PICKITEM_CANCELLED = StatusItemData.newBuilder()
        .setDescription("Cancelled")
        .setSequenceId("99")
        .setStatusCode("CANCELLED")
        .setStatusId("PICKITEM_CANCELLED")
        .setStatusTypeId("PICKITEM_STATUS")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_ON_ORDER_INV_AVAILABLE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_ON_ORDER")
        .setStatusIdTo("INV_AVAILABLE")
        .setTransitionName("Order Arrived")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_AVAILABLE_INV_PROMISED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_AVAILABLE")
        .setStatusIdTo("INV_PROMISED")
        .setTransitionName("Promise")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_AVAILABLE_INV_ON_HOLD = StatusValidChangeData.newBuilder()
        .setStatusId("INV_AVAILABLE")
        .setStatusIdTo("INV_ON_HOLD")
        .setTransitionName("Hold")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_AVAILABLE_INV_DEFECTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_AVAILABLE")
        .setStatusIdTo("INV_DEFECTIVE")
        .setTransitionName("Mark As Defective")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_AVAILABLE_INV_BEING_TRANSFERED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_AVAILABLE")
        .setStatusIdTo("INV_BEING_TRANSFERED")
        .setTransitionName("Being Transfered")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_ON_HOLD_INV_AVAILABLE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_ON_HOLD")
        .setStatusIdTo("INV_AVAILABLE")
        .setTransitionName("Release Hold")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_ON_HOLD_INV_DEFECTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_ON_HOLD")
        .setStatusIdTo("INV_DEFECTIVE")
        .setTransitionName("Mark Held Defective")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_BEING_TRANSFERED_INV_AVAILABLE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_BEING_TRANSFERED")
        .setStatusIdTo("INV_AVAILABLE")
        .setTransitionName("Transfer Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_PROMISED_INV_AVAILABLE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_PROMISED")
        .setStatusIdTo("INV_AVAILABLE")
        .setTransitionName("Cancel Promise")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_PROMISED_INV_DELIVERED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_PROMISED")
        .setStatusIdTo("INV_DELIVERED")
        .setTransitionName("Deliver")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_PROMISED_INV_DEFECTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_PROMISED")
        .setStatusIdTo("INV_DEFECTIVE")
        .setTransitionName("Mark As Defective")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_PROMISED_INV_BEING_TRANS_PRM = StatusValidChangeData.newBuilder()
        .setStatusId("INV_PROMISED")
        .setStatusIdTo("INV_BEING_TRANS_PRM")
        .setTransitionName("Being Transfered (Promised)")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_BEING_TRANS_PRM_INV_PROMISED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_BEING_TRANS_PRM")
        .setStatusIdTo("INV_PROMISED")
        .setTransitionName("Transfer Complete (Promised)")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_DELIVERED_INV_RETURNED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_DELIVERED")
        .setStatusIdTo("INV_RETURNED")
        .setTransitionName("Return Status Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_RETURNED_INV_AVAILABLE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_RETURNED")
        .setStatusIdTo("INV_AVAILABLE")
        .setTransitionName("Make Return Available")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_RETURNED_INV_ON_HOLD = StatusValidChangeData.newBuilder()
        .setStatusId("INV_RETURNED")
        .setStatusIdTo("INV_ON_HOLD")
        .setTransitionName("Make Return Held")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_RETURNED_INV_DEFECTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_RETURNED")
        .setStatusIdTo("INV_DEFECTIVE")
        .setTransitionName("Mark Return Defective")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_DELIVERED_INV_ACTIVATED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_DELIVERED")
        .setStatusIdTo("INV_ACTIVATED")
        .setTransitionName("Activate")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_ACTIVATED_INV_DEACTIVATED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_ACTIVATED")
        .setStatusIdTo("INV_DEACTIVATED")
        .setTransitionName("Deactivate")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_ACTIVATED_INV_RETURNED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_ACTIVATED")
        .setStatusIdTo("INV_RETURNED")
        .setTransitionName("Return Status Pending")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_DEACTIVATED_INV_ON_HOLD = StatusValidChangeData.newBuilder()
        .setStatusId("INV_DEACTIVATED")
        .setStatusIdTo("INV_ON_HOLD")
        .setTransitionName("Hold Inactive")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_DEACTIVATED_INV_RETURNED = StatusValidChangeData.newBuilder()
        .setStatusId("INV_DEACTIVATED")
        .setStatusIdTo("INV_RETURNED")
        .setTransitionName("Return Inactive")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_NS_RETURNED_INV_NS_ON_HOLD = StatusValidChangeData.newBuilder()
        .setStatusId("INV_NS_RETURNED")
        .setStatusIdTo("INV_NS_ON_HOLD")
        .setTransitionName("Make Return Held")
        .build();


    public final static StatusValidChangeData StatusValidChange_INV_NS_RETURNED_INV_NS_DEFECTIVE = StatusValidChangeData.newBuilder()
        .setStatusId("INV_NS_RETURNED")
        .setStatusIdTo("INV_NS_DEFECTIVE")
        .setTransitionName("Mark Return Defective")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_REQUESTED_IXF_SCHEDULED = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_REQUESTED")
        .setStatusIdTo("IXF_SCHEDULED")
        .setTransitionName("Inventory Request Scheduled")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_REQUESTED_IXF_EN_ROUTE = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_REQUESTED")
        .setStatusIdTo("IXF_EN_ROUTE")
        .setTransitionName("Inventory Request In Route")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_REQUESTED_IXF_COMPLETE = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_REQUESTED")
        .setStatusIdTo("IXF_COMPLETE")
        .setTransitionName("Inventory Request Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_REQUESTED_IXF_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_REQUESTED")
        .setStatusIdTo("IXF_CANCELLED")
        .setTransitionName("Inventory Request Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_SCHEDULED_IXF_EN_ROUTE = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_SCHEDULED")
        .setStatusIdTo("IXF_EN_ROUTE")
        .setTransitionName("Scheduled Inventory In Route")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_SCHEDULED_IXF_COMPLETE = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_SCHEDULED")
        .setStatusIdTo("IXF_COMPLETE")
        .setTransitionName("Scheduled Inventory Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_SCHEDULED_IXF_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_SCHEDULED")
        .setStatusIdTo("IXF_CANCELLED")
        .setTransitionName("Scheduled Inventory Cancelled")
        .build();


    public final static StatusValidChangeData StatusValidChange_IXF_EN_ROUTE_IXF_COMPLETE = StatusValidChangeData.newBuilder()
        .setStatusId("IXF_EN_ROUTE")
        .setStatusIdTo("IXF_COMPLETE")
        .setTransitionName("In Route Transfer Completed")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRR_PENDING_PRR_APPROVED = StatusValidChangeData.newBuilder()
        .setStatusId("PRR_PENDING")
        .setStatusIdTo("PRR_APPROVED")
        .setTransitionName("Review Approved")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRR_PENDING_PRR_DELETED = StatusValidChangeData.newBuilder()
        .setStatusId("PRR_PENDING")
        .setStatusIdTo("PRR_DELETED")
        .setTransitionName("Review Deleted")
        .build();


    public final static StatusValidChangeData StatusValidChange_PRR_APPROVED_PRR_DELETED = StatusValidChangeData.newBuilder()
        .setStatusId("PRR_APPROVED")
        .setStatusIdTo("PRR_DELETED")
        .setTransitionName("Review Deleted")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_INPUT_SHIPMENT_SCHEDULED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_INPUT")
        .setStatusIdTo("SHIPMENT_SCHEDULED")
        .setTransitionName("Schedule")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_INPUT_SHIPMENT_PICKED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_INPUT")
        .setStatusIdTo("SHIPMENT_PICKED")
        .setTransitionName("Pick")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_INPUT_SHIPMENT_PACKED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_INPUT")
        .setStatusIdTo("SHIPMENT_PACKED")
        .setTransitionName("Pack")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_SCHEDULED_SHIPMENT_PICKED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_SCHEDULED")
        .setStatusIdTo("SHIPMENT_PICKED")
        .setTransitionName("Pick")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_SCHEDULED_SHIPMENT_PACKED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_SCHEDULED")
        .setStatusIdTo("SHIPMENT_PACKED")
        .setTransitionName("Pack")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_PICKED_SHIPMENT_PACKED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_PICKED")
        .setStatusIdTo("SHIPMENT_PACKED")
        .setTransitionName("Pack")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_PACKED_SHIPMENT_SHIPPED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_PACKED")
        .setStatusIdTo("SHIPMENT_SHIPPED")
        .setTransitionName("Ship")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_SHIPPED_SHIPMENT_DELIVERED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_SHIPPED")
        .setStatusIdTo("SHIPMENT_DELIVERED")
        .setTransitionName("Deliver")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_INPUT_SHIPMENT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_INPUT")
        .setStatusIdTo("SHIPMENT_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_SCHEDULED_SHIPMENT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_SCHEDULED")
        .setStatusIdTo("SHIPMENT_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHIPMENT_PICKED_SHIPMENT_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("SHIPMENT_PICKED")
        .setStatusIdTo("SHIPMENT_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_PURCH_SHIP_CREATED_PURCH_SHIP_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("PURCH_SHIP_CREATED")
        .setStatusIdTo("PURCH_SHIP_RECEIVED")
        .setTransitionName("Receive")
        .build();


    public final static StatusValidChangeData StatusValidChange_PURCH_SHIP_CREATED_PURCH_SHIP_SHIPPED = StatusValidChangeData.newBuilder()
        .setStatusId("PURCH_SHIP_CREATED")
        .setStatusIdTo("PURCH_SHIP_SHIPPED")
        .setTransitionName("Ship")
        .build();


    public final static StatusValidChangeData StatusValidChange_PURCH_SHIP_SHIPPED_PURCH_SHIP_RECEIVED = StatusValidChangeData.newBuilder()
        .setStatusId("PURCH_SHIP_SHIPPED")
        .setStatusIdTo("PURCH_SHIP_RECEIVED")
        .setTransitionName("Receive")
        .build();


    public final static StatusValidChangeData StatusValidChange_PURCH_SHIP_RECEIVED_PURCH_SHIP_SHIPPED = StatusValidChangeData.newBuilder()
        .setStatusId("PURCH_SHIP_RECEIVED")
        .setStatusIdTo("PURCH_SHIP_SHIPPED")
        .setTransitionName("Ship")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHRSCS_NOT_STARTED_SHRSCS_CONFIRMED = StatusValidChangeData.newBuilder()
        .setStatusId("SHRSCS_NOT_STARTED")
        .setStatusIdTo("SHRSCS_CONFIRMED")
        .setTransitionName("Confirm")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHRSCS_CONFIRMED_SHRSCS_ACCEPTED = StatusValidChangeData.newBuilder()
        .setStatusId("SHRSCS_CONFIRMED")
        .setStatusIdTo("SHRSCS_ACCEPTED")
        .setTransitionName("Accept")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHRSCS_CONFIRMED_SHRSCS_VOIDED = StatusValidChangeData.newBuilder()
        .setStatusId("SHRSCS_CONFIRMED")
        .setStatusIdTo("SHRSCS_VOIDED")
        .setTransitionName("Void")
        .build();


    public final static StatusValidChangeData StatusValidChange_SHRSCS_ACCEPTED_SHRSCS_VOIDED = StatusValidChangeData.newBuilder()
        .setStatusId("SHRSCS_ACCEPTED")
        .setStatusIdTo("SHRSCS_VOIDED")
        .setTransitionName("Void")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_INPUT_PICKLIST_ASSIGNED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_INPUT")
        .setStatusIdTo("PICKLIST_ASSIGNED")
        .setTransitionName("Assign")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_INPUT_PICKLIST_PRINTED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_INPUT")
        .setStatusIdTo("PICKLIST_PRINTED")
        .setTransitionName("Print")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_INPUT_PICKLIST_PICKED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_INPUT")
        .setStatusIdTo("PICKLIST_PICKED")
        .setTransitionName("Pick")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_INPUT_PICKLIST_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_INPUT")
        .setStatusIdTo("PICKLIST_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_ASSIGNED_PICKLIST_PICKED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_ASSIGNED")
        .setStatusIdTo("PICKLIST_PICKED")
        .setTransitionName("Pick")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_ASSIGNED_PICKLIST_PRINTED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_ASSIGNED")
        .setStatusIdTo("PICKLIST_PRINTED")
        .setTransitionName("Print")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_ASSIGNED_PICKLIST_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_ASSIGNED")
        .setStatusIdTo("PICKLIST_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_PRINTED_PICKLIST_PICKED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_PRINTED")
        .setStatusIdTo("PICKLIST_PICKED")
        .setTransitionName("Pick")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKLIST_PRINTED_PICKLIST_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKLIST_PRINTED")
        .setStatusIdTo("PICKLIST_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKITEM_PENDING_PICKITEM_COMPLETED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKITEM_PENDING")
        .setStatusIdTo("PICKITEM_COMPLETED")
        .setTransitionName("Complete")
        .build();


    public final static StatusValidChangeData StatusValidChange_PICKITEM_PENDING_PICKITEM_CANCELLED = StatusValidChangeData.newBuilder()
        .setStatusId("PICKITEM_PENDING")
        .setStatusIdTo("PICKITEM_CANCELLED")
        .setTransitionName("Cancel")
        .build();


    public final static QuantityBreakTypeData QuantityBreakType_SHIP_WEIGHT = QuantityBreakTypeData.newBuilder()
        .setDescription("Shipping Weight Break")
        .setQuantityBreakTypeId("SHIP_WEIGHT")
        .build();


    public final static QuantityBreakTypeData QuantityBreakType_SHIP_QUANTITY = QuantityBreakTypeData.newBuilder()
        .setDescription("Shipping Quantity Break")
        .setQuantityBreakTypeId("SHIP_QUANTITY")
        .build();


    public final static QuantityBreakTypeData QuantityBreakType_SHIP_PRICE = QuantityBreakTypeData.newBuilder()
        .setDescription("Shipping Price Break")
        .setQuantityBreakTypeId("SHIP_PRICE")
        .build();


    public final static QuantityBreakTypeData QuantityBreakType_QUANTITY = QuantityBreakTypeData.newBuilder()
        .setDescription("Price Component Quantity Break")
        .setQuantityBreakTypeId("QUANTITY")
        .build();


    public final static QuantityBreakTypeData QuantityBreakType_ORDER_VALUE = QuantityBreakTypeData.newBuilder()
        .setDescription("Price Component Order Value Break")
        .setQuantityBreakTypeId("ORDER_VALUE")
        .build();


    public final static FacilityAssocTypeData FacilityAssocType_BACKUP_WAREHOUSE = FacilityAssocTypeData.newBuilder()
        .setDescription("Facility that serves another facility in terms of inventory")
        .setFacilityAssocTypeId("BACKUP_WAREHOUSE")
        .build();


    public final static SubscriptionTypeData SubscriptionType_PRODUCT_SUBSCR = SubscriptionTypeData.newBuilder()
        .setDescription("Product")
        .setHasTable(castIndicator("N"))
        .setSubscriptionTypeId("PRODUCT_SUBSCR")
        .build();


    public final static ShipmentTypeData ShipmentType_INCOMING_SHIPMENT = ShipmentTypeData.newBuilder()
        .setDescription("Incoming")
        .setHasTable(castIndicator("N"))
        .setShipmentTypeId("INCOMING_SHIPMENT")
        .build();


    public final static ShipmentTypeData ShipmentType_OUTGOING_SHIPMENT = ShipmentTypeData.newBuilder()
        .setDescription("Outgoing")
        .setHasTable(castIndicator("N"))
        .setShipmentTypeId("OUTGOING_SHIPMENT")
        .build();


    public final static ShipmentTypeData ShipmentType_SALES_RETURN = ShipmentTypeData.newBuilder()
        .setDescription("Sales Return")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INCOMING_SHIPMENT")
        .setShipmentTypeId("SALES_RETURN")
        .build();


    public final static ShipmentTypeData ShipmentType_SALES_SHIPMENT = ShipmentTypeData.newBuilder()
        .setDescription("Sales Shipment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OUTGOING_SHIPMENT")
        .setShipmentTypeId("SALES_SHIPMENT")
        .build();


    public final static ShipmentTypeData ShipmentType_PURCHASE_SHIPMENT = ShipmentTypeData.newBuilder()
        .setDescription("Purchase Shipment")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INCOMING_SHIPMENT")
        .setShipmentTypeId("PURCHASE_SHIPMENT")
        .build();


    public final static ShipmentTypeData ShipmentType_PURCHASE_RETURN = ShipmentTypeData.newBuilder()
        .setDescription("Purchase Return")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OUTGOING_SHIPMENT")
        .setShipmentTypeId("PURCHASE_RETURN")
        .build();


    public final static ShipmentTypeData ShipmentType_DROP_SHIPMENT = ShipmentTypeData.newBuilder()
        .setDescription("Drop Shipment")
        .setHasTable(castIndicator("N"))
        .setShipmentTypeId("DROP_SHIPMENT")
        .build();


    public final static ShipmentTypeData ShipmentType_TRANSFER = ShipmentTypeData.newBuilder()
        .setDescription("Transfer")
        .setHasTable(castIndicator("N"))
        .setShipmentTypeId("TRANSFER")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_CATEGORY_NAME = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Category Name")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("CATEGORY_NAME")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_DESCRIPTION = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Description")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("DESCRIPTION")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_LONG_DESCRIPTION = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Description - Long")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("LONG_DESCRIPTION")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_ALTERNATIVE_URL = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Alternative URL")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("ALTERNATIVE_URL")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_CATEGORY_IMAGE = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Category Image")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("CATEGORY_IMAGE")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_CATEGORY_IMAGE_URL = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Category Image URL")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("CATEGORY_IMAGE_URL")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_CATEGORY_IMAGE_ALT = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Category Image Alt Text")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("CATEGORY_IMAGE_ALT")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_LINK1_ALT_TEXT = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Link 1 Alt Text")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("LINK1_ALT_TEXT")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_LINK2_ALT_TEXT = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Link 2 Alt Text")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("LINK2_ALT_TEXT")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_FOOTER = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Footer")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("FOOTER")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_PAGE_TITLE = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Page Title")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("PAGE_TITLE")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_META_KEYWORD = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Meta Keyword")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("META_KEYWORD")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_META_DESCRIPTION = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Meta Description")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("META_DESCRIPTION")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_RELATED_URL = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Related URL")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("RELATED_URL")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_VIDEO = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Video")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("VIDEO")
        .build();


    public final static ProductCategoryContentTypeData ProductCategoryContentType_VIDEO_URL = ProductCategoryContentTypeData.newBuilder()
        .setDescription("Video URL")
        .setHasTable(castIndicator("N"))
        .setProdCatContentTypeId("VIDEO_URL")
        .build();


    public final static ProductFeatureCategoryData ProductFeatureCategory_IMAGE = ProductFeatureCategoryData.newBuilder()
        .setDescription("Image")
        .setProductFeatureCategoryId("IMAGE")
        .build();


    public final static ProductFeatureCategoryData ProductFeatureCategory_TEXT = ProductFeatureCategoryData.newBuilder()
        .setDescription("Text")
        .setProductFeatureCategoryId("TEXT")
        .build();


    public final static ProductFeatureApplTypeData ProductFeatureApplType_OPTIONAL_FEATURE = ProductFeatureApplTypeData.newBuilder()
        .setDescription("Optional")
        .setHasTable(castIndicator("N"))
        .setProductFeatureApplTypeId("OPTIONAL_FEATURE")
        .build();


    public final static ProductFeatureApplTypeData ProductFeatureApplType_REQUIRED_FEATURE = ProductFeatureApplTypeData.newBuilder()
        .setDescription("Required")
        .setHasTable(castIndicator("N"))
        .setProductFeatureApplTypeId("REQUIRED_FEATURE")
        .build();


    public final static ProductFeatureApplTypeData ProductFeatureApplType_SELECTABLE_FEATURE = ProductFeatureApplTypeData.newBuilder()
        .setDescription("Selectable")
        .setHasTable(castIndicator("N"))
        .setProductFeatureApplTypeId("SELECTABLE_FEATURE")
        .build();


    public final static ProductFeatureApplTypeData ProductFeatureApplType_STANDARD_FEATURE = ProductFeatureApplTypeData.newBuilder()
        .setDescription("Standard")
        .setHasTable(castIndicator("N"))
        .setProductFeatureApplTypeId("STANDARD_FEATURE")
        .build();


    public final static ProductFeatureApplTypeData ProductFeatureApplType_DISTINGUISHING_FEAT = ProductFeatureApplTypeData.newBuilder()
        .setDescription("Distinguishing")
        .setHasTable(castIndicator("N"))
        .setProductFeatureApplTypeId("DISTINGUISHING_FEAT")
        .build();


    public final static ProductPricePurposeData ProductPricePurpose_DEPOSIT = ProductPricePurposeData.newBuilder()
        .setDescription("Deposit price")
        .setProductPricePurposeId("DEPOSIT")
        .build();


    public final static ProductPricePurposeData ProductPricePurpose_PURCHASE = ProductPricePurposeData.newBuilder()
        .setDescription("Purchase/Initial")
        .setProductPricePurposeId("PURCHASE")
        .build();


    public final static ProductPricePurposeData ProductPricePurpose_RECURRING_CHARGE = ProductPricePurposeData.newBuilder()
        .setDescription("Recurring Charge")
        .setProductPricePurposeId("RECURRING_CHARGE")
        .build();


    public final static ProductPricePurposeData ProductPricePurpose_USAGE_CHARGE = ProductPricePurposeData.newBuilder()
        .setDescription("Usage Charge")
        .setProductPricePurposeId("USAGE_CHARGE")
        .build();


    public final static ProductPricePurposeData ProductPricePurpose_COMPONENT_PRICE = ProductPricePurposeData.newBuilder()
        .setDescription("Component Price")
        .setProductPricePurposeId("COMPONENT_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_LIST_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("List Price")
        .setProductPriceTypeId("LIST_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_DEFAULT_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Default Price")
        .setProductPriceTypeId("DEFAULT_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_AVERAGE_COST = ProductPriceTypeData.newBuilder()
        .setDescription("Average Cost")
        .setProductPriceTypeId("AVERAGE_COST")
        .build();


    public final static ProductPriceTypeData ProductPriceType_MINIMUM_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Minimum Price")
        .setProductPriceTypeId("MINIMUM_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_MAXIMUM_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Maximum Price")
        .setProductPriceTypeId("MAXIMUM_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_PROMO_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Promotional Price")
        .setProductPriceTypeId("PROMO_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_COMPETITIVE_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Competitive Price")
        .setProductPriceTypeId("COMPETITIVE_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_WHOLESALE_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Wholesale Price")
        .setProductPriceTypeId("WHOLESALE_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_SPECIAL_PROMO_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Special Promo Price")
        .setProductPriceTypeId("SPECIAL_PROMO_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_BOX_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Box Price")
        .setProductPriceTypeId("BOX_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_MINIMUM_ORDER_PRICE = ProductPriceTypeData.newBuilder()
        .setDescription("Minimum Order Price")
        .setProductPriceTypeId("MINIMUM_ORDER_PRICE")
        .build();


    public final static ProductPriceTypeData ProductPriceType_SHIPPING_ALLOWANCE = ProductPriceTypeData.newBuilder()
        .setDescription("Shipping Allowance Price")
        .setProductPriceTypeId("SHIPPING_ALLOWANCE")
        .build();


    public final static ShipmentGatewayDhlData ShipmentGatewayDhl_DHL_CONFIG = ShipmentGatewayDhlData.newBuilder()
        .setAccessAccountNbr("YOUR DHL ShipIT ACCOUNT NUMBER")
        .setAccessPassword("YOUR DHL ShipIT ACCESS PASSWORD")
        .setAccessShippingKey("YOUR DHL ShipIT SHIPPING KEY")
        .setAccessUserId("YOUR DHL ShipIT USER ID")
        .setConnectTimeout(60)
        .setConnectUrl("https://eCommerce.airborne.com/ApiLandingTest.asp")
        .setHeadAction("Request")
        .setHeadVersion("1.1")
        .setLabelImageFormat("PNG")
        .setRateEstimateTemplate("api.schema.DHL")
        .setShipmentGatewayConfigId("DHL_CONFIG")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_POL = ProductPriceActionTypeData.newBuilder()
        .setDescription("Percent Of List Price")
        .setProductPriceActionTypeId("PRICE_POL")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_POD = ProductPriceActionTypeData.newBuilder()
        .setDescription("Percent Of Default Price")
        .setProductPriceActionTypeId("PRICE_POD")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_POAC = ProductPriceActionTypeData.newBuilder()
        .setDescription("Percent Of Average Cost")
        .setProductPriceActionTypeId("PRICE_POAC")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_POM = ProductPriceActionTypeData.newBuilder()
        .setDescription("Percent Of Margin")
        .setProductPriceActionTypeId("PRICE_POM")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_POWHS = ProductPriceActionTypeData.newBuilder()
        .setDescription("Percent Of Wholesale")
        .setProductPriceActionTypeId("PRICE_POWHS")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_FOL = ProductPriceActionTypeData.newBuilder()
        .setDescription("Flat Amount Modify")
        .setProductPriceActionTypeId("PRICE_FOL")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_FLAT = ProductPriceActionTypeData.newBuilder()
        .setDescription("Flat Amount Override")
        .setProductPriceActionTypeId("PRICE_FLAT")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_PFLAT = ProductPriceActionTypeData.newBuilder()
        .setDescription("Promo Amount Override")
        .setProductPriceActionTypeId("PRICE_PFLAT")
        .build();


    public final static ProductPriceActionTypeData ProductPriceActionType_PRICE_WFLAT = ProductPriceActionTypeData.newBuilder()
        .setDescription("Wholesale Amount Override")
        .setProductPriceActionTypeId("PRICE_WFLAT")
        .build();


    public final static ShipmentGatewayFedexData ShipmentGatewayFedex_FEDEX_CONFIG = ShipmentGatewayFedexData.newBuilder()
        .setConnectSoapUrl("https://gatewaybeta.fedex.com:443/web-services")
        .setConnectTimeout(60)
        .setConnectUrl("https://gatewaybeta.fedex.com/GatewayDC")
        .setDefaultDropoffType("REGULARPICKUP")
        .setDefaultPackagingType("YOURPACKNG")
        .setLabelImageType("PNG")
        .setRateEstimateTemplate("component://product/template/shipment/FedexRateEstimateRequestTemplate.xml.ftl")
        .setShipmentGatewayConfigId("FEDEX_CONFIG")
        .setTemplateShipment("component://product/template/shipment/FedexShipRequestTemplate.xml.ftl")
        .setTemplateSubscription("component://product/template/shipment/FedexSubscriptionRequestTemplate.xml.ftl")
        .build();


    public final static EnumerationData Enumeration_PRIP_PRODUCT_ID = EnumerationData.newBuilder()
        .setDescription("Product")
        .setEnumCode("PRODUCT_ID")
        .setEnumId("PRIP_PRODUCT_ID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PRIP_PROD_CAT_ID = EnumerationData.newBuilder()
        .setDescription("Product Category")
        .setEnumCode("PRODUCT_CATEGORY_ID")
        .setEnumId("PRIP_PROD_CAT_ID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRIP_PROD_CLG_ID = EnumerationData.newBuilder()
        .setDescription("Product Catalog")
        .setEnumCode("PROD_CATALOG_ID")
        .setEnumId("PRIP_PROD_CLG_ID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PRIP_PROD_FEAT_ID = EnumerationData.newBuilder()
        .setDescription("Product Feature")
        .setEnumCode("PRODUCT_FEATURE_ID")
        .setEnumId("PRIP_PROD_FEAT_ID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PRIP_PROD_SGRP_ID = EnumerationData.newBuilder()
        .setDescription("Product Store Group")
        .setEnumCode("PROD_STORE_GRP_ID")
        .setEnumId("PRIP_PROD_SGRP_ID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PRIP_WEBSITE_ID = EnumerationData.newBuilder()
        .setDescription("Website")
        .setEnumCode("WEBSITE_ID")
        .setEnumId("PRIP_WEBSITE_ID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PRIP_QUANTITY = EnumerationData.newBuilder()
        .setDescription("Quantity")
        .setEnumCode("QUANTITY")
        .setEnumId("PRIP_QUANTITY")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_PRIP_PARTY_ID = EnumerationData.newBuilder()
        .setDescription("Party")
        .setEnumCode("PARTY_ID")
        .setEnumId("PRIP_PARTY_ID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("08")
        .build();


    public final static EnumerationData Enumeration_PRIP_PARTY_GRP_MEM = EnumerationData.newBuilder()
        .setDescription("Party Group Member")
        .setEnumCode("PARTY_GROUP_MEMBER")
        .setEnumId("PRIP_PARTY_GRP_MEM")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("09")
        .build();


    public final static EnumerationData Enumeration_PRIP_PARTY_CLASS = EnumerationData.newBuilder()
        .setDescription("Party Classification")
        .setEnumCode("PARTY_CLASS")
        .setEnumId("PRIP_PARTY_CLASS")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("10")
        .build();


    public final static EnumerationData Enumeration_PRIP_ROLE_TYPE = EnumerationData.newBuilder()
        .setDescription("Role Type")
        .setEnumCode("ROLE_TYPE")
        .setEnumId("PRIP_ROLE_TYPE")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("11")
        .build();


    public final static EnumerationData Enumeration_PRIP_LIST_PRICE = EnumerationData.newBuilder()
        .setDescription("List Price")
        .setEnumCode("LIST_PRICE")
        .setEnumId("PRIP_LIST_PRICE")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("12")
        .build();


    public final static EnumerationData Enumeration_PRIP_CURRENCY_UOMID = EnumerationData.newBuilder()
        .setDescription("Currency UomId")
        .setEnumCode("CURRENCY_UOMID")
        .setEnumId("PRIP_CURRENCY_UOMID")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setSequenceId("13")
        .build();


    public final static EnumerationData Enumeration_PRC_EQ = EnumerationData.newBuilder()
        .setDescription("Is")
        .setEnumCode("EQ")
        .setEnumId("PRC_EQ")
        .setEnumTypeId("PROD_PRICE_COND")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PRC_NEQ = EnumerationData.newBuilder()
        .setDescription("Is Not")
        .setEnumCode("NEQ")
        .setEnumId("PRC_NEQ")
        .setEnumTypeId("PROD_PRICE_COND")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRC_LT = EnumerationData.newBuilder()
        .setDescription("Is Less Than")
        .setEnumCode("LT")
        .setEnumId("PRC_LT")
        .setEnumTypeId("PROD_PRICE_COND")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PRC_LTE = EnumerationData.newBuilder()
        .setDescription("Is Less Than or Equal To")
        .setEnumCode("LTE")
        .setEnumId("PRC_LTE")
        .setEnumTypeId("PROD_PRICE_COND")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PRC_GT = EnumerationData.newBuilder()
        .setDescription("Is Greater Than")
        .setEnumCode("GT")
        .setEnumId("PRC_GT")
        .setEnumTypeId("PROD_PRICE_COND")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PRC_GTE = EnumerationData.newBuilder()
        .setDescription("Is Greater Than or Equal To")
        .setEnumCode("GTE")
        .setEnumId("PRC_GTE")
        .setEnumTypeId("PROD_PRICE_COND")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_INVRO_FIFO_REC = EnumerationData.newBuilder()
        .setDescription("FIFO Received")
        .setEnumCode("FIFO_REC")
        .setEnumId("INVRO_FIFO_REC")
        .setEnumTypeId("INV_RES_ORDER")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_INVRO_LIFO_REC = EnumerationData.newBuilder()
        .setDescription("LIFO Received")
        .setEnumCode("LIFO_REC")
        .setEnumId("INVRO_LIFO_REC")
        .setEnumTypeId("INV_RES_ORDER")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_INVRO_FIFO_EXP = EnumerationData.newBuilder()
        .setDescription("FIFO Expire")
        .setEnumCode("FIFO_EXP")
        .setEnumId("INVRO_FIFO_EXP")
        .setEnumTypeId("INV_RES_ORDER")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_INVRO_LIFO_EXP = EnumerationData.newBuilder()
        .setDescription("LIFO Expire")
        .setEnumCode("LIFO_EXP")
        .setEnumId("INVRO_LIFO_EXP")
        .setEnumTypeId("INV_RES_ORDER")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_INVRO_GUNIT_COST = EnumerationData.newBuilder()
        .setDescription("Greater Unit Cost")
        .setEnumCode("GUNIT_COST")
        .setEnumId("INVRO_GUNIT_COST")
        .setEnumTypeId("INV_RES_ORDER")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_INVRO_LUNIT_COST = EnumerationData.newBuilder()
        .setDescription("Less Unit Cost")
        .setEnumCode("LUNIT_COST")
        .setEnumId("INVRO_LUNIT_COST")
        .setEnumTypeId("INV_RES_ORDER")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_VAR_LOST = EnumerationData.newBuilder()
        .setDescription("Lost")
        .setEnumCode("VAR_LOST")
        .setEnumId("VAR_LOST")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_VAR_STOLEN = EnumerationData.newBuilder()
        .setDescription("Stolen")
        .setEnumCode("VAR_STOLEN")
        .setEnumId("VAR_STOLEN")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_VAR_FOUND = EnumerationData.newBuilder()
        .setDescription("Found")
        .setEnumCode("VAR_FOUND")
        .setEnumId("VAR_FOUND")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_VAR_DAMAGED = EnumerationData.newBuilder()
        .setDescription("Damaged")
        .setEnumCode("VAR_DAMAGED")
        .setEnumId("VAR_DAMAGED")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_VAR_SAMPLE = EnumerationData.newBuilder()
        .setDescription("Sample (Giveaway)")
        .setEnumCode("VAR_SAMPLE")
        .setEnumId("VAR_SAMPLE")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_VAR_INTEGR = EnumerationData.newBuilder()
        .setDescription("Integration")
        .setEnumCode("VAR_INTEGR")
        .setEnumId("VAR_INTEGR")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_VAR_MISSHIP_ORDERED = EnumerationData.newBuilder()
        .setDescription("Mis-shipped Item Ordered (+)")
        .setEnumCode("VAR_MISSHIP_ORDERED")
        .setEnumId("VAR_MISSHIP_ORDERED")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_VAR_MISSHIP_SHIPPED = EnumerationData.newBuilder()
        .setDescription("Mis-shipped Item Shipped (-)")
        .setEnumCode("VAR_MISSHIP_SHIPPED")
        .setEnumId("VAR_MISSHIP_SHIPPED")
        .setEnumTypeId("IID_REASON")
        .setSequenceId("08")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_AUTH = EnumerationData.newBuilder()
        .setDescription("Payment Authorization Service")
        .setEnumCode("PAY_AUTH")
        .setEnumId("PRDS_PAY_AUTH")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_AUTH_VERIFY = EnumerationData.newBuilder()
        .setDescription("Payment Auth Verification Service")
        .setEnumCode("PAY_AUTH_VERIFY")
        .setEnumId("PRDS_PAY_AUTH_VERIFY")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_REAUTH = EnumerationData.newBuilder()
        .setDescription("Payment Re-Authorization Service")
        .setEnumCode("PAY_REAUTH")
        .setEnumId("PRDS_PAY_REAUTH")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_RELEASE = EnumerationData.newBuilder()
        .setDescription("Payment Release Authorization Service")
        .setEnumCode("PAY_RELEASE")
        .setEnumId("PRDS_PAY_RELEASE")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_CAPTURE = EnumerationData.newBuilder()
        .setDescription("Payment Capture Service")
        .setEnumCode("PAY_CAPTURE")
        .setEnumId("PRDS_PAY_CAPTURE")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_REFUND = EnumerationData.newBuilder()
        .setDescription("Payment Refund Service")
        .setEnumCode("PAY_REFUND")
        .setEnumId("PRDS_PAY_REFUND")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_CREDIT = EnumerationData.newBuilder()
        .setDescription("Payment Credit Service")
        .setEnumCode("PAY_CREDIT")
        .setEnumId("PRDS_PAY_CREDIT")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PRDS_PAY_EXTERNAL = EnumerationData.newBuilder()
        .setDescription("External Payment (No Service)")
        .setEnumCode("PAY_EXTERNAL")
        .setEnumId("PRDS_PAY_EXTERNAL")
        .setEnumTypeId("PRDS_PAYSVC")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_PRDS_CUST_REGISTER = EnumerationData.newBuilder()
        .setDescription("Registration")
        .setEnumCode("CUST_REGISTER")
        .setEnumId("PRDS_CUST_REGISTER")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PRDS_ODR_CONFIRM = EnumerationData.newBuilder()
        .setDescription("Confirmation")
        .setEnumCode("ODR_CONFIRM")
        .setEnumId("PRDS_ODR_CONFIRM")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRDS_ODR_COMPLETE = EnumerationData.newBuilder()
        .setDescription("Complete")
        .setEnumCode("ODR_COMPLETE")
        .setEnumId("PRDS_ODR_COMPLETE")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PRDS_ODR_BACKORDER = EnumerationData.newBuilder()
        .setDescription("Back-Order")
        .setEnumCode("ODR_BACKORDER")
        .setEnumId("PRDS_ODR_BACKORDER")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PRDS_ODR_CHANGE = EnumerationData.newBuilder()
        .setDescription("Order Change")
        .setEnumCode("ODR_CHANGE")
        .setEnumId("PRDS_ODR_CHANGE")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PRDS_ODR_PAYRETRY = EnumerationData.newBuilder()
        .setDescription("Payment Retry")
        .setEnumCode("ODR_PAYRETRY")
        .setEnumId("PRDS_ODR_PAYRETRY")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PRDS_RTN_ACCEPT = EnumerationData.newBuilder()
        .setDescription("Return Accepted")
        .setEnumCode("RTN_ACCEPT")
        .setEnumId("PRDS_RTN_ACCEPT")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_PRDS_RTN_COMPLETE = EnumerationData.newBuilder()
        .setDescription("Return Completed")
        .setEnumCode("RTN_COMPLETE")
        .setEnumId("PRDS_RTN_COMPLETE")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("08")
        .build();


    public final static EnumerationData Enumeration_PRDS_RTN_CANCEL = EnumerationData.newBuilder()
        .setDescription("Return Cancelled")
        .setEnumCode("RTN_CANCEL")
        .setEnumId("PRDS_RTN_CANCEL")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("09")
        .build();


    public final static EnumerationData Enumeration_PRDS_PWD_RETRIEVE = EnumerationData.newBuilder()
        .setDescription("Retrieve Password")
        .setEnumCode("PWD_RETRIEVE")
        .setEnumId("PRDS_PWD_RETRIEVE")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("10")
        .build();


    public final static EnumerationData Enumeration_PRDS_TELL_FRIEND = EnumerationData.newBuilder()
        .setDescription("Tell-A-Friend")
        .setEnumCode("TELL_FRIEND")
        .setEnumId("PRDS_TELL_FRIEND")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("11")
        .build();


    public final static EnumerationData Enumeration_PRDS_GC_PURCHASE = EnumerationData.newBuilder()
        .setDescription("Gift-Card Purchase")
        .setEnumCode("GC_PURCHASE")
        .setEnumId("PRDS_GC_PURCHASE")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("12")
        .build();


    public final static EnumerationData Enumeration_PRDS_GC_RELOAD = EnumerationData.newBuilder()
        .setDescription("Gift-Card Reload")
        .setEnumCode("GC_RELOAD")
        .setEnumId("PRDS_GC_RELOAD")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("13")
        .build();


    public final static EnumerationData Enumeration_PRDS_QUO_CREATED = EnumerationData.newBuilder()
        .setDescription("Quote Created")
        .setEnumCode("QUO_CREATED")
        .setEnumId("PRDS_QUO_CREATED")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("14")
        .build();


    public final static EnumerationData Enumeration_PRDS_QUO_CONFIRM = EnumerationData.newBuilder()
        .setDescription("Quote Confirmation")
        .setEnumCode("QUO_CONFIRM")
        .setEnumId("PRDS_QUO_CONFIRM")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("15")
        .build();


    public final static EnumerationData Enumeration_PRDS_ODR_SHIP_COMPLT = EnumerationData.newBuilder()
        .setDescription("Shipment Complete")
        .setEnumCode("SHP_COMPLETE")
        .setEnumId("PRDS_ODR_SHIP_COMPLT")
        .setEnumTypeId("PRDS_EMAIL")
        .setSequenceId("16")
        .build();


    public final static EnumerationData Enumeration_FLT_PICKLOC = EnumerationData.newBuilder()
        .setDescription("Pick/Primary")
        .setEnumCode("PICKLOC")
        .setEnumId("FLT_PICKLOC")
        .setEnumTypeId("FACLOC_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_FLT_BULK = EnumerationData.newBuilder()
        .setDescription("Bulk")
        .setEnumCode("BULK")
        .setEnumId("FLT_BULK")
        .setEnumTypeId("FACLOC_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_KOTT_PRODCAT = EnumerationData.newBuilder()
        .setDescription("Product Category")
        .setEnumCode("PRODCAT")
        .setEnumId("KOTT_PRODCAT")
        .setEnumTypeId("KWOVRD_TRGT_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_KOTT_PRODUCT = EnumerationData.newBuilder()
        .setDescription("Product")
        .setEnumCode("PRODUCT")
        .setEnumId("KOTT_PRODUCT")
        .setEnumTypeId("KWOVRD_TRGT_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_KOTT_OFBURL = EnumerationData.newBuilder()
        .setDescription("OFBiz URL")
        .setEnumCode("OFBURL")
        .setEnumId("KOTT_OFBURL")
        .setEnumTypeId("KWOVRD_TRGT_TYPE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_KOTT_AURL = EnumerationData.newBuilder()
        .setDescription("Absolute URL")
        .setEnumCode("AURL")
        .setEnumId("KOTT_AURL")
        .setEnumTypeId("KWOVRD_TRGT_TYPE")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PCLT_SEARCH_PARAM = EnumerationData.newBuilder()
        .setDescription("Search Parameters")
        .setEnumCode("SEARCH_PARAM")
        .setEnumId("PCLT_SEARCH_PARAM")
        .setEnumTypeId("PCAT_LINK_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PCLT_ABS_URL = EnumerationData.newBuilder()
        .setDescription("Absolute URL")
        .setEnumCode("ABS_URL")
        .setEnumId("PCLT_ABS_URL")
        .setEnumTypeId("PCAT_LINK_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PCLT_CAT_ID = EnumerationData.newBuilder()
        .setDescription("Category ID")
        .setEnumCode("CAT_ID")
        .setEnumId("PCLT_CAT_ID")
        .setEnumTypeId("PCAT_LINK_TYPE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PG_PURCH_INCLUDE = EnumerationData.newBuilder()
        .setDescription("Purchase Include Geo")
        .setEnumCode("PURCHASE_INCLUDE")
        .setEnumId("PG_PURCH_INCLUDE")
        .setEnumTypeId("PROD_GEO")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PG_PURCH_EXCLUDE = EnumerationData.newBuilder()
        .setDescription("Purchase Exclude Geo")
        .setEnumCode("PURCHASE_EXCLUDE")
        .setEnumId("PG_PURCH_EXCLUDE")
        .setEnumTypeId("PROD_GEO")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PG_SHIP_INCLUDE = EnumerationData.newBuilder()
        .setDescription("Shipment Include Geo")
        .setEnumCode("SHIPMENT_INCLUDE")
        .setEnumId("PG_SHIP_INCLUDE")
        .setEnumTypeId("PROD_GEO")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PG_SHIP_EXCLUDE = EnumerationData.newBuilder()
        .setDescription("Shipment Exclude Geo")
        .setEnumCode("SHIPMENT_EXCLUDE")
        .setEnumId("PG_SHIP_EXCLUDE")
        .setEnumTypeId("PROD_GEO")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PPIP_ORDER_TOTAL = EnumerationData.newBuilder()
        .setDescription("Cart Sub-total")
        .setEnumCode("ORDER_TOTAL")
        .setEnumId("PPIP_ORDER_TOTAL")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PPIP_PRODUCT_TOTAL = EnumerationData.newBuilder()
        .setDescription("Total Amount of Product")
        .setEnumCode("PRODUCT_TOTAL")
        .setEnumId("PPIP_PRODUCT_TOTAL")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PPIP_PRODUCT_AMOUNT = EnumerationData.newBuilder()
        .setDescription("X Amount of Product")
        .setEnumCode("PRODUCT_AMOUNT")
        .setEnumId("PPIP_PRODUCT_AMOUNT")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PPIP_PRODUCT_QUANT = EnumerationData.newBuilder()
        .setDescription("X Quantity of Product")
        .setEnumCode("PRODUCT_QUANT")
        .setEnumId("PPIP_PRODUCT_QUANT")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PPIP_NEW_ACCT = EnumerationData.newBuilder()
        .setDescription("Account Days Since Created")
        .setEnumCode("NEW_ACCT")
        .setEnumId("PPIP_NEW_ACCT")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PPIP_PARTY_ID = EnumerationData.newBuilder()
        .setDescription("Party")
        .setEnumCode("PARTY_ID")
        .setEnumId("PPIP_PARTY_ID")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PPIP_PARTY_GRP_MEM = EnumerationData.newBuilder()
        .setDescription("Party Group Member")
        .setEnumCode("PARTY_GROUP_MEMBER")
        .setEnumId("PPIP_PARTY_GRP_MEM")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_PPIP_PARTY_CLASS = EnumerationData.newBuilder()
        .setDescription("Party Classification")
        .setEnumCode("PARTY_CLASS")
        .setEnumId("PPIP_PARTY_CLASS")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("08")
        .build();


    public final static EnumerationData Enumeration_PPIP_ROLE_TYPE = EnumerationData.newBuilder()
        .setDescription("Role Type")
        .setEnumCode("ROLE_TYPE")
        .setEnumId("PPIP_ROLE_TYPE")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("09")
        .build();


    public final static EnumerationData Enumeration_PPIP_ORST_HIST = EnumerationData.newBuilder()
        .setDescription("Order sub-total X in last Y Months")
        .setEnumCode("ORST_HIST")
        .setEnumId("PPIP_ORST_HIST")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("10")
        .build();


    public final static EnumerationData Enumeration_PPIP_RECURRENCE = EnumerationData.newBuilder()
        .setDescription("Promotion Recurrence")
        .setEnumCode("PROMO_RECURRENCE")
        .setEnumId("PPIP_RECURRENCE")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("11")
        .build();


    public final static EnumerationData Enumeration_PPIP_ORST_YEAR = EnumerationData.newBuilder()
        .setDescription("Order sub-total X since beginning of current year")
        .setEnumCode("ORST_YEAR")
        .setEnumId("PPIP_ORST_YEAR")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("12")
        .build();


    public final static EnumerationData Enumeration_PPIP_ORST_LAST_YEAR = EnumerationData.newBuilder()
        .setDescription("Order sub-total X last year")
        .setEnumCode("ORST_LAST_YEAR")
        .setEnumId("PPIP_ORST_LAST_YEAR")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("13")
        .build();


    public final static EnumerationData Enumeration_PPIP_LPMUP_AMT = EnumerationData.newBuilder()
        .setDescription("List Price minus Unit Price (Amount)")
        .setEnumCode("LPMUP_AMT")
        .setEnumId("PPIP_LPMUP_AMT")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("14")
        .build();


    public final static EnumerationData Enumeration_PPIP_LPMUP_PER = EnumerationData.newBuilder()
        .setDescription("List Price minus Unit Price (Percent)")
        .setEnumCode("LPMUP_PER")
        .setEnumId("PPIP_LPMUP_PER")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("15")
        .build();


    public final static EnumerationData Enumeration_PPIP_ORDER_SHIPTOTAL = EnumerationData.newBuilder()
        .setDescription("Shipping Total")
        .setEnumCode("ORDER_SHIP_TOTAL")
        .setEnumId("PPIP_ORDER_SHIPTOTAL")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("16")
        .build();


    public final static EnumerationData Enumeration_PPIP_SERVICE = EnumerationData.newBuilder()
        .setDescription("Call Service")
        .setEnumCode("SERVICE")
        .setEnumId("PPIP_SERVICE")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("17")
        .build();


    public final static EnumerationData Enumeration_PPIP_GEO_ID = EnumerationData.newBuilder()
        .setDescription("Shipping Destination")
        .setEnumCode("GEO_ID")
        .setEnumId("PPIP_GEO_ID")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setSequenceId("18")
        .build();


    public final static EnumerationData Enumeration_PPC_EQ = EnumerationData.newBuilder()
        .setDescription("Is")
        .setEnumCode("EQ")
        .setEnumId("PPC_EQ")
        .setEnumTypeId("PROD_PROMO_COND")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PPC_NEQ = EnumerationData.newBuilder()
        .setDescription("Is Not")
        .setEnumCode("NEQ")
        .setEnumId("PPC_NEQ")
        .setEnumTypeId("PROD_PROMO_COND")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PPC_LT = EnumerationData.newBuilder()
        .setDescription("Is Less Than")
        .setEnumCode("LT")
        .setEnumId("PPC_LT")
        .setEnumTypeId("PROD_PROMO_COND")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PPC_LTE = EnumerationData.newBuilder()
        .setDescription("Is Less Than or Equal To")
        .setEnumCode("LTE")
        .setEnumId("PPC_LTE")
        .setEnumTypeId("PROD_PROMO_COND")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PPC_GT = EnumerationData.newBuilder()
        .setDescription("Is Greater Than")
        .setEnumCode("GT")
        .setEnumId("PPC_GT")
        .setEnumTypeId("PROD_PROMO_COND")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PPC_GTE = EnumerationData.newBuilder()
        .setDescription("Is Greater Than or Equal To")
        .setEnumCode("GTE")
        .setEnumId("PPC_GTE")
        .setEnumTypeId("PROD_PROMO_COND")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PPPA_INCLUDE = EnumerationData.newBuilder()
        .setDescription("Include")
        .setEnumCode("INCLUDE")
        .setEnumId("PPPA_INCLUDE")
        .setEnumTypeId("PROD_PROMO_PCAPPL")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PPPA_EXCLUDE = EnumerationData.newBuilder()
        .setDescription("Exclude")
        .setEnumCode("EXCLUDE")
        .setEnumId("PPPA_EXCLUDE")
        .setEnumTypeId("PROD_PROMO_PCAPPL")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PPPA_ALWAYS = EnumerationData.newBuilder()
        .setDescription("Always Include")
        .setEnumCode("ALWAYS")
        .setEnumId("PPPA_ALWAYS")
        .setEnumTypeId("PROD_PROMO_PCAPPL")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PROMO_GWP = EnumerationData.newBuilder()
        .setDescription("Gift With Purchase")
        .setEnumCode("GWP")
        .setEnumId("PROMO_GWP")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PROMO_PROD_DISC = EnumerationData.newBuilder()
        .setDescription("X Product for Y% Discount")
        .setEnumCode("PROD_DISC")
        .setEnumId("PROMO_PROD_DISC")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PROMO_PROD_AMDISC = EnumerationData.newBuilder()
        .setDescription("X Product for Y Discount")
        .setEnumCode("PROD_AMDISC")
        .setEnumId("PROMO_PROD_AMDISC")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PROMO_PROD_PRICE = EnumerationData.newBuilder()
        .setDescription("X Product for Y Price")
        .setEnumCode("PROD_PRICE")
        .setEnumId("PROMO_PROD_PRICE")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PROMO_ORDER_PERCENT = EnumerationData.newBuilder()
        .setDescription("Order Percent Discount")
        .setEnumCode("ORDER_PERCENT")
        .setEnumId("PROMO_ORDER_PERCENT")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PROMO_ORDER_AMOUNT = EnumerationData.newBuilder()
        .setDescription("Order Amount Flat")
        .setEnumCode("ORDER_AMOUNT")
        .setEnumId("PROMO_ORDER_AMOUNT")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_PROMO_PROD_SPPRC = EnumerationData.newBuilder()
        .setDescription("Product for [Special Promo] Price")
        .setEnumCode("PROD_SPPRC")
        .setEnumId("PROMO_PROD_SPPRC")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("08")
        .build();


    public final static EnumerationData Enumeration_PROMO_SHIP_CHARGE = EnumerationData.newBuilder()
        .setDescription("Shipping X% discount")
        .setEnumCode("SHIP_CHARGE")
        .setEnumId("PROMO_SHIP_CHARGE")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("09")
        .build();


    public final static EnumerationData Enumeration_PROMO_SERVICE = EnumerationData.newBuilder()
        .setDescription("Call Service")
        .setEnumCode("SERVICE")
        .setEnumId("PROMO_SERVICE")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("10")
        .build();


    public final static EnumerationData Enumeration_PROMO_TAX_PERCENT = EnumerationData.newBuilder()
        .setDescription("Tax % Discount")
        .setEnumCode("TAX_PERCENT")
        .setEnumId("PROMO_TAX_PERCENT")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setSequenceId("11")
        .build();


    public final static EnumerationData Enumeration_PRDR_MIN = EnumerationData.newBuilder()
        .setDescription("Min Rating")
        .setEnumCode("MIN")
        .setEnumId("PRDR_MIN")
        .setEnumTypeId("PROD_RATING_TYPE")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PRDR_MAX = EnumerationData.newBuilder()
        .setDescription("Max Rating")
        .setEnumCode("MAX")
        .setEnumId("PRDR_MAX")
        .setEnumTypeId("PROD_RATING_TYPE")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRDR_FLAT = EnumerationData.newBuilder()
        .setDescription("Rating Override")
        .setEnumCode("FLAT")
        .setEnumId("PRDR_FLAT")
        .setEnumTypeId("PROD_RATING_TYPE")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_VV_FEATURETREE = EnumerationData.newBuilder()
        .setDescription("Feature tree Generation")
        .setEnumCode("FEATURETREE")
        .setEnumId("VV_FEATURETREE")
        .setEnumTypeId("PROD_VVMETHOD")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_VV_VARIANTTREE = EnumerationData.newBuilder()
        .setDescription("Variant Tree generation")
        .setEnumCode("VARIANTTREE")
        .setEnumId("VV_VARIANTTREE")
        .setEnumTypeId("PROD_VVMETHOD")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRODRQM_NONE = EnumerationData.newBuilder()
        .setDescription("No Requirement Created")
        .setEnumCode("NONE")
        .setEnumId("PRODRQM_NONE")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_PRODRQM_AUTO = EnumerationData.newBuilder()
        .setDescription("Automatic For Every Sales Order")
        .setEnumCode("AUTO")
        .setEnumId("PRODRQM_AUTO")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_PRODRQM_STOCK = EnumerationData.newBuilder()
        .setDescription("When QOH Reaches Minimum Stock for Product-Facility")
        .setEnumCode("STOCK_QOH")
        .setEnumId("PRODRQM_STOCK")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_PRODRQM_STOCK_ATP = EnumerationData.newBuilder()
        .setDescription("When ATP Reaches Minimum Stock for Product-Facility")
        .setEnumCode("STOCK_ATP")
        .setEnumId("PRODRQM_STOCK_ATP")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setSequenceId("04")
        .build();


    public final static EnumerationData Enumeration_PRODRQM_ATP = EnumerationData.newBuilder()
        .setDescription("Requirement for order when ATP Reaches Minimum Stock for Product-Facility")
        .setEnumCode("ATP")
        .setEnumId("PRODRQM_ATP")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setSequenceId("05")
        .build();


    public final static EnumerationData Enumeration_PRODRQM_DS = EnumerationData.newBuilder()
        .setDescription("Drop-ship only")
        .setEnumCode("DROPS")
        .setEnumId("PRODRQM_DS")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setSequenceId("06")
        .build();


    public final static EnumerationData Enumeration_PRODRQM_DSATP = EnumerationData.newBuilder()
        .setDescription("Auto drop-ship on low quantity")
        .setEnumCode("DROPS_ATP")
        .setEnumId("PRODRQM_DSATP")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setSequenceId("07")
        .build();


    public final static EnumerationData Enumeration_RETAKE_PHOTO = EnumerationData.newBuilder()
        .setDescription("Re-take Photo")
        .setEnumCode("RETAKE_PHOTO")
        .setEnumId("RETAKE_PHOTO")
        .setEnumTypeId("IMAGE_REJECT_REASON")
        .setSequenceId("01")
        .build();


    public final static EnumerationData Enumeration_REMOVE_LOGO = EnumerationData.newBuilder()
        .setDescription("Remove Logo")
        .setEnumCode("REMOVE_LOGO")
        .setEnumId("REMOVE_LOGO")
        .setEnumTypeId("IMAGE_REJECT_REASON")
        .setSequenceId("02")
        .build();


    public final static EnumerationData Enumeration_OTHER = EnumerationData.newBuilder()
        .setDescription("Other")
        .setEnumCode("OTHER")
        .setEnumId("OTHER")
        .setEnumTypeId("IMAGE_REJECT_REASON")
        .setSequenceId("03")
        .build();


    public final static EnumerationData Enumeration_DIRECT_STORE_DELIVRY = EnumerationData.newBuilder()
        .setDescription("Direct Store Delivery")
        .setEnumCode("DIRECT_STORE_DELIVRY")
        .setEnumId("DIRECT_STORE_DELIVRY")
        .setSequenceId("01")
        .build();


    public final static ProductAssocTypeData ProductAssocType_ALSO_BOUGHT = ProductAssocTypeData.newBuilder()
        .setDescription("Also Bought")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("ALSO_BOUGHT")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_UPGRADE = ProductAssocTypeData.newBuilder()
        .setDescription("Upgrade or Up-Sell")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_UPGRADE")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_COMPLEMENT = ProductAssocTypeData.newBuilder()
        .setDescription("Complementary or Cross-Sell")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_COMPLEMENT")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_INCOMPATABLE = ProductAssocTypeData.newBuilder()
        .setDescription("Incompatible")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_INCOMPATABLE")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_OBSOLESCENCE = ProductAssocTypeData.newBuilder()
        .setDescription("New Version, Replacement")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_OBSOLESCENCE")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_COMPONENT = ProductAssocTypeData.newBuilder()
        .setDescription("Actual Product Component")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_COMPONENT")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_SUBSTITUTE = ProductAssocTypeData.newBuilder()
        .setDescription("Equivalent or Substitute")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_SUBSTITUTE")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_VARIANT = ProductAssocTypeData.newBuilder()
        .setDescription("Product Variant")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_VARIANT")
        .build();


    public final static ProductAssocTypeData ProductAssocType_UNIQUE_ITEM = ProductAssocTypeData.newBuilder()
        .setDescription("Unique Item")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("UNIQUE_ITEM")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_ACCESSORY = ProductAssocTypeData.newBuilder()
        .setDescription("Accessory")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_ACCESSORY")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_REFURB = ProductAssocTypeData.newBuilder()
        .setDescription("Refurbished Equivalent")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_REFURB")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_REPAIR_SRV = ProductAssocTypeData.newBuilder()
        .setDescription("Repair Service")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_REPAIR_SRV")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_AUTORO = ProductAssocTypeData.newBuilder()
        .setDescription("Auto Reorder (needs recurrenceInfoId)")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_AUTORO")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_REVISION = ProductAssocTypeData.newBuilder()
        .setDescription("Revision")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_REVISION")
        .build();


    public final static ProductAssocTypeData ProductAssocType_MANUF_COMPONENT = ProductAssocTypeData.newBuilder()
        .setDescription("Manufacturing Bill of Materials")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PRODUCT_COMPONENT")
        .setProductAssocTypeId("MANUF_COMPONENT")
        .build();


    public final static ProductAssocTypeData ProductAssocType_ENGINEER_COMPONENT = ProductAssocTypeData.newBuilder()
        .setDescription("Engineering Bill of Materials")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PRODUCT_COMPONENT")
        .setProductAssocTypeId("ENGINEER_COMPONENT")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_MANUFACTURED = ProductAssocTypeData.newBuilder()
        .setDescription("Product Manufactured As")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_MANUFACTURED")
        .build();


    public final static ProductAssocTypeData ProductAssocType_PRODUCT_CONF = ProductAssocTypeData.newBuilder()
        .setDescription("Configurable product instance")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("PRODUCT_CONF")
        .build();


    public final static ProductAssocTypeData ProductAssocType_ALTERNATIVE_PACKAGE = ProductAssocTypeData.newBuilder()
        .setDescription("Alternative Packaging")
        .setHasTable(castIndicator("N"))
        .setProductAssocTypeId("ALTERNATIVE_PACKAGE")
        .build();


    public final static FacilityGroupData FacilityGroup__NA_ = FacilityGroupData.newBuilder()
        .setDescription("Not Applicable")
        .setFacilityGroupId("_NA_")
        .setFacilityGroupName("Not Applicable")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_ACCESSORY = ProductFeatureTypeData.newBuilder()
        .setDescription("Accessory")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("ACCESSORY")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_AMOUNT = ProductFeatureTypeData.newBuilder()
        .setDescription("Amount")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("AMOUNT")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_NET_WEIGHT = ProductFeatureTypeData.newBuilder()
        .setDescription("Net Weight")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("AMOUNT")
        .setProductFeatureTypeId("NET_WEIGHT")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_ARTIST = ProductFeatureTypeData.newBuilder()
        .setDescription("Artist")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("ARTIST")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_BILLING_FEATURE = ProductFeatureTypeData.newBuilder()
        .setDescription("Billing Feature")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("BILLING_FEATURE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_BRAND = ProductFeatureTypeData.newBuilder()
        .setDescription("Brand")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("BRAND")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_CARE = ProductFeatureTypeData.newBuilder()
        .setDescription("Care")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("CARE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_COLOR = ProductFeatureTypeData.newBuilder()
        .setDescription("Color")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("COLOR")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_DIMENSION = ProductFeatureTypeData.newBuilder()
        .setDescription("Dimension")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("DIMENSION")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_EQUIP_CLASS = ProductFeatureTypeData.newBuilder()
        .setDescription("Equipment Class")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("EQUIP_CLASS")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_FABRIC = ProductFeatureTypeData.newBuilder()
        .setDescription("Fabric")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("FABRIC")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_GENRE = ProductFeatureTypeData.newBuilder()
        .setDescription("Genre")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("GENRE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_GIFT_WRAP = ProductFeatureTypeData.newBuilder()
        .setDescription("Gift Wrap")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("GIFT_WRAP")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_HARDWARE_FEATURE = ProductFeatureTypeData.newBuilder()
        .setDescription("Hardware Feature")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("HARDWARE_FEATURE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_HAZMAT = ProductFeatureTypeData.newBuilder()
        .setDescription("Hazmat")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("HAZMAT")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_LICENSE = ProductFeatureTypeData.newBuilder()
        .setDescription("License")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("LICENSE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_ORIGIN = ProductFeatureTypeData.newBuilder()
        .setDescription("Origin")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("ORIGIN")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_OTHER_FEATURE = ProductFeatureTypeData.newBuilder()
        .setDescription("Other Feature")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("OTHER_FEATURE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_PRODUCT_QUALITY = ProductFeatureTypeData.newBuilder()
        .setDescription("Product Quality")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("PRODUCT_QUALITY")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_SIZE = ProductFeatureTypeData.newBuilder()
        .setDescription("Size")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("SIZE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_SOFTWARE_FEATURE = ProductFeatureTypeData.newBuilder()
        .setDescription("Software Feature")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("SOFTWARE_FEATURE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_STYLE = ProductFeatureTypeData.newBuilder()
        .setDescription("Style")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("STYLE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_SYMPTOM = ProductFeatureTypeData.newBuilder()
        .setDescription("Symptom")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("SYMPTOM")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_TOPIC = ProductFeatureTypeData.newBuilder()
        .setDescription("Topic")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("TOPIC")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_TYPE = ProductFeatureTypeData.newBuilder()
        .setDescription("Type")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("TYPE")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_WARRANTY = ProductFeatureTypeData.newBuilder()
        .setDescription("Warranty")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("WARRANTY")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_MODEL_YEAR = ProductFeatureTypeData.newBuilder()
        .setDescription("Model Year")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("MODEL_YEAR")
        .build();


    public final static ProductFeatureTypeData ProductFeatureType_YEAR_MADE = ProductFeatureTypeData.newBuilder()
        .setDescription("Year Made")
        .setHasTable(castIndicator("N"))
        .setProductFeatureTypeId("YEAR_MADE")
        .build();


    public final static ProductTypeData ProductType_ASSET_USAGE = ProductTypeData.newBuilder()
        .setDescription("Fixed Asset Usage")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setProductTypeId("ASSET_USAGE")
        .build();


    public final static ProductTypeData ProductType_SERVICE = ProductTypeData.newBuilder()
        .setDescription("Service")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("N"))
        .setProductTypeId("SERVICE")
        .build();


    public final static ProductTypeData ProductType_GOOD = ProductTypeData.newBuilder()
        .setDescription("Good")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setProductTypeId("GOOD")
        .build();


    public final static ProductTypeData ProductType_RAW_MATERIAL = ProductTypeData.newBuilder()
        .setDescription("Raw Material")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("GOOD")
        .setProductTypeId("RAW_MATERIAL")
        .build();


    public final static ProductTypeData ProductType_SUBASSEMBLY = ProductTypeData.newBuilder()
        .setDescription("Subassembly")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("GOOD")
        .setProductTypeId("SUBASSEMBLY")
        .build();


    public final static ProductTypeData ProductType_FINISHED_GOOD = ProductTypeData.newBuilder()
        .setDescription("Finished Good")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("GOOD")
        .setProductTypeId("FINISHED_GOOD")
        .build();


    public final static ProductTypeData ProductType_DIGITAL_GOOD = ProductTypeData.newBuilder()
        .setDescription("Digital Good")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("Y"))
        .setIsPhysical(castIndicator("N"))
        .setParentTypeId("GOOD")
        .setProductTypeId("DIGITAL_GOOD")
        .build();


    public final static ProductTypeData ProductType_FINDIG_GOOD = ProductTypeData.newBuilder()
        .setDescription("Finished/Digital Good")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("Y"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("GOOD")
        .setProductTypeId("FINDIG_GOOD")
        .build();


    public final static ProductTypeData ProductType_AGGREGATED = ProductTypeData.newBuilder()
        .setDescription("Configurable Good")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("GOOD")
        .setProductTypeId("AGGREGATED")
        .build();


    public final static ProductTypeData ProductType_MARKETING_PKG = ProductTypeData.newBuilder()
        .setDescription("Marketing Package")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("GOOD")
        .setProductTypeId("MARKETING_PKG")
        .build();


    public final static ProductTypeData ProductType_MARKETING_PKG_AUTO = ProductTypeData.newBuilder()
        .setDescription("Marketing Package: Auto Manufactured")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("MARKETING_PKG")
        .setProductTypeId("MARKETING_PKG_AUTO")
        .build();


    public final static ProductTypeData ProductType_MARKETING_PKG_PICK = ProductTypeData.newBuilder()
        .setDescription("Marketing Package: Pick Assembly")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("MARKETING_PKG")
        .setProductTypeId("MARKETING_PKG_PICK")
        .build();


    public final static ProductTypeData ProductType_WIP = ProductTypeData.newBuilder()
        .setDescription("Work In Process")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("GOOD")
        .setProductTypeId("WIP")
        .build();


    public final static ProductTypeData ProductType_AGGREGATED_CONF = ProductTypeData.newBuilder()
        .setDescription("Configurable Good Configuration")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("AGGREGATED")
        .setProductTypeId("AGGREGATED_CONF")
        .build();


    public final static ProductTypeData ProductType_ASSET_USAGE_OUT_IN = ProductTypeData.newBuilder()
        .setDescription("Fixed Asset Usage For Rental of an asset which is shipped from and returned to inventory")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setProductTypeId("ASSET_USAGE_OUT_IN")
        .build();


    public final static ProductTypeData ProductType_SERVICE_PRODUCT = ProductTypeData.newBuilder()
        .setDescription("Service a product using inventory")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setProductTypeId("SERVICE_PRODUCT")
        .build();


    public final static ProductTypeData ProductType_AGGREGATED_SERVICE = ProductTypeData.newBuilder()
        .setDescription("Configurable Service using inventory")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("SERVICE_PRODUCT")
        .setProductTypeId("AGGREGATED_SERVICE")
        .build();


    public final static ProductTypeData ProductType_AGGREGATEDSERV_CONF = ProductTypeData.newBuilder()
        .setDescription("Configurable Service Configuration")
        .setHasTable(castIndicator("N"))
        .setIsDigital(castIndicator("N"))
        .setIsPhysical(castIndicator("Y"))
        .setParentTypeId("AGGREGATED")
        .setProductTypeId("AGGREGATEDSERV_CONF")
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PRICE = EnumerationTypeData.newBuilder()
        .setDescription("Product Price Parent Enum Type")
        .setEnumTypeId("PROD_PRICE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PRICE_IN_PARAM = EnumerationTypeData.newBuilder()
        .setDescription("Product Price Input Parameter")
        .setEnumTypeId("PROD_PRICE_IN_PARAM")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PROD_PRICE")
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PRICE_COND = EnumerationTypeData.newBuilder()
        .setDescription("Product Price Condition")
        .setEnumTypeId("PROD_PRICE_COND")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PROD_PRICE")
        .build();


    public final static EnumerationTypeData EnumerationType_INV_RES_ORDER = EnumerationTypeData.newBuilder()
        .setDescription("Inventory Reservation Order")
        .setEnumTypeId("INV_RES_ORDER")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_IID_REASON = EnumerationTypeData.newBuilder()
        .setDescription("Inventory Item Detail Reason")
        .setEnumTypeId("IID_REASON")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PRDS_PAYSVC = EnumerationTypeData.newBuilder()
        .setDescription("Product Store Payment Service Type")
        .setEnumTypeId("PRDS_PAYSVC")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PRDS_EMAIL = EnumerationTypeData.newBuilder()
        .setDescription("Product Store Email Notification")
        .setEnumTypeId("PRDS_EMAIL")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_FACLOC_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Facility Location Type")
        .setEnumTypeId("FACLOC_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_KWOVRD_TRGT_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Keyword Override Target Type")
        .setEnumTypeId("KWOVRD_TRGT_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PCAT_LINK_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Product Category Link Type")
        .setEnumTypeId("PCAT_LINK_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_GEO = EnumerationTypeData.newBuilder()
        .setDescription("Product Geo Data")
        .setEnumTypeId("PROD_GEO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PROMO = EnumerationTypeData.newBuilder()
        .setDescription("Product Promotion Parent Enum Type")
        .setEnumTypeId("PROD_PROMO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PROMO_IN_PARAM = EnumerationTypeData.newBuilder()
        .setDescription("Product Promotion Input Parameter")
        .setEnumTypeId("PROD_PROMO_IN_PARAM")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PROD_PROMO")
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PROMO_COND = EnumerationTypeData.newBuilder()
        .setDescription("Product Promotion Condition")
        .setEnumTypeId("PROD_PROMO_COND")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PROD_PROMO")
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PROMO_PCAPPL = EnumerationTypeData.newBuilder()
        .setDescription("Product Promotion Product/Category Application Type")
        .setEnumTypeId("PROD_PROMO_PCAPPL")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PROD_PROMO")
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_PROMO_ACTION = EnumerationTypeData.newBuilder()
        .setDescription("Product Promotion Action")
        .setEnumTypeId("PROD_PROMO_ACTION")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("PROD_PROMO")
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_RATING_TYPE = EnumerationTypeData.newBuilder()
        .setDescription("Product Rating Field Type")
        .setEnumTypeId("PROD_RATING_TYPE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_VVMETHOD = EnumerationTypeData.newBuilder()
        .setDescription("Virtual Variant Method")
        .setEnumTypeId("PROD_VVMETHOD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_PROD_REQ_METHOD = EnumerationTypeData.newBuilder()
        .setDescription("Product Requirement Method")
        .setEnumTypeId("PROD_REQ_METHOD")
        .setHasTable(castIndicator("N"))
        .build();


    public final static EnumerationTypeData EnumerationType_IMAGE_REJECT_REASON = EnumerationTypeData.newBuilder()
        .setDescription("Image Reject Reason")
        .setEnumTypeId("IMAGE_REJECT_REASON")
        .setHasTable(castIndicator("N"))
        .build();


    public final static VarianceReasonData VarianceReason_VAR_LOST = VarianceReasonData.newBuilder()
        .setDescription("Lost")
        .setVarianceReasonId("VAR_LOST")
        .build();


    public final static VarianceReasonData VarianceReason_VAR_STOLEN = VarianceReasonData.newBuilder()
        .setDescription("Stolen")
        .setVarianceReasonId("VAR_STOLEN")
        .build();


    public final static VarianceReasonData VarianceReason_VAR_FOUND = VarianceReasonData.newBuilder()
        .setDescription("Found")
        .setVarianceReasonId("VAR_FOUND")
        .build();


    public final static VarianceReasonData VarianceReason_VAR_DAMAGED = VarianceReasonData.newBuilder()
        .setDescription("Damaged")
        .setVarianceReasonId("VAR_DAMAGED")
        .build();


    public final static VarianceReasonData VarianceReason_VAR_INTEGR = VarianceReasonData.newBuilder()
        .setDescription("Integration")
        .setVarianceReasonId("VAR_INTEGR")
        .build();


    public final static VarianceReasonData VarianceReason_VAR_SAMPLE = VarianceReasonData.newBuilder()
        .setDescription("Sample (Giveaway)")
        .setVarianceReasonId("VAR_SAMPLE")
        .build();


    public final static VarianceReasonData VarianceReason_VAR_MISSHIP_ORDERED = VarianceReasonData.newBuilder()
        .setDescription("Mis-shipped Item Ordered (+)")
        .setVarianceReasonId("VAR_MISSHIP_ORDERED")
        .build();


    public final static VarianceReasonData VarianceReason_VAR_MISSHIP_SHIPPED = VarianceReasonData.newBuilder()
        .setDescription("Mis-shipped Item Shipped (-)")
        .setVarianceReasonId("VAR_MISSHIP_SHIPPED")
        .build();


    public final static ProductContentTypeData ProductContentType_ONLINE_ACCESS = ProductContentTypeData.newBuilder()
        .setDescription("Online Access")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ONLINE_ACCESS")
        .build();


    public final static ProductContentTypeData ProductContentType_DIGITAL_DOWNLOAD = ProductContentTypeData.newBuilder()
        .setDescription("Digital Download")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("DIGITAL_DOWNLOAD")
        .build();


    public final static ProductContentTypeData ProductContentType_FULFILLMENT_EMAIL = ProductContentTypeData.newBuilder()
        .setDescription("Fulfillment Email")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("FULFILLMENT_EMAIL")
        .build();


    public final static ProductContentTypeData ProductContentType_FULFILLMENT_EXTASYNC = ProductContentTypeData.newBuilder()
        .setDescription("Fulfillment External (Async)")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("FULFILLMENT_EXTASYNC")
        .build();


    public final static ProductContentTypeData ProductContentType_FULFILLMENT_EXTSYNC = ProductContentTypeData.newBuilder()
        .setDescription("Fulfillment External (Sync)")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("FULFILLMENT_EXTSYNC")
        .build();


    public final static ProductContentTypeData ProductContentType_PRODUCT_NAME = ProductContentTypeData.newBuilder()
        .setDescription("Product Name")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("PRODUCT_NAME")
        .build();


    public final static ProductContentTypeData ProductContentType_DESCRIPTION = ProductContentTypeData.newBuilder()
        .setDescription("Description")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("DESCRIPTION")
        .build();


    public final static ProductContentTypeData ProductContentType_LONG_DESCRIPTION = ProductContentTypeData.newBuilder()
        .setDescription("Description - Long")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("LONG_DESCRIPTION")
        .build();


    public final static ProductContentTypeData ProductContentType_ALTERNATIVE_URL = ProductContentTypeData.newBuilder()
        .setDescription("Alternative URL")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ALTERNATIVE_URL")
        .build();


    public final static ProductContentTypeData ProductContentType_PRICE_DETAIL_TEXT = ProductContentTypeData.newBuilder()
        .setDescription("Price Detail Text")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("PRICE_DETAIL_TEXT")
        .build();


    public final static ProductContentTypeData ProductContentType_INGREDIENTS = ProductContentTypeData.newBuilder()
        .setDescription("Ingredients")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("INGREDIENTS")
        .build();


    public final static ProductContentTypeData ProductContentType_UNIQUE_INGREDIENTS = ProductContentTypeData.newBuilder()
        .setDescription("Unique Ingredients")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("UNIQUE_INGREDIENTS")
        .build();


    public final static ProductContentTypeData ProductContentType_SPECIALINSTRUCTIONS = ProductContentTypeData.newBuilder()
        .setDescription("Special Instructions")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("SPECIALINSTRUCTIONS")
        .build();


    public final static ProductContentTypeData ProductContentType_WARNINGS = ProductContentTypeData.newBuilder()
        .setDescription("Warnings")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("WARNINGS")
        .build();


    public final static ProductContentTypeData ProductContentType_DIRECTIONS = ProductContentTypeData.newBuilder()
        .setDescription("Directions")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("DIRECTIONS")
        .build();


    public final static ProductContentTypeData ProductContentType_TERMS_AND_CONDS = ProductContentTypeData.newBuilder()
        .setDescription("Terms and Conditions")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("TERMS_AND_CONDS")
        .build();


    public final static ProductContentTypeData ProductContentType_DELIVERY_INFO = ProductContentTypeData.newBuilder()
        .setDescription("Delivery Info")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("DELIVERY_INFO")
        .build();


    public final static ProductContentTypeData ProductContentType_SMALL_IMAGE_URL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Small")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("SMALL_IMAGE_URL")
        .build();


    public final static ProductContentTypeData ProductContentType_MEDIUM_IMAGE_URL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Medium")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("MEDIUM_IMAGE_URL")
        .build();


    public final static ProductContentTypeData ProductContentType_LARGE_IMAGE_URL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Large")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("LARGE_IMAGE_URL")
        .build();


    public final static ProductContentTypeData ProductContentType_DETAIL_IMAGE_URL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Detail")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("DETAIL_IMAGE_URL")
        .build();


    public final static ProductContentTypeData ProductContentType_ORIGINAL_IMAGE_URL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Original")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ORIGINAL_IMAGE_URL")
        .build();


    public final static ProductContentTypeData ProductContentType_SMALL_IMAGE_ALT = ProductContentTypeData.newBuilder()
        .setDescription("Image Alt Text - Small")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("SMALL_IMAGE_ALT")
        .build();


    public final static ProductContentTypeData ProductContentType_MEDIUM_IMAGE_ALT = ProductContentTypeData.newBuilder()
        .setDescription("Image Alt Text - Medium")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("MEDIUM_IMAGE_ALT")
        .build();


    public final static ProductContentTypeData ProductContentType_LARGE_IMAGE_ALT = ProductContentTypeData.newBuilder()
        .setDescription("Image Alt Text - Large")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("LARGE_IMAGE_ALT")
        .build();


    public final static ProductContentTypeData ProductContentType_DETAIL_IMAGE_ALT = ProductContentTypeData.newBuilder()
        .setDescription("Image Alt Text - Detail")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("DETAIL_IMAGE_ALT")
        .build();


    public final static ProductContentTypeData ProductContentType_ADDITIONAL_IMAGE_1 = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 1")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ADDITIONAL_IMAGE_1")
        .build();


    public final static ProductContentTypeData ProductContentType_ADDITIONAL_IMAGE_2 = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 2")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ADDITIONAL_IMAGE_2")
        .build();


    public final static ProductContentTypeData ProductContentType_ADDITIONAL_IMAGE_3 = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 3")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ADDITIONAL_IMAGE_3")
        .build();


    public final static ProductContentTypeData ProductContentType_ADDITIONAL_IMAGE_4 = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 4")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ADDITIONAL_IMAGE_4")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_1_SMALL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 1 Small")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_1_SMALL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_1_MEDIUM = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 1 Medium")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_1_MEDIUM")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_1_LARGE = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 1 Large")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_1_LARGE")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_1_DETAIL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 1 Detail")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_1_DETAIL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_2_SMALL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 2 Small")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_2_SMALL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_2_MEDIUM = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 2 Medium")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_2_MEDIUM")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_2_LARGE = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 2 Large")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_2_LARGE")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_2_DETAIL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 2 Detail")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_2_DETAIL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_3_SMALL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 3 Small")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_3_SMALL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_3_MEDIUM = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 3 Medium")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_3_MEDIUM")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_3_LARGE = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 3 Large")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_3_LARGE")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_3_DETAIL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 3 Detail")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_3_DETAIL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_4_SMALL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 4 Small")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_4_SMALL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_4_MEDIUM = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 4 Medium")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_4_MEDIUM")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_4_LARGE = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 4 Large")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_4_LARGE")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_4_DETAIL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View 4 Detail")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_4_DETAIL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_L_SMALL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View Small")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_L_SMALL")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_L_MEDIUM = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View Medium")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_L_MEDIUM")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_L_LARGE = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View Large")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_L_LARGE")
        .build();


    public final static ProductContentTypeData ProductContentType_XTRA_IMG_L_DETAIL = ProductContentTypeData.newBuilder()
        .setDescription("Image - Additional View Detail")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("XTRA_IMG_L_DETAIL")
        .build();


    public final static ProductContentTypeData ProductContentType_ADDTOCART_LABEL = ProductContentTypeData.newBuilder()
        .setDescription("Add To Cart Label")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ADDTOCART_LABEL")
        .build();


    public final static ProductContentTypeData ProductContentType_ADDTOCART_IMAGE = ProductContentTypeData.newBuilder()
        .setDescription("Add To Cart Image")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("ADDTOCART_IMAGE")
        .build();


    public final static ProductContentTypeData ProductContentType_SHORT_SALES_PITCH = ProductContentTypeData.newBuilder()
        .setDescription("Short Sales Pitch")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("SHORT_SALES_PITCH")
        .build();


    public final static ProductContentTypeData ProductContentType_INSTALLATION = ProductContentTypeData.newBuilder()
        .setDescription("Installation")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DIGITAL_DOWNLOAD")
        .setProductContentTypeId("INSTALLATION")
        .build();


    public final static ProductContentTypeData ProductContentType_SPECIFICATION = ProductContentTypeData.newBuilder()
        .setDescription("Specification")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DIGITAL_DOWNLOAD")
        .setProductContentTypeId("SPECIFICATION")
        .build();


    public final static ProductContentTypeData ProductContentType_WARRANTY = ProductContentTypeData.newBuilder()
        .setDescription("Warranty")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("DIGITAL_DOWNLOAD")
        .setProductContentTypeId("WARRANTY")
        .build();


    public final static ProductContentTypeData ProductContentType_PAGE_TITLE = ProductContentTypeData.newBuilder()
        .setDescription("Page Title")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("PAGE_TITLE")
        .build();


    public final static ProductContentTypeData ProductContentType_META_KEYWORD = ProductContentTypeData.newBuilder()
        .setDescription("Meta Keyword")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("META_KEYWORD")
        .build();


    public final static ProductContentTypeData ProductContentType_META_DESCRIPTION = ProductContentTypeData.newBuilder()
        .setDescription("Meta Description")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("META_DESCRIPTION")
        .build();


    public final static ProductContentTypeData ProductContentType_IMAGE = ProductContentTypeData.newBuilder()
        .setDescription("Image")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("IMAGE")
        .build();


    public final static ProductContentTypeData ProductContentType_DEFAULT_IMAGE = ProductContentTypeData.newBuilder()
        .setDescription("Default Image")
        .setHasTable(castIndicator("N"))
        .setProductContentTypeId("DEFAULT_IMAGE")
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_ISBN = GoodIdentificationTypeData.newBuilder()
        .setDescription("ISBN")
        .setGoodIdentificationTypeId("ISBN")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_MANUFACTURER_ID_NO = GoodIdentificationTypeData.newBuilder()
        .setDescription("Manufacturer (Model) Number")
        .setGoodIdentificationTypeId("MANUFACTURER_ID_NO")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_MODEL_YEAR = GoodIdentificationTypeData.newBuilder()
        .setDescription("Model Year")
        .setGoodIdentificationTypeId("MODEL_YEAR")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_OTHER_ID = GoodIdentificationTypeData.newBuilder()
        .setDescription("Other")
        .setGoodIdentificationTypeId("OTHER_ID")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_SKU = GoodIdentificationTypeData.newBuilder()
        .setDescription("SKU")
        .setGoodIdentificationTypeId("SKU")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_UPCA = GoodIdentificationTypeData.newBuilder()
        .setDescription("UPCA")
        .setGoodIdentificationTypeId("UPCA")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_UPCE = GoodIdentificationTypeData.newBuilder()
        .setDescription("UPCE")
        .setGoodIdentificationTypeId("UPCE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_EAN = GoodIdentificationTypeData.newBuilder()
        .setDescription("EAN")
        .setGoodIdentificationTypeId("EAN")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_LOC = GoodIdentificationTypeData.newBuilder()
        .setDescription("Library of Congress")
        .setGoodIdentificationTypeId("LOC")
        .setHasTable(castIndicator("N"))
        .build();


    public final static GoodIdentificationTypeData GoodIdentificationType_HS_CODE = GoodIdentificationTypeData.newBuilder()
        .setDescription("Harmonized System Codes (HS Code)")
        .setGoodIdentificationTypeId("HS_CODE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ProdConfItemContentTypeData ProdConfItemContentType_IMAGE_URL = ProdConfItemContentTypeData.newBuilder()
        .setConfItemContentTypeId("IMAGE_URL")
        .setDescription("Image")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ProdConfItemContentTypeData ProdConfItemContentType_DESCRIPTION = ProdConfItemContentTypeData.newBuilder()
        .setConfItemContentTypeId("DESCRIPTION")
        .setDescription("Description")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ProdConfItemContentTypeData ProdConfItemContentType_LONG_DESCRIPTION = ProdConfItemContentTypeData.newBuilder()
        .setConfItemContentTypeId("LONG_DESCRIPTION")
        .setDescription("Description - Long")
        .setHasTable(castIndicator("N"))
        .build();


    public final static ProdConfItemContentTypeData ProdConfItemContentType_INSTRUCTIONS = ProdConfItemContentTypeData.newBuilder()
        .setConfItemContentTypeId("INSTRUCTIONS")
        .setDescription("Instructions")
        .setHasTable(castIndicator("N"))
        .build();


    public final static SupplierPrefOrderData SupplierPrefOrder_10_MAIN_SUPPL = SupplierPrefOrderData.newBuilder()
        .setDescription("Main Supplier")
        .setSupplierPrefOrderId("10_MAIN_SUPPL")
        .build();


    public final static SupplierPrefOrderData SupplierPrefOrder_90_ALT_SUPPL = SupplierPrefOrderData.newBuilder()
        .setDescription("Alternative Supplier")
        .setSupplierPrefOrderId("90_ALT_SUPPL")
        .build();


    public final static RejectionReasonData RejectionReason_SRJ_DAMAGED = RejectionReasonData.newBuilder()
        .setDescription("Damaged")
        .setRejectionId("SRJ_DAMAGED")
        .build();


    public final static RejectionReasonData RejectionReason_SRJ_NOT_ORDERED = RejectionReasonData.newBuilder()
        .setDescription("Not Ordered")
        .setRejectionId("SRJ_NOT_ORDERED")
        .build();


    public final static RejectionReasonData RejectionReason_SRJ_OVER_SHIPPED = RejectionReasonData.newBuilder()
        .setDescription("Over Shipped")
        .setRejectionId("SRJ_OVER_SHIPPED")
        .build();


    public final static ShipmentGatewayUpsData ShipmentGatewayUps_UPS_CONFIG = ShipmentGatewayUpsData.newBuilder()
        .setAccessLicenseNumber("TEST262223144CAT")
        .setAccessPassword("REG111111")
        .setAccessUserId("REG111111")
        .setBillShipperAccountNumber("12345E")
        .setCodAllowCod("true")
        .setCodFundsCode("0")
        .setCodSurchargeAmount(getFixedPoint("9"))
        .setCodSurchargeApplyToPackage("first")
        .setCodSurchargeCurrencyUomId("USD")
        .setConnectTimeout(60)
        .setConnectUrl("https://wwwcie.ups.com/ups.app/xml")
        .setCustomerClassification("03")
        .setDefaultReturnLabelMemo("UPS Shipment Return Memo")
        .setDefaultReturnLabelSubject("UPS Shipment Return Label")
        .setMaxEstimateWeight(getFixedPoint("90"))
        .setMinEstimateWeight(getFixedPoint("0.1"))
        .setSaveCertInfo("true")
        .setSaveCertPath("${sys:getProperty('ofbiz.home')}/runtime/output/upscert")
        .setShipmentGatewayConfigId("UPS_CONFIG")
        .setShipperNumber("12345E")
        .setShipperPickupType("06")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_CATALOG_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Catalog")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("CATALOG_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_INDUSTRY_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Industry")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("INDUSTRY_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_INTERNAL_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Internal")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("INTERNAL_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_MATERIALS_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Materials")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("MATERIALS_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_QUICKADD_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Quick Add")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("QUICKADD_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_SEARCH_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Search")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("SEARCH_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_USAGE_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Usage")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("USAGE_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_MIXMATCH_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Mix and Match")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("MIXMATCH_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_CROSS_SELL_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Cross Sell")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("CROSS_SELL_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_TAX_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Tax")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("TAX_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_GOOGLE_BASE_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Google Base")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("GOOGLE_BASE_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_GIFT_CARD_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Gift Cards")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("GIFT_CARD_CATEGORY")
        .build();


    public final static ProductCategoryTypeData ProductCategoryType_BEST_SELL_CATEGORY = ProductCategoryTypeData.newBuilder()
        .setDescription("Best Selling")
        .setHasTable(castIndicator("N"))
        .setProductCategoryTypeId("BEST_SELL_CATEGORY")
        .build();


    public final static CostComponentTypeData CostComponentType_MAT_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("MAT_COST")
        .setDescription("Materials Cost")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CostComponentTypeData CostComponentType_ROUTE_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("ROUTE_COST")
        .setDescription("Route (fixed asset usage) Cost")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CostComponentTypeData CostComponentType_LABOR_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("LABOR_COST")
        .setDescription("Labor Cost")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CostComponentTypeData CostComponentType_GEN_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("GEN_COST")
        .setDescription("General Cost")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CostComponentTypeData CostComponentType_IND_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("IND_COST")
        .setDescription("Indirect Cost")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CostComponentTypeData CostComponentType_OTHER_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("OTHER_COST")
        .setDescription("Other Cost")
        .setHasTable(castIndicator("N"))
        .build();


    public final static CostComponentTypeData CostComponentType_EST_STD_MAT_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("EST_STD_MAT_COST")
        .setDescription("Estimated Standard Materials Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("MAT_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_EST_STD_ROUTE_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("EST_STD_ROUTE_COST")
        .setDescription("Estimated Standard Route (fixed asset usage) Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ROUTE_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_EST_STD_LABOR_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("EST_STD_LABOR_COST")
        .setDescription("Estimated Standard Labor Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("LABOR_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_EST_STD_GEN_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("EST_STD_GEN_COST")
        .setDescription("Estimated Standard General Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("GEN_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_EST_STD_IND_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("EST_STD_IND_COST")
        .setDescription("Estimated Standard Indirect Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("IND_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_EST_STD_OTHER_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("EST_STD_OTHER_COST")
        .setDescription("Estimated Standard Other Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OTHER_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_ACTUAL_MAT_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("ACTUAL_MAT_COST")
        .setDescription("Actual Materials Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("MAT_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_ACTUAL_ROUTE_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("ACTUAL_ROUTE_COST")
        .setDescription("Actual Route (fixed asset usage) Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("ROUTE_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_ACTUAL_LABOR_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("ACTUAL_LABOR_COST")
        .setDescription("Actual Labor Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("LABOR_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_ACTUAL_OTHER_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("ACTUAL_OTHER_COST")
        .setDescription("Actual Other Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("OTHER_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_ACTUAL_GEN_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("ACTUAL_GEN_COST")
        .setDescription("Actual General Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("GEN_COST")
        .build();


    public final static CostComponentTypeData CostComponentType_ACTUAL_IND_COST = CostComponentTypeData.newBuilder()
        .setCostComponentTypeId("ACTUAL_IND_COST")
        .setDescription("Actual Indirect Cost")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("IND_COST")
        .build();


    public final static ProductStoreGroupData ProductStoreGroup__NA_ = ProductStoreGroupData.newBuilder()
        .setDescription("Not Applicable")
        .setProductStoreGroupId("_NA_")
        .setProductStoreGroupName("Not Applicable")
        .build();


    public final static StatusTypeData StatusType_INVENTORY_ITEM_STTS = StatusTypeData.newBuilder()
        .setDescription("Inventory Item")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("INVENTORY_ITEM_STTS")
        .build();


    public final static StatusTypeData StatusType_INV_SERIALIZED_STTS = StatusTypeData.newBuilder()
        .setDescription("Serialized Inventory Item")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INVENTORY_ITEM_STTS")
        .setStatusTypeId("INV_SERIALIZED_STTS")
        .build();


    public final static StatusTypeData StatusType_INV_NON_SER_STTS = StatusTypeData.newBuilder()
        .setDescription("Non-Serialized Inventory Item")
        .setHasTable(castIndicator("N"))
        .setParentTypeId("INVENTORY_ITEM_STTS")
        .setStatusTypeId("INV_NON_SER_STTS")
        .build();


    public final static StatusTypeData StatusType_INVENTORY_XFER_STTS = StatusTypeData.newBuilder()
        .setDescription("Inventory Transfer")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("INVENTORY_XFER_STTS")
        .build();


    public final static StatusTypeData StatusType_PRODUCT_REVIEW_STTS = StatusTypeData.newBuilder()
        .setDescription("Product Review")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PRODUCT_REVIEW_STTS")
        .build();


    public final static StatusTypeData StatusType_IMAGE_MANAGEMENT_ST = StatusTypeData.newBuilder()
        .setDescription("Image Management")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("IMAGE_MANAGEMENT_ST")
        .build();


    public final static StatusTypeData StatusType_GROUP_ORDER_STATUS = StatusTypeData.newBuilder()
        .setDescription("Group Order Status")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("GROUP_ORDER_STATUS")
        .build();


    public final static StatusTypeData StatusType_SHIPMENT_STATUS = StatusTypeData.newBuilder()
        .setDescription("Shipment")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("SHIPMENT_STATUS")
        .build();


    public final static StatusTypeData StatusType_PURCH_SHIP_STATUS = StatusTypeData.newBuilder()
        .setDescription("Purchase Shipment")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PURCH_SHIP_STATUS")
        .build();


    public final static StatusTypeData StatusType_SHPRTSG_CS_STATUS = StatusTypeData.newBuilder()
        .setDescription("ShipmentRouteSegment:CarrierService")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("SHPRTSG_CS_STATUS")
        .build();


    public final static StatusTypeData StatusType_PICKLIST_STATUS = StatusTypeData.newBuilder()
        .setDescription("Picklist")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PICKLIST_STATUS")
        .build();


    public final static StatusTypeData StatusType_PICKITEM_STATUS = StatusTypeData.newBuilder()
        .setDescription("Picklist Item")
        .setHasTable(castIndicator("N"))
        .setStatusTypeId("PICKITEM_STATUS")
        .build();


    public final static CustomMethodTypeData CustomMethodType_COST_FORMULA = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("COST_FORMULA")
        .setDescription("Formula for calculating costs for tasks and products")
        .build();


    public final static CustomMethodTypeData CustomMethodType_PRICE_FORMULA = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("PRICE_FORMULA")
        .setDescription("Service with formula for calculating the unit price of a product")
        .build();


    public final static CustomMethodTypeData CustomMethodType_SHIP_EST = CustomMethodTypeData.newBuilder()
        .setCustomMethodTypeId("SHIP_EST")
        .setDescription("Shipment Gateway rate estimate methods")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_BUILDING = FacilityTypeData.newBuilder()
        .setDescription("Building")
        .setFacilityTypeId("BUILDING")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_FLOOR = FacilityTypeData.newBuilder()
        .setDescription("Floor")
        .setFacilityTypeId("FLOOR")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_OFFICE = FacilityTypeData.newBuilder()
        .setDescription("Office")
        .setFacilityTypeId("OFFICE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_CALL_CENTER = FacilityTypeData.newBuilder()
        .setDescription("Call Center")
        .setFacilityTypeId("CALL_CENTER")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_PLANT = FacilityTypeData.newBuilder()
        .setDescription("Plant")
        .setFacilityTypeId("PLANT")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_ROOM = FacilityTypeData.newBuilder()
        .setDescription("Room")
        .setFacilityTypeId("ROOM")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_RETAIL_STORE = FacilityTypeData.newBuilder()
        .setDescription("Retail Store")
        .setFacilityTypeId("RETAIL_STORE")
        .setHasTable(castIndicator("N"))
        .build();


    public final static FacilityTypeData FacilityType_WAREHOUSE = FacilityTypeData.newBuilder()
        .setDescription("Warehouse")
        .setFacilityTypeId("WAREHOUSE")
        .setHasTable(castIndicator("N"))
        .build();

}
