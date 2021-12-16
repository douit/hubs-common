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

import com.bluecc.hubs.stub.ProductPromoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoData.class,
        symbol = EntityNames.ProductPromo)
public class ProductPromo implements IEventModel<ProductPromoData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String productPromoId;
    String promoName;
    String promoText;
    Character userEntered;
    Character showToCustomer;
    Character requireCode;
    Long useLimitPerOrder;
    Long useLimitPerCustomer;
    Long useLimitPerPromotion;
    java.math.BigDecimal billbackFactor;
    String overrideOrgPartyId;
    java.time.LocalDateTime createdDate;
    String createdByUserLogin;
    java.time.LocalDateTime lastModifiedDate;
    String lastModifiedByUserLogin;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoData.Builder toDataBuilder() {
        ProductPromoData.Builder builder = ProductPromoData.newBuilder();
        if (productPromoId != null) {
            builder.setProductPromoId(productPromoId);
        }
        if (promoName != null) {
            builder.setPromoName(promoName);
        }
        if (promoText != null) {
            builder.setPromoText(promoText);
        }
        if (userEntered != null) {
            builder.setUserEntered(getIndicator(userEntered));
        }
        if (showToCustomer != null) {
            builder.setShowToCustomer(getIndicator(showToCustomer));
        }
        if (requireCode != null) {
            builder.setRequireCode(getIndicator(requireCode));
        }
        if (useLimitPerOrder != null) {
            builder.setUseLimitPerOrder(useLimitPerOrder);
        }
        if (useLimitPerCustomer != null) {
            builder.setUseLimitPerCustomer(useLimitPerCustomer);
        }
        if (useLimitPerPromotion != null) {
            builder.setUseLimitPerPromotion(useLimitPerPromotion);
        }
        if (billbackFactor != null) {
            builder.setBillbackFactor(getFixedPoint(billbackFactor));
        }
        if (overrideOrgPartyId != null) {
            builder.setOverrideOrgPartyId(overrideOrgPartyId);
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
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static ProductPromo fromData(ProductPromoData data) {
        return ProductPromo.builder()
                .productPromoId(data.getProductPromoId())
                .promoName(data.getPromoName())
                .promoText(data.getPromoText())
                .userEntered(getIndicatorChar(data.getUserEntered()))
                .showToCustomer(getIndicatorChar(data.getShowToCustomer()))
                .requireCode(getIndicatorChar(data.getRequireCode()))
                .useLimitPerOrder(data.getUseLimitPerOrder())
                .useLimitPerCustomer(data.getUseLimitPerCustomer())
                .useLimitPerPromotion(data.getUseLimitPerPromotion())
                .billbackFactor(getBigDecimal(data.getBillbackFactor()))
                .overrideOrgPartyId(data.getOverrideOrgPartyId())
                .createdDate(getLocalDateTime(data.getCreatedDate()))
                .createdByUserLogin(data.getCreatedByUserLogin())
                .lastModifiedDate(getLocalDateTime(data.getLastModifiedDate()))
                .lastModifiedByUserLogin(data.getLastModifiedByUserLogin())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: productPromoId

-- fields --
    
    String productPromoId
    String promoName
    String promoText
    Character userEntered
    Character showToCustomer
    Character requireCode
    Long useLimitPerOrder
    Long useLimitPerCustomer
    Long useLimitPerPromotion
    java.math.BigDecimal billbackFactor
    String overrideOrgPartyId
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - Party (one, autoRelation: false, keymaps: overrideOrgPartyId -> partyId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    + AgreementPromoAppl (many, autoRelation: true, keymaps: productPromoId)
    + MarketingCampaignPromo (many, autoRelation: true, keymaps: productPromoId)
    + OrderAdjustment (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoAction (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoCategory (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoCode (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoCond (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoContent (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoProduct (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoRule (many, autoRelation: true, keymaps: productPromoId)
    + ProductPromoUse (many, autoRelation: true, keymaps: productPromoId)
    + ProductStorePromoAppl (many, autoRelation: true, keymaps: productPromoId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: productPromoId)
    + ReturnAdjustment (many, autoRelation: true, keymaps: productPromoId)
*/

