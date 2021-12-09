package com.bluecc.income.procs;

import com.bluecc.hubs.stub.*;
import com.bluecc.income.dao.PaymentDelegator;

import java.math.BigDecimal;

import static com.bluecc.hubs.ProtoTypes.*;

public class Payments extends PaymentDelegator {

    public PaymentFlatData createPayment(CommonData.PartyFromTo fromTo, BigDecimal amount) {
        return PaymentFlatData.newBuilder()
                .setAmount(getCurrency(amount))
                .setCurrencyUomId("USD")
                .setEffectiveDate(nowTimestamp())
                .setPartyIdFrom(fromTo.getFrom())
                .setPartyIdTo(fromTo.getTo())
                .setPaymentId(sequence.nextStringId())
                .setPaymentMethodTypeId("EFT_ACCOUNT")
                .setPaymentTypeId("CUSTOMER_PAYMENT")
                .setStatusId("PMNT_NOT_PAID")
                .build();
    }

    public  PaymentApplicationData createPaymentApplication(
            InvoiceFlatData invoice,
            PaymentFlatData payment,
            BigDecimal amountApplied) {
        return PaymentApplicationData.newBuilder()
                .setAmountApplied(getCurrency(amountApplied))
                .setInvoiceId(invoice.getInvoiceId())
                .setPaymentApplicationId(sequence.nextStringId())
                .setPaymentId(payment.getPaymentId())
                .build();
    }

    public AcctgTransData postAcctgTrans(InvoiceFlatData invoice, PaymentFlatData payment) {
        return AcctgTransData.newBuilder()
                .setAcctgTransId(sequence.nextStringId())
                .setAcctgTransTypeId("PAYMENT_APPL")
                .setGlFiscalTypeId("ACTUAL")
                .setInvoiceId(invoice.getInvoiceId())
                .setIsPosted(castIndicator("Y"))
                .setPartyId(payment.getPartyIdFrom())
                .setPaymentId(payment.getPaymentId())
                .setPostedDate(nowTimestamp())
                .setRoleTypeId("BILL_TO_CUSTOMER")
                .setTransactionDate(nowTimestamp())
                .build();
    }

    public void setPaymentStatus(PaymentFlatData payment, String statusId){
        process(c ->{
            update(c, PaymentFlatData.newBuilder()
                    .setPaymentId(payment.getPaymentId())
                    .setStatusId(statusId)
                    .build());
        });
    }
}
