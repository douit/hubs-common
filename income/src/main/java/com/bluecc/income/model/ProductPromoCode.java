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

import com.bluecc.hubs.stub.ProductPromoCodeData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductPromoCodeData.class,
        symbol = EntityNames.ProductPromoCode)
public class ProductPromoCode implements IEventModel<ProductPromoCodeData.Builder>, HasId, Serializable, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_promo_code_id")
	@RId 
    String productPromoCodeId;
    @SerializedName("product_promo_id") 
    String productPromoId;
    @SerializedName("user_entered") 
    Character userEntered;
    @SerializedName("require_email_or_party") 
    Character requireEmailOrParty;
    @SerializedName("use_limit_per_code") 
    Long useLimitPerCode;
    @SerializedName("use_limit_per_customer") 
    Long useLimitPerCustomer;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
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
        return productPromoCodeId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductPromoCodeData.Builder toDataBuilder() {
        ProductPromoCodeData.Builder builder = ProductPromoCodeData.newBuilder();
        if (getProductPromoCodeId() != null) {
            builder.setProductPromoCodeId(getProductPromoCodeId());
        }
        if (getProductPromoId() != null) {
            builder.setProductPromoId(getProductPromoId());
        }
        if (getUserEntered() != null) {
            builder.setUserEntered(getIndicator(getUserEntered()));
        }
        if (getRequireEmailOrParty() != null) {
            builder.setRequireEmailOrParty(getIndicator(getRequireEmailOrParty()));
        }
        if (getUseLimitPerCode() != null) {
            builder.setUseLimitPerCode(getUseLimitPerCode());
        }
        if (getUseLimitPerCustomer() != null) {
            builder.setUseLimitPerCustomer(getUseLimitPerCustomer());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
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

    public static ProductPromoCode fromData(ProductPromoCodeData data) {
        return fromPrototype(data).build();
    }

    public static ProductPromoCode.ProductPromoCodeBuilder fromPrototype(ProductPromoCodeData data) {
        return ProductPromoCode.builder()
                .productPromoCodeId(data.getProductPromoCodeId())
                .productPromoId(data.getProductPromoId())
                .userEntered(getIndicatorChar(data.getUserEntered()))
                .requireEmailOrParty(getIndicatorChar(data.getRequireEmailOrParty()))
                .useLimitPerCode(data.getUseLimitPerCode())
                .useLimitPerCustomer(data.getUseLimitPerCustomer())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
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
-- keys: productPromoCodeId

-- fields --
    
    String productPromoCodeId
    String productPromoId
    Character userEntered
    Character requireEmailOrParty
    Long useLimitPerCode
    Long useLimitPerCustomer
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - ProductPromo (one, autoRelation: false, keymaps: productPromoId)
    - CreatedByUserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - LastModifiedByUserLogin (one, autoRelation: false, keymaps: lastModifiedByUserLogin -> userLoginId)
    + OldProductPromoCodeEmail (many, autoRelation: true, keymaps: productPromoCodeId)
    + OrderProductPromoCode (many, autoRelation: true, keymaps: productPromoCodeId)
    + ProdPromoCodeContactMech (many, autoRelation: true, keymaps: productPromoCodeId)
    + ProductPromoCodeParty (many, autoRelation: true, keymaps: productPromoCodeId)
    + ProductPromoUse (many, autoRelation: true, keymaps: productPromoCodeId)
    + ShoppingList (many, autoRelation: true, keymaps: productPromoCodeId)
*/

