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
public class Product implements IEventModel<ProductFlatData.Builder>, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String productId;
    String productTypeId;
    String primaryProductCategoryId;
    String facilityId;
    java.time.LocalDateTime introductionDate;
    java.time.LocalDateTime releaseDate;
    java.time.LocalDateTime supportDiscontinuationDate;
    java.time.LocalDateTime salesDiscontinuationDate;
    Character salesDiscWhenNotAvail;
    String internalName;
    String brandName;
    String comments;
    String productName;
    String description;
    String longDescription;
    String priceDetailText;
    String smallImageUrl;
    String mediumImageUrl;
    String largeImageUrl;
    String detailImageUrl;
    String originalImageUrl;
    String detailScreen;
    String inventoryMessage;
    String inventoryItemTypeId;
    Character requireInventory;
    String quantityUomId;
    java.math.BigDecimal quantityIncluded;
    Long piecesIncluded;
    Character requireAmount;
    java.math.BigDecimal fixedAmount;
    String amountUomTypeId;
    String weightUomId;
    java.math.BigDecimal shippingWeight;
    java.math.BigDecimal productWeight;
    String heightUomId;
    java.math.BigDecimal productHeight;
    java.math.BigDecimal shippingHeight;
    String widthUomId;
    java.math.BigDecimal productWidth;
    java.math.BigDecimal shippingWidth;
    String depthUomId;
    java.math.BigDecimal productDepth;
    java.math.BigDecimal shippingDepth;
    String diameterUomId;
    java.math.BigDecimal productDiameter;
    java.math.BigDecimal productRating;
    String ratingTypeEnum;
    Character returnable;
    Character taxable;
    Character chargeShipping;
    Character autoCreateKeywords;
    Character includeInPromotions;
    Character isVirtual;
    Character isVariant;
    String virtualVariantMethodEnum;
    String originGeoId;
    String requirementMethodEnumId;
    Long billOfMaterialLevel;
    java.math.BigDecimal reservMaxPersons;
    java.math.BigDecimal reserv2ndPPPerc;
    java.math.BigDecimal reservNthPPPerc;
    String configId;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    Character inShippingBox;
    String defaultShipmentBoxTypeId;
    String lotIdFilledIn;
    Character orderDecimalQuantity;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String tenantId;
    

        
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
    List<ProductCategory> relPrimaryProductCategory= new ArrayList<>(); 
    @Exclude
    @Singular("addFacility")
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addCreatedByUserLogin")
    List<UserLogin> relCreatedByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addLastModifiedByUserLogin")
    List<UserLogin> relLastModifiedByUserLogin= new ArrayList<>(); 
    @Exclude
    @Singular("addDefaultShipmentBoxType")
    List<ShipmentBoxType> relDefaultShipmentBoxType= new ArrayList<>(); 
    @Exclude
    @Singular("addAgreement")
    List<Agreement> relAgreement= new ArrayList<>(); 
    @Exclude
    @Singular("addAgreementProductAppl")
    List<AgreementProductAppl> relAgreementProductAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addCustRequestItem")
    List<CustRequestItem> relCustRequestItem= new ArrayList<>(); 
    @Exclude
    @Singular("addInstanceOfFixedAsset")
    List<FixedAsset> relInstanceOfFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetProduct")
    List<FixedAssetProduct> relFixedAssetProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItem")
    List<InventoryItem> relInventoryItem= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceItem")
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItem")
    List<OrderItem> relOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addMainProductAssoc")
    List<ProductAssoc> relMainProductAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addAssocProductAssoc")
    List<ProductAssoc> relAssocProductAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addProductCategoryMember")
    List<ProductCategoryMember> relProductCategoryMember= new ArrayList<>(); 
    @Exclude
    @Singular("addProductProductConfig")
    List<ProductConfig> relProductProductConfig= new ArrayList<>(); 
    @Exclude
    @Singular("addProductProductConfigProduct")
    List<ProductConfigProduct> relProductProductConfigProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addProductContent")
    List<ProductContent> relProductContent= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacility")
    List<ProductFacility> relProductFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacilityAssoc")
    List<ProductFacilityAssoc> relProductFacilityAssoc= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacilityLocation")
    List<ProductFacilityLocation> relProductFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFeatureAppl")
    List<ProductFeatureAppl> relProductFeatureAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addProductKeyword")
    List<ProductKeyword> relProductKeyword= new ArrayList<>(); 
    @Exclude
    @Singular("addProductPrice")
    List<ProductPrice> relProductPrice= new ArrayList<>(); 
    @Exclude
    @Singular("addProductPromoProduct")
    List<ProductPromoProduct> relProductPromoProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addProductReview")
    List<ProductReview> relProductReview= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStoreSurveyAppl")
    List<ProductStoreSurveyAppl> relProductStoreSurveyAppl= new ArrayList<>(); 
    @Exclude
    @Singular("addProductSubscriptionResource")
    List<ProductSubscriptionResource> relProductSubscriptionResource= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteItem")
    List<QuoteItem> relQuoteItem= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentItem")
    List<ShipmentItem> relShipmentItem= new ArrayList<>(); 
    @Exclude
    @Singular("addSubShipmentPackageContent")
    List<ShipmentPackageContent> relSubShipmentPackageContent= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addSupplierProduct")
    List<SupplierProduct> relSupplierProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortGoodStandard")
    List<WorkEffortGoodStandard> relWorkEffortGoodStandard= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
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
        supplierMap.put(SHIPMENT_ITEM, getter(this, Product::getRelShipmentItem)); 
        supplierMap.put(SUB_SHIPMENT_PACKAGE_CONTENT, getter(this, Product::getRelSubShipmentPackageContent)); 
        supplierMap.put(SHIPMENT_RECEIPT, getter(this, Product::getRelShipmentReceipt)); 
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

