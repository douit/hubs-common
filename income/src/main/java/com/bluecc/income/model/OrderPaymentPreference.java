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
        if (orderPaymentPreferenceId != null) {
            builder.setOrderPaymentPreferenceId(orderPaymentPreferenceId);
        }
        if (orderId != null) {
            builder.setOrderId(orderId);
        }
        if (orderItemSeqId != null) {
            builder.setOrderItemSeqId(orderItemSeqId);
        }
        if (shipGroupSeqId != null) {
            builder.setShipGroupSeqId(shipGroupSeqId);
        }
        if (productPricePurposeId != null) {
            builder.setProductPricePurposeId(productPricePurposeId);
        }
        if (paymentMethodTypeId != null) {
            builder.setPaymentMethodTypeId(paymentMethodTypeId);
        }
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (finAccountId != null) {
            builder.setFinAccountId(finAccountId);
        }
        if (securityCode != null) {
            builder.setSecurityCode(securityCode);
        }
        if (track2 != null) {
            builder.setTrack2(track2);
        }
        if (presentFlag != null) {
            builder.setPresentFlag(getIndicator(presentFlag));
        }
        if (swipedFlag != null) {
            builder.setSwipedFlag(getIndicator(swipedFlag));
        }
        if (overflowFlag != null) {
            builder.setOverflowFlag(getIndicator(overflowFlag));
        }
        if (maxAmount != null) {
            builder.setMaxAmount(getCurrency(maxAmount));
        }
        if (processAttempt != null) {
            builder.setProcessAttempt(processAttempt);
        }
        if (billingPostalCode != null) {
            builder.setBillingPostalCode(billingPostalCode);
        }
        if (manualAuthCode != null) {
            builder.setManualAuthCode(manualAuthCode);
        }
        if (manualRefNum != null) {
            builder.setManualRefNum(manualRefNum);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (needsNsfRetry != null) {
            builder.setNeedsNsfRetry(getIndicator(needsNsfRetry));
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

    public static OrderPaymentPreference fromData(OrderPaymentPreferenceData data) {
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
                
                .build();
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

