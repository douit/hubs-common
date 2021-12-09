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
import org.redisson.api.annotation.*;

import com.bluecc.hubs.stub.InvoiceFlatData;

import com.bluecc.hubs.stub.InvoiceData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class Invoice implements IEventModel<InvoiceFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String invoiceId;
    String invoiceTypeId;
    String partyIdFrom;
    String partyId;
    String roleTypeId;
    String statusId;
    String billingAccountId;
    String contactMechId;
    java.time.LocalDateTime invoiceDate;
    java.time.LocalDateTime dueDate;
    java.time.LocalDateTime paidDate;
    String invoiceMessage;
    String referenceNumber;
    String description;
    String currencyUomId;
    String recurrenceInfoId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceFlatData.Builder toDataBuilder() {
        InvoiceFlatData.Builder builder = InvoiceFlatData.newBuilder();
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceTypeId != null) {
            builder.setInvoiceTypeId(invoiceTypeId);
        }
        if (partyIdFrom != null) {
            builder.setPartyIdFrom(partyIdFrom);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (billingAccountId != null) {
            builder.setBillingAccountId(billingAccountId);
        }
        if (contactMechId != null) {
            builder.setContactMechId(contactMechId);
        }
        if (invoiceDate != null) {
            builder.setInvoiceDate(getTimestamp(invoiceDate));
        }
        if (dueDate != null) {
            builder.setDueDate(getTimestamp(dueDate));
        }
        if (paidDate != null) {
            builder.setPaidDate(getTimestamp(paidDate));
        }
        if (invoiceMessage != null) {
            builder.setInvoiceMessage(invoiceMessage);
        }
        if (referenceNumber != null) {
            builder.setReferenceNumber(referenceNumber);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (recurrenceInfoId != null) {
            builder.setRecurrenceInfoId(recurrenceInfoId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static Invoice fromData(InvoiceFlatData data) {
        return Invoice.builder()
                .invoiceId(data.getInvoiceId())
                .invoiceTypeId(data.getInvoiceTypeId())
                .partyIdFrom(data.getPartyIdFrom())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .statusId(data.getStatusId())
                .billingAccountId(data.getBillingAccountId())
                .contactMechId(data.getContactMechId())
                .invoiceDate(getLocalDateTime(data.getInvoiceDate()))
                .dueDate(getLocalDateTime(data.getDueDate()))
                .paidDate(getLocalDateTime(data.getPaidDate()))
                .invoiceMessage(data.getInvoiceMessage())
                .referenceNumber(data.getReferenceNumber())
                .description(data.getDescription())
                .currencyUomId(data.getCurrencyUomId())
                .recurrenceInfoId(data.getRecurrenceInfoId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

        
    public InvoiceData.Builder toHeadBuilder() {
        InvoiceData.Builder builder = InvoiceData.newBuilder();
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceTypeId != null) {
            builder.setInvoiceTypeId(invoiceTypeId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (invoiceDate != null) {
            builder.setInvoiceDate(getTimestamp(invoiceDate));
        }
        if (dueDate != null) {
            builder.setDueDate(getTimestamp(dueDate));
        }
        if (paidDate != null) {
            builder.setPaidDate(getTimestamp(paidDate));
        }
        if (invoiceMessage != null) {
            builder.setInvoiceMessage(invoiceMessage);
        }
        if (referenceNumber != null) {
            builder.setReferenceNumber(referenceNumber);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}
