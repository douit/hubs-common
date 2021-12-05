package com.bluecc.hubs.stereotypes;

import com.google.common.collect.ImmutableList;
import java.util.List;
import static com.bluecc.hubs.stereotypes.ProductSeedData.*;import com.bluecc.hubs.stub.ContentAssocTypeData;
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

public final class ProductSeedDataList {
    public static final List<ContentAssocTypeData> contentAssocTypeList=ImmutableList.of(        
            ContentAssocType_IMAGE_THUMBNAIL);

    public static final List<ProdCatalogCategoryTypeData> prodCatalogCategoryTypeList=ImmutableList.of(        
            ProdCatalogCategoryType_PCCT_BROWSE_ROOT,        
            ProdCatalogCategoryType_PCCT_SEARCH,        
            ProdCatalogCategoryType_PCCT_OTHER_SEARCH,        
            ProdCatalogCategoryType_PCCT_QUICK_ADD,        
            ProdCatalogCategoryType_PCCT_PROMOTIONS,        
            ProdCatalogCategoryType_PCCT_MOST_POPULAR,        
            ProdCatalogCategoryType_PCCT_WHATS_NEW,        
            ProdCatalogCategoryType_PCCT_VIEW_ALLW,        
            ProdCatalogCategoryType_PCCT_PURCH_ALLW,        
            ProdCatalogCategoryType_PCCT_ADMIN_ALLW,        
            ProdCatalogCategoryType_PCCT_EBAY_ROOT,        
            ProdCatalogCategoryType_PCCT_BEST_SELL);

    public static final List<ProductMaintTypeData> productMaintTypeList=ImmutableList.of(        
            ProductMaintType_VEHICLE_MAINT,        
            ProductMaintType_OIL_CHANGE,        
            ProductMaintType_SERP_BELT,        
            ProductMaintType_REFUEL,        
            ProductMaintType_REPLACE_BATTERY,        
            ProductMaintType_TUNE_UP,        
            ProductMaintType_CHECK_BATTERY,        
            ProductMaintType_CHASSIS_LUBE,        
            ProductMaintType_ROTATE_TIRES,        
            ProductMaintType_HVAC_MAINT,        
            ProductMaintType_HVAC_REPLACE_FILTER,        
            ProductMaintType_HVAC_CHECK_REFR,        
            ProductMaintType_WASH);

    public static final List<FacilityGroupTypeData> facilityGroupTypeList=ImmutableList.of(        
            FacilityGroupType_MGMT_STRUCTURE,        
            FacilityGroupType_PRICING_GROUP);

    public static final List<InventoryItemTypeData> inventoryItemTypeList=ImmutableList.of(        
            InventoryItemType_SERIALIZED_INV_ITEM,        
            InventoryItemType_NON_SERIAL_INV_ITEM);

    public static final List<ContentTypeData> contentTypeList=ImmutableList.of(        
            ContentType_IMAGE_FRAME);

    public static final List<ProductFeatureIactnTypeData> productFeatureIactnTypeList=ImmutableList.of(        
            ProductFeatureIactnType_FEATURE_IACTN_DEPEND,        
            ProductFeatureIactnType_FEATURE_IACTN_INCOMP);

    public static final List<ShipmentGatewayUspsData> shipmentGatewayUspsList=ImmutableList.of(        
            ShipmentGatewayUsps_USPS_CONFIG);

    public static final List<RoleTypeData> roleTypeList=ImmutableList.of(        
            RoleType_IMAGEAPPROVER);

    public static final List<ProductMeterTypeData> productMeterTypeList=ImmutableList.of(        
            ProductMeterType_SPEEDOMETER,        
            ProductMeterType_TACHOMETER,        
            ProductMeterType_DISTANCE,        
            ProductMeterType_MOTOR_TIME,        
            ProductMeterType_USE_COUNT,        
            ProductMeterType_COPY_COUNT,        
            ProductMeterType_TRIP_METER,        
            ProductMeterType_TACHOGRAPH,        
            ProductMeterType_TAXIMETER,        
            ProductMeterType_EVENT_DATA_RECORDER,        
            ProductMeterType_PEDOMETER,        
            ProductMeterType_ODOMETER);

    public static final List<ShipmentGatewayConfigData> shipmentGatewayConfigList=ImmutableList.of(        
            ShipmentGatewayConfig_DHL_CONFIG,        
            ShipmentGatewayConfig_FEDEX_CONFIG,        
            ShipmentGatewayConfig_UPS_CONFIG,        
            ShipmentGatewayConfig_USPS_CONFIG);

    public static final List<ProductFeatureData> productFeatureList=ImmutableList.of(        
            ProductFeature_IMAGE_AVATAR,        
            ProductFeature_IMAGE_THUMBNAIL,        
            ProductFeature_IMAGE_WEBSITE,        
            ProductFeature_IMAGE_BOARD,        
            ProductFeature_IMAGE_MONITOR15,        
            ProductFeature_IMAGE_MONITOR17,        
            ProductFeature_IMAGE_MONITOR19,        
            ProductFeature_IMAGE_MONITOR21,        
            ProductFeature_TEXT_SMALL,        
            ProductFeature_TEXT_MIDDLE,        
            ProductFeature_TEXT_LARGE,        
            ProductFeature_TEXT_VERYLARGE,        
            ProductFeature_TEXT_WHITE,        
            ProductFeature_TEXT_GRAY,        
            ProductFeature_TEXT_BLACK,        
            ProductFeature_TEXT_RED,        
            ProductFeature_TEXT_GREEN,        
            ProductFeature_TEXT_BLUE,        
            ProductFeature_TEXT_YELLOW);

