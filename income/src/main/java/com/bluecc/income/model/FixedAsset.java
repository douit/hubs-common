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

import com.bluecc.hubs.stub.FixedAssetFlatData;

import com.bluecc.hubs.stub.FixedAssetData;
import com.bluecc.income.dao.FixedAssetDelegator;
import static com.bluecc.income.dao.FixedAssetDelegator.*;
import com.bluecc.income.exchange.IProc;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FixedAssetData.class,
        symbol = EntityNames.FixedAsset)
public class FixedAsset implements IEventModel<FixedAssetFlatData.Builder>, HasId, Serializable, WithSuppliers {
    private static final long serialVersionUID = 1L;

    @SerializedName("fixed_asset_id")
	@RId 
    String fixedAssetId;
    @SerializedName("fixed_asset_type_id") 
    String fixedAssetTypeId;
    @SerializedName("parent_fixed_asset_id") 
    String parentFixedAssetId;
    @SerializedName("instance_of_product_id") 
    String instanceOfProductId;
    @SerializedName("class_enum_id") 
    String classEnumId;
    @SerializedName("party_id") 
    String partyId;
    @SerializedName("role_type_id") 
    String roleTypeId;
    @SerializedName("fixed_asset_name") 
    String fixedAssetName;
    @SerializedName("acquire_order_id") 
    String acquireOrderId;
    @SerializedName("acquire_order_item_seq_id") 
    String acquireOrderItemSeqId;
    @SerializedName("date_acquired") 
    java.time.LocalDateTime dateAcquired;
    @SerializedName("date_last_serviced") 
    java.time.LocalDateTime dateLastServiced;
    @SerializedName("date_next_service") 
    java.time.LocalDateTime dateNextService;
    @SerializedName("expected_end_of_life") 
    java.time.LocalDate expectedEndOfLife;
    @SerializedName("actual_end_of_life") 
    java.time.LocalDate actualEndOfLife;
    @SerializedName("production_capacity") 
    java.math.BigDecimal productionCapacity;
    @SerializedName("uom_id") 
    String uomId;
    @SerializedName("calendar_id") 
    String calendarId;
    @SerializedName("serial_number") 
    String serialNumber;
    @SerializedName("located_at_facility_id") 
    String locatedAtFacilityId;
    @SerializedName("located_at_location_seq_id") 
    String locatedAtLocationSeqId;
    @SerializedName("salvage_value") 
    java.math.BigDecimal salvageValue;
    @SerializedName("depreciation") 
    java.math.BigDecimal depreciation;
    @SerializedName("purchase_cost") 
    java.math.BigDecimal purchaseCost;
    @SerializedName("purchase_cost_uom_id") 
    String purchaseCostUomId;
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
        return fixedAssetId;
    }

        
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
        if (tenantId != null) {
            builder.setTenantId(tenantId);
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
                .tenantId(data.getTenantId())
                
                .build();
    }

        // relations
     
    @Exclude
    @Singular("addParentFixedAsset")
    @SerializedName("parent_fixed_asset") 
    List<FixedAsset> relParentFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addInstanceOfProduct")
    @SerializedName("instance_of_product") 
    List<Product> relInstanceOfProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addParty")
    @SerializedName("party") 
    List<Party> relParty= new ArrayList<>(); 
    @Exclude
    @Singular("addPartyRole")
    @SerializedName("party_role") 
    List<PartyRole> relPartyRole= new ArrayList<>(); 
    @Exclude
    @Singular("addAcquireOrderHeader")
    @SerializedName("acquire_order_header") 
    List<OrderHeader> relAcquireOrderHeader= new ArrayList<>(); 
    @Exclude
    @Singular("addAcquireOrderItem")
    @SerializedName("acquire_order_item") 
    List<OrderItem> relAcquireOrderItem= new ArrayList<>(); 
    @Exclude
    @Singular("addTechDataCalendar")
    @SerializedName("tech_data_calendar") 
    List<TechDataCalendar> relTechDataCalendar= new ArrayList<>(); 
    @Exclude
    @Singular("addLocatedAtFacility")
    @SerializedName("located_at_facility") 
    List<Facility> relLocatedAtFacility= new ArrayList<>(); 
    @Exclude
    @Singular("addLocatedAtFacilityLocation")
    @SerializedName("located_at_facility_location") 
    List<FacilityLocation> relLocatedAtFacilityLocation= new ArrayList<>(); 
    @Exclude
    @Singular("addAcctgTrans")
    @SerializedName("acctg_trans") 
    List<AcctgTrans> relAcctgTrans= new ArrayList<>(); 
    @Exclude
    @Singular("addChildFixedAsset")
    @SerializedName("child_fixed_asset") 
    List<FixedAsset> relChildFixedAsset= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetDepMethod")
    @SerializedName("fixed_asset_dep_method") 
    List<FixedAssetDepMethod> relFixedAssetDepMethod= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetGeoPoint")
    @SerializedName("fixed_asset_geo_point") 
    List<FixedAssetGeoPoint> relFixedAssetGeoPoint= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetProduct")
    @SerializedName("fixed_asset_product") 
    List<FixedAssetProduct> relFixedAssetProduct= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetRegistration")
    @SerializedName("fixed_asset_registration") 
    List<FixedAssetRegistration> relFixedAssetRegistration= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetStdCost")
    @SerializedName("fixed_asset_std_cost") 
    List<FixedAssetStdCost> relFixedAssetStdCost= new ArrayList<>(); 
    @Exclude
    @Singular("addFixedAssetInventoryItem")
    @SerializedName("fixed_asset_inventory_item") 
    List<InventoryItem> relFixedAssetInventoryItem= new ArrayList<>(); 
    @Exclude
    @Singular("addRequirement")
    @SerializedName("requirement") 
    List<Requirement> relRequirement= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffort")
    @SerializedName("work_effort") 
    List<WorkEffort> relWorkEffort= new ArrayList<>(); 
    @Exclude
    @Singular("addWorkEffortFixedAssetAssign")
    @SerializedName("work_effort_fixed_asset_assign") 
    List<WorkEffortFixedAssetAssign> relWorkEffortFixedAssetAssign= new ArrayList<>(); 
    @Exclude
    @Singular("addTenant")
    @SerializedName("tenant") 
    List<Tenant> relTenant= new ArrayList<>();

    public Map<String, Supplier<List<?>>> suppliers(){
        Map<String, Supplier<List<?>>> supplierMap=Maps.newHashMap();
         
        supplierMap.put(PARENT_FIXED_ASSET, getter(this, FixedAsset::getRelParentFixedAsset)); 
        supplierMap.put(INSTANCE_OF_PRODUCT, getter(this, FixedAsset::getRelInstanceOfProduct)); 
        supplierMap.put(PARTY, getter(this, FixedAsset::getRelParty)); 
        supplierMap.put(PARTY_ROLE, getter(this, FixedAsset::getRelPartyRole)); 
        supplierMap.put(ACQUIRE_ORDER_HEADER, getter(this, FixedAsset::getRelAcquireOrderHeader)); 
        supplierMap.put(ACQUIRE_ORDER_ITEM, getter(this, FixedAsset::getRelAcquireOrderItem)); 
        supplierMap.put(TECH_DATA_CALENDAR, getter(this, FixedAsset::getRelTechDataCalendar)); 
        supplierMap.put(LOCATED_AT_FACILITY, getter(this, FixedAsset::getRelLocatedAtFacility)); 
        supplierMap.put(LOCATED_AT_FACILITY_LOCATION, getter(this, FixedAsset::getRelLocatedAtFacilityLocation)); 
        supplierMap.put(ACCTG_TRANS, getter(this, FixedAsset::getRelAcctgTrans)); 
        supplierMap.put(CHILD_FIXED_ASSET, getter(this, FixedAsset::getRelChildFixedAsset)); 
        supplierMap.put(FIXED_ASSET_DEP_METHOD, getter(this, FixedAsset::getRelFixedAssetDepMethod)); 
        supplierMap.put(FIXED_ASSET_GEO_POINT, getter(this, FixedAsset::getRelFixedAssetGeoPoint)); 
        supplierMap.put(FIXED_ASSET_PRODUCT, getter(this, FixedAsset::getRelFixedAssetProduct)); 
        supplierMap.put(FIXED_ASSET_REGISTRATION, getter(this, FixedAsset::getRelFixedAssetRegistration)); 
        supplierMap.put(FIXED_ASSET_STD_COST, getter(this, FixedAsset::getRelFixedAssetStdCost)); 
        supplierMap.put(FIXED_ASSET_INVENTORY_ITEM, getter(this, FixedAsset::getRelFixedAssetInventoryItem)); 
        supplierMap.put(REQUIREMENT, getter(this, FixedAsset::getRelRequirement)); 
        supplierMap.put(WORK_EFFORT, getter(this, FixedAsset::getRelWorkEffort)); 
        supplierMap.put(WORK_EFFORT_FIXED_ASSET_ASSIGN, getter(this, FixedAsset::getRelWorkEffortFixedAssetAssign)); 
        supplierMap.put(TENANT, getter(this, FixedAsset::getRelTenant));

        return supplierMap;
    };

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
    - Tenant (one, autoRelation: false, keymaps: tenantId)
*/

