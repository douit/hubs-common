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

import com.bluecc.hubs.stub.PaymentGatewayResponseData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentGatewayResponseData.class,
        symbol = EntityNames.PaymentGatewayResponse)
public class PaymentGatewayResponse implements IEventModel<PaymentGatewayResponseData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_gateway_response_id")
	@RId 
    String paymentGatewayResponseId;
    @SerializedName("payment_service_type_enum_id") 
    String paymentServiceTypeEnumId;
    @SerializedName("order_payment_preference_id") 
    String orderPaymentPreferenceId;
    @SerializedName("payment_method_type_id") 
    String paymentMethodTypeId;
    @SerializedName("payment_method_id") 
    String paymentMethodId;
    @SerializedName("trans_code_enum_id") 
    String transCodeEnumId;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("reference_num") 
    String referenceNum;
    @SerializedName("alt_reference") 
    String altReference;
    @SerializedName("sub_reference") 
    String subReference;
    @SerializedName("gateway_code") 
    String gatewayCode;
    @SerializedName("gateway_flag") 
    String gatewayFlag;
    @SerializedName("gateway_avs_result") 
    String gatewayAvsResult;
    @SerializedName("gateway_cv_result") 
    String gatewayCvResult;
    @SerializedName("gateway_score_result") 
    String gatewayScoreResult;
    @SerializedName("gateway_message") 
    String gatewayMessage;
    @SerializedName("transaction_date") 
    java.time.LocalDateTime transactionDate;
    @SerializedName("result_declined") 
    Character resultDeclined;
    @SerializedName("result_nsf") 
    Character resultNsf;
    @SerializedName("result_bad_expire") 
    Character resultBadExpire;
    @SerializedName("result_bad_card_number") 
    Character resultBadCardNumber;
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
        return paymentGatewayResponseId;
    }

        
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

