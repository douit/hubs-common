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

import com.bluecc.hubs.stub.TaxAuthorityRateProductData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
public class TaxAuthorityRateProduct implements IEventModel<TaxAuthorityRateProductData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RIndex String taxAuthorityRateSeqId;
    String taxAuthGeoId;
    String taxAuthPartyId;
    String taxAuthorityRateTypeId;
    String productStoreId;
    String productCategoryId;
    String titleTransferEnumId;
    java.math.BigDecimal minItemPrice;
    java.math.BigDecimal minPurchase;
    Character taxShipping;
    java.math.BigDecimal taxPercentage;
    Character taxPromotions;
    java.time.LocalDateTime fromDate;
    java.time.LocalDateTime thruDate;
    String description;
    Character isTaxInShippingPrice;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public TaxAuthorityRateProductData.Builder toDataBuilder() {
        TaxAuthorityRateProductData.Builder builder = TaxAuthorityRateProductData.newBuilder();
        if (taxAuthorityRateSeqId != null) {
            builder.setTaxAuthorityRateSeqId(taxAuthorityRateSeqId);
        }
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (taxAuthorityRateTypeId != null) {
            builder.setTaxAuthorityRateTypeId(taxAuthorityRateTypeId);
        }
        if (productStoreId != null) {
            builder.setProductStoreId(productStoreId);
        }
        if (productCategoryId != null) {
            builder.setProductCategoryId(productCategoryId);
        }
        if (titleTransferEnumId != null) {
            builder.setTitleTransferEnumId(titleTransferEnumId);
        }
        if (minItemPrice != null) {
            builder.setMinItemPrice(getCurrency(minItemPrice));
        }
        if (minPurchase != null) {
            builder.setMinPurchase(getCurrency(minPurchase));
        }
        if (taxShipping != null) {
            builder.setTaxShipping(getIndicator(taxShipping));
        }
        if (taxPercentage != null) {
            builder.setTaxPercentage(getFixedPoint(taxPercentage));
        }
        if (taxPromotions != null) {
            builder.setTaxPromotions(getIndicator(taxPromotions));
        }
        if (fromDate != null) {
            builder.setFromDate(getTimestamp(fromDate));
        }
        if (thruDate != null) {
            builder.setThruDate(getTimestamp(thruDate));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (isTaxInShippingPrice != null) {
            builder.setIsTaxInShippingPrice(getIndicator(isTaxInShippingPrice));
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static TaxAuthorityRateProduct fromData(TaxAuthorityRateProductData data) {
        return TaxAuthorityRateProduct.builder()
                .taxAuthorityRateSeqId(data.getTaxAuthorityRateSeqId())
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .taxAuthorityRateTypeId(data.getTaxAuthorityRateTypeId())
                .productStoreId(data.getProductStoreId())
                .productCategoryId(data.getProductCategoryId())
                .titleTransferEnumId(data.getTitleTransferEnumId())
                .minItemPrice(getBigDecimal(data.getMinItemPrice()))
                .minPurchase(getBigDecimal(data.getMinPurchase()))
                .taxShipping(getIndicatorChar(data.getTaxShipping()))
                .taxPercentage(getBigDecimal(data.getTaxPercentage()))
                .taxPromotions(getIndicatorChar(data.getTaxPromotions()))
                .fromDate(getLocalDateTime(data.getFromDate()))
                .thruDate(getLocalDateTime(data.getThruDate()))
                .description(data.getDescription())
                .isTaxInShippingPrice(getIndicatorChar(data.getIsTaxInShippingPrice()))
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
