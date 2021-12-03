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
import com.bluecc.hubs.stub.QuoteData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quote implements IEventModel<QuoteData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String quoteId;
    String quoteTypeId;
    String partyId;
    java.time.LocalDateTime issueDate;
    String statusId;
    String currencyUomId;
    String productStoreId;
    String salesChannelEnumId;
    java.time.LocalDateTime validFromDate;
    java.time.LocalDateTime validThruDate;
    String quoteName;
    String description;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public QuoteData.Builder toDataBuilder() {
        QuoteData.Builder builder = QuoteData.newBuilder();
        if (quoteId != null) {
            builder.setQuoteId(quoteId);
        }
        if (quoteTypeId != null) {
            builder.setQuoteTypeId(quoteTypeId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (issueDate != null) {
            builder.setIssueDate(getTimestamp(issueDate));
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (salesChannelEnumId != null) {
            builder.setSalesChannelEnumId(salesChannelEnumId);
        }
        if (validFromDate != null) {
            builder.setValidFromDate(getTimestamp(validFromDate));
        }
        if (validThruDate != null) {
            builder.setValidThruDate(getTimestamp(validThruDate));
        }
        if (quoteName != null) {
            builder.setQuoteName(quoteName);
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

    public static Quote fromData(QuoteData data) {
        return Quote.builder()
                .quoteId(data.getQuoteId())
                .quoteTypeId(data.getQuoteTypeId())
                .partyId(data.getPartyId())
                .issueDate(getLocalDateTime(data.getIssueDate()))
                .statusId(data.getStatusId())
                .currencyUomId(data.getCurrencyUomId())
                .productStoreId(data.getProductStoreId())
                .salesChannelEnumId(data.getSalesChannelEnumId())
                .validFromDate(getLocalDateTime(data.getValidFromDate()))
                .validThruDate(getLocalDateTime(data.getValidThruDate()))
                .quoteName(data.getQuoteName())
                .description(data.getDescription())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
