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

import com.bluecc.hubs.fund.model.*;
import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.PaymentGatewayResponseData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentGatewayResponseData.class,
        symbol = EntityNames.PaymentGatewayResponse)
public class PaymentGatewayResponse implements IEventModel<PaymentGatewayResponseData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String paymentGatewayResponseId;
    String paymentServiceTypeEnumId;
    String orderPaymentPreferenceId;
    String paymentMethodTypeId;
    String paymentMethodId;
    String transCodeEnumId;
    java.math.BigDecimal amount;
    String currencyUomId;
    String referenceNum;
    String altReference;
    String subReference;
    String gatewayCode;
    String gatewayFlag;
    String gatewayAvsResult;
    String gatewayCvResult;
    String gatewayScoreResult;
    String gatewayMessage;
    java.time.LocalDateTime transactionDate;
    Character resultDeclined;
    Character resultNsf;
    Character resultBadExpire;
    Character resultBadCardNumber;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentGatewayResponseData.Builder toDataBuilder() {
        PaymentGatewayResponseData.Builder builder = PaymentGatewayResponseData.newBuilder();
        if (paymentGatewayResponseId != null) {
            builder.setPaymentGatewayResponseId(paymentGatewayResponseId);
        }
        if (paymentServiceTypeEnumId != null) {
            builder.setPaymentServiceTypeEnumId(paymentServiceTypeEnumId);
        }
        if (orderPaymentPreferenceId != null) {
            builder.setOrderPaymentPreferenceId(orderPaymentPreferenceId);
        }
        if (paymentMethodTypeId != null) {
            builder.setPaymentMethodTypeId(paymentMethodTypeId);
        }
        if (paymentMethodId != null) {
            builder.setPaymentMethodId(paymentMethodId);
        }
        if (transCodeEnumId != null) {
            builder.setTransCodeEnumId(transCodeEnumId);
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (referenceNum != null) {
            builder.setReferenceNum(referenceNum);
        }
        if (altReference != null) {
            builder.setAltReference(altReference);
        }
        if (subReference != null) {
            builder.setSubReference(subReference);
        }
        if (gatewayCode != null) {
            builder.setGatewayCode(gatewayCode);
        }
        if (gatewayFlag != null) {
            builder.setGatewayFlag(gatewayFlag);
        }
        if (gatewayAvsResult != null) {
            builder.setGatewayAvsResult(gatewayAvsResult);
        }
        if (gatewayCvResult != null) {
            builder.setGatewayCvResult(gatewayCvResult);
        }
        if (gatewayScoreResult != null) {
            builder.setGatewayScoreResult(gatewayScoreResult);
        }
        if (gatewayMessage != null) {
            builder.setGatewayMessage(gatewayMessage);
        }
        if (transactionDate != null) {
            builder.setTransactionDate(getTimestamp(transactionDate));
        }
        if (resultDeclined != null) {
            builder.setResultDeclined(getIndicator(resultDeclined));
        }
        if (resultNsf != null) {
            builder.setResultNsf(getIndicator(resultNsf));
        }
        if (resultBadExpire != null) {
            builder.setResultBadExpire(getIndicator(resultBadExpire));
        }
        if (resultBadCardNumber != null) {
            builder.setResultBadCardNumber(getIndicator(resultBadCardNumber));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static PaymentGatewayResponse fromData(PaymentGatewayResponseData data) {
        return PaymentGatewayResponse.builder()
                .paymentGatewayResponseId(data.getPaymentGatewayResponseId())
                .paymentServiceTypeEnumId(data.getPaymentServiceTypeEnumId())
                .orderPaymentPreferenceId(data.getOrderPaymentPreferenceId())
                .paymentMethodTypeId(data.getPaymentMethodTypeId())
                .paymentMethodId(data.getPaymentMethodId())
                .transCodeEnumId(data.getTransCodeEnumId())
                .amount(getBigDecimal(data.getAmount()))
                .currencyUomId(data.getCurrencyUomId())
                .referenceNum(data.getReferenceNum())
                .altReference(data.getAltReference())
                .subReference(data.getSubReference())
                .gatewayCode(data.getGatewayCode())
                .gatewayFlag(data.getGatewayFlag())
                .gatewayAvsResult(data.getGatewayAvsResult())
                .gatewayCvResult(data.getGatewayCvResult())
                .gatewayScoreResult(data.getGatewayScoreResult())
                .gatewayMessage(data.getGatewayMessage())
                .transactionDate(getLocalDateTime(data.getTransactionDate()))
                .resultDeclined(getIndicatorChar(data.getResultDeclined()))
                .resultNsf(getIndicatorChar(data.getResultNsf()))
                .resultBadExpire(getIndicatorChar(data.getResultBadExpire()))
                .resultBadCardNumber(getIndicatorChar(data.getResultBadCardNumber()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: paymentGatewayResponseId

-- fields --
    
    String paymentGatewayResponseId
    String paymentServiceTypeEnumId
    String orderPaymentPreferenceId
    String paymentMethodTypeId
    String paymentMethodId
    String transCodeEnumId
    java.math.BigDecimal amount
    String currencyUomId
    String referenceNum
    String altReference
    String subReference
    String gatewayCode
    String gatewayFlag
    String gatewayAvsResult
    String gatewayCvResult
    String gatewayScoreResult
    String gatewayMessage
    java.time.LocalDateTime transactionDate
    Character resultDeclined
    Character resultNsf
    Character resultBadExpire
    Character resultBadCardNumber

-- relations --
    
    - ServiceTypeEnumeration (one, autoRelation: false, keymaps: paymentServiceTypeEnumId -> enumId)
    - TranCodeEnumeration (one, autoRelation: false, keymaps: transCodeEnumId -> enumId)
    - Uom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - OrderPaymentPreference (one, autoRelation: false, keymaps: orderPaymentPreferenceId)
    - PaymentMethodType (one, autoRelation: false, keymaps: paymentMethodTypeId)
    - PaymentMethod (one, autoRelation: false, keymaps: paymentMethodId)
    + Payment (many, autoRelation: true, keymaps: paymentGatewayResponseId)
    + PaymentGatewayRespMsg (many, autoRelation: true, keymaps: paymentGatewayResponseId)
*/

