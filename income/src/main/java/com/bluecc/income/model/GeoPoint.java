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

import com.bluecc.hubs.stub.GeoPointData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@REntity
@MessageObject(value = GeoPointData.class,
        symbol = EntityNames.GeoPoint)
public class GeoPoint implements IEventModel<GeoPointData.Builder>, Serializable, WithLocation, WithDescription {
    private static final long serialVersionUID = 1L;

    @RId String geoPointId;
    String geoPointTypeEnumId;
    String description;
    String dataSourceId;
    String latitude;
    String longitude;
    java.math.BigDecimal elevation;
    String elevationUomId;
    String information;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public GeoPointData.Builder toDataBuilder() {
        GeoPointData.Builder builder = GeoPointData.newBuilder();
        if (geoPointId != null) {
            builder.setGeoPointId(geoPointId);
        }
        if (geoPointTypeEnumId != null) {
            builder.setGeoPointTypeEnumId(geoPointTypeEnumId);
        }
        if (description != null) {
            builder.setDescription(description);
        }
        if (dataSourceId != null) {
            builder.setDataSourceId(dataSourceId);
        }
        if (latitude != null) {
            builder.setLatitude(latitude);
        }
        if (longitude != null) {
            builder.setLongitude(longitude);
        }
        if (elevation != null) {
            builder.setElevation(getFixedPoint(elevation));
        }
        if (elevationUomId != null) {
            builder.setElevationUomId(elevationUomId);
        }
        if (information != null) {
            builder.setInformation(information);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

    public static GeoPoint fromData(GeoPointData data) {
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
                
                .build();
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