    public static final List<ShipmentGatewayConfigTypeData> shipmentGatewayConfigTypeList=ImmutableList.of(        
            ShipmentGatewayConfigType_SHIP_GATEWAY_DHL,        
            ShipmentGatewayConfigType_SHIP_GATEWAY_FEDEX,        
            ShipmentGatewayConfigType_SHIP_GATEWAY_UPS,        
            ShipmentGatewayConfigType_SHIP_GATEWAY_USPS);

    public static final List<CustomMethodData> customMethodList=ImmutableList.of(        
            CustomMethod_PROD_PERC_FORMULA,        
            CustomMethod_SHIP_EST_DHL,        
            CustomMethod_SHIP_EST_FEDEX,        
            CustomMethod_SHIP_EST_UPS,        
            CustomMethod_SHIP_EST_USPS,        
            CustomMethod_SHIP_EST_USPS_INT);

    public static final List<ShipmentContactMechTypeData> shipmentContactMechTypeList=ImmutableList.of(        
            ShipmentContactMechType_SHIP_TO_ADDRESS,        
            ShipmentContactMechType_SHIP_FROM_ADDRESS,        
            ShipmentContactMechType_SHIP_TO_TELECOM,        
            ShipmentContactMechType_SHIP_FROM_TELECOM,        
            ShipmentContactMechType_SHIP_TO_EMAIL,        
            ShipmentContactMechType_SHIP_FROM_EMAIL);

    public static final List<StatusItemData> statusItemList=ImmutableList.of(        
            StatusItem_INV_ON_ORDER,        
            StatusItem_INV_AVAILABLE,        
            StatusItem_INV_PROMISED,        
            StatusItem_INV_DELIVERED,        
            StatusItem_INV_ACTIVATED,        
            StatusItem_INV_DEACTIVATED,        
            StatusItem_INV_ON_HOLD,        
            StatusItem_INV_BEING_TRANSFERED,        
            StatusItem_INV_BEING_TRANS_PRM,        
            StatusItem_INV_RETURNED,        
            StatusItem_INV_DEFECTIVE,        
            StatusItem_INV_NS_ON_HOLD,        
            StatusItem_INV_NS_DEFECTIVE,        
            StatusItem_INV_NS_RETURNED,        
            StatusItem_IXF_REQUESTED,        
            StatusItem_IXF_SCHEDULED,        
            StatusItem_IXF_EN_ROUTE,        
            StatusItem_IXF_COMPLETE,        
            StatusItem_IXF_CANCELLED,        
            StatusItem_PRR_PENDING,        
            StatusItem_PRR_APPROVED,        
            StatusItem_PRR_DELETED,        
            StatusItem_IM_PENDING,        
            StatusItem_IM_APPROVED,        
            StatusItem_IM_REJECTED,        
            StatusItem_GO_CREATED,        
            StatusItem_GO_SUCCESS,        
            StatusItem_GO_CANCELLED,        
            StatusItem_SHIPMENT_INPUT,        
            StatusItem_SHIPMENT_SCHEDULED,        
            StatusItem_SHIPMENT_PICKED,        
            StatusItem_SHIPMENT_PACKED,        
            StatusItem_SHIPMENT_SHIPPED,        
            StatusItem_SHIPMENT_DELIVERED,        
            StatusItem_SHIPMENT_CANCELLED,        
            StatusItem_PURCH_SHIP_CREATED,        
            StatusItem_PURCH_SHIP_SHIPPED,        
            StatusItem_PURCH_SHIP_RECEIVED,        
            StatusItem_SHRSCS_NOT_STARTED,        
            StatusItem_SHRSCS_CONFIRMED,        
            StatusItem_SHRSCS_ACCEPTED,        
            StatusItem_SHRSCS_VOIDED,        
            StatusItem_PICKLIST_INPUT,        
            StatusItem_PICKLIST_ASSIGNED,        
            StatusItem_PICKLIST_PRINTED,        
            StatusItem_PICKLIST_PICKED,        
            StatusItem_PICKLIST_CANCELLED,        
            StatusItem_PICKITEM_PENDING,        
            StatusItem_PICKITEM_COMPLETED,        
            StatusItem_PICKITEM_CANCELLED);

