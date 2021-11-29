package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
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
    java.net.URI smallImageUrl;
    java.net.URI mediumImageUrl;
    java.net.URI largeImageUrl;
    java.net.URI detailImageUrl;
    java.net.URI originalImageUrl;
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
    
}
