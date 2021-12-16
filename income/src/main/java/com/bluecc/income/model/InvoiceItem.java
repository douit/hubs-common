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

import com.bluecc.hubs.stub.InvoiceItemFlatData;

import com.bluecc.hubs.stub.InvoiceItemData;
import com.bluecc.income.dao.InvoiceItemDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InvoiceItemData.class,
        symbol = EntityNames.InvoiceItem)
public class InvoiceItem implements IEventModel<InvoiceItemFlatData.Builder>, Serializable, WithDescription {
    private static final long serialVersionUID = 1L;

    @RIndex String invoiceId;
    @RIndex String invoiceItemSeqId;
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
    @RId String id;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceItemFlatData.Builder toDataBuilder() {
        InvoiceItemFlatData.Builder builder = InvoiceItemFlatData.newBuilder();
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

    public static InvoiceItem fromData(InvoiceItemFlatData data) {
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

        // relations
     
    @Exclude
    List<Invoice> relInvoice= new ArrayList<>(); 
    @Exclude
    List<InventoryItem> relInventoryItem= new ArrayList<>(); 
    @Exclude
    List<Product> relProduct= new ArrayList<>(); 
    @Exclude
    List<ProductFeature> relProductFeature= new ArrayList<>(); 
    @Exclude
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    List<InvoiceItem> relChildrenInvoiceItem= new ArrayList<>(); 
    @Exclude
    List<GlAccount> relOverrideGlAccount= new ArrayList<>(); 
    @Exclude
    List<Party> relTaxAuthorityParty= new ArrayList<>(); 
    @Exclude
    List<TaxAuthorityRateProduct> relTaxAuthorityRateProduct= new ArrayList<>(); 
    @Exclude
    List<Party> relOverrideOrgParty= new ArrayList<>(); 
    @Exclude
    List<OrderAdjustmentBilling> relOrderAdjustmentBilling= new ArrayList<>(); 
    @Exclude
    List<OrderItemBilling> relOrderItemBilling= new ArrayList<>(); 
    @Exclude
    List<PaymentApplication> relPaymentApplication= new ArrayList<>(); 
    @Exclude
    List<ShipmentItemBilling> relShipmentItemBilling= new ArrayList<>();

    public InvoiceItemDelegator.Agent agent(IProc.ProcContext ctx,
                                             InvoiceItemDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public InvoiceItemData.Builder toHeadBuilder() {
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
        if (taxAuthGeoId != null) {
            builder.setTaxAuthGeoId(taxAuthGeoId);
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

}


/*
-- keys: invoiceId, invoiceItemSeqId

-- fields --
    
    String invoiceId
    String invoiceItemSeqId
    String invoiceItemTypeId
    String overrideGlAccountId
    String overrideOrgPartyId
    String inventoryItemId
    String productId
    String productFeatureId
    String parentInvoiceId
    String parentInvoiceItemSeqId
    String uomId
    Character taxableFlag
    java.math.BigDecimal quantity
    java.math.BigDecimal amount
    String description
    String taxAuthPartyId
    String taxAuthGeoId
    String taxAuthorityRateSeqId
    String salesOpportunityId

-- relations --
    
    - InvoiceItemType (one, autoRelation: false, keymaps: invoiceItemTypeId)
    + InvoiceItemTypeAttr (many, autoRelation: false, keymaps: invoiceItemTypeId)
    - Invoice (one, autoRelation: false, keymaps: invoiceId)
    - InventoryItem (one, autoRelation: false, keymaps: inventoryItemId)
    - Product (one, autoRelation: false, keymaps: productId)
    - ProductFeature (one, autoRelation: false, keymaps: productFeatureId)
    - InvoiceItem (one, autoRelation: false, keymaps: parentInvoiceId -> invoiceId, parentInvoiceItemSeqId -> invoiceItemSeqId)
    + ChildrenInvoiceItem (many, autoRelation: false, keymaps: invoiceId -> parentInvoiceId, invoiceItemSeqId -> parentInvoiceItemSeqId)
    - Uom (one, autoRelation: false, keymaps: uomId)
    - OverrideGlAccount (one, autoRelation: false, keymaps: overrideGlAccountId -> glAccountId)
    - TaxAuthorityParty (one, autoRelation: false, keymaps: taxAuthPartyId -> partyId)
    - TaxGeo (one, autoRelation: false, keymaps: taxAuthGeoId -> geoId)
    - TaxAuthorityRateProduct (one, autoRelation: false, keymaps: taxAuthorityRateSeqId)
    - OverrideOrgParty (one, autoRelation: false, keymaps: overrideOrgPartyId -> partyId)
    - SalesOpportunity (one, autoRelation: false, keymaps: salesOpportunityId)
    + FromInvoiceItemAssoc (many, autoRelation: true, keymaps: invoiceId -> invoiceIdFrom, invoiceItemSeqId -> invoiceItemSeqIdFrom)
    + ToInvoiceItemAssoc (many, autoRelation: true, keymaps: invoiceId -> invoiceIdTo, invoiceItemSeqId -> invoiceItemSeqIdTo)
    + InvoiceItemAttribute (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + InvoiceTerm (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + OrderAdjustmentBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + OrderItemBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + PaymentApplication (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + ReturnItemBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + ShipmentItemBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + TimeEntry (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
    + WorkEffortBilling (many, autoRelation: true, keymaps: invoiceId, invoiceItemSeqId)
*/