    public static final List<StatusValidChangeData> statusValidChangeList=ImmutableList.of(        
            StatusValidChange_INV_ON_ORDER_INV_AVAILABLE,        
            StatusValidChange_INV_AVAILABLE_INV_PROMISED,        
            StatusValidChange_INV_AVAILABLE_INV_ON_HOLD,        
            StatusValidChange_INV_AVAILABLE_INV_DEFECTIVE,        
            StatusValidChange_INV_AVAILABLE_INV_BEING_TRANSFERED,        
            StatusValidChange_INV_ON_HOLD_INV_AVAILABLE,        
            StatusValidChange_INV_ON_HOLD_INV_DEFECTIVE,        
            StatusValidChange_INV_BEING_TRANSFERED_INV_AVAILABLE,        
            StatusValidChange_INV_PROMISED_INV_AVAILABLE,        
            StatusValidChange_INV_PROMISED_INV_DELIVERED,        
            StatusValidChange_INV_PROMISED_INV_DEFECTIVE,        
            StatusValidChange_INV_PROMISED_INV_BEING_TRANS_PRM,        
            StatusValidChange_INV_BEING_TRANS_PRM_INV_PROMISED,        
            StatusValidChange_INV_DELIVERED_INV_RETURNED,        
            StatusValidChange_INV_RETURNED_INV_AVAILABLE,        
            StatusValidChange_INV_RETURNED_INV_ON_HOLD,        
            StatusValidChange_INV_RETURNED_INV_DEFECTIVE,        
            StatusValidChange_INV_DELIVERED_INV_ACTIVATED,        
            StatusValidChange_INV_ACTIVATED_INV_DEACTIVATED,        
            StatusValidChange_INV_ACTIVATED_INV_RETURNED,        
            StatusValidChange_INV_DEACTIVATED_INV_ON_HOLD,        
            StatusValidChange_INV_DEACTIVATED_INV_RETURNED,        
            StatusValidChange_INV_NS_RETURNED_INV_NS_ON_HOLD,        
            StatusValidChange_INV_NS_RETURNED_INV_NS_DEFECTIVE,        
            StatusValidChange_IXF_REQUESTED_IXF_SCHEDULED,        
            StatusValidChange_IXF_REQUESTED_IXF_EN_ROUTE,        
            StatusValidChange_IXF_REQUESTED_IXF_COMPLETE,        
            StatusValidChange_IXF_REQUESTED_IXF_CANCELLED,        
            StatusValidChange_IXF_SCHEDULED_IXF_EN_ROUTE,        
            StatusValidChange_IXF_SCHEDULED_IXF_COMPLETE,        
            StatusValidChange_IXF_SCHEDULED_IXF_CANCELLED,        
            StatusValidChange_IXF_EN_ROUTE_IXF_COMPLETE,        
            StatusValidChange_PRR_PENDING_PRR_APPROVED,        
            StatusValidChange_PRR_PENDING_PRR_DELETED,        
            StatusValidChange_PRR_APPROVED_PRR_DELETED,        
            StatusValidChange_SHIPMENT_INPUT_SHIPMENT_SCHEDULED,        
            StatusValidChange_SHIPMENT_INPUT_SHIPMENT_PICKED,        
            StatusValidChange_SHIPMENT_INPUT_SHIPMENT_PACKED,        
            StatusValidChange_SHIPMENT_SCHEDULED_SHIPMENT_PICKED,        
            StatusValidChange_SHIPMENT_SCHEDULED_SHIPMENT_PACKED,        
            StatusValidChange_SHIPMENT_PICKED_SHIPMENT_PACKED,        
            StatusValidChange_SHIPMENT_PACKED_SHIPMENT_SHIPPED,        
            StatusValidChange_SHIPMENT_SHIPPED_SHIPMENT_DELIVERED,        
            StatusValidChange_SHIPMENT_INPUT_SHIPMENT_CANCELLED,        
            StatusValidChange_SHIPMENT_SCHEDULED_SHIPMENT_CANCELLED,        
            StatusValidChange_SHIPMENT_PICKED_SHIPMENT_CANCELLED,        
            StatusValidChange_PURCH_SHIP_CREATED_PURCH_SHIP_RECEIVED,        
            StatusValidChange_PURCH_SHIP_CREATED_PURCH_SHIP_SHIPPED,        
            StatusValidChange_PURCH_SHIP_SHIPPED_PURCH_SHIP_RECEIVED,        
            StatusValidChange_PURCH_SHIP_RECEIVED_PURCH_SHIP_SHIPPED,        
            StatusValidChange_SHRSCS_NOT_STARTED_SHRSCS_CONFIRMED,        
            StatusValidChange_SHRSCS_CONFIRMED_SHRSCS_ACCEPTED,        
            StatusValidChange_SHRSCS_CONFIRMED_SHRSCS_VOIDED,        
            StatusValidChange_SHRSCS_ACCEPTED_SHRSCS_VOIDED,        
            StatusValidChange_PICKLIST_INPUT_PICKLIST_ASSIGNED,        
            StatusValidChange_PICKLIST_INPUT_PICKLIST_PRINTED,        
            StatusValidChange_PICKLIST_INPUT_PICKLIST_PICKED,        
            StatusValidChange_PICKLIST_INPUT_PICKLIST_CANCELLED,        
            StatusValidChange_PICKLIST_ASSIGNED_PICKLIST_PICKED,        
            StatusValidChange_PICKLIST_ASSIGNED_PICKLIST_PRINTED,        
            StatusValidChange_PICKLIST_ASSIGNED_PICKLIST_CANCELLED,        
            StatusValidChange_PICKLIST_PRINTED_PICKLIST_PICKED,        
            StatusValidChange_PICKLIST_PRINTED_PICKLIST_CANCELLED,        
            StatusValidChange_PICKITEM_PENDING_PICKITEM_COMPLETED,        
            StatusValidChange_PICKITEM_PENDING_PICKITEM_CANCELLED);

