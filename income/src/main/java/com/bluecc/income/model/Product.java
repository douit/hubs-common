//// Generated, DO NOT EDIT
package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;
// import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;
import static com.bluecc.hubs.fund.FnUtil.getter;

import com.bluecc.hubs.stub.ProductFlatData;

import com.bluecc.hubs.stub.ProductData;
import com.bluecc.income.dao.ProductDelegator;
import static com.bluecc.income.dao.ProductDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductData.class,
        symbol = EntityNames.Product)
public class Product implements IEventModel<ProductFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_id")
	@RId 
    String productId;
    @SerializedName("product_type_id") 
    String productTypeId;
    @SerializedName("primary_product_category_id") 
    String primaryProductCategoryId;
    @SerializedName("facility_id") 
    String facilityId;
    @SerializedName("introduction_date") 
    java.time.LocalDateTime introductionDate;
    @SerializedName("release_date") 
    java.time.LocalDateTime releaseDate;
    @SerializedName("support_discontinuation_date") 
    java.time.LocalDateTime supportDiscontinuationDate;
    @SerializedName("sales_discontinuation_date") 
    java.time.LocalDateTime salesDiscontinuationDate;
    @SerializedName("sales_disc_when_not_avail") 
    Character salesDiscWhenNotAvail;
    @SerializedName("internal_name") 
    String internalName;
    @SerializedName("brand_name") 
    String brandName;
    @SerializedName("comments") 
    String comments;
    @SerializedName("product_name") 
    String productName;
    @SerializedName("description") 
    String description;
    @SerializedName("long_description") 
    String longDescription;
    @SerializedName("price_detail_text") 
    String priceDetailText;
    @SerializedName("small_image_url") 
    String smallImageUrl;
    @SerializedName("medium_image_url") 
    String mediumImageUrl;
    @SerializedName("large_image_url") 
    String largeImageUrl;
    @SerializedName("detail_image_url") 
    String detailImageUrl;
    @SerializedName("original_image_url") 
    String originalImageUrl;
    @SerializedName("detail_screen") 
    String detailScreen;
    @SerializedName("inventory_message") 
    String inventoryMessage;
    @SerializedName("inventory_item_type_id") 
    String inventoryItemTypeId;
    @SerializedName("require_inventory") 
    Character requireInventory;
    @SerializedName("quantity_uom_id") 
    String quantityUomId;
    @SerializedName("quantity_included") 
    java.math.BigDecimal quantityIncluded;
    @SerializedName("pieces_included") 
    Long piecesIncluded;
    @SerializedName("require_amount") 
    Character requireAmount;
    @SerializedName("fixed_amount") 
    java.math.BigDecimal fixedAmount;
    @SerializedName("amount_uom_type_id") 
    String amountUomTypeId;
    @SerializedName("weight_uom_id") 
    String weightUomId;
    @SerializedName("shipping_weight") 
    java.math.BigDecimal shippingWeight;
    @SerializedName("product_weight") 
    java.math.BigDecimal productWeight;
    @SerializedName("height_uom_id") 
    String heightUomId;
    @SerializedName("product_height") 
    java.math.BigDecimal productHeight;
    @SerializedName("shipping_height") 
    java.math.BigDecimal shippingHeight;
    @SerializedName("width_uom_id") 
    String widthUomId;
    @SerializedName("product_width") 
    java.math.BigDecimal productWidth;
    @SerializedName("shipping_width") 
    java.math.BigDecimal shippingWidth;
    @SerializedName("depth_uom_id") 
    String depthUomId;
    @SerializedName("product_depth") 
    java.math.BigDecimal productDepth;
    @SerializedName("shipping_depth") 
    java.math.BigDecimal shippingDepth;
    @SerializedName("diameter_uom_id") 
    String diameterUomId;
    @SerializedName("product_diameter") 
    java.math.BigDecimal productDiameter;
    @SerializedName("product_rating") 
    java.math.BigDecimal productRating;
    @SerializedName("rating_type_enum") 
    String ratingTypeEnum;
    @SerializedName("returnable") 
    Character returnable;
    @SerializedName("taxable") 
    Character taxable;
    @SerializedName("charge_shipping") 
    Character chargeShipping;
    @SerializedName("auto_create_keywords") 
    Character autoCreateKeywords;
    @SerializedName("include_in_promotions") 
    Character includeInPromotions;
    @SerializedName("is_virtual") 
    Character isVirtual;
    @SerializedName("is_variant") 
    Character isVariant;
    @SerializedName("virtual_variant_method_enum") 
    String virtualVariantMethodEnum;
    @SerializedName("origin_geo_id") 
    String originGeoId;
    @SerializedName("requirement_method_enum_id") 
    String requirementMethodEnumId;
    @SerializedName("bill_of_material_level") 
    Long billOfMaterialLevel;
    @SerializedName("reserv_max_persons") 
    java.math.BigDecimal reservMaxPersons;
    @SerializedName("reserv_2nd_p_p_perc") 
    java.math.BigDecimal reserv2ndPPPerc;
    @SerializedName("reserv_nth_p_p_perc") 
    java.math.BigDecimal reservNthPPPerc;
    @SerializedName("config_id") 
    String configId;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
    @SerializedName("in_shipping_box") 
    Character inShippingBox;
    @SerializedName("default_shipment_box_type_id") 
    String defaultShipmentBoxTypeId;
    @SerializedName("lot_id_filled_in") 
    String lotIdFilledIn;
    @SerializedName("order_decimal_quantity") 
    Character orderDecimalQuantity;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return productId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductFlatData.Builder toDataBuilder() {
        ProductFlatData.Builder builder = ProductFlatData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productTypeId != null) {
            builder.setProductTypeId(productTypeId);
        }
        if (primaryProductCategoryId != null) {
            builder.setPrimaryProductCategoryId(primaryProductCategoryId);
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (introductionDate != null) {
            builder.setIntroductionDate(getTimestamp(introductionDate));
        }
        if (releaseDate != null) {
            builder.setReleaseDate(getTimestamp(releaseDate));
        }
        if (supportDiscontinuationDate != null) {
            builder.setSupportDiscontinuationDate(getTimestamp(supportDiscontinuationDate));
        }
        if (salesDiscontinuationDate != null) {
            builder.setSalesDiscontinuationDate(getTimestamp(salesDiscontinuationDate));
        }
        if (salesDiscWhenNotAvail != null) {
            builder.setSalesDiscWhenNotAvail(getIndicator(salesDiscWhenNotAvail));
        }
        if (internalName != null) {
            builder.setInternalName(internalName);
        }
        if (brandName != null) {
            builder.setBrandName(brandName);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (productName != null) {
            builder.setProductName(productName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (longDescription != null) {
            builder.setLongDescription(longDescription);
        }
        if (priceDetailText != null) {
            builder.setPriceDetailText(priceDetailText);
        }
        if (smallImageUrl != null) {
            builder.setSmallImageUrl(smallImageUrl);
        }
        if (mediumImageUrl != null) {
            builder.setMediumImageUrl(mediumImageUrl);
        }
        if (largeImageUrl != null) {
            builder.setLargeImageUrl(largeImageUrl);
        }
        if (detailImageUrl != null) {
            builder.setDetailImageUrl(detailImageUrl);
        }
        if (originalImageUrl != null) {
            builder.setOriginalImageUrl(originalImageUrl);
        }
        if (detailScreen != null) {
            builder.setDetailScreen(detailScreen);
        }
        if (inventoryMessage != null) {
            builder.setInventoryMessage(inventoryMessage);
        }
        if (inventoryItemTypeId != null) {
            builder.setInventoryItemTypeId(inventoryItemTypeId);
        }
        if (requireInventory != null) {
            builder.setRequireInventory(getIndicator(requireInventory));
        }
        if (quantityUomId != null) {
            builder.setQuantityUomId(quantityUomId);
        }
        if (quantityIncluded != null) {
            builder.setQuantityIncluded(getFixedPoint(quantityIncluded));
        }
        if (piecesIncluded != null) {
            builder.setPiecesIncluded(piecesIncluded);
        }
        if (requireAmount != null) {
            builder.setRequireAmount(getIndicator(requireAmount));
        }
        if (fixedAmount != null) {
            builder.setFixedAmount(getCurrency(fixedAmount));
        }
        if (amountUomTypeId != null) {
            builder.setAmountUomTypeId(amountUomTypeId);
        }
        if (weightUomId != null) {
            builder.setWeightUomId(weightUomId);
        }
        if (shippingWeight != null) {
            builder.setShippingWeight(getFixedPoint(shippingWeight));
        }
        if (productWeight != null) {
            builder.setProductWeight(getFixedPoint(productWeight));
        }
        if (heightUomId != null) {
            builder.setHeightUomId(heightUomId);
        }
        if (productHeight != null) {
            builder.setProductHeight(getFixedPoint(productHeight));
        }
        if (shippingHeight != null) {
            builder.setShippingHeight(getFixedPoint(shippingHeight));
        }
        if (widthUomId != null) {
            builder.setWidthUomId(widthUomId);
        }
        if (productWidth != null) {
            builder.setProductWidth(getFixedPoint(productWidth));
        }
        if (shippingWidth != null) {
            builder.setShippingWidth(getFixedPoint(shippingWidth));
        }
        if (depthUomId != null) {
            builder.setDepthUomId(depthUomId);
        }
        if (productDepth != null) {
            builder.setProductDepth(getFixedPoint(productDepth));
        }
        if (shippingDepth != null) {
            builder.setShippingDepth(getFixedPoint(shippingDepth));
        }
        if (diameterUomId != null) {
            builder.setDiameterUomId(diameterUomId);
        }
        if (productDiameter != null) {
            builder.setProductDiameter(getFixedPoint(productDiameter));
        }
        if (productRating != null) {
            builder.setProductRating(getFixedPoint(productRating));
        }
        if (ratingTypeEnum != null) {
            builder.setRatingTypeEnum(ratingTypeEnum);
        }
        if (returnable != null) {
            builder.setReturnable(getIndicator(returnable));
        }
        if (taxable != null) {
            builder.setTaxable(getIndicator(taxable));
        }
        if (chargeShipping != null) {
            builder.setChargeShipping(getIndicator(chargeShipping));
        }
        if (autoCreateKeywords != null) {
            builder.setAutoCreateKeywords(getIndicator(autoCreateKeywords));
        }
        if (includeInPromotions != null) {
            builder.setIncludeInPromotions(getIndicator(includeInPromotions));
        }
        if (isVirtual != null) {
            builder.setIsVirtual(getIndicator(isVirtual));
        }
        if (isVariant != null) {
            builder.setIsVariant(getIndicator(isVariant));
        }
        if (virtualVariantMethodEnum != null) {
            builder.setVirtualVariantMethodEnum(virtualVariantMethodEnum);
        }
        if (originGeoId != null) {
            builder.setOriginGeoId(originGeoId);
        }
        if (requirementMethodEnumId != null) {
            builder.setRequirementMethodEnumId(requirementMethodEnumId);
        }
        if (billOfMaterialLevel != null) {
            builder.setBillOfMaterialLevel(billOfMaterialLevel);
        }
        if (reservMaxPersons != null) {
            builder.setReservMaxPersons(getFixedPoint(reservMaxPersons));
        }
        if (reserv2ndPPPerc != null) {
            builder.setReserv2NdPPPerc(getFixedPoint(reserv2ndPPPerc));
        }
        if (reservNthPPPerc != null) {
            builder.setReservNthPPPerc(getFixedPoint(reservNthPPPerc));
        }
        if (configId != null) {
            builder.setConfigId(configId);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (createdByUserLogin != null) {
            builder.setCreatedByUserLogin(createdByUserLogin);
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (lastModifiedByUserLogin != null) {
            builder.setLastModifiedByUserLogin(lastModifiedByUserLogin);
        }
        if (inShippingBox != null) {
            builder.setInShippingBox(getIndicator(inShippingBox));
        }
        if (defaultShipmentBoxTypeId != null) {
            builder.setDefaultShipmentBoxTypeId(defaultShipmentBoxTypeId);
        }
        if (lotIdFilledIn != null) {
            builder.setLotIdFilledIn(lotIdFilledIn);
        }
        if (orderDecimalQuantity != null) {
            builder.setOrderDecimalQuantity(getIndicator(orderDecimalQuantity));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static Product fromData(ProductFlatData data) {
        return Product.builder()
                .productId(data.getProductId())
                .productTypeId(data.getProductTypeId())
                .primaryProductCategoryId(data.getPrimaryProductCategoryId())
                .facilityId(data.getFacilityId())
                .introductionDate(getLocalDateTime(data.getIntroductionDate()))
                .releaseDate(getLocalDateTime(data.getReleaseDate()))
                .supportDiscontinuationDate(getLocalDateTime(data.getSupportDiscontinuationDate()))
                .salesDiscontinuationDate(getLocalDateTime(data.getSalesDiscontinuationDate()))
                .salesDiscWhenNotAvail(getIndicatorChar(data.getSalesDiscWhenNotAvail()))
                .internalName(data.getInternalName())
                .brandName(data.getBrandName())
                .comments(data.getComments())
                .productName(data.getProductName())
                .description(data.getDescription())
                .longDescription(data.getLongDescription())
                .priceDetailText(data.getPriceDetailText())
                .smallImageUrl(data.getSmallImageUrl())
                .mediumImageUrl(data.getMediumImageUrl())
                .largeImageUrl(data.getLargeImageUrl())
                .detailImageUrl(data.getDetailImageUrl())
                .originalImageUrl(data.getOriginalImageUrl())
                .detailScreen(data.getDetailScreen())
                .inventoryMessage(data.getInventoryMessage())
                .inventoryItemTypeId(data.getInventoryItemTypeId())
                .requireInventory(getIndicatorChar(data.getRequireInventory()))
                .quantityUomId(data.getQuantityUomId())
                .quantityIncluded(getBigDecimal(data.getQuantityIncluded()))
                .piecesIncluded(data.getPiecesIncluded())
                .requireAmount(getIndicatorChar(data.getRequireAmount()))
                .fixedAmount(getBigDecimal(data.getFixedAmount()))
                .amountUomTypeId(data.getAmountUomTypeId())
                .weightUomId(data.getWeightUomId())
                .shippingWeight(getBigDecimal(data.getShippingWeight()))
                .productWeight(getBigDecimal(data.getProductWeight()))
                .heightUomId(data.getHeightUomId())
                .productHeight(getBigDecimal(data.getProductHeight()))
                .shippingHeight(getBigDecimal(data.getShippingHeight()))
                .widthUomId(data.getWidthUomId())
                .productWidth(getBigDecimal(data.getProductWidth()))
                .shippingWidth(getBigDecimal(data.getShippingWidth()))
                .depthUomId(data.getDepthUomId())
                .productDepth(getBigDecimal(data.getProductDepth()))
                .shippingDepth(getBigDecimal(data.getShippingDepth()))
                .diameterUomId(data.getDiameterUomId())
                .productDiameter(getBigDecimal(data.getProductDiameter()))
                .productRating(getBigDecimal(data.getProductRating()))
                .ratingTypeEnum(data.getRatingTypeEnum())
                .returnable(getIndicatorChar(data.getReturnable()))
                .taxable(getIndicatorChar(data.getTaxable()))
                .chargeShipping(getIndicatorChar(data.getChargeShipping()))
                .autoCreateKeywords(getIndicatorChar(data.getAutoCreateKeywords()))
                .includeInPromotions(getIndicatorChar(data.getIncludeInPromotions()))
                .isVirtual(getIndicatorChar(data.getIsVirtual()))
                .isVariant(getIndicatorChar(data.getIsVariant()))
                .virtualVariantMethodEnum(data.getVirtualVariantMethodEnum())
                .originGeoId(data.getOriginGeoId())
                .requirementMethodEnumId(data.getRequirementMethodEnumId())
                .billOfMaterialLevel(data.getBillOfMaterialLevel())
                .reservMaxPersons(getBigDecimal(data.getReservMaxPersons()))
                .reserv2ndPPPerc(getBigDecimal(data.getReserv2NdPPPerc()))
                .reservNthPPPerc(getBigDecimal(data.getReservNthPPPerc()))
                .configId(data.getConfigId())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .inShippingBox(getIndicatorChar(data.getInShippingBox()))
                .defaultShipmentBoxTypeId(data.getDefaultShipmentBoxTypeId())
                .lotIdFilledIn(data.getLotIdFilledIn())
                .orderDecimalQuantity(getIndicatorChar(data.getOrderDecimalQuantity()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addPrimaryProductCategory")
    @SerializedName("primary_product_category") 
    List<ProductCategory> relPrimaryProductCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addFacility")
    @SerializedName("facility") 
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByUserLogin")
    @SerializedName("created_by_user_login") 
    List<UserLogin> relCreatedByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByUserLogin")
    @SerializedName("last_modified_by_user_login") 
    List<UserLogin> relLastModifiedByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addDefaultShipmentBoxType")
    @SerializedName("default_shipment_box_type") 
    List<ShipmentBoxType> relDefaultShipmentBoxType= new ArrayList<>(); 
    @Exclude
    @Singular("addAgreement")
    @SerializedName("agreement") 
    List<Agreement> relAgreement= new ArrayList<>(); 
    @Exclude
    @Singular("addAgreementProductAppl")
    @SerializedName("agreement_product_appl") 
    List<AgreementProductAppl> relAgreementProductAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addCustRequestItem")
    @SerializedName("cust_request_item") 
    List<CustRequestItem> relCustRequestItem= new ArrayList<>(); 
    @Exclude
    @Singular("addInstanceOfFixedAsset")
    @SerializedName("instance_of_fixed_asset") 
    List<FixedAsset> relInstanceOfFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetProduct")
    @SerializedName("fixed_asset_product") 
    List<FixedAssetProduct> relFixedAssetProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItem")
    @SerializedName("inventory_item") 
    List<InventoryItem> relInventoryItem= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceItem")
    @SerializedName("invoice_item") 
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItem")
    @SerializedName("order_item") 
    List<OrderItem> relOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addMainProductAssoc")
    @SerializedName("main_product_assoc") 
    List<ProductAssoc> relMainProductAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addAssocProductAssoc")
    @SerializedName("assoc_product_assoc") 
    List<ProductAssoc> relAssocProductAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategoryMember")
    @SerializedName("product_category_member") 
    List<ProductCategoryMember> relProductCategoryMember= new ArrayList<>(); 
    @Exclude
    @Singular("addProductProductConfig")
    @SerializedName("product_product_config") 
    List<ProductConfig> relProductProductConfig= new ArrayList<>(); 
    @Exclude
    @Singular("addProductProductConfigProduct")
    @SerializedName("product_product_config_product") 
    List<ProductConfigProduct> relProductProductConfigProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addProductContent")
    @SerializedName("product_content") 
    List<ProductContent> relProductContent= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacility")
    @SerializedName("product_facility") 
    List<ProductFacility> relProductFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacilityAssoc")
    @SerializedName("product_facility_assoc") 
    List<ProductFacilityAssoc> relProductFacilityAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacilityLocation")
    @SerializedName("product_facility_location") 
    List<ProductFacilityLocation> relProductFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFeatureAppl")
    @SerializedName("product_feature_appl") 
    List<ProductFeatureAppl> relProductFeatureAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addProductKeyword")
    @SerializedName("product_keyword") 
    List<ProductKeyword> relProductKeyword= new ArrayList<>(); 
    @Exclude
    @Singular("addProductPrice")
    @SerializedName("product_price") 
    List<ProductPrice> relProductPrice= new ArrayList<>(); 
    @Exclude
    @Singular("addProductPromoProduct")
    @SerializedName("product_promo_product") 
    List<ProductPromoProduct> relProductPromoProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addProductReview")
    @SerializedName("product_review") 
    List<ProductReview> relProductReview= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreSurveyAppl")
    @SerializedName("product_store_survey_appl") 
    List<ProductStoreSurveyAppl> relProductStoreSurveyAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addProductSubscriptionResource")
    @SerializedName("product_subscription_resource") 
    List<ProductSubscriptionResource> relProductSubscriptionResource= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteItem")
    @SerializedName("quote_item") 
    List<QuoteItem> relQuoteItem= new ArrayList<>(); 
    @Exclude
    @Singular("addRequirement")
    @SerializedName("requirement") 
    List<Requirement> relRequirement= new ArrayList<>(); 
    @Exclude
    @Singular("addReturnItem")
    @SerializedName("return_item") 
    List<ReturnItem> relReturnItem= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentItem")
    @SerializedName("shipment_item") 
    List<ShipmentItem> relShipmentItem= new ArrayList<>(); 
    @Exclude
    @Singular("addSubShipmentPackageContent")
    @SerializedName("sub_shipment_package_content") 
    List<ShipmentPackageContent> relSubShipmentPackageContent= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    @SerializedName("shipment_receipt") 
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addShoppingListItem")
    @SerializedName("shopping_list_item") 
    List<ShoppingListItem> relShoppingListItem= new ArrayList<>(); 
    @Exclude
    @Singular("addSupplierProduct")
    @SerializedName("supplier_product") 
    List<SupplierProduct> relSupplierProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortGoodStandard")
    @SerializedName("work_effort_good_standard") 
    List<WorkEffortGoodStandard> relWorkEffortGoodStandard= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PRIMARY_PRODUCT_CATEGORY, getter(this, Product::getRelPrimaryProductCategory)); 
        supplierMap.put(FACILITY, getter(this, Product::getRelFacility)); 
        supplierMap.put(CREATED_BY_USER_LOGIN, getter(this, Product::getRelCreatedByUserLogin)); 
        supplierMap.put(LAST_MODIFIED_BY_USER_LOGIN, getter(this, Product::getRelLastModifiedByUserLogin)); 
        supplierMap.put(DEFAULT_SHIPMENT_BOX_TYPE, getter(this, Product::getRelDefaultShipmentBoxType)); 
        supplierMap.put(AGREEMENT, getter(this, Product::getRelAgreement)); 
        supplierMap.put(AGREEMENT_PRODUCT_APPL, getter(this, Product::getRelAgreementProductAppl)); 
        supplierMap.put(CUST_REQUEST_ITEM, getter(this, Product::getRelCustRequestItem)); 
        supplierMap.put(INSTANCE_OF_FIXED_ASSET, getter(this, Product::getRelInstanceOfFixedAsset)); 
        supplierMap.put(FIXED_ASSET_PRODUCT, getter(this, Product::getRelFixedAssetProduct)); 
        supplierMap.put(INVENTORY_ITEM, getter(this, Product::getRelInventoryItem)); 
        supplierMap.put(INVOICE_ITEM, getter(this, Product::getRelInvoiceItem)); 
        supplierMap.put(ORDER_ITEM, getter(this, Product::getRelOrderItem)); 
        supplierMap.put(MAIN_PRODUCT_ASSOC, getter(this, Product::getRelMainProductAssoc)); 
        supplierMap.put(ASSOC_PRODUCT_ASSOC, getter(this, Product::getRelAssocProductAssoc)); 
        supplierMap.put(PRODUCT_CATEGORY_MEMBER, getter(this, Product::getRelProductCategoryMember)); 
        supplierMap.put(PRODUCT_PRODUCT_CONFIG, getter(this, Product::getRelProductProductConfig)); 
        supplierMap.put(PRODUCT_PRODUCT_CONFIG_PRODUCT, getter(this, Product::getRelProductProductConfigProduct)); 
        supplierMap.put(PRODUCT_CONTENT, getter(this, Product::getRelProductContent)); 
        supplierMap.put(PRODUCT_FACILITY, getter(this, Product::getRelProductFacility)); 
        supplierMap.put(PRODUCT_FACILITY_ASSOC, getter(this, Product::getRelProductFacilityAssoc)); 
        supplierMap.put(PRODUCT_FACILITY_LOCATION, getter(this, Product::getRelProductFacilityLocation)); 
        supplierMap.put(PRODUCT_FEATURE_APPL, getter(this, Product::getRelProductFeatureAppl)); 
        supplierMap.put(PRODUCT_KEYWORD, getter(this, Product::getRelProductKeyword)); 
        supplierMap.put(PRODUCT_PRICE, getter(this, Product::getRelProductPrice)); 
        supplierMap.put(PRODUCT_PROMO_PRODUCT, getter(this, Product::getRelProductPromoProduct)); 
        supplierMap.put(PRODUCT_REVIEW, getter(this, Product::getRelProductReview)); 
        supplierMap.put(PRODUCT_STORE_SURVEY_APPL, getter(this, Product::getRelProductStoreSurveyAppl)); 
        supplierMap.put(PRODUCT_SUBSCRIPTION_RESOURCE, getter(this, Product::getRelProductSubscriptionResource)); 
        supplierMap.put(QUOTE_ITEM, getter(this, Product::getRelQuoteItem)); 
        supplierMap.put(REQUIREMENT, getter(this, Product::getRelRequirement)); 
        supplierMap.put(RETURN_ITEM, getter(this, Product::getRelReturnItem)); 
        supplierMap.put(SHIPMENT_ITEM, getter(this, Product::getRelShipmentItem)); 
        supplierMap.put(SUB_SHIPMENT_PACKAGE_CONTENT, getter(this, Product::getRelSubShipmentPackageContent)); 
        supplierMap.put(SHIPMENT_RECEIPT, getter(this, Product::getRelShipmentReceipt)); 
        supplierMap.put(SHOPPING_LIST_ITEM, getter(this, Product::getRelShoppingListItem)); 
        supplierMap.put(SUPPLIER_PRODUCT, getter(this, Product::getRelSupplierProduct)); 
        supplierMap.put(WORK_EFFORT_GOOD_STANDARD, getter(this, Product::getRelWorkEffortGoodStandard)); 
        supplierMap.put(TENANT, getter(this, Product::getRelTenant));

        return supplierMap;
    };

    public ProductDelegator.Agent agent(IProc.ProcContext ctx,
                                             ProductDelegator delegator){
        return delegator.getAgent(ctx, this.getProductId());
    }

    public ProductData.Builder toHeadBuilder() {
        ProductData.Builder builder = ProductData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productTypeId != null) {
            builder.setProductTypeId(productTypeId);
        }
        if (introductionDate != null) {
            builder.setIntroductionDate(getTimestamp(introductionDate));
        }
        if (releaseDate != null) {
            builder.setReleaseDate(getTimestamp(releaseDate));
        }
        if (supportDiscontinuationDate != null) {
            builder.setSupportDiscontinuationDate(getTimestamp(supportDiscontinuationDate));
        }
        if (salesDiscontinuationDate != null) {
            builder.setSalesDiscontinuationDate(getTimestamp(salesDiscontinuationDate));
        }
        if (salesDiscWhenNotAvail != null) {
            builder.setSalesDiscWhenNotAvail(getIndicator(salesDiscWhenNotAvail));
        }
        if (internalName != null) {
            builder.setInternalName(internalName);
        }
        if (brandName != null) {
            builder.setBrandName(brandName);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (productName != null) {
            builder.setProductName(productName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (longDescription != null) {
            builder.setLongDescription(longDescription);
        }
        if (priceDetailText != null) {
            builder.setPriceDetailText(priceDetailText);
        }
        if (smallImageUrl != null) {
            builder.setSmallImageUrl(smallImageUrl);
        }
        if (mediumImageUrl != null) {
            builder.setMediumImageUrl(mediumImageUrl);
        }
        if (largeImageUrl != null) {
            builder.setLargeImageUrl(largeImageUrl);
        }
        if (detailImageUrl != null) {
            builder.setDetailImageUrl(detailImageUrl);
        }
        if (originalImageUrl != null) {
            builder.setOriginalImageUrl(originalImageUrl);
        }
        if (detailScreen != null) {
            builder.setDetailScreen(detailScreen);
        }
        if (inventoryMessage != null) {
            builder.setInventoryMessage(inventoryMessage);
        }
        if (inventoryItemTypeId != null) {
            builder.setInventoryItemTypeId(inventoryItemTypeId);
        }
        if (requireInventory != null) {
            builder.setRequireInventory(getIndicator(requireInventory));
        }
        if (quantityUomId != null) {
            builder.setQuantityUomId(quantityUomId);
        }
        if (quantityIncluded != null) {
            builder.setQuantityIncluded(getFixedPoint(quantityIncluded));
        }
        if (piecesIncluded != null) {
            builder.setPiecesIncluded(piecesIncluded);
        }
        if (requireAmount != null) {
            builder.setRequireAmount(getIndicator(requireAmount));
        }
        if (fixedAmount != null) {
            builder.setFixedAmount(getCurrency(fixedAmount));
        }
        if (amountUomTypeId != null) {
            builder.setAmountUomTypeId(amountUomTypeId);
        }
        if (weightUomId != null) {
            builder.setWeightUomId(weightUomId);
        }
        if (shippingWeight != null) {
            builder.setShippingWeight(getFixedPoint(shippingWeight));
        }
        if (productWeight != null) {
            builder.setProductWeight(getFixedPoint(productWeight));
        }
        if (heightUomId != null) {
            builder.setHeightUomId(heightUomId);
        }
        if (productHeight != null) {
            builder.setProductHeight(getFixedPoint(productHeight));
        }
        if (shippingHeight != null) {
            builder.setShippingHeight(getFixedPoint(shippingHeight));
        }
        if (widthUomId != null) {
            builder.setWidthUomId(widthUomId);
        }
        if (productWidth != null) {
            builder.setProductWidth(getFixedPoint(productWidth));
        }
        if (shippingWidth != null) {
            builder.setShippingWidth(getFixedPoint(shippingWidth));
        }
        if (depthUomId != null) {
            builder.setDepthUomId(depthUomId);
        }
        if (productDepth != null) {
            builder.setProductDepth(getFixedPoint(productDepth));
        }
        if (shippingDepth != null) {
            builder.setShippingDepth(getFixedPoint(shippingDepth));
        }
        if (diameterUomId != null) {
            builder.setDiameterUomId(diameterUomId);
        }
        if (productDiameter != null) {
            builder.setProductDiameter(getFixedPoint(productDiameter));
        }
        if (productRating != null) {
            builder.setProductRating(getFixedPoint(productRating));
        }
        if (ratingTypeEnum != null) {
            builder.setRatingTypeEnum(ratingTypeEnum);
        }
        if (returnable != null) {
            builder.setReturnable(getIndicator(returnable));
        }
        if (taxable != null) {
            builder.setTaxable(getIndicator(taxable));
        }
        if (chargeShipping != null) {
            builder.setChargeShipping(getIndicator(chargeShipping));
        }
        if (autoCreateKeywords != null) {
            builder.setAutoCreateKeywords(getIndicator(autoCreateKeywords));
        }
        if (includeInPromotions != null) {
            builder.setIncludeInPromotions(getIndicator(includeInPromotions));
        }
        if (isVirtual != null) {
            builder.setIsVirtual(getIndicator(isVirtual));
        }
        if (isVariant != null) {
            builder.setIsVariant(getIndicator(isVariant));
        }
        if (virtualVariantMethodEnum != null) {
            builder.setVirtualVariantMethodEnum(virtualVariantMethodEnum);
        }
        if (originGeoId != null) {
            builder.setOriginGeoId(originGeoId);
        }
        if (requirementMethodEnumId != null) {
            builder.setRequirementMethodEnumId(requirementMethodEnumId);
        }
        if (billOfMaterialLevel != null) {
            builder.setBillOfMaterialLevel(billOfMaterialLevel);
        }
        if (reservMaxPersons != null) {
            builder.setReservMaxPersons(getFixedPoint(reservMaxPersons));
        }
        if (reserv2ndPPPerc != null) {
            builder.setReserv2NdPPPerc(getFixedPoint(reserv2ndPPPerc));
        }
        if (reservNthPPPerc != null) {
            builder.setReservNthPPPerc(getFixedPoint(reservNthPPPerc));
        }
        if (configId != null) {
            builder.setConfigId(configId);
        }
        if (createdDate != null) {
            builder.setCreatedDate(getTimestamp(createdDate));
        }
        if (lastModifiedDate != null) {
            builder.setLastModifiedDate(getTimestamp(lastModifiedDate));
        }
        if (inShippingBox != null) {
            builder.setInShippingBox(getIndicator(inShippingBox));
        }
        if (lotIdFilledIn != null) {
            builder.setLotIdFilledIn(lotIdFilledIn);
        }
        if (orderDecimalQuantity != null) {
            builder.setOrderDecimalQuantity(getIndicator(orderDecimalQuantity));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}


/*
-- keys: productId

-- fields --
    
    String productId
    String productTypeId
    String primaryProductCategoryId
    String facilityId
    java.time.LocalDateTime introductionDate
    java.time.LocalDateTime releaseDate
    java.time.LocalDateTime supportDiscontinuationDate
    java.time.LocalDateTime salesDiscontinuationDate
    Character salesDiscWhenNotAvail
    String internalName
    String brandName
    String comments
    String productName
    String description
    String longDescription
    String priceDetailText
    String smallImageUrl
    String mediumImageUrl
    String largeImageUrl
    String detailImageUrl
    String originalImageUrl
    String detailScreen
    String inventoryMessage
    String inventoryItemTypeId
    Character requireInventory
    String quantityUomId
    java.math.BigDecimal quantityIncluded
    Long piecesIncluded
    Character requireAmount
    java.math.BigDecimal fixedAmount
    String amountUomTypeId
    String weightUomId
    java.math.BigDecimal shippingWeight
    java.math.BigDecimal productWeight
    String heightUomId
    java.math.BigDecimal productHeight
    java.math.BigDecimal shippingHeight
    String widthUomId
    java.math.BigDecimal productWidth
    java.math.BigDecimal shippingWidth
    String depthUomId
    java.math.BigDecimal productDepth
    java.math.BigDecimal shippingDepth
    String diameterUomId
    java.math.BigDecimal productDiameter
    java.math.BigDecimal productRating
    String ratingTypeEnum
    Character returnable
    Character taxable
    Character chargeShipping
    Character autoCreateKeywords
    Character includeInPromotions
    Character isVirtual
    Character isVariant
    String virtualVariantMethodEnum
    String originGeoId
    String requirementMethodEnumId
    Long billOfMaterialLevel
    java.math.BigDecimal reservMaxPersons
    java.math.BigDecimal reserv2ndPPPerc
    java.math.BigDecimal reservNthPPPerc
    String configId
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin
    Character inShippingBox
    String defaultShipmentBoxTypeId
    String lotIdFilledIn
    Character orderDecimalQuantity

-- relations --
    
    - ProductType (one, autoRelation: false, keymaps: productTypeId)
    + ProductTypeAttr (many, autoRelation: false, keymaps: productTypeId)
    - PrimaryProductCategory (one, autoRelation: false, keymaps: primaryProductCategoryId -> productCategoryId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - QuantityUom (one, autoRelation: false, keymaps: quantityUomId -> uomId)
    - AmountUomType (one, autoRelation: false, keymaps: amountUomTypeId -> uomTypeId)
    - WeightUom (one, autoRelation: false, keymaps: weightUomId -> uomId)
    - HeightUom (one, autoRelation: false, keymaps: heightUomId -> uomId)
    - WidthUom (one, autoRelation: false, keymaps: widthUomId -> uomId)
    - DepthUom (one, autoRelation: false, keymaps: depthUomId -> uomId)
    - DiameterUom (one, autoRelation: false, keymaps: diameterUomId -> uomId)
    - VirtualVariantMethodEnumeration (one, autoRelation: false, keymaps: virtualVariantMethodEnum -> enumId)
    - RatingEnumeration (one, autoRelation: false, keymaps: ratingTypeEnum -> enumId)
    - RequirementMethodEnumeration (one, autoRelation: false, keymaps: requirementMethodEnumId -> enumId)
    - OriginGeo (one, autoRelation: false, keymaps: originGeoId -> geoId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    + ProductFeatureAndAppl (many, autoRelation: false, keymaps: productId)
    - DefaultShipmentBoxType (one, autoRelation: false, keymaps: defaultShipmentBoxTypeId -> shipmentBoxTypeId)
    - InventoryItemType (one, autoRelation: false, keymaps: inventoryItemTypeId)
    + Agreement (many, autoRelation: true, keymaps: productId)
    + AgreementProductAppl (many, autoRelation: true, keymaps: productId)
    + CartAbandonedLine (many, autoRelation: true, keymaps: productId)
    + CommunicationEventProduct (many, autoRelation: true, keymaps: productId)
    + CostComponent (many, autoRelation: true, keymaps: productId)
    + CustRequestItem (many, autoRelation: true, keymaps: productId)
    + InstanceOfFixedAsset (many, autoRelation: true, keymaps: productId -> instanceOfProductId)
    + FixedAssetProduct (many, autoRelation: true, keymaps: productId)
    + GoodIdentification (many, autoRelation: true, keymaps: productId)
    + InventoryItem (many, autoRelation: true, keymaps: productId)
    + InventoryItemTempRes (many, autoRelation: true, keymaps: productId)
    + InvoiceItem (many, autoRelation: true, keymaps: productId)
    + MrpEvent (many, autoRelation: true, keymaps: productId)
    + OrderItem (many, autoRelation: true, keymaps: productId)
    + OrderSummaryEntry (many, autoRelation: true, keymaps: productId)
    + PartyNeed (many, autoRelation: true, keymaps: productId)
    + MainProductAssoc (many, autoRelation: true, keymaps: productId)
    + AssocProductAssoc (many, autoRelation: true, keymaps: productId -> productIdTo)
    + ProductAttribute (many, autoRelation: true, keymaps: productId)
    + ProductAverageCost (many, autoRelation: true, keymaps: productId)
    - ProductCalculatedInfo (one-nofk, autoRelation: true, keymaps: productId)
    + ProductCategoryMember (many, autoRelation: true, keymaps: productId)
    + ProductProductConfig (many, autoRelation: true, keymaps: productId)
    + ProductProductConfigProduct (many, autoRelation: true, keymaps: productId)
    + ProductProductConfigStats (many, autoRelation: true, keymaps: productId)
    + ProductContent (many, autoRelation: true, keymaps: productId)
    + ProductCostComponentCalc (many, autoRelation: true, keymaps: productId)
    + ProductFacility (many, autoRelation: true, keymaps: productId)
    + ProductFacilityAssoc (many, autoRelation: true, keymaps: productId)
    + ProductFacilityLocation (many, autoRelation: true, keymaps: productId)
    + ProductFeatureAppl (many, autoRelation: true, keymaps: productId)
    + ProductFeatureApplAttr (many, autoRelation: true, keymaps: productId)
    + ProductGeo (many, autoRelation: true, keymaps: productId)
    + ProductGlAccount (many, autoRelation: true, keymaps: productId)
    + ProductGroupOrder (many, autoRelation: true, keymaps: productId)
    + ProductKeyword (many, autoRelation: true, keymaps: productId)
    + ProductMaint (many, autoRelation: true, keymaps: productId)
    + ProductManufacturingRule (many, autoRelation: true, keymaps: productId)
    + ProductForProductManufacturingRule (many, autoRelation: true, keymaps: productId -> productIdFor)
    + ProductInProductManufacturingRule (many, autoRelation: true, keymaps: productId -> productIdIn)
    + ProductSubstProductManufacturingRule (many, autoRelation: true, keymaps: productId -> productIdInSubst)
    + ProductMeter (many, autoRelation: true, keymaps: productId)
    + ProductOrderItem (many, autoRelation: true, keymaps: productId)
    + ProductPaymentMethodType (many, autoRelation: true, keymaps: productId)
    + ProductPrice (many, autoRelation: true, keymaps: productId)
    + ProductPromoProduct (many, autoRelation: true, keymaps: productId)
    + ProductReview (many, autoRelation: true, keymaps: productId)
    + ProductRole (many, autoRelation: true, keymaps: productId)
    + ProductStoreSurveyAppl (many, autoRelation: true, keymaps: productId)
    + ProductSubscriptionResource (many, autoRelation: true, keymaps: productId)
    + QuoteItem (many, autoRelation: true, keymaps: productId)
    + ReorderGuideline (many, autoRelation: true, keymaps: productId)
    + Requirement (many, autoRelation: true, keymaps: productId)
    + ReturnItem (many, autoRelation: true, keymaps: productId)
    + SalesForecastDetail (many, autoRelation: true, keymaps: productId)
    + ShipmentItem (many, autoRelation: true, keymaps: productId)
    + SubShipmentPackageContent (many, autoRelation: true, keymaps: productId -> subProductId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: productId)
    + ShoppingListItem (many, autoRelation: true, keymaps: productId)
    + Subscription (many, autoRelation: true, keymaps: productId)
    + SupplierProduct (many, autoRelation: true, keymaps: productId)
    + VendorProduct (many, autoRelation: true, keymaps: productId)
    + WorkEffortGoodStandard (many, autoRelation: true, keymaps: productId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

