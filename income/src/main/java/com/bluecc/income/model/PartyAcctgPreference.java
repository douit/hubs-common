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

import com.bluecc.hubs.stub.PartyAcctgPreferenceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = PartyAcctgPreferenceData.class,
        symbol = EntityNames.PartyAcctgPreference)
public class PartyAcctgPreference implements IEventModel<PartyAcctgPreferenceData.Builder>, HasId, Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("party_id")
	@RId 
    String partyId;
    @SerializedName("fiscal_year_start_month") 
    Long fiscalYearStartMonth;
    @SerializedName("fiscal_year_start_day") 
    Long fiscalYearStartDay;
    @SerializedName("tax_form_id") 
    String taxFormId;
    @SerializedName("cogs_method_id") 
    String cogsMethodId;
    @SerializedName("base_currency_uom_id") 
    String baseCurrencyUomId;
    @SerializedName("invoice_seq_cust_meth_id") 
    String invoiceSeqCustMethId;
    @SerializedName("invoice_id_prefix") 
    String invoiceIdPrefix;
    @SerializedName("last_invoice_number") 
    Long lastInvoiceNumber;
    @SerializedName("last_invoice_restart_date") 
    java.time.LocalDateTime lastInvoiceRestartDate;
    @SerializedName("use_invoice_id_for_returns") 
    Character useInvoiceIdForReturns;
    @SerializedName("quote_seq_cust_meth_id") 
    String quoteSeqCustMethId;
    @SerializedName("quote_id_prefix") 
    String quoteIdPrefix;
    @SerializedName("last_quote_number") 
    Long lastQuoteNumber;
    @SerializedName("order_seq_cust_meth_id") 
    String orderSeqCustMethId;
    @SerializedName("order_id_prefix") 
    String orderIdPrefix;
    @SerializedName("last_order_number") 
    Long lastOrderNumber;
    @SerializedName("refund_payment_method_id") 
    String refundPaymentMethodId;
    @SerializedName("error_gl_journal_id") 
    String errorGlJournalId;
    @SerializedName("enable_accounting") 
    Character enableAccounting;
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
        return partyId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public PartyAcctgPreferenceData.Builder toDataBuilder() {
        PartyAcctgPreferenceData.Builder builder = PartyAcctgPreferenceData.newBuilder();
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (fiscalYearStartMonth != null) {
            builder.setFiscalYearStartMonth(fiscalYearStartMonth);
        }
        if (fiscalYearStartDay != null) {
            builder.setFiscalYearStartDay(fiscalYearStartDay);
        }
        if (taxFormId != null) {
            builder.setTaxFormId(taxFormId);
        }
        if (cogsMethodId != null) {
            builder.setCogsMethodId(cogsMethodId);
        }
        if (baseCurrencyUomId != null) {
            builder.setBaseCurrencyUomId(baseCurrencyUomId);
        }
        if (invoiceSeqCustMethId != null) {
            builder.setInvoiceSeqCustMethId(invoiceSeqCustMethId);
        }
        if (invoiceIdPrefix != null) {
            builder.setInvoiceIdPrefix(invoiceIdPrefix);
        }
        if (lastInvoiceNumber != null) {
            builder.setLastInvoiceNumber(lastInvoiceNumber);
        }
        if (lastInvoiceRestartDate != null) {
            builder.setLastInvoiceRestartDate(getTimestamp(lastInvoiceRestartDate));
        }
        if (useInvoiceIdForReturns != null) {
            builder.setUseInvoiceIdForReturns(getIndicator(useInvoiceIdForReturns));
        }
        if (quoteSeqCustMethId != null) {
            builder.setQuoteSeqCustMethId(quoteSeqCustMethId);
        }
        if (quoteIdPrefix != null) {
            builder.setQuoteIdPrefix(quoteIdPrefix);
        }
        if (lastQuoteNumber != null) {
            builder.setLastQuoteNumber(lastQuoteNumber);
        }
        if (orderSeqCustMethId != null) {
            builder.setOrderSeqCustMethId(orderSeqCustMethId);
        }
        if (orderIdPrefix != null) {
            builder.setOrderIdPrefix(orderIdPrefix);
        }
        if (lastOrderNumber != null) {
            builder.setLastOrderNumber(lastOrderNumber);
        }
        if (refundPaymentMethodId != null) {
            builder.setRefundPaymentMethodId(refundPaymentMethodId);
        }
        if (errorGlJournalId != null) {
            builder.setErrorGlJournalId(errorGlJournalId);
        }
        if (enableAccounting != null) {
            builder.setEnableAccounting(getIndicator(enableAccounting));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static PartyAcctgPreference fromData(PartyAcctgPreferenceData data) {
        return PartyAcctgPreference.builder()
                .partyId(data.getPartyId())
                .fiscalYearStartMonth(data.getFiscalYearStartMonth())
                .fiscalYearStartDay(data.getFiscalYearStartDay())
                .taxFormId(data.getTaxFormId())
                .cogsMethodId(data.getCogsMethodId())
                .baseCurrencyUomId(data.getBaseCurrencyUomId())
                .invoiceSeqCustMethId(data.getInvoiceSeqCustMethId())
                .invoiceIdPrefix(data.getInvoiceIdPrefix())
                .lastInvoiceNumber(data.getLastInvoiceNumber())
                .lastInvoiceRestartDate(getLocalDateTime(data.getLastInvoiceRestartDate()))
                .useInvoiceIdForReturns(getIndicatorChar(data.getUseInvoiceIdForReturns()))
                .quoteSeqCustMethId(data.getQuoteSeqCustMethId())
                .quoteIdPrefix(data.getQuoteIdPrefix())
                .lastQuoteNumber(data.getLastQuoteNumber())
                .orderSeqCustMethId(data.getOrderSeqCustMethId())
                .orderIdPrefix(data.getOrderIdPrefix())
                .lastOrderNumber(data.getLastOrderNumber())
                .refundPaymentMethodId(data.getRefundPaymentMethodId())
                .errorGlJournalId(data.getErrorGlJournalId())
                .enableAccounting(getIndicatorChar(data.getEnableAccounting()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: partyId

-- fields --
    
    String partyId
    Long fiscalYearStartMonth
    Long fiscalYearStartDay
    String taxFormId
    String cogsMethodId
    String baseCurrencyUomId
    String invoiceSeqCustMethId
    String invoiceIdPrefix
    Long lastInvoiceNumber
    java.time.LocalDateTime lastInvoiceRestartDate
    Character useInvoiceIdForReturns
    String quoteSeqCustMethId
    String quoteIdPrefix
    Long lastQuoteNumber
    String orderSeqCustMethId
    String orderIdPrefix
    Long lastOrderNumber
    String refundPaymentMethodId
    String errorGlJournalId
    Character enableAccounting

-- relations --
    
    - Party (one, autoRelation: false, keymaps: partyId)
    - TaxFormEnumeration (one, autoRelation: false, keymaps: taxFormId -> enumId)
    - CogsEnumeration (one, autoRelation: false, keymaps: cogsMethodId -> enumId)
    - Uom (one, autoRelation: false, keymaps: baseCurrencyUomId -> uomId)
    - InvoiceCustomMethod (one, autoRelation: false, keymaps: invoiceSeqCustMethId -> customMethodId)
    - QuoteCustomMethod (one, autoRelation: false, keymaps: quoteSeqCustMethId -> customMethodId)
    - OrderCustomMethod (one, autoRelation: false, keymaps: orderSeqCustMethId -> customMethodId)
    - PaymentMethod (one, autoRelation: false, keymaps: refundPaymentMethodId -> paymentMethodId)
    - GlJournal (one, autoRelation: false, keymaps: errorGlJournalId -> glJournalId)
    - InvoiceSequenceEnumeration (one, autoRelation: false, keymaps: oldInvoiceSequenceEnumId -> enumId)
    - QuoteSequenceEnumeration (one, autoRelation: false, keymaps: oldQuoteSequenceEnumId -> enumId)
    - OrderSequenceEnumeration (one, autoRelation: false, keymaps: oldOrderSequenceEnumId -> enumId)
    + PartyPrefDocTypeTpl (many, autoRelation: true, keymaps: partyId)
*/

