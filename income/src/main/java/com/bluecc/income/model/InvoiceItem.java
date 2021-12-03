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
import com.bluecc.hubs.stub.InvoiceItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem implements IEventModel<InvoiceItemData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String invoiceId;
    String invoiceItemSeqId;
    String invoiceItemTypeId;
    String overrideGlAccountId;
    String overrideOrgPartyId;
    String inventoryItemId;
    String productId;
    String productFeatureId;
    String parentInvoiceId;
    String parentInvoiceItemSeqId;
    String uomId;
    Character taxableFlag;
    java.math.BigDecimal quantity;
    java.math.BigDecimal amount;
    String description;
    String taxAuthPartyId;
    String taxAuthGeoId;
    String taxAuthorityRateSeqId;
    String salesOpportunityId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceItemData.Builder toDataBuilder() {
        InvoiceItemData.Builder builder = InvoiceItemData.newBuilder();
        if (invoiceId != null) {
            builder.setInvoiceId(invoiceId);
        }
        if (invoiceItemSeqId != null) {
            builder.setInvoiceItemSeqId(invoiceItemSeqId);
        }
        if (invoiceItemTypeId != null) {
            builder.setInvoiceItemTypeId(invoiceItemTypeId);
        }
        if (overrideGlAccountId != null) {
            builder.setOverrideGlAccountId(overrideGlAccountId);
        }
        if (overrideOrgPartyId != null) {
            builder.setOverrideOrgPartyId(overrideOrgPartyId);
        }
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (productFeatureId != null) {
            builder.setProductFeatureId(productFeatureId);
        }
        if (parentInvoiceId != null) {
            builder.setParentInvoiceId(parentInvoiceId);
        }
        if (parentInvoiceItemSeqId != null) {
            builder.setParentInvoiceItemSeqId(parentInvoiceItemSeqId);
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (taxableFlag != null) {
            builder.setTaxableFlag(getIndicator(taxableFlag));
        }
        if (quantity != null) {
            builder.setQuantity(getFixedPoint(quantity));
        }
        if (amount != null) {
            builder.setAmount(getCurrency(amount));
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (taxAuthPartyId != null) {
            builder.setTaxAuthPartyId(taxAuthPartyId);
        }
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
        }
        if (taxAuthorityRateSeqId != null) {
            builder.setTaxAuthorityRateSeqId(taxAuthorityRateSeqId);
        }
        if (salesOpportunityId != null) {
            builder.setSalesOpportunityId(salesOpportunityId);
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

    public static InvoiceItem fromData(InvoiceItemData data) {
        return InvoiceItem.builder()
                .invoiceId(data.getInvoiceId())
                .invoiceItemSeqId(data.getInvoiceItemSeqId())
                .invoiceItemTypeId(data.getInvoiceItemTypeId())
                .overrideGlAccountId(data.getOverrideGlAccountId())
                .overrideOrgPartyId(data.getOverrideOrgPartyId())
                .inventoryItemId(data.getInventoryItemId())
                .productId(data.getProductId())
                .productFeatureId(data.getProductFeatureId())
                .parentInvoiceId(data.getParentInvoiceId())
                .parentInvoiceItemSeqId(data.getParentInvoiceItemSeqId())
                .uomId(data.getUomId())
                .taxableFlag(getIndicatorChar(data.getTaxableFlag()))
                .quantity(getBigDecimal(data.getQuantity()))
                .amount(getBigDecimal(data.getAmount()))
                .description(data.getDescription())
                .taxAuthPartyId(data.getTaxAuthPartyId())
                .taxAuthGeoId(data.getTaxAuthGeoId())
                .taxAuthorityRateSeqId(data.getTaxAuthorityRateSeqId())
                .salesOpportunityId(data.getSalesOpportunityId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}
