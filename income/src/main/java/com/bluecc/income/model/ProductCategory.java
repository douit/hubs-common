package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import org.redisson.api.annotation.*;

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.ProductCategoryFlatData;

import com.bluecc.hubs.stub.ProductCategoryData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductCategoryData.class,
        symbol = EntityNames.ProductCategory)
public class ProductCategory implements IEventModel<ProductCategoryFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String productCategoryId;
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
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductCategoryFlatData.Builder toDataBuilder() {
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
                    
        return builder;
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

        // relations
     
    List<ProductCategory> relPrimaryParentProductCategory= new ArrayList<>(); 
    List<ProductCategory> relPrimaryChildProductCategory= new ArrayList<>(); 
    List<ProdCatalogCategory> relProdCatalogCategory= new ArrayList<>(); 
    List<Product> relPrimaryProduct= new ArrayList<>(); 
    List<ProductCategoryContent> relProductCategoryContent= new ArrayList<>(); 
    List<ProductCategoryLink> relProductCategoryLink= new ArrayList<>(); 
    List<ProductCategoryMember> relProductCategoryMember= new ArrayList<>(); 
    List<ProductCategoryRole> relProductCategoryRole= new ArrayList<>(); 
    List<ProductCategoryRollup> relCurrentProductCategoryRollup= new ArrayList<>(); 
    List<ProductCategoryRollup> relParentProductCategoryRollup= new ArrayList<>(); 
    List<ProductFeatureCategoryAppl> relProductFeatureCategoryAppl= new ArrayList<>(); 
    List<ProductPromoCategory> relProductPromoCategory= new ArrayList<>(); 
    List<ProductStoreSurveyAppl> relProductStoreSurveyAppl= new ArrayList<>(); 
    List<TaxAuthorityCategory> relTaxAuthorityCategory= new ArrayList<>(); 
    List<TaxAuthorityRateProduct> relTaxAuthorityRateProduct= new ArrayList<>();

    public ProductCategoryData.Builder toHeadBuilder() {
        ProductCategoryData.Builder builder = ProductCategoryData.newBuilder();
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (productCategoryTypeId != null) {
            builder.setProductCategoryTypeId(productCategoryTypeId);
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
                    
        return builder;
    }

}