    public static final List<QuantityBreakTypeData> quantityBreakTypeList=ImmutableList.of(        
            QuantityBreakType_SHIP_WEIGHT,        
            QuantityBreakType_SHIP_QUANTITY,        
            QuantityBreakType_SHIP_PRICE,        
            QuantityBreakType_QUANTITY,        
            QuantityBreakType_ORDER_VALUE);

    public static final List<FacilityAssocTypeData> facilityAssocTypeList=ImmutableList.of(        
            FacilityAssocType_BACKUP_WAREHOUSE);

    public static final List<SubscriptionTypeData> subscriptionTypeList=ImmutableList.of(        
            SubscriptionType_PRODUCT_SUBSCR);

    public static final List<ShipmentTypeData> shipmentTypeList=ImmutableList.of(        
            ShipmentType_INCOMING_SHIPMENT,        
            ShipmentType_OUTGOING_SHIPMENT,        
            ShipmentType_SALES_RETURN,        
            ShipmentType_SALES_SHIPMENT,        
            ShipmentType_PURCHASE_SHIPMENT,        
            ShipmentType_PURCHASE_RETURN,        
            ShipmentType_DROP_SHIPMENT,        
            ShipmentType_TRANSFER);

    public static final List<ProductCategoryContentTypeData> productCategoryContentTypeList=ImmutableList.of(        
            ProductCategoryContentType_CATEGORY_NAME,        
            ProductCategoryContentType_DESCRIPTION,        
            ProductCategoryContentType_LONG_DESCRIPTION,        
            ProductCategoryContentType_ALTERNATIVE_URL,        
            ProductCategoryContentType_CATEGORY_IMAGE,        
            ProductCategoryContentType_CATEGORY_IMAGE_URL,        
            ProductCategoryContentType_CATEGORY_IMAGE_ALT,        
            ProductCategoryContentType_LINK1_ALT_TEXT,        
            ProductCategoryContentType_LINK2_ALT_TEXT,        
            ProductCategoryContentType_FOOTER,        
            ProductCategoryContentType_PAGE_TITLE,        
            ProductCategoryContentType_META_KEYWORD,        
            ProductCategoryContentType_META_DESCRIPTION,        
            ProductCategoryContentType_RELATED_URL,        
            ProductCategoryContentType_VIDEO,        
            ProductCategoryContentType_VIDEO_URL);

    public static final List<ProductFeatureCategoryData> productFeatureCategoryList=ImmutableList.of(        
            ProductFeatureCategory_IMAGE,        
            ProductFeatureCategory_TEXT);

    public static final List<ProductFeatureApplTypeData> productFeatureApplTypeList=ImmutableList.of(        
            ProductFeatureApplType_OPTIONAL_FEATURE,        
            ProductFeatureApplType_REQUIRED_FEATURE,        
            ProductFeatureApplType_SELECTABLE_FEATURE,        
            ProductFeatureApplType_STANDARD_FEATURE,        
            ProductFeatureApplType_DISTINGUISHING_FEAT);

    public static final List<ProductPricePurposeData> productPricePurposeList=ImmutableList.of(        
            ProductPricePurpose_DEPOSIT,        
            ProductPricePurpose_PURCHASE,        
            ProductPricePurpose_RECURRING_CHARGE,        
            ProductPricePurpose_USAGE_CHARGE,        
            ProductPricePurpose_COMPONENT_PRICE);

    public static final List<ProductPriceTypeData> productPriceTypeList=ImmutableList.of(        
            ProductPriceType_LIST_PRICE,        
            ProductPriceType_DEFAULT_PRICE,        
            ProductPriceType_AVERAGE_COST,        
            ProductPriceType_MINIMUM_PRICE,        
            ProductPriceType_MAXIMUM_PRICE,        
            ProductPriceType_PROMO_PRICE,        
            ProductPriceType_COMPETITIVE_PRICE,        
            ProductPriceType_WHOLESALE_PRICE,        
            ProductPriceType_SPECIAL_PROMO_PRICE,        
            ProductPriceType_BOX_PRICE,        
            ProductPriceType_MINIMUM_ORDER_PRICE,        
            ProductPriceType_SHIPPING_ALLOWANCE);

    public static final List<ShipmentGatewayDhlData> shipmentGatewayDhlList=ImmutableList.of(        
            ShipmentGatewayDhl_DHL_CONFIG);

    public static final List<ProductPriceActionTypeData> productPriceActionTypeList=ImmutableList.of(        
            ProductPriceActionType_PRICE_POL,        
            ProductPriceActionType_PRICE_POD,        
            ProductPriceActionType_PRICE_POAC,        
            ProductPriceActionType_PRICE_POM,        
            ProductPriceActionType_PRICE_POWHS,        
            ProductPriceActionType_PRICE_FOL,        
            ProductPriceActionType_PRICE_FLAT,        
            ProductPriceActionType_PRICE_PFLAT,        
            ProductPriceActionType_PRICE_WFLAT);

    public static final List<ShipmentGatewayFedexData> shipmentGatewayFedexList=ImmutableList.of(        
            ShipmentGatewayFedex_FEDEX_CONFIG);

