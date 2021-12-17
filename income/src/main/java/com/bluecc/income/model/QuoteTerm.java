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

import com.bluecc.hubs.stub.QuoteTermData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = QuoteTermData.class,
        symbol = EntityNames.QuoteTerm)
public class QuoteTerm implements IEventModel<QuoteTermData.Builder>, HasId, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("term_type_id")
	@RIndex 
    String termTypeId;
    @SerializedName("quote_id")
	@RIndex 
    String quoteId;
    @SerializedName("quote_item_seq_id")
	@RIndex 
    String quoteItemSeqId;
    @SerializedName("term_value") 
    Long termValue;
    @SerializedName("uom_id") 
    String uomId;
    @SerializedName("term_days") 
    Long termDays;
    @SerializedName("text_value") 
    String textValue;
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
    @SerializedName("id")
	@RId 
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public QuoteTermData.Builder toDataBuilder() {
        QuoteTermData.Builder builder = QuoteTermData.newBuilder();
        if (termTypeId != null) {
            builder.setTermTypeId(termTypeId);
        }
        if (quoteId != null) {
            builder.setQuoteId(quoteId);
        }
        if (quoteItemSeqId != null) {
            builder.setQuoteItemSeqId(quoteItemSeqId);
        }
        if (termValue != null) {
            builder.setTermValue(termValue);
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (termDays != null) {
            builder.setTermDays(termDays);
        }
        if (textValue != null) {
            builder.setTextValue(textValue);
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
        if (id != null) {
            builder.setId(id);
        }
                    
        return builder;
    }

    public static QuoteTerm fromData(QuoteTermData data) {
        return QuoteTerm.builder()
                .termTypeId(data.getTermTypeId())
                .quoteId(data.getQuoteId())
                .quoteItemSeqId(data.getQuoteItemSeqId())
                .termValue(data.getTermValue())
                .uomId(data.getUomId())
                .termDays(data.getTermDays())
                .textValue(data.getTextValue())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: termTypeId, quoteId, quoteItemSeqId

-- fields --
    
    String termTypeId
    String quoteId
    String quoteItemSeqId
    Long termValue
    String uomId
    Long termDays
    String textValue
    String description

-- relations --
    
    - Quote (one, autoRelation: false, keymaps: quoteId)
    - QuoteItem (one-nofk, autoRelation: false, keymaps: quoteId, quoteItemSeqId)
    - TermType (one, autoRelation: false, keymaps: termTypeId)
    + QuoteTermAttribute (many, autoRelation: true, keymaps: termTypeId, quoteId, quoteItemSeqId)
*/

