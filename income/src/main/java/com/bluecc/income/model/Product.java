package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ProductFlatData;

import com.bluecc.hubs.stub.ProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements IEventModel<ProductFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String productId;
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
                
                .build();
    }

    
    @SuppressWarnings("unchecked")
    public <T extends Message.Builder> T toHeadBuilder() {
        ProductData.Builder builder = ProductData.newBuilder();
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productTypeId != null) {
            builder.setProductTypeId(productTypeId);
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
                    
        return (T)builder;
    }

}
