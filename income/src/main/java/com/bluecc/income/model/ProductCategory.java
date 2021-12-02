package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;

import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.ProductCategoryFlatData;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    String productCategoryId;
    String productCategoryTypeId;
    String primaryParentCategoryId;
    String categoryName;
    String description;
    String longDescription;
    String categoryImageUrl;
    String linkOneImageUrl;
    String linkTwoImageUrl;
    String detailScreen;
    Character showInSelect;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public ProductCategoryFlatData toData() {
        ProductCategoryFlatData.Builder builder = ProductCategoryFlatData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (productCategoryTypeId != null) {
            builder.setProductCategoryTypeId(productCategoryTypeId);
        }
        if (primaryParentCategoryId != null) {
            builder.setPrimaryParentCategoryId(primaryParentCategoryId);
        }
        if (categoryName != null) {
            builder.setCategoryName(categoryName);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (longDescription != null) {
            builder.setLongDescription(longDescription);
        }
        if (categoryImageUrl != null) {
            builder.setCategoryImageUrl(categoryImageUrl);
        }
        if (linkOneImageUrl != null) {
            builder.setLinkOneImageUrl(linkOneImageUrl);
        }
        if (linkTwoImageUrl != null) {
            builder.setLinkTwoImageUrl(linkTwoImageUrl);
        }
        if (detailScreen != null) {
            builder.setDetailScreen(detailScreen);
        }
        if (showInSelect != null) {
            builder.setShowInSelect(getIndicator(showInSelect));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder.build();
    }

    public static ProductCategory fromData(ProductCategoryFlatData data) {
        return ProductCategory.builder()
                .productCategoryId(data.getProductCategoryId())
                .productCategoryTypeId(data.getProductCategoryTypeId())
                .primaryParentCategoryId(data.getPrimaryParentCategoryId())
                .categoryName(data.getCategoryName())
                .description(data.getDescription())
                .longDescription(data.getLongDescription())
                .categoryImageUrl(data.getCategoryImageUrl())
                .linkOneImageUrl(data.getLinkOneImageUrl())
                .linkTwoImageUrl(data.getLinkTwoImageUrl())
                .detailScreen(data.getDetailScreen())
                .showInSelect(getIndicatorChar(data.getShowInSelect()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

}
