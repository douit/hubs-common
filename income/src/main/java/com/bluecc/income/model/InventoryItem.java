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
import com.bluecc.hubs.stub.InventoryItemData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItem implements IEventModel<InventoryItemData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String inventoryItemId;
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

    public InventoryItemData.Builder toDataBuilder() {
        InventoryItemData.Builder builder = InventoryItemData.newBuilder();
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

    public static InventoryItem fromData(InventoryItemData data) {
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

    
}
