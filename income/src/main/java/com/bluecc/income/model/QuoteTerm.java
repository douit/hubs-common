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
import com.bluecc.hubs.stub.QuoteTermData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteTerm implements IEventModel<QuoteTermData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String termTypeId;
    String quoteId;
    String quoteItemSeqId;
    Long termValue;
    String uomId;
    Long termDays;
    String textValue;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
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