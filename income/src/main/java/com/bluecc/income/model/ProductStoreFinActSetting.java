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

import com.bluecc.hubs.stub.ProductStoreFinActSettingData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = ProductStoreFinActSettingData.class,
        symbol = EntityNames.ProductStoreFinActSetting)
public class ProductStoreFinActSetting implements IEventModel<ProductStoreFinActSettingData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("product_store_id")
	@RIndex 
    String productStoreId;
    @SerializedName("fin_account_type_id")
	@RIndex 
    String finAccountTypeId;
    @SerializedName("require_pin_code") 
    Character requirePinCode;
    @SerializedName("validate_g_c_fin_acct") 
    Character validateGCFinAcct;
    @SerializedName("account_code_length") 
    Long accountCodeLength;
    @SerializedName("pin_code_length") 
    Long pinCodeLength;
    @SerializedName("account_valid_days") 
    Long accountValidDays;
    @SerializedName("auth_valid_days") 
    Long authValidDays;
    @SerializedName("purchase_survey_id") 
    String purchaseSurveyId;
    @SerializedName("purch_survey_send_to") 
    String purchSurveySendTo;
    @SerializedName("purch_survey_copy_me") 
    String purchSurveyCopyMe;
    @SerializedName("allow_auth_to_negative") 
    Character allowAuthToNegative;
    @SerializedName("min_balance") 
    java.math.BigDecimal minBalance;
    @SerializedName("replenish_threshold") 
    java.math.BigDecimal replenishThreshold;
    @SerializedName("replenish_method_enum_id") 
    String replenishMethodEnumId;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public ProductStoreFinActSettingData.Builder toDataBuilder() {
        ProductStoreFinActSettingData.Builder builder = ProductStoreFinActSettingData.newBuilder();
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (finAccountTypeId != null) {
            builder.setFinAccountTypeId(finAccountTypeId);
        }
        if (requirePinCode != null) {
            builder.setRequirePinCode(getIndicator(requirePinCode));
        }
        if (validateGCFinAcct != null) {
            builder.setValidateGCFinAcct(getIndicator(validateGCFinAcct));
        }
        if (accountCodeLength != null) {
            builder.setAccountCodeLength(accountCodeLength);
        }
        if (pinCodeLength != null) {
            builder.setPinCodeLength(pinCodeLength);
        }
        if (accountValidDays != null) {
            builder.setAccountValidDays(accountValidDays);
        }
        if (authValidDays != null) {
            builder.setAuthValidDays(authValidDays);
        }
        if (purchaseSurveyId != null) {
            builder.setPurchaseSurveyId(purchaseSurveyId);
        }
        if (purchSurveySendTo != null) {
            builder.setPurchSurveySendTo(purchSurveySendTo);
        }
        if (purchSurveyCopyMe != null) {
            builder.setPurchSurveyCopyMe(purchSurveyCopyMe);
        }
        if (allowAuthToNegative != null) {
            builder.setAllowAuthToNegative(getIndicator(allowAuthToNegative));
        }
        if (minBalance != null) {
            builder.setMinBalance(getCurrency(minBalance));
        }
        if (replenishThreshold != null) {
            builder.setReplenishThreshold(getCurrency(replenishThreshold));
        }
        if (replenishMethodEnumId != null) {
            builder.setReplenishMethodEnumId(replenishMethodEnumId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static ProductStoreFinActSetting fromData(ProductStoreFinActSettingData data) {
        return ProductStoreFinActSetting.builder()
                .productStoreId(data.getProductStoreId())
                .finAccountTypeId(data.getFinAccountTypeId())
                .requirePinCode(getIndicatorChar(data.getRequirePinCode()))
                .validateGCFinAcct(getIndicatorChar(data.getValidateGCFinAcct()))
                .accountCodeLength(data.getAccountCodeLength())
                .pinCodeLength(data.getPinCodeLength())
                .accountValidDays(data.getAccountValidDays())
                .authValidDays(data.getAuthValidDays())
                .purchaseSurveyId(data.getPurchaseSurveyId())
                .purchSurveySendTo(data.getPurchSurveySendTo())
                .purchSurveyCopyMe(data.getPurchSurveyCopyMe())
                .allowAuthToNegative(getIndicatorChar(data.getAllowAuthToNegative()))
                .minBalance(getBigDecimal(data.getMinBalance()))
                .replenishThreshold(getBigDecimal(data.getReplenishThreshold()))
                .replenishMethodEnumId(data.getReplenishMethodEnumId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: productStoreId, finAccountTypeId

-- fields --
    
    String productStoreId
    String finAccountTypeId
    Character requirePinCode
    Character validateGCFinAcct
    Long accountCodeLength
    Long pinCodeLength
    Long accountValidDays
    Long authValidDays
    String purchaseSurveyId
    String purchSurveySendTo
    String purchSurveyCopyMe
    Character allowAuthToNegative
    java.math.BigDecimal minBalance
    java.math.BigDecimal replenishThreshold
    String replenishMethodEnumId

-- relations --
    
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - FinAccountType (one, autoRelation: false, keymaps: finAccountTypeId)
    - Survey (one, autoRelation: false, keymaps: purchaseSurveyId -> surveyId)
    - ReplenishMethodEnumeration (one, autoRelation: false, keymaps: replenishMethodEnumId -> enumId)
*/

