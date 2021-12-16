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
public class InventoryItem implements IEventModel<InventoryItemFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String inventoryItemId;
    String inventoryItemTypeId;
    String productId;
    String partyId;
    String ownerPartyId;
    String statusId;
    java.time.LocalDateTime datetimeReceived;
    java.time.LocalDateTime datetimeManufactured;
    java.time.LocalDateTime expireDate;
    String facilityId;
    String containerId;
    String lotId;
    String uomId;
    String binNumber;
    String locationSeqId;
    String comments;
    java.math.BigDecimal quantityOnHandTotal;
    java.math.BigDecimal availableToPromiseTotal;
    java.math.BigDecimal accountingQuantityTotal;
    String serialNumber;
    String softIdentifier;
    String activationNumber;
    java.time.LocalDateTime activationValidThru;
    java.math.BigDecimal unitCost;
    String currencyUomId;
    String fixedAssetId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String tenantId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public InventoryItemFlatData.Builder toDataBuilder() {
        InventoryItemFlatData.Builder builder = InventoryItemFlatData.newBuilder();
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (inventoryItemTypeId != null) {
            builder.setInventoryItemTypeId(inventoryItemTypeId);
        }
        if (productId != null) {
            builder.setProductId(productId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (ownerPartyId != null) {
            builder.setOwnerPartyId(ownerPartyId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (datetimeReceived != null) {
            builder.setDatetimeReceived(getTimestamp(datetimeReceived));
        }
        if (datetimeManufactured != null) {
            builder.setDatetimeManufactured(getTimestamp(datetimeManufactured));
        }
        if (expireDate != null) {
            builder.setExpireDate(getTimestamp(expireDate));
        }
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (containerId != null) {
            builder.setContainerId(containerId);
        }
        if (lotId != null) {
            builder.setLotId(lotId);
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (binNumber != null) {
            builder.setBinNumber(binNumber);
        }
        if (locationSeqId != null) {
            builder.setLocationSeqId(locationSeqId);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (quantityOnHandTotal != null) {
            builder.setQuantityOnHandTotal(getFixedPoint(quantityOnHandTotal));
        }
        if (availableToPromiseTotal != null) {
            builder.setAvailableToPromiseTotal(getFixedPoint(availableToPromiseTotal));
        }
        if (accountingQuantityTotal != null) {
            builder.setAccountingQuantityTotal(getFixedPoint(accountingQuantityTotal));
        }
        if (serialNumber != null) {
            builder.setSerialNumber(serialNumber);
        }
        if (softIdentifier != null) {
            builder.setSoftIdentifier(softIdentifier);
        }
        if (activationNumber != null) {
            builder.setActivationNumber(activationNumber);
        }
        if (activationValidThru != null) {
            builder.setActivationValidThru(getTimestamp(activationValidThru));
        }
        if (unitCost != null) {
            builder.setUnitCost(getFixedPoint(unitCost));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
        }
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (tenantId != null) {
            builder.setTenantId(tenantId);
        }
                    
        return builder;
    }

    public static InventoryItem fromData(InventoryItemFlatData data) {
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
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addProduct")
    List<Product> relProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addParty")
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addOwnerParty")
    List<Party> relOwnerParty= new ArrayList<>(); 
    @Exclude
    @Singular("addFacility")
    List<Facility> relFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacility")
    List<ProductFacility> relProductFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addFacilityLocation")
    List<FacilityLocation> relFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addProductFacilityLocation")
    List<ProductFacilityLocation> relProductFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetFixedAsset")
    List<FixedAsset> relFixedAssetFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTransEntry")
    List<AcctgTransEntry> relAcctgTransEntry= new ArrayList<>(); 
    @Exclude
    @Singular("addInventoryItemDetail")
    List<InventoryItemDetail> relInventoryItemDetail= new ArrayList<>(); 
    @Exclude
    @Singular("addInvoiceItem")
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    @Singular("addItemIssuance")
    List<ItemIssuance> relItemIssuance= new ArrayList<>(); 
    @Exclude
    @Singular("addFromOrderItem")
    List<OrderItem> relFromOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addOrderItemShipGrpInvRes")
    List<OrderItemShipGrpInvRes> relOrderItemShipGrpInvRes= new ArrayList<>(); 
    @Exclude
    @Singular("addShipmentReceipt")
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
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
        if (inventoryItemId != null) {
            builder.setInventoryItemId(inventoryItemId);
        }
        if (inventoryItemTypeId != null) {
            builder.setInventoryItemTypeId(inventoryItemTypeId);
        }
        if (statusId != null) {
            builder.setStatusId(statusId);
        }
        if (datetimeReceived != null) {
            builder.setDatetimeReceived(getTimestamp(datetimeReceived));
        }
        if (datetimeManufactured != null) {
            builder.setDatetimeManufactured(getTimestamp(datetimeManufactured));
        }
        if (expireDate != null) {
            builder.setExpireDate(getTimestamp(expireDate));
        }
        if (containerId != null) {
            builder.setContainerId(containerId);
        }
        if (lotId != null) {
            builder.setLotId(lotId);
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (binNumber != null) {
            builder.setBinNumber(binNumber);
        }
        if (locationSeqId != null) {
            builder.setLocationSeqId(locationSeqId);
        }
        if (comments != null) {
            builder.setComments(comments);
        }
        if (quantityOnHandTotal != null) {
            builder.setQuantityOnHandTotal(getFixedPoint(quantityOnHandTotal));
        }
        if (availableToPromiseTotal != null) {
            builder.setAvailableToPromiseTotal(getFixedPoint(availableToPromiseTotal));
        }
        if (accountingQuantityTotal != null) {
            builder.setAccountingQuantityTotal(getFixedPoint(accountingQuantityTotal));
        }
        if (serialNumber != null) {
            builder.setSerialNumber(serialNumber);
        }
        if (softIdentifier != null) {
            builder.setSoftIdentifier(softIdentifier);
        }
        if (activationNumber != null) {
            builder.setActivationNumber(activationNumber);
        }
        if (activationValidThru != null) {
            builder.setActivationValidThru(getTimestamp(activationValidThru));
        }
        if (unitCost != null) {
            builder.setUnitCost(getFixedPoint(unitCost));
        }
        if (currencyUomId != null) {
            builder.setCurrencyUomId(currencyUomId);
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

