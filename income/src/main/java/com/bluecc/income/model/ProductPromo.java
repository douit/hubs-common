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

import com.bluecc.hubs.stub.ProductPromoData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoData.class,
        symbol = EntityNames.ProductPromo)
public class ProductPromo implements IEventModel<ProductPromoData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_promo_id")
	@RId 
    String productPromoId;
    @SerializedName("promo_name") 
    String promoName;
    @SerializedName("promo_text") 
    String promoText;
    @SerializedName("user_entered") 
    Character userEntered;
    @SerializedName("show_to_customer") 
    Character showToCustomer;
    @SerializedName("require_code") 
    Character requireCode;
    @SerializedName("use_limit_per_order") 
    Long useLimitPerOrder;
    @SerializedName("use_limit_per_customer") 
    Long useLimitPerCustomer;
    @SerializedName("use_limit_per_promotion") 
    Long useLimitPerPromotion;
    @SerializedName("billback_factor") 
    java.math.BigDecimal billbackFactor;
    @SerializedName("override_org_party_id") 
    String overrideOrgPartyId;
    @SerializedName("created_date") 
    java.time.LocalDateTime createdDate;
    @SerializedName("created_by_user_login_id") 
    String createdByUserLogin;
    @SerializedName("last_modified_date") 
    java.time.LocalDateTime lastModifiedDate;
    @SerializedName("last_modified_by_user_login_id") 
    String lastModifiedByUserLogin;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return productPromoId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoData.Builder toDataBuilder() {
        ProductPromoData.Builder builder = ProductPromoData.newBuilder();
        if (getProductPromoId() != null) {
            builder.setProductPromoId(getProductPromoId());
        }
        if (getPromoName() != null) {
            builder.setPromoName(getPromoName());
        }
        if (getPromoText() != null) {
            builder.setPromoText(getPromoText());
        }
        if (getUserEntered() != null) {
            builder.setUserEntered(getIndicator(getUserEntered()));
        }
        if (getShowToCustomer() != null) {
            builder.setShowToCustomer(getIndicator(getShowToCustomer()));
        }
        if (getRequireCode() != null) {
            builder.setRequireCode(getIndicator(getRequireCode()));
        }
        if (getUseLimitPerOrder() != null) {
            builder.setUseLimitPerOrder(getUseLimitPerOrder());
        }
        if (getUseLimitPerCustomer() != null) {
            builder.setUseLimitPerCustomer(getUseLimitPerCustomer());
        }
        if (getUseLimitPerPromotion() != null) {
            builder.setUseLimitPerPromotion(getUseLimitPerPromotion());
        }
        if (getBillbackFactor() != null) {
            builder.setBillbackFactor(getFixedPoint(getBillbackFactor()));
        }
        if (getOverrideOrgPartyId() != null) {
            builder.setOverrideOrgPartyId(getOverrideOrgPartyId());
        }
        if (getCreatedDate() != null) {
            builder.setCreatedDate(getTimestamp(getCreatedDate()));
        }
        if (getCreatedByUserLogin() != null) {
            builder.setCreatedByUserLogin(getCreatedByUserLogin());
        }
        if (getLastModifiedDate() != null) {
            builder.setLastModifiedDate(getTimestamp(getLastModifiedDate()));
        }
        if (getLastModifiedByUserLogin() != null) {
            builder.setLastModifiedByUserLogin(getLastModifiedByUserLogin());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static ProductPromo fromData(ProductPromoData data) {
        return fromPrototype(data).build();
    }

    public static ProductPromo.ProductPromoBuilder fromPrototype(ProductPromoData data) {
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
                ;
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

