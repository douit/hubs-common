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
import com.bluecc.hubs.stub.FixedAssetData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FixedAsset implements IEventModel<FixedAssetData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String fixedAssetId;
    String fixedAssetTypeId;
    String parentFixedAssetId;
    String instanceOfProductId;
    String classEnumId;
    String partyId;
    String roleTypeId;
    String fixedAssetName;
    String acquireOrderId;
    String acquireOrderItemSeqId;
    java.time.LocalDateTime dateAcquired;
    java.time.LocalDateTime dateLastServiced;
    java.time.LocalDateTime dateNextService;
    java.time.LocalDate expectedEndOfLife;
    java.time.LocalDate actualEndOfLife;
    java.math.BigDecimal productionCapacity;
    String uomId;
    String calendarId;
    String serialNumber;
    String locatedAtFacilityId;
    String locatedAtLocationSeqId;
    java.math.BigDecimal salvageValue;
    java.math.BigDecimal depreciation;
    java.math.BigDecimal purchaseCost;
    String purchaseCostUomId;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FixedAssetData.Builder toDataBuilder() {
        FixedAssetData.Builder builder = FixedAssetData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (fixedAssetTypeId != null) {
            builder.setFixedAssetTypeId(fixedAssetTypeId);
        }
        if (parentFixedAssetId != null) {
            builder.setParentFixedAssetId(parentFixedAssetId);
        }
        if (instanceOfProductId != null) {
            builder.setInstanceOfProductId(instanceOfProductId);
        }
        if (classEnumId != null) {
            builder.setClassEnumId(classEnumId);
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (fixedAssetName != null) {
            builder.setFixedAssetName(fixedAssetName);
        }
        if (acquireOrderId != null) {
            builder.setAcquireOrderId(acquireOrderId);
        }
        if (acquireOrderItemSeqId != null) {
            builder.setAcquireOrderItemSeqId(acquireOrderItemSeqId);
        }
        if (dateAcquired != null) {
            builder.setDateAcquired(getTimestamp(dateAcquired));
        }
        if (dateLastServiced != null) {
            builder.setDateLastServiced(getTimestamp(dateLastServiced));
        }
        if (dateNextService != null) {
            builder.setDateNextService(getTimestamp(dateNextService));
        }
        if (expectedEndOfLife != null) {
            builder.setExpectedEndOfLife(getDate(expectedEndOfLife));
        }
        if (actualEndOfLife != null) {
            builder.setActualEndOfLife(getDate(actualEndOfLife));
        }
        if (productionCapacity != null) {
            builder.setProductionCapacity(getFixedPoint(productionCapacity));
        }
        if (uomId != null) {
            builder.setUomId(uomId);
        }
        if (calendarId != null) {
            builder.setCalendarId(calendarId);
        }
        if (serialNumber != null) {
            builder.setSerialNumber(serialNumber);
        }
        if (locatedAtFacilityId != null) {
            builder.setLocatedAtFacilityId(locatedAtFacilityId);
        }
        if (locatedAtLocationSeqId != null) {
            builder.setLocatedAtLocationSeqId(locatedAtLocationSeqId);
        }
        if (salvageValue != null) {
            builder.setSalvageValue(getCurrency(salvageValue));
        }
        if (depreciation != null) {
            builder.setDepreciation(getCurrency(depreciation));
        }
        if (purchaseCost != null) {
            builder.setPurchaseCost(getCurrency(purchaseCost));
        }
        if (purchaseCostUomId != null) {
            builder.setPurchaseCostUomId(purchaseCostUomId);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static FixedAsset fromData(FixedAssetData data) {
        return FixedAsset.builder()
                .fixedAssetId(data.getFixedAssetId())
                .fixedAssetTypeId(data.getFixedAssetTypeId())
                .parentFixedAssetId(data.getParentFixedAssetId())
                .instanceOfProductId(data.getInstanceOfProductId())
                .classEnumId(data.getClassEnumId())
                .partyId(data.getPartyId())
                .roleTypeId(data.getRoleTypeId())
                .fixedAssetName(data.getFixedAssetName())
                .acquireOrderId(data.getAcquireOrderId())
                .acquireOrderItemSeqId(data.getAcquireOrderItemSeqId())
                .dateAcquired(getLocalDateTime(data.getDateAcquired()))
                .dateLastServiced(getLocalDateTime(data.getDateLastServiced()))
                .dateNextService(getLocalDateTime(data.getDateNextService()))
                .expectedEndOfLife(getLocalDate(data.getExpectedEndOfLife()))
                .actualEndOfLife(getLocalDate(data.getActualEndOfLife()))
                .productionCapacity(getBigDecimal(data.getProductionCapacity()))
                .uomId(data.getUomId())
                .calendarId(data.getCalendarId())
                .serialNumber(data.getSerialNumber())
                .locatedAtFacilityId(data.getLocatedAtFacilityId())
                .locatedAtLocationSeqId(data.getLocatedAtLocationSeqId())
                .salvageValue(getBigDecimal(data.getSalvageValue()))
                .depreciation(getBigDecimal(data.getDepreciation()))
                .purchaseCost(getBigDecimal(data.getPurchaseCost()))
                .purchaseCostUomId(data.getPurchaseCostUomId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                
                .build();
    }

    
}
