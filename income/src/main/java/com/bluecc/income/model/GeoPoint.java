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

import com.bluecc.hubs.stub.GeoPointData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = GeoPointData.class,
        symbol = EntityNames.GeoPoint)
public class GeoPoint implements IEventModel<GeoPointData.Builder>, HasId, Serializable, WithLocation, WithDescription {
    private static final long serialVersionUID = 1L;

    @SerializedName("geo_point_id")
	@RId 
    String geoPointId;
    @SerializedName("geo_point_type_enum_id") 
    String geoPointTypeEnumId;
    @SerializedName("description") 
    String description;
    @SerializedName("data_source_id") 
    String dataSourceId;
    @SerializedName("latitude") 
    String latitude;
    @SerializedName("longitude") 
    String longitude;
    @SerializedName("elevation") 
    java.math.BigDecimal elevation;
    @SerializedName("elevation_uom_id") 
    String elevationUomId;
    @SerializedName("information") 
    String information;
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
        return geoPointId;
    }

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public GeoPointData.Builder toDataBuilder() {
        GeoPointData.Builder builder = GeoPointData.newBuilder();
        if (getGeoPointId() != null) {
            builder.setGeoPointId(getGeoPointId());
        }
        if (getGeoPointTypeEnumId() != null) {
            builder.setGeoPointTypeEnumId(getGeoPointTypeEnumId());
        }
        if (getDescription() != null) {
            builder.setDescription(getDescription());
        }
        if (getDataSourceId() != null) {
            builder.setDataSourceId(getDataSourceId());
        }
        if (getLatitude() != null) {
            builder.setLatitude(getLatitude());
        }
        if (getLongitude() != null) {
            builder.setLongitude(getLongitude());
        }
        if (getElevation() != null) {
            builder.setElevation(getFixedPoint(getElevation()));
        }
        if (getElevationUomId() != null) {
            builder.setElevationUomId(getElevationUomId());
        }
        if (getInformation() != null) {
            builder.setInformation(getInformation());
        }
        if (getLastUpdatedTxStamp() != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(getLastUpdatedTxStamp()));
        }
        if (getCreatedTxStamp() != null) {
            builder.setCreatedTxStamp(getTimestamp(getCreatedTxStamp()));
        }
                    
        return builder;
    }

    public static GeoPoint fromData(GeoPointData data) {
        return fromPrototype(data).build();
    }

    public static GeoPoint.GeoPointBuilder fromPrototype(GeoPointData data) {
        return GeoPoint.builder()
                .geoPointId(data.getGeoPointId())
                .geoPointTypeEnumId(data.getGeoPointTypeEnumId())
                .description(data.getDescription())
                .dataSourceId(data.getDataSourceId())
                .latitude(data.getLatitude())
                .longitude(data.getLongitude())
                .elevation(getBigDecimal(data.getElevation()))
                .elevationUomId(data.getElevationUomId())
                .information(data.getInformation())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                ;
    }

    
}


/*
-- keys: geoPointId

-- fields --
    
    String geoPointId
    String geoPointTypeEnumId
    String description
    String dataSourceId
    String latitude
    String longitude
    java.math.BigDecimal elevation
    String elevationUomId
    String information

-- relations --
    
    - DataSource (one, autoRelation: false, keymaps: dataSourceId)
    - GeoPointTypeEnumeration (one, autoRelation: false, keymaps: geoPointTypeEnumId -> enumId)
    - ElevationUom (one, autoRelation: false, keymaps: elevationUomId -> uomId)
    + ContainerGeoPoint (many, autoRelation: true, keymaps: geoPointId)
    + Facility (many, autoRelation: true, keymaps: geoPointId)
    + FacilityLocation (many, autoRelation: true, keymaps: geoPointId)
    + FacilityLocationGeoPoint (many, autoRelation: true, keymaps: geoPointId)
    + FixedAssetGeoPoint (many, autoRelation: true, keymaps: geoPointId)
    + PartyGeoPoint (many, autoRelation: true, keymaps: geoPointId)
    + PostalAddress (many, autoRelation: true, keymaps: geoPointId)
*/