    public static final List<EnumerationData> enumerationList=ImmutableList.of(        
            Enumeration_PRIP_PRODUCT_ID,        
            Enumeration_PRIP_PROD_CAT_ID,        
            Enumeration_PRIP_PROD_CLG_ID,        
            Enumeration_PRIP_PROD_FEAT_ID,        
            Enumeration_PRIP_PROD_SGRP_ID,        
            Enumeration_PRIP_WEBSITE_ID,        
            Enumeration_PRIP_QUANTITY,        
            Enumeration_PRIP_PARTY_ID,        
            Enumeration_PRIP_PARTY_GRP_MEM,        
            Enumeration_PRIP_PARTY_CLASS,        
            Enumeration_PRIP_ROLE_TYPE,        
            Enumeration_PRIP_LIST_PRICE,        
            Enumeration_PRIP_CURRENCY_UOMID,        
            Enumeration_PRC_EQ,        
            Enumeration_PRC_NEQ,        
            Enumeration_PRC_LT,        
            Enumeration_PRC_LTE,        
            Enumeration_PRC_GT,        
            Enumeration_PRC_GTE,        
            Enumeration_INVRO_FIFO_REC,        
            Enumeration_INVRO_LIFO_REC,        
            Enumeration_INVRO_FIFO_EXP,        
            Enumeration_INVRO_LIFO_EXP,        
            Enumeration_INVRO_GUNIT_COST,        
            Enumeration_INVRO_LUNIT_COST,        
            Enumeration_VAR_LOST,        
            Enumeration_VAR_STOLEN,        
            Enumeration_VAR_FOUND,        
            Enumeration_VAR_DAMAGED,        
            Enumeration_VAR_SAMPLE,        
            Enumeration_VAR_INTEGR,        
            Enumeration_VAR_MISSHIP_ORDERED,        
            Enumeration_VAR_MISSHIP_SHIPPED,        
            Enumeration_PRDS_PAY_AUTH,        
            Enumeration_PRDS_PAY_AUTH_VERIFY,        
            Enumeration_PRDS_PAY_REAUTH,        
            Enumeration_PRDS_PAY_RELEASE,        
            Enumeration_PRDS_PAY_CAPTURE,        
            Enumeration_PRDS_PAY_REFUND,        
            Enumeration_PRDS_PAY_CREDIT,        
            Enumeration_PRDS_PAY_EXTERNAL,        
            Enumeration_PRDS_CUST_REGISTER,        
            Enumeration_PRDS_ODR_CONFIRM,        
            Enumeration_PRDS_ODR_COMPLETE,        
            Enumeration_PRDS_ODR_BACKORDER,        
            Enumeration_PRDS_ODR_CHANGE,        
            Enumeration_PRDS_ODR_PAYRETRY,        
            Enumeration_PRDS_RTN_ACCEPT,        
            Enumeration_PRDS_RTN_COMPLETE,        
            Enumeration_PRDS_RTN_CANCEL,        
            Enumeration_PRDS_PWD_RETRIEVE,        
            Enumeration_PRDS_TELL_FRIEND,        
            Enumeration_PRDS_GC_PURCHASE,        
            Enumeration_PRDS_GC_RELOAD,        
            Enumeration_PRDS_QUO_CREATED,        
            Enumeration_PRDS_QUO_CONFIRM,        
            Enumeration_PRDS_ODR_SHIP_COMPLT,        
            Enumeration_FLT_PICKLOC,        
            Enumeration_FLT_BULK,        
            Enumeration_KOTT_PRODCAT,        
            Enumeration_KOTT_PRODUCT,        
            Enumeration_KOTT_OFBURL,        
            Enumeration_KOTT_AURL,        
            Enumeration_PCLT_SEARCH_PARAM,        
            Enumeration_PCLT_ABS_URL,        
            Enumeration_PCLT_CAT_ID,        
            Enumeration_PG_PURCH_INCLUDE,        
            Enumeration_PG_PURCH_EXCLUDE,        
            Enumeration_PG_SHIP_INCLUDE,        
            Enumeration_PG_SHIP_EXCLUDE,        
            Enumeration_PPIP_ORDER_TOTAL,        
            Enumeration_PPIP_PRODUCT_TOTAL,        
            Enumeration_PPIP_PRODUCT_AMOUNT,        
            Enumeration_PPIP_PRODUCT_QUANT,        
            Enumeration_PPIP_NEW_ACCT,        
            Enumeration_PPIP_PARTY_ID,        
            Enumeration_PPIP_PARTY_GRP_MEM,        
            Enumeration_PPIP_PARTY_CLASS,        
            Enumeration_PPIP_ROLE_TYPE,        
            Enumeration_PPIP_ORST_HIST,        
            Enumeration_PPIP_RECURRENCE,        
            Enumeration_PPIP_ORST_YEAR,        
            Enumeration_PPIP_ORST_LAST_YEAR,        
            Enumeration_PPIP_LPMUP_AMT,        
            Enumeration_PPIP_LPMUP_PER,        
            Enumeration_PPIP_ORDER_SHIPTOTAL,        
            Enumeration_PPIP_SERVICE,        
            Enumeration_PPIP_GEO_ID,        
            Enumeration_PPC_EQ,        
            Enumeration_PPC_NEQ,        
            Enumeration_PPC_LT,        
            Enumeration_PPC_LTE,        
            Enumeration_PPC_GT,        
            Enumeration_PPC_GTE,        
            Enumeration_PPPA_INCLUDE,        
            Enumeration_PPPA_EXCLUDE,        
            Enumeration_PPPA_ALWAYS,        
            Enumeration_PROMO_GWP,        
            Enumeration_PROMO_PROD_DISC,        
            Enumeration_PROMO_PROD_AMDISC,        
            Enumeration_PROMO_PROD_PRICE,        
            Enumeration_PROMO_ORDER_PERCENT,        
            Enumeration_PROMO_ORDER_AMOUNT,        
            Enumeration_PROMO_PROD_SPPRC,        
            Enumeration_PROMO_SHIP_CHARGE,        
            Enumeration_PROMO_SERVICE,        
            Enumeration_PROMO_TAX_PERCENT,        
            Enumeration_PRDR_MIN,        
            Enumeration_PRDR_MAX,        
            Enumeration_PRDR_FLAT,        
            Enumeration_VV_FEATURETREE,        
            Enumeration_VV_VARIANTTREE,        
            Enumeration_PRODRQM_NONE,        
            Enumeration_PRODRQM_AUTO,        
            Enumeration_PRODRQM_STOCK,        
            Enumeration_PRODRQM_STOCK_ATP,        
            Enumeration_PRODRQM_ATP,        
            Enumeration_PRODRQM_DS,        
            Enumeration_PRODRQM_DSATP,        
            Enumeration_RETAKE_PHOTO,        
            Enumeration_REMOVE_LOGO,        
            Enumeration_OTHER,        
            Enumeration_DIRECT_STORE_DELIVRY);

