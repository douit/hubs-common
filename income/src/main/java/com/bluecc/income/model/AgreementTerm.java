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

import com.bluecc.hubs.stub.AgreementTermData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AgreementTermData.class,
        symbol = EntityNames.AgreementTerm)
public class AgreementTerm implements IEventModel<AgreementTermData.Builder>, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @RId String agreementTermId;
    String termTypeId;
    String agreementId;
    String agreementItemSeqId;
    String invoiceItemTypeId;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    java.math.BigDecimal termValue;
    Long termDays;
    String textValue;
    Double minQuantity;
    Double maxQuantity;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AgreementTermData.Builder toDataBuilder() {
        AgreementTermData.Builder builder = AgreementTermData.newBuilder();
        if (agreementTermId != null) {
            builder.setAgreementTermId(agreementTermId);
        }
        if (termTypeId != null) {
            builder.setTermTypeId(termTypeId);
        }
        if (agreementId != null) {
            builder.setAgreementId(agreementId);
        }
        if (agreementItemSeqId != null) {
            builder.setAgreementItemSeqId(agreementItemSeqId);
        }
        if (invoiceItemTypeId != null) {
            builder.setInvoiceItemTypeId(invoiceItemTypeId);
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (termValue != null) {
            builder.setTermValue(getCurrency(termValue));
        }
        if (termDays != null) {
            builder.setTermDays(termDays);
        }
        if (textValue != null) {
            builder.setTextValue(textValue);
        }
        if (minQuantity != null) {
            builder.setMinQuantity(minQuantity);
        }
        if (maxQuantity != null) {
            builder.setMaxQuantity(maxQuantity);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static AgreementTerm fromData(AgreementTermData data) {
        return AgreementTerm.builder()
                .agreementTermId(data.getAgreementTermId())
                .termTypeId(data.getTermTypeId())
                .agreementId(data.getAgreementId())
                .agreementItemSeqId(data.getAgreementItemSeqId())
                .invoiceItemTypeId(data.getInvoiceItemTypeId())
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .termValue(getBigDecimal(data.getTermValue()))
                .termDays(data.getTermDays())
                .textValue(data.getTextValue())
                .minQuantity(data.getMinQuantity())
                .maxQuantity(data.getMaxQuantity())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}


/*
-- keys: agreementTermId

-- fields --
    
    String agreementTermId
    String termTypeId
    String agreementId
    String agreementItemSeqId
    String invoiceItemTypeId
    java.time.LocalDateTime fromDate
    java.time.LocalDateTime thruDate
    java.math.BigDecimal termValue
    Long termDays
    String textValue
    Double minQuantity
    Double maxQuantity
    String description

-- relations --
    
    - TermType (one, autoRelation: false, keymaps: termTypeId)
    - Agreement (one, autoRelation: false, keymaps: agreementId)
    - AgreementItem (one, autoRelation: false, keymaps: agreementId, agreementItemSeqId)
    - InvoiceItemType (one, autoRelation: false, keymaps: invoiceItemTypeId)
    + AgreementTermAttribute (many, autoRelation: true, keymaps: agreementTermId)
*/

