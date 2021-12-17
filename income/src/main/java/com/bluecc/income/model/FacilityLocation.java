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

import com.bluecc.hubs.stub.FacilityLocationData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = FacilityLocationData.class,
        symbol = EntityNames.FacilityLocation)
public class FacilityLocation implements IEventModel<FacilityLocationData.Builder>, HasId, Serializable, WithLocation {
    private static final long serialVersionUID = 1L;

    @SerializedName("facility_id")
	@RIndex 
    String facilityId;
    @SerializedName("location_seq_id")
	@RIndex 
    String locationSeqId;
    @SerializedName("location_type_enum_id") 
    String locationTypeEnumId;
    @SerializedName("area_id") 
    String areaId;
    @SerializedName("aisle_id") 
    String aisleId;
    @SerializedName("section_id") 
    String sectionId;
    @SerializedName("level_id") 
    String levelId;
    @SerializedName("position_id") 
    String positionId;
    @SerializedName("geo_point_id") 
    String geoPointId;
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
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public FacilityLocationData.Builder toDataBuilder() {
        FacilityLocationData.Builder builder = FacilityLocationData.newBuilder();
        if (facilityId != null) {
            builder.setFacilityId(facilityId);
        }
        if (locationSeqId != null) {
            builder.setLocationSeqId(locationSeqId);
        }
        if (locationTypeEnumId != null) {
            builder.setLocationTypeEnumId(locationTypeEnumId);
        }
        if (areaId != null) {
            builder.setAreaId(areaId);
        }
        if (aisleId != null) {
            builder.setAisleId(aisleId);
        }
        if (sectionId != null) {
            builder.setSectionId(sectionId);
        }
        if (levelId != null) {
            builder.setLevelId(levelId);
        }
        if (positionId != null) {
            builder.setPositionId(positionId);
        }
        if (geoPointId != null) {
            builder.setGeoPointId(geoPointId);
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

    public static FacilityLocation fromData(FacilityLocationData data) {
        return FacilityLocation.builder()
                .facilityId(data.getFacilityId())
                .locationSeqId(data.getLocationSeqId())
                .locationTypeEnumId(data.getLocationTypeEnumId())
                .areaId(data.getAreaId())
                .aisleId(data.getAisleId())
                .sectionId(data.getSectionId())
                .levelId(data.getLevelId())
                .positionId(data.getPositionId())
                .geoPointId(data.getGeoPointId())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .id(data.getId())
                
                .build();
    }

    
}


/*
-- keys: facilityId, locationSeqId

-- fields --
    
    String facilityId
    String locationSeqId
    String locationTypeEnumId
    String areaId
    String aisleId
    String sectionId
    String levelId
    String positionId
    String geoPointId

-- relations --
    
    - Facility (one, autoRelation: false, keymaps: facilityId)
    - TypeEnumeration (one, autoRelation: false, keymaps: locationTypeEnumId -> enumId)
    - GeoPoint (one, autoRelation: false, keymaps: geoPointId)
    + FacilityLocationGeoPoint (many, autoRelation: true, keymaps: facilityId, locationSeqId)
    + LocatedAtFixedAsset (many, autoRelation: true, keymaps: facilityId -> locatedAtFacilityId, locationSeqId -> locatedAtLocationSeqId)
    + InventoryItem (many, autoRelation: true, keymaps: facilityId, locationSeqId)
    + InventoryTransfer (many, autoRelation: true, keymaps: facilityId, locationSeqId)
    + ToInventoryTransfer (many, autoRelation: true, keymaps: facilityId -> facilityIdTo, locationSeqId -> locationSeqIdTo)
    + ProductFacilityLocation (many, autoRelation: true, keymaps: facilityId, locationSeqId)
*/