    public static final List<ProductAssocTypeData> productAssocTypeList=ImmutableList.of(        
            ProductAssocType_ALSO_BOUGHT,        
            ProductAssocType_PRODUCT_UPGRADE,        
            ProductAssocType_PRODUCT_COMPLEMENT,        
            ProductAssocType_PRODUCT_INCOMPATABLE,        
            ProductAssocType_PRODUCT_OBSOLESCENCE,        
            ProductAssocType_PRODUCT_COMPONENT,        
            ProductAssocType_PRODUCT_SUBSTITUTE,        
            ProductAssocType_PRODUCT_VARIANT,        
            ProductAssocType_UNIQUE_ITEM,        
            ProductAssocType_PRODUCT_ACCESSORY,        
            ProductAssocType_PRODUCT_REFURB,        
            ProductAssocType_PRODUCT_REPAIR_SRV,        
            ProductAssocType_PRODUCT_AUTORO,        
            ProductAssocType_PRODUCT_REVISION,        
            ProductAssocType_MANUF_COMPONENT,        
            ProductAssocType_ENGINEER_COMPONENT,        
            ProductAssocType_PRODUCT_MANUFACTURED,        
            ProductAssocType_PRODUCT_CONF,        
            ProductAssocType_ALTERNATIVE_PACKAGE);

    public static final List<FacilityGroupData> facilityGroupList=ImmutableList.of(        
            FacilityGroup__NA_);

    public static final List<ProductFeatureTypeData> productFeatureTypeList=ImmutableList.of(        
            ProductFeatureType_ACCESSORY,        
            ProductFeatureType_AMOUNT,        
            ProductFeatureType_NET_WEIGHT,        
            ProductFeatureType_ARTIST,        
            ProductFeatureType_BILLING_FEATURE,        
            ProductFeatureType_BRAND,        
            ProductFeatureType_CARE,        
            ProductFeatureType_COLOR,        
            ProductFeatureType_DIMENSION,        
            ProductFeatureType_EQUIP_CLASS,        
            ProductFeatureType_FABRIC,        
            ProductFeatureType_GENRE,        
            ProductFeatureType_GIFT_WRAP,        
            ProductFeatureType_HARDWARE_FEATURE,        
            ProductFeatureType_HAZMAT,        
            ProductFeatureType_LICENSE,        
            ProductFeatureType_ORIGIN,        
            ProductFeatureType_OTHER_FEATURE,        
            ProductFeatureType_PRODUCT_QUALITY,        
            ProductFeatureType_SIZE,        
            ProductFeatureType_SOFTWARE_FEATURE,        
            ProductFeatureType_STYLE,        
            ProductFeatureType_SYMPTOM,        
            ProductFeatureType_TOPIC,        
            ProductFeatureType_TYPE,        
            ProductFeatureType_WARRANTY,        
            ProductFeatureType_MODEL_YEAR,        
            ProductFeatureType_YEAR_MADE);

    public static final List<ProductTypeData> productTypeList=ImmutableList.of(        
            ProductType_ASSET_USAGE,        
            ProductType_SERVICE,        
            ProductType_GOOD,        
            ProductType_RAW_MATERIAL,        
            ProductType_SUBASSEMBLY,        
            ProductType_FINISHED_GOOD,        
            ProductType_DIGITAL_GOOD,        
            ProductType_FINDIG_GOOD,        
            ProductType_AGGREGATED,        
            ProductType_MARKETING_PKG,        
            ProductType_MARKETING_PKG_AUTO,        
            ProductType_MARKETING_PKG_PICK,        
            ProductType_WIP,        
            ProductType_AGGREGATED_CONF,        
            ProductType_ASSET_USAGE_OUT_IN,        
            ProductType_SERVICE_PRODUCT,        
            ProductType_AGGREGATED_SERVICE,        
            ProductType_AGGREGATEDSERV_CONF);

