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

import com.bluecc.hubs.stub.InventoryItemFlatData;

import com.bluecc.hubs.stub.InventoryItemData;
import com.bluecc.income.dao.InventoryItemDelegator;
import static com.bluecc.income.dao.InventoryItemDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = InventoryItemData.class,
        symbol = EntityNames.InventoryItem)
public class InventoryItem implements IEventModel<InventoryItemFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("inventory_item_id")
	@RId 
    String inventoryItemId;
    @SerializedName("inventory_item_type_id") 
    String inventoryItemTypeId;
    @SerializedName("product_id") 
    String productId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("owner_party_id") 
    String ownerPartyId;
    @SerializedName("status_id") 
    String statusId;
    @SerializedName("datetime_received") 
    java.time.LocalDateTime datetimeReceived;
    @SerializedName("datetime_manufactured") 
    java.time.LocalDateTime datetimeManufactured;
    @SerializedName("expire_date") 
    java.time.LocalDateTime expireDate;
    @SerializedName("facility_id") 
    String facilityId;
    @SerializedName("container_id") 
    String containerId;
    @SerializedName("lot_id") 
    String lotId;
    @SerializedName("uom_id") 
    String uomId;
    @SerializedName("bin_number") 
    String binNumber;
    @SerializedName("location_seq_id") 
    String locationSeqId;
    @SerializedName("comments") 
    String comments;
    @SerializedName("quantity_on_hand_total") 
    java.math.BigDecimal quantityOnHandTotal;
    @SerializedName("available_to_promise_total") 
    java.math.BigDecimal availableToPromiseTotal;
    @SerializedName("accounting_quantity_total") 
    java.math.BigDecimal accountingQuantityTotal;
    @SerializedName("serial_number") 
    String serialNumber;
    @SerializedName("soft_identifier") 
    String softIdentifier;
    @SerializedName("activation_number") 
    String activationNumber;
    @SerializedName("activation_valid_thru") 
    java.time.LocalDateTime activationValidThru;
    @SerializedName("unit_cost") 
    java.math.BigDecimal unitCost;
    @SerializedName("currency_uom_id") 
    String currencyUomId;
    @SerializedName("fixed_asset_id") 
    String fixedAssetId;
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
        return inventoryItemId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InventoryItemFlatData.Builder toDataBuilder() {
        InventoryItemFlatData.Builder builder = InventoryItemFlatData.newBuilder();
        if (getInventoryItemId() != null) {
            builder.setInventoryItemId(getInventoryItemId());
        }
        if (getInventoryItemTypeId() != null) {
            builder.setInventoryItemTypeId(getInventoryItemTypeId());
        }
        if (getProductId() != null) {
            builder.setProductId(getProductId());
        }
        if (getPartyId() != null) {
            builder.setPartyId(getPartyId());
        }
        if (getOwnerPartyId() != null) {
            builder.setOwnerPartyId(getOwnerPartyId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getDatetimeReceived() != null) {
            builder.setDatetimeReceived(getTimestamp(getDatetimeReceived()));
        }
        if (getDatetimeManufactured() != null) {
            builder.setDatetimeManufactured(getTimestamp(getDatetimeManufactured()));
        }
        if (getExpireDate() != null) {
            builder.setExpireDate(getTimestamp(getExpireDate()));
        }
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getContainerId() != null) {
            builder.setContainerId(getContainerId());
        }
        if (getLotId() != null) {
            builder.setLotId(getLotId());
        }
        if (getUomId() != null) {
            builder.setUomId(getUomId());
        }
        if (getBinNumber() != null) {
            builder.setBinNumber(getBinNumber());
        }
        if (getLocationSeqId() != null) {
            builder.setLocationSeqId(getLocationSeqId());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getQuantityOnHandTotal() != null) {
            builder.setQuantityOnHandTotal(getFixedPoint(getQuantityOnHandTotal()));
        }
        if (getAvailableToPromiseTotal() != null) {
            builder.setAvailableToPromiseTotal(getFixedPoint(getAvailableToPromiseTotal()));
        }
        if (getAccountingQuantityTotal() != null) {
            builder.setAccountingQuantityTotal(getFixedPoint(getAccountingQuantityTotal()));
        }
        if (getSerialNumber() != null) {
            builder.setSerialNumber(getSerialNumber());
        }
        if (getSoftIdentifier() != null) {
            builder.setSoftIdentifier(getSoftIdentifier());
        }
        if (getActivationNumber() != null) {
            builder.setActivationNumber(getActivationNumber());
        }
        if (getActivationValidThru() != null) {
            builder.setActivationValidThru(getTimestamp(getActivationValidThru()));
        }
        if (getUnitCost() != null) {
            builder.setUnitCost(getFixedPoint(getUnitCost()));
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
        }
        if (getFixedAssetId() != null) {
            builder.setFixedAssetId(getFixedAssetId());
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

    public static InventoryItem fromData(InventoryItemFlatData data) {
        return fromPrototype(data).build();
    }

    public static InventoryItem.InventoryItemBuilder fromPrototype(InventoryItemFlatData data) {
        return InventoryItem.builder()
                .inventoryItemId(data.getInventoryItemId())
                .inventoryItemTypeId(data.getInventoryItemTypeId())
                .productId(data.getProductId())
                .partyId(data.getPartyId())
                .ownerPartyId(data.getOwnerPartyId())
                .statusId(data.getStatusId())
                .datetimeReceived(getLocalDateTime(data.getDatetimeReceived()))
                .datetimeManufactured(getLocalDateTime(data.getDatetimeManufactured()))
                .expireDate(getLocalDateTime(data.getExpireDate()))
                .facilityId(data.getFacilityId())
                .containerId(data.getContainerId())
                .lotId(data.getLotId())
                .uomId(data.getUomId())
                .binNumber(data.getBinNumber())
                .locationSeqId(data.getLocationSeqId())
                .comments(data.getComments())
                .quantityOnHandTotal(getBigDecimal(data.getQuantityOnHandTotal()))
                .availableToPromiseTotal(getBigDecimal(data.getAvailableToPromiseTotal()))
                .accountingQuantityTotal(getBigDecimal(data.getAccountingQuantityTotal()))
                .serialNumber(data.getSerialNumber())
                .softIdentifier(data.getSoftIdentifier())
                .activationNumber(data.getActivationNumber())
                .activationValidThru(getLocalDateTime(data.getActivationValidThru()))
                .unitCost(getBigDecimal(data.getUnitCost()))
                .currencyUomId(data.getCurrencyUomId())
                .fixedAssetId(data.getFixedAssetId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .tenantId(data.getTenantId())
                ;
    }

        // relations
     
    @Exclude
    @Singular("addProduct")
    @SerializedName("product") 
    List<Product> relProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addParty")
    @SerializedName("party") 
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addOwnerParty")
    @SerializedName("owner_party") 
    List<Party> relOwnerParty= new ArrayList<>(); 
    @Exclude
    @Singular("addFacility")
    @SerializedName("facility") 
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacility")
    @SerializedName("product_facility") 
    List<ProductFacility> relProductFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addFacilityLocation")
    @SerializedName("facility_location") 
    List<FacilityLocation> relFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacilityLocation")
    @SerializedName("product_facility_location") 
    List<ProductFacilityLocation> relProductFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetFixedAsset")
    @SerializedName("fixed_asset_fixed_asset") 
    List<FixedAsset> relFixedAssetFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    @SerializedName("acctg_trans") 
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTransEntry")
    @SerializedName("acctg_trans_entry") 
    List<AcctgTransEntry> relAcctgTransEntry= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItemDetail")
    @SerializedName("inventory_item_detail") 
    List<InventoryItemDetail> relInventoryItemDetail= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceItem")
    @SerializedName("invoice_item") 
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addItemIssuance")
    @SerializedName("item_issuance") 
    List<ItemIssuance> relItemIssuance= new ArrayList<>(); 
    @Exclude
    @Singular("addFromOrderItem")
    @SerializedName("from_order_item") 
    List<OrderItem> relFromOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemShipGrpInvRes")
    @SerializedName("order_item_ship_grp_inv_res") 
    List<OrderItemShipGrpInvRes> relOrderItemShipGrpInvRes= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    @SerializedName("shipment_receipt") 
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PRODUCT, getter(this, InventoryItem::getRelProduct)); 
        supplierMap.put(PARTY, getter(this, InventoryItem::getRelParty)); 
        supplierMap.put(OWNER_PARTY, getter(this, InventoryItem::getRelOwnerParty)); 
        supplierMap.put(FACILITY, getter(this, InventoryItem::getRelFacility)); 
        supplierMap.put(PRODUCT_FACILITY, getter(this, InventoryItem::getRelProductFacility)); 
        supplierMap.put(FACILITY_LOCATION, getter(this, InventoryItem::getRelFacilityLocation)); 
        supplierMap.put(PRODUCT_FACILITY_LOCATION, getter(this, InventoryItem::getRelProductFacilityLocation)); 
        supplierMap.put(FIXED_ASSET_FIXED_ASSET, getter(this, InventoryItem::getRelFixedAssetFixedAsset)); 
        supplierMap.put(ACCTG_TRANS, getter(this, InventoryItem::getRelAcctgTrans)); 
        supplierMap.put(ACCTG_TRANS_ENTRY, getter(this, InventoryItem::getRelAcctgTransEntry)); 
        supplierMap.put(INVENTORY_ITEM_DETAIL, getter(this, InventoryItem::getRelInventoryItemDetail)); 
        supplierMap.put(INVOICE_ITEM, getter(this, InventoryItem::getRelInvoiceItem)); 
        supplierMap.put(ITEM_ISSUANCE, getter(this, InventoryItem::getRelItemIssuance)); 
        supplierMap.put(FROM_ORDER_ITEM, getter(this, InventoryItem::getRelFromOrderItem)); 
        supplierMap.put(ORDER_ITEM_SHIP_GRP_INV_RES, getter(this, InventoryItem::getRelOrderItemShipGrpInvRes)); 
        supplierMap.put(SHIPMENT_RECEIPT, getter(this, InventoryItem::getRelShipmentReceipt)); 
        supplierMap.put(TENANT, getter(this, InventoryItem::getRelTenant));

        return supplierMap;
    };

    public InventoryItemDelegator.Agent agent(IProc.ProcContext ctx,
                                             InventoryItemDelegator delegator){
        return delegator.getAgent(ctx, this.getInventoryItemId());
    }

    public InventoryItemData.Builder toHeadBuilder() {
        InventoryItemData.Builder builder = InventoryItemData.newBuilder();
        if (getInventoryItemId() != null) {
            builder.setInventoryItemId(getInventoryItemId());
        }
        if (getInventoryItemTypeId() != null) {
            builder.setInventoryItemTypeId(getInventoryItemTypeId());
        }
        if (getStatusId() != null) {
            builder.setStatusId(getStatusId());
        }
        if (getDatetimeReceived() != null) {
            builder.setDatetimeReceived(getTimestamp(getDatetimeReceived()));
        }
        if (getDatetimeManufactured() != null) {
            builder.setDatetimeManufactured(getTimestamp(getDatetimeManufactured()));
        }
        if (getExpireDate() != null) {
            builder.setExpireDate(getTimestamp(getExpireDate()));
        }
        if (getContainerId() != null) {
            builder.setContainerId(getContainerId());
        }
        if (getLotId() != null) {
            builder.setLotId(getLotId());
        }
        if (getUomId() != null) {
            builder.setUomId(getUomId());
        }
        if (getBinNumber() != null) {
            builder.setBinNumber(getBinNumber());
        }
        if (getLocationSeqId() != null) {
            builder.setLocationSeqId(getLocationSeqId());
        }
        if (getComments() != null) {
            builder.setComments(getComments());
        }
        if (getQuantityOnHandTotal() != null) {
            builder.setQuantityOnHandTotal(getFixedPoint(getQuantityOnHandTotal()));
        }
        if (getAvailableToPromiseTotal() != null) {
            builder.setAvailableToPromiseTotal(getFixedPoint(getAvailableToPromiseTotal()));
        }
        if (getAccountingQuantityTotal() != null) {
            builder.setAccountingQuantityTotal(getFixedPoint(getAccountingQuantityTotal()));
        }
        if (getSerialNumber() != null) {
            builder.setSerialNumber(getSerialNumber());
        }
        if (getSoftIdentifier() != null) {
            builder.setSoftIdentifier(getSoftIdentifier());
        }
        if (getActivationNumber() != null) {
            builder.setActivationNumber(getActivationNumber());
        }
        if (getActivationValidThru() != null) {
            builder.setActivationValidThru(getTimestamp(getActivationValidThru()));
        }
        if (getUnitCost() != null) {
            builder.setUnitCost(getFixedPoint(getUnitCost()));
        }
        if (getCurrencyUomId() != null) {
            builder.setCurrencyUomId(getCurrencyUomId());
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
-- keys: inventoryItemId

-- fields --
    
    String inventoryItemId
    String inventoryItemTypeId
    String productId
    String partyId
    String ownerPartyId
    String statusId
    java.time.LocalDateTime datetimeReceived
    java.time.LocalDateTime datetimeManufactured
    java.time.LocalDateTime expireDate
    String facilityId
    String containerId
    String lotId
    String uomId
    String binNumber
    String locationSeqId
    String comments
    java.math.BigDecimal quantityOnHandTotal
    java.math.BigDecimal availableToPromiseTotal
    java.math.BigDecimal accountingQuantityTotal
    String serialNumber
    String softIdentifier
    String activationNumber
    java.time.LocalDateTime activationValidThru
    java.math.BigDecimal unitCost
    String currencyUomId
    String fixedAssetId

-- relations --
    
    - InventoryItemType (one, autoRelation: false, keymaps: inventoryItemTypeId)
    + InventoryItemTypeAttr (many, autoRelation: false, keymaps: inventoryItemTypeId)
    - Product (one, autoRelation: false, keymaps: productId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - OwnerParty (one, autoRelation: false, keymaps: ownerPartyId -> partyId)
    - StatusItem (one, autoRelation: false, keymaps: statusId)
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - Container (one, autoRelation: false, keymaps: containerId)
    - Lot (one, autoRelation: false, keymaps: lotId)
    - ProductFacility (one-nofk, autoRelation: false, keymaps: productId, facilityId)
    - FacilityLocation (one-nofk, autoRelation: false, keymaps: facilityId, locationSeqId)
    - ProductFacilityLocation (one-nofk, autoRelation: false, keymaps: productId, facilityId, locationSeqId)
    - Uom (one, autoRelation: false, keymaps: uomId)
    - CurrencyUom (one, autoRelation: false, keymaps: currencyUomId -> uomId)
    - FixedAssetFixedAsset (one, autoRelation: false, keymaps: fixedAssetId)
    + AcctgTrans (many, autoRelation: true, keymaps: inventoryItemId)
    + AcctgTransEntry (many, autoRelation: true, keymaps: inventoryItemId)
    + InventoryItemAttribute (many, autoRelation: true, keymaps: inventoryItemId)
    + InventoryItemDetail (many, autoRelation: true, keymaps: inventoryItemId)
    + InventoryItemLabelAppl (many, autoRelation: true, keymaps: inventoryItemId)
    + InventoryItemStatus (many, autoRelation: true, keymaps: inventoryItemId)
    + InventoryItemVariance (many, autoRelation: true, keymaps: inventoryItemId)
    + InventoryTransfer (many, autoRelation: true, keymaps: inventoryItemId)
    + InvoiceItem (many, autoRelation: true, keymaps: inventoryItemId)
    + ItemIssuance (many, autoRelation: true, keymaps: inventoryItemId)
    + FromOrderItem (many, autoRelation: true, keymaps: inventoryItemId -> fromInventoryItemId)
    + OrderItemShipGrpInvRes (many, autoRelation: true, keymaps: inventoryItemId)
    + PicklistItem (many, autoRelation: true, keymaps: inventoryItemId)
    + ShipmentReceipt (many, autoRelation: true, keymaps: inventoryItemId)
    + Subscription (many, autoRelation: true, keymaps: inventoryItemId)
    + WorkEffortInventoryAssign (many, autoRelation: true, keymaps: inventoryItemId)
    + WorkEffortInventoryProduced (many, autoRelation: true, keymaps: inventoryItemId)
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

