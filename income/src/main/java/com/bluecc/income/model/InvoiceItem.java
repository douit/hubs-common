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

import com.bluecc.hubs.stub.InvoiceItemFlatData;

import com.bluecc.hubs.stub.InvoiceItemData;
import com.bluecc.income.dao.InvoiceItemDelegator;
import static com.bluecc.income.dao.InvoiceItemDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InvoiceItemData.class,
        symbol = EntityNames.InvoiceItem)
public class InvoiceItem implements IEventModel<InvoiceItemFlatData.Builder>, HasId, Serializable, WithSuppliers, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("invoice_id")
	@RIndex 
    String invoiceId;
    @SerializedName("invoice_item_seq_id")
	@RIndex 
    String invoiceItemSeqId;
    @SerializedName("invoice_item_type_id") 
    String invoiceItemTypeId;
    @SerializedName("override_gl_account_id") 
    String overrideGlAccountId;
    @SerializedName("override_org_party_id") 
    String overrideOrgPartyId;
    @SerializedName("inventory_item_id") 
    String inventoryItemId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("product_feature_id") 
    String productFeatureId;
    @SerializedName("parent_invoice_id") 
    String parentInvoiceId;
    @SerializedName("parent_invoice_item_seq_id") 
    String parentInvoiceItemSeqId;
    @SerializedName("uom_id") 
    String uomId;
    @SerializedName("taxable_flag") 
    Character taxableFlag;
    @SerializedName("quantity") 
    java.math.BigDecimal quantity;
    @SerializedName("amount") 
    java.math.BigDecimal amount;
    @SerializedName("description") 
    String description;
    @SerializedName("tax_auth_party_id") 
    String taxAuthPartyId;
    @SerializedName("tax_auth_geo_id") 
    String taxAuthGeoId;
    @SerializedName("tax_authority_rate_seq_id") 
    String taxAuthorityRateSeqId;
    @SerializedName("sales_opportunity_id") 
    String salesOpportunityId;
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
    @SerializedName("tenant_id") 
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InvoiceItemFlatData.Builder toDataBuilder() {
        InvoiceItemFlatData.Builder builder = InvoiceItemFlatData.newBuilder();
        if (getInvoiceId() != null) {
            builder.setInvoiceId(getInvoiceId());
        }
        if (getInvoiceItemSeqId() != null) {
            builder.setInvoiceItemSeqId(getInvoiceItemSeqId());
        }
        if (getInvoiceItemTypeId() != null) {
            builder.setInvoiceItemTypeId(getInvoiceItemTypeId());
        }
        if (getOverrideGlAccountId() != null) {
            builder.setOverrideGlAccountId(getOverrideGlAccountId());
        }
        if (getOverrideOrgPartyId() != null) {
            builder.setOverrideOrgPartyId(getOverrideOrgPartyId());
        }
        if (getInventoryItemId() != null) {
            builder.setInventoryItemId(getInventoryItemId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getProductFeatureId() != null) {
            builder.setProductFeatureId(getProductFeatureId());
        }
        if (getParentInvoiceId() != null) {
            builder.setParentInvoiceId(getParentInvoiceId());
        }
        if (getParentInvoiceItemSeqId() != null) {
            builder.setParentInvoiceItemSeqId(getParentInvoiceItemSeqId());
        }
        if (getUomId() != null) {
            builder.setUomId(getUomId());
        }
        if (getTaxableFlag() != null) {
            builder.setTaxableFlag(getIndicator(getTaxableFlag()));
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getTaxAuthPartyId() != null) {
            builder.setTaxAuthPartyId(getTaxAuthPartyId());
        }
        if (getTaxAuthGeoId() != null) {
            builder.setTaxAuthGeoId(getTaxAuthGeoId());
        }
        if (getTaxAuthorityRateSeqId() != null) {
            builder.setTaxAuthorityRateSeqId(getTaxAuthorityRateSeqId());
        }
        if (getSalesOpportunityId() != null) {
            builder.setSalesOpportunityId(getSalesOpportunityId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
        }
        if (getTenantId() != null) {
            builder.setTenantId(getTenantId());
        }
                    
        return builder;
    }

    public static InvoiceItem fromData(InvoiceItemFlatData data) {
        return fromPrototype(data).build();
    }

    public static InvoiceItem.InvoiceItemBuilder fromPrototype(InvoiceItemFlatData data) {
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
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addInvoice")
    @SerializedName("invoice") 
    List<Invoice> relInvoice= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItem")
    @SerializedName("inventory_item") 
    List<InventoryItem> relInventoryItem= new ArrayList<>(); 
    @Exclude
    @Singular("addProduct")
    @SerializedName("product") 
    List<Product> relProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFeature")
    @SerializedName("product_feature") 
    List<ProductFeature> relProductFeature= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceItem")
    @SerializedName("invoice_item") 
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addChildrenInvoiceItem")
    @SerializedName("children_invoice_item") 
    List<InvoiceItem> relChildrenInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOverrideGlAccount")
    @SerializedName("override_gl_account") 
    List<GlAccount> relOverrideGlAccount= new ArrayList<>(); 
    @Exclude
    @Singular("addTaxAuthorityParty")
    @SerializedName("tax_authority_party") 
    List<Party> relTaxAuthorityParty= new ArrayList<>(); 
    @Exclude
    @Singular("addTaxAuthorityRateProduct")
    @SerializedName("tax_authority_rate_product") 
    List<TaxAuthorityRateProduct> relTaxAuthorityRateProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addOverrideOrgParty")
    @SerializedName("override_org_party") 
    List<Party> relOverrideOrgParty= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderAdjustmentBilling")
    @SerializedName("order_adjustment_billing") 
    List<OrderAdjustmentBilling> relOrderAdjustmentBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemBilling")
    @SerializedName("order_item_billing") 
    List<OrderItemBilling> relOrderItemBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addPaymentApplication")
    @SerializedName("payment_application") 
    List<PaymentApplication> relPaymentApplication= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentItemBilling")
    @SerializedName("shipment_item_billing") 
    List<ShipmentItemBilling> relShipmentItemBilling= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(INVOICE, getter(this, InvoiceItem::getRelInvoice)); 
        supplierMap.put(INVENTORY_ITEM, getter(this, InvoiceItem::getRelInventoryItem)); 
        supplierMap.put(PRODUCT, getter(this, InvoiceItem::getRelProduct)); 
        supplierMap.put(PRODUCT_FEATURE, getter(this, InvoiceItem::getRelProductFeature)); 
        supplierMap.put(INVOICE_ITEM, getter(this, InvoiceItem::getRelInvoiceItem)); 
        supplierMap.put(CHILDREN_INVOICE_ITEM, getter(this, InvoiceItem::getRelChildrenInvoiceItem)); 
        supplierMap.put(OVERRIDE_GL_ACCOUNT, getter(this, InvoiceItem::getRelOverrideGlAccount)); 
        supplierMap.put(TAX_AUTHORITY_PARTY, getter(this, InvoiceItem::getRelTaxAuthorityParty)); 
        supplierMap.put(TAX_AUTHORITY_RATE_PRODUCT, getter(this, InvoiceItem::getRelTaxAuthorityRateProduct)); 
        supplierMap.put(OVERRIDE_ORG_PARTY, getter(this, InvoiceItem::getRelOverrideOrgParty)); 
        supplierMap.put(ORDER_ADJUSTMENT_BILLING, getter(this, InvoiceItem::getRelOrderAdjustmentBilling)); 
        supplierMap.put(ORDER_ITEM_BILLING, getter(this, InvoiceItem::getRelOrderItemBilling)); 
        supplierMap.put(PAYMENT_APPLICATION, getter(this, InvoiceItem::getRelPaymentApplication)); 
        supplierMap.put(SHIPMENT_ITEM_BILLING, getter(this, InvoiceItem::getRelShipmentItemBilling)); 
        supplierMap.put(TENANT, getter(this, InvoiceItem::getRelTenant));

        return supplierMap;
    };

    public InvoiceItemDelegator.Agent agent(IProc.ProcContext ctx,
                                             InvoiceItemDelegator delegator){
        return delegator.getAgent(ctx, this.getId());
    }

    public InvoiceItemData.Builder toHeadBuilder() {
        InvoiceItemData.Builder builder = InvoiceItemData.newBuilder();
        if (getInvoiceId() != null) {
            builder.setInvoiceId(getInvoiceId());
        }
        if (getInvoiceItemSeqId() != null) {
            builder.setInvoiceItemSeqId(getInvoiceItemSeqId());
        }
        if (getInvoiceItemTypeId() != null) {
            builder.setInvoiceItemTypeId(getInvoiceItemTypeId());
        }
        if (getParentInvoiceItemSeqId() != null) {
            builder.setParentInvoiceItemSeqId(getParentInvoiceItemSeqId());
        }
        if (getUomId() != null) {
            builder.setUomId(getUomId());
        }
        if (getTaxableFlag() != null) {
            builder.setTaxableFlag(getIndicator(getTaxableFlag()));
        }
        if (getQuantity() != null) {
            builder.setQuantity(getFixedPoint(getQuantity()));
        }
        if (getAmount() != null) {
            builder.setAmount(getCurrency(getAmount()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getTaxAuthGeoId() != null) {
            builder.setTaxAuthGeoId(getTaxAuthGeoId());
        }
        if (getSalesOpportunityId() != null) {
            builder.setSalesOpportunityId(getSalesOpportunityId());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
        if (getId() != null) {
            builder.setId(getId());
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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