    public static final List<EnumerationTypeData> enumerationTypeList=ImmutableList.of(        
            EnumerationType_PROD_PRICE,        
            EnumerationType_PROD_PRICE_IN_PARAM,        
            EnumerationType_PROD_PRICE_COND,        
            EnumerationType_INV_RES_ORDER,        
            EnumerationType_IID_REASON,        
            EnumerationType_PRDS_PAYSVC,        
            EnumerationType_PRDS_EMAIL,        
            EnumerationType_FACLOC_TYPE,        
            EnumerationType_KWOVRD_TRGT_TYPE,        
            EnumerationType_PCAT_LINK_TYPE,        
            EnumerationType_PROD_GEO,        
            EnumerationType_PROD_PROMO,        
            EnumerationType_PROD_PROMO_IN_PARAM,        
            EnumerationType_PROD_PROMO_COND,        
            EnumerationType_PROD_PROMO_PCAPPL,        
            EnumerationType_PROD_PROMO_ACTION,        
            EnumerationType_PROD_RATING_TYPE,        
            EnumerationType_PROD_VVMETHOD,        
            EnumerationType_PROD_REQ_METHOD,        
            EnumerationType_IMAGE_REJECT_REASON);

    public static final List<VarianceReasonData> varianceReasonList=ImmutableList.of(        
            VarianceReason_VAR_LOST,        
            VarianceReason_VAR_STOLEN,        
            VarianceReason_VAR_FOUND,        
            VarianceReason_VAR_DAMAGED,        
            VarianceReason_VAR_INTEGR,        
            VarianceReason_VAR_SAMPLE,        
            VarianceReason_VAR_MISSHIP_ORDERED,        
            VarianceReason_VAR_MISSHIP_SHIPPED);

    public static final List<ProductContentTypeData> productContentTypeList=ImmutableList.of(        
            ProductContentType_ONLINE_ACCESS,        
            ProductContentType_DIGITAL_DOWNLOAD,        
            ProductContentType_FULFILLMENT_EMAIL,        
            ProductContentType_FULFILLMENT_EXTASYNC,        
            ProductContentType_FULFILLMENT_EXTSYNC,        
            ProductContentType_PRODUCT_NAME,        
            ProductContentType_DESCRIPTION,        
            ProductContentType_LONG_DESCRIPTION,        
            ProductContentType_ALTERNATIVE_URL,        
            ProductContentType_PRICE_DETAIL_TEXT,        
            ProductContentType_INGREDIENTS,        
            ProductContentType_UNIQUE_INGREDIENTS,        
            ProductContentType_SPECIALINSTRUCTIONS,        
            ProductContentType_WARNINGS,        
            ProductContentType_DIRECTIONS,        
            ProductContentType_TERMS_AND_CONDS,        
            ProductContentType_DELIVERY_INFO,        
            ProductContentType_SMALL_IMAGE_URL,        
            ProductContentType_MEDIUM_IMAGE_URL,        
            ProductContentType_LARGE_IMAGE_URL,        
            ProductContentType_DETAIL_IMAGE_URL,        
            ProductContentType_ORIGINAL_IMAGE_URL,        
            ProductContentType_SMALL_IMAGE_ALT,        
            ProductContentType_MEDIUM_IMAGE_ALT,        
            ProductContentType_LARGE_IMAGE_ALT,        
            ProductContentType_DETAIL_IMAGE_ALT,        
            ProductContentType_ADDITIONAL_IMAGE_1,        
            ProductContentType_ADDITIONAL_IMAGE_2,        
            ProductContentType_ADDITIONAL_IMAGE_3,        
            ProductContentType_ADDITIONAL_IMAGE_4,        
            ProductContentType_XTRA_IMG_1_SMALL,        
            ProductContentType_XTRA_IMG_1_MEDIUM,        
            ProductContentType_XTRA_IMG_1_LARGE,        
            ProductContentType_XTRA_IMG_1_DETAIL,        
            ProductContentType_XTRA_IMG_2_SMALL,        
            ProductContentType_XTRA_IMG_2_MEDIUM,        
            ProductContentType_XTRA_IMG_2_LARGE,        
            ProductContentType_XTRA_IMG_2_DETAIL,        
            ProductContentType_XTRA_IMG_3_SMALL,        
            ProductContentType_XTRA_IMG_3_MEDIUM,        
            ProductContentType_XTRA_IMG_3_LARGE,        
            ProductContentType_XTRA_IMG_3_DETAIL,        
            ProductContentType_XTRA_IMG_4_SMALL,        
            ProductContentType_XTRA_IMG_4_MEDIUM,        
            ProductContentType_XTRA_IMG_4_LARGE,        
            ProductContentType_XTRA_IMG_4_DETAIL,        
            ProductContentType_XTRA_IMG_L_SMALL,        
            ProductContentType_XTRA_IMG_L_MEDIUM,        
            ProductContentType_XTRA_IMG_L_LARGE,        
            ProductContentType_XTRA_IMG_L_DETAIL,        
            ProductContentType_ADDTOCART_LABEL,        
            ProductContentType_ADDTOCART_IMAGE,        
            ProductContentType_SHORT_SALES_PITCH,        
            ProductContentType_INSTALLATION,        
            ProductContentType_SPECIFICATION,        
            ProductContentType_WARRANTY,        
            ProductContentType_PAGE_TITLE,        
            ProductContentType_META_KEYWORD,        
            ProductContentType_META_DESCRIPTION,        
            ProductContentType_IMAGE,        
            ProductContentType_DEFAULT_IMAGE);

