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

import com.bluecc.hubs.stub.QuoteFlatData;

import com.bluecc.hubs.stub.QuoteData;
import com.bluecc.income.dao.QuoteDelegator;
import static com.bluecc.income.dao.QuoteDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = QuoteData.class,
        symbol = EntityNames.Quote)
public class Quote implements IEventModel<QuoteFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("quote_id")
	@RId 
    String quoteId;
    @SerializedName("quote_type_id") 
    String quoteTypeId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("issue_date") 
    java.time.LocalDateTime issueDate;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("sales_channel_enum_id") 
    String salesChannelEnumId;
    @SerializedName("valid_from_date") 
    java.time.LocalDateTime validFromDate;
    @SerializedName("valid_thru_date") 
    java.time.LocalDateTime validThruDate;
    @SerializedName("quote_name") 
    String quoteName;
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
    @SerializedName("tenant_id") 
    String tenantId;
    
    @Override
    public String getId(){
        return quoteId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public QuoteFlatData.Builder toDataBuilder() {
        QuoteFlatData.Builder builder = QuoteFlatData.newBuilder();
        if (getQuoteId() != null) {
            builder.setQuoteId(getQuoteId());
        }
        if (getQuoteTypeId() != null) {
            builder.setQuoteTypeId(getQuoteTypeId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getIssueDate() != null) {
            builder.setIssueDate(getTimestamp(getIssueDate()));
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getProductStoreId() != null) {
            builder.setProductStoreId(getProductStoreId());
        }
        if (getSalesChannelEnumId() != null) {
            builder.setSalesChannelEnumId(getSalesChannelEnumId());
        }
        if (getValidFromDate() != null) {
            builder.setValidFromDate(getTimestamp(getValidFromDate()));
        }
        if (getValidThruDate() != null) {
            builder.setValidThruDate(getTimestamp(getValidThruDate()));
        }
        if (getQuoteName() != null) {
            builder.setQuoteName(getQuoteName());
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
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static Quote fromData(QuoteFlatData data) {
        return fromPrototype(data).build();
    }

    public static Quote.QuoteBuilder fromPrototype(QuoteFlatData data) {
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
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addParty")
    @SerializedName("party") 
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addProductStore")
    @SerializedName("product_store") 
    List<ProductStore> relProductStore= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteAdjustment")
    @SerializedName("quote_adjustment") 
    List<QuoteAdjustment> relQuoteAdjustment= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteItem")
    @SerializedName("quote_item") 
    List<QuoteItem> relQuoteItem= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteRole")
    @SerializedName("quote_role") 
    List<QuoteRole> relQuoteRole= new ArrayList<>(); 
    @Exclude
    @Singular("addQuoteTerm")
    @SerializedName("quote_term") 
    List<QuoteTerm> relQuoteTerm= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARTY, getter(this, Quote::getRelParty)); 
        supplierMap.put(PRODUCT_STORE, getter(this, Quote::getRelProductStore)); 
        supplierMap.put(QUOTE_ADJUSTMENT, getter(this, Quote::getRelQuoteAdjustment)); 
        supplierMap.put(QUOTE_ITEM, getter(this, Quote::getRelQuoteItem)); 
        supplierMap.put(QUOTE_ROLE, getter(this, Quote::getRelQuoteRole)); 
        supplierMap.put(QUOTE_TERM, getter(this, Quote::getRelQuoteTerm)); 
        supplierMap.put(TENANT, getter(this, Quote::getRelTenant));

        return supplierMap;
    };

    public QuoteDelegator.Agent agent(IProc.ProcContext ctx,
                                             QuoteDelegator delegator){
        return delegator.getAgent(ctx, this.getQuoteId());
    }

    public QuoteData.Builder toHeadBuilder() {
        QuoteData.Builder builder = QuoteData.newBuilder();
        if (getQuoteId() != null) {
            builder.setQuoteId(getQuoteId());
        }
        if (getQuoteTypeId() != null) {
            builder.setQuoteTypeId(getQuoteTypeId());
        }
        if (getIssueDate() != null) {
            builder.setIssueDate(getTimestamp(getIssueDate()));
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getSalesChannelEnumId() != null) {
            builder.setSalesChannelEnumId(getSalesChannelEnumId());
        }
        if (getValidFromDate() != null) {
            builder.setValidFromDate(getTimestamp(getValidFromDate()));
        }
        if (getValidThruDate() != null) {
            builder.setValidThruDate(getTimestamp(getValidThruDate()));
        }
        if (getQuoteName() != null) {
            builder.setQuoteName(getQuoteName());
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

}


/*
-- keys: quoteId

-- fields --
    
    String quoteId
    String quoteTypeId
    String partyId
    java.time.LocalDateTime issueDate
    String statusId
    String currencyUomId
    String productStoreId
    String salesChannelEnumId
    java.time.LocalDateTime validFromDate
    java.time.LocalDateTime validThruDate
    String quoteName
    String description

-- relations --
    
    - QuoteType (one, autoRelation: false, keymaps: quoteTypeId)
    + QuoteTypeAttr (many, autoRelation: false, keymaps: quoteTypeId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - Uom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - ProductStore (one, autoRelation: false, keymaps: productStoreId)
    - SalesChannelEnumeration (one, autoRelation: false, keymaps: salesChannelEnumId -> enumId)
    + QuoteNoteView (many, autoRelation: false, keymaps: quoteId)
    + QuoteAdjustment (many, autoRelation: true, keymaps: quoteId)
    + QuoteAttribute (many, autoRelation: true, keymaps: quoteId)
    + QuoteCoefficient (many, autoRelation: true, keymaps: quoteId)
    + QuoteItem (many, autoRelation: true, keymaps: quoteId)
    + QuoteNote (many, autoRelation: true, keymaps: quoteId)
    + QuoteRole (many, autoRelation: true, keymaps: quoteId)
    + QuoteTerm (many, autoRelation: true, keymaps: quoteId)
    + QuoteWorkEffort (many, autoRelation: true, keymaps: quoteId)
    + SalesOpportunityQuote (many, autoRelation: true, keymaps: quoteId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

