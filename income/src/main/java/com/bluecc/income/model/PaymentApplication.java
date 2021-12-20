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

import com.bluecc.hubs.stub.PaymentApplicationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentApplicationData.class,
        symbol = EntityNames.PaymentApplication)
public class PaymentApplication implements IEventModel<PaymentApplicationData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("payment_application_id")
	@RId 
    String paymentApplicationId;
    @SerializedName("payment_id") 
    String paymentId;
    @SerializedName("invoice_id") 
    String invoiceId;
    @SerializedName("invoice_item_seq_id") 
    String invoiceItemSeqId;
    @SerializedName("billing_account_id") 
    String billingAccountId;
    @SerializedName("override_gl_account_id") 
    String overrideGlAccountId;
    @SerializedName("to_payment_id") 
    String toPaymentId;
    @SerializedName("tax_auth_geo_id") 
    String taxAuthGeoId;
    @SerializedName("amount_applied") 
    java.math.BigDecimal amountApplied;
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
        return paymentApplicationId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentApplicationData.Builder toDataBuilder() {
        PaymentApplicationData.Builder builder = PaymentApplicationData.newBuilder();
        if (getPaymentApplicationId() != null) {
            builder.setPaymentApplicationId(getPaymentApplicationId());
        }
        if (getPaymentId() != null) {
            builder.setPaymentId(getPaymentId());
        }
        if (getInvoiceId() != null) {
            builder.setInvoiceId(getInvoiceId());
        }
        if (getInvoiceItemSeqId() != null) {
            builder.setInvoiceItemSeqId(getInvoiceItemSeqId());
        }
        if (getBillingAccountId() != null) {
            builder.setBillingAccountId(getBillingAccountId());
        }
        if (getOverrideGlAccountId() != null) {
            builder.setOverrideGlAccountId(getOverrideGlAccountId());
        }
        if (getToPaymentId() != null) {
            builder.setToPaymentId(getToPaymentId());
        }
        if (getTaxAuthGeoId() != null) {
            builder.setTaxAuthGeoId(getTaxAuthGeoId());
        }
        if (getAmountApplied() != null) {
            builder.setAmountApplied(getCurrency(getAmountApplied()));
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static PaymentApplication fromData(PaymentApplicationData data) {
        return fromPrototype(data).build();
    }

    public static PaymentApplication.PaymentApplicationBuilder fromPrototype(PaymentApplicationData data) {
        return PaymentApplication.builder()
                .paymentApplicationId(data.getPaymentApplicationId())
                .paymentId(data.getPaymentId())
                .invoiceId(data.getInvoiceId())
                .invoiceItemSeqId(data.getInvoiceItemSeqId())
                .billingAccountId(data.getBillingAccountId())
                .overrideGlAccountId(data.getOverrideGlAccountId())
                .toPaymentId(data.getToPaymentId())
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .amountApplied(getBigDecimal(data.getAmountApplied()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: paymentApplicationId

-- fields --
    
    String paymentApplicationId
    String paymentId
    String invoiceId
    String invoiceItemSeqId
    String billingAccountId
    String overrideGlAccountId
    String toPaymentId
    String taxAuthGeoId
    java.math.BigDecimal amountApplied

-- relations --
    
    - Payment (one, autoRelation: false, keymaps: paymentId)
    - Invoice (one, autoRelation: false, keymaps: invoiceId)
    - InvoiceItem (one-nofk, autoRelation: false, keymaps: invoiceId, invoiceItemSeqId)
    - BillingAccount (one, autoRelation: false, keymaps: billingAccountId)
    - ToPayment (one, autoRelation: false, keymaps: toPaymentId -> paymentId)
    - Geo (one, autoRelation: false, keymaps: taxAuthGeoId -> geoId)
    - GlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
*/