    public static final List<GoodIdentificationTypeData> goodIdentificationTypeList=ImmutableList.of(        
            GoodIdentificationType_ISBN,        
            GoodIdentificationType_MANUFACTURER_ID_NO,        
            GoodIdentificationType_MODEL_YEAR,        
            GoodIdentificationType_OTHER_ID,        
            GoodIdentificationType_SKU,        
            GoodIdentificationType_UPCA,        
            GoodIdentificationType_UPCE,        
            GoodIdentificationType_EAN,        
            GoodIdentificationType_LOC,        
            GoodIdentificationType_HS_CODE);

    public static final List<ProdConfItemContentTypeData> prodConfItemContentTypeList=ImmutableList.of(        
            ProdConfItemContentType_IMAGE_URL,        
            ProdConfItemContentType_DESCRIPTION,        
            ProdConfItemContentType_LONG_DESCRIPTION,        
            ProdConfItemContentType_INSTRUCTIONS);

    public static final List<SupplierPrefOrderData> supplierPrefOrderList=ImmutableList.of(        
            SupplierPrefOrder_10_MAIN_SUPPL,        
            SupplierPrefOrder_90_ALT_SUPPL);

    public static final List<RejectionReasonData> rejectionReasonList=ImmutableList.of(        
            RejectionReason_SRJ_DAMAGED,        
            RejectionReason_SRJ_NOT_ORDERED,        
            RejectionReason_SRJ_OVER_SHIPPED);

    public static final List<ShipmentGatewayUpsData> shipmentGatewayUpsList=ImmutableList.of(        
            ShipmentGatewayUps_UPS_CONFIG);

    public static final List<ProductCategoryTypeData> productCategoryTypeList=ImmutableList.of(        
            ProductCategoryType_CATALOG_CATEGORY,        
            ProductCategoryType_INDUSTRY_CATEGORY,        
            ProductCategoryType_INTERNAL_CATEGORY,        
            ProductCategoryType_MATERIALS_CATEGORY,        
            ProductCategoryType_QUICKADD_CATEGORY,        
            ProductCategoryType_SEARCH_CATEGORY,        
            ProductCategoryType_USAGE_CATEGORY,        
            ProductCategoryType_MIXMATCH_CATEGORY,        
            ProductCategoryType_CROSS_SELL_CATEGORY,        
            ProductCategoryType_TAX_CATEGORY,        
            ProductCategoryType_GOOGLE_BASE_CATEGORY,        
            ProductCategoryType_GIFT_CARD_CATEGORY,        
            ProductCategoryType_BEST_SELL_CATEGORY);

    public static final List<CostComponentTypeData> costComponentTypeList=ImmutableList.of(        
            CostComponentType_MAT_COST,        
            CostComponentType_ROUTE_COST,        
            CostComponentType_LABOR_COST,        
            CostComponentType_GEN_COST,        
            CostComponentType_IND_COST,        
            CostComponentType_OTHER_COST,        
            CostComponentType_EST_STD_MAT_COST,        
            CostComponentType_EST_STD_ROUTE_COST,        
            CostComponentType_EST_STD_LABOR_COST,        
            CostComponentType_EST_STD_GEN_COST,        
            CostComponentType_EST_STD_IND_COST,        
            CostComponentType_EST_STD_OTHER_COST,        
            CostComponentType_ACTUAL_MAT_COST,        
            CostComponentType_ACTUAL_ROUTE_COST,        
            CostComponentType_ACTUAL_LABOR_COST,        
            CostComponentType_ACTUAL_OTHER_COST,        
            CostComponentType_ACTUAL_GEN_COST,        
            CostComponentType_ACTUAL_IND_COST);

    public static final List<ProductStoreGroupData> productStoreGroupList=ImmutableList.of(        
            ProductStoreGroup__NA_);

    public static final List<StatusTypeData> statusTypeList=ImmutableList.of(        
            StatusType_INVENTORY_ITEM_STTS,        
            StatusType_INV_SERIALIZED_STTS,        
            StatusType_INV_NON_SER_STTS,        
            StatusType_INVENTORY_XFER_STTS,        
            StatusType_PRODUCT_REVIEW_STTS,        
            StatusType_IMAGE_MANAGEMENT_ST,        
            StatusType_GROUP_ORDER_STATUS,        
            StatusType_SHIPMENT_STATUS,        
            StatusType_PURCH_SHIP_STATUS,        
            StatusType_SHPRTSG_CS_STATUS,        
            StatusType_PICKLIST_STATUS,        
            StatusType_PICKITEM_STATUS);

    public static final List<CustomMethodTypeData> customMethodTypeList=ImmutableList.of(        
            CustomMethodType_COST_FORMULA,        
            CustomMethodType_PRICE_FORMULA,        
            CustomMethodType_SHIP_EST);

    public static final List<FacilityTypeData> facilityTypeList=ImmutableList.of(        
            FacilityType_BUILDING,        
            FacilityType_FLOOR,        
            FacilityType_OFFICE,        
            FacilityType_CALL_CENTER,        
            FacilityType_PLANT,        
            FacilityType_ROOM,        
            FacilityType_RETAIL_STORE,        
            FacilityType_WAREHOUSE);

}
