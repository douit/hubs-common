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

import com.bluecc.hubs.stub.FacilityData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FacilityData.class,
        symbol = EntityNames.Facility)
public class Facility implements IEventModel<FacilityData.Builder>, HasId, Serializable, WithLocation, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("facility_id")
	@RId 
    String facilityId;
    @SerializedName("facility_type_id") 
    String facilityTypeId;
    @SerializedName("parent_facility_id") 
    String parentFacilityId;
    @SerializedName("owner_party_id") 
    String ownerPartyId;
    @SerializedName("default_inventory_item_type_id") 
    String defaultInventoryItemTypeId;
    @SerializedName("facility_name") 
    String facilityName;
    @SerializedName("primary_facility_group_id") 
    String primaryFacilityGroupId;
    @SerializedName("facility_size") 
    java.math.BigDecimal facilitySize;
    @SerializedName("facility_size_uom_id") 
    String facilitySizeUomId;
    @SerializedName("product_store_id") 
    String productStoreId;
    @SerializedName("default_days_to_ship") 
    Long defaultDaysToShip;
    @SerializedName("opened_date") 
    java.time.LocalDateTime openedDate;
    @SerializedName("closed_date") 
    java.time.LocalDateTime closedDate;
    @SerializedName("description") 
    String description;
    @SerializedName("default_dimension_uom_id") 
    String defaultDimensionUomId;
    @SerializedName("default_weight_uom_id") 
    String defaultWeightUomId;
    @SerializedName("geo_point_id") 
    String geoPointId;
    @SerializedName("facility_level") 
    Long facilityLevel;
    @SerializedName("last_updated_stamp") 
    java.time.LocalDateTime lastUpdatedStamp;
    @SerializedName("last_updated_tx_stamp") 
    java.time.LocalDateTime lastUpdatedTxStamp;
    @SerializedName("created_stamp") 
    java.time.LocalDateTime createdStamp;
    @SerializedName("created_tx_stamp") 
    java.time.LocalDateTime createdTxStamp;
    
    @Override
    public String getId(){
        return facilityId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FacilityData.Builder toDataBuilder() {
        FacilityData.Builder builder = FacilityData.newBuilder();
        if (getFacilityId() != null) {
            builder.setFacilityId(getFacilityId());
        }
        if (getFacilityTypeId() != null) {
            builder.setFacilityTypeId(getFacilityTypeId());
        }
        if (getParentFacilityId() != null) {
            builder.setParentFacilityId(getParentFacilityId());
        }
        if (getOwnerPartyId() != null) {
            builder.setOwnerPartyId(getOwnerPartyId());
        }
        if (getDefaultInventoryItemTypeId() != null) {
            builder.setDefaultInventoryItemTypeId(getDefaultInventoryItemTypeId());
        }
        if (getFacilityName() != null) {
            builder.setFacilityName(getFacilityName());
        }
        if (getPrimaryFacilityGroupId() != null) {
            builder.setPrimaryFacilityGroupId(getPrimaryFacilityGroupId());
        }
        if (getFacilitySize() != null) {
            builder.setFacilitySize(getFixedPoint(getFacilitySize()));
        }
        if (getFacilitySizeUomId() != null) {
            builder.setFacilitySizeUomId(getFacilitySizeUomId());
        }
        if (getProductStoreId() != null) {
            builder.setProductStoreId(getProductStoreId());
        }
        if (getDefaultDaysToShip() != null) {
            builder.setDefaultDaysToShip(getDefaultDaysToShip());
        }
        if (getOpenedDate() != null) {
            builder.setOpenedDate(getTimestamp(getOpenedDate()));
        }
        if (getClosedDate() != null) {
            builder.setClosedDate(getTimestamp(getClosedDate()));
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getDefaultDimensionUomId() != null) {
            builder.setDefaultDimensionUomId(getDefaultDimensionUomId());
        }
        if (getDefaultWeightUomId() != null) {
            builder.setDefaultWeightUomId(getDefaultWeightUomId());
        }
        if (getGeoPointId() != null) {
            builder.setGeoPointId(getGeoPointId());
        }
        if (getFacilityLevel() != null) {
            builder.setFacilityLevel(getFacilityLevel());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static Facility fromData(FacilityData data) {
        return fromPrototype(data).build();
    }

    public static Facility.FacilityBuilder fromPrototype(FacilityData data) {
        return Facility.builder()
                .facilityId(data.getFacilityId())
                .facilityTypeId(data.getFacilityTypeId())
                .parentFacilityId(data.getParentFacilityId())
                .ownerPartyId(data.getOwnerPartyId())
                .defaultInventoryItemTypeId(data.getDefaultInventoryItemTypeId())
                .facilityName(data.getFacilityName())
                .primaryFacilityGroupId(data.getPrimaryFacilityGroupId())
                .facilitySize(getBigDecimal(data.getFacilitySize()))
                .facilitySizeUomId(data.getFacilitySizeUomId())
                .productStoreId(data.getProductStoreId())
                .defaultDaysToShip(data.getDefaultDaysToShip())
                .openedDate(getLocalDateTime(data.getOpenedDate()))
                .closedDate(getLocalDateTime(data.getClosedDate()))
                .description(data.getDescription())
                .defaultDimensionUomId(data.getDefaultDimensionUomId())
                .defaultWeightUomId(data.getDefaultWeightUomId())
                .geoPointId(data.getGeoPointId())
                .facilityLevel(data.getFacilityLevel())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: facilityId

-- fields --
    
    String facilityId
    String facilityTypeId
    String parentFacilityId
    String ownerPartyId
    String defaultInventoryItemTypeId
    String facilityName
    String primaryFacilityGroupId
    java.math.BigDecimal facilitySize
    String facilitySizeUomId
    String productStoreId
    Long defaultDaysToShip
    java.time.LocalDateTime openedDate
    java.time.LocalDateTime closedDate
    String description
    String defaultDimensionUomId
    String defaultWeightUomId
    String geoPointId
    Long facilityLevel

-- relations --
    
    - FacilityType (one, autoRelation: false, keymaps: facilityTypeId)
    - ParentFacility (one, autoRelation: false, keymaps: parentFacilityId -> facilityId)
    - FacilityGroup (one, autoRelation: false, keymaps: primaryFacilityGroupId -> facilityGroupId)
    - OwnerParty (one, autoRelation: false, keymaps: ownerPartyId -> partyId)
    - DefaultInventoryItemType (one, autoRelation: false, keymaps: defaultInventoryItemTypeId -> inventoryItemTypeId)
    - DimensionUom (one, autoRelation: false, keymaps: defaultDimensionUomId -> uomId)
    - WeightUom (one, autoRelation: false, keymaps: defaultWeightUomId -> uomId)
    - ProductStore (one-nofk, autoRelation: false, keymaps: productStoreId)
    + FacilityTypeAttr (many, autoRelation: false, keymaps: facilityTypeId)
    - GeoPoint (one, autoRelation: false, keymaps: geoPointId)
    - FacilitySizeUom (one, autoRelation: false, keymaps: facilitySizeUomId -> uomId)
    + AgreementFacilityAppl (many, autoRelation: true, keymaps: facilityId)
    + Container (many, autoRelation: true, keymaps: facilityId)
    + OriginDelivery (many, autoRelation: true, keymaps: facilityId -> originFacilityId)
    + DestDelivery (many, autoRelation: true, keymaps: facilityId -> destFacilityId)
    + ChildFacility (many, autoRelation: true, keymaps: facilityId -> parentFacilityId)
    + FacilityAttribute (many, autoRelation: true, keymaps: facilityId)
    + FacilityCalendar (many, autoRelation: true, keymaps: facilityId)
    + FacilityCarrierShipment (many, autoRelation: true, keymaps: facilityId)
    + FacilityContactMech (many, autoRelation: true, keymaps: facilityId)
    + FacilityContactMechPurpose (many, autoRelation: true, keymaps: facilityId)
    + FacilityContent (many, autoRelation: true, keymaps: facilityId)
    + FacilityGroupMember (many, autoRelation: true, keymaps: facilityId)
    + FacilityLocation (many, autoRelation: true, keymaps: facilityId)
    + FacilityParty (many, autoRelation: true, keymaps: facilityId)
    + LocatedAtFixedAsset (many, autoRelation: true, keymaps: facilityId -> locatedAtFacilityId)
    + InventoryItem (many, autoRelation: true, keymaps: facilityId)
    + InventoryTransfer (many, autoRelation: true, keymaps: facilityId)
    + ToInventoryTransfer (many, autoRelation: true, keymaps: facilityId -> facilityIdTo)
    + MrpEvent (many, autoRelation: true, keymaps: facilityId)
    + OriginOrderHeader (many, autoRelation: true, keymaps: facilityId -> originFacilityId)
    + OrderItemShipGroup (many, autoRelation: true, keymaps: facilityId)
    + OrderSummaryEntry (many, autoRelation: true, keymaps: facilityId)
    + Picklist (many, autoRelation: true, keymaps: facilityId)
    + ProdCatalogInvFacility (many, autoRelation: true, keymaps: facilityId)
    + Product (many, autoRelation: true, keymaps: facilityId)
    + ProductAverageCost (many, autoRelation: true, keymaps: facilityId)
    + ProductFacility (many, autoRelation: true, keymaps: facilityId)
    + FromProductFacilityAssoc (many, autoRelation: true, keymaps: facilityId)
    + ToProductFacilityAssoc (many, autoRelation: true, keymaps: facilityId -> facilityIdTo)
    + ProductFacilityLocation (many, autoRelation: true, keymaps: facilityId)
    + ProductStoreFacility (many, autoRelation: true, keymaps: facilityId)
    + ReorderGuideline (many, autoRelation: true, keymaps: facilityId)
    + Requirement (many, autoRelation: true, keymaps: facilityId)
    + ReturnHeader (many, autoRelation: true, keymaps: facilityId -> destinationFacilityId)
    + OriginShipment (many, autoRelation: true, keymaps: facilityId -> originFacilityId)
    + DestinationShipment (many, autoRelation: true, keymaps: facilityId -> destinationFacilityId)
    + OriginShipmentRouteSegment (many, autoRelation: true, keymaps: facilityId -> originFacilityId)
    + DestShipmentRouteSegment (many, autoRelation: true, keymaps: facilityId -> destFacilityId)
    + WorkEffort (many, autoRelation: true, keymaps: facilityId)
    + WorkEffortPartyAssignment (many, autoRelation: true, keymaps: facilityId)
*/

