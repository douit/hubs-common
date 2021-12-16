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

import com.bluecc.hubs.stub.FixedAssetFlatData;

import com.bluecc.hubs.stub.FixedAssetData;
import com.bluecc.income.dao.FixedAssetDelegator;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetData.class,
        symbol = EntityNames.FixedAsset)
public class FixedAsset implements IEventModel<FixedAssetFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    @RId String fixedAssetId;
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

    public FixedAssetFlatData.Builder toDataBuilder() {
        FixedAssetFlatData.Builder builder = FixedAssetFlatData.newBuilder();
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

    public static FixedAsset fromData(FixedAssetFlatData data) {
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

        // relations
     
    @Exclude
    List<FixedAsset> relParentFixedAsset= new ArrayList<>(); 
    @Exclude
    List<Product> relInstanceOfProduct= new ArrayList<>(); 
    @Exclude
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    List<PartyRole> relPartyRole= new ArrayList<>(); 
    @Exclude
    List<OrderHeader> relAcquireOrderHeader= new ArrayList<>(); 
    @Exclude
    List<OrderItem> relAcquireOrderItem= new ArrayList<>(); 
    @Exclude
    List<Facility> relLocatedAtFacility= new ArrayList<>(); 
    @Exclude
    List<FacilityLocation> relLocatedAtFacilityLocation= new ArrayList<>(); 
    @Exclude
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    List<FixedAsset> relChildFixedAsset= new ArrayList<>(); 
    @Exclude
    List<FixedAssetGeoPoint> relFixedAssetGeoPoint= new ArrayList<>(); 
    @Exclude
    List<FixedAssetProduct> relFixedAssetProduct= new ArrayList<>(); 
    @Exclude
    List<FixedAssetRegistration> relFixedAssetRegistration= new ArrayList<>(); 
    @Exclude
    List<FixedAssetStdCost> relFixedAssetStdCost= new ArrayList<>(); 
    @Exclude
    List<InventoryItem> relFixedAssetInventoryItem= new ArrayList<>(); 
    @Exclude
    List<WorkEffort> relWorkEffort= new ArrayList<>();

    public FixedAssetDelegator.Agent agent(IProc.ProcContext ctx,
                                             FixedAssetDelegator delegator){
        return delegator.getAgent(ctx, this.getFixedAssetId());
    }

    public FixedAssetData.Builder toHeadBuilder() {
        FixedAssetData.Builder builder = FixedAssetData.newBuilder();
        if (fixedAssetId != null) {
            builder.setFixedAssetId(fixedAssetId);
        }
        if (fixedAssetTypeId != null) {
            builder.setFixedAssetTypeId(fixedAssetTypeId);
        }
        if (classEnumId != null) {
            builder.setClassEnumId(classEnumId);
        }
        if (roleTypeId != null) {
            builder.setRoleTypeId(roleTypeId);
        }
        if (fixedAssetName != null) {
            builder.setFixedAssetName(fixedAssetName);
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

}


/*
-- keys: fixedAssetId

-- fields --
    
    String fixedAssetId
    String fixedAssetTypeId
    String parentFixedAssetId
    String instanceOfProductId
    String classEnumId
    String partyId
    String roleTypeId
    String fixedAssetName
    String acquireOrderId
    String acquireOrderItemSeqId
    java.time.LocalDateTime dateAcquired
    java.time.LocalDateTime dateLastServiced
    java.time.LocalDateTime dateNextService
    java.time.LocalDate expectedEndOfLife
    java.time.LocalDate actualEndOfLife
    java.math.BigDecimal productionCapacity
    String uomId
    String calendarId
    String serialNumber
    String locatedAtFacilityId
    String locatedAtLocationSeqId
    java.math.BigDecimal salvageValue
    java.math.BigDecimal depreciation
    java.math.BigDecimal purchaseCost
    String purchaseCostUomId

-- relations --
    
    - FixedAssetType (one, autoRelation: false, keymaps: fixedAssetTypeId)
    + FixedAssetTypeAttr (many, autoRelation: false, keymaps: fixedAssetTypeId)
    - ParentFixedAsset (one, autoRelation: false, keymaps: parentFixedAssetId -> fixedAssetId)
    - InstanceOfProduct (one, autoRelation: false, keymaps: instanceOfProductId -> productId)
    - ClassEnumeration (one, autoRelation: false, keymaps: classEnumId -> enumId)
    - Party (one, autoRelation: false, keymaps: partyId)
    - RoleType (one, autoRelation: false, keymaps: roleTypeId)
    - PartyRole (one-nofk, autoRelation: false, keymaps: partyId, roleTypeId)
    - AcquireOrderHeader (one, autoRelation: false, keymaps: acquireOrderId -> orderId)
    - AcquireOrderItem (one, autoRelation: false, keymaps: acquireOrderId -> orderId, acquireOrderItemSeqId -> orderItemSeqId)
    - Uom (one, autoRelation: false, keymaps: uomId)
    - TechDataCalendar (one, autoRelation: false, keymaps: calendarId)
    - LocatedAtFacility (one, autoRelation: false, keymaps: locatedAtFacilityId -> facilityId)
    - LocatedAtFacilityLocation (one-nofk, autoRelation: false, keymaps: locatedAtFacilityId -> facilityId, locatedAtLocationSeqId -> locationSeqId)
    + AccommodationMap (many, autoRelation: true, keymaps: fixedAssetId)
    + AccommodationSpot (many, autoRelation: true, keymaps: fixedAssetId)
    + AcctgTrans (many, autoRelation: true, keymaps: fixedAssetId)
    + CostComponent (many, autoRelation: true, keymaps: fixedAssetId)
    + Delivery (many, autoRelation: true, keymaps: fixedAssetId)
    + ChildFixedAsset (many, autoRelation: true, keymaps: fixedAssetId -> parentFixedAssetId)
    + FixedAssetAttribute (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetDepMethod (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetGeoPoint (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetIdent (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetMaint (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetMaintOrder (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetProduct (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetRegistration (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetStdCost (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetTypeGlAccount (many, autoRelation: true, keymaps: fixedAssetId)
    + FixedAssetInventoryItem (many, autoRelation: true, keymaps: fixedAssetId)
    + PartyFixedAssetAssignment (many, autoRelation: true, keymaps: fixedAssetId)
    + Requirement (many, autoRelation: true, keymaps: fixedAssetId)
    + WorkEffort (many, autoRelation: true, keymaps: fixedAssetId)
    + WorkEffortFixedAssetAssign (many, autoRelation: true, keymaps: fixedAssetId)
*/

