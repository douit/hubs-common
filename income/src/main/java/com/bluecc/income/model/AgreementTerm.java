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

import com.bluecc.hubs.stub.AgreementTermData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = AgreementTermData.class,
        symbol = EntityNames.AgreementTerm)
public class AgreementTerm implements IEventModel<AgreementTermData.Builder>, HasId, Serializable, WithDescription, WithPeriod {
    private static final long serialVersionUID = 1L;

    @SerializedName("agreement_term_id")
	@RId 
    String agreementTermId;
    @SerializedName("term_type_id") 
    String termTypeId;
    @SerializedName("agreement_id") 
    String agreementId;
    @SerializedName("agreement_item_seq_id") 
    String agreementItemSeqId;
    @SerializedName("invoice_item_type_id") 
    String invoiceItemTypeId;
    @SerializedName("from_date") 
    java.time.LocalDateTime fromDate;
    @SerializedName("thru_date") 
    java.time.LocalDateTime thruDate;
    @SerializedName("term_value") 
    java.math.BigDecimal termValue;
    @SerializedName("term_days") 
    Long termDays;
    @SerializedName("text_value") 
    String textValue;
    @SerializedName("min_quantity") 
    Double minQuantity;
    @SerializedName("max_quantity") 
    Double maxQuantity;
    @SerializedName("description") 
    String description;
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
        return agreementTermId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public AgreementTermData.Builder toDataBuilder() {
        AgreementTermData.Builder builder = AgreementTermData.newBuilder();
        if (getAgreementTermId() != null) {
            builder.setAgreementTermId(getAgreementTermId());
        }
        if (getTermTypeId() != null) {
            builder.setTermTypeId(getTermTypeId());
        }
        if (getAgreementId() != null) {
            builder.setAgreementId(getAgreementId());
        }
        if (getAgreementItemSeqId() != null) {
            builder.setAgreementItemSeqId(getAgreementItemSeqId());
        }
        if (getInvoiceItemTypeId() != null) {
            builder.setInvoiceItemTypeId(getInvoiceItemTypeId());
        }
        if (getFromDate() != null) {
            builder.setFromDate(getTimestamp(getFromDate()));
        }
        if (getThruDate() != null) {
            builder.setThruDate(getTimestamp(getThruDate()));
        }
        if (getTermValue() != null) {
            builder.setTermValue(getCurrency(getTermValue()));
        }
        if (getTermDays() != null) {
            builder.setTermDays(getTermDays());
        }
        if (getTextValue() != null) {
            builder.setTextValue(getTextValue());
        }
        if (getMinQuantity() != null) {
            builder.setMinQuantity(getMinQuantity());
        }
        if (getMaxQuantity() != null) {
            builder.setMaxQuantity(getMaxQuantity());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static AgreementTerm fromData(AgreementTermData data) {
        return fromPrototype(data).build();
    }

    public static AgreementTerm.AgreementTermBuilder fromPrototype(AgreementTermData data) {
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
                ;
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

