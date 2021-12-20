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

import com.bluecc.hubs.stub.OrderPaymentPreferenceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = OrderPaymentPreferenceData.class,
        symbol = EntityNames.OrderPaymentPreference)
public class OrderPaymentPreference implements IEventModel<OrderPaymentPreferenceData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("order_payment_preference_id")
	@RId 
    String orderPaymentPreferenceId;
    @SerializedName("order_id") 
    String orderId;
    @SerializedName("order_item_seq_id") 
    String orderItemSeqId;
    @SerializedName("ship_group_seq_id") 
    String shipGroupSeqId;
    @SerializedName("product_price_purpose_id") 
    String productPricePurposeId;
    @SerializedName("payment_method_type_id") 
    String paymentMethodTypeId;
    @SerializedName("payment_method_id") 
    String paymentMethodId;
    @SerializedName("fin_account_id") 
    String finAccountId;
    @SerializedName("security_code") 
    String securityCode;
    @SerializedName("track2") 
    String track2;
    @SerializedName("present_flag") 
    Character presentFlag;
    @SerializedName("swiped_flag") 
    Character swipedFlag;
    @SerializedName("overflow_flag") 
    Character overflowFlag;
    @SerializedName("max_amount") 
    java.math.BigDecimal maxAmount;
    @SerializedName("process_attempt") 
    Long processAttempt;
    @SerializedName("billing_postal_code") 
    String billingPostalCode;
    @SerializedName("manual_auth_code") 
    String manualAuthCode;
    @SerializedName("manual_ref_num") 
    String manualRefNum;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("needs_nsf_retry") 
    Character needsNsfRetry;
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
        return orderPaymentPreferenceId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public OrderPaymentPreferenceData.Builder toDataBuilder() {
        OrderPaymentPreferenceData.Builder builder = OrderPaymentPreferenceData.newBuilder();
        if (getOrderPaymentPreferenceId() != null) {
            builder.setOrderPaymentPreferenceId(getOrderPaymentPreferenceId());
        }
        if (getOrderId() != null) {
            builder.setOrderId(getOrderId());
        }
        if (getOrderItemSeqId() != null) {
            builder.setOrderItemSeqId(getOrderItemSeqId());
        }
        if (getShipGroupSeqId() != null) {
            builder.setShipGroupSeqId(getShipGroupSeqId());
        }
        if (getProductPricePurposeId() != null) {
            builder.setProductPricePurposeId(getProductPricePurposeId());
        }
        if (getPaymentMethodTypeId() != null) {
            builder.setPaymentMethodTypeId(getPaymentMethodTypeId());
        }
        if (getPaymentMethodId() != null) {
            builder.setPaymentMethodId(getPaymentMethodId());
        }
        if (getFinAccountId() != null) {
            builder.setFinAccountId(getFinAccountId());
        }
        if (getSecurityCode() != null) {
            builder.setSecurityCode(getSecurityCode());
        }
        if (getTrack2() != null) {
            builder.setTrack2(getTrack2());
        }
        if (getPresentFlag() != null) {
            builder.setPresentFlag(getIndicator(getPresentFlag()));
        }
        if (getSwipedFlag() != null) {
            builder.setSwipedFlag(getIndicator(getSwipedFlag()));
        }
        if (getOverflowFlag() != null) {
            builder.setOverflowFlag(getIndicator(getOverflowFlag()));
        }
        if (getMaxAmount() != null) {
            builder.setMaxAmount(getCurrency(getMaxAmount()));
        }
        if (getProcessAttempt() != null) {
            builder.setProcessAttempt(getProcessAttempt());
        }
        if (getBillingPostalCode() != null) {
            builder.setBillingPostalCode(getBillingPostalCode());
        }
        if (getManualAuthCode() != null) {
            builder.setManualAuthCode(getManualAuthCode());
        }
        if (getManualRefNum() != null) {
            builder.setManualRefNum(getManualRefNum());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getNeedsNsfRetry() != null) {
            builder.setNeedsNsfRetry(getIndicator(getNeedsNsfRetry()));
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

    public static OrderPaymentPreference fromData(OrderPaymentPreferenceData data) {
        return fromPrototype(data).build();
    }

    public static OrderPaymentPreference.OrderPaymentPreferenceBuilder fromPrototype(OrderPaymentPreferenceData data) {
        return OrderPaymentPreference.builder()
                .orderPaymentPreferenceId(data.getOrderPaymentPreferenceId())
                .orderId(data.getOrderId())
                .orderItemSeqId(data.getOrderItemSeqId())
                .shipGroupSeqId(data.getShipGroupSeqId())
                .productPricePurposeId(data.getProductPricePurposeId())
                .paymentMethodTypeId(data.getPaymentMethodTypeId())
                .paymentMethodId(data.getPaymentMethodId())
                .finAccountId(data.getFinAccountId())
                .securityCode(data.getSecurityCode())
                .track2(data.getTrack2())
                .presentFlag(getIndicatorChar(data.getPresentFlag()))
                .swipedFlag(getIndicatorChar(data.getSwipedFlag()))
                .overflowFlag(getIndicatorChar(data.getOverflowFlag()))
                .maxAmount(getBigDecimal(data.getMaxAmount()))
                .processAttempt(data.getProcessAttempt())
                .billingPostalCode(data.getBillingPostalCode())
                .manualAuthCode(data.getManualAuthCode())
                .manualRefNum(data.getManualRefNum())
                .statusId(data.getStatusId())
                .needsNsfRetry(getIndicatorChar(data.getNeedsNsfRetry()))
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
-- keys: orderPaymentPreferenceId

-- fields --
    
    String orderPaymentPreferenceId
    String orderId
    String orderItemSeqId
    String shipGroupSeqId
    String productPricePurposeId
    String paymentMethodTypeId
    String paymentMethodId
    String finAccountId
    String securityCode
    String track2
    Character presentFlag
    Character swipedFlag
    Character overflowFlag
    java.math.BigDecimal maxAmount
    Long processAttempt
    String billingPostalCode
    String manualAuthCode
    String manualRefNum
    String statusId
    Character needsNsfRetry
    java.time.LocalDateTime createdDate
    String createdByUserLogin
    java.time.LocalDateTime lastModifiedDate
    String lastModifiedByUserLogin

-- relations --
    
    - OrderHeader (one, autoRelation: false, keymaps: orderId)
    - OrderItem (one-nofk, autoRelation: false, keymaps: orderId, orderItemSeqId)
    - OrderItemShipGroup (one-nofk, autoRelation: false, keymaps: orderId, shipGroupSeqId)
    - ProductPricePurpose (one, autoRelation: false, keymaps: productPricePurposeId)
    - PaymentMethodType (one, autoRelation: false, keymaps: paymentMethodTypeId)
    - PaymentMethod (one, autoRelation: false, keymaps: paymentMethodId)
    - FinAccount (one, autoRelation: false, keymaps: finAccountId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - UserLogin (one, autoRelation: false, keymaps: createdByUserLogin -> userLoginId)
    - CreditCard (one-nofk, autoRelation: false, keymaps: paymentMethodId)
    - EftAccount (one-nofk, autoRelation: false, keymaps: paymentMethodId)
    - GiftCard (one-nofk, autoRelation: false, keymaps: paymentMethodId)
    + OrderStatus (many, autoRelation: true, keymaps: orderPaymentPreferenceId)
    + Payment (many, autoRelation: true, keymaps: orderPaymentPreferenceId -> paymentPreferenceId)
    + PaymentGatewayResponse (many, autoRelation: true, keymaps: orderPaymentPreferenceId)
    + ReturnItemResponse (many, autoRelation: true, keymaps: orderPaymentPreferenceId)
*/

