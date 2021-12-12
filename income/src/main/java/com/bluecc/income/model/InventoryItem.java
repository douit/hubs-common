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
import com.bluecc.hubs.fund.pubs.Exclude;

import com.bluecc.hubs.stub.InventoryItemFlatData;

import com.bluecc.hubs.stub.InventoryItemData;
import com.bluecc.income.dao.InventoryItemDelegator;
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
                
                .build();
    }

        // relations
     
    @Exclude
    List<Product> relProduct= new ArrayList<>(); 
    @Exclude
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    List<Party> relOwnerParty= new ArrayList<>(); 
    @Exclude
    List<ProductFacility> relProductFacility= new ArrayList<>(); 
    @Exclude
    List<FacilityLocation> relFacilityLocation= new ArrayList<>(); 
    @Exclude
    List<ProductFacilityLocation> relProductFacilityLocation= new ArrayList<>(); 
    @Exclude
    List<FixedAsset> relFixedAssetFixedAsset= new ArrayList<>(); 
    @Exclude
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    List<AcctgTransEntry> relAcctgTransEntry= new ArrayList<>(); 
    @Exclude
    List<InventoryItemDetail> relInventoryItemDetail= new ArrayList<>(); 
    @Exclude
    List<InvoiceItem> relInvoiceItem= new ArrayList<>(); 
    @Exclude
    List<ItemIssuance> relItemIssuance= new ArrayList<>(); 
    @Exclude
    List<OrderItem> relFromOrderItem= new ArrayList<>(); 
    @Exclude
    List<OrderItemShipGrpInvRes> relOrderItemShipGrpInvRes= new ArrayList<>(); 
    @Exclude
    List<ShipmentReceipt> relShipmentReceipt= new ArrayList<>();

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
