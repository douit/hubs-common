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

import com.bluecc.hubs.fund.descriptor.EntityNames;
import com.bluecc.hubs.fund.pubs.MessageObject;

import com.bluecc.hubs.stub.QuoteFlatData;

import com.bluecc.hubs.stub.QuoteData;
import com.bluecc.income.dao.QuoteDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = QuoteData.class,
        symbol = EntityNames.Quote)
public class Quote implements IEventModel<QuoteFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String quoteId;
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

    public QuoteFlatData.Builder toDataBuilder() {
        QuoteFlatData.Builder builder = QuoteFlatData.newBuilder();
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

    public static Quote fromData(QuoteFlatData data) {
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

        // relations
     
    List<Party> relParty= new ArrayList<>(); 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    List<QuoteItem> relQuoteItem= new ArrayList<>(); 
    List<QuoteRole> relQuoteRole= new ArrayList<>(); 
    List<QuoteTerm> relQuoteTerm= new ArrayList<>();

    public QuoteDelegator.Agent agent(IProc.ProcContext ctx,
                                             QuoteDelegator delegator){
        return delegator.getAgent(ctx, this.getQuoteId());
    }

    public QuoteData.Builder toHeadBuilder() {
        QuoteData.Builder builder = QuoteData.newBuilder();
        if (quoteId != null) {
            builder.setQuoteId(quoteId);
        }
        if (quoteTypeId != null) {
            builder.setQuoteTypeId(quoteTypeId);
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

}
