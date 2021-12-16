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

import com.bluecc.hubs.stub.PaymentApplicationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PaymentApplicationData.class,
        symbol = EntityNames.PaymentApplication)
public class PaymentApplication implements IEventModel<PaymentApplicationData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String paymentApplicationId;
    String paymentId;
    String invoiceId;
    String invoiceItemSeqId;
    String billingAccountId;
    String overrideGlAccountId;
    String toPaymentId;
    String taxAuthGeoId;
    java.math.BigDecimal amountApplied;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PaymentApplicationData.Builder toDataBuilder() {
        PaymentApplicationData.Builder builder = PaymentApplicationData.newBuilder();
        if (paymentApplicationId != null) {
            builder.setPaymentApplicationId(paymentApplicationId);
        }
        if (paymentId != null) {
            builder.setPaymentId(paymentId);
        }
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceItemSeqId != null) {
            builder.setInvoiceItemSeqId(invoiceItemSeqId);
        }
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (overrideGlAccountId != null) {
            builder.setOverrideGlAccountId(overrideGlAccountId);
        }
        if (toPaymentId != null) {
            builder.setToPaymentId(toPaymentId);
        }
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (amountApplied != null) {
            builder.setAmountApplied(getCurrency(amountApplied));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static PaymentApplication fromData(PaymentApplicationData data) {
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
                
                .build();
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

