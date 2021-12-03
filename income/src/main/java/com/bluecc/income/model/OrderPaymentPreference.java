package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.OrderPaymentPreferenceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaymentPreference implements IEventModel<OrderPaymentPreferenceData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String orderPaymentPreferenceId;
    String orderId;
    String orderItemSeqId;
    String shipGroupSeqId;
    String productPricePurposeId;
    String paymentMethodTypeId;
    String paymentMethodId;
    String finAccountId;
    String securityCode;
    String track2;
    Character presentFlag;
    Character swipedFlag;
    Character overflowFlag;
    java.math.BigDecimal maxAmount;
    Long processAttempt;
    String billingPostalCode;
    String manualAuthCode;
    String manualRefNum;
    String statusId;
    Character needsNsfRetry;
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
